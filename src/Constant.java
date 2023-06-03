public class Constant extends Function{

    /**
     * Constructor
     *
     * @param value the value of the constant
     */
    public Constant(double value){
        super(value);
    }
    /**
     * @return the representation of the function as a string
     */
    public String toString(){
        return "("+this+")";
    }



}
