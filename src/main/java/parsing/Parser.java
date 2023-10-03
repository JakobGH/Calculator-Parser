package parsing;

import lexing.Lexer;
import lexing.Token;
import tree.*;
import tree.Number;

import java.util.Optional;

public class Parser {

    private final Lexer lexer;

    public Parser() {
        this.lexer = new Lexer();
    }

    public Node parseRoot(String input) {
        this.lexer.init(input);
        return parseExpression();
    }

    private Node parseExpression() {
        Node a = parseTerm();
        while (lexer.hasNext()) {

            Optional<Token> peek = lexer.peek();

            if (peek.isEmpty()) {
                return a;
            }

            Token token = peek.get();

            if (token == Token.ADD) {
                lexer.toNextToken();
                Node b = parseExpression();
                a = new Add(a, b);
            } else if (token == Token.SUBTRACT) {
                lexer.toNextToken();
                Node b = parseExpression();
                a = new Subtract(a, b);
            } else {
                return a;
            }
        }
        return a;
    }

    private Node parseTerm() {
        Node a = parseFactor();

        Optional<Token> peek = lexer.peek();
        if (peek.isEmpty()) {
            return a;
        }

        Token token = peek.get();

        if (token == Token.MULTIPLY) {
            lexer.toNextToken();
            return new Multiply(a, parseTerm());
        } else if (token == Token.DIVIDE) {
            lexer.toNextToken();
            return new Divide(a, parseTerm());
        }
        return a;
    }

    private Node parseFactor() {

        Optional<Token> peek = lexer.peek();

        if (peek.isEmpty()) {
            throw new IllegalStateException("No token present!");
        }

        Token token = peek.get();

        if (token == Token.NUMBER) {
            lexer.toNextToken();
            return new Number(lexer.getValue());
        } else if (token == Token.OPENED_PARENTHESES) {
            if (lexer.toNextToken()) {
                Node a = parseExpression();
                if (lexer.hasNext()) {
                    if (lexer.peek().get() == Token.CLOSED_PARENTHESES) {
                        lexer.toNextToken();
                        return a;
                    } else {
                        throw new IllegalStateException("Missing ')' at: " + lexer.remainingEquation());
                    }
                } else {
                    throw new IllegalStateException("Missing ')' at: " + lexer.remainingEquation());
                }

            } else {
                throw new IllegalStateException("Missing content at: " + lexer.remainingEquation());
            }
        } else if(token == Token.SUBTRACT) {
            lexer.toNextToken();
            return new Negate(parseFactor());
        }
        throw new IllegalStateException("Missing content at: " + lexer.remainingEquation());
    }
}
