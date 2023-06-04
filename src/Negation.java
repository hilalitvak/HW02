public class Negation extends Function{
    private Function origFun;

    /**
     * constructor for the negation of a function
     * @param origFun the function to be negated
     */
    public Negation(Function negaFun){
        this.origFun = negaFun;
    }
    /**
     * the representation of the negation of a function
     * @return the representation of the negation of a function
     */
    public double valueAt(double x){
        double newVal= origFun.valueAt(x);
        return -newVal;
    }
    /**
     * calculates the derivative of the negation of a function
     * @return the derivative of the negation of a function
     */
    public Function derivative() {
        return new Negation(origFun.derivative());
    }
    /**
     * the representation of the negation of a function
     * @return the representation of the negation of a function
     */
    public String toString() {
        return "(-" + origFun + ")";
    }

    public Polynomial taylorPolynomial(int n) {
        return origFun.taylorPolynomial(n).negate();
    }


}
