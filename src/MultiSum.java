public class MultiSum extends Function{
    private Function[] functions;

    public MultiSum(Function function1, Function function2, Function... functions) {
        this.functions = new Function[functions.length+2];
        this.functions[0] = function1;
        this.functions[1] = function2;
        for (int i = 0; i < functions.length; i++) {
            this.functions[i+2] = functions[i];
        }
    }

    public double valueAt(double x) {
        double sum = 0;
        for (Function function : functions) {
            sum += function.valueAt(x);
        }
        return sum;
    }

    public String toString() {
        String sum = "(";
        for (Function function : functions) {
            if(functions.length-1 == 0 || function == functions[functions.length-1])
                sum += function.toString();
            else
                sum += function.toString() + " + ";
        }
        return sum + ")";
    }

    /**
     * calculates the derivative of the sum of the functions using the chain rule
     * @return the derivative of the sum of the functions
     */
    public Function derivative() {
        Function[] derivatives = new Function[functions.length];

        for (int i = 0; i < functions.length; i++) {
            Function derivativeProduct = null;

            for (int j = 0; j < functions.length; j++) {
                if (i != j) {
                    Function derivative = functions[i].derivative();
                    if (derivativeProduct == null) {
                        derivativeProduct = derivative;
                    } else {
                        derivativeProduct = new Product(derivativeProduct, functions[j]);
                    }
                }
            }

            derivatives[i] = derivativeProduct;
        }

        if (derivatives.length == 2) {
            return new Sum(derivatives[0], derivatives[1]);
        }

        Function[] newFunctions = new Function[functions.length - 2];
        System.arraycopy(derivatives, 2, newFunctions, 0, newFunctions.length);

        return new MultiSum(derivatives[0], derivatives[1], newFunctions);
    }

    /*public Function derivative() {
        Function current  = new Constant(0);
        for (Function function : functions) {
            current = new Sum(current, (function.derivative()));
        }
        return current;
    }*/

}

