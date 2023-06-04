public class Log extends Function {
    private Function base;
    private Function argument;

    /**
     * constructor for the logarithm of two functions
     * @param base the base function of the logarithm
     * @param argument the argument function of the logarithm
     */
    public Log(Function base, Function argument) {
        this.base = base;
        this.argument = argument;
    }
    /**
     * the representation the logarithm of two functions
     * @return the representation the logarithm of two functions
     */
    public String toString() {
        return "log" + base + "(" + argument + ")";
    }
    /**
     * calculates the value of the logarithm of two functions at x by using the formula log_a(b) = ln(b)/ln(a)
     * @param x the value of the point x
     * @return the value of the logarithm of two functions at x
     */
    public double valueAt(double x) {
        return Math.log(argument.valueAt(x)) / Math.log(base.valueAt(x));
    }

    /**
     * calculates the derivative of the logarithm of two functions
     * by using the chain rule of differentiation (log f)' = f'/f and (log f)' = (1/f) * f'
     * @return the derivative of the logarithm of two functions
     */
    public Function derivative() {
        return new Quotient(new Log(new Constant(Math.E), argument), new Log(new Constant(Math.E), base));
    }
}
