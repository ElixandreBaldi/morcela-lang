package morcela.stackable;

public class State implements Stackable {
    private int id;

    public static State makeInitialState() {
        return new State(0);
    }

    public State(int id) {
        this.id = id;
    }
}
