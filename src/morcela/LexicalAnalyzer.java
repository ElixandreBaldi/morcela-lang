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
        char currentLine = 1;
        char currentColumn = 0;
        for (int i = 0; i < content.length(); i++) {
            currentColumn++;
            char currentCharacter = content.charAt(i);
            if (currentCharacter == '*') {
                tokens.add(new Token(Token.TokenType.MULT, currentLine, currentColumn));
            } else if (currentCharacter == ',') {
                tokens.add(new Token(Token.TokenType.COMMA, currentLine, currentColumn));
            } else if (currentCharacter == '/') {
                i = lookAheadSlash(currentLine, currentColumn, i);
            } else if (currentCharacter == '^') {
                tokens.add(new Token(Token.TokenType.XOR, currentLine, currentColumn));
            } else if (currentCharacter == '|') {
                i = lookAheadPipe(currentLine, currentColumn, i);
            } else if (currentCharacter == '{') {
                tokens.add(new Token(Token.TokenType.OPEN_BRACES, currentLine, currentColumn));
            } else if (currentCharacter == '}') {
                tokens.add(new Token(Token.TokenType.CLOSE_BRACES, currentLine, currentColumn));
            } else if (currentCharacter == '"') {
                i = lookAheadQuote(currentLine, currentColumn, i);
            } else if (currentCharacter == '(') {
                tokens.add(new Token(Token.TokenType.OPEN_PAR, currentLine, currentColumn));
            } else if (currentCharacter == ')') {
                tokens.add(new Token(Token.TokenType.CLOSE_PAR, currentLine, currentColumn));
            } else if (currentCharacter == '[') {
                tokens.add(new Token(Token.TokenType.OPEN_SIZE_STRING, currentLine, currentColumn));
            } else if (currentCharacter == ']') {
                tokens.add(new Token(Token.TokenType.CLOSE_SIZE_STRING, currentLine, currentColumn));
            } else if (currentCharacter == ':') {
                tokens.add(new Token(Token.TokenType.DOUBLE_DOT, currentLine, currentColumn));
            } else if (currentCharacter == ';') {
                tokens.add(new Token(Token.TokenType.SEMICOLON, currentLine, currentColumn));
            } else if (currentCharacter == '=') {
                i = lookAheadEqual(currentLine, currentColumn, i);
            } else if (currentCharacter == '!') {
                i = lookAheadExclamation(currentLine, currentColumn, i);
            } else if (currentCharacter == '>') {
                i = lookAheadBigger(currentLine, currentColumn, i);
            } else if (currentCharacter == '<') {
                i = lookAheadLess(currentLine, currentColumn, i);
            } else if (currentCharacter == '+') {
                i = lookAheadPlus(currentLine, currentColumn, i);
            } else if (currentCharacter == '-') {
                i = lookAheadMinus(currentLine, currentColumn, i);
            } else if (Character.isDigit(currentCharacter)) {
                i = lookAheadDigit(currentLine, currentColumn, i);
            } else if (currentCharacter == '\n') {
                currentLine++;
                currentColumn = 0;
            } else if (Character.isSpaceChar(currentCharacter)) {
                continue;
            } else {
                errors.add(new LexicalError(currentLine, currentColumn, String.valueOf(currentCharacter)));
            }
        }
    }

    private int lookAheadDigit(int line, int column, int initialTokenPos) {
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
        tokens.add(new Token(Token.TokenType.NUM, line, column, number.toString()));
        return i;
    }

    private int lookAheadQuote(int line, int column, int initialTokenPos) {
        StringBuilder stringContent = new StringBuilder();
        int i = initialTokenPos + 1;
        do {
            if (i == content.length()) {
                errors.add(new LexicalError(line, column, String.valueOf(content.charAt(initialTokenPos))));
                return initialTokenPos;
            }
            char next = content.charAt(i);
            if (next != '"') {
                stringContent.append(next);
            } else break;
            i++;
        } while (true);
        tokens.add(new Token(Token.TokenType.STRING, line, column, stringContent.toString()));

        return i;
    }

    private int lookAheadSlash(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '/') {
            return addComment(line, column, initialTokenPos + 2);
        }

        tokens.add(new Token(Token.TokenType.DIV, line, column));
        return initialTokenPos;
    }

    private int addComment(int line, int column, final int initialCommentPos) {
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
        tokens.add(new Token(Token.TokenType.COMMENT, line, column, commentContent.toString()));
        return i;
    }

    private int lookAheadPipe(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '|') {
            tokens.add(new Token(Token.TokenType.OR, line, column));
            return initialTokenPos + 1;
        }

        errors.add(new LexicalError(line, column, String.valueOf(content.charAt(initialTokenPos))));
        return initialTokenPos;
    }

    private int lookAheadEqual(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '=') {
            tokens.add(new Token(Token.TokenType.EQ, line, column));
            return initialTokenPos + 1;
        }

        tokens.add(new Token(Token.TokenType.ATT, line, column));
        return initialTokenPos;
    }

    private int lookAheadExclamation(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '=') {
            tokens.add(new Token(Token.TokenType.DIF, line, column));
            return initialTokenPos + 1;
        }

        errors.add(new LexicalError(line, column, String.valueOf(content.charAt(initialTokenPos))));
        return initialTokenPos;
    }

    private int lookAheadBigger(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '=') {
            tokens.add(new Token(Token.TokenType.BIGGER_EQ, line, column));
            return initialTokenPos + 1;
        }

        tokens.add(new Token(Token.TokenType.BIGGER, line, column));
        return initialTokenPos;
    }

    private int lookAheadLess(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '=') {
            tokens.add(new Token(Token.TokenType.LESS_EQ, line, column));
            return initialTokenPos + 1;
        }

        tokens.add(new Token(Token.TokenType.LESS, line, column));
        return initialTokenPos;
    }

    private int lookAheadPlus(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '+') {
            tokens.add(new Token(Token.TokenType.INC, line, column));
            return initialTokenPos + 1;
        }

        tokens.add(new Token(Token.TokenType.SUM, line, column));
        return initialTokenPos;
    }

    private int lookAheadMinus(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '-') {
            tokens.add(new Token(Token.TokenType.DEC, line, column));
            return initialTokenPos + 1;
        }

        tokens.add(new Token(Token.TokenType.SUB, line, column));
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
