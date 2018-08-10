package morcela.lr;

import morcela.stackable.NonTerminal;

public class Production {

    private Integer size;

    private NonTerminal reductor;

    Production(Integer size, NonTerminal reductor) {
        this.size = size;
        this.reductor = reductor;
    }

    public Integer getSize() {
        return size;
    }

    public NonTerminal getReductor() {
        return reductor;
    }
}
