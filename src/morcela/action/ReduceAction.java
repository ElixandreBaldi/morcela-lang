package morcela.action;

import morcela.lr.LRTable;
import morcela.lr.Production;
import morcela.lr.ProductionList;
import morcela.stackable.Stackable;
import morcela.stackable.State;
import morcela.stackable.Token;

import java.util.Stack;

public class ReduceAction implements Action {

    private Production production;

    public ReduceAction(Integer production) {
        this.production = ProductionList.getInstance().get(production);
    }

    @Override
    public void apply(Stack<Stackable> stack, Stack<Token> input) {
        for (int i = 0; i < production.getSize() * 2; ++i) {
            stack.pop();
        }
        State nextState = (State) stack.peek();
        GotoAction gotoAction = (GotoAction) LRTable.getInstance().get(nextState.id()).get(production.getReductor());
        stack.push(production.getReductor());
        stack.push(gotoAction.getDestiny());
    }
}
