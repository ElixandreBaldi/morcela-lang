package morcela;

import java.util.ArrayList;

class LexicalAnalyzer {
    private String content;

    private ArrayList<Token> tokens;


    LexicalAnalyzer(String content) {
        this.content = content;
        this.tokens = new ArrayList<>();
    }

    void run() {
        for(int i = 0; i < content.length(); i++) {
            char charCurrent = content.charAt(i);
            if(charCurrent == '*') {
                tokens.add(new Token(Token.TokenType.MULT));
            } else if(charCurrent == ',') {
                tokens.add(new Token(Token.TokenType.COMMA));
            } else if(charCurrent == '/') {

            } else if(charCurrent == '^') {
                tokens.add(new Token(Token.TokenType.XOR));
            } else if(charCurrent == '|') {

            } else if(charCurrent == '{') {
                tokens.add(new Token(Token.TokenType.OPEN_BRACES));
            } else if(charCurrent == '}') {
                tokens.add(new Token(Token.TokenType.CLOSE_BRACES));
            } else if(charCurrent == '"') {
                tokens.add(new Token(Token.TokenType.QUOTE));
            } else if(charCurrent == '(') {
                tokens.add(new Token(Token.TokenType.OPEN_PAR));
            } else if(charCurrent == ')') {
                tokens.add(new Token(Token.TokenType.CLOSE_PAR));
            } else if(charCurrent == '[') {
                tokens.add(new Token(Token.TokenType.OPEN_SIZE_STRING));
            } else if(charCurrent == ']') {
                tokens.add(new Token(Token.TokenType.CLOSE_SIZE_STRING));
            } else if(charCurrent == ':') {
                tokens.add(new Token(Token.TokenType.DOUBLE_DOT));
            } else if(charCurrent == ';') {
                tokens.add(new Token(Token.TokenType.SEMICOLON));
            } else if(charCurrent == '=') {
                //TODO
                //tokens.add(new Token(Token.TokenType.EQ));
            } else if(charCurrent == '!') {
                //TODO
            } else if(charCurrent == '>') {
                //TODO
            } else if(charCurrent == '<') {
                //TODO
            } else if(charCurrent == '+') {
                //TODO
            } else if(charCurrent == '-') {
                //TODO
            }
        }
    }
}
