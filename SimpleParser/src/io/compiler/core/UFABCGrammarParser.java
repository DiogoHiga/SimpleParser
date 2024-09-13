// Generated from UFABCGrammar.g4 by ANTLR 4.13.2
package io.compiler.core;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.HashSet; 
    import io.compiler.types.*;
    import io.compiler.core.exceptions.*;
    import io.compiler.core.ast.*;
    import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class UFABCGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, OP_SOM_SUB=16, 
		OP_MULT_DIV=17, OP_REL=18, OP_LOG=19, TXT=20, NUM=21, ID=22, AP=23, FP=24, 
		AC=25, FC=26, PV=27, WS=28;
	public static final int
		RULE_programa = 0, RULE_declara = 1, RULE_bloco = 2, RULE_cmd = 3, RULE_cmdLeitura = 4, 
		RULE_cmdEscrita = 5, RULE_cmdAtr = 6, RULE_cmdIF = 7, RULE_cmdWhile = 8, 
		RULE_cmdDoWhile = 9, RULE_expr = 10, RULE_exprl = 11, RULE_termo = 12, 
		RULE_termol = 13, RULE_fator = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "declara", "bloco", "cmd", "cmdLeitura", "cmdEscrita", "cmdAtr", 
			"cmdIF", "cmdWhile", "cmdDoWhile", "expr", "exprl", "termo", "termol", 
			"fator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "'number'", "'text'", "'real'", 
			"','", "'leia'", "'escreva'", "':='", "'se'", "'entao'", "'senao'", "'enquanto'", 
			"'execute'", null, null, null, null, null, null, null, "'('", "')'", 
			"'{'", "'}'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "OP_SOM_SUB", "OP_MULT_DIV", "OP_REL", "OP_LOG", 
			"TXT", "NUM", "ID", "AP", "FP", "AC", "FC", "PV", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "UFABCGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public UFABCGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(UFABCGrammarParser.ID, 0); }
		public TerminalNode AC() { return getToken(UFABCGrammarParser.AC, 0); }
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode FC() { return getToken(UFABCGrammarParser.FC, 0); }
		public List<DeclaraContext> declara() {
			return getRuleContexts(DeclaraContext.class);
		}
		public DeclaraContext declara(int i) {
			return getRuleContext(DeclaraContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(T__0);
			setState(31);
			match(ID);
			 program.setName(_input.LT(-1).getText()); 
			                                  stack.push(new ArrayList<Command>());
			                                
			setState(33);
			match(AC);
			setState(35); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(34);
				declara();
				}
				}
				setState(37); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(39);
			bloco();
			setState(40);
			match(FC);
			setState(41);
			match(T__1);

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
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaraContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(UFABCGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(UFABCGrammarParser.ID, i);
		}
		public TerminalNode PV() { return getToken(UFABCGrammarParser.PV, 0); }
		public DeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterDeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitDeclara(this);
		}
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(T__2);
			 currentDecl.clear(); 
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(46);
				match(T__3);
				 currentType = Types.NUMBER; 
				}
				break;
			case T__4:
				{
				setState(48);
				match(T__4);
				 currentType = Types.TEXT; 
				}
				break;
			case T__5:
				{
				setState(50);
				match(T__5);
				 currentType = Types.REAL; 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(54);
			match(ID);
			 currentDecl.add(new Var(_input.LT(-1).getText())); 
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(56);
				match(T__6);
				setState(57);
				match(ID);
				 currentDecl.add(new Var(_input.LT(-1).getText())); 
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			updateTypes();
			setState(65);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(67);
				cmd();
				}
				}
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4246272L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdAtrContext cmdAtr() {
			return getRuleContext(CmdAtrContext.class,0);
		}
		public CmdIFContext cmdIF() {
			return getRuleContext(CmdIFContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public CmdDoWhileContext cmdDoWhile() {
			return getRuleContext(CmdDoWhileContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmd);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				cmdLeitura();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				cmdEscrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				cmdAtr();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				cmdIF();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 5);
				{
				setState(76);
				cmdWhile();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(77);
				cmdDoWhile();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public TerminalNode ID() { return getToken(UFABCGrammarParser.ID, 0); }
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(UFABCGrammarParser.PV, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdLeitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdLeitura(this);
		}
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__7);
			setState(81);
			match(AP);
			 program.setReadCommandUsed(true); 
			setState(83);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                        throw new UFABCSemanticException("Variável [" +(_input.LT(-1).getText()) + "] não declarada!");
			                    } 
			                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                    Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                    stack.peek().add(cmdRead);
			                    
			setState(85);
			match(FP);
			setState(86);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEscritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(UFABCGrammarParser.PV, 0); }
		public TerminalNode TXT() { return getToken(UFABCGrammarParser.TXT, 0); }
		public TerminalNode ID() { return getToken(UFABCGrammarParser.ID, 0); }
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdEscrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdEscrita(this);
		}
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__8);
			setState(89);
			match(AP);
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TXT:
				{
				setState(90);
				match(TXT);
				}
				break;
			case ID:
				{
				setState(91);
				match(ID);
				   if (!isDeclared(_input.LT(-1).getText())) {
				                            throw new UFABCSemanticException("Variável [" +(_input.LT(-1).getText()) + "] não declarada!");
				                        } 
				                        if(!symbolTable.get(_input.LT(-1).getText()).isInitialized()) {
				                            throw new UFABCSemanticException("Variável [" +(_input.LT(-1).getText()) + "] não inicializada!");
				                        }
				                        symbolTable.get(_input.LT(-1).getText()).setUsed(true);
				                    
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 Command cmdWrite = new WriteCommand(_input.LT(-1).getText()); 
			                      stack.peek().add(cmdWrite);
			setState(96);
			match(FP);
			setState(97);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAtrContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(UFABCGrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(UFABCGrammarParser.ID, i);
		}
		public TerminalNode PV() { return getToken(UFABCGrammarParser.PV, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode TXT() { return getToken(UFABCGrammarParser.TXT, 0); }
		public CmdAtrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAtr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdAtr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdAtr(this);
		}
	}

	public final CmdAtrContext cmdAtr() throws RecognitionException {
		CmdAtrContext _localctx = new CmdAtrContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdAtr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                        throw new UFABCSemanticException("Variável [" +(_input.LT(-1).getText()) + "] não declarada!");
			                    } 
			                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                    leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			                    AttributionCommand cmdAtr = new AttributionCommand(symbolTable.get(_input.LT(-1).getText()));
			                    strExpr = "";
			                    rightType = null;
			                    
			setState(101);
			match(T__9);
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(102);
				expr();
				}
				break;
			case 2:
				{
				setState(103);
				match(ID);

				                        if (!isDeclared(_input.LT(-1).getText())) {
				                            throw new UFABCSemanticException("Variável [" +(_input.LT(-1).getText()) + "] não declarada!");
				                        }
				                        rightType = symbolTable.get(_input.LT(-1).getText()).getType();
				                        symbolTable.get(_input.LT(-1).getText()).setUsed(true);
				                    
				}
				break;
			case 3:
				{
				setState(105);
				match(TXT);
				 rightType = Types.TEXT; 
				                      strExpr += _input.LT(-1).getText();
				                    
				}
				break;
			}
			setState(109);
			match(PV);
			   
			                    if(rightType != leftType) {
			                        throw new UFABCSemanticException(String.format("Atribuição inválida! variável é do tipo %s, mas recebe atribuição do tipo %s", leftType, rightType));
			                    }
			                    cmdAtr.setContent(strExpr);
			                    stack.peek().add(cmdAtr);
			                
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdIFContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> OP_REL() { return getTokens(UFABCGrammarParser.OP_REL); }
		public TerminalNode OP_REL(int i) {
			return getToken(UFABCGrammarParser.OP_REL, i);
		}
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public List<TerminalNode> AC() { return getTokens(UFABCGrammarParser.AC); }
		public TerminalNode AC(int i) {
			return getToken(UFABCGrammarParser.AC, i);
		}
		public List<TerminalNode> FC() { return getTokens(UFABCGrammarParser.FC); }
		public TerminalNode FC(int i) {
			return getToken(UFABCGrammarParser.FC, i);
		}
		public TerminalNode OP_LOG() { return getToken(UFABCGrammarParser.OP_LOG, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdIFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIF; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdIF(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdIF(this);
		}
	}

	public final CmdIFContext cmdIF() throws RecognitionException {
		CmdIFContext _localctx = new CmdIFContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdIF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__10);
			 stack.push(new ArrayList<Command>());
			                       strExpr = "";
			                       currentIfCommand = new IfCommand();
			                     
			setState(114);
			match(AP);
			setState(115);
			expr();
			setState(116);
			match(OP_REL);
			 strExpr += " " + _input.LT(-1).getText() + " "; 
			setState(118);
			expr();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_LOG) {
				{
				setState(119);
				match(OP_LOG);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(121);
				expr();
				setState(122);
				match(OP_REL);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(124);
				expr();
				}
			}

			setState(128);
			match(FP);
			 currentIfCommand.setExpression(strExpr); 
			setState(130);
			match(T__11);
			setState(131);
			match(AC);
			setState(133); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(132);
				cmd();
				}
				}
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4246272L) != 0) );
			setState(137);
			match(FC);
			 currentIfCommand.setTrueList(stack.pop()); 
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(139);
				match(T__12);
				 stack.push(new ArrayList<Command>()); 
				setState(141);
				match(AC);
				setState(143); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(142);
					cmd();
					}
					}
					setState(145); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4246272L) != 0) );
				setState(147);
				match(FC);
				 currentIfCommand.setFalseList(stack.pop());
				}
			}


			                    stack.peek().add(currentIfCommand);
			                
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWhileContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> OP_REL() { return getTokens(UFABCGrammarParser.OP_REL); }
		public TerminalNode OP_REL(int i) {
			return getToken(UFABCGrammarParser.OP_REL, i);
		}
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public TerminalNode AC() { return getToken(UFABCGrammarParser.AC, 0); }
		public TerminalNode FC() { return getToken(UFABCGrammarParser.FC, 0); }
		public TerminalNode OP_LOG() { return getToken(UFABCGrammarParser.OP_LOG, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdWhile(this);
		}
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(T__13);
			 stack.push(new ArrayList<Command>()); 
			                              strExpr = "";
			                              currentWhileCommand = new WhileCommand();
			                            
			setState(156);
			match(AP);
			setState(157);
			expr();
			setState(158);
			match(OP_REL);
			 strExpr += " " + _input.LT(-1).getText() + " "; 
			setState(160);
			expr();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_LOG) {
				{
				setState(161);
				match(OP_LOG);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(163);
				expr();
				setState(164);
				match(OP_REL);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(166);
				expr();
				}
			}

			setState(170);
			match(FP);
			 currentWhileCommand.setExpr(strExpr); 
			setState(172);
			match(AC);
			setState(174); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(173);
				cmd();
				}
				}
				setState(176); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4246272L) != 0) );
			setState(178);
			match(FC);
			 currentWhileCommand.setTrueList(stack.pop()); 
			                      stack.peek().add(currentWhileCommand);
			                    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdDoWhileContext extends ParserRuleContext {
		public TerminalNode AC() { return getToken(UFABCGrammarParser.AC, 0); }
		public TerminalNode FC() { return getToken(UFABCGrammarParser.FC, 0); }
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> OP_REL() { return getTokens(UFABCGrammarParser.OP_REL); }
		public TerminalNode OP_REL(int i) {
			return getToken(UFABCGrammarParser.OP_REL, i);
		}
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public TerminalNode PV() { return getToken(UFABCGrammarParser.PV, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode OP_LOG() { return getToken(UFABCGrammarParser.OP_LOG, 0); }
		public CmdDoWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdDoWhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterCmdDoWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitCmdDoWhile(this);
		}
	}

	public final CmdDoWhileContext cmdDoWhile() throws RecognitionException {
		CmdDoWhileContext _localctx = new CmdDoWhileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdDoWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(T__14);
			 stack.push(new ArrayList<Command>()); 
			                              currentDoWhileCommand = new DoWhileCommand();
			                            
			setState(183);
			match(AC);
			setState(185); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(184);
				cmd();
				}
				}
				setState(187); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4246272L) != 0) );
			setState(189);
			match(FC);
			 currentDoWhileCommand.setTrueList(stack.pop()); 
			setState(191);
			match(T__13);
			 strExpr = ""; 
			setState(193);
			match(AP);
			setState(194);
			expr();
			setState(195);
			match(OP_REL);
			 strExpr += " " + _input.LT(-1).getText() + " "; 
			setState(197);
			expr();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_LOG) {
				{
				setState(198);
				match(OP_LOG);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(200);
				expr();
				setState(201);
				match(OP_REL);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(203);
				expr();
				}
			}

			setState(207);
			match(FP);
			 currentDoWhileCommand.setExpr(strExpr); 
			                      stack.peek().add(currentDoWhileCommand);
			                    
			setState(209);
			match(PV);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprlContext exprl() {
			return getRuleContext(ExprlContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			termo();
			setState(212);
			exprl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprlContext extends ParserRuleContext {
		public List<TerminalNode> OP_SOM_SUB() { return getTokens(UFABCGrammarParser.OP_SOM_SUB); }
		public TerminalNode OP_SOM_SUB(int i) {
			return getToken(UFABCGrammarParser.OP_SOM_SUB, i);
		}
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public ExprlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterExprl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitExprl(this);
		}
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_SOM_SUB) {
				{
				{
				setState(214);
				match(OP_SOM_SUB);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(216);
				termo();
				}
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TermolContext termol() {
			return getRuleContext(TermolContext.class,0);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_termo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			fator();
			 strExpr += _input.LT(-1).getText(); 
			setState(224);
			termol();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermolContext extends ParserRuleContext {
		public List<TerminalNode> OP_MULT_DIV() { return getTokens(UFABCGrammarParser.OP_MULT_DIV); }
		public TerminalNode OP_MULT_DIV(int i) {
			return getToken(UFABCGrammarParser.OP_MULT_DIV, i);
		}
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public TermolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterTermol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitTermol(this);
		}
	}

	public final TermolContext termol() throws RecognitionException {
		TermolContext _localctx = new TermolContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_MULT_DIV) {
				{
				{
				setState(226);
				match(OP_MULT_DIV);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(228);
				fator();
				 strExpr += _input.LT(-1).getText(); 
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FatorContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(UFABCGrammarParser.NUM, 0); }
		public TerminalNode ID() { return getToken(UFABCGrammarParser.ID, 0); }
		public TerminalNode AP() { return getToken(UFABCGrammarParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(UFABCGrammarParser.FP, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UFABCGrammarListener ) ((UFABCGrammarListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fator);
		try {
			setState(244);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(236);
				match(NUM);
				   if (rightType == null) {
				                            rightType = Types.NUMBER;
				                        }

				                    
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				match(ID);
				   if (!isDeclared(_input.LT(-1).getText())) {
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
				break;
			case AP:
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				match(AP);
				setState(241);
				expr();
				setState(242);
				match(FP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001c\u00f7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000$\b\u0000\u000b"+
		"\u0000\f\u0000%\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u00015\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001<\b\u0001\n\u0001"+
		"\f\u0001?\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0004"+
		"\u0002E\b\u0002\u000b\u0002\f\u0002F\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003O\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005^\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006l\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u007f\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007\u0086\b\u0007"+
		"\u000b\u0007\f\u0007\u0087\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0004\u0007\u0090\b\u0007\u000b\u0007\f\u0007"+
		"\u0091\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0097\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00a9"+
		"\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004\b\u00af\b\b\u000b\b\f\b\u00b0"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u00ba"+
		"\b\t\u000b\t\f\t\u00bb\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u00ce\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00da\b\u000b"+
		"\n\u000b\f\u000b\u00dd\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u00e8\b\r\n\r\f\r\u00eb\t\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u00f5\b\u000e\u0001\u000e\u0000\u0000\u000f"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u0000\u0000\u0100\u0000\u001e\u0001\u0000\u0000\u0000\u0002,\u0001"+
		"\u0000\u0000\u0000\u0004D\u0001\u0000\u0000\u0000\u0006N\u0001\u0000\u0000"+
		"\u0000\bP\u0001\u0000\u0000\u0000\nX\u0001\u0000\u0000\u0000\fc\u0001"+
		"\u0000\u0000\u0000\u000ep\u0001\u0000\u0000\u0000\u0010\u009a\u0001\u0000"+
		"\u0000\u0000\u0012\u00b5\u0001\u0000\u0000\u0000\u0014\u00d3\u0001\u0000"+
		"\u0000\u0000\u0016\u00db\u0001\u0000\u0000\u0000\u0018\u00de\u0001\u0000"+
		"\u0000\u0000\u001a\u00e9\u0001\u0000\u0000\u0000\u001c\u00f4\u0001\u0000"+
		"\u0000\u0000\u001e\u001f\u0005\u0001\u0000\u0000\u001f \u0005\u0016\u0000"+
		"\u0000 !\u0006\u0000\uffff\uffff\u0000!#\u0005\u0019\u0000\u0000\"$\u0003"+
		"\u0002\u0001\u0000#\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000"+
		"%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000"+
		"\u0000\'(\u0003\u0004\u0002\u0000()\u0005\u001a\u0000\u0000)*\u0005\u0002"+
		"\u0000\u0000*+\u0006\u0000\uffff\uffff\u0000+\u0001\u0001\u0000\u0000"+
		"\u0000,-\u0005\u0003\u0000\u0000-4\u0006\u0001\uffff\uffff\u0000./\u0005"+
		"\u0004\u0000\u0000/5\u0006\u0001\uffff\uffff\u000001\u0005\u0005\u0000"+
		"\u000015\u0006\u0001\uffff\uffff\u000023\u0005\u0006\u0000\u000035\u0006"+
		"\u0001\uffff\uffff\u00004.\u0001\u0000\u0000\u000040\u0001\u0000\u0000"+
		"\u000042\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000067\u0005\u0016"+
		"\u0000\u00007=\u0006\u0001\uffff\uffff\u000089\u0005\u0007\u0000\u0000"+
		"9:\u0005\u0016\u0000\u0000:<\u0006\u0001\uffff\uffff\u0000;8\u0001\u0000"+
		"\u0000\u0000<?\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001"+
		"\u0000\u0000\u0000>@\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000"+
		"@A\u0006\u0001\uffff\uffff\u0000AB\u0005\u001b\u0000\u0000B\u0003\u0001"+
		"\u0000\u0000\u0000CE\u0003\u0006\u0003\u0000DC\u0001\u0000\u0000\u0000"+
		"EF\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000"+
		"\u0000G\u0005\u0001\u0000\u0000\u0000HO\u0003\b\u0004\u0000IO\u0003\n"+
		"\u0005\u0000JO\u0003\f\u0006\u0000KO\u0003\u000e\u0007\u0000LO\u0003\u0010"+
		"\b\u0000MO\u0003\u0012\t\u0000NH\u0001\u0000\u0000\u0000NI\u0001\u0000"+
		"\u0000\u0000NJ\u0001\u0000\u0000\u0000NK\u0001\u0000\u0000\u0000NL\u0001"+
		"\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000O\u0007\u0001\u0000\u0000"+
		"\u0000PQ\u0005\b\u0000\u0000QR\u0005\u0017\u0000\u0000RS\u0006\u0004\uffff"+
		"\uffff\u0000ST\u0005\u0016\u0000\u0000TU\u0006\u0004\uffff\uffff\u0000"+
		"UV\u0005\u0018\u0000\u0000VW\u0005\u001b\u0000\u0000W\t\u0001\u0000\u0000"+
		"\u0000XY\u0005\t\u0000\u0000Y]\u0005\u0017\u0000\u0000Z^\u0005\u0014\u0000"+
		"\u0000[\\\u0005\u0016\u0000\u0000\\^\u0006\u0005\uffff\uffff\u0000]Z\u0001"+
		"\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_`\u0006\u0005\uffff\uffff\u0000`a\u0005\u0018\u0000\u0000ab\u0005\u001b"+
		"\u0000\u0000b\u000b\u0001\u0000\u0000\u0000cd\u0005\u0016\u0000\u0000"+
		"de\u0006\u0006\uffff\uffff\u0000ek\u0005\n\u0000\u0000fl\u0003\u0014\n"+
		"\u0000gh\u0005\u0016\u0000\u0000hl\u0006\u0006\uffff\uffff\u0000ij\u0005"+
		"\u0014\u0000\u0000jl\u0006\u0006\uffff\uffff\u0000kf\u0001\u0000\u0000"+
		"\u0000kg\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mn\u0005\u001b\u0000\u0000no\u0006\u0006\uffff\uffff\u0000"+
		"o\r\u0001\u0000\u0000\u0000pq\u0005\u000b\u0000\u0000qr\u0006\u0007\uffff"+
		"\uffff\u0000rs\u0005\u0017\u0000\u0000st\u0003\u0014\n\u0000tu\u0005\u0012"+
		"\u0000\u0000uv\u0006\u0007\uffff\uffff\u0000v~\u0003\u0014\n\u0000wx\u0005"+
		"\u0013\u0000\u0000xy\u0006\u0007\uffff\uffff\u0000yz\u0003\u0014\n\u0000"+
		"z{\u0005\u0012\u0000\u0000{|\u0006\u0007\uffff\uffff\u0000|}\u0003\u0014"+
		"\n\u0000}\u007f\u0001\u0000\u0000\u0000~w\u0001\u0000\u0000\u0000~\u007f"+
		"\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0005\u0018\u0000\u0000\u0081\u0082\u0006\u0007\uffff\uffff\u0000\u0082"+
		"\u0083\u0005\f\u0000\u0000\u0083\u0085\u0005\u0019\u0000\u0000\u0084\u0086"+
		"\u0003\u0006\u0003\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0087"+
		"\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0005\u001a\u0000\u0000\u008a\u0096\u0006\u0007\uffff\uffff\u0000\u008b"+
		"\u008c\u0005\r\u0000\u0000\u008c\u008d\u0006\u0007\uffff\uffff\u0000\u008d"+
		"\u008f\u0005\u0019\u0000\u0000\u008e\u0090\u0003\u0006\u0003\u0000\u008f"+
		"\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091"+
		"\u008f\u0001\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0001\u0000\u0000\u0000\u0093\u0094\u0005\u001a\u0000\u0000\u0094"+
		"\u0095\u0006\u0007\uffff\uffff\u0000\u0095\u0097\u0001\u0000\u0000\u0000"+
		"\u0096\u008b\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000"+
		"\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0099\u0006\u0007\uffff\uffff"+
		"\u0000\u0099\u000f\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u000e\u0000"+
		"\u0000\u009b\u009c\u0006\b\uffff\uffff\u0000\u009c\u009d\u0005\u0017\u0000"+
		"\u0000\u009d\u009e\u0003\u0014\n\u0000\u009e\u009f\u0005\u0012\u0000\u0000"+
		"\u009f\u00a0\u0006\b\uffff\uffff\u0000\u00a0\u00a8\u0003\u0014\n\u0000"+
		"\u00a1\u00a2\u0005\u0013\u0000\u0000\u00a2\u00a3\u0006\b\uffff\uffff\u0000"+
		"\u00a3\u00a4\u0003\u0014\n\u0000\u00a4\u00a5\u0005\u0012\u0000\u0000\u00a5"+
		"\u00a6\u0006\b\uffff\uffff\u0000\u00a6\u00a7\u0003\u0014\n\u0000\u00a7"+
		"\u00a9\u0001\u0000\u0000\u0000\u00a8\u00a1\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0005\u0018\u0000\u0000\u00ab\u00ac\u0006\b\uffff\uffff\u0000\u00ac"+
		"\u00ae\u0005\u0019\u0000\u0000\u00ad\u00af\u0003\u0006\u0003\u0000\u00ae"+
		"\u00ad\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0"+
		"\u00ae\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005\u001a\u0000\u0000\u00b3"+
		"\u00b4\u0006\b\uffff\uffff\u0000\u00b4\u0011\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b6\u0005\u000f\u0000\u0000\u00b6\u00b7\u0006\t\uffff\uffff\u0000\u00b7"+
		"\u00b9\u0005\u0019\u0000\u0000\u00b8\u00ba\u0003\u0006\u0003\u0000\u00b9"+
		"\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb"+
		"\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bd\u0001\u0000\u0000\u0000\u00bd\u00be\u0005\u001a\u0000\u0000\u00be"+
		"\u00bf\u0006\t\uffff\uffff\u0000\u00bf\u00c0\u0005\u000e\u0000\u0000\u00c0"+
		"\u00c1\u0006\t\uffff\uffff\u0000\u00c1\u00c2\u0005\u0017\u0000\u0000\u00c2"+
		"\u00c3\u0003\u0014\n\u0000\u00c3\u00c4\u0005\u0012\u0000\u0000\u00c4\u00c5"+
		"\u0006\t\uffff\uffff\u0000\u00c5\u00cd\u0003\u0014\n\u0000\u00c6\u00c7"+
		"\u0005\u0013\u0000\u0000\u00c7\u00c8\u0006\t\uffff\uffff\u0000\u00c8\u00c9"+
		"\u0003\u0014\n\u0000\u00c9\u00ca\u0005\u0012\u0000\u0000\u00ca\u00cb\u0006"+
		"\t\uffff\uffff\u0000\u00cb\u00cc\u0003\u0014\n\u0000\u00cc\u00ce\u0001"+
		"\u0000\u0000\u0000\u00cd\u00c6\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005"+
		"\u0018\u0000\u0000\u00d0\u00d1\u0006\t\uffff\uffff\u0000\u00d1\u00d2\u0005"+
		"\u001b\u0000\u0000\u00d2\u0013\u0001\u0000\u0000\u0000\u00d3\u00d4\u0003"+
		"\u0018\f\u0000\u00d4\u00d5\u0003\u0016\u000b\u0000\u00d5\u0015\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d7\u0005\u0010\u0000\u0000\u00d7\u00d8\u0006\u000b"+
		"\uffff\uffff\u0000\u00d8\u00da\u0003\u0018\f\u0000\u00d9\u00d6\u0001\u0000"+
		"\u0000\u0000\u00da\u00dd\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000"+
		"\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u0017\u0001\u0000"+
		"\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00de\u00df\u0003\u001c"+
		"\u000e\u0000\u00df\u00e0\u0006\f\uffff\uffff\u0000\u00e0\u00e1\u0003\u001a"+
		"\r\u0000\u00e1\u0019\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\u0011\u0000"+
		"\u0000\u00e3\u00e4\u0006\r\uffff\uffff\u0000\u00e4\u00e5\u0003\u001c\u000e"+
		"\u0000\u00e5\u00e6\u0006\r\uffff\uffff\u0000\u00e6\u00e8\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e2\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000"+
		"\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ea\u001b\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000"+
		"\u0000\u00ec\u00ed\u0005\u0015\u0000\u0000\u00ed\u00f5\u0006\u000e\uffff"+
		"\uffff\u0000\u00ee\u00ef\u0005\u0016\u0000\u0000\u00ef\u00f5\u0006\u000e"+
		"\uffff\uffff\u0000\u00f0\u00f1\u0005\u0017\u0000\u0000\u00f1\u00f2\u0003"+
		"\u0014\n\u0000\u00f2\u00f3\u0005\u0018\u0000\u0000\u00f3\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f4\u00ec\u0001\u0000\u0000\u0000\u00f4\u00ee\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f0\u0001\u0000\u0000\u0000\u00f5\u001d\u0001\u0000"+
		"\u0000\u0000\u0012%4=FN]k~\u0087\u0091\u0096\u00a8\u00b0\u00bb\u00cd\u00db"+
		"\u00e9\u00f4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}