package io.compiler.core.ast;

import io.compiler.types.Types;
import io.compiler.types.Var;

public class ReadCommand extends Command{
    private Var var;

    public ReadCommand(Var var) {
        this.var = var;
    }

    public ReadCommand() {
    }

    public Var getVar() {
        return var;
    }

    public void setVar(Var var) {
        this.var = var;
    }
    
    @Override
    public String generateTarget() {
        StringBuilder sb = new StringBuilder();
        sb.append(var.getId() + "=");
        if(var.getType() == Types.NUMBER) {
            sb.append("_scTrx.nextInt();\n");
        }
        else if(var.getType() == Types.TEXT) {
            sb.append("_scTrx.nextLine();\n");
        }
        else if(var.getType() == Types.REAL) {
            sb.append("_scTrx.nextDouble();\n");
        }


        return sb.toString();
    }

}
