package io.compiler.core.ast;

import java.util.ArrayList;

public class DoWhileCommand extends Command{
    private String expr;
    private ArrayList<Command> trueList;

    public DoWhileCommand(String expr, ArrayList<Command> trueList) {
        this.expr = expr;
        this.trueList = trueList;
    }

    public DoWhileCommand() {
    }

    public String getExpr() {
        return expr;
    }

    public void setExpr(String expr) {
        this.expr = expr;
    }

    public ArrayList<Command> getTrueList() {
        return trueList;
    }

    public void setTrueList(ArrayList<Command> trueList) {
        this.trueList = trueList;
    }

    @Override
    public String generateTarget() {
        StringBuilder sb = new StringBuilder();
        sb.append("do {\n");
        for(Command cmd : trueList) {
            sb.append("            " + cmd.generateTarget());
        }
        sb.append("} while(" + expr + ");");
        return sb.toString();
    }

}
