package morcela.analyzer;

import morcela.error.Error;
import morcela.stackable.Stackable;
import morcela.stackable.State;
import morcela.stackable.Token;

import java.util.ArrayList;
import java.util.Stack;

public class SyntaticAnalyzer implements Analyzer {

    private Stack<Token> input;

    private ArrayList<Error> errors;

    private Boolean accept = Boolean.FALSE;

    public SyntaticAnalyzer(Stack<Token> input) {
        this.input = input;
        this.errors = new ArrayList<>();
    }

    public void run() {
        Stack<Stackable> auxStack = new Stack<>();
        auxStack.push(State.makeInitialState());
        while (!input.empty()) {
            Stackable current = input.pop();
        }
    }

    @Override
    public Error[] getErrors() {
        return errors.toArray(new Error[0]);
    }
}
