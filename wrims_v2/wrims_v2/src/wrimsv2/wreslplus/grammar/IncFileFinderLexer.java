// $ANTLR 3.5.2 IncFileFinder.g 2024-02-12 13:08:36

  package wrimsv2.wreslplus.grammar;
  import wrimsv2.wreslparser.elements.LogUtils; 


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class IncFileFinderLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int Digit=4;
	public static final int FROM=5;
	public static final int GROUP=6;
	public static final int ID=7;
	public static final int INCLUDE=8;
	public static final int LOCAL=9;
	public static final int Letter=10;
	public static final int ML_COMMENT=11;
	public static final int MODEL=12;
	public static final int N=13;
	public static final int Others=14;
	public static final int QUOTE=15;
	public static final int SELECT=16;
	public static final int SL_COMMENT=17;
	public static final int WHERE=18;
	public static final int WS=19;

		
		public String currentAbsolutePath;
		public int number_of_errors = 0;
		/// error message	
	    public void displayRecognitionError(String[] tokenNames,
	                                        RecognitionException e) {
	        String hdr = getErrorHeader(e);
	        String msg = getErrorMessage(e, tokenNames);
	        LogUtils.errMsgLocation(currentAbsolutePath, e.line, msg);
	        number_of_errors++;
	    }


	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public IncFileFinderLexer() {} 
	public IncFileFinderLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public IncFileFinderLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "IncFileFinder.g"; }

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:25:7: ( '[' )
			// IncFileFinder.g:25:9: '['
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
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:26:7: ( ']' )
			// IncFileFinder.g:26:9: ']'
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
	// $ANTLR end "T__21"

	// $ANTLR start "QUOTE"
	public final void mQUOTE() throws RecognitionException {
		try {
			int _type = QUOTE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:109:7: ( '\\'' ( Letter | Digit | '\\\\' | '_' | '.' | '-' | '/' )+ '\\'' )
			// IncFileFinder.g:109:9: '\\'' ( Letter | Digit | '\\\\' | '_' | '.' | '-' | '/' )+ '\\''
			{
			match('\''); 
			// IncFileFinder.g:109:15: ( Letter | Digit | '\\\\' | '_' | '.' | '-' | '/' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '-' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='\\'||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// IncFileFinder.g:
					{
					if ( (input.LA(1) >= '-' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='\\'||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "QUOTE"

	// $ANTLR start "ML_COMMENT"
	public final void mML_COMMENT() throws RecognitionException {
		try {
			int _type = ML_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:111:12: ( '/*' ( . )* '*/' )
			// IncFileFinder.g:111:14: '/*' ( . )* '*/'
			{
			match("/*"); 

			// IncFileFinder.g:111:19: ( . )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0=='*') ) {
					int LA2_1 = input.LA(2);
					if ( (LA2_1=='/') ) {
						alt2=2;
					}
					else if ( ((LA2_1 >= '\u0000' && LA2_1 <= '.')||(LA2_1 >= '0' && LA2_1 <= '\uFFFF')) ) {
						alt2=1;
					}

				}
				else if ( ((LA2_0 >= '\u0000' && LA2_0 <= ')')||(LA2_0 >= '+' && LA2_0 <= '\uFFFF')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// IncFileFinder.g:111:19: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop2;
				}
			}

			match("*/"); 

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ML_COMMENT"

	// $ANTLR start "SL_COMMENT"
	public final void mSL_COMMENT() throws RecognitionException {
		try {
			int _type = SL_COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:113:12: ( ( '#' | '!' ) (~ ( '\\r' | '\\n' ) )* ( '\\r' )? ( '\\n' | EOF ) )
			// IncFileFinder.g:113:14: ( '#' | '!' ) (~ ( '\\r' | '\\n' ) )* ( '\\r' )? ( '\\n' | EOF )
			{
			if ( input.LA(1)=='!'||input.LA(1)=='#' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// IncFileFinder.g:113:24: (~ ( '\\r' | '\\n' ) )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// IncFileFinder.g:
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
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
					break loop3;
				}
			}

			// IncFileFinder.g:113:39: ( '\\r' )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0=='\r') ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// IncFileFinder.g:113:39: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			// IncFileFinder.g:113:45: ( '\\n' | EOF )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0=='\n') ) {
				alt5=1;
			}

			else {
				alt5=2;
			}

			switch (alt5) {
				case 1 :
					// IncFileFinder.g:113:47: '\\n'
					{
					match('\n'); 
					}
					break;
				case 2 :
					// IncFileFinder.g:113:54: EOF
					{
					match(EOF); 

					}
					break;

			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SL_COMMENT"

	// $ANTLR start "INCLUDE"
	public final void mINCLUDE() throws RecognitionException {
		try {
			int _type = INCLUDE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:115:9: ( 'include' | 'INCLUDE' | 'Include' )
			int alt6=3;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='i') ) {
				alt6=1;
			}
			else if ( (LA6_0=='I') ) {
				int LA6_2 = input.LA(2);
				if ( (LA6_2=='N') ) {
					alt6=2;
				}
				else if ( (LA6_2=='n') ) {
					alt6=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 2, input);
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
					// IncFileFinder.g:115:13: 'include'
					{
					match("include"); 

					}
					break;
				case 2 :
					// IncFileFinder.g:115:25: 'INCLUDE'
					{
					match("INCLUDE"); 

					}
					break;
				case 3 :
					// IncFileFinder.g:115:37: 'Include'
					{
					match("Include"); 

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
	// $ANTLR end "INCLUDE"

	// $ANTLR start "LOCAL"
	public final void mLOCAL() throws RecognitionException {
		try {
			int _type = LOCAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:116:7: ( 'local' | 'LOCAL' | 'Local' )
			int alt7=3;
			int LA7_0 = input.LA(1);
			if ( (LA7_0=='l') ) {
				alt7=1;
			}
			else if ( (LA7_0=='L') ) {
				int LA7_2 = input.LA(2);
				if ( (LA7_2=='O') ) {
					alt7=2;
				}
				else if ( (LA7_2=='o') ) {
					alt7=3;
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

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// IncFileFinder.g:116:9: 'local'
					{
					match("local"); 

					}
					break;
				case 2 :
					// IncFileFinder.g:116:19: 'LOCAL'
					{
					match("LOCAL"); 

					}
					break;
				case 3 :
					// IncFileFinder.g:116:29: 'Local'
					{
					match("Local"); 

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
	// $ANTLR end "LOCAL"

	// $ANTLR start "MODEL"
	public final void mMODEL() throws RecognitionException {
		try {
			int _type = MODEL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:117:7: ( 'model' | 'MODEL' | 'Model' )
			int alt8=3;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='m') ) {
				alt8=1;
			}
			else if ( (LA8_0=='M') ) {
				int LA8_2 = input.LA(2);
				if ( (LA8_2=='O') ) {
					alt8=2;
				}
				else if ( (LA8_2=='o') ) {
					alt8=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 8, 2, input);
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
					// IncFileFinder.g:117:9: 'model'
					{
					match("model"); 

					}
					break;
				case 2 :
					// IncFileFinder.g:117:19: 'MODEL'
					{
					match("MODEL"); 

					}
					break;
				case 3 :
					// IncFileFinder.g:117:29: 'Model'
					{
					match("Model"); 

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
	// $ANTLR end "MODEL"

	// $ANTLR start "GROUP"
	public final void mGROUP() throws RecognitionException {
		try {
			int _type = GROUP;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:118:7: ( 'group' | 'GROUP' | 'Group' )
			int alt9=3;
			int LA9_0 = input.LA(1);
			if ( (LA9_0=='g') ) {
				alt9=1;
			}
			else if ( (LA9_0=='G') ) {
				int LA9_2 = input.LA(2);
				if ( (LA9_2=='R') ) {
					alt9=2;
				}
				else if ( (LA9_2=='r') ) {
					alt9=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 9, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// IncFileFinder.g:118:9: 'group'
					{
					match("group"); 

					}
					break;
				case 2 :
					// IncFileFinder.g:118:19: 'GROUP'
					{
					match("GROUP"); 

					}
					break;
				case 3 :
					// IncFileFinder.g:118:29: 'Group'
					{
					match("Group"); 

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
	// $ANTLR end "GROUP"

	// $ANTLR start "SELECT"
	public final void mSELECT() throws RecognitionException {
		try {
			int _type = SELECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:119:8: ( 'select' | 'SELECT' | 'Select' )
			int alt10=3;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='s') ) {
				alt10=1;
			}
			else if ( (LA10_0=='S') ) {
				int LA10_2 = input.LA(2);
				if ( (LA10_2=='E') ) {
					alt10=2;
				}
				else if ( (LA10_2=='e') ) {
					alt10=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// IncFileFinder.g:119:10: 'select'
					{
					match("select"); 

					}
					break;
				case 2 :
					// IncFileFinder.g:119:19: 'SELECT'
					{
					match("SELECT"); 

					}
					break;
				case 3 :
					// IncFileFinder.g:119:28: 'Select'
					{
					match("Select"); 

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
	// $ANTLR end "SELECT"

	// $ANTLR start "FROM"
	public final void mFROM() throws RecognitionException {
		try {
			int _type = FROM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:120:6: ( 'from' | 'FROM' | 'From' )
			int alt11=3;
			int LA11_0 = input.LA(1);
			if ( (LA11_0=='f') ) {
				alt11=1;
			}
			else if ( (LA11_0=='F') ) {
				int LA11_2 = input.LA(2);
				if ( (LA11_2=='R') ) {
					alt11=2;
				}
				else if ( (LA11_2=='r') ) {
					alt11=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 11, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// IncFileFinder.g:120:8: 'from'
					{
					match("from"); 

					}
					break;
				case 2 :
					// IncFileFinder.g:120:15: 'FROM'
					{
					match("FROM"); 

					}
					break;
				case 3 :
					// IncFileFinder.g:120:22: 'From'
					{
					match("From"); 

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
	// $ANTLR end "FROM"

	// $ANTLR start "WHERE"
	public final void mWHERE() throws RecognitionException {
		try {
			int _type = WHERE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:121:6: ( 'where' | 'WHERE' | 'Where' )
			int alt12=3;
			int LA12_0 = input.LA(1);
			if ( (LA12_0=='w') ) {
				alt12=1;
			}
			else if ( (LA12_0=='W') ) {
				int LA12_2 = input.LA(2);
				if ( (LA12_2=='H') ) {
					alt12=2;
				}
				else if ( (LA12_2=='h') ) {
					alt12=3;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 12, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// IncFileFinder.g:121:8: 'where'
					{
					match("where"); 

					}
					break;
				case 2 :
					// IncFileFinder.g:121:16: 'WHERE'
					{
					match("WHERE"); 

					}
					break;
				case 3 :
					// IncFileFinder.g:121:24: 'Where'
					{
					match("Where"); 

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
	// $ANTLR end "WHERE"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:123:4: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
			// IncFileFinder.g:123:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
			{
			// IncFileFinder.g:123:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( ((LA13_0 >= '\t' && LA13_0 <= '\n')||(LA13_0 >= '\f' && LA13_0 <= '\r')||LA13_0==' ') ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// IncFileFinder.g:
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
					if ( cnt13 >= 1 ) break loop13;
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:125:4: ( Letter ( Letter | Digit | '_' )* )
			// IncFileFinder.g:125:6: Letter ( Letter | Digit | '_' )*
			{
			mLetter(); 

			// IncFileFinder.g:125:13: ( Letter | Digit | '_' )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( ((LA14_0 >= '0' && LA14_0 <= '9')||(LA14_0 >= 'A' && LA14_0 <= 'Z')||LA14_0=='_'||(LA14_0 >= 'a' && LA14_0 <= 'z')) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// IncFileFinder.g:
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
					break loop14;
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
	// $ANTLR end "ID"

	// $ANTLR start "N"
	public final void mN() throws RecognitionException {
		try {
			int _type = N;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:126:3: ( ( Digit )+ )
			// IncFileFinder.g:126:5: ( Digit )+
			{
			// IncFileFinder.g:126:5: ( Digit )+
			int cnt15=0;
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( ((LA15_0 >= '0' && LA15_0 <= '9')) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// IncFileFinder.g:
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
					if ( cnt15 >= 1 ) break loop15;
					EarlyExitException eee = new EarlyExitException(15, input);
					throw eee;
				}
				cnt15++;
			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "N"

	// $ANTLR start "Letter"
	public final void mLetter() throws RecognitionException {
		try {
			// IncFileFinder.g:128:17: ( 'a' .. 'z' | 'A' .. 'Z' )
			// IncFileFinder.g:
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
	// $ANTLR end "Letter"

	// $ANTLR start "Digit"
	public final void mDigit() throws RecognitionException {
		try {
			// IncFileFinder.g:130:16: ( '0' .. '9' )
			// IncFileFinder.g:
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
	// $ANTLR end "Digit"

	// $ANTLR start "Others"
	public final void mOthers() throws RecognitionException {
		try {
			int _type = Others;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// IncFileFinder.g:132:8: ( '{' | '}' | '\\\\' | '.' | '=' | '(' | ')' | '\\r' | '\\n' | '<' | '>' | '+' | '-' | '*' | '/' | ',' | '$' )
			int alt16=17;
			switch ( input.LA(1) ) {
			case '{':
				{
				alt16=1;
				}
				break;
			case '}':
				{
				alt16=2;
				}
				break;
			case '\\':
				{
				alt16=3;
				}
				break;
			case '.':
				{
				alt16=4;
				}
				break;
			case '=':
				{
				alt16=5;
				}
				break;
			case '(':
				{
				alt16=6;
				}
				break;
			case ')':
				{
				alt16=7;
				}
				break;
			case '\r':
				{
				alt16=8;
				}
				break;
			case '\n':
				{
				alt16=9;
				}
				break;
			case '<':
				{
				alt16=10;
				}
				break;
			case '>':
				{
				alt16=11;
				}
				break;
			case '+':
				{
				alt16=12;
				}
				break;
			case '-':
				{
				alt16=13;
				}
				break;
			case '*':
				{
				alt16=14;
				}
				break;
			case '/':
				{
				alt16=15;
				}
				break;
			case ',':
				{
				alt16=16;
				}
				break;
			case '$':
				{
				alt16=17;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// IncFileFinder.g:132:10: '{'
					{
					match('{'); 
					}
					break;
				case 2 :
					// IncFileFinder.g:132:14: '}'
					{
					match('}'); 
					}
					break;
				case 3 :
					// IncFileFinder.g:132:18: '\\\\'
					{
					match('\\'); 
					}
					break;
				case 4 :
					// IncFileFinder.g:132:23: '.'
					{
					match('.'); 
					}
					break;
				case 5 :
					// IncFileFinder.g:132:27: '='
					{
					match('='); 
					}
					break;
				case 6 :
					// IncFileFinder.g:132:31: '('
					{
					match('('); 
					}
					break;
				case 7 :
					// IncFileFinder.g:132:35: ')'
					{
					match(')'); 
					}
					break;
				case 8 :
					// IncFileFinder.g:132:39: '\\r'
					{
					match('\r'); 
					}
					break;
				case 9 :
					// IncFileFinder.g:132:44: '\\n'
					{
					match('\n'); 
					}
					break;
				case 10 :
					// IncFileFinder.g:132:49: '<'
					{
					match('<'); 
					}
					break;
				case 11 :
					// IncFileFinder.g:132:53: '>'
					{
					match('>'); 
					}
					break;
				case 12 :
					// IncFileFinder.g:132:57: '+'
					{
					match('+'); 
					}
					break;
				case 13 :
					// IncFileFinder.g:132:61: '-'
					{
					match('-'); 
					}
					break;
				case 14 :
					// IncFileFinder.g:132:65: '*'
					{
					match('*'); 
					}
					break;
				case 15 :
					// IncFileFinder.g:132:69: '/'
					{
					match('/'); 
					}
					break;
				case 16 :
					// IncFileFinder.g:132:73: ','
					{
					match(','); 
					}
					break;
				case 17 :
					// IncFileFinder.g:132:77: '$'
					{
					match('$'); 
					skip();
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
	// $ANTLR end "Others"

	@Override
	public void mTokens() throws RecognitionException {
		// IncFileFinder.g:1:8: ( T__20 | T__21 | QUOTE | ML_COMMENT | SL_COMMENT | INCLUDE | LOCAL | MODEL | GROUP | SELECT | FROM | WHERE | WS | ID | N | Others )
		int alt17=16;
		alt17 = dfa17.predict(input);
		switch (alt17) {
			case 1 :
				// IncFileFinder.g:1:10: T__20
				{
				mT__20(); 

				}
				break;
			case 2 :
				// IncFileFinder.g:1:16: T__21
				{
				mT__21(); 

				}
				break;
			case 3 :
				// IncFileFinder.g:1:22: QUOTE
				{
				mQUOTE(); 

				}
				break;
			case 4 :
				// IncFileFinder.g:1:28: ML_COMMENT
				{
				mML_COMMENT(); 

				}
				break;
			case 5 :
				// IncFileFinder.g:1:39: SL_COMMENT
				{
				mSL_COMMENT(); 

				}
				break;
			case 6 :
				// IncFileFinder.g:1:50: INCLUDE
				{
				mINCLUDE(); 

				}
				break;
			case 7 :
				// IncFileFinder.g:1:58: LOCAL
				{
				mLOCAL(); 

				}
				break;
			case 8 :
				// IncFileFinder.g:1:64: MODEL
				{
				mMODEL(); 

				}
				break;
			case 9 :
				// IncFileFinder.g:1:70: GROUP
				{
				mGROUP(); 

				}
				break;
			case 10 :
				// IncFileFinder.g:1:76: SELECT
				{
				mSELECT(); 

				}
				break;
			case 11 :
				// IncFileFinder.g:1:83: FROM
				{
				mFROM(); 

				}
				break;
			case 12 :
				// IncFileFinder.g:1:88: WHERE
				{
				mWHERE(); 

				}
				break;
			case 13 :
				// IncFileFinder.g:1:94: WS
				{
				mWS(); 

				}
				break;
			case 14 :
				// IncFileFinder.g:1:97: ID
				{
				mID(); 

				}
				break;
			case 15 :
				// IncFileFinder.g:1:100: N
				{
				mN(); 

				}
				break;
			case 16 :
				// IncFileFinder.g:1:102: Others
				{
				mOthers(); 

				}
				break;

		}
	}


	protected DFA17 dfa17 = new DFA17(this);
	static final String DFA17_eotS =
		"\4\uffff\1\27\1\uffff\16\25\7\uffff\71\25\3\151\6\25\3\160\3\161\3\162"+
		"\3\25\1\uffff\3\166\3\25\3\uffff\3\172\1\uffff\3\173\2\uffff";
	static final String DFA17_eofS =
		"\174\uffff";
	static final String DFA17_minS =
		"\1\11\3\uffff\1\52\1\uffff\1\156\1\116\1\157\1\117\1\157\1\117\1\162\1"+
		"\122\1\145\1\105\1\162\1\122\1\150\1\110\7\uffff\1\143\1\103\2\143\1\103"+
		"\1\143\1\144\1\104\1\144\1\157\1\117\1\157\1\154\1\114\1\154\1\157\1\117"+
		"\1\157\1\145\1\105\1\145\1\154\1\114\1\154\1\141\1\101\1\141\1\145\1\105"+
		"\1\145\1\165\1\125\1\165\1\145\1\105\1\145\1\155\1\115\1\155\1\162\1\122"+
		"\1\162\1\165\1\125\1\165\1\154\1\114\2\154\1\114\1\154\1\160\1\120\1\160"+
		"\1\143\1\103\1\143\3\60\1\145\1\105\1\145\1\144\1\104\1\144\11\60\1\164"+
		"\1\124\1\164\1\uffff\3\60\1\145\1\105\1\145\3\uffff\3\60\1\uffff\3\60"+
		"\2\uffff";
	static final String DFA17_maxS =
		"\1\175\3\uffff\1\52\1\uffff\2\156\4\157\2\162\2\145\2\162\2\150\7\uffff"+
		"\1\143\1\103\2\143\1\103\1\143\1\144\1\104\1\144\1\157\1\117\1\157\1\154"+
		"\1\114\1\154\1\157\1\117\1\157\1\145\1\105\1\145\1\154\1\114\1\154\1\141"+
		"\1\101\1\141\1\145\1\105\1\145\1\165\1\125\1\165\1\145\1\105\1\145\1\155"+
		"\1\115\1\155\1\162\1\122\1\162\1\165\1\125\1\165\1\154\1\114\2\154\1\114"+
		"\1\154\1\160\1\120\1\160\1\143\1\103\1\143\3\172\1\145\1\105\1\145\1\144"+
		"\1\104\1\144\11\172\1\164\1\124\1\164\1\uffff\3\172\1\145\1\105\1\145"+
		"\3\uffff\3\172\1\uffff\3\172\2\uffff";
	static final String DFA17_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\uffff\1\5\16\uffff\1\15\1\16\1\17\1\20\2\15\1\4"+
		"\116\uffff\1\13\6\uffff\1\7\1\10\1\11\3\uffff\1\14\3\uffff\1\12\1\6";
	static final String DFA17_specialS =
		"\174\uffff}>";
	static final String[] DFA17_transitionS = {
			"\1\31\1\30\1\uffff\1\31\1\24\22\uffff\1\31\1\5\1\uffff\1\5\1\27\2\uffff"+
			"\1\3\7\27\1\4\12\26\2\uffff\3\27\2\uffff\5\25\1\21\1\15\1\25\1\7\2\25"+
			"\1\11\1\13\5\25\1\17\3\25\1\23\3\25\1\1\1\27\1\2\3\uffff\5\25\1\20\1"+
			"\14\1\25\1\6\2\25\1\10\1\12\5\25\1\16\3\25\1\22\3\25\1\27\1\uffff\1\27",
			"",
			"",
			"",
			"\1\32",
			"",
			"\1\33",
			"\1\34\37\uffff\1\35",
			"\1\36",
			"\1\37\37\uffff\1\40",
			"\1\41",
			"\1\42\37\uffff\1\43",
			"\1\44",
			"\1\45\37\uffff\1\46",
			"\1\47",
			"\1\50\37\uffff\1\51",
			"\1\52",
			"\1\53\37\uffff\1\54",
			"\1\55",
			"\1\56\37\uffff\1\57",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\60",
			"\1\61",
			"\1\62",
			"\1\63",
			"\1\64",
			"\1\65",
			"\1\66",
			"\1\67",
			"\1\70",
			"\1\71",
			"\1\72",
			"\1\73",
			"\1\74",
			"\1\75",
			"\1\76",
			"\1\77",
			"\1\100",
			"\1\101",
			"\1\102",
			"\1\103",
			"\1\104",
			"\1\105",
			"\1\106",
			"\1\107",
			"\1\110",
			"\1\111",
			"\1\112",
			"\1\113",
			"\1\114",
			"\1\115",
			"\1\116",
			"\1\117",
			"\1\120",
			"\1\121",
			"\1\122",
			"\1\123",
			"\1\124",
			"\1\125",
			"\1\126",
			"\1\127",
			"\1\130",
			"\1\131",
			"\1\132",
			"\1\133",
			"\1\134",
			"\1\135",
			"\1\136",
			"\1\137",
			"\1\140",
			"\1\141",
			"\1\142",
			"\1\143",
			"\1\144",
			"\1\145",
			"\1\146",
			"\1\147",
			"\1\150",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\152",
			"\1\153",
			"\1\154",
			"\1\155",
			"\1\156",
			"\1\157",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\163",
			"\1\164",
			"\1\165",
			"",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\1\167",
			"\1\170",
			"\1\171",
			"",
			"",
			"",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
			"",
			""
	};

	static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
	static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
	static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
	static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
	static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
	static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
	static final short[][] DFA17_transition;

	static {
		int numStates = DFA17_transitionS.length;
		DFA17_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
		}
	}

	protected class DFA17 extends DFA {

		public DFA17(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 17;
			this.eot = DFA17_eot;
			this.eof = DFA17_eof;
			this.min = DFA17_min;
			this.max = DFA17_max;
			this.accept = DFA17_accept;
			this.special = DFA17_special;
			this.transition = DFA17_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__20 | T__21 | QUOTE | ML_COMMENT | SL_COMMENT | INCLUDE | LOCAL | MODEL | GROUP | SELECT | FROM | WHERE | WS | ID | N | Others );";
		}
	}

}
