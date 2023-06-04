public class MultiSum extends Function{
    private Function[] functions;

    public MultiSum(Function... functions) {
        this.functions = functions;
    }

    public double valueAt(double x) {
        double sum = 0;
        for (Function function : functions) {
            sum += function.valueAt(x);
        }
        return sum;
    }

    public String toString() {
        String sum = "";
        for (Function function : functions) {
            sum += "(" + function.toString() + "+";
        }
        return sum.substring(0,sum.length()-2)+ ")";
    }

    public Function derivative() {
        Function current  = new Constant(0);
        for (Function function : functions) {
            current = current.add(function.derivative());
        }
        return current;
    }


}

