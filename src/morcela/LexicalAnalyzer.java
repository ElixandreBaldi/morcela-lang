package morcela;

import java.util.ArrayList;

class LexicalAnalyzer {
    private String content;

    private ArrayList<Token> tokens;

    private ArrayList<LexicalError> errors;

    LexicalAnalyzer(String content) {
        this.content = content;
        this.tokens = new ArrayList<>();
        this.errors = new ArrayList<>();
    }

    void run() {
        for (int i = 0; i < content.length(); i++) {
            char charCurrent = content.charAt(i);
            if (charCurrent == '*') {
                tokens.add(new Token(Token.TokenType.MULT));
            } else if (charCurrent == ',') {
                tokens.add(new Token(Token.TokenType.COMMA));
            } else if (charCurrent == '/') {
                i = lookAheadSlash(i);
            } else if (charCurrent == '^') {
                tokens.add(new Token(Token.TokenType.XOR));
            } else if (charCurrent == '|') {
                i = lookAheadPipe(i);
            } else if (charCurrent == '{') {
                tokens.add(new Token(Token.TokenType.OPEN_BRACES));
            } else if (charCurrent == '}') {
                tokens.add(new Token(Token.TokenType.CLOSE_BRACES));
            } else if (charCurrent == '"') {
                i = lookAheadQuote(i);
            } else if (charCurrent == '(') {
                tokens.add(new Token(Token.TokenType.OPEN_PAR));
            } else if (charCurrent == ')') {
                tokens.add(new Token(Token.TokenType.CLOSE_PAR));
            } else if (charCurrent == '[') {
                tokens.add(new Token(Token.TokenType.OPEN_SIZE_STRING));
            } else if (charCurrent == ']') {
                tokens.add(new Token(Token.TokenType.CLOSE_SIZE_STRING));
            } else if (charCurrent == ':') {
                tokens.add(new Token(Token.TokenType.DOUBLE_DOT));
            } else if (charCurrent == ';') {
                tokens.add(new Token(Token.TokenType.SEMICOLON));
            } else if (charCurrent == '=') {
                i = lookAheadEqual(i);
            } else if (charCurrent == '!') {
                i = lookAheadExclamation(i);
            } else if (charCurrent == '>') {
                i = lookAheadBigger(i);
            } else if (charCurrent == '<') {
                i = lookAheadLess(i);
            } else if (charCurrent == '+') {
                i = lookAheadPlus(i);
            } else if (charCurrent == '-') {
                i = lookAheadMinus(i);
            } else if (Character.isDigit(charCurrent)) {
                i = lookAheadDigit(i);
            } else if (Character.isSpaceChar(charCurrent)) {
                continue;
            } else {
                errors.add(new LexicalError("Unexpected char " + charCurrent));
            }
        }
    }

    private int lookAheadDigit(int initialTokenPos) {
        StringBuilder number = new StringBuilder();
        int i = initialTokenPos;
        do {
            if (i == content.length()) break;
            char next = content.charAt(i);
            if (Character.isDigit(next) || next == '.') {
                number.append(next);
            } else {
                i--;
                break;
            }
            i++;
        } while (true);
        tokens.add(new Token(Token.TokenType.NUM, number.toString()));
        return i;
    }

    private int lookAheadQuote(int initialTokenPos) {
        StringBuilder stringContent = new StringBuilder();
        int i = initialTokenPos + 1;
        do {
            if (i == content.length()) {
                errors.add(new LexicalError("Unexpected char " + content.charAt(initialTokenPos)));
                return initialTokenPos;
            }
            char next = content.charAt(i);
            if (next != '"') {
                stringContent.append(next);
            } else break;
            i++;
        } while (true);
        tokens.add(new Token(Token.TokenType.STRING, stringContent.toString()));

        return i;
    }

    private int lookAheadSlash(int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '/') {
            return addComment(initialTokenPos + 2);
        }

        tokens.add(new Token(Token.TokenType.DIV));
        return initialTokenPos;
    }

    private int addComment(final int initialCommentPos) {
        StringBuilder commentContent;
        commentContent = new StringBuilder();
        int i = initialCommentPos;
        do {
            if (i == content.length()) break;
            char next = content.charAt(i);
            if (next == '\n') break;
            commentContent.append(next);
            i++;
        } while (true);
        tokens.add(new Token(Token.TokenType.COMMENT, commentContent.toString()));
        return i;
    }

    private int lookAheadPipe(int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '|') {
            tokens.add(new Token(Token.TokenType.OR));
            return initialTokenPos + 1;
        }

        errors.add(new LexicalError("Unexpected char " + content.charAt(initialTokenPos)));
        return initialTokenPos;
    }

    private int lookAheadEqual(int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '=') {
            tokens.add(new Token(Token.TokenType.EQ));
            return initialTokenPos + 1;
        }

        tokens.add(new Token(Token.TokenType.ATT));
        return initialTokenPos;
    }

    private int lookAheadExclamation(int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '=') {
            tokens.add(new Token(Token.TokenType.DIF));
            return initialTokenPos + 1;
        }

        errors.add(new LexicalError("Unexpected char " + content.charAt(initialTokenPos)));
        return initialTokenPos;
    }

    private int lookAheadBigger(int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '=') {
            tokens.add(new Token(Token.TokenType.BIGGER_EQ));
            return initialTokenPos + 1;
        }

        tokens.add(new Token(Token.TokenType.BIGGER));
        return initialTokenPos;
    }

    private int lookAheadLess(int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '=') {
            tokens.add(new Token(Token.TokenType.LESS_EQ));
            return initialTokenPos + 1;
        }

        tokens.add(new Token(Token.TokenType.LESS));
        return initialTokenPos;
    }

    private int lookAheadPlus(int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '+') {
            tokens.add(new Token(Token.TokenType.INC));
            return initialTokenPos + 1;
        }

        tokens.add(new Token(Token.TokenType.SUM));
        return initialTokenPos;
    }

    private int lookAheadMinus(int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '-') {
            tokens.add(new Token(Token.TokenType.DEC));
            return initialTokenPos + 1;
        }

        tokens.add(new Token(Token.TokenType.SUB));
        return initialTokenPos;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (LexicalError error : errors) {
            result.append(error);
            result.append("\n");
        }
        for (Token token : tokens) {
            result.append(token);
            result.append("\n");
        }
        return result.toString();
    }
}
