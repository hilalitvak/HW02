public class Function {
    private double[] values;

    /**
     * the constructor of the class
     */
    public Function(double... values) {
        this.values = values;
    }


    /**
     * return the value of the function at x
     *
     * @param x the value of the point x
     * @return the value of the function at x
     */
    public double valueAt(double x) {
        double value=0;
        for(int i=0; i < this.values.length; i++){
            if(i==0)
                value+= this.values[i];
            else
                value+= this.values[i]*Math.pow(x, i);//add the coefficient and the power of x
        }
        return value;
    }

    /**
     *
     * @param coefficient the coefficient of the polynomial
     * @return the coefficient as an int
     */
    private String formatCoefficient(double coefficient) {
        if (coefficient % 1 == 0) {
            return Integer.toString((int) coefficient);
        } else {
            return Double.toString(coefficient);
        }
    }

    /**
     * @return the representation of the function as a string
     */
    @Override
    public String toString() {
            StringBuilder polyString = new StringBuilder();
            if (values.length == 0) {
                return "(0)";
            }

            for (int i = 0; i < values.length; i++) {
                double coefficient = values[i];

                if (coefficient != 0) {
                    if (i == 0) {
                        polyString.append(formatCoefficient(coefficient));
                    } else {
                        if (polyString.length() != 0) {
                            polyString.append(" + ");
                        }

                        if (coefficient != 1) {
                            polyString.append(formatCoefficient(coefficient));
                        }

                        polyString.append("x");

                        if (i > 1) {
                            polyString.append("^").append(i);
                        }
                    }
                }
            }

            if (polyString.length() == 0) {
                return "(0)";
            }

            return "(" + polyString + ")";
    }





    /**
     * calculates the derivative of the function
     *
     * @return the derivative of the function
     */
    public Function derivative() {
        return new Function(0);
    }

    /**
     * calculates the derivation of the function in the segment between a and b, with an 10^-5 error
     * @param a the left side of the segment
     * @param b the right side of the segment
     * @return the derivation of the function in the segment between a and b
     */
    public double bisectionMethod(double a, double b) {
        return bisectionMethod(a,b, 0.00001);
    }

    /**
     * calculates the derivation of the function in the segment between a and b, with an epsilon error
     * with the bisection method
     * @param a the left side of the segment
     * @param b the right side of the segment
     * @param epsilon the error
     * @return the derivation of the function in the segment between a and b
     */
    public double bisectionMethod(double a, double b, double epsilon) {
        double left= a, right = b, mid;
        while(right - left > epsilon){
            mid= (left + right)/2;
            if(this.valueAt(left)*this.valueAt(right) > 0)
                left= mid;
            else
                right=mid;
        }
        return (left + right)/2;
    }

    /**
     * @return the values of the function
     */
    public double[] getValues() {
        return values;
    }



    /**
     *
     * @param a
     * @param epsilon
     * @return
     */
    public double newtonRaphsonMethod(double a, double epsilon) {
        if(this.valueAt(a) == 0)//if a is a root
            return a;
        if (this.values.length == 0)//if the function is a constant
            return 0;
        double[] x= new double[this.values.length];
        x[0]=a;
        int k=1;
        while(Math.abs(this.valueAt(x[k])) < epsilon){
            x[k+1]= x[k] - (this.valueAt(x[k])/this.derivative().valueAt(x[k]));
            k++;
        }
        return x[k];
    }

    public double newtonRaphsonMethod(double a) {
        return newtonRaphsonMethod(a, 0.00001);
    }

    /**
     * gives the factorial of n
     * @param n the number to factorial
     * @return the factorial of n
     */
    public double factorial(int n){
        double factorial=1;
        for(int i=1; i <= n; i++)
            factorial *= i;
        return factorial;
    }


    /**
     * gives taylorPolynomial of n power of function
     * @param n
     * @return
     */
    public Polynomial taylorPolynomial(int n){
        double[] coefficeint= new double[n+1];
        if(this.values.length == 0)
            return new Polynomial(0);
        if(n==0)
            return new Polynomial(this.values[0]);
        for(int i = 0; i < (Math.min(n+1, this.values.length)); i++){
            coefficeint[i]= this.values[i];
        }
        return new Polynomial(coefficeint);
    }

    /**
     * adds two functions together and returns the result
     * @param f the function to add
     * @return the result of the addition
     */
    public Function add(Function f) {
        int resultLength = Math.max(this.values.length, f.values.length);
        double[] newValues = new double[resultLength];

        for (int i = 0; i < this.values.length; i++) {
            newValues[i] += this.values[i];
        }

        for (int i = 0; i < f.values.length; i++) {
            newValues[i] += f.values[i];
        }

        return new Function(newValues);
    }


    /**
     * subtracts two functions together and returns the result
     * @param f the function to subtract
     * @return the result of the subtraction
     */
    public Function subtract(Function f){
        double[] new_values= new double[Math.max(this.values.length, f.values.length)];
        for(int i=0; i < new_values.length; i++){
            if(i < this.values.length && i < f.values.length)//if both are in range
                new_values[i]= this.values[i] - f.values[i];
            else if(i < this.values.length)//if f is shorter than this
                new_values[i]= this.values[i];
            else//if this is shorter than f
                new_values[i]= -f.values[i];
        }
        return new Function(new_values);
    }

    /**
     * multiplies two functions together and returns the result
     * @param f the function to multiply
     * @return the result of the multiplication
     */
    public Function multiply(Function f) {
        int resultLength = this.values.length + f.values.length - 1;
        if (resultLength <= 0) {
            return new Function(new double[]{0});
        }

        double[] newValues = new double[resultLength];

        for (int i = 0; i < this.values.length; i++) {
            for (int j = 0; j < f.values.length; j++) {
                newValues[i + j] += this.values[i] * f.values[j];
            }
        }
        return new Function(newValues);
    }

    /**
     * divides the function by a constant
     * @param divisor the constant to divide by
     * @return the result of the division
     */
    public Polynomial divide(double divisor) {
        double[] dividedCoefficients = new double[this.values.length];
        for (int i = 0; i < this.values.length; i++) {
            dividedCoefficients[i] = this.values[i] / divisor;
        }
        return new Polynomial(dividedCoefficients);
    }

}