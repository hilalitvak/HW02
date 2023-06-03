public class Function {
    private double value;
    private double[] coefficients;

    /**
     * the constructor of the class
     */
    public Function(double value) {
        this.value = value;
    }

    /**
     * return the value of the function at x
     *
     * @param x the value of the point x
     * @return the value of the function at x
     */
    public double valueAt(double x) {
        return 0;
    }

    /**
     * @return the representation of the function as a string
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * calculates the derivative of the function
     *
     * @return the derivative of the function
     */
    public double derivative() {
        return 0;
    }

    /**
     * calculates the derivation of the function in the segment between a and b, with an 10^-5 error
     * @param a the left side of the segment
     * @param b the right side of the segment
     * @return the derivation of the function in the segment between a and b
     */
    public double bisectionMethod(double a, double b) {
        return 0;
    }

    /**
     * calculates the derivation of the function in the segment between a and b, with an epsilon error
     * @param a the left side of the segment
     * @param b the right side of the segment
     * @param epsilon the error
     * @return the derivation of the function in the segment between a and b
     */
    public double bisectionMethod(double a, double b, double epsilon) {
        return 0;
    }

    /**
     *
     * @param a
     * @param epsilon
     * @return
     */
    public double newtonRaphsonMethod(double a, double epsilon) {
        return 0;
    }

    public double newtonRaphsonMethod(double a) {
        return 0;
    }

    /**
     * gives taylorPolynomial of n power of function
     * @param n
     * @return
     */
    public double taylorPolynomial(double n){
        return 0;
    }

}