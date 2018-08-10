package morcela.action;

import morcela.stackable.Production;
import morcela.stackable.Stackable;
import morcela.stackable.Token;

import java.util.Stack;

public class ReduceAction implements Action {

    private Production production;

    public ReduceAction(Production production) {
        this.production = production;
    }

    public ReduceAction(int production) {
        this.production = new Production(production);
    }

    @Override
    public void apply(Stack<Stackable> stack, Stack<Token> input) {

    }
}
