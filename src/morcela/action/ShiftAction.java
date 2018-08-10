package morcela.action;

import morcela.stackable.Stackable;
import morcela.stackable.State;
import morcela.stackable.Token;

import java.util.Stack;

public class ShiftAction implements Action {
    private State state;

    public ShiftAction(int state) {
        this.state = new State(state);
    }

    @Override
    public void apply(Stack<Stackable> stack, Stack<Token> input) {
        stack.push(input.pop());
        stack.push(state);
    }
}
