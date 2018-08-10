package morcela.analyzer;

import morcela.action.Action;
import morcela.error.Error;
import morcela.lr.LRTable;
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
        Boolean noErrors = Boolean.TRUE;
        Stack<Stackable> auxStack = new Stack<>();
        auxStack.push(new State(0));
        LRTable table = LRTable.getInstance();
        while (!input.empty()) {
            Token currentInput = input.peek();
            State nextState = (State) auxStack.peek();
            Action action = table.get(nextState.id()).get(currentInput.getType());
            if (action != null) {
                action.apply(auxStack, input);
            } else {
                // error!
                noErrors = Boolean.FALSE;
            }
        }
        accept = noErrors;
    }

    public boolean accepted() {
        return accept;
    }

    @Override
    public Error[] getErrors() {
        return errors.toArray(new Error[0]);
    }
}
