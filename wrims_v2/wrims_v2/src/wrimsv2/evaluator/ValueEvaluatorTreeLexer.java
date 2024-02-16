// $ANTLR 3.5.2 ValueEvaluatorTree.g 2024-02-12 13:09:12

  package wrimsv2.evaluator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ValueEvaluatorTreeLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public ValueEvaluatorTreeLexer() {} 
	public ValueEvaluatorTreeLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public ValueEvaluatorTreeLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "ValueEvaluatorTree.g"; }

	// $ANTLR start "T__67"
	public final void mT__67() throws RecognitionException {
		try {
			int _type = T__67;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:11:7: ( '(' )
			// ValueEvaluatorTree.g:11:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__67"

	// $ANTLR start "T__68"
	public final void mT__68() throws RecognitionException {
		try {
			int _type = T__68;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:12:7: ( ')' )
			// ValueEvaluatorTree.g:12:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__68"

	// $ANTLR start "T__69"
	public final void mT__69() throws RecognitionException {
		try {
			int _type = T__69;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:13:7: ( '*' )
			// ValueEvaluatorTree.g:13:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__69"

	// $ANTLR start "T__70"
	public final void mT__70() throws RecognitionException {
		try {
			int _type = T__70;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:14:7: ( '+' )
			// ValueEvaluatorTree.g:14:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__70"

	// $ANTLR start "T__71"
	public final void mT__71() throws RecognitionException {
		try {
			int _type = T__71;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:15:7: ( '-' )
			// ValueEvaluatorTree.g:15:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__71"

	// $ANTLR start "T__72"
	public final void mT__72() throws RecognitionException {
		try {
			int _type = T__72;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:16:7: ( '.' )
			// ValueEvaluatorTree.g:16:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__72"

	// $ANTLR start "T__73"
	public final void mT__73() throws RecognitionException {
		try {
			int _type = T__73;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:17:7: ( '.and.' )
			// ValueEvaluatorTree.g:17:9: '.and.'
			{
			match(".and."); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__73"

	// $ANTLR start "T__74"
	public final void mT__74() throws RecognitionException {
		try {
			int _type = T__74;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:18:7: ( '.or.' )
			// ValueEvaluatorTree.g:18:9: '.or.'
			{
			match(".or."); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__74"

	// $ANTLR start "T__75"
	public final void mT__75() throws RecognitionException {
		try {
			int _type = T__75;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:19:7: ( '/' )
			// ValueEvaluatorTree.g:19:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__75"

	// $ANTLR start "T__76"
	public final void mT__76() throws RecognitionException {
		try {
			int _type = T__76;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:20:7: ( ':' )
			// ValueEvaluatorTree.g:20:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__76"

	// $ANTLR start "T__77"
	public final void mT__77() throws RecognitionException {
		try {
			int _type = T__77;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:21:7: ( ';' )
			// ValueEvaluatorTree.g:21:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__77"

	// $ANTLR start "T__78"
	public final void mT__78() throws RecognitionException {
		try {
			int _type = T__78;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:22:7: ( '<' )
			// ValueEvaluatorTree.g:22:9: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__78"

	// $ANTLR start "T__79"
	public final void mT__79() throws RecognitionException {
		try {
			int _type = T__79;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:23:7: ( '<=' )
			// ValueEvaluatorTree.g:23:9: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__79"

	// $ANTLR start "T__80"
	public final void mT__80() throws RecognitionException {
		try {
			int _type = T__80;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:24:7: ( '=' )
			// ValueEvaluatorTree.g:24:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__80"

	// $ANTLR start "T__81"
	public final void mT__81() throws RecognitionException {
		try {
			int _type = T__81;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:25:7: ( '==' )
			// ValueEvaluatorTree.g:25:9: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__81"

	// $ANTLR start "T__82"
	public final void mT__82() throws RecognitionException {
		try {
			int _type = T__82;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:26:7: ( '>' )
			// ValueEvaluatorTree.g:26:9: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__82"

	// $ANTLR start "T__83"
	public final void mT__83() throws RecognitionException {
		try {
			int _type = T__83;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:27:7: ( '>=' )
			// ValueEvaluatorTree.g:27:9: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__83"

	// $ANTLR start "T__84"
	public final void mT__84() throws RecognitionException {
		try {
			int _type = T__84;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:28:7: ( '[' )
			// ValueEvaluatorTree.g:28:9: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__84"

	// $ANTLR start "T__85"
	public final void mT__85() throws RecognitionException {
		try {
			int _type = T__85;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:29:7: ( ']' )
			// ValueEvaluatorTree.g:29:9: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__85"

	// $ANTLR start "T__86"
	public final void mT__86() throws RecognitionException {
		try {
			int _type = T__86;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:30:7: ( 'c:' )
			// ValueEvaluatorTree.g:30:9: 'c:'
			{
			match("c:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__86"

	// $ANTLR start "T__87"
	public final void mT__87() throws RecognitionException {
		try {
			int _type = T__87;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:31:7: ( 'v:' )
			// ValueEvaluatorTree.g:31:9: 'v:'
			{
			match("v:"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__87"

	// $ANTLR start "T__88"
	public final void mT__88() throws RecognitionException {
		try {
			int _type = T__88;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:32:7: ( '|' )
			// ValueEvaluatorTree.g:32:9: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__88"

	// $ANTLR start "MULTILINE_COMMENT"
	public final void mMULTILINE_COMMENT() throws RecognitionException {
		try {
			int _type = MULTILINE_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:284:19: ( '/*' ( . )* '*/' )
			// ValueEvaluatorTree.g:284:21: '/*' ( . )* '*/'
			{
			match("/*"); 

			// ValueEvaluatorTree.g:284:26: ( . )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0=='*') ) {
					int LA1_1 = input.LA(2);
					if ( (LA1_1=='/') ) {
						alt1=2;
					}
					else if ( ((LA1_1 >= '\u0000' && LA1_1 <= '.')||(LA1_1 >= '0' && LA1_1 <= '\uFFFF')) ) {
						alt1=1;
					}

				}
				else if ( ((LA1_0 >= '\u0000' && LA1_0 <= ')')||(LA1_0 >= '+' && LA1_0 <= '\uFFFF')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// ValueEvaluatorTree.g:284:26: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop1;
				}
			}

			match("*/"); 

			_channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MULTILINE_COMMENT"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// ValueEvaluatorTree.g:286:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
			// ValueEvaluatorTree.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// ValueEvaluatorTree.g:287:16: ( '0' .. '9' )
			// ValueEvaluatorTree.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "SYMBOLS"
	public final void mSYMBOLS() throws RecognitionException {
		try {
			// ValueEvaluatorTree.g:288:18: ( '_' )
			// ValueEvaluatorTree.g:288:20: '_'
			{
			match('_'); 
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SYMBOLS"

	// $ANTLR start "BACKSLASH"
	public final void mBACKSLASH() throws RecognitionException {
		try {
			int _type = BACKSLASH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:290:11: ( '\\\\' )
			// ValueEvaluatorTree.g:290:13: '\\\\'
			{
			match('\\'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BACKSLASH"

	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:292:9: ( ( DIGIT )+ )
			// ValueEvaluatorTree.g:292:11: ( DIGIT )+
			{
			// ValueEvaluatorTree.g:292:11: ( DIGIT )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// ValueEvaluatorTree.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTEGER"

	// $ANTLR start "FLOAT"
	public final void mFLOAT() throws RecognitionException {
		try {
			int _type = FLOAT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:293:7: ( ( INTEGER )? '.' INTEGER | INTEGER '.' )
			int alt4=2;
			alt4 = dfa4.predict(input);
			switch (alt4) {
				case 1 :
					// ValueEvaluatorTree.g:293:9: ( INTEGER )? '.' INTEGER
					{
					// ValueEvaluatorTree.g:293:9: ( INTEGER )?
					int alt3=2;
					int LA3_0 = input.LA(1);
					if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
						alt3=1;
					}
					switch (alt3) {
						case 1 :
							// ValueEvaluatorTree.g:293:9: INTEGER
							{
							mINTEGER(); 

							}
							break;

					}

					match('.'); 
					mINTEGER(); 

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:294:6: INTEGER '.'
					{
					mINTEGER(); 

					match('.'); 
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FLOAT"

	// $ANTLR start "YEAR"
	public final void mYEAR() throws RecognitionException {
		try {
			int _type = YEAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:298:5: ( 'wateryear' )
			// ValueEvaluatorTree.g:298:7: 'wateryear'
			{
			match("wateryear"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "YEAR"

	// $ANTLR start "MONTH"
	public final void mMONTH() throws RecognitionException {
		try {
			int _type = MONTH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:299:6: ( 'month' )
			// ValueEvaluatorTree.g:299:8: 'month'
			{
			match("month"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MONTH"

	// $ANTLR start "MONTH_CONST"
	public final void mMONTH_CONST() throws RecognitionException {
		try {
			int _type = MONTH_CONST;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:300:12: ( 'jan' | 'feb' | 'mar' | 'apr' | 'may' | 'jun' | 'jul' | 'aug' | 'sep' | 'oct' | 'nov' | 'dec' )
			int alt5=12;
			switch ( input.LA(1) ) {
			case 'j':
				{
				int LA5_1 = input.LA(2);
				if ( (LA5_1=='a') ) {
					alt5=1;
				}
				else if ( (LA5_1=='u') ) {
					int LA5_10 = input.LA(3);
					if ( (LA5_10=='n') ) {
						alt5=6;
					}
					else if ( (LA5_10=='l') ) {
						alt5=7;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 5, 10, input);
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
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'f':
				{
				alt5=2;
				}
				break;
			case 'm':
				{
				int LA5_3 = input.LA(2);
				if ( (LA5_3=='a') ) {
					int LA5_11 = input.LA(3);
					if ( (LA5_11=='r') ) {
						alt5=3;
					}
					else if ( (LA5_11=='y') ) {
						alt5=5;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 5, 11, input);
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
							new NoViableAltException("", 5, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'a':
				{
				int LA5_4 = input.LA(2);
				if ( (LA5_4=='p') ) {
					alt5=4;
				}
				else if ( (LA5_4=='u') ) {
					alt5=8;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 4, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 's':
				{
				alt5=9;
				}
				break;
			case 'o':
				{
				alt5=10;
				}
				break;
			case 'n':
				{
				alt5=11;
				}
				break;
			case 'd':
				{
				alt5=12;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// ValueEvaluatorTree.g:300:14: 'jan'
					{
					match("jan"); 

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:300:20: 'feb'
					{
					match("feb"); 

					}
					break;
				case 3 :
					// ValueEvaluatorTree.g:300:26: 'mar'
					{
					match("mar"); 

					}
					break;
				case 4 :
					// ValueEvaluatorTree.g:300:32: 'apr'
					{
					match("apr"); 

					}
					break;
				case 5 :
					// ValueEvaluatorTree.g:300:38: 'may'
					{
					match("may"); 

					}
					break;
				case 6 :
					// ValueEvaluatorTree.g:300:44: 'jun'
					{
					match("jun"); 

					}
					break;
				case 7 :
					// ValueEvaluatorTree.g:300:50: 'jul'
					{
					match("jul"); 

					}
					break;
				case 8 :
					// ValueEvaluatorTree.g:300:56: 'aug'
					{
					match("aug"); 

					}
					break;
				case 9 :
					// ValueEvaluatorTree.g:300:62: 'sep'
					{
					match("sep"); 

					}
					break;
				case 10 :
					// ValueEvaluatorTree.g:300:68: 'oct'
					{
					match("oct"); 

					}
					break;
				case 11 :
					// ValueEvaluatorTree.g:300:74: 'nov'
					{
					match("nov"); 

					}
					break;
				case 12 :
					// ValueEvaluatorTree.g:300:80: 'dec'
					{
					match("dec"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MONTH_CONST"

	// $ANTLR start "PASTMONTH"
	public final void mPASTMONTH() throws RecognitionException {
		try {
			int _type = PASTMONTH;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:301:10: ( 'prevjan' | 'prevfeb' | 'prevmar' | 'prevapr' | 'prevmay' | 'prevjun' | 'prevjul' | 'prevaug' | 'prevsep' | 'prevoct' | 'prevnov' | 'prevdec' )
			int alt6=12;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='p') ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1=='r') ) {
					int LA6_2 = input.LA(3);
					if ( (LA6_2=='e') ) {
						int LA6_3 = input.LA(4);
						if ( (LA6_3=='v') ) {
							switch ( input.LA(5) ) {
							case 'j':
								{
								int LA6_5 = input.LA(6);
								if ( (LA6_5=='a') ) {
									alt6=1;
								}
								else if ( (LA6_5=='u') ) {
									int LA6_14 = input.LA(7);
									if ( (LA6_14=='n') ) {
										alt6=6;
									}
									else if ( (LA6_14=='l') ) {
										alt6=7;
									}

									else {
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 6, 14, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 6, 5, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case 'f':
								{
								alt6=2;
								}
								break;
							case 'm':
								{
								int LA6_7 = input.LA(6);
								if ( (LA6_7=='a') ) {
									int LA6_15 = input.LA(7);
									if ( (LA6_15=='r') ) {
										alt6=3;
									}
									else if ( (LA6_15=='y') ) {
										alt6=5;
									}

									else {
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 6, 15, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 6, 7, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case 'a':
								{
								int LA6_8 = input.LA(6);
								if ( (LA6_8=='p') ) {
									alt6=4;
								}
								else if ( (LA6_8=='u') ) {
									alt6=8;
								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 6, 8, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

								}
								break;
							case 's':
								{
								alt6=9;
								}
								break;
							case 'o':
								{
								alt6=10;
								}
								break;
							case 'n':
								{
								alt6=11;
								}
								break;
							case 'd':
								{
								alt6=12;
								}
								break;
							default:
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 6, 4, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 6, 3, input);
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
								new NoViableAltException("", 6, 2, input);
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
							new NoViableAltException("", 6, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// ValueEvaluatorTree.g:301:12: 'prevjan'
					{
					match("prevjan"); 

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:301:22: 'prevfeb'
					{
					match("prevfeb"); 

					}
					break;
				case 3 :
					// ValueEvaluatorTree.g:301:32: 'prevmar'
					{
					match("prevmar"); 

					}
					break;
				case 4 :
					// ValueEvaluatorTree.g:301:42: 'prevapr'
					{
					match("prevapr"); 

					}
					break;
				case 5 :
					// ValueEvaluatorTree.g:301:52: 'prevmay'
					{
					match("prevmay"); 

					}
					break;
				case 6 :
					// ValueEvaluatorTree.g:301:62: 'prevjun'
					{
					match("prevjun"); 

					}
					break;
				case 7 :
					// ValueEvaluatorTree.g:301:72: 'prevjul'
					{
					match("prevjul"); 

					}
					break;
				case 8 :
					// ValueEvaluatorTree.g:301:82: 'prevaug'
					{
					match("prevaug"); 

					}
					break;
				case 9 :
					// ValueEvaluatorTree.g:301:92: 'prevsep'
					{
					match("prevsep"); 

					}
					break;
				case 10 :
					// ValueEvaluatorTree.g:301:102: 'prevoct'
					{
					match("prevoct"); 

					}
					break;
				case 11 :
					// ValueEvaluatorTree.g:301:112: 'prevnov'
					{
					match("prevnov"); 

					}
					break;
				case 12 :
					// ValueEvaluatorTree.g:301:122: 'prevdec'
					{
					match("prevdec"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PASTMONTH"

	// $ANTLR start "RANGE"
	public final void mRANGE() throws RecognitionException {
		try {
			int _type = RANGE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:302:6: ( 'range' )
			// ValueEvaluatorTree.g:302:8: 'range'
			{
			match("range"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RANGE"

	// $ANTLR start "TAFCFS"
	public final void mTAFCFS() throws RecognitionException {
		try {
			int _type = TAFCFS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:304:7: ( 'taf_cfs' | 'cfs_taf' | 'cfs_af' | 'af_cfs' )
			int alt7=4;
			switch ( input.LA(1) ) {
			case 't':
				{
				alt7=1;
				}
				break;
			case 'c':
				{
				int LA7_2 = input.LA(2);
				if ( (LA7_2=='f') ) {
					int LA7_4 = input.LA(3);
					if ( (LA7_4=='s') ) {
						int LA7_5 = input.LA(4);
						if ( (LA7_5=='_') ) {
							int LA7_6 = input.LA(5);
							if ( (LA7_6=='t') ) {
								alt7=2;
							}
							else if ( (LA7_6=='a') ) {
								alt7=3;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 7, 6, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 7, 5, input);
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
								new NoViableAltException("", 7, 4, input);
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
							new NoViableAltException("", 7, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 'a':
				{
				alt7=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}
			switch (alt7) {
				case 1 :
					// ValueEvaluatorTree.g:304:9: 'taf_cfs'
					{
					match("taf_cfs"); 

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:304:19: 'cfs_taf'
					{
					match("cfs_taf"); 

					}
					break;
				case 3 :
					// ValueEvaluatorTree.g:304:29: 'cfs_af'
					{
					match("cfs_af"); 

					}
					break;
				case 4 :
					// ValueEvaluatorTree.g:304:38: 'af_cfs'
					{
					match("af_cfs"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TAFCFS"

	// $ANTLR start "DAYSIN"
	public final void mDAYSIN() throws RecognitionException {
		try {
			int _type = DAYSIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:305:7: ( 'daysin' | 'daysinmonth' )
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='d') ) {
				int LA8_1 = input.LA(2);
				if ( (LA8_1=='a') ) {
					int LA8_2 = input.LA(3);
					if ( (LA8_2=='y') ) {
						int LA8_3 = input.LA(4);
						if ( (LA8_3=='s') ) {
							int LA8_4 = input.LA(5);
							if ( (LA8_4=='i') ) {
								int LA8_5 = input.LA(6);
								if ( (LA8_5=='n') ) {
									int LA8_6 = input.LA(7);
									if ( (LA8_6=='m') ) {
										alt8=2;
									}

									else {
										alt8=1;
									}

								}

								else {
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 8, 5, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 8, 4, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 8, 3, input);
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
								new NoViableAltException("", 8, 2, input);
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
							new NoViableAltException("", 8, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				throw nvae;
			}

			switch (alt8) {
				case 1 :
					// ValueEvaluatorTree.g:305:9: 'daysin'
					{
					match("daysin"); 

					}
					break;
				case 2 :
					// ValueEvaluatorTree.g:305:18: 'daysinmonth'
					{
					match("daysinmonth"); 

					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DAYSIN"

	// $ANTLR start "SUM"
	public final void mSUM() throws RecognitionException {
		try {
			int _type = SUM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:307:4: ( 'sum' )
			// ValueEvaluatorTree.g:307:6: 'sum'
			{
			match("sum"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SUM"

	// $ANTLR start "MAX"
	public final void mMAX() throws RecognitionException {
		try {
			int _type = MAX;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:308:5: ( 'max' )
			// ValueEvaluatorTree.g:308:7: 'max'
			{
			match("max"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MAX"

	// $ANTLR start "MIN"
	public final void mMIN() throws RecognitionException {
		try {
			int _type = MIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:309:5: ( 'min' )
			// ValueEvaluatorTree.g:309:7: 'min'
			{
			match("min"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MIN"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:310:5: ( 'int' )
			// ValueEvaluatorTree.g:310:7: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "REAL"
	public final void mREAL() throws RecognitionException {
		try {
			int _type = REAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:311:5: ( 'real' )
			// ValueEvaluatorTree.g:311:7: 'real'
			{
			match("real"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "REAL"

	// $ANTLR start "ABS"
	public final void mABS() throws RecognitionException {
		try {
			int _type = ABS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:312:4: ( 'abs' )
			// ValueEvaluatorTree.g:312:6: 'abs'
			{
			match("abs"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ABS"

	// $ANTLR start "EXP"
	public final void mEXP() throws RecognitionException {
		try {
			int _type = EXP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:313:4: ( 'exp' )
			// ValueEvaluatorTree.g:313:6: 'exp'
			{
			match("exp"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXP"

	// $ANTLR start "LOG"
	public final void mLOG() throws RecognitionException {
		try {
			int _type = LOG;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:314:4: ( 'log' )
			// ValueEvaluatorTree.g:314:6: 'log'
			{
			match("log"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOG"

	// $ANTLR start "LOG10"
	public final void mLOG10() throws RecognitionException {
		try {
			int _type = LOG10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:315:6: ( 'log10' )
			// ValueEvaluatorTree.g:315:8: 'log10'
			{
			match("log10"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOG10"

	// $ANTLR start "POW"
	public final void mPOW() throws RecognitionException {
		try {
			int _type = POW;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:316:4: ( 'pow' )
			// ValueEvaluatorTree.g:316:6: 'pow'
			{
			match("pow"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "POW"

	// $ANTLR start "MOD"
	public final void mMOD() throws RecognitionException {
		try {
			int _type = MOD;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:317:4: ( 'mod' )
			// ValueEvaluatorTree.g:317:6: 'mod'
			{
			match("mod"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "MOD"

	// $ANTLR start "UNARY"
	public final void mUNARY() throws RecognitionException {
		try {
			int _type = UNARY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:318:6: ( 'unary' )
			// ValueEvaluatorTree.g:318:8: 'unary'
			{
			match("unary"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNARY"

	// $ANTLR start "SELECT"
	public final void mSELECT() throws RecognitionException {
		try {
			int _type = SELECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:320:7: ( 'select' )
			// ValueEvaluatorTree.g:320:9: 'select'
			{
			match("select"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SELECT"

	// $ANTLR start "FROM"
	public final void mFROM() throws RecognitionException {
		try {
			int _type = FROM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:321:5: ( 'from' )
			// ValueEvaluatorTree.g:321:7: 'from'
			{
			match("from"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FROM"

	// $ANTLR start "GIVEN"
	public final void mGIVEN() throws RecognitionException {
		try {
			int _type = GIVEN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:322:6: ( 'given' )
			// ValueEvaluatorTree.g:322:8: 'given'
			{
			match("given"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GIVEN"

	// $ANTLR start "USE"
	public final void mUSE() throws RecognitionException {
		try {
			int _type = USE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:323:4: ( 'use' )
			// ValueEvaluatorTree.g:323:6: 'use'
			{
			match("use"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "USE"

	// $ANTLR start "WHERE"
	public final void mWHERE() throws RecognitionException {
		try {
			int _type = WHERE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:324:7: ( 'where' )
			// ValueEvaluatorTree.g:324:9: 'where'
			{
			match("where"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHERE"

	// $ANTLR start "TIMESERIES"
	public final void mTIMESERIES() throws RecognitionException {
		try {
			int _type = TIMESERIES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:325:11: ( 'timeseries' )
			// ValueEvaluatorTree.g:325:13: 'timeseries'
			{
			match("timeseries"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TIMESERIES"

	// $ANTLR start "CONSTRAIN"
	public final void mCONSTRAIN() throws RecognitionException {
		try {
			int _type = CONSTRAIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:327:10: ( 'constrain' )
			// ValueEvaluatorTree.g:327:12: 'constrain'
			{
			match("constrain"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONSTRAIN"

	// $ANTLR start "ALWAYS"
	public final void mALWAYS() throws RecognitionException {
		try {
			int _type = ALWAYS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:328:7: ( 'always' )
			// ValueEvaluatorTree.g:328:9: 'always'
			{
			match("always"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ALWAYS"

	// $ANTLR start "NAME"
	public final void mNAME() throws RecognitionException {
		try {
			int _type = NAME;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:330:5: ( 'name' )
			// ValueEvaluatorTree.g:330:7: 'name'
			{
			match("name"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NAME"

	// $ANTLR start "DVAR"
	public final void mDVAR() throws RecognitionException {
		try {
			int _type = DVAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:331:5: ( 'dvar' )
			// ValueEvaluatorTree.g:331:7: 'dvar'
			{
			match("dvar"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DVAR"

	// $ANTLR start "CYCLE"
	public final void mCYCLE() throws RecognitionException {
		try {
			int _type = CYCLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:332:6: ( 'cycle' )
			// ValueEvaluatorTree.g:332:8: 'cycle'
			{
			match("cycle"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CYCLE"

	// $ANTLR start "FILE"
	public final void mFILE() throws RecognitionException {
		try {
			int _type = FILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:333:5: ( 'file' )
			// ValueEvaluatorTree.g:333:7: 'file'
			{
			match("file"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FILE"

	// $ANTLR start "CONDITION"
	public final void mCONDITION() throws RecognitionException {
		try {
			int _type = CONDITION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:334:10: ( 'condition' )
			// ValueEvaluatorTree.g:334:12: 'condition'
			{
			match("condition"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONDITION"

	// $ANTLR start "INCLUDE"
	public final void mINCLUDE() throws RecognitionException {
		try {
			int _type = INCLUDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:335:8: ( 'include' )
			// ValueEvaluatorTree.g:335:10: 'include'
			{
			match("include"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INCLUDE"

	// $ANTLR start "LOWERBOUND"
	public final void mLOWERBOUND() throws RecognitionException {
		try {
			int _type = LOWERBOUND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:336:11: ( 'lower_bound' )
			// ValueEvaluatorTree.g:336:13: 'lower_bound'
			{
			match("lower_bound"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOWERBOUND"

	// $ANTLR start "UPPERBOUND"
	public final void mUPPERBOUND() throws RecognitionException {
		try {
			int _type = UPPERBOUND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:337:11: ( 'upper_bound' )
			// ValueEvaluatorTree.g:337:13: 'upper_bound'
			{
			match("upper_bound"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPPERBOUND"

	// $ANTLR start "INTEGERTYPE"
	public final void mINTEGERTYPE() throws RecognitionException {
		try {
			int _type = INTEGERTYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:338:12: ( 'integer' )
			// ValueEvaluatorTree.g:338:14: 'integer'
			{
			match("integer"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTEGERTYPE"

	// $ANTLR start "UNITS"
	public final void mUNITS() throws RecognitionException {
		try {
			int _type = UNITS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:339:6: ( 'units' )
			// ValueEvaluatorTree.g:339:8: 'units'
			{
			match("units"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNITS"

	// $ANTLR start "CONVERTUNITS"
	public final void mCONVERTUNITS() throws RecognitionException {
		try {
			int _type = CONVERTUNITS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:340:13: ( 'convert_to_units' )
			// ValueEvaluatorTree.g:340:15: 'convert_to_units'
			{
			match("convert_to_units"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CONVERTUNITS"

	// $ANTLR start "TYPE"
	public final void mTYPE() throws RecognitionException {
		try {
			int _type = TYPE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:341:5: ( 'type' )
			// ValueEvaluatorTree.g:341:7: 'type'
			{
			match("type"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TYPE"

	// $ANTLR start "OUTPUT"
	public final void mOUTPUT() throws RecognitionException {
		try {
			int _type = OUTPUT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:342:7: ( 'output' )
			// ValueEvaluatorTree.g:342:9: 'output'
			{
			match("output"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OUTPUT"

	// $ANTLR start "CASE"
	public final void mCASE() throws RecognitionException {
		try {
			int _type = CASE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:343:5: ( 'case' )
			// ValueEvaluatorTree.g:343:7: 'case'
			{
			match("case"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CASE"

	// $ANTLR start "ORDER"
	public final void mORDER() throws RecognitionException {
		try {
			int _type = ORDER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:344:6: ( 'order' )
			// ValueEvaluatorTree.g:344:8: 'order'
			{
			match("order"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ORDER"

	// $ANTLR start "EXPRESSION"
	public final void mEXPRESSION() throws RecognitionException {
		try {
			int _type = EXPRESSION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:345:11: ( 'expression' )
			// ValueEvaluatorTree.g:345:13: 'expression'
			{
			match("expression"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EXPRESSION"

	// $ANTLR start "LHSGTRHS"
	public final void mLHSGTRHS() throws RecognitionException {
		try {
			int _type = LHSGTRHS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:346:9: ( 'lhs_gt_rhs' )
			// ValueEvaluatorTree.g:346:11: 'lhs_gt_rhs'
			{
			match("lhs_gt_rhs"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LHSGTRHS"

	// $ANTLR start "LHSLTRHS"
	public final void mLHSLTRHS() throws RecognitionException {
		try {
			int _type = LHSLTRHS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:347:9: ( 'lhs_lt_rhs' )
			// ValueEvaluatorTree.g:347:11: 'lhs_lt_rhs'
			{
			match("lhs_lt_rhs"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LHSLTRHS"

	// $ANTLR start "WEIGHT"
	public final void mWEIGHT() throws RecognitionException {
		try {
			int _type = WEIGHT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:348:7: ( 'weight' )
			// ValueEvaluatorTree.g:348:9: 'weight'
			{
			match("weight"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WEIGHT"

	// $ANTLR start "FUNCTION"
	public final void mFUNCTION() throws RecognitionException {
		try {
			int _type = FUNCTION;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:349:9: ( 'function' )
			// ValueEvaluatorTree.g:349:11: 'function'
			{
			match("function"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FUNCTION"

	// $ANTLR start "FROM_WRESL_FILE"
	public final void mFROM_WRESL_FILE() throws RecognitionException {
		try {
			int _type = FROM_WRESL_FILE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:350:16: ( 'from_wresl_file' )
			// ValueEvaluatorTree.g:350:18: 'from_wresl_file'
			{
			match("from_wresl_file"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FROM_WRESL_FILE"

	// $ANTLR start "UPPERUNBOUNDED"
	public final void mUPPERUNBOUNDED() throws RecognitionException {
		try {
			int _type = UPPERUNBOUNDED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:351:15: ( 'upper_unbounded' )
			// ValueEvaluatorTree.g:351:17: 'upper_unbounded'
			{
			match("upper_unbounded"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPPERUNBOUNDED"

	// $ANTLR start "LOWERUNBOUNDED"
	public final void mLOWERUNBOUNDED() throws RecognitionException {
		try {
			int _type = LOWERUNBOUNDED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:352:15: ( 'lower_unbounded' )
			// ValueEvaluatorTree.g:352:17: 'lower_unbounded'
			{
			match("lower_unbounded"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LOWERUNBOUNDED"

	// $ANTLR start "SVAR"
	public final void mSVAR() throws RecognitionException {
		try {
			int _type = SVAR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:354:5: ( '{' IDENT '}' )
			// ValueEvaluatorTree.g:354:7: '{' IDENT '}'
			{
			match('{'); 
			mIDENT(); 

			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SVAR"

	// $ANTLR start "IDENT"
	public final void mIDENT() throws RecognitionException {
		try {
			int _type = IDENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:355:7: ( LETTER ( LETTER | DIGIT | SYMBOLS )* )
			// ValueEvaluatorTree.g:355:9: LETTER ( LETTER | DIGIT | SYMBOLS )*
			{
			mLETTER(); 

			// ValueEvaluatorTree.g:355:16: ( LETTER | DIGIT | SYMBOLS )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// ValueEvaluatorTree.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop9;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENT"

	// $ANTLR start "IDENT1"
	public final void mIDENT1() throws RecognitionException {
		try {
			int _type = IDENT1;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:356:8: ( DIGIT ( LETTER | DIGIT | SYMBOLS )* )
			// ValueEvaluatorTree.g:356:10: DIGIT ( LETTER | DIGIT | SYMBOLS )*
			{
			mDIGIT(); 

			// ValueEvaluatorTree.g:356:16: ( LETTER | DIGIT | SYMBOLS )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( ((LA10_0 >= '0' && LA10_0 <= '9')||(LA10_0 >= 'A' && LA10_0 <= 'Z')||LA10_0=='_'||(LA10_0 >= 'a' && LA10_0 <= 'z')) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// ValueEvaluatorTree.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop10;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENT1"

	// $ANTLR start "IDENT2"
	public final void mIDENT2() throws RecognitionException {
		try {
			int _type = IDENT2;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:357:8: ( SYMBOLS ( LETTER | DIGIT | SYMBOLS )* )
			// ValueEvaluatorTree.g:357:10: SYMBOLS ( LETTER | DIGIT | SYMBOLS )*
			{
			mSYMBOLS(); 

			// ValueEvaluatorTree.g:357:18: ( LETTER | DIGIT | SYMBOLS )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( ((LA11_0 >= '0' && LA11_0 <= '9')||(LA11_0 >= 'A' && LA11_0 <= 'Z')||LA11_0=='_'||(LA11_0 >= 'a' && LA11_0 <= 'z')) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// ValueEvaluatorTree.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop11;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENT2"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:359:4: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
			// ValueEvaluatorTree.g:359:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
			{
			// ValueEvaluatorTree.g:359:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
			int cnt12=0;
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= '\t' && LA12_0 <= '\n')||(LA12_0 >= '\f' && LA12_0 <= '\r')||LA12_0==' ') ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// ValueEvaluatorTree.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt12 >= 1 ) break loop12;
					EarlyExitException eee = new EarlyExitException(12, input);
					throw eee;
				}
				cnt12++;
			}

			_channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// ValueEvaluatorTree.g:360:9: ( '!' ( . )* ( '\\n' | '\\r' ) )
			// ValueEvaluatorTree.g:360:11: '!' ( . )* ( '\\n' | '\\r' )
			{
			match('!'); 
			// ValueEvaluatorTree.g:360:15: ( . )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0=='\n'||LA13_0=='\r') ) {
					alt13=2;
				}
				else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '\t')||(LA13_0 >= '\u000B' && LA13_0 <= '\f')||(LA13_0 >= '\u000E' && LA13_0 <= '\uFFFF')) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// ValueEvaluatorTree.g:360:15: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop13;
				}
			}

			if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	@Override
	public void mTokens() throws RecognitionException {
		// ValueEvaluatorTree.g:1:8: ( T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | MULTILINE_COMMENT | BACKSLASH | INTEGER | FLOAT | YEAR | MONTH | MONTH_CONST | PASTMONTH | RANGE | TAFCFS | DAYSIN | SUM | MAX | MIN | INT | REAL | ABS | EXP | LOG | LOG10 | POW | MOD | UNARY | SELECT | FROM | GIVEN | USE | WHERE | TIMESERIES | CONSTRAIN | ALWAYS | NAME | DVAR | CYCLE | FILE | CONDITION | INCLUDE | LOWERBOUND | UPPERBOUND | INTEGERTYPE | UNITS | CONVERTUNITS | TYPE | OUTPUT | CASE | ORDER | EXPRESSION | LHSGTRHS | LHSLTRHS | WEIGHT | FUNCTION | FROM_WRESL_FILE | UPPERUNBOUNDED | LOWERUNBOUNDED | SVAR | IDENT | IDENT1 | IDENT2 | WS | COMMENT )
		int alt14=82;
		alt14 = dfa14.predict(input);
		switch (alt14) {
			case 1 :
				// ValueEvaluatorTree.g:1:10: T__67
				{
				mT__67(); 

				}
				break;
			case 2 :
				// ValueEvaluatorTree.g:1:16: T__68
				{
				mT__68(); 

				}
				break;
			case 3 :
				// ValueEvaluatorTree.g:1:22: T__69
				{
				mT__69(); 

				}
				break;
			case 4 :
				// ValueEvaluatorTree.g:1:28: T__70
				{
				mT__70(); 

				}
				break;
			case 5 :
				// ValueEvaluatorTree.g:1:34: T__71
				{
				mT__71(); 

				}
				break;
			case 6 :
				// ValueEvaluatorTree.g:1:40: T__72
				{
				mT__72(); 

				}
				break;
			case 7 :
				// ValueEvaluatorTree.g:1:46: T__73
				{
				mT__73(); 

				}
				break;
			case 8 :
				// ValueEvaluatorTree.g:1:52: T__74
				{
				mT__74(); 

				}
				break;
			case 9 :
				// ValueEvaluatorTree.g:1:58: T__75
				{
				mT__75(); 

				}
				break;
			case 10 :
				// ValueEvaluatorTree.g:1:64: T__76
				{
				mT__76(); 

				}
				break;
			case 11 :
				// ValueEvaluatorTree.g:1:70: T__77
				{
				mT__77(); 

				}
				break;
			case 12 :
				// ValueEvaluatorTree.g:1:76: T__78
				{
				mT__78(); 

				}
				break;
			case 13 :
				// ValueEvaluatorTree.g:1:82: T__79
				{
				mT__79(); 

				}
				break;
			case 14 :
				// ValueEvaluatorTree.g:1:88: T__80
				{
				mT__80(); 

				}
				break;
			case 15 :
				// ValueEvaluatorTree.g:1:94: T__81
				{
				mT__81(); 

				}
				break;
			case 16 :
				// ValueEvaluatorTree.g:1:100: T__82
				{
				mT__82(); 

				}
				break;
			case 17 :
				// ValueEvaluatorTree.g:1:106: T__83
				{
				mT__83(); 

				}
				break;
			case 18 :
				// ValueEvaluatorTree.g:1:112: T__84
				{
				mT__84(); 

				}
				break;
			case 19 :
				// ValueEvaluatorTree.g:1:118: T__85
				{
				mT__85(); 

				}
				break;
			case 20 :
				// ValueEvaluatorTree.g:1:124: T__86
				{
				mT__86(); 

				}
				break;
			case 21 :
				// ValueEvaluatorTree.g:1:130: T__87
				{
				mT__87(); 

				}
				break;
			case 22 :
				// ValueEvaluatorTree.g:1:136: T__88
				{
				mT__88(); 

				}
				break;
			case 23 :
				// ValueEvaluatorTree.g:1:142: MULTILINE_COMMENT
				{
				mMULTILINE_COMMENT(); 

				}
				break;
			case 24 :
				// ValueEvaluatorTree.g:1:160: BACKSLASH
				{
				mBACKSLASH(); 

				}
				break;
			case 25 :
				// ValueEvaluatorTree.g:1:170: INTEGER
				{
				mINTEGER(); 

				}
				break;
			case 26 :
				// ValueEvaluatorTree.g:1:178: FLOAT
				{
				mFLOAT(); 

				}
				break;
			case 27 :
				// ValueEvaluatorTree.g:1:184: YEAR
				{
				mYEAR(); 

				}
				break;
			case 28 :
				// ValueEvaluatorTree.g:1:189: MONTH
				{
				mMONTH(); 

				}
				break;
			case 29 :
				// ValueEvaluatorTree.g:1:195: MONTH_CONST
				{
				mMONTH_CONST(); 

				}
				break;
			case 30 :
				// ValueEvaluatorTree.g:1:207: PASTMONTH
				{
				mPASTMONTH(); 

				}
				break;
			case 31 :
				// ValueEvaluatorTree.g:1:217: RANGE
				{
				mRANGE(); 

				}
				break;
			case 32 :
				// ValueEvaluatorTree.g:1:223: TAFCFS
				{
				mTAFCFS(); 

				}
				break;
			case 33 :
				// ValueEvaluatorTree.g:1:230: DAYSIN
				{
				mDAYSIN(); 

				}
				break;
			case 34 :
				// ValueEvaluatorTree.g:1:237: SUM
				{
				mSUM(); 

				}
				break;
			case 35 :
				// ValueEvaluatorTree.g:1:241: MAX
				{
				mMAX(); 

				}
				break;
			case 36 :
				// ValueEvaluatorTree.g:1:245: MIN
				{
				mMIN(); 

				}
				break;
			case 37 :
				// ValueEvaluatorTree.g:1:249: INT
				{
				mINT(); 

				}
				break;
			case 38 :
				// ValueEvaluatorTree.g:1:253: REAL
				{
				mREAL(); 

				}
				break;
			case 39 :
				// ValueEvaluatorTree.g:1:258: ABS
				{
				mABS(); 

				}
				break;
			case 40 :
				// ValueEvaluatorTree.g:1:262: EXP
				{
				mEXP(); 

				}
				break;
			case 41 :
				// ValueEvaluatorTree.g:1:266: LOG
				{
				mLOG(); 

				}
				break;
			case 42 :
				// ValueEvaluatorTree.g:1:270: LOG10
				{
				mLOG10(); 

				}
				break;
			case 43 :
				// ValueEvaluatorTree.g:1:276: POW
				{
				mPOW(); 

				}
				break;
			case 44 :
				// ValueEvaluatorTree.g:1:280: MOD
				{
				mMOD(); 

				}
				break;
			case 45 :
				// ValueEvaluatorTree.g:1:284: UNARY
				{
				mUNARY(); 

				}
				break;
			case 46 :
				// ValueEvaluatorTree.g:1:290: SELECT
				{
				mSELECT(); 

				}
				break;
			case 47 :
				// ValueEvaluatorTree.g:1:297: FROM
				{
				mFROM(); 

				}
				break;
			case 48 :
				// ValueEvaluatorTree.g:1:302: GIVEN
				{
				mGIVEN(); 

				}
				break;
			case 49 :
				// ValueEvaluatorTree.g:1:308: USE
				{
				mUSE(); 

				}
				break;
			case 50 :
				// ValueEvaluatorTree.g:1:312: WHERE
				{
				mWHERE(); 

				}
				break;
			case 51 :
				// ValueEvaluatorTree.g:1:318: TIMESERIES
				{
				mTIMESERIES(); 

				}
				break;
			case 52 :
				// ValueEvaluatorTree.g:1:329: CONSTRAIN
				{
				mCONSTRAIN(); 

				}
				break;
			case 53 :
				// ValueEvaluatorTree.g:1:339: ALWAYS
				{
				mALWAYS(); 

				}
				break;
			case 54 :
				// ValueEvaluatorTree.g:1:346: NAME
				{
				mNAME(); 

				}
				break;
			case 55 :
				// ValueEvaluatorTree.g:1:351: DVAR
				{
				mDVAR(); 

				}
				break;
			case 56 :
				// ValueEvaluatorTree.g:1:356: CYCLE
				{
				mCYCLE(); 

				}
				break;
			case 57 :
				// ValueEvaluatorTree.g:1:362: FILE
				{
				mFILE(); 

				}
				break;
			case 58 :
				// ValueEvaluatorTree.g:1:367: CONDITION
				{
				mCONDITION(); 

				}
				break;
			case 59 :
				// ValueEvaluatorTree.g:1:377: INCLUDE
				{
				mINCLUDE(); 

				}
				break;
			case 60 :
				// ValueEvaluatorTree.g:1:385: LOWERBOUND
				{
				mLOWERBOUND(); 

				}
				break;
			case 61 :
				// ValueEvaluatorTree.g:1:396: UPPERBOUND
				{
				mUPPERBOUND(); 

				}
				break;
			case 62 :
				// ValueEvaluatorTree.g:1:407: INTEGERTYPE
				{
				mINTEGERTYPE(); 

				}
				break;
			case 63 :
				// ValueEvaluatorTree.g:1:419: UNITS
				{
				mUNITS(); 

				}
				break;
			case 64 :
				// ValueEvaluatorTree.g:1:425: CONVERTUNITS
				{
				mCONVERTUNITS(); 

				}
				break;
			case 65 :
				// ValueEvaluatorTree.g:1:438: TYPE
				{
				mTYPE(); 

				}
				break;
			case 66 :
				// ValueEvaluatorTree.g:1:443: OUTPUT
				{
				mOUTPUT(); 

				}
				break;
			case 67 :
				// ValueEvaluatorTree.g:1:450: CASE
				{
				mCASE(); 

				}
				break;
			case 68 :
				// ValueEvaluatorTree.g:1:455: ORDER
				{
				mORDER(); 

				}
				break;
			case 69 :
				// ValueEvaluatorTree.g:1:461: EXPRESSION
				{
				mEXPRESSION(); 

				}
				break;
			case 70 :
				// ValueEvaluatorTree.g:1:472: LHSGTRHS
				{
				mLHSGTRHS(); 

				}
				break;
			case 71 :
				// ValueEvaluatorTree.g:1:481: LHSLTRHS
				{
				mLHSLTRHS(); 

				}
				break;
			case 72 :
				// ValueEvaluatorTree.g:1:490: WEIGHT
				{
				mWEIGHT(); 

				}
				break;
			case 73 :
				// ValueEvaluatorTree.g:1:497: FUNCTION
				{
				mFUNCTION(); 

				}
				break;
			case 74 :
				// ValueEvaluatorTree.g:1:506: FROM_WRESL_FILE
				{
				mFROM_WRESL_FILE(); 

				}
				break;
			case 75 :
				// ValueEvaluatorTree.g:1:522: UPPERUNBOUNDED
				{
				mUPPERUNBOUNDED(); 

				}
				break;
			case 76 :
				// ValueEvaluatorTree.g:1:537: LOWERUNBOUNDED
				{
				mLOWERUNBOUNDED(); 

				}
				break;
			case 77 :
				// ValueEvaluatorTree.g:1:552: SVAR
				{
				mSVAR(); 

				}
				break;
			case 78 :
				// ValueEvaluatorTree.g:1:557: IDENT
				{
				mIDENT(); 

				}
				break;
			case 79 :
				// ValueEvaluatorTree.g:1:563: IDENT1
				{
				mIDENT1(); 

				}
				break;
			case 80 :
				// ValueEvaluatorTree.g:1:570: IDENT2
				{
				mIDENT2(); 

				}
				break;
			case 81 :
				// ValueEvaluatorTree.g:1:577: WS
				{
				mWS(); 

				}
				break;
			case 82 :
				// ValueEvaluatorTree.g:1:580: COMMENT
				{
				mCOMMENT(); 

				}
				break;

		}
	}


	protected DFA4 dfa4 = new DFA4(this);
	protected DFA14 dfa14 = new DFA14(this);
	static final String DFA4_eotS =
		"\3\uffff\1\4\1\uffff";
	static final String DFA4_eofS =
		"\5\uffff";
	static final String DFA4_minS =
		"\2\56\1\uffff\1\60\1\uffff";
	static final String DFA4_maxS =
		"\2\71\1\uffff\1\71\1\uffff";
	static final String DFA4_acceptS =
		"\2\uffff\1\1\1\uffff\1\2";
	static final String DFA4_specialS =
		"\5\uffff}>";
	static final String[] DFA4_transitionS = {
			"\1\2\1\uffff\12\1",
			"\1\3\1\uffff\12\1",
			"",
			"\12\2",
			""
	};

	static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
	static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
	static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
	static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
	static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
	static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
	static final short[][] DFA4_transition;

	static {
		int numStates = DFA4_transitionS.length;
		DFA4_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
		}
	}

	protected class DFA4 extends DFA {

		public DFA4(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 4;
			this.eot = DFA4_eot;
			this.eof = DFA4_eof;
			this.min = DFA4_min;
			this.max = DFA4_max;
			this.accept = DFA4_accept;
			this.special = DFA4_special;
			this.transition = DFA4_transition;
		}
		@Override
		public String getDescription() {
			return "293:1: FLOAT : ( ( INTEGER )? '.' INTEGER | INTEGER '.' );";
		}
	}

	static final String DFA14_eotS =
		"\6\uffff\1\54\1\57\2\uffff\1\61\1\63\1\65\2\uffff\2\46\2\uffff\1\74\21"+
		"\46\22\uffff\4\46\2\uffff\1\74\1\uffff\62\46\1\u00a9\2\u00aa\1\u00ab\1"+
		"\u00ac\4\u00aa\3\46\2\u00aa\1\46\1\u00b1\1\46\1\u00aa\1\46\1\u00b4\1\u00aa"+
		"\2\46\1\u00aa\1\46\1\u00aa\3\46\1\u00bb\5\46\1\u00c2\1\46\1\u00c5\1\u00c7"+
		"\4\46\1\u00cc\7\46\1\u00d5\4\46\4\uffff\1\u00db\1\u00dc\2\46\1\uffff\2"+
		"\46\1\uffff\2\46\1\u00e3\1\46\1\u00e5\1\46\1\uffff\1\46\1\u00ef\2\46\1"+
		"\u00f2\1\46\1\uffff\2\46\1\uffff\1\46\1\uffff\4\46\1\uffff\7\46\1\u0103"+
		"\1\uffff\1\46\1\u0105\1\46\1\u0107\1\46\2\uffff\5\46\1\u010e\1\uffff\1"+
		"\46\1\uffff\10\46\1\u011a\1\uffff\2\46\1\uffff\3\46\1\u0120\3\46\1\u0124"+
		"\1\u0125\1\46\1\u0127\1\46\1\u0129\3\46\1\uffff\1\46\1\uffff\1\u012e\1"+
		"\uffff\2\46\1\u0129\1\u0131\1\u0132\1\u0133\1\uffff\1\u0135\12\46\1\uffff"+
		"\5\46\1\uffff\3\46\2\uffff\1\46\1\uffff\1\u0129\1\uffff\4\46\1\uffff\2"+
		"\46\3\uffff\1\46\1\uffff\14\u0154\1\u0129\1\46\1\u0156\1\u0157\14\46\1"+
		"\u0164\1\46\1\uffff\1\46\2\uffff\7\46\1\u016e\1\u016f\1\46\1\u0171\1\46"+
		"\1\uffff\11\46\2\uffff\1\46\1\uffff\2\46\1\u017f\1\u0180\2\46\1\u0183"+
		"\1\u0184\4\46\1\u0135\2\uffff\1\u0189\1\46\2\uffff\1\u018b\3\46\1\uffff"+
		"\1\46\1\uffff\12\46\1\u019a\1\u019b\1\u019c\1\u019d\4\uffff";
	static final String DFA14_eofS =
		"\u019e\uffff";
	static final String DFA14_minS =
		"\1\11\5\uffff\1\60\1\52\2\uffff\3\75\2\uffff\2\72\2\uffff\1\56\3\141\1"+
		"\145\1\142\1\145\1\143\2\141\1\157\2\141\1\156\1\170\1\150\1\156\1\151"+
		"\22\uffff\1\163\1\156\1\143\1\163\2\uffff\1\56\1\uffff\1\164\1\145\1\151"+
		"\1\144\1\162\2\156\1\154\1\142\1\157\1\154\1\156\1\162\1\147\1\137\1\163"+
		"\1\167\1\154\1\155\2\164\1\144\1\166\1\155\1\143\1\171\1\141\1\145\1\167"+
		"\1\156\1\141\1\146\1\155\1\160\1\143\1\160\1\147\1\163\1\141\1\145\1\160"+
		"\1\166\1\137\1\144\1\154\2\145\1\162\1\147\1\164\11\60\1\155\1\145\1\143"+
		"\2\60\1\143\1\60\1\141\1\60\1\145\2\60\1\160\1\145\1\60\1\145\1\60\1\163"+
		"\1\162\1\166\1\60\1\147\1\154\1\137\2\145\1\60\1\154\2\60\1\145\1\137"+
		"\1\162\1\164\1\60\2\145\1\141\1\164\1\151\2\145\1\60\1\162\1\145\2\150"+
		"\4\uffff\2\60\1\164\1\146\1\uffff\1\171\1\143\1\uffff\1\165\1\162\1\60"+
		"\1\151\1\60\1\141\1\uffff\1\145\1\60\1\143\1\163\1\60\1\147\1\uffff\1"+
		"\165\1\145\1\uffff\1\60\1\uffff\1\162\1\147\1\171\1\163\1\uffff\1\162"+
		"\1\156\1\141\1\146\1\162\1\164\1\162\1\60\1\uffff\1\171\1\60\1\164\1\60"+
		"\1\167\2\uffff\1\151\2\163\2\164\1\60\1\uffff\1\156\1\uffff\1\141\1\145"+
		"\1\141\1\160\1\145\1\143\1\157\1\145\1\60\1\uffff\1\146\1\145\1\uffff"+
		"\1\145\1\144\1\163\1\60\1\137\2\164\2\60\1\137\1\60\1\146\1\60\1\141\1"+
		"\151\1\164\1\uffff\1\145\1\uffff\1\60\1\uffff\1\162\1\157\4\60\1\uffff"+
		"\1\60\1\156\1\154\1\142\2\162\1\147\1\160\1\164\1\166\1\143\1\uffff\1"+
		"\163\2\162\1\145\1\163\1\uffff\1\142\2\137\2\uffff\1\142\1\uffff\1\60"+
		"\1\uffff\1\151\1\157\1\137\1\141\1\uffff\1\145\1\156\3\uffff\1\157\1\uffff"+
		"\15\60\1\151\2\60\1\151\1\157\1\156\2\162\1\157\3\156\1\164\1\162\1\163"+
		"\1\60\1\156\1\uffff\1\145\2\uffff\1\157\1\165\1\142\2\150\1\165\1\142"+
		"\2\60\1\157\1\60\1\154\1\uffff\1\164\1\163\2\156\1\157\2\163\1\156\1\157"+
		"\2\uffff\1\137\1\uffff\1\137\1\150\2\60\1\144\1\165\2\60\1\144\2\165\1"+
		"\146\1\60\2\uffff\1\60\1\156\2\uffff\1\60\2\156\1\151\1\uffff\1\144\1"+
		"\uffff\1\144\1\151\1\154\2\145\1\164\1\145\2\144\1\163\4\60\4\uffff";
	static final String DFA14_maxS =
		"\1\174\5\uffff\1\157\1\52\2\uffff\3\75\2\uffff\1\171\1\72\2\uffff\1\172"+
		"\1\150\1\157\5\165\1\157\1\166\1\162\1\145\1\171\1\156\1\170\1\157\1\163"+
		"\1\151\22\uffff\1\163\1\156\1\143\1\163\2\uffff\1\172\1\uffff\1\164\1"+
		"\145\1\151\1\156\1\171\3\156\1\142\1\157\1\154\1\156\1\162\1\147\1\137"+
		"\1\163\1\167\1\160\1\155\2\164\1\144\1\166\1\155\1\143\1\171\1\141\1\145"+
		"\1\167\1\156\1\141\1\146\1\155\1\160\1\164\1\160\1\167\1\163\1\151\1\145"+
		"\1\160\1\166\1\137\1\166\1\154\2\145\1\162\1\147\1\164\11\172\1\155\1"+
		"\145\1\143\2\172\1\143\1\172\1\141\1\172\1\145\2\172\1\160\1\145\1\172"+
		"\1\145\1\172\1\163\1\162\1\166\1\172\1\147\1\154\1\137\2\145\1\172\1\154"+
		"\2\172\1\145\1\137\1\162\1\164\1\172\2\145\2\164\1\151\2\145\1\172\1\162"+
		"\1\145\2\150\4\uffff\2\172\1\164\1\146\1\uffff\1\171\1\143\1\uffff\1\165"+
		"\1\162\1\172\1\151\1\172\1\163\1\uffff\1\145\1\172\1\143\1\163\1\172\1"+
		"\147\1\uffff\1\165\1\145\1\uffff\1\60\1\uffff\1\162\1\154\1\171\1\163"+
		"\1\uffff\1\162\1\156\1\141\1\146\1\162\1\164\1\162\1\172\1\uffff\1\171"+
		"\1\172\1\164\1\172\1\167\2\uffff\1\151\2\163\2\164\1\172\1\uffff\1\156"+
		"\1\uffff\1\165\1\145\1\141\1\165\1\145\1\143\1\157\1\145\1\172\1\uffff"+
		"\1\146\1\145\1\uffff\1\145\1\144\1\163\1\172\1\137\2\164\2\172\1\137\1"+
		"\172\1\146\1\172\1\141\1\151\1\164\1\uffff\1\145\1\uffff\1\172\1\uffff"+
		"\1\162\1\157\4\172\1\uffff\1\172\2\156\1\142\1\171\1\162\1\147\1\160\1"+
		"\164\1\166\1\143\1\uffff\1\163\2\162\1\145\1\163\1\uffff\1\165\2\137\2"+
		"\uffff\1\165\1\uffff\1\172\1\uffff\1\151\1\157\1\137\1\141\1\uffff\1\145"+
		"\1\156\3\uffff\1\157\1\uffff\15\172\1\151\2\172\1\151\1\157\1\156\2\162"+
		"\1\157\3\156\1\164\1\162\1\163\1\172\1\156\1\uffff\1\145\2\uffff\1\157"+
		"\1\165\1\142\2\150\1\165\1\142\2\172\1\157\1\172\1\154\1\uffff\1\164\1"+
		"\163\2\156\1\157\2\163\1\156\1\157\2\uffff\1\137\1\uffff\1\137\1\150\2"+
		"\172\1\144\1\165\2\172\1\144\2\165\1\146\1\172\2\uffff\1\172\1\156\2\uffff"+
		"\1\172\2\156\1\151\1\uffff\1\144\1\uffff\1\144\1\151\1\154\2\145\1\164"+
		"\1\145\2\144\1\163\4\172\4\uffff";
	static final String DFA14_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\2\uffff\1\12\1\13\3\uffff\1\22\1\23\2\uffff"+
		"\1\26\1\30\22\uffff\1\115\1\116\1\120\1\121\1\122\1\7\1\10\1\6\1\32\1"+
		"\27\1\11\1\15\1\14\1\17\1\16\1\21\1\20\1\24\4\uffff\1\25\1\31\1\uffff"+
		"\1\117\152\uffff\1\54\1\35\1\43\1\44\4\uffff\1\47\2\uffff\1\42\6\uffff"+
		"\1\53\6\uffff\1\45\2\uffff\1\50\1\uffff\1\51\4\uffff\1\61\10\uffff\1\103"+
		"\5\uffff\1\57\1\71\6\uffff\1\66\1\uffff\1\67\11\uffff\1\46\2\uffff\1\101"+
		"\20\uffff\1\70\1\uffff\1\62\1\uffff\1\34\6\uffff\1\104\13\uffff\1\37\5"+
		"\uffff\1\52\3\uffff\1\55\1\77\1\uffff\1\60\1\uffff\1\40\4\uffff\1\110"+
		"\2\uffff\1\65\1\56\1\102\1\uffff\1\41\36\uffff\1\36\1\uffff\1\76\1\73"+
		"\14\uffff\1\111\11\uffff\1\64\1\72\1\uffff\1\33\15\uffff\1\63\1\105\2"+
		"\uffff\1\106\1\107\4\uffff\1\74\1\uffff\1\75\16\uffff\1\112\1\114\1\113"+
		"\1\100";
	static final String DFA14_specialS =
		"\u019e\uffff}>";
	static final String[] DFA14_transitionS = {
			"\2\50\1\uffff\2\50\22\uffff\1\50\1\51\6\uffff\1\1\1\2\1\3\1\4\1\uffff"+
			"\1\5\1\6\1\7\12\23\1\10\1\11\1\12\1\13\1\14\2\uffff\32\46\1\15\1\22\1"+
			"\16\1\uffff\1\47\1\uffff\1\30\1\46\1\17\1\34\1\41\1\27\1\44\1\46\1\40"+
			"\1\26\1\46\1\42\1\25\1\33\1\32\1\35\1\46\1\36\1\31\1\37\1\43\1\20\1\24"+
			"\3\46\1\45\1\21",
			"",
			"",
			"",
			"",
			"",
			"\12\55\47\uffff\1\52\15\uffff\1\53",
			"\1\56",
			"",
			"",
			"\1\60",
			"\1\62",
			"\1\64",
			"",
			"",
			"\1\66\46\uffff\1\72\4\uffff\1\67\10\uffff\1\70\11\uffff\1\71",
			"\1\73",
			"",
			"",
			"\1\55\1\uffff\12\75\7\uffff\32\76\4\uffff\1\76\1\uffff\32\76",
			"\1\77\3\uffff\1\101\2\uffff\1\100",
			"\1\103\7\uffff\1\104\5\uffff\1\102",
			"\1\105\23\uffff\1\106",
			"\1\107\3\uffff\1\111\10\uffff\1\110\2\uffff\1\112",
			"\1\116\3\uffff\1\115\5\uffff\1\117\3\uffff\1\113\4\uffff\1\114",
			"\1\120\17\uffff\1\121",
			"\1\122\16\uffff\1\124\2\uffff\1\123",
			"\1\126\15\uffff\1\125",
			"\1\130\3\uffff\1\127\20\uffff\1\131",
			"\1\133\2\uffff\1\132",
			"\1\134\3\uffff\1\135",
			"\1\136\7\uffff\1\137\17\uffff\1\140",
			"\1\141",
			"\1\142",
			"\1\144\6\uffff\1\143",
			"\1\145\1\uffff\1\147\2\uffff\1\146",
			"\1\150",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\151",
			"\1\152",
			"\1\153",
			"\1\154",
			"",
			"",
			"\1\55\1\uffff\12\75\7\uffff\32\76\4\uffff\1\76\1\uffff\32\76",
			"",
			"\1\155",
			"\1\156",
			"\1\157",
			"\1\161\11\uffff\1\160",
			"\1\162\5\uffff\1\164\1\163",
			"\1\165",
			"\1\166",
			"\1\170\1\uffff\1\167",
			"\1\171",
			"\1\172",
			"\1\173",
			"\1\174",
			"\1\175",
			"\1\176",
			"\1\177",
			"\1\u0080",
			"\1\u0081",
			"\1\u0083\3\uffff\1\u0082",
			"\1\u0084",
			"\1\u0085",
			"\1\u0086",
			"\1\u0087",
			"\1\u0088",
			"\1\u0089",
			"\1\u008a",
			"\1\u008b",
			"\1\u008c",
			"\1\u008d",
			"\1\u008e",
			"\1\u008f",
			"\1\u0090",
			"\1\u0091",
			"\1\u0092",
			"\1\u0093",
			"\1\u0095\20\uffff\1\u0094",
			"\1\u0096",
			"\1\u0097\17\uffff\1\u0098",
			"\1\u0099",
			"\1\u009a\7\uffff\1\u009b",
			"\1\u009c",
			"\1\u009d",
			"\1\u009e",
			"\1\u009f",
			"\1\u00a1\16\uffff\1\u00a0\2\uffff\1\u00a2",
			"\1\u00a3",
			"\1\u00a4",
			"\1\u00a5",
			"\1\u00a6",
			"\1\u00a7",
			"\1\u00a8",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00ad",
			"\1\u00ae",
			"\1\u00af",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00b0",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00b2",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00b3",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00b5",
			"\1\u00b6",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00b7",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00b8",
			"\1\u00b9",
			"\1\u00ba",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00bc",
			"\1\u00bd",
			"\1\u00be",
			"\1\u00bf",
			"\1\u00c0",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\4\46\1\u00c1\25\46",
			"\1\u00c3",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\21\46\1\u00c4\10\46",
			"\1\46\1\u00c6\10\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00c8",
			"\1\u00c9",
			"\1\u00ca",
			"\1\u00cb",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00cd",
			"\1\u00ce",
			"\1\u00d0\22\uffff\1\u00cf",
			"\1\u00d1",
			"\1\u00d2",
			"\1\u00d3",
			"\1\u00d4",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00d6",
			"\1\u00d7",
			"\1\u00d8",
			"\1\u00d9",
			"",
			"",
			"",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\u00da\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00dd",
			"\1\u00de",
			"",
			"\1\u00df",
			"\1\u00e0",
			"",
			"\1\u00e1",
			"\1\u00e2",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00e4",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00e9\2\uffff\1\u00ed\1\uffff\1\u00e7\3\uffff\1\u00e6\2\uffff\1\u00e8"+
			"\1\u00ec\1\u00eb\3\uffff\1\u00ea",
			"",
			"\1\u00ee",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00f0",
			"\1\u00f1",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u00f3",
			"",
			"\1\u00f4",
			"\1\u00f5",
			"",
			"\1\u00f6",
			"",
			"\1\u00f7",
			"\1\u00f8\4\uffff\1\u00f9",
			"\1\u00fa",
			"\1\u00fb",
			"",
			"\1\u00fc",
			"\1\u00fd",
			"\1\u00fe",
			"\1\u00ff",
			"\1\u0100",
			"\1\u0101",
			"\1\u0102",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"\1\u0104",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0106",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0108",
			"",
			"",
			"\1\u0109",
			"\1\u010a",
			"\1\u010b",
			"\1\u010c",
			"\1\u010d",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"\1\u010f",
			"",
			"\1\u0110\23\uffff\1\u0111",
			"\1\u0112",
			"\1\u0113",
			"\1\u0114\4\uffff\1\u0115",
			"\1\u0116",
			"\1\u0117",
			"\1\u0118",
			"\1\u0119",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"\1\u011b",
			"\1\u011c",
			"",
			"\1\u011d",
			"\1\u011e",
			"\1\u011f",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0121",
			"\1\u0122",
			"\1\u0123",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0126",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0128",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u012a",
			"\1\u012b",
			"\1\u012c",
			"",
			"\1\u012d",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"\1\u012f",
			"\1\u0130",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\14\46\1\u0134\15\46",
			"\1\u0136",
			"\1\u0138\1\uffff\1\u0137",
			"\1\u0139",
			"\1\u013a\6\uffff\1\u013b",
			"\1\u013c",
			"\1\u013d",
			"\1\u013e",
			"\1\u013f",
			"\1\u0140",
			"\1\u0141",
			"",
			"\1\u0142",
			"\1\u0143",
			"\1\u0144",
			"\1\u0145",
			"\1\u0146",
			"",
			"\1\u0147\22\uffff\1\u0148",
			"\1\u0149",
			"\1\u014a",
			"",
			"",
			"\1\u014b\22\uffff\1\u014c",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"\1\u014d",
			"\1\u014e",
			"\1\u014f",
			"\1\u0150",
			"",
			"\1\u0151",
			"\1\u0152",
			"",
			"",
			"",
			"\1\u0153",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0155",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0158",
			"\1\u0159",
			"\1\u015a",
			"\1\u015b",
			"\1\u015c",
			"\1\u015d",
			"\1\u015e",
			"\1\u015f",
			"\1\u0160",
			"\1\u0161",
			"\1\u0162",
			"\1\u0163",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0165",
			"",
			"\1\u0166",
			"",
			"",
			"\1\u0167",
			"\1\u0168",
			"\1\u0169",
			"\1\u016a",
			"\1\u016b",
			"\1\u016c",
			"\1\u016d",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0170",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0172",
			"",
			"\1\u0173",
			"\1\u0174",
			"\1\u0175",
			"\1\u0176",
			"\1\u0177",
			"\1\u0178",
			"\1\u0179",
			"\1\u017a",
			"\1\u017b",
			"",
			"",
			"\1\u017c",
			"",
			"\1\u017d",
			"\1\u017e",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0181",
			"\1\u0182",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u0185",
			"\1\u0186",
			"\1\u0187",
			"\1\u0188",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u018a",
			"",
			"",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\1\u018c",
			"\1\u018d",
			"\1\u018e",
			"",
			"\1\u018f",
			"",
			"\1\u0190",
			"\1\u0191",
			"\1\u0192",
			"\1\u0193",
			"\1\u0194",
			"\1\u0195",
			"\1\u0196",
			"\1\u0197",
			"\1\u0198",
			"\1\u0199",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
			"",
			"",
			"",
			""
	};

	static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
	static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
	static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
	static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
	static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
	static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
	static final short[][] DFA14_transition;

	static {
		int numStates = DFA14_transitionS.length;
		DFA14_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
		}
	}

	protected class DFA14 extends DFA {

		public DFA14(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 14;
			this.eot = DFA14_eot;
			this.eof = DFA14_eof;
			this.min = DFA14_min;
			this.max = DFA14_max;
			this.accept = DFA14_accept;
			this.special = DFA14_special;
			this.transition = DFA14_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | MULTILINE_COMMENT | BACKSLASH | INTEGER | FLOAT | YEAR | MONTH | MONTH_CONST | PASTMONTH | RANGE | TAFCFS | DAYSIN | SUM | MAX | MIN | INT | REAL | ABS | EXP | LOG | LOG10 | POW | MOD | UNARY | SELECT | FROM | GIVEN | USE | WHERE | TIMESERIES | CONSTRAIN | ALWAYS | NAME | DVAR | CYCLE | FILE | CONDITION | INCLUDE | LOWERBOUND | UPPERBOUND | INTEGERTYPE | UNITS | CONVERTUNITS | TYPE | OUTPUT | CASE | ORDER | EXPRESSION | LHSGTRHS | LHSLTRHS | WEIGHT | FUNCTION | FROM_WRESL_FILE | UPPERUNBOUNDED | LOWERUNBOUNDED | SVAR | IDENT | IDENT1 | IDENT2 | WS | COMMENT );";
		}
	}

}
