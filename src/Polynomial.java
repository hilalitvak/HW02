
public class Polynomial extends Function{
    private double[] coefficients;
    /**
     * constructor
     *
     * @param coefficients the coefficients of the polynomial
     */
    public Polynomial(double... coefficients) {
        this.coefficients = coefficients;
    }

    /**
     * return the representation of the function as a string
     * @return the representation of the function as a string
     */
    @Override
    public String toString()
    {
        String poly_string="";
        if(this.coefficients[0] != 0)
            poly_string += this.coefficients[0]+"+";//add the constant to string
        for(int i=1; i < this.coefficients.length; i++){
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

    /**
     * gives the value of the function in a certain point
     * @param x the value of the point x
     * @return the value of the function in point x
     */
    public double valueAt(double x){
        double value=0;
        for(int i=0; i < this.coefficients.length; i++){
            if(i==0)
                value+= this.coefficients[i];
            else
                value+= this.coefficients[i]*Math.pow(x, i);
        }
        return value;
    }

    /**
     * gives the derivative of the function
     * @return the derivative of the function
     */
    public Function derivative(){
        double[] derivative_coefficients= new double[this.coefficients.length-1];
        for(int i=1; i < this.coefficients.length; i++)
            derivative_coefficients[i-1]= this.coefficients[i]*i;
        return new Polynomial(derivative_coefficients);
    }


}
