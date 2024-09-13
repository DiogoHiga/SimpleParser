// Generated from c:/Users/diogo/OneDrive/Documentos/Compiladores/ProjetoFinal/SimpleParser/UFABCGrammar.g4 by ANTLR 4.13.1

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

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class UFABCGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, OP_SOM_SUB=15, OP_MULT_DIV=16, 
		OP_REL=17, OP_LOG=18, TXT=19, NUM=20, ID=21, AP=22, FP=23, AC=24, FC=25, 
		PV=26, WS=27;
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
			null, "'programa'", "'fimprog'", "'declare'", "'number'", "'text'", "','", 
			"'leia'", "'escreva'", "':='", "'se'", "'entao'", "'senao'", "'enquanto'", 
			"'execute'", null, null, null, null, null, null, null, "'('", "')'", 
			"'{'", "'}'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "OP_SOM_SUB", "OP_MULT_DIV", "OP_REL", "OP_LOG", "TXT", 
			"NUM", "ID", "AP", "FP", "AC", "FC", "PV", "WS"
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
			setState(50);
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
			default:
				throw new NoViableAltException(this);
			}
			setState(52);
			match(ID);
			 currentDecl.add(new Var(_input.LT(-1).getText())); 
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(54);
				match(T__5);
				setState(55);
				match(ID);
				 currentDecl.add(new Var(_input.LT(-1).getText())); 
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			updateTypes();
			setState(63);
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
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				cmd();
				}
				}
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2123136L) != 0) );
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
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmd);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				cmdLeitura();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				cmdEscrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				cmdAtr();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				cmdIF();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				cmdWhile();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
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
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__6);
			setState(79);
			match(AP);
			 program.setReadCommandUsed(true); 
			setState(81);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                        throw new UFABCSemanticException("Variável [" +(_input.LT(-1).getText()) + "] não declarada!");
			                    } 
			                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                    Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                    stack.peek().add(cmdRead);
			                    
			setState(83);
			match(FP);
			setState(84);
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
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__7);
			setState(87);
			match(AP);
			setState(91);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TXT:
				{
				setState(88);
				match(TXT);
				}
				break;
			case ID:
				{
				setState(89);
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
			setState(94);
			match(FP);
			setState(95);
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
	}

	public final CmdAtrContext cmdAtr() throws RecognitionException {
		CmdAtrContext _localctx = new CmdAtrContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdAtr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                        throw new UFABCSemanticException("Variável [" +(_input.LT(-1).getText()) + "] não declarada!");
			                    } 
			                    symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                    leftType = symbolTable.get(_input.LT(-1).getText()).getType();
			                    AttributionCommand cmdAtr = new AttributionCommand(symbolTable.get(_input.LT(-1).getText()));
			                    strExpr = "";
			                    rightType = null;
			                    
			setState(99);
			match(T__8);
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(100);
				expr();
				}
				break;
			case 2:
				{
				setState(101);
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
				setState(103);
				match(TXT);
				 rightType = Types.TEXT; 
				                      strExpr += _input.LT(-1).getText();
				                    
				}
				break;
			}
			setState(107);
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
	}

	public final CmdIFContext cmdIF() throws RecognitionException {
		CmdIFContext _localctx = new CmdIFContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdIF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__9);
			 stack.push(new ArrayList<Command>());
			                       strExpr = "";
			                       currentIfCommand = new IfCommand();
			                     
			setState(112);
			match(AP);
			setState(113);
			expr();
			setState(114);
			match(OP_REL);
			 strExpr += " " + _input.LT(-1).getText() + " "; 
			setState(116);
			expr();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_LOG) {
				{
				setState(117);
				match(OP_LOG);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(119);
				expr();
				setState(120);
				match(OP_REL);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(122);
				expr();
				}
			}

			setState(126);
			match(FP);
			 currentIfCommand.setExpression(strExpr); 
			setState(128);
			match(T__10);
			setState(129);
			match(AC);
			setState(131); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(130);
				cmd();
				}
				}
				setState(133); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2123136L) != 0) );
			setState(135);
			match(FC);
			 currentIfCommand.setTrueList(stack.pop()); 
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(137);
				match(T__11);
				 stack.push(new ArrayList<Command>()); 
				setState(139);
				match(AC);
				setState(141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(140);
					cmd();
					}
					}
					setState(143); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2123136L) != 0) );
				setState(145);
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
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(T__12);
			 stack.push(new ArrayList<Command>()); 
			                              strExpr = "";
			                              currentWhileCommand = new WhileCommand();
			                            
			setState(154);
			match(AP);
			setState(155);
			expr();
			setState(156);
			match(OP_REL);
			 strExpr += " " + _input.LT(-1).getText() + " "; 
			setState(158);
			expr();
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_LOG) {
				{
				setState(159);
				match(OP_LOG);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(161);
				expr();
				setState(162);
				match(OP_REL);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(164);
				expr();
				}
			}

			setState(168);
			match(FP);
			 currentWhileCommand.setExpr(strExpr); 
			setState(170);
			match(AC);
			setState(172); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(171);
				cmd();
				}
				}
				setState(174); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2123136L) != 0) );
			setState(176);
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
	}

	public final CmdDoWhileContext cmdDoWhile() throws RecognitionException {
		CmdDoWhileContext _localctx = new CmdDoWhileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdDoWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(T__13);
			 stack.push(new ArrayList<Command>()); 
			                              currentDoWhileCommand = new DoWhileCommand();
			                            
			setState(181);
			match(AC);
			setState(183); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(182);
				cmd();
				}
				}
				setState(185); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 2123136L) != 0) );
			setState(187);
			match(FC);
			 currentDoWhileCommand.setTrueList(stack.pop()); 
			setState(189);
			match(T__12);
			 str = ""; 
			setState(191);
			match(AP);
			setState(192);
			expr();
			setState(193);
			match(OP_REL);
			 strExpr += " " + _input.LT(-1).getText() + " "; 
			setState(195);
			expr();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_LOG) {
				{
				setState(196);
				match(OP_LOG);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(198);
				expr();
				setState(199);
				match(OP_REL);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(201);
				expr();
				}
			}

			setState(205);
			match(FP);
			 currentDoWhileCommand.setExpr(strExpr); 
			                      stack.peek().add(currentDoWhileCommand);
			                    
			setState(207);
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
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			termo();
			setState(210);
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
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_SOM_SUB) {
				{
				{
				setState(212);
				match(OP_SOM_SUB);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(214);
				termo();
				}
				}
				setState(219);
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
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_termo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			fator();
			 strExpr += _input.LT(-1).getText(); 
			setState(222);
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
	}

	public final TermolContext termol() throws RecognitionException {
		TermolContext _localctx = new TermolContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_MULT_DIV) {
				{
				{
				setState(224);
				match(OP_MULT_DIV);
				 strExpr += " " + _input.LT(-1).getText() + " "; 
				setState(226);
				fator();
				 strExpr += _input.LT(-1).getText(); 
				}
				}
				setState(233);
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
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fator);
		try {
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				match(NUM);
				   if (rightType == null) {
				                            rightType = Types.NUMBER;
				                        }

				                    
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
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
				setState(238);
				match(AP);
				setState(239);
				expr();
				setState(240);
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
		"\u0004\u0001\u001b\u00f5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000$\b\u0000\u000b"+
		"\u0000\f\u0000%\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u00013\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0005\u0001:\b\u0001\n\u0001\f\u0001=\t\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0004\u0002C\b\u0002\u000b"+
		"\u0002\f\u0002D\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003M\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\\\b"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006j\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007}\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0004\u0007\u0084\b\u0007\u000b\u0007\f"+
		"\u0007\u0085\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0004\u0007\u008e\b\u0007\u000b\u0007\f\u0007\u008f\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0095\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00a7\b\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0004\b\u00ad\b\b\u000b\b\f\b\u00ae\u0001\b"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u00b8\b\t\u000b"+
		"\t\f\t\u00b9\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u00cc\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00d8\b\u000b\n\u000b\f\u000b"+
		"\u00db\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0001\r\u0005\r\u00e6\b\r\n\r\f\r\u00e9\t\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u00f3\b\u000e\u0001\u000e\u0000\u0000\u000f\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u0000"+
		"\u0000\u00fd\u0000\u001e\u0001\u0000\u0000\u0000\u0002,\u0001\u0000\u0000"+
		"\u0000\u0004B\u0001\u0000\u0000\u0000\u0006L\u0001\u0000\u0000\u0000\b"+
		"N\u0001\u0000\u0000\u0000\nV\u0001\u0000\u0000\u0000\fa\u0001\u0000\u0000"+
		"\u0000\u000en\u0001\u0000\u0000\u0000\u0010\u0098\u0001\u0000\u0000\u0000"+
		"\u0012\u00b3\u0001\u0000\u0000\u0000\u0014\u00d1\u0001\u0000\u0000\u0000"+
		"\u0016\u00d9\u0001\u0000\u0000\u0000\u0018\u00dc\u0001\u0000\u0000\u0000"+
		"\u001a\u00e7\u0001\u0000\u0000\u0000\u001c\u00f2\u0001\u0000\u0000\u0000"+
		"\u001e\u001f\u0005\u0001\u0000\u0000\u001f \u0005\u0015\u0000\u0000 !"+
		"\u0006\u0000\uffff\uffff\u0000!#\u0005\u0018\u0000\u0000\"$\u0003\u0002"+
		"\u0001\u0000#\"\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000\u0000%#\u0001"+
		"\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000"+
		"\'(\u0003\u0004\u0002\u0000()\u0005\u0019\u0000\u0000)*\u0005\u0002\u0000"+
		"\u0000*+\u0006\u0000\uffff\uffff\u0000+\u0001\u0001\u0000\u0000\u0000"+
		",-\u0005\u0003\u0000\u0000-2\u0006\u0001\uffff\uffff\u0000./\u0005\u0004"+
		"\u0000\u0000/3\u0006\u0001\uffff\uffff\u000001\u0005\u0005\u0000\u0000"+
		"13\u0006\u0001\uffff\uffff\u00002.\u0001\u0000\u0000\u000020\u0001\u0000"+
		"\u0000\u000034\u0001\u0000\u0000\u000045\u0005\u0015\u0000\u00005;\u0006"+
		"\u0001\uffff\uffff\u000067\u0005\u0006\u0000\u000078\u0005\u0015\u0000"+
		"\u00008:\u0006\u0001\uffff\uffff\u000096\u0001\u0000\u0000\u0000:=\u0001"+
		"\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000"+
		"<>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0006\u0001\uffff"+
		"\uffff\u0000?@\u0005\u001a\u0000\u0000@\u0003\u0001\u0000\u0000\u0000"+
		"AC\u0003\u0006\u0003\u0000BA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000DB\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000E\u0005\u0001"+
		"\u0000\u0000\u0000FM\u0003\b\u0004\u0000GM\u0003\n\u0005\u0000HM\u0003"+
		"\f\u0006\u0000IM\u0003\u000e\u0007\u0000JM\u0003\u0010\b\u0000KM\u0003"+
		"\u0012\t\u0000LF\u0001\u0000\u0000\u0000LG\u0001\u0000\u0000\u0000LH\u0001"+
		"\u0000\u0000\u0000LI\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000"+
		"LK\u0001\u0000\u0000\u0000M\u0007\u0001\u0000\u0000\u0000NO\u0005\u0007"+
		"\u0000\u0000OP\u0005\u0016\u0000\u0000PQ\u0006\u0004\uffff\uffff\u0000"+
		"QR\u0005\u0015\u0000\u0000RS\u0006\u0004\uffff\uffff\u0000ST\u0005\u0017"+
		"\u0000\u0000TU\u0005\u001a\u0000\u0000U\t\u0001\u0000\u0000\u0000VW\u0005"+
		"\b\u0000\u0000W[\u0005\u0016\u0000\u0000X\\\u0005\u0013\u0000\u0000YZ"+
		"\u0005\u0015\u0000\u0000Z\\\u0006\u0005\uffff\uffff\u0000[X\u0001\u0000"+
		"\u0000\u0000[Y\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0006"+
		"\u0005\uffff\uffff\u0000^_\u0005\u0017\u0000\u0000_`\u0005\u001a\u0000"+
		"\u0000`\u000b\u0001\u0000\u0000\u0000ab\u0005\u0015\u0000\u0000bc\u0006"+
		"\u0006\uffff\uffff\u0000ci\u0005\t\u0000\u0000dj\u0003\u0014\n\u0000e"+
		"f\u0005\u0015\u0000\u0000fj\u0006\u0006\uffff\uffff\u0000gh\u0005\u0013"+
		"\u0000\u0000hj\u0006\u0006\uffff\uffff\u0000id\u0001\u0000\u0000\u0000"+
		"ie\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000kl\u0005\u001a\u0000\u0000lm\u0006\u0006\uffff\uffff\u0000m\r\u0001"+
		"\u0000\u0000\u0000no\u0005\n\u0000\u0000op\u0006\u0007\uffff\uffff\u0000"+
		"pq\u0005\u0016\u0000\u0000qr\u0003\u0014\n\u0000rs\u0005\u0011\u0000\u0000"+
		"st\u0006\u0007\uffff\uffff\u0000t|\u0003\u0014\n\u0000uv\u0005\u0012\u0000"+
		"\u0000vw\u0006\u0007\uffff\uffff\u0000wx\u0003\u0014\n\u0000xy\u0005\u0011"+
		"\u0000\u0000yz\u0006\u0007\uffff\uffff\u0000z{\u0003\u0014\n\u0000{}\u0001"+
		"\u0000\u0000\u0000|u\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}~\u0001\u0000\u0000\u0000~\u007f\u0005\u0017\u0000\u0000\u007f\u0080"+
		"\u0006\u0007\uffff\uffff\u0000\u0080\u0081\u0005\u000b\u0000\u0000\u0081"+
		"\u0083\u0005\u0018\u0000\u0000\u0082\u0084\u0003\u0006\u0003\u0000\u0083"+
		"\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086"+
		"\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0019\u0000\u0000\u0088"+
		"\u0094\u0006\u0007\uffff\uffff\u0000\u0089\u008a\u0005\f\u0000\u0000\u008a"+
		"\u008b\u0006\u0007\uffff\uffff\u0000\u008b\u008d\u0005\u0018\u0000\u0000"+
		"\u008c\u008e\u0003\u0006\u0003\u0000\u008d\u008c\u0001\u0000\u0000\u0000"+
		"\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0005\u0019\u0000\u0000\u0092\u0093\u0006\u0007\uffff\uffff"+
		"\u0000\u0093\u0095\u0001\u0000\u0000\u0000\u0094\u0089\u0001\u0000\u0000"+
		"\u0000\u0094\u0095\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0006\u0007\uffff\uffff\u0000\u0097\u000f\u0001\u0000"+
		"\u0000\u0000\u0098\u0099\u0005\r\u0000\u0000\u0099\u009a\u0006\b\uffff"+
		"\uffff\u0000\u009a\u009b\u0005\u0016\u0000\u0000\u009b\u009c\u0003\u0014"+
		"\n\u0000\u009c\u009d\u0005\u0011\u0000\u0000\u009d\u009e\u0006\b\uffff"+
		"\uffff\u0000\u009e\u00a6\u0003\u0014\n\u0000\u009f\u00a0\u0005\u0012\u0000"+
		"\u0000\u00a0\u00a1\u0006\b\uffff\uffff\u0000\u00a1\u00a2\u0003\u0014\n"+
		"\u0000\u00a2\u00a3\u0005\u0011\u0000\u0000\u00a3\u00a4\u0006\b\uffff\uffff"+
		"\u0000\u00a4\u00a5\u0003\u0014\n\u0000\u00a5\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a6\u009f\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\u0017\u0000\u0000"+
		"\u00a9\u00aa\u0006\b\uffff\uffff\u0000\u00aa\u00ac\u0005\u0018\u0000\u0000"+
		"\u00ab\u00ad\u0003\u0006\u0003\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b1\u0005\u0019\u0000\u0000\u00b1\u00b2\u0006\b\uffff\uffff\u0000"+
		"\u00b2\u0011\u0001\u0000\u0000\u0000\u00b3\u00b4\u0005\u000e\u0000\u0000"+
		"\u00b4\u00b5\u0006\t\uffff\uffff\u0000\u00b5\u00b7\u0005\u0018\u0000\u0000"+
		"\u00b6\u00b8\u0003\u0006\u0003\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bc\u0005\u0019\u0000\u0000\u00bc\u00bd\u0006\t\uffff\uffff\u0000"+
		"\u00bd\u00be\u0005\r\u0000\u0000\u00be\u00bf\u0006\t\uffff\uffff\u0000"+
		"\u00bf\u00c0\u0005\u0016\u0000\u0000\u00c0\u00c1\u0003\u0014\n\u0000\u00c1"+
		"\u00c2\u0005\u0011\u0000\u0000\u00c2\u00c3\u0006\t\uffff\uffff\u0000\u00c3"+
		"\u00cb\u0003\u0014\n\u0000\u00c4\u00c5\u0005\u0012\u0000\u0000\u00c5\u00c6"+
		"\u0006\t\uffff\uffff\u0000\u00c6\u00c7\u0003\u0014\n\u0000\u00c7\u00c8"+
		"\u0005\u0011\u0000\u0000\u00c8\u00c9\u0006\t\uffff\uffff\u0000\u00c9\u00ca"+
		"\u0003\u0014\n\u0000\u00ca\u00cc\u0001\u0000\u0000\u0000\u00cb\u00c4\u0001"+
		"\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cd\u00ce\u0005\u0017\u0000\u0000\u00ce\u00cf\u0006"+
		"\t\uffff\uffff\u0000\u00cf\u00d0\u0005\u001a\u0000\u0000\u00d0\u0013\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d2\u0003\u0018\f\u0000\u00d2\u00d3\u0003\u0016"+
		"\u000b\u0000\u00d3\u0015\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\u000f"+
		"\u0000\u0000\u00d5\u00d6\u0006\u000b\uffff\uffff\u0000\u00d6\u00d8\u0003"+
		"\u0018\f\u0000\u00d7\u00d4\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000"+
		"\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000"+
		"\u0000\u0000\u00da\u0017\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000"+
		"\u0000\u0000\u00dc\u00dd\u0003\u001c\u000e\u0000\u00dd\u00de\u0006\f\uffff"+
		"\uffff\u0000\u00de\u00df\u0003\u001a\r\u0000\u00df\u0019\u0001\u0000\u0000"+
		"\u0000\u00e0\u00e1\u0005\u0010\u0000\u0000\u00e1\u00e2\u0006\r\uffff\uffff"+
		"\u0000\u00e2\u00e3\u0003\u001c\u000e\u0000\u00e3\u00e4\u0006\r\uffff\uffff"+
		"\u0000\u00e4\u00e6\u0001\u0000\u0000\u0000\u00e5\u00e0\u0001\u0000\u0000"+
		"\u0000\u00e6\u00e9\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000"+
		"\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8\u001b\u0001\u0000\u0000"+
		"\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00ea\u00eb\u0005\u0014\u0000"+
		"\u0000\u00eb\u00f3\u0006\u000e\uffff\uffff\u0000\u00ec\u00ed\u0005\u0015"+
		"\u0000\u0000\u00ed\u00f3\u0006\u000e\uffff\uffff\u0000\u00ee\u00ef\u0005"+
		"\u0016\u0000\u0000\u00ef\u00f0\u0003\u0014\n\u0000\u00f0\u00f1\u0005\u0017"+
		"\u0000\u0000\u00f1\u00f3\u0001\u0000\u0000\u0000\u00f2\u00ea\u0001\u0000"+
		"\u0000\u0000\u00f2\u00ec\u0001\u0000\u0000\u0000\u00f2\u00ee\u0001\u0000"+
		"\u0000\u0000\u00f3\u001d\u0001\u0000\u0000\u0000\u0012%2;DL[i|\u0085\u008f"+
		"\u0094\u00a6\u00ae\u00b9\u00cb\u00d9\u00e7\u00f2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}