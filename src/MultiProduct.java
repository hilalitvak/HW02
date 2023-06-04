public class MultiProduct extends Function{
    private Function[] functions;

    /**
     * constructor for the MultiProduct class
     *
     * @param functions the functions to be multiplied
     */
    public MultiProduct(Function function1,Function function2,Function... functions) {
        this.functions = new Function[functions.length + 2];
        this.functions[0] = function1;
        this.functions[1] = function2;
        for (int i = 0; i < functions.length; i++) {
            this.functions[i + 2] = functions[i];
        }
    }

    /**
     * calculates the value of the product of the functions at x
     *
     * @param x the value of the point x
     * @return the value of the product of the functions at x
     */
    public double valueAt(double x) {
        double product = 1;
        for (Function function : functions) {
            product *= function.valueAt(x);//product = product * function.valueAt(x);
        }
        return product;
    }

    /**
     * the representation the product of the functions
     *
     * @return the representation the product of the functions
     */
    public String toString() {
        String product = "(";
        int index = functions.length;
        for (Function function : functions) {
            if(index == 1)
                product += function.toString();
            else
                product += function.toString() + " * ";
            index--;

        }
        return product + ")";
    }

    /**
     * calculates the derivative of the product of the functions
     *
     * @return the derivative of the product of the functions
     */
    public Function derivative() {
        Function[] derivatives = new Function[functions.length];
        for (int i = 0; i < functions.length; i++) {
            for (int j = 0; j < functions.length; j++) {
                if (!(i == j)) {
                    derivatives[i] = new Product(functions[i].derivative(), functions[j]);
                }
            }
        }
        if(derivatives.length == 2)
            return new Sum(derivatives[0],derivatives[1]);
        Function[] newFunctions = new Function[functions.length-2];
        for(int i = 0; i < newFunctions.length; i++){
            newFunctions[i] = derivatives[i+2];
        }
        return new MultiSum(derivatives[0],derivatives[1],newFunctions);
    }

    /**
     * calculates the taylor polynomial of the product of the functions
     *
     * @param n the degree of the taylor polynomial
     * @return the taylor polynomial of the product of the functions
     */
    public Polynomial taylorPolynomial(int n) {
        if(functions.length == 2)
            return new Product(functions[0],functions[1]).taylorPolynomial(n);
        Function[] newfunc= new Function[functions.length-2];
        for(int i = 0; i < newfunc.length; i++){
            newfunc[i] = functions[i+2];
        }
        Function newProduct = new MultiProduct(functions[0], functions[1],newfunc).derivative();
        return newProduct.taylorPolynomial(n);
    }

}
