package morcela.analyzer;

import morcela.Token;

import java.util.Stack;

public class SyntaticAnalyzer {
    private Stack<Token> input;

    public SyntaticAnalyzer(Stack<Token> input) {
        this.input = input;
    }
}
