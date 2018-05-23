package morcela;

class Token {
    private TokenType type;
    private String content;

    public enum TokenType {
        ID, MULT, COMMA, DIV, XOR, OR, NUM, OPEN_PAR, CLOSE_PAR, OPEN_SIZE_STRING, CLOSE_SIZE_STRING, DOUBLE_DOT, SEMICOLON, ATT, EQ, DIF, NOT, LESS_EQ, LESS, BIGGER_EQ, BIGGER, INC, SUM, DEC, SUB, OPEN_BRACES, CLOSE_BRACES, IF, ELSE, DO, WHILE, SWITCH, CASE, VAR, MORCELA, BODY, STOP, PRINT, SCAN, STRING, DOUBLE, BOOLEAN, TRUE, FALSE, COMMENT;
    }

    Token(TokenType type, String content) {
        this.type = type;
        this.content = content;
    }

    Token(TokenType type) {
        this.type = type;
        this.content = type.toString();
    }

    @Override
    public String toString() {
        return "<"+type+", "+content+">";
    }
}
