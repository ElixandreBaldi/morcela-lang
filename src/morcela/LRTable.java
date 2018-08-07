package morcela;

import morcela.action.*;
import morcela.stackable.NonTerminal;
import morcela.stackable.Operable;
import morcela.stackable.State;
import morcela.stackable.TokenType;

import java.util.HashMap;

public class LRTable extends HashMap<State, HashMap<Operable, Action>> {
    private LRTable() {
        // Empty private constructor.
    }

    public LRTable newInstance() {
        LRTable table = new LRTable();
        HashMap<Operable, Action> actions;

        // State 0
        actions = new HashMap<>();
        actions.put(TokenType.MORCELA, new ShiftAction(2));
        actions.put(NonTerminal.PROGRAM, new GotoAction(2));
        table.put(State.makeInitialState(), actions);

        // State 1
        actions = new HashMap<>();
        actions.put(TokenType.EOF, new AcceptAction());
        table.put(new State(1), actions);

        // State 2
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(3));
        table.put(new State(2), actions);

        // State 3
        actions = new HashMap<>();
        actions.put(TokenType.VAR, new ShiftAction(7));
        actions.put(TokenType.BODY, new ShiftAction(8));
        actions.put(NonTerminal.SECTION, new GotoAction(4));
        actions.put(NonTerminal.VAR_SECTION, new GotoAction(5));
        actions.put(NonTerminal.BODY_SECTION, new GotoAction(6));
        table.put(new State(3), actions);

        // State 4
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(9));
        table.put(new State(4), actions);

        // State 5
        actions = new HashMap<>();
        actions.put(TokenType.BODY, new ShiftAction(8));
        actions.put(NonTerminal.BODY_SECTION, new GotoAction(10));
        table.put(new State(5), actions);

        // State 6
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(3));
        table.put(new State(6), actions);

        // State 7
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(11));
        table.put(new State(7), actions);

        // State 8
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(12));
        table.put(new State(8), actions);

        // State 9
        actions = new HashMap<>();
        actions.put(TokenType.EOF, new ReduceAction(1));
        table.put(new State(9), actions);

        // State 10
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(2));
        table.put(new State(10), actions);

        return table;
    }
}
