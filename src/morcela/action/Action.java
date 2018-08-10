package morcela.action;

import morcela.stackable.Stackable;
import morcela.stackable.Token;

import java.util.Stack;

public interface Action {
    void apply(Stack<Stackable> stack, Stack<Token> input);
}
