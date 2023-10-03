package tree;

public class Divide implements Node {
    private final Node left;
    private final Node right;

    public Divide(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() / right.evaluate();
    }

    @Override
    public String print() {
        return "(" + left.print() + "/" + right.evaluate() + ")";
    }
}
