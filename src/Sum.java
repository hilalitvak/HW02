public class Sum extends Function{
    private Function fun1;
    private Function fun2;

    public Sum(Function fun1, Function fun2) {
        this.fun1 = fun1;
        this.fun2 = fun2;
    }
    public double valueAt(double x) {
        return fun1.valueAt(x) + fun2.valueAt(x);
    }
    public String toString() {
        return "(" + fun1.toString() + "+" + fun2.toString() + ")";
    }
    public Function derivative() {
        return fun1.derivative().add(fun2.derivative());
    }

        /**
         * calculates the tylor polynomial of the functions
         * @param n the degree of the polynomial
         * @return the tylor polynomial of the functions
         */
    public Polynomial taylorPolynomial(int n) {
        Function newsum= fun1.add(fun2);
        return newsum.taylorPolynomial(n);
    }

}