package tree;

public class Number implements Node {

    private final double value;

    public Number(double value) {
        this.value = value;
    }

    public Number(String value) {
        this.value = Double.parseDouble(value);
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String print() {
        return String.valueOf(value);
    }
}
