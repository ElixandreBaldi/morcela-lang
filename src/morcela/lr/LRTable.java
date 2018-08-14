package morcela.lr;

import morcela.action.*;
import morcela.stackable.NonTerminal;
import morcela.stackable.Operable;
import morcela.stackable.TokenType;

import java.util.HashMap;

public class LRTable extends HashMap<Integer, HashMap<Operable, Action>> {

    private static LRTable instance = null;

    private LRTable() {
        // Empty private constructor.
    }

    public static LRTable getInstance() {
        if (instance != null) {
            return instance;
        }

        LRTable table = new LRTable();
        HashMap<Operable, Action> actions;

        // State 0
        actions = new HashMap<>();
        actions.put(TokenType.MORCELA, new ShiftAction(2));
        actions.put(NonTerminal.PROGRAM, new GotoAction(1));
        table.put(0, actions);

        // State 1
        actions = new HashMap<>();
        actions.put(TokenType.EOF, new AcceptAction());
        table.put((1), actions);

        // State 2
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(3));
        table.put((2), actions);

        // State 3
        actions = new HashMap<>();
        actions.put(TokenType.VAR, new ShiftAction(7));
        actions.put(TokenType.BODY, new ShiftAction(8));
        actions.put(NonTerminal.SECTION, new GotoAction(4));
        actions.put(NonTerminal.VAR_SECTION, new GotoAction(5));
        actions.put(NonTerminal.BODY_SECTION, new GotoAction(6));
        table.put((3), actions);

