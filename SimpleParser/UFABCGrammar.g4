grammar UFABCGrammar;

@header {
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.HashSet; 
    import io.compiler.types.*;
    import io.compiler.core.exceptions.*;
    import io.compiler.core.ast.*;
    import java.util.Stack;
}

@members {
    private HashMap<String, Var> symbolTable = new HashMap<String, Var>();
    private ArrayList<Var> currentDecl = new ArrayList<Var>();
    private Types currentType;
    private Types leftType = null;
    private Types rightType = null;
    private Program program = new Program();
    private String strExpr = "";
    private IfCommand currentIfCommand;
    private WhileCommand currentWhileCommand;
    private DoWhileCommand currentDoWhileCommand;

    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();

    public void updateTypes() {
        for(Var v : currentDecl) {
            v.setType(currentType);
            symbolTable.put(v.getId(), v);
        }
    }

    public void exibirVar() {
        for(String id : symbolTable.keySet()) {
            System.out.println(symbolTable.get(id));
        }
    }

    public Program getProgram() {
        return this.program;
    }

    public boolean isDeclared(String id) {
        return symbolTable.get(id) != null;
    }
}

programa    :   'programa' ID   { program.setName(_input.LT(-1).getText()); 
                                  stack.push(new ArrayList<Command>());
                                } 
                AC 
                declara+ 
                bloco 
                FC 
                'fimprog'

                {
                    for(Var var : symbolTable.values()) {
                        if(!var.isUsed()) {
                            try {
                                throw new UFABCWarningException("Warning: Variável [" + var.getId() + "] não eh usada!");
                            }
                            catch(UFABCWarningException ex) {
                                System.err.println(ex.getMessage());
                            }
                        }
                    }
                    program.setSymbolTable(symbolTable);
                    program.setCommandList(stack.pop());
                }
            ;

declara     :   'declare' { currentDecl.clear(); }
                ('number' { currentType = Types.NUMBER; } |'text' { currentType = Types.TEXT; } )
                ID { currentDecl.add(new Var(_input.LT(-1).getText())); }
                (',' ID { currentDecl.add(new Var(_input.LT(-1).getText())); } )* 
                {updateTypes();}
                PV
            ;

bloco       :   cmd+
            ;

cmd         :   cmdLeitura | cmdEscrita | cmdAtr | cmdIF | cmdWhile | cmdDoWhile
            ;

cmdLeitura  :   'leia'
                AP  { program.setReadCommandUsed(true); }
                ID  { if (!isDeclared(_input.LT(-1).getText())) {
                        throw new UFABCSemanticException("Variável [" +(_input.LT(-1).getText()) + "] não declarada!");
                    } 
                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                    Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
                    stack.peek().add(cmdRead);
                    }
                    
                FP 
                PV
            ;

cmdEscrita  :   'escreva'
                AP 
                (
                TXT
            |   ID  {   if (!isDeclared(_input.LT(-1).getText())) {
                            throw new UFABCSemanticException("Variável [" +(_input.LT(-1).getText()) + "] não declarada!");
                        } 
                        if(!symbolTable.get(_input.LT(-1).getText()).isInitialized()) {
                            throw new UFABCSemanticException("Variável [" +(_input.LT(-1).getText()) + "] não inicializada!");
                        }
                        symbolTable.get(_input.LT(-1).getText()).setUsed(true);
                    }
                )   { Command cmdWrite = new WriteCommand(_input.LT(-1).getText()); 
                      stack.peek().add(cmdWrite);}          
                FP 
                PV
            ;

cmdAtr      :   ID  { if (!isDeclared(_input.LT(-1).getText())) {
                        throw new UFABCSemanticException("Variável [" +(_input.LT(-1).getText()) + "] não declarada!");
                    } 
                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                    leftType = symbolTable.get(_input.LT(-1).getText()).getType();
                    AttributionCommand cmdAtr = new AttributionCommand(symbolTable.get(_input.LT(-1).getText()));
                    strExpr = "";
                    rightType = null;
                    }
                ':=' 
                (
                expr
                |
                ID  {
                        if (!isDeclared(_input.LT(-1).getText())) {
                            throw new UFABCSemanticException("Variável [" +(_input.LT(-1).getText()) + "] não declarada!");
                        }
                        rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                        symbolTable.get(_input.LT(-1).getText()).setUsed(true);
                    }
                | 
                TXT { rightType = Types.TEXT; 
                      strExpr += _input.LT(-1).getText();
                    }
                ) 
                PV

                {   
                    if(rightType != leftType) {
                        throw new UFABCSemanticException(String.format("Atribuição inválida! variável é do tipo %s, mas recebe atribuição do tipo %s", leftType, rightType));
                    }
                    cmdAtr.setContent(strExpr);
                    stack.peek().add(cmdAtr);
                }
            ;

