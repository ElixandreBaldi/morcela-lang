package morcela;

class Token {

    public enum TokenType {
        ID, MULT, COMMA, DIV, XOR, OR, NUM, OPEN_PAR, CLOSE_PAR, OPEN_SIZE_STRING, CLOSE_SIZE_STRING, DOUBLE_DOT, SEMICOLON, ATT, EQ, DIF, NOT, LESS_EQ, LESS, BIGGER_EQ, BIGGER, INC, SUM, DEC, SUB;
    }

    Token(TokenType type, String content) {

    }

    Token(TokenType type) {

    }

}
