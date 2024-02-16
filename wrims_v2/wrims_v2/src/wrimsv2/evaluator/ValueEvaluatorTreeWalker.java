// $ANTLR 3.5.2 ValueEvaluatorTreeWalker.g 2024-02-12 13:09:24

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
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ValueEvaluatorTreeWalker extends TreeParser {
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
		"'=='", "'>'", "'>='", "'['", "']'", "'c:'", "'v:'", "'|'", "'kind'", 
		"'units'"
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
	public static final int T__89=89;
	public static final int T__90=90;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public ValueEvaluatorTreeWalker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public ValueEvaluatorTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ValueEvaluatorTreeWalker.tokenNames; }
	@Override public String getGrammarFileName() { return "ValueEvaluatorTreeWalker.g"; }


	  public static IntDouble evalValue;
	  public static boolean evalCondition;
	    public Stack<LoopIndex> sumIndex= new Stack <LoopIndex>();
	  
	  @Override
	  public void reportError(RecognitionException e) {
	       Error.addEvaluationError(getErrorMessage(e, tokenNames));
	  }



	// $ANTLR start "evaluator"
	// ValueEvaluatorTreeWalker.g:34:1: evaluator : ( expressionInput | conditionInput );
	public final void evaluator() throws RecognitionException {
		try {
			// ValueEvaluatorTreeWalker.g:35:3: ( expressionInput | conditionInput )
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
					// ValueEvaluatorTreeWalker.g:35:5: expressionInput
					{
					pushFollow(FOLLOW_expressionInput_in_evaluator55);
					expressionInput();
					state._fsp--;

					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:36:5: conditionInput
					{
					pushFollow(FOLLOW_conditionInput_in_evaluator63);
					conditionInput();
					state._fsp--;

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
	// $ANTLR end "evaluator"



	// $ANTLR start "expressionInput"
	// ValueEvaluatorTreeWalker.g:43:1: expressionInput : ^( 'v:' expressionCollection ) ;
	public final void expressionInput() throws RecognitionException {
		IntDouble expressionCollection1 =null;

		try {
			// ValueEvaluatorTreeWalker.g:43:16: ( ^( 'v:' expressionCollection ) )
			// ValueEvaluatorTreeWalker.g:43:18: ^( 'v:' expressionCollection )
			{
			match(input,87,FOLLOW_87_in_expressionInput79); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_expressionCollection_in_expressionInput81);
			expressionCollection1=expressionCollection();
			state._fsp--;

			match(input, Token.UP, null); 

			evalValue=expressionCollection1;
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
	// ValueEvaluatorTreeWalker.g:44:1: conditionInput : ^( 'c:' conditionStatement ) ;
	public final void conditionInput() throws RecognitionException {
		boolean conditionStatement2 =false;

		try {
			// ValueEvaluatorTreeWalker.g:44:15: ( ^( 'c:' conditionStatement ) )
			// ValueEvaluatorTreeWalker.g:44:17: ^( 'c:' conditionStatement )
			{
			match(input,86,FOLLOW_86_in_conditionInput90); 
			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_conditionStatement_in_conditionInput92);
			conditionStatement2=conditionStatement();
			state._fsp--;

			match(input, Token.UP, null); 

			evalCondition=conditionStatement2;
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
	// ValueEvaluatorTreeWalker.g:49:1: lhsrhs : ( term | CONSTRAIN );
	public final void lhsrhs() throws RecognitionException {
		try {
			// ValueEvaluatorTreeWalker.g:49:7: ( term | CONSTRAIN )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ABS||LA2_0==DAYSIN||LA2_0==EXP||LA2_0==FLOAT||LA2_0==IDENT||(LA2_0 >= INT && LA2_0 <= INTEGER)||(LA2_0 >= LOG && LA2_0 <= LOG10)||(LA2_0 >= MAX && LA2_0 <= MONTH_CONST)||(LA2_0 >= PASTMONTH && LA2_0 <= POW)||LA2_0==REAL||LA2_0==SVAR||LA2_0==TAFCFS||LA2_0==UNARY||LA2_0==YEAR||(LA2_0 >= 69 && LA2_0 <= 71)||LA2_0==75) ) {
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
					// ValueEvaluatorTreeWalker.g:49:9: term
					{
					pushFollow(FOLLOW_term_in_lhsrhs105);
					term();
					state._fsp--;

					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:49:14: CONSTRAIN
					{
					match(input,CONSTRAIN,FOLLOW_CONSTRAIN_in_lhsrhs107); 
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
	// ValueEvaluatorTreeWalker.g:53:1: units : ( IDENT | ( IDENT '/' IDENT ) );
	public final void units() throws RecognitionException {
		try {
			// ValueEvaluatorTreeWalker.g:53:6: ( IDENT | ( IDENT '/' IDENT ) )
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
					// ValueEvaluatorTreeWalker.g:53:8: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_units116); 
					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:53:14: ( IDENT '/' IDENT )
					{
					// ValueEvaluatorTreeWalker.g:53:14: ( IDENT '/' IDENT )
					// ValueEvaluatorTreeWalker.g:53:15: IDENT '/' IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_units119); 
					match(input,75,FOLLOW_75_in_units121); 
					match(input,IDENT,FOLLOW_IDENT_in_units123); 
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
	// ValueEvaluatorTreeWalker.g:55:1: fileName : ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+ ;
	public final void fileName() throws RecognitionException {
		try {
			// ValueEvaluatorTreeWalker.g:56:3: ( ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+ )
			// ValueEvaluatorTreeWalker.g:56:5: ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+
			{
			// ValueEvaluatorTreeWalker.g:56:5: ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+
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
				case SELECT:
				case SUM:
				case TAFCFS:
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
					// ValueEvaluatorTreeWalker.g:56:6: ':'
					{
					match(input,76,FOLLOW_76_in_fileName135); 
					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:56:10: ';'
					{
					match(input,77,FOLLOW_77_in_fileName137); 
					}
					break;
				case 3 :
					// ValueEvaluatorTreeWalker.g:56:14: '.'
					{
					match(input,72,FOLLOW_72_in_fileName139); 
					}
					break;
				case 4 :
					// ValueEvaluatorTreeWalker.g:56:18: '|'
					{
					match(input,88,FOLLOW_88_in_fileName141); 
					}
					break;
				case 5 :
					// ValueEvaluatorTreeWalker.g:56:22: SYMBOLS
					{
					match(input,SYMBOLS,FOLLOW_SYMBOLS_in_fileName143); 
					}
					break;
				case 6 :
					// ValueEvaluatorTreeWalker.g:56:30: '-'
					{
					match(input,71,FOLLOW_71_in_fileName145); 
					}
					break;
				case 7 :
					// ValueEvaluatorTreeWalker.g:56:34: '+'
					{
					match(input,70,FOLLOW_70_in_fileName147); 
					}
					break;
				case 8 :
					// ValueEvaluatorTreeWalker.g:56:38: BACKSLASH
					{
					match(input,BACKSLASH,FOLLOW_BACKSLASH_in_fileName149); 
					}
					break;
				case 9 :
					// ValueEvaluatorTreeWalker.g:56:48: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_fileName151); 
					}
					break;
				case 10 :
					// ValueEvaluatorTreeWalker.g:56:54: IDENT1
					{
					match(input,IDENT1,FOLLOW_IDENT1_in_fileName153); 
					}
					break;
				case 11 :
					// ValueEvaluatorTreeWalker.g:56:61: IDENT2
					{
					match(input,IDENT2,FOLLOW_IDENT2_in_fileName155); 
					}
					break;
				case 12 :
					// ValueEvaluatorTreeWalker.g:56:68: INTEGER
					{
					match(input,INTEGER,FOLLOW_INTEGER_in_fileName157); 
					}
					break;
				case 13 :
					// ValueEvaluatorTreeWalker.g:56:76: FLOAT
					{
					match(input,FLOAT,FOLLOW_FLOAT_in_fileName159); 
					}
					break;
				case 14 :
					// ValueEvaluatorTreeWalker.g:56:82: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_fileName161);
					usedKeywords();
					state._fsp--;

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
	// ValueEvaluatorTreeWalker.g:60:1: externalFile : ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+ ;
	public final void externalFile() throws RecognitionException {
		try {
			// ValueEvaluatorTreeWalker.g:61:3: ( ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+ )
			// ValueEvaluatorTreeWalker.g:61:5: ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+
			{
			// ValueEvaluatorTreeWalker.g:61:5: ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+
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
				case SELECT:
				case SUM:
				case TAFCFS:
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
					// ValueEvaluatorTreeWalker.g:61:6: ';'
					{
					match(input,77,FOLLOW_77_in_externalFile180); 
					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:61:10: '.'
					{
					match(input,72,FOLLOW_72_in_externalFile182); 
					}
					break;
				case 3 :
					// ValueEvaluatorTreeWalker.g:61:14: '|'
					{
					match(input,88,FOLLOW_88_in_externalFile184); 
					}
					break;
				case 4 :
					// ValueEvaluatorTreeWalker.g:61:18: SYMBOLS
					{
					match(input,SYMBOLS,FOLLOW_SYMBOLS_in_externalFile186); 
					}
					break;
				case 5 :
					// ValueEvaluatorTreeWalker.g:61:26: '-'
					{
					match(input,71,FOLLOW_71_in_externalFile188); 
					}
					break;
				case 6 :
					// ValueEvaluatorTreeWalker.g:61:30: '+'
					{
					match(input,70,FOLLOW_70_in_externalFile190); 
					}
					break;
				case 7 :
					// ValueEvaluatorTreeWalker.g:61:34: INTEGER
					{
					match(input,INTEGER,FOLLOW_INTEGER_in_externalFile192); 
					}
					break;
				case 8 :
					// ValueEvaluatorTreeWalker.g:61:42: FLOAT
					{
					match(input,FLOAT,FOLLOW_FLOAT_in_externalFile194); 
					}
					break;
				case 9 :
					// ValueEvaluatorTreeWalker.g:61:48: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_externalFile196); 
					}
					break;
				case 10 :
					// ValueEvaluatorTreeWalker.g:61:54: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_externalFile198);
					usedKeywords();
					state._fsp--;

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
	// ValueEvaluatorTreeWalker.g:64:1: text : LETTER ( LETTER | DIGIT )* ;
	public final void text() throws RecognitionException {
		try {
			// ValueEvaluatorTreeWalker.g:64:6: ( LETTER ( LETTER | DIGIT )* )
			// ValueEvaluatorTreeWalker.g:64:8: LETTER ( LETTER | DIGIT )*
			{
			match(input,LETTER,FOLLOW_LETTER_in_text212); 
			// ValueEvaluatorTreeWalker.g:64:15: ( LETTER | DIGIT )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==DIGIT||LA6_0==LETTER) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:
					{
					if ( input.LA(1)==DIGIT||input.LA(1)==LETTER ) {
						input.consume();
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



	// $ANTLR start "conditionStatement"
	// ValueEvaluatorTreeWalker.g:66:1: conditionStatement returns [boolean result] : ( (r= relationStatementTerm ) | ALWAYS );
	public final boolean conditionStatement() throws RecognitionException {
		boolean result = false;


		boolean r =false;

		try {
			// ValueEvaluatorTreeWalker.g:67:3: ( (r= relationStatementTerm ) | ALWAYS )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==RANGE||(LA7_0 >= 73 && LA7_0 <= 74)||(LA7_0 >= 78 && LA7_0 <= 79)||(LA7_0 >= 81 && LA7_0 <= 83)) ) {
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
					// ValueEvaluatorTreeWalker.g:67:5: (r= relationStatementTerm )
					{
					// ValueEvaluatorTreeWalker.g:67:5: (r= relationStatementTerm )
					// ValueEvaluatorTreeWalker.g:67:6: r= relationStatementTerm
					{
					pushFollow(FOLLOW_relationStatementTerm_in_conditionStatement239);
					r=relationStatementTerm();
					state._fsp--;

					result=r;
					}

					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:67:50: ALWAYS
					{
					match(input,ALWAYS,FOLLOW_ALWAYS_in_conditionStatement243); 
					result=true;
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
	// $ANTLR end "conditionStatement"



	// $ANTLR start "relationStatementTerm"
	// ValueEvaluatorTreeWalker.g:70:1: relationStatementTerm returns [boolean result] : (r0= relationRangeStatement |r1= relationStatementSeries );
	public final boolean relationStatementTerm() throws RecognitionException {
		boolean result = false;


		boolean r0 =false;
		boolean r1 =false;

		try {
			// ValueEvaluatorTreeWalker.g:71:3: (r0= relationRangeStatement |r1= relationStatementSeries )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==RANGE||(LA8_0 >= 78 && LA8_0 <= 79)||(LA8_0 >= 81 && LA8_0 <= 83)) ) {
				alt8=1;
			}
			else if ( ((LA8_0 >= 73 && LA8_0 <= 74)) ) {
				alt8=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:71:5: r0= relationRangeStatement
					{
					pushFollow(FOLLOW_relationRangeStatement_in_relationStatementTerm265);
					r0=relationRangeStatement();
					state._fsp--;

					result=r0;
					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:71:51: r1= relationStatementSeries
					{
					pushFollow(FOLLOW_relationStatementSeries_in_relationStatementTerm270);
					r1=relationStatementSeries();
					state._fsp--;

					result=r1;
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
	// $ANTLR end "relationStatementTerm"



	// $ANTLR start "relationStatementSeries"
	// ValueEvaluatorTreeWalker.g:74:1: relationStatementSeries returns [boolean result] : ( ^( (s= ( '.and.' | '.or.' ) ) r1= relationStatementTerm (r2= relationStatementTerm ) ) ) ;
	public final boolean relationStatementSeries() throws RecognitionException {
		boolean result = false;


		CommonTree s=null;
		boolean r1 =false;
		boolean r2 =false;

		try {
			// ValueEvaluatorTreeWalker.g:75:3: ( ( ^( (s= ( '.and.' | '.or.' ) ) r1= relationStatementTerm (r2= relationStatementTerm ) ) ) )
			// ValueEvaluatorTreeWalker.g:75:5: ( ^( (s= ( '.and.' | '.or.' ) ) r1= relationStatementTerm (r2= relationStatementTerm ) ) )
			{
			// ValueEvaluatorTreeWalker.g:75:5: ( ^( (s= ( '.and.' | '.or.' ) ) r1= relationStatementTerm (r2= relationStatementTerm ) ) )
			// ValueEvaluatorTreeWalker.g:75:6: ^( (s= ( '.and.' | '.or.' ) ) r1= relationStatementTerm (r2= relationStatementTerm ) )
			{
			// ValueEvaluatorTreeWalker.g:75:8: (s= ( '.and.' | '.or.' ) )
			// ValueEvaluatorTreeWalker.g:75:9: s= ( '.and.' | '.or.' )
			{
			s=(CommonTree)input.LT(1);
			if ( (input.LA(1) >= 73 && input.LA(1) <= 74) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_relationStatementTerm_in_relationStatementSeries303);
			r1=relationStatementTerm();
			state._fsp--;

			result=r1;
			// ValueEvaluatorTreeWalker.g:76:5: (r2= relationStatementTerm )
			// ValueEvaluatorTreeWalker.g:76:6: r2= relationStatementTerm
			{
			pushFollow(FOLLOW_relationStatementTerm_in_relationStatementSeries315);
			r2=relationStatementTerm();
			state._fsp--;

			result=ValueEvaluation.relationStatementSeries(result, r2, (s!=null?s.getText():null));
			}

			match(input, Token.UP, null); 

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
	// $ANTLR end "relationStatementSeries"



	// $ANTLR start "relationRangeStatement"
	// ValueEvaluatorTreeWalker.g:78:1: relationRangeStatement returns [boolean result] : ( (r1= relationStatement ) | (r2= range_func ) );
	public final boolean relationRangeStatement() throws RecognitionException {
		boolean result = false;


		boolean r1 =false;
		boolean r2 =false;

		try {
			// ValueEvaluatorTreeWalker.g:79:3: ( (r1= relationStatement ) | (r2= range_func ) )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( ((LA9_0 >= 78 && LA9_0 <= 79)||(LA9_0 >= 81 && LA9_0 <= 83)) ) {
				alt9=1;
			}
			else if ( (LA9_0==RANGE) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:79:5: (r1= relationStatement )
					{
					// ValueEvaluatorTreeWalker.g:79:5: (r1= relationStatement )
					// ValueEvaluatorTreeWalker.g:79:6: r1= relationStatement
					{
					pushFollow(FOLLOW_relationStatement_in_relationRangeStatement338);
					r1=relationStatement();
					state._fsp--;

					result=r1;
					}

					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:79:48: (r2= range_func )
					{
					// ValueEvaluatorTreeWalker.g:79:48: (r2= range_func )
					// ValueEvaluatorTreeWalker.g:79:49: r2= range_func
					{
					pushFollow(FOLLOW_range_func_in_relationRangeStatement345);
					r2=range_func();
					state._fsp--;

					result=r2;
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
	// ValueEvaluatorTreeWalker.g:82:1: relationStatement returns [boolean result] : ^(s= relation e1= term e2= term ) ;
	public final boolean relationStatement() throws RecognitionException {
		boolean result = false;


		String s =null;
		IntDouble e1 =null;
		IntDouble e2 =null;

		try {
			// ValueEvaluatorTreeWalker.g:83:3: ( ^(s= relation e1= term e2= term ) )
			// ValueEvaluatorTreeWalker.g:83:5: ^(s= relation e1= term e2= term )
			{
			pushFollow(FOLLOW_relation_in_relationStatement368);
			s=relation();
			state._fsp--;

			match(input, Token.DOWN, null); 
			pushFollow(FOLLOW_term_in_relationStatement372);
			e1=term();
			state._fsp--;

			pushFollow(FOLLOW_term_in_relationStatement376);
			e2=term();
			state._fsp--;

			match(input, Token.UP, null); 

			result=ValueEvaluation.relationStatement(e1, e2, s);
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



	// $ANTLR start "expressionCollection"
	// ValueEvaluatorTreeWalker.g:87:1: expressionCollection returns [IntDouble id] : ( ( ( term ) | ( tableSQL ) | ( timeseriesWithUnits ) | ( ( timeseries ) ) | ( sumExpression ) ) | ( UPPERUNBOUNDED ) | ( LOWERUNBOUNDED ) );
	public final IntDouble expressionCollection() throws RecognitionException {
		IntDouble id = null;


		IntDouble term3 =null;
		IntDouble tableSQL4 =null;
		IntDouble timeseries5 =null;
		IntDouble sumExpression6 =null;

		try {
			// ValueEvaluatorTreeWalker.g:88:2: ( ( ( term ) | ( tableSQL ) | ( timeseriesWithUnits ) | ( ( timeseries ) ) | ( sumExpression ) ) | ( UPPERUNBOUNDED ) | ( LOWERUNBOUNDED ) )
			int alt11=3;
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
			case MOD:
			case MONTH:
			case MONTH_CONST:
			case PASTMONTH:
			case POW:
			case REAL:
			case SELECT:
			case SUM:
			case SVAR:
			case TAFCFS:
			case TIMESERIES:
			case UNARY:
			case YEAR:
			case 69:
			case 70:
			case 71:
			case 75:
				{
				alt11=1;
				}
				break;
			case UPPERUNBOUNDED:
				{
				alt11=2;
				}
				break;
			case LOWERUNBOUNDED:
				{
				alt11=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:88:3: ( ( term ) | ( tableSQL ) | ( timeseriesWithUnits ) | ( ( timeseries ) ) | ( sumExpression ) )
					{
					// ValueEvaluatorTreeWalker.g:88:3: ( ( term ) | ( tableSQL ) | ( timeseriesWithUnits ) | ( ( timeseries ) ) | ( sumExpression ) )
					int alt10=5;
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
					case MOD:
					case MONTH:
					case MONTH_CONST:
					case PASTMONTH:
					case POW:
					case REAL:
					case SVAR:
					case TAFCFS:
					case UNARY:
					case YEAR:
					case 69:
					case 70:
					case 71:
					case 75:
						{
						alt10=1;
						}
						break;
					case SELECT:
						{
						alt10=2;
						}
						break;
					case TIMESERIES:
						{
						int LA10_3 = input.LA(2);
						if ( (LA10_3==89) ) {
							alt10=3;
						}
						else if ( (LA10_3==UP) ) {
							alt10=4;
						}

						else {
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 10, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case SUM:
						{
						alt10=5;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 10, 0, input);
						throw nvae;
					}
					switch (alt10) {
						case 1 :
							// ValueEvaluatorTreeWalker.g:88:4: ( term )
							{
							// ValueEvaluatorTreeWalker.g:88:4: ( term )
							// ValueEvaluatorTreeWalker.g:88:5: term
							{
							pushFollow(FOLLOW_term_in_expressionCollection397);
							term3=term();
							state._fsp--;

							id=term3;
							}

							}
							break;
						case 2 :
							// ValueEvaluatorTreeWalker.g:89:3: ( tableSQL )
							{
							// ValueEvaluatorTreeWalker.g:89:3: ( tableSQL )
							// ValueEvaluatorTreeWalker.g:89:4: tableSQL
							{
							pushFollow(FOLLOW_tableSQL_in_expressionCollection404);
							tableSQL4=tableSQL();
							state._fsp--;

							}

							id=tableSQL4;
							}
							break;
						case 3 :
							// ValueEvaluatorTreeWalker.g:90:3: ( timeseriesWithUnits )
							{
							// ValueEvaluatorTreeWalker.g:90:3: ( timeseriesWithUnits )
							// ValueEvaluatorTreeWalker.g:90:4: timeseriesWithUnits
							{
							pushFollow(FOLLOW_timeseriesWithUnits_in_expressionCollection411);
							timeseriesWithUnits();
							state._fsp--;

							}

							}
							break;
						case 4 :
							// ValueEvaluatorTreeWalker.g:91:3: ( ( timeseries ) )
							{
							// ValueEvaluatorTreeWalker.g:91:3: ( ( timeseries ) )
							// ValueEvaluatorTreeWalker.g:91:4: ( timeseries )
							{
							// ValueEvaluatorTreeWalker.g:91:4: ( timeseries )
							// ValueEvaluatorTreeWalker.g:91:5: timeseries
							{
							pushFollow(FOLLOW_timeseries_in_expressionCollection418);
							timeseries5=timeseries();
							state._fsp--;

							}

							id=timeseries5;
							}

							}
							break;
						case 5 :
							// ValueEvaluatorTreeWalker.g:92:3: ( sumExpression )
							{
							// ValueEvaluatorTreeWalker.g:92:3: ( sumExpression )
							// ValueEvaluatorTreeWalker.g:92:4: sumExpression
							{
							pushFollow(FOLLOW_sumExpression_in_expressionCollection426);
							sumExpression6=sumExpression();
							state._fsp--;

							id=sumExpression6;
							}

							}
							break;

					}

					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:93:3: ( UPPERUNBOUNDED )
					{
					// ValueEvaluatorTreeWalker.g:93:3: ( UPPERUNBOUNDED )
					// ValueEvaluatorTreeWalker.g:93:4: UPPERUNBOUNDED
					{
					match(input,UPPERUNBOUNDED,FOLLOW_UPPERUNBOUNDED_in_expressionCollection434); 
					id=new IntDouble(1e38,true);
					}

					}
					break;
				case 3 :
					// ValueEvaluatorTreeWalker.g:94:3: ( LOWERUNBOUNDED )
					{
					// ValueEvaluatorTreeWalker.g:94:3: ( LOWERUNBOUNDED )
					// ValueEvaluatorTreeWalker.g:94:4: LOWERUNBOUNDED
					{
					match(input,LOWERUNBOUNDED,FOLLOW_LOWERUNBOUNDED_in_expressionCollection441); 
					id=new IntDouble(-1e38,true);
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
	// ValueEvaluatorTreeWalker.g:97:1: func returns [IntDouble id] : ( ( max_func ) | ( min_func ) | ( int_func ) | ( real_func ) | ( abs_func ) | ( exp_func ) | ( log_func ) | ( log10_func ) | ( pow_func ) );
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

		try {
			// ValueEvaluatorTreeWalker.g:97:27: ( ( max_func ) | ( min_func ) | ( int_func ) | ( real_func ) | ( abs_func ) | ( exp_func ) | ( log_func ) | ( log10_func ) | ( pow_func ) )
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
					// ValueEvaluatorTreeWalker.g:98:3: ( max_func )
					{
					// ValueEvaluatorTreeWalker.g:98:3: ( max_func )
					// ValueEvaluatorTreeWalker.g:98:4: max_func
					{
					pushFollow(FOLLOW_max_func_in_func459);
					max_func7=max_func();
					state._fsp--;

					id=max_func7;
					}

					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:99:3: ( min_func )
					{
					// ValueEvaluatorTreeWalker.g:99:3: ( min_func )
					// ValueEvaluatorTreeWalker.g:99:4: min_func
					{
					pushFollow(FOLLOW_min_func_in_func467);
					min_func8=min_func();
					state._fsp--;

					id=min_func8;
					}

					}
					break;
				case 3 :
					// ValueEvaluatorTreeWalker.g:100:3: ( int_func )
					{
					// ValueEvaluatorTreeWalker.g:100:3: ( int_func )
					// ValueEvaluatorTreeWalker.g:100:4: int_func
					{
					pushFollow(FOLLOW_int_func_in_func475);
					int_func9=int_func();
					state._fsp--;

					id=int_func9;
					}

					}
					break;
				case 4 :
					// ValueEvaluatorTreeWalker.g:101:3: ( real_func )
					{
					// ValueEvaluatorTreeWalker.g:101:3: ( real_func )
					// ValueEvaluatorTreeWalker.g:101:4: real_func
					{
					pushFollow(FOLLOW_real_func_in_func483);
					real_func10=real_func();
					state._fsp--;

					id=real_func10;
					}

					}
					break;
				case 5 :
					// ValueEvaluatorTreeWalker.g:102:3: ( abs_func )
					{
					// ValueEvaluatorTreeWalker.g:102:3: ( abs_func )
					// ValueEvaluatorTreeWalker.g:102:4: abs_func
					{
					pushFollow(FOLLOW_abs_func_in_func491);
					abs_func11=abs_func();
					state._fsp--;

					id=abs_func11;
					}

					}
					break;
				case 6 :
					// ValueEvaluatorTreeWalker.g:103:3: ( exp_func )
					{
					// ValueEvaluatorTreeWalker.g:103:3: ( exp_func )
					// ValueEvaluatorTreeWalker.g:103:4: exp_func
					{
					pushFollow(FOLLOW_exp_func_in_func499);
					exp_func12=exp_func();
					state._fsp--;

					id=exp_func12;
					}

					}
					break;
				case 7 :
					// ValueEvaluatorTreeWalker.g:104:3: ( log_func )
					{
					// ValueEvaluatorTreeWalker.g:104:3: ( log_func )
					// ValueEvaluatorTreeWalker.g:104:4: log_func
					{
					pushFollow(FOLLOW_log_func_in_func507);
					log_func13=log_func();
					state._fsp--;

					id=log_func13;
					}

					}
					break;
				case 8 :
					// ValueEvaluatorTreeWalker.g:105:3: ( log10_func )
					{
					// ValueEvaluatorTreeWalker.g:105:3: ( log10_func )
					// ValueEvaluatorTreeWalker.g:105:4: log10_func
					{
					pushFollow(FOLLOW_log10_func_in_func515);
					log10_func14=log10_func();
					state._fsp--;

					id=log10_func14;
					}

					}
					break;
				case 9 :
					// ValueEvaluatorTreeWalker.g:106:3: ( pow_func )
					{
					// ValueEvaluatorTreeWalker.g:106:3: ( pow_func )
					// ValueEvaluatorTreeWalker.g:106:4: pow_func
					{
					pushFollow(FOLLOW_pow_func_in_func523);
					pow_func15=pow_func();
					state._fsp--;

					id=pow_func15;
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



	// $ANTLR start "max_func"
	// ValueEvaluatorTreeWalker.g:108:1: max_func returns [IntDouble id] : ^( MAX (t1= term ) (t2= term ) ) ;
	public final IntDouble max_func() throws RecognitionException {
		IntDouble id = null;


		IntDouble t1 =null;
		IntDouble t2 =null;

		try {
			// ValueEvaluatorTreeWalker.g:109:2: ( ^( MAX (t1= term ) (t2= term ) ) )
			// ValueEvaluatorTreeWalker.g:109:4: ^( MAX (t1= term ) (t2= term ) )
			{
			match(input,MAX,FOLLOW_MAX_in_max_func539); 
			match(input, Token.DOWN, null); 
			// ValueEvaluatorTreeWalker.g:109:10: (t1= term )
			// ValueEvaluatorTreeWalker.g:109:11: t1= term
			{
			pushFollow(FOLLOW_term_in_max_func544);
			t1=term();
			state._fsp--;

			}

			id=t1;
			// ValueEvaluatorTreeWalker.g:109:32: (t2= term )
			// ValueEvaluatorTreeWalker.g:109:33: t2= term
			{
			pushFollow(FOLLOW_term_in_max_func551);
			t2=term();
			state._fsp--;


			     id=ValueEvaluation.max(id, t2);
			  
			}

			match(input, Token.UP, null); 

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
	// ValueEvaluatorTreeWalker.g:114:1: min_func returns [IntDouble id] : ^( MIN (t1= term ) (t2= term ) ) ;
	public final IntDouble min_func() throws RecognitionException {
		IntDouble id = null;


		IntDouble t1 =null;
		IntDouble t2 =null;

		try {
			// ValueEvaluatorTreeWalker.g:115:2: ( ^( MIN (t1= term ) (t2= term ) ) )
			// ValueEvaluatorTreeWalker.g:115:4: ^( MIN (t1= term ) (t2= term ) )
			{
			match(input,MIN,FOLLOW_MIN_in_min_func569); 
			match(input, Token.DOWN, null); 
			// ValueEvaluatorTreeWalker.g:115:10: (t1= term )
			// ValueEvaluatorTreeWalker.g:115:11: t1= term
			{
			pushFollow(FOLLOW_term_in_min_func574);
			t1=term();
			state._fsp--;

			}

			id=t1;
			// ValueEvaluatorTreeWalker.g:115:32: (t2= term )
			// ValueEvaluatorTreeWalker.g:115:33: t2= term
			{
			pushFollow(FOLLOW_term_in_min_func581);
			t2=term();
			state._fsp--;


			     id=ValueEvaluation.min(id, t2);
			  
			}

			match(input, Token.UP, null); 

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
	// ValueEvaluatorTreeWalker.g:120:1: int_func returns [IntDouble id] : ^( INT (t= term ) ) ;
	public final IntDouble int_func() throws RecognitionException {
		IntDouble id = null;


		IntDouble t =null;

		try {
			// ValueEvaluatorTreeWalker.g:121:3: ( ^( INT (t= term ) ) )
			// ValueEvaluatorTreeWalker.g:121:5: ^( INT (t= term ) )
			{
			match(input,INT,FOLLOW_INT_in_int_func601); 
			match(input, Token.DOWN, null); 
			// ValueEvaluatorTreeWalker.g:121:11: (t= term )
			// ValueEvaluatorTreeWalker.g:121:12: t= term
			{
			pushFollow(FOLLOW_term_in_int_func606);
			t=term();
			state._fsp--;

			}


			     id=ValueEvaluation.intFunc(t);
			  
			match(input, Token.UP, null); 

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
	// ValueEvaluatorTreeWalker.g:126:1: real_func returns [IntDouble id] : ^( REAL (t= term ) ) ;
	public final IntDouble real_func() throws RecognitionException {
		IntDouble id = null;


		IntDouble t =null;

		try {
			// ValueEvaluatorTreeWalker.g:127:3: ( ^( REAL (t= term ) ) )
			// ValueEvaluatorTreeWalker.g:127:5: ^( REAL (t= term ) )
			{
			match(input,REAL,FOLLOW_REAL_in_real_func629); 
			match(input, Token.DOWN, null); 
			// ValueEvaluatorTreeWalker.g:127:12: (t= term )
			// ValueEvaluatorTreeWalker.g:127:13: t= term
			{
			pushFollow(FOLLOW_term_in_real_func634);
			t=term();
			state._fsp--;

			}


			     id=ValueEvaluation.realFunc(t);
			  
			match(input, Token.UP, null); 

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
	// ValueEvaluatorTreeWalker.g:132:1: abs_func returns [IntDouble id] : ^( ABS (t= term ) ) ;
	public final IntDouble abs_func() throws RecognitionException {
		IntDouble id = null;


		IntDouble t =null;

		try {
			// ValueEvaluatorTreeWalker.g:133:3: ( ^( ABS (t= term ) ) )
			// ValueEvaluatorTreeWalker.g:133:5: ^( ABS (t= term ) )
			{
			match(input,ABS,FOLLOW_ABS_in_abs_func657); 
			match(input, Token.DOWN, null); 
			// ValueEvaluatorTreeWalker.g:133:11: (t= term )
			// ValueEvaluatorTreeWalker.g:133:12: t= term
			{
			pushFollow(FOLLOW_term_in_abs_func662);
			t=term();
			state._fsp--;

			}


			     id=ValueEvaluation.abs(t);
			  
			match(input, Token.UP, null); 

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
	// ValueEvaluatorTreeWalker.g:138:1: exp_func returns [IntDouble id] : ^( EXP (t= term ) ) ;
	public final IntDouble exp_func() throws RecognitionException {
		IntDouble id = null;


		IntDouble t =null;

		try {
			// ValueEvaluatorTreeWalker.g:139:3: ( ^( EXP (t= term ) ) )
			// ValueEvaluatorTreeWalker.g:139:5: ^( EXP (t= term ) )
			{
			match(input,EXP,FOLLOW_EXP_in_exp_func683); 
			match(input, Token.DOWN, null); 
			// ValueEvaluatorTreeWalker.g:139:11: (t= term )
			// ValueEvaluatorTreeWalker.g:139:12: t= term
			{
			pushFollow(FOLLOW_term_in_exp_func688);
			t=term();
			state._fsp--;

			}


			     id=ValueEvaluation.exp(t);
			  
			match(input, Token.UP, null); 

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
	// ValueEvaluatorTreeWalker.g:144:1: log_func returns [IntDouble id] : ^( LOG (t= term ) ) ;
	public final IntDouble log_func() throws RecognitionException {
		IntDouble id = null;


		IntDouble t =null;

		try {
			// ValueEvaluatorTreeWalker.g:145:3: ( ^( LOG (t= term ) ) )
			// ValueEvaluatorTreeWalker.g:145:5: ^( LOG (t= term ) )
			{
			match(input,LOG,FOLLOW_LOG_in_log_func709); 
			match(input, Token.DOWN, null); 
			// ValueEvaluatorTreeWalker.g:145:11: (t= term )
			// ValueEvaluatorTreeWalker.g:145:12: t= term
			{
			pushFollow(FOLLOW_term_in_log_func714);
			t=term();
			state._fsp--;

			}


			     id=ValueEvaluation.log(t);
			  
			match(input, Token.UP, null); 

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
	// ValueEvaluatorTreeWalker.g:150:1: log10_func returns [IntDouble id] : ^( LOG10 (t= term ) ) ;
	public final IntDouble log10_func() throws RecognitionException {
		IntDouble id = null;


		IntDouble t =null;

		try {
			// ValueEvaluatorTreeWalker.g:151:3: ( ^( LOG10 (t= term ) ) )
			// ValueEvaluatorTreeWalker.g:151:5: ^( LOG10 (t= term ) )
			{
			match(input,LOG10,FOLLOW_LOG10_in_log10_func735); 
			match(input, Token.DOWN, null); 
			// ValueEvaluatorTreeWalker.g:151:13: (t= term )
			// ValueEvaluatorTreeWalker.g:151:14: t= term
			{
			pushFollow(FOLLOW_term_in_log10_func740);
			t=term();
			state._fsp--;

			}


			    id=ValueEvaluation.log10(t);
			  
			match(input, Token.UP, null); 

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
	// ValueEvaluatorTreeWalker.g:156:1: pow_func returns [IntDouble id] : ^( POW (t1= term ) (t2= term ) ) ;
	public final IntDouble pow_func() throws RecognitionException {
		IntDouble id = null;


		IntDouble t1 =null;
		IntDouble t2 =null;

		try {
			// ValueEvaluatorTreeWalker.g:157:3: ( ^( POW (t1= term ) (t2= term ) ) )
			// ValueEvaluatorTreeWalker.g:157:5: ^( POW (t1= term ) (t2= term ) )
			{
			match(input,POW,FOLLOW_POW_in_pow_func763); 
			match(input, Token.DOWN, null); 
			// ValueEvaluatorTreeWalker.g:157:11: (t1= term )
			// ValueEvaluatorTreeWalker.g:157:12: t1= term
			{
			pushFollow(FOLLOW_term_in_pow_func768);
			t1=term();
			state._fsp--;

			}

			// ValueEvaluatorTreeWalker.g:157:21: (t2= term )
			// ValueEvaluatorTreeWalker.g:157:22: t2= term
			{
			pushFollow(FOLLOW_term_in_pow_func774);
			t2=term();
			state._fsp--;

			}


			     id=ValueEvaluation.pow(t1, t2);
			  
			match(input, Token.UP, null); 

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



	// $ANTLR start "range_func"
	// ValueEvaluatorTreeWalker.g:162:1: range_func returns [boolean result] : ^( RANGE MONTH m1= MONTH_CONST m2= MONTH_CONST ) ;
	public final boolean range_func() throws RecognitionException {
		boolean result = false;


		CommonTree m1=null;
		CommonTree m2=null;

		try {
			// ValueEvaluatorTreeWalker.g:163:3: ( ^( RANGE MONTH m1= MONTH_CONST m2= MONTH_CONST ) )
			// ValueEvaluatorTreeWalker.g:163:5: ^( RANGE MONTH m1= MONTH_CONST m2= MONTH_CONST )
			{
			match(input,RANGE,FOLLOW_RANGE_in_range_func798); 
			match(input, Token.DOWN, null); 
			match(input,MONTH,FOLLOW_MONTH_in_range_func801); 
			m1=(CommonTree)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_range_func805); 
			m2=(CommonTree)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_range_func809); 
			match(input, Token.UP, null); 

			result=ValueEvaluation.range((m1!=null?m1.getText():null), (m2!=null?m2.getText():null));
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
	// ValueEvaluatorTreeWalker.g:165:1: timeseriesWithUnits : TIMESERIES 'kind' '=' partC 'units' '=' IDENT ;
	public final void timeseriesWithUnits() throws RecognitionException {
		try {
			// ValueEvaluatorTreeWalker.g:166:2: ( TIMESERIES 'kind' '=' partC 'units' '=' IDENT )
			// ValueEvaluatorTreeWalker.g:166:4: TIMESERIES 'kind' '=' partC 'units' '=' IDENT
			{
			match(input,TIMESERIES,FOLLOW_TIMESERIES_in_timeseriesWithUnits822); 
			match(input,89,FOLLOW_89_in_timeseriesWithUnits824); 
			match(input,80,FOLLOW_80_in_timeseriesWithUnits826); 
			pushFollow(FOLLOW_partC_in_timeseriesWithUnits828);
			partC();
			state._fsp--;

			match(input,90,FOLLOW_90_in_timeseriesWithUnits830); 
			match(input,80,FOLLOW_80_in_timeseriesWithUnits832); 
			match(input,IDENT,FOLLOW_IDENT_in_timeseriesWithUnits834); 
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
	// ValueEvaluatorTreeWalker.g:169:1: timeseries returns [IntDouble id] : TIMESERIES ;
	public final IntDouble timeseries() throws RecognitionException {
		IntDouble id = null;


		try {
			// ValueEvaluatorTreeWalker.g:170:2: ( TIMESERIES )
			// ValueEvaluatorTreeWalker.g:170:4: TIMESERIES
			{
			match(input,TIMESERIES,FOLLOW_TIMESERIES_in_timeseries850); 
			id=ValueEvaluation.timeseries();
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
	// ValueEvaluatorTreeWalker.g:175:1: partC : ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )* ;
	public final void partC() throws RecognitionException {
		try {
			// ValueEvaluatorTreeWalker.g:175:6: ( ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )* )
			// ValueEvaluatorTreeWalker.g:175:9: ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )*
			{
			// ValueEvaluatorTreeWalker.g:175:9: ( IDENT | IDENT1 | usedKeywords )
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
			case ALWAYS:
			case CASE:
			case CONDITION:
			case CONSTRAIN:
			case CONVERTUNITS:
			case CYCLE:
			case DAYSIN:
			case DVAR:
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
			case SELECT:
			case SUM:
			case TAFCFS:
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
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}
			switch (alt13) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:175:10: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_partC867); 
					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:175:16: IDENT1
					{
					match(input,IDENT1,FOLLOW_IDENT1_in_partC869); 
					}
					break;
				case 3 :
					// ValueEvaluatorTreeWalker.g:175:23: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_partC871);
					usedKeywords();
					state._fsp--;

					}
					break;

			}

			// ValueEvaluatorTreeWalker.g:175:37: ( '-' ( IDENT | IDENT1 | usedKeywords ) )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==71) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:175:38: '-' ( IDENT | IDENT1 | usedKeywords )
					{
					match(input,71,FOLLOW_71_in_partC875); 
					// ValueEvaluatorTreeWalker.g:175:42: ( IDENT | IDENT1 | usedKeywords )
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
					case ALWAYS:
					case CASE:
					case CONDITION:
					case CONSTRAIN:
					case CONVERTUNITS:
					case CYCLE:
					case DAYSIN:
					case DVAR:
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
					case SELECT:
					case SUM:
					case TAFCFS:
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
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						throw nvae;
					}
					switch (alt14) {
						case 1 :
							// ValueEvaluatorTreeWalker.g:175:43: IDENT
							{
							match(input,IDENT,FOLLOW_IDENT_in_partC878); 
							}
							break;
						case 2 :
							// ValueEvaluatorTreeWalker.g:175:49: IDENT1
							{
							match(input,IDENT1,FOLLOW_IDENT1_in_partC880); 
							}
							break;
						case 3 :
							// ValueEvaluatorTreeWalker.g:175:56: usedKeywords
							{
							pushFollow(FOLLOW_usedKeywords_in_partC882);
							usedKeywords();
							state._fsp--;

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


	public static class usedKeywords_return extends TreeRuleReturnScope {
	};


	// $ANTLR start "usedKeywords"
	// ValueEvaluatorTreeWalker.g:177:1: usedKeywords : ( YEAR | MONTH | MONTH_CONST | PASTMONTH | RANGE | TAFCFS | DAYSIN | SUM | MAX | MIN | INT | ABS | LOG | LOG10 | POW | MOD | SELECT | FROM | GIVEN | USE | WHERE | CONSTRAIN | ALWAYS | NAME | DVAR | CYCLE | FILE | CONDITION | INCLUDE | LOWERBOUND | UPPERBOUND | INTEGERTYPE | UNITS | CONVERTUNITS | TYPE | OUTPUT | CASE | ORDER | EXPRESSION | LHSGTRHS | LHSLTRHS | WEIGHT | FUNCTION | FROM_WRESL_FILE | UPPERUNBOUNDED | LOWERUNBOUNDED );
	public final ValueEvaluatorTreeWalker.usedKeywords_return usedKeywords() throws RecognitionException {
		ValueEvaluatorTreeWalker.usedKeywords_return retval = new ValueEvaluatorTreeWalker.usedKeywords_return();
		retval.start = input.LT(1);

		try {
			// ValueEvaluatorTreeWalker.g:177:13: ( YEAR | MONTH | MONTH_CONST | PASTMONTH | RANGE | TAFCFS | DAYSIN | SUM | MAX | MIN | INT | ABS | LOG | LOG10 | POW | MOD | SELECT | FROM | GIVEN | USE | WHERE | CONSTRAIN | ALWAYS | NAME | DVAR | CYCLE | FILE | CONDITION | INCLUDE | LOWERBOUND | UPPERBOUND | INTEGERTYPE | UNITS | CONVERTUNITS | TYPE | OUTPUT | CASE | ORDER | EXPRESSION | LHSGTRHS | LHSLTRHS | WEIGHT | FUNCTION | FROM_WRESL_FILE | UPPERUNBOUNDED | LOWERUNBOUNDED )
			// ValueEvaluatorTreeWalker.g:
			{
			if ( (input.LA(1) >= ABS && input.LA(1) <= ALWAYS)||input.LA(1)==CASE||(input.LA(1) >= CONDITION && input.LA(1) <= DAYSIN)||input.LA(1)==DVAR||(input.LA(1) >= EXPRESSION && input.LA(1) <= FILE)||(input.LA(1) >= FROM && input.LA(1) <= GIVEN)||(input.LA(1) >= INCLUDE && input.LA(1) <= INT)||input.LA(1)==INTEGERTYPE||(input.LA(1) >= LHSGTRHS && input.LA(1) <= MONTH_CONST)||(input.LA(1) >= NAME && input.LA(1) <= RANGE)||(input.LA(1) >= SELECT && input.LA(1) <= SUM)||input.LA(1)==TAFCFS||input.LA(1)==TYPE||(input.LA(1) >= UNITS && input.LA(1) <= WHERE)||input.LA(1)==YEAR ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
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
		return retval;
	}
	// $ANTLR end "usedKeywords"



	// $ANTLR start "tableSQL"
	// ValueEvaluatorTreeWalker.g:181:1: tableSQL returns [IntDouble id] : ^( SELECT ( selectName ) i1= IDENT (a= assignStatement )? (i2= IDENT )? ( where_items )? ) ;
	public final IntDouble tableSQL() throws RecognitionException {
		IntDouble id = null;


		CommonTree i1=null;
		CommonTree i2=null;
		TreeRuleReturnScope a =null;
		TreeRuleReturnScope selectName16 =null;
		HashMap<String, Number> where_items17 =null;

		String table=null; String select=null; String use=null; HashMap<String, Number> given=null; HashMap<String, Number> where=null;
		try {
			// ValueEvaluatorTreeWalker.g:182:2: ( ^( SELECT ( selectName ) i1= IDENT (a= assignStatement )? (i2= IDENT )? ( where_items )? ) )
			// ValueEvaluatorTreeWalker.g:182:4: ^( SELECT ( selectName ) i1= IDENT (a= assignStatement )? (i2= IDENT )? ( where_items )? )
			{
			match(input,SELECT,FOLLOW_SELECT_in_tableSQL1004); 
			match(input, Token.DOWN, null); 
			// ValueEvaluatorTreeWalker.g:182:13: ( selectName )
			// ValueEvaluatorTreeWalker.g:182:14: selectName
			{
			pushFollow(FOLLOW_selectName_in_tableSQL1007);
			selectName16=selectName();
			state._fsp--;

			select=(selectName16!=null?(input.getTokenStream().toString(input.getTreeAdaptor().getTokenStartIndex(selectName16.start),input.getTreeAdaptor().getTokenStopIndex(selectName16.start))):null);
			}

			i1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_tableSQL1013); 
			table=(i1!=null?i1.getText():null);
			// ValueEvaluatorTreeWalker.g:183:4: (a= assignStatement )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==80) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:183:5: a= assignStatement
					{
					pushFollow(FOLLOW_assignStatement_in_tableSQL1023);
					a=assignStatement();
					state._fsp--;

					given=new HashMap<String, Number>(); given.put((a!=null?((ValueEvaluatorTreeWalker.assignStatement_return)a).assignIdent:null), (a!=null?((ValueEvaluatorTreeWalker.assignStatement_return)a).value:null));
					}
					break;

			}

			// ValueEvaluatorTreeWalker.g:183:100: (i2= IDENT )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==IDENT) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:183:101: i2= IDENT
					{
					i2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_tableSQL1031); 
					use=(i2!=null?i2.getText():null);
					}
					break;

			}

			// ValueEvaluatorTreeWalker.g:184:4: ( where_items )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==WHERE) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:184:5: where_items
					{
					pushFollow(FOLLOW_where_items_in_tableSQL1041);
					where_items17=where_items();
					state._fsp--;

					where=where_items17;
					}
					break;

			}

			match(input, Token.UP, null); 

			id=ValueEvaluation.tableSQL(table, select, where, given, use);
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


	public static class selectName_return extends TreeRuleReturnScope {
	};


	// $ANTLR start "selectName"
	// ValueEvaluatorTreeWalker.g:187:1: selectName : ( IDENT | usedKeywords ) ;
	public final ValueEvaluatorTreeWalker.selectName_return selectName() throws RecognitionException {
		ValueEvaluatorTreeWalker.selectName_return retval = new ValueEvaluatorTreeWalker.selectName_return();
		retval.start = input.LT(1);

		try {
			// ValueEvaluatorTreeWalker.g:187:11: ( ( IDENT | usedKeywords ) )
			// ValueEvaluatorTreeWalker.g:187:13: ( IDENT | usedKeywords )
			{
			// ValueEvaluatorTreeWalker.g:187:13: ( IDENT | usedKeywords )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==IDENT) ) {
				alt19=1;
			}
			else if ( ((LA19_0 >= ABS && LA19_0 <= ALWAYS)||LA19_0==CASE||(LA19_0 >= CONDITION && LA19_0 <= DAYSIN)||LA19_0==DVAR||(LA19_0 >= EXPRESSION && LA19_0 <= FILE)||(LA19_0 >= FROM && LA19_0 <= GIVEN)||(LA19_0 >= INCLUDE && LA19_0 <= INT)||LA19_0==INTEGERTYPE||(LA19_0 >= LHSGTRHS && LA19_0 <= MONTH_CONST)||(LA19_0 >= NAME && LA19_0 <= RANGE)||(LA19_0 >= SELECT && LA19_0 <= SUM)||LA19_0==TAFCFS||LA19_0==TYPE||(LA19_0 >= UNITS && LA19_0 <= WHERE)||LA19_0==YEAR) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:187:14: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_selectName1061); 
					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:187:21: usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_selectName1064);
					usedKeywords();
					state._fsp--;

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
		return retval;
	}
	// $ANTLR end "selectName"



	// $ANTLR start "where_items"
	// ValueEvaluatorTreeWalker.g:189:1: where_items returns [HashMap<String, Number> where] : ^( WHERE (r1= whereStatement ) (r= whereStatement )* ) ;
	public final HashMap<String, Number> where_items() throws RecognitionException {
		HashMap<String, Number> where = null;


		TreeRuleReturnScope r1 =null;
		TreeRuleReturnScope r =null;

		try {
			// ValueEvaluatorTreeWalker.g:190:2: ( ^( WHERE (r1= whereStatement ) (r= whereStatement )* ) )
			// ValueEvaluatorTreeWalker.g:190:5: ^( WHERE (r1= whereStatement ) (r= whereStatement )* )
			{
			match(input,WHERE,FOLLOW_WHERE_in_where_items1080); 
			match(input, Token.DOWN, null); 
			// ValueEvaluatorTreeWalker.g:190:14: (r1= whereStatement )
			// ValueEvaluatorTreeWalker.g:190:15: r1= whereStatement
			{
			pushFollow(FOLLOW_whereStatement_in_where_items1086);
			r1=whereStatement();
			state._fsp--;

			where=new HashMap<String, Number>(); where.put((r1!=null?((ValueEvaluatorTreeWalker.whereStatement_return)r1).whereIdent:null), (r1!=null?((ValueEvaluatorTreeWalker.whereStatement_return)r1).value:null));
			}

			// ValueEvaluatorTreeWalker.g:191:10: (r= whereStatement )*
			loop20:
			while (true) {
				int alt20=2;
				int LA20_0 = input.LA(1);
				if ( (LA20_0==WHERE) ) {
					alt20=1;
				}

				switch (alt20) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:191:11: r= whereStatement
					{
					pushFollow(FOLLOW_whereStatement_in_where_items1102);
					r=whereStatement();
					state._fsp--;

					where.put((r!=null?((ValueEvaluatorTreeWalker.whereStatement_return)r).whereIdent:null), (r!=null?((ValueEvaluatorTreeWalker.whereStatement_return)r).value:null));
					}
					break;

				default :
					break loop20;
				}
			}

			match(input, Token.UP, null); 

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



	// $ANTLR start "sumExpression"
	// ValueEvaluatorTreeWalker.g:210:1: sumExpression returns [IntDouble id] : ^( SUM IDENT t1= term t2= term ( ( ( '-' )? INTEGER ) )? () t3= term ) ;
	public final IntDouble sumExpression() throws RecognitionException {
		IntDouble id = null;


		CommonTree INTEGER18=null;
		IntDouble t1 =null;
		IntDouble t2 =null;
		IntDouble t3 =null;

		String s="";
		try {
			// ValueEvaluatorTreeWalker.g:211:3: ( ^( SUM IDENT t1= term t2= term ( ( ( '-' )? INTEGER ) )? () t3= term ) )
			// ValueEvaluatorTreeWalker.g:211:5: ^( SUM IDENT t1= term t2= term ( ( ( '-' )? INTEGER ) )? () t3= term )
			{
			match(input,SUM,FOLLOW_SUM_in_sumExpression1144); 
			match(input, Token.DOWN, null); 
			match(input,IDENT,FOLLOW_IDENT_in_sumExpression1146); 
			id =new IntDouble(0, false);
			pushFollow(FOLLOW_term_in_sumExpression1151);
			t1=term();
			state._fsp--;

			pushFollow(FOLLOW_term_in_sumExpression1155);
			t2=term();
			state._fsp--;

			// ValueEvaluatorTreeWalker.g:211:63: ( ( ( '-' )? INTEGER ) )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==71) ) {
				int LA22_1 = input.LA(2);
				if ( (LA22_1==INTEGER) ) {
					alt22=1;
				}
			}
			else if ( (LA22_0==INTEGER) ) {
				int LA22_2 = input.LA(2);
				if ( (LA22_2==ABS||LA22_2==DAYSIN||LA22_2==EXP||LA22_2==FLOAT||LA22_2==IDENT||(LA22_2 >= INT && LA22_2 <= INTEGER)||(LA22_2 >= LOG && LA22_2 <= LOG10)||(LA22_2 >= MAX && LA22_2 <= MONTH_CONST)||(LA22_2 >= PASTMONTH && LA22_2 <= POW)||LA22_2==REAL||LA22_2==SVAR||LA22_2==TAFCFS||LA22_2==UNARY||LA22_2==YEAR||(LA22_2 >= 69 && LA22_2 <= 71)||LA22_2==75) ) {
					alt22=1;
				}
			}
			switch (alt22) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:211:64: ( ( '-' )? INTEGER )
					{
					// ValueEvaluatorTreeWalker.g:211:64: ( ( '-' )? INTEGER )
					// ValueEvaluatorTreeWalker.g:211:65: ( '-' )? INTEGER
					{
					// ValueEvaluatorTreeWalker.g:211:65: ( '-' )?
					int alt21=2;
					int LA21_0 = input.LA(1);
					if ( (LA21_0==71) ) {
						alt21=1;
					}
					switch (alt21) {
						case 1 :
							// ValueEvaluatorTreeWalker.g:211:66: '-'
							{
							match(input,71,FOLLOW_71_in_sumExpression1160); 
							s=s+"-";
							}
							break;

					}

					INTEGER18=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sumExpression1165); 
					s=s+(INTEGER18!=null?INTEGER18.getText():null);
					}

					}
					break;

			}

			// ValueEvaluatorTreeWalker.g:211:114: ()
			// ValueEvaluatorTreeWalker.g:211:115: 
			{
			id =new IntDouble(0, false);
			}

			pushFollow(FOLLOW_term_in_sumExpression1179);
			t3=term();
			state._fsp--;

			id =new IntDouble(0, false);
			match(input, Token.UP, null); 

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
	// ValueEvaluatorTreeWalker.g:214:1: term returns [IntDouble id] : ( ( IDENT ) | ( FLOAT ) | (t= expression ) | ( ( knownTS ) | func | ( INTEGER ) | tafcfs_term | YEAR | MONTH | MONTH_CONST | PASTMONTH | DAYSIN ) | ( SVAR ) );
	public final IntDouble term() throws RecognitionException {
		IntDouble id = null;


		CommonTree FLOAT19=null;
		CommonTree INTEGER22=null;
		CommonTree MONTH_CONST24=null;
		CommonTree PASTMONTH25=null;
		CommonTree SVAR26=null;
		IntDouble t =null;
		IntDouble knownTS20 =null;
		IntDouble func21 =null;
		IntDouble tafcfs_term23 =null;

		try {
			// ValueEvaluatorTreeWalker.g:215:2: ( ( IDENT ) | ( FLOAT ) | (t= expression ) | ( ( knownTS ) | func | ( INTEGER ) | tafcfs_term | YEAR | MONTH | MONTH_CONST | PASTMONTH | DAYSIN ) | ( SVAR ) )
			int alt24=5;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				int LA24_1 = input.LA(2);
				if ( (LA24_1==DOWN) ) {
					alt24=4;
				}
				else if ( (LA24_1==EOF||(LA24_1 >= UP && LA24_1 <= ABS)||LA24_1==DAYSIN||LA24_1==EXP||LA24_1==FLOAT||LA24_1==IDENT||(LA24_1 >= INT && LA24_1 <= INTEGER)||(LA24_1 >= LOG && LA24_1 <= LOG10)||(LA24_1 >= MAX && LA24_1 <= MONTH_CONST)||(LA24_1 >= PASTMONTH && LA24_1 <= POW)||LA24_1==REAL||LA24_1==SVAR||LA24_1==TAFCFS||LA24_1==UNARY||LA24_1==YEAR||(LA24_1 >= 68 && LA24_1 <= 71)||LA24_1==75) ) {
					alt24=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 24, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case FLOAT:
				{
				alt24=2;
				}
				break;
			case MOD:
			case UNARY:
			case 69:
			case 70:
			case 71:
			case 75:
				{
				alt24=3;
				}
				break;
			case ABS:
			case DAYSIN:
			case EXP:
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
			case TAFCFS:
			case YEAR:
				{
				alt24=4;
				}
				break;
			case SVAR:
				{
				alt24=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}
			switch (alt24) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:215:4: ( IDENT )
					{
					// ValueEvaluatorTreeWalker.g:215:4: ( IDENT )
					// ValueEvaluatorTreeWalker.g:215:5: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_term1198); 
					id =new IntDouble(0, false);
					}

					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:216:4: ( FLOAT )
					{
					// ValueEvaluatorTreeWalker.g:216:4: ( FLOAT )
					// ValueEvaluatorTreeWalker.g:216:5: FLOAT
					{
					FLOAT19=(CommonTree)match(input,FLOAT,FOLLOW_FLOAT_in_term1207); 
					id =ValueEvaluation.term_FLOAT((FLOAT19!=null?FLOAT19.getText():null));
					}

					}
					break;
				case 3 :
					// ValueEvaluatorTreeWalker.g:217:4: (t= expression )
					{
					// ValueEvaluatorTreeWalker.g:217:4: (t= expression )
					// ValueEvaluatorTreeWalker.g:217:6: t= expression
					{
					pushFollow(FOLLOW_expression_in_term1220);
					t=expression();
					state._fsp--;

					id =t;
					}

					}
					break;
				case 4 :
					// ValueEvaluatorTreeWalker.g:218:4: ( ( knownTS ) | func | ( INTEGER ) | tafcfs_term | YEAR | MONTH | MONTH_CONST | PASTMONTH | DAYSIN )
					{
					// ValueEvaluatorTreeWalker.g:218:4: ( ( knownTS ) | func | ( INTEGER ) | tafcfs_term | YEAR | MONTH | MONTH_CONST | PASTMONTH | DAYSIN )
					int alt23=9;
					switch ( input.LA(1) ) {
					case IDENT:
						{
						alt23=1;
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
						alt23=2;
						}
						break;
					case INTEGER:
						{
						alt23=3;
						}
						break;
					case TAFCFS:
						{
						alt23=4;
						}
						break;
					case YEAR:
						{
						alt23=5;
						}
						break;
					case MONTH:
						{
						alt23=6;
						}
						break;
					case MONTH_CONST:
						{
						alt23=7;
						}
						break;
					case PASTMONTH:
						{
						alt23=8;
						}
						break;
					case DAYSIN:
						{
						alt23=9;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 23, 0, input);
						throw nvae;
					}
					switch (alt23) {
						case 1 :
							// ValueEvaluatorTreeWalker.g:218:5: ( knownTS )
							{
							// ValueEvaluatorTreeWalker.g:218:5: ( knownTS )
							// ValueEvaluatorTreeWalker.g:218:6: knownTS
							{
							pushFollow(FOLLOW_knownTS_in_term1231);
							knownTS20=knownTS();
							state._fsp--;

							id =ValueEvaluation.term_knownTS(knownTS20);
							}

							}
							break;
						case 2 :
							// ValueEvaluatorTreeWalker.g:219:4: func
							{
							pushFollow(FOLLOW_func_in_term1239);
							func21=func();
							state._fsp--;

							id =func21;
							}
							break;
						case 3 :
							// ValueEvaluatorTreeWalker.g:220:4: ( INTEGER )
							{
							// ValueEvaluatorTreeWalker.g:220:4: ( INTEGER )
							// ValueEvaluatorTreeWalker.g:220:5: INTEGER
							{
							INTEGER22=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_term1246); 
							id =ValueEvaluation.term_INTEGER((INTEGER22!=null?INTEGER22.getText():null));
							}

							}
							break;
						case 4 :
							// ValueEvaluatorTreeWalker.g:221:4: tafcfs_term
							{
							pushFollow(FOLLOW_tafcfs_term_in_term1254);
							tafcfs_term23=tafcfs_term();
							state._fsp--;

							id =tafcfs_term23;
							}
							break;
						case 5 :
							// ValueEvaluatorTreeWalker.g:222:4: YEAR
							{
							match(input,YEAR,FOLLOW_YEAR_in_term1260); 
							id =ValueEvaluation.term_YEAR();
							}
							break;
						case 6 :
							// ValueEvaluatorTreeWalker.g:223:4: MONTH
							{
							match(input,MONTH,FOLLOW_MONTH_in_term1266); 
							id =ValueEvaluation.term_MONTH();
							}
							break;
						case 7 :
							// ValueEvaluatorTreeWalker.g:224:4: MONTH_CONST
							{
							MONTH_CONST24=(CommonTree)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_term1272); 
							id =ValueEvaluation.term_MONTH_CONST((MONTH_CONST24!=null?MONTH_CONST24.getText():null));
							}
							break;
						case 8 :
							// ValueEvaluatorTreeWalker.g:225:4: PASTMONTH
							{
							PASTMONTH25=(CommonTree)match(input,PASTMONTH,FOLLOW_PASTMONTH_in_term1278); 
							id =ValueEvaluation.term_PASTMONTH((PASTMONTH25!=null?PASTMONTH25.getText():null));
							}
							break;
						case 9 :
							// ValueEvaluatorTreeWalker.g:226:4: DAYSIN
							{
							match(input,DAYSIN,FOLLOW_DAYSIN_in_term1284); 
							id =ValueEvaluation.daysIn();
							}
							break;

					}

					}
					break;
				case 5 :
					// ValueEvaluatorTreeWalker.g:227:4: ( SVAR )
					{
					// ValueEvaluatorTreeWalker.g:227:4: ( SVAR )
					// ValueEvaluatorTreeWalker.g:227:5: SVAR
					{
					SVAR26=(CommonTree)match(input,SVAR,FOLLOW_SVAR_in_term1292); 
					id =ValueEvaluation.term_SVAR((SVAR26!=null?SVAR26.getText():null).replace("{","").replace("}",""));
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
	// $ANTLR end "term"



	// $ANTLR start "tafcfs_term"
	// ValueEvaluatorTreeWalker.g:230:1: tafcfs_term returns [IntDouble id] : ^( TAFCFS ( term )? ) ;
	public final IntDouble tafcfs_term() throws RecognitionException {
		IntDouble id = null;


		CommonTree TAFCFS27=null;
		IntDouble term28 =null;

		try {
			// ValueEvaluatorTreeWalker.g:230:35: ( ^( TAFCFS ( term )? ) )
			// ValueEvaluatorTreeWalker.g:230:37: ^( TAFCFS ( term )? )
			{
			TAFCFS27=(CommonTree)match(input,TAFCFS,FOLLOW_TAFCFS_in_tafcfs_term1310); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// ValueEvaluatorTreeWalker.g:230:46: ( term )?
				int alt25=2;
				int LA25_0 = input.LA(1);
				if ( (LA25_0==ABS||LA25_0==DAYSIN||LA25_0==EXP||LA25_0==FLOAT||LA25_0==IDENT||(LA25_0 >= INT && LA25_0 <= INTEGER)||(LA25_0 >= LOG && LA25_0 <= LOG10)||(LA25_0 >= MAX && LA25_0 <= MONTH_CONST)||(LA25_0 >= PASTMONTH && LA25_0 <= POW)||LA25_0==REAL||LA25_0==SVAR||LA25_0==TAFCFS||LA25_0==UNARY||LA25_0==YEAR||(LA25_0 >= 69 && LA25_0 <= 71)||LA25_0==75) ) {
					alt25=1;
				}
				switch (alt25) {
					case 1 :
						// ValueEvaluatorTreeWalker.g:230:46: term
						{
						pushFollow(FOLLOW_term_in_tafcfs_term1312);
						term28=term();
						state._fsp--;

						}
						break;

				}

				match(input, Token.UP, null); 
			}


			    id=ValueEvaluation.tafcfs_term((TAFCFS27!=null?TAFCFS27.getText():null), term28);

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
	// ValueEvaluatorTreeWalker.g:234:1: knownTS returns [IntDouble result] : ( (f= function ) | (p= pastCycleDV ) );
	public final IntDouble knownTS() throws RecognitionException {
		IntDouble result = null;


		IntDouble f =null;
		IntDouble p =null;

		try {
			// ValueEvaluatorTreeWalker.g:235:3: ( (f= function ) | (p= pastCycleDV ) )
			int alt26=2;
			int LA26_0 = input.LA(1);
			if ( (LA26_0==IDENT) ) {
				int LA26_1 = input.LA(2);
				if ( (LA26_1==DOWN) ) {
					int LA26_2 = input.LA(3);
					if ( (LA26_2==67) ) {
						alt26=1;
					}
					else if ( (LA26_2==84) ) {
						alt26=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 26, 2, input);
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
							new NoViableAltException("", 26, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}

			switch (alt26) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:235:5: (f= function )
					{
					// ValueEvaluatorTreeWalker.g:235:5: (f= function )
					// ValueEvaluatorTreeWalker.g:235:6: f= function
					{
					pushFollow(FOLLOW_function_in_knownTS1336);
					f=function();
					state._fsp--;

					result=f;
					}

					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:235:37: (p= pastCycleDV )
					{
					// ValueEvaluatorTreeWalker.g:235:37: (p= pastCycleDV )
					// ValueEvaluatorTreeWalker.g:235:38: p= pastCycleDV
					{
					pushFollow(FOLLOW_pastCycleDV_in_knownTS1343);
					p=pastCycleDV();
					state._fsp--;

					result=p;
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



	// $ANTLR start "pastCycleDV"
	// ValueEvaluatorTreeWalker.g:246:1: pastCycleDV returns [IntDouble result] : ^(i1= IDENT '[' i2= IDENT ']' ) ;
	public final IntDouble pastCycleDV() throws RecognitionException {
		IntDouble result = null;


		CommonTree i1=null;
		CommonTree i2=null;

		try {
			// ValueEvaluatorTreeWalker.g:247:3: ( ^(i1= IDENT '[' i2= IDENT ']' ) )
			// ValueEvaluatorTreeWalker.g:247:5: ^(i1= IDENT '[' i2= IDENT ']' )
			{
			i1=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pastCycleDV1381); 
			match(input, Token.DOWN, null); 
			match(input,84,FOLLOW_84_in_pastCycleDV1383); 
			i2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_pastCycleDV1387); 
			match(input,85,FOLLOW_85_in_pastCycleDV1389); 
			result=ValueEvaluation.pastCycleNoTimeArray((i1!=null?i1.getText():null),(i2!=null?i2.getText():null));
			match(input, Token.UP, null); 

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
	// $ANTLR end "pastCycleDV"



	// $ANTLR start "function"
	// ValueEvaluatorTreeWalker.g:250:1: function returns [IntDouble result] : ( (n= noArgFunction ) | (a= argFunction ) );
	public final IntDouble function() throws RecognitionException {
		IntDouble result = null;


		IntDouble n =null;
		IntDouble a =null;

		try {
			// ValueEvaluatorTreeWalker.g:251:3: ( (n= noArgFunction ) | (a= argFunction ) )
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==IDENT) ) {
				int LA27_1 = input.LA(2);
				if ( (LA27_1==DOWN) ) {
					int LA27_2 = input.LA(3);
					if ( (LA27_2==67) ) {
						int LA27_3 = input.LA(4);
						if ( (LA27_3==68) ) {
							alt27=1;
						}
						else if ( (LA27_3==ABS||LA27_3==DAYSIN||LA27_3==EXP||LA27_3==FLOAT||LA27_3==IDENT||(LA27_3 >= INT && LA27_3 <= INTEGER)||(LA27_3 >= LOG && LA27_3 <= LOG10)||(LA27_3 >= MAX && LA27_3 <= MONTH_CONST)||(LA27_3 >= PASTMONTH && LA27_3 <= POW)||LA27_3==REAL||LA27_3==SVAR||LA27_3==TAFCFS||LA27_3==UNARY||LA27_3==YEAR||(LA27_3 >= 69 && LA27_3 <= 71)||LA27_3==75) ) {
							alt27=2;
						}

						else {
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

					else {
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
					// ValueEvaluatorTreeWalker.g:251:5: (n= noArgFunction )
					{
					// ValueEvaluatorTreeWalker.g:251:5: (n= noArgFunction )
					// ValueEvaluatorTreeWalker.g:251:6: n= noArgFunction
					{
					pushFollow(FOLLOW_noArgFunction_in_function1412);
					n=noArgFunction();
					state._fsp--;

					result=n;
					}

					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:251:42: (a= argFunction )
					{
					// ValueEvaluatorTreeWalker.g:251:42: (a= argFunction )
					// ValueEvaluatorTreeWalker.g:251:43: a= argFunction
					{
					pushFollow(FOLLOW_argFunction_in_function1419);
					a=argFunction();
					state._fsp--;

					result=a;
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
	// ValueEvaluatorTreeWalker.g:254:1: noArgFunction returns [IntDouble result] : ^( IDENT '(' ')' ) ;
	public final IntDouble noArgFunction() throws RecognitionException {
		IntDouble result = null;


		CommonTree IDENT29=null;

		try {
			// ValueEvaluatorTreeWalker.g:255:3: ( ^( IDENT '(' ')' ) )
			// ValueEvaluatorTreeWalker.g:255:5: ^( IDENT '(' ')' )
			{
			IDENT29=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_noArgFunction1439); 
			match(input, Token.DOWN, null); 
			match(input,67,FOLLOW_67_in_noArgFunction1441); 
			match(input,68,FOLLOW_68_in_noArgFunction1443); 
			result=ValueEvaluation.noArgFunction((IDENT29!=null?IDENT29.getText():null));
			match(input, Token.UP, null); 

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
	// ValueEvaluatorTreeWalker.g:257:1: argFunction returns [IntDouble result] : ^( IDENT '(' (t1= term ) ( (t2= term ) )* ')' ) ;
	public final IntDouble argFunction() throws RecognitionException {
		IntDouble result = null;


		CommonTree IDENT30=null;
		IntDouble t1 =null;
		IntDouble t2 =null;

		ArrayList<ArrayList<IntDouble>> idArray = new ArrayList<ArrayList<IntDouble>>();
		try {
			// ValueEvaluatorTreeWalker.g:258:3: ( ^( IDENT '(' (t1= term ) ( (t2= term ) )* ')' ) )
			// ValueEvaluatorTreeWalker.g:258:5: ^( IDENT '(' (t1= term ) ( (t2= term ) )* ')' )
			{
			IDENT30=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_argFunction1465); 
			match(input, Token.DOWN, null); 
			match(input,67,FOLLOW_67_in_argFunction1467); 
			// ValueEvaluatorTreeWalker.g:258:17: (t1= term )
			// ValueEvaluatorTreeWalker.g:258:18: t1= term
			{
			pushFollow(FOLLOW_term_in_argFunction1472);
			t1=term();
			state._fsp--;

			ArrayList<IntDouble> idArray1=new ArrayList<IntDouble>();idArray1.add(t1);idArray.add(idArray1);
			}

			// ValueEvaluatorTreeWalker.g:258:130: ( (t2= term ) )*
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==ABS||LA28_0==DAYSIN||LA28_0==EXP||LA28_0==FLOAT||LA28_0==IDENT||(LA28_0 >= INT && LA28_0 <= INTEGER)||(LA28_0 >= LOG && LA28_0 <= LOG10)||(LA28_0 >= MAX && LA28_0 <= MONTH_CONST)||(LA28_0 >= PASTMONTH && LA28_0 <= POW)||LA28_0==REAL||LA28_0==SVAR||LA28_0==TAFCFS||LA28_0==UNARY||LA28_0==YEAR||(LA28_0 >= 69 && LA28_0 <= 71)||LA28_0==75) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:258:131: (t2= term )
					{
					// ValueEvaluatorTreeWalker.g:258:131: (t2= term )
					// ValueEvaluatorTreeWalker.g:258:132: t2= term
					{
					pushFollow(FOLLOW_term_in_argFunction1481);
					t2=term();
					state._fsp--;

					ArrayList<IntDouble> idArray1=new ArrayList<IntDouble>();idArray1.add(t2);idArray.add(idArray1);
					}

					}
					break;

				default :
					break loop28;
				}
			}

			match(input,68,FOLLOW_68_in_argFunction1487); 
			result=ValueEvaluation.argFunction((IDENT30!=null?IDENT30.getText():null),idArray);
			match(input, Token.UP, null); 

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



	// $ANTLR start "expression"
	// ValueEvaluatorTreeWalker.g:260:1: expression returns [IntDouble id] : ( ^( '+' t1= term t2= term ) | ^( '-' t3= term t4= term ) | ^( '*' t5= term t6= term ) | ^( '/' t7= term t8= term ) | ^( MOD t9= term t10= term ) | ^( UNARY t11= term ) ) ;
	public final IntDouble expression() throws RecognitionException {
		IntDouble id = null;


		IntDouble t1 =null;
		IntDouble t2 =null;
		IntDouble t3 =null;
		IntDouble t4 =null;
		IntDouble t5 =null;
		IntDouble t6 =null;
		IntDouble t7 =null;
		IntDouble t8 =null;
		IntDouble t9 =null;
		IntDouble t10 =null;
		IntDouble t11 =null;

		try {
			// ValueEvaluatorTreeWalker.g:261:3: ( ( ^( '+' t1= term t2= term ) | ^( '-' t3= term t4= term ) | ^( '*' t5= term t6= term ) | ^( '/' t7= term t8= term ) | ^( MOD t9= term t10= term ) | ^( UNARY t11= term ) ) )
			// ValueEvaluatorTreeWalker.g:261:5: ( ^( '+' t1= term t2= term ) | ^( '-' t3= term t4= term ) | ^( '*' t5= term t6= term ) | ^( '/' t7= term t8= term ) | ^( MOD t9= term t10= term ) | ^( UNARY t11= term ) )
			{
			// ValueEvaluatorTreeWalker.g:261:5: ( ^( '+' t1= term t2= term ) | ^( '-' t3= term t4= term ) | ^( '*' t5= term t6= term ) | ^( '/' t7= term t8= term ) | ^( MOD t9= term t10= term ) | ^( UNARY t11= term ) )
			int alt29=6;
			switch ( input.LA(1) ) {
			case 70:
				{
				alt29=1;
				}
				break;
			case 71:
				{
				alt29=2;
				}
				break;
			case 69:
				{
				alt29=3;
				}
				break;
			case 75:
				{
				alt29=4;
				}
				break;
			case MOD:
				{
				alt29=5;
				}
				break;
			case UNARY:
				{
				alt29=6;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 29, 0, input);
				throw nvae;
			}
			switch (alt29) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:261:6: ^( '+' t1= term t2= term )
					{
					match(input,70,FOLLOW_70_in_expression1510); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_term_in_expression1514);
					t1=term();
					state._fsp--;

					pushFollow(FOLLOW_term_in_expression1518);
					t2=term();
					state._fsp--;

					id =ValueEvaluation.add(t1, t2);
					match(input, Token.UP, null); 

					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:262:4: ^( '-' t3= term t4= term )
					{
					match(input,71,FOLLOW_71_in_expression1526); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_term_in_expression1530);
					t3=term();
					state._fsp--;

					pushFollow(FOLLOW_term_in_expression1534);
					t4=term();
					state._fsp--;

					id =ValueEvaluation.substract(t3, t4);
					match(input, Token.UP, null); 

					}
					break;
				case 3 :
					// ValueEvaluatorTreeWalker.g:263:4: ^( '*' t5= term t6= term )
					{
					match(input,69,FOLLOW_69_in_expression1542); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_term_in_expression1546);
					t5=term();
					state._fsp--;

					pushFollow(FOLLOW_term_in_expression1550);
					t6=term();
					state._fsp--;

					id =ValueEvaluation.mult(t5, t6);
					match(input, Token.UP, null); 

					}
					break;
				case 4 :
					// ValueEvaluatorTreeWalker.g:264:4: ^( '/' t7= term t8= term )
					{
					match(input,75,FOLLOW_75_in_expression1558); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_term_in_expression1562);
					t7=term();
					state._fsp--;

					pushFollow(FOLLOW_term_in_expression1566);
					t8=term();
					state._fsp--;

					id =ValueEvaluation.divide(t7, t8);
					match(input, Token.UP, null); 

					}
					break;
				case 5 :
					// ValueEvaluatorTreeWalker.g:265:4: ^( MOD t9= term t10= term )
					{
					match(input,MOD,FOLLOW_MOD_in_expression1574); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_term_in_expression1578);
					t9=term();
					state._fsp--;

					pushFollow(FOLLOW_term_in_expression1582);
					t10=term();
					state._fsp--;

					id =ValueEvaluation.mod(t9, t10);
					match(input, Token.UP, null); 

					}
					break;
				case 6 :
					// ValueEvaluatorTreeWalker.g:266:4: ^( UNARY t11= term )
					{
					match(input,UNARY,FOLLOW_UNARY_in_expression1590); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_term_in_expression1594);
					t11=term();
					state._fsp--;

					id =ValueEvaluation.unary("-", t11);
					match(input, Token.UP, null); 

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
		return id;
	}
	// $ANTLR end "expression"



	// $ANTLR start "relation"
	// ValueEvaluatorTreeWalker.g:269:1: relation returns [String text] : ( '==' | '<' | '>' | '>=' | '<=' );
	public final String relation() throws RecognitionException {
		String text = null;


		try {
			// ValueEvaluatorTreeWalker.g:270:2: ( '==' | '<' | '>' | '>=' | '<=' )
			int alt30=5;
			switch ( input.LA(1) ) {
			case 81:
				{
				alt30=1;
				}
				break;
			case 78:
				{
				alt30=2;
				}
				break;
			case 82:
				{
				alt30=3;
				}
				break;
			case 83:
				{
				alt30=4;
				}
				break;
			case 79:
				{
				alt30=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 30, 0, input);
				throw nvae;
			}
			switch (alt30) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:270:4: '=='
					{
					match(input,81,FOLLOW_81_in_relation1613); 
					text="==";
					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:271:4: '<'
					{
					match(input,78,FOLLOW_78_in_relation1619); 
					text="<";
					}
					break;
				case 3 :
					// ValueEvaluatorTreeWalker.g:272:4: '>'
					{
					match(input,82,FOLLOW_82_in_relation1625); 
					text=">";
					}
					break;
				case 4 :
					// ValueEvaluatorTreeWalker.g:273:4: '>='
					{
					match(input,83,FOLLOW_83_in_relation1631); 
					text=">=";
					}
					break;
				case 5 :
					// ValueEvaluatorTreeWalker.g:274:4: '<='
					{
					match(input,79,FOLLOW_79_in_relation1637); 
					text="<=";
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
		return text;
	}
	// $ANTLR end "relation"


	public static class whereStatement_return extends TreeRuleReturnScope {
		public String whereIdent;
		public Number value;
	};


	// $ANTLR start "whereStatement"
	// ValueEvaluatorTreeWalker.g:277:1: whereStatement returns [String whereIdent, Number value] : ^( WHERE ( (i= IDENT ) | (u= usedKeywords ) ) term ) ;
	public final ValueEvaluatorTreeWalker.whereStatement_return whereStatement() throws RecognitionException {
		ValueEvaluatorTreeWalker.whereStatement_return retval = new ValueEvaluatorTreeWalker.whereStatement_return();
		retval.start = input.LT(1);

		CommonTree i=null;
		TreeRuleReturnScope u =null;
		IntDouble term31 =null;

		try {
			// ValueEvaluatorTreeWalker.g:278:3: ( ^( WHERE ( (i= IDENT ) | (u= usedKeywords ) ) term ) )
			// ValueEvaluatorTreeWalker.g:278:5: ^( WHERE ( (i= IDENT ) | (u= usedKeywords ) ) term )
			{
			match(input,WHERE,FOLLOW_WHERE_in_whereStatement1656); 
			match(input, Token.DOWN, null); 
			// ValueEvaluatorTreeWalker.g:278:13: ( (i= IDENT ) | (u= usedKeywords ) )
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==IDENT) ) {
				alt31=1;
			}
			else if ( ((LA31_0 >= ABS && LA31_0 <= ALWAYS)||LA31_0==CASE||(LA31_0 >= CONDITION && LA31_0 <= DAYSIN)||LA31_0==DVAR||(LA31_0 >= EXPRESSION && LA31_0 <= FILE)||(LA31_0 >= FROM && LA31_0 <= GIVEN)||(LA31_0 >= INCLUDE && LA31_0 <= INT)||LA31_0==INTEGERTYPE||(LA31_0 >= LHSGTRHS && LA31_0 <= MONTH_CONST)||(LA31_0 >= NAME && LA31_0 <= RANGE)||(LA31_0 >= SELECT && LA31_0 <= SUM)||LA31_0==TAFCFS||LA31_0==TYPE||(LA31_0 >= UNITS && LA31_0 <= WHERE)||LA31_0==YEAR) ) {
				alt31=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 31, 0, input);
				throw nvae;
			}

			switch (alt31) {
				case 1 :
					// ValueEvaluatorTreeWalker.g:278:14: (i= IDENT )
					{
					// ValueEvaluatorTreeWalker.g:278:14: (i= IDENT )
					// ValueEvaluatorTreeWalker.g:278:15: i= IDENT
					{
					i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_whereStatement1662); 
					retval.whereIdent =(i!=null?i.getText():null);
					}

					}
					break;
				case 2 :
					// ValueEvaluatorTreeWalker.g:278:46: (u= usedKeywords )
					{
					// ValueEvaluatorTreeWalker.g:278:46: (u= usedKeywords )
					// ValueEvaluatorTreeWalker.g:278:47: u= usedKeywords
					{
					pushFollow(FOLLOW_usedKeywords_in_whereStatement1669);
					u=usedKeywords();
					state._fsp--;

					retval.whereIdent =(u!=null?(input.getTokenStream().toString(input.getTreeAdaptor().getTokenStartIndex(u.start),input.getTreeAdaptor().getTokenStopIndex(u.start))):null);
					}

					}
					break;

			}

			pushFollow(FOLLOW_term_in_whereStatement1674);
			term31=term();
			state._fsp--;

			retval.value =ValueEvaluation.assignWhereStatement(term31);
			match(input, Token.UP, null); 

			}

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


	public static class assignStatement_return extends TreeRuleReturnScope {
		public String assignIdent;
		public Number value;
	};


	// $ANTLR start "assignStatement"
	// ValueEvaluatorTreeWalker.g:281:1: assignStatement returns [String assignIdent, Number value] : ^( '=' IDENT term ) ;
	public final ValueEvaluatorTreeWalker.assignStatement_return assignStatement() throws RecognitionException {
		ValueEvaluatorTreeWalker.assignStatement_return retval = new ValueEvaluatorTreeWalker.assignStatement_return();
		retval.start = input.LT(1);

		CommonTree IDENT32=null;
		IntDouble term33 =null;

		try {
			// ValueEvaluatorTreeWalker.g:282:3: ( ^( '=' IDENT term ) )
			// ValueEvaluatorTreeWalker.g:282:5: ^( '=' IDENT term )
			{
			match(input,80,FOLLOW_80_in_assignStatement1697); 
			match(input, Token.DOWN, null); 
			IDENT32=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_assignStatement1699); 
			pushFollow(FOLLOW_term_in_assignStatement1702);
			term33=term();
			state._fsp--;

			retval.assignIdent =(IDENT32!=null?IDENT32.getText():null); retval.value =ValueEvaluation.assignWhereStatement(term33);
			match(input, Token.UP, null); 

			}

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
	// ValueEvaluatorTreeWalker.g:285:1: number : ( INTEGER | FLOAT );
	public final void number() throws RecognitionException {
		try {
			// ValueEvaluatorTreeWalker.g:286:2: ( INTEGER | FLOAT )
			// ValueEvaluatorTreeWalker.g:
			{
			if ( input.LA(1)==FLOAT||input.LA(1)==INTEGER ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
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

	// Delegated rules



	public static final BitSet FOLLOW_expressionInput_in_evaluator55 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_conditionInput_in_evaluator63 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_87_in_expressionInput79 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expressionCollection_in_expressionInput81 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_86_in_conditionInput90 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_conditionStatement_in_conditionInput92 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_term_in_lhsrhs105 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONSTRAIN_in_lhsrhs107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_units116 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_units119 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_75_in_units121 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IDENT_in_units123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_76_in_fileName135 = new BitSet(new long[]{0xFADBF7FF7FFEBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_77_in_fileName137 = new BitSet(new long[]{0xFADBF7FF7FFEBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_72_in_fileName139 = new BitSet(new long[]{0xFADBF7FF7FFEBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_88_in_fileName141 = new BitSet(new long[]{0xFADBF7FF7FFEBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_SYMBOLS_in_fileName143 = new BitSet(new long[]{0xFADBF7FF7FFEBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_71_in_fileName145 = new BitSet(new long[]{0xFADBF7FF7FFEBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_70_in_fileName147 = new BitSet(new long[]{0xFADBF7FF7FFEBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_BACKSLASH_in_fileName149 = new BitSet(new long[]{0xFADBF7FF7FFEBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_IDENT_in_fileName151 = new BitSet(new long[]{0xFADBF7FF7FFEBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_IDENT1_in_fileName153 = new BitSet(new long[]{0xFADBF7FF7FFEBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_IDENT2_in_fileName155 = new BitSet(new long[]{0xFADBF7FF7FFEBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_INTEGER_in_fileName157 = new BitSet(new long[]{0xFADBF7FF7FFEBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_FLOAT_in_fileName159 = new BitSet(new long[]{0xFADBF7FF7FFEBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_usedKeywords_in_fileName161 = new BitSet(new long[]{0xFADBF7FF7FFEBEF2L,0x00000000010031C5L});
	public static final BitSet FOLLOW_77_in_externalFile180 = new BitSet(new long[]{0xFADBF7FF79FEBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_72_in_externalFile182 = new BitSet(new long[]{0xFADBF7FF79FEBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_88_in_externalFile184 = new BitSet(new long[]{0xFADBF7FF79FEBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_SYMBOLS_in_externalFile186 = new BitSet(new long[]{0xFADBF7FF79FEBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_71_in_externalFile188 = new BitSet(new long[]{0xFADBF7FF79FEBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_70_in_externalFile190 = new BitSet(new long[]{0xFADBF7FF79FEBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_INTEGER_in_externalFile192 = new BitSet(new long[]{0xFADBF7FF79FEBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_FLOAT_in_externalFile194 = new BitSet(new long[]{0xFADBF7FF79FEBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_IDENT_in_externalFile196 = new BitSet(new long[]{0xFADBF7FF79FEBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_usedKeywords_in_externalFile198 = new BitSet(new long[]{0xFADBF7FF79FEBEB2L,0x00000000010021C5L});
	public static final BitSet FOLLOW_LETTER_in_text212 = new BitSet(new long[]{0x0000000080004002L});
	public static final BitSet FOLLOW_relationStatementTerm_in_conditionStatement239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALWAYS_in_conditionStatement243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_relationRangeStatement_in_relationStatementTerm265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_relationStatementSeries_in_relationStatementTerm270 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_relationStatementSeries294 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_relationStatementTerm_in_relationStatementSeries303 = new BitSet(new long[]{0x0002000000000000L,0x00000000000EC600L});
	public static final BitSet FOLLOW_relationStatementTerm_in_relationStatementSeries315 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_relationStatement_in_relationRangeStatement338 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_range_func_in_relationRangeStatement345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_relation_in_relationStatement368 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_relationStatement372 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_relationStatement376 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_term_in_expressionCollection397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tableSQL_in_expressionCollection404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timeseriesWithUnits_in_expressionCollection411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timeseries_in_expressionCollection418 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sumExpression_in_expressionCollection426 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPPERUNBOUNDED_in_expressionCollection434 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOWERUNBOUNDED_in_expressionCollection441 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_max_func_in_func459 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_min_func_in_func467 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_int_func_in_func475 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_real_func_in_func483 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_abs_func_in_func491 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exp_func_in_func499 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_log_func_in_func507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_log10_func_in_func515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pow_func_in_func523 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAX_in_max_func539 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_max_func544 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_max_func551 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MIN_in_min_func569 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_min_func574 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_min_func581 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_INT_in_int_func601 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_int_func606 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_REAL_in_real_func629 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_real_func634 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ABS_in_abs_func657 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_abs_func662 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EXP_in_exp_func683 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_exp_func688 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOG_in_log_func709 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_log_func714 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_LOG10_in_log10_func735 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_log10_func740 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_POW_in_pow_func763 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_pow_func768 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_pow_func774 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_RANGE_in_range_func798 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_MONTH_in_range_func801 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_range_func805 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_MONTH_CONST_in_range_func809 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_TIMESERIES_in_timeseriesWithUnits822 = new BitSet(new long[]{0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_89_in_timeseriesWithUnits824 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_timeseriesWithUnits826 = new BitSet(new long[]{0xFA9BF7FF5BF6BEB0L,0x0000000000000005L});
	public static final BitSet FOLLOW_partC_in_timeseriesWithUnits828 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_90_in_timeseriesWithUnits830 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_80_in_timeseriesWithUnits832 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IDENT_in_timeseriesWithUnits834 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TIMESERIES_in_timeseries850 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_partC867 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_IDENT1_in_partC869 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_usedKeywords_in_partC871 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_71_in_partC875 = new BitSet(new long[]{0xFA9BF7FF5BF6BEB0L,0x0000000000000005L});
	public static final BitSet FOLLOW_IDENT_in_partC878 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_IDENT1_in_partC880 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_usedKeywords_in_partC882 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
	public static final BitSet FOLLOW_SELECT_in_tableSQL1004 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_selectName_in_tableSQL1007 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IDENT_in_tableSQL1013 = new BitSet(new long[]{0x0000000001000008L,0x0000000000010001L});
	public static final BitSet FOLLOW_assignStatement_in_tableSQL1023 = new BitSet(new long[]{0x0000000001000008L,0x0000000000000001L});
	public static final BitSet FOLLOW_IDENT_in_tableSQL1031 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000001L});
	public static final BitSet FOLLOW_where_items_in_tableSQL1041 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENT_in_selectName1061 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_usedKeywords_in_selectName1064 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_where_items1080 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_whereStatement_in_where_items1086 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000001L});
	public static final BitSet FOLLOW_whereStatement_in_where_items1102 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000001L});
	public static final BitSet FOLLOW_SUM_in_sumExpression1144 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_sumExpression1146 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_sumExpression1151 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_sumExpression1155 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_71_in_sumExpression1160 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_INTEGER_in_sumExpression1165 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_sumExpression1179 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENT_in_term1198 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_term1207 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_term1220 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_knownTS_in_term1231 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_func_in_term1239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_term1246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tafcfs_term_in_term1254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_YEAR_in_term1260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONTH_in_term1266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MONTH_CONST_in_term1272 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PASTMONTH_in_term1278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DAYSIN_in_term1284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SVAR_in_term1292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TAFCFS_in_tafcfs_term1310 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_tafcfs_term1312 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_function_in_knownTS1336 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pastCycleDV_in_knownTS1343 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleDV1381 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_84_in_pastCycleDV1383 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_IDENT_in_pastCycleDV1387 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_85_in_pastCycleDV1389 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_noArgFunction_in_function1412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_argFunction_in_function1419 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_noArgFunction1439 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_67_in_noArgFunction1441 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
	public static final BitSet FOLLOW_68_in_noArgFunction1443 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENT_in_argFunction1465 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_67_in_argFunction1467 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_argFunction1472 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008F4L});
	public static final BitSet FOLLOW_term_in_argFunction1481 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008F4L});
	public static final BitSet FOLLOW_68_in_argFunction1487 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_70_in_expression1510 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_expression1514 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_expression1518 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_71_in_expression1526 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_expression1530 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_expression1534 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_69_in_expression1542 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_expression1546 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_expression1550 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_75_in_expression1558 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_expression1562 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_expression1566 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_MOD_in_expression1574 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_expression1578 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_expression1582 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_UNARY_in_expression1590 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_term_in_expression1594 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_81_in_relation1613 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_78_in_relation1619 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_82_in_relation1625 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_83_in_relation1631 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_79_in_relation1637 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_whereStatement1656 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_whereStatement1662 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_usedKeywords_in_whereStatement1669 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_whereStatement1674 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_80_in_assignStatement1697 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_assignStatement1699 = new BitSet(new long[]{0x04A587CC31092010L,0x00000000000008E4L});
	public static final BitSet FOLLOW_term_in_assignStatement1702 = new BitSet(new long[]{0x0000000000000008L});
}
