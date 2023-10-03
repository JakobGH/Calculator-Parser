package lexing;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LexerTest {

    @Test
    void test_happyDay_lexerReturnsAllTokensCorrectly() {
        String input = "+-";

        Lexer objectUnderTest = new Lexer();
        objectUnderTest.init(input);
        Map<Token, String> result = new HashMap<>();

        while(objectUnderTest.hasNext()) {
            if(objectUnderTest.toNextToken()) {
                result.put(objectUnderTest.getToken(), objectUnderTest.getValue());
            }
        }

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("+", result.get(Token.ADD));
        assertEquals("-", result.get(Token.SUBTRACT));
    }
}
