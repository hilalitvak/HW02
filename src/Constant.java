public class Constant extends Function {
    private final double value;

    /**
     * Constructor
     *
     * @param value the value of the constant
     */
    public Constant(double value) {
        super(value);
        this.value = value;
    }


    /**
     * calculates the value of the constant at x
     *
     * @param x the value of the point x
     * @return the value of the constant at x
     */
    public double valueAt(double x) {
        if(value % 1 == 0)
            return (int)Math.round(value);;
        return value;
    }

    /**
     * the representation of the constant
     *
     * @return the representation of the constant
     */
    public String toString() {
        if(value % 1 == 0)
            return "("+ (int)Math.round(value) +")";
        return "(" + value+")";
    }

    /**
     * calculates the derivative of the constant
     *
     * @return the derivative of the constant
     */
    public Function derivative() {
        return new Constant(0);
    }

    /**
     * calculates the taylor polynomial of the constant
     *
     * @param n the degree of the taylor polynomial
     * @return the taylor polynomial of the constant
     */
    public Polynomial taylorPolynomial(int n) {
        return value % 1 == 0 ? new Polynomial((int)Math.round(value)) : new Polynomial(value);
    }
}



