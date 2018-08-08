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

    public static LRTable newInstance() {
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

        // State 11
        actions = new HashMap<>();
        actions.put(TokenType.BOOLEAN, new ShiftAction(16));
        actions.put(TokenType.DOUBLE, new ShiftAction(17));
        actions.put(TokenType.STRING, new ShiftAction(18));
        actions.put(NonTerminal.VAR_DECLARATION, new GotoAction(13));
        actions.put(NonTerminal.VAR_TYPE, new GotoAction(14));
        table.put(new State(11), actions);

        // State 12
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(19));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.OPERATOR, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put(new State(12), actions);

        // State 13
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(37));
        table.put(new State(13), actions);

        // State 14
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ShiftAction(38));
        table.put(new State(14), actions);

        // State 15
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(7));
        table.put(new State(15), actions);

        // State 16
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ReduceAction(8));
        table.put(new State(16), actions);

        // State 17
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ReduceAction(9));
        table.put(new State(17), actions);

        // State 18
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ReduceAction(10));
        table.put(new State(18), actions);

        // State 19
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(39));
        table.put(new State(19), actions);

        // State 20
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(40));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put(new State(20), actions);

        return table;
    }
}
