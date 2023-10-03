package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubtractTest {

    @Test
    void evaluate_happyDay_correctResultReturned() {
        Node objectUnderTest = new Subtract(new Number(5), new Number(10));
        double actualResult = objectUnderTest.evaluate();
        assertEquals(-5, actualResult);
    }

    @Test
    void print_happyDay_correctStringReturned() {
        Node objectUnderTest = new Subtract(new Number(5), new Number(10));
        String actualResult = objectUnderTest.print();
        assertEquals("(5.0-10.0)", actualResult);
    }
}
