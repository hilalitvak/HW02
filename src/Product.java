public class Product extends MultiProduct {

    /**
     * constructor for the product of two functions
     *
     * @param fun1
     * @param fun2
     */
    public Product(Function fun1, Function fun2) {
        super(fun1, fun2);
    }

    /**
     * calculates the value of the product of the functions at x
     *
     * @param x the value of the point x
     * @return the value of the product of the functions at x
     */

    public double valueAt(double x) {
        return super.valueAt(x);
    }

    public String toString() {
        return super.toString();
    }

    /**
     * calculates the derivative of the product of the functions
     *
     * @return the derivative of the product of the functions
     */
    public Function derivative() {
        return super.derivative();
    }


    /**
     * calculates the tylor polynomial of the functions
     *
     * @param n the degree of the polynomial
     * @return the tylor polynomial of the functions
     */
    public Polynomial taylorPolynomial(int n) {
        double startValue = valueAt(0);
        double[] taylorPolynomials1 = new double[n + 1];
        taylorPolynomials1[0] = startValue;;

        for (int i = 1; i <= n; i++) {
            taylorPolynomials1[i] = this.derivative().valueAt(0)/ factorial(i);
            //taylorPolynomials1[i - 1] * (i + 1);
        }
        Polynomial polynomial = new Polynomial(taylorPolynomials1);
        return polynomial;
    }



}


