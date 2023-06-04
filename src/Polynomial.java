
public class Polynomial extends Function {
    /**
     * constructor
     *
     * @param coefficients the coefficients of the polynomial
     */
    public Polynomial(double... coefficients) {
        super(coefficients);
    }

    /**
     * return the representation of the function as a string
     *
     * @return the representation of the function as a string
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * gives the value of the function in a certain point
     *
     * @param x the value of the point x
     * @return the value of the function in point x
     */
    public double valueAt(double x) {
        return super.valueAt(x);//call the function from the super class
    }

    /**
     * gives the derivative of the function
     *
     * @return the derivative of the function
     */
    public Function derivative() {
        double[] coefficients = this.getValues();
        if (coefficients.length == 1 || coefficients.length == 0)
            return new Constant(0);
        double[] derivative_coefficients = new double[coefficients.length - 1];
        for (int i = 1; i < coefficients.length; i++)
            derivative_coefficients[i - 1] = coefficients[i] * i;
        return new Polynomial(derivative_coefficients);
    }


    /**
     * gives the taylor polynomial of the function
     *
     * @return the taylor polynomial of the function
     */
    public Polynomial negate() {
        double[] coefficients = this.getValues();
        double[] negated_coefficients = new double[coefficients.length];
        for (int i = 0; i < coefficients.length; i++)
            negated_coefficients[i] = coefficients[i] * (-1);
        return new Polynomial(negated_coefficients);
    }

    /**
     * gives the taylor polynomial of the function
     *
     * @param polynomial the polynomial to divide by
     * @return the taylor polynomial of the function
     */
    public Polynomial divide(Polynomial polynomial) {
        double[] coefficients = this.getValues();
        double[] polynomialCoefficients = polynomial.getValues();
        if (coefficients.length - polynomialCoefficients.length + 1 <= 0)
            return new Polynomial(0);
        double[] quotientCoefficients = new double[coefficients.length - polynomialCoefficients.length + 1];
        double[] remainderCoefficients = new double[polynomialCoefficients.length - 1];

        for (int i = 0; i < Math.min(coefficients.length, quotientCoefficients.length); i++) {
            quotientCoefficients[i] = coefficients[i];
        }
        for (int i = 0; i < Math.min(polynomialCoefficients.length, remainderCoefficients.length); i++) {
            remainderCoefficients[i] = polynomialCoefficients[i];
        }
        for (int i = 0; i < quotientCoefficients.length; i++) {
            if (quotientCoefficients[i] != 0) {
                for (int j = 0; j < Math.min(remainderCoefficients.length, quotientCoefficients.length ); j++) {
                    quotientCoefficients[i + j] -= remainderCoefficients[j];
                }
            }
        }
        return new Polynomial(quotientCoefficients);
    }



}

