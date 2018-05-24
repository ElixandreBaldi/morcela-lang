package morcela;

class Token {
    private TokenType type;

    private String content;

    private int line;

    private int column;

    public enum TokenType {
        ID, MULT, COMMA, DIV, XOR, OR, NUM, OPEN_PAR, CLOSE_PAR, OPEN_SIZE_STRING, CLOSE_SIZE_STRING, DOUBLE_DOT, SEMICOLON, ATT, EQ, DIF, NOT, LESS_EQ, LESS, BIGGER_EQ, BIGGER, INC, SUM, DEC, SUB, OPEN_BRACES, CLOSE_BRACES, IF, ELSE, DO, WHILE, SWITCH, CASE, VAR, MORCELA, BODY, STOP, PRINT, SCAN, STRING, DOUBLE, BOOLEAN, TRUE, FALSE, COMMENT;
    }

    Token(TokenType type, int line, int column, String content) {
        this.type = type;
        this.content = content;
        this.line = line;
        this.column = column;
    }

    Token(TokenType type, int line, int column) {
        this.type = type;
        this.content = type.toString();
        this.line = line;
        this.column = column;
    }

    @Override
    public String toString() {
        return "<" + type + ", " + content + "," + line + "," + column + ">";
    }
}
