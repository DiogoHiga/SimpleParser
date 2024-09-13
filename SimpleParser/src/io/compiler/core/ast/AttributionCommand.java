package io.compiler.core.ast;
import io.compiler.types.*;

public class AttributionCommand extends Command{
    private Var var;
    private String content;

    public AttributionCommand(Var var, String content) {
        this.var = var;
        this.content = content;
    }

    public AttributionCommand(Var var) {
        this.var = var;
    }

    public AttributionCommand() {
    }

    public Var getVar() {
        return var;
    }

    public void setVar(Var var) {
        this.var = var;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String generateTarget() {
        return var.getId() + " = " + content + ";\n";
    }

}
