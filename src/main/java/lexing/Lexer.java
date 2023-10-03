package lexing;

import java.util.Optional;

public class Lexer {

    private StringBuilder input;
    private Token token;
    private String value;
    private boolean exhausted;

    public void init(String input) {
        this.clearState();
        this.input = new StringBuilder(input);
    }

    public void clearState() {
        this.input = null;
        this.token = null;
        this.value = null;
        this.exhausted = false;
    }

    public Optional<Token> peek() {
        for(Token t : Token.values()) {
            Optional<Integer> endOfNextToken = t.endOfMatch(input.toString());

            if(endOfNextToken.isPresent()) {
                return Optional.of(t);
            }
        }
        return Optional.empty();
    }

    public boolean toNextToken() {
        if(!hasNext()) {
            return false;
        }

        String currentInput = input.toString();
        for(Token t : Token.values()) {
            Optional<Integer> endOfNextToken = t.endOfMatch(currentInput);

            if(endOfNextToken.isPresent()) {
                this.token = t;
                this.value = input.substring(0, endOfNextToken.get());
                this.input.delete(0, endOfNextToken.get());
                return true;
            }
        }
        this.exhausted = true;
        return false;
    }


    public boolean hasNext() {
        return !this.exhausted;
    }

    public Token getToken() {
        return this.token;
    }

    public String getValue() {
        return this.value;
    }

    public String remainingEquation() {
        return this.input.toString();
    }
}
