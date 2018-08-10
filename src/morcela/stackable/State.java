package morcela.stackable;

public class State implements Stackable {
    private Integer id;

    public State(Integer id) {
        this.id = id;
    }

    public Integer id() {
        return id;
    }
}
