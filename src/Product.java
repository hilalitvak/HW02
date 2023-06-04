public class Product extends Function {
    private Function fun1;
    private Function fun2;

    /**
     * constructor for the product of two functions
     *
     * @param fun1
     * @param fun2
     */
    public Product(Function fun1, Function fun2) {
        this.fun1 = fun1;
        this.fun2 = fun2;
    }

}
