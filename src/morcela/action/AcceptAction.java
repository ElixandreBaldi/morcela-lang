package morcela.action;

import morcela.stackable.Stackable;
import morcela.stackable.Token;

import java.util.Stack;

public class AcceptAction implements Action {

    @Override
    public void apply(Stack<Stackable> stack, Stack<Token> input) {
        input.pop();
    }
}
