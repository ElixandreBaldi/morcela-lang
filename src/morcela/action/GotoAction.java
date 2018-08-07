package morcela.action;

import morcela.stackable.Stackable;
import morcela.stackable.State;

import java.util.Stack;

public class GotoAction implements Action {
    private State destiny;

    public GotoAction(State destiny) {
        this.destiny = destiny;
    }

    public GotoAction(int destiny) {
        this.destiny = new State(destiny);
    }

    @Override
    public void apply(Stack<Stackable> target) {
        //
    }
}
