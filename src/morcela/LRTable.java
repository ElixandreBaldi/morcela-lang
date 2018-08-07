package morcela;

import morcela.action.Action;
import morcela.action.GotoAction;
import morcela.action.ShiftAction;
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

        // State 0
        HashMap<Operable, Action> actions = new HashMap<>();
        actions.put(TokenType.MORCELA, new ShiftAction(2));
        actions.put(NonTerminal.PROGRAM, new GotoAction(2));
        table.put(State.makeInitialState(), actions);


        return table;
    }
}
