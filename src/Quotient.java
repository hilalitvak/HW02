public class Quotient extends Function{
    private Function denoFunc;//mecane
    private Function numFunc;//mone

    /**
     * constructor for the quotient of two functions
     * @param denoFunc denominator function of the quotient
     * @param numFunc numerator function of the quotient
     */
    public Quotient(Function numFunc, Function denoFunc) {
        this.numFunc = numFunc;//mecane
        this.denoFunc = denoFunc;//mone
    }

    /**
     * the representation the quotient of two functions
     * @return the representation the quotient of two functions
     */
    public String toString() {
        return "(" + numFunc + " / " +  denoFunc + ")";
    }

    /**
     * calculates the value of the quotient of two functions at x
     * @param x the value of the point x
     * @return the value of the quotient of two functions at x
     */
    public double valueAt(double x) {
        return numFunc.valueAt(x) / denoFunc.valueAt(x);
    }

    /**
     * calculates the derivative of the quotient of two functions by
     * using the quotient rule of differentiation (f/g)' = (f'g - fg')/g^2
     * @return the derivative of the quotient of two functions
     */
    public Function derivative() {
        return new Quotient(new Difference(new Product(denoFunc, numFunc.derivative()), new Product(numFunc, denoFunc.derivative())),
                                new Power(denoFunc, 2));
    }
    /**
     * calculates the taylor polynomial of the quotient of two functions
     * @param n the degree of the taylor polynomial
     * @return the taylor polynomial of the quotient of two functions
     */
    public Polynomial taylorPolynomial(int n) {
        return numFunc.taylorPolynomial(n).divide(denoFunc.taylorPolynomial(n));
    }


}
