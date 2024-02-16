// $ANTLR 3.5.2 ValueEvaluatorTree.g 2024-02-12 13:09:12

  package wrimsv2.evaluator;
    
  import org.antlr.runtime.ANTLRFileStream;
  import org.antlr.runtime.CharStream;
  import org.antlr.runtime.CommonTokenStream;
  import org.antlr.runtime.RecognitionException;
  import org.antlr.runtime.TokenStream;
  
  import java.util.HashMap;
  import wrimsv2.components.Error;
  import wrimsv2.components.IntDouble;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class ValueEvaluatorTreeParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ABS", "ALWAYS", "BACKSLASH", 
		"CASE", "COMMENT", "CONDITION", "CONSTRAIN", "CONVERTUNITS", "CYCLE", 
		"DAYSIN", "DIGIT", "DVAR", "EXP", "EXPRESSION", "FILE", "FLOAT", "FROM", 
		"FROM_WRESL_FILE", "FUNCTION", "GIVEN", "IDENT", "IDENT1", "IDENT2", "INCLUDE", 
		"INT", "INTEGER", "INTEGERTYPE", "LETTER", "LHSGTRHS", "LHSLTRHS", "LOG", 
		"LOG10", "LOWERBOUND", "LOWERUNBOUNDED", "MAX", "MIN", "MOD", "MONTH", 
		"MONTH_CONST", "MULTILINE_COMMENT", "NAME", "ORDER", "OUTPUT", "PASTMONTH", 
		"POW", "RANGE", "REAL", "SELECT", "SUM", "SVAR", "SYMBOLS", "TAFCFS", 
		"TIMESERIES", "TYPE", "UNARY", "UNITS", "UPPERBOUND", "UPPERUNBOUNDED", 
		"USE", "WEIGHT", "WHERE", "WS", "YEAR", "'('", "')'", "'*'", "'+'", "'-'", 
		"'.'", "'.and.'", "'.or.'", "'/'", "':'", "';'", "'<'", "'<='", "'='", 
		"'=='", "'>'", "'>='", "'['", "']'", "'c:'", "'v:'", "'|'"
	};
	public static final int EOF=-1;
	public static final int T__67=67;
	public static final int T__68=68;
	public static final int T__69=69;
	public static final int T__70=70;
	public static final int T__71=71;
	public static final int T__72=72;
	public static final int T__73=73;
	public static final int T__74=74;
	public static final int T__75=75;
	public static final int T__76=76;
	public static final int T__77=77;
	public static final int T__78=78;
	public static final int T__79=79;
	public static final int T__80=80;
	public static final int T__81=81;
	public static final int T__82=82;
	public static final int T__83=83;
	public static final int T__84=84;
	public static final int T__85=85;
	public static final int T__86=86;
	public static final int T__87=87;
	public static final int T__88=88;
	public static final int ABS=4;
	public static final int ALWAYS=5;
	public static final int BACKSLASH=6;
	public static final int CASE=7;
	public static final int COMMENT=8;
	public static final int CONDITION=9;
	public static final int CONSTRAIN=10;
	public static final int CONVERTUNITS=11;
	public static final int CYCLE=12;
	public static final int DAYSIN=13;
	public static final int DIGIT=14;
	public static final int DVAR=15;
	public static final int EXP=16;
	public static final int EXPRESSION=17;
	public static final int FILE=18;
	public static final int FLOAT=19;
	public static final int FROM=20;
	public static final int FROM_WRESL_FILE=21;
	public static final int FUNCTION=22;
	public static final int GIVEN=23;
	public static final int IDENT=24;
	public static final int IDENT1=25;
	public static final int IDENT2=26;
	public static final int INCLUDE=27;
	public static final int INT=28;
	public static final int INTEGER=29;
	public static final int INTEGERTYPE=30;
	public static final int LETTER=31;
	public static final int LHSGTRHS=32;
	public static final int LHSLTRHS=33;
	public static final int LOG=34;
	public static final int LOG10=35;
	public static final int LOWERBOUND=36;
	public static final int LOWERUNBOUNDED=37;
	public static final int MAX=38;
	public static final int MIN=39;
	public static final int MOD=40;
	public static final int MONTH=41;
	public static final int MONTH_CONST=42;
	public static final int MULTILINE_COMMENT=43;
	public static final int NAME=44;
	public static final int ORDER=45;
	public static final int OUTPUT=46;
	public static final int PASTMONTH=47;
	public static final int POW=48;
	public static final int RANGE=49;
	public static final int REAL=50;
	public static final int SELECT=51;
	public static final int SUM=52;
	public static final int SVAR=53;
	public static final int SYMBOLS=54;
	public static final int TAFCFS=55;
	public static final int TIMESERIES=56;
	public static final int TYPE=57;
	public static final int UNARY=58;
	public static final int UNITS=59;
	public static final int UPPERBOUND=60;
	public static final int UPPERUNBOUNDED=61;
	public static final int USE=62;
	public static final int WEIGHT=63;
	public static final int WHERE=64;
	public static final int WS=65;
	public static final int YEAR=66;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ValueEvaluatorTreeParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ValueEvaluatorTreeParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return ValueEvaluatorTreeParser.tokenNames; }
	@Override public String getGrammarFileName() { return "ValueEvaluatorTree.g"; }


	 
	  @Override
	  public void reportError(RecognitionException e) {
	       Error.addEvaluationError(getErrorMessage(e, tokenNames));
	  }


	public static class evaluator_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "evaluator"
	// ValueEvaluatorTree.g:35:1: evaluator : ( expressionInput | conditionInput );
	public final ValueEvaluatorTreeParser.evaluator_return evaluator() throws RecognitionException {
		ValueEvaluatorTreeParser.evaluator_return retval = new ValueEvaluatorTreeParser.evaluator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expressionInput1 =null;
		ParserRuleReturnScope conditionInput2 =null;


		try {
			// ValueEvaluatorTree.g:36:2: ( expressionInput | conditionInput )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==87) ) {
				alt1=1;
			}
			else if ( (LA1_0==86) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// ValueEvaluatorTree.g:36:4: expressionInput
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_expressionInput_in_evaluator61);
					expressionInput1=expressionInput();
					state._fsp--;

					adaptor.addChild(root_0, expressionInput1.getTree());

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:37:3: conditionInput
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_conditionInput_in_evaluator67);
					conditionInput2=conditionInput();
					state._fsp--;

					adaptor.addChild(root_0, conditionInput2.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "evaluator"


	public static class expressionInput_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expressionInput"
	// ValueEvaluatorTree.g:44:1: expressionInput : 'v:' expressionCollection -> ^( 'v:' expressionCollection ) ;
	public final ValueEvaluatorTreeParser.expressionInput_return expressionInput() throws RecognitionException {
		ValueEvaluatorTreeParser.expressionInput_return retval = new ValueEvaluatorTreeParser.expressionInput_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal3=null;
		ParserRuleReturnScope expressionCollection4 =null;

		CommonTree string_literal3_tree=null;
		RewriteRuleTokenStream stream_87=new RewriteRuleTokenStream(adaptor,"token 87");
		RewriteRuleSubtreeStream stream_expressionCollection=new RewriteRuleSubtreeStream(adaptor,"rule expressionCollection");

		try {
			// ValueEvaluatorTree.g:44:16: ( 'v:' expressionCollection -> ^( 'v:' expressionCollection ) )
			// ValueEvaluatorTree.g:44:18: 'v:' expressionCollection
			{
			string_literal3=(Token)match(input,87,FOLLOW_87_in_expressionInput81);  
			stream_87.add(string_literal3);

			pushFollow(FOLLOW_expressionCollection_in_expressionInput83);
			expressionCollection4=expressionCollection();
			state._fsp--;

			stream_expressionCollection.add(expressionCollection4.getTree());
			// AST REWRITE
			// elements: 87, expressionCollection
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 44:43: -> ^( 'v:' expressionCollection )
			{
				// ValueEvaluatorTree.g:44:46: ^( 'v:' expressionCollection )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_87.nextNode(), root_1);
				adaptor.addChild(root_1, stream_expressionCollection.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expressionInput"


	public static class conditionInput_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "conditionInput"
	// ValueEvaluatorTree.g:45:1: conditionInput : 'c:' conditionStatement -> ^( 'c:' conditionStatement ) ;
	public final ValueEvaluatorTreeParser.conditionInput_return conditionInput() throws RecognitionException {
		ValueEvaluatorTreeParser.conditionInput_return retval = new ValueEvaluatorTreeParser.conditionInput_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal5=null;
		ParserRuleReturnScope conditionStatement6 =null;

		CommonTree string_literal5_tree=null;
		RewriteRuleTokenStream stream_86=new RewriteRuleTokenStream(adaptor,"token 86");
		RewriteRuleSubtreeStream stream_conditionStatement=new RewriteRuleSubtreeStream(adaptor,"rule conditionStatement");

		try {
			// ValueEvaluatorTree.g:45:15: ( 'c:' conditionStatement -> ^( 'c:' conditionStatement ) )
			// ValueEvaluatorTree.g:45:17: 'c:' conditionStatement
			{
			string_literal5=(Token)match(input,86,FOLLOW_86_in_conditionInput96);  
			stream_86.add(string_literal5);

			pushFollow(FOLLOW_conditionStatement_in_conditionInput98);
			conditionStatement6=conditionStatement();
			state._fsp--;

			stream_conditionStatement.add(conditionStatement6.getTree());
			// AST REWRITE
			// elements: 86, conditionStatement
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 45:40: -> ^( 'c:' conditionStatement )
			{
				// ValueEvaluatorTree.g:45:43: ^( 'c:' conditionStatement )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_86.nextNode(), root_1);
				adaptor.addChild(root_1, stream_conditionStatement.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "conditionInput"


	public static class lhsrhs_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lhsrhs"
	// ValueEvaluatorTree.g:50:1: lhsrhs : ( expression | CONSTRAIN );
	public final ValueEvaluatorTreeParser.lhsrhs_return lhsrhs() throws RecognitionException {
		ValueEvaluatorTreeParser.lhsrhs_return retval = new ValueEvaluatorTreeParser.lhsrhs_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token CONSTRAIN8=null;
		ParserRuleReturnScope expression7 =null;

		CommonTree CONSTRAIN8_tree=null;

		try {
			// ValueEvaluatorTree.g:50:7: ( expression | CONSTRAIN )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ABS||LA2_0==DAYSIN||LA2_0==EXP||LA2_0==FLOAT||LA2_0==IDENT||(LA2_0 >= INT && LA2_0 <= INTEGER)||(LA2_0 >= LOG && LA2_0 <= LOG10)||(LA2_0 >= MAX && LA2_0 <= MIN)||(LA2_0 >= MONTH && LA2_0 <= MONTH_CONST)||(LA2_0 >= PASTMONTH && LA2_0 <= POW)||LA2_0==REAL||LA2_0==SVAR||LA2_0==TAFCFS||(LA2_0 >= YEAR && LA2_0 <= 67)||LA2_0==71) ) {
				alt2=1;
			}
			else if ( (LA2_0==CONSTRAIN) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// ValueEvaluatorTree.g:50:9: expression
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_expression_in_lhsrhs115);
					expression7=expression();
					state._fsp--;

					adaptor.addChild(root_0, expression7.getTree());

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:50:20: CONSTRAIN
					{
					root_0 = (CommonTree)adaptor.nil();


					CONSTRAIN8=(Token)match(input,CONSTRAIN,FOLLOW_CONSTRAIN_in_lhsrhs117); 
					CONSTRAIN8_tree = (CommonTree)adaptor.create(CONSTRAIN8);
					adaptor.addChild(root_0, CONSTRAIN8_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "lhsrhs"


	public static class units_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "units"
	// ValueEvaluatorTree.g:54:1: units : ( IDENT | ( IDENT '/' IDENT ) );
	public final ValueEvaluatorTreeParser.units_return units() throws RecognitionException {
		ValueEvaluatorTreeParser.units_return retval = new ValueEvaluatorTreeParser.units_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT9=null;
		Token IDENT10=null;
		Token char_literal11=null;
		Token IDENT12=null;

		CommonTree IDENT9_tree=null;
		CommonTree IDENT10_tree=null;
		CommonTree char_literal11_tree=null;
		CommonTree IDENT12_tree=null;

		try {
			// ValueEvaluatorTree.g:54:6: ( IDENT | ( IDENT '/' IDENT ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==IDENT) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==75) ) {
					alt3=2;
				}
				else if ( (LA3_1==EOF) ) {
					alt3=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// ValueEvaluatorTree.g:54:8: IDENT
					{
					root_0 = (CommonTree)adaptor.nil();


					IDENT9=(Token)match(input,IDENT,FOLLOW_IDENT_in_units126); 
					IDENT9_tree = (CommonTree)adaptor.create(IDENT9);
					adaptor.addChild(root_0, IDENT9_tree);

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:54:14: ( IDENT '/' IDENT )
					{
					root_0 = (CommonTree)adaptor.nil();


					// ValueEvaluatorTree.g:54:14: ( IDENT '/' IDENT )
					// ValueEvaluatorTree.g:54:15: IDENT '/' IDENT
					{
					IDENT10=(Token)match(input,IDENT,FOLLOW_IDENT_in_units129); 
					IDENT10_tree = (CommonTree)adaptor.create(IDENT10);
					adaptor.addChild(root_0, IDENT10_tree);

					char_literal11=(Token)match(input,75,FOLLOW_75_in_units131); 
					char_literal11_tree = (CommonTree)adaptor.create(char_literal11);
					adaptor.addChild(root_0, char_literal11_tree);

					IDENT12=(Token)match(input,IDENT,FOLLOW_IDENT_in_units133); 
					IDENT12_tree = (CommonTree)adaptor.create(IDENT12);
					adaptor.addChild(root_0, IDENT12_tree);

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "units"


	public static class fileName_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "fileName"
	// ValueEvaluatorTree.g:56:1: fileName : ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+ ;
	public final ValueEvaluatorTreeParser.fileName_return fileName() throws RecognitionException {
		ValueEvaluatorTreeParser.fileName_return retval = new ValueEvaluatorTreeParser.fileName_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal13=null;
		Token char_literal14=null;
		Token char_literal15=null;
		Token char_literal16=null;
		Token SYMBOLS17=null;
		Token char_literal18=null;
		Token char_literal19=null;
		Token BACKSLASH20=null;
		Token IDENT21=null;
		Token IDENT122=null;
		Token IDENT223=null;
		Token INTEGER24=null;
		Token FLOAT25=null;
		ParserRuleReturnScope usedKeywords26 =null;

		CommonTree char_literal13_tree=null;
		CommonTree char_literal14_tree=null;
		CommonTree char_literal15_tree=null;
		CommonTree char_literal16_tree=null;
		CommonTree SYMBOLS17_tree=null;
		CommonTree char_literal18_tree=null;
		CommonTree char_literal19_tree=null;
		CommonTree BACKSLASH20_tree=null;
		CommonTree IDENT21_tree=null;
		CommonTree IDENT122_tree=null;
		CommonTree IDENT223_tree=null;
		CommonTree INTEGER24_tree=null;
		CommonTree FLOAT25_tree=null;

		try {
			// ValueEvaluatorTree.g:57:3: ( ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+ )
			// ValueEvaluatorTree.g:57:5: ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// ValueEvaluatorTree.g:57:5: ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=15;
				switch ( input.LA(1) ) {
				case 76:
					{
					alt4=1;
					}
					break;
				case 77:
					{
					alt4=2;
					}
					break;
				case 72:
					{
					alt4=3;
					}
					break;
				case 88:
					{
					alt4=4;
					}
					break;
				case SYMBOLS:
					{
					alt4=5;
					}
					break;
				case 71:
					{
					alt4=6;
					}
					break;
				case 70:
					{
					alt4=7;
					}
					break;
				case BACKSLASH:
					{
					alt4=8;
					}
					break;
				case IDENT:
					{
					alt4=9;
					}
					break;
				case IDENT1:
					{
					alt4=10;
					}
					break;
				case IDENT2:
					{
					alt4=11;
					}
					break;
				case INTEGER:
					{
					alt4=12;
					}
					break;
				case FLOAT:
					{
					alt4=13;
					}
					break;
				case ABS:
				case ALWAYS:
				case CASE:
				case CONDITION:
				case CONSTRAIN:
				case CONVERTUNITS:
				case CYCLE:
				case DAYSIN:
				case DVAR:
				case EXP:
				case EXPRESSION:
				case FILE:
				case FROM:
				case FROM_WRESL_FILE:
				case FUNCTION:
				case GIVEN:
				case INCLUDE:
				case INT:
				case INTEGERTYPE:
				case LHSGTRHS:
				case LHSLTRHS:
				case LOG:
				case LOG10:
				case LOWERBOUND:
				case LOWERUNBOUNDED:
				case MAX:
				case MIN:
				case MOD:
				case MONTH:
				case MONTH_CONST:
				case NAME:
				case ORDER:
				case OUTPUT:
				case PASTMONTH:
				case POW:
				case RANGE:
				case REAL:
				case SELECT:
				case SUM:
				case TAFCFS:
				case TIMESERIES:
				case TYPE:
				case UNARY:
				case UNITS:
				case UPPERBOUND:
				case UPPERUNBOUNDED:
				case USE:
				case WEIGHT:
				case WHERE:
				case YEAR:
					{
					alt4=14;
					}
					break;
				}
				switch (alt4) {
				case 1 :
					// ValueEvaluatorTree.g:57:6: ':'
					{
					char_literal13=(Token)match(input,76,FOLLOW_76_in_fileName145); 
					char_literal13_tree = (CommonTree)adaptor.create(char_literal13);
					adaptor.addChild(root_0, char_literal13_tree);

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:57:10: ';'
					{
					char_literal14=(Token)match(input,77,FOLLOW_77_in_fileName147); 
					char_literal14_tree = (CommonTree)adaptor.create(char_literal14);
					adaptor.addChild(root_0, char_literal14_tree);

					}
					break;
				case 3 :
					// ValueEvaluatorTree.g:57:14: '.'
					{
					char_literal15=(Token)match(input,72,FOLLOW_72_in_fileName149); 
					char_literal15_tree = (CommonTree)adaptor.create(char_literal15);
					adaptor.addChild(root_0, char_literal15_tree);

					}
					break;
				case 4 :
					// ValueEvaluatorTree.g:57:18: '|'
					{
					char_literal16=(Token)match(input,88,FOLLOW_88_in_fileName151); 
					char_literal16_tree = (CommonTree)adaptor.create(char_literal16);
					adaptor.addChild(root_0, char_literal16_tree);

					}
					break;
				case 5 :
					// ValueEvaluatorTree.g:57:22: SYMBOLS
					{
					SYMBOLS17=(Token)match(input,SYMBOLS,FOLLOW_SYMBOLS_in_fileName153); 
					SYMBOLS17_tree = (CommonTree)adaptor.create(SYMBOLS17);
					adaptor.addChild(root_0, SYMBOLS17_tree);

					}
					break;
				case 6 :
					// ValueEvaluatorTree.g:57:30: '-'
					{
					char_literal18=(Token)match(input,71,FOLLOW_71_in_fileName155); 
					char_literal18_tree = (CommonTree)adaptor.create(char_literal18);
					adaptor.addChild(root_0, char_literal18_tree);

					}
					break;
				case 7 :
					// ValueEvaluatorTree.g:57:34: '+'
					{
					char_literal19=(Token)match(input,70,FOLLOW_70_in_fileName157); 
					char_literal19_tree = (CommonTree)adaptor.create(char_literal19);
					adaptor.addChild(root_0, char_literal19_tree);

					}
					break;
				case 8 :
					// ValueEvaluatorTree.g:57:38: BACKSLASH
					{
					BACKSLASH20=(Token)match(input,BACKSLASH,FOLLOW_BACKSLASH_in_fileName159); 
					BACKSLASH20_tree = (CommonTree)adaptor.create(BACKSLASH20);
					adaptor.addChild(root_0, BACKSLASH20_tree);

					}
					break;
				case 9 :
					// ValueEvaluatorTree.g:57:48: IDENT
					{
					IDENT21=(Token)match(input,IDENT,FOLLOW_IDENT_in_fileName161); 
					IDENT21_tree = (CommonTree)adaptor.create(IDENT21);
					adaptor.addChild(root_0, IDENT21_tree);

					}
					break;
				case 10 :
					// ValueEvaluatorTree.g:57:54: IDENT1
					{
					IDENT122=(Token)match(input,IDENT1,FOLLOW_IDENT1_in_fileName163); 
					IDENT122_tree = (CommonTree)adaptor.create(IDENT122);
					adaptor.addChild(root_0, IDENT122_tree);

					}
					break;
				case 11 :
					// ValueEvaluatorTree.g:57:61: IDENT2
					{
					IDENT223=(Token)match(input,IDENT2,FOLLOW_IDENT2_in_fileName165); 
					IDENT223_tree = (CommonTree)adaptor.create(IDENT223);
					adaptor.addChild(root_0, IDENT223_tree);

					}
					break;
				case 12 :
					// ValueEvaluatorTree.g:57:68: INTEGER
					{
					INTEGER24=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_fileName167); 
					INTEGER24_tree = (CommonTree)adaptor.create(INTEGER24);
					adaptor.addChild(root_0, INTEGER24_tree);

					}
					break;
				case 13 :
					// ValueEvaluatorTree.g:57:76: FLOAT
					{
					FLOAT25=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_fileName169); 
					FLOAT25_tree = (CommonTree)adaptor.create(FLOAT25);
					adaptor.addChild(root_0, FLOAT25_tree);

					}
					break;
				case 14 :
					// ValueEvaluatorTree.g:57:82: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_fileName171);
					usedKeywords26=usedKeywords();
					state._fsp--;

					adaptor.addChild(root_0, usedKeywords26.getTree());

					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}


			  
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "fileName"


	public static class externalFile_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "externalFile"
	// ValueEvaluatorTree.g:61:1: externalFile : ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+ ;
	public final ValueEvaluatorTreeParser.externalFile_return externalFile() throws RecognitionException {
		ValueEvaluatorTreeParser.externalFile_return retval = new ValueEvaluatorTreeParser.externalFile_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal27=null;
		Token char_literal28=null;
		Token char_literal29=null;
		Token SYMBOLS30=null;
		Token char_literal31=null;
		Token char_literal32=null;
		Token INTEGER33=null;
		Token FLOAT34=null;
		Token IDENT35=null;
		ParserRuleReturnScope usedKeywords36 =null;

		CommonTree char_literal27_tree=null;
		CommonTree char_literal28_tree=null;
		CommonTree char_literal29_tree=null;
		CommonTree SYMBOLS30_tree=null;
		CommonTree char_literal31_tree=null;
		CommonTree char_literal32_tree=null;
		CommonTree INTEGER33_tree=null;
		CommonTree FLOAT34_tree=null;
		CommonTree IDENT35_tree=null;

		try {
			// ValueEvaluatorTree.g:62:3: ( ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+ )
			// ValueEvaluatorTree.g:62:5: ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// ValueEvaluatorTree.g:62:5: ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=11;
				switch ( input.LA(1) ) {
				case 77:
					{
					alt5=1;
					}
					break;
				case 72:
					{
					alt5=2;
					}
					break;
				case 88:
					{
					alt5=3;
					}
					break;
				case SYMBOLS:
					{
					alt5=4;
					}
					break;
				case 71:
					{
					alt5=5;
					}
					break;
				case 70:
					{
					alt5=6;
					}
					break;
				case INTEGER:
					{
					alt5=7;
					}
					break;
				case FLOAT:
					{
					alt5=8;
					}
					break;
				case IDENT:
					{
					alt5=9;
					}
					break;
				case ABS:
				case ALWAYS:
				case CASE:
				case CONDITION:
				case CONSTRAIN:
				case CONVERTUNITS:
				case CYCLE:
				case DAYSIN:
				case DVAR:
				case EXP:
				case EXPRESSION:
				case FILE:
				case FROM:
				case FROM_WRESL_FILE:
				case FUNCTION:
				case GIVEN:
				case INCLUDE:
				case INT:
				case INTEGERTYPE:
				case LHSGTRHS:
				case LHSLTRHS:
				case LOG:
				case LOG10:
				case LOWERBOUND:
				case LOWERUNBOUNDED:
				case MAX:
				case MIN:
				case MOD:
				case MONTH:
				case MONTH_CONST:
				case NAME:
				case ORDER:
				case OUTPUT:
				case PASTMONTH:
				case POW:
				case RANGE:
				case REAL:
				case SELECT:
				case SUM:
				case TAFCFS:
				case TIMESERIES:
				case TYPE:
				case UNARY:
				case UNITS:
				case UPPERBOUND:
				case UPPERUNBOUNDED:
				case USE:
				case WEIGHT:
				case WHERE:
				case YEAR:
					{
					alt5=10;
					}
					break;
				}
				switch (alt5) {
				case 1 :
					// ValueEvaluatorTree.g:62:6: ';'
					{
					char_literal27=(Token)match(input,77,FOLLOW_77_in_externalFile190); 
					char_literal27_tree = (CommonTree)adaptor.create(char_literal27);
					adaptor.addChild(root_0, char_literal27_tree);

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:62:10: '.'
					{
					char_literal28=(Token)match(input,72,FOLLOW_72_in_externalFile192); 
					char_literal28_tree = (CommonTree)adaptor.create(char_literal28);
					adaptor.addChild(root_0, char_literal28_tree);

					}
					break;
				case 3 :
					// ValueEvaluatorTree.g:62:14: '|'
					{
					char_literal29=(Token)match(input,88,FOLLOW_88_in_externalFile194); 
					char_literal29_tree = (CommonTree)adaptor.create(char_literal29);
					adaptor.addChild(root_0, char_literal29_tree);

					}
					break;
				case 4 :
					// ValueEvaluatorTree.g:62:18: SYMBOLS
					{
					SYMBOLS30=(Token)match(input,SYMBOLS,FOLLOW_SYMBOLS_in_externalFile196); 
					SYMBOLS30_tree = (CommonTree)adaptor.create(SYMBOLS30);
					adaptor.addChild(root_0, SYMBOLS30_tree);

					}
					break;
				case 5 :
					// ValueEvaluatorTree.g:62:26: '-'
					{
					char_literal31=(Token)match(input,71,FOLLOW_71_in_externalFile198); 
					char_literal31_tree = (CommonTree)adaptor.create(char_literal31);
					adaptor.addChild(root_0, char_literal31_tree);

					}
					break;
				case 6 :
					// ValueEvaluatorTree.g:62:30: '+'
					{
					char_literal32=(Token)match(input,70,FOLLOW_70_in_externalFile200); 
					char_literal32_tree = (CommonTree)adaptor.create(char_literal32);
					adaptor.addChild(root_0, char_literal32_tree);

					}
					break;
				case 7 :
					// ValueEvaluatorTree.g:62:34: INTEGER
					{
					INTEGER33=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_externalFile202); 
					INTEGER33_tree = (CommonTree)adaptor.create(INTEGER33);
					adaptor.addChild(root_0, INTEGER33_tree);

					}
					break;
				case 8 :
					// ValueEvaluatorTree.g:62:42: FLOAT
					{
					FLOAT34=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_externalFile204); 
					FLOAT34_tree = (CommonTree)adaptor.create(FLOAT34);
					adaptor.addChild(root_0, FLOAT34_tree);

					}
					break;
				case 9 :
					// ValueEvaluatorTree.g:62:48: IDENT
					{
					IDENT35=(Token)match(input,IDENT,FOLLOW_IDENT_in_externalFile206); 
					IDENT35_tree = (CommonTree)adaptor.create(IDENT35);
					adaptor.addChild(root_0, IDENT35_tree);

					}
					break;
				case 10 :
					// ValueEvaluatorTree.g:62:54: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_externalFile208);
					usedKeywords36=usedKeywords();
					state._fsp--;

					adaptor.addChild(root_0, usedKeywords36.getTree());

					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "externalFile"


	public static class text_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "text"
	// ValueEvaluatorTree.g:65:1: text : LETTER ( LETTER | DIGIT )* ;
	public final ValueEvaluatorTreeParser.text_return text() throws RecognitionException {
		ValueEvaluatorTreeParser.text_return retval = new ValueEvaluatorTreeParser.text_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LETTER37=null;
		Token set38=null;

		CommonTree LETTER37_tree=null;
		CommonTree set38_tree=null;

		try {
			// ValueEvaluatorTree.g:65:6: ( LETTER ( LETTER | DIGIT )* )
			// ValueEvaluatorTree.g:65:8: LETTER ( LETTER | DIGIT )*
			{
			root_0 = (CommonTree)adaptor.nil();


			LETTER37=(Token)match(input,LETTER,FOLLOW_LETTER_in_text222); 
			LETTER37_tree = (CommonTree)adaptor.create(LETTER37);
			adaptor.addChild(root_0, LETTER37_tree);

			// ValueEvaluatorTree.g:65:15: ( LETTER | DIGIT )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==DIGIT||LA6_0==LETTER) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// ValueEvaluatorTree.g:
					{
					set38=input.LT(1);
					if ( input.LA(1)==DIGIT||input.LA(1)==LETTER ) {
						input.consume();
						adaptor.addChild(root_0, (CommonTree)adaptor.create(set38));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

				default :
					break loop6;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "text"


	public static class conditionStatement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "conditionStatement"
	// ValueEvaluatorTree.g:67:1: conditionStatement : ( (r= relationStatementSeries -> $r) | ( ALWAYS -> ALWAYS ) ) ;
	public final ValueEvaluatorTreeParser.conditionStatement_return conditionStatement() throws RecognitionException {
		ValueEvaluatorTreeParser.conditionStatement_return retval = new ValueEvaluatorTreeParser.conditionStatement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ALWAYS39=null;
		ParserRuleReturnScope r =null;

		CommonTree ALWAYS39_tree=null;
		RewriteRuleTokenStream stream_ALWAYS=new RewriteRuleTokenStream(adaptor,"token ALWAYS");
		RewriteRuleSubtreeStream stream_relationStatementSeries=new RewriteRuleSubtreeStream(adaptor,"rule relationStatementSeries");

		try {
			// ValueEvaluatorTree.g:68:3: ( ( (r= relationStatementSeries -> $r) | ( ALWAYS -> ALWAYS ) ) )
			// ValueEvaluatorTree.g:68:5: ( (r= relationStatementSeries -> $r) | ( ALWAYS -> ALWAYS ) )
			{
			// ValueEvaluatorTree.g:68:5: ( (r= relationStatementSeries -> $r) | ( ALWAYS -> ALWAYS ) )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==ABS||LA7_0==DAYSIN||LA7_0==EXP||LA7_0==FLOAT||LA7_0==IDENT||(LA7_0 >= INT && LA7_0 <= INTEGER)||(LA7_0 >= LOG && LA7_0 <= LOG10)||(LA7_0 >= MAX && LA7_0 <= MIN)||(LA7_0 >= MONTH && LA7_0 <= MONTH_CONST)||(LA7_0 >= PASTMONTH && LA7_0 <= REAL)||LA7_0==SVAR||LA7_0==TAFCFS||(LA7_0 >= YEAR && LA7_0 <= 67)||LA7_0==71) ) {
				alt7=1;
			}
			else if ( (LA7_0==ALWAYS) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// ValueEvaluatorTree.g:68:6: (r= relationStatementSeries -> $r)
					{
					// ValueEvaluatorTree.g:68:6: (r= relationStatementSeries -> $r)
					// ValueEvaluatorTree.g:68:7: r= relationStatementSeries
					{
					pushFollow(FOLLOW_relationStatementSeries_in_conditionStatement247);
					r=relationStatementSeries();
					state._fsp--;

					stream_relationStatementSeries.add(r.getTree());
					// AST REWRITE
					// elements: r
					// token labels: 
					// rule labels: r, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_r=new RewriteRuleSubtreeStream(adaptor,"rule r",r!=null?r.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 68:32: -> $r
					{
						adaptor.addChild(root_0, stream_r.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:68:39: ( ALWAYS -> ALWAYS )
					{
					// ValueEvaluatorTree.g:68:39: ( ALWAYS -> ALWAYS )
					// ValueEvaluatorTree.g:68:40: ALWAYS
					{
					ALWAYS39=(Token)match(input,ALWAYS,FOLLOW_ALWAYS_in_conditionStatement255);  
					stream_ALWAYS.add(ALWAYS39);

					// AST REWRITE
					// elements: ALWAYS
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 68:46: -> ALWAYS
					{
						adaptor.addChild(root_0, stream_ALWAYS.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "conditionStatement"


	public static class relationStatementSeries_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "relationStatementSeries"
	// ValueEvaluatorTree.g:71:1: relationStatementSeries : r1= relationRangeStatement ( ( (s= ( '.and.' ^| '.or.' ^) ) ) r2= relationRangeStatement )* ;
	public final ValueEvaluatorTreeParser.relationStatementSeries_return relationStatementSeries() throws RecognitionException {
		ValueEvaluatorTreeParser.relationStatementSeries_return retval = new ValueEvaluatorTreeParser.relationStatementSeries_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		ParserRuleReturnScope r1 =null;
		ParserRuleReturnScope r2 =null;

		CommonTree s_tree=null;

		try {
			// ValueEvaluatorTree.g:72:3: (r1= relationRangeStatement ( ( (s= ( '.and.' ^| '.or.' ^) ) ) r2= relationRangeStatement )* )
			// ValueEvaluatorTree.g:72:5: r1= relationRangeStatement ( ( (s= ( '.and.' ^| '.or.' ^) ) ) r2= relationRangeStatement )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_relationRangeStatement_in_relationStatementSeries276);
			r1=relationRangeStatement();
			state._fsp--;

			adaptor.addChild(root_0, r1.getTree());

			// ValueEvaluatorTree.g:73:5: ( ( (s= ( '.and.' ^| '.or.' ^) ) ) r2= relationRangeStatement )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= 73 && LA9_0 <= 74)) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// ValueEvaluatorTree.g:73:6: ( (s= ( '.and.' ^| '.or.' ^) ) ) r2= relationRangeStatement
					{
					// ValueEvaluatorTree.g:73:6: ( (s= ( '.and.' ^| '.or.' ^) ) )
					// ValueEvaluatorTree.g:73:7: (s= ( '.and.' ^| '.or.' ^) )
					{
					// ValueEvaluatorTree.g:73:7: (s= ( '.and.' ^| '.or.' ^) )
					// ValueEvaluatorTree.g:73:8: s= ( '.and.' ^| '.or.' ^)
					{
					// ValueEvaluatorTree.g:73:10: ( '.and.' ^| '.or.' ^)
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==73) ) {
						alt8=1;
					}
					else if ( (LA8_0==74) ) {
						alt8=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 8, 0, input);
						throw nvae;
					}

					switch (alt8) {
						case 1 :
							// ValueEvaluatorTree.g:73:11: '.and.' ^
							{
							s=(Token)match(input,73,FOLLOW_73_in_relationStatementSeries290); 
							s_tree = (CommonTree)adaptor.create(s);
							root_0 = (CommonTree)adaptor.becomeRoot(s_tree, root_0);

							}
							break;
						case 2 :
							// ValueEvaluatorTree.g:73:20: '.or.' ^
							{
							s=(Token)match(input,74,FOLLOW_74_in_relationStatementSeries293); 
							s_tree = (CommonTree)adaptor.create(s);
							root_0 = (CommonTree)adaptor.becomeRoot(s_tree, root_0);

							}
							break;

					}

					}

					}

					pushFollow(FOLLOW_relationRangeStatement_in_relationStatementSeries301);
					r2=relationRangeStatement();
					state._fsp--;

					adaptor.addChild(root_0, r2.getTree());

					}
					break;

				default :
					break loop9;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "relationStatementSeries"


	public static class relationRangeStatement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "relationRangeStatement"
	// ValueEvaluatorTree.g:75:1: relationRangeStatement : ( ( relationStatement -> relationStatement ) | ( range_func -> range_func ) );
	public final ValueEvaluatorTreeParser.relationRangeStatement_return relationRangeStatement() throws RecognitionException {
		ValueEvaluatorTreeParser.relationRangeStatement_return retval = new ValueEvaluatorTreeParser.relationRangeStatement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope relationStatement40 =null;
		ParserRuleReturnScope range_func41 =null;

		RewriteRuleSubtreeStream stream_relationStatement=new RewriteRuleSubtreeStream(adaptor,"rule relationStatement");
		RewriteRuleSubtreeStream stream_range_func=new RewriteRuleSubtreeStream(adaptor,"rule range_func");

		try {
			// ValueEvaluatorTree.g:76:3: ( ( relationStatement -> relationStatement ) | ( range_func -> range_func ) )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==ABS||LA10_0==DAYSIN||LA10_0==EXP||LA10_0==FLOAT||LA10_0==IDENT||(LA10_0 >= INT && LA10_0 <= INTEGER)||(LA10_0 >= LOG && LA10_0 <= LOG10)||(LA10_0 >= MAX && LA10_0 <= MIN)||(LA10_0 >= MONTH && LA10_0 <= MONTH_CONST)||(LA10_0 >= PASTMONTH && LA10_0 <= POW)||LA10_0==REAL||LA10_0==SVAR||LA10_0==TAFCFS||(LA10_0 >= YEAR && LA10_0 <= 67)||LA10_0==71) ) {
				alt10=1;
			}
			else if ( (LA10_0==RANGE) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// ValueEvaluatorTree.g:76:5: ( relationStatement -> relationStatement )
					{
					// ValueEvaluatorTree.g:76:5: ( relationStatement -> relationStatement )
					// ValueEvaluatorTree.g:76:6: relationStatement
					{
					pushFollow(FOLLOW_relationStatement_in_relationRangeStatement315);
					relationStatement40=relationStatement();
					state._fsp--;

					stream_relationStatement.add(relationStatement40.getTree());
					// AST REWRITE
					// elements: relationStatement
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 76:24: -> relationStatement
					{
						adaptor.addChild(root_0, stream_relationStatement.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:76:46: ( range_func -> range_func )
					{
					// ValueEvaluatorTree.g:76:46: ( range_func -> range_func )
					// ValueEvaluatorTree.g:76:47: range_func
					{
					pushFollow(FOLLOW_range_func_in_relationRangeStatement323);
					range_func41=range_func();
					state._fsp--;

					stream_range_func.add(range_func41.getTree());
					// AST REWRITE
					// elements: range_func
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 76:58: -> range_func
					{
						adaptor.addChild(root_0, stream_range_func.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "relationRangeStatement"


	public static class relationStatement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "relationStatement"
	// ValueEvaluatorTree.g:79:1: relationStatement : (e1= expression ) relation (e2= expression ) -> ^( relation $e1 $e2) ;
	public final ValueEvaluatorTreeParser.relationStatement_return relationStatement() throws RecognitionException {
		ValueEvaluatorTreeParser.relationStatement_return retval = new ValueEvaluatorTreeParser.relationStatement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;
		ParserRuleReturnScope relation42 =null;

		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_relation=new RewriteRuleSubtreeStream(adaptor,"rule relation");

		try {
			// ValueEvaluatorTree.g:80:3: ( (e1= expression ) relation (e2= expression ) -> ^( relation $e1 $e2) )
			// ValueEvaluatorTree.g:80:5: (e1= expression ) relation (e2= expression )
			{
			// ValueEvaluatorTree.g:80:5: (e1= expression )
			// ValueEvaluatorTree.g:80:6: e1= expression
			{
			pushFollow(FOLLOW_expression_in_relationStatement346);
			e1=expression();
			state._fsp--;

			stream_expression.add(e1.getTree());
			}

			pushFollow(FOLLOW_relation_in_relationStatement349);
			relation42=relation();
			state._fsp--;

			stream_relation.add(relation42.getTree());
			// ValueEvaluatorTree.g:80:30: (e2= expression )
			// ValueEvaluatorTree.g:80:31: e2= expression
			{
			pushFollow(FOLLOW_expression_in_relationStatement354);
			e2=expression();
			state._fsp--;

			stream_expression.add(e2.getTree());
			}

			// AST REWRITE
			// elements: e1, e2, relation
			// token labels: 
			// rule labels: e1, e2, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_e1=new RewriteRuleSubtreeStream(adaptor,"rule e1",e1!=null?e1.getTree():null);
			RewriteRuleSubtreeStream stream_e2=new RewriteRuleSubtreeStream(adaptor,"rule e2",e2!=null?e2.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 80:46: -> ^( relation $e1 $e2)
			{
				// ValueEvaluatorTree.g:80:49: ^( relation $e1 $e2)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_relation.nextNode(), root_1);
				adaptor.addChild(root_1, stream_e1.nextTree());
				adaptor.addChild(root_1, stream_e2.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "relationStatement"


	public static class expressionCollection_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expressionCollection"
	// ValueEvaluatorTree.g:83:1: expressionCollection : ( ( expression -> expression ) | ( tableSQL -> tableSQL ) | ( timeseries -> timeseries ) | ( sumExpression -> sumExpression ) | ( UPPERUNBOUNDED -> UPPERUNBOUNDED ) | ( LOWERUNBOUNDED -> LOWERUNBOUNDED ) ) ;
	public final ValueEvaluatorTreeParser.expressionCollection_return expressionCollection() throws RecognitionException {
		ValueEvaluatorTreeParser.expressionCollection_return retval = new ValueEvaluatorTreeParser.expressionCollection_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token UPPERUNBOUNDED47=null;
		Token LOWERUNBOUNDED48=null;
		ParserRuleReturnScope expression43 =null;
		ParserRuleReturnScope tableSQL44 =null;
		ParserRuleReturnScope timeseries45 =null;
		ParserRuleReturnScope sumExpression46 =null;

		CommonTree UPPERUNBOUNDED47_tree=null;
		CommonTree LOWERUNBOUNDED48_tree=null;
		RewriteRuleTokenStream stream_LOWERUNBOUNDED=new RewriteRuleTokenStream(adaptor,"token LOWERUNBOUNDED");
		RewriteRuleTokenStream stream_UPPERUNBOUNDED=new RewriteRuleTokenStream(adaptor,"token UPPERUNBOUNDED");
		RewriteRuleSubtreeStream stream_tableSQL=new RewriteRuleSubtreeStream(adaptor,"rule tableSQL");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_timeseries=new RewriteRuleSubtreeStream(adaptor,"rule timeseries");
		RewriteRuleSubtreeStream stream_sumExpression=new RewriteRuleSubtreeStream(adaptor,"rule sumExpression");

		try {
			// ValueEvaluatorTree.g:84:2: ( ( ( expression -> expression ) | ( tableSQL -> tableSQL ) | ( timeseries -> timeseries ) | ( sumExpression -> sumExpression ) | ( UPPERUNBOUNDED -> UPPERUNBOUNDED ) | ( LOWERUNBOUNDED -> LOWERUNBOUNDED ) ) )
			// ValueEvaluatorTree.g:84:3: ( ( expression -> expression ) | ( tableSQL -> tableSQL ) | ( timeseries -> timeseries ) | ( sumExpression -> sumExpression ) | ( UPPERUNBOUNDED -> UPPERUNBOUNDED ) | ( LOWERUNBOUNDED -> LOWERUNBOUNDED ) )
			{
			// ValueEvaluatorTree.g:84:3: ( ( expression -> expression ) | ( tableSQL -> tableSQL ) | ( timeseries -> timeseries ) | ( sumExpression -> sumExpression ) | ( UPPERUNBOUNDED -> UPPERUNBOUNDED ) | ( LOWERUNBOUNDED -> LOWERUNBOUNDED ) )
			int alt11=6;
			switch ( input.LA(1) ) {
			case ABS:
			case DAYSIN:
			case EXP:
			case FLOAT:
			case IDENT:
			case INT:
			case INTEGER:
			case LOG:
			case LOG10:
			case MAX:
			case MIN:
			case MONTH:
			case MONTH_CONST:
			case PASTMONTH:
			case POW:
			case REAL:
			case SVAR:
			case TAFCFS:
			case YEAR:
			case 67:
			case 71:
				{
				alt11=1;
				}
				break;
			case SELECT:
				{
				alt11=2;
				}
				break;
			case TIMESERIES:
				{
				alt11=3;
				}
				break;
			case SUM:
				{
				alt11=4;
				}
				break;
			case UPPERUNBOUNDED:
				{
				alt11=5;
				}
				break;
			case LOWERUNBOUNDED:
				{
				alt11=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// ValueEvaluatorTree.g:84:4: ( expression -> expression )
					{
					// ValueEvaluatorTree.g:84:4: ( expression -> expression )
					// ValueEvaluatorTree.g:84:5: expression
					{
					pushFollow(FOLLOW_expression_in_expressionCollection381);
					expression43=expression();
					state._fsp--;

					stream_expression.add(expression43.getTree());
					// AST REWRITE
					// elements: expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 84:15: -> expression
					{
						adaptor.addChild(root_0, stream_expression.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:85:3: ( tableSQL -> tableSQL )
					{
					// ValueEvaluatorTree.g:85:3: ( tableSQL -> tableSQL )
					// ValueEvaluatorTree.g:85:4: tableSQL
					{
					pushFollow(FOLLOW_tableSQL_in_expressionCollection389);
					tableSQL44=tableSQL();
					state._fsp--;

					stream_tableSQL.add(tableSQL44.getTree());
					// AST REWRITE
					// elements: tableSQL
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 85:12: -> tableSQL
					{
						adaptor.addChild(root_0, stream_tableSQL.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 3 :
					// ValueEvaluatorTree.g:86:3: ( timeseries -> timeseries )
					{
					// ValueEvaluatorTree.g:86:3: ( timeseries -> timeseries )
					// ValueEvaluatorTree.g:86:4: timeseries
					{
					pushFollow(FOLLOW_timeseries_in_expressionCollection397);
					timeseries45=timeseries();
					state._fsp--;

					stream_timeseries.add(timeseries45.getTree());
					// AST REWRITE
					// elements: timeseries
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 86:14: -> timeseries
					{
						adaptor.addChild(root_0, stream_timeseries.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 4 :
					// ValueEvaluatorTree.g:87:3: ( sumExpression -> sumExpression )
					{
					// ValueEvaluatorTree.g:87:3: ( sumExpression -> sumExpression )
					// ValueEvaluatorTree.g:87:4: sumExpression
					{
					pushFollow(FOLLOW_sumExpression_in_expressionCollection405);
					sumExpression46=sumExpression();
					state._fsp--;

					stream_sumExpression.add(sumExpression46.getTree());
					// AST REWRITE
					// elements: sumExpression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 87:17: -> sumExpression
					{
						adaptor.addChild(root_0, stream_sumExpression.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 5 :
					// ValueEvaluatorTree.g:88:3: ( UPPERUNBOUNDED -> UPPERUNBOUNDED )
					{
					// ValueEvaluatorTree.g:88:3: ( UPPERUNBOUNDED -> UPPERUNBOUNDED )
					// ValueEvaluatorTree.g:88:4: UPPERUNBOUNDED
					{
					UPPERUNBOUNDED47=(Token)match(input,UPPERUNBOUNDED,FOLLOW_UPPERUNBOUNDED_in_expressionCollection413);  
					stream_UPPERUNBOUNDED.add(UPPERUNBOUNDED47);

					// AST REWRITE
					// elements: UPPERUNBOUNDED
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 88:19: -> UPPERUNBOUNDED
					{
						adaptor.addChild(root_0, stream_UPPERUNBOUNDED.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 6 :
					// ValueEvaluatorTree.g:89:3: ( LOWERUNBOUNDED -> LOWERUNBOUNDED )
					{
					// ValueEvaluatorTree.g:89:3: ( LOWERUNBOUNDED -> LOWERUNBOUNDED )
					// ValueEvaluatorTree.g:89:4: LOWERUNBOUNDED
					{
					LOWERUNBOUNDED48=(Token)match(input,LOWERUNBOUNDED,FOLLOW_LOWERUNBOUNDED_in_expressionCollection422);  
					stream_LOWERUNBOUNDED.add(LOWERUNBOUNDED48);

					// AST REWRITE
					// elements: LOWERUNBOUNDED
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 89:19: -> LOWERUNBOUNDED
					{
						adaptor.addChild(root_0, stream_LOWERUNBOUNDED.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expressionCollection"


	public static class func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func"
	// ValueEvaluatorTree.g:92:1: func : ( max_func | min_func | int_func | real_func | abs_func | exp_func | log_func | log10_func | pow_func ) ;
	public final ValueEvaluatorTreeParser.func_return func() throws RecognitionException {
		ValueEvaluatorTreeParser.func_return retval = new ValueEvaluatorTreeParser.func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope max_func49 =null;
		ParserRuleReturnScope min_func50 =null;
		ParserRuleReturnScope int_func51 =null;
		ParserRuleReturnScope real_func52 =null;
		ParserRuleReturnScope abs_func53 =null;
		ParserRuleReturnScope exp_func54 =null;
		ParserRuleReturnScope log_func55 =null;
		ParserRuleReturnScope log10_func56 =null;
		ParserRuleReturnScope pow_func57 =null;


		try {
			// ValueEvaluatorTree.g:92:5: ( ( max_func | min_func | int_func | real_func | abs_func | exp_func | log_func | log10_func | pow_func ) )
			// ValueEvaluatorTree.g:93:3: ( max_func | min_func | int_func | real_func | abs_func | exp_func | log_func | log10_func | pow_func )
			{
			root_0 = (CommonTree)adaptor.nil();


			// ValueEvaluatorTree.g:93:3: ( max_func | min_func | int_func | real_func | abs_func | exp_func | log_func | log10_func | pow_func )
			int alt12=9;
			switch ( input.LA(1) ) {
			case MAX:
				{
				alt12=1;
				}
				break;
			case MIN:
				{
				alt12=2;
				}
				break;
			case INT:
				{
				alt12=3;
				}
				break;
			case REAL:
				{
				alt12=4;
				}
				break;
			case ABS:
				{
				alt12=5;
				}
				break;
			case EXP:
				{
				alt12=6;
				}
				break;
			case LOG:
				{
				alt12=7;
				}
				break;
			case LOG10:
				{
				alt12=8;
				}
				break;
			case POW:
				{
				alt12=9;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// ValueEvaluatorTree.g:93:4: max_func
					{
					pushFollow(FOLLOW_max_func_in_func440);
					max_func49=max_func();
					state._fsp--;

					adaptor.addChild(root_0, max_func49.getTree());

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:94:3: min_func
					{
					pushFollow(FOLLOW_min_func_in_func445);
					min_func50=min_func();
					state._fsp--;

					adaptor.addChild(root_0, min_func50.getTree());

					}
					break;
				case 3 :
					// ValueEvaluatorTree.g:95:3: int_func
					{
					pushFollow(FOLLOW_int_func_in_func450);
					int_func51=int_func();
					state._fsp--;

					adaptor.addChild(root_0, int_func51.getTree());

					}
					break;
				case 4 :
					// ValueEvaluatorTree.g:96:3: real_func
					{
					pushFollow(FOLLOW_real_func_in_func455);
					real_func52=real_func();
					state._fsp--;

					adaptor.addChild(root_0, real_func52.getTree());

					}
					break;
				case 5 :
					// ValueEvaluatorTree.g:97:3: abs_func
					{
					pushFollow(FOLLOW_abs_func_in_func460);
					abs_func53=abs_func();
					state._fsp--;

					adaptor.addChild(root_0, abs_func53.getTree());

					}
					break;
				case 6 :
					// ValueEvaluatorTree.g:98:3: exp_func
					{
					pushFollow(FOLLOW_exp_func_in_func465);
					exp_func54=exp_func();
					state._fsp--;

					adaptor.addChild(root_0, exp_func54.getTree());

					}
					break;
				case 7 :
					// ValueEvaluatorTree.g:99:3: log_func
					{
					pushFollow(FOLLOW_log_func_in_func470);
					log_func55=log_func();
					state._fsp--;

					adaptor.addChild(root_0, log_func55.getTree());

					}
					break;
				case 8 :
					// ValueEvaluatorTree.g:100:3: log10_func
					{
					pushFollow(FOLLOW_log10_func_in_func475);
					log10_func56=log10_func();
					state._fsp--;

					adaptor.addChild(root_0, log10_func56.getTree());

					}
					break;
				case 9 :
					// ValueEvaluatorTree.g:101:3: pow_func
					{
					pushFollow(FOLLOW_pow_func_in_func480);
					pow_func57=pow_func();
					state._fsp--;

					adaptor.addChild(root_0, pow_func57.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "func"


	public static class max_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "max_func"
	// ValueEvaluatorTree.g:103:1: max_func : MAX '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' -> ^( MAX $e1 ( $e2)+ ) ;
	public final ValueEvaluatorTreeParser.max_func_return max_func() throws RecognitionException {
		ValueEvaluatorTreeParser.max_func_return retval = new ValueEvaluatorTreeParser.max_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MAX58=null;
		Token char_literal59=null;
		Token char_literal60=null;
		Token char_literal61=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		CommonTree MAX58_tree=null;
		CommonTree char_literal59_tree=null;
		CommonTree char_literal60_tree=null;
		CommonTree char_literal61_tree=null;
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_MAX=new RewriteRuleTokenStream(adaptor,"token MAX");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ValueEvaluatorTree.g:104:2: ( MAX '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' -> ^( MAX $e1 ( $e2)+ ) )
			// ValueEvaluatorTree.g:104:4: MAX '(' (e1= expression ) ( ';' (e2= expression ) )+ ')'
			{
			MAX58=(Token)match(input,MAX,FOLLOW_MAX_in_max_func491);  
			stream_MAX.add(MAX58);

			char_literal59=(Token)match(input,67,FOLLOW_67_in_max_func493);  
			stream_67.add(char_literal59);

			// ValueEvaluatorTree.g:104:12: (e1= expression )
			// ValueEvaluatorTree.g:104:13: e1= expression
			{
			pushFollow(FOLLOW_expression_in_max_func498);
			e1=expression();
			state._fsp--;

			stream_expression.add(e1.getTree());
			}

			// ValueEvaluatorTree.g:104:28: ( ';' (e2= expression ) )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==77) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// ValueEvaluatorTree.g:104:29: ';' (e2= expression )
					{
					char_literal60=(Token)match(input,77,FOLLOW_77_in_max_func502);  
					stream_77.add(char_literal60);

					// ValueEvaluatorTree.g:104:33: (e2= expression )
					// ValueEvaluatorTree.g:104:34: e2= expression
					{
					pushFollow(FOLLOW_expression_in_max_func507);
					e2=expression();
					state._fsp--;

					stream_expression.add(e2.getTree());
					}

					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			char_literal61=(Token)match(input,68,FOLLOW_68_in_max_func512);  
			stream_68.add(char_literal61);

			// AST REWRITE
			// elements: MAX, e1, e2
			// token labels: 
			// rule labels: e1, e2, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_e1=new RewriteRuleSubtreeStream(adaptor,"rule e1",e1!=null?e1.getTree():null);
			RewriteRuleSubtreeStream stream_e2=new RewriteRuleSubtreeStream(adaptor,"rule e2",e2!=null?e2.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 104:55: -> ^( MAX $e1 ( $e2)+ )
			{
				// ValueEvaluatorTree.g:104:58: ^( MAX $e1 ( $e2)+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_MAX.nextNode(), root_1);
				adaptor.addChild(root_1, stream_e1.nextTree());
				if ( !(stream_e2.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_e2.hasNext() ) {
					adaptor.addChild(root_1, stream_e2.nextTree());
				}
				stream_e2.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "max_func"


	public static class min_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "min_func"
	// ValueEvaluatorTree.g:107:1: min_func : MIN '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' -> ^( MIN $e1 ( $e2)+ ) ;
	public final ValueEvaluatorTreeParser.min_func_return min_func() throws RecognitionException {
		ValueEvaluatorTreeParser.min_func_return retval = new ValueEvaluatorTreeParser.min_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MIN62=null;
		Token char_literal63=null;
		Token char_literal64=null;
		Token char_literal65=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		CommonTree MIN62_tree=null;
		CommonTree char_literal63_tree=null;
		CommonTree char_literal64_tree=null;
		CommonTree char_literal65_tree=null;
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_MIN=new RewriteRuleTokenStream(adaptor,"token MIN");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ValueEvaluatorTree.g:108:2: ( MIN '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' -> ^( MIN $e1 ( $e2)+ ) )
			// ValueEvaluatorTree.g:108:4: MIN '(' (e1= expression ) ( ';' (e2= expression ) )+ ')'
			{
			MIN62=(Token)match(input,MIN,FOLLOW_MIN_in_min_func537);  
			stream_MIN.add(MIN62);

			char_literal63=(Token)match(input,67,FOLLOW_67_in_min_func539);  
			stream_67.add(char_literal63);

			// ValueEvaluatorTree.g:108:12: (e1= expression )
			// ValueEvaluatorTree.g:108:13: e1= expression
			{
			pushFollow(FOLLOW_expression_in_min_func544);
			e1=expression();
			state._fsp--;

			stream_expression.add(e1.getTree());
			}

			// ValueEvaluatorTree.g:108:27: ( ';' (e2= expression ) )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==77) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// ValueEvaluatorTree.g:108:28: ';' (e2= expression )
					{
					char_literal64=(Token)match(input,77,FOLLOW_77_in_min_func547);  
					stream_77.add(char_literal64);

					// ValueEvaluatorTree.g:108:32: (e2= expression )
					// ValueEvaluatorTree.g:108:33: e2= expression
					{
					pushFollow(FOLLOW_expression_in_min_func552);
					e2=expression();
					state._fsp--;

					stream_expression.add(e2.getTree());
					}

					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			char_literal65=(Token)match(input,68,FOLLOW_68_in_min_func557);  
			stream_68.add(char_literal65);

			// AST REWRITE
			// elements: e1, MIN, e2
			// token labels: 
			// rule labels: e1, e2, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_e1=new RewriteRuleSubtreeStream(adaptor,"rule e1",e1!=null?e1.getTree():null);
			RewriteRuleSubtreeStream stream_e2=new RewriteRuleSubtreeStream(adaptor,"rule e2",e2!=null?e2.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 108:54: -> ^( MIN $e1 ( $e2)+ )
			{
				// ValueEvaluatorTree.g:108:57: ^( MIN $e1 ( $e2)+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_MIN.nextNode(), root_1);
				adaptor.addChild(root_1, stream_e1.nextTree());
				if ( !(stream_e2.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_e2.hasNext() ) {
					adaptor.addChild(root_1, stream_e2.nextTree());
				}
				stream_e2.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "min_func"


	public static class int_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "int_func"
	// ValueEvaluatorTree.g:111:1: int_func : INT '(' (e= expression ) ')' -> ^( INT $e) ;
	public final ValueEvaluatorTreeParser.int_func_return int_func() throws RecognitionException {
		ValueEvaluatorTreeParser.int_func_return retval = new ValueEvaluatorTreeParser.int_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INT66=null;
		Token char_literal67=null;
		Token char_literal68=null;
		ParserRuleReturnScope e =null;

		CommonTree INT66_tree=null;
		CommonTree char_literal67_tree=null;
		CommonTree char_literal68_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ValueEvaluatorTree.g:112:3: ( INT '(' (e= expression ) ')' -> ^( INT $e) )
			// ValueEvaluatorTree.g:112:5: INT '(' (e= expression ) ')'
			{
			INT66=(Token)match(input,INT,FOLLOW_INT_in_int_func583);  
			stream_INT.add(INT66);

			char_literal67=(Token)match(input,67,FOLLOW_67_in_int_func585);  
			stream_67.add(char_literal67);

			// ValueEvaluatorTree.g:112:13: (e= expression )
			// ValueEvaluatorTree.g:112:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_int_func590);
			e=expression();
			state._fsp--;

			stream_expression.add(e.getTree());
			}

			char_literal68=(Token)match(input,68,FOLLOW_68_in_int_func593);  
			stream_68.add(char_literal68);

			// AST REWRITE
			// elements: e, INT
			// token labels: 
			// rule labels: e, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 112:32: -> ^( INT $e)
			{
				// ValueEvaluatorTree.g:112:35: ^( INT $e)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_INT.nextNode(), root_1);
				adaptor.addChild(root_1, stream_e.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "int_func"


	public static class real_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "real_func"
	// ValueEvaluatorTree.g:115:1: real_func : REAL '(' (e= expression ) ')' -> ^( REAL $e) ;
	public final ValueEvaluatorTreeParser.real_func_return real_func() throws RecognitionException {
		ValueEvaluatorTreeParser.real_func_return retval = new ValueEvaluatorTreeParser.real_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token REAL69=null;
		Token char_literal70=null;
		Token char_literal71=null;
		ParserRuleReturnScope e =null;

		CommonTree REAL69_tree=null;
		CommonTree char_literal70_tree=null;
		CommonTree char_literal71_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_REAL=new RewriteRuleTokenStream(adaptor,"token REAL");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ValueEvaluatorTree.g:116:3: ( REAL '(' (e= expression ) ')' -> ^( REAL $e) )
			// ValueEvaluatorTree.g:116:5: REAL '(' (e= expression ) ')'
			{
			REAL69=(Token)match(input,REAL,FOLLOW_REAL_in_real_func617);  
			stream_REAL.add(REAL69);

			char_literal70=(Token)match(input,67,FOLLOW_67_in_real_func619);  
			stream_67.add(char_literal70);

			// ValueEvaluatorTree.g:116:14: (e= expression )
			// ValueEvaluatorTree.g:116:15: e= expression
			{
			pushFollow(FOLLOW_expression_in_real_func624);
			e=expression();
			state._fsp--;

			stream_expression.add(e.getTree());
			}

			char_literal71=(Token)match(input,68,FOLLOW_68_in_real_func627);  
			stream_68.add(char_literal71);

			// AST REWRITE
			// elements: REAL, e
			// token labels: 
			// rule labels: e, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 116:33: -> ^( REAL $e)
			{
				// ValueEvaluatorTree.g:116:36: ^( REAL $e)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_REAL.nextNode(), root_1);
				adaptor.addChild(root_1, stream_e.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "real_func"


	public static class abs_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "abs_func"
	// ValueEvaluatorTree.g:119:1: abs_func : ABS '(' (e= expression ) ')' -> ^( ABS $e) ;
	public final ValueEvaluatorTreeParser.abs_func_return abs_func() throws RecognitionException {
		ValueEvaluatorTreeParser.abs_func_return retval = new ValueEvaluatorTreeParser.abs_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ABS72=null;
		Token char_literal73=null;
		Token char_literal74=null;
		ParserRuleReturnScope e =null;

		CommonTree ABS72_tree=null;
		CommonTree char_literal73_tree=null;
		CommonTree char_literal74_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_ABS=new RewriteRuleTokenStream(adaptor,"token ABS");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ValueEvaluatorTree.g:120:3: ( ABS '(' (e= expression ) ')' -> ^( ABS $e) )
			// ValueEvaluatorTree.g:120:5: ABS '(' (e= expression ) ')'
			{
			ABS72=(Token)match(input,ABS,FOLLOW_ABS_in_abs_func652);  
			stream_ABS.add(ABS72);

			char_literal73=(Token)match(input,67,FOLLOW_67_in_abs_func654);  
			stream_67.add(char_literal73);

			// ValueEvaluatorTree.g:120:13: (e= expression )
			// ValueEvaluatorTree.g:120:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_abs_func659);
			e=expression();
			state._fsp--;

			stream_expression.add(e.getTree());
			}

			char_literal74=(Token)match(input,68,FOLLOW_68_in_abs_func662);  
			stream_68.add(char_literal74);

			// AST REWRITE
			// elements: e, ABS
			// token labels: 
			// rule labels: e, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 120:31: -> ^( ABS $e)
			{
				// ValueEvaluatorTree.g:120:34: ^( ABS $e)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_ABS.nextNode(), root_1);
				adaptor.addChild(root_1, stream_e.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "abs_func"


	public static class exp_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "exp_func"
	// ValueEvaluatorTree.g:123:1: exp_func : EXP '(' (e= expression ) ')' -> ^( EXP $e) ;
	public final ValueEvaluatorTreeParser.exp_func_return exp_func() throws RecognitionException {
		ValueEvaluatorTreeParser.exp_func_return retval = new ValueEvaluatorTreeParser.exp_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EXP75=null;
		Token char_literal76=null;
		Token char_literal77=null;
		ParserRuleReturnScope e =null;

		CommonTree EXP75_tree=null;
		CommonTree char_literal76_tree=null;
		CommonTree char_literal77_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_EXP=new RewriteRuleTokenStream(adaptor,"token EXP");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ValueEvaluatorTree.g:124:3: ( EXP '(' (e= expression ) ')' -> ^( EXP $e) )
			// ValueEvaluatorTree.g:124:5: EXP '(' (e= expression ) ')'
			{
			EXP75=(Token)match(input,EXP,FOLLOW_EXP_in_exp_func684);  
			stream_EXP.add(EXP75);

			char_literal76=(Token)match(input,67,FOLLOW_67_in_exp_func686);  
			stream_67.add(char_literal76);

			// ValueEvaluatorTree.g:124:13: (e= expression )
			// ValueEvaluatorTree.g:124:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_exp_func691);
			e=expression();
			state._fsp--;

			stream_expression.add(e.getTree());
			}

			char_literal77=(Token)match(input,68,FOLLOW_68_in_exp_func694);  
			stream_68.add(char_literal77);

			// AST REWRITE
			// elements: e, EXP
			// token labels: 
			// rule labels: e, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 124:32: -> ^( EXP $e)
			{
				// ValueEvaluatorTree.g:124:35: ^( EXP $e)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_EXP.nextNode(), root_1);
				adaptor.addChild(root_1, stream_e.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "exp_func"


	public static class log_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "log_func"
	// ValueEvaluatorTree.g:127:1: log_func : LOG '(' (e= expression ) ')' -> ^( LOG $e) ;
	public final ValueEvaluatorTreeParser.log_func_return log_func() throws RecognitionException {
		ValueEvaluatorTreeParser.log_func_return retval = new ValueEvaluatorTreeParser.log_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LOG78=null;
		Token char_literal79=null;
		Token char_literal80=null;
		ParserRuleReturnScope e =null;

		CommonTree LOG78_tree=null;
		CommonTree char_literal79_tree=null;
		CommonTree char_literal80_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_LOG=new RewriteRuleTokenStream(adaptor,"token LOG");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ValueEvaluatorTree.g:128:3: ( LOG '(' (e= expression ) ')' -> ^( LOG $e) )
			// ValueEvaluatorTree.g:128:5: LOG '(' (e= expression ) ')'
			{
			LOG78=(Token)match(input,LOG,FOLLOW_LOG_in_log_func717);  
			stream_LOG.add(LOG78);

			char_literal79=(Token)match(input,67,FOLLOW_67_in_log_func719);  
			stream_67.add(char_literal79);

			// ValueEvaluatorTree.g:128:13: (e= expression )
			// ValueEvaluatorTree.g:128:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_log_func724);
			e=expression();
			state._fsp--;

			stream_expression.add(e.getTree());
			}

			char_literal80=(Token)match(input,68,FOLLOW_68_in_log_func727);  
			stream_68.add(char_literal80);

			// AST REWRITE
			// elements: LOG, e
			// token labels: 
			// rule labels: e, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 128:32: -> ^( LOG $e)
			{
				// ValueEvaluatorTree.g:128:35: ^( LOG $e)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_LOG.nextNode(), root_1);
				adaptor.addChild(root_1, stream_e.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "log_func"


	public static class log10_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "log10_func"
	// ValueEvaluatorTree.g:131:1: log10_func : LOG10 '(' (e= expression ) ')' -> ^( LOG10 $e) ;
	public final ValueEvaluatorTreeParser.log10_func_return log10_func() throws RecognitionException {
		ValueEvaluatorTreeParser.log10_func_return retval = new ValueEvaluatorTreeParser.log10_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LOG1081=null;
		Token char_literal82=null;
		Token char_literal83=null;
		ParserRuleReturnScope e =null;

		CommonTree LOG1081_tree=null;
		CommonTree char_literal82_tree=null;
		CommonTree char_literal83_tree=null;
		RewriteRuleTokenStream stream_LOG10=new RewriteRuleTokenStream(adaptor,"token LOG10");
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ValueEvaluatorTree.g:132:3: ( LOG10 '(' (e= expression ) ')' -> ^( LOG10 $e) )
			// ValueEvaluatorTree.g:132:5: LOG10 '(' (e= expression ) ')'
			{
			LOG1081=(Token)match(input,LOG10,FOLLOW_LOG10_in_log10_func750);  
			stream_LOG10.add(LOG1081);

			char_literal82=(Token)match(input,67,FOLLOW_67_in_log10_func752);  
			stream_67.add(char_literal82);

			// ValueEvaluatorTree.g:132:15: (e= expression )
			// ValueEvaluatorTree.g:132:16: e= expression
			{
			pushFollow(FOLLOW_expression_in_log10_func757);
			e=expression();
			state._fsp--;

			stream_expression.add(e.getTree());
			}

			char_literal83=(Token)match(input,68,FOLLOW_68_in_log10_func760);  
			stream_68.add(char_literal83);

			// AST REWRITE
			// elements: e, LOG10
			// token labels: 
			// rule labels: e, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"rule e",e!=null?e.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 132:33: -> ^( LOG10 $e)
			{
				// ValueEvaluatorTree.g:132:36: ^( LOG10 $e)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_LOG10.nextNode(), root_1);
				adaptor.addChild(root_1, stream_e.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "log10_func"


	public static class pow_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "pow_func"
	// ValueEvaluatorTree.g:135:1: pow_func : POW '(' (e1= expression ) ( ';' (e2= expression ) ) ')' -> ^( POW $e1 $e2) ;
	public final ValueEvaluatorTreeParser.pow_func_return pow_func() throws RecognitionException {
		ValueEvaluatorTreeParser.pow_func_return retval = new ValueEvaluatorTreeParser.pow_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token POW84=null;
		Token char_literal85=null;
		Token char_literal86=null;
		Token char_literal87=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		CommonTree POW84_tree=null;
		CommonTree char_literal85_tree=null;
		CommonTree char_literal86_tree=null;
		CommonTree char_literal87_tree=null;
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_POW=new RewriteRuleTokenStream(adaptor,"token POW");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ValueEvaluatorTree.g:136:3: ( POW '(' (e1= expression ) ( ';' (e2= expression ) ) ')' -> ^( POW $e1 $e2) )
			// ValueEvaluatorTree.g:136:5: POW '(' (e1= expression ) ( ';' (e2= expression ) ) ')'
			{
			POW84=(Token)match(input,POW,FOLLOW_POW_in_pow_func784);  
			stream_POW.add(POW84);

			char_literal85=(Token)match(input,67,FOLLOW_67_in_pow_func786);  
			stream_67.add(char_literal85);

			// ValueEvaluatorTree.g:136:13: (e1= expression )
			// ValueEvaluatorTree.g:136:14: e1= expression
			{
			pushFollow(FOLLOW_expression_in_pow_func791);
			e1=expression();
			state._fsp--;

			stream_expression.add(e1.getTree());
			}

			// ValueEvaluatorTree.g:136:29: ( ';' (e2= expression ) )
			// ValueEvaluatorTree.g:136:30: ';' (e2= expression )
			{
			char_literal86=(Token)match(input,77,FOLLOW_77_in_pow_func795);  
			stream_77.add(char_literal86);

			// ValueEvaluatorTree.g:136:34: (e2= expression )
			// ValueEvaluatorTree.g:136:35: e2= expression
			{
			pushFollow(FOLLOW_expression_in_pow_func800);
			e2=expression();
			state._fsp--;

			stream_expression.add(e2.getTree());
			}

			}

			char_literal87=(Token)match(input,68,FOLLOW_68_in_pow_func804);  
			stream_68.add(char_literal87);

			// AST REWRITE
			// elements: POW, e2, e1
			// token labels: 
			// rule labels: e1, e2, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_e1=new RewriteRuleSubtreeStream(adaptor,"rule e1",e1!=null?e1.getTree():null);
			RewriteRuleSubtreeStream stream_e2=new RewriteRuleSubtreeStream(adaptor,"rule e2",e2!=null?e2.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 136:54: -> ^( POW $e1 $e2)
			{
				// ValueEvaluatorTree.g:136:57: ^( POW $e1 $e2)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_POW.nextNode(), root_1);
				adaptor.addChild(root_1, stream_e1.nextTree());
				adaptor.addChild(root_1, stream_e2.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "pow_func"


	public static class range_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "range_func"
	// ValueEvaluatorTree.g:139:1: range_func : RANGE '(' MONTH ';' m1= MONTH_CONST ';' m2= MONTH_CONST ')' -> ^( RANGE MONTH $m1 $m2) ;
	public final ValueEvaluatorTreeParser.range_func_return range_func() throws RecognitionException {
		ValueEvaluatorTreeParser.range_func_return retval = new ValueEvaluatorTreeParser.range_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token m1=null;
		Token m2=null;
		Token RANGE88=null;
		Token char_literal89=null;
		Token MONTH90=null;
		Token char_literal91=null;
		Token char_literal92=null;
		Token char_literal93=null;

		CommonTree m1_tree=null;
		CommonTree m2_tree=null;
		CommonTree RANGE88_tree=null;
		CommonTree char_literal89_tree=null;
		CommonTree MONTH90_tree=null;
		CommonTree char_literal91_tree=null;
		CommonTree char_literal92_tree=null;
		CommonTree char_literal93_tree=null;
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_MONTH=new RewriteRuleTokenStream(adaptor,"token MONTH");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_MONTH_CONST=new RewriteRuleTokenStream(adaptor,"token MONTH_CONST");
		RewriteRuleTokenStream stream_RANGE=new RewriteRuleTokenStream(adaptor,"token RANGE");

		try {
			// ValueEvaluatorTree.g:140:3: ( RANGE '(' MONTH ';' m1= MONTH_CONST ';' m2= MONTH_CONST ')' -> ^( RANGE MONTH $m1 $m2) )
			// ValueEvaluatorTree.g:140:5: RANGE '(' MONTH ';' m1= MONTH_CONST ';' m2= MONTH_CONST ')'
			{
			RANGE88=(Token)match(input,RANGE,FOLLOW_RANGE_in_range_func831);  
			stream_RANGE.add(RANGE88);

			char_literal89=(Token)match(input,67,FOLLOW_67_in_range_func833);  
			stream_67.add(char_literal89);

			MONTH90=(Token)match(input,MONTH,FOLLOW_MONTH_in_range_func835);  
			stream_MONTH.add(MONTH90);

			char_literal91=(Token)match(input,77,FOLLOW_77_in_range_func837);  
			stream_77.add(char_literal91);

			m1=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_range_func841);  
			stream_MONTH_CONST.add(m1);

			char_literal92=(Token)match(input,77,FOLLOW_77_in_range_func843);  
			stream_77.add(char_literal92);

			m2=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_range_func847);  
			stream_MONTH_CONST.add(m2);

			char_literal93=(Token)match(input,68,FOLLOW_68_in_range_func849);  
			stream_68.add(char_literal93);

			// AST REWRITE
			// elements: m1, RANGE, MONTH, m2
			// token labels: m1, m2
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_m1=new RewriteRuleTokenStream(adaptor,"token m1",m1);
			RewriteRuleTokenStream stream_m2=new RewriteRuleTokenStream(adaptor,"token m2",m2);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 140:63: -> ^( RANGE MONTH $m1 $m2)
			{
				// ValueEvaluatorTree.g:140:66: ^( RANGE MONTH $m1 $m2)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_RANGE.nextNode(), root_1);
				adaptor.addChild(root_1, stream_MONTH.nextNode());
				adaptor.addChild(root_1, stream_m1.nextNode());
				adaptor.addChild(root_1, stream_m2.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "range_func"


	public static class timeseries_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "timeseries"
	// ValueEvaluatorTree.g:143:1: timeseries : TIMESERIES -> TIMESERIES ;
	public final ValueEvaluatorTreeParser.timeseries_return timeseries() throws RecognitionException {
		ValueEvaluatorTreeParser.timeseries_return retval = new ValueEvaluatorTreeParser.timeseries_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token TIMESERIES94=null;

		CommonTree TIMESERIES94_tree=null;
		RewriteRuleTokenStream stream_TIMESERIES=new RewriteRuleTokenStream(adaptor,"token TIMESERIES");

		try {
			// ValueEvaluatorTree.g:144:2: ( TIMESERIES -> TIMESERIES )
			// ValueEvaluatorTree.g:144:4: TIMESERIES
			{
			TIMESERIES94=(Token)match(input,TIMESERIES,FOLLOW_TIMESERIES_in_timeseries877);  
			stream_TIMESERIES.add(TIMESERIES94);

			// AST REWRITE
			// elements: TIMESERIES
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 144:15: -> TIMESERIES
			{
				adaptor.addChild(root_0, stream_TIMESERIES.nextNode());
			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "timeseries"


	public static class partC_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "partC"
	// ValueEvaluatorTree.g:149:1: partC : ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )* ;
	public final ValueEvaluatorTreeParser.partC_return partC() throws RecognitionException {
		ValueEvaluatorTreeParser.partC_return retval = new ValueEvaluatorTreeParser.partC_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT95=null;
		Token IDENT196=null;
		Token char_literal98=null;
		Token IDENT99=null;
		Token IDENT1100=null;
		ParserRuleReturnScope usedKeywords97 =null;
		ParserRuleReturnScope usedKeywords101 =null;

		CommonTree IDENT95_tree=null;
		CommonTree IDENT196_tree=null;
		CommonTree char_literal98_tree=null;
		CommonTree IDENT99_tree=null;
		CommonTree IDENT1100_tree=null;

		try {
			// ValueEvaluatorTree.g:149:6: ( ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )* )
			// ValueEvaluatorTree.g:149:9: ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )*
			{
			root_0 = (CommonTree)adaptor.nil();


			// ValueEvaluatorTree.g:149:9: ( IDENT | IDENT1 | usedKeywords )
			int alt15=3;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				alt15=1;
				}
				break;
			case IDENT1:
				{
				alt15=2;
				}
				break;
			case ABS:
			case ALWAYS:
			case CASE:
			case CONDITION:
			case CONSTRAIN:
			case CONVERTUNITS:
			case CYCLE:
			case DAYSIN:
			case DVAR:
			case EXP:
			case EXPRESSION:
			case FILE:
			case FROM:
			case FROM_WRESL_FILE:
			case FUNCTION:
			case GIVEN:
			case INCLUDE:
			case INT:
			case INTEGERTYPE:
			case LHSGTRHS:
			case LHSLTRHS:
			case LOG:
			case LOG10:
			case LOWERBOUND:
			case LOWERUNBOUNDED:
			case MAX:
			case MIN:
			case MOD:
			case MONTH:
			case MONTH_CONST:
			case NAME:
			case ORDER:
			case OUTPUT:
			case PASTMONTH:
			case POW:
			case RANGE:
			case REAL:
			case SELECT:
			case SUM:
			case TAFCFS:
			case TIMESERIES:
			case TYPE:
			case UNARY:
			case UNITS:
			case UPPERBOUND:
			case UPPERUNBOUNDED:
			case USE:
			case WEIGHT:
			case WHERE:
			case YEAR:
				{
				alt15=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// ValueEvaluatorTree.g:149:10: IDENT
					{
					IDENT95=(Token)match(input,IDENT,FOLLOW_IDENT_in_partC895); 
					IDENT95_tree = (CommonTree)adaptor.create(IDENT95);
					adaptor.addChild(root_0, IDENT95_tree);

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:149:16: IDENT1
					{
					IDENT196=(Token)match(input,IDENT1,FOLLOW_IDENT1_in_partC897); 
					IDENT196_tree = (CommonTree)adaptor.create(IDENT196);
					adaptor.addChild(root_0, IDENT196_tree);

					}
					break;
				case 3 :
					// ValueEvaluatorTree.g:149:23: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_partC899);
					usedKeywords97=usedKeywords();
					state._fsp--;

					adaptor.addChild(root_0, usedKeywords97.getTree());

					}
					break;

			}

			// ValueEvaluatorTree.g:149:37: ( '-' ( IDENT | IDENT1 | usedKeywords ) )*
			loop17:
			while (true) {
				int alt17=2;
				int LA17_0 = input.LA(1);
				if ( (LA17_0==71) ) {
					alt17=1;
				}

				switch (alt17) {
				case 1 :
					// ValueEvaluatorTree.g:149:38: '-' ( IDENT | IDENT1 | usedKeywords )
					{
					char_literal98=(Token)match(input,71,FOLLOW_71_in_partC903); 
					char_literal98_tree = (CommonTree)adaptor.create(char_literal98);
					adaptor.addChild(root_0, char_literal98_tree);

					// ValueEvaluatorTree.g:149:42: ( IDENT | IDENT1 | usedKeywords )
					int alt16=3;
					switch ( input.LA(1) ) {
					case IDENT:
						{
						alt16=1;
						}
						break;
					case IDENT1:
						{
						alt16=2;
						}
						break;
					case ABS:
					case ALWAYS:
					case CASE:
					case CONDITION:
					case CONSTRAIN:
					case CONVERTUNITS:
					case CYCLE:
					case DAYSIN:
					case DVAR:
					case EXP:
					case EXPRESSION:
					case FILE:
					case FROM:
					case FROM_WRESL_FILE:
					case FUNCTION:
					case GIVEN:
					case INCLUDE:
					case INT:
					case INTEGERTYPE:
					case LHSGTRHS:
					case LHSLTRHS:
					case LOG:
					case LOG10:
					case LOWERBOUND:
					case LOWERUNBOUNDED:
					case MAX:
					case MIN:
					case MOD:
					case MONTH:
					case MONTH_CONST:
					case NAME:
					case ORDER:
					case OUTPUT:
					case PASTMONTH:
					case POW:
					case RANGE:
					case REAL:
					case SELECT:
					case SUM:
					case TAFCFS:
					case TIMESERIES:
					case TYPE:
					case UNARY:
					case UNITS:
					case UPPERBOUND:
					case UPPERUNBOUNDED:
					case USE:
					case WEIGHT:
					case WHERE:
					case YEAR:
						{
						alt16=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 16, 0, input);
						throw nvae;
					}
					switch (alt16) {
						case 1 :
							// ValueEvaluatorTree.g:149:43: IDENT
							{
							IDENT99=(Token)match(input,IDENT,FOLLOW_IDENT_in_partC906); 
							IDENT99_tree = (CommonTree)adaptor.create(IDENT99);
							adaptor.addChild(root_0, IDENT99_tree);

							}
							break;
						case 2 :
							// ValueEvaluatorTree.g:149:49: IDENT1
							{
							IDENT1100=(Token)match(input,IDENT1,FOLLOW_IDENT1_in_partC908); 
							IDENT1100_tree = (CommonTree)adaptor.create(IDENT1100);
							adaptor.addChild(root_0, IDENT1100_tree);

							}
							break;
						case 3 :
							// ValueEvaluatorTree.g:149:56: usedKeywords
							{
							pushFollow(FOLLOW_usedKeywords_in_partC910);
							usedKeywords101=usedKeywords();
							state._fsp--;

							adaptor.addChild(root_0, usedKeywords101.getTree());

							}
							break;

					}

					}
					break;

				default :
					break loop17;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "partC"


	public static class usedKeywords_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "usedKeywords"
	// ValueEvaluatorTree.g:151:1: usedKeywords : ( YEAR | MONTH | MONTH_CONST | PASTMONTH | RANGE | TAFCFS | DAYSIN | SUM | MAX | MIN | INT | REAL | ABS | EXP | LOG | LOG10 | POW | MOD | UNARY | SELECT | FROM | GIVEN | USE | WHERE | TIMESERIES | CONSTRAIN | ALWAYS | NAME | DVAR | CYCLE | FILE | CONDITION | INCLUDE | LOWERBOUND | UPPERBOUND | INTEGERTYPE | UNITS | CONVERTUNITS | TYPE | OUTPUT | CASE | ORDER | EXPRESSION | LHSGTRHS | LHSLTRHS | WEIGHT | FUNCTION | FROM_WRESL_FILE | UPPERUNBOUNDED | LOWERUNBOUNDED );
	public final ValueEvaluatorTreeParser.usedKeywords_return usedKeywords() throws RecognitionException {
		ValueEvaluatorTreeParser.usedKeywords_return retval = new ValueEvaluatorTreeParser.usedKeywords_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set102=null;

		CommonTree set102_tree=null;

		try {
			// ValueEvaluatorTree.g:151:13: ( YEAR | MONTH | MONTH_CONST | PASTMONTH | RANGE | TAFCFS | DAYSIN | SUM | MAX | MIN | INT | REAL | ABS | EXP | LOG | LOG10 | POW | MOD | UNARY | SELECT | FROM | GIVEN | USE | WHERE | TIMESERIES | CONSTRAIN | ALWAYS | NAME | DVAR | CYCLE | FILE | CONDITION | INCLUDE | LOWERBOUND | UPPERBOUND | INTEGERTYPE | UNITS | CONVERTUNITS | TYPE | OUTPUT | CASE | ORDER | EXPRESSION | LHSGTRHS | LHSLTRHS | WEIGHT | FUNCTION | FROM_WRESL_FILE | UPPERUNBOUNDED | LOWERUNBOUNDED )
			// ValueEvaluatorTree.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set102=input.LT(1);
			if ( (input.LA(1) >= ABS && input.LA(1) <= ALWAYS)||input.LA(1)==CASE||(input.LA(1) >= CONDITION && input.LA(1) <= DAYSIN)||(input.LA(1) >= DVAR && input.LA(1) <= FILE)||(input.LA(1) >= FROM && input.LA(1) <= GIVEN)||(input.LA(1) >= INCLUDE && input.LA(1) <= INT)||input.LA(1)==INTEGERTYPE||(input.LA(1) >= LHSGTRHS && input.LA(1) <= MONTH_CONST)||(input.LA(1) >= NAME && input.LA(1) <= SUM)||(input.LA(1) >= TAFCFS && input.LA(1) <= WHERE)||input.LA(1)==YEAR ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set102));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "usedKeywords"


	public static class tableSQL_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tableSQL"
	// ValueEvaluatorTree.g:155:1: tableSQL : SELECT selectName FROM i1= IDENT ( GIVEN a= assignStatement )? ( USE i2= IDENT )? ( where_items )? -> ^( SELECT selectName $i1 ( assignStatement )? ( $i2)? ( where_items )? ) ;
	public final ValueEvaluatorTreeParser.tableSQL_return tableSQL() throws RecognitionException {
		ValueEvaluatorTreeParser.tableSQL_return retval = new ValueEvaluatorTreeParser.tableSQL_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i1=null;
		Token i2=null;
		Token SELECT103=null;
		Token FROM105=null;
		Token GIVEN106=null;
		Token USE107=null;
		ParserRuleReturnScope a =null;
		ParserRuleReturnScope selectName104 =null;
		ParserRuleReturnScope where_items108 =null;

		CommonTree i1_tree=null;
		CommonTree i2_tree=null;
		CommonTree SELECT103_tree=null;
		CommonTree FROM105_tree=null;
		CommonTree GIVEN106_tree=null;
		CommonTree USE107_tree=null;
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_USE=new RewriteRuleTokenStream(adaptor,"token USE");
		RewriteRuleTokenStream stream_GIVEN=new RewriteRuleTokenStream(adaptor,"token GIVEN");
		RewriteRuleTokenStream stream_FROM=new RewriteRuleTokenStream(adaptor,"token FROM");
		RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
		RewriteRuleSubtreeStream stream_where_items=new RewriteRuleSubtreeStream(adaptor,"rule where_items");
		RewriteRuleSubtreeStream stream_assignStatement=new RewriteRuleSubtreeStream(adaptor,"rule assignStatement");
		RewriteRuleSubtreeStream stream_selectName=new RewriteRuleSubtreeStream(adaptor,"rule selectName");

		try {
			// ValueEvaluatorTree.g:155:10: ( SELECT selectName FROM i1= IDENT ( GIVEN a= assignStatement )? ( USE i2= IDENT )? ( where_items )? -> ^( SELECT selectName $i1 ( assignStatement )? ( $i2)? ( where_items )? ) )
			// ValueEvaluatorTree.g:155:12: SELECT selectName FROM i1= IDENT ( GIVEN a= assignStatement )? ( USE i2= IDENT )? ( where_items )?
			{
			SELECT103=(Token)match(input,SELECT,FOLLOW_SELECT_in_tableSQL1030);  
			stream_SELECT.add(SELECT103);

			pushFollow(FOLLOW_selectName_in_tableSQL1032);
			selectName104=selectName();
			state._fsp--;

			stream_selectName.add(selectName104.getTree());
			FROM105=(Token)match(input,FROM,FOLLOW_FROM_in_tableSQL1034);  
			stream_FROM.add(FROM105);

			i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_tableSQL1038);  
			stream_IDENT.add(i1);

			// ValueEvaluatorTree.g:155:44: ( GIVEN a= assignStatement )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==GIVEN) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// ValueEvaluatorTree.g:155:45: GIVEN a= assignStatement
					{
					GIVEN106=(Token)match(input,GIVEN,FOLLOW_GIVEN_in_tableSQL1041);  
					stream_GIVEN.add(GIVEN106);

					pushFollow(FOLLOW_assignStatement_in_tableSQL1045);
					a=assignStatement();
					state._fsp--;

					stream_assignStatement.add(a.getTree());
					}
					break;

			}

			// ValueEvaluatorTree.g:155:71: ( USE i2= IDENT )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==USE) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// ValueEvaluatorTree.g:155:72: USE i2= IDENT
					{
					USE107=(Token)match(input,USE,FOLLOW_USE_in_tableSQL1050);  
					stream_USE.add(USE107);

					i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_tableSQL1054);  
					stream_IDENT.add(i2);

					}
					break;

			}

			// ValueEvaluatorTree.g:155:87: ( where_items )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==WHERE) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// ValueEvaluatorTree.g:155:88: where_items
					{
					pushFollow(FOLLOW_where_items_in_tableSQL1059);
					where_items108=where_items();
					state._fsp--;

					stream_where_items.add(where_items108.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: i2, selectName, assignStatement, SELECT, where_items, i1
			// token labels: i1, i2
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i1=new RewriteRuleTokenStream(adaptor,"token i1",i1);
			RewriteRuleTokenStream stream_i2=new RewriteRuleTokenStream(adaptor,"token i2",i2);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 155:105: -> ^( SELECT selectName $i1 ( assignStatement )? ( $i2)? ( where_items )? )
			{
				// ValueEvaluatorTree.g:155:108: ^( SELECT selectName $i1 ( assignStatement )? ( $i2)? ( where_items )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_SELECT.nextNode(), root_1);
				adaptor.addChild(root_1, stream_selectName.nextTree());
				adaptor.addChild(root_1, stream_i1.nextNode());
				// ValueEvaluatorTree.g:155:132: ( assignStatement )?
				if ( stream_assignStatement.hasNext() ) {
					adaptor.addChild(root_1, stream_assignStatement.nextTree());
				}
				stream_assignStatement.reset();

				// ValueEvaluatorTree.g:155:150: ( $i2)?
				if ( stream_i2.hasNext() ) {
					adaptor.addChild(root_1, stream_i2.nextNode());
				}
				stream_i2.reset();

				// ValueEvaluatorTree.g:155:154: ( where_items )?
				if ( stream_where_items.hasNext() ) {
					adaptor.addChild(root_1, stream_where_items.nextTree());
				}
				stream_where_items.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tableSQL"


	public static class selectName_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "selectName"
	// ValueEvaluatorTree.g:158:1: selectName : ( ( IDENT -> IDENT ) | ( usedKeywords -> usedKeywords ) );
	public final ValueEvaluatorTreeParser.selectName_return selectName() throws RecognitionException {
		ValueEvaluatorTreeParser.selectName_return retval = new ValueEvaluatorTreeParser.selectName_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT109=null;
		ParserRuleReturnScope usedKeywords110 =null;

		CommonTree IDENT109_tree=null;
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleSubtreeStream stream_usedKeywords=new RewriteRuleSubtreeStream(adaptor,"rule usedKeywords");

		try {
			// ValueEvaluatorTree.g:158:11: ( ( IDENT -> IDENT ) | ( usedKeywords -> usedKeywords ) )
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==IDENT) ) {
				alt21=1;
			}
			else if ( ((LA21_0 >= ABS && LA21_0 <= ALWAYS)||LA21_0==CASE||(LA21_0 >= CONDITION && LA21_0 <= DAYSIN)||(LA21_0 >= DVAR && LA21_0 <= FILE)||(LA21_0 >= FROM && LA21_0 <= GIVEN)||(LA21_0 >= INCLUDE && LA21_0 <= INT)||LA21_0==INTEGERTYPE||(LA21_0 >= LHSGTRHS && LA21_0 <= MONTH_CONST)||(LA21_0 >= NAME && LA21_0 <= SUM)||(LA21_0 >= TAFCFS && LA21_0 <= WHERE)||LA21_0==YEAR) ) {
				alt21=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}

			switch (alt21) {
				case 1 :
					// ValueEvaluatorTree.g:158:13: ( IDENT -> IDENT )
					{
					// ValueEvaluatorTree.g:158:13: ( IDENT -> IDENT )
					// ValueEvaluatorTree.g:158:14: IDENT
					{
					IDENT109=(Token)match(input,IDENT,FOLLOW_IDENT_in_selectName1096);  
					stream_IDENT.add(IDENT109);

					// AST REWRITE
					// elements: IDENT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 158:20: -> IDENT
					{
						adaptor.addChild(root_0, stream_IDENT.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:158:30: ( usedKeywords -> usedKeywords )
					{
					// ValueEvaluatorTree.g:158:30: ( usedKeywords -> usedKeywords )
					// ValueEvaluatorTree.g:158:31: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_selectName1104);
					usedKeywords110=usedKeywords();
					state._fsp--;

					stream_usedKeywords.add(usedKeywords110.getTree());
					// AST REWRITE
					// elements: usedKeywords
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 158:44: -> usedKeywords
					{
						adaptor.addChild(root_0, stream_usedKeywords.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "selectName"


	public static class where_items_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "where_items"
	// ValueEvaluatorTree.g:160:1: where_items : WHERE (w1= whereStatement ) ( addWhereStatement )* -> ^( WHERE $w1 ( addWhereStatement )* ) ;
	public final ValueEvaluatorTreeParser.where_items_return where_items() throws RecognitionException {
		ValueEvaluatorTreeParser.where_items_return retval = new ValueEvaluatorTreeParser.where_items_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token WHERE111=null;
		ParserRuleReturnScope w1 =null;
		ParserRuleReturnScope addWhereStatement112 =null;

		CommonTree WHERE111_tree=null;
		RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
		RewriteRuleSubtreeStream stream_addWhereStatement=new RewriteRuleSubtreeStream(adaptor,"rule addWhereStatement");
		RewriteRuleSubtreeStream stream_whereStatement=new RewriteRuleSubtreeStream(adaptor,"rule whereStatement");

		try {
			// ValueEvaluatorTree.g:161:2: ( WHERE (w1= whereStatement ) ( addWhereStatement )* -> ^( WHERE $w1 ( addWhereStatement )* ) )
			// ValueEvaluatorTree.g:161:5: WHERE (w1= whereStatement ) ( addWhereStatement )*
			{
			WHERE111=(Token)match(input,WHERE,FOLLOW_WHERE_in_where_items1119);  
			stream_WHERE.add(WHERE111);

			// ValueEvaluatorTree.g:161:12: (w1= whereStatement )
			// ValueEvaluatorTree.g:161:13: w1= whereStatement
			{
			pushFollow(FOLLOW_whereStatement_in_where_items1125);
			w1=whereStatement();
			state._fsp--;

			stream_whereStatement.add(w1.getTree());
			}

			// ValueEvaluatorTree.g:162:10: ( addWhereStatement )*
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==77) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// ValueEvaluatorTree.g:162:11: addWhereStatement
					{
					pushFollow(FOLLOW_addWhereStatement_in_where_items1138);
					addWhereStatement112=addWhereStatement();
					state._fsp--;

					stream_addWhereStatement.add(addWhereStatement112.getTree());
					}
					break;

				default :
					break loop22;
				}
			}

			// AST REWRITE
			// elements: WHERE, w1, addWhereStatement
			// token labels: 
			// rule labels: w1, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_w1=new RewriteRuleSubtreeStream(adaptor,"rule w1",w1!=null?w1.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 162:31: -> ^( WHERE $w1 ( addWhereStatement )* )
			{
				// ValueEvaluatorTree.g:162:33: ^( WHERE $w1 ( addWhereStatement )* )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_WHERE.nextNode(), root_1);
				adaptor.addChild(root_1, stream_w1.nextTree());
				// ValueEvaluatorTree.g:162:45: ( addWhereStatement )*
				while ( stream_addWhereStatement.hasNext() ) {
					adaptor.addChild(root_1, stream_addWhereStatement.nextTree());
				}
				stream_addWhereStatement.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "where_items"


	public static class addWhereStatement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "addWhereStatement"
	// ValueEvaluatorTree.g:165:1: addWhereStatement : ';' whereStatement -> whereStatement ;
	public final ValueEvaluatorTreeParser.addWhereStatement_return addWhereStatement() throws RecognitionException {
		ValueEvaluatorTreeParser.addWhereStatement_return retval = new ValueEvaluatorTreeParser.addWhereStatement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal113=null;
		ParserRuleReturnScope whereStatement114 =null;

		CommonTree char_literal113_tree=null;
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleSubtreeStream stream_whereStatement=new RewriteRuleSubtreeStream(adaptor,"rule whereStatement");

		try {
			// ValueEvaluatorTree.g:166:3: ( ';' whereStatement -> whereStatement )
			// ValueEvaluatorTree.g:166:5: ';' whereStatement
			{
			char_literal113=(Token)match(input,77,FOLLOW_77_in_addWhereStatement1163);  
			stream_77.add(char_literal113);

			pushFollow(FOLLOW_whereStatement_in_addWhereStatement1165);
			whereStatement114=whereStatement();
			state._fsp--;

			stream_whereStatement.add(whereStatement114.getTree());
			// AST REWRITE
			// elements: whereStatement
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 166:24: -> whereStatement
			{
				adaptor.addChild(root_0, stream_whereStatement.nextTree());
			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "addWhereStatement"


	public static class sumExpression_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "sumExpression"
	// ValueEvaluatorTree.g:184:1: sumExpression : SUM '(' IDENT '=' e1= expression ';' e2= expression ( ';' ( ( '-' )? INTEGER ) )? ')' e3= expression -> ^( SUM IDENT $e1 $e2 ( '-' )? ( INTEGER )? $e3) ;
	public final ValueEvaluatorTreeParser.sumExpression_return sumExpression() throws RecognitionException {
		ValueEvaluatorTreeParser.sumExpression_return retval = new ValueEvaluatorTreeParser.sumExpression_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SUM115=null;
		Token char_literal116=null;
		Token IDENT117=null;
		Token char_literal118=null;
		Token char_literal119=null;
		Token char_literal120=null;
		Token char_literal121=null;
		Token INTEGER122=null;
		Token char_literal123=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;
		ParserRuleReturnScope e3 =null;

		CommonTree SUM115_tree=null;
		CommonTree char_literal116_tree=null;
		CommonTree IDENT117_tree=null;
		CommonTree char_literal118_tree=null;
		CommonTree char_literal119_tree=null;
		CommonTree char_literal120_tree=null;
		CommonTree char_literal121_tree=null;
		CommonTree INTEGER122_tree=null;
		CommonTree char_literal123_tree=null;
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
		RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
		RewriteRuleTokenStream stream_SUM=new RewriteRuleTokenStream(adaptor,"token SUM");
		RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ValueEvaluatorTree.g:185:3: ( SUM '(' IDENT '=' e1= expression ';' e2= expression ( ';' ( ( '-' )? INTEGER ) )? ')' e3= expression -> ^( SUM IDENT $e1 $e2 ( '-' )? ( INTEGER )? $e3) )
			// ValueEvaluatorTree.g:185:5: SUM '(' IDENT '=' e1= expression ';' e2= expression ( ';' ( ( '-' )? INTEGER ) )? ')' e3= expression
			{
			SUM115=(Token)match(input,SUM,FOLLOW_SUM_in_sumExpression1198);  
			stream_SUM.add(SUM115);

			char_literal116=(Token)match(input,67,FOLLOW_67_in_sumExpression1200);  
			stream_67.add(char_literal116);

			IDENT117=(Token)match(input,IDENT,FOLLOW_IDENT_in_sumExpression1202);  
			stream_IDENT.add(IDENT117);

			char_literal118=(Token)match(input,80,FOLLOW_80_in_sumExpression1204);  
			stream_80.add(char_literal118);

			pushFollow(FOLLOW_expression_in_sumExpression1208);
			e1=expression();
			state._fsp--;

			stream_expression.add(e1.getTree());
			char_literal119=(Token)match(input,77,FOLLOW_77_in_sumExpression1210);  
			stream_77.add(char_literal119);

			pushFollow(FOLLOW_expression_in_sumExpression1214);
			e2=expression();
			state._fsp--;

			stream_expression.add(e2.getTree());
			// ValueEvaluatorTree.g:185:55: ( ';' ( ( '-' )? INTEGER ) )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==77) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// ValueEvaluatorTree.g:185:56: ';' ( ( '-' )? INTEGER )
					{
					char_literal120=(Token)match(input,77,FOLLOW_77_in_sumExpression1217);  
					stream_77.add(char_literal120);

					// ValueEvaluatorTree.g:185:60: ( ( '-' )? INTEGER )
					// ValueEvaluatorTree.g:185:61: ( '-' )? INTEGER
					{
					// ValueEvaluatorTree.g:185:61: ( '-' )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==71) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// ValueEvaluatorTree.g:185:62: '-'
							{
							char_literal121=(Token)match(input,71,FOLLOW_71_in_sumExpression1221);  
							stream_71.add(char_literal121);

							}
							break;

					}

					INTEGER122=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sumExpression1225);  
					stream_INTEGER.add(INTEGER122);

					}

					}
					break;

			}

			char_literal123=(Token)match(input,68,FOLLOW_68_in_sumExpression1231);  
			stream_68.add(char_literal123);

			pushFollow(FOLLOW_expression_in_sumExpression1236);
			e3=expression();
			state._fsp--;

			stream_expression.add(e3.getTree());
			// AST REWRITE
			// elements: IDENT, e2, SUM, INTEGER, e1, e3, 71
			// token labels: 
			// rule labels: e1, e2, e3, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_e1=new RewriteRuleSubtreeStream(adaptor,"rule e1",e1!=null?e1.getTree():null);
			RewriteRuleSubtreeStream stream_e2=new RewriteRuleSubtreeStream(adaptor,"rule e2",e2!=null?e2.getTree():null);
			RewriteRuleSubtreeStream stream_e3=new RewriteRuleSubtreeStream(adaptor,"rule e3",e3!=null?e3.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 186:5: -> ^( SUM IDENT $e1 $e2 ( '-' )? ( INTEGER )? $e3)
			{
				// ValueEvaluatorTree.g:186:8: ^( SUM IDENT $e1 $e2 ( '-' )? ( INTEGER )? $e3)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_SUM.nextNode(), root_1);
				adaptor.addChild(root_1, stream_IDENT.nextNode());
				adaptor.addChild(root_1, stream_e1.nextTree());
				adaptor.addChild(root_1, stream_e2.nextTree());
				// ValueEvaluatorTree.g:186:28: ( '-' )?
				if ( stream_71.hasNext() ) {
					adaptor.addChild(root_1, stream_71.nextNode());
				}
				stream_71.reset();

				// ValueEvaluatorTree.g:186:33: ( INTEGER )?
				if ( stream_INTEGER.hasNext() ) {
					adaptor.addChild(root_1, stream_INTEGER.nextNode());
				}
				stream_INTEGER.reset();

				adaptor.addChild(root_1, stream_e3.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "sumExpression"


	public static class term_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "term"
	// ValueEvaluatorTree.g:189:1: term : ( ( IDENT -> IDENT ) | ( FLOAT -> FLOAT ) | ( '(' ( expression ) ')' -> expression ) | ( knownTS -> knownTS ) | ( func -> func ) | ( INTEGER -> INTEGER ) | ( tafcfs_term -> tafcfs_term ) | ( YEAR -> YEAR ) | ( MONTH -> MONTH ) | ( MONTH_CONST -> MONTH_CONST ) | ( PASTMONTH -> PASTMONTH ) | ( DAYSIN -> DAYSIN ) | ( SVAR -> SVAR ) );
	public final ValueEvaluatorTreeParser.term_return term() throws RecognitionException {
		ValueEvaluatorTreeParser.term_return retval = new ValueEvaluatorTreeParser.term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT124=null;
		Token FLOAT125=null;
		Token char_literal126=null;
		Token char_literal128=null;
		Token INTEGER131=null;
		Token YEAR133=null;
		Token MONTH134=null;
		Token MONTH_CONST135=null;
		Token PASTMONTH136=null;
		Token DAYSIN137=null;
		Token SVAR138=null;
		ParserRuleReturnScope expression127 =null;
		ParserRuleReturnScope knownTS129 =null;
		ParserRuleReturnScope func130 =null;
		ParserRuleReturnScope tafcfs_term132 =null;

		CommonTree IDENT124_tree=null;
		CommonTree FLOAT125_tree=null;
		CommonTree char_literal126_tree=null;
		CommonTree char_literal128_tree=null;
		CommonTree INTEGER131_tree=null;
		CommonTree YEAR133_tree=null;
		CommonTree MONTH134_tree=null;
		CommonTree MONTH_CONST135_tree=null;
		CommonTree PASTMONTH136_tree=null;
		CommonTree DAYSIN137_tree=null;
		CommonTree SVAR138_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_FLOAT=new RewriteRuleTokenStream(adaptor,"token FLOAT");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_MONTH=new RewriteRuleTokenStream(adaptor,"token MONTH");
		RewriteRuleTokenStream stream_PASTMONTH=new RewriteRuleTokenStream(adaptor,"token PASTMONTH");
		RewriteRuleTokenStream stream_SVAR=new RewriteRuleTokenStream(adaptor,"token SVAR");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_YEAR=new RewriteRuleTokenStream(adaptor,"token YEAR");
		RewriteRuleTokenStream stream_MONTH_CONST=new RewriteRuleTokenStream(adaptor,"token MONTH_CONST");
		RewriteRuleTokenStream stream_DAYSIN=new RewriteRuleTokenStream(adaptor,"token DAYSIN");
		RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
		RewriteRuleSubtreeStream stream_knownTS=new RewriteRuleSubtreeStream(adaptor,"rule knownTS");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_tafcfs_term=new RewriteRuleSubtreeStream(adaptor,"rule tafcfs_term");
		RewriteRuleSubtreeStream stream_func=new RewriteRuleSubtreeStream(adaptor,"rule func");

		try {
			// ValueEvaluatorTree.g:190:2: ( ( IDENT -> IDENT ) | ( FLOAT -> FLOAT ) | ( '(' ( expression ) ')' -> expression ) | ( knownTS -> knownTS ) | ( func -> func ) | ( INTEGER -> INTEGER ) | ( tafcfs_term -> tafcfs_term ) | ( YEAR -> YEAR ) | ( MONTH -> MONTH ) | ( MONTH_CONST -> MONTH_CONST ) | ( PASTMONTH -> PASTMONTH ) | ( DAYSIN -> DAYSIN ) | ( SVAR -> SVAR ) )
			int alt25=13;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				int LA25_1 = input.LA(2);
				if ( (LA25_1==67||LA25_1==84) ) {
					alt25=4;
				}
				else if ( (LA25_1==EOF||LA25_1==MOD||LA25_1==USE||LA25_1==WHERE||(LA25_1 >= 68 && LA25_1 <= 71)||(LA25_1 >= 73 && LA25_1 <= 75)||(LA25_1 >= 77 && LA25_1 <= 79)||(LA25_1 >= 81 && LA25_1 <= 83)) ) {
					alt25=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 25, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case FLOAT:
				{
				alt25=2;
				}
				break;
			case 67:
				{
				alt25=3;
				}
				break;
			case ABS:
			case EXP:
			case INT:
			case LOG:
			case LOG10:
			case MAX:
			case MIN:
			case POW:
			case REAL:
				{
				alt25=5;
				}
				break;
			case INTEGER:
				{
				alt25=6;
				}
				break;
			case TAFCFS:
				{
				alt25=7;
				}
				break;
			case YEAR:
				{
				alt25=8;
				}
				break;
			case MONTH:
				{
				alt25=9;
				}
				break;
			case MONTH_CONST:
				{
				alt25=10;
				}
				break;
			case PASTMONTH:
				{
				alt25=11;
				}
				break;
			case DAYSIN:
				{
				alt25=12;
				}
				break;
			case SVAR:
				{
				alt25=13;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// ValueEvaluatorTree.g:190:4: ( IDENT -> IDENT )
					{
					// ValueEvaluatorTree.g:190:4: ( IDENT -> IDENT )
					// ValueEvaluatorTree.g:190:5: IDENT
					{
					IDENT124=(Token)match(input,IDENT,FOLLOW_IDENT_in_term1278);  
					stream_IDENT.add(IDENT124);

					// AST REWRITE
					// elements: IDENT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 190:11: -> IDENT
					{
						adaptor.addChild(root_0, stream_IDENT.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:191:4: ( FLOAT -> FLOAT )
					{
					// ValueEvaluatorTree.g:191:4: ( FLOAT -> FLOAT )
					// ValueEvaluatorTree.g:191:5: FLOAT
					{
					FLOAT125=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_term1289);  
					stream_FLOAT.add(FLOAT125);

					// AST REWRITE
					// elements: FLOAT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 191:11: -> FLOAT
					{
						adaptor.addChild(root_0, stream_FLOAT.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 3 :
					// ValueEvaluatorTree.g:192:4: ( '(' ( expression ) ')' -> expression )
					{
					// ValueEvaluatorTree.g:192:4: ( '(' ( expression ) ')' -> expression )
					// ValueEvaluatorTree.g:192:5: '(' ( expression ) ')'
					{
					char_literal126=(Token)match(input,67,FOLLOW_67_in_term1301);  
					stream_67.add(char_literal126);

					// ValueEvaluatorTree.g:192:9: ( expression )
					// ValueEvaluatorTree.g:192:10: expression
					{
					pushFollow(FOLLOW_expression_in_term1304);
					expression127=expression();
					state._fsp--;

					stream_expression.add(expression127.getTree());
					}

					char_literal128=(Token)match(input,68,FOLLOW_68_in_term1307);  
					stream_68.add(char_literal128);

					// AST REWRITE
					// elements: expression
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 192:26: -> expression
					{
						adaptor.addChild(root_0, stream_expression.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 4 :
					// ValueEvaluatorTree.g:193:4: ( knownTS -> knownTS )
					{
					// ValueEvaluatorTree.g:193:4: ( knownTS -> knownTS )
					// ValueEvaluatorTree.g:193:5: knownTS
					{
					pushFollow(FOLLOW_knownTS_in_term1318);
					knownTS129=knownTS();
					state._fsp--;

					stream_knownTS.add(knownTS129.getTree());
					// AST REWRITE
					// elements: knownTS
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 193:13: -> knownTS
					{
						adaptor.addChild(root_0, stream_knownTS.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 5 :
					// ValueEvaluatorTree.g:194:4: ( func -> func )
					{
					// ValueEvaluatorTree.g:194:4: ( func -> func )
					// ValueEvaluatorTree.g:194:5: func
					{
					pushFollow(FOLLOW_func_in_term1330);
					func130=func();
					state._fsp--;

					stream_func.add(func130.getTree());
					// AST REWRITE
					// elements: func
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 194:10: -> func
					{
						adaptor.addChild(root_0, stream_func.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 6 :
					// ValueEvaluatorTree.g:195:4: ( INTEGER -> INTEGER )
					{
					// ValueEvaluatorTree.g:195:4: ( INTEGER -> INTEGER )
					// ValueEvaluatorTree.g:195:5: INTEGER
					{
					INTEGER131=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_term1341);  
					stream_INTEGER.add(INTEGER131);

					// AST REWRITE
					// elements: INTEGER
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 195:13: -> INTEGER
					{
						adaptor.addChild(root_0, stream_INTEGER.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 7 :
					// ValueEvaluatorTree.g:196:4: ( tafcfs_term -> tafcfs_term )
					{
					// ValueEvaluatorTree.g:196:4: ( tafcfs_term -> tafcfs_term )
					// ValueEvaluatorTree.g:196:5: tafcfs_term
					{
					pushFollow(FOLLOW_tafcfs_term_in_term1352);
					tafcfs_term132=tafcfs_term();
					state._fsp--;

					stream_tafcfs_term.add(tafcfs_term132.getTree());
					// AST REWRITE
					// elements: tafcfs_term
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 196:17: -> tafcfs_term
					{
						adaptor.addChild(root_0, stream_tafcfs_term.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 8 :
					// ValueEvaluatorTree.g:197:4: ( YEAR -> YEAR )
					{
					// ValueEvaluatorTree.g:197:4: ( YEAR -> YEAR )
					// ValueEvaluatorTree.g:197:5: YEAR
					{
					YEAR133=(Token)match(input,YEAR,FOLLOW_YEAR_in_term1363);  
					stream_YEAR.add(YEAR133);

					// AST REWRITE
					// elements: YEAR
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 197:10: -> YEAR
					{
						adaptor.addChild(root_0, stream_YEAR.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 9 :
					// ValueEvaluatorTree.g:198:4: ( MONTH -> MONTH )
					{
					// ValueEvaluatorTree.g:198:4: ( MONTH -> MONTH )
					// ValueEvaluatorTree.g:198:5: MONTH
					{
					MONTH134=(Token)match(input,MONTH,FOLLOW_MONTH_in_term1373);  
					stream_MONTH.add(MONTH134);

					// AST REWRITE
					// elements: MONTH
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 198:11: -> MONTH
					{
						adaptor.addChild(root_0, stream_MONTH.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 10 :
					// ValueEvaluatorTree.g:199:4: ( MONTH_CONST -> MONTH_CONST )
					{
					// ValueEvaluatorTree.g:199:4: ( MONTH_CONST -> MONTH_CONST )
					// ValueEvaluatorTree.g:199:5: MONTH_CONST
					{
					MONTH_CONST135=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_term1383);  
					stream_MONTH_CONST.add(MONTH_CONST135);

					// AST REWRITE
					// elements: MONTH_CONST
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 199:17: -> MONTH_CONST
					{
						adaptor.addChild(root_0, stream_MONTH_CONST.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 11 :
					// ValueEvaluatorTree.g:200:4: ( PASTMONTH -> PASTMONTH )
					{
					// ValueEvaluatorTree.g:200:4: ( PASTMONTH -> PASTMONTH )
					// ValueEvaluatorTree.g:200:5: PASTMONTH
					{
					PASTMONTH136=(Token)match(input,PASTMONTH,FOLLOW_PASTMONTH_in_term1393);  
					stream_PASTMONTH.add(PASTMONTH136);

					// AST REWRITE
					// elements: PASTMONTH
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 200:15: -> PASTMONTH
					{
						adaptor.addChild(root_0, stream_PASTMONTH.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 12 :
					// ValueEvaluatorTree.g:201:4: ( DAYSIN -> DAYSIN )
					{
					// ValueEvaluatorTree.g:201:4: ( DAYSIN -> DAYSIN )
					// ValueEvaluatorTree.g:201:5: DAYSIN
					{
					DAYSIN137=(Token)match(input,DAYSIN,FOLLOW_DAYSIN_in_term1404);  
					stream_DAYSIN.add(DAYSIN137);

					// AST REWRITE
					// elements: DAYSIN
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 201:12: -> DAYSIN
					{
						adaptor.addChild(root_0, stream_DAYSIN.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 13 :
					// ValueEvaluatorTree.g:202:4: ( SVAR -> SVAR )
					{
					// ValueEvaluatorTree.g:202:4: ( SVAR -> SVAR )
					// ValueEvaluatorTree.g:202:5: SVAR
					{
					SVAR138=(Token)match(input,SVAR,FOLLOW_SVAR_in_term1415);  
					stream_SVAR.add(SVAR138);

					// AST REWRITE
					// elements: SVAR
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 202:10: -> SVAR
					{
						adaptor.addChild(root_0, stream_SVAR.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "term"


	public static class tafcfs_term_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tafcfs_term"
	// ValueEvaluatorTree.g:205:1: tafcfs_term : TAFCFS ( '(' expression ')' )? -> ^( TAFCFS ( expression )? ) ;
	public final ValueEvaluatorTreeParser.tafcfs_term_return tafcfs_term() throws RecognitionException {
		ValueEvaluatorTreeParser.tafcfs_term_return retval = new ValueEvaluatorTreeParser.tafcfs_term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token TAFCFS139=null;
		Token char_literal140=null;
		Token char_literal142=null;
		ParserRuleReturnScope expression141 =null;

		CommonTree TAFCFS139_tree=null;
		CommonTree char_literal140_tree=null;
		CommonTree char_literal142_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_TAFCFS=new RewriteRuleTokenStream(adaptor,"token TAFCFS");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ValueEvaluatorTree.g:205:13: ( TAFCFS ( '(' expression ')' )? -> ^( TAFCFS ( expression )? ) )
			// ValueEvaluatorTree.g:205:15: TAFCFS ( '(' expression ')' )?
			{
			TAFCFS139=(Token)match(input,TAFCFS,FOLLOW_TAFCFS_in_tafcfs_term1431);  
			stream_TAFCFS.add(TAFCFS139);

			// ValueEvaluatorTree.g:205:22: ( '(' expression ')' )?
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==67) ) {
				alt26=1;
			}
			switch (alt26) {
				case 1 :
					// ValueEvaluatorTree.g:205:23: '(' expression ')'
					{
					char_literal140=(Token)match(input,67,FOLLOW_67_in_tafcfs_term1434);  
					stream_67.add(char_literal140);

					pushFollow(FOLLOW_expression_in_tafcfs_term1436);
					expression141=expression();
					state._fsp--;

					stream_expression.add(expression141.getTree());
					char_literal142=(Token)match(input,68,FOLLOW_68_in_tafcfs_term1438);  
					stream_68.add(char_literal142);

					}
					break;

			}

			// AST REWRITE
			// elements: TAFCFS, expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 205:44: -> ^( TAFCFS ( expression )? )
			{
				// ValueEvaluatorTree.g:205:47: ^( TAFCFS ( expression )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_TAFCFS.nextNode(), root_1);
				// ValueEvaluatorTree.g:205:56: ( expression )?
				if ( stream_expression.hasNext() ) {
					adaptor.addChild(root_1, stream_expression.nextTree());
				}
				stream_expression.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tafcfs_term"


	public static class knownTS_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "knownTS"
	// ValueEvaluatorTree.g:208:1: knownTS : ( (f= function -> $f) | (p= pastCycleDV -> $p) );
	public final ValueEvaluatorTreeParser.knownTS_return knownTS() throws RecognitionException {
		ValueEvaluatorTreeParser.knownTS_return retval = new ValueEvaluatorTreeParser.knownTS_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope f =null;
		ParserRuleReturnScope p =null;

		RewriteRuleSubtreeStream stream_function=new RewriteRuleSubtreeStream(adaptor,"rule function");
		RewriteRuleSubtreeStream stream_pastCycleDV=new RewriteRuleSubtreeStream(adaptor,"rule pastCycleDV");

		try {
			// ValueEvaluatorTree.g:209:3: ( (f= function -> $f) | (p= pastCycleDV -> $p) )
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==IDENT) ) {
				int LA27_1 = input.LA(2);
				if ( (LA27_1==67) ) {
					alt27=1;
				}
				else if ( (LA27_1==84) ) {
					alt27=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 27, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}

			switch (alt27) {
				case 1 :
					// ValueEvaluatorTree.g:209:5: (f= function -> $f)
					{
					// ValueEvaluatorTree.g:209:5: (f= function -> $f)
					// ValueEvaluatorTree.g:209:6: f= function
					{
					pushFollow(FOLLOW_function_in_knownTS1468);
					f=function();
					state._fsp--;

					stream_function.add(f.getTree());
					// AST REWRITE
					// elements: f
					// token labels: 
					// rule labels: f, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_f=new RewriteRuleSubtreeStream(adaptor,"rule f",f!=null?f.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 209:17: -> $f
					{
						adaptor.addChild(root_0, stream_f.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:209:24: (p= pastCycleDV -> $p)
					{
					// ValueEvaluatorTree.g:209:24: (p= pastCycleDV -> $p)
					// ValueEvaluatorTree.g:209:25: p= pastCycleDV
					{
					pushFollow(FOLLOW_pastCycleDV_in_knownTS1479);
					p=pastCycleDV();
					state._fsp--;

					stream_pastCycleDV.add(p.getTree());
					// AST REWRITE
					// elements: p
					// token labels: 
					// rule labels: p, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_p=new RewriteRuleSubtreeStream(adaptor,"rule p",p!=null?p.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 209:39: -> $p
					{
						adaptor.addChild(root_0, stream_p.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "knownTS"


	public static class pastCycleDV_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "pastCycleDV"
	// ValueEvaluatorTree.g:220:1: pastCycleDV : i1= IDENT '[' i2= IDENT ']' -> ^( $i1 '[' $i2 ']' ) ;
	public final ValueEvaluatorTreeParser.pastCycleDV_return pastCycleDV() throws RecognitionException {
		ValueEvaluatorTreeParser.pastCycleDV_return retval = new ValueEvaluatorTreeParser.pastCycleDV_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i1=null;
		Token i2=null;
		Token char_literal143=null;
		Token char_literal144=null;

		CommonTree i1_tree=null;
		CommonTree i2_tree=null;
		CommonTree char_literal143_tree=null;
		CommonTree char_literal144_tree=null;
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_84=new RewriteRuleTokenStream(adaptor,"token 84");
		RewriteRuleTokenStream stream_85=new RewriteRuleTokenStream(adaptor,"token 85");

		try {
			// ValueEvaluatorTree.g:221:3: (i1= IDENT '[' i2= IDENT ']' -> ^( $i1 '[' $i2 ']' ) )
			// ValueEvaluatorTree.g:221:5: i1= IDENT '[' i2= IDENT ']'
			{
			i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleDV1515);  
			stream_IDENT.add(i1);

			char_literal143=(Token)match(input,84,FOLLOW_84_in_pastCycleDV1517);  
			stream_84.add(char_literal143);

			i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleDV1521);  
			stream_IDENT.add(i2);

			char_literal144=(Token)match(input,85,FOLLOW_85_in_pastCycleDV1523);  
			stream_85.add(char_literal144);

			// AST REWRITE
			// elements: i2, i1, 85, 84
			// token labels: i1, i2
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i1=new RewriteRuleTokenStream(adaptor,"token i1",i1);
			RewriteRuleTokenStream stream_i2=new RewriteRuleTokenStream(adaptor,"token i2",i2);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 221:31: -> ^( $i1 '[' $i2 ']' )
			{
				// ValueEvaluatorTree.g:221:34: ^( $i1 '[' $i2 ']' )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_i1.nextNode(), root_1);
				adaptor.addChild(root_1, stream_84.nextNode());
				adaptor.addChild(root_1, stream_i2.nextNode());
				adaptor.addChild(root_1, stream_85.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "pastCycleDV"


	public static class function_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "function"
	// ValueEvaluatorTree.g:224:1: function : ( (n= noArgFunction -> $n) | (a= argFunction -> $a) );
	public final ValueEvaluatorTreeParser.function_return function() throws RecognitionException {
		ValueEvaluatorTreeParser.function_return retval = new ValueEvaluatorTreeParser.function_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope n =null;
		ParserRuleReturnScope a =null;

		RewriteRuleSubtreeStream stream_argFunction=new RewriteRuleSubtreeStream(adaptor,"rule argFunction");
		RewriteRuleSubtreeStream stream_noArgFunction=new RewriteRuleSubtreeStream(adaptor,"rule noArgFunction");

		try {
			// ValueEvaluatorTree.g:225:3: ( (n= noArgFunction -> $n) | (a= argFunction -> $a) )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==IDENT) ) {
				int LA28_1 = input.LA(2);
				if ( (LA28_1==67) ) {
					int LA28_2 = input.LA(3);
					if ( (LA28_2==68) ) {
						alt28=1;
					}
					else if ( (LA28_2==ABS||LA28_2==DAYSIN||LA28_2==EXP||LA28_2==FLOAT||LA28_2==IDENT||(LA28_2 >= INT && LA28_2 <= INTEGER)||(LA28_2 >= LOG && LA28_2 <= LOG10)||(LA28_2 >= MAX && LA28_2 <= MIN)||(LA28_2 >= MONTH && LA28_2 <= MONTH_CONST)||(LA28_2 >= PASTMONTH && LA28_2 <= POW)||LA28_2==REAL||LA28_2==SVAR||LA28_2==TAFCFS||(LA28_2 >= YEAR && LA28_2 <= 67)||LA28_2==71) ) {
						alt28=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 28, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 28, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// ValueEvaluatorTree.g:225:5: (n= noArgFunction -> $n)
					{
					// ValueEvaluatorTree.g:225:5: (n= noArgFunction -> $n)
					// ValueEvaluatorTree.g:225:6: n= noArgFunction
					{
					pushFollow(FOLLOW_noArgFunction_in_function1555);
					n=noArgFunction();
					state._fsp--;

					stream_noArgFunction.add(n.getTree());
					// AST REWRITE
					// elements: n
					// token labels: 
					// rule labels: n, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_n=new RewriteRuleSubtreeStream(adaptor,"rule n",n!=null?n.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 225:21: -> $n
					{
						adaptor.addChild(root_0, stream_n.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:225:28: (a= argFunction -> $a)
					{
					// ValueEvaluatorTree.g:225:28: (a= argFunction -> $a)
					// ValueEvaluatorTree.g:225:29: a= argFunction
					{
					pushFollow(FOLLOW_argFunction_in_function1565);
					a=argFunction();
					state._fsp--;

					stream_argFunction.add(a.getTree());
					// AST REWRITE
					// elements: a
					// token labels: 
					// rule labels: a, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 225:42: -> $a
					{
						adaptor.addChild(root_0, stream_a.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "function"


	public static class noArgFunction_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "noArgFunction"
	// ValueEvaluatorTree.g:228:1: noArgFunction : IDENT '(' ')' -> ^( IDENT '(' ')' ) ;
	public final ValueEvaluatorTreeParser.noArgFunction_return noArgFunction() throws RecognitionException {
		ValueEvaluatorTreeParser.noArgFunction_return retval = new ValueEvaluatorTreeParser.noArgFunction_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT145=null;
		Token char_literal146=null;
		Token char_literal147=null;

		CommonTree IDENT145_tree=null;
		CommonTree char_literal146_tree=null;
		CommonTree char_literal147_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");

		try {
			// ValueEvaluatorTree.g:229:3: ( IDENT '(' ')' -> ^( IDENT '(' ')' ) )
			// ValueEvaluatorTree.g:229:5: IDENT '(' ')'
			{
			IDENT145=(Token)match(input,IDENT,FOLLOW_IDENT_in_noArgFunction1583);  
			stream_IDENT.add(IDENT145);

			char_literal146=(Token)match(input,67,FOLLOW_67_in_noArgFunction1585);  
			stream_67.add(char_literal146);

			char_literal147=(Token)match(input,68,FOLLOW_68_in_noArgFunction1587);  
			stream_68.add(char_literal147);

			// AST REWRITE
			// elements: IDENT, 67, 68
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 229:19: -> ^( IDENT '(' ')' )
			{
				// ValueEvaluatorTree.g:229:22: ^( IDENT '(' ')' )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_IDENT.nextNode(), root_1);
				adaptor.addChild(root_1, stream_67.nextNode());
				adaptor.addChild(root_1, stream_68.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "noArgFunction"


	public static class argFunction_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "argFunction"
	// ValueEvaluatorTree.g:231:1: argFunction : IDENT '(' e1= expression ( addarg )* ')' -> ^( IDENT '(' $e1 ( addarg )* ')' ) ;
	public final ValueEvaluatorTreeParser.argFunction_return argFunction() throws RecognitionException {
		ValueEvaluatorTreeParser.argFunction_return retval = new ValueEvaluatorTreeParser.argFunction_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT148=null;
		Token char_literal149=null;
		Token char_literal151=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope addarg150 =null;

		CommonTree IDENT148_tree=null;
		CommonTree char_literal149_tree=null;
		CommonTree char_literal151_tree=null;
		RewriteRuleTokenStream stream_67=new RewriteRuleTokenStream(adaptor,"token 67");
		RewriteRuleTokenStream stream_68=new RewriteRuleTokenStream(adaptor,"token 68");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_addarg=new RewriteRuleSubtreeStream(adaptor,"rule addarg");

		try {
			// ValueEvaluatorTree.g:232:3: ( IDENT '(' e1= expression ( addarg )* ')' -> ^( IDENT '(' $e1 ( addarg )* ')' ) )
			// ValueEvaluatorTree.g:232:5: IDENT '(' e1= expression ( addarg )* ')'
			{
			IDENT148=(Token)match(input,IDENT,FOLLOW_IDENT_in_argFunction1608);  
			stream_IDENT.add(IDENT148);

			char_literal149=(Token)match(input,67,FOLLOW_67_in_argFunction1610);  
			stream_67.add(char_literal149);

			pushFollow(FOLLOW_expression_in_argFunction1614);
			e1=expression();
			state._fsp--;

			stream_expression.add(e1.getTree());
			// ValueEvaluatorTree.g:232:30: ( addarg )*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==77) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// ValueEvaluatorTree.g:232:30: addarg
					{
					pushFollow(FOLLOW_addarg_in_argFunction1617);
					addarg150=addarg();
					state._fsp--;

					stream_addarg.add(addarg150.getTree());
					}
					break;

				default :
					break loop29;
				}
			}

			char_literal151=(Token)match(input,68,FOLLOW_68_in_argFunction1620);  
			stream_68.add(char_literal151);

			// AST REWRITE
			// elements: e1, 68, IDENT, addarg, 67
			// token labels: 
			// rule labels: e1, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_e1=new RewriteRuleSubtreeStream(adaptor,"rule e1",e1!=null?e1.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 232:42: -> ^( IDENT '(' $e1 ( addarg )* ')' )
			{
				// ValueEvaluatorTree.g:232:45: ^( IDENT '(' $e1 ( addarg )* ')' )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_IDENT.nextNode(), root_1);
				adaptor.addChild(root_1, stream_67.nextNode());
				adaptor.addChild(root_1, stream_e1.nextTree());
				// ValueEvaluatorTree.g:232:61: ( addarg )*
				while ( stream_addarg.hasNext() ) {
					adaptor.addChild(root_1, stream_addarg.nextTree());
				}
				stream_addarg.reset();

				adaptor.addChild(root_1, stream_68.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "argFunction"


	public static class addarg_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "addarg"
	// ValueEvaluatorTree.g:235:1: addarg : ';' expression -> expression ;
	public final ValueEvaluatorTreeParser.addarg_return addarg() throws RecognitionException {
		ValueEvaluatorTreeParser.addarg_return retval = new ValueEvaluatorTreeParser.addarg_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal152=null;
		ParserRuleReturnScope expression153 =null;

		CommonTree char_literal152_tree=null;
		RewriteRuleTokenStream stream_77=new RewriteRuleTokenStream(adaptor,"token 77");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ValueEvaluatorTree.g:236:3: ( ';' expression -> expression )
			// ValueEvaluatorTree.g:236:5: ';' expression
			{
			char_literal152=(Token)match(input,77,FOLLOW_77_in_addarg1653);  
			stream_77.add(char_literal152);

			pushFollow(FOLLOW_expression_in_addarg1655);
			expression153=expression();
			state._fsp--;

			stream_expression.add(expression153.getTree());
			// AST REWRITE
			// elements: expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 236:20: -> expression
			{
				adaptor.addChild(root_0, stream_expression.nextTree());
			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "addarg"


	public static class unary_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "unary"
	// ValueEvaluatorTree.g:239:1: unary : (s= '-' )? term -> {s==null}? term -> ^( UNARY term ) ;
	public final ValueEvaluatorTreeParser.unary_return unary() throws RecognitionException {
		ValueEvaluatorTreeParser.unary_return retval = new ValueEvaluatorTreeParser.unary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		ParserRuleReturnScope term154 =null;

		CommonTree s_tree=null;
		RewriteRuleTokenStream stream_71=new RewriteRuleTokenStream(adaptor,"token 71");
		RewriteRuleSubtreeStream stream_term=new RewriteRuleSubtreeStream(adaptor,"rule term");

		try {
			// ValueEvaluatorTree.g:240:2: ( (s= '-' )? term -> {s==null}? term -> ^( UNARY term ) )
			// ValueEvaluatorTree.g:240:4: (s= '-' )? term
			{
			// ValueEvaluatorTree.g:240:4: (s= '-' )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==71) ) {
				alt30=1;
			}
			switch (alt30) {
				case 1 :
					// ValueEvaluatorTree.g:240:5: s= '-'
					{
					s=(Token)match(input,71,FOLLOW_71_in_unary1678);  
					stream_71.add(s);

					}
					break;

			}

			pushFollow(FOLLOW_term_in_unary1682);
			term154=term();
			state._fsp--;

			stream_term.add(term154.getTree());
			// AST REWRITE
			// elements: term, term
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 240:18: -> {s==null}? term
			if (s==null) {
				adaptor.addChild(root_0, stream_term.nextTree());
			}

			else // 241:18: -> ^( UNARY term )
			{
				// ValueEvaluatorTree.g:241:21: ^( UNARY term )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(UNARY, "UNARY"), root_1);
				adaptor.addChild(root_1, stream_term.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "unary"


	public static class mult_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "mult"
	// ValueEvaluatorTree.g:249:1: mult : (u1= unary ) (s= ( '*' ^| '/' ^| MOD ^) (u2= unary ) )* ;
	public final ValueEvaluatorTreeParser.mult_return mult() throws RecognitionException {
		ValueEvaluatorTreeParser.mult_return retval = new ValueEvaluatorTreeParser.mult_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		ParserRuleReturnScope u1 =null;
		ParserRuleReturnScope u2 =null;

		CommonTree s_tree=null;

		try {
			// ValueEvaluatorTree.g:250:2: ( (u1= unary ) (s= ( '*' ^| '/' ^| MOD ^) (u2= unary ) )* )
			// ValueEvaluatorTree.g:250:4: (u1= unary ) (s= ( '*' ^| '/' ^| MOD ^) (u2= unary ) )*
			{
			root_0 = (CommonTree)adaptor.nil();


			// ValueEvaluatorTree.g:250:4: (u1= unary )
			// ValueEvaluatorTree.g:250:5: u1= unary
			{
			pushFollow(FOLLOW_unary_in_mult1736);
			u1=unary();
			state._fsp--;

			adaptor.addChild(root_0, u1.getTree());

			}

			// ValueEvaluatorTree.g:250:15: (s= ( '*' ^| '/' ^| MOD ^) (u2= unary ) )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==MOD||LA32_0==69||LA32_0==75) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// ValueEvaluatorTree.g:250:16: s= ( '*' ^| '/' ^| MOD ^) (u2= unary )
					{
					// ValueEvaluatorTree.g:250:18: ( '*' ^| '/' ^| MOD ^)
					int alt31=3;
					switch ( input.LA(1) ) {
					case 69:
						{
						alt31=1;
						}
						break;
					case 75:
						{
						alt31=2;
						}
						break;
					case MOD:
						{
						alt31=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 31, 0, input);
						throw nvae;
					}
					switch (alt31) {
						case 1 :
							// ValueEvaluatorTree.g:250:19: '*' ^
							{
							s=(Token)match(input,69,FOLLOW_69_in_mult1743); 
							s_tree = (CommonTree)adaptor.create(s);
							root_0 = (CommonTree)adaptor.becomeRoot(s_tree, root_0);

							}
							break;
						case 2 :
							// ValueEvaluatorTree.g:250:25: '/' ^
							{
							s=(Token)match(input,75,FOLLOW_75_in_mult1747); 
							s_tree = (CommonTree)adaptor.create(s);
							root_0 = (CommonTree)adaptor.becomeRoot(s_tree, root_0);

							}
							break;
						case 3 :
							// ValueEvaluatorTree.g:250:31: MOD ^
							{
							s=(Token)match(input,MOD,FOLLOW_MOD_in_mult1751); 
							s_tree = (CommonTree)adaptor.create(s);
							root_0 = (CommonTree)adaptor.becomeRoot(s_tree, root_0);

							}
							break;

					}

					// ValueEvaluatorTree.g:250:37: (u2= unary )
					// ValueEvaluatorTree.g:250:38: u2= unary
					{
					pushFollow(FOLLOW_unary_in_mult1758);
					u2=unary();
					state._fsp--;

					adaptor.addChild(root_0, u2.getTree());

					}

					}
					break;

				default :
					break loop32;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "mult"


	public static class add_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "add"
	// ValueEvaluatorTree.g:253:1: add : (m1= mult ) ( (s= ( '+' ^| '-' ^) ) (m2= mult ) )* ;
	public final ValueEvaluatorTreeParser.add_return add() throws RecognitionException {
		ValueEvaluatorTreeParser.add_return retval = new ValueEvaluatorTreeParser.add_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		ParserRuleReturnScope m1 =null;
		ParserRuleReturnScope m2 =null;

		CommonTree s_tree=null;

		try {
			// ValueEvaluatorTree.g:254:2: ( (m1= mult ) ( (s= ( '+' ^| '-' ^) ) (m2= mult ) )* )
			// ValueEvaluatorTree.g:254:4: (m1= mult ) ( (s= ( '+' ^| '-' ^) ) (m2= mult ) )*
			{
			root_0 = (CommonTree)adaptor.nil();


			// ValueEvaluatorTree.g:254:4: (m1= mult )
			// ValueEvaluatorTree.g:254:5: m1= mult
			{
			pushFollow(FOLLOW_mult_in_add1778);
			m1=mult();
			state._fsp--;

			adaptor.addChild(root_0, m1.getTree());

			}

			// ValueEvaluatorTree.g:254:14: ( (s= ( '+' ^| '-' ^) ) (m2= mult ) )*
			loop34:
			while (true) {
				int alt34=2;
				int LA34_0 = input.LA(1);
				if ( ((LA34_0 >= 70 && LA34_0 <= 71)) ) {
					alt34=1;
				}

				switch (alt34) {
				case 1 :
					// ValueEvaluatorTree.g:254:15: (s= ( '+' ^| '-' ^) ) (m2= mult )
					{
					// ValueEvaluatorTree.g:254:15: (s= ( '+' ^| '-' ^) )
					// ValueEvaluatorTree.g:254:16: s= ( '+' ^| '-' ^)
					{
					// ValueEvaluatorTree.g:254:18: ( '+' ^| '-' ^)
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0==70) ) {
						alt33=1;
					}
					else if ( (LA33_0==71) ) {
						alt33=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 33, 0, input);
						throw nvae;
					}

					switch (alt33) {
						case 1 :
							// ValueEvaluatorTree.g:254:19: '+' ^
							{
							s=(Token)match(input,70,FOLLOW_70_in_add1786); 
							s_tree = (CommonTree)adaptor.create(s);
							root_0 = (CommonTree)adaptor.becomeRoot(s_tree, root_0);

							}
							break;
						case 2 :
							// ValueEvaluatorTree.g:254:24: '-' ^
							{
							s=(Token)match(input,71,FOLLOW_71_in_add1789); 
							s_tree = (CommonTree)adaptor.create(s);
							root_0 = (CommonTree)adaptor.becomeRoot(s_tree, root_0);

							}
							break;

					}

					}

					// ValueEvaluatorTree.g:254:31: (m2= mult )
					// ValueEvaluatorTree.g:254:32: m2= mult
					{
					pushFollow(FOLLOW_mult_in_add1797);
					m2=mult();
					state._fsp--;

					adaptor.addChild(root_0, m2.getTree());

					}

					}
					break;

				default :
					break loop34;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "add"


	public static class expression_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// ValueEvaluatorTree.g:257:1: expression : add -> add ;
	public final ValueEvaluatorTreeParser.expression_return expression() throws RecognitionException {
		ValueEvaluatorTreeParser.expression_return retval = new ValueEvaluatorTreeParser.expression_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope add155 =null;

		RewriteRuleSubtreeStream stream_add=new RewriteRuleSubtreeStream(adaptor,"rule add");

		try {
			// ValueEvaluatorTree.g:258:2: ( add -> add )
			// ValueEvaluatorTree.g:258:4: add
			{
			pushFollow(FOLLOW_add_in_expression1812);
			add155=add();
			state._fsp--;

			stream_add.add(add155.getTree());
			// AST REWRITE
			// elements: add
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 258:9: -> add
			{
				adaptor.addChild(root_0, stream_add.nextTree());
			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class relation_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "relation"
	// ValueEvaluatorTree.g:261:1: relation : ( '==' | '<' | '>' | '>=' | '<=' );
	public final ValueEvaluatorTreeParser.relation_return relation() throws RecognitionException {
		ValueEvaluatorTreeParser.relation_return retval = new ValueEvaluatorTreeParser.relation_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set156=null;

		CommonTree set156_tree=null;

		try {
			// ValueEvaluatorTree.g:262:2: ( '==' | '<' | '>' | '>=' | '<=' )
			// ValueEvaluatorTree.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set156=input.LT(1);
			if ( (input.LA(1) >= 78 && input.LA(1) <= 79)||(input.LA(1) >= 81 && input.LA(1) <= 83) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set156));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "relation"


	public static class whereStatement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "whereStatement"
	// ValueEvaluatorTree.g:269:1: whereStatement : whereName '=' expression -> ^( WHERE whereName expression ) ;
	public final ValueEvaluatorTreeParser.whereStatement_return whereStatement() throws RecognitionException {
		ValueEvaluatorTreeParser.whereStatement_return retval = new ValueEvaluatorTreeParser.whereStatement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal158=null;
		ParserRuleReturnScope whereName157 =null;
		ParserRuleReturnScope expression159 =null;

		CommonTree char_literal158_tree=null;
		RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_whereName=new RewriteRuleSubtreeStream(adaptor,"rule whereName");

		try {
			// ValueEvaluatorTree.g:270:3: ( whereName '=' expression -> ^( WHERE whereName expression ) )
			// ValueEvaluatorTree.g:270:5: whereName '=' expression
			{
			pushFollow(FOLLOW_whereName_in_whereStatement1861);
			whereName157=whereName();
			state._fsp--;

			stream_whereName.add(whereName157.getTree());
			char_literal158=(Token)match(input,80,FOLLOW_80_in_whereStatement1863);  
			stream_80.add(char_literal158);

			pushFollow(FOLLOW_expression_in_whereStatement1865);
			expression159=expression();
			state._fsp--;

			stream_expression.add(expression159.getTree());
			// AST REWRITE
			// elements: expression, whereName
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 270:30: -> ^( WHERE whereName expression )
			{
				// ValueEvaluatorTree.g:270:33: ^( WHERE whereName expression )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(WHERE, "WHERE"), root_1);
				adaptor.addChild(root_1, stream_whereName.nextTree());
				adaptor.addChild(root_1, stream_expression.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "whereStatement"


	public static class whereName_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "whereName"
	// ValueEvaluatorTree.g:273:1: whereName : ( ( IDENT -> IDENT ) | ( usedKeywords -> usedKeywords ) );
	public final ValueEvaluatorTreeParser.whereName_return whereName() throws RecognitionException {
		ValueEvaluatorTreeParser.whereName_return retval = new ValueEvaluatorTreeParser.whereName_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT160=null;
		ParserRuleReturnScope usedKeywords161 =null;

		CommonTree IDENT160_tree=null;
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleSubtreeStream stream_usedKeywords=new RewriteRuleSubtreeStream(adaptor,"rule usedKeywords");

		try {
			// ValueEvaluatorTree.g:273:10: ( ( IDENT -> IDENT ) | ( usedKeywords -> usedKeywords ) )
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==IDENT) ) {
				alt35=1;
			}
			else if ( ((LA35_0 >= ABS && LA35_0 <= ALWAYS)||LA35_0==CASE||(LA35_0 >= CONDITION && LA35_0 <= DAYSIN)||(LA35_0 >= DVAR && LA35_0 <= FILE)||(LA35_0 >= FROM && LA35_0 <= GIVEN)||(LA35_0 >= INCLUDE && LA35_0 <= INT)||LA35_0==INTEGERTYPE||(LA35_0 >= LHSGTRHS && LA35_0 <= MONTH_CONST)||(LA35_0 >= NAME && LA35_0 <= SUM)||(LA35_0 >= TAFCFS && LA35_0 <= WHERE)||LA35_0==YEAR) ) {
				alt35=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}

			switch (alt35) {
				case 1 :
					// ValueEvaluatorTree.g:273:12: ( IDENT -> IDENT )
					{
					// ValueEvaluatorTree.g:273:12: ( IDENT -> IDENT )
					// ValueEvaluatorTree.g:273:13: IDENT
					{
					IDENT160=(Token)match(input,IDENT,FOLLOW_IDENT_in_whereName1888);  
					stream_IDENT.add(IDENT160);

					// AST REWRITE
					// elements: IDENT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 273:19: -> IDENT
					{
						adaptor.addChild(root_0, stream_IDENT.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:273:29: ( usedKeywords -> usedKeywords )
					{
					// ValueEvaluatorTree.g:273:29: ( usedKeywords -> usedKeywords )
					// ValueEvaluatorTree.g:273:30: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_whereName1896);
					usedKeywords161=usedKeywords();
					state._fsp--;

					stream_usedKeywords.add(usedKeywords161.getTree());
					// AST REWRITE
					// elements: usedKeywords
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 273:43: -> usedKeywords
					{
						adaptor.addChild(root_0, stream_usedKeywords.nextTree());
					}


					retval.tree = root_0;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "whereName"


	public static class assignStatement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assignStatement"
	// ValueEvaluatorTree.g:275:1: assignStatement : IDENT '=' expression -> ^( '=' IDENT expression ) ;
	public final ValueEvaluatorTreeParser.assignStatement_return assignStatement() throws RecognitionException {
		ValueEvaluatorTreeParser.assignStatement_return retval = new ValueEvaluatorTreeParser.assignStatement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT162=null;
		Token char_literal163=null;
		ParserRuleReturnScope expression164 =null;

		CommonTree IDENT162_tree=null;
		CommonTree char_literal163_tree=null;
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_80=new RewriteRuleTokenStream(adaptor,"token 80");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// ValueEvaluatorTree.g:276:3: ( IDENT '=' expression -> ^( '=' IDENT expression ) )
			// ValueEvaluatorTree.g:276:5: IDENT '=' expression
			{
			IDENT162=(Token)match(input,IDENT,FOLLOW_IDENT_in_assignStatement1914);  
			stream_IDENT.add(IDENT162);

			char_literal163=(Token)match(input,80,FOLLOW_80_in_assignStatement1916);  
			stream_80.add(char_literal163);

			pushFollow(FOLLOW_expression_in_assignStatement1918);
			expression164=expression();
			state._fsp--;

			stream_expression.add(expression164.getTree());
			// AST REWRITE
			// elements: IDENT, 80, expression
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 276:26: -> ^( '=' IDENT expression )
			{
				// ValueEvaluatorTree.g:276:29: ^( '=' IDENT expression )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_80.nextNode(), root_1);
				adaptor.addChild(root_1, stream_IDENT.nextNode());
				adaptor.addChild(root_1, stream_expression.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignStatement"


	public static class number_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "number"
	// ValueEvaluatorTree.g:279:1: number : ( ( INTEGER -> INTEGER ) | ( FLOAT -> FLOAT ) );
	public final ValueEvaluatorTreeParser.number_return number() throws RecognitionException {
		ValueEvaluatorTreeParser.number_return retval = new ValueEvaluatorTreeParser.number_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INTEGER165=null;
		Token FLOAT166=null;

		CommonTree INTEGER165_tree=null;
		CommonTree FLOAT166_tree=null;
		RewriteRuleTokenStream stream_FLOAT=new RewriteRuleTokenStream(adaptor,"token FLOAT");
		RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");

		try {
			// ValueEvaluatorTree.g:280:2: ( ( INTEGER -> INTEGER ) | ( FLOAT -> FLOAT ) )
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==INTEGER) ) {
				alt36=1;
			}
			else if ( (LA36_0==FLOAT) ) {
				alt36=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 36, 0, input);
				throw nvae;
			}

			switch (alt36) {
				case 1 :
					// ValueEvaluatorTree.g:280:4: ( INTEGER -> INTEGER )
					{
					// ValueEvaluatorTree.g:280:4: ( INTEGER -> INTEGER )
					// ValueEvaluatorTree.g:280:5: INTEGER
					{
					INTEGER165=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_number1942);  
					stream_INTEGER.add(INTEGER165);

					// AST REWRITE
					// elements: INTEGER
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 280:12: -> INTEGER
					{
						adaptor.addChild(root_0, stream_INTEGER.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:281:4: ( FLOAT -> FLOAT )
					{
					// ValueEvaluatorTree.g:281:4: ( FLOAT -> FLOAT )
					// ValueEvaluatorTree.g:281:5: FLOAT
					{
					FLOAT166=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_number1952);  
					stream_FLOAT.add(FLOAT166);

					// AST REWRITE
					// elements: FLOAT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 281:10: -> FLOAT
					{
						adaptor.addChild(root_0, stream_FLOAT.nextNode());
					}


					retval.tree = root_0;

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "number"

	// Delegated rules



	public static final BitSet FOLLOW_expressionInput_in_evaluator61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditionInput_in_evaluator67 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_87_in_expressionInput81 = new BitSet(new long[]{0x21BD86EC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expressionCollection_in_expressionInput83 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_86_in_conditionInput96 = new BitSet(new long[]{0x00A786CC31092030L,0x000000000000008CL});
	public static final BitSet FOLLOW_conditionStatement_in_conditionInput98 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_lhsrhs115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONSTRAIN_in_lhsrhs117 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_units126 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_units129 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_75_in_units131 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IDENT_in_units133 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_76_in_fileName145 = new BitSet(new long[]{0xFFDFF7FF7FFFBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_77_in_fileName147 = new BitSet(new long[]{0xFFDFF7FF7FFFBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_72_in_fileName149 = new BitSet(new long[]{0xFFDFF7FF7FFFBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_88_in_fileName151 = new BitSet(new long[]{0xFFDFF7FF7FFFBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_SYMBOLS_in_fileName153 = new BitSet(new long[]{0xFFDFF7FF7FFFBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_71_in_fileName155 = new BitSet(new long[]{0xFFDFF7FF7FFFBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_70_in_fileName157 = new BitSet(new long[]{0xFFDFF7FF7FFFBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_BACKSLASH_in_fileName159 = new BitSet(new long[]{0xFFDFF7FF7FFFBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_IDENT_in_fileName161 = new BitSet(new long[]{0xFFDFF7FF7FFFBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_IDENT1_in_fileName163 = new BitSet(new long[]{0xFFDFF7FF7FFFBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_IDENT2_in_fileName165 = new BitSet(new long[]{0xFFDFF7FF7FFFBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_INTEGER_in_fileName167 = new BitSet(new long[]{0xFFDFF7FF7FFFBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_FLOAT_in_fileName169 = new BitSet(new long[]{0xFFDFF7FF7FFFBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_usedKeywords_in_fileName171 = new BitSet(new long[]{0xFFDFF7FF7FFFBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_77_in_externalFile190 = new BitSet(new long[]{0xFFDFF7FF79FFBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_72_in_externalFile192 = new BitSet(new long[]{0xFFDFF7FF79FFBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_88_in_externalFile194 = new BitSet(new long[]{0xFFDFF7FF79FFBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_SYMBOLS_in_externalFile196 = new BitSet(new long[]{0xFFDFF7FF79FFBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_71_in_externalFile198 = new BitSet(new long[]{0xFFDFF7FF79FFBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_70_in_externalFile200 = new BitSet(new long[]{0xFFDFF7FF79FFBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_INTEGER_in_externalFile202 = new BitSet(new long[]{0xFFDFF7FF79FFBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_FLOAT_in_externalFile204 = new BitSet(new long[]{0xFFDFF7FF79FFBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_IDENT_in_externalFile206 = new BitSet(new long[]{0xFFDFF7FF79FFBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_usedKeywords_in_externalFile208 = new BitSet(new long[]{0xFFDFF7FF79FFBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_LETTER_in_text222 = new BitSet(new long[]{0x0000000080004002L});
	public static final BitSet FOLLOW_relationStatementSeries_in_conditionStatement247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALWAYS_in_conditionStatement255 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_relationRangeStatement_in_relationStatementSeries276 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000600L});
	public static final BitSet FOLLOW_73_in_relationStatementSeries290 = new BitSet(new long[]{0x00A786CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_74_in_relationStatementSeries293 = new BitSet(new long[]{0x00A786CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_relationRangeStatement_in_relationStatementSeries301 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000600L});
	public static final BitSet FOLLOW_relationStatement_in_relationRangeStatement315 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_range_func_in_relationRangeStatement323 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_relationStatement346 = new BitSet(new long[]{0x0000000000000000L,0x00000000000EC000L});
	public static final BitSet FOLLOW_relation_in_relationStatement349 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_relationStatement354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_expressionCollection381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tableSQL_in_expressionCollection389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timeseries_in_expressionCollection397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sumExpression_in_expressionCollection405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPPERUNBOUNDED_in_expressionCollection413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOWERUNBOUNDED_in_expressionCollection422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_max_func_in_func440 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_min_func_in_func445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_int_func_in_func450 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_real_func_in_func455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_abs_func_in_func460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_func_in_func465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_log_func_in_func470 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_log10_func_in_func475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pow_func_in_func480 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAX_in_max_func491 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_max_func493 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_max_func498 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_77_in_max_func502 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_max_func507 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002010L});
	public static final BitSet FOLLOW_68_in_max_func512 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MIN_in_min_func537 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_min_func539 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_min_func544 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_77_in_min_func547 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_min_func552 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002010L});
	public static final BitSet FOLLOW_68_in_min_func557 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_int_func583 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_int_func585 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_int_func590 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_int_func593 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REAL_in_real_func617 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_real_func619 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_real_func624 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_real_func627 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ABS_in_abs_func652 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_abs_func654 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_abs_func659 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_abs_func662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXP_in_exp_func684 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_exp_func686 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_exp_func691 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_exp_func694 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOG_in_log_func717 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_log_func719 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_log_func724 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_log_func727 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOG10_in_log10_func750 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_log10_func752 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_log10_func757 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_log10_func760 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_POW_in_pow_func784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_pow_func786 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_pow_func791 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_77_in_pow_func795 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_pow_func800 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_pow_func804 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANGE_in_range_func831 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_range_func833 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_MONTH_in_range_func835 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_77_in_range_func837 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_range_func841 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_77_in_range_func843 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_range_func847 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_range_func849 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TIMESERIES_in_timeseries877 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_partC895 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_IDENT1_in_partC897 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_usedKeywords_in_partC899 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_71_in_partC903 = new BitSet(new long[]{0xFF9FF7FF5BF7BEB0L,0x0000000000000005L});
	public static final BitSet FOLLOW_IDENT_in_partC906 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_IDENT1_in_partC908 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_usedKeywords_in_partC910 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_SELECT_in_tableSQL1030 = new BitSet(new long[]{0xFF9FF7FF59F7BEB0L,0x0000000000000005L});
	public static final BitSet FOLLOW_selectName_in_tableSQL1032 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_FROM_in_tableSQL1034 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IDENT_in_tableSQL1038 = new BitSet(new long[]{0x4000000000800002L,0x0000000000000001L});
	public static final BitSet FOLLOW_GIVEN_in_tableSQL1041 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_assignStatement_in_tableSQL1045 = new BitSet(new long[]{0x4000000000000002L,0x0000000000000001L});
	public static final BitSet FOLLOW_USE_in_tableSQL1050 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IDENT_in_tableSQL1054 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
	public static final BitSet FOLLOW_where_items_in_tableSQL1059 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_selectName1096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_usedKeywords_in_selectName1104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_where_items1119 = new BitSet(new long[]{0xFF9FF7FF59F7BEB0L,0x0000000000000005L});
	public static final BitSet FOLLOW_whereStatement_in_where_items1125 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_addWhereStatement_in_where_items1138 = new BitSet(new long[]{0x0000000000000002L,0x0000000000002000L});
	public static final BitSet FOLLOW_77_in_addWhereStatement1163 = new BitSet(new long[]{0xFF9FF7FF59F7BEB0L,0x0000000000000005L});
	public static final BitSet FOLLOW_whereStatement_in_addWhereStatement1165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SUM_in_sumExpression1198 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_sumExpression1200 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IDENT_in_sumExpression1202 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_sumExpression1204 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_sumExpression1208 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
	public static final BitSet FOLLOW_77_in_sumExpression1210 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_sumExpression1214 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002010L});
	public static final BitSet FOLLOW_77_in_sumExpression1217 = new BitSet(new long[]{0x0000000020000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_71_in_sumExpression1221 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTEGER_in_sumExpression1225 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_sumExpression1231 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_sumExpression1236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_term1278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_term1289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_67_in_term1301 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_term1304 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_term1307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_knownTS_in_term1318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_in_term1330 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_term1341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tafcfs_term_in_term1352 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_YEAR_in_term1363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONTH_in_term1373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONTH_CONST_in_term1383 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PASTMONTH_in_term1393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DAYSIN_in_term1404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SVAR_in_term1415 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TAFCFS_in_tafcfs_term1431 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_tafcfs_term1434 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_tafcfs_term1436 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_tafcfs_term1438 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_knownTS1468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pastCycleDV_in_knownTS1479 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleDV1515 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_pastCycleDV1517 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleDV1521 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_pastCycleDV1523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_noArgFunction_in_function1555 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_argFunction_in_function1565 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_noArgFunction1583 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_noArgFunction1585 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_noArgFunction1587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_argFunction1608 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_67_in_argFunction1610 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_argFunction1614 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002010L});
	public static final BitSet FOLLOW_addarg_in_argFunction1617 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002010L});
	public static final BitSet FOLLOW_68_in_argFunction1620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_77_in_addarg1653 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_addarg1655 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_71_in_unary1678 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000000CL});
	public static final BitSet FOLLOW_term_in_unary1682 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unary_in_mult1736 = new BitSet(new long[]{0x0000010000000002L,0x0000000000000820L});
	public static final BitSet FOLLOW_69_in_mult1743 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_75_in_mult1747 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_MOD_in_mult1751 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_unary_in_mult1758 = new BitSet(new long[]{0x0000010000000002L,0x0000000000000820L});
	public static final BitSet FOLLOW_mult_in_add1778 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
	public static final BitSet FOLLOW_70_in_add1786 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_71_in_add1789 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_mult_in_add1797 = new BitSet(new long[]{0x0000000000000002L,0x00000000000000C0L});
	public static final BitSet FOLLOW_add_in_expression1812 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_whereName_in_whereStatement1861 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_whereStatement1863 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_whereStatement1865 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_whereName1888 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_usedKeywords_in_whereName1896 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_assignStatement1914 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_assignStatement1916 = new BitSet(new long[]{0x00A586CC31092010L,0x000000000000008CL});
	public static final BitSet FOLLOW_expression_in_assignStatement1918 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_number1942 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_number1952 = new BitSet(new long[]{0x0000000000000002L});
}
