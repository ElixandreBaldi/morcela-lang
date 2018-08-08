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

        // State 21
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(41));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put(new State(21), actions);

        // State 22
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(42));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put(new State(22), actions);

        // State 23
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(43));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put(new State(23), actions);

        // State 24
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(44));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put(new State(24), actions);

        // State 25
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(45));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put(new State(25), actions);

        // State 26
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(46));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put(new State(26), actions);

        // State 27
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(47));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put(new State(27), actions);

        // State 28
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(21));
        actions.put(TokenType.CASE, new ReduceAction(21));
        actions.put(TokenType.DFLT, new ReduceAction(21));
        table.put(new State(28), actions);

        // State 29
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(48));
        table.put(new State(29), actions);

        // State 30
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(50));
        actions.put(NonTerminal.CONDITION, new GotoAction(49));
        table.put(new State(30), actions);

        // State 31
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(50));
        actions.put(NonTerminal.CONDITION, new GotoAction(51));
        table.put(new State(31), actions);

        // State 32
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(52));
        table.put(new State(32), actions);

        // State 33
        actions = new HashMap<>();
        actions.put(TokenType.ATT, new ShiftAction(53));
        table.put(new State(33), actions);

        // State 34
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(54));
        table.put(new State(34), actions);

        // State 35
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(55));
        table.put(new State(35), actions);

        // State 36
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(56));
        table.put(new State(36), actions);

        // State 37
        actions = new HashMap<>();
        actions.put(TokenType.BODY, new ReduceAction(4));
        table.put(new State(37), actions);

        // State 38
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(57));
        table.put(new State(38), actions);

        // State 39
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(5));
        table.put(new State(39), actions);

        // State 40
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(13));
        actions.put(TokenType.CASE, new ReduceAction(13));
        actions.put(TokenType.DFLT, new ReduceAction(13));
        table.put(new State(40), actions);

        // State 41
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(14));
        actions.put(TokenType.CASE, new ReduceAction(14));
        actions.put(TokenType.DFLT, new ReduceAction(14));
        table.put(new State(41), actions);

        // State 42
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(15));
        actions.put(TokenType.CASE, new ReduceAction(15));
        actions.put(TokenType.DFLT, new ReduceAction(15));
        table.put(new State(42), actions);

        // State 43
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(16));
        actions.put(TokenType.CASE, new ReduceAction(16));
        actions.put(TokenType.DFLT, new ReduceAction(16));
        table.put(new State(43), actions);

        // State 44
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(17));
        actions.put(TokenType.CASE, new ReduceAction(17));
        actions.put(TokenType.DFLT, new ReduceAction(17));
        table.put(new State(44), actions);

        // State 45
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(18));
        actions.put(TokenType.CASE, new ReduceAction(18));
        actions.put(TokenType.DFLT, new ReduceAction(18));
        table.put(new State(45), actions);

        // State 46
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(19));
        actions.put(TokenType.CASE, new ReduceAction(19));
        actions.put(TokenType.DFLT, new ReduceAction(19));
        table.put(new State(46), actions);

        // State 47
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(20));
        actions.put(TokenType.CASE, new ReduceAction(20));
        actions.put(TokenType.DFLT, new ReduceAction(20));
        table.put(new State(47), actions);

        // State 48
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(58));
        table.put(new State(48), actions);

        // State 49
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(59));
        table.put(new State(49), actions);

        // State 50
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(63));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new GotoAction(64));
        actions.put(NonTerminal.OPERATOR_BOOLEAN, new GotoAction(60));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(62));
        actions.put(NonTerminal.RELATIONAL_STATEMENT, new GotoAction(61));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(66));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put(new State(50), actions);

        // State 51
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(69));
        table.put(new State(51), actions);

        // State 52
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(70));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put(new State(52), actions);

        // State 53
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(63));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new ShiftAction(71));
        actions.put(NonTerminal.OPERATOR_BOOLEAN, new GotoAction(72));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(62));
        actions.put(NonTerminal.RELATIONAL_STATEMENT, new GotoAction(61));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(66));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put(new State(53), actions);

        // State 54
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ReduceAction(23));
        actions.put(TokenType.WHILE, new ReduceAction(23));
        actions.put(TokenType.STOP, new ReduceAction(23));
        actions.put(TokenType.DO, new ReduceAction(23));
        actions.put(TokenType.IF, new ReduceAction(23));
        actions.put(TokenType.SWITCH, new ReduceAction(23));
        actions.put(TokenType.PRINT, new ReduceAction(23));
        actions.put(TokenType.SCAN, new ReduceAction(23));
        table.put(new State(54), actions);

        // State 55
        actions = new HashMap<>();
        actions.put(TokenType.STRING_VALUE, new ReduceAction(73));
        table.put(new State(55), actions);

        // State 56
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(74));
        table.put(new State(56), actions);

        // State 57
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_SIZE_STRING, new ShiftAction(76));
        actions.put(NonTerminal.SIZE_DECLARATION, new GotoAction(75));
        table.put(new State(57), actions);

        return table;
    }
}
