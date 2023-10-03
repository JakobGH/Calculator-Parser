package tree;

public class Negate implements Node {

    private final Node negate;

    public Negate(Node negate) {
        this.negate = negate;
    }

    @Override
    public double evaluate() {
        return negate.evaluate() * -1;
    }

    @Override
    public String print() {
        return "(-" + negate.print() + ")";
    }
}
