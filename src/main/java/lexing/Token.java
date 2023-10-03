package lexing;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Token {

    ADD("\\+"),
    SUBTRACT("-"),
    MULTIPLY("\\*"),
    DIVIDE("\\/"),
    OPENED_PARENTHESES("\\("),
    CLOSED_PARENTHESES("\\)"),
    NEGATE("\\?"),
    NUMBER("(\\d+(?:\\.\\d+)?)");

    private final Pattern pattern;

    Token(String pattern) {
        this.pattern = Pattern.compile("^" + pattern);
    }

    public Optional<Integer> endOfMatch(String input) {
        Matcher matcher = pattern.matcher(input);

        if(matcher.find()) {
            return Optional.of(matcher.end());
        }
        return Optional.empty();
    }
}
