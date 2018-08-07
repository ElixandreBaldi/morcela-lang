package morcela;

import morcela.analyzer.LexicalAnalyzer;
import morcela.analyzer.SyntaticAnalyzer;
import morcela.error.Error;
import morcela.stackable.Stackable;
import morcela.stackable.Token;

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
        Stack<Stackable> stackContent = new Stack<>();
        for (Token token : tokens) {
            stackContent.push(token);
        }
        SyntaticAnalyzer syntaticAnalyzer = new SyntaticAnalyzer(stackContent);
        syntaticAnalyzer.run();
        errors.addAll(Arrays.asList(lexicalAnalyzer.getErrors()));
        errors.addAll(Arrays.asList(syntaticAnalyzer.getErrors()));
    }

    Error[] getErrors() {
        return errors.toArray(new Error[0]);
    }
}
