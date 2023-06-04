public class Sum extends MultiSum{

    /**
     * constructor for the sum of two functions
     * @param fun1 first function
     * @param fun2 second function
     */
    public Sum(Function fun1, Function fun2) {
        super(fun1, fun2);
    }
    /**
     * calculates the value of the sum of the functions at x
     * @param x the value of the point x
     * @return the value of the sum of the functions at x
     */
    public double valueAt(double x) {
        return super.valueAt(x);
    }
    /**
     * calculates the derivative of the sum of the functions
     * @return the derivative of the sum of the functions
     */
    public String toString() {
        return super.toString();
    }


        /**
         * calculates the tylor polynomial of the functions
         * @param n the degree of the polynomial
         * @return the tylor polynomial of the functions
         */
    public Polynomial taylorPolynomial(int n) {
        return super.taylorPolynomial(n);
    }

}