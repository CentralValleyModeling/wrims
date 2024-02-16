// $ANTLR 3.5.2 ValueEvaluator.g 2024-02-12 13:08:54

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
public class ValueEvaluatorParser extends Parser {
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
		"'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'['", "']'", "'c:'", "'kind'", 
		"'timeseries'", "'v:'", "'|'"
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


	public ValueEvaluatorParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ValueEvaluatorParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ValueEvaluatorParser.tokenNames; }
	@Override public String getGrammarFileName() { return "ValueEvaluator.g"; }


	  public IntDouble evalValue;
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
	// ValueEvaluator.g:46:1: evaluator returns [String result] : ( expressionInput | conditionInput );
	public final String evaluator() throws RecognitionException {
		String result = null;


		try {
			// ValueEvaluator.g:47:2: ( expressionInput | conditionInput )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==104) ) {
				alt1=1;
			}
			else if ( (LA1_0==101) ) {
				alt1=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// ValueEvaluator.g:47:4: expressionInput
					{
					pushFollow(FOLLOW_expressionInput_in_evaluator50);
					expressionInput();
					state._fsp--;
					if (state.failed) return result;
					}
					break;
				case 2 :
					// ValueEvaluator.g:48:3: conditionInput
					{
					pushFollow(FOLLOW_conditionInput_in_evaluator56);
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



	// $ANTLR start "expressionInput"
	// ValueEvaluator.g:55:1: expressionInput : 'v:' expressionCollection ;
	public final void expressionInput() throws RecognitionException {
		IntDouble expressionCollection1 =null;

		try {
			// ValueEvaluator.g:55:16: ( 'v:' expressionCollection )
			// ValueEvaluator.g:55:18: 'v:' expressionCollection
			{
			match(input,104,FOLLOW_104_in_expressionInput70); if (state.failed) return;
			pushFollow(FOLLOW_expressionCollection_in_expressionInput72);
			expressionCollection1=expressionCollection();
			state._fsp--;
			if (state.failed) return;
			if ( state.backtracking==0 ) {evalValue=expressionCollection1;}
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



	// $ANTLR start "conditionInput"
	// ValueEvaluator.g:56:1: conditionInput : 'c:' conditionStatement ;
	public final void conditionInput() throws RecognitionException {
		boolean conditionStatement2 =false;

		try {
			// ValueEvaluator.g:56:15: ( 'c:' conditionStatement )
			// ValueEvaluator.g:56:17: 'c:' conditionStatement
			{
			match(input,101,FOLLOW_101_in_conditionInput79); if (state.failed) return;
			pushFollow(FOLLOW_conditionStatement_in_conditionInput81);
			conditionStatement2=conditionStatement();
			state._fsp--;
			if (state.failed) return;
			if ( state.backtracking==0 ) {evalCondition=conditionStatement2;}
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
	// ValueEvaluator.g:61:1: lhsrhs : ( expression | CONSTRAIN );
	public final void lhsrhs() throws RecognitionException {
		try {
			// ValueEvaluator.g:61:7: ( expression | CONSTRAIN )
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
					// ValueEvaluator.g:61:9: expression
					{
					pushFollow(FOLLOW_expression_in_lhsrhs93);
					expression();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// ValueEvaluator.g:61:20: CONSTRAIN
					{
					match(input,CONSTRAIN,FOLLOW_CONSTRAIN_in_lhsrhs95); if (state.failed) return;
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
	// ValueEvaluator.g:65:1: units : ( IDENT | ( IDENT '/' IDENT ) );
	public final void units() throws RecognitionException {
		try {
			// ValueEvaluator.g:65:6: ( IDENT | ( IDENT '/' IDENT ) )
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
					// ValueEvaluator.g:65:8: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_units104); if (state.failed) return;
					}
					break;
				case 2 :
					// ValueEvaluator.g:65:14: ( IDENT '/' IDENT )
					{
					// ValueEvaluator.g:65:14: ( IDENT '/' IDENT )
					// ValueEvaluator.g:65:15: IDENT '/' IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_units107); if (state.failed) return;
					match(input,90,FOLLOW_90_in_units109); if (state.failed) return;
					match(input,IDENT,FOLLOW_IDENT_in_units111); if (state.failed) return;
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
	// ValueEvaluator.g:67:1: fileName : ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+ ;
	public final void fileName() throws RecognitionException {
		try {
			// ValueEvaluator.g:68:3: ( ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+ )
			// ValueEvaluator.g:68:5: ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+
			{
			// ValueEvaluator.g:68:5: ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+
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
				case 105:
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
					// ValueEvaluator.g:68:6: ':'
					{
					match(input,91,FOLLOW_91_in_fileName123); if (state.failed) return;
					}
					break;
				case 2 :
					// ValueEvaluator.g:68:10: ';'
					{
					match(input,92,FOLLOW_92_in_fileName125); if (state.failed) return;
					}
					break;
				case 3 :
					// ValueEvaluator.g:68:14: '.'
					{
					match(input,89,FOLLOW_89_in_fileName127); if (state.failed) return;
					}
					break;
				case 4 :
					// ValueEvaluator.g:68:18: '|'
					{
					match(input,105,FOLLOW_105_in_fileName129); if (state.failed) return;
					}
					break;
				case 5 :
					// ValueEvaluator.g:68:22: SYMBOLS
					{
					match(input,SYMBOLS,FOLLOW_SYMBOLS_in_fileName131); if (state.failed) return;
					}
					break;
				case 6 :
					// ValueEvaluator.g:68:30: '-'
					{
					match(input,88,FOLLOW_88_in_fileName133); if (state.failed) return;
					}
					break;
				case 7 :
					// ValueEvaluator.g:68:34: '+'
					{
					match(input,87,FOLLOW_87_in_fileName135); if (state.failed) return;
					}
					break;
				case 8 :
					// ValueEvaluator.g:68:38: BACKSLASH
					{
					match(input,BACKSLASH,FOLLOW_BACKSLASH_in_fileName137); if (state.failed) return;
					}
					break;
				case 9 :
					// ValueEvaluator.g:68:48: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_fileName139); if (state.failed) return;
					}
					break;
				case 10 :
					// ValueEvaluator.g:68:54: IDENT1
					{
					match(input,IDENT1,FOLLOW_IDENT1_in_fileName141); if (state.failed) return;
					}
					break;
				case 11 :
					// ValueEvaluator.g:68:61: IDENT2
					{
					match(input,IDENT2,FOLLOW_IDENT2_in_fileName143); if (state.failed) return;
					}
					break;
				case 12 :
					// ValueEvaluator.g:68:68: INTEGER
					{
					match(input,INTEGER,FOLLOW_INTEGER_in_fileName145); if (state.failed) return;
					}
					break;
				case 13 :
					// ValueEvaluator.g:68:76: FLOAT
					{
					match(input,FLOAT,FOLLOW_FLOAT_in_fileName147); if (state.failed) return;
					}
					break;
				case 14 :
					// ValueEvaluator.g:68:82: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_fileName149);
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
	// ValueEvaluator.g:72:1: externalFile : ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+ ;
	public final void externalFile() throws RecognitionException {
		try {
			// ValueEvaluator.g:73:3: ( ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+ )
			// ValueEvaluator.g:73:5: ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+
			{
			// ValueEvaluator.g:73:5: ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+
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
				case 105:
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
					// ValueEvaluator.g:73:6: ';'
					{
					match(input,92,FOLLOW_92_in_externalFile168); if (state.failed) return;
					}
					break;
				case 2 :
					// ValueEvaluator.g:73:10: '.'
					{
					match(input,89,FOLLOW_89_in_externalFile170); if (state.failed) return;
					}
					break;
				case 3 :
					// ValueEvaluator.g:73:14: '|'
					{
					match(input,105,FOLLOW_105_in_externalFile172); if (state.failed) return;
					}
					break;
				case 4 :
					// ValueEvaluator.g:73:18: SYMBOLS
					{
					match(input,SYMBOLS,FOLLOW_SYMBOLS_in_externalFile174); if (state.failed) return;
					}
					break;
				case 5 :
					// ValueEvaluator.g:73:26: '-'
					{
					match(input,88,FOLLOW_88_in_externalFile176); if (state.failed) return;
					}
					break;
				case 6 :
					// ValueEvaluator.g:73:30: '+'
					{
					match(input,87,FOLLOW_87_in_externalFile178); if (state.failed) return;
					}
					break;
				case 7 :
					// ValueEvaluator.g:73:34: INTEGER
					{
					match(input,INTEGER,FOLLOW_INTEGER_in_externalFile180); if (state.failed) return;
					}
					break;
				case 8 :
					// ValueEvaluator.g:73:42: FLOAT
					{
					match(input,FLOAT,FOLLOW_FLOAT_in_externalFile182); if (state.failed) return;
					}
					break;
				case 9 :
					// ValueEvaluator.g:73:48: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_externalFile184); if (state.failed) return;
					}
					break;
				case 10 :
					// ValueEvaluator.g:73:54: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_externalFile186);
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
	// ValueEvaluator.g:76:1: text : LETTER ( LETTER | DIGIT )* ;
	public final void text() throws RecognitionException {
		try {
			// ValueEvaluator.g:76:6: ( LETTER ( LETTER | DIGIT )* )
			// ValueEvaluator.g:76:8: LETTER ( LETTER | DIGIT )*
			{
			match(input,LETTER,FOLLOW_LETTER_in_text200); if (state.failed) return;
			// ValueEvaluator.g:76:15: ( LETTER | DIGIT )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==DIGIT||LA6_0==LETTER) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// ValueEvaluator.g:
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
	// ValueEvaluator.g:78:1: expressionCollection returns [IntDouble id] : ( ( expression ) | ( tableSQL ) | ( timeseriesWithUnits ) | ( ( timeseries ) ) | sumExpression | ( UPPERUNBOUNDED ) | ( LOWERUNBOUNDED ) );
	public final IntDouble expressionCollection() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope expression3 =null;
		IntDouble tableSQL4 =null;
		IntDouble timeseries5 =null;
		IntDouble sumExpression6 =null;

		try {
			// ValueEvaluator.g:79:2: ( ( expression ) | ( tableSQL ) | ( timeseriesWithUnits ) | ( ( timeseries ) ) | sumExpression | ( UPPERUNBOUNDED ) | ( LOWERUNBOUNDED ) )
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
			case 103:
				{
				int LA7_3 = input.LA(2);
				if ( (LA7_3==102) ) {
					alt7=3;
				}
				else if ( (LA7_3==EOF) ) {
					alt7=4;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return id;}
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
				if (state.backtracking>0) {state.failed=true; return id;}
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// ValueEvaluator.g:79:3: ( expression )
					{
					// ValueEvaluator.g:79:3: ( expression )
					// ValueEvaluator.g:79:4: expression
					{
					pushFollow(FOLLOW_expression_in_expressionCollection224);
					expression3=expression();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=(expression3!=null?((ValueEvaluatorParser.expression_return)expression3).id:null);}
					}

					}
					break;
				case 2 :
					// ValueEvaluator.g:80:3: ( tableSQL )
					{
					// ValueEvaluator.g:80:3: ( tableSQL )
					// ValueEvaluator.g:80:4: tableSQL
					{
					pushFollow(FOLLOW_tableSQL_in_expressionCollection231);
					tableSQL4=tableSQL();
					state._fsp--;
					if (state.failed) return id;
					}

					if ( state.backtracking==0 ) {id=tableSQL4;}
					}
					break;
				case 3 :
					// ValueEvaluator.g:81:3: ( timeseriesWithUnits )
					{
					// ValueEvaluator.g:81:3: ( timeseriesWithUnits )
					// ValueEvaluator.g:81:4: timeseriesWithUnits
					{
					pushFollow(FOLLOW_timeseriesWithUnits_in_expressionCollection238);
					timeseriesWithUnits();
					state._fsp--;
					if (state.failed) return id;
					}

					}
					break;
				case 4 :
					// ValueEvaluator.g:82:3: ( ( timeseries ) )
					{
					// ValueEvaluator.g:82:3: ( ( timeseries ) )
					// ValueEvaluator.g:82:4: ( timeseries )
					{
					// ValueEvaluator.g:82:4: ( timeseries )
					// ValueEvaluator.g:82:5: timeseries
					{
					pushFollow(FOLLOW_timeseries_in_expressionCollection245);
					timeseries5=timeseries();
					state._fsp--;
					if (state.failed) return id;
					}

					if ( state.backtracking==0 ) {id=timeseries5;}
					}

					}
					break;
				case 5 :
					// ValueEvaluator.g:83:4: sumExpression
					{
					pushFollow(FOLLOW_sumExpression_in_expressionCollection253);
					sumExpression6=sumExpression();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=sumExpression6;}
					}
					break;
				case 6 :
					// ValueEvaluator.g:84:3: ( UPPERUNBOUNDED )
					{
					// ValueEvaluator.g:84:3: ( UPPERUNBOUNDED )
					// ValueEvaluator.g:84:4: UPPERUNBOUNDED
					{
					match(input,UPPERUNBOUNDED,FOLLOW_UPPERUNBOUNDED_in_expressionCollection260); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=new IntDouble(1e38,true);}
					}

					}
					break;
				case 7 :
					// ValueEvaluator.g:85:3: ( LOWERUNBOUNDED )
					{
					// ValueEvaluator.g:85:3: ( LOWERUNBOUNDED )
					// ValueEvaluator.g:85:4: LOWERUNBOUNDED
					{
					match(input,LOWERUNBOUNDED,FOLLOW_LOWERUNBOUNDED_in_expressionCollection267); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=new IntDouble(-1e38,true);}
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
		return id;
	}
	// $ANTLR end "expressionCollection"



	// $ANTLR start "func"
	// ValueEvaluator.g:88:1: func returns [IntDouble id] : ( ( max_func ) | ( min_func ) | ( int_func ) | ( real_func ) | ( abs_func ) | ( exp_func ) | ( log_func ) | ( log10_func ) | ( pow_func ) | ( mod_func ) | ( round_func ) | ( sin_func ) | ( cos_func ) | ( tan_func ) | ( cot_func ) | ( asin_func ) | ( acos_func ) | ( atan_func ) | ( acot_func ) | ( exceedFunc ) | ( exceedtsiFunc ) );
	public final IntDouble func() throws RecognitionException {
		IntDouble id = null;


		IntDouble max_func7 =null;
		IntDouble min_func8 =null;
		IntDouble int_func9 =null;
		IntDouble real_func10 =null;
		IntDouble abs_func11 =null;
		IntDouble exp_func12 =null;
		IntDouble log_func13 =null;
		IntDouble log10_func14 =null;
		IntDouble pow_func15 =null;
		IntDouble mod_func16 =null;
		IntDouble round_func17 =null;
		IntDouble sin_func18 =null;
		IntDouble cos_func19 =null;
		IntDouble tan_func20 =null;
		IntDouble cot_func21 =null;
		IntDouble asin_func22 =null;
		IntDouble acos_func23 =null;
		IntDouble atan_func24 =null;
		IntDouble acot_func25 =null;
		IntDouble exceedFunc26 =null;
		IntDouble exceedtsiFunc27 =null;

		try {
			// ValueEvaluator.g:88:27: ( ( max_func ) | ( min_func ) | ( int_func ) | ( real_func ) | ( abs_func ) | ( exp_func ) | ( log_func ) | ( log10_func ) | ( pow_func ) | ( mod_func ) | ( round_func ) | ( sin_func ) | ( cos_func ) | ( tan_func ) | ( cot_func ) | ( asin_func ) | ( acos_func ) | ( atan_func ) | ( acot_func ) | ( exceedFunc ) | ( exceedtsiFunc ) )
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
				if (state.backtracking>0) {state.failed=true; return id;}
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}
			switch (alt8) {
				case 1 :
					// ValueEvaluator.g:89:3: ( max_func )
					{
					// ValueEvaluator.g:89:3: ( max_func )
					// ValueEvaluator.g:89:4: max_func
					{
					pushFollow(FOLLOW_max_func_in_func285);
					max_func7=max_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=max_func7;}
					}

					}
					break;
				case 2 :
					// ValueEvaluator.g:90:3: ( min_func )
					{
					// ValueEvaluator.g:90:3: ( min_func )
					// ValueEvaluator.g:90:4: min_func
					{
					pushFollow(FOLLOW_min_func_in_func293);
					min_func8=min_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=min_func8;}
					}

					}
					break;
				case 3 :
					// ValueEvaluator.g:91:3: ( int_func )
					{
					// ValueEvaluator.g:91:3: ( int_func )
					// ValueEvaluator.g:91:4: int_func
					{
					pushFollow(FOLLOW_int_func_in_func301);
					int_func9=int_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=int_func9;}
					}

					}
					break;
				case 4 :
					// ValueEvaluator.g:92:3: ( real_func )
					{
					// ValueEvaluator.g:92:3: ( real_func )
					// ValueEvaluator.g:92:4: real_func
					{
					pushFollow(FOLLOW_real_func_in_func309);
					real_func10=real_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=real_func10;}
					}

					}
					break;
				case 5 :
					// ValueEvaluator.g:93:3: ( abs_func )
					{
					// ValueEvaluator.g:93:3: ( abs_func )
					// ValueEvaluator.g:93:4: abs_func
					{
					pushFollow(FOLLOW_abs_func_in_func317);
					abs_func11=abs_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=abs_func11;}
					}

					}
					break;
				case 6 :
					// ValueEvaluator.g:94:3: ( exp_func )
					{
					// ValueEvaluator.g:94:3: ( exp_func )
					// ValueEvaluator.g:94:4: exp_func
					{
					pushFollow(FOLLOW_exp_func_in_func325);
					exp_func12=exp_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=exp_func12;}
					}

					}
					break;
				case 7 :
					// ValueEvaluator.g:95:3: ( log_func )
					{
					// ValueEvaluator.g:95:3: ( log_func )
					// ValueEvaluator.g:95:4: log_func
					{
					pushFollow(FOLLOW_log_func_in_func333);
					log_func13=log_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=log_func13;}
					}

					}
					break;
				case 8 :
					// ValueEvaluator.g:96:3: ( log10_func )
					{
					// ValueEvaluator.g:96:3: ( log10_func )
					// ValueEvaluator.g:96:4: log10_func
					{
					pushFollow(FOLLOW_log10_func_in_func341);
					log10_func14=log10_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=log10_func14;}
					}

					}
					break;
				case 9 :
					// ValueEvaluator.g:97:3: ( pow_func )
					{
					// ValueEvaluator.g:97:3: ( pow_func )
					// ValueEvaluator.g:97:4: pow_func
					{
					pushFollow(FOLLOW_pow_func_in_func349);
					pow_func15=pow_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=pow_func15;}
					}

					}
					break;
				case 10 :
					// ValueEvaluator.g:98:3: ( mod_func )
					{
					// ValueEvaluator.g:98:3: ( mod_func )
					// ValueEvaluator.g:98:4: mod_func
					{
					pushFollow(FOLLOW_mod_func_in_func357);
					mod_func16=mod_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=mod_func16;}
					}

					}
					break;
				case 11 :
					// ValueEvaluator.g:99:3: ( round_func )
					{
					// ValueEvaluator.g:99:3: ( round_func )
					// ValueEvaluator.g:99:4: round_func
					{
					pushFollow(FOLLOW_round_func_in_func365);
					round_func17=round_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=round_func17;}
					}

					}
					break;
				case 12 :
					// ValueEvaluator.g:100:3: ( sin_func )
					{
					// ValueEvaluator.g:100:3: ( sin_func )
					// ValueEvaluator.g:100:4: sin_func
					{
					pushFollow(FOLLOW_sin_func_in_func373);
					sin_func18=sin_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=sin_func18;}
					}

					}
					break;
				case 13 :
					// ValueEvaluator.g:101:3: ( cos_func )
					{
					// ValueEvaluator.g:101:3: ( cos_func )
					// ValueEvaluator.g:101:4: cos_func
					{
					pushFollow(FOLLOW_cos_func_in_func381);
					cos_func19=cos_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=cos_func19;}
					}

					}
					break;
				case 14 :
					// ValueEvaluator.g:102:3: ( tan_func )
					{
					// ValueEvaluator.g:102:3: ( tan_func )
					// ValueEvaluator.g:102:4: tan_func
					{
					pushFollow(FOLLOW_tan_func_in_func389);
					tan_func20=tan_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=tan_func20;}
					}

					}
					break;
				case 15 :
					// ValueEvaluator.g:103:3: ( cot_func )
					{
					// ValueEvaluator.g:103:3: ( cot_func )
					// ValueEvaluator.g:103:4: cot_func
					{
					pushFollow(FOLLOW_cot_func_in_func397);
					cot_func21=cot_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=cot_func21;}
					}

					}
					break;
				case 16 :
					// ValueEvaluator.g:104:3: ( asin_func )
					{
					// ValueEvaluator.g:104:3: ( asin_func )
					// ValueEvaluator.g:104:4: asin_func
					{
					pushFollow(FOLLOW_asin_func_in_func405);
					asin_func22=asin_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=asin_func22;}
					}

					}
					break;
				case 17 :
					// ValueEvaluator.g:105:3: ( acos_func )
					{
					// ValueEvaluator.g:105:3: ( acos_func )
					// ValueEvaluator.g:105:4: acos_func
					{
					pushFollow(FOLLOW_acos_func_in_func413);
					acos_func23=acos_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=acos_func23;}
					}

					}
					break;
				case 18 :
					// ValueEvaluator.g:106:3: ( atan_func )
					{
					// ValueEvaluator.g:106:3: ( atan_func )
					// ValueEvaluator.g:106:4: atan_func
					{
					pushFollow(FOLLOW_atan_func_in_func421);
					atan_func24=atan_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=atan_func24;}
					}

					}
					break;
				case 19 :
					// ValueEvaluator.g:107:3: ( acot_func )
					{
					// ValueEvaluator.g:107:3: ( acot_func )
					// ValueEvaluator.g:107:4: acot_func
					{
					pushFollow(FOLLOW_acot_func_in_func429);
					acot_func25=acot_func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=acot_func25;}
					}

					}
					break;
				case 20 :
					// ValueEvaluator.g:108:3: ( exceedFunc )
					{
					// ValueEvaluator.g:108:3: ( exceedFunc )
					// ValueEvaluator.g:108:4: exceedFunc
					{
					pushFollow(FOLLOW_exceedFunc_in_func437);
					exceedFunc26=exceedFunc();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=exceedFunc26;}
					}

					}
					break;
				case 21 :
					// ValueEvaluator.g:109:3: ( exceedtsiFunc )
					{
					// ValueEvaluator.g:109:3: ( exceedtsiFunc )
					// ValueEvaluator.g:109:4: exceedtsiFunc
					{
					pushFollow(FOLLOW_exceedtsiFunc_in_func445);
					exceedtsiFunc27=exceedtsiFunc();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=exceedtsiFunc27;}
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
		return id;
	}
	// $ANTLR end "func"



	// $ANTLR start "round_func"
	// ValueEvaluator.g:111:1: round_func returns [IntDouble id] : ROUND '(' (e1= expression ) ')' ;
	public final IntDouble round_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e1 =null;

		try {
			// ValueEvaluator.g:112:3: ( ROUND '(' (e1= expression ) ')' )
			// ValueEvaluator.g:112:5: ROUND '(' (e1= expression ) ')'
			{
			match(input,ROUND,FOLLOW_ROUND_in_round_func460); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_round_func462); if (state.failed) return id;
			// ValueEvaluator.g:112:15: (e1= expression )
			// ValueEvaluator.g:112:16: e1= expression
			{
			pushFollow(FOLLOW_expression_in_round_func467);
			e1=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_round_func470); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			     id=ValueEvaluation.round((e1!=null?((ValueEvaluatorParser.expression_return)e1).id:null));
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
		return id;
	}
	// $ANTLR end "round_func"



	// $ANTLR start "mod_func"
	// ValueEvaluator.g:117:1: mod_func returns [IntDouble id] : MOD '(' (e1= expression ) ( ';' (e2= expression ) ) ')' ;
	public final IntDouble mod_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		try {
			// ValueEvaluator.g:118:3: ( MOD '(' (e1= expression ) ( ';' (e2= expression ) ) ')' )
			// ValueEvaluator.g:118:5: MOD '(' (e1= expression ) ( ';' (e2= expression ) ) ')'
			{
			match(input,MOD,FOLLOW_MOD_in_mod_func487); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_mod_func489); if (state.failed) return id;
			// ValueEvaluator.g:118:13: (e1= expression )
			// ValueEvaluator.g:118:14: e1= expression
			{
			pushFollow(FOLLOW_expression_in_mod_func494);
			e1=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			// ValueEvaluator.g:118:29: ( ';' (e2= expression ) )
			// ValueEvaluator.g:118:30: ';' (e2= expression )
			{
			match(input,92,FOLLOW_92_in_mod_func498); if (state.failed) return id;
			// ValueEvaluator.g:118:34: (e2= expression )
			// ValueEvaluator.g:118:35: e2= expression
			{
			pushFollow(FOLLOW_expression_in_mod_func503);
			e2=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			}

			match(input,85,FOLLOW_85_in_mod_func507); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			     id=ValueEvaluation.mod((e1!=null?((ValueEvaluatorParser.expression_return)e1).id:null), (e2!=null?((ValueEvaluatorParser.expression_return)e2).id:null));
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
		return id;
	}
	// $ANTLR end "mod_func"



	// $ANTLR start "max_func"
	// ValueEvaluator.g:123:1: max_func returns [IntDouble id] : MAX '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' ;
	public final IntDouble max_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		try {
			// ValueEvaluator.g:124:2: ( MAX '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' )
			// ValueEvaluator.g:124:4: MAX '(' (e1= expression ) ( ';' (e2= expression ) )+ ')'
			{
			match(input,MAX,FOLLOW_MAX_in_max_func524); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_max_func526); if (state.failed) return id;
			// ValueEvaluator.g:124:12: (e1= expression )
			// ValueEvaluator.g:124:13: e1= expression
			{
			pushFollow(FOLLOW_expression_in_max_func531);
			e1=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			if ( state.backtracking==0 ) {id=(e1!=null?((ValueEvaluatorParser.expression_return)e1).id:null);}
			// ValueEvaluator.g:124:39: ( ';' (e2= expression ) )+
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
					// ValueEvaluator.g:124:40: ';' (e2= expression )
					{
					match(input,92,FOLLOW_92_in_max_func535); if (state.failed) return id;
					// ValueEvaluator.g:124:44: (e2= expression )
					// ValueEvaluator.g:124:45: e2= expression
					{
					pushFollow(FOLLOW_expression_in_max_func540);
					e2=expression();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {
					     id=ValueEvaluation.max(id, (e2!=null?((ValueEvaluatorParser.expression_return)e2).id:null));
					  }
					}

					}
					break;

				default :
					if ( cnt9 >= 1 ) break loop9;
					if (state.backtracking>0) {state.failed=true; return id;}
					EarlyExitException eee = new EarlyExitException(9, input);
					throw eee;
				}
				cnt9++;
			}

			match(input,85,FOLLOW_85_in_max_func546); if (state.failed) return id;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return id;
	}
	// $ANTLR end "max_func"



	// $ANTLR start "min_func"
	// ValueEvaluator.g:129:1: min_func returns [IntDouble id] : MIN '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' ;
	public final IntDouble min_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		try {
			// ValueEvaluator.g:130:2: ( MIN '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' )
			// ValueEvaluator.g:130:4: MIN '(' (e1= expression ) ( ';' (e2= expression ) )+ ')'
			{
			match(input,MIN,FOLLOW_MIN_in_min_func560); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_min_func562); if (state.failed) return id;
			// ValueEvaluator.g:130:12: (e1= expression )
			// ValueEvaluator.g:130:13: e1= expression
			{
			pushFollow(FOLLOW_expression_in_min_func567);
			e1=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			if ( state.backtracking==0 ) {id=(e1!=null?((ValueEvaluatorParser.expression_return)e1).id:null);}
			// ValueEvaluator.g:130:39: ( ';' (e2= expression ) )+
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
					// ValueEvaluator.g:130:40: ';' (e2= expression )
					{
					match(input,92,FOLLOW_92_in_min_func571); if (state.failed) return id;
					// ValueEvaluator.g:130:44: (e2= expression )
					// ValueEvaluator.g:130:45: e2= expression
					{
					pushFollow(FOLLOW_expression_in_min_func576);
					e2=expression();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {
					     id=ValueEvaluation.min(id, (e2!=null?((ValueEvaluatorParser.expression_return)e2).id:null));
					  }
					}

					}
					break;

				default :
					if ( cnt10 >= 1 ) break loop10;
					if (state.backtracking>0) {state.failed=true; return id;}
					EarlyExitException eee = new EarlyExitException(10, input);
					throw eee;
				}
				cnt10++;
			}

			match(input,85,FOLLOW_85_in_min_func582); if (state.failed) return id;
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return id;
	}
	// $ANTLR end "min_func"



	// $ANTLR start "int_func"
	// ValueEvaluator.g:135:1: int_func returns [IntDouble id] : INT '(' (e= expression ) ')' ;
	public final IntDouble int_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e =null;

		try {
			// ValueEvaluator.g:136:3: ( INT '(' (e= expression ) ')' )
			// ValueEvaluator.g:136:5: INT '(' (e= expression ) ')'
			{
			match(input,INT,FOLLOW_INT_in_int_func598); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_int_func600); if (state.failed) return id;
			// ValueEvaluator.g:136:13: (e= expression )
			// ValueEvaluator.g:136:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_int_func605);
			e=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_int_func608); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			     id=ValueEvaluation.intFunc((e!=null?((ValueEvaluatorParser.expression_return)e).id:null));
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
		return id;
	}
	// $ANTLR end "int_func"



	// $ANTLR start "real_func"
	// ValueEvaluator.g:141:1: real_func returns [IntDouble id] : REAL '(' (e= expression ) ')' ;
	public final IntDouble real_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e =null;

		try {
			// ValueEvaluator.g:142:3: ( REAL '(' (e= expression ) ')' )
			// ValueEvaluator.g:142:5: REAL '(' (e= expression ) ')'
			{
			match(input,REAL,FOLLOW_REAL_in_real_func627); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_real_func629); if (state.failed) return id;
			// ValueEvaluator.g:142:14: (e= expression )
			// ValueEvaluator.g:142:15: e= expression
			{
			pushFollow(FOLLOW_expression_in_real_func634);
			e=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_real_func637); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			    id=ValueEvaluation.realFunc((e!=null?((ValueEvaluatorParser.expression_return)e).id:null));
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
		return id;
	}
	// $ANTLR end "real_func"



	// $ANTLR start "abs_func"
	// ValueEvaluator.g:147:1: abs_func returns [IntDouble id] : ABS '(' (e= expression ) ')' ;
	public final IntDouble abs_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e =null;

		try {
			// ValueEvaluator.g:148:3: ( ABS '(' (e= expression ) ')' )
			// ValueEvaluator.g:148:5: ABS '(' (e= expression ) ')'
			{
			match(input,ABS,FOLLOW_ABS_in_abs_func656); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_abs_func658); if (state.failed) return id;
			// ValueEvaluator.g:148:13: (e= expression )
			// ValueEvaluator.g:148:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_abs_func663);
			e=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_abs_func666); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			     id=ValueEvaluation.abs((e!=null?((ValueEvaluatorParser.expression_return)e).id:null));
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
		return id;
	}
	// $ANTLR end "abs_func"



	// $ANTLR start "exp_func"
	// ValueEvaluator.g:153:1: exp_func returns [IntDouble id] : EXP '(' (e= expression ) ')' ;
	public final IntDouble exp_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e =null;

		try {
			// ValueEvaluator.g:154:3: ( EXP '(' (e= expression ) ')' )
			// ValueEvaluator.g:154:5: EXP '(' (e= expression ) ')'
			{
			match(input,EXP,FOLLOW_EXP_in_exp_func683); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_exp_func685); if (state.failed) return id;
			// ValueEvaluator.g:154:13: (e= expression )
			// ValueEvaluator.g:154:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_exp_func690);
			e=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_exp_func693); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			     id=ValueEvaluation.exp((e!=null?((ValueEvaluatorParser.expression_return)e).id:null));
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
		return id;
	}
	// $ANTLR end "exp_func"



	// $ANTLR start "log_func"
	// ValueEvaluator.g:159:1: log_func returns [IntDouble id] : LOG '(' (e= expression ) ')' ;
	public final IntDouble log_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e =null;

		try {
			// ValueEvaluator.g:160:3: ( LOG '(' (e= expression ) ')' )
			// ValueEvaluator.g:160:5: LOG '(' (e= expression ) ')'
			{
			match(input,LOG,FOLLOW_LOG_in_log_func712); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_log_func714); if (state.failed) return id;
			// ValueEvaluator.g:160:13: (e= expression )
			// ValueEvaluator.g:160:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_log_func719);
			e=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_log_func722); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			     id=ValueEvaluation.log((e!=null?((ValueEvaluatorParser.expression_return)e).id:null));
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
		return id;
	}
	// $ANTLR end "log_func"



	// $ANTLR start "log10_func"
	// ValueEvaluator.g:165:1: log10_func returns [IntDouble id] : LOG10 '(' (e= expression ) ')' ;
	public final IntDouble log10_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e =null;

		try {
			// ValueEvaluator.g:166:3: ( LOG10 '(' (e= expression ) ')' )
			// ValueEvaluator.g:166:5: LOG10 '(' (e= expression ) ')'
			{
			match(input,LOG10,FOLLOW_LOG10_in_log10_func739); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_log10_func741); if (state.failed) return id;
			// ValueEvaluator.g:166:15: (e= expression )
			// ValueEvaluator.g:166:16: e= expression
			{
			pushFollow(FOLLOW_expression_in_log10_func746);
			e=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_log10_func749); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			    id=ValueEvaluation.log10((e!=null?((ValueEvaluatorParser.expression_return)e).id:null));
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
		return id;
	}
	// $ANTLR end "log10_func"



	// $ANTLR start "pow_func"
	// ValueEvaluator.g:171:1: pow_func returns [IntDouble id] : POW '(' (e1= expression ) ( ';' (e2= expression ) ) ')' ;
	public final IntDouble pow_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		try {
			// ValueEvaluator.g:172:3: ( POW '(' (e1= expression ) ( ';' (e2= expression ) ) ')' )
			// ValueEvaluator.g:172:5: POW '(' (e1= expression ) ( ';' (e2= expression ) ) ')'
			{
			match(input,POW,FOLLOW_POW_in_pow_func768); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_pow_func770); if (state.failed) return id;
			// ValueEvaluator.g:172:13: (e1= expression )
			// ValueEvaluator.g:172:14: e1= expression
			{
			pushFollow(FOLLOW_expression_in_pow_func775);
			e1=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			// ValueEvaluator.g:172:29: ( ';' (e2= expression ) )
			// ValueEvaluator.g:172:30: ';' (e2= expression )
			{
			match(input,92,FOLLOW_92_in_pow_func779); if (state.failed) return id;
			// ValueEvaluator.g:172:34: (e2= expression )
			// ValueEvaluator.g:172:35: e2= expression
			{
			pushFollow(FOLLOW_expression_in_pow_func784);
			e2=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			}

			match(input,85,FOLLOW_85_in_pow_func788); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			     id=ValueEvaluation.pow((e1!=null?((ValueEvaluatorParser.expression_return)e1).id:null), (e2!=null?((ValueEvaluatorParser.expression_return)e2).id:null));
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
		return id;
	}
	// $ANTLR end "pow_func"



	// $ANTLR start "sin_func"
	// ValueEvaluator.g:177:1: sin_func returns [IntDouble id] : SIN '(' (e= expression ) ')' ;
	public final IntDouble sin_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e =null;

		try {
			// ValueEvaluator.g:178:3: ( SIN '(' (e= expression ) ')' )
			// ValueEvaluator.g:178:5: SIN '(' (e= expression ) ')'
			{
			match(input,SIN,FOLLOW_SIN_in_sin_func805); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_sin_func807); if (state.failed) return id;
			// ValueEvaluator.g:178:13: (e= expression )
			// ValueEvaluator.g:178:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_sin_func812);
			e=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_sin_func815); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			    id=ValueEvaluation.sin((e!=null?((ValueEvaluatorParser.expression_return)e).id:null));
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
		return id;
	}
	// $ANTLR end "sin_func"



	// $ANTLR start "cos_func"
	// ValueEvaluator.g:183:1: cos_func returns [IntDouble id] : COS '(' (e= expression ) ')' ;
	public final IntDouble cos_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e =null;

		try {
			// ValueEvaluator.g:184:3: ( COS '(' (e= expression ) ')' )
			// ValueEvaluator.g:184:5: COS '(' (e= expression ) ')'
			{
			match(input,COS,FOLLOW_COS_in_cos_func832); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_cos_func834); if (state.failed) return id;
			// ValueEvaluator.g:184:13: (e= expression )
			// ValueEvaluator.g:184:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_cos_func839);
			e=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_cos_func842); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			    id=ValueEvaluation.cos((e!=null?((ValueEvaluatorParser.expression_return)e).id:null));
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
		return id;
	}
	// $ANTLR end "cos_func"



	// $ANTLR start "tan_func"
	// ValueEvaluator.g:189:1: tan_func returns [IntDouble id] : TAN '(' (e= expression ) ')' ;
	public final IntDouble tan_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e =null;

		try {
			// ValueEvaluator.g:190:3: ( TAN '(' (e= expression ) ')' )
			// ValueEvaluator.g:190:5: TAN '(' (e= expression ) ')'
			{
			match(input,TAN,FOLLOW_TAN_in_tan_func861); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_tan_func863); if (state.failed) return id;
			// ValueEvaluator.g:190:13: (e= expression )
			// ValueEvaluator.g:190:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_tan_func868);
			e=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_tan_func871); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			    id=ValueEvaluation.tan((e!=null?((ValueEvaluatorParser.expression_return)e).id:null));
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
		return id;
	}
	// $ANTLR end "tan_func"



	// $ANTLR start "cot_func"
	// ValueEvaluator.g:195:1: cot_func returns [IntDouble id] : COT '(' (e= expression ) ')' ;
	public final IntDouble cot_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e =null;

		try {
			// ValueEvaluator.g:196:3: ( COT '(' (e= expression ) ')' )
			// ValueEvaluator.g:196:5: COT '(' (e= expression ) ')'
			{
			match(input,COT,FOLLOW_COT_in_cot_func890); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_cot_func892); if (state.failed) return id;
			// ValueEvaluator.g:196:13: (e= expression )
			// ValueEvaluator.g:196:14: e= expression
			{
			pushFollow(FOLLOW_expression_in_cot_func897);
			e=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_cot_func900); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			    id=ValueEvaluation.cot((e!=null?((ValueEvaluatorParser.expression_return)e).id:null));
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
		return id;
	}
	// $ANTLR end "cot_func"



	// $ANTLR start "asin_func"
	// ValueEvaluator.g:201:1: asin_func returns [IntDouble id] : ASIN '(' (e= expression ) ')' ;
	public final IntDouble asin_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e =null;

		try {
			// ValueEvaluator.g:202:3: ( ASIN '(' (e= expression ) ')' )
			// ValueEvaluator.g:202:5: ASIN '(' (e= expression ) ')'
			{
			match(input,ASIN,FOLLOW_ASIN_in_asin_func917); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_asin_func919); if (state.failed) return id;
			// ValueEvaluator.g:202:14: (e= expression )
			// ValueEvaluator.g:202:15: e= expression
			{
			pushFollow(FOLLOW_expression_in_asin_func924);
			e=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_asin_func927); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			    id=ValueEvaluation.asin((e!=null?((ValueEvaluatorParser.expression_return)e).id:null));
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
		return id;
	}
	// $ANTLR end "asin_func"



	// $ANTLR start "acos_func"
	// ValueEvaluator.g:207:1: acos_func returns [IntDouble id] : ACOS '(' (e= expression ) ')' ;
	public final IntDouble acos_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e =null;

		try {
			// ValueEvaluator.g:208:3: ( ACOS '(' (e= expression ) ')' )
			// ValueEvaluator.g:208:5: ACOS '(' (e= expression ) ')'
			{
			match(input,ACOS,FOLLOW_ACOS_in_acos_func944); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_acos_func946); if (state.failed) return id;
			// ValueEvaluator.g:208:14: (e= expression )
			// ValueEvaluator.g:208:15: e= expression
			{
			pushFollow(FOLLOW_expression_in_acos_func951);
			e=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_acos_func954); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			    id=ValueEvaluation.acos((e!=null?((ValueEvaluatorParser.expression_return)e).id:null));
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
		return id;
	}
	// $ANTLR end "acos_func"



	// $ANTLR start "atan_func"
	// ValueEvaluator.g:213:1: atan_func returns [IntDouble id] : ATAN '(' (e= expression ) ')' ;
	public final IntDouble atan_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e =null;

		try {
			// ValueEvaluator.g:214:3: ( ATAN '(' (e= expression ) ')' )
			// ValueEvaluator.g:214:5: ATAN '(' (e= expression ) ')'
			{
			match(input,ATAN,FOLLOW_ATAN_in_atan_func973); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_atan_func975); if (state.failed) return id;
			// ValueEvaluator.g:214:14: (e= expression )
			// ValueEvaluator.g:214:15: e= expression
			{
			pushFollow(FOLLOW_expression_in_atan_func980);
			e=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_atan_func983); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			    id=ValueEvaluation.atan((e!=null?((ValueEvaluatorParser.expression_return)e).id:null));
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
		return id;
	}
	// $ANTLR end "atan_func"



	// $ANTLR start "acot_func"
	// ValueEvaluator.g:219:1: acot_func returns [IntDouble id] : ACOT '(' (e= expression ) ')' ;
	public final IntDouble acot_func() throws RecognitionException {
		IntDouble id = null;


		ParserRuleReturnScope e =null;

		try {
			// ValueEvaluator.g:220:3: ( ACOT '(' (e= expression ) ')' )
			// ValueEvaluator.g:220:5: ACOT '(' (e= expression ) ')'
			{
			match(input,ACOT,FOLLOW_ACOT_in_acot_func1002); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_acot_func1004); if (state.failed) return id;
			// ValueEvaluator.g:220:14: (e= expression )
			// ValueEvaluator.g:220:15: e= expression
			{
			pushFollow(FOLLOW_expression_in_acot_func1009);
			e=expression();
			state._fsp--;
			if (state.failed) return id;
			}

			match(input,85,FOLLOW_85_in_acot_func1012); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			    id=ValueEvaluation.acot((e!=null?((ValueEvaluatorParser.expression_return)e).id:null));
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
		return id;
	}
	// $ANTLR end "acot_func"



	// $ANTLR start "exceedFunc"
	// ValueEvaluator.g:225:1: exceedFunc returns [IntDouble id] : EXCEEDANCE '(' var= IDENT ';' exc= term ';' (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL ) ';' sy= INTEGER ';' sm= MONTH_CONST ';' sd= INTEGER ';' ey= INTEGER ';' em= MONTH_CONST ';' ed= INTEGER ')' ;
	public final IntDouble exceedFunc() throws RecognitionException {
		IntDouble id = null;


		Token var=null;
		Token mon=null;
		Token sy=null;
		Token sm=null;
		Token sd=null;
		Token ey=null;
		Token em=null;
		Token ed=null;
		IntDouble exc =null;

		try {
			// ValueEvaluator.g:226:3: ( EXCEEDANCE '(' var= IDENT ';' exc= term ';' (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL ) ';' sy= INTEGER ';' sm= MONTH_CONST ';' sd= INTEGER ';' ey= INTEGER ';' em= MONTH_CONST ';' ed= INTEGER ')' )
			// ValueEvaluator.g:226:5: EXCEEDANCE '(' var= IDENT ';' exc= term ';' (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL ) ';' sy= INTEGER ';' sm= MONTH_CONST ';' sd= INTEGER ';' ey= INTEGER ';' em= MONTH_CONST ';' ed= INTEGER ')'
			{
			match(input,EXCEEDANCE,FOLLOW_EXCEEDANCE_in_exceedFunc1031); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_exceedFunc1033); if (state.failed) return id;
			var=(Token)match(input,IDENT,FOLLOW_IDENT_in_exceedFunc1037); if (state.failed) return id;
			match(input,92,FOLLOW_92_in_exceedFunc1039); if (state.failed) return id;
			pushFollow(FOLLOW_term_in_exceedFunc1043);
			exc=term();
			state._fsp--;
			if (state.failed) return id;
			match(input,92,FOLLOW_92_in_exceedFunc1045); if (state.failed) return id;
			// ValueEvaluator.g:226:47: (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL )
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
				if (state.backtracking>0) {state.failed=true; return id;}
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// ValueEvaluator.g:226:48: mon= MONTH_CONST
					{
					mon=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_exceedFunc1050); if (state.failed) return id;
					}
					break;
				case 2 :
					// ValueEvaluator.g:226:64: mon= MONTH_RANGE
					{
					mon=(Token)match(input,MONTH_RANGE,FOLLOW_MONTH_RANGE_in_exceedFunc1054); if (state.failed) return id;
					}
					break;
				case 3 :
					// ValueEvaluator.g:226:80: mon= ALL
					{
					mon=(Token)match(input,ALL,FOLLOW_ALL_in_exceedFunc1058); if (state.failed) return id;
					}
					break;

			}

			match(input,92,FOLLOW_92_in_exceedFunc1061); if (state.failed) return id;
			sy=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedFunc1065); if (state.failed) return id;
			match(input,92,FOLLOW_92_in_exceedFunc1067); if (state.failed) return id;
			sm=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_exceedFunc1071); if (state.failed) return id;
			match(input,92,FOLLOW_92_in_exceedFunc1073); if (state.failed) return id;
			sd=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedFunc1077); if (state.failed) return id;
			match(input,92,FOLLOW_92_in_exceedFunc1079); if (state.failed) return id;
			ey=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedFunc1083); if (state.failed) return id;
			match(input,92,FOLLOW_92_in_exceedFunc1085); if (state.failed) return id;
			em=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_exceedFunc1089); if (state.failed) return id;
			match(input,92,FOLLOW_92_in_exceedFunc1091); if (state.failed) return id;
			ed=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedFunc1095); if (state.failed) return id;
			match(input,85,FOLLOW_85_in_exceedFunc1097); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			    id=ValueEvaluation.exceedance((var!=null?var.getText():null), exc, (mon!=null?mon.getText():null), (sy!=null?sy.getText():null), (sm!=null?sm.getText():null), (sd!=null?sd.getText():null), (ey!=null?ey.getText():null), (em!=null?em.getText():null), (ed!=null?ed.getText():null));
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
		return id;
	}
	// $ANTLR end "exceedFunc"



	// $ANTLR start "exceedtsiFunc"
	// ValueEvaluator.g:231:1: exceedtsiFunc returns [IntDouble id] : EXCEEDANCE_TSI '(' var= IDENT ';' exc= term ';' (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL ) ';' sy= INTEGER ';' sm= MONTH_CONST ';' sd= INTEGER ';' ey= INTEGER ';' em= MONTH_CONST ';' ed= INTEGER ')' ;
	public final IntDouble exceedtsiFunc() throws RecognitionException {
		IntDouble id = null;


		Token var=null;
		Token mon=null;
		Token sy=null;
		Token sm=null;
		Token sd=null;
		Token ey=null;
		Token em=null;
		Token ed=null;
		IntDouble exc =null;

		try {
			// ValueEvaluator.g:232:3: ( EXCEEDANCE_TSI '(' var= IDENT ';' exc= term ';' (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL ) ';' sy= INTEGER ';' sm= MONTH_CONST ';' sd= INTEGER ';' ey= INTEGER ';' em= MONTH_CONST ';' ed= INTEGER ')' )
			// ValueEvaluator.g:232:5: EXCEEDANCE_TSI '(' var= IDENT ';' exc= term ';' (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL ) ';' sy= INTEGER ';' sm= MONTH_CONST ';' sd= INTEGER ';' ey= INTEGER ';' em= MONTH_CONST ';' ed= INTEGER ')'
			{
			match(input,EXCEEDANCE_TSI,FOLLOW_EXCEEDANCE_TSI_in_exceedtsiFunc1119); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_exceedtsiFunc1121); if (state.failed) return id;
			var=(Token)match(input,IDENT,FOLLOW_IDENT_in_exceedtsiFunc1125); if (state.failed) return id;
			match(input,92,FOLLOW_92_in_exceedtsiFunc1127); if (state.failed) return id;
			pushFollow(FOLLOW_term_in_exceedtsiFunc1131);
			exc=term();
			state._fsp--;
			if (state.failed) return id;
			match(input,92,FOLLOW_92_in_exceedtsiFunc1133); if (state.failed) return id;
			// ValueEvaluator.g:232:51: (mon= MONTH_CONST |mon= MONTH_RANGE |mon= ALL )
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
				if (state.backtracking>0) {state.failed=true; return id;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// ValueEvaluator.g:232:52: mon= MONTH_CONST
					{
					mon=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_exceedtsiFunc1138); if (state.failed) return id;
					}
					break;
				case 2 :
					// ValueEvaluator.g:232:68: mon= MONTH_RANGE
					{
					mon=(Token)match(input,MONTH_RANGE,FOLLOW_MONTH_RANGE_in_exceedtsiFunc1142); if (state.failed) return id;
					}
					break;
				case 3 :
					// ValueEvaluator.g:232:84: mon= ALL
					{
					mon=(Token)match(input,ALL,FOLLOW_ALL_in_exceedtsiFunc1146); if (state.failed) return id;
					}
					break;

			}

			match(input,92,FOLLOW_92_in_exceedtsiFunc1149); if (state.failed) return id;
			sy=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedtsiFunc1153); if (state.failed) return id;
			match(input,92,FOLLOW_92_in_exceedtsiFunc1155); if (state.failed) return id;
			sm=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_exceedtsiFunc1159); if (state.failed) return id;
			match(input,92,FOLLOW_92_in_exceedtsiFunc1161); if (state.failed) return id;
			sd=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedtsiFunc1165); if (state.failed) return id;
			match(input,92,FOLLOW_92_in_exceedtsiFunc1167); if (state.failed) return id;
			ey=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedtsiFunc1171); if (state.failed) return id;
			match(input,92,FOLLOW_92_in_exceedtsiFunc1173); if (state.failed) return id;
			em=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_exceedtsiFunc1177); if (state.failed) return id;
			match(input,92,FOLLOW_92_in_exceedtsiFunc1179); if (state.failed) return id;
			ed=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_exceedtsiFunc1183); if (state.failed) return id;
			match(input,85,FOLLOW_85_in_exceedtsiFunc1185); if (state.failed) return id;
			if ( state.backtracking==0 ) {
			    id=ValueEvaluation.exceedance_tsi((var!=null?var.getText():null), exc, (mon!=null?mon.getText():null), (sy!=null?sy.getText():null), (sm!=null?sm.getText():null), (sd!=null?sd.getText():null), (ey!=null?ey.getText():null), (em!=null?em.getText():null), (ed!=null?ed.getText():null));
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
		return id;
	}
	// $ANTLR end "exceedtsiFunc"



	// $ANTLR start "range_func"
	// ValueEvaluator.g:237:1: range_func returns [boolean result] : RANGE '(' MONTH ';' m1= MONTH_CONST ';' m2= MONTH_CONST ')' ;
	public final boolean range_func() throws RecognitionException {
		boolean result = false;


		Token m1=null;
		Token m2=null;

		try {
			// ValueEvaluator.g:238:3: ( RANGE '(' MONTH ';' m1= MONTH_CONST ';' m2= MONTH_CONST ')' )
			// ValueEvaluator.g:238:5: RANGE '(' MONTH ';' m1= MONTH_CONST ';' m2= MONTH_CONST ')'
			{
			match(input,RANGE,FOLLOW_RANGE_in_range_func1208); if (state.failed) return result;
			match(input,84,FOLLOW_84_in_range_func1210); if (state.failed) return result;
			match(input,MONTH,FOLLOW_MONTH_in_range_func1212); if (state.failed) return result;
			match(input,92,FOLLOW_92_in_range_func1214); if (state.failed) return result;
			m1=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_range_func1218); if (state.failed) return result;
			match(input,92,FOLLOW_92_in_range_func1220); if (state.failed) return result;
			m2=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_range_func1224); if (state.failed) return result;
			match(input,85,FOLLOW_85_in_range_func1226); if (state.failed) return result;
			if ( state.backtracking==0 ) {result=ValueEvaluation.range((m1!=null?m1.getText():null), (m2!=null?m2.getText():null));}
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
	// ValueEvaluator.g:240:1: timeseriesWithUnits : 'timeseries' 'kind' '=' partC 'units' '=' IDENT ;
	public final void timeseriesWithUnits() throws RecognitionException {
		try {
			// ValueEvaluator.g:241:2: ( 'timeseries' 'kind' '=' partC 'units' '=' IDENT )
			// ValueEvaluator.g:241:4: 'timeseries' 'kind' '=' partC 'units' '=' IDENT
			{
			match(input,103,FOLLOW_103_in_timeseriesWithUnits1238); if (state.failed) return;
			match(input,102,FOLLOW_102_in_timeseriesWithUnits1240); if (state.failed) return;
			match(input,95,FOLLOW_95_in_timeseriesWithUnits1242); if (state.failed) return;
			pushFollow(FOLLOW_partC_in_timeseriesWithUnits1244);
			partC();
			state._fsp--;
			if (state.failed) return;
			match(input,UNITS,FOLLOW_UNITS_in_timeseriesWithUnits1246); if (state.failed) return;
			match(input,95,FOLLOW_95_in_timeseriesWithUnits1248); if (state.failed) return;
			match(input,IDENT,FOLLOW_IDENT_in_timeseriesWithUnits1250); if (state.failed) return;
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
	// ValueEvaluator.g:244:1: timeseries returns [IntDouble id] : 'timeseries' ;
	public final IntDouble timeseries() throws RecognitionException {
		IntDouble id = null;


		try {
			// ValueEvaluator.g:245:2: ( 'timeseries' )
			// ValueEvaluator.g:245:4: 'timeseries'
			{
			match(input,103,FOLLOW_103_in_timeseries1266); if (state.failed) return id;
			if ( state.backtracking==0 ) {id=ValueEvaluation.timeseries();}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return id;
	}
	// $ANTLR end "timeseries"



	// $ANTLR start "partC"
	// ValueEvaluator.g:250:1: partC : ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )* ;
	public final void partC() throws RecognitionException {
		try {
			// ValueEvaluator.g:250:6: ( ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )* )
			// ValueEvaluator.g:250:9: ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )*
			{
			// ValueEvaluator.g:250:9: ( IDENT | IDENT1 | usedKeywords )
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
					// ValueEvaluator.g:250:10: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_partC1283); if (state.failed) return;
					}
					break;
				case 2 :
					// ValueEvaluator.g:250:16: IDENT1
					{
					match(input,IDENT1,FOLLOW_IDENT1_in_partC1285); if (state.failed) return;
					}
					break;
				case 3 :
					// ValueEvaluator.g:250:23: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_partC1287);
					usedKeywords();
					state._fsp--;
					if (state.failed) return;
					}
					break;

			}

			// ValueEvaluator.g:250:37: ( '-' ( IDENT | IDENT1 | usedKeywords ) )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==88) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// ValueEvaluator.g:250:38: '-' ( IDENT | IDENT1 | usedKeywords )
					{
					match(input,88,FOLLOW_88_in_partC1291); if (state.failed) return;
					// ValueEvaluator.g:250:42: ( IDENT | IDENT1 | usedKeywords )
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
							// ValueEvaluator.g:250:43: IDENT
							{
							match(input,IDENT,FOLLOW_IDENT_in_partC1294); if (state.failed) return;
							}
							break;
						case 2 :
							// ValueEvaluator.g:250:49: IDENT1
							{
							match(input,IDENT1,FOLLOW_IDENT1_in_partC1296); if (state.failed) return;
							}
							break;
						case 3 :
							// ValueEvaluator.g:250:56: usedKeywords
							{
							pushFollow(FOLLOW_usedKeywords_in_partC1298);
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
	// ValueEvaluator.g:252:1: usedKeywords : ( YEAR | MONTH | MONTH_CONST | MONTH_RANGE | DAY | PASTMONTH | RANGE | TAFCFS | DAYSIN | DAYSINTIMESTEP | SUM | MAX | MIN | INT | REAL | ABS | EXP | LOG | LOG10 | POW | MOD | ROUND | SELECT | FROM | GIVEN | USE | WHERE | CONSTRAIN | ALWAYS | NAME | DVAR | CYCLE | FILE | CONDITION | INCLUDE | LOWERBOUND | UPPERBOUND | INTEGERTYPE | UNITS | CONVERTUNITS | TYPE | OUTPUT | CASE | ORDER | EXPRESSION | LHSGTRHS | LHSLTRHS | WEIGHT | FUNCTION | FROM_WRESL_FILE | UPPERUNBOUNDED | LOWERUNBOUNDED | AND | OR | NOT | SIN | COS | TAN | COT | ASIN | ACOS | ATAN | ACOT | EXCEEDANCE | EXCEEDANCE_TSI | ALL );
	public final ValueEvaluatorParser.usedKeywords_return usedKeywords() throws RecognitionException {
		ValueEvaluatorParser.usedKeywords_return retval = new ValueEvaluatorParser.usedKeywords_return();
		retval.start = input.LT(1);

		try {
			// ValueEvaluator.g:252:13: ( YEAR | MONTH | MONTH_CONST | MONTH_RANGE | DAY | PASTMONTH | RANGE | TAFCFS | DAYSIN | DAYSINTIMESTEP | SUM | MAX | MIN | INT | REAL | ABS | EXP | LOG | LOG10 | POW | MOD | ROUND | SELECT | FROM | GIVEN | USE | WHERE | CONSTRAIN | ALWAYS | NAME | DVAR | CYCLE | FILE | CONDITION | INCLUDE | LOWERBOUND | UPPERBOUND | INTEGERTYPE | UNITS | CONVERTUNITS | TYPE | OUTPUT | CASE | ORDER | EXPRESSION | LHSGTRHS | LHSLTRHS | WEIGHT | FUNCTION | FROM_WRESL_FILE | UPPERUNBOUNDED | LOWERUNBOUNDED | AND | OR | NOT | SIN | COS | TAN | COT | ASIN | ACOS | ATAN | ACOT | EXCEEDANCE | EXCEEDANCE_TSI | ALL )
			// ValueEvaluator.g:
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
	// ValueEvaluator.g:257:1: tableSQL returns [IntDouble id] : SELECT ( (i1= IDENT ) | (u1= usedKeywords ) ) FROM i2= IDENT ( GIVEN a= assignStatement )? ( USE i3= IDENT )? ( where_items )? ;
	public final IntDouble tableSQL() throws RecognitionException {
		IntDouble id = null;


		Token i1=null;
		Token i2=null;
		Token i3=null;
		ParserRuleReturnScope u1 =null;
		ParserRuleReturnScope a =null;
		HashMap<String, Number> where_items28 =null;

		String table=null; String select=null; String use=null; HashMap<String, Number> given=null; HashMap<String, Number> where=null;
		try {
			// ValueEvaluator.g:258:2: ( SELECT ( (i1= IDENT ) | (u1= usedKeywords ) ) FROM i2= IDENT ( GIVEN a= assignStatement )? ( USE i3= IDENT )? ( where_items )? )
			// ValueEvaluator.g:258:4: SELECT ( (i1= IDENT ) | (u1= usedKeywords ) ) FROM i2= IDENT ( GIVEN a= assignStatement )? ( USE i3= IDENT )? ( where_items )?
			{
			match(input,SELECT,FOLLOW_SELECT_in_tableSQL1460); if (state.failed) return id;
			// ValueEvaluator.g:258:11: ( (i1= IDENT ) | (u1= usedKeywords ) )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==IDENT) ) {
				alt16=1;
			}
			else if ( ((LA16_0 >= ABS && LA16_0 <= AND)||(LA16_0 >= ASIN && LA16_0 <= ATAN)||LA16_0==CASE||(LA16_0 >= CONDITION && LA16_0 <= DAYSINTIMESTEP)||(LA16_0 >= DVAR && LA16_0 <= FILE)||(LA16_0 >= FROM && LA16_0 <= GIVEN)||(LA16_0 >= INCLUDE && LA16_0 <= INT)||LA16_0==INTEGERTYPE||(LA16_0 >= LHSGTRHS && LA16_0 <= MONTH_RANGE)||(LA16_0 >= NAME && LA16_0 <= SUM)||(LA16_0 >= TAFCFS && LA16_0 <= WHERE)||LA16_0==YEAR) ) {
				alt16=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return id;}
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// ValueEvaluator.g:258:12: (i1= IDENT )
					{
					// ValueEvaluator.g:258:12: (i1= IDENT )
					// ValueEvaluator.g:258:13: i1= IDENT
					{
					i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_tableSQL1466); if (state.failed) return id;
					if ( state.backtracking==0 ) {select=(i1!=null?i1.getText():null);}
					}

					}
					break;
				case 2 :
					// ValueEvaluator.g:258:41: (u1= usedKeywords )
					{
					// ValueEvaluator.g:258:41: (u1= usedKeywords )
					// ValueEvaluator.g:258:42: u1= usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_tableSQL1473);
					u1=usedKeywords();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {select=(u1!=null?input.toString(u1.start,u1.stop):null);}
					}

					}
					break;

			}

			match(input,FROM,FOLLOW_FROM_in_tableSQL1478); if (state.failed) return id;
			i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_tableSQL1482); if (state.failed) return id;
			if ( state.backtracking==0 ) {table=(i2!=null?i2.getText():null);}
			// ValueEvaluator.g:259:4: ( GIVEN a= assignStatement )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==GIVEN) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// ValueEvaluator.g:259:5: GIVEN a= assignStatement
					{
					match(input,GIVEN,FOLLOW_GIVEN_in_tableSQL1490); if (state.failed) return id;
					pushFollow(FOLLOW_assignStatement_in_tableSQL1494);
					a=assignStatement();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {given=new HashMap<String, Number>(); given.put((a!=null?((ValueEvaluatorParser.assignStatement_return)a).assignIdent:null), (a!=null?((ValueEvaluatorParser.assignStatement_return)a).value:null));}
					}
					break;

			}

			// ValueEvaluator.g:259:106: ( USE i3= IDENT )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==USE) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// ValueEvaluator.g:259:107: USE i3= IDENT
					{
					match(input,USE,FOLLOW_USE_in_tableSQL1500); if (state.failed) return id;
					i3=(Token)match(input,IDENT,FOLLOW_IDENT_in_tableSQL1504); if (state.failed) return id;
					if ( state.backtracking==0 ) {use=(i3!=null?i3.getText():null);}
					}
					break;

			}

			// ValueEvaluator.g:260:4: ( where_items )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==WHERE) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// ValueEvaluator.g:260:5: where_items
					{
					pushFollow(FOLLOW_where_items_in_tableSQL1514);
					where_items28=where_items();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {where=where_items28;}
					}
					break;

			}

			if ( state.backtracking==0 ) {id=ValueEvaluation.tableSQL(table, select, where, given, use);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return id;
	}
	// $ANTLR end "tableSQL"



	// $ANTLR start "where_items"
	// ValueEvaluator.g:263:1: where_items returns [HashMap<String, Number> where] : WHERE (r1= whereStatement ) ( ';' r= whereStatement )* ;
	public final HashMap<String, Number> where_items() throws RecognitionException {
		HashMap<String, Number> where = null;


		ParserRuleReturnScope r1 =null;
		ParserRuleReturnScope r =null;

		try {
			// ValueEvaluator.g:264:2: ( WHERE (r1= whereStatement ) ( ';' r= whereStatement )* )
			// ValueEvaluator.g:264:5: WHERE (r1= whereStatement ) ( ';' r= whereStatement )*
			{
			match(input,WHERE,FOLLOW_WHERE_in_where_items1538); if (state.failed) return where;
			// ValueEvaluator.g:264:12: (r1= whereStatement )
			// ValueEvaluator.g:264:13: r1= whereStatement
			{
			pushFollow(FOLLOW_whereStatement_in_where_items1544);
			r1=whereStatement();
			state._fsp--;
			if (state.failed) return where;
			if ( state.backtracking==0 ) {where=new HashMap<String, Number>(); where.put((r1!=null?((ValueEvaluatorParser.whereStatement_return)r1).whereIdent:null), (r1!=null?((ValueEvaluatorParser.whereStatement_return)r1).value:null));}
			}

			// ValueEvaluator.g:265:10: ( ';' r= whereStatement )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==92) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// ValueEvaluator.g:265:11: ';' r= whereStatement
					{
					match(input,92,FOLLOW_92_in_where_items1558); if (state.failed) return where;
					pushFollow(FOLLOW_whereStatement_in_where_items1562);
					r=whereStatement();
					state._fsp--;
					if (state.failed) return where;
					if ( state.backtracking==0 ) {where.put((r!=null?((ValueEvaluatorParser.whereStatement_return)r).whereIdent:null), (r!=null?((ValueEvaluatorParser.whereStatement_return)r).value:null));}
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
	// ValueEvaluator.g:269:1: upperbound : ( IDENT | allnumber | ( allnumber '*' TAFCFS ) );
	public final void upperbound() throws RecognitionException {
		try {
			// ValueEvaluator.g:269:11: ( IDENT | allnumber | ( allnumber '*' TAFCFS ) )
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
					// ValueEvaluator.g:269:13: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_upperbound1575); if (state.failed) return;
					}
					break;
				case 2 :
					// ValueEvaluator.g:269:19: allnumber
					{
					pushFollow(FOLLOW_allnumber_in_upperbound1577);
					allnumber();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// ValueEvaluator.g:269:29: ( allnumber '*' TAFCFS )
					{
					// ValueEvaluator.g:269:29: ( allnumber '*' TAFCFS )
					// ValueEvaluator.g:269:30: allnumber '*' TAFCFS
					{
					pushFollow(FOLLOW_allnumber_in_upperbound1580);
					allnumber();
					state._fsp--;
					if (state.failed) return;
					match(input,86,FOLLOW_86_in_upperbound1582); if (state.failed) return;
					match(input,TAFCFS,FOLLOW_TAFCFS_in_upperbound1584); if (state.failed) return;
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
	// ValueEvaluator.g:271:1: lowerbound : ( IDENT | allnumber | ( allnumber '*' TAFCFS ) );
	public final void lowerbound() throws RecognitionException {
		try {
			// ValueEvaluator.g:271:11: ( IDENT | allnumber | ( allnumber '*' TAFCFS ) )
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
					// ValueEvaluator.g:271:13: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_lowerbound1592); if (state.failed) return;
					}
					break;
				case 2 :
					// ValueEvaluator.g:271:19: allnumber
					{
					pushFollow(FOLLOW_allnumber_in_lowerbound1594);
					allnumber();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// ValueEvaluator.g:271:29: ( allnumber '*' TAFCFS )
					{
					// ValueEvaluator.g:271:29: ( allnumber '*' TAFCFS )
					// ValueEvaluator.g:271:30: allnumber '*' TAFCFS
					{
					pushFollow(FOLLOW_allnumber_in_lowerbound1597);
					allnumber();
					state._fsp--;
					if (state.failed) return;
					match(input,86,FOLLOW_86_in_lowerbound1599); if (state.failed) return;
					match(input,TAFCFS,FOLLOW_TAFCFS_in_lowerbound1601); if (state.failed) return;
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
	// ValueEvaluator.g:284:1: sumExpression returns [IntDouble id] : SUM '(' IDENT '=' e1= expression ';' e2= expression ( ';' ( ( '-' )? INTEGER ) )? ( ')' ) e3= expression ;
	public final IntDouble sumExpression() throws RecognitionException {
		IntDouble id = null;


		Token IDENT29=null;
		Token INTEGER30=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;
		ParserRuleReturnScope e3 =null;

		String s="";
		try {
			// ValueEvaluator.g:285:3: ( SUM '(' IDENT '=' e1= expression ';' e2= expression ( ';' ( ( '-' )? INTEGER ) )? ( ')' ) e3= expression )
			// ValueEvaluator.g:285:5: SUM '(' IDENT '=' e1= expression ';' e2= expression ( ';' ( ( '-' )? INTEGER ) )? ( ')' ) e3= expression
			{
			match(input,SUM,FOLLOW_SUM_in_sumExpression1631); if (state.failed) return id;
			match(input,84,FOLLOW_84_in_sumExpression1633); if (state.failed) return id;
			IDENT29=(Token)match(input,IDENT,FOLLOW_IDENT_in_sumExpression1635); if (state.failed) return id;
			if ( state.backtracking==0 ) {ValueEvaluation.sumExpression_IDENT((IDENT29!=null?IDENT29.getText():null), sumIndex);}
			match(input,95,FOLLOW_95_in_sumExpression1638); if (state.failed) return id;
			pushFollow(FOLLOW_expression_in_sumExpression1642);
			e1=expression();
			state._fsp--;
			if (state.failed) return id;
			match(input,92,FOLLOW_92_in_sumExpression1644); if (state.failed) return id;
			pushFollow(FOLLOW_expression_in_sumExpression1648);
			e2=expression();
			state._fsp--;
			if (state.failed) return id;
			// ValueEvaluator.g:285:116: ( ';' ( ( '-' )? INTEGER ) )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==92) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// ValueEvaluator.g:285:117: ';' ( ( '-' )? INTEGER )
					{
					match(input,92,FOLLOW_92_in_sumExpression1651); if (state.failed) return id;
					// ValueEvaluator.g:285:121: ( ( '-' )? INTEGER )
					// ValueEvaluator.g:285:122: ( '-' )? INTEGER
					{
					// ValueEvaluator.g:285:122: ( '-' )?
					int alt23=2;
					int LA23_0 = input.LA(1);
					if ( (LA23_0==88) ) {
						alt23=1;
					}
					switch (alt23) {
						case 1 :
							// ValueEvaluator.g:285:123: '-'
							{
							match(input,88,FOLLOW_88_in_sumExpression1655); if (state.failed) return id;
							if ( state.backtracking==0 ) {s=s+"-";}
							}
							break;

					}

					INTEGER30=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sumExpression1660); if (state.failed) return id;
					if ( state.backtracking==0 ) {s=s+(INTEGER30!=null?INTEGER30.getText():null);}
					}

					}
					break;

			}

			// ValueEvaluator.g:285:171: ( ')' )
			// ValueEvaluator.g:285:172: ')'
			{
			match(input,85,FOLLOW_85_in_sumExpression1668); if (state.failed) return id;
			if ( state.backtracking==0 ) {ValueEvaluation.initSumExpression((e1!=null?((ValueEvaluatorParser.expression_return)e1).id:null), (e2!=null?((ValueEvaluatorParser.expression_return)e2).id:null), s, sumIndex);}
			}

			pushFollow(FOLLOW_expression_in_sumExpression1675);
			e3=expression();
			state._fsp--;
			if (state.failed) return id;
			if ( state.backtracking==0 ) {id=ValueEvaluation.sumExpression((e3!=null?((ValueEvaluatorParser.expression_return)e3).id:null), (e3!=null?input.toString(e3.start,e3.stop):null), sumIndex);}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return id;
	}
	// $ANTLR end "sumExpression"



	// $ANTLR start "term"
	// ValueEvaluator.g:288:1: term returns [IntDouble id] : ( ( IDENT ) | ( FLOAT ) | ( '(' (e= expression ) ')' ) | ( knownTS ) | func | ( INTEGER ) | tafcfs_term | YEAR | MONTH | DAY | MONTH_CONST | PASTMONTH | DAYSIN | DAYSINTIMESTEP | ( SVAR ) | ARRAY_ITERATOR | '(' sumExpression ')' );
	public final IntDouble term() throws RecognitionException {
		IntDouble id = null;


		Token IDENT31=null;
		Token FLOAT32=null;
		Token INTEGER35=null;
		Token MONTH_CONST37=null;
		Token PASTMONTH38=null;
		Token SVAR39=null;
		ParserRuleReturnScope e =null;
		IntDouble knownTS33 =null;
		IntDouble func34 =null;
		IntDouble tafcfs_term36 =null;
		IntDouble sumExpression40 =null;

		try {
			// ValueEvaluator.g:289:2: ( ( IDENT ) | ( FLOAT ) | ( '(' (e= expression ) ')' ) | ( knownTS ) | func | ( INTEGER ) | tafcfs_term | YEAR | MONTH | DAY | MONTH_CONST | PASTMONTH | DAYSIN | DAYSINTIMESTEP | ( SVAR ) | ARRAY_ITERATOR | '(' sumExpression ')' )
			int alt25=17;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				int LA25_1 = input.LA(2);
				if ( (LA25_1==84||LA25_1==99) ) {
					alt25=4;
				}
				else if ( (LA25_1==EOF||LA25_1==AND||LA25_1==OR||LA25_1==USE||LA25_1==WHERE||(LA25_1 >= 85 && LA25_1 <= 88)||LA25_1==90||(LA25_1 >= 92 && LA25_1 <= 94)||(LA25_1 >= 96 && LA25_1 <= 98)) ) {
					alt25=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return id;}
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
					alt25=17;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return id;}
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
			case DAY:
				{
				alt25=10;
				}
				break;
			case MONTH_CONST:
				{
				alt25=11;
				}
				break;
			case PASTMONTH:
				{
				alt25=12;
				}
				break;
			case DAYSIN:
				{
				alt25=13;
				}
				break;
			case DAYSINTIMESTEP:
				{
				alt25=14;
				}
				break;
			case SVAR:
				{
				alt25=15;
				}
				break;
			case ARRAY_ITERATOR:
				{
				alt25=16;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return id;}
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}
			switch (alt25) {
				case 1 :
					// ValueEvaluator.g:289:4: ( IDENT )
					{
					// ValueEvaluator.g:289:4: ( IDENT )
					// ValueEvaluator.g:289:5: IDENT
					{
					IDENT31=(Token)match(input,IDENT,FOLLOW_IDENT_in_term1693); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=ValueEvaluation.term_IDENT((IDENT31!=null?IDENT31.getText():null), sumIndex);}
					}

					}
					break;
				case 2 :
					// ValueEvaluator.g:290:4: ( FLOAT )
					{
					// ValueEvaluator.g:290:4: ( FLOAT )
					// ValueEvaluator.g:290:5: FLOAT
					{
					FLOAT32=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_term1702); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=ValueEvaluation.term_FLOAT((FLOAT32!=null?FLOAT32.getText():null));}
					}

					}
					break;
				case 3 :
					// ValueEvaluator.g:291:4: ( '(' (e= expression ) ')' )
					{
					// ValueEvaluator.g:291:4: ( '(' (e= expression ) ')' )
					// ValueEvaluator.g:291:5: '(' (e= expression ) ')'
					{
					match(input,84,FOLLOW_84_in_term1712); if (state.failed) return id;
					// ValueEvaluator.g:291:9: (e= expression )
					// ValueEvaluator.g:291:10: e= expression
					{
					pushFollow(FOLLOW_expression_in_term1717);
					e=expression();
					state._fsp--;
					if (state.failed) return id;
					}

					match(input,85,FOLLOW_85_in_term1720); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=(e!=null?((ValueEvaluatorParser.expression_return)e).id:null);}
					}

					}
					break;
				case 4 :
					// ValueEvaluator.g:292:4: ( knownTS )
					{
					// ValueEvaluator.g:292:4: ( knownTS )
					// ValueEvaluator.g:292:5: knownTS
					{
					pushFollow(FOLLOW_knownTS_in_term1729);
					knownTS33=knownTS();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=ValueEvaluation.term_knownTS(knownTS33);}
					}

					}
					break;
				case 5 :
					// ValueEvaluator.g:293:4: func
					{
					pushFollow(FOLLOW_func_in_term1737);
					func34=func();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=func34;}
					}
					break;
				case 6 :
					// ValueEvaluator.g:294:4: ( INTEGER )
					{
					// ValueEvaluator.g:294:4: ( INTEGER )
					// ValueEvaluator.g:294:5: INTEGER
					{
					INTEGER35=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_term1744); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=ValueEvaluation.term_INTEGER((INTEGER35!=null?INTEGER35.getText():null));}
					}

					}
					break;
				case 7 :
					// ValueEvaluator.g:295:4: tafcfs_term
					{
					pushFollow(FOLLOW_tafcfs_term_in_term1752);
					tafcfs_term36=tafcfs_term();
					state._fsp--;
					if (state.failed) return id;
					if ( state.backtracking==0 ) {id=tafcfs_term36;}
					}
					break;
				case 8 :
					// ValueEvaluator.g:296:4: YEAR
					{
					match(input,YEAR,FOLLOW_YEAR_in_term1758); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=ValueEvaluation.term_YEAR();}
					}
					break;
				case 9 :
					// ValueEvaluator.g:297:4: MONTH
					{
					match(input,MONTH,FOLLOW_MONTH_in_term1764); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=ValueEvaluation.term_MONTH();}
					}
					break;
				case 10 :
					// ValueEvaluator.g:298:4: DAY
					{
					match(input,DAY,FOLLOW_DAY_in_term1770); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=ValueEvaluation.term_DAY();}
					}
					break;
				case 11 :
					// ValueEvaluator.g:299:4: MONTH_CONST
					{
					MONTH_CONST37=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_term1777); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=ValueEvaluation.term_MONTH_CONST((MONTH_CONST37!=null?MONTH_CONST37.getText():null));}
					}
					break;
				case 12 :
					// ValueEvaluator.g:300:4: PASTMONTH
					{
					PASTMONTH38=(Token)match(input,PASTMONTH,FOLLOW_PASTMONTH_in_term1783); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=ValueEvaluation.term_PASTMONTH((PASTMONTH38!=null?PASTMONTH38.getText():null));}
					}
					break;
				case 13 :
					// ValueEvaluator.g:301:4: DAYSIN
					{
					match(input,DAYSIN,FOLLOW_DAYSIN_in_term1789); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=ValueEvaluation.daysIn();}
					}
					break;
				case 14 :
					// ValueEvaluator.g:302:4: DAYSINTIMESTEP
					{
					match(input,DAYSINTIMESTEP,FOLLOW_DAYSINTIMESTEP_in_term1795); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=ValueEvaluation.daysInTimeStep();}
					}
					break;
				case 15 :
					// ValueEvaluator.g:303:4: ( SVAR )
					{
					// ValueEvaluator.g:303:4: ( SVAR )
					// ValueEvaluator.g:303:5: SVAR
					{
					SVAR39=(Token)match(input,SVAR,FOLLOW_SVAR_in_term1802); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=ValueEvaluation.term_SVAR((SVAR39!=null?SVAR39.getText():null).replace("{","").replace("}",""));}
					}

					}
					break;
				case 16 :
					// ValueEvaluator.g:304:4: ARRAY_ITERATOR
					{
					match(input,ARRAY_ITERATOR,FOLLOW_ARRAY_ITERATOR_in_term1809); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=ValueEvaluation.term_ARRAY_ITERATOR(prvs);}
					}
					break;
				case 17 :
					// ValueEvaluator.g:305:4: '(' sumExpression ')'
					{
					match(input,84,FOLLOW_84_in_term1816); if (state.failed) return id;
					pushFollow(FOLLOW_sumExpression_in_term1818);
					sumExpression40=sumExpression();
					state._fsp--;
					if (state.failed) return id;
					match(input,85,FOLLOW_85_in_term1820); if (state.failed) return id;
					if ( state.backtracking==0 ) {id=sumExpression40;}
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
		return id;
	}
	// $ANTLR end "term"



	// $ANTLR start "tafcfs_term"
	// ValueEvaluator.g:308:1: tafcfs_term returns [IntDouble id] : TAFCFS ( '(' expression ')' )? ;
	public final IntDouble tafcfs_term() throws RecognitionException {
		IntDouble id = null;


		Token TAFCFS41=null;
		ParserRuleReturnScope expression42 =null;

		try {
			// ValueEvaluator.g:308:35: ( TAFCFS ( '(' expression ')' )? )
			// ValueEvaluator.g:308:37: TAFCFS ( '(' expression ')' )?
			{
			TAFCFS41=(Token)match(input,TAFCFS,FOLLOW_TAFCFS_in_tafcfs_term1836); if (state.failed) return id;
			// ValueEvaluator.g:308:44: ( '(' expression ')' )?
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==84) ) {
				alt26=1;
			}
			switch (alt26) {
				case 1 :
					// ValueEvaluator.g:308:45: '(' expression ')'
					{
					match(input,84,FOLLOW_84_in_tafcfs_term1839); if (state.failed) return id;
					pushFollow(FOLLOW_expression_in_tafcfs_term1841);
					expression42=expression();
					state._fsp--;
					if (state.failed) return id;
					match(input,85,FOLLOW_85_in_tafcfs_term1843); if (state.failed) return id;
					}
					break;

			}

			if ( state.backtracking==0 ) {
			    id=ValueEvaluation.tafcfs_term((TAFCFS41!=null?TAFCFS41.getText():null), (expression42!=null?((ValueEvaluatorParser.expression_return)expression42).id:null));
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
		return id;
	}
	// $ANTLR end "tafcfs_term"



	// $ANTLR start "knownTS"
	// ValueEvaluator.g:312:1: knownTS returns [IntDouble result] : ( (f= function ) | (p= pastCycleValue ) );
	public final IntDouble knownTS() throws RecognitionException {
		IntDouble result = null;


		IntDouble f =null;
		IntDouble p =null;

		try {
			// ValueEvaluator.g:313:3: ( (f= function ) | (p= pastCycleValue ) )
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==IDENT) ) {
				int LA27_1 = input.LA(2);
				if ( (LA27_1==84) ) {
					alt27=1;
				}
				else if ( (LA27_1==99) ) {
					alt27=2;
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
					// ValueEvaluator.g:313:5: (f= function )
					{
					// ValueEvaluator.g:313:5: (f= function )
					// ValueEvaluator.g:313:6: f= function
					{
					pushFollow(FOLLOW_function_in_knownTS1867);
					f=function();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result=f;}
					}

					}
					break;
				case 2 :
					// ValueEvaluator.g:313:37: (p= pastCycleValue )
					{
					// ValueEvaluator.g:313:37: (p= pastCycleValue )
					// ValueEvaluator.g:313:38: p= pastCycleValue
					{
					pushFollow(FOLLOW_pastCycleValue_in_knownTS1874);
					p=pastCycleValue();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result=p;}
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
	// $ANTLR end "knownTS"



	// $ANTLR start "pastCycleValue"
	// ValueEvaluator.g:316:1: pastCycleValue returns [IntDouble result] : ( (p1= pastCycleNoTimeArray ) | (p2= pastCycleTimeArray ) | (p3= pastCycleIndexNoTimeArray ) | (p4= pastCycleIndexTimeArray ) );
	public final IntDouble pastCycleValue() throws RecognitionException {
		IntDouble result = null;


		IntDouble p1 =null;
		IntDouble p2 =null;
		IntDouble p3 =null;
		IntDouble p4 =null;

		try {
			// ValueEvaluator.g:317:3: ( (p1= pastCycleNoTimeArray ) | (p2= pastCycleTimeArray ) | (p3= pastCycleIndexNoTimeArray ) | (p4= pastCycleIndexTimeArray ) )
			int alt28=4;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==IDENT) ) {
				int LA28_1 = input.LA(2);
				if ( (LA28_1==99) ) {
					int LA28_2 = input.LA(3);
					if ( (LA28_2==IDENT) ) {
						int LA28_3 = input.LA(4);
						if ( (LA28_3==100) ) {
							int LA28_5 = input.LA(5);
							if ( (LA28_5==84) ) {
								alt28=2;
							}
							else if ( (LA28_5==EOF||LA28_5==AND||LA28_5==OR||LA28_5==USE||LA28_5==WHERE||(LA28_5 >= 85 && LA28_5 <= 88)||LA28_5==90||(LA28_5 >= 92 && LA28_5 <= 94)||(LA28_5 >= 96 && LA28_5 <= 98)) ) {
								alt28=1;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 28, 5, input);
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
									new NoViableAltException("", 28, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA28_2==88) ) {
						int LA28_4 = input.LA(4);
						if ( (LA28_4==INTEGER) ) {
							int LA28_6 = input.LA(5);
							if ( (LA28_6==100) ) {
								int LA28_9 = input.LA(6);
								if ( (LA28_9==84) ) {
									alt28=4;
								}
								else if ( (LA28_9==EOF||LA28_9==AND||LA28_9==OR||LA28_9==USE||LA28_9==WHERE||(LA28_9 >= 85 && LA28_9 <= 88)||LA28_9==90||(LA28_9 >= 92 && LA28_9 <= 94)||(LA28_9 >= 96 && LA28_9 <= 98)) ) {
									alt28=3;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return result;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 28, 9, input);
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
										new NoViableAltException("", 28, 6, input);
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
									new NoViableAltException("", 28, 4, input);
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
								new NoViableAltException("", 28, 2, input);
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
							new NoViableAltException("", 28, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// ValueEvaluator.g:317:5: (p1= pastCycleNoTimeArray )
					{
					// ValueEvaluator.g:317:5: (p1= pastCycleNoTimeArray )
					// ValueEvaluator.g:317:6: p1= pastCycleNoTimeArray
					{
					pushFollow(FOLLOW_pastCycleNoTimeArray_in_pastCycleValue1902);
					p1=pastCycleNoTimeArray();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {return p1;}
					}

					}
					break;
				case 2 :
					// ValueEvaluator.g:317:51: (p2= pastCycleTimeArray )
					{
					// ValueEvaluator.g:317:51: (p2= pastCycleTimeArray )
					// ValueEvaluator.g:317:52: p2= pastCycleTimeArray
					{
					pushFollow(FOLLOW_pastCycleTimeArray_in_pastCycleValue1909);
					p2=pastCycleTimeArray();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {return p2;}
					}

					}
					break;
				case 3 :
					// ValueEvaluator.g:317:95: (p3= pastCycleIndexNoTimeArray )
					{
					// ValueEvaluator.g:317:95: (p3= pastCycleIndexNoTimeArray )
					// ValueEvaluator.g:317:96: p3= pastCycleIndexNoTimeArray
					{
					pushFollow(FOLLOW_pastCycleIndexNoTimeArray_in_pastCycleValue1916);
					p3=pastCycleIndexNoTimeArray();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {return p3;}
					}

					}
					break;
				case 4 :
					// ValueEvaluator.g:317:146: (p4= pastCycleIndexTimeArray )
					{
					// ValueEvaluator.g:317:146: (p4= pastCycleIndexTimeArray )
					// ValueEvaluator.g:317:147: p4= pastCycleIndexTimeArray
					{
					pushFollow(FOLLOW_pastCycleIndexTimeArray_in_pastCycleValue1923);
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
	// ValueEvaluator.g:320:1: pastCycleNoTimeArray returns [IntDouble result] : i1= IDENT '[' i2= IDENT ']' ;
	public final IntDouble pastCycleNoTimeArray() throws RecognitionException {
		IntDouble result = null;


		Token i1=null;
		Token i2=null;

		try {
			// ValueEvaluator.g:321:3: (i1= IDENT '[' i2= IDENT ']' )
			// ValueEvaluator.g:321:5: i1= IDENT '[' i2= IDENT ']'
			{
			i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleNoTimeArray1944); if (state.failed) return result;
			match(input,99,FOLLOW_99_in_pastCycleNoTimeArray1946); if (state.failed) return result;
			i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleNoTimeArray1950); if (state.failed) return result;
			match(input,100,FOLLOW_100_in_pastCycleNoTimeArray1952); if (state.failed) return result;
			if ( state.backtracking==0 ) {result=ValueEvaluation.pastCycleNoTimeArray((i1!=null?i1.getText():null),(i2!=null?i2.getText():null));}
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
	// ValueEvaluator.g:324:1: pastCycleTimeArray returns [IntDouble result] : i1= IDENT '[' i2= IDENT ']' '(' e1= expression ')' ;
	public final IntDouble pastCycleTimeArray() throws RecognitionException {
		IntDouble result = null;


		Token i1=null;
		Token i2=null;
		ParserRuleReturnScope e1 =null;

		try {
			// ValueEvaluator.g:325:3: (i1= IDENT '[' i2= IDENT ']' '(' e1= expression ')' )
			// ValueEvaluator.g:325:5: i1= IDENT '[' i2= IDENT ']' '(' e1= expression ')'
			{
			i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleTimeArray1975); if (state.failed) return result;
			match(input,99,FOLLOW_99_in_pastCycleTimeArray1977); if (state.failed) return result;
			i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleTimeArray1981); if (state.failed) return result;
			match(input,100,FOLLOW_100_in_pastCycleTimeArray1983); if (state.failed) return result;
			match(input,84,FOLLOW_84_in_pastCycleTimeArray1985); if (state.failed) return result;
			pushFollow(FOLLOW_expression_in_pastCycleTimeArray1989);
			e1=expression();
			state._fsp--;
			if (state.failed) return result;
			match(input,85,FOLLOW_85_in_pastCycleTimeArray1991); if (state.failed) return result;
			if ( state.backtracking==0 ) {result=ValueEvaluation.pastCycleTimeArray((i1!=null?i1.getText():null),(i2!=null?i2.getText():null), (e1!=null?((ValueEvaluatorParser.expression_return)e1).id:null));}
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
	// ValueEvaluator.g:328:1: pastCycleIndexNoTimeArray returns [IntDouble result] : i1= IDENT '[' ( '-' index= INTEGER ) ']' ;
	public final IntDouble pastCycleIndexNoTimeArray() throws RecognitionException {
		IntDouble result = null;


		Token i1=null;
		Token index=null;

		try {
			// ValueEvaluator.g:329:3: (i1= IDENT '[' ( '-' index= INTEGER ) ']' )
			// ValueEvaluator.g:329:5: i1= IDENT '[' ( '-' index= INTEGER ) ']'
			{
			i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleIndexNoTimeArray2015); if (state.failed) return result;
			match(input,99,FOLLOW_99_in_pastCycleIndexNoTimeArray2017); if (state.failed) return result;
			// ValueEvaluator.g:329:18: ( '-' index= INTEGER )
			// ValueEvaluator.g:329:19: '-' index= INTEGER
			{
			match(input,88,FOLLOW_88_in_pastCycleIndexNoTimeArray2020); if (state.failed) return result;
			index=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_pastCycleIndexNoTimeArray2024); if (state.failed) return result;
			}

			match(input,100,FOLLOW_100_in_pastCycleIndexNoTimeArray2027); if (state.failed) return result;
			if ( state.backtracking==0 ) {result=ValueEvaluation.pastCycleIndexNoTimeArray((i1!=null?i1.getText():null), -Integer.parseInt((index!=null?index.getText():null)));}
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
	// ValueEvaluator.g:332:1: pastCycleIndexTimeArray returns [IntDouble result] : i1= IDENT '[' '-' index= INTEGER ']' '(' e1= expression ')' ;
	public final IntDouble pastCycleIndexTimeArray() throws RecognitionException {
		IntDouble result = null;


		Token i1=null;
		Token index=null;
		ParserRuleReturnScope e1 =null;

		try {
			// ValueEvaluator.g:333:3: (i1= IDENT '[' '-' index= INTEGER ']' '(' e1= expression ')' )
			// ValueEvaluator.g:333:5: i1= IDENT '[' '-' index= INTEGER ']' '(' e1= expression ')'
			{
			i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleIndexTimeArray2050); if (state.failed) return result;
			match(input,99,FOLLOW_99_in_pastCycleIndexTimeArray2052); if (state.failed) return result;
			match(input,88,FOLLOW_88_in_pastCycleIndexTimeArray2054); if (state.failed) return result;
			index=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_pastCycleIndexTimeArray2058); if (state.failed) return result;
			match(input,100,FOLLOW_100_in_pastCycleIndexTimeArray2060); if (state.failed) return result;
			match(input,84,FOLLOW_84_in_pastCycleIndexTimeArray2062); if (state.failed) return result;
			pushFollow(FOLLOW_expression_in_pastCycleIndexTimeArray2066);
			e1=expression();
			state._fsp--;
			if (state.failed) return result;
			match(input,85,FOLLOW_85_in_pastCycleIndexTimeArray2068); if (state.failed) return result;
			if ( state.backtracking==0 ) {result=ValueEvaluation.pastCycleIndexTimeArray((i1!=null?i1.getText():null),-Integer.parseInt((index!=null?index.getText():null)), (e1!=null?((ValueEvaluatorParser.expression_return)e1).id:null));}
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
	// ValueEvaluator.g:336:1: function returns [IntDouble result] : ( (n= noArgFunction ) | (a= argFunction ) );
	public final IntDouble function() throws RecognitionException {
		IntDouble result = null;


		IntDouble n =null;
		IntDouble a =null;

		try {
			// ValueEvaluator.g:337:3: ( (n= noArgFunction ) | (a= argFunction ) )
			int alt29=2;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==IDENT) ) {
				int LA29_1 = input.LA(2);
				if ( (LA29_1==84) ) {
					int LA29_2 = input.LA(3);
					if ( (LA29_2==85) ) {
						alt29=1;
					}
					else if ( ((LA29_2 >= ABS && LA29_2 <= ACOT)||(LA29_2 >= ARRAY_ITERATOR && LA29_2 <= ATAN)||(LA29_2 >= COS && LA29_2 <= COT)||(LA29_2 >= DAY && LA29_2 <= DAYSINTIMESTEP)||(LA29_2 >= EXCEEDANCE && LA29_2 <= EXP)||LA29_2==FLOAT||LA29_2==IDENT||(LA29_2 >= INT && LA29_2 <= INTEGER)||(LA29_2 >= LOG && LA29_2 <= LOG10)||(LA29_2 >= MAX && LA29_2 <= MONTH_CONST)||(LA29_2 >= PASTMONTH && LA29_2 <= POW)||(LA29_2 >= REAL && LA29_2 <= ROUND)||LA29_2==SIN||LA29_2==SVAR||(LA29_2 >= TAFCFS && LA29_2 <= TAN)||(LA29_2 >= YEAR && LA29_2 <= 84)||(LA29_2 >= 87 && LA29_2 <= 88)) ) {
						alt29=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 29, 2, input);
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
							new NoViableAltException("", 29, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}

			switch (alt29) {
				case 1 :
					// ValueEvaluator.g:337:5: (n= noArgFunction )
					{
					// ValueEvaluator.g:337:5: (n= noArgFunction )
					// ValueEvaluator.g:337:6: n= noArgFunction
					{
					pushFollow(FOLLOW_noArgFunction_in_function2090);
					n=noArgFunction();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result=n;}
					}

					}
					break;
				case 2 :
					// ValueEvaluator.g:337:42: (a= argFunction )
					{
					// ValueEvaluator.g:337:42: (a= argFunction )
					// ValueEvaluator.g:337:43: a= argFunction
					{
					pushFollow(FOLLOW_argFunction_in_function2097);
					a=argFunction();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result=a;}
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
	// $ANTLR end "function"



	// $ANTLR start "noArgFunction"
	// ValueEvaluator.g:340:1: noArgFunction returns [IntDouble result] : IDENT '(' ')' ;
	public final IntDouble noArgFunction() throws RecognitionException {
		IntDouble result = null;


		Token IDENT43=null;

		try {
			// ValueEvaluator.g:341:3: ( IDENT '(' ')' )
			// ValueEvaluator.g:341:5: IDENT '(' ')'
			{
			IDENT43=(Token)match(input,IDENT,FOLLOW_IDENT_in_noArgFunction2116); if (state.failed) return result;
			match(input,84,FOLLOW_84_in_noArgFunction2118); if (state.failed) return result;
			match(input,85,FOLLOW_85_in_noArgFunction2120); if (state.failed) return result;
			if ( state.backtracking==0 ) {result=ValueEvaluation.noArgFunction((IDENT43!=null?IDENT43.getText():null));}
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
	// $ANTLR end "noArgFunction"



	// $ANTLR start "argFunction"
	// ValueEvaluator.g:343:1: argFunction returns [IntDouble result] : IDENT '(' (e1= expression |t1= trunk_timeArray ) ( ';' (e2= expression |t2= trunk_timeArray ) )* ')' ( '(' e0= expression ')' )? ;
	public final IntDouble argFunction() throws RecognitionException {
		IntDouble result = null;


		Token IDENT44=null;
		ParserRuleReturnScope e1 =null;
		ArrayList<IntDouble> t1 =null;
		ParserRuleReturnScope e2 =null;
		ArrayList<IntDouble> t2 =null;
		ParserRuleReturnScope e0 =null;

		ArrayList<ArrayList<IntDouble>> idArray = new ArrayList<ArrayList<IntDouble>>(); ArrayList<IntDouble> id0Array=new ArrayList<IntDouble>();
		try {
			// ValueEvaluator.g:344:3: ( IDENT '(' (e1= expression |t1= trunk_timeArray ) ( ';' (e2= expression |t2= trunk_timeArray ) )* ')' ( '(' e0= expression ')' )? )
			// ValueEvaluator.g:344:5: IDENT '(' (e1= expression |t1= trunk_timeArray ) ( ';' (e2= expression |t2= trunk_timeArray ) )* ')' ( '(' e0= expression ')' )?
			{
			IDENT44=(Token)match(input,IDENT,FOLLOW_IDENT_in_argFunction2140); if (state.failed) return result;
			match(input,84,FOLLOW_84_in_argFunction2142); if (state.failed) return result;
			// ValueEvaluator.g:344:15: (e1= expression |t1= trunk_timeArray )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( ((LA30_0 >= ABS && LA30_0 <= ACOT)||(LA30_0 >= ARRAY_ITERATOR && LA30_0 <= ATAN)||(LA30_0 >= COS && LA30_0 <= COT)||(LA30_0 >= DAY && LA30_0 <= DAYSINTIMESTEP)||(LA30_0 >= EXCEEDANCE && LA30_0 <= EXP)||LA30_0==FLOAT||(LA30_0 >= INT && LA30_0 <= INTEGER)||(LA30_0 >= LOG && LA30_0 <= LOG10)||(LA30_0 >= MAX && LA30_0 <= MONTH_CONST)||(LA30_0 >= PASTMONTH && LA30_0 <= POW)||(LA30_0 >= REAL && LA30_0 <= ROUND)||LA30_0==SIN||LA30_0==SVAR||(LA30_0 >= TAFCFS && LA30_0 <= TAN)||(LA30_0 >= YEAR && LA30_0 <= 84)||(LA30_0 >= 87 && LA30_0 <= 88)) ) {
				alt30=1;
			}
			else if ( (LA30_0==IDENT) ) {
				int LA30_2 = input.LA(2);
				if ( (LA30_2==84) ) {
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
								if (state.backtracking>0) {state.failed=true; return result;}
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
							if (state.backtracking>0) {state.failed=true; return result;}
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
							if (state.backtracking>0) {state.failed=true; return result;}
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
							if (state.backtracking>0) {state.failed=true; return result;}
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
						if (state.backtracking>0) {state.failed=true; return result;}
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
				else if ( ((LA30_2 >= 85 && LA30_2 <= 88)||LA30_2==90||LA30_2==92||LA30_2==99) ) {
					alt30=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return result;}
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
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}

			switch (alt30) {
				case 1 :
					// ValueEvaluator.g:344:16: e1= expression
					{
					pushFollow(FOLLOW_expression_in_argFunction2147);
					e1=expression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {ArrayList<IntDouble> idArray1=new ArrayList<IntDouble>(); idArray1.add((e1!=null?((ValueEvaluatorParser.expression_return)e1).id:null)); idArray.add(idArray1);}
					}
					break;
				case 2 :
					// ValueEvaluator.g:345:5: t1= trunk_timeArray
					{
					pushFollow(FOLLOW_trunk_timeArray_in_argFunction2158);
					t1=trunk_timeArray();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {idArray.add(t1);}
					}
					break;

			}

			// ValueEvaluator.g:346:3: ( ';' (e2= expression |t2= trunk_timeArray ) )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==92) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// ValueEvaluator.g:346:4: ';' (e2= expression |t2= trunk_timeArray )
					{
					match(input,92,FOLLOW_92_in_argFunction2166); if (state.failed) return result;
					// ValueEvaluator.g:346:8: (e2= expression |t2= trunk_timeArray )
					int alt31=2;
					int LA31_0 = input.LA(1);
					if ( ((LA31_0 >= ABS && LA31_0 <= ACOT)||(LA31_0 >= ARRAY_ITERATOR && LA31_0 <= ATAN)||(LA31_0 >= COS && LA31_0 <= COT)||(LA31_0 >= DAY && LA31_0 <= DAYSINTIMESTEP)||(LA31_0 >= EXCEEDANCE && LA31_0 <= EXP)||LA31_0==FLOAT||(LA31_0 >= INT && LA31_0 <= INTEGER)||(LA31_0 >= LOG && LA31_0 <= LOG10)||(LA31_0 >= MAX && LA31_0 <= MONTH_CONST)||(LA31_0 >= PASTMONTH && LA31_0 <= POW)||(LA31_0 >= REAL && LA31_0 <= ROUND)||LA31_0==SIN||LA31_0==SVAR||(LA31_0 >= TAFCFS && LA31_0 <= TAN)||(LA31_0 >= YEAR && LA31_0 <= 84)||(LA31_0 >= 87 && LA31_0 <= 88)) ) {
						alt31=1;
					}
					else if ( (LA31_0==IDENT) ) {
						int LA31_2 = input.LA(2);
						if ( (LA31_2==84) ) {
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
								alt31=1;
								}
								break;
							case 88:
								{
								int LA31_4 = input.LA(4);
								if ( (LA31_4==INTEGER) ) {
									int LA31_7 = input.LA(5);
									if ( (LA31_7==91) ) {
										alt31=2;
									}
									else if ( ((LA31_7 >= 85 && LA31_7 <= 88)||LA31_7==90||LA31_7==92) ) {
										alt31=1;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return result;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 31, 7, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}
								else if ( ((LA31_4 >= ABS && LA31_4 <= ACOT)||(LA31_4 >= ARRAY_ITERATOR && LA31_4 <= ATAN)||(LA31_4 >= COS && LA31_4 <= COT)||(LA31_4 >= DAY && LA31_4 <= DAYSINTIMESTEP)||(LA31_4 >= EXCEEDANCE && LA31_4 <= EXP)||LA31_4==FLOAT||LA31_4==IDENT||LA31_4==INT||(LA31_4 >= LOG && LA31_4 <= LOG10)||(LA31_4 >= MAX && LA31_4 <= MONTH_CONST)||(LA31_4 >= PASTMONTH && LA31_4 <= POW)||(LA31_4 >= REAL && LA31_4 <= ROUND)||LA31_4==SIN||LA31_4==SVAR||(LA31_4 >= TAFCFS && LA31_4 <= TAN)||(LA31_4 >= YEAR && LA31_4 <= 84)) ) {
									alt31=1;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return result;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 31, 4, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case IDENT:
								{
								int LA31_5 = input.LA(4);
								if ( ((LA31_5 >= 84 && LA31_5 <= 88)||LA31_5==90||LA31_5==92||LA31_5==99) ) {
									alt31=1;
								}
								else if ( (LA31_5==91) ) {
									alt31=2;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return result;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 31, 5, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case INTEGER:
								{
								int LA31_6 = input.LA(4);
								if ( ((LA31_6 >= 85 && LA31_6 <= 88)||LA31_6==90||LA31_6==92) ) {
									alt31=1;
								}
								else if ( (LA31_6==91) ) {
									alt31=2;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return result;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 31, 6, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							default:
								if (state.backtracking>0) {state.failed=true; return result;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 31, 3, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
						}
						else if ( ((LA31_2 >= 85 && LA31_2 <= 88)||LA31_2==90||LA31_2==92||LA31_2==99) ) {
							alt31=1;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return result;}
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 31, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return result;}
						NoViableAltException nvae =
							new NoViableAltException("", 31, 0, input);
						throw nvae;
					}

					switch (alt31) {
						case 1 :
							// ValueEvaluator.g:346:9: e2= expression
							{
							pushFollow(FOLLOW_expression_in_argFunction2171);
							e2=expression();
							state._fsp--;
							if (state.failed) return result;
							if ( state.backtracking==0 ) {ArrayList<IntDouble> idArray1=new ArrayList<IntDouble>(); idArray1.add((e2!=null?((ValueEvaluatorParser.expression_return)e2).id:null)); idArray.add(idArray1);}
							}
							break;
						case 2 :
							// ValueEvaluator.g:347:4: t2= trunk_timeArray
							{
							pushFollow(FOLLOW_trunk_timeArray_in_argFunction2179);
							t2=trunk_timeArray();
							state._fsp--;
							if (state.failed) return result;
							if ( state.backtracking==0 ) {idArray.add(t2);}
							}
							break;

					}

					}
					break;

				default :
					break loop32;
				}
			}

			match(input,85,FOLLOW_85_in_argFunction2185); if (state.failed) return result;
			// ValueEvaluator.g:347:57: ( '(' e0= expression ')' )?
			int alt33=2;
			int LA33_0 = input.LA(1);
			if ( (LA33_0==84) ) {
				alt33=1;
			}
			switch (alt33) {
				case 1 :
					// ValueEvaluator.g:347:58: '(' e0= expression ')'
					{
					match(input,84,FOLLOW_84_in_argFunction2188); if (state.failed) return result;
					pushFollow(FOLLOW_expression_in_argFunction2192);
					e0=expression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {id0Array.add((e0!=null?((ValueEvaluatorParser.expression_return)e0).id:null));}
					match(input,85,FOLLOW_85_in_argFunction2196); if (state.failed) return result;
					}
					break;

			}

			if ( state.backtracking==0 ) {
			    if (id0Array.size()==0) {
			      result=ValueEvaluation.argFunction((IDENT44!=null?IDENT44.getText():null),idArray);
			    }else{
			      result=ValueEvaluation.pastTSFV((IDENT44!=null?IDENT44.getText():null), (e0!=null?((ValueEvaluatorParser.expression_return)e0).id:null), idArray, prvs);
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
	// $ANTLR end "argFunction"



	// $ANTLR start "trunk_timeArray"
	// ValueEvaluator.g:356:1: trunk_timeArray returns [ArrayList<IntDouble> idArray] : i0= IDENT '(' (n1= integer |i1= IDENT ) ':' (n2= integer |i2= IDENT ) ')' ;
	public final ArrayList<IntDouble> trunk_timeArray() throws RecognitionException {
		ArrayList<IntDouble> idArray = null;


		Token i0=null;
		Token i1=null;
		Token i2=null;
		ParserRuleReturnScope n1 =null;
		ParserRuleReturnScope n2 =null;

		idArray = new ArrayList<IntDouble>(); IntDouble start=new IntDouble(1, true);  IntDouble end=new IntDouble(1, true);
		try {
			// ValueEvaluator.g:357:3: (i0= IDENT '(' (n1= integer |i1= IDENT ) ':' (n2= integer |i2= IDENT ) ')' )
			// ValueEvaluator.g:357:5: i0= IDENT '(' (n1= integer |i1= IDENT ) ':' (n2= integer |i2= IDENT ) ')'
			{
			i0=(Token)match(input,IDENT,FOLLOW_IDENT_in_trunk_timeArray2221); if (state.failed) return idArray;
			match(input,84,FOLLOW_84_in_trunk_timeArray2223); if (state.failed) return idArray;
			// ValueEvaluator.g:357:18: (n1= integer |i1= IDENT )
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==INTEGER||LA34_0==88) ) {
				alt34=1;
			}
			else if ( (LA34_0==IDENT) ) {
				alt34=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return idArray;}
				NoViableAltException nvae =
					new NoViableAltException("", 34, 0, input);
				throw nvae;
			}

			switch (alt34) {
				case 1 :
					// ValueEvaluator.g:357:19: n1= integer
					{
					pushFollow(FOLLOW_integer_in_trunk_timeArray2228);
					n1=integer();
					state._fsp--;
					if (state.failed) return idArray;
					if ( state.backtracking==0 ) {start=ValueEvaluation.term_INTEGER((n1!=null?input.toString(n1.start,n1.stop):null));}
					}
					break;
				case 2 :
					// ValueEvaluator.g:357:77: i1= IDENT
					{
					i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_trunk_timeArray2233); if (state.failed) return idArray;
					if ( state.backtracking==0 ) {start=ValueEvaluation.term_IDENT((i1!=null?i1.getText():null), sumIndex);}
					}
					break;

			}

			match(input,91,FOLLOW_91_in_trunk_timeArray2237); if (state.failed) return idArray;
			// ValueEvaluator.g:357:146: (n2= integer |i2= IDENT )
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==INTEGER||LA35_0==88) ) {
				alt35=1;
			}
			else if ( (LA35_0==IDENT) ) {
				alt35=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return idArray;}
				NoViableAltException nvae =
					new NoViableAltException("", 35, 0, input);
				throw nvae;
			}

			switch (alt35) {
				case 1 :
					// ValueEvaluator.g:357:147: n2= integer
					{
					pushFollow(FOLLOW_integer_in_trunk_timeArray2242);
					n2=integer();
					state._fsp--;
					if (state.failed) return idArray;
					if ( state.backtracking==0 ) {end=ValueEvaluation.term_INTEGER((n2!=null?input.toString(n2.start,n2.stop):null));}
					}
					break;
				case 2 :
					// ValueEvaluator.g:357:203: i2= IDENT
					{
					i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_trunk_timeArray2247); if (state.failed) return idArray;
					if ( state.backtracking==0 ) {end=ValueEvaluation.term_IDENT((i2!=null?i2.getText():null), sumIndex);}
					}
					break;

			}

			match(input,85,FOLLOW_85_in_trunk_timeArray2251); if (state.failed) return idArray;
			if ( state.backtracking==0 ) {
			    idArray=ValueEvaluation.trunk_timeArray((i0!=null?i0.getText():null), start, end);
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
		return idArray;
	}
	// $ANTLR end "trunk_timeArray"



	// $ANTLR start "unary"
	// ValueEvaluator.g:363:1: unary returns [IntDouble id] : (s= ( '+' | '-' ) )? term ;
	public final IntDouble unary() throws RecognitionException {
		IntDouble id = null;


		Token s=null;
		IntDouble term45 =null;

		try {
			// ValueEvaluator.g:364:2: ( (s= ( '+' | '-' ) )? term )
			// ValueEvaluator.g:364:4: (s= ( '+' | '-' ) )? term
			{
			// ValueEvaluator.g:364:4: (s= ( '+' | '-' ) )?
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( ((LA36_0 >= 87 && LA36_0 <= 88)) ) {
				alt36=1;
			}
			switch (alt36) {
				case 1 :
					// ValueEvaluator.g:364:5: s= ( '+' | '-' )
					{
					s=input.LT(1);
					if ( (input.LA(1) >= 87 && input.LA(1) <= 88) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return id;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			pushFollow(FOLLOW_term_in_unary2287);
			term45=term();
			state._fsp--;
			if (state.failed) return id;
			if ( state.backtracking==0 ) {id=ValueEvaluation.unary((s!=null?s.getText():null), term45);
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
		return id;
	}
	// $ANTLR end "unary"



	// $ANTLR start "allnumber"
	// ValueEvaluator.g:367:1: allnumber : ( '-' )? number ;
	public final void allnumber() throws RecognitionException {
		try {
			// ValueEvaluator.g:368:2: ( ( '-' )? number )
			// ValueEvaluator.g:368:4: ( '-' )? number
			{
			// ValueEvaluator.g:368:4: ( '-' )?
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==88) ) {
				alt37=1;
			}
			switch (alt37) {
				case 1 :
					// ValueEvaluator.g:368:5: '-'
					{
					match(input,88,FOLLOW_88_in_allnumber2300); if (state.failed) return;
					}
					break;

			}

			pushFollow(FOLLOW_number_in_allnumber2304);
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
	// ValueEvaluator.g:370:1: mult returns [IntDouble id] : (u1= unary ) (s= ( '*' | '/' ) (u2= unary ) )* ;
	public final IntDouble mult() throws RecognitionException {
		IntDouble id = null;


		Token s=null;
		IntDouble u1 =null;
		IntDouble u2 =null;

		try {
			// ValueEvaluator.g:371:2: ( (u1= unary ) (s= ( '*' | '/' ) (u2= unary ) )* )
			// ValueEvaluator.g:371:4: (u1= unary ) (s= ( '*' | '/' ) (u2= unary ) )*
			{
			// ValueEvaluator.g:371:4: (u1= unary )
			// ValueEvaluator.g:371:5: u1= unary
			{
			pushFollow(FOLLOW_unary_in_mult2322);
			u1=unary();
			state._fsp--;
			if (state.failed) return id;
			if ( state.backtracking==0 ) {id=u1;}
			}

			// ValueEvaluator.g:371:28: (s= ( '*' | '/' ) (u2= unary ) )*
			loop38:
			while (true) {
				int alt38=2;
				int LA38_0 = input.LA(1);
				if ( (LA38_0==86||LA38_0==90) ) {
					alt38=1;
				}

				switch (alt38) {
				case 1 :
					// ValueEvaluator.g:371:29: s= ( '*' | '/' ) (u2= unary )
					{
					s=input.LT(1);
					if ( input.LA(1)==86||input.LA(1)==90 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return id;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					// ValueEvaluator.g:371:42: (u2= unary )
					// ValueEvaluator.g:371:43: u2= unary
					{
					pushFollow(FOLLOW_unary_in_mult2340);
					u2=unary();
					state._fsp--;
					if (state.failed) return id;
					}

					if ( state.backtracking==0 ) {
						   if ((s!=null?s.getText():null).equals("*")){
						     id=ValueEvaluation.mult(id, u2);
						   }else{
						     id=ValueEvaluation.divide(id, u2);
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
		return id;
	}
	// $ANTLR end "mult"



	// $ANTLR start "add"
	// ValueEvaluator.g:380:1: add returns [IntDouble id] : (m1= mult ) ( (s= ( '+' | '-' ) ) (m2= mult ) )* ;
	public final IntDouble add() throws RecognitionException {
		IntDouble id = null;


		Token s=null;
		IntDouble m1 =null;
		IntDouble m2 =null;

		try {
			// ValueEvaluator.g:381:2: ( (m1= mult ) ( (s= ( '+' | '-' ) ) (m2= mult ) )* )
			// ValueEvaluator.g:381:4: (m1= mult ) ( (s= ( '+' | '-' ) ) (m2= mult ) )*
			{
			// ValueEvaluator.g:381:4: (m1= mult )
			// ValueEvaluator.g:381:5: m1= mult
			{
			pushFollow(FOLLOW_mult_in_add2364);
			m1=mult();
			state._fsp--;
			if (state.failed) return id;
			if ( state.backtracking==0 ) {id=m1;}
			}

			// ValueEvaluator.g:381:27: ( (s= ( '+' | '-' ) ) (m2= mult ) )*
			loop39:
			while (true) {
				int alt39=2;
				int LA39_0 = input.LA(1);
				if ( ((LA39_0 >= 87 && LA39_0 <= 88)) ) {
					alt39=1;
				}

				switch (alt39) {
				case 1 :
					// ValueEvaluator.g:381:28: (s= ( '+' | '-' ) ) (m2= mult )
					{
					// ValueEvaluator.g:381:28: (s= ( '+' | '-' ) )
					// ValueEvaluator.g:381:29: s= ( '+' | '-' )
					{
					s=input.LT(1);
					if ( (input.LA(1) >= 87 && input.LA(1) <= 88) ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return id;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}

					// ValueEvaluator.g:381:42: (m2= mult )
					// ValueEvaluator.g:381:43: m2= mult
					{
					pushFollow(FOLLOW_mult_in_add2383);
					m2=mult();
					state._fsp--;
					if (state.failed) return id;
					}

					if ( state.backtracking==0 ) {
					     if ((s!=null?s.getText():null).equals("+")){
					       id=ValueEvaluation.add(id, m2);
					     }else{
					       id=ValueEvaluation.substract(id, m2);
					     }
						}
					}
					break;

				default :
					break loop39;
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
		return id;
	}
	// $ANTLR end "add"


	public static class expression_return extends ParserRuleReturnScope {
		public IntDouble id;
	};


	// $ANTLR start "expression"
	// ValueEvaluator.g:390:1: expression returns [IntDouble id] : i= add ;
	public final ValueEvaluatorParser.expression_return expression() throws RecognitionException {
		ValueEvaluatorParser.expression_return retval = new ValueEvaluatorParser.expression_return();
		retval.start = input.LT(1);

		IntDouble i =null;

		try {
			// ValueEvaluator.g:391:2: (i= add )
			// ValueEvaluator.g:391:4: i= add
			{
			pushFollow(FOLLOW_add_in_expression2406);
			i=add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) {retval.id =i;}
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
	// ValueEvaluator.g:394:1: relation : ( '==' | '<' | '>' | '>=' | '<=' );
	public final ValueEvaluatorParser.relation_return relation() throws RecognitionException {
		ValueEvaluatorParser.relation_return retval = new ValueEvaluatorParser.relation_return();
		retval.start = input.LT(1);

		try {
			// ValueEvaluator.g:395:2: ( '==' | '<' | '>' | '>=' | '<=' )
			// ValueEvaluator.g:
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
	// ValueEvaluator.g:402:1: whereStatement returns [String whereIdent, Number value] : ( (i= IDENT ) | (u= usedKeywords ) ) '=' expression ;
	public final ValueEvaluatorParser.whereStatement_return whereStatement() throws RecognitionException {
		ValueEvaluatorParser.whereStatement_return retval = new ValueEvaluatorParser.whereStatement_return();
		retval.start = input.LT(1);

		Token i=null;
		ParserRuleReturnScope u =null;
		ParserRuleReturnScope expression46 =null;

		try {
			// ValueEvaluator.g:403:3: ( ( (i= IDENT ) | (u= usedKeywords ) ) '=' expression )
			// ValueEvaluator.g:403:5: ( (i= IDENT ) | (u= usedKeywords ) ) '=' expression
			{
			// ValueEvaluator.g:403:5: ( (i= IDENT ) | (u= usedKeywords ) )
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==IDENT) ) {
				alt40=1;
			}
			else if ( ((LA40_0 >= ABS && LA40_0 <= AND)||(LA40_0 >= ASIN && LA40_0 <= ATAN)||LA40_0==CASE||(LA40_0 >= CONDITION && LA40_0 <= DAYSINTIMESTEP)||(LA40_0 >= DVAR && LA40_0 <= FILE)||(LA40_0 >= FROM && LA40_0 <= GIVEN)||(LA40_0 >= INCLUDE && LA40_0 <= INT)||LA40_0==INTEGERTYPE||(LA40_0 >= LHSGTRHS && LA40_0 <= MONTH_RANGE)||(LA40_0 >= NAME && LA40_0 <= SUM)||(LA40_0 >= TAFCFS && LA40_0 <= WHERE)||LA40_0==YEAR) ) {
				alt40=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 40, 0, input);
				throw nvae;
			}

			switch (alt40) {
				case 1 :
					// ValueEvaluator.g:403:6: (i= IDENT )
					{
					// ValueEvaluator.g:403:6: (i= IDENT )
					// ValueEvaluator.g:403:7: i= IDENT
					{
					i=(Token)match(input,IDENT,FOLLOW_IDENT_in_whereStatement2461); if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.whereIdent =(i!=null?i.getText():null);}
					}

					}
					break;
				case 2 :
					// ValueEvaluator.g:403:38: (u= usedKeywords )
					{
					// ValueEvaluator.g:403:38: (u= usedKeywords )
					// ValueEvaluator.g:403:39: u= usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_whereStatement2468);
					u=usedKeywords();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.whereIdent =(u!=null?input.toString(u.start,u.stop):null);}
					}

					}
					break;

			}

			match(input,95,FOLLOW_95_in_whereStatement2473); if (state.failed) return retval;
			pushFollow(FOLLOW_expression_in_whereStatement2475);
			expression46=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) {retval.value =ValueEvaluation.assignWhereStatement((expression46!=null?((ValueEvaluatorParser.expression_return)expression46).id:null));}
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
	// ValueEvaluator.g:406:1: conditionStatement returns [boolean result] : ( (r= relationUnary ) | ALWAYS ) ;
	public final boolean conditionStatement() throws RecognitionException {
		boolean result = false;


		boolean r =false;

		try {
			// ValueEvaluator.g:407:2: ( ( (r= relationUnary ) | ALWAYS ) )
			// ValueEvaluator.g:407:4: ( (r= relationUnary ) | ALWAYS )
			{
			// ValueEvaluator.g:407:4: ( (r= relationUnary ) | ALWAYS )
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( ((LA41_0 >= ABS && LA41_0 <= ACOT)||(LA41_0 >= ARRAY_ITERATOR && LA41_0 <= ATAN)||(LA41_0 >= COS && LA41_0 <= COT)||(LA41_0 >= DAY && LA41_0 <= DAYSINTIMESTEP)||(LA41_0 >= EXCEEDANCE && LA41_0 <= EXP)||LA41_0==FLOAT||LA41_0==IDENT||(LA41_0 >= INT && LA41_0 <= INTEGER)||(LA41_0 >= LOG && LA41_0 <= LOG10)||(LA41_0 >= MAX && LA41_0 <= MONTH_CONST)||LA41_0==NOT||(LA41_0 >= PASTMONTH && LA41_0 <= ROUND)||LA41_0==SIN||LA41_0==SVAR||(LA41_0 >= TAFCFS && LA41_0 <= TAN)||(LA41_0 >= YEAR && LA41_0 <= 84)||(LA41_0 >= 87 && LA41_0 <= 88)) ) {
				alt41=1;
			}
			else if ( (LA41_0==ALWAYS) ) {
				alt41=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 41, 0, input);
				throw nvae;
			}

			switch (alt41) {
				case 1 :
					// ValueEvaluator.g:407:5: (r= relationUnary )
					{
					// ValueEvaluator.g:407:5: (r= relationUnary )
					// ValueEvaluator.g:407:6: r= relationUnary
					{
					pushFollow(FOLLOW_relationUnary_in_conditionStatement2497);
					r=relationUnary();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result=r;}
					}

					}
					break;
				case 2 :
					// ValueEvaluator.g:407:42: ALWAYS
					{
					match(input,ALWAYS,FOLLOW_ALWAYS_in_conditionStatement2501); if (state.failed) return result;
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
	// ValueEvaluator.g:410:1: relationUnary returns [boolean result] : (n= NOT )? r= relationOr ;
	public final boolean relationUnary() throws RecognitionException {
		boolean result = false;


		Token n=null;
		boolean r =false;

		try {
			// ValueEvaluator.g:411:3: ( (n= NOT )? r= relationOr )
			// ValueEvaluator.g:411:5: (n= NOT )? r= relationOr
			{
			// ValueEvaluator.g:411:5: (n= NOT )?
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==NOT) ) {
				alt42=1;
			}
			switch (alt42) {
				case 1 :
					// ValueEvaluator.g:411:6: n= NOT
					{
					n=(Token)match(input,NOT,FOLLOW_NOT_in_relationUnary2522); if (state.failed) return result;
					}
					break;

			}

			pushFollow(FOLLOW_relationOr_in_relationUnary2528);
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
	// ValueEvaluator.g:424:1: relationOr returns [boolean result] : r1= relationAnd (s= OR r2= relationAnd )* ;
	public final boolean relationOr() throws RecognitionException {
		boolean result = false;


		Token s=null;
		boolean r1 =false;
		boolean r2 =false;

		try {
			// ValueEvaluator.g:425:3: (r1= relationAnd (s= OR r2= relationAnd )* )
			// ValueEvaluator.g:425:5: r1= relationAnd (s= OR r2= relationAnd )*
			{
			pushFollow(FOLLOW_relationAnd_in_relationOr2551);
			r1=relationAnd();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {result=r1;}
			// ValueEvaluator.g:426:5: (s= OR r2= relationAnd )*
			loop43:
			while (true) {
				int alt43=2;
				int LA43_0 = input.LA(1);
				if ( (LA43_0==OR) ) {
					alt43=1;
				}

				switch (alt43) {
				case 1 :
					// ValueEvaluator.g:426:6: s= OR r2= relationAnd
					{
					s=(Token)match(input,OR,FOLLOW_OR_in_relationOr2563); if (state.failed) return result;
					pushFollow(FOLLOW_relationAnd_in_relationOr2567);
					r2=relationAnd();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result=ValueEvaluation.relationStatementSeries(result, r2, (s!=null?s.getText():null));}
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
	// $ANTLR end "relationOr"



	// $ANTLR start "relationAnd"
	// ValueEvaluator.g:428:1: relationAnd returns [boolean result] : r1= relationRangeStatement (s= AND r2= relationRangeStatement )* ;
	public final boolean relationAnd() throws RecognitionException {
		boolean result = false;


		Token s=null;
		boolean r1 =false;
		boolean r2 =false;

		try {
			// ValueEvaluator.g:429:3: (r1= relationRangeStatement (s= AND r2= relationRangeStatement )* )
			// ValueEvaluator.g:429:5: r1= relationRangeStatement (s= AND r2= relationRangeStatement )*
			{
			pushFollow(FOLLOW_relationRangeStatement_in_relationAnd2589);
			r1=relationRangeStatement();
			state._fsp--;
			if (state.failed) return result;
			if ( state.backtracking==0 ) {result=r1;}
			// ValueEvaluator.g:430:5: (s= AND r2= relationRangeStatement )*
			loop44:
			while (true) {
				int alt44=2;
				int LA44_0 = input.LA(1);
				if ( (LA44_0==AND) ) {
					alt44=1;
				}

				switch (alt44) {
				case 1 :
					// ValueEvaluator.g:430:6: s= AND r2= relationRangeStatement
					{
					s=(Token)match(input,AND,FOLLOW_AND_in_relationAnd2601); if (state.failed) return result;
					pushFollow(FOLLOW_relationRangeStatement_in_relationAnd2605);
					r2=relationRangeStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result=ValueEvaluation.relationStatementSeries(result, r2, (s!=null?s.getText():null));}
					}
					break;

				default :
					break loop44;
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
	// ValueEvaluator.g:432:1: relationRangeStatement returns [boolean result] : ( (r1= relationStatement ) | (r2= range_func ) );
	public final boolean relationRangeStatement() throws RecognitionException {
		boolean result = false;


		boolean r1 =false;
		boolean r2 =false;

		try {
			// ValueEvaluator.g:433:3: ( (r1= relationStatement ) | (r2= range_func ) )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( ((LA45_0 >= ABS && LA45_0 <= ACOT)||(LA45_0 >= ARRAY_ITERATOR && LA45_0 <= ATAN)||(LA45_0 >= COS && LA45_0 <= COT)||(LA45_0 >= DAY && LA45_0 <= DAYSINTIMESTEP)||(LA45_0 >= EXCEEDANCE && LA45_0 <= EXP)||LA45_0==FLOAT||LA45_0==IDENT||(LA45_0 >= INT && LA45_0 <= INTEGER)||(LA45_0 >= LOG && LA45_0 <= LOG10)||(LA45_0 >= MAX && LA45_0 <= MONTH_CONST)||(LA45_0 >= PASTMONTH && LA45_0 <= POW)||(LA45_0 >= REAL && LA45_0 <= ROUND)||LA45_0==SIN||LA45_0==SVAR||(LA45_0 >= TAFCFS && LA45_0 <= TAN)||(LA45_0 >= YEAR && LA45_0 <= 84)||(LA45_0 >= 87 && LA45_0 <= 88)) ) {
				alt45=1;
			}
			else if ( (LA45_0==RANGE) ) {
				alt45=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return result;}
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}

			switch (alt45) {
				case 1 :
					// ValueEvaluator.g:433:5: (r1= relationStatement )
					{
					// ValueEvaluator.g:433:5: (r1= relationStatement )
					// ValueEvaluator.g:433:6: r1= relationStatement
					{
					pushFollow(FOLLOW_relationStatement_in_relationRangeStatement2627);
					r1=relationStatement();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result=r1;}
					}

					}
					break;
				case 2 :
					// ValueEvaluator.g:433:48: (r2= range_func )
					{
					// ValueEvaluator.g:433:48: (r2= range_func )
					// ValueEvaluator.g:433:49: r2= range_func
					{
					pushFollow(FOLLOW_range_func_in_relationRangeStatement2634);
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
	// ValueEvaluator.g:436:1: relationStatement returns [boolean result] : ( ( ( expression relation expression )=>e1= expression relation e2= expression ) | ( ( '(' relationUnary ')' )=> '(' r2= relationUnary ')' ) );
	public final boolean relationStatement() throws RecognitionException {
		boolean result = false;


		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;
		boolean r2 =false;
		ParserRuleReturnScope relation47 =null;

		try {
			// ValueEvaluator.g:437:2: ( ( ( expression relation expression )=>e1= expression relation e2= expression ) | ( ( '(' relationUnary ')' )=> '(' r2= relationUnary ')' ) )
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( ((LA46_0 >= 87 && LA46_0 <= 88)) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==IDENT) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==FLOAT) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==84) ) {
				int LA46_4 = input.LA(2);
				if ( (synpred1_ValueEvaluator()) ) {
					alt46=1;
				}
				else if ( (synpred2_ValueEvaluator()) ) {
					alt46=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return result;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 46, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA46_0==MAX) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==MIN) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==INT) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==REAL) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==ABS) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==EXP) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==LOG) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==LOG10) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==POW) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==MOD) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==ROUND) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==SIN) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==COS) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==TAN) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==COT) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==ASIN) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==ACOS) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==ATAN) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==ACOT) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==EXCEEDANCE) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==EXCEEDANCE_TSI) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==INTEGER) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==TAFCFS) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==YEAR) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==MONTH) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==DAY) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==MONTH_CONST) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==PASTMONTH) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==DAYSIN) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==DAYSINTIMESTEP) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==SVAR) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}
			else if ( (LA46_0==ARRAY_ITERATOR) && (synpred1_ValueEvaluator())) {
				alt46=1;
			}

			switch (alt46) {
				case 1 :
					// ValueEvaluator.g:437:4: ( ( expression relation expression )=>e1= expression relation e2= expression )
					{
					// ValueEvaluator.g:437:4: ( ( expression relation expression )=>e1= expression relation e2= expression )
					// ValueEvaluator.g:437:6: ( expression relation expression )=>e1= expression relation e2= expression
					{
					pushFollow(FOLLOW_expression_in_relationStatement2668);
					e1=expression();
					state._fsp--;
					if (state.failed) return result;
					pushFollow(FOLLOW_relation_in_relationStatement2670);
					relation47=relation();
					state._fsp--;
					if (state.failed) return result;
					pushFollow(FOLLOW_expression_in_relationStatement2674);
					e2=expression();
					state._fsp--;
					if (state.failed) return result;
					if ( state.backtracking==0 ) {result=ValueEvaluation.relationStatement((e1!=null?((ValueEvaluatorParser.expression_return)e1).id:null), (e2!=null?((ValueEvaluatorParser.expression_return)e2).id:null), (relation47!=null?input.toString(relation47.start,relation47.stop):null));}
					}

					}
					break;
				case 2 :
					// ValueEvaluator.g:438:4: ( ( '(' relationUnary ')' )=> '(' r2= relationUnary ')' )
					{
					// ValueEvaluator.g:438:4: ( ( '(' relationUnary ')' )=> '(' r2= relationUnary ')' )
					// ValueEvaluator.g:438:6: ( '(' relationUnary ')' )=> '(' r2= relationUnary ')'
					{
					match(input,84,FOLLOW_84_in_relationStatement2696); if (state.failed) return result;
					pushFollow(FOLLOW_relationUnary_in_relationStatement2699);
					r2=relationUnary();
					state._fsp--;
					if (state.failed) return result;
					match(input,85,FOLLOW_85_in_relationStatement2700); if (state.failed) return result;
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


	public static class assignStatement_return extends ParserRuleReturnScope {
		public String assignIdent;
		public Number value;
	};


	// $ANTLR start "assignStatement"
	// ValueEvaluator.g:441:1: assignStatement returns [String assignIdent, Number value] : IDENT '=' expression ;
	public final ValueEvaluatorParser.assignStatement_return assignStatement() throws RecognitionException {
		ValueEvaluatorParser.assignStatement_return retval = new ValueEvaluatorParser.assignStatement_return();
		retval.start = input.LT(1);

		Token IDENT48=null;
		ParserRuleReturnScope expression49 =null;

		try {
			// ValueEvaluator.g:442:3: ( IDENT '=' expression )
			// ValueEvaluator.g:442:5: IDENT '=' expression
			{
			IDENT48=(Token)match(input,IDENT,FOLLOW_IDENT_in_assignStatement2722); if (state.failed) return retval;
			match(input,95,FOLLOW_95_in_assignStatement2724); if (state.failed) return retval;
			pushFollow(FOLLOW_expression_in_assignStatement2726);
			expression49=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) {retval.assignIdent =(IDENT48!=null?IDENT48.getText():null); retval.value =ValueEvaluation.assignWhereStatement((expression49!=null?((ValueEvaluatorParser.expression_return)expression49).id:null));}
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
	// ValueEvaluator.g:445:1: number : ( INTEGER | FLOAT );
	public final void number() throws RecognitionException {
		try {
			// ValueEvaluator.g:446:2: ( INTEGER | FLOAT )
			// ValueEvaluator.g:
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
	// ValueEvaluator.g:450:1: integer : ( integer_p | integer_n );
	public final ValueEvaluatorParser.integer_return integer() throws RecognitionException {
		ValueEvaluatorParser.integer_return retval = new ValueEvaluatorParser.integer_return();
		retval.start = input.LT(1);

		try {
			// ValueEvaluator.g:450:9: ( integer_p | integer_n )
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
					// ValueEvaluator.g:450:11: integer_p
					{
					pushFollow(FOLLOW_integer_p_in_integer2757);
					integer_p();
					state._fsp--;
					if (state.failed) return retval;
					}
					break;
				case 2 :
					// ValueEvaluator.g:450:21: integer_n
					{
					pushFollow(FOLLOW_integer_n_in_integer2759);
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
	// ValueEvaluator.g:451:1: integer_p : INTEGER ;
	public final void integer_p() throws RecognitionException {
		try {
			// ValueEvaluator.g:451:11: ( INTEGER )
			// ValueEvaluator.g:451:13: INTEGER
			{
			match(input,INTEGER,FOLLOW_INTEGER_in_integer_p2767); if (state.failed) return;
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
	// ValueEvaluator.g:452:1: integer_n : '-' INTEGER ;
	public final void integer_n() throws RecognitionException {
		try {
			// ValueEvaluator.g:452:11: ( '-' INTEGER )
			// ValueEvaluator.g:452:13: '-' INTEGER
			{
			match(input,88,FOLLOW_88_in_integer_n2775); if (state.failed) return;
			match(input,INTEGER,FOLLOW_INTEGER_in_integer_n2777); if (state.failed) return;
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

	// $ANTLR start synpred1_ValueEvaluator
	public final void synpred1_ValueEvaluator_fragment() throws RecognitionException {
		// ValueEvaluator.g:437:6: ( expression relation expression )
		// ValueEvaluator.g:437:8: expression relation expression
		{
		pushFollow(FOLLOW_expression_in_synpred1_ValueEvaluator2657);
		expression();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_relation_in_synpred1_ValueEvaluator2659);
		relation();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_expression_in_synpred1_ValueEvaluator2661);
		expression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred1_ValueEvaluator

	// $ANTLR start synpred2_ValueEvaluator
	public final void synpred2_ValueEvaluator_fragment() throws RecognitionException {
		// ValueEvaluator.g:438:6: ( '(' relationUnary ')' )
		// ValueEvaluator.g:438:8: '(' relationUnary ')'
		{
		match(input,84,FOLLOW_84_in_synpred2_ValueEvaluator2687); if (state.failed) return;
		pushFollow(FOLLOW_relationUnary_in_synpred2_ValueEvaluator2688);
		relationUnary();
		state._fsp--;
		if (state.failed) return;
		match(input,85,FOLLOW_85_in_synpred2_ValueEvaluator2689); if (state.failed) return;
		}

	}
	// $ANTLR end synpred2_ValueEvaluator

	// Delegated rules

	public final boolean synpred1_ValueEvaluator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_ValueEvaluator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred2_ValueEvaluator() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_ValueEvaluator_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_expressionInput_in_evaluator50 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditionInput_in_evaluator56 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_104_in_expressionInput70 = new BitSet(new long[]{0x80FD862139D81C70L,0x00000080019846FDL});
	public static final BitSet FOLLOW_expressionCollection_in_expressionInput72 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_101_in_conditionInput79 = new BitSet(new long[]{0x88F9862139D81D70L,0x00000000019806AFL});
	public static final BitSet FOLLOW_conditionStatement_in_conditionInput81 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_lhsrhs93 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONSTRAIN_in_lhsrhs95 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_units104 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_units107 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_units109 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_units111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_91_in_fileName123 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000002001B8BFF7FL});
	public static final BitSet FOLLOW_92_in_fileName125 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000002001B8BFF7FL});
	public static final BitSet FOLLOW_89_in_fileName127 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000002001B8BFF7FL});
	public static final BitSet FOLLOW_105_in_fileName129 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000002001B8BFF7FL});
	public static final BitSet FOLLOW_SYMBOLS_in_fileName131 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000002001B8BFF7FL});
	public static final BitSet FOLLOW_88_in_fileName133 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000002001B8BFF7FL});
	public static final BitSet FOLLOW_87_in_fileName135 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000002001B8BFF7FL});
	public static final BitSet FOLLOW_BACKSLASH_in_fileName137 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000002001B8BFF7FL});
	public static final BitSet FOLLOW_IDENT_in_fileName139 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000002001B8BFF7FL});
	public static final BitSet FOLLOW_IDENT1_in_fileName141 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000002001B8BFF7FL});
	public static final BitSet FOLLOW_IDENT2_in_fileName143 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000002001B8BFF7FL});
	public static final BitSet FOLLOW_INTEGER_in_fileName145 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000002001B8BFF7FL});
	public static final BitSet FOLLOW_FLOAT_in_fileName147 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000002001B8BFF7FL});
	public static final BitSet FOLLOW_usedKeywords_in_fileName149 = new BitSet(new long[]{0xFDFFEFFFFDFF7BF2L,0x000002001B8BFF7FL});
	public static final BitSet FOLLOW_92_in_externalFile168 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000200138BFF7FL});
	public static final BitSet FOLLOW_89_in_externalFile170 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000200138BFF7FL});
	public static final BitSet FOLLOW_105_in_externalFile172 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000200138BFF7FL});
	public static final BitSet FOLLOW_SYMBOLS_in_externalFile174 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000200138BFF7FL});
	public static final BitSet FOLLOW_88_in_externalFile176 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000200138BFF7FL});
	public static final BitSet FOLLOW_87_in_externalFile178 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000200138BFF7FL});
	public static final BitSet FOLLOW_INTEGER_in_externalFile180 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000200138BFF7FL});
	public static final BitSet FOLLOW_FLOAT_in_externalFile182 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000200138BFF7FL});
	public static final BitSet FOLLOW_IDENT_in_externalFile184 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000200138BFF7FL});
	public static final BitSet FOLLOW_usedKeywords_in_externalFile186 = new BitSet(new long[]{0xFDFFEF3FFDFF5BF2L,0x00000200138BFF7FL});
	public static final BitSet FOLLOW_LETTER_in_text200 = new BitSet(new long[]{0x0000100002000002L});
	public static final BitSet FOLLOW_expression_in_expressionCollection224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tableSQL_in_expressionCollection231 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timeseriesWithUnits_in_expressionCollection238 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timeseries_in_expressionCollection245 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sumExpression_in_expressionCollection253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPPERUNBOUNDED_in_expressionCollection260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOWERUNBOUNDED_in_expressionCollection267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_max_func_in_func285 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_min_func_in_func293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_int_func_in_func301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_real_func_in_func309 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_abs_func_in_func317 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_func_in_func325 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_log_func_in_func333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_log10_func_in_func341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pow_func_in_func349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mod_func_in_func357 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_round_func_in_func365 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sin_func_in_func373 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cos_func_in_func381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tan_func_in_func389 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_cot_func_in_func397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_asin_func_in_func405 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_acos_func_in_func413 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atan_func_in_func421 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_acot_func_in_func429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exceedFunc_in_func437 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exceedtsiFunc_in_func445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ROUND_in_round_func460 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_round_func462 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_round_func467 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_round_func470 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_mod_func487 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_mod_func489 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_mod_func494 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_mod_func498 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_mod_func503 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_mod_func507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAX_in_max_func524 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_max_func526 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_max_func531 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_max_func535 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_max_func540 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
	public static final BitSet FOLLOW_85_in_max_func546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MIN_in_min_func560 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_min_func562 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_min_func567 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_min_func571 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_min_func576 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
	public static final BitSet FOLLOW_85_in_min_func582 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_int_func598 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_int_func600 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_int_func605 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_int_func608 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REAL_in_real_func627 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_real_func629 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_real_func634 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_real_func637 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ABS_in_abs_func656 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_abs_func658 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_abs_func663 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_abs_func666 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXP_in_exp_func683 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_exp_func685 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_exp_func690 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_exp_func693 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOG_in_log_func712 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_log_func714 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_log_func719 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_log_func722 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOG10_in_log10_func739 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_log10_func741 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_log10_func746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_log10_func749 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_POW_in_pow_func768 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_pow_func770 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_pow_func775 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_pow_func779 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_pow_func784 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_pow_func788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SIN_in_sin_func805 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_sin_func807 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_sin_func812 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_sin_func815 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COS_in_cos_func832 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_cos_func834 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_cos_func839 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_cos_func842 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TAN_in_tan_func861 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_tan_func863 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_tan_func868 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_tan_func871 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COT_in_cot_func890 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_cot_func892 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_cot_func897 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_cot_func900 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASIN_in_asin_func917 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_asin_func919 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_asin_func924 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_asin_func927 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACOS_in_acos_func944 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_acos_func946 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_acos_func951 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_acos_func954 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATAN_in_atan_func973 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_atan_func975 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_atan_func980 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_atan_func983 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACOT_in_acot_func1002 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_acot_func1004 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_acot_func1009 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_acot_func1012 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXCEEDANCE_in_exceedFunc1031 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_exceedFunc1033 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_exceedFunc1037 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1039 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000001806ADL});
	public static final BitSet FOLLOW_term_in_exceedFunc1043 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1045 = new BitSet(new long[]{0x0180000000000080L});
	public static final BitSet FOLLOW_MONTH_CONST_in_exceedFunc1050 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_MONTH_RANGE_in_exceedFunc1054 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_ALL_in_exceedFunc1058 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1061 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedFunc1065 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1067 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_exceedFunc1071 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1073 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedFunc1077 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1079 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedFunc1083 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1085 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_exceedFunc1089 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedFunc1091 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedFunc1095 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_exceedFunc1097 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXCEEDANCE_TSI_in_exceedtsiFunc1119 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_exceedtsiFunc1121 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_exceedtsiFunc1125 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1127 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000001806ADL});
	public static final BitSet FOLLOW_term_in_exceedtsiFunc1131 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1133 = new BitSet(new long[]{0x0180000000000080L});
	public static final BitSet FOLLOW_MONTH_CONST_in_exceedtsiFunc1138 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_MONTH_RANGE_in_exceedtsiFunc1142 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_ALL_in_exceedtsiFunc1146 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1149 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedtsiFunc1153 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1155 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_exceedtsiFunc1159 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1161 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedtsiFunc1165 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1167 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedtsiFunc1171 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1173 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_exceedtsiFunc1177 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_exceedtsiFunc1179 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_exceedtsiFunc1183 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_exceedtsiFunc1185 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANGE_in_range_func1208 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_range_func1210 = new BitSet(new long[]{0x0040000000000000L});
	public static final BitSet FOLLOW_MONTH_in_range_func1212 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_range_func1214 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_range_func1218 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_range_func1220 = new BitSet(new long[]{0x0080000000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_range_func1224 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_range_func1226 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_timeseriesWithUnits1238 = new BitSet(new long[]{0x0000000000000000L,0x0000004000000000L});
	public static final BitSet FOLLOW_102_in_timeseriesWithUnits1240 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_timeseriesWithUnits1242 = new BitSet(new long[]{0xFDFFEB7EFDFF5BF0L,0x00000000000BFE7FL});
	public static final BitSet FOLLOW_partC_in_timeseriesWithUnits1244 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_UNITS_in_timeseriesWithUnits1246 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_timeseriesWithUnits1248 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_timeseriesWithUnits1250 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_timeseries1266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_partC1283 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_IDENT1_in_partC1285 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_usedKeywords_in_partC1287 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_partC1291 = new BitSet(new long[]{0xFDFFEB7EFDFF5BF0L,0x00000000000BFE7FL});
	public static final BitSet FOLLOW_IDENT_in_partC1294 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_IDENT1_in_partC1296 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_usedKeywords_in_partC1298 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
	public static final BitSet FOLLOW_SELECT_in_tableSQL1460 = new BitSet(new long[]{0xFDFFEB3EFDFF5BF0L,0x00000000000BFE7FL});
	public static final BitSet FOLLOW_IDENT_in_tableSQL1466 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_usedKeywords_in_tableSQL1473 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_FROM_in_tableSQL1478 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_tableSQL1482 = new BitSet(new long[]{0x0000001000000002L,0x0000000000028000L});
	public static final BitSet FOLLOW_GIVEN_in_tableSQL1490 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_assignStatement_in_tableSQL1494 = new BitSet(new long[]{0x0000000000000002L,0x0000000000028000L});
	public static final BitSet FOLLOW_USE_in_tableSQL1500 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_tableSQL1504 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
	public static final BitSet FOLLOW_where_items_in_tableSQL1514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_where_items1538 = new BitSet(new long[]{0xFDFFEB3EFDFF5BF0L,0x00000000000BFE7FL});
	public static final BitSet FOLLOW_whereStatement_in_where_items1544 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_where_items1558 = new BitSet(new long[]{0xFDFFEB3EFDFF5BF0L,0x00000000000BFE7FL});
	public static final BitSet FOLLOW_whereStatement_in_where_items1562 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
	public static final BitSet FOLLOW_IDENT_in_upperbound1575 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_allnumber_in_upperbound1577 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_allnumber_in_upperbound1580 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_86_in_upperbound1582 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_TAFCFS_in_upperbound1584 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_lowerbound1592 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_allnumber_in_lowerbound1594 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_allnumber_in_lowerbound1597 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_86_in_lowerbound1599 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
	public static final BitSet FOLLOW_TAFCFS_in_lowerbound1601 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SUM_in_sumExpression1631 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_sumExpression1633 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_sumExpression1635 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_sumExpression1638 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_sumExpression1642 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_92_in_sumExpression1644 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_sumExpression1648 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
	public static final BitSet FOLLOW_92_in_sumExpression1651 = new BitSet(new long[]{0x0000040000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_sumExpression1655 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_sumExpression1660 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_sumExpression1668 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_sumExpression1675 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_term1693 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_term1702 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_term1712 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_term1717 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_term1720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_knownTS_in_term1729 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_in_term1737 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_term1744 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tafcfs_term_in_term1752 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_YEAR_in_term1758 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONTH_in_term1764 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DAY_in_term1770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONTH_CONST_in_term1777 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PASTMONTH_in_term1783 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DAYSIN_in_term1789 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DAYSINTIMESTEP_in_term1795 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SVAR_in_term1802 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ARRAY_ITERATOR_in_term1809 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_term1816 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_sumExpression_in_term1818 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_term1820 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TAFCFS_in_tafcfs_term1836 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_tafcfs_term1839 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_tafcfs_term1841 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_tafcfs_term1843 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_knownTS1867 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pastCycleValue_in_knownTS1874 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pastCycleNoTimeArray_in_pastCycleValue1902 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pastCycleTimeArray_in_pastCycleValue1909 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pastCycleIndexNoTimeArray_in_pastCycleValue1916 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pastCycleIndexTimeArray_in_pastCycleValue1923 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleNoTimeArray1944 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_pastCycleNoTimeArray1946 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleNoTimeArray1950 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_pastCycleNoTimeArray1952 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleTimeArray1975 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_pastCycleTimeArray1977 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleTimeArray1981 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_pastCycleTimeArray1983 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_pastCycleTimeArray1985 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_pastCycleTimeArray1989 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_pastCycleTimeArray1991 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleIndexNoTimeArray2015 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_pastCycleIndexNoTimeArray2017 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_pastCycleIndexNoTimeArray2020 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_pastCycleIndexNoTimeArray2024 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_pastCycleIndexNoTimeArray2027 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleIndexTimeArray2050 = new BitSet(new long[]{0x0000000000000000L,0x0000000800000000L});
	public static final BitSet FOLLOW_99_in_pastCycleIndexTimeArray2052 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_88_in_pastCycleIndexTimeArray2054 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_pastCycleIndexTimeArray2058 = new BitSet(new long[]{0x0000000000000000L,0x0000001000000000L});
	public static final BitSet FOLLOW_100_in_pastCycleIndexTimeArray2060 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_pastCycleIndexTimeArray2062 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_pastCycleIndexTimeArray2066 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_pastCycleIndexTimeArray2068 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_noArgFunction_in_function2090 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_argFunction_in_function2097 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_noArgFunction2116 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_noArgFunction2118 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_noArgFunction2120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_argFunction2140 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_argFunction2142 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_argFunction2147 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
	public static final BitSet FOLLOW_trunk_timeArray_in_argFunction2158 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
	public static final BitSet FOLLOW_92_in_argFunction2166 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_argFunction2171 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
	public static final BitSet FOLLOW_trunk_timeArray_in_argFunction2179 = new BitSet(new long[]{0x0000000000000000L,0x0000000010200000L});
	public static final BitSet FOLLOW_85_in_argFunction2185 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_argFunction2188 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_argFunction2192 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_argFunction2196 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_trunk_timeArray2221 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
	public static final BitSet FOLLOW_84_in_trunk_timeArray2223 = new BitSet(new long[]{0x0000042000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_integer_in_trunk_timeArray2228 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_IDENT_in_trunk_timeArray2233 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_91_in_trunk_timeArray2237 = new BitSet(new long[]{0x0000042000000000L,0x0000000001000000L});
	public static final BitSet FOLLOW_integer_in_trunk_timeArray2242 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_IDENT_in_trunk_timeArray2247 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_trunk_timeArray2251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_unary2279 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000001806ADL});
	public static final BitSet FOLLOW_term_in_unary2287 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_88_in_allnumber2300 = new BitSet(new long[]{0x0000040100000000L});
	public static final BitSet FOLLOW_number_in_allnumber2304 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unary_in_mult2322 = new BitSet(new long[]{0x0000000000000002L,0x0000000004400000L});
	public static final BitSet FOLLOW_set_in_mult2330 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_unary_in_mult2340 = new BitSet(new long[]{0x0000000000000002L,0x0000000004400000L});
	public static final BitSet FOLLOW_mult_in_add2364 = new BitSet(new long[]{0x0000000000000002L,0x0000000001800000L});
	public static final BitSet FOLLOW_set_in_add2373 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_mult_in_add2383 = new BitSet(new long[]{0x0000000000000002L,0x0000000001800000L});
	public static final BitSet FOLLOW_add_in_expression2406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_whereStatement2461 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_usedKeywords_in_whereStatement2468 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_whereStatement2473 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_whereStatement2475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_relationUnary_in_conditionStatement2497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALWAYS_in_conditionStatement2501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_relationUnary2522 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806AFL});
	public static final BitSet FOLLOW_relationOr_in_relationUnary2528 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_relationAnd_in_relationOr2551 = new BitSet(new long[]{0x1000000000000002L});
	public static final BitSet FOLLOW_OR_in_relationOr2563 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806AFL});
	public static final BitSet FOLLOW_relationAnd_in_relationOr2567 = new BitSet(new long[]{0x1000000000000002L});
	public static final BitSet FOLLOW_relationRangeStatement_in_relationAnd2589 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_AND_in_relationAnd2601 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806AFL});
	public static final BitSet FOLLOW_relationRangeStatement_in_relationAnd2605 = new BitSet(new long[]{0x0000000000000202L});
	public static final BitSet FOLLOW_relationStatement_in_relationRangeStatement2627 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_range_func_in_relationRangeStatement2634 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_relationStatement2668 = new BitSet(new long[]{0x0000000000000000L,0x0000000760000000L});
	public static final BitSet FOLLOW_relation_in_relationStatement2670 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_relationStatement2674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_relationStatement2696 = new BitSet(new long[]{0x88F9862139D81C70L,0x00000000019806AFL});
	public static final BitSet FOLLOW_relationUnary_in_relationStatement2699 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_relationStatement2700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_assignStatement2722 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_95_in_assignStatement2724 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_assignStatement2726 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_p_in_integer2757 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_n_in_integer2759 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_integer_p2767 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_88_in_integer_n2775 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_INTEGER_in_integer_n2777 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_synpred1_ValueEvaluator2657 = new BitSet(new long[]{0x0000000000000000L,0x0000000760000000L});
	public static final BitSet FOLLOW_relation_in_synpred1_ValueEvaluator2659 = new BitSet(new long[]{0x80F9862139D81C70L,0x00000000019806ADL});
	public static final BitSet FOLLOW_expression_in_synpred1_ValueEvaluator2661 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_84_in_synpred2_ValueEvaluator2687 = new BitSet(new long[]{0x88F9862139D81C70L,0x00000000019806AFL});
	public static final BitSet FOLLOW_relationUnary_in_synpred2_ValueEvaluator2688 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_synpred2_ValueEvaluator2689 = new BitSet(new long[]{0x0000000000000002L});
}
