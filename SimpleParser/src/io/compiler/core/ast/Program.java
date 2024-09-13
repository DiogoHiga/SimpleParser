package io.compiler.core.ast;

import java.util.HashMap;

import io.compiler.types.Types;
import io.compiler.types.Var;
import java.util.ArrayList;

public class Program {
    private String name;
    private HashMap<String, Var> symbolTable;
    private ArrayList<Command> commandList;
    private boolean readCommandUsed;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public HashMap<String, Var> getSymbolTable() {
        return symbolTable;
    }
    public void setSymbolTable(HashMap<String, Var> symbolTable) {
        this.symbolTable = symbolTable;
    }
    public ArrayList<Command> getCommandList() {
        return commandList;
    }
    public void setCommandList(ArrayList<Command> commandList) {
        this.commandList = commandList;
    }
    public boolean isReadCommandUsed() {
        return readCommandUsed;
    }
    public void setReadCommandUsed(boolean readCommandUsed) {
        this.readCommandUsed = readCommandUsed;
    }

    public String generateTarget() {
        StringBuilder sb = new StringBuilder();
        if(readCommandUsed){
            sb.append("import java.util.Scanner;\n\n");
        }
        sb.append("public class " + name + " {\n");
        sb.append("    public static void main(String args[]) {\n");
        if(readCommandUsed) {
            sb.append("    Scanner _scTrx = new Scanner(System.in);\n");
        }
        for (String varId : symbolTable.keySet()) {
            Var var = symbolTable.get(varId);
            if(var.getType() == Types.NUMBER) {
                sb.append("        int ");
            }
            else if(var.getType() == Types.TEXT) {
                sb.append("        String ");
            }
            sb.append(var.getId() + ";\n");
        }
        sb.append("\n");
        for(Command cmd : commandList) {
            sb.append("        " + cmd.generateTarget());
        }
        if(readCommandUsed){
            sb.append("_scTrx.close();\n");
        }
        sb.append("    }\n");
        sb.append("}");
        return sb.toString();
    }
}
