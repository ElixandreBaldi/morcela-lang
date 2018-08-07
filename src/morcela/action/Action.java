package morcela.action;

import morcela.stackable.Stackable;

import java.util.Stack;

public interface Action {
    void apply(Stack<Stackable> target);
}
