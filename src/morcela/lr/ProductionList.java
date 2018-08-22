package morcela.lr;

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

//        list.put(0, new Production(1, NonTerminal.PROGRAM_LINE));
//TODO: Refazer

        instance = list;

        return instance;
    }
}
