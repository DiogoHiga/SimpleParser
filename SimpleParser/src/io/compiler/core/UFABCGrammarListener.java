// Generated from UFABCGrammar.g4 by ANTLR 4.13.2
package io.compiler.core;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.HashSet; 
    import io.compiler.types.*;
    import io.compiler.core.exceptions.*;
    import io.compiler.core.ast.*;
    import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UFABCGrammarParser}.
 */
public interface UFABCGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(UFABCGrammarParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(UFABCGrammarParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#declara}.
	 * @param ctx the parse tree
	 */
	void enterDeclara(UFABCGrammarParser.DeclaraContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#declara}.
	 * @param ctx the parse tree
	 */
	void exitDeclara(UFABCGrammarParser.DeclaraContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(UFABCGrammarParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(UFABCGrammarParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(UFABCGrammarParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(UFABCGrammarParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(UFABCGrammarParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(UFABCGrammarParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(UFABCGrammarParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(UFABCGrammarParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#cmdAtr}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtr(UFABCGrammarParser.CmdAtrContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#cmdAtr}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtr(UFABCGrammarParser.CmdAtrContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#cmdIF}.
	 * @param ctx the parse tree
	 */
	void enterCmdIF(UFABCGrammarParser.CmdIFContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#cmdIF}.
	 * @param ctx the parse tree
	 */
	void exitCmdIF(UFABCGrammarParser.CmdIFContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdWhile(UFABCGrammarParser.CmdWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdWhile(UFABCGrammarParser.CmdWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdDoWhile(UFABCGrammarParser.CmdDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdDoWhile(UFABCGrammarParser.CmdDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(UFABCGrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(UFABCGrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(UFABCGrammarParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(UFABCGrammarParser.ExprlContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(UFABCGrammarParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(UFABCGrammarParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#termol}.
	 * @param ctx the parse tree
	 */
	void enterTermol(UFABCGrammarParser.TermolContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#termol}.
	 * @param ctx the parse tree
	 */
	void exitTermol(UFABCGrammarParser.TermolContext ctx);
	/**
	 * Enter a parse tree produced by {@link UFABCGrammarParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(UFABCGrammarParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link UFABCGrammarParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(UFABCGrammarParser.FatorContext ctx);
}