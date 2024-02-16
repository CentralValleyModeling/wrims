// $ANTLR 3.5.2 IncFileFinder.g 2024-02-12 13:08:36

  package wrimsv2.wreslplus.grammar;
  import wrimsv2.wreslparser.elements.LogUtils; 
  import wrimsv2.wreslplus.elements.IncFileSimple; 
  import wrimsv2.wreslplus.elements.LookupTableSimple; 
  import java.util.HashMap;
  import java.util.Set;
  import java.util.HashSet;
  import java.util.LinkedHashSet;
  import java.io.File;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class IncFileFinderParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "Digit", "FROM", "GROUP", "ID", 
		"INCLUDE", "LOCAL", "Letter", "ML_COMMENT", "MODEL", "N", "Others", "QUOTE", 
		"SELECT", "SL_COMMENT", "WHERE", "WS", "'['", "']'"
	};
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

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public IncFileFinderParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public IncFileFinderParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return IncFileFinderParser.tokenNames; }
	@Override public String getGrammarFileName() { return "IncFileFinder.g"; }


	    //public ArrayList<String> incFileList;
	    public ArrayList<IncFileSimple> incFileSimpleList;
	    public ArrayList<LookupTableSimple> lookupTableSimpleList;
		  //public CommonTree commonTree;
		  public String currentAbsolutePath;
	  	public String currentAbsoluteParent;
	    public int number_of_errors = 0;
	    public int line=1;
	  
	      /// error message 
	    public void displayRecognitionError(String[] tokenNames,
	                                        RecognitionException e) {
	        String hdr = getErrorHeader(e);
	        String msg = getErrorMessage(e, tokenNames);
	        //LogUtils.errMsg("@parser "+ hdr + " " + msg);
	        LogUtils.errMsgLocation(currentAbsolutePath, e.line, msg);
	        number_of_errors++;
	    }



	// $ANTLR start "wreslFile"
	// IncFileFinder.g:62:1: wreslFile : ( . )* ( (f= include_file | include_group | include_model |l= lookup ) ( . )* )* ;
	public final void wreslFile() throws RecognitionException {
		ParserRuleReturnScope f =null;
		ParserRuleReturnScope l =null;

		 //incFileList = new ArrayList<String>(); 
		       incFileSimpleList = new ArrayList<IncFileSimple>();
		       lookupTableSimpleList = new ArrayList<LookupTableSimple>(); 
		try {
			// IncFileFinder.g:66:3: ( ( . )* ( (f= include_file | include_group | include_model |l= lookup ) ( . )* )* )
			// IncFileFinder.g:66:5: ( . )* ( (f= include_file | include_group | include_model |l= lookup ) ( . )* )*
			{
			// IncFileFinder.g:66:5: ( . )*
			loop1:
			while (true) {
				int alt1=2;
				switch ( input.LA(1) ) {
				case INCLUDE:
					{
					alt1=2;
					}
					break;
				case SELECT:
					{
					alt1=2;
					}
					break;
				case EOF:
					{
					alt1=2;
					}
					break;
				case Digit:
				case FROM:
				case GROUP:
				case ID:
				case LOCAL:
				case Letter:
				case ML_COMMENT:
				case MODEL:
				case N:
				case Others:
				case QUOTE:
				case SL_COMMENT:
				case WHERE:
				case WS:
				case 20:
				case 21:
					{
					alt1=1;
					}
					break;
				}
				switch (alt1) {
				case 1 :
					// IncFileFinder.g:66:5: .
					{
					matchAny(input); 
					}
					break;

				default :
					break loop1;
				}
			}

			// IncFileFinder.g:66:9: ( (f= include_file | include_group | include_model |l= lookup ) ( . )* )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==INCLUDE||LA4_0==SELECT) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// IncFileFinder.g:67:7: (f= include_file | include_group | include_model |l= lookup ) ( . )*
					{
					// IncFileFinder.g:67:7: (f= include_file | include_group | include_model |l= lookup )
					int alt2=4;
					int LA2_0 = input.LA(1);
					if ( (LA2_0==INCLUDE) ) {
						switch ( input.LA(2) ) {
						case GROUP:
							{
							alt2=2;
							}
							break;
						case MODEL:
							{
							alt2=3;
							}
							break;
						case QUOTE:
						case 20:
							{
							alt2=1;
							}
							break;
						default:
							int nvaeMark = input.mark();
							try {
								input.consume();
								NoViableAltException nvae =
									new NoViableAltException("", 2, 1, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
					}
					else if ( (LA2_0==SELECT) ) {
						alt2=4;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 2, 0, input);
						throw nvae;
					}

					switch (alt2) {
						case 1 :
							// IncFileFinder.g:67:9: f= include_file
							{
							pushFollow(FOLLOW_include_file_in_wreslFile86);
							f=include_file();
							state._fsp--;

							 //incFileList.add(new File(currentAbsoluteParent, (f!=null?((IncFileFinderParser.include_file_return)f).fp_string:null)).toString());
							          (f!=null?((IncFileFinderParser.include_file_return)f).incFileObj:null).absPath=new File(currentAbsoluteParent, (f!=null?((IncFileFinderParser.include_file_return)f).fp_string:null)).toString();
							          incFileSimpleList.add((f!=null?((IncFileFinderParser.include_file_return)f).incFileObj:null));
							        
							}
							break;
						case 2 :
							// IncFileFinder.g:72:9: include_group
							{
							pushFollow(FOLLOW_include_group_in_wreslFile107);
							include_group();
							state._fsp--;

							}
							break;
						case 3 :
							// IncFileFinder.g:73:9: include_model
							{
							pushFollow(FOLLOW_include_model_in_wreslFile119);
							include_model();
							state._fsp--;

							}
							break;
						case 4 :
							// IncFileFinder.g:74:9: l= lookup
							{
							pushFollow(FOLLOW_lookup_in_wreslFile131);
							l=lookup();
							state._fsp--;

							 lookupTableSimpleList.add((l!=null?((IncFileFinderParser.lookup_return)l).lookupTableObj:null));
							        
							}
							break;

					}

					// IncFileFinder.g:77:7: ( . )*
					loop3:
					while (true) {
						int alt3=2;
						switch ( input.LA(1) ) {
						case EOF:
							{
							alt3=2;
							}
							break;
						case INCLUDE:
							{
							alt3=2;
							}
							break;
						case SELECT:
							{
							alt3=2;
							}
							break;
						case Digit:
						case FROM:
						case GROUP:
						case ID:
						case LOCAL:
						case Letter:
						case ML_COMMENT:
						case MODEL:
						case N:
						case Others:
						case QUOTE:
						case SL_COMMENT:
						case WHERE:
						case WS:
						case 20:
						case 21:
							{
							alt3=1;
							}
							break;
						}
						switch (alt3) {
						case 1 :
							// IncFileFinder.g:77:7: .
							{
							matchAny(input); 
							}
							break;

						default :
							break loop3;
						}
					}

					}
					break;

				default :
					break loop4;
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
	// $ANTLR end "wreslFile"



	// $ANTLR start "include_group"
	// IncFileFinder.g:79:1: include_group : INCLUDE GROUP ID ;
	public final void include_group() throws RecognitionException {
		try {
			// IncFileFinder.g:79:15: ( INCLUDE GROUP ID )
			// IncFileFinder.g:79:17: INCLUDE GROUP ID
			{
			match(input,INCLUDE,FOLLOW_INCLUDE_in_include_group167); 
			match(input,GROUP,FOLLOW_GROUP_in_include_group169); 
			match(input,ID,FOLLOW_ID_in_include_group171); 
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
	// $ANTLR end "include_group"



	// $ANTLR start "include_model"
	// IncFileFinder.g:80:1: include_model : INCLUDE MODEL ID ;
	public final void include_model() throws RecognitionException {
		try {
			// IncFileFinder.g:80:15: ( INCLUDE MODEL ID )
			// IncFileFinder.g:80:17: INCLUDE MODEL ID
			{
			match(input,INCLUDE,FOLLOW_INCLUDE_in_include_model179); 
			match(input,MODEL,FOLLOW_MODEL_in_include_model181); 
			match(input,ID,FOLLOW_ID_in_include_model183); 
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
	// $ANTLR end "include_model"


	public static class include_file_return extends ParserRuleReturnScope {
		public String fp_string;
		public IncFileSimple incFileObj;
	};


	// $ANTLR start "include_file"
	// IncFileFinder.g:81:1: include_file returns [String fp_string, IncFileSimple incFileObj] : i= INCLUDE ( local_deprecated )? fp= file_path ;
	public final IncFileFinderParser.include_file_return include_file() throws RecognitionException {
		IncFileFinderParser.include_file_return retval = new IncFileFinderParser.include_file_return();
		retval.start = input.LT(1);

		Token i=null;
		ParserRuleReturnScope fp =null;

		retval.incFileObj = new IncFileSimple();
		       retval.incFileObj.fromWresl = this.currentAbsolutePath; 
		       
		try {
			// IncFileFinder.g:88:7: (i= INCLUDE ( local_deprecated )? fp= file_path )
			// IncFileFinder.g:88:9: i= INCLUDE ( local_deprecated )? fp= file_path
			{
			i=(Token)match(input,INCLUDE,FOLLOW_INCLUDE_in_include_file220); 
			line=(i!=null?i.getLine():0);
			// IncFileFinder.g:88:33: ( local_deprecated )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==20) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// IncFileFinder.g:88:34: local_deprecated
					{
					pushFollow(FOLLOW_local_deprecated_in_include_file223);
					local_deprecated();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_file_path_in_include_file229);
			fp=file_path();
			state._fsp--;

			retval.fp_string = (fp!=null?input.toString(fp.start,fp.stop):null).substring(1,(fp!=null?input.toString(fp.start,fp.stop):null).length()-1);
			}

			retval.stop = input.LT(-1);

			retval.incFileObj.line=line;
			       
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
	// $ANTLR end "include_file"


	public static class file_path_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "file_path"
	// IncFileFinder.g:91:1: file_path : QUOTE ;
	public final IncFileFinderParser.file_path_return file_path() throws RecognitionException {
		IncFileFinderParser.file_path_return retval = new IncFileFinderParser.file_path_return();
		retval.start = input.LT(1);

		try {
			// IncFileFinder.g:91:11: ( QUOTE )
			// IncFileFinder.g:91:13: QUOTE
			{
			match(input,QUOTE,FOLLOW_QUOTE_in_file_path249); 
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
	// $ANTLR end "file_path"



	// $ANTLR start "local_deprecated"
	// IncFileFinder.g:93:1: local_deprecated : '[' LOCAL ']' ;
	public final void local_deprecated() throws RecognitionException {
		try {
			// IncFileFinder.g:94:3: ( '[' LOCAL ']' )
			// IncFileFinder.g:94:5: '[' LOCAL ']'
			{
			match(input,20,FOLLOW_20_in_local_deprecated261); 
			match(input,LOCAL,FOLLOW_LOCAL_in_local_deprecated263); 
			match(input,21,FOLLOW_21_in_local_deprecated265); 
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
	// $ANTLR end "local_deprecated"


	public static class lookup_return extends ParserRuleReturnScope {
		public String tp_string;
		public LookupTableSimple lookupTableObj;
	};


	// $ANTLR start "lookup"
	// IncFileFinder.g:97:1: lookup returns [String tp_string, LookupTableSimple lookupTableObj] : SELECT ID i= FROM ft= fromTable ;
	public final IncFileFinderParser.lookup_return lookup() throws RecognitionException {
		IncFileFinderParser.lookup_return retval = new IncFileFinderParser.lookup_return();
		retval.start = input.LT(1);

		Token i=null;
		ParserRuleReturnScope ft =null;

		retval.lookupTableObj = new LookupTableSimple();
		       retval.lookupTableObj.fromWresl = this.currentAbsolutePath; 
		       
		try {
			// IncFileFinder.g:104:3: ( SELECT ID i= FROM ft= fromTable )
			// IncFileFinder.g:104:3: SELECT ID i= FROM ft= fromTable
			{
			match(input,SELECT,FOLLOW_SELECT_in_lookup296); 
			match(input,ID,FOLLOW_ID_in_lookup298); 
			i=(Token)match(input,FROM,FOLLOW_FROM_in_lookup302); 
			line=(i!=null?i.getLine():0);
			pushFollow(FOLLOW_fromTable_in_lookup308);
			ft=fromTable();
			state._fsp--;

			retval.lookupTableObj.tableName=(ft!=null?input.toString(ft.start,ft.stop):null);
			}

			retval.stop = input.LT(-1);

			retval.lookupTableObj.line=line;
			       
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
	// $ANTLR end "lookup"


	public static class fromTable_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "fromTable"
	// IncFileFinder.g:106:1: fromTable : ID ;
	public final IncFileFinderParser.fromTable_return fromTable() throws RecognitionException {
		IncFileFinderParser.fromTable_return retval = new IncFileFinderParser.fromTable_return();
		retval.start = input.LT(1);

		try {
			// IncFileFinder.g:106:11: ( ID )
			// IncFileFinder.g:107:1: ID
			{
			match(input,ID,FOLLOW_ID_in_fromTable319); 
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
	// $ANTLR end "fromTable"

	// Delegated rules



	public static final BitSet FOLLOW_include_file_in_wreslFile86 = new BitSet(new long[]{0x00000000003FFFF2L});
	public static final BitSet FOLLOW_include_group_in_wreslFile107 = new BitSet(new long[]{0x00000000003FFFF2L});
	public static final BitSet FOLLOW_include_model_in_wreslFile119 = new BitSet(new long[]{0x00000000003FFFF2L});
	public static final BitSet FOLLOW_lookup_in_wreslFile131 = new BitSet(new long[]{0x00000000003FFFF2L});
	public static final BitSet FOLLOW_INCLUDE_in_include_group167 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_GROUP_in_include_group169 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ID_in_include_group171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INCLUDE_in_include_model179 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_MODEL_in_include_model181 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ID_in_include_model183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INCLUDE_in_include_file220 = new BitSet(new long[]{0x0000000000108000L});
	public static final BitSet FOLLOW_local_deprecated_in_include_file223 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_file_path_in_include_file229 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QUOTE_in_file_path249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_20_in_local_deprecated261 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_LOCAL_in_local_deprecated263 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_local_deprecated265 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_lookup296 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_ID_in_lookup298 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_FROM_in_lookup302 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_fromTable_in_lookup308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_fromTable319 = new BitSet(new long[]{0x0000000000000002L});
}
