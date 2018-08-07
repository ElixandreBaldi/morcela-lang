package morcela;

import morcela.analyzer.LexicalAnalyzer;
import morcela.error.Error;

import java.util.*;

class Compiler {

    private String content;

    private ArrayList<Error> errors;

    Compiler(String content) {
        this.content = content;
        this.errors = new ArrayList<>();
    }

    void run() {
        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer(content);
        lexicalAnalyzer.run();
        List<Token> tokens = Arrays.asList(lexicalAnalyzer.getIdentifiedTokens());
        Collections.reverse(tokens);
        Stack<Token> stackContent = new Stack<>();
        for (Token token : tokens) {
            stackContent.push(token);
        }


        errors.addAll(Arrays.asList(lexicalAnalyzer.getErrors()));
    }

    Error[] getErrors() {
        return errors.toArray(new Error[0]);
    }
}
