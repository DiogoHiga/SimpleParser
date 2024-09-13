package io.compiler.core.ast;

import java.util.ArrayList;

public class IfCommand extends Command{

    private String expression;
    private ArrayList<Command> trueList;
    private ArrayList<Command> falseList;

    public IfCommand(String expression, ArrayList<Command> trueList, ArrayList<Command> falseList) {
        this.expression = expression;
        this.trueList = trueList;
        this.falseList = falseList;
    }

    public IfCommand() {
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public ArrayList<Command> getTrueList() {
        return trueList;
    }

    public void setTrueList(ArrayList<Command> trueList) {
        this.trueList = trueList;
    }

    public ArrayList<Command> getFalseList() {
        return falseList;
    }

    public void setFalseList(ArrayList<Command> falseList) {
        this.falseList = falseList;
    }

    @Override
    public String generateTarget() {
        StringBuilder sb = new StringBuilder();
        sb.append("if (" + expression + ") {\n");
        for(Command cmd : trueList) {
            sb.append("        " + cmd.generateTarget());
        }
        sb.append("        }\n");
        if(!falseList.isEmpty()) {
            sb.append("        else {\n");
            for(Command cmd : falseList) {
                sb.append("        " + cmd.generateTarget());
            }
            sb.append("        }\n");
        }
        return sb.toString();
    }
    
}
