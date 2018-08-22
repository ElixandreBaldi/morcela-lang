package morcela.lr;

import morcela.action.Action;
import morcela.action.GotoAction;
import morcela.action.ReduceAction;
import morcela.action.ShiftAction;
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
        // State 1
        actions = new HashMap<>();
        // State 2
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(3));
        // State 3
        actions = new HashMap<>();
        actions.put(TokenType.VAR, new ShiftAction(7));
        actions.put(TokenType.BODY, new ShiftAction(8));
        actions.put(NonTerminal.SECTION, new GotoAction(4));
        actions.put(NonTerminal.VAR_SECTION, new GotoAction(5));
        actions.put(NonTerminal.BODY_SECTION, new GotoAction(6));
        // State 4
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(9));
        // State 5
        actions = new HashMap<>();
        actions.put(TokenType.BODY, new ShiftAction(8));
        actions.put(NonTerminal.BODY_SECTION, new GotoAction(10));
        // State 6
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(3));
        // State 7
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(11));
        // State 8
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(12));
        // State 9
        actions = new HashMap<>();
        actions.put(TokenType.EOF, new ReduceAction(1));
        // State 10
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(2));
        // State 11
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(8));
        actions.put(TokenType.BOOLEAN, new ShiftAction(15));
        actions.put(TokenType.DOUBLE, new ShiftAction(16));
        actions.put(TokenType.STRING, new ShiftAction(17));
        actions.put(NonTerminal.VAR_DECLARATION, new GotoAction(13));
        actions.put(NonTerminal.VAR_TYPE, new GotoAction(14));
        // State 12
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.STOP, new ShiftAction(24));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.SCAN, new ShiftAction(35));
        actions.put(TokenType.PRINT, new ShiftAction(34));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(18));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.INC_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.DEC_STATEMENT, new GotoAction(28));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(19));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(23));
        // State 13
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(36));
        // State 14
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ShiftAction(37));
        // State 15
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ReduceAction(9));
        // State 16
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ReduceAction(10));
        // State 17
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ReduceAction(11));
        // State 18
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(38));
        // State 19
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(40));
        actions.put(NonTerminal.BODY_STATEMENT_LINE, new GotoAction(39));
        // State 20
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(40));
        actions.put(NonTerminal.BODY_STATEMENT_LINE, new GotoAction(41));
        // State 21
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(40));
        actions.put(NonTerminal.BODY_STATEMENT_LINE, new GotoAction(42));
        // State 22
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(40));
        actions.put(NonTerminal.BODY_STATEMENT_LINE, new GotoAction(43));
        // State 23
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(40));
        actions.put(NonTerminal.BODY_STATEMENT_LINE, new GotoAction(44));
        // State 24
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(40));
        actions.put(NonTerminal.BODY_STATEMENT_LINE, new GotoAction(45));
        // State 25
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(40));
        actions.put(NonTerminal.BODY_STATEMENT_LINE, new GotoAction(46));
        // State 26
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(40));
        actions.put(NonTerminal.BODY_STATEMENT_LINE, new GotoAction(47));
        // State 27
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(40));
        actions.put(NonTerminal.BODY_STATEMENT_LINE, new GotoAction(48));
        // State 28
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(40));
        actions.put(NonTerminal.BODY_STATEMENT_LINE, new GotoAction(49));
        // State 29
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(50));
        // State 30
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(51));
        // State 31
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(52));
        // State 32
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(53));
        // State 33
        actions = new HashMap<>();
        actions.put(TokenType.INC, new ShiftAction(55));
        actions.put(TokenType.DEC, new ShiftAction(56));
        actions.put(TokenType.ATT, new ShiftAction(54));
        // State 34
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(57));
        // State 35
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(58));
        // State 36
        actions = new HashMap<>();
        actions.put(TokenType.BODY, new ReduceAction(4));
        // State 37
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(59));
        // State 38
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(5));
        // State 39
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(13));
        actions.put(TokenType.CASE, new ReduceAction(13));
        actions.put(TokenType.DFLT, new ReduceAction(13));
        // State 40
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(23));
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.STOP, new ShiftAction(24));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.CASE, new ReduceAction(23));
        actions.put(TokenType.DFLT, new ReduceAction(23));
        actions.put(TokenType.SCAN, new ShiftAction(35));
        actions.put(TokenType.PRINT, new ShiftAction(34));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(60));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.INC_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.DEC_STATEMENT, new GotoAction(28));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(19));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(23));
        // State 41
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(14));
        actions.put(TokenType.CASE, new ReduceAction(14));
        actions.put(TokenType.DFLT, new ReduceAction(14));
        // State 42
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(15));
        actions.put(TokenType.CASE, new ReduceAction(15));
        actions.put(TokenType.DFLT, new ReduceAction(15));
        // State 43
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(16));
        actions.put(TokenType.CASE, new ReduceAction(16));
        actions.put(TokenType.DFLT, new ReduceAction(16));
        // State 44
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(17));
        actions.put(TokenType.CASE, new ReduceAction(17));
        actions.put(TokenType.DFLT, new ReduceAction(17));
        // State 45
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(18));
        actions.put(TokenType.CASE, new ReduceAction(18));
        actions.put(TokenType.DFLT, new ReduceAction(18));
        // State 46
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(19));
        actions.put(TokenType.CASE, new ReduceAction(19));
        actions.put(TokenType.DFLT, new ReduceAction(19));
        // State 47
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(20));
        actions.put(TokenType.CASE, new ReduceAction(20));
        actions.put(TokenType.DFLT, new ReduceAction(20));
        // State 48
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(21));
        actions.put(TokenType.CASE, new ReduceAction(21));
        actions.put(TokenType.DFLT, new ReduceAction(21));
        // State 49
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(22));
        actions.put(TokenType.CASE, new ReduceAction(22));
        actions.put(TokenType.DFLT, new ReduceAction(22));
        // State 50
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(61));
        // State 51
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(67));
        actions.put(TokenType.NUM, new ShiftAction(66));
        actions.put(TokenType.STRING_VALUE, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.IF_STATEMENT_LINE, new GotoAction(62));
        actions.put(NonTerminal.OPERATOR, new GotoAction(64));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(63));
        // State 52
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(67));
        actions.put(TokenType.NUM, new ShiftAction(66));
        actions.put(TokenType.STRING_VALUE, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new GotoAction(70));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(69));
        // State 53
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.STOP, new ShiftAction(24));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.SCAN, new ShiftAction(35));
        actions.put(TokenType.PRINT, new ShiftAction(34));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(71));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.INC_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.DEC_STATEMENT, new GotoAction(28));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(19));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(23));
        // State 54
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(67));
        actions.put(TokenType.NUM, new ShiftAction(66));
        actions.put(TokenType.STRING_VALUE, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.OPERATOR, new GotoAction(72));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(74));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT, new GotoAction(73));
        // State 55
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(28));
        // State 56
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(29));
        // State 57
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(67));
        actions.put(TokenType.NUM, new ShiftAction(66));
        actions.put(TokenType.STRING_VALUE, new ShiftAction(68));
        actions.put(NonTerminal.OPERATOR, new GotoAction(75));
        // State 58
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(76));
        // State 59
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(78));
        actions.put(TokenType.OPEN_SIZE_STRING, new ShiftAction(79));
        actions.put(NonTerminal.SIZE_DECLARATION, new GotoAction(77));
        // State 60
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(24));
        actions.put(TokenType.CASE, new ReduceAction(24));
        actions.put(TokenType.DFLT, new ReduceAction(24));
        // State 61
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(80));
        // State 62
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(33));
        // State 63
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(82));
        actions.put(NonTerminal.IF_STATEMENT_LINE_LINE, new GotoAction(81));
        // State 64
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(82));
        actions.put(TokenType.AND, new ShiftAction(85));
        actions.put(TokenType.OR, new ShiftAction(86));
        actions.put(TokenType.XOR, new ShiftAction(87));
        actions.put(NonTerminal.IF_STATEMENT_LINE_LINE, new GotoAction(83));
        actions.put(NonTerminal.LOGICAL_STATEMENT_LINE, new GotoAction(84));
        // State 65
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(67));
        actions.put(TokenType.NUM, new ShiftAction(66));
        actions.put(TokenType.STRING_VALUE, new ShiftAction(68));
        actions.put(NonTerminal.OPERATOR, new GotoAction(88));
        // State 66
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
        actions.put(TokenType.SUM, new ReduceAction(49));
        actions.put(TokenType.SUB, new ReduceAction(49));
        actions.put(TokenType.MULT, new ReduceAction(49));
        actions.put(TokenType.DIV, new ReduceAction(49));
        // State 67
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(50));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(50));
        actions.put(TokenType.AND, new ReduceAction(50));
        actions.put(TokenType.OR, new ReduceAction(50));
        actions.put(TokenType.XOR, new ReduceAction(50));
        actions.put(TokenType.EQ, new ReduceAction(50));
        actions.put(TokenType.BIGGER, new ReduceAction(50));
        actions.put(TokenType.LESS, new ReduceAction(50));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(50));
        actions.put(TokenType.LESS_EQ, new ReduceAction(50));
        actions.put(TokenType.DIF, new ReduceAction(50));
        actions.put(TokenType.SUM, new ReduceAction(50));
        actions.put(TokenType.SUB, new ReduceAction(50));
        actions.put(TokenType.MULT, new ReduceAction(50));
        actions.put(TokenType.DIV, new ReduceAction(50));
        // State 68
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(51));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(51));
        actions.put(TokenType.AND, new ReduceAction(51));
        actions.put(TokenType.OR, new ReduceAction(51));
        actions.put(TokenType.XOR, new ReduceAction(51));
        actions.put(TokenType.EQ, new ReduceAction(51));
        actions.put(TokenType.BIGGER, new ReduceAction(51));
        actions.put(TokenType.LESS, new ReduceAction(51));
        actions.put(TokenType.BIGGER_EQ, new ReduceAction(51));
        actions.put(TokenType.LESS_EQ, new ReduceAction(51));
        actions.put(TokenType.DIF, new ReduceAction(51));
        actions.put(TokenType.SUM, new ReduceAction(51));
        actions.put(TokenType.SUB, new ReduceAction(51));
        actions.put(TokenType.MULT, new ReduceAction(51));
        actions.put(TokenType.DIV, new ReduceAction(51));
        // State 69
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(90));
        actions.put(NonTerminal.WHILE_STATEMENT_LINE, new GotoAction(89));
        // State 70
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(90));
        actions.put(TokenType.AND, new ShiftAction(85));
        actions.put(TokenType.OR, new ShiftAction(86));
        actions.put(TokenType.XOR, new ShiftAction(87));
        actions.put(NonTerminal.WHILE_STATEMENT_LINE, new GotoAction(91));
        actions.put(NonTerminal.LOGICAL_STATEMENT_LINE, new GotoAction(84));
        // State 71
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(92));
        // State 72
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(70));
        actions.put(TokenType.AND, new ShiftAction(85));
        actions.put(TokenType.OR, new ShiftAction(86));
        actions.put(TokenType.XOR, new ShiftAction(87));
        actions.put(TokenType.SUM, new ShiftAction(94));
        actions.put(TokenType.SUB, new ShiftAction(95));
        actions.put(TokenType.MULT, new ShiftAction(96));
        actions.put(TokenType.DIV, new ShiftAction(97));
        actions.put(NonTerminal.LOGICAL_STATEMENT_LINE, new GotoAction(84));
        actions.put(NonTerminal.ARITHMETIC_STATEMENT_LINE, new GotoAction(93));
        // State 73
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(71));
        // State 74
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(72));
        // State 75
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(98));
        // State 76
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(99));
        // State 77
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ShiftAction(100));
        // State 78
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(8));
        actions.put(TokenType.BOOLEAN, new ShiftAction(15));
        actions.put(TokenType.DOUBLE, new ShiftAction(16));
        actions.put(TokenType.STRING, new ShiftAction(17));
        actions.put(NonTerminal.VAR_DECLARATION, new GotoAction(101));
        actions.put(NonTerminal.VAR_TYPE, new GotoAction(14));
        // State 79
        actions = new HashMap<>();
        actions.put(TokenType.NUM, new ShiftAction(102));
        // State 80
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(103));
        // State 81
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(34));
        // State 82
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(104));
        // State 83
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(35));
        // State 84
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(53));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(53));
        // State 85
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(67));
        actions.put(TokenType.NUM, new ShiftAction(66));
        actions.put(TokenType.STRING_VALUE, new ShiftAction(68));
        actions.put(NonTerminal.OPERATOR, new GotoAction(105));
        // State 86
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(67));
        actions.put(TokenType.NUM, new ShiftAction(66));
        actions.put(TokenType.STRING_VALUE, new ShiftAction(68));
        actions.put(NonTerminal.OPERATOR, new GotoAction(106));
        // State 87
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(67));
        actions.put(TokenType.NUM, new ShiftAction(66));
        actions.put(TokenType.STRING_VALUE, new ShiftAction(68));
        actions.put(NonTerminal.OPERATOR, new GotoAction(107));
        // State 88
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(54));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(54));
        // State 89
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(25));
        // State 90
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(108));
        // State 91
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(26));
        // State 92
        actions = new HashMap<>();
        actions.put(TokenType.WHILE, new ShiftAction(109));
        // State 93
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(65));
        // State 94
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(67));
        actions.put(TokenType.NUM, new ShiftAction(66));
        actions.put(TokenType.STRING_VALUE, new ShiftAction(68));
        actions.put(NonTerminal.OPERATOR, new GotoAction(110));
        // State 95
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(67));
        actions.put(TokenType.NUM, new ShiftAction(66));
        actions.put(TokenType.STRING_VALUE, new ShiftAction(68));
        actions.put(NonTerminal.OPERATOR, new GotoAction(111));
        // State 96
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(67));
        actions.put(TokenType.NUM, new ShiftAction(66));
        actions.put(TokenType.STRING_VALUE, new ShiftAction(68));
        actions.put(NonTerminal.OPERATOR, new GotoAction(112));
        // State 97
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(67));
        actions.put(TokenType.NUM, new ShiftAction(66));
        actions.put(TokenType.STRING_VALUE, new ShiftAction(68));
        actions.put(NonTerminal.OPERATOR, new GotoAction(113));
        // State 98
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(52));
        // State 99
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(48));
        // State 100
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(8));
        actions.put(TokenType.BOOLEAN, new ShiftAction(15));
        actions.put(TokenType.DOUBLE, new ShiftAction(16));
        actions.put(TokenType.STRING, new ShiftAction(17));
        actions.put(NonTerminal.VAR_DECLARATION, new GotoAction(114));
        actions.put(NonTerminal.VAR_TYPE, new GotoAction(14));
        // State 101
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(7));
        // State 102
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_SIZE_STRING, new ShiftAction(115));
        // State 103
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(47));
        actions.put(TokenType.CASE, new ShiftAction(117));
        actions.put(TokenType.DFLT, new ShiftAction(118));
        actions.put(NonTerminal.CASE_STATEMENT, new GotoAction(116));
        // State 104
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.STOP, new ShiftAction(24));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.SCAN, new ShiftAction(35));
        actions.put(TokenType.PRINT, new ShiftAction(34));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(119));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.INC_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.DEC_STATEMENT, new GotoAction(28));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(19));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(23));
        // State 105
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(55));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(55));
        // State 106
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(56));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(56));
        // State 107
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(57));
        actions.put(TokenType.CLOSE_PAR, new ReduceAction(57));
        // State 108
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.STOP, new ShiftAction(24));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.SCAN, new ShiftAction(35));
        actions.put(TokenType.PRINT, new ShiftAction(34));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(120));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.INC_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.DEC_STATEMENT, new GotoAction(28));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(19));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(23));
        // State 109
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(121));
        // State 110
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(66));
        // State 111
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(67));
        // State 112
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(68));
        // State 113
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(69));
        // State 114
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(6));
        // State 115
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(12));
        // State 116
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(122));
        // State 117
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(123));
        // State 118
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ShiftAction(124));
        // State 119
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(125));
        // State 120
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(126));
        // State 121
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(67));
        actions.put(TokenType.NUM, new ShiftAction(66));
        actions.put(TokenType.STRING_VALUE, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.DO_WHILE_STATEMENT_LINE, new GotoAction(127));
        actions.put(NonTerminal.OPERATOR, new GotoAction(129));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(128));
        // State 122
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(44));
        // State 123
        actions = new HashMap<>();
        actions.put(TokenType.DOUBLE_DOT, new ShiftAction(130));
        // State 124
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.STOP, new ShiftAction(24));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.SCAN, new ShiftAction(35));
        actions.put(TokenType.PRINT, new ShiftAction(34));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(131));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.INC_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.DEC_STATEMENT, new GotoAction(28));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(19));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(23));
        // State 125
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(38));
        actions.put(TokenType.ELSE, new ShiftAction(133));
        actions.put(NonTerminal.ELSE_IF_STATEMENT, new GotoAction(132));
        // State 126
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(27));
        // State 127
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(30));
        // State 128
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(134));
        // State 129
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(135));
        actions.put(TokenType.AND, new ShiftAction(85));
        actions.put(TokenType.OR, new ShiftAction(86));
        actions.put(TokenType.XOR, new ShiftAction(87));
        actions.put(NonTerminal.LOGICAL_STATEMENT_LINE, new GotoAction(84));
        // State 130
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.STOP, new ShiftAction(24));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.SCAN, new ShiftAction(35));
        actions.put(TokenType.PRINT, new ShiftAction(34));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(136));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.INC_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.DEC_STATEMENT, new GotoAction(28));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(19));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(23));
        // State 131
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(46));
        // State 132
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(43));
        actions.put(TokenType.ELSE, new ShiftAction(138));
        actions.put(NonTerminal.ELSE_STATEMENT, new GotoAction(137));
        // State 133
        actions = new HashMap<>();
        actions.put(TokenType.IF, new ShiftAction(139));
        // State 134
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(31));
        // State 135
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(32));
        // State 136
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(47));
        actions.put(TokenType.CASE, new ShiftAction(117));
        actions.put(TokenType.DFLT, new ShiftAction(118));
        actions.put(NonTerminal.CASE_STATEMENT, new GotoAction(140));
        // State 137
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(36));
        // State 138
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(141));
        // State 139
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_PAR, new ShiftAction(142));
        // State 140
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ReduceAction(45));
        // State 141
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.STOP, new ShiftAction(24));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.SCAN, new ShiftAction(35));
        actions.put(TokenType.PRINT, new ShiftAction(34));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(143));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.INC_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.DEC_STATEMENT, new GotoAction(28));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(19));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(23));
        // State 142
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(67));
        actions.put(TokenType.NUM, new ShiftAction(66));
        actions.put(TokenType.STRING_VALUE, new ShiftAction(68));
        actions.put(TokenType.NOT, new ShiftAction(65));
        actions.put(NonTerminal.ELSE_IF_STATEMENT_LINE, new GotoAction(144));
        actions.put(NonTerminal.OPERATOR, new GotoAction(146));
        actions.put(NonTerminal.LOGICAL_STATEMENT, new GotoAction(145));
        // State 143
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(147));
        // State 144
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(37));
        actions.put(TokenType.ELSE, new ReduceAction(37));
        // State 145
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(149));
        actions.put(NonTerminal.ELSE_IF_STATEMENT_LINE_LINE, new GotoAction(148));
        // State 146
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_PAR, new ShiftAction(149));
        actions.put(TokenType.AND, new ShiftAction(85));
        actions.put(TokenType.OR, new ShiftAction(86));
        actions.put(TokenType.XOR, new ShiftAction(87));
        actions.put(NonTerminal.ELSE_IF_STATEMENT_LINE_LINE, new GotoAction(150));
        actions.put(NonTerminal.LOGICAL_STATEMENT_LINE, new GotoAction(84));
        // State 147
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(42));
        // State 148
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(39));
        actions.put(TokenType.ELSE, new ReduceAction(39));
        // State 149
        actions = new HashMap<>();
        actions.put(TokenType.OPEN_BRACES, new ShiftAction(151));
        // State 150
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(40));
        actions.put(TokenType.ELSE, new ReduceAction(40));
        // State 151
        actions = new HashMap<>();
        actions.put(TokenType.ID, new ShiftAction(33));
        actions.put(TokenType.STOP, new ShiftAction(24));
        actions.put(TokenType.WHILE, new ShiftAction(31));
        actions.put(TokenType.DO, new ShiftAction(32));
        actions.put(TokenType.IF, new ShiftAction(30));
        actions.put(TokenType.SWITCH, new ShiftAction(29));
        actions.put(TokenType.SCAN, new ShiftAction(35));
        actions.put(TokenType.PRINT, new ShiftAction(34));
        actions.put(NonTerminal.BODY_STATEMENT, new GotoAction(152));
        actions.put(NonTerminal.WHILE_STATEMENT, new GotoAction(21));
        actions.put(NonTerminal.INC_STATEMENT, new GotoAction(27));
        actions.put(NonTerminal.DEC_STATEMENT, new GotoAction(28));
        actions.put(NonTerminal.DO_WHILE_STATEMENT, new GotoAction(22));
        actions.put(NonTerminal.IF_STATEMENT, new GotoAction(20));
        actions.put(NonTerminal.SWITCH_STATEMENT, new GotoAction(19));
        actions.put(NonTerminal.SCAN_STATEMENT, new GotoAction(26));
        actions.put(NonTerminal.PRINT_STATEMENT, new GotoAction(25));
        actions.put(NonTerminal.ATTRIBUTION_STATEMENT, new GotoAction(23));
        // State 152
        actions = new HashMap<>();
        actions.put(TokenType.CLOSE_BRACES, new ShiftAction(153));
        // State 153
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(38));
        actions.put(TokenType.ELSE, new ShiftAction(133));
        actions.put(NonTerminal.ELSE_IF_STATEMENT, new GotoAction(154));
        // State 154
        actions = new HashMap<>();
        actions.put(TokenType.SEMICOLON, new ReduceAction(41));
        actions.put(TokenType.ELSE, new ReduceAction(41));

        instance = table;

        return instance;
    }
}
