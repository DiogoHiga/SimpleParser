package io.compiler.core.ast;

import java.util.ArrayList;

public class WhileCommand extends Command{
    private String expr;
    private ArrayList<Command> trueList;

    public WhileCommand(String expr, ArrayList<Command> trueList, ArrayList<Command> falseList) {
        this.expr = expr;
        this.trueList = trueList;
    }

    public WhileCommand(String expr) {
        this.expr = expr;
    }

    public WhileCommand() {
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
        sb.append("while(" + expr + ") {\n");
        for(Command cmd : trueList) {
            sb.append("            " + cmd.generateTarget());
        }
        sb.append("        }\n");
        return sb.toString();
    }

}
