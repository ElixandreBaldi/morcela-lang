package morcela.analyzer;


import morcela.error.Error;
import morcela.stackable.Token;
import morcela.stackable.TokenType;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class LexicalAnalyzer implements Analyzer {
    private String content;

    private ArrayList<Token> tokens;

    private ArrayList<Error> errors;

    private Pattern letterPattern = Pattern.compile("[A-Za-z]+");

    public LexicalAnalyzer(String content) {
        this.content = content;
        this.tokens = new ArrayList<>();
        this.errors = new ArrayList<>();
    }

    public void run() {
        int currentLine = 1;
        int currentColumn = 1;
        int ignoreNext = 0;
        for (int i = 0; i < content.length(); i++) {
            char currentCharacter = content.charAt(i);
            if (ignoreNext > 0) {
                ignoreNext--;
            } else if (currentCharacter == '*') {
                tokens.add(new Token(TokenType.MULT, currentLine, currentColumn));
            } else if (currentCharacter == ',') {
                tokens.add(new Token(TokenType.COMMA, currentLine, currentColumn));
            } else if (currentCharacter == '/') {
                ignoreNext = lookAheadSlash(currentLine, currentColumn, i);
            } else if (currentCharacter == '^') {
                tokens.add(new Token(TokenType.XOR, currentLine, currentColumn));
            } else if (currentCharacter == '|') {
                ignoreNext = lookAheadPipe(currentLine, currentColumn, i);
            } else if (currentCharacter == '&') {
                ignoreNext = lookAheadAnd(currentLine, currentColumn, i);
            } else if (currentCharacter == '{') {
                tokens.add(new Token(TokenType.OPEN_BRACES, currentLine, currentColumn));
            } else if (currentCharacter == '}') {
                tokens.add(new Token(TokenType.CLOSE_BRACES, currentLine, currentColumn));
            } else if (currentCharacter == '"') {
                ignoreNext = lookAheadQuote(currentLine, currentColumn, i);
            } else if (currentCharacter == '(') {
                tokens.add(new Token(TokenType.OPEN_PAR, currentLine, currentColumn));
            } else if (currentCharacter == ')') {
                tokens.add(new Token(TokenType.CLOSE_PAR, currentLine, currentColumn));
            } else if (currentCharacter == '[') {
                tokens.add(new Token(TokenType.OPEN_SIZE_STRING, currentLine, currentColumn));
            } else if (currentCharacter == ']') {
                tokens.add(new Token(TokenType.CLOSE_SIZE_STRING, currentLine, currentColumn));
            } else if (currentCharacter == ':') {
                tokens.add(new Token(TokenType.DOUBLE_DOT, currentLine, currentColumn));
            } else if (currentCharacter == ';') {
                tokens.add(new Token(TokenType.SEMICOLON, currentLine, currentColumn));
            } else if (currentCharacter == '=') {
                ignoreNext = lookAheadEqual(currentLine, currentColumn, i);
            } else if (currentCharacter == '!') {
                ignoreNext = lookAheadExclamation(currentLine, currentColumn, i);
            } else if (currentCharacter == '>') {
                ignoreNext = lookAheadBigger(currentLine, currentColumn, i);
            } else if (currentCharacter == '<') {
                ignoreNext = lookAheadLess(currentLine, currentColumn, i);
            } else if (currentCharacter == '+') {
                ignoreNext = lookAheadPlus(currentLine, currentColumn, i);
            } else if (currentCharacter == '-') {
                ignoreNext = lookAheadMinus(currentLine, currentColumn, i);
            } else if (Character.isDigit(currentCharacter)) {
                ignoreNext = lookAheadDigit(currentLine, currentColumn, i);
            } else if (letterPattern.matcher(String.valueOf(currentCharacter)).matches()) {
                ignoreNext = lookAheadLetter(currentLine, currentColumn, i);
            } else if (currentCharacter == '\n') {
                currentLine++;
                currentColumn = 0;
            } else if (Character.isSpaceChar(currentCharacter) || currentCharacter == '\t') {
                // nothing
            } else {
                errors.add(new Error(currentLine, currentColumn, String.valueOf(currentCharacter)));
            }
            currentColumn++;
        }
    }

    private int lookAheadLetter(int line, int column, int initialTokenPos) {
        int i = initialTokenPos;
        StringBuilder elBuilder = new StringBuilder();
        do {
            char next = content.charAt(i);
            if (!letterPattern.matcher(String.valueOf(next)).matches() && !Character.isDigit(next) && next != '_') {
                i--;
                break;
            }
            elBuilder.append(next);
            i++;
        } while (true);
        insertIdOrReserved(elBuilder.toString(), line, column);
        return i - initialTokenPos;
    }

    private void insertIdOrReserved(String el, int line, int column) {
        switch (el) {
            case "IF":
                tokens.add(new Token(TokenType.IF, line, column));
                break;
            case "ELSE":
                tokens.add(new Token(TokenType.ELSE, line, column));
                break;
            case "DO":
                tokens.add(new Token(TokenType.DO, line, column));
                break;
            case "WHILE":
                tokens.add(new Token(TokenType.WHILE, line, column));
                break;
            case "SWITCH":
                tokens.add(new Token(TokenType.SWITCH, line, column));
                break;
            case "CASE":
                tokens.add(new Token(TokenType.CASE, line, column));
                break;
            case "VAR":
                tokens.add(new Token(TokenType.VAR, line, column));
                break;
            case "MORCELA":
                tokens.add(new Token(TokenType.MORCELA, line, column));
                break;
            case "BODY":
                tokens.add(new Token(TokenType.BODY, line, column));
                break;
            case "STOP":
                tokens.add(new Token(TokenType.STOP, line, column));
                break;
            case "PRINT":
                tokens.add(new Token(TokenType.PRINT, line, column));
                break;
            case "SCAN":
                tokens.add(new Token(TokenType.SCAN, line, column));
                break;
            case "DOUBLE":
                tokens.add(new Token(TokenType.DOUBLE, line, column));
                break;
            case "STRING":
                tokens.add(new Token(TokenType.STRING, line, column));
                break;
            case "BOOLEAN":
                tokens.add(new Token(TokenType.BOOLEAN, line, column));
                break;
            case "TRUE":
                tokens.add(new Token(TokenType.TRUE, line, column));
                break;
            case "FALSE":
                tokens.add(new Token(TokenType.FALSE, line, column));
                break;
            case "DFLT":
                tokens.add(new Token(TokenType.DFLT, line, column));
                break;
            default:
                tokens.add(new Token(TokenType.ID, line, column, el));
                break;
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
        tokens.add(new Token(TokenType.NUM, line, column, number.toString()));
        return i - initialTokenPos;
    }

    private int lookAheadQuote(int line, int column, int initialTokenPos) {
        StringBuilder stringContent = new StringBuilder();
        int i = initialTokenPos + 1;
        do {
            if (i == content.length()) {
                errors.add(new Error(line, column, String.valueOf(content.charAt(initialTokenPos))));
                return 0;
            }
            char next = content.charAt(i);
            if (next != '"') {
                stringContent.append(next);
            } else break;
            i++;
        } while (true);
        tokens.add(new Token(TokenType.STRING, line, column, stringContent.toString()));

        return i - initialTokenPos;
    }

    private int lookAheadSlash(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '/') {
            return addComment(line, column, initialTokenPos);
        }

        tokens.add(new Token(TokenType.DIV, line, column));
        return 0;
    }

    private int addComment(int line, int column, final int initialCommentPos) {
        StringBuilder commentContent;
        commentContent = new StringBuilder();
        int i = initialCommentPos + 2;
        do {
            if (i == content.length()) break;
            char next = content.charAt(i);
            if (next == '\n') {
                i--;
                break;
            }
            commentContent.append(next);
            i++;
        } while (true);
        // tokens.add(new Token(TokenType.COMMENT, line, column, commentContent.toString()));
        return i - initialCommentPos;
    }

    private int lookAheadPipe(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '|') {
            tokens.add(new Token(TokenType.OR, line, column));
            return 1;
        }

        errors.add(new Error(line, column, String.valueOf(content.charAt(initialTokenPos))));
        return 0;
    }

    private int lookAheadAnd(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '&') {
            tokens.add(new Token(TokenType.AND, line, column));
            return 1;
        }

        errors.add(new Error(line, column, String.valueOf(content.charAt(initialTokenPos))));
        return 0;
    }

    private int lookAheadEqual(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '=') {
            tokens.add(new Token(TokenType.EQ, line, column));
            return 1;
        }

        tokens.add(new Token(TokenType.ATT, line, column));
        return 0;
    }

    private int lookAheadExclamation(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '=') {
            tokens.add(new Token(TokenType.DIF, line, column));
            return 1;
        }

        tokens.add(new Token(TokenType.NOT, line, column));
        return 0;
    }

    private int lookAheadBigger(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '=') {
            tokens.add(new Token(TokenType.BIGGER_EQ, line, column));
            return 1;
        }

        tokens.add(new Token(TokenType.BIGGER, line, column));
        return 0;
    }

    private int lookAheadLess(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '=') {
            tokens.add(new Token(TokenType.LESS_EQ, line, column));
            return 1;
        }

        tokens.add(new Token(TokenType.LESS, line, column));
        return 0;
    }

    private int lookAheadPlus(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '+') {
            tokens.add(new Token(TokenType.INC, line, column));
            return 1;
        }

        tokens.add(new Token(TokenType.SUM, line, column));
        return 0;
    }

    private int lookAheadMinus(int line, int column, int initialTokenPos) {
        char next = content.charAt(initialTokenPos + 1);
        if (next == '-') {
            tokens.add(new Token(TokenType.DEC, line, column));
            return 1;
        }

        tokens.add(new Token(TokenType.SUB, line, column));
        return 0;
    }

    @Override
    public Error[] getErrors() {
        return errors.toArray(new Error[0]);
    }

    public Token[] getIdentifiedTokens() {
        return tokens.toArray(new Token[0]);
    }
}