cmdIF       :   'se' { stack.push(new ArrayList<Command>());
                       strExpr = "";
                       currentIfCommand = new IfCommand();
                     }
                AP 
                expr
                OP_REL { strExpr += " " + _input.LT(-1).getText() + " "; }
                expr
                (OP_LOG { strExpr += " " + _input.LT(-1).getText() + " "; }
                expr 
                OP_REL { strExpr += " " + _input.LT(-1).getText() + " "; }
                expr)? 
                FP { currentIfCommand.setExpression(strExpr); }
                'entao' 
                AC 
                cmd+ 
                FC  { currentIfCommand.setTrueList(stack.pop()); }
                ('senao' { stack.push(new ArrayList<Command>()); }   
                AC 
                cmd+ 
                FC  { currentIfCommand.setFalseList(stack.pop());}
                )?
                {
                    stack.peek().add(currentIfCommand);
                }
            ;

cmdWhile    :   'enquanto'  { stack.push(new ArrayList<Command>()); 
                              strExpr = "";
                              currentWhileCommand = new WhileCommand();
                            }
                AP
                expr
                OP_REL { strExpr += " " + _input.LT(-1).getText() + " "; }
                expr
                (OP_LOG { strExpr += " " + _input.LT(-1).getText() + " "; }
                expr 
                OP_REL { strExpr += " " + _input.LT(-1).getText() + " "; }
                expr)?
                FP { currentWhileCommand.setExpr(strExpr); }
                AC
                cmd+
                FC  { currentWhileCommand.setTrueList(stack.pop()); 
                      stack.peek().add(currentWhileCommand);
                    }
            ;

cmdDoWhile  :   'execute'   { stack.push(new ArrayList<Command>()); 
                              currentDoWhileCommand = new DoWhileCommand();
                            }
                AC
                cmd+
                FC  { currentDoWhileCommand.setTrueList(stack.pop()); }
                'enquanto' { str = ""; }
                AP
                expr
                OP_REL { strExpr += " " + _input.LT(-1).getText() + " "; }
                expr
                (OP_LOG { strExpr += " " + _input.LT(-1).getText() + " "; }
                expr 
                OP_REL { strExpr += " " + _input.LT(-1).getText() + " "; }
                expr)?
                FP  { currentDoWhileCommand.setExpr(strExpr); 
                      stack.peek().add(currentDoWhileCommand);
                    }
                PV
            ;


expr        :   termo
                exprl
            ;

exprl       :   (   OP_SOM_SUB  { strExpr += " " + _input.LT(-1).getText() + " "; } 
                    termo
                )*
            ;

termo       :   fator { strExpr += _input.LT(-1).getText(); } 
                termol
            ;

termol      :   (OP_MULT_DIV    { strExpr += " " + _input.LT(-1).getText() + " "; } 
                 fator          { strExpr += _input.LT(-1).getText(); } 
                )*
            ;

fator       :   NUM {   if (rightType == null) {
                            rightType = Types.NUMBER;
                        }

                    }

            |   ID  {   if (!isDeclared(_input.LT(-1).getText())) {
                            throw new UFABCSemanticException("Variável [" +(_input.LT(-1).getText()) + "] não declarada!");
                        } 

                        if(!symbolTable.get(_input.LT(-1).getText()).isInitialized()) {
                            throw new UFABCSemanticException("Variável [" +(_input.LT(-1).getText()) + "] não inicializada!");
                        }

                        if (rightType == null) {
                            rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                        }
                        else {
                            if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()) {
                                rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                            }
                        }

                        symbolTable.get(_input.LT(-1).getText()).setUsed(true);
                    }
            |   AP expr FP 
            ;

OP_SOM_SUB  :    '+' | '-'
            ;

OP_MULT_DIV :    '*' | '/'
            ;

OP_REL      :    '<' | '>' | '<=' | '>=' | '!=' | '=='
            ;

OP_LOG      :    '&&'|'||'|'!'|'^'
            ;

TXT         :   '"' (~["\r\n])* '"'
            ;

NUM         :   [0-9]+ ('.' [0-9]+)?
            ;

ID          :   ([a-z] | [A-Z]) ([a-z] | [A-Z] | [0-9])*
            ;

AP          :   '('
            ;

FP          :   ')'
            ;

AC          :   '{'
            ;

FC          :   '}'
            ;

PV          :   ';'
            ;

WS          :   (' ' | '\n' | '\r' | '\t') -> skip
            ;