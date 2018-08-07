package morcela.analyzer;

import morcela.error.Error;
import morcela.stackable.Stackable;
import morcela.stackable.State;
import morcela.stackable.Token;

import java.util.ArrayList;
import java.util.Stack;

public class SyntaticAnalyzer implements Analyzer {

    private Stack<Stackable> input;

    private ArrayList<Error> errors;

    public SyntaticAnalyzer(Stack<Stackable> input) {
        this.input = input;
    }

    public void run() {
        while (!input.empty()) {
            Stackable top = input.pop();
            if (top instanceof Token) {

            } else if (top instanceof State) {

            }
        }
    }

    @Override
    public Error[] getErrors() {
        return errors.toArray(new Error[0]);
    }
}
