package morcela.action;

import morcela.stackable.NonTerminal;
import morcela.stackable.Stackable;

import java.util.Stack;

public class ReduceAction implements Action {

    private NonTerminal nonTerminal;

    public ReduceAction(NonTerminal nonTerminal) {
        this.nonTerminal = nonTerminal;
    }

    @Override
    public void apply(Stack<Stackable> target) {
        //
    }
}