        // State 4
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(9));
        table.put((4), actions);

        // State 5
        actions = new HashMap<>();
        actions.put(TokenType.BODY, new ShiftAction(8));
        actions.put(NonTerminal.BODY_SECTION, new GotoAction(10));
        table.put((5), actions);

        // State 6
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(3));
        table.put((6), actions);

        // State 7
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(11));
        table.put((7), actions);

        // State 8
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(12));
        table.put((8), actions);

        // State 9
        actions = new HashMap<>();
        actions.put(TokenType.EOF, new ReduceAction(1));
        table.put((9), actions);

        // State 10
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(2));
        table.put((10), actions);

        // State 11
        actions = new HashMap<>();
        actions.put(TokenType.BOOLEAN, new ShiftAction(16));
        actions.put(TokenType.DOUBLE, new ShiftAction(17));
        actions.put(TokenType.STRING, new ShiftAction(18));
        actions.put(NonTerminal.VAR_DECLARATION, new GotoAction(13));
        actions.put(NonTerminal.VAR_TYPE, new GotoAction(14));
        table.put((11), actions);

        // State 12
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftSpecialAction(28));
        actions.put(TokenType.ID, new ShiftAction(33));        
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
        table.put((12), actions);

        // State 13
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(37));
        table.put((13), actions);

        // State 14
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ShiftAction(38));
        table.put((14), actions);

        // State 15
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(7));
        table.put((15), actions);

        // State 16
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ReduceAction(8));
        table.put((16), actions);

        // State 17
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ReduceAction(9));
        table.put((17), actions);

        // State 18
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ReduceAction(10));
        table.put((18), actions);

        // State 19
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(39));
        table.put((19), actions);

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
        table.put((20), actions);

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
        table.put((21), actions);

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
        table.put((22), actions);

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
        table.put((23), actions);

        // State 24
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftSpecialAction(28));
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
        table.put((24), actions);

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
        table.put((25), actions);

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
        table.put((26), actions);

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
        table.put((27), actions);

        // State 28
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(21));
        actions.put(TokenType.CASE, new ReduceAction(21));
        actions.put(TokenType.DFLT, new ReduceAction(21));
        table.put((28), actions);

        // State 29
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(48));
        table.put((29), actions);

        // State 30
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(50));
        actions.put(NonTerminal.CONDITION, new GotoAction(49));
        table.put((30), actions);

        // State 31
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(50));
        actions.put(NonTerminal.CONDITION, new GotoAction(51));
        table.put((31), actions);

        // State 32
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(52));
        table.put((32), actions);

        // State 33
        actions = new HashMap<>();
        actions.put(TokenType.ATT, new ShiftAction(53));
        table.put((33), actions);

        // State 34
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(54));
        table.put((34), actions);

        // State 35
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(55));
        table.put((35), actions);

        // State 36
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(56));
        table.put((36), actions);

        // State 37
        actions = new HashMap<>();
        actions.put(TokenType.BODY, new ReduceAction(4));
        table.put((37), actions);

        // State 38
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(57));
        table.put((38), actions);

        // State 39
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(5));
        table.put((39), actions);

        // State 40
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(13));
        actions.put(TokenType.CASE, new ReduceAction(13));
        actions.put(TokenType.DFLT, new ReduceAction(13));
        table.put((40), actions);

        // State 41
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(14));
        actions.put(TokenType.CASE, new ReduceAction(14));
        actions.put(TokenType.DFLT, new ReduceAction(14));
        table.put((41), actions);

        // State 42
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(15));
        actions.put(TokenType.CASE, new ReduceAction(15));
        actions.put(TokenType.DFLT, new ReduceAction(15));
        table.put((42), actions);

        // State 43
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(16));
        actions.put(TokenType.CASE, new ReduceAction(16));
        actions.put(TokenType.DFLT, new ReduceAction(16));
        table.put((43), actions);

        // State 44
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(17));
        actions.put(TokenType.CASE, new ReduceAction(17));
        actions.put(TokenType.DFLT, new ReduceAction(17));
        table.put((44), actions);

        // State 45
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(18));
        actions.put(TokenType.CASE, new ReduceAction(18));
        actions.put(TokenType.DFLT, new ReduceAction(18));
        table.put((45), actions);

        // State 46
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(19));
        actions.put(TokenType.CASE, new ReduceAction(19));
        actions.put(TokenType.DFLT, new ReduceAction(19));
        table.put((46), actions);

        // State 47
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(20));
        actions.put(TokenType.CASE, new ReduceAction(20));
        actions.put(TokenType.DFLT, new ReduceAction(20));
        table.put((47), actions);

        // State 48
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(58));
        table.put((48), actions);

        // State 49
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(59));
        table.put((49), actions);

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
        table.put((50), actions);

        // State 51
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(69));
        table.put((51), actions);

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
        table.put((52), actions);

        // State 53
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(63));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new GotoAction(71));
        actions.put(NonTerminal.OPERATOR_BOOLEAN, new GotoAction(72));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(62));
        actions.put(NonTerminal.RELATIONAL_STATEMENT, new GotoAction(61));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(66));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((53), actions);

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
        table.put((54), actions);

        // State 55
        actions = new HashMap<>();
        actions.put(TokenType.STRING_VALUE, new ReduceAction(73));
        table.put((55), actions);

        // State 56
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(74));
        table.put((56), actions);

        // State 57
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftSpecialAction((77)));
        actions.put(TokenType.OPEN_SIZE_STRING, new ShiftAction(76));
        actions.put(NonTerminal.SIZE_DECLARATION, new GotoAction(75));
        table.put((57), actions);

        // State 58
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(78));
        table.put((58), actions);

        // State 59
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(79));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put((59), actions);

        // State 60
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(80));
        actions.put(TokenType.AND, new ShiftAction(82));
        actions.put(TokenType.OR, new ShiftAction(83));
        actions.put(TokenType.XOR, new ShiftAction(84));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new ShiftAction(81));
        table.put((60), actions);

        // State 61
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(41));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(41));
        actions.put(TokenType.AND, new ReduceAction(41));
        actions.put(TokenType.OR, new ReduceAction(41));
        actions.put(TokenType.XOR, new ReduceAction(41));
        actions.put(TokenType.EQ, new ReduceAction(41));
        actions.put(TokenType.BIGGER, new ReduceAction(41));
        actions.put(TokenType.LESS, new ReduceAction(41));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(41));
        actions.put(TokenType.LESS_EQ, new ReduceAction(41));
        actions.put(TokenType.DIF, new ReduceAction(41));
        table.put((61), actions);

        // State 62
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(42));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(42));
        actions.put(TokenType.AND, new ReduceAction(42));
        actions.put(TokenType.OR, new ReduceAction(42));
        actions.put(TokenType.XOR, new ReduceAction(42));
        actions.put(TokenType.EQ, new ReduceAction(42));
        actions.put(TokenType.BIGGER, new ReduceAction(42));
        actions.put(TokenType.LESS, new ReduceAction(42));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(42));
        actions.put(TokenType.LESS_EQ, new ReduceAction(42));
        actions.put(TokenType.DIF, new ReduceAction(42));
        table.put((62), actions);

        // State 63
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(43));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(43));
        actions.put(TokenType.AND, new ReduceAction(43));
        actions.put(TokenType.OR, new ReduceAction(43));
        actions.put(TokenType.XOR, new ReduceAction(43));
        actions.put(TokenType.EQ, new ReduceAction(43));
        actions.put(TokenType.BIGGER, new ReduceAction(43));
        actions.put(TokenType.LESS, new ReduceAction(43));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(43));
        actions.put(TokenType.LESS_EQ, new ReduceAction(43));
        actions.put(TokenType.DIF, new ReduceAction(43));
        actions.put(TokenType.SUM, new ReduceAction(57));
        actions.put(TokenType.SUB, new ReduceAction(57));
        actions.put(TokenType.MULT, new ReduceAction(57));
        actions.put(TokenType.DIV, new ReduceAction(57));
        table.put((63), actions);

        // State 64
        actions = new HashMap<>();
        actions.put(TokenType.EQ, new ShiftAction(86));
        actions.put(TokenType.BIGGER, new ShiftAction(87));
        actions.put(TokenType.LESS, new ShiftAction(88));
        actions.put(TokenType.BIGGER_EQ, new ShiftAction(89));
        actions.put(TokenType.LESS_EQ, new ShiftAction(90));
        actions.put(TokenType.DIF, new ShiftAction(91));
        actions.put(NonTerminal.RELATIONAL_STATEMENT_LINE, new GotoAction(85));
        table.put((64), actions);

        // State 65
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(63));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new GotoAction(64));
        actions.put(NonTerminal.OPERATOR_BOOLEAN, new GotoAction(92));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(62));
        actions.put(NonTerminal.RELATIONAL_STATEMENT, new GotoAction(61));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(66));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((65), actions);

        // State 66
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(39));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(39));
        actions.put(TokenType.AND, new ReduceAction(39));
        actions.put(TokenType.OR, new ReduceAction(39));
        actions.put(TokenType.XOR, new ReduceAction(39));
        actions.put(TokenType.EQ, new ReduceAction(39));
        actions.put(TokenType.BIGGER, new ReduceAction(39));
        actions.put(TokenType.LESS, new ReduceAction(39));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(39));
        actions.put(TokenType.LESS_EQ, new ReduceAction(39));
        actions.put(TokenType.DIF, new ReduceAction(39));
        actions.put(TokenType.SUM, new ShiftAction(94));
        actions.put(TokenType.SUB, new ShiftAction(95));
        actions.put(TokenType.MULT, new ShiftAction(96));
        actions.put(TokenType.DIV, new ShiftAction(97));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(93));
        table.put((66), actions);

        // State 67
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(56));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(56));
        actions.put(TokenType.AND, new ReduceAction(56));
        actions.put(TokenType.OR, new ReduceAction(56));
        actions.put(TokenType.XOR, new ReduceAction(56));
        actions.put(TokenType.EQ, new ReduceAction(56));
        actions.put(TokenType.BIGGER, new ReduceAction(56));
        actions.put(TokenType.LESS, new ReduceAction(56));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(56));
        actions.put(TokenType.LESS_EQ, new ReduceAction(56));
        actions.put(TokenType.DIF, new ReduceAction(56));
        actions.put(TokenType.SUM, new ReduceAction(56));
        actions.put(TokenType.SUB, new ReduceAction(56));
        actions.put(TokenType.MULT, new ReduceAction(56));
        actions.put(TokenType.DIV, new ReduceAction(56));
        table.put((67), actions);

        // State 68
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(58));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(58));
        actions.put(TokenType.AND, new ReduceAction(58));
        actions.put(TokenType.OR, new ReduceAction(58));
        actions.put(TokenType.XOR, new ReduceAction(58));
        actions.put(TokenType.EQ, new ReduceAction(58));
        actions.put(TokenType.BIGGER, new ReduceAction(58));
        actions.put(TokenType.LESS, new ReduceAction(58));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(58));
        actions.put(TokenType.LESS_EQ, new ReduceAction(58));
        actions.put(TokenType.DIF, new ReduceAction(58));
        actions.put(TokenType.SUM, new ReduceAction(58));
        actions.put(TokenType.SUB, new ReduceAction(58));
        actions.put(TokenType.MULT, new ReduceAction(58));
        actions.put(TokenType.DIV, new ReduceAction(58));
        table.put((68), actions);

        // State 69
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(98));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put((69), actions);

        //State 70
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(99));
        table.put((70), actions);

        //State 71
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(100));
        actions.put(TokenType.EQ, new ShiftAction(86));
        actions.put(TokenType.BIGGER, new ShiftAction(87));
        actions.put(TokenType.LESS, new ShiftAction(88));
        actions.put(TokenType.BIGGER_EQ, new ShiftAction(89));
        actions.put(TokenType.LESS_EQ, new ShiftAction(90));
        actions.put(TokenType.DIF, new ShiftAction(91));
        actions.put(NonTerminal.RELATIONAL_STATEMENT_LINE, new GotoAction(85));
        table.put((71), actions);

        //State 72
        actions.put(TokenType.AND, new ShiftAction(82));
        actions.put(TokenType.OR, new ShiftAction(83));
        actions.put(TokenType.XOR, new ShiftAction(84));
        actions.put(NonTerminal.LOGICAL_STATEMENT_LINE, new GotoAction(81));
        table.put((72), actions);

        //State 73
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(101));
        table.put((73), actions);

        //State 74
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(102));
        table.put((74), actions);

        //State 75
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(103));
        table.put((75), actions);

        //State 76
        actions = new HashMap<>();
        actions.put(TokenType.NUM, new ShiftAction(104));
        table.put((76), actions);

        //State 77
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(12));
        table.put((77), actions);

        //State 78
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(105));
        table.put((78), actions);

        //State 79
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(106));
        table.put((79), actions);

        //State 80
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ReduceAction(24));
        actions.put(TokenType.SEMICOLON, new ReduceAction(24));
        table.put((80), actions);

        //State 81
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(44));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(44));
        actions.put(TokenType.AND, new ReduceAction(44));
        actions.put(TokenType.OR, new ReduceAction(44));
        actions.put(TokenType.XOR, new ReduceAction(44));
        actions.put(TokenType.EQ, new ReduceAction(44));
        actions.put(TokenType.BIGGER, new ReduceAction(44));
        actions.put(TokenType.LESS, new ReduceAction(44));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(44));
        actions.put(TokenType.LESS_EQ, new ReduceAction(44));
        actions.put(TokenType.DIF, new ReduceAction(44));
        table.put((81), actions);

        //State 82
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(63));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new GotoAction(64));
        actions.put(NonTerminal.OPERATOR_BOOLEAN, new GotoAction(107));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(62));
        actions.put(NonTerminal.RELATIONAL_STATEMENT, new GotoAction(61));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(66));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((82), actions);

        //State 83
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(63));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new GotoAction(64));
        actions.put(NonTerminal.OPERATOR_BOOLEAN, new GotoAction(108));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(62));
        actions.put(NonTerminal.RELATIONAL_STATEMENT, new GotoAction(61));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(66));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((83), actions);

        //State 84
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(63));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new GotoAction(64));
        actions.put(NonTerminal.OPERATOR_BOOLEAN, new GotoAction(109));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(62));
        actions.put(NonTerminal.RELATIONAL_STATEMENT, new GotoAction(61));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(66));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((84), actions);

        //State 85
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(49));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(49));
        actions.put(TokenType.AND, new ReduceAction(49));
        actions.put(TokenType.OR, new ReduceAction(49));
        actions.put(TokenType.XOR, new ReduceAction(49));
        actions.put(TokenType.EQ, new ReduceAction(49));
        actions.put(TokenType.BIGGER, new ReduceAction(49));
        actions.put(TokenType.LESS, new ReduceAction(49));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(49));
        actions.put(TokenType.LESS_EQ, new ReduceAction(49));
        actions.put(TokenType.DIF, new ReduceAction(49));
        table.put((85), actions);

        //State 86
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(63));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new GotoAction(110));
        actions.put(NonTerminal.OPERATOR_BOOLEAN, new GotoAction(72));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(62));
        actions.put(NonTerminal.RELATIONAL_STATEMENT, new GotoAction(61));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(66));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((86), actions);

        //State 87
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(63));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new GotoAction(111));
        actions.put(NonTerminal.OPERATOR_BOOLEAN, new GotoAction(72));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(62));
        actions.put(NonTerminal.RELATIONAL_STATEMENT, new GotoAction(61));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(66));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((87), actions);

        //State 88
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(63));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new GotoAction(112));
        actions.put(NonTerminal.OPERATOR_BOOLEAN, new GotoAction(72));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(62));
        actions.put(NonTerminal.RELATIONAL_STATEMENT, new GotoAction(61));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(66));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((88), actions);

        //State 89
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(63));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new GotoAction(113));
        actions.put(NonTerminal.OPERATOR_BOOLEAN, new GotoAction(72));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(62));
        actions.put(NonTerminal.RELATIONAL_STATEMENT, new GotoAction(61));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(66));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((89), actions);

        //State 90
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(63));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new GotoAction(114));
        actions.put(NonTerminal.OPERATOR_BOOLEAN, new GotoAction(72));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(62));
        actions.put(NonTerminal.RELATIONAL_STATEMENT, new GotoAction(61));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(66));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((90), actions);

        //State 91
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(63));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new GotoAction(115));
        actions.put(NonTerminal.OPERATOR_BOOLEAN, new GotoAction(72));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(62));
        actions.put(NonTerminal.RELATIONAL_STATEMENT, new GotoAction(61));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(66));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((91), actions);

        //State 92
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(45));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(45));
        actions.put(TokenType.AND, new ShiftAction(82));
        actions.put(TokenType.OR, new ShiftAction(83));
        actions.put(TokenType.XOR, new ShiftAction(84));
        actions.put(TokenType.EQ, new ShiftAction(45));
        actions.put(TokenType.BIGGER, new ShiftAction(45));
        actions.put(TokenType.LESS, new ShiftAction(45));
        actions.put(TokenType.BIGGER_EQ, new ShiftAction(45));
        actions.put(TokenType.LESS_EQ, new ShiftAction(45));
        actions.put(TokenType.DIF, new ShiftAction(45));
        actions.put(NonTerminal.LOGICAL_STATEMENT_LINE, new GotoAction(81));
        table.put((92), actions);

        //State 93
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(49));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(59));
        actions.put(TokenType.AND, new ReduceAction(59));
        actions.put(TokenType.OR, new ReduceAction(59));
        actions.put(TokenType.XOR, new ReduceAction(59));
        actions.put(TokenType.EQ, new ReduceAction(59));
        actions.put(TokenType.BIGGER, new ReduceAction(59));
        actions.put(TokenType.LESS, new ReduceAction(59));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(59));
        actions.put(TokenType.LESS_EQ, new ReduceAction(59));
        actions.put(TokenType.DIF, new ReduceAction(59));
        actions.put(TokenType.SUM, new ReduceAction(59));
        actions.put(TokenType.SUB, new ReduceAction(59));
        actions.put(TokenType.MULT, new ReduceAction(59));
        actions.put(TokenType.DIV, new ReduceAction(59));
        table.put((93), actions);

        //State 94
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(117));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(116));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((94), actions);

        //State 95
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(117));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(118));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((95), actions);

        //State 96
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(117));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(119));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((96), actions);

        //State 97
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(117));
        actions.put(TokenType.NUM, new ShiftAction(68));
        actions.put(NonTerminal.OPERATOR_ARITHMETIC, new GotoAction(120));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(67));
        table.put((97), actions);

        //State 98
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(121));
        table.put((98), actions);

        //State 99
        actions = new HashMap<>();
        actions.put(TokenType.WHILE, new ShiftAction(122));
        table.put((99), actions);

        //State 100
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(65));
        actions.put(TokenType.ID, new ReduceAction(65));
        actions.put(TokenType.WHILE, new ReduceAction(65));
        actions.put(TokenType.STOP, new ReduceAction(65));
        actions.put(TokenType.DO, new ReduceAction(65));
        actions.put(TokenType.IF, new ReduceAction(65));
        actions.put(TokenType.SWITCH, new ReduceAction(65));
        actions.put(TokenType.PRINT, new ReduceAction(65));
        actions.put(TokenType.SCAN, new ReduceAction(65));
        table.put((100), actions);

        //State 101
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ReduceAction(35));
        actions.put(TokenType.WHILE, new ReduceAction(35));
        actions.put(TokenType.STOP, new ReduceAction(35));
        actions.put(TokenType.DO, new ReduceAction(35));
        actions.put(TokenType.IF, new ReduceAction(35));
        actions.put(TokenType.SWITCH, new ReduceAction(35));
        actions.put(TokenType.PRINT, new ReduceAction(35));
        actions.put(TokenType.SCAN, new ReduceAction(35));
        table.put((101), actions);

        //State 102
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ReduceAction(36));
        actions.put(TokenType.WHILE, new ReduceAction(36));
        actions.put(TokenType.STOP, new ReduceAction(36));
        actions.put(TokenType.DO, new ReduceAction(36));
        actions.put(TokenType.IF, new ReduceAction(36));
        actions.put(TokenType.SWITCH, new ReduceAction(36));
        actions.put(TokenType.PRINT, new ReduceAction(36));
        actions.put(TokenType.SCAN, new ReduceAction(36));
        table.put((102), actions);

        //State 103
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftSpecialAction(15));
        actions.put(TokenType.BOOLEAN, new ShiftAction(16));
        actions.put(TokenType.DOUBLE, new ShiftAction(17));
        actions.put(TokenType.STRING, new ShiftAction(18));
        actions.put(NonTerminal.VAR_DECLARATION, new GotoAction(123));
        actions.put(NonTerminal.VAR_TYPE, new GotoAction(14));
        table.put((103), actions);

        //State 104
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_SIZE_STRING, new ShiftAction(124));
        table.put((104), actions);

        //State 105
        actions = new HashMap<>();
        actions.put(TokenType.CASE, new ShiftAction(126));
        actions.put(TokenType.DFLT, new ShiftAction(127));
        actions.put(NonTerminal.CASE_STATEMENT, new GotoAction(125));
        table.put((105), actions);

        //State 106
        actions = new HashMap<>();
        actions.put(TokenType.ELSE, new ShiftAction(130));
        actions.put(NonTerminal.ELSE_IF_STATEMENT, new ShiftAction(129));
        table.put((106), actions);

        //State 107
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(46));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(46));
        actions.put(TokenType.AND, new ShiftAction(82));
        actions.put(TokenType.OR, new ShiftAction(83));
        actions.put(TokenType.XOR, new ShiftAction(84));
        actions.put(TokenType.EQ, new ReduceAction(46));
        actions.put(TokenType.BIGGER, new ReduceAction(46));
        actions.put(TokenType.LESS, new ReduceAction(46));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(46));
        actions.put(TokenType.LESS_EQ, new ReduceAction(46));
        actions.put(TokenType.DIF, new ReduceAction(46));
        actions.put(NonTerminal.LOGICAL_STATEMENT_LINE, new GotoAction(81));
        table.put((107), actions);

        //State 108
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(47));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(47));
        actions.put(TokenType.AND, new ShiftAction(82));
        actions.put(TokenType.OR, new ShiftAction(83));
        actions.put(TokenType.XOR, new ShiftAction(84));
        actions.put(TokenType.EQ, new ReduceAction(47));
        actions.put(TokenType.BIGGER, new ReduceAction(47));
        actions.put(TokenType.LESS, new ReduceAction(47));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(47));
        actions.put(TokenType.LESS_EQ, new ReduceAction(47));
        actions.put(TokenType.DIF, new ReduceAction(47));
        actions.put(NonTerminal.LOGICAL_STATEMENT_LINE, new GotoAction(81));
        table.put((108), actions);

        //State 109
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(48));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(48));
        actions.put(TokenType.AND, new ShiftAction(82));
        actions.put(TokenType.OR, new ShiftAction(83));
        actions.put(TokenType.XOR, new ShiftAction(84));
        actions.put(TokenType.EQ, new ReduceAction(48));
        actions.put(TokenType.BIGGER, new ReduceAction(48));
        actions.put(TokenType.LESS, new ReduceAction(48));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(48));
        actions.put(TokenType.LESS_EQ, new ReduceAction(48));
        actions.put(TokenType.DIF, new ReduceAction(48));
        actions.put(NonTerminal.LOGICAL_STATEMENT_LINE, new GotoAction(81));
        table.put((109), actions);

        //State 110
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(50));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(50));
        actions.put(TokenType.AND, new ReduceAction(50));
        actions.put(TokenType.OR, new ReduceAction(50));
        actions.put(TokenType.XOR, new ReduceAction(50));
        actions.put(TokenType.EQ, new ShiftAction(86));
        actions.put(TokenType.BIGGER, new ShiftAction(87));
        actions.put(TokenType.LESS, new ShiftAction(88));
        actions.put(TokenType.BIGGER_EQ, new ShiftAction(89));
        actions.put(TokenType.LESS_EQ, new ShiftAction(90));
        actions.put(TokenType.DIF, new ShiftAction(91));
        actions.put(NonTerminal.RELATIONAL_STATEMENT_LINE, new GotoAction(85));
        table.put((110), actions);

        //State 111
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(51));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(51));
        actions.put(TokenType.AND, new ReduceAction(51));
        actions.put(TokenType.OR, new ReduceAction(51));
        actions.put(TokenType.XOR, new ReduceAction(51));
        actions.put(TokenType.EQ, new ShiftAction(86));
        actions.put(TokenType.BIGGER, new ShiftAction(87));
        actions.put(TokenType.LESS, new ShiftAction(88));
        actions.put(TokenType.BIGGER_EQ, new ShiftAction(89));
        actions.put(TokenType.LESS_EQ, new ShiftAction(90));
        actions.put(TokenType.DIF, new ShiftAction(91));
        actions.put(NonTerminal.RELATIONAL_STATEMENT_LINE, new GotoAction(85));
        table.put((111), actions);

        //State 112
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(52));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(52));
        actions.put(TokenType.AND, new ReduceAction(52));
        actions.put(TokenType.OR, new ReduceAction(52));
        actions.put(TokenType.XOR, new ReduceAction(52));
        actions.put(TokenType.EQ, new ShiftAction(86));
        actions.put(TokenType.BIGGER, new ShiftAction(87));
        actions.put(TokenType.LESS, new ShiftAction(88));
        actions.put(TokenType.BIGGER_EQ, new ShiftAction(89));
        actions.put(TokenType.LESS_EQ, new ShiftAction(90));
        actions.put(TokenType.DIF, new ShiftAction(91));
        actions.put(NonTerminal.RELATIONAL_STATEMENT_LINE, new GotoAction(85));
        table.put((112), actions);

        //State 113
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(53));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(53));
        actions.put(TokenType.AND, new ReduceAction(53));
        actions.put(TokenType.OR, new ReduceAction(53));
        actions.put(TokenType.XOR, new ReduceAction(53));
        actions.put(TokenType.EQ, new ShiftAction(86));
        actions.put(TokenType.BIGGER, new ShiftAction(87));
        actions.put(TokenType.LESS, new ShiftAction(88));
        actions.put(TokenType.BIGGER_EQ, new ShiftAction(89));
        actions.put(TokenType.LESS_EQ, new ShiftAction(90));
        actions.put(TokenType.DIF, new ShiftAction(91));
        actions.put(NonTerminal.RELATIONAL_STATEMENT_LINE, new GotoAction(85));
        table.put((113), actions);

        //State 114
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(54));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(54));
        actions.put(TokenType.AND, new ReduceAction(54));
        actions.put(TokenType.OR, new ReduceAction(54));
        actions.put(TokenType.XOR, new ReduceAction(54));
        actions.put(TokenType.EQ, new ShiftAction(86));
        actions.put(TokenType.BIGGER, new ShiftAction(87));
        actions.put(TokenType.LESS, new ShiftAction(88));
        actions.put(TokenType.BIGGER_EQ, new ShiftAction(89));
        actions.put(TokenType.LESS_EQ, new ShiftAction(90));
        actions.put(TokenType.DIF, new ShiftAction(91));
        actions.put(NonTerminal.RELATIONAL_STATEMENT_LINE, new GotoAction(85));
        table.put((114), actions);

        //State 115
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(55));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(55));
        actions.put(TokenType.AND, new ReduceAction(55));
        actions.put(TokenType.OR, new ReduceAction(55));
        actions.put(TokenType.XOR, new ReduceAction(55));
        actions.put(TokenType.EQ, new ShiftAction(86));
        actions.put(TokenType.BIGGER, new ShiftAction(87));
        actions.put(TokenType.LESS, new ShiftAction(88));
        actions.put(TokenType.BIGGER_EQ, new ShiftAction(89));
        actions.put(TokenType.LESS_EQ, new ShiftAction(90));
        actions.put(TokenType.DIF, new ShiftAction(91));
        actions.put(NonTerminal.RELATIONAL_STATEMENT_LINE, new GotoAction(85));
        table.put((115), actions);

        //State 116
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(61));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(61));
        actions.put(TokenType.AND, new ReduceAction(61));
        actions.put(TokenType.OR, new ReduceAction(61));
        actions.put(TokenType.XOR, new ReduceAction(61));
        actions.put(TokenType.EQ, new ReduceAction(61));
        actions.put(TokenType.BIGGER, new ReduceAction(61));
        actions.put(TokenType.LESS, new ReduceAction(61));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(61));
        actions.put(TokenType.LESS_EQ, new ReduceAction(61));
        actions.put(TokenType.DIF, new ReduceAction(61));
        actions.put(TokenType.SUM, new ShiftAction(94));
        actions.put(TokenType.SUB, new ShiftAction(95));
        actions.put(TokenType.MULT, new ShiftAction(96));
        actions.put(TokenType.DIV, new ShiftAction(97));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT_LINE, new GotoAction(93));
        table.put((116), actions);

        //State 117
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(57));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(57));
        actions.put(TokenType.AND, new ReduceAction(57));
        actions.put(TokenType.OR, new ReduceAction(57));
        actions.put(TokenType.XOR, new ReduceAction(57));
        actions.put(TokenType.EQ, new ReduceAction(57));
        actions.put(TokenType.BIGGER, new ReduceAction(57));
        actions.put(TokenType.LESS, new ReduceAction(57));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(57));
        actions.put(TokenType.LESS_EQ, new ReduceAction(57));
        actions.put(TokenType.DIF, new ReduceAction(57));
        actions.put(TokenType.SUM, new ReduceAction(57));
        actions.put(TokenType.SUB, new ReduceAction(57));
        actions.put(TokenType.MULT, new ReduceAction(57));
        actions.put(TokenType.DIV, new ReduceAction(57));
        table.put((117), actions);

        //State 118
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(62));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(62));
        actions.put(TokenType.AND, new ReduceAction(62));
        actions.put(TokenType.OR, new ReduceAction(62));
        actions.put(TokenType.XOR, new ReduceAction(62));
        actions.put(TokenType.EQ, new ReduceAction(62));
        actions.put(TokenType.BIGGER, new ReduceAction(62));
        actions.put(TokenType.LESS, new ReduceAction(62));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(62));
        actions.put(TokenType.LESS_EQ, new ReduceAction(62));
        actions.put(TokenType.DIF, new ReduceAction(62));
        actions.put(TokenType.SUM, new ShiftAction(94));
        actions.put(TokenType.SUB, new ShiftAction(95));
        actions.put(TokenType.MULT, new ShiftAction(96));
        actions.put(TokenType.DIV, new ShiftAction(97));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT_LINE, new GotoAction(93));
        table.put((118), actions);

        //State 119
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(63));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(63));
        actions.put(TokenType.AND, new ReduceAction(63));
        actions.put(TokenType.OR, new ReduceAction(63));
        actions.put(TokenType.XOR, new ReduceAction(63));
        actions.put(TokenType.EQ, new ReduceAction(63));
        actions.put(TokenType.BIGGER, new ReduceAction(63));
        actions.put(TokenType.LESS, new ReduceAction(63));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(63));
        actions.put(TokenType.LESS_EQ, new ReduceAction(63));
        actions.put(TokenType.DIF, new ReduceAction(63));
        actions.put(TokenType.SUM, new ShiftAction(94));
        actions.put(TokenType.SUB, new ShiftAction(95));
        actions.put(TokenType.MULT, new ShiftAction(96));
        actions.put(TokenType.DIV, new ShiftAction(97));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT_LINE, new GotoAction(93));
        table.put((119), actions);

        //State 120
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(64));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(64));
        actions.put(TokenType.AND, new ReduceAction(64));
        actions.put(TokenType.OR, new ReduceAction(64));
        actions.put(TokenType.XOR, new ReduceAction(64));
        actions.put(TokenType.EQ, new ReduceAction(64));
        actions.put(TokenType.BIGGER, new ReduceAction(64));
        actions.put(TokenType.LESS, new ReduceAction(64));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(64));
        actions.put(TokenType.LESS_EQ, new ReduceAction(64));
        actions.put(TokenType.DIF, new ReduceAction(64));
        actions.put(TokenType.SUM, new ShiftAction(94));
        actions.put(TokenType.SUB, new ShiftAction(95));
        actions.put(TokenType.MULT, new ShiftAction(96));
        actions.put(TokenType.DIV, new ShiftAction(97));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT_LINE, new GotoAction(93));
        table.put((120), actions);

        //State 121
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ReduceAction(22));
        actions.put(TokenType.WHILE, new ReduceAction(22));
        actions.put(TokenType.STOP, new ReduceAction(22));
        actions.put(TokenType.DO, new ReduceAction(22));
        actions.put(TokenType.IF, new ReduceAction(22));
        actions.put(TokenType.SWITCH, new ReduceAction(22));
        actions.put(TokenType.SCAN, new ReduceAction(22));
        table.put((121), actions);

        //State 122
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(50));
        actions.put(NonTerminal.CONDITION, new GotoAction(132));
        table.put((122), actions);

        //State 123
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(6));
        table.put((123), actions);

        //State 124
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(11));
        table.put((124), actions);

        //State 125
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(133));
        table.put((125), actions);

        //State 126
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(134));
        table.put((126), actions);

        //State 127
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ShiftAction(135));
        table.put((127), actions);

        //State 128
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(34));
        table.put((128), actions);

        //State 129
        actions = new HashMap<>();
        actions.put(TokenType.ELSE, new ShiftAction(137));
        actions.put(NonTerminal.ELSE_STATEMENT, new GotoAction(136));
        table.put((129), actions);

        //State 130
        actions = new HashMap<>();
        actions.put(TokenType.IF, new ShiftAction(139));
        table.put((130), actions);

        //State 131
        actions = new HashMap<>();
        actions.put(TokenType.ELSE, new ReduceAction(28));
        table.put((131), actions);

        //State 132
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(140));
        table.put((132), actions);

        // State 133
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ReduceAction(31));
        actions.put(TokenType.WHILE, new ReduceAction(31));
        actions.put(TokenType.STOP, new ReduceAction(31));
        actions.put(TokenType.DO, new ReduceAction(31));
        actions.put(TokenType.IF, new ReduceAction(31));
        actions.put(TokenType.SWITCH, new ReduceAction(31));
        actions.put(TokenType.PRINT, new ReduceAction(31));
        actions.put(TokenType.SCAN, new ReduceAction(31));
        table.put((133), actions);

        // State 134
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ShiftAction(141));
        table.put((134), actions);

        // State 135
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(142));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put((135), actions);

        // State 136
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ReduceAction(26));
        actions.put(TokenType.WHILE, new ReduceAction(26));
        actions.put(TokenType.STOP, new ReduceAction(26));
        actions.put(TokenType.DO, new ReduceAction(26));
        actions.put(TokenType.IF, new ReduceAction(26));
        actions.put(TokenType.SWITCH, new ReduceAction(26));
        actions.put(TokenType.PRINT, new ReduceAction(26));
        actions.put(TokenType.SCAN, new ReduceAction(26));
        table.put((136), actions);

        // State 137
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(143));
        table.put((137), actions);

        // State 138
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ReduceAction(30));
        actions.put(TokenType.WHILE, new ReduceAction(30));
        actions.put(TokenType.STOP, new ReduceAction(30));
        actions.put(TokenType.DO, new ReduceAction(30));
        actions.put(TokenType.IF, new ReduceAction(30));
        actions.put(TokenType.SWITCH, new ReduceAction(30));
        actions.put(TokenType.PRINT, new ReduceAction(30));
        actions.put(TokenType.SCAN, new ReduceAction(30));
        table.put((138), actions);

        // State 139
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(50));
        actions.put(NonTerminal.CONDITION, new GotoAction(144));
        table.put((139), actions);

        // State 140
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ReduceAction(25));
        actions.put(TokenType.WHILE, new ReduceAction(25));
        actions.put(TokenType.STOP, new ReduceAction(25));
        actions.put(TokenType.DO, new ReduceAction(25));
        actions.put(TokenType.IF, new ReduceAction(25));
        actions.put(TokenType.SWITCH, new ReduceAction(25));
        actions.put(TokenType.PRINT, new ReduceAction(25));
        actions.put(TokenType.SCAN, new ReduceAction(25));
        table.put((140), actions);

        // State 141
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(145));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put((141), actions);

        // State 142
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(33));
        table.put((142), actions);

        // State 143
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(146));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put((143), actions);

        // State 144
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(147));
        table.put((144), actions);

        // State 145
        actions = new HashMap<>();
        actions.put(TokenType.CASE, new ShiftAction(126));
        actions.put(TokenType.DFLT, new ShiftAction(127));
        actions.put(NonTerminal.CASE_STATEMENT, new GotoAction(148));
        table.put((145), actions);


        // State 146
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(149));
        table.put((146), actions);

        // State 147
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.STOP, new ShiftAction(34));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.PRINT, new ShiftAction(35));
        actions.put(TokenType.SCAN, new ShiftAction(36));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(150));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.STOP_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(23));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(24));
        table.put((147), actions);

        // State 148
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(32));
        table.put((148), actions);

        // State 149
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ReduceAction(29));
        actions.put(TokenType.WHILE, new ReduceAction(29));
        actions.put(TokenType.STOP, new ReduceAction(29));
        actions.put(TokenType.DO, new ReduceAction(29));
        actions.put(TokenType.IF, new ReduceAction(29));
        actions.put(TokenType.SWITCH, new ReduceAction(29));
        actions.put(TokenType.PRINT, new ReduceAction(29));
        actions.put(TokenType.SCAN, new ReduceAction(29));
        table.put((149), actions);

        // State 150
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(151));
        table.put((150), actions);

        // State 151
        actions = new HashMap<>();
        actions.put(TokenType.ELSE, new ShiftAction(130));
        actions.put(NonTerminal.ELSE_IF_STATEMENT, new GotoAction(152));
        table.put((151), actions);


        // State 152
        actions = new HashMap<>();
        actions.put(TokenType.ELSE, new ReduceAction(27));
        table.put((152), actions);

        instance = table;

        return instance;
    }
}
