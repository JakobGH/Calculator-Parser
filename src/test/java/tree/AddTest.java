package tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddTest {

    @Test
    void evaluate_happyDay_correctResultReturned() {
        Node objectUnderTest = new Add(new Number(5), new Number(10));
        double actualResult = objectUnderTest.evaluate();
        assertEquals(15, actualResult);
    }

    @Test
    void print_happyDay_correctStringReturned() {
        Node objectUnderTest = new Add(new Number(5), new Number(10));
        String actualResult = objectUnderTest.print();
        assertEquals("(5.0+10.0)", actualResult);
    }
}
