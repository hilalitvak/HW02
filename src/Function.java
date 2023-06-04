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
                value+= this.values[i]*Math.pow(x, i);
        }
        return value;
    }

    /**
     * @return the representation of the function as a string
     */
    @Override
    public String toString() {
        return "("+super.toString()+")";
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
        Polynomial taylor;
        Function newFunction= this;
        double[] coefficients= new double[n+1];
        if(n==0)
            taylor = new Polynomial(0);//return 0
        else{
            for(int i=0; i < n; i++){
                coefficients[i]= newFunction.derivative().valueAt(0)/factorial(i);
                newFunction= newFunction.derivative();//derivative of the function
            }
        }
        taylor = new Polynomial(coefficients);
        return taylor;
    }

    /**
     * adds two functions together and returns the result
     * @param f the function to add
     * @return the result of the addition
     */
    public Function add(Function f){
        double[] new_values= new double[Math.max(this.values.length, f.values.length)];
        for(int i=0; i < new_values.length; i++){
            if(i < this.values.length && i < f.values.length)//if both are in range
                new_values[i]= this.values[i] + f.values[i];
            else if(i < this.values.length)//if f is shorter than this
                new_values[i]= this.values[i];
            else//if this is shorter than f
                new_values[i]= f.values[i];
        }
        return new Function(new_values);
    }


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

}