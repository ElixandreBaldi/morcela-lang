package morcela.action;

import morcela.stackable.Stackable;
import morcela.stackable.State;

import java.util.Stack;

public class ShiftAction implements Action {
    private State state;

    public ShiftAction(int state) {
        this.state = new State(state);
    }

    public ShiftAction(State state) {
        this.state = state;
    }

    @Override
    public void apply(Stack<Stackable> target) {
        //
    }
}
