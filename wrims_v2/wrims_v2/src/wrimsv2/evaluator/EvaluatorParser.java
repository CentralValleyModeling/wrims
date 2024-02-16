// $ANTLR 3.5.2 Evaluator.g 2024-02-12 13:08:20

  package wrimsv2.evaluator;
    
  import org.antlr.runtime.ANTLRFileStream;
  import org.antlr.runtime.CharStream;
  import org.antlr.runtime.CommonTokenStream;
  import org.antlr.runtime.RecognitionException;
  import org.antlr.runtime.TokenStream;
  
  import java.util.HashMap;
  import wrimsv2.components.Error;
  import wrimsv2.components.IntDouble;
  import wrimsv2.parallel.ParallelVars; 


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class EvaluatorParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ABS", "ACOS", "ACOT", "ALL", 
		"ALWAYS", "AND", "ARRAY_ITERATOR", "ASIN", "ATAN", "BACKSLASH", "CASE", 
		"COMMENT", "CONDITION", "CONSTRAIN", "CONVERTUNITS", "COS", "COT", "CYCLE", 
		"DAY", "DAYSIN", "DAYSINTIMESTEP", "DIGIT", "DVAR", "EXCEEDANCE", "EXCEEDANCE_TSI", 
		"EXP", "EXPRESSION", "FILE", "FLOAT", "FROM", "FROM_WRESL_FILE", "FUNCTION", 
		"GIVEN", "IDENT", "IDENT1", "IDENT2", "INCLUDE", "INT", "INTEGER", "INTEGERTYPE", 
		"LETTER", "LHSGTRHS", "LHSLTRHS", "LOG", "LOG10", "LOWERBOUND", "LOWERUNBOUNDED", 
		"MAX", "MIN", "MOD", "MONTH", "MONTH_CONST", "MONTH_RANGE", "MULTILINE_COMMENT", 
		"NAME", "NOT", "OR", "ORDER", "OUTPUT", "PASTMONTH", "POW", "RANGE", "REAL", 
		"ROUND", "SELECT", "SIN", "SUM", "SVAR", "SYMBOLS", "TAFCFS", "TAN", "TYPE", 
		"UNITS", "UPPERBOUND", "UPPERUNBOUNDED", "USE", "WEIGHT", "WHERE", "WS", 
		"YEAR", "'('", "')'", "'*'", "'+'", "'-'", "'.'", "'/'", "':'", "';'", 
		"'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'['", "']'", "'c:'", "'g:'", 
		"'kind'", "'s:'", "'timeseries'", "'v:'", "'|'"
	};
	public static final int EOF=-1;
	public static final int T__84=84;
	public static final int T__85=85;
	public static final int T__86=86;
	public static final int T__87=87;
	public static final int T__88=88;
	public static final int T__89=89;
	public static final int T__90=90;
	public static final int T__91=91;
	public static final int T__92=92;
	public static final int T__93=93;
	public static final int T__94=94;
	public static final int T__95=95;
	public static final int T__96=96;
	public static final int T__97=97;
	public static final int T__98=98;
	public static final int T__99=99;
	public static final int T__100=100;
	public static final int T__101=101;
	public static final int T__102=102;
	public static final int T__103=103;
	public static final int T__104=104;
	public static final int T__105=105;
	public static final int T__106=106;
	public static final int T__107=107;
	public static final int ABS=4;
	public static final int ACOS=5;
	public static final int ACOT=6;
	public static final int ALL=7;
	public static final int ALWAYS=8;
	public static final int AND=9;
	public static final int ARRAY_ITERATOR=10;
	public static final int ASIN=11;
	public static final int ATAN=12;
	public static final int BACKSLASH=13;
	public static final int CASE=14;
	public static final int COMMENT=15;
	public static final int CONDITION=16;
	public static final int CONSTRAIN=17;
	public static final int CONVERTUNITS=18;
	public static final int COS=19;
	public static final int COT=20;
	public static final int CYCLE=21;
	public static final int DAY=22;
	public static final int DAYSIN=23;
	public static final int DAYSINTIMESTEP=24;
	public static final int DIGIT=25;
	public static final int DVAR=26;
	public static final int EXCEEDANCE=27;
	public static final int EXCEEDANCE_TSI=28;
	public static final int EXP=29;
	public static final int EXPRESSION=30;
	public static final int FILE=31;
	public static final int FLOAT=32;
	public static final int FROM=33;
	public static final int FROM_WRESL_FILE=34;
	public static final int FUNCTION=35;
	public static final int GIVEN=36;
	public static final int IDENT=37;
	public static final int IDENT1=38;
	public static final int IDENT2=39;
	public static final int INCLUDE=40;
	public static final int INT=41;
	public static final int INTEGER=42;
	public static final int INTEGERTYPE=43;
	public static final int LETTER=44;
	public static final int LHSGTRHS=45;
	public static final int LHSLTRHS=46;
	public static final int LOG=47;
	public static final int LOG10=48;
	public static final int LOWERBOUND=49;
	public static final int LOWERUNBOUNDED=50;
	public static final int MAX=51;
	public static final int MIN=52;
	public static final int MOD=53;
	public static final int MONTH=54;
	public static final int MONTH_CONST=55;
	public static final int MONTH_RANGE=56;
	public static final int MULTILINE_COMMENT=57;
	public static final int NAME=58;
	public static final int NOT=59;
	public static final int OR=60;
	public static final int ORDER=61;
	public static final int OUTPUT=62;
	public static final int PASTMONTH=63;
	public static final int POW=64;
	public static final int RANGE=65;
	public static final int REAL=66;
	public static final int ROUND=67;
	public static final int SELECT=68;
	public static final int SIN=69;
	public static final int SUM=70;
	public static final int SVAR=71;
	public static final int SYMBOLS=72;
	public static final int TAFCFS=73;
	public static final int TAN=74;
	public static final int TYPE=75;
	public static final int UNITS=76;
	public static final int UPPERBOUND=77;
	public static final int UPPERUNBOUNDED=78;
	public static final int USE=79;
	public static final int WEIGHT=80;
	public static final int WHERE=81;
	public static final int WS=82;
	public static final int YEAR=83;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public EvaluatorParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public EvaluatorParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return EvaluatorParser.tokenNames; }
	@Override public String getGrammarFileName() { return "Evaluator.g"; }


	  public IntDouble evalValue;
	  public EvalExpression evalExpression;
	  public EvalConstraint evalConstraint;
	  public boolean evalCondition;
	  public ParallelVars prvs;
	  public Stack<LoopIndex> sumIndex= new Stack <LoopIndex>();
	  
	  @Override
	  public void reportError(RecognitionException e) {
	       Error.addEvaluationError(getErrorMessage(e, tokenNames));
	  }
	  
	  public void setParallelVars (ParallelVars prvs1) {
	       prvs=prvs1;
	  }
	  
	  public void setSumIndex(Stack<LoopIndex> sumIndex){
	      this.sumIndex=sumIndex;
	  }



	// $ANTLR start "evaluator"
	// Evaluator.g:48:1: evaluator returns [String result] : ( goalInput | expressionInput | softConstraint | conditionInput );
	public final String evaluator() throws RecognitionException {
		String result = null;


		try {
			// Evaluator.g:49:2: ( goalInput | expressionInput | softConstraint | conditionInput )
			int alt1=4;
			switch ( input.LA(1) ) {
			case 102:
				{
				alt1=1;
				}
				break;
			case 106:
				{
				alt1=2;
				}
				break;
			case 104:
				{
				alt1=3;
				}
				break;
			case 101:
				{
				alt1=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// Evaluator.g:49:5: goalInput
					{
					pushFollow(FOLLOW_goalInput_in_evaluator51);
					goalInput();
					state._fsp--;
					if (state.failed) return result;
					}
					break;
				case 2 :
					// Evaluator.g:50:2: expressionInput
					{
					pushFollow(FOLLOW_expressionInput_in_evaluator55);
					expressionInput();
					state._fsp--;
					if (state.failed) return result;
					}
					break;
				case 3 :
					// Evaluator.g:51:2: softConstraint
					{
					pushFollow(FOLLOW_softConstraint_in_evaluator60);
					softConstraint();
					state._fsp--;
					if (state.failed) return result;
					}
					break;
				case 4 :
					// Evaluator.g:52:2: conditionInput
					{
					pushFollow(FOLLOW_conditionInput_in_evaluator64);
					conditionInput();
					state._fsp--;
					if (state.failed) return result;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "evaluator"



	// $ANTLR start "goalInput"
	// Evaluator.g:59:1: goalInput : 'g:' constraintStatement ;
	public final void goalInput() throws RecognitionException {
		EvalConstraint constraintStatement1 =null;

		try {
			// Evaluator.g:59:10: ( 'g:' constraintStatement )
			// Evaluator.g:59:12: 'g:' constraintStatement
			{
			match(input,102,FOLLOW_102_in_goalInput78); if (state.failed) return;
			pushFollow(FOLLOW_constraintStatement_in_goalInput80);
			constraintStatement1=constraintStatement();
			state._fsp--;
			if (state.failed) return;
			if ( state.backtracking==0 ) {evalConstraint = constraintStatement1;}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "goalInput"



	// $ANTLR start "expressionInput"
	// Evaluator.g:60:1: expressionInput : 'v:' expressionCollection ;
	public final void expressionInput() throws RecognitionException {
		EvalExpression expressionCollection2 =null;

		try {
			// Evaluator.g:60:16: ( 'v:' expressionCollection )
			// Evaluator.g:60:18: 'v:' expressionCollection
			{
			match(input,106,FOLLOW_106_in_expressionInput88); if (state.failed) return;
			pushFollow(FOLLOW_expressionCollection_in_expressionInput90);
			expressionCollection2=expressionCollection();
			state._fsp--;
			if (state.failed) return;
			if ( state.backtracking==0 ) {evalValue=Evaluation.expressionInput(expressionCollection2);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expressionInput"



	// $ANTLR start "softConstraint"
	// Evaluator.g:61:1: softConstraint : 's:' expressionCollection ;
	public final void softConstraint() throws RecognitionException {
		EvalExpression expressionCollection3 =null;

		try {
			// Evaluator.g:61:15: ( 's:' expressionCollection )
			// Evaluator.g:61:17: 's:' expressionCollection
			{
			match(input,104,FOLLOW_104_in_softConstraint97); if (state.failed) return;
			pushFollow(FOLLOW_expressionCollection_in_softConstraint99);
			expressionCollection3=expressionCollection();
			state._fsp--;
			if (state.failed) return;
			if ( state.backtracking==0 ) {evalExpression=expressionCollection3;}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "softConstraint"



	// $ANTLR start "conditionInput"
	// Evaluator.g:62:1: conditionInput : 'c:' conditionStatement ;
	public final void conditionInput() throws RecognitionException {
		boolean conditionStatement4 =false;

		try {
			// Evaluator.g:62:15: ( 'c:' conditionStatement )
			// Evaluator.g:62:17: 'c:' conditionStatement
			{
			match(input,101,FOLLOW_101_in_conditionInput106); if (state.failed) return;
			pushFollow(FOLLOW_conditionStatement_in_conditionInput108);
			conditionStatement4=conditionStatement();
			state._fsp--;
			if (state.failed) return;
			if ( state.backtracking==0 ) {evalCondition=conditionStatement4;}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "conditionInput"



	// $ANTLR start "lhsrhs"
	// Evaluator.g:67:1: lhsrhs : ( expression | CONSTRAIN );
	public final void lhsrhs() throws RecognitionException {
		try {
			// Evaluator.g:67:7: ( expression | CONSTRAIN )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( ((LA2_0 >= ABS && LA2_0 <= ACOT)||(LA2_0 >= ARRAY_ITERATOR && LA2_0 <= ATAN)||(LA2_0 >= COS && LA2_0 <= COT)||(LA2_0 >= DAY && LA2_0 <= DAYSINTIMESTEP)||(LA2_0 >= EXCEEDANCE && LA2_0 <= EXP)||LA2_0==FLOAT||LA2_0==IDENT||(LA2_0 >= INT && LA2_0 <= INTEGER)||(LA2_0 >= LOG && LA2_0 <= LOG10)||(LA2_0 >= MAX && LA2_0 <= MONTH_CONST)||(LA2_0 >= PASTMONTH && LA2_0 <= POW)||(LA2_0 >= REAL && LA2_0 <= ROUND)||LA2_0==SIN||LA2_0==SVAR||(LA2_0 >= TAFCFS && LA2_0 <= TAN)||(LA2_0 >= YEAR && LA2_0 <= 84)||(LA2_0 >= 87 && LA2_0 <= 88)) ) {
				alt2=1;
			}
			else if ( (LA2_0==CONSTRAIN) ) {
				alt2=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// Evaluator.g:67:9: expression
					{
					pushFollow(FOLLOW_expression_in_lhsrhs120);
					expression();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// Evaluator.g:67:20: CONSTRAIN
					{
					match(input,CONSTRAIN,FOLLOW_CONSTRAIN_in_lhsrhs122); if (state.failed) return;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "lhsrhs"



	// $ANTLR start "units"
	// Evaluator.g:71:1: units : ( IDENT | ( IDENT '/' IDENT ) );
	public final void units() throws RecognitionException {
		try {
			// Evaluator.g:71:6: ( IDENT | ( IDENT '/' IDENT ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==IDENT) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==90) ) {
					alt3=2;
				}
				else if ( (LA3_1==EOF) ) {
					alt3=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
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
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// Evaluator.g:71:8: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_units131); if (state.failed) return;
					}
					break;
				case 2 :
					// Evaluator.g:71:14: ( IDENT '/' IDENT )
					{
					// Evaluator.g:71:14: ( IDENT '/' IDENT )
					// Evaluator.g:71:15: IDENT '/' IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_units134); if (state.failed) return;
					match(input,90,FOLLOW_90_in_units136); if (state.failed) return;
					match(input,IDENT,FOLLOW_IDENT_in_units138); if (state.failed) return;
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "units"



	// $ANTLR start "fileName"
	// Evaluator.g:73:1: fileName : ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+ ;
	public final void fileName() throws RecognitionException {
		try {
			// Evaluator.g:74:3: ( ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+ )
			// Evaluator.g:74:5: ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+
			{
			// Evaluator.g:74:5: ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=15;
				switch ( input.LA(1) ) {
				case 91:
					{
					alt4=1;
					}
					break;
				case 92:
					{
					alt4=2;
					}
					break;
				case 89:
					{
					alt4=3;
					}
					break;
				case 107:
					{
					alt4=4;
					}
					break;
				case SYMBOLS:
					{
					alt4=5;
					}
					break;
				case 88:
					{
					alt4=6;
					}
					break;
				case 87:
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
				case ACOS:
				case ACOT:
				case ALL:
				case ALWAYS:
				case AND:
				case ASIN:
				case ATAN:
				case CASE:
				case CONDITION:
				case CONSTRAIN:
				case CONVERTUNITS:
				case COS:
				case COT:
				case CYCLE:
				case DAY:
				case DAYSIN:
				case DAYSINTIMESTEP:
				case DVAR:
				case EXCEEDANCE:
				case EXCEEDANCE_TSI:
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
				case MONTH_RANGE:
				case NAME:
				case NOT:
				case OR:
				case ORDER:
				case OUTPUT:
				case PASTMONTH:
				case POW:
				case RANGE:
				case REAL:
				case ROUND:
				case SELECT:
				case SIN:
				case SUM:
				case TAFCFS:
				case TAN:
				case TYPE:
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
					// Evaluator.g:74:6: ':'
					{
					match(input,91,FOLLOW_91_in_fileName150); if (state.failed) return;
					}
					break;
				case 2 :
					// Evaluator.g:74:10: ';'
					{
					match(input,92,FOLLOW_92_in_fileName152); if (state.failed) return;
					}
					break;
				case 3 :
					// Evaluator.g:74:14: '.'
					{
					match(input,89,FOLLOW_89_in_fileName154); if (state.failed) return;
					}
					break;
				case 4 :
					// Evaluator.g:74:18: '|'
					{
					match(input,107,FOLLOW_107_in_fileName156); if (state.failed) return;
					}
					break;
				case 5 :
					// Evaluator.g:74:22: SYMBOLS
					{
					match(input,SYMBOLS,FOLLOW_SYMBOLS_in_fileName158); if (state.failed) return;
					}
					break;
				case 6 :
					// Evaluator.g:74:30: '-'
					{
					match(input,88,FOLLOW_88_in_fileName160); if (state.failed) return;
					}
					break;
				case 7 :
					// Evaluator.g:74:34: '+'
					{
					match(input,87,FOLLOW_87_in_fileName162); if (state.failed) return;
					}
					break;
				case 8 :
					// Evaluator.g:74:38: BACKSLASH
					{
					match(input,BACKSLASH,FOLLOW_BACKSLASH_in_fileName164); if (state.failed) return;
					}
					break;
				case 9 :
					// Evaluator.g:74:48: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_fileName166); if (state.failed) return;
					}
					break;
				case 10 :
					// Evaluator.g:74:54: IDENT1
					{
					match(input,IDENT1,FOLLOW_IDENT1_in_fileName168); if (state.failed) return;
					}
					break;
				case 11 :
					// Evaluator.g:74:61: IDENT2
					{
					match(input,IDENT2,FOLLOW_IDENT2_in_fileName170); if (state.failed) return;
					}
					break;
				case 12 :
					// Evaluator.g:74:68: INTEGER
					{
					match(input,INTEGER,FOLLOW_INTEGER_in_fileName172); if (state.failed) return;
					}
					break;
				case 13 :
					// Evaluator.g:74:76: FLOAT
					{
					match(input,FLOAT,FOLLOW_FLOAT_in_fileName174); if (state.failed) return;
					}
					break;
				case 14 :
					// Evaluator.g:74:82: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_fileName176);
					usedKeywords();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					if ( cnt4 >= 1 ) break loop4;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
			}

			if ( state.backtracking==0 ) {
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "fileName"



	// $ANTLR start "externalFile"
	// Evaluator.g:78:1: externalFile : ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+ ;
	public final void externalFile() throws RecognitionException {
		try {
			// Evaluator.g:79:3: ( ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+ )
			// Evaluator.g:79:5: ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+
			{
			// Evaluator.g:79:5: ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=11;
				switch ( input.LA(1) ) {
				case 92:
					{
					alt5=1;
					}
					break;
				case 89:
					{
					alt5=2;
					}
					break;
				case 107:
					{
					alt5=3;
					}
					break;
				case SYMBOLS:
					{
					alt5=4;
					}
					break;
				case 88:
					{
					alt5=5;
					}
					break;
				case 87:
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
				case ACOS:
				case ACOT:
				case ALL:
				case ALWAYS:
				case AND:
				case ASIN:
				case ATAN:
				case CASE:
				case CONDITION:
				case CONSTRAIN:
				case CONVERTUNITS:
				case COS:
				case COT:
				case CYCLE:
				case DAY:
				case DAYSIN:
				case DAYSINTIMESTEP:
				case DVAR:
				case EXCEEDANCE:
				case EXCEEDANCE_TSI:
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
				case MONTH_RANGE:
				case NAME:
				case NOT:
				case OR:
				case ORDER:
				case OUTPUT:
				case PASTMONTH:
				case POW:
				case RANGE:
				case REAL:
				case ROUND:
				case SELECT:
				case SIN:
				case SUM:
				case TAFCFS:
				case TAN:
				case TYPE:
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
					// Evaluator.g:79:6: ';'
					{
					match(input,92,FOLLOW_92_in_externalFile195); if (state.failed) return;
					}
					break;
				case 2 :
					// Evaluator.g:79:10: '.'
					{
					match(input,89,FOLLOW_89_in_externalFile197); if (state.failed) return;
					}
					break;
				case 3 :
					// Evaluator.g:79:14: '|'
					{
					match(input,107,FOLLOW_107_in_externalFile199); if (state.failed) return;
					}
					break;
				case 4 :
					// Evaluator.g:79:18: SYMBOLS
					{
					match(input,SYMBOLS,FOLLOW_SYMBOLS_in_externalFile201); if (state.failed) return;
					}
					break;
				case 5 :
					// Evaluator.g:79:26: '-'
					{
					match(input,88,FOLLOW_88_in_externalFile203); if (state.failed) return;
					}
					break;
				case 6 :
					// Evaluator.g:79:30: '+'
					{
					match(input,87,FOLLOW_87_in_externalFile205); if (state.failed) return;
					}
					break;
				case 7 :
					// Evaluator.g:79:34: INTEGER
					{
					match(input,INTEGER,FOLLOW_INTEGER_in_externalFile207); if (state.failed) return;
					}
					break;
				case 8 :
					// Evaluator.g:79:42: FLOAT
					{
					match(input,FLOAT,FOLLOW_FLOAT_in_externalFile209); if (state.failed) return;
					}
					break;
				case 9 :
					// Evaluator.g:79:48: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_externalFile211); if (state.failed) return;
					}
					break;
				case 10 :
					// Evaluator.g:79:54: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_externalFile213);
					usedKeywords();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "externalFile"



	// $ANTLR start "text"
	// Evaluator.g:82:1: text : LETTER ( LETTER | DIGIT )* ;
	public final void text() throws RecognitionException {
		try {
			// Evaluator.g:82:6: ( LETTER ( LETTER | DIGIT )* )
			// Evaluator.g:82:8: LETTER ( LETTER | DIGIT )*
			{
			match(input,LETTER,FOLLOW_LETTER_in_text227); if (state.failed) return;
			// Evaluator.g:82:15: ( LETTER | DIGIT )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==DIGIT||LA6_0==LETTER) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// Evaluator.g:
					{
					if ( input.LA(1)==DIGIT||input.LA(1)==LETTER ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
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

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "text"



	// $ANTLR start "expressionCollection"
	// Evaluator.g:84:1: expressionCollection returns [EvalExpression ee] : ( ( expression ) | ( tableSQL ) | ( timeseriesWithUnits ) | ( ( timeseries ) ) | sumExpression | ( UPPERUNBOUNDED ) | ( LOWERUNBOUNDED ) );
	public final EvalExpression expressionCollection() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope expression5 =null;
		EvalExpression tableSQL6 =null;
		EvalExpression timeseries7 =null;
		EvalExpression sumExpression8 =null;

		try {
			// Evaluator.g:85:2: ( ( expression ) | ( tableSQL ) | ( timeseriesWithUnits ) | ( ( timeseries ) ) | sumExpression | ( UPPERUNBOUNDED ) | ( LOWERUNBOUNDED ) )
			int alt7=7;
			switch ( input.LA(1) ) {
			case ABS:
			case ACOS:
			case ACOT:
			case ARRAY_ITERATOR:
			case ASIN:
			case ATAN:
			case COS:
			case COT:
			case DAY:
			case DAYSIN:
			case DAYSINTIMESTEP:
			case EXCEEDANCE:
			case EXCEEDANCE_TSI:
			case EXP:
			case FLOAT:
			case IDENT:
			case INT:
			case INTEGER:
			case LOG:
			case LOG10:
			case MAX:
			case MIN:
			case MOD:
			case MONTH:
			case MONTH_CONST:
			case PASTMONTH:
			case POW:
			case REAL:
			case ROUND:
			case SIN:
			case SVAR:
			case TAFCFS:
			case TAN:
			case YEAR:
			case 84:
			case 87:
			case 88:
				{
				alt7=1;
				}
				break;
			case SELECT:
				{
				alt7=2;
				}
				break;
			case 105:
				{
				int LA7_3 = input.LA(2);
				if ( (LA7_3==103) ) {
					alt7=3;
				}
				else if ( (LA7_3==EOF) ) {
					alt7=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return ee;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 7, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case SUM:
				{
				alt7=5;
				}
				break;
			case UPPERUNBOUNDED:
				{
				alt7=6;
				}
				break;
			case LOWERUNBOUNDED:
				{
				alt7=7;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return ee;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// Evaluator.g:85:4: ( expression )
					{
					// Evaluator.g:85:4: ( expression )
					// Evaluator.g:85:5: expression
					{
					pushFollow(FOLLOW_expression_in_expressionCollection252);
					expression5=expression();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=(expression5!=null?((EvaluatorParser.expression_return)expression5).ee:null);}
					}

					}
					break;
				case 2 :
					// Evaluator.g:86:3: ( tableSQL )
					{
					// Evaluator.g:86:3: ( tableSQL )
					// Evaluator.g:86:4: tableSQL
					{
					pushFollow(FOLLOW_tableSQL_in_expressionCollection259);
					tableSQL6=tableSQL();
					state._fsp--;
					if (state.failed) return ee;
					}

					if ( state.backtracking==0 ) {ee=tableSQL6;}
					}
					break;
				case 3 :
					// Evaluator.g:87:3: ( timeseriesWithUnits )
					{
					// Evaluator.g:87:3: ( timeseriesWithUnits )
					// Evaluator.g:87:4: timeseriesWithUnits
					{
					pushFollow(FOLLOW_timeseriesWithUnits_in_expressionCollection266);
					timeseriesWithUnits();
					state._fsp--;
					if (state.failed) return ee;
					}

					}
					break;
				case 4 :
					// Evaluator.g:88:3: ( ( timeseries ) )
					{
					// Evaluator.g:88:3: ( ( timeseries ) )
					// Evaluator.g:88:4: ( timeseries )
					{
					// Evaluator.g:88:4: ( timeseries )
					// Evaluator.g:88:5: timeseries
					{
					pushFollow(FOLLOW_timeseries_in_expressionCollection273);
					timeseries7=timeseries();
					state._fsp--;
					if (state.failed) return ee;
					}

					if ( state.backtracking==0 ) {ee=timeseries7;}
					}

					}
					break;
				case 5 :
					// Evaluator.g:89:4: sumExpression
					{
					pushFollow(FOLLOW_sumExpression_in_expressionCollection281);
					sumExpression8=sumExpression();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=sumExpression8;}
					}
					break;
				case 6 :
					// Evaluator.g:90:3: ( UPPERUNBOUNDED )
					{
					// Evaluator.g:90:3: ( UPPERUNBOUNDED )
					// Evaluator.g:90:4: UPPERUNBOUNDED
					{
					match(input,UPPERUNBOUNDED,FOLLOW_UPPERUNBOUNDED_in_expressionCollection288); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=new EvalExpression(new IntDouble(1e38,true));}
					}

					}
					break;
				case 7 :
					// Evaluator.g:91:3: ( LOWERUNBOUNDED )
					{
					// Evaluator.g:91:3: ( LOWERUNBOUNDED )
					// Evaluator.g:91:4: LOWERUNBOUNDED
					{
					match(input,LOWERUNBOUNDED,FOLLOW_LOWERUNBOUNDED_in_expressionCollection295); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=new EvalExpression(new IntDouble(-1e38,true));}
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "expressionCollection"



	// $ANTLR start "func"
	// Evaluator.g:94:1: func returns [EvalExpression ee] : ( ( max_func ) | ( min_func ) | ( int_func ) | ( real_func ) | ( abs_func ) | ( exp_func ) | ( log_func ) | ( log10_func ) | ( pow_func ) | ( mod_func ) | ( round_func ) | ( sin_func ) | ( cos_func ) | ( tan_func ) | ( cot_func ) | ( asin_func ) | ( acos_func ) | ( atan_func ) | ( acot_func ) | ( exceedFunc ) | ( exceedtsiFunc ) );
	public final EvalExpression func() throws RecognitionException {
		EvalExpression ee = null;


		EvalExpression max_func9 =null;
		EvalExpression min_func10 =null;
		EvalExpression int_func11 =null;
		EvalExpression real_func12 =null;
		EvalExpression abs_func13 =null;
		EvalExpression exp_func14 =null;
		EvalExpression log_func15 =null;
		EvalExpression log10_func16 =null;
		EvalExpression pow_func17 =null;
		EvalExpression mod_func18 =null;
		EvalExpression round_func19 =null;
		EvalExpression sin_func20 =null;
		EvalExpression cos_func21 =null;
		EvalExpression tan_func22 =null;
		EvalExpression cot_func23 =null;
		EvalExpression asin_func24 =null;
		EvalExpression acos_func25 =null;
		EvalExpression atan_func26 =null;
		EvalExpression acot_func27 =null;
		EvalExpression exceedFunc28 =null;
		EvalExpression exceedtsiFunc29 =null;

		try {
			// Evaluator.g:94:32: ( ( max_func ) | ( min_func ) | ( int_func ) | ( real_func ) | ( abs_func ) | ( exp_func ) | ( log_func ) | ( log10_func ) | ( pow_func ) | ( mod_func ) | ( round_func ) | ( sin_func ) | ( cos_func ) | ( tan_func ) | ( cot_func ) | ( asin_func ) | ( acos_func ) | ( atan_func ) | ( acot_func ) | ( exceedFunc ) | ( exceedtsiFunc ) )
			int alt8=21;
			switch ( input.LA(1) ) {
			case MAX:
				{
				alt8=1;
				}
				break;
			case MIN:
				{
				alt8=2;
				}
				break;
			case INT:
				{
				alt8=3;
				}
				break;
			case REAL:
				{
				alt8=4;
				}
				break;
			case ABS:
				{
				alt8=5;
				}
				break;
			case EXP:
				{
				alt8=6;
				}
				break;
			case LOG:
				{
				alt8=7;
				}
				break;
			case LOG10:
				{
				alt8=8;
				}
				break;
			case POW:
				{
				alt8=9;
				}
				break;
			case MOD:
				{
				alt8=10;
				}
				break;
			case ROUND:
				{
				alt8=11;
				}
				break;
			case SIN:
				{
				alt8=12;
				}
				break;
			case COS:
				{
				alt8=13;
				}
				break;
			case TAN:
				{
				alt8=14;
				}
				break;
			case COT:
				{
				alt8=15;
				}
				break;
			case ASIN:
				{
				alt8=16;
				}
				break;
			case ACOS:
				{
				alt8=17;
				}
				break;
			case ATAN:
				{
				alt8=18;
				}
				break;
			case ACOT:
				{
				alt8=19;
				}
				break;
			case EXCEEDANCE:
				{
				alt8=20;
				}
				break;
			case EXCEEDANCE_TSI:
				{
				alt8=21;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return ee;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// Evaluator.g:95:3: ( max_func )
					{
					// Evaluator.g:95:3: ( max_func )
					// Evaluator.g:95:4: max_func
					{
					pushFollow(FOLLOW_max_func_in_func313);
					max_func9=max_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=max_func9;}
					}

					}
					break;
				case 2 :
					// Evaluator.g:96:3: ( min_func )
					{
					// Evaluator.g:96:3: ( min_func )
					// Evaluator.g:96:4: min_func
					{
					pushFollow(FOLLOW_min_func_in_func321);
					min_func10=min_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=min_func10;}
					}

					}
					break;
				case 3 :
					// Evaluator.g:97:3: ( int_func )
					{
					// Evaluator.g:97:3: ( int_func )
					// Evaluator.g:97:4: int_func
					{
					pushFollow(FOLLOW_int_func_in_func329);
					int_func11=int_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=int_func11;}
					}

					}
					break;
				case 4 :
					// Evaluator.g:98:3: ( real_func )
					{
					// Evaluator.g:98:3: ( real_func )
					// Evaluator.g:98:4: real_func
					{
					pushFollow(FOLLOW_real_func_in_func337);
					real_func12=real_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=real_func12;}
					}

					}
					break;
				case 5 :
					// Evaluator.g:99:3: ( abs_func )
					{
					// Evaluator.g:99:3: ( abs_func )
					// Evaluator.g:99:4: abs_func
					{
					pushFollow(FOLLOW_abs_func_in_func345);
					abs_func13=abs_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=abs_func13;}
					}

					}
					break;
				case 6 :
					// Evaluator.g:100:3: ( exp_func )
					{
					// Evaluator.g:100:3: ( exp_func )
					// Evaluator.g:100:4: exp_func
					{
					pushFollow(FOLLOW_exp_func_in_func353);
					exp_func14=exp_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=exp_func14;}
					}

					}
					break;
				case 7 :
					// Evaluator.g:101:3: ( log_func )
					{
					// Evaluator.g:101:3: ( log_func )
					// Evaluator.g:101:4: log_func
					{
					pushFollow(FOLLOW_log_func_in_func361);
					log_func15=log_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=log_func15;}
					}

					}
					break;
				case 8 :
					// Evaluator.g:102:3: ( log10_func )
					{
					// Evaluator.g:102:3: ( log10_func )
					// Evaluator.g:102:4: log10_func
					{
					pushFollow(FOLLOW_log10_func_in_func369);
					log10_func16=log10_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=log10_func16;}
					}

					}
					break;
				case 9 :
					// Evaluator.g:103:3: ( pow_func )
					{
					// Evaluator.g:103:3: ( pow_func )
					// Evaluator.g:103:4: pow_func
					{
					pushFollow(FOLLOW_pow_func_in_func377);
					pow_func17=pow_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=pow_func17;}
					}

					}
					break;
				case 10 :
					// Evaluator.g:104:3: ( mod_func )
					{
					// Evaluator.g:104:3: ( mod_func )
					// Evaluator.g:104:4: mod_func
					{
					pushFollow(FOLLOW_mod_func_in_func385);
					mod_func18=mod_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=mod_func18;}
					}

					}
					break;
				case 11 :
					// Evaluator.g:105:3: ( round_func )
					{
					// Evaluator.g:105:3: ( round_func )
					// Evaluator.g:105:4: round_func
					{
					pushFollow(FOLLOW_round_func_in_func393);
					round_func19=round_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=round_func19;}
					}

					}
					break;
				case 12 :
					// Evaluator.g:106:3: ( sin_func )
					{
					// Evaluator.g:106:3: ( sin_func )
					// Evaluator.g:106:4: sin_func
					{
					pushFollow(FOLLOW_sin_func_in_func401);
					sin_func20=sin_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=sin_func20;}
					}

					}
					break;
				case 13 :
					// Evaluator.g:107:3: ( cos_func )
					{
					// Evaluator.g:107:3: ( cos_func )
					// Evaluator.g:107:4: cos_func
					{
					pushFollow(FOLLOW_cos_func_in_func409);
					cos_func21=cos_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=cos_func21;}
					}

					}
					break;
				case 14 :
					// Evaluator.g:108:3: ( tan_func )
					{
					// Evaluator.g:108:3: ( tan_func )
					// Evaluator.g:108:4: tan_func
					{
					pushFollow(FOLLOW_tan_func_in_func417);
					tan_func22=tan_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=tan_func22;}
					}

					}
					break;
				case 15 :
					// Evaluator.g:109:3: ( cot_func )
					{
					// Evaluator.g:109:3: ( cot_func )
					// Evaluator.g:109:4: cot_func
					{
					pushFollow(FOLLOW_cot_func_in_func425);
					cot_func23=cot_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=cot_func23;}
					}

					}
					break;
				case 16 :
					// Evaluator.g:110:3: ( asin_func )
					{
					// Evaluator.g:110:3: ( asin_func )
					// Evaluator.g:110:4: asin_func
					{
					pushFollow(FOLLOW_asin_func_in_func433);
					asin_func24=asin_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=asin_func24;}
					}

					}
					break;
				case 17 :
					// Evaluator.g:111:3: ( acos_func )
					{
					// Evaluator.g:111:3: ( acos_func )
					// Evaluator.g:111:4: acos_func
					{
					pushFollow(FOLLOW_acos_func_in_func441);
					acos_func25=acos_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=acos_func25;}
					}

					}
					break;
				case 18 :
					// Evaluator.g:112:3: ( atan_func )
					{
					// Evaluator.g:112:3: ( atan_func )
					// Evaluator.g:112:4: atan_func
					{
					pushFollow(FOLLOW_atan_func_in_func449);
					atan_func26=atan_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=atan_func26;}
					}

					}
					break;
				case 19 :
					// Evaluator.g:113:3: ( acot_func )
					{
					// Evaluator.g:113:3: ( acot_func )
					// Evaluator.g:113:4: acot_func
					{
					pushFollow(FOLLOW_acot_func_in_func457);
					acot_func27=acot_func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=acot_func27;}
					}

					}
					break;
				case 20 :
					// Evaluator.g:114:3: ( exceedFunc )
					{
					// Evaluator.g:114:3: ( exceedFunc )
					// Evaluator.g:114:4: exceedFunc
					{
					pushFollow(FOLLOW_exceedFunc_in_func465);
					exceedFunc28=exceedFunc();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=exceedFunc28;}
					}

					}
					break;
				case 21 :
					// Evaluator.g:115:3: ( exceedtsiFunc )
					{
					// Evaluator.g:115:3: ( exceedtsiFunc )
					// Evaluator.g:115:4: exceedtsiFunc
					{
					pushFollow(FOLLOW_exceedtsiFunc_in_func473);
					exceedtsiFunc29=exceedtsiFunc();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=exceedtsiFunc29;}
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "func"



	// $ANTLR start "round_func"
	// Evaluator.g:118:1: round_func returns [EvalExpression ee] : ROUND '(' (e1= expression ) ')' ;
	public final EvalExpression round_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e1 =null;

		try {
			// Evaluator.g:119:3: ( ROUND '(' (e1= expression ) ')' )
			// Evaluator.g:119:5: ROUND '(' (e1= expression ) ')'
			{
			match(input,ROUND,FOLLOW_ROUND_in_round_func492); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_round_func494); if (state.failed) return ee;
			// Evaluator.g:119:15: (e1= expression )
			// Evaluator.g:119:16: e1= expression
			{
			pushFollow(FOLLOW_expression_in_round_func499);
			e1=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_round_func501); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			     ee=Evaluation.round((e1!=null?((EvaluatorParser.expression_return)e1).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "round_func"



	// $ANTLR start "mod_func"
	// Evaluator.g:124:1: mod_func returns [EvalExpression ee] : MOD '(' (e1= expression ) ( ';' (e2= expression ) ) ')' ;
	public final EvalExpression mod_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		try {
			// Evaluator.g:125:3: ( MOD '(' (e1= expression ) ( ';' (e2= expression ) ) ')' )
			// Evaluator.g:125:5: MOD '(' (e1= expression ) ( ';' (e2= expression ) ) ')'
			{
			match(input,MOD,FOLLOW_MOD_in_mod_func518); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_mod_func520); if (state.failed) return ee;
			// Evaluator.g:125:13: (e1= expression )
			// Evaluator.g:125:14: e1= expression
			{
			pushFollow(FOLLOW_expression_in_mod_func525);
			e1=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			// Evaluator.g:125:29: ( ';' (e2= expression ) )
			// Evaluator.g:125:30: ';' (e2= expression )
			{
			match(input,92,FOLLOW_92_in_mod_func529); if (state.failed) return ee;
			// Evaluator.g:125:34: (e2= expression )
			// Evaluator.g:125:35: e2= expression
			{
			pushFollow(FOLLOW_expression_in_mod_func534);
			e2=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			}

			match(input,85,FOLLOW_85_in_mod_func538); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			     ee=Evaluation.mod((e1!=null?((EvaluatorParser.expression_return)e1).ee:null), (e2!=null?((EvaluatorParser.expression_return)e2).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "mod_func"



	// $ANTLR start "max_func"
	// Evaluator.g:130:1: max_func returns [EvalExpression ee] : MAX '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' ;
	public final EvalExpression max_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		try {
			// Evaluator.g:131:2: ( MAX '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' )
			// Evaluator.g:131:4: MAX '(' (e1= expression ) ( ';' (e2= expression ) )+ ')'
			{
			match(input,MAX,FOLLOW_MAX_in_max_func555); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_max_func557); if (state.failed) return ee;
			// Evaluator.g:131:12: (e1= expression )
			// Evaluator.g:131:13: e1= expression
			{
			pushFollow(FOLLOW_expression_in_max_func562);
			e1=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			if ( state.backtracking==0 ) {ee=(e1!=null?((EvaluatorParser.expression_return)e1).ee:null);}
			// Evaluator.g:131:39: ( ';' (e2= expression ) )+
			int cnt9=0;
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==92) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// Evaluator.g:131:40: ';' (e2= expression )
					{
					match(input,92,FOLLOW_92_in_max_func566); if (state.failed) return ee;
					// Evaluator.g:131:44: (e2= expression )
					// Evaluator.g:131:45: e2= expression
					{
					pushFollow(FOLLOW_expression_in_max_func571);
					e2=expression();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {
					     ee=Evaluation.max(ee, (e2!=null?((EvaluatorParser.expression_return)e2).ee:null));
					  }
					}

					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					if (state.backtracking>0) {state.failed=true; return ee;}
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			match(input,85,FOLLOW_85_in_max_func577); if (state.failed) return ee;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "max_func"



	// $ANTLR start "min_func"
	// Evaluator.g:136:1: min_func returns [EvalExpression ee] : MIN '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' ;
	public final EvalExpression min_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		try {
			// Evaluator.g:137:2: ( MIN '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' )
			// Evaluator.g:137:4: MIN '(' (e1= expression ) ( ';' (e2= expression ) )+ ')'
			{
			match(input,MIN,FOLLOW_MIN_in_min_func591); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_min_func593); if (state.failed) return ee;
			// Evaluator.g:137:12: (e1= expression )
			// Evaluator.g:137:13: e1= expression
			{
			pushFollow(FOLLOW_expression_in_min_func598);
			e1=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			if ( state.backtracking==0 ) {ee=(e1!=null?((EvaluatorParser.expression_return)e1).ee:null);}
			// Evaluator.g:137:39: ( ';' (e2= expression ) )+
			int cnt10=0;
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==92) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// Evaluator.g:137:40: ';' (e2= expression )
					{
					match(input,92,FOLLOW_92_in_min_func602); if (state.failed) return ee;
					// Evaluator.g:137:44: (e2= expression )
					// Evaluator.g:137:45: e2= expression
					{
					pushFollow(FOLLOW_expression_in_min_func607);
					e2=expression();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {
					     ee=Evaluation.min(ee, (e2!=null?((EvaluatorParser.expression_return)e2).ee:null));
					  }
					}

					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					if (state.backtracking>0) {state.failed=true; return ee;}
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			match(input,85,FOLLOW_85_in_min_func613); if (state.failed) return ee;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "min_func"



	// $ANTLR start "int_func"
	// Evaluator.g:142:1: int_func returns [EvalExpression ee] : INT '(' (e= expression ) ')' ;
	public final EvalExpression int_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e =null;

		try {
			// Evaluator.g:143:3: ( INT '(' (e= expression ) ')' )
			// Evaluator.g:143:5: INT '(' (e= expression ) ')'
			{
			match(input,INT,FOLLOW_INT_in_int_func629); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_int_func631); if (state.failed) return ee;
			// Evaluator.g:143:13: (e= expression )
			// Evaluator.g:143:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_int_func636);
			e=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_int_func639); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			     ee=Evaluation.intFunc((e!=null?((EvaluatorParser.expression_return)e).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "int_func"



	// $ANTLR start "real_func"
	// Evaluator.g:148:1: real_func returns [EvalExpression ee] : REAL '(' (e= expression ) ')' ;
	public final EvalExpression real_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e =null;

		try {
			// Evaluator.g:149:3: ( REAL '(' (e= expression ) ')' )
			// Evaluator.g:149:5: REAL '(' (e= expression ) ')'
			{
			match(input,REAL,FOLLOW_REAL_in_real_func656); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_real_func658); if (state.failed) return ee;
			// Evaluator.g:149:14: (e= expression )
			// Evaluator.g:149:15: e= expression
			{
			pushFollow(FOLLOW_expression_in_real_func663);
			e=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_real_func666); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			    ee=Evaluation.realFunc((e!=null?((EvaluatorParser.expression_return)e).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "real_func"



	// $ANTLR start "abs_func"
	// Evaluator.g:154:1: abs_func returns [EvalExpression ee] : ABS '(' (e= expression ) ')' ;
	public final EvalExpression abs_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e =null;

		try {
			// Evaluator.g:155:3: ( ABS '(' (e= expression ) ')' )
			// Evaluator.g:155:5: ABS '(' (e= expression ) ')'
			{
			match(input,ABS,FOLLOW_ABS_in_abs_func685); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_abs_func687); if (state.failed) return ee;
			// Evaluator.g:155:13: (e= expression )
			// Evaluator.g:155:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_abs_func692);
			e=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_abs_func695); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			     ee=Evaluation.abs((e!=null?((EvaluatorParser.expression_return)e).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "abs_func"



	// $ANTLR start "exp_func"
	// Evaluator.g:160:1: exp_func returns [EvalExpression ee] : EXP '(' (e= expression ) ')' ;
	public final EvalExpression exp_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e =null;

		try {
			// Evaluator.g:161:3: ( EXP '(' (e= expression ) ')' )
			// Evaluator.g:161:5: EXP '(' (e= expression ) ')'
			{
			match(input,EXP,FOLLOW_EXP_in_exp_func712); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_exp_func714); if (state.failed) return ee;
			// Evaluator.g:161:13: (e= expression )
			// Evaluator.g:161:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_exp_func719);
			e=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_exp_func722); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			     ee=Evaluation.exp((e!=null?((EvaluatorParser.expression_return)e).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "exp_func"



	// $ANTLR start "log_func"
	// Evaluator.g:166:1: log_func returns [EvalExpression ee] : LOG '(' (e= expression ) ')' ;
	public final EvalExpression log_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e =null;

		try {
			// Evaluator.g:167:3: ( LOG '(' (e= expression ) ')' )
			// Evaluator.g:167:5: LOG '(' (e= expression ) ')'
			{
			match(input,LOG,FOLLOW_LOG_in_log_func739); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_log_func741); if (state.failed) return ee;
			// Evaluator.g:167:13: (e= expression )
			// Evaluator.g:167:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_log_func746);
			e=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_log_func749); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			     ee=Evaluation.log((e!=null?((EvaluatorParser.expression_return)e).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "log_func"



	// $ANTLR start "log10_func"
	// Evaluator.g:172:1: log10_func returns [EvalExpression ee] : LOG10 '(' (e= expression ) ')' ;
	public final EvalExpression log10_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e =null;

		try {
			// Evaluator.g:173:3: ( LOG10 '(' (e= expression ) ')' )
			// Evaluator.g:173:5: LOG10 '(' (e= expression ) ')'
			{
			match(input,LOG10,FOLLOW_LOG10_in_log10_func766); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_log10_func768); if (state.failed) return ee;
			// Evaluator.g:173:15: (e= expression )
			// Evaluator.g:173:16: e= expression
			{
			pushFollow(FOLLOW_expression_in_log10_func773);
			e=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_log10_func776); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			    ee=Evaluation.log10((e!=null?((EvaluatorParser.expression_return)e).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "log10_func"



	// $ANTLR start "pow_func"
	// Evaluator.g:178:1: pow_func returns [EvalExpression ee] : POW '(' (e1= expression ) ( ';' (e2= expression ) ) ')' ;
	public final EvalExpression pow_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		try {
			// Evaluator.g:179:3: ( POW '(' (e1= expression ) ( ';' (e2= expression ) ) ')' )
			// Evaluator.g:179:5: POW '(' (e1= expression ) ( ';' (e2= expression ) ) ')'
			{
			match(input,POW,FOLLOW_POW_in_pow_func795); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_pow_func797); if (state.failed) return ee;
			// Evaluator.g:179:13: (e1= expression )
			// Evaluator.g:179:14: e1= expression
			{
			pushFollow(FOLLOW_expression_in_pow_func802);
			e1=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			// Evaluator.g:179:29: ( ';' (e2= expression ) )
			// Evaluator.g:179:30: ';' (e2= expression )
			{
			match(input,92,FOLLOW_92_in_pow_func806); if (state.failed) return ee;
			// Evaluator.g:179:34: (e2= expression )
			// Evaluator.g:179:35: e2= expression
			{
			pushFollow(FOLLOW_expression_in_pow_func811);
			e2=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			}

			match(input,85,FOLLOW_85_in_pow_func815); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			     ee=Evaluation.pow((e1!=null?((EvaluatorParser.expression_return)e1).ee:null), (e2!=null?((EvaluatorParser.expression_return)e2).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "pow_func"



	// $ANTLR start "sin_func"
	// Evaluator.g:184:1: sin_func returns [EvalExpression ee] : SIN '(' (e= expression ) ')' ;
	public final EvalExpression sin_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e =null;

		try {
			// Evaluator.g:185:3: ( SIN '(' (e= expression ) ')' )
			// Evaluator.g:185:5: SIN '(' (e= expression ) ')'
			{
			match(input,SIN,FOLLOW_SIN_in_sin_func832); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_sin_func834); if (state.failed) return ee;
			// Evaluator.g:185:13: (e= expression )
			// Evaluator.g:185:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_sin_func839);
			e=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_sin_func842); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			    ee=Evaluation.sin((e!=null?((EvaluatorParser.expression_return)e).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "sin_func"



	// $ANTLR start "cos_func"
	// Evaluator.g:190:1: cos_func returns [EvalExpression ee] : COS '(' (e= expression ) ')' ;
	public final EvalExpression cos_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e =null;

		try {
			// Evaluator.g:191:3: ( COS '(' (e= expression ) ')' )
			// Evaluator.g:191:5: COS '(' (e= expression ) ')'
			{
			match(input,COS,FOLLOW_COS_in_cos_func859); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_cos_func861); if (state.failed) return ee;
			// Evaluator.g:191:13: (e= expression )
			// Evaluator.g:191:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_cos_func866);
			e=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_cos_func869); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			    ee=Evaluation.cos((e!=null?((EvaluatorParser.expression_return)e).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "cos_func"



	// $ANTLR start "tan_func"
	// Evaluator.g:196:1: tan_func returns [EvalExpression ee] : TAN '(' (e= expression ) ')' ;
	public final EvalExpression tan_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e =null;

		try {
			// Evaluator.g:197:3: ( TAN '(' (e= expression ) ')' )
			// Evaluator.g:197:5: TAN '(' (e= expression ) ')'
			{
			match(input,TAN,FOLLOW_TAN_in_tan_func888); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_tan_func890); if (state.failed) return ee;
			// Evaluator.g:197:13: (e= expression )
			// Evaluator.g:197:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_tan_func895);
			e=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_tan_func898); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			    ee=Evaluation.tan((e!=null?((EvaluatorParser.expression_return)e).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "tan_func"



	// $ANTLR start "cot_func"
	// Evaluator.g:202:1: cot_func returns [EvalExpression ee] : COT '(' (e= expression ) ')' ;
	public final EvalExpression cot_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e =null;

		try {
			// Evaluator.g:203:3: ( COT '(' (e= expression ) ')' )
			// Evaluator.g:203:5: COT '(' (e= expression ) ')'
			{
			match(input,COT,FOLLOW_COT_in_cot_func917); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_cot_func919); if (state.failed) return ee;
			// Evaluator.g:203:13: (e= expression )
			// Evaluator.g:203:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_cot_func924);
			e=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_cot_func927); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			    ee=Evaluation.cot((e!=null?((EvaluatorParser.expression_return)e).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "cot_func"



	// $ANTLR start "asin_func"
	// Evaluator.g:208:1: asin_func returns [EvalExpression ee] : ASIN '(' (e= expression ) ')' ;
	public final EvalExpression asin_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e =null;

		try {
			// Evaluator.g:209:3: ( ASIN '(' (e= expression ) ')' )
			// Evaluator.g:209:5: ASIN '(' (e= expression ) ')'
			{
			match(input,ASIN,FOLLOW_ASIN_in_asin_func944); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_asin_func946); if (state.failed) return ee;
			// Evaluator.g:209:14: (e= expression )
			// Evaluator.g:209:15: e= expression
			{
			pushFollow(FOLLOW_expression_in_asin_func951);
			e=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_asin_func954); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			    ee=Evaluation.asin((e!=null?((EvaluatorParser.expression_return)e).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "asin_func"



	// $ANTLR start "acos_func"
	// Evaluator.g:214:1: acos_func returns [EvalExpression ee] : ACOS '(' (e= expression ) ')' ;
	public final EvalExpression acos_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e =null;

		try {
			// Evaluator.g:215:3: ( ACOS '(' (e= expression ) ')' )
			// Evaluator.g:215:5: ACOS '(' (e= expression ) ')'
			{
			match(input,ACOS,FOLLOW_ACOS_in_acos_func971); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_acos_func973); if (state.failed) return ee;
			// Evaluator.g:215:14: (e= expression )
			// Evaluator.g:215:15: e= expression
			{
			pushFollow(FOLLOW_expression_in_acos_func978);
			e=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_acos_func981); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			    ee=Evaluation.acos((e!=null?((EvaluatorParser.expression_return)e).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "acos_func"



	// $ANTLR start "atan_func"
	// Evaluator.g:220:1: atan_func returns [EvalExpression ee] : ATAN '(' (e= expression ) ')' ;
	public final EvalExpression atan_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e =null;

		try {
			// Evaluator.g:221:3: ( ATAN '(' (e= expression ) ')' )
			// Evaluator.g:221:5: ATAN '(' (e= expression ) ')'
			{
			match(input,ATAN,FOLLOW_ATAN_in_atan_func1000); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_atan_func1002); if (state.failed) return ee;
			// Evaluator.g:221:14: (e= expression )
			// Evaluator.g:221:15: e= expression
			{
			pushFollow(FOLLOW_expression_in_atan_func1007);
			e=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_atan_func1010); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			    ee=Evaluation.atan((e!=null?((EvaluatorParser.expression_return)e).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "atan_func"



	// $ANTLR start "acot_func"
	// Evaluator.g:226:1: acot_func returns [EvalExpression ee] : ACOT '(' (e= expression ) ')' ;
	public final EvalExpression acot_func() throws RecognitionException {
		EvalExpression ee = null;


		ParserRuleReturnScope e =null;

		try {
			// Evaluator.g:227:3: ( ACOT '(' (e= expression ) ')' )
			// Evaluator.g:227:5: ACOT '(' (e= expression ) ')'
			{
			match(input,ACOT,FOLLOW_ACOT_in_acot_func1029); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_acot_func1031); if (state.failed) return ee;
			// Evaluator.g:227:14: (e= expression )
			// Evaluator.g:227:15: e= expression
			{
			pushFollow(FOLLOW_expression_in_acot_func1036);
			e=expression();
			state._fsp--;
			if (state.failed) return ee;
			}

			match(input,85,FOLLOW_85_in_acot_func1039); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			    ee=Evaluation.acot((e!=null?((EvaluatorParser.expression_return)e).ee:null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "acot_func"



	// $ANTLR start "exceedFunc"
	// Evaluator.g:232:1: exceedFunc returns [EvalExpression ee] : EXCEEDANCE '(' var= IDENT ';' exc= term ';' (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL ) ';' sy= INTEGER ';' sm= MONTH_CONST ';' sd= INTEGER ';' ey= INTEGER ';' em= MONTH_CONST ';' ed= INTEGER ')' ;
	public final EvalExpression exceedFunc() throws RecognitionException {
		EvalExpression ee = null;


		Token var=null;
		Token mon=null;
		Token sy=null;
		Token sm=null;
		Token sd=null;
		Token ey=null;
		Token em=null;
		Token ed=null;
		EvalExpression exc =null;

		try {
			// Evaluator.g:233:3: ( EXCEEDANCE '(' var= IDENT ';' exc= term ';' (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL ) ';' sy= INTEGER ';' sm= MONTH_CONST ';' sd= INTEGER ';' ey= INTEGER ';' em= MONTH_CONST ';' ed= INTEGER ')' )
			// Evaluator.g:233:5: EXCEEDANCE '(' var= IDENT ';' exc= term ';' (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL ) ';' sy= INTEGER ';' sm= MONTH_CONST ';' sd= INTEGER ';' ey= INTEGER ';' em= MONTH_CONST ';' ed= INTEGER ')'
			{
			match(input,EXCEEDANCE,FOLLOW_EXCEEDANCE_in_exceedFunc1056); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_exceedFunc1058); if (state.failed) return ee;
			var=(Token)match(input,IDENT,FOLLOW_IDENT_in_exceedFunc1062); if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_exceedFunc1064); if (state.failed) return ee;
			pushFollow(FOLLOW_term_in_exceedFunc1068);
			exc=term();
			state._fsp--;
			if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_exceedFunc1070); if (state.failed) return ee;
			// Evaluator.g:233:47: (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL )
			int alt11=3;
			switch ( input.LA(1) ) {
			case MONTH_CONST:
				{
				alt11=1;
				}
				break;
			case MONTH_RANGE:
				{
				alt11=2;
				}
				break;
			case ALL:
				{
				alt11=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return ee;}
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// Evaluator.g:233:48: mon= MONTH_CONST
					{
					mon=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_exceedFunc1075); if (state.failed) return ee;
					}
					break;
				case 2 :
					// Evaluator.g:233:64: mon= MONTH_RANGE
					{
					mon=(Token)match(input,MONTH_RANGE,FOLLOW_MONTH_RANGE_in_exceedFunc1079); if (state.failed) return ee;
					}
					break;
				case 3 :
					// Evaluator.g:233:80: mon= ALL
					{
					mon=(Token)match(input,ALL,FOLLOW_ALL_in_exceedFunc1083); if (state.failed) return ee;
					}
					break;

			}

			match(input,92,FOLLOW_92_in_exceedFunc1086); if (state.failed) return ee;
			sy=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedFunc1090); if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_exceedFunc1092); if (state.failed) return ee;
			sm=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_exceedFunc1096); if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_exceedFunc1098); if (state.failed) return ee;
			sd=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedFunc1102); if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_exceedFunc1104); if (state.failed) return ee;
			ey=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedFunc1108); if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_exceedFunc1110); if (state.failed) return ee;
			em=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_exceedFunc1114); if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_exceedFunc1116); if (state.failed) return ee;
			ed=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedFunc1120); if (state.failed) return ee;
			match(input,85,FOLLOW_85_in_exceedFunc1122); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			    ee=Evaluation.exceedance((var!=null?var.getText():null), exc, (mon!=null?mon.getText():null), (sy!=null?sy.getText():null), (sm!=null?sm.getText():null), (sd!=null?sd.getText():null), (ey!=null?ey.getText():null), (em!=null?em.getText():null), (ed!=null?ed.getText():null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "exceedFunc"



	// $ANTLR start "exceedtsiFunc"
	// Evaluator.g:238:1: exceedtsiFunc returns [EvalExpression ee] : EXCEEDANCE_TSI '(' var= IDENT ';' exc= term ';' (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL ) ';' sy= INTEGER ';' sm= MONTH_CONST ';' sd= INTEGER ';' ey= INTEGER ';' em= MONTH_CONST ';' ed= INTEGER ')' ;
	public final EvalExpression exceedtsiFunc() throws RecognitionException {
		EvalExpression ee = null;


		Token var=null;
		Token mon=null;
		Token sy=null;
		Token sm=null;
		Token sd=null;
		Token ey=null;
		Token em=null;
		Token ed=null;
		EvalExpression exc =null;

		try {
			// Evaluator.g:239:3: ( EXCEEDANCE_TSI '(' var= IDENT ';' exc= term ';' (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL ) ';' sy= INTEGER ';' sm= MONTH_CONST ';' sd= INTEGER ';' ey= INTEGER ';' em= MONTH_CONST ';' ed= INTEGER ')' )
			// Evaluator.g:239:5: EXCEEDANCE_TSI '(' var= IDENT ';' exc= term ';' (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL ) ';' sy= INTEGER ';' sm= MONTH_CONST ';' sd= INTEGER ';' ey= INTEGER ';' em= MONTH_CONST ';' ed= INTEGER ')'
			{
			match(input,EXCEEDANCE_TSI,FOLLOW_EXCEEDANCE_TSI_in_exceedtsiFunc1144); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_exceedtsiFunc1146); if (state.failed) return ee;
			var=(Token)match(input,IDENT,FOLLOW_IDENT_in_exceedtsiFunc1150); if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_exceedtsiFunc1152); if (state.failed) return ee;
			pushFollow(FOLLOW_term_in_exceedtsiFunc1156);
			exc=term();
			state._fsp--;
			if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_exceedtsiFunc1158); if (state.failed) return ee;
			// Evaluator.g:239:51: (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL )
			int alt12=3;
			switch ( input.LA(1) ) {
			case MONTH_CONST:
				{
				alt12=1;
				}
				break;
			case MONTH_RANGE:
				{
				alt12=2;
				}
				break;
			case ALL:
				{
				alt12=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return ee;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// Evaluator.g:239:52: mon= MONTH_CONST
					{
					mon=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_exceedtsiFunc1163); if (state.failed) return ee;
					}
					break;
				case 2 :
					// Evaluator.g:239:68: mon= MONTH_RANGE
					{
					mon=(Token)match(input,MONTH_RANGE,FOLLOW_MONTH_RANGE_in_exceedtsiFunc1167); if (state.failed) return ee;
					}
					break;
				case 3 :
					// Evaluator.g:239:84: mon= ALL
					{
					mon=(Token)match(input,ALL,FOLLOW_ALL_in_exceedtsiFunc1171); if (state.failed) return ee;
					}
					break;

			}

			match(input,92,FOLLOW_92_in_exceedtsiFunc1174); if (state.failed) return ee;
			sy=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedtsiFunc1178); if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_exceedtsiFunc1180); if (state.failed) return ee;
			sm=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_exceedtsiFunc1184); if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_exceedtsiFunc1186); if (state.failed) return ee;
			sd=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedtsiFunc1190); if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_exceedtsiFunc1192); if (state.failed) return ee;
			ey=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedtsiFunc1196); if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_exceedtsiFunc1198); if (state.failed) return ee;
			em=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_exceedtsiFunc1202); if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_exceedtsiFunc1204); if (state.failed) return ee;
			ed=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedtsiFunc1208); if (state.failed) return ee;
			match(input,85,FOLLOW_85_in_exceedtsiFunc1210); if (state.failed) return ee;
			if ( state.backtracking==0 ) {
			    ee=Evaluation.exceedance_tsi((var!=null?var.getText():null), exc, (mon!=null?mon.getText():null), (sy!=null?sy.getText():null), (sm!=null?sm.getText():null), (sd!=null?sd.getText():null), (ey!=null?ey.getText():null), (em!=null?em.getText():null), (ed!=null?ed.getText():null));
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "exceedtsiFunc"



	// $ANTLR start "range_func"
	// Evaluator.g:244:1: range_func returns [boolean result] : RANGE '(' MONTH ';' m1= MONTH_CONST ';' m2= MONTH_CONST ')' ;
	public final boolean range_func() throws RecognitionException {
		boolean result = false;


		Token m1=null;
		Token m2=null;

		try {
			// Evaluator.g:245:3: ( RANGE '(' MONTH ';' m1= MONTH_CONST ';' m2= MONTH_CONST ')' )
			// Evaluator.g:245:5: RANGE '(' MONTH ';' m1= MONTH_CONST ';' m2= MONTH_CONST ')'
			{
			match(input,RANGE,FOLLOW_RANGE_in_range_func1233); if (state.failed) return result;
			match(input,84,FOLLOW_84_in_range_func1235); if (state.failed) return result;
			match(input,MONTH,FOLLOW_MONTH_in_range_func1237); if (state.failed) return result;
			match(input,92,FOLLOW_92_in_range_func1239); if (state.failed) return result;
			m1=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_range_func1243); if (state.failed) return result;
			match(input,92,FOLLOW_92_in_range_func1245); if (state.failed) return result;
			m2=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_range_func1249); if (state.failed) return result;
			match(input,85,FOLLOW_85_in_range_func1251); if (state.failed) return result;
			if ( state.backtracking==0 ) {Evaluation.range((m1!=null?m1.getText():null), (m2!=null?m2.getText():null));}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "range_func"



	// $ANTLR start "timeseriesWithUnits"
	// Evaluator.g:247:1: timeseriesWithUnits : 'timeseries' 'kind' '=' partC 'units' '=' IDENT ;
	public final void timeseriesWithUnits() throws RecognitionException {
		try {
			// Evaluator.g:248:2: ( 'timeseries' 'kind' '=' partC 'units' '=' IDENT )
			// Evaluator.g:248:4: 'timeseries' 'kind' '=' partC 'units' '=' IDENT
			{
			match(input,105,FOLLOW_105_in_timeseriesWithUnits1263); if (state.failed) return;
			match(input,103,FOLLOW_103_in_timeseriesWithUnits1265); if (state.failed) return;
			match(input,95,FOLLOW_95_in_timeseriesWithUnits1267); if (state.failed) return;
			pushFollow(FOLLOW_partC_in_timeseriesWithUnits1269);
			partC();
			state._fsp--;
			if (state.failed) return;
			match(input,UNITS,FOLLOW_UNITS_in_timeseriesWithUnits1271); if (state.failed) return;
			match(input,95,FOLLOW_95_in_timeseriesWithUnits1273); if (state.failed) return;
			match(input,IDENT,FOLLOW_IDENT_in_timeseriesWithUnits1275); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "timeseriesWithUnits"



	// $ANTLR start "timeseries"
	// Evaluator.g:251:1: timeseries returns [EvalExpression ee] : 'timeseries' ;
	public final EvalExpression timeseries() throws RecognitionException {
		EvalExpression ee = null;


		try {
			// Evaluator.g:252:2: ( 'timeseries' )
			// Evaluator.g:252:4: 'timeseries'
			{
			match(input,105,FOLLOW_105_in_timeseries1291); if (state.failed) return ee;
			if ( state.backtracking==0 ) {ee=Evaluation.timeseries();}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "timeseries"



	// $ANTLR start "partC"
	// Evaluator.g:257:1: partC : ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )* ;
	public final void partC() throws RecognitionException {
		try {
			// Evaluator.g:257:6: ( ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )* )
			// Evaluator.g:257:9: ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )*
			{
			// Evaluator.g:257:9: ( IDENT | IDENT1 | usedKeywords )
			int alt13=3;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				alt13=1;
				}
				break;
			case IDENT1:
				{
				alt13=2;
				}
				break;
			case ABS:
			case ACOS:
			case ACOT:
			case ALL:
			case ALWAYS:
			case AND:
			case ASIN:
			case ATAN:
			case CASE:
			case CONDITION:
			case CONSTRAIN:
			case CONVERTUNITS:
			case COS:
			case COT:
			case CYCLE:
			case DAY:
			case DAYSIN:
			case DAYSINTIMESTEP:
			case DVAR:
			case EXCEEDANCE:
			case EXCEEDANCE_TSI:
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
			case MONTH_RANGE:
			case NAME:
			case NOT:
			case OR:
			case ORDER:
			case OUTPUT:
			case PASTMONTH:
			case POW:
			case RANGE:
			case REAL:
			case ROUND:
			case SELECT:
			case SIN:
			case SUM:
			case TAFCFS:
			case TAN:
			case TYPE:
			case UNITS:
			case UPPERBOUND:
			case UPPERUNBOUNDED:
			case USE:
			case WEIGHT:
			case WHERE:
			case YEAR:
				{
				alt13=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// Evaluator.g:257:10: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_partC1308); if (state.failed) return;
					}
					break;
				case 2 :
					// Evaluator.g:257:16: IDENT1
					{
					match(input,IDENT1,FOLLOW_IDENT1_in_partC1310); if (state.failed) return;
					}
					break;
				case 3 :
					// Evaluator.g:257:23: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_partC1312);
					usedKeywords();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// Evaluator.g:257:37: ( '-' ( IDENT | IDENT1 | usedKeywords ) )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==88) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// Evaluator.g:257:38: '-' ( IDENT | IDENT1 | usedKeywords )
					{
					match(input,88,FOLLOW_88_in_partC1316); if (state.failed) return;
					// Evaluator.g:257:42: ( IDENT | IDENT1 | usedKeywords )
					int alt14=3;
					switch ( input.LA(1) ) {
					case IDENT:
						{
						alt14=1;
						}
						break;
					case IDENT1:
						{
						alt14=2;
						}
						break;
					case ABS:
					case ACOS:
					case ACOT:
					case ALL:
					case ALWAYS:
					case AND:
					case ASIN:
					case ATAN:
					case CASE:
					case CONDITION:
					case CONSTRAIN:
					case CONVERTUNITS:
					case COS:
					case COT:
					case CYCLE:
					case DAY:
					case DAYSIN:
					case DAYSINTIMESTEP:
					case DVAR:
					case EXCEEDANCE:
					case EXCEEDANCE_TSI:
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
					case MONTH_RANGE:
					case NAME:
					case NOT:
					case OR:
					case ORDER:
					case OUTPUT:
					case PASTMONTH:
					case POW:
					case RANGE:
					case REAL:
					case ROUND:
					case SELECT:
					case SIN:
					case SUM:
					case TAFCFS:
					case TAN:
					case TYPE:
					case UNITS:
					case UPPERBOUND:
					case UPPERUNBOUNDED:
					case USE:
					case WEIGHT:
					case WHERE:
					case YEAR:
						{
						alt14=3;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return;}
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						throw nvae;
					}
					switch (alt14) {
						case 1 :
							// Evaluator.g:257:43: IDENT
							{
							match(input,IDENT,FOLLOW_IDENT_in_partC1319); if (state.failed) return;
							}
							break;
						case 2 :
							// Evaluator.g:257:49: IDENT1
							{
							match(input,IDENT1,FOLLOW_IDENT1_in_partC1321); if (state.failed) return;
							}
							break;
						case 3 :
							// Evaluator.g:257:56: usedKeywords
							{
							pushFollow(FOLLOW_usedKeywords_in_partC1323);
							usedKeywords();
							state._fsp--;
							if (state.failed) return;
							}
							break;

					}

					}
					break;

				default :
					break loop15;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "partC"


	public static class usedKeywords_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "usedKeywords"
	// Evaluator.g:259:1: usedKeywords : ( YEAR | MONTH | MONTH_CONST | MONTH_RANGE | DAY | PASTMONTH | RANGE | TAFCFS | DAYSIN | DAYSINTIMESTEP | SUM | MAX | MIN | INT | REAL | ABS | EXP | LOG | LOG10 | POW | MOD | ROUND | SELECT | FROM | GIVEN | USE | WHERE | CONSTRAIN | ALWAYS | NAME | DVAR | CYCLE | FILE | CONDITION | INCLUDE | LOWERBOUND | UPPERBOUND | INTEGERTYPE | UNITS | CONVERTUNITS | TYPE | OUTPUT | CASE | ORDER | EXPRESSION | LHSGTRHS | LHSLTRHS | WEIGHT | FUNCTION | FROM_WRESL_FILE | UPPERUNBOUNDED | LOWERUNBOUNDED | AND | OR | NOT | SIN | COS | TAN | COT | ASIN | ACOS | ATAN | ACOT | EXCEEDANCE | EXCEEDANCE_TSI | ALL );
	public final EvaluatorParser.usedKeywords_return usedKeywords() throws RecognitionException {
		EvaluatorParser.usedKeywords_return retval = new EvaluatorParser.usedKeywords_return();
		retval.start = input.LT(1);

		try {
			// Evaluator.g:259:13: ( YEAR | MONTH | MONTH_CONST | MONTH_RANGE | DAY | PASTMONTH | RANGE | TAFCFS | DAYSIN | DAYSINTIMESTEP | SUM | MAX | MIN | INT | REAL | ABS | EXP | LOG | LOG10 | POW | MOD | ROUND | SELECT | FROM | GIVEN | USE | WHERE | CONSTRAIN | ALWAYS | NAME | DVAR | CYCLE | FILE | CONDITION | INCLUDE | LOWERBOUND | UPPERBOUND | INTEGERTYPE | UNITS | CONVERTUNITS | TYPE | OUTPUT | CASE | ORDER | EXPRESSION | LHSGTRHS | LHSLTRHS | WEIGHT | FUNCTION | FROM_WRESL_FILE | UPPERUNBOUNDED | LOWERUNBOUNDED | AND | OR | NOT | SIN | COS | TAN | COT | ASIN | ACOS | ATAN | ACOT | EXCEEDANCE | EXCEEDANCE_TSI | ALL )
			// Evaluator.g:
			{
			if ( (input.LA(1) >= ABS && input.LA(1) <= AND)||(input.LA(1) >= ASIN && input.LA(1) <= ATAN)||input.LA(1)==CASE||(input.LA(1) >= CONDITION && input.LA(1) <= DAYSINTIMESTEP)||(input.LA(1) >= DVAR && input.LA(1) <= FILE)||(input.LA(1) >= FROM && input.LA(1) <= GIVEN)||(input.LA(1) >= INCLUDE && input.LA(1) <= INT)||input.LA(1)==INTEGERTYPE||(input.LA(1) >= LHSGTRHS && input.LA(1) <= MONTH_RANGE)||(input.LA(1) >= NAME && input.LA(1) <= SUM)||(input.LA(1) >= TAFCFS && input.LA(1) <= WHERE)||input.LA(1)==YEAR ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "usedKeywords"



	// $ANTLR start "tableSQL"
	// Evaluator.g:264:1: tableSQL returns [EvalExpression ee] : SELECT ( (i1= IDENT ) | (u1= usedKeywords ) ) FROM i2= IDENT ( GIVEN a= assignStatement )? ( USE i3= IDENT )? ( where_items )? ;
	public final EvalExpression tableSQL() throws RecognitionException {
		EvalExpression ee = null;


		Token i1=null;
		Token i2=null;
		Token i3=null;
		ParserRuleReturnScope u1 =null;
		ParserRuleReturnScope a =null;
		HashMap<String, Number> where_items30 =null;

		String table=null; String select=null; String use=null; HashMap<String, Number> given=null; HashMap<String, Number> where=null;
		try {
			// Evaluator.g:265:2: ( SELECT ( (i1= IDENT ) | (u1= usedKeywords ) ) FROM i2= IDENT ( GIVEN a= assignStatement )? ( USE i3= IDENT )? ( where_items )? )
			// Evaluator.g:265:4: SELECT ( (i1= IDENT ) | (u1= usedKeywords ) ) FROM i2= IDENT ( GIVEN a= assignStatement )? ( USE i3= IDENT )? ( where_items )?
			{
			match(input,SELECT,FOLLOW_SELECT_in_tableSQL1487); if (state.failed) return ee;
			// Evaluator.g:265:11: ( (i1= IDENT ) | (u1= usedKeywords ) )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==IDENT) ) {
				alt16=1;
			}
			else if ( ((LA16_0 >= ABS && LA16_0 <= AND)||(LA16_0 >= ASIN && LA16_0 <= ATAN)||LA16_0==CASE||(LA16_0 >= CONDITION && LA16_0 <= DAYSINTIMESTEP)||(LA16_0 >= DVAR && LA16_0 <= FILE)||(LA16_0 >= FROM && LA16_0 <= GIVEN)||(LA16_0 >= INCLUDE && LA16_0 <= INT)||LA16_0==INTEGERTYPE||(LA16_0 >= LHSGTRHS && LA16_0 <= MONTH_RANGE)||(LA16_0 >= NAME && LA16_0 <= SUM)||(LA16_0 >= TAFCFS && LA16_0 <= WHERE)||LA16_0==YEAR) ) {
				alt16=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return ee;}
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// Evaluator.g:265:12: (i1= IDENT )
					{
					// Evaluator.g:265:12: (i1= IDENT )
					// Evaluator.g:265:13: i1= IDENT
					{
					i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_tableSQL1493); if (state.failed) return ee;
					if ( state.backtracking==0 ) {select=(i1!=null?i1.getText():null);}
					}

					}
					break;
				case 2 :
					// Evaluator.g:265:41: (u1= usedKeywords )
					{
					// Evaluator.g:265:41: (u1= usedKeywords )
					// Evaluator.g:265:42: u1= usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_tableSQL1500);
					u1=usedKeywords();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {select=(u1!=null?input.toString(u1.start,u1.stop):null);}
					}

					}
					break;

			}

			match(input,FROM,FOLLOW_FROM_in_tableSQL1505); if (state.failed) return ee;
			i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_tableSQL1509); if (state.failed) return ee;
			if ( state.backtracking==0 ) {table=(i2!=null?i2.getText():null);}
			// Evaluator.g:266:4: ( GIVEN a= assignStatement )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==GIVEN) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// Evaluator.g:266:5: GIVEN a= assignStatement
					{
					match(input,GIVEN,FOLLOW_GIVEN_in_tableSQL1517); if (state.failed) return ee;
					pushFollow(FOLLOW_assignStatement_in_tableSQL1521);
					a=assignStatement();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {given=new HashMap<String, Number>(); given.put((a!=null?((EvaluatorParser.assignStatement_return)a).assignIdent:null), (a!=null?((EvaluatorParser.assignStatement_return)a).value:null));}
					}
					break;

			}

			// Evaluator.g:266:106: ( USE i3= IDENT )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==USE) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// Evaluator.g:266:107: USE i3= IDENT
					{
					match(input,USE,FOLLOW_USE_in_tableSQL1527); if (state.failed) return ee;
					i3=(Token)match(input,IDENT,FOLLOW_IDENT_in_tableSQL1531); if (state.failed) return ee;
					if ( state.backtracking==0 ) {use=(i3!=null?i3.getText():null);}
					}
					break;

			}

			// Evaluator.g:267:4: ( where_items )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==WHERE) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// Evaluator.g:267:5: where_items
					{
					pushFollow(FOLLOW_where_items_in_tableSQL1541);
					where_items30=where_items();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {where=where_items30;}
					}
					break;

			}

			if ( state.backtracking==0 ) {ee=Evaluation.tableSQL(table, select, where, given, use);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "tableSQL"



	// $ANTLR start "where_items"
	// Evaluator.g:270:1: where_items returns [HashMap<String, Number> where] : WHERE (r1= whereStatement ) ( ';' r= whereStatement )* ;
	public final HashMap<String, Number> where_items() throws RecognitionException {
		HashMap<String, Number> where = null;


		ParserRuleReturnScope r1 =null;
		ParserRuleReturnScope r =null;

		try {
			// Evaluator.g:271:2: ( WHERE (r1= whereStatement ) ( ';' r= whereStatement )* )
			// Evaluator.g:271:5: WHERE (r1= whereStatement ) ( ';' r= whereStatement )*
			{
			match(input,WHERE,FOLLOW_WHERE_in_where_items1565); if (state.failed) return where;
			// Evaluator.g:271:12: (r1= whereStatement )
			// Evaluator.g:271:13: r1= whereStatement
			{
			pushFollow(FOLLOW_whereStatement_in_where_items1571);
			r1=whereStatement();
			state._fsp--;
			if (state.failed) return where;
			if ( state.backtracking==0 ) {where=new HashMap<String, Number>(); where.put((r1!=null?((EvaluatorParser.whereStatement_return)r1).whereIdent:null), (r1!=null?((EvaluatorParser.whereStatement_return)r1).value:null));}
			}

			// Evaluator.g:272:10: ( ';' r= whereStatement )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==92) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// Evaluator.g:272:11: ';' r= whereStatement
					{
					match(input,92,FOLLOW_92_in_where_items1585); if (state.failed) return where;
					pushFollow(FOLLOW_whereStatement_in_where_items1589);
					r=whereStatement();
					state._fsp--;
					if (state.failed) return where;
					if ( state.backtracking==0 ) {where.put((r!=null?((EvaluatorParser.whereStatement_return)r).whereIdent:null), (r!=null?((EvaluatorParser.whereStatement_return)r).value:null));}
					}
					break;

				default :
					break loop20;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return where;
	}
	// $ANTLR end "where_items"



	// $ANTLR start "upperbound"
	// Evaluator.g:276:1: upperbound : ( IDENT | allnumber | ( allnumber '*' TAFCFS ) );
	public final void upperbound() throws RecognitionException {
		try {
			// Evaluator.g:276:11: ( IDENT | allnumber | ( allnumber '*' TAFCFS ) )
			int alt21=3;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				alt21=1;
				}
				break;
			case 88:
				{
				int LA21_2 = input.LA(2);
				if ( (LA21_2==FLOAT||LA21_2==INTEGER) ) {
					int LA21_3 = input.LA(3);
					if ( (LA21_3==EOF) ) {
						alt21=2;
					}
					else if ( (LA21_3==86) ) {
						alt21=3;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 21, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 21, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case FLOAT:
			case INTEGER:
				{
				int LA21_3 = input.LA(2);
				if ( (LA21_3==EOF) ) {
					alt21=2;
				}
				else if ( (LA21_3==86) ) {
					alt21=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 21, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 21, 0, input);
				throw nvae;
			}
			switch (alt21) {
				case 1 :
					// Evaluator.g:276:13: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_upperbound1602); if (state.failed) return;
					}
					break;
				case 2 :
					// Evaluator.g:276:19: allnumber
					{
					pushFollow(FOLLOW_allnumber_in_upperbound1604);
					allnumber();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// Evaluator.g:276:29: ( allnumber '*' TAFCFS )
					{
					// Evaluator.g:276:29: ( allnumber '*' TAFCFS )
					// Evaluator.g:276:30: allnumber '*' TAFCFS
					{
					pushFollow(FOLLOW_allnumber_in_upperbound1607);
					allnumber();
					state._fsp--;
					if (state.failed) return;
					match(input,86,FOLLOW_86_in_upperbound1609); if (state.failed) return;
					match(input,TAFCFS,FOLLOW_TAFCFS_in_upperbound1611); if (state.failed) return;
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "upperbound"



	// $ANTLR start "lowerbound"
	// Evaluator.g:278:1: lowerbound : ( IDENT | allnumber | ( allnumber '*' TAFCFS ) );
	public final void lowerbound() throws RecognitionException {
		try {
			// Evaluator.g:278:11: ( IDENT | allnumber | ( allnumber '*' TAFCFS ) )
			int alt22=3;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				alt22=1;
				}
				break;
			case 88:
				{
				int LA22_2 = input.LA(2);
				if ( (LA22_2==FLOAT||LA22_2==INTEGER) ) {
					int LA22_3 = input.LA(3);
					if ( (LA22_3==EOF) ) {
						alt22=2;
					}
					else if ( (LA22_3==86) ) {
						alt22=3;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 22, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 22, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case FLOAT:
			case INTEGER:
				{
				int LA22_3 = input.LA(2);
				if ( (LA22_3==EOF) ) {
					alt22=2;
				}
				else if ( (LA22_3==86) ) {
					alt22=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 22, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}
			switch (alt22) {
				case 1 :
					// Evaluator.g:278:13: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_lowerbound1619); if (state.failed) return;
					}
					break;
				case 2 :
					// Evaluator.g:278:19: allnumber
					{
					pushFollow(FOLLOW_allnumber_in_lowerbound1621);
					allnumber();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// Evaluator.g:278:29: ( allnumber '*' TAFCFS )
					{
					// Evaluator.g:278:29: ( allnumber '*' TAFCFS )
					// Evaluator.g:278:30: allnumber '*' TAFCFS
					{
					pushFollow(FOLLOW_allnumber_in_lowerbound1624);
					allnumber();
					state._fsp--;
					if (state.failed) return;
					match(input,86,FOLLOW_86_in_lowerbound1626); if (state.failed) return;
					match(input,TAFCFS,FOLLOW_TAFCFS_in_lowerbound1628); if (state.failed) return;
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "lowerbound"



	// $ANTLR start "sumExpression"
	// Evaluator.g:291:1: sumExpression returns [EvalExpression ee] : SUM '(' IDENT '=' e1= expression ';' e2= expression ( ';' ( ( '-' )? INTEGER ) )? ')' e3= expression ;
	public final EvalExpression sumExpression() throws RecognitionException {
		EvalExpression ee = null;


		Token IDENT31=null;
		Token INTEGER32=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;
		ParserRuleReturnScope e3 =null;

		String s="";
		try {
			// Evaluator.g:292:3: ( SUM '(' IDENT '=' e1= expression ';' e2= expression ( ';' ( ( '-' )? INTEGER ) )? ')' e3= expression )
			// Evaluator.g:292:5: SUM '(' IDENT '=' e1= expression ';' e2= expression ( ';' ( ( '-' )? INTEGER ) )? ')' e3= expression
			{
			match(input,SUM,FOLLOW_SUM_in_sumExpression1658); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_sumExpression1660); if (state.failed) return ee;
			IDENT31=(Token)match(input,IDENT,FOLLOW_IDENT_in_sumExpression1662); if (state.failed) return ee;
			if ( state.backtracking==0 ) {Evaluation.sumExpression_IDENT((IDENT31!=null?IDENT31.getText():null), sumIndex);}
			match(input,95,FOLLOW_95_in_sumExpression1665); if (state.failed) return ee;
			pushFollow(FOLLOW_expression_in_sumExpression1669);
			e1=expression();
			state._fsp--;
			if (state.failed) return ee;
			match(input,92,FOLLOW_92_in_sumExpression1671); if (state.failed) return ee;
			pushFollow(FOLLOW_expression_in_sumExpression1675);
			e2=expression();
			state._fsp--;
			if (state.failed) return ee;
			// Evaluator.g:292:111: ( ';' ( ( '-' )? INTEGER ) )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==92) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// Evaluator.g:292:112: ';' ( ( '-' )? INTEGER )
					{
					match(input,92,FOLLOW_92_in_sumExpression1678); if (state.failed) return ee;
					// Evaluator.g:292:116: ( ( '-' )? INTEGER )
					// Evaluator.g:292:117: ( '-' )? INTEGER
					{
					// Evaluator.g:292:117: ( '-' )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==88) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// Evaluator.g:292:118: '-'
							{
							match(input,88,FOLLOW_88_in_sumExpression1682); if (state.failed) return ee;
							if ( state.backtracking==0 ) {s=s+"-";}
							}
							break;

					}

					INTEGER32=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sumExpression1687); if (state.failed) return ee;
					if ( state.backtracking==0 ) {s=s+(INTEGER32!=null?INTEGER32.getText():null);}
					}

					}
					break;

			}

			match(input,85,FOLLOW_85_in_sumExpression1694); if (state.failed) return ee;
			if ( state.backtracking==0 ) {Evaluation.initSumExpression((e1!=null?((EvaluatorParser.expression_return)e1).ee:null), (e2!=null?((EvaluatorParser.expression_return)e2).ee:null), s, sumIndex);}
			pushFollow(FOLLOW_expression_in_sumExpression1700);
			e3=expression();
			state._fsp--;
			if (state.failed) return ee;
			if ( state.backtracking==0 ) {ee=Evaluation.sumExpression((e3!=null?((EvaluatorParser.expression_return)e3).ee:null), (e3!=null?input.toString(e3.start,e3.stop):null), sumIndex);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "sumExpression"



	// $ANTLR start "term"
	// Evaluator.g:295:1: term returns [EvalExpression ee] : ( ( IDENT ) | ( FLOAT ) | ( '(' (e= expression ) ')' ) | pastCycleValue | function | func | ( INTEGER ) | tafcfs_term | YEAR | MONTH | DAY | MONTH_CONST | PASTMONTH | DAYSIN | DAYSINTIMESTEP | ( SVAR ) | ARRAY_ITERATOR | '(' sumExpression ')' );
	public final EvalExpression term() throws RecognitionException {
		EvalExpression ee = null;


		Token IDENT33=null;
		Token FLOAT34=null;
		Token INTEGER38=null;
		Token MONTH_CONST40=null;
		Token PASTMONTH41=null;
		Token SVAR42=null;
		ParserRuleReturnScope e =null;
		IntDouble pastCycleValue35 =null;
		EvalExpression function36 =null;
		EvalExpression func37 =null;
		EvalExpression tafcfs_term39 =null;
		EvalExpression sumExpression43 =null;

		try {
			// Evaluator.g:296:2: ( ( IDENT ) | ( FLOAT ) | ( '(' (e= expression ) ')' ) | pastCycleValue | function | func | ( INTEGER ) | tafcfs_term | YEAR | MONTH | DAY | MONTH_CONST | PASTMONTH | DAYSIN | DAYSINTIMESTEP | ( SVAR ) | ARRAY_ITERATOR | '(' sumExpression ')' )
			int alt25=18;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				switch ( input.LA(2) ) {
				case 99:
					{
					alt25=4;
					}
					break;
				case 84:
					{
					alt25=5;
					}
					break;
				case EOF:
				case AND:
				case OR:
				case USE:
				case WHERE:
				case 85:
				case 86:
				case 87:
				case 88:
				case 90:
				case 92:
				case 93:
				case 94:
				case 95:
				case 96:
				case 97:
				case 98:
					{
					alt25=1;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return ee;}
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
			case 84:
				{
				int LA25_3 = input.LA(2);
				if ( ((LA25_3 >= ABS && LA25_3 <= ACOT)||(LA25_3 >= ARRAY_ITERATOR && LA25_3 <= ATAN)||(LA25_3 >= COS && LA25_3 <= COT)||(LA25_3 >= DAY && LA25_3 <= DAYSINTIMESTEP)||(LA25_3 >= EXCEEDANCE && LA25_3 <= EXP)||LA25_3==FLOAT||LA25_3==IDENT||(LA25_3 >= INT && LA25_3 <= INTEGER)||(LA25_3 >= LOG && LA25_3 <= LOG10)||(LA25_3 >= MAX && LA25_3 <= MONTH_CONST)||(LA25_3 >= PASTMONTH && LA25_3 <= POW)||(LA25_3 >= REAL && LA25_3 <= ROUND)||LA25_3==SIN||LA25_3==SVAR||(LA25_3 >= TAFCFS && LA25_3 <= TAN)||(LA25_3 >= YEAR && LA25_3 <= 84)||(LA25_3 >= 87 && LA25_3 <= 88)) ) {
					alt25=3;
				}
				else if ( (LA25_3==SUM) ) {
					alt25=18;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return ee;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 25, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case ABS:
			case ACOS:
			case ACOT:
			case ASIN:
			case ATAN:
			case COS:
			case COT:
			case EXCEEDANCE:
			case EXCEEDANCE_TSI:
			case EXP:
			case INT:
			case LOG:
			case LOG10:
			case MAX:
			case MIN:
			case MOD:
			case POW:
			case REAL:
			case ROUND:
			case SIN:
			case TAN:
				{
				alt25=6;
				}
				break;
			case INTEGER:
				{
				alt25=7;
				}
				break;
			case TAFCFS:
				{
				alt25=8;
				}
				break;
			case YEAR:
				{
				alt25=9;
				}
				break;
			case MONTH:
				{
				alt25=10;
				}
				break;
			case DAY:
				{
				alt25=11;
				}
				break;
			case MONTH_CONST:
				{
				alt25=12;
				}
				break;
			case PASTMONTH:
				{
				alt25=13;
				}
				break;
			case DAYSIN:
				{
				alt25=14;
				}
				break;
			case DAYSINTIMESTEP:
				{
				alt25=15;
				}
				break;
			case SVAR:
				{
				alt25=16;
				}
				break;
			case ARRAY_ITERATOR:
				{
				alt25=17;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return ee;}
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// Evaluator.g:296:4: ( IDENT )
					{
					// Evaluator.g:296:4: ( IDENT )
					// Evaluator.g:296:5: IDENT
					{
					IDENT33=(Token)match(input,IDENT,FOLLOW_IDENT_in_term1718); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=Evaluation.term_IDENT((IDENT33!=null?IDENT33.getText():null), sumIndex);}
					}

					}
					break;
				case 2 :
					// Evaluator.g:297:4: ( FLOAT )
					{
					// Evaluator.g:297:4: ( FLOAT )
					// Evaluator.g:297:5: FLOAT
					{
					FLOAT34=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_term1727); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=Evaluation.term_FLOAT((FLOAT34!=null?FLOAT34.getText():null));}
					}

					}
					break;
				case 3 :
					// Evaluator.g:298:4: ( '(' (e= expression ) ')' )
					{
					// Evaluator.g:298:4: ( '(' (e= expression ) ')' )
					// Evaluator.g:298:5: '(' (e= expression ) ')'
					{
					match(input,84,FOLLOW_84_in_term1737); if (state.failed) return ee;
					// Evaluator.g:298:9: (e= expression )
					// Evaluator.g:298:10: e= expression
					{
					pushFollow(FOLLOW_expression_in_term1742);
					e=expression();
					state._fsp--;
					if (state.failed) return ee;
					}

					match(input,85,FOLLOW_85_in_term1745); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=(e!=null?((EvaluatorParser.expression_return)e).ee:null);}
					}

					}
					break;
				case 4 :
					// Evaluator.g:299:4: pastCycleValue
					{
					pushFollow(FOLLOW_pastCycleValue_in_term1753);
					pastCycleValue35=pastCycleValue();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=Evaluation.term_knownTS(pastCycleValue35);}
					}
					break;
				case 5 :
					// Evaluator.g:300:4: function
					{
					pushFollow(FOLLOW_function_in_term1759);
					function36=function();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=function36;}
					}
					break;
				case 6 :
					// Evaluator.g:301:4: func
					{
					pushFollow(FOLLOW_func_in_term1765);
					func37=func();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=func37;}
					}
					break;
				case 7 :
					// Evaluator.g:302:4: ( INTEGER )
					{
					// Evaluator.g:302:4: ( INTEGER )
					// Evaluator.g:302:5: INTEGER
					{
					INTEGER38=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_term1772); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=Evaluation.term_INTEGER((INTEGER38!=null?INTEGER38.getText():null));}
					}

					}
					break;
				case 8 :
					// Evaluator.g:303:4: tafcfs_term
					{
					pushFollow(FOLLOW_tafcfs_term_in_term1781);
					tafcfs_term39=tafcfs_term();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=tafcfs_term39;}
					}
					break;
				case 9 :
					// Evaluator.g:304:4: YEAR
					{
					match(input,YEAR,FOLLOW_YEAR_in_term1787); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=Evaluation.term_YEAR();}
					}
					break;
				case 10 :
					// Evaluator.g:305:4: MONTH
					{
					match(input,MONTH,FOLLOW_MONTH_in_term1793); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=Evaluation.term_MONTH();}
					}
					break;
				case 11 :
					// Evaluator.g:306:4: DAY
					{
					match(input,DAY,FOLLOW_DAY_in_term1799); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=Evaluation.term_DAY();}
					}
					break;
				case 12 :
					// Evaluator.g:307:4: MONTH_CONST
					{
					MONTH_CONST40=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_term1805); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=Evaluation.term_MONTH_CONST((MONTH_CONST40!=null?MONTH_CONST40.getText():null));}
					}
					break;
				case 13 :
					// Evaluator.g:308:4: PASTMONTH
					{
					PASTMONTH41=(Token)match(input,PASTMONTH,FOLLOW_PASTMONTH_in_term1811); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=Evaluation.term_PASTMONTH((PASTMONTH41!=null?PASTMONTH41.getText():null));}
					}
					break;
				case 14 :
					// Evaluator.g:309:4: DAYSIN
					{
					match(input,DAYSIN,FOLLOW_DAYSIN_in_term1817); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=Evaluation.daysIn();}
					}
					break;
				case 15 :
					// Evaluator.g:310:4: DAYSINTIMESTEP
					{
					match(input,DAYSINTIMESTEP,FOLLOW_DAYSINTIMESTEP_in_term1823); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=Evaluation.daysInTimeStep();}
					}
					break;
				case 16 :
					// Evaluator.g:311:4: ( SVAR )
					{
					// Evaluator.g:311:4: ( SVAR )
					// Evaluator.g:311:5: SVAR
					{
					SVAR42=(Token)match(input,SVAR,FOLLOW_SVAR_in_term1830); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=Evaluation.term_SVAR((SVAR42!=null?SVAR42.getText():null).replace("{","").replace("}",""));}
					}

					}
					break;
				case 17 :
					// Evaluator.g:312:4: ARRAY_ITERATOR
					{
					match(input,ARRAY_ITERATOR,FOLLOW_ARRAY_ITERATOR_in_term1838); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=Evaluation.term_ARRAY_ITERATOR(prvs);}
					}
					break;
				case 18 :
					// Evaluator.g:313:4: '(' sumExpression ')'
					{
					match(input,84,FOLLOW_84_in_term1844); if (state.failed) return ee;
					pushFollow(FOLLOW_sumExpression_in_term1846);
					sumExpression43=sumExpression();
					state._fsp--;
					if (state.failed) return ee;
					match(input,85,FOLLOW_85_in_term1848); if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=sumExpression43;}
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "term"



	// $ANTLR start "tafcfs_term"
	// Evaluator.g:316:1: tafcfs_term returns [EvalExpression ee] : TAFCFS ( '(' expression ')' )? ;
	public final EvalExpression tafcfs_term() throws RecognitionException {
		EvalExpression ee = null;


		Token TAFCFS44=null;
		ParserRuleReturnScope expression45 =null;

		try {
			// Evaluator.g:316:40: ( TAFCFS ( '(' expression ')' )? )
			// Evaluator.g:316:42: TAFCFS ( '(' expression ')' )?
			{
			TAFCFS44=(Token)match(input,TAFCFS,FOLLOW_TAFCFS_in_tafcfs_term1863); if (state.failed) return ee;
			// Evaluator.g:316:49: ( '(' expression ')' )?
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==84) ) {
				alt26=1;
			}
			switch (alt26) {
				case 1 :
					// Evaluator.g:316:50: '(' expression ')'
					{
					match(input,84,FOLLOW_84_in_tafcfs_term1866); if (state.failed) return ee;
					pushFollow(FOLLOW_expression_in_tafcfs_term1868);
					expression45=expression();
					state._fsp--;
					if (state.failed) return ee;
					match(input,85,FOLLOW_85_in_tafcfs_term1870); if (state.failed) return ee;
					}
					break;

			}

			if ( state.backtracking==0 ) {
			    ee=Evaluation.tafcfs_term((TAFCFS44!=null?TAFCFS44.getText():null), (expression45!=null?((EvaluatorParser.expression_return)expression45).ee:null), sumIndex);
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "tafcfs_term"



	// $ANTLR start "pastCycleValue"
	// Evaluator.g:320:1: pastCycleValue returns [IntDouble result] : ( (p1= pastCycleNoTimeArray ) | (p2= pastCycleTimeArray ) | (p3= pastCycleIndexNoTimeArray ) | (p4= pastCycleIndexTimeArray ) );
	public final IntDouble pastCycleValue() throws RecognitionException {
		IntDouble result = null;


		IntDouble p1 =null;
		IntDouble p2 =null;
		IntDouble p3 =null;
		IntDouble p4 =null;

		try {
			// Evaluator.g:321:3: ( (p1= pastCycleNoTimeArray ) | (p2= pastCycleTimeArray ) | (p3= pastCycleIndexNoTimeArray ) | (p4= pastCycleIndexTimeArray ) )
			int alt27=4;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==IDENT) ) {
				int LA27_1 = input.LA(2);
				if ( (LA27_1==99) ) {
					int LA27_2 = input.LA(3);
					if ( (LA27_2==IDENT) ) {
						int LA27_3 = input.LA(4);
						if ( (LA27_3==100) ) {
							int LA27_5 = input.LA(5);
							if ( (LA27_5==84) ) {
								alt27=2;
							}
							else if ( (LA27_5==EOF||LA27_5==AND||LA27_5==OR||LA27_5==USE||LA27_5==WHERE||(LA27_5 >= 85 && LA27_5 <= 88)||LA27_5==90||(LA27_5 >= 92 && LA27_5 <= 98)) ) {
								alt27=1;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 27, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return result;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 27, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA27_2==88) ) {
						int LA27_4 = input.LA(4);
						if ( (LA27_4==INTEGER) ) {
							int LA27_6 = input.LA(5);
							if ( (LA27_6==100) ) {
								int LA27_9 = input.LA(6);
								if ( (LA27_9==84) ) {
									alt27=4;
								}
								else if ( (LA27_9==EOF||LA27_9==AND||LA27_9==OR||LA27_9==USE||LA27_9==WHERE||(LA27_9 >= 85 && LA27_9 <= 88)||LA27_9==90||(LA27_9 >= 92 && LA27_9 <= 98)) ) {
									alt27=3;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return result;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 27, 9, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 27, 6, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return result;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 27, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 27, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return result;}
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
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 27, 0, input);
				throw nvae;
			}

			switch (alt27) {
				case 1 :
					// Evaluator.g:321:5: (p1= pastCycleNoTimeArray )
					{
					// Evaluator.g:321:5: (p1= pastCycleNoTimeArray )
					// Evaluator.g:321:6: p1= pastCycleNoTimeArray
					{
					pushFollow(FOLLOW_pastCycleNoTimeArray_in_pastCycleValue1893);
					p1=pastCycleNoTimeArray();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {return p1;}
					}

					}
					break;
				case 2 :
					// Evaluator.g:321:51: (p2= pastCycleTimeArray )
					{
					// Evaluator.g:321:51: (p2= pastCycleTimeArray )
					// Evaluator.g:321:52: p2= pastCycleTimeArray
					{
					pushFollow(FOLLOW_pastCycleTimeArray_in_pastCycleValue1900);
					p2=pastCycleTimeArray();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {return p2;}
					}

					}
					break;
				case 3 :
					// Evaluator.g:321:95: (p3= pastCycleIndexNoTimeArray )
					{
					// Evaluator.g:321:95: (p3= pastCycleIndexNoTimeArray )
					// Evaluator.g:321:96: p3= pastCycleIndexNoTimeArray
					{
					pushFollow(FOLLOW_pastCycleIndexNoTimeArray_in_pastCycleValue1907);
					p3=pastCycleIndexNoTimeArray();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {return p3;}
					}

					}
					break;
				case 4 :
					// Evaluator.g:321:146: (p4= pastCycleIndexTimeArray )
					{
					// Evaluator.g:321:146: (p4= pastCycleIndexTimeArray )
					// Evaluator.g:321:147: p4= pastCycleIndexTimeArray
					{
					pushFollow(FOLLOW_pastCycleIndexTimeArray_in_pastCycleValue1914);
					p4=pastCycleIndexTimeArray();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {return p4;}
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "pastCycleValue"



	// $ANTLR start "pastCycleNoTimeArray"
	// Evaluator.g:324:1: pastCycleNoTimeArray returns [IntDouble result] : i1= IDENT '[' i2= IDENT ']' ;
	public final IntDouble pastCycleNoTimeArray() throws RecognitionException {
		IntDouble result = null;


		Token i1=null;
		Token i2=null;

		try {
			// Evaluator.g:325:3: (i1= IDENT '[' i2= IDENT ']' )
			// Evaluator.g:325:5: i1= IDENT '[' i2= IDENT ']'
			{
			i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleNoTimeArray1935); if (state.failed) return result;
			match(input,99,FOLLOW_99_in_pastCycleNoTimeArray1937); if (state.failed) return result;
			i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleNoTimeArray1941); if (state.failed) return result;
			match(input,100,FOLLOW_100_in_pastCycleNoTimeArray1943); if (state.failed) return result;
			if ( state.backtracking==0 ) {result=Evaluation.pastCycleNoTimeArray((i1!=null?i1.getText():null),(i2!=null?i2.getText():null));}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "pastCycleNoTimeArray"



	// $ANTLR start "pastCycleTimeArray"
	// Evaluator.g:328:1: pastCycleTimeArray returns [IntDouble result] : i1= IDENT '[' i2= IDENT ']' '(' e1= expression ')' ;
	public final IntDouble pastCycleTimeArray() throws RecognitionException {
		IntDouble result = null;


		Token i1=null;
		Token i2=null;
		ParserRuleReturnScope e1 =null;

		try {
			// Evaluator.g:329:3: (i1= IDENT '[' i2= IDENT ']' '(' e1= expression ')' )
			// Evaluator.g:329:5: i1= IDENT '[' i2= IDENT ']' '(' e1= expression ')'
			{
			i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleTimeArray1966); if (state.failed) return result;
			match(input,99,FOLLOW_99_in_pastCycleTimeArray1968); if (state.failed) return result;
			i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleTimeArray1972); if (state.failed) return result;
			match(input,100,FOLLOW_100_in_pastCycleTimeArray1974); if (state.failed) return result;
			match(input,84,FOLLOW_84_in_pastCycleTimeArray1976); if (state.failed) return result;
			pushFollow(FOLLOW_expression_in_pastCycleTimeArray1980);
			e1=expression();
			state._fsp--;
			if (state.failed) return result;
			match(input,85,FOLLOW_85_in_pastCycleTimeArray1982); if (state.failed) return result;
			if ( state.backtracking==0 ) {result=Evaluation.pastCycleTimeArray((i1!=null?i1.getText():null),(i2!=null?i2.getText():null), (e1!=null?((EvaluatorParser.expression_return)e1).ee:null));}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "pastCycleTimeArray"



	// $ANTLR start "pastCycleIndexNoTimeArray"
	// Evaluator.g:332:1: pastCycleIndexNoTimeArray returns [IntDouble result] : i1= IDENT '[' '-' index= INTEGER ']' ;
	public final IntDouble pastCycleIndexNoTimeArray() throws RecognitionException {
		IntDouble result = null;


		Token i1=null;
		Token index=null;

		try {
			// Evaluator.g:333:3: (i1= IDENT '[' '-' index= INTEGER ']' )
			// Evaluator.g:333:5: i1= IDENT '[' '-' index= INTEGER ']'
			{
			i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleIndexNoTimeArray2006); if (state.failed) return result;
			match(input,99,FOLLOW_99_in_pastCycleIndexNoTimeArray2008); if (state.failed) return result;
			match(input,88,FOLLOW_88_in_pastCycleIndexNoTimeArray2010); if (state.failed) return result;
			index=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_pastCycleIndexNoTimeArray2014); if (state.failed) return result;
			match(input,100,FOLLOW_100_in_pastCycleIndexNoTimeArray2016); if (state.failed) return result;
			if ( state.backtracking==0 ) {result=Evaluation.pastCycleIndexNoTimeArray((i1!=null?i1.getText():null),-Integer.parseInt((index!=null?index.getText():null)));}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "pastCycleIndexNoTimeArray"



	// $ANTLR start "pastCycleIndexTimeArray"
	// Evaluator.g:336:1: pastCycleIndexTimeArray returns [IntDouble result] : i1= IDENT '[' '-' index= INTEGER ']' '(' e1= expression ')' ;
	public final IntDouble pastCycleIndexTimeArray() throws RecognitionException {
		IntDouble result = null;


		Token i1=null;
		Token index=null;
		ParserRuleReturnScope e1 =null;

		try {
			// Evaluator.g:337:3: (i1= IDENT '[' '-' index= INTEGER ']' '(' e1= expression ')' )
			// Evaluator.g:337:5: i1= IDENT '[' '-' index= INTEGER ']' '(' e1= expression ')'
			{
			i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleIndexTimeArray2039); if (state.failed) return result;
			match(input,99,FOLLOW_99_in_pastCycleIndexTimeArray2041); if (state.failed) return result;
			match(input,88,FOLLOW_88_in_pastCycleIndexTimeArray2043); if (state.failed) return result;
			index=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_pastCycleIndexTimeArray2047); if (state.failed) return result;
			match(input,100,FOLLOW_100_in_pastCycleIndexTimeArray2049); if (state.failed) return result;
			match(input,84,FOLLOW_84_in_pastCycleIndexTimeArray2051); if (state.failed) return result;
			pushFollow(FOLLOW_expression_in_pastCycleIndexTimeArray2055);
			e1=expression();
			state._fsp--;
			if (state.failed) return result;
			match(input,85,FOLLOW_85_in_pastCycleIndexTimeArray2057); if (state.failed) return result;
			if ( state.backtracking==0 ) {result=Evaluation.pastCycleIndexTimeArray((i1!=null?i1.getText():null),-Integer.parseInt((index!=null?index.getText():null)), (e1!=null?((EvaluatorParser.expression_return)e1).ee:null));}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "pastCycleIndexTimeArray"



	// $ANTLR start "function"
	// Evaluator.g:340:1: function returns [EvalExpression ee] : ( (n= noArgFunction ) | (a= argFunction ) );
	public final EvalExpression function() throws RecognitionException {
		EvalExpression ee = null;


		EvalExpression n =null;
		EvalExpression a =null;

		try {
			// Evaluator.g:341:3: ( (n= noArgFunction ) | (a= argFunction ) )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==IDENT) ) {
				int LA28_1 = input.LA(2);
				if ( (LA28_1==84) ) {
					int LA28_2 = input.LA(3);
					if ( (LA28_2==85) ) {
						alt28=1;
					}
					else if ( ((LA28_2 >= ABS && LA28_2 <= ACOT)||(LA28_2 >= ARRAY_ITERATOR && LA28_2 <= ATAN)||(LA28_2 >= COS && LA28_2 <= COT)||(LA28_2 >= DAY && LA28_2 <= DAYSINTIMESTEP)||(LA28_2 >= EXCEEDANCE && LA28_2 <= EXP)||LA28_2==FLOAT||LA28_2==IDENT||(LA28_2 >= INT && LA28_2 <= INTEGER)||(LA28_2 >= LOG && LA28_2 <= LOG10)||(LA28_2 >= MAX && LA28_2 <= MONTH_CONST)||(LA28_2 >= PASTMONTH && LA28_2 <= POW)||(LA28_2 >= REAL && LA28_2 <= ROUND)||LA28_2==SIN||LA28_2==SVAR||(LA28_2 >= TAFCFS && LA28_2 <= TAN)||(LA28_2 >= YEAR && LA28_2 <= 84)||(LA28_2 >= 87 && LA28_2 <= 88)) ) {
						alt28=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return ee;}
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
					if (state.backtracking>0) {state.failed=true; return ee;}
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
				if (state.backtracking>0) {state.failed=true; return ee;}
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// Evaluator.g:341:5: (n= noArgFunction )
					{
					// Evaluator.g:341:5: (n= noArgFunction )
					// Evaluator.g:341:6: n= noArgFunction
					{
					pushFollow(FOLLOW_noArgFunction_in_function2080);
					n=noArgFunction();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=n;}
					}

					}
					break;
				case 2 :
					// Evaluator.g:341:34: (a= argFunction )
					{
					// Evaluator.g:341:34: (a= argFunction )
					// Evaluator.g:341:35: a= argFunction
					{
					pushFollow(FOLLOW_argFunction_in_function2087);
					a=argFunction();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee=a;}
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "function"



	// $ANTLR start "noArgFunction"
	// Evaluator.g:344:1: noArgFunction returns [EvalExpression ee] : IDENT '(' ')' ;
	public final EvalExpression noArgFunction() throws RecognitionException {
		EvalExpression ee = null;


		Token IDENT46=null;

		try {
			// Evaluator.g:345:3: ( IDENT '(' ')' )
			// Evaluator.g:345:5: IDENT '(' ')'
			{
			IDENT46=(Token)match(input,IDENT,FOLLOW_IDENT_in_noArgFunction2106); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_noArgFunction2108); if (state.failed) return ee;
			match(input,85,FOLLOW_85_in_noArgFunction2110); if (state.failed) return ee;
			if ( state.backtracking==0 ) {ee=Evaluation.noArgFunction((IDENT46!=null?IDENT46.getText():null));}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "noArgFunction"



	// $ANTLR start "argFunction"
	// Evaluator.g:347:1: argFunction returns [EvalExpression ee] : IDENT '(' (e1= expression |t1= trunk_timeArray ) ( ';' (e2= expression |t2= trunk_timeArray ) )* ')' ( '(' e0= expression ')' )? ;
	public final EvalExpression argFunction() throws RecognitionException {
		EvalExpression ee = null;


		Token IDENT47=null;
		ParserRuleReturnScope e1 =null;
		ArrayList<EvalExpression> t1 =null;
		ParserRuleReturnScope e2 =null;
		ArrayList<EvalExpression> t2 =null;
		ParserRuleReturnScope e0 =null;

		ArrayList<ArrayList<EvalExpression>> eeArray = new ArrayList<ArrayList<EvalExpression>>(); ArrayList<EvalExpression> ee0Array=new ArrayList<EvalExpression>();
		try {
			// Evaluator.g:348:3: ( IDENT '(' (e1= expression |t1= trunk_timeArray ) ( ';' (e2= expression |t2= trunk_timeArray ) )* ')' ( '(' e0= expression ')' )? )
			// Evaluator.g:348:5: IDENT '(' (e1= expression |t1= trunk_timeArray ) ( ';' (e2= expression |t2= trunk_timeArray ) )* ')' ( '(' e0= expression ')' )?
			{
			IDENT47=(Token)match(input,IDENT,FOLLOW_IDENT_in_argFunction2130); if (state.failed) return ee;
			match(input,84,FOLLOW_84_in_argFunction2132); if (state.failed) return ee;
			// Evaluator.g:348:15: (e1= expression |t1= trunk_timeArray )
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( ((LA29_0 >= ABS && LA29_0 <= ACOT)||(LA29_0 >= ARRAY_ITERATOR && LA29_0 <= ATAN)||(LA29_0 >= COS && LA29_0 <= COT)||(LA29_0 >= DAY && LA29_0 <= DAYSINTIMESTEP)||(LA29_0 >= EXCEEDANCE && LA29_0 <= EXP)||LA29_0==FLOAT||(LA29_0 >= INT && LA29_0 <= INTEGER)||(LA29_0 >= LOG && LA29_0 <= LOG10)||(LA29_0 >= MAX && LA29_0 <= MONTH_CONST)||(LA29_0 >= PASTMONTH && LA29_0 <= POW)||(LA29_0 >= REAL && LA29_0 <= ROUND)||LA29_0==SIN||LA29_0==SVAR||(LA29_0 >= TAFCFS && LA29_0 <= TAN)||(LA29_0 >= YEAR && LA29_0 <= 84)||(LA29_0 >= 87 && LA29_0 <= 88)) ) {
				alt29=1;
			}
			else if ( (LA29_0==IDENT) ) {
				int LA29_2 = input.LA(2);
				if ( ((LA29_2 >= 85 && LA29_2 <= 88)||LA29_2==90||LA29_2==92||LA29_2==99) ) {
					alt29=1;
				}
				else if ( (LA29_2==84) ) {
					switch ( input.LA(3) ) {
					case ABS:
					case ACOS:
					case ACOT:
					case ARRAY_ITERATOR:
					case ASIN:
					case ATAN:
					case COS:
					case COT:
					case DAY:
					case DAYSIN:
					case DAYSINTIMESTEP:
					case EXCEEDANCE:
					case EXCEEDANCE_TSI:
					case EXP:
					case FLOAT:
					case INT:
					case LOG:
					case LOG10:
					case MAX:
					case MIN:
					case MOD:
					case MONTH:
					case MONTH_CONST:
					case PASTMONTH:
					case POW:
					case REAL:
					case ROUND:
					case SIN:
					case SVAR:
					case TAFCFS:
					case TAN:
					case YEAR:
					case 84:
					case 85:
					case 87:
						{
						alt29=1;
						}
						break;
					case 88:
						{
						int LA29_4 = input.LA(4);
						if ( (LA29_4==INTEGER) ) {
							int LA29_7 = input.LA(5);
							if ( (LA29_7==91) ) {
								alt29=2;
							}
							else if ( ((LA29_7 >= 85 && LA29_7 <= 88)||LA29_7==90||LA29_7==92) ) {
								alt29=1;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return ee;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 29, 7, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}
						else if ( ((LA29_4 >= ABS && LA29_4 <= ACOT)||(LA29_4 >= ARRAY_ITERATOR && LA29_4 <= ATAN)||(LA29_4 >= COS && LA29_4 <= COT)||(LA29_4 >= DAY && LA29_4 <= DAYSINTIMESTEP)||(LA29_4 >= EXCEEDANCE && LA29_4 <= EXP)||LA29_4==FLOAT||LA29_4==IDENT||LA29_4==INT||(LA29_4 >= LOG && LA29_4 <= LOG10)||(LA29_4 >= MAX && LA29_4 <= MONTH_CONST)||(LA29_4 >= PASTMONTH && LA29_4 <= POW)||(LA29_4 >= REAL && LA29_4 <= ROUND)||LA29_4==SIN||LA29_4==SVAR||(LA29_4 >= TAFCFS && LA29_4 <= TAN)||(LA29_4 >= YEAR && LA29_4 <= 84)) ) {
							alt29=1;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return ee;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 29, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case IDENT:
						{
						int LA29_5 = input.LA(4);
						if ( ((LA29_5 >= 84 && LA29_5 <= 88)||LA29_5==90||LA29_5==92||LA29_5==99) ) {
							alt29=1;
						}
						else if ( (LA29_5==91) ) {
							alt29=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return ee;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 29, 5, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case INTEGER:
						{
						int LA29_6 = input.LA(4);
						if ( ((LA29_6 >= 85 && LA29_6 <= 88)||LA29_6==90||LA29_6==92) ) {
							alt29=1;
						}
						else if ( (LA29_6==91) ) {
							alt29=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return ee;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 29, 6, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return ee;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 29, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					if (state.backtracking>0) {state.failed=true; return ee;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 29, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return ee;}
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}

			switch (alt29) {
				case 1 :
					// Evaluator.g:348:16: e1= expression
					{
					pushFollow(FOLLOW_expression_in_argFunction2137);
					e1=expression();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ArrayList<EvalExpression> eeArray1=new ArrayList<EvalExpression>(); eeArray1.add((e1!=null?((EvaluatorParser.expression_return)e1).ee:null)); eeArray.add(eeArray1);}
					}
					break;
				case 2 :
					// Evaluator.g:349:6: t1= trunk_timeArray
					{
					pushFollow(FOLLOW_trunk_timeArray_in_argFunction2148);
					t1=trunk_timeArray();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {eeArray.add(t1);}
					}
					break;

			}

			// Evaluator.g:350:5: ( ';' (e2= expression |t2= trunk_timeArray ) )*
			loop31:
			while (true) {
				int alt31=2;
				int LA31_0 = input.LA(1);
				if ( (LA31_0==92) ) {
					alt31=1;
				}

				switch (alt31) {
				case 1 :
					// Evaluator.g:350:6: ';' (e2= expression |t2= trunk_timeArray )
					{
					match(input,92,FOLLOW_92_in_argFunction2158); if (state.failed) return ee;
					// Evaluator.g:350:10: (e2= expression |t2= trunk_timeArray )
					int alt30=2;
					int LA30_0 = input.LA(1);
					if ( ((LA30_0 >= ABS && LA30_0 <= ACOT)||(LA30_0 >= ARRAY_ITERATOR && LA30_0 <= ATAN)||(LA30_0 >= COS && LA30_0 <= COT)||(LA30_0 >= DAY && LA30_0 <= DAYSINTIMESTEP)||(LA30_0 >= EXCEEDANCE && LA30_0 <= EXP)||LA30_0==FLOAT||(LA30_0 >= INT && LA30_0 <= INTEGER)||(LA30_0 >= LOG && LA30_0 <= LOG10)||(LA30_0 >= MAX && LA30_0 <= MONTH_CONST)||(LA30_0 >= PASTMONTH && LA30_0 <= POW)||(LA30_0 >= REAL && LA30_0 <= ROUND)||LA30_0==SIN||LA30_0==SVAR||(LA30_0 >= TAFCFS && LA30_0 <= TAN)||(LA30_0 >= YEAR && LA30_0 <= 84)||(LA30_0 >= 87 && LA30_0 <= 88)) ) {
						alt30=1;
					}
					else if ( (LA30_0==IDENT) ) {
						int LA30_2 = input.LA(2);
						if ( ((LA30_2 >= 85 && LA30_2 <= 88)||LA30_2==90||LA30_2==92||LA30_2==99) ) {
							alt30=1;
						}
						else if ( (LA30_2==84) ) {
							switch ( input.LA(3) ) {
							case ABS:
							case ACOS:
							case ACOT:
							case ARRAY_ITERATOR:
							case ASIN:
							case ATAN:
							case COS:
							case COT:
							case DAY:
							case DAYSIN:
							case DAYSINTIMESTEP:
							case EXCEEDANCE:
							case EXCEEDANCE_TSI:
							case EXP:
							case FLOAT:
							case INT:
							case LOG:
							case LOG10:
							case MAX:
							case MIN:
							case MOD:
							case MONTH:
							case MONTH_CONST:
							case PASTMONTH:
							case POW:
							case REAL:
							case ROUND:
							case SIN:
							case SVAR:
							case TAFCFS:
							case TAN:
							case YEAR:
							case 84:
							case 85:
							case 87:
								{
								alt30=1;
								}
								break;
							case 88:
								{
								int LA30_4 = input.LA(4);
								if ( (LA30_4==INTEGER) ) {
									int LA30_7 = input.LA(5);
									if ( (LA30_7==91) ) {
										alt30=2;
									}
									else if ( ((LA30_7 >= 85 && LA30_7 <= 88)||LA30_7==90||LA30_7==92) ) {
										alt30=1;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return ee;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 30, 7, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}
								else if ( ((LA30_4 >= ABS && LA30_4 <= ACOT)||(LA30_4 >= ARRAY_ITERATOR && LA30_4 <= ATAN)||(LA30_4 >= COS && LA30_4 <= COT)||(LA30_4 >= DAY && LA30_4 <= DAYSINTIMESTEP)||(LA30_4 >= EXCEEDANCE && LA30_4 <= EXP)||LA30_4==FLOAT||LA30_4==IDENT||LA30_4==INT||(LA30_4 >= LOG && LA30_4 <= LOG10)||(LA30_4 >= MAX && LA30_4 <= MONTH_CONST)||(LA30_4 >= PASTMONTH && LA30_4 <= POW)||(LA30_4 >= REAL && LA30_4 <= ROUND)||LA30_4==SIN||LA30_4==SVAR||(LA30_4 >= TAFCFS && LA30_4 <= TAN)||(LA30_4 >= YEAR && LA30_4 <= 84)) ) {
									alt30=1;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return ee;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 30, 4, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case IDENT:
								{
								int LA30_5 = input.LA(4);
								if ( ((LA30_5 >= 84 && LA30_5 <= 88)||LA30_5==90||LA30_5==92||LA30_5==99) ) {
									alt30=1;
								}
								else if ( (LA30_5==91) ) {
									alt30=2;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return ee;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 30, 5, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case INTEGER:
								{
								int LA30_6 = input.LA(4);
								if ( ((LA30_6 >= 85 && LA30_6 <= 88)||LA30_6==90||LA30_6==92) ) {
									alt30=1;
								}
								else if ( (LA30_6==91) ) {
									alt30=2;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return ee;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 30, 6, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							default:
								if (state.backtracking>0) {state.failed=true; return ee;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 30, 3, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
						}

						else {
							if (state.backtracking>0) {state.failed=true; return ee;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 30, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return ee;}
						NoViableAltException nvae =
							new NoViableAltException("", 30, 0, input);
						throw nvae;
					}

					switch (alt30) {
						case 1 :
							// Evaluator.g:350:11: e2= expression
							{
							pushFollow(FOLLOW_expression_in_argFunction2163);
							e2=expression();
							state._fsp--;
							if (state.failed) return ee;
							if ( state.backtracking==0 ) {ArrayList<EvalExpression> eeArray1=new ArrayList<EvalExpression>(); eeArray1.add((e2!=null?((EvaluatorParser.expression_return)e2).ee:null)); eeArray.add(eeArray1);}
							}
							break;
						case 2 :
							// Evaluator.g:351:6: t2= trunk_timeArray
							{
							pushFollow(FOLLOW_trunk_timeArray_in_argFunction2173);
							t2=trunk_timeArray();
							state._fsp--;
							if (state.failed) return ee;
							if ( state.backtracking==0 ) {eeArray.add(t2);}
							}
							break;

					}

					}
					break;

				default :
					break loop31;
				}
			}

			match(input,85,FOLLOW_85_in_argFunction2179); if (state.failed) return ee;
			// Evaluator.g:351:59: ( '(' e0= expression ')' )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==84) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// Evaluator.g:351:60: '(' e0= expression ')'
					{
					match(input,84,FOLLOW_84_in_argFunction2182); if (state.failed) return ee;
					pushFollow(FOLLOW_expression_in_argFunction2186);
					e0=expression();
					state._fsp--;
					if (state.failed) return ee;
					if ( state.backtracking==0 ) {ee0Array.add((e0!=null?((EvaluatorParser.expression_return)e0).ee:null));}
					match(input,85,FOLLOW_85_in_argFunction2190); if (state.failed) return ee;
					}
					break;

			}

			if ( state.backtracking==0 ) {
			        if (ee0Array.size()==0){
			          ee=Evaluation.argFunction((IDENT47!=null?IDENT47.getText():null),eeArray,sumIndex);   
			        }else{
			          ee=Evaluation.pastTSFV((IDENT47!=null?IDENT47.getText():null), (e0!=null?((EvaluatorParser.expression_return)e0).ee:null), eeArray, prvs);
			        }
			    }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "argFunction"



	// $ANTLR start "trunk_timeArray"
	// Evaluator.g:360:1: trunk_timeArray returns [ArrayList<EvalExpression> eeArray] : i0= IDENT '(' (n1= integer |i1= IDENT ) ':' (n2= integer |i2= IDENT ) ')' ;
	public final ArrayList<EvalExpression> trunk_timeArray() throws RecognitionException {
		ArrayList<EvalExpression> eeArray = null;


		Token i0=null;
		Token i1=null;
		Token i2=null;
		ParserRuleReturnScope n1 =null;
		ParserRuleReturnScope n2 =null;

		eeArray = new ArrayList<EvalExpression>(); IntDouble start=new IntDouble(1, true);  IntDouble end=new IntDouble(1, true);
		try {
			// Evaluator.g:361:3: (i0= IDENT '(' (n1= integer |i1= IDENT ) ':' (n2= integer |i2= IDENT ) ')' )
			// Evaluator.g:361:5: i0= IDENT '(' (n1= integer |i1= IDENT ) ':' (n2= integer |i2= IDENT ) ')'
			{
			i0=(Token)match(input,IDENT,FOLLOW_IDENT_in_trunk_timeArray2217); if (state.failed) return eeArray;
			match(input,84,FOLLOW_84_in_trunk_timeArray2219); if (state.failed) return eeArray;
			// Evaluator.g:361:18: (n1= integer |i1= IDENT )
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==INTEGER||LA33_0==88) ) {
				alt33=1;
			}
			else if ( (LA33_0==IDENT) ) {
				alt33=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return eeArray;}
				NoViableAltException nvae =
					new NoViableAltException("", 33, 0, input);
				throw nvae;
			}

			switch (alt33) {
				case 1 :
					// Evaluator.g:361:19: n1= integer
					{
					pushFollow(FOLLOW_integer_in_trunk_timeArray2224);
					n1=integer();
					state._fsp--;
					if (state.failed) return eeArray;
					if ( state.backtracking==0 ) {start=ValueEvaluation.term_INTEGER((n1!=null?input.toString(n1.start,n1.stop):null));}
					}
					break;
				case 2 :
					// Evaluator.g:361:77: i1= IDENT
					{
					i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_trunk_timeArray2229); if (state.failed) return eeArray;
					if ( state.backtracking==0 ) {start=ValueEvaluation.term_IDENT((i1!=null?i1.getText():null), sumIndex);}
					}
					break;

			}

			match(input,91,FOLLOW_91_in_trunk_timeArray2233); if (state.failed) return eeArray;
			// Evaluator.g:361:146: (n2= integer |i2= IDENT )
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==INTEGER||LA34_0==88) ) {
				alt34=1;
			}
			else if ( (LA34_0==IDENT) ) {
				alt34=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return eeArray;}
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// Evaluator.g:361:147: n2= integer
					{
					pushFollow(FOLLOW_integer_in_trunk_timeArray2238);
					n2=integer();
					state._fsp--;
					if (state.failed) return eeArray;
					if ( state.backtracking==0 ) {end=ValueEvaluation.term_INTEGER((n2!=null?input.toString(n2.start,n2.stop):null));}
					}
					break;
				case 2 :
					// Evaluator.g:361:203: i2= IDENT
					{
					i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_trunk_timeArray2243); if (state.failed) return eeArray;
					if ( state.backtracking==0 ) {end=ValueEvaluation.term_IDENT((i2!=null?i2.getText():null), sumIndex);}
					}
					break;

			}

			match(input,85,FOLLOW_85_in_trunk_timeArray2247); if (state.failed) return eeArray;
			if ( state.backtracking==0 ) {
			    eeArray=Evaluation.trunk_timeArray((i0!=null?i0.getText():null), start, end);
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return eeArray;
	}
	// $ANTLR end "trunk_timeArray"



	// $ANTLR start "unary"
	// Evaluator.g:367:1: unary returns [EvalExpression ee] : (s= ( '+' | '-' ) )? term ;
	public final EvalExpression unary() throws RecognitionException {
		EvalExpression ee = null;


		Token s=null;
		EvalExpression term48 =null;

		try {
			// Evaluator.g:368:2: ( (s= ( '+' | '-' ) )? term )
			// Evaluator.g:368:4: (s= ( '+' | '-' ) )? term
			{
			// Evaluator.g:368:4: (s= ( '+' | '-' ) )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( ((LA35_0 >= 87 && LA35_0 <= 88)) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// Evaluator.g:368:5: s= ( '+' | '-' )
					{
					s=input.LT(1);
					if ( (input.LA(1) >= 87 && input.LA(1) <= 88) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return ee;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			pushFollow(FOLLOW_term_in_unary2283);
			term48=term();
			state._fsp--;
			if (state.failed) return ee;
			if ( state.backtracking==0 ) {ee=Evaluation.unary((s!=null?s.getText():null), term48);
				}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "unary"



	// $ANTLR start "allnumber"
	// Evaluator.g:371:1: allnumber : ( '-' )? number ;
	public final void allnumber() throws RecognitionException {
		try {
			// Evaluator.g:372:2: ( ( '-' )? number )
			// Evaluator.g:372:4: ( '-' )? number
			{
			// Evaluator.g:372:4: ( '-' )?
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==88) ) {
				alt36=1;
			}
			switch (alt36) {
				case 1 :
					// Evaluator.g:372:5: '-'
					{
					match(input,88,FOLLOW_88_in_allnumber2296); if (state.failed) return;
					}
					break;

			}

			pushFollow(FOLLOW_number_in_allnumber2300);
			number();
			state._fsp--;
			if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "allnumber"



	// $ANTLR start "mult"
	// Evaluator.g:374:1: mult returns [EvalExpression ee] : (u1= unary ) (s= ( '*' | '/' ) (u2= unary ) )* ;
	public final EvalExpression mult() throws RecognitionException {
		EvalExpression ee = null;


		Token s=null;
		EvalExpression u1 =null;
		EvalExpression u2 =null;

		try {
			// Evaluator.g:375:2: ( (u1= unary ) (s= ( '*' | '/' ) (u2= unary ) )* )
			// Evaluator.g:375:4: (u1= unary ) (s= ( '*' | '/' ) (u2= unary ) )*
			{
			// Evaluator.g:375:4: (u1= unary )
			// Evaluator.g:375:5: u1= unary
			{
			pushFollow(FOLLOW_unary_in_mult2318);
			u1=unary();
			state._fsp--;
			if (state.failed) return ee;
			if ( state.backtracking==0 ) {ee=u1;}
			}

			// Evaluator.g:375:28: (s= ( '*' | '/' ) (u2= unary ) )*
			loop37:
			while (true) {
				int alt37=2;
				int LA37_0 = input.LA(1);
				if ( (LA37_0==86||LA37_0==90) ) {
					alt37=1;
				}

				switch (alt37) {
				case 1 :
					// Evaluator.g:375:29: s= ( '*' | '/' ) (u2= unary )
					{
					s=input.LT(1);
					if ( input.LA(1)==86||input.LA(1)==90 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return ee;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					// Evaluator.g:375:42: (u2= unary )
					// Evaluator.g:375:43: u2= unary
					{
					pushFollow(FOLLOW_unary_in_mult2336);
					u2=unary();
					state._fsp--;
					if (state.failed) return ee;
					}

					if ( state.backtracking==0 ) {
						   if ((s!=null?s.getText():null).equals("*")){
						     ee=Evaluation.mult(ee, u2);
						   }else{
						     ee=Evaluation.divide(ee, u2);
						   }
					  }
					}
					break;

				default :
					break loop37;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "mult"



	// $ANTLR start "add"
	// Evaluator.g:384:1: add returns [EvalExpression ee] : (m1= mult ) ( (s= ( '+' | '-' ) ) (m2= mult ) )* ;
	public final EvalExpression add() throws RecognitionException {
		EvalExpression ee = null;


		Token s=null;
		EvalExpression m1 =null;
		EvalExpression m2 =null;

		try {
			// Evaluator.g:385:2: ( (m1= mult ) ( (s= ( '+' | '-' ) ) (m2= mult ) )* )
			// Evaluator.g:385:4: (m1= mult ) ( (s= ( '+' | '-' ) ) (m2= mult ) )*
			{
			// Evaluator.g:385:4: (m1= mult )
			// Evaluator.g:385:5: m1= mult
			{
			pushFollow(FOLLOW_mult_in_add2360);
			m1=mult();
			state._fsp--;
			if (state.failed) return ee;
			if ( state.backtracking==0 ) {ee=m1;}
			}

			// Evaluator.g:385:27: ( (s= ( '+' | '-' ) ) (m2= mult ) )*
			loop38:
			while (true) {
				int alt38=2;
				int LA38_0 = input.LA(1);
				if ( ((LA38_0 >= 87 && LA38_0 <= 88)) ) {
					alt38=1;
				}

				switch (alt38) {
				case 1 :
					// Evaluator.g:385:28: (s= ( '+' | '-' ) ) (m2= mult )
					{
					// Evaluator.g:385:28: (s= ( '+' | '-' ) )
					// Evaluator.g:385:29: s= ( '+' | '-' )
					{
					s=input.LT(1);
					if ( (input.LA(1) >= 87 && input.LA(1) <= 88) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return ee;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}

					// Evaluator.g:385:42: (m2= mult )
					// Evaluator.g:385:43: m2= mult
					{
					pushFollow(FOLLOW_mult_in_add2379);
					m2=mult();
					state._fsp--;
					if (state.failed) return ee;
					}

					if ( state.backtracking==0 ) {
					     if ((s!=null?s.getText():null).equals("+")){
					       ee=Evaluation.add(ee, m2);
					     }else{
					       ee=Evaluation.substract(ee, m2);
					     }
						}
					}
					break;

				default :
					break loop38;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ee;
	}
	// $ANTLR end "add"


	public static class expression_return extends ParserRuleReturnScope {
		public EvalExpression ee;
	};


	// $ANTLR start "expression"
	// Evaluator.g:394:1: expression returns [EvalExpression ee] : i= add ;
	public final EvaluatorParser.expression_return expression() throws RecognitionException {
		EvaluatorParser.expression_return retval = new EvaluatorParser.expression_return();
		retval.start = input.LT(1);

		EvalExpression i =null;

		try {
			// Evaluator.g:395:2: (i= add )
			// Evaluator.g:395:4: i= add
			{
			pushFollow(FOLLOW_add_in_expression2402);
			i=add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) {retval.ee =i;}
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class relation_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "relation"
	// Evaluator.g:398:1: relation : ( '==' | '<' | '>' | '>=' | '<=' );
	public final EvaluatorParser.relation_return relation() throws RecognitionException {
		EvaluatorParser.relation_return retval = new EvaluatorParser.relation_return();
		retval.start = input.LT(1);

		try {
			// Evaluator.g:399:2: ( '==' | '<' | '>' | '>=' | '<=' )
			// Evaluator.g:
			{
			if ( (input.LA(1) >= 93 && input.LA(1) <= 94)||(input.LA(1) >= 96 && input.LA(1) <= 98) ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "relation"


	public static class whereStatement_return extends ParserRuleReturnScope {
		public String whereIdent;
		public Number value;
	};


	// $ANTLR start "whereStatement"
	// Evaluator.g:406:1: whereStatement returns [String whereIdent, Number value] : ( (i= IDENT ) | (u= usedKeywords ) ) '=' expression ;
	public final EvaluatorParser.whereStatement_return whereStatement() throws RecognitionException {
		EvaluatorParser.whereStatement_return retval = new EvaluatorParser.whereStatement_return();
		retval.start = input.LT(1);

		Token i=null;
		ParserRuleReturnScope u =null;
		ParserRuleReturnScope expression49 =null;

		try {
			// Evaluator.g:407:3: ( ( (i= IDENT ) | (u= usedKeywords ) ) '=' expression )
			// Evaluator.g:407:5: ( (i= IDENT ) | (u= usedKeywords ) ) '=' expression
			{
			// Evaluator.g:407:5: ( (i= IDENT ) | (u= usedKeywords ) )
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==IDENT) ) {
				alt39=1;
			}
			else if ( ((LA39_0 >= ABS && LA39_0 <= AND)||(LA39_0 >= ASIN && LA39_0 <= ATAN)||LA39_0==CASE||(LA39_0 >= CONDITION && LA39_0 <= DAYSINTIMESTEP)||(LA39_0 >= DVAR && LA39_0 <= FILE)||(LA39_0 >= FROM && LA39_0 <= GIVEN)||(LA39_0 >= INCLUDE && LA39_0 <= INT)||LA39_0==INTEGERTYPE||(LA39_0 >= LHSGTRHS && LA39_0 <= MONTH_RANGE)||(LA39_0 >= NAME && LA39_0 <= SUM)||(LA39_0 >= TAFCFS && LA39_0 <= WHERE)||LA39_0==YEAR) ) {
				alt39=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 39, 0, input);
				throw nvae;
			}

			switch (alt39) {
				case 1 :
					// Evaluator.g:407:6: (i= IDENT )
					{
					// Evaluator.g:407:6: (i= IDENT )
					// Evaluator.g:407:7: i= IDENT
					{
					i=(Token)match(input,IDENT,FOLLOW_IDENT_in_whereStatement2457); if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.whereIdent =(i!=null?i.getText():null);}
					}

					}
					break;
				case 2 :
					// Evaluator.g:407:38: (u= usedKeywords )
					{
					// Evaluator.g:407:38: (u= usedKeywords )
					// Evaluator.g:407:39: u= usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_whereStatement2464);
					u=usedKeywords();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.whereIdent =(u!=null?input.toString(u.start,u.stop):null);}
					}

					}
					break;

			}

			match(input,95,FOLLOW_95_in_whereStatement2469); if (state.failed) return retval;
			pushFollow(FOLLOW_expression_in_whereStatement2471);
			expression49=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) {retval.value =Evaluation.assignWhereStatement((expression49!=null?((EvaluatorParser.expression_return)expression49).ee:null));}
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "whereStatement"



	// $ANTLR start "conditionStatement"
	// Evaluator.g:410:1: conditionStatement returns [boolean result] : ( (r= relationUnary ) | ALWAYS ) ;
	public final boolean conditionStatement() throws RecognitionException {
		boolean result = false;


		boolean r =false;

		try {
			// Evaluator.g:411:2: ( ( (r= relationUnary ) | ALWAYS ) )
			// Evaluator.g:411:4: ( (r= relationUnary ) | ALWAYS )
			{
			// Evaluator.g:411:4: ( (r= relationUnary ) | ALWAYS )
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( ((LA40_0 >= ABS && LA40_0 <= ACOT)||(LA40_0 >= ARRAY_ITERATOR && LA40_0 <= ATAN)||(LA40_0 >= COS && LA40_0 <= COT)||(LA40_0 >= DAY && LA40_0 <= DAYSINTIMESTEP)||(LA40_0 >= EXCEEDANCE && LA40_0 <= EXP)||LA40_0==FLOAT||LA40_0==IDENT||(LA40_0 >= INT && LA40_0 <= INTEGER)||(LA40_0 >= LOG && LA40_0 <= LOG10)||(LA40_0 >= MAX && LA40_0 <= MONTH_CONST)||LA40_0==NOT||(LA40_0 >= PASTMONTH && LA40_0 <= ROUND)||LA40_0==SIN||LA40_0==SVAR||(LA40_0 >= TAFCFS && LA40_0 <= TAN)||(LA40_0 >= YEAR && LA40_0 <= 84)||(LA40_0 >= 87 && LA40_0 <= 88)) ) {
				alt40=1;
			}
			else if ( (LA40_0==ALWAYS) ) {
				alt40=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}

			switch (alt40) {
				case 1 :
					// Evaluator.g:411:5: (r= relationUnary )
					{
					// Evaluator.g:411:5: (r= relationUnary )
					// Evaluator.g:411:6: r= relationUnary
					{
					pushFollow(FOLLOW_relationUnary_in_conditionStatement2493);
					r=relationUnary();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result=r;}
					}

					}
					break;
				case 2 :
					// Evaluator.g:411:42: ALWAYS
					{
					match(input,ALWAYS,FOLLOW_ALWAYS_in_conditionStatement2497); if (state.failed) return result;
					if ( state.backtracking==0 ) {result=true;}
					}
					break;

			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "conditionStatement"



	// $ANTLR start "relationUnary"
	// Evaluator.g:414:1: relationUnary returns [boolean result] : (n= NOT )? r= relationOr ;
	public final boolean relationUnary() throws RecognitionException {
		boolean result = false;


		Token n=null;
		boolean r =false;

		try {
			// Evaluator.g:415:3: ( (n= NOT )? r= relationOr )
			// Evaluator.g:415:5: (n= NOT )? r= relationOr
			{
			// Evaluator.g:415:5: (n= NOT )?
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==NOT) ) {
				alt41=1;
			}
			switch (alt41) {
				case 1 :
					// Evaluator.g:415:6: n= NOT
					{
					n=(Token)match(input,NOT,FOLLOW_NOT_in_relationUnary2518); if (state.failed) return result;
					}
					break;

			}

			pushFollow(FOLLOW_relationOr_in_relationUnary2524);
			r=relationOr();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {
			      if (n==null){
			        return r;
			      }else{
			        if (r){
			          return false;
			        }else{
			          return true;
			        }
			      }
			  }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "relationUnary"



	// $ANTLR start "relationOr"
	// Evaluator.g:428:1: relationOr returns [boolean result] : r1= relationAnd (s= OR r2= relationAnd )* ;
	public final boolean relationOr() throws RecognitionException {
		boolean result = false;


		Token s=null;
		boolean r1 =false;
		boolean r2 =false;

		try {
			// Evaluator.g:429:3: (r1= relationAnd (s= OR r2= relationAnd )* )
			// Evaluator.g:429:5: r1= relationAnd (s= OR r2= relationAnd )*
			{
			pushFollow(FOLLOW_relationAnd_in_relationOr2547);
			r1=relationAnd();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {result=r1;}
			// Evaluator.g:430:5: (s= OR r2= relationAnd )*
			loop42:
			while (true) {
				int alt42=2;
				int LA42_0 = input.LA(1);
				if ( (LA42_0==OR) ) {
					alt42=1;
				}

				switch (alt42) {
				case 1 :
					// Evaluator.g:430:6: s= OR r2= relationAnd
					{
					s=(Token)match(input,OR,FOLLOW_OR_in_relationOr2559); if (state.failed) return result;
					pushFollow(FOLLOW_relationAnd_in_relationOr2563);
					r2=relationAnd();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result=Evaluation.relationStatementSeries(result, r2, (s!=null?s.getText():null));}
					}
					break;

				default :
					break loop42;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "relationOr"



	// $ANTLR start "relationAnd"
	// Evaluator.g:432:1: relationAnd returns [boolean result] : r1= relationRangeStatement (s= AND r2= relationRangeStatement )* ;
	public final boolean relationAnd() throws RecognitionException {
		boolean result = false;


		Token s=null;
		boolean r1 =false;
		boolean r2 =false;

		try {
			// Evaluator.g:433:3: (r1= relationRangeStatement (s= AND r2= relationRangeStatement )* )
			// Evaluator.g:433:5: r1= relationRangeStatement (s= AND r2= relationRangeStatement )*
			{
			pushFollow(FOLLOW_relationRangeStatement_in_relationAnd2585);
			r1=relationRangeStatement();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {result=r1;}
			// Evaluator.g:434:5: (s= AND r2= relationRangeStatement )*
			loop43:
			while (true) {
				int alt43=2;
				int LA43_0 = input.LA(1);
				if ( (LA43_0==AND) ) {
					alt43=1;
				}

				switch (alt43) {
				case 1 :
					// Evaluator.g:434:6: s= AND r2= relationRangeStatement
					{
					s=(Token)match(input,AND,FOLLOW_AND_in_relationAnd2597); if (state.failed) return result;
					pushFollow(FOLLOW_relationRangeStatement_in_relationAnd2601);
					r2=relationRangeStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result=Evaluation.relationStatementSeries(result, r2, (s!=null?s.getText():null));}
					}
					break;

				default :
					break loop43;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "relationAnd"



	// $ANTLR start "relationRangeStatement"
	// Evaluator.g:436:1: relationRangeStatement returns [boolean result] : ( (r1= relationStatement ) | (r2= range_func ) );
	public final boolean relationRangeStatement() throws RecognitionException {
		boolean result = false;


		boolean r1 =false;
		boolean r2 =false;

		try {
			// Evaluator.g:437:3: ( (r1= relationStatement ) | (r2= range_func ) )
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( ((LA44_0 >= ABS && LA44_0 <= ACOT)||(LA44_0 >= ARRAY_ITERATOR && LA44_0 <= ATAN)||(LA44_0 >= COS && LA44_0 <= COT)||(LA44_0 >= DAY && LA44_0 <= DAYSINTIMESTEP)||(LA44_0 >= EXCEEDANCE && LA44_0 <= EXP)||LA44_0==FLOAT||LA44_0==IDENT||(LA44_0 >= INT && LA44_0 <= INTEGER)||(LA44_0 >= LOG && LA44_0 <= LOG10)||(LA44_0 >= MAX && LA44_0 <= MONTH_CONST)||(LA44_0 >= PASTMONTH && LA44_0 <= POW)||(LA44_0 >= REAL && LA44_0 <= ROUND)||LA44_0==SIN||LA44_0==SVAR||(LA44_0 >= TAFCFS && LA44_0 <= TAN)||(LA44_0 >= YEAR && LA44_0 <= 84)||(LA44_0 >= 87 && LA44_0 <= 88)) ) {
				alt44=1;
			}
			else if ( (LA44_0==RANGE) ) {
				alt44=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 44, 0, input);
				throw nvae;
			}

			switch (alt44) {
				case 1 :
					// Evaluator.g:437:5: (r1= relationStatement )
					{
					// Evaluator.g:437:5: (r1= relationStatement )
					// Evaluator.g:437:6: r1= relationStatement
					{
					pushFollow(FOLLOW_relationStatement_in_relationRangeStatement2623);
					r1=relationStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result=r1;}
					}

					}
					break;
				case 2 :
					// Evaluator.g:437:48: (r2= range_func )
					{
					// Evaluator.g:437:48: (r2= range_func )
					// Evaluator.g:437:49: r2= range_func
					{
					pushFollow(FOLLOW_range_func_in_relationRangeStatement2630);
					r2=range_func();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result=r2;}
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "relationRangeStatement"



	// $ANTLR start "relationStatement"
	// Evaluator.g:440:1: relationStatement returns [boolean result] : ( ( ( expression relation expression )=> (e1= expression ) relation (e2= expression ) ) | ( ( '(' relationUnary ')' )=> '(' r2= relationUnary ')' ) );
	public final boolean relationStatement() throws RecognitionException {
		boolean result = false;


		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;
		boolean r2 =false;
		ParserRuleReturnScope relation50 =null;

		try {
			// Evaluator.g:441:2: ( ( ( expression relation expression )=> (e1= expression ) relation (e2= expression ) ) | ( ( '(' relationUnary ')' )=> '(' r2= relationUnary ')' ) )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( ((LA45_0 >= 87 && LA45_0 <= 88)) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==IDENT) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==FLOAT) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==84) ) {
				int LA45_4 = input.LA(2);
				if ( (synpred1_Evaluator()) ) {
					alt45=1;
				}
				else if ( (synpred2_Evaluator()) ) {
					alt45=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return result;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 45, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA45_0==MAX) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==MIN) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==INT) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==REAL) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==ABS) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==EXP) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==LOG) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==LOG10) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==POW) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==MOD) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==ROUND) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==SIN) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==COS) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==TAN) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==COT) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==ASIN) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==ACOS) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==ATAN) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==ACOT) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==EXCEEDANCE) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==EXCEEDANCE_TSI) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==INTEGER) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==TAFCFS) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==YEAR) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==MONTH) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==DAY) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==MONTH_CONST) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==PASTMONTH) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==DAYSIN) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==DAYSINTIMESTEP) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==SVAR) && (synpred1_Evaluator())) {
				alt45=1;
			}
			else if ( (LA45_0==ARRAY_ITERATOR) && (synpred1_Evaluator())) {
				alt45=1;
			}

			switch (alt45) {
				case 1 :
					// Evaluator.g:441:4: ( ( expression relation expression )=> (e1= expression ) relation (e2= expression ) )
					{
					// Evaluator.g:441:4: ( ( expression relation expression )=> (e1= expression ) relation (e2= expression ) )
					// Evaluator.g:441:6: ( expression relation expression )=> (e1= expression ) relation (e2= expression )
					{
					// Evaluator.g:441:44: (e1= expression )
					// Evaluator.g:441:45: e1= expression
					{
					pushFollow(FOLLOW_expression_in_relationStatement2668);
					e1=expression();
					state._fsp--;
					if (state.failed) return result;
					}

					pushFollow(FOLLOW_relation_in_relationStatement2671);
					relation50=relation();
					state._fsp--;
					if (state.failed) return result;
					// Evaluator.g:441:69: (e2= expression )
					// Evaluator.g:441:70: e2= expression
					{
					pushFollow(FOLLOW_expression_in_relationStatement2676);
					e2=expression();
					state._fsp--;
					if (state.failed) return result;
					}

					if ( state.backtracking==0 ) {result=Evaluation.relationStatement((e1!=null?((EvaluatorParser.expression_return)e1).ee:null), (e2!=null?((EvaluatorParser.expression_return)e2).ee:null), (relation50!=null?input.toString(relation50.start,relation50.stop):null));}
					}

					}
					break;
				case 2 :
					// Evaluator.g:442:4: ( ( '(' relationUnary ')' )=> '(' r2= relationUnary ')' )
					{
					// Evaluator.g:442:4: ( ( '(' relationUnary ')' )=> '(' r2= relationUnary ')' )
					// Evaluator.g:442:6: ( '(' relationUnary ')' )=> '(' r2= relationUnary ')'
					{
					match(input,84,FOLLOW_84_in_relationStatement2699); if (state.failed) return result;
					pushFollow(FOLLOW_relationUnary_in_relationStatement2702);
					r2=relationUnary();
					state._fsp--;
					if (state.failed) return result;
					match(input,85,FOLLOW_85_in_relationStatement2703); if (state.failed) return result;
					if ( state.backtracking==0 ) {result=r2;}
					}

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return result;
	}
	// $ANTLR end "relationStatement"



	// $ANTLR start "constraintStatement"
	// Evaluator.g:445:1: constraintStatement returns [EvalConstraint ec] : e1= expression ( (s= '=' ) | (s= '>' ) | (s= '<' ) ) e2= expression ;
	public final EvalConstraint constraintStatement() throws RecognitionException {
		EvalConstraint ec = null;


		Token s=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		try {
			// Evaluator.g:446:3: (e1= expression ( (s= '=' ) | (s= '>' ) | (s= '<' ) ) e2= expression )
			// Evaluator.g:446:5: e1= expression ( (s= '=' ) | (s= '>' ) | (s= '<' ) ) e2= expression
			{
			pushFollow(FOLLOW_expression_in_constraintStatement2725);
			e1=expression();
			state._fsp--;
			if (state.failed) return ec;
			// Evaluator.g:446:19: ( (s= '=' ) | (s= '>' ) | (s= '<' ) )
			int alt46=3;
			switch ( input.LA(1) ) {
			case 95:
				{
				alt46=1;
				}
				break;
			case 97:
				{
				alt46=2;
				}
				break;
			case 93:
				{
				alt46=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return ec;}
				NoViableAltException nvae =
					new NoViableAltException("", 46, 0, input);
				throw nvae;
			}
			switch (alt46) {
				case 1 :
					// Evaluator.g:446:20: (s= '=' )
					{
					// Evaluator.g:446:20: (s= '=' )
					// Evaluator.g:446:21: s= '='
					{
					s=(Token)match(input,95,FOLLOW_95_in_constraintStatement2731); if (state.failed) return ec;
					}

					}
					break;
				case 2 :
					// Evaluator.g:446:28: (s= '>' )
					{
					// Evaluator.g:446:28: (s= '>' )
					// Evaluator.g:446:29: s= '>'
					{
					s=(Token)match(input,97,FOLLOW_97_in_constraintStatement2737); if (state.failed) return ec;
					}

					}
					break;
				case 3 :
					// Evaluator.g:446:36: (s= '<' )
					{
					// Evaluator.g:446:36: (s= '<' )
					// Evaluator.g:446:37: s= '<'
					{
					s=(Token)match(input,93,FOLLOW_93_in_constraintStatement2743); if (state.failed) return ec;
					}

					}
					break;

			}

			pushFollow(FOLLOW_expression_in_constraintStatement2749);
			e2=expression();
			state._fsp--;
			if (state.failed) return ec;
			if ( state.backtracking==0 ) {ec=Evaluation.constraintStatement((e1!=null?((EvaluatorParser.expression_return)e1).ee:null), (e2!=null?((EvaluatorParser.expression_return)e2).ee:null), (s!=null?s.getText():null));}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return ec;
	}
	// $ANTLR end "constraintStatement"


	public static class assignStatement_return extends ParserRuleReturnScope {
		public String assignIdent;
		public Number value;
	};


	// $ANTLR start "assignStatement"
	// Evaluator.g:449:1: assignStatement returns [String assignIdent, Number value] : IDENT '=' expression ;
	public final EvaluatorParser.assignStatement_return assignStatement() throws RecognitionException {
		EvaluatorParser.assignStatement_return retval = new EvaluatorParser.assignStatement_return();
		retval.start = input.LT(1);

		Token IDENT51=null;
		ParserRuleReturnScope expression52 =null;

		try {
			// Evaluator.g:450:3: ( IDENT '=' expression )
			// Evaluator.g:450:5: IDENT '=' expression
			{
			IDENT51=(Token)match(input,IDENT,FOLLOW_IDENT_in_assignStatement2769); if (state.failed) return retval;
			match(input,95,FOLLOW_95_in_assignStatement2771); if (state.failed) return retval;
			pushFollow(FOLLOW_expression_in_assignStatement2773);
			expression52=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) {retval.assignIdent =(IDENT51!=null?IDENT51.getText():null); retval.value =Evaluation.assignWhereStatement((expression52!=null?((EvaluatorParser.expression_return)expression52).ee:null));}
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignStatement"



	// $ANTLR start "number"
	// Evaluator.g:453:1: number : ( INTEGER | FLOAT );
	public final void number() throws RecognitionException {
		try {
			// Evaluator.g:454:2: ( INTEGER | FLOAT )
			// Evaluator.g:
			{
			if ( input.LA(1)==FLOAT||input.LA(1)==INTEGER ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "number"


	public static class integer_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "integer"
	// Evaluator.g:458:1: integer : ( integer_p | integer_n );
	public final EvaluatorParser.integer_return integer() throws RecognitionException {
		EvaluatorParser.integer_return retval = new EvaluatorParser.integer_return();
		retval.start = input.LT(1);

		try {
			// Evaluator.g:458:9: ( integer_p | integer_n )
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==INTEGER) ) {
				alt47=1;
			}
			else if ( (LA47_0==88) ) {
				alt47=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 47, 0, input);
				throw nvae;
			}

			switch (alt47) {
				case 1 :
					// Evaluator.g:458:11: integer_p
					{
					pushFollow(FOLLOW_integer_p_in_integer2805);
					integer_p();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;
				case 2 :
					// Evaluator.g:458:21: integer_n
					{
					pushFollow(FOLLOW_integer_n_in_integer2807);
					integer_n();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;

			}
			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "integer"



	// $ANTLR start "integer_p"
	// Evaluator.g:459:1: integer_p : INTEGER ;
	public final void integer_p() throws RecognitionException {
		try {
			// Evaluator.g:459:11: ( INTEGER )
			// Evaluator.g:459:13: INTEGER
			{
			match(input,INTEGER,FOLLOW_INTEGER_in_integer_p2815); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "integer_p"



	// $ANTLR start "integer_n"
	// Evaluator.g:460:1: integer_n : '-' INTEGER ;
	public final void integer_n() throws RecognitionException {
		try {
			// Evaluator.g:460:11: ( '-' INTEGER )
			// Evaluator.g:460:13: '-' INTEGER
			{
			match(input,88,FOLLOW_88_in_integer_n2823); if (state.failed) return;
			match(input,INTEGER,FOLLOW_INTEGER_in_integer_n2825); if (state.failed) return;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "integer_n"

	// $ANTLR start synpred1_Evaluator
	public final void synpred1_Evaluator_fragment() throws RecognitionException {
		// Evaluator.g:441:6: ( expression relation expression )
		// Evaluator.g:441:8: expression relation expression
		{
		pushFollow(FOLLOW_expression_in_synpred1_Evaluator2655);
		expression();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_relation_in_synpred1_Evaluator2657);
		relation();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_expression_in_synpred1_Evaluator2659);
		expression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred1_Evaluator

	// $ANTLR start synpred2_Evaluator
	public final void synpred2_Evaluator_fragment() throws RecognitionException {
		// Evaluator.g:442:6: ( '(' relationUnary ')' )
		// Evaluator.g:442:8: '(' relationUnary ')'
		{
		match(input,84,FOLLOW_84_in_synpred2_Evaluator2690); if (state.failed) return;
		pushFollow(FOLLOW_relationUnary_in_synpred2_Evaluator2691);
		relationUnary();
		state._fsp--;
		if (state.failed) return;
		match(input,85,FOLLOW_85_in_synpred2_Evaluator2692); if (state.failed) return;
		}

	}
	// $ANTLR end synpred2_Evaluator

	// Delegated rules

	public final boolean synpred1_Evaluator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_Evaluator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_Evaluator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_Evaluator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_goalInput_in_evaluator51 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expressionInput_in_evaluator55 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_softConstraint_in_evaluator60 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditionInput_in_evaluator64 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_102_in_goalInput78 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_constraintStatement_in_goalInput80 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_106_in_expressionInput88 = new BitSet(new long[]{0x80FD862139D81C70L,0x00000200019846FDL});
	public static final BitSet FOLLOW_expressionCollection_in_expressionInput90 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_104_in_softConstraint97 = new BitSet(new long[]{0x80FD862139D81C70L,0x00000200019846FDL});
	public static final BitSet FOLLOW_expressionCollection_in_softConstraint99 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_101_in_conditionInput106 = new BitSet(new long[]{0x88F9862139D81D70L,0x00000000019806AFL});
	public static final BitSet FOLLOW_conditionStatement_in_conditionInput108 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_lhsrhs120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONSTRAIN_in_lhsrhs122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_units131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_units134 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_units136 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_units138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_91_in_fileName150 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000008001B8BFF7FL});
	public static final BitSet FOLLOW_92_in_fileName152 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000008001B8BFF7FL});
	public static final BitSet FOLLOW_89_in_fileName154 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000008001B8BFF7FL});
	public static final BitSet FOLLOW_107_in_fileName156 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000008001B8BFF7FL});
	public static final BitSet FOLLOW_SYMBOLS_in_fileName158 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000008001B8BFF7FL});
	public static final BitSet FOLLOW_88_in_fileName160 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000008001B8BFF7FL});
	public static final BitSet FOLLOW_87_in_fileName162 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000008001B8BFF7FL});
	public static final BitSet FOLLOW_BACKSLASH_in_fileName164 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000008001B8BFF7FL});
	public static final BitSet FOLLOW_IDENT_in_fileName166 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000008001B8BFF7FL});
	public static final BitSet FOLLOW_IDENT1_in_fileName168 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000008001B8BFF7FL});
	public static final BitSet FOLLOW_IDENT2_in_fileName170 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000008001B8BFF7FL});
	public static final BitSet FOLLOW_INTEGER_in_fileName172 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000008001B8BFF7FL});
	public static final BitSet FOLLOW_FLOAT_in_fileName174 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000008001B8BFF7FL});
	public static final BitSet FOLLOW_usedKeywords_in_fileName176 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000008001B8BFF7FL});
	public static final BitSet FOLLOW_92_in_externalFile195 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000800138BFF7FL});
	public static final BitSet FOLLOW_89_in_externalFile197 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000800138BFF7FL});
	public static final BitSet FOLLOW_107_in_externalFile199 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000800138BFF7FL});
	public static final BitSet FOLLOW_SYMBOLS_in_externalFile201 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000800138BFF7FL});
	public static final BitSet FOLLOW_88_in_externalFile203 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000800138BFF7FL});
	public static final BitSet FOLLOW_87_in_externalFile205 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000800138BFF7FL});
	public static final BitSet FOLLOW_INTEGER_in_externalFile207 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000800138BFF7FL});
	public static final BitSet FOLLOW_FLOAT_in_externalFile209 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000800138BFF7FL});
	public static final BitSet FOLLOW_IDENT_in_externalFile211 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000800138BFF7FL});
	public static final BitSet FOLLOW_usedKeywords_in_externalFile213 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000800138BFF7FL});
	public static final BitSet FOLLOW_LETTER_in_text227 = new BitSet(new long[]{0x0000100002000002L});
	public static final BitSet FOLLOW_expression_in_expressionCollection252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tableSQL_in_expressionCollection259 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timeseriesWithUnits_in_expressionCollection266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timeseries_in_expressionCollection273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sumExpression_in_expressionCollection281 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPPERUNBOUNDED_in_expressionCollection288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOWERUNBOUNDED_in_expressionCollection295 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_max_func_in_func313 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_min_func_in_func321 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_int_func_in_func329 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_real_func_in_func337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_abs_func_in_func345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_func_in_func353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_log_func_in_func361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_log10_func_in_func369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pow_func_in_func377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mod_func_in_func385 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_round_func_in_func393 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sin_func_in_func401 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cos_func_in_func409 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tan_func_in_func417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cot_func_in_func425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_asin_func_in_func433 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_acos_func_in_func441 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atan_func_in_func449 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_acot_func_in_func457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exceedFunc_in_func465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exceedtsiFunc_in_func473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ROUND_in_round_func492 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_round_func494 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_round_func499 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_round_func501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_mod_func518 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_mod_func520 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_mod_func525 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_mod_func529 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_mod_func534 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_mod_func538 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAX_in_max_func555 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_max_func557 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_max_func562 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_max_func566 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_max_func571 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
	public static final BitSet FOLLOW_85_in_max_func577 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MIN_in_min_func591 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_min_func593 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_min_func598 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_min_func602 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_min_func607 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
	public static final BitSet FOLLOW_85_in_min_func613 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_int_func629 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_int_func631 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_int_func636 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_int_func639 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REAL_in_real_func656 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_real_func658 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_real_func663 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_real_func666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ABS_in_abs_func685 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_abs_func687 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_abs_func692 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_abs_func695 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXP_in_exp_func712 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_exp_func714 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_exp_func719 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_exp_func722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOG_in_log_func739 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_log_func741 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_log_func746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_log_func749 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOG10_in_log10_func766 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_log10_func768 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_log10_func773 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_log10_func776 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_POW_in_pow_func795 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_pow_func797 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_pow_func802 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_pow_func806 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_pow_func811 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_pow_func815 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SIN_in_sin_func832 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_sin_func834 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_sin_func839 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_sin_func842 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COS_in_cos_func859 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_cos_func861 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_cos_func866 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_cos_func869 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TAN_in_tan_func888 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_tan_func890 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_tan_func895 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_tan_func898 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COT_in_cot_func917 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_cot_func919 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_cot_func924 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_cot_func927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASIN_in_asin_func944 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_asin_func946 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_asin_func951 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_asin_func954 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACOS_in_acos_func971 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_acos_func973 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_acos_func978 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_acos_func981 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATAN_in_atan_func1000 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_atan_func1002 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_atan_func1007 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_atan_func1010 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACOT_in_acot_func1029 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_acot_func1031 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_acot_func1036 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_acot_func1039 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXCEEDANCE_in_exceedFunc1056 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_exceedFunc1058 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_exceedFunc1062 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1064 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000001806ADL});
	public static final BitSet FOLLOW_term_in_exceedFunc1068 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1070 = new BitSet(new long[]{0x0180000000000080L});
	public static final BitSet FOLLOW_MONTH_CONST_in_exceedFunc1075 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_MONTH_RANGE_in_exceedFunc1079 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_ALL_in_exceedFunc1083 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1086 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedFunc1090 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1092 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_exceedFunc1096 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1098 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedFunc1102 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1104 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedFunc1108 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1110 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_exceedFunc1114 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1116 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedFunc1120 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_exceedFunc1122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXCEEDANCE_TSI_in_exceedtsiFunc1144 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_exceedtsiFunc1146 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_exceedtsiFunc1150 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1152 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000001806ADL});
	public static final BitSet FOLLOW_term_in_exceedtsiFunc1156 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1158 = new BitSet(new long[]{0x0180000000000080L});
	public static final BitSet FOLLOW_MONTH_CONST_in_exceedtsiFunc1163 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_MONTH_RANGE_in_exceedtsiFunc1167 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_ALL_in_exceedtsiFunc1171 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1174 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedtsiFunc1178 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1180 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_exceedtsiFunc1184 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1186 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedtsiFunc1190 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1192 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedtsiFunc1196 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1198 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_exceedtsiFunc1202 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1204 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedtsiFunc1208 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_exceedtsiFunc1210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANGE_in_range_func1233 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_range_func1235 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_MONTH_in_range_func1237 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_range_func1239 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_range_func1243 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_range_func1245 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_range_func1249 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_range_func1251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_105_in_timeseriesWithUnits1263 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_timeseriesWithUnits1265 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_timeseriesWithUnits1267 = new BitSet(new long[]{0xFDFFEB7EFDFF5BF0L,0x00000000000BFE7FL});
	public static final BitSet FOLLOW_partC_in_timeseriesWithUnits1269 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_UNITS_in_timeseriesWithUnits1271 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_timeseriesWithUnits1273 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_timeseriesWithUnits1275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_105_in_timeseries1291 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_partC1308 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_IDENT1_in_partC1310 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_usedKeywords_in_partC1312 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_partC1316 = new BitSet(new long[]{0xFDFFEB7EFDFF5BF0L,0x00000000000BFE7FL});
	public static final BitSet FOLLOW_IDENT_in_partC1319 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_IDENT1_in_partC1321 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_usedKeywords_in_partC1323 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_SELECT_in_tableSQL1487 = new BitSet(new long[]{0xFDFFEB3EFDFF5BF0L,0x00000000000BFE7FL});
	public static final BitSet FOLLOW_IDENT_in_tableSQL1493 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_usedKeywords_in_tableSQL1500 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_FROM_in_tableSQL1505 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_tableSQL1509 = new BitSet(new long[]{0x0000001000000002L,0x0000000000028000L});
	public static final BitSet FOLLOW_GIVEN_in_tableSQL1517 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_assignStatement_in_tableSQL1521 = new BitSet(new long[]{0x0000000000000002L,0x0000000000028000L});
	public static final BitSet FOLLOW_USE_in_tableSQL1527 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_tableSQL1531 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
	public static final BitSet FOLLOW_where_items_in_tableSQL1541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_where_items1565 = new BitSet(new long[]{0xFDFFEB3EFDFF5BF0L,0x00000000000BFE7FL});
	public static final BitSet FOLLOW_whereStatement_in_where_items1571 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_where_items1585 = new BitSet(new long[]{0xFDFFEB3EFDFF5BF0L,0x00000000000BFE7FL});
	public static final BitSet FOLLOW_whereStatement_in_where_items1589 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
	public static final BitSet FOLLOW_IDENT_in_upperbound1602 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_allnumber_in_upperbound1604 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_allnumber_in_upperbound1607 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_86_in_upperbound1609 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_TAFCFS_in_upperbound1611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_lowerbound1619 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_allnumber_in_lowerbound1621 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_allnumber_in_lowerbound1624 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_86_in_lowerbound1626 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_TAFCFS_in_lowerbound1628 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SUM_in_sumExpression1658 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_sumExpression1660 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_sumExpression1662 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_sumExpression1665 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_sumExpression1669 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_sumExpression1671 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_sumExpression1675 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
	public static final BitSet FOLLOW_92_in_sumExpression1678 = new BitSet(new long[]{0x0000040000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_sumExpression1682 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_sumExpression1687 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_sumExpression1694 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_sumExpression1700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_term1718 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_term1727 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_term1737 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_term1742 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_term1745 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pastCycleValue_in_term1753 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_term1759 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_in_term1765 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_term1772 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tafcfs_term_in_term1781 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_YEAR_in_term1787 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONTH_in_term1793 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DAY_in_term1799 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONTH_CONST_in_term1805 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PASTMONTH_in_term1811 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DAYSIN_in_term1817 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DAYSINTIMESTEP_in_term1823 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SVAR_in_term1830 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_ITERATOR_in_term1838 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_term1844 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_sumExpression_in_term1846 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_term1848 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TAFCFS_in_tafcfs_term1863 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_tafcfs_term1866 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_tafcfs_term1868 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_tafcfs_term1870 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pastCycleNoTimeArray_in_pastCycleValue1893 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pastCycleTimeArray_in_pastCycleValue1900 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pastCycleIndexNoTimeArray_in_pastCycleValue1907 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pastCycleIndexTimeArray_in_pastCycleValue1914 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleNoTimeArray1935 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_pastCycleNoTimeArray1937 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleNoTimeArray1941 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_pastCycleNoTimeArray1943 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleTimeArray1966 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_pastCycleTimeArray1968 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleTimeArray1972 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_pastCycleTimeArray1974 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_pastCycleTimeArray1976 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_pastCycleTimeArray1980 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_pastCycleTimeArray1982 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleIndexNoTimeArray2006 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_pastCycleIndexNoTimeArray2008 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_pastCycleIndexNoTimeArray2010 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_pastCycleIndexNoTimeArray2014 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_pastCycleIndexNoTimeArray2016 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleIndexTimeArray2039 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_pastCycleIndexTimeArray2041 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_pastCycleIndexTimeArray2043 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_pastCycleIndexTimeArray2047 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_pastCycleIndexTimeArray2049 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_pastCycleIndexTimeArray2051 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_pastCycleIndexTimeArray2055 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_pastCycleIndexTimeArray2057 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_noArgFunction_in_function2080 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_argFunction_in_function2087 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_noArgFunction2106 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_noArgFunction2108 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_noArgFunction2110 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_argFunction2130 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_argFunction2132 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_argFunction2137 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
	public static final BitSet FOLLOW_trunk_timeArray_in_argFunction2148 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
	public static final BitSet FOLLOW_92_in_argFunction2158 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_argFunction2163 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
	public static final BitSet FOLLOW_trunk_timeArray_in_argFunction2173 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
	public static final BitSet FOLLOW_85_in_argFunction2179 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_argFunction2182 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_argFunction2186 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_argFunction2190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_trunk_timeArray2217 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_trunk_timeArray2219 = new BitSet(new long[]{0x0000042000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_integer_in_trunk_timeArray2224 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_IDENT_in_trunk_timeArray2229 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_91_in_trunk_timeArray2233 = new BitSet(new long[]{0x0000042000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_integer_in_trunk_timeArray2238 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_IDENT_in_trunk_timeArray2243 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_trunk_timeArray2247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_unary2275 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000001806ADL});
	public static final BitSet FOLLOW_term_in_unary2283 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_88_in_allnumber2296 = new BitSet(new long[]{0x0000040100000000L});
	public static final BitSet FOLLOW_number_in_allnumber2300 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unary_in_mult2318 = new BitSet(new long[]{0x0000000000000002L,0x0000000004400000L});
	public static final BitSet FOLLOW_set_in_mult2326 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_unary_in_mult2336 = new BitSet(new long[]{0x0000000000000002L,0x0000000004400000L});
	public static final BitSet FOLLOW_mult_in_add2360 = new BitSet(new long[]{0x0000000000000002L,0x0000000001800000L});
	public static final BitSet FOLLOW_set_in_add2369 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_mult_in_add2379 = new BitSet(new long[]{0x0000000000000002L,0x0000000001800000L});
	public static final BitSet FOLLOW_add_in_expression2402 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_whereStatement2457 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_usedKeywords_in_whereStatement2464 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_whereStatement2469 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_whereStatement2471 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_relationUnary_in_conditionStatement2493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALWAYS_in_conditionStatement2497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_relationUnary2518 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806AFL});
	public static final BitSet FOLLOW_relationOr_in_relationUnary2524 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_relationAnd_in_relationOr2547 = new BitSet(new long[]{0x1000000000000002L});
	public static final BitSet FOLLOW_OR_in_relationOr2559 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806AFL});
	public static final BitSet FOLLOW_relationAnd_in_relationOr2563 = new BitSet(new long[]{0x1000000000000002L});
	public static final BitSet FOLLOW_relationRangeStatement_in_relationAnd2585 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_AND_in_relationAnd2597 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806AFL});
	public static final BitSet FOLLOW_relationRangeStatement_in_relationAnd2601 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_relationStatement_in_relationRangeStatement2623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_range_func_in_relationRangeStatement2630 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_relationStatement2668 = new BitSet(new long[]{0x0000000000000000L,0x0000000760000000L});
	public static final BitSet FOLLOW_relation_in_relationStatement2671 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_relationStatement2676 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_relationStatement2699 = new BitSet(new long[]{0x88F9862139D81C70L,0x00000000019806AFL});
	public static final BitSet FOLLOW_relationUnary_in_relationStatement2702 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_relationStatement2703 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_constraintStatement2725 = new BitSet(new long[]{0x0000000000000000L,0x00000002A0000000L});
	public static final BitSet FOLLOW_95_in_constraintStatement2731 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_97_in_constraintStatement2737 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_93_in_constraintStatement2743 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_constraintStatement2749 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_assignStatement2769 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_assignStatement2771 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_assignStatement2773 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_p_in_integer2805 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_n_in_integer2807 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_integer_p2815 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_88_in_integer_n2823 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_integer_n2825 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_synpred1_Evaluator2655 = new BitSet(new long[]{0x0000000000000000L,0x0000000760000000L});
	public static final BitSet FOLLOW_relation_in_synpred1_Evaluator2657 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_synpred1_Evaluator2659 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_synpred2_Evaluator2690 = new BitSet(new long[]{0x88F9862139D81C70L,0x00000000019806AFL});
	public static final BitSet FOLLOW_relationUnary_in_synpred2_Evaluator2691 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_synpred2_Evaluator2692 = new BitSet(new long[]{0x0000000000000002L});
}
