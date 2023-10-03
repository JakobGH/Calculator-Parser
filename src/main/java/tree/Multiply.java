package tree;

public class Multiply implements Node {

    private final Node left;
    private final Node right;

    public Multiply(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }

    @Override
    public String print() {
        return "(" + left.print() + "*" + right.evaluate() + ")";
    }
}
