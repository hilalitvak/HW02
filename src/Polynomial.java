
public class Polynomial extends Function{
    private double[] coefficients;
    /**
     * constructor
     *
     * @param coefficients the coefficients of the polynomial
     */
    public Polynomial(double... coefficients) {
        super(0);
        this.coefficients = coefficients;
    }

    /**
     * return the representation of the function as a string
     * @return the representation of the function as a string
     */
    @Override
    public String toString() {
        String poly_string="";
        for(int i=0; i < this.coefficients.length; i++){
            if (this.coefficients[i] != 0)
                if(this.coefficients[i] == 1 || this.coefficients[i] == -1)
                    poly_string += "x^"+i+"+";//add the power of x
                else if((Math.round(this.coefficients[i]) == this.coefficients[i]))
                    poly_string += ((int)this.coefficients[i])+"x^"+i+"+";//add the coefficient and the power of x
                else
                    poly_string += this.coefficients[i]+"x^"+i+"+";//add the coefficient and the power of x
        }
        return poly_string.substring(0, poly_string.length()-2);//remove the last "+"
    }


}
