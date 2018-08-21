package morcela.lr;

import morcela.stackable.NonTerminal;

import java.util.HashMap;

public class ProductionList extends HashMap<Integer, Production> {

    private static ProductionList instance = null;

    private ProductionList() {
        //
    }

    public static ProductionList getInstance() {
        if (instance != null) {
            return instance;
        }

        ProductionList list = new ProductionList();

        list.put(0, new Production(1, NonTerminal.PROGRAM_LINE));
        list.put(1, new Production(4, NonTerminal.PROGRAM));
        list.put(2, new Production(2, NonTerminal.SECTION));
        list.put(3, new Production(1, NonTerminal.SECTION));
        list.put(4, new Production(4, NonTerminal.VAR_SECTION));
        list.put(5, new Production(4, NonTerminal.BODY_SECTION));
        list.put(6, new Production(6, NonTerminal.VAR_DECLARATION));
        list.put(7, new Production(1, NonTerminal.VAR_DECLARATION));
        list.put(8, new Production(1, NonTerminal.VAR_TYPE));
        list.put(9, new Production(1, NonTerminal.VAR_TYPE));
        list.put(10, new Production(1, NonTerminal.VAR_TYPE));
        list.put(11, new Production(3, NonTerminal.SIZE_DECLARATION));
        list.put(12, new Production(1, NonTerminal.SIZE_DECLARATION));
        list.put(13, new Production(2, NonTerminal.BODY_STATEMENT));
        list.put(14, new Production(2, NonTerminal.BODY_STATEMENT));
        list.put(15, new Production(2, NonTerminal.BODY_STATEMENT));
        list.put(16, new Production(2, NonTerminal.BODY_STATEMENT));
        list.put(17, new Production(2, NonTerminal.BODY_STATEMENT));
        list.put(18, new Production(2, NonTerminal.BODY_STATEMENT));
        list.put(19, new Production(2, NonTerminal.BODY_STATEMENT));
        list.put(20, new Production(2, NonTerminal.BODY_STATEMENT));
        list.put(21, new Production(2, NonTerminal.BODY_STATEMENT));
        list.put(22, new Production(2, NonTerminal.BODY_STATEMENT));
        list.put(23, new Production(1, NonTerminal.BODY_STATEMENT));
        list.put(24, new Production(5, NonTerminal.WHILE_STATEMENT));
        list.put(25, new Production(2, NonTerminal.STOP_STATEMENT));
        list.put(26, new Production(2, NonTerminal.INC_STATEMENT));
        list.put(27, new Production(2, NonTerminal.DEC_STATEMENT));
        list.put(28, new Production(3, NonTerminal.CONDITION));
        list.put(29, new Production(7, NonTerminal.DO_WHILE_STATEMENT));
        list.put(30, new Production(7, NonTerminal.IF_STATEMENT));
        list.put(31, new Production(7, NonTerminal.ELSE_IF_STATEMENT));
        list.put(32, new Production(1, NonTerminal.ELSE_IF_STATEMENT));
        list.put(33, new Production(4, NonTerminal.ELSE_STATEMENT));
        list.put(34, new Production(1, NonTerminal.ELSE_STATEMENT));
        list.put(35, new Production(7, NonTerminal.SWITCH_STATEMENT));
        list.put(36, new Production(5, NonTerminal.CASE_STATEMENT));
        list.put(37, new Production(3, NonTerminal.CASE_STATEMENT));
        list.put(38, new Production(1, NonTerminal.CASE_STATEMENT));
        list.put(39, new Production(5, NonTerminal.PRINT_STATEMENT));
        list.put(40, new Production(5, NonTerminal.SCAN_STATEMENT));
        list.put(41, new Production(1, NonTerminal.OPERATOR));
        list.put(42, new Production(1, NonTerminal.OPERATOR));
        list.put(43, new Production(1, NonTerminal.OPERATOR));
        list.put(44, new Production(1, NonTerminal.OPERATOR_BOOLEAN));
        list.put(45, new Production(1, NonTerminal.OPERATOR_BOOLEAN));
        list.put(46, new Production(1, NonTerminal.OPERATOR_BOOLEAN));
        list.put(47, new Production(2, NonTerminal.LOGICAL_STATEMENT));
        list.put(48, new Production(2, NonTerminal.LOGICAL_STATEMENT_LINE));
        list.put(49, new Production(2, NonTerminal.LOGICAL_STATEMENT_LINE));
        list.put(50, new Production(2, NonTerminal.LOGICAL_STATEMENT_LINE));
        list.put(51, new Production(2, NonTerminal.LOGICAL_STATEMENT_LINE));
        list.put(52, new Production(1, NonTerminal.LOGICAL_STATEMENT_LINE));
        list.put(53, new Production(2, NonTerminal.RELATIONAL_STATEMENT));
        list.put(54, new Production(2, NonTerminal.RELATIONAL_STATEMENT));
        list.put(55, new Production(2, NonTerminal.RELATIONAL_STATEMENT_LINE));
        list.put(56, new Production(2, NonTerminal.RELATIONAL_STATEMENT_LINE));
        list.put(57, new Production(2, NonTerminal.RELATIONAL_STATEMENT_LINE));
        list.put(58, new Production(2, NonTerminal.RELATIONAL_STATEMENT_LINE));
        list.put(59, new Production(2, NonTerminal.RELATIONAL_STATEMENT_LINE));
        list.put(60, new Production(2, NonTerminal.RELATIONAL_STATEMENT_LINE));
        list.put(61, new Production(2, NonTerminal.ARITHMETIC_STATEMENT));
        list.put(62, new Production(2, NonTerminal.ARITHMETIC_STATEMENT));
        list.put(63, new Production(2, NonTerminal.ARITHMETIC_STATEMENT_LINE));
        list.put(64, new Production(2, NonTerminal.ARITHMETIC_STATEMENT_LINE));
        list.put(65, new Production(2, NonTerminal.ARITHMETIC_STATEMENT_LINE));
        list.put(66, new Production(2, NonTerminal.ARITHMETIC_STATEMENT_LINE));
        list.put(67, new Production(1, NonTerminal.ARITHMETIC_STATEMENT_LINE_LINE));
        list.put(68, new Production(1, NonTerminal.ARITHMETIC_STATEMENT_LINE_LINE));
        list.put(69, new Production(1, NonTerminal.ARITHMETIC_STATEMENT_LINE_LINE));
        list.put(70, new Production(4, NonTerminal.ATTRIBUTION_STATEMENT));

        instance = list;

        return instance;
    }
}
