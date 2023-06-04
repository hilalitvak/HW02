
public class Power extends Function{
    private Function base;
    private int exponent;

    /**
     * constructor for the power of two functions
     * @param base the base function of the power
     * @param exponent the exponent function of the power
     */
    public Power(Function base, int exponent) {
        this.base = base;
        this.exponent = exponent;
    }
    /**
     * calculates the value of the power of two functions at x
     * by using the formula a^b = e^(b*ln(a))
     * @param x the value of the point x
     * @return the value of the power of two functions at x
     */
    public double valueAt(double x) {
        return Math.pow(base.valueAt(x), exponent);
    }

    /**
     * the representation the power of two functions
     * @return the representation the power of two functions
     */
    public String toString() {
        return "(" + base + "^" + exponent + ")";
    }

    /**
     * calculates the derivative of the power of two functions
     * @return the derivative of the power of two functions
     */
    public Function derivative() {
        if(exponent == 0)
            return new Constant(0);
        if (exponent == 1)
            return base.derivative();
        return new Product(new Constant(exponent) ,
                new Product(new Power(base, exponent - 1), base.derivative()));
    }

}
