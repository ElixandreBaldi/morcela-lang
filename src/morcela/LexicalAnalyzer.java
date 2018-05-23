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
            if(content.charAt(i) == '*') {
                tokens.add(new Token(Token.TokenType.MULT));
            }
        }
    }
}
