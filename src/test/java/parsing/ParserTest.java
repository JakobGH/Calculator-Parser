package parsing;

import org.junit.jupiter.api.Test;
import tree.Node;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParserTest {

    @Test
    void parseRoot_happyDay_inputParsedCorrectly() {
        Parser objectUnderTest = new Parser();
        Node actualResult = objectUnderTest.parseRoot("-5+(2*(4+5)*5+(100*2)*2)-3");
        assertNotNull(actualResult);
        System.out.println(actualResult.print());
        assertEquals(482, actualResult.evaluate());
    }
}
