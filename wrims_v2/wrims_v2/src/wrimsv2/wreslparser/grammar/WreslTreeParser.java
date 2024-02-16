// $ANTLR 3.5.2 WreslTree.g 2024-02-12 13:12:49

  package wrimsv2.wreslparser.grammar;
  import wrimsv2.wreslparser.elements.LogUtils; 
  import wrimsv2.wreslparser.elements.Tools;
  import wrimsv2.wreslplus.elements.VarCycleIndex; 
  import wrimsv2.commondata.wresldata.Param;
  import java.util.Set;
  import java.util.HashSet;
  import java.util.Arrays;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class WreslTreeParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALIAS", "ALWAYS", "AND", "Alias", 
		"Always", "Assignment", "B_part", "CASE", "COMMENT", "COMMENT_LAST_LINE", 
		"CONDITION", "CONSTRAIN", "CONVERT", "Case", "Condition", "Constrain", 
		"Constraint_content", "DEFINE", "DIGIT", "DIR_ELEMENT", "DIR_SPLIT", "DIR_UP", 
		"DLL", "Dependants", "Dvar", "DvarTimeArray_nonStd", "DvarTimeArray_std", 
		"Dvar_integer", "Dvar_nonStd", "Dvar_nonStd_local", "Dvar_std", "EXTERNAL", 
		"Exp", "Expression", "External", "F90", "FILE_PATH", "FLOAT", "FROM", 
		"Free", "From", "GIVEN", "GOAL", "Given", "Global", "Goal_case", "Goal_no_case", 
		"Goal_simple", "IDENT", "IDENT_FOLLOWED_BY_LOGICAL", "INCLUDE", "INT", 
		"INTEGER", "INTEGER_FOLLOWED_BY_LOGICAL", "INTEGER_WORD", "Include", "KIND", 
		"Kind", "LETTER", "LHS", "LOCAL", "LOWER", "Lhs", "Lhs_gt_rhs", "Lhs_lt_rhs", 
		"LimitType", "Local", "Lower", "MAX", "MIN", "MODEL", "MULTILINE_COMMENT", 
		"Model", "NEGATION", "NEW_LINE", "NOT", "Never", "OBJECTIVE", "OR", "ORDER", 
		"One", "Op", "Order", "PENALTY", "Penalty", "RANGE", "RHS", "ROUND", "Rhs", 
		"SELECT", "SEQUENCE", "STD", "STRING", "SUM", "Scope", "Select", "Separator", 
		"Sequence", "Sign", "Simple", "Slack_Surplus", "Std", "Sum_hdr", "SvarTimeArray_case", 
		"SvarTimeArray_const", "Svar_case", "Svar_const", "Svar_dss", "Svar_sum", 
		"Svar_table", "TIMESERIES", "TIMESTEP", "TIMESTEPVALUE", "TimeArraySize", 
		"Two", "UNBOUNDED", "UNITS", "UPPER", "USE", "Unbounded", "Units", "Upper", 
		"Use", "VALUE", "Value", "VarInCycle", "WHERE", "WRESL_EXT", "WRESL_FILE", 
		"WS", "Weight", "Weight_table", "Where_content", "Where_item_number", 
		"'$m'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'/'", "'/='", "'<'", 
		"'<='", "'='", "'=='", "'>'", "'>='", "'['", "']'", "'i='", "'wresl_version'", 
		"'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__138=138;
	public static final int T__139=139;
	public static final int T__140=140;
	public static final int T__141=141;
	public static final int T__142=142;
	public static final int T__143=143;
	public static final int T__144=144;
	public static final int T__145=145;
	public static final int T__146=146;
	public static final int T__147=147;
	public static final int T__148=148;
	public static final int T__149=149;
	public static final int T__150=150;
	public static final int T__151=151;
	public static final int T__152=152;
	public static final int T__153=153;
	public static final int T__154=154;
	public static final int T__155=155;
	public static final int T__156=156;
	public static final int T__157=157;
	public static final int T__158=158;
	public static final int ALIAS=4;
	public static final int ALWAYS=5;
	public static final int AND=6;
	public static final int Alias=7;
	public static final int Always=8;
	public static final int Assignment=9;
	public static final int B_part=10;
	public static final int CASE=11;
	public static final int COMMENT=12;
	public static final int COMMENT_LAST_LINE=13;
	public static final int CONDITION=14;
	public static final int CONSTRAIN=15;
	public static final int CONVERT=16;
	public static final int Case=17;
	public static final int Condition=18;
	public static final int Constrain=19;
	public static final int Constraint_content=20;
	public static final int DEFINE=21;
	public static final int DIGIT=22;
	public static final int DIR_ELEMENT=23;
	public static final int DIR_SPLIT=24;
	public static final int DIR_UP=25;
	public static final int DLL=26;
	public static final int Dependants=27;
	public static final int Dvar=28;
	public static final int DvarTimeArray_nonStd=29;
	public static final int DvarTimeArray_std=30;
	public static final int Dvar_integer=31;
	public static final int Dvar_nonStd=32;
	public static final int Dvar_nonStd_local=33;
	public static final int Dvar_std=34;
	public static final int EXTERNAL=35;
	public static final int Exp=36;
	public static final int Expression=37;
	public static final int External=38;
	public static final int F90=39;
	public static final int FILE_PATH=40;
	public static final int FLOAT=41;
	public static final int FROM=42;
	public static final int Free=43;
	public static final int From=44;
	public static final int GIVEN=45;
	public static final int GOAL=46;
	public static final int Given=47;
	public static final int Global=48;
	public static final int Goal_case=49;
	public static final int Goal_no_case=50;
	public static final int Goal_simple=51;
	public static final int IDENT=52;
	public static final int IDENT_FOLLOWED_BY_LOGICAL=53;
	public static final int INCLUDE=54;
	public static final int INT=55;
	public static final int INTEGER=56;
	public static final int INTEGER_FOLLOWED_BY_LOGICAL=57;
	public static final int INTEGER_WORD=58;
	public static final int Include=59;
	public static final int KIND=60;
	public static final int Kind=61;
	public static final int LETTER=62;
	public static final int LHS=63;
	public static final int LOCAL=64;
	public static final int LOWER=65;
	public static final int Lhs=66;
	public static final int Lhs_gt_rhs=67;
	public static final int Lhs_lt_rhs=68;
	public static final int LimitType=69;
	public static final int Local=70;
	public static final int Lower=71;
	public static final int MAX=72;
	public static final int MIN=73;
	public static final int MODEL=74;
	public static final int MULTILINE_COMMENT=75;
	public static final int Model=76;
	public static final int NEGATION=77;
	public static final int NEW_LINE=78;
	public static final int NOT=79;
	public static final int Never=80;
	public static final int OBJECTIVE=81;
	public static final int OR=82;
	public static final int ORDER=83;
	public static final int One=84;
	public static final int Op=85;
	public static final int Order=86;
	public static final int PENALTY=87;
	public static final int Penalty=88;
	public static final int RANGE=89;
	public static final int RHS=90;
	public static final int ROUND=91;
	public static final int Rhs=92;
	public static final int SELECT=93;
	public static final int SEQUENCE=94;
	public static final int STD=95;
	public static final int STRING=96;
	public static final int SUM=97;
	public static final int Scope=98;
	public static final int Select=99;
	public static final int Separator=100;
	public static final int Sequence=101;
	public static final int Sign=102;
	public static final int Simple=103;
	public static final int Slack_Surplus=104;
	public static final int Std=105;
	public static final int Sum_hdr=106;
	public static final int SvarTimeArray_case=107;
	public static final int SvarTimeArray_const=108;
	public static final int Svar_case=109;
	public static final int Svar_const=110;
	public static final int Svar_dss=111;
	public static final int Svar_sum=112;
	public static final int Svar_table=113;
	public static final int TIMESERIES=114;
	public static final int TIMESTEP=115;
	public static final int TIMESTEPVALUE=116;
	public static final int TimeArraySize=117;
	public static final int Two=118;
	public static final int UNBOUNDED=119;
	public static final int UNITS=120;
	public static final int UPPER=121;
	public static final int USE=122;
	public static final int Unbounded=123;
	public static final int Units=124;
	public static final int Upper=125;
	public static final int Use=126;
	public static final int VALUE=127;
	public static final int Value=128;
	public static final int VarInCycle=129;
	public static final int WHERE=130;
	public static final int WRESL_EXT=131;
	public static final int WRESL_FILE=132;
	public static final int WS=133;
	public static final int Weight=134;
	public static final int Weight_table=135;
	public static final int Where_content=136;
	public static final int Where_item_number=137;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public WreslTreeParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public WreslTreeParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return WreslTreeParser.tokenNames; }
	@Override public String getGrammarFileName() { return "WreslTree.g"; }


		
		public String wresl_version = null;
	    public ArrayList<String> model_in_sequence = new ArrayList<String>();
	    public ArrayList<String> model_list = new ArrayList<String>();
	    
	    public CommonTree commonTree;
	  	public String currentAbsolutePath;
	  	public String currentAbsoluteParent;
	  		public boolean sometest(String name) {
			
				return true;
				}
	  	
		/// error message	
	    public void displayRecognitionError(String[] tokenNames,
	                                        RecognitionException e) {
	        String hdr = getErrorHeader(e);
	        String msg = getErrorMessage(e, tokenNames);
	        LogUtils.errMsg(hdr + " " + msg);
	    }	


	public static class mainFile_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "mainFile"
	// WreslTree.g:98:1: mainFile : ( sequence )+ ( model )+ EOF !;
	public final WreslTreeParser.mainFile_return mainFile() throws RecognitionException {
		WreslTreeParser.mainFile_return retval = new WreslTreeParser.mainFile_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EOF3=null;
		ParserRuleReturnScope sequence1 =null;
		ParserRuleReturnScope model2 =null;

		CommonTree EOF3_tree=null;

		try {
			// WreslTree.g:99:2: ( ( sequence )+ ( model )+ EOF !)
			// WreslTree.g:99:4: ( sequence )+ ( model )+ EOF !
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslTree.g:99:4: ( sequence )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==SEQUENCE) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// WreslTree.g:99:4: sequence
					{
					pushFollow(FOLLOW_sequence_in_mainFile330);
					sequence1=sequence();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, sequence1.getTree());

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			// WreslTree.g:99:14: ( model )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==MODEL) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// WreslTree.g:99:14: model
					{
					pushFollow(FOLLOW_model_in_mainFile333);
					model2=model();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, model2.getTree());

					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_mainFile339); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "mainFile"


	public static class version_tag_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "version_tag"
	// WreslTree.g:103:1: version_tag : '[' 'wresl_version' vn= version_number ']' ;
	public final WreslTreeParser.version_tag_return version_tag() throws RecognitionException {
		WreslTreeParser.version_tag_return retval = new WreslTreeParser.version_tag_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal4=null;
		Token string_literal5=null;
		Token char_literal6=null;
		ParserRuleReturnScope vn =null;

		CommonTree char_literal4_tree=null;
		CommonTree string_literal5_tree=null;
		CommonTree char_literal6_tree=null;

		try {
			// WreslTree.g:103:13: ( '[' 'wresl_version' vn= version_number ']' )
			// WreslTree.g:103:15: '[' 'wresl_version' vn= version_number ']'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal4=(Token)match(input,153,FOLLOW_153_in_version_tag351); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal4_tree = (CommonTree)adaptor.create(char_literal4);
			adaptor.addChild(root_0, char_literal4_tree);
			}

			string_literal5=(Token)match(input,156,FOLLOW_156_in_version_tag353); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal5_tree = (CommonTree)adaptor.create(string_literal5);
			adaptor.addChild(root_0, string_literal5_tree);
			}

			pushFollow(FOLLOW_version_number_in_version_tag357);
			vn=version_number();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, vn.getTree());

			char_literal6=(Token)match(input,154,FOLLOW_154_in_version_tag359); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal6_tree = (CommonTree)adaptor.create(char_literal6);
			adaptor.addChild(root_0, char_literal6_tree);
			}

			if ( state.backtracking==0 ) {wresl_version=(vn!=null?input.toString(vn.start,vn.stop):null);}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "version_tag"


	public static class version_number_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "version_number"
	// WreslTree.g:105:1: version_number : FLOAT ;
	public final WreslTreeParser.version_number_return version_number() throws RecognitionException {
		WreslTreeParser.version_number_return retval = new WreslTreeParser.version_number_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FLOAT7=null;

		CommonTree FLOAT7_tree=null;

		try {
			// WreslTree.g:105:16: ( FLOAT )
			// WreslTree.g:105:18: FLOAT
			{
			root_0 = (CommonTree)adaptor.nil();


			FLOAT7=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_version_number371); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FLOAT7_tree = (CommonTree)adaptor.create(FLOAT7);
			adaptor.addChild(root_0, FLOAT7_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "version_number"


	public static class evaluator_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "evaluator"
	// WreslTree.g:107:1: evaluator : ( pattern )+ EOF !;
	public final WreslTreeParser.evaluator_return evaluator() throws RecognitionException {
		WreslTreeParser.evaluator_return retval = new WreslTreeParser.evaluator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EOF9=null;
		ParserRuleReturnScope pattern8 =null;

		CommonTree EOF9_tree=null;

		try {
			// WreslTree.g:108:2: ( ( pattern )+ EOF !)
			// WreslTree.g:108:4: ( pattern )+ EOF !
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslTree.g:108:4: ( pattern )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==DEFINE||LA3_0==GOAL||LA3_0==INCLUDE||LA3_0==OBJECTIVE) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// WreslTree.g:108:4: pattern
					{
					pushFollow(FOLLOW_pattern_in_evaluator380);
					pattern8=pattern();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, pattern8.getTree());

					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			EOF9=(Token)match(input,EOF,FOLLOW_EOF_in_evaluator387); if (state.failed) return retval;
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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


	public static class pattern_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "pattern"
	// WreslTree.g:112:1: pattern : ( dvar | svar | goal | includeFile | alias | weight_table | external | integer | svar_timeArray );
	public final WreslTreeParser.pattern_return pattern() throws RecognitionException {
		WreslTreeParser.pattern_return retval = new WreslTreeParser.pattern_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope dvar10 =null;
		ParserRuleReturnScope svar11 =null;
		ParserRuleReturnScope goal12 =null;
		ParserRuleReturnScope includeFile13 =null;
		ParserRuleReturnScope alias14 =null;
		ParserRuleReturnScope weight_table15 =null;
		ParserRuleReturnScope external16 =null;
		ParserRuleReturnScope integer17 =null;
		ParserRuleReturnScope svar_timeArray18 =null;


		try {
			// WreslTree.g:113:2: ( dvar | svar | goal | includeFile | alias | weight_table | external | integer | svar_timeArray )
			int alt4=9;
			switch ( input.LA(1) ) {
			case DEFINE:
				{
				switch ( input.LA(2) ) {
				case 139:
					{
					int LA4_5 = input.LA(3);
					if ( (LA4_5==INTEGER) ) {
						int LA4_8 = input.LA(4);
						if ( (LA4_8==140) ) {
							int LA4_13 = input.LA(5);
							if ( (LA4_13==153) ) {
								int LA4_21 = input.LA(6);
								if ( (LA4_21==LOCAL) ) {
									int LA4_24 = input.LA(7);
									if ( (LA4_24==154) ) {
										int LA4_27 = input.LA(8);
										if ( (LA4_27==IDENT) ) {
											int LA4_22 = input.LA(9);
											if ( (LA4_22==157) ) {
												switch ( input.LA(10) ) {
												case INTEGER_WORD:
													{
													alt4=8;
													}
													break;
												case LOWER:
												case STD:
												case UPPER:
													{
													alt4=1;
													}
													break;
												case ALIAS:
													{
													alt4=5;
													}
													break;
												case CASE:
												case SELECT:
												case SUM:
												case VALUE:
													{
													alt4=9;
													}
													break;
												default:
													if (state.backtracking>0) {state.failed=true; return retval;}
													int nvaeMark = input.mark();
													try {
														for (int nvaeConsume = 0; nvaeConsume < 10 - 1; nvaeConsume++) {
															input.consume();
														}
														NoViableAltException nvae =
															new NoViableAltException("", 4, 26, input);
														throw nvae;
													} finally {
														input.rewind(nvaeMark);
													}
												}
											}

											else {
												if (state.backtracking>0) {state.failed=true; return retval;}
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 4, 22, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}

										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 4, 27, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 4, 24, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}
								else if ( (LA4_21==154) ) {
									int LA4_25 = input.LA(7);
									if ( (LA4_25==IDENT) ) {
										int LA4_28 = input.LA(8);
										if ( (LA4_28==157) ) {
											switch ( input.LA(9) ) {
											case INTEGER_WORD:
												{
												alt4=8;
												}
												break;
											case ALIAS:
												{
												alt4=5;
												}
												break;
											case CASE:
											case SELECT:
												{
												alt4=9;
												}
												break;
											default:
												if (state.backtracking>0) {state.failed=true; return retval;}
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 4, 30, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}
										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 4, 28, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 4, 25, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 4, 21, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}
							else if ( (LA4_13==IDENT) ) {
								int LA4_22 = input.LA(6);
								if ( (LA4_22==157) ) {
									switch ( input.LA(7) ) {
									case INTEGER_WORD:
										{
										alt4=8;
										}
										break;
									case LOWER:
									case STD:
									case UPPER:
										{
										alt4=1;
										}
										break;
									case ALIAS:
										{
										alt4=5;
										}
										break;
									case CASE:
									case SELECT:
									case SUM:
									case VALUE:
										{
										alt4=9;
										}
										break;
									default:
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 4, 26, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}
								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 4, 22, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 4, 13, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 8, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA4_5==IDENT) ) {
						int LA4_9 = input.LA(4);
						if ( (LA4_9==140) ) {
							int LA4_13 = input.LA(5);
							if ( (LA4_13==153) ) {
								int LA4_21 = input.LA(6);
								if ( (LA4_21==LOCAL) ) {
									int LA4_24 = input.LA(7);
									if ( (LA4_24==154) ) {
										int LA4_27 = input.LA(8);
										if ( (LA4_27==IDENT) ) {
											int LA4_22 = input.LA(9);
											if ( (LA4_22==157) ) {
												switch ( input.LA(10) ) {
												case INTEGER_WORD:
													{
													alt4=8;
													}
													break;
												case LOWER:
												case STD:
												case UPPER:
													{
													alt4=1;
													}
													break;
												case ALIAS:
													{
													alt4=5;
													}
													break;
												case CASE:
												case SELECT:
												case SUM:
												case VALUE:
													{
													alt4=9;
													}
													break;
												default:
													if (state.backtracking>0) {state.failed=true; return retval;}
													int nvaeMark = input.mark();
													try {
														for (int nvaeConsume = 0; nvaeConsume < 10 - 1; nvaeConsume++) {
															input.consume();
														}
														NoViableAltException nvae =
															new NoViableAltException("", 4, 26, input);
														throw nvae;
													} finally {
														input.rewind(nvaeMark);
													}
												}
											}

											else {
												if (state.backtracking>0) {state.failed=true; return retval;}
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 4, 22, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}

										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 4, 27, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 4, 24, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}
								else if ( (LA4_21==154) ) {
									int LA4_25 = input.LA(7);
									if ( (LA4_25==IDENT) ) {
										int LA4_28 = input.LA(8);
										if ( (LA4_28==157) ) {
											switch ( input.LA(9) ) {
											case INTEGER_WORD:
												{
												alt4=8;
												}
												break;
											case ALIAS:
												{
												alt4=5;
												}
												break;
											case CASE:
											case SELECT:
												{
												alt4=9;
												}
												break;
											default:
												if (state.backtracking>0) {state.failed=true; return retval;}
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 4, 30, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}
										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 4, 28, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 4, 25, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 4, 21, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}
							else if ( (LA4_13==IDENT) ) {
								int LA4_22 = input.LA(6);
								if ( (LA4_22==157) ) {
									switch ( input.LA(7) ) {
									case INTEGER_WORD:
										{
										alt4=8;
										}
										break;
									case LOWER:
									case STD:
									case UPPER:
										{
										alt4=1;
										}
										break;
									case ALIAS:
										{
										alt4=5;
										}
										break;
									case CASE:
									case SELECT:
									case SUM:
									case VALUE:
										{
										alt4=9;
										}
										break;
									default:
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 4, 26, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}
								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 4, 22, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 4, 13, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 9, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case 153:
					{
					int LA4_6 = input.LA(3);
					if ( (LA4_6==LOCAL) ) {
						int LA4_10 = input.LA(4);
						if ( (LA4_10==154) ) {
							int LA4_14 = input.LA(5);
							if ( (LA4_14==IDENT) ) {
								int LA4_7 = input.LA(6);
								if ( (LA4_7==157) ) {
									switch ( input.LA(7) ) {
									case LOWER:
									case STD:
									case UPPER:
										{
										alt4=1;
										}
										break;
									case CASE:
									case SELECT:
									case SUM:
									case TIMESERIES:
									case VALUE:
										{
										alt4=2;
										}
										break;
									case ALIAS:
										{
										alt4=5;
										}
										break;
									case EXTERNAL:
										{
										alt4=7;
										}
										break;
									case INTEGER_WORD:
										{
										alt4=8;
										}
										break;
									default:
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 4, 12, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}
								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 4, 7, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 4, 14, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 10, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA4_6==154) ) {
						int LA4_11 = input.LA(4);
						if ( (LA4_11==IDENT) ) {
							int LA4_15 = input.LA(5);
							if ( (LA4_15==157) ) {
								switch ( input.LA(6) ) {
								case ALIAS:
									{
									alt4=5;
									}
									break;
								case EXTERNAL:
									{
									alt4=7;
									}
									break;
								case INTEGER_WORD:
									{
									alt4=8;
									}
									break;
								case CASE:
								case SELECT:
									{
									alt4=2;
									}
									break;
								default:
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 4, 23, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 4, 15, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 11, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 6, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case IDENT:
					{
					int LA4_7 = input.LA(3);
					if ( (LA4_7==157) ) {
						switch ( input.LA(4) ) {
						case LOWER:
						case STD:
						case UPPER:
							{
							alt4=1;
							}
							break;
						case CASE:
						case SELECT:
						case SUM:
						case TIMESERIES:
						case VALUE:
							{
							alt4=2;
							}
							break;
						case ALIAS:
							{
							alt4=5;
							}
							break;
						case EXTERNAL:
							{
							alt4=7;
							}
							break;
						case INTEGER_WORD:
							{
							alt4=8;
							}
							break;
						default:
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 4, 12, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 4, 7, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 4, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case GOAL:
				{
				alt4=3;
				}
				break;
			case INCLUDE:
				{
				alt4=4;
				}
				break;
			case OBJECTIVE:
				{
				alt4=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// WreslTree.g:113:4: dvar
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_dvar_in_pattern399);
					dvar10=dvar();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dvar10.getTree());

					}
					break;
				case 2 :
					// WreslTree.g:113:11: svar
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_svar_in_pattern403);
					svar11=svar();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar11.getTree());

					}
					break;
				case 3 :
					// WreslTree.g:113:18: goal
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_goal_in_pattern407);
					goal12=goal();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goal12.getTree());

					}
					break;
				case 4 :
					// WreslTree.g:113:25: includeFile
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_includeFile_in_pattern411);
					includeFile13=includeFile();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, includeFile13.getTree());

					}
					break;
				case 5 :
					// WreslTree.g:113:39: alias
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_alias_in_pattern415);
					alias14=alias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, alias14.getTree());

					}
					break;
				case 6 :
					// WreslTree.g:113:47: weight_table
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_weight_table_in_pattern419);
					weight_table15=weight_table();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, weight_table15.getTree());

					}
					break;
				case 7 :
					// WreslTree.g:113:62: external
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_external_in_pattern423);
					external16=external();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, external16.getTree());

					}
					break;
				case 8 :
					// WreslTree.g:113:73: integer
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_integer_in_pattern427);
					integer17=integer();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, integer17.getTree());

					}
					break;
				case 9 :
					// WreslTree.g:114:4: svar_timeArray
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_svar_timeArray_in_pattern432);
					svar_timeArray18=svar_timeArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_timeArray18.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "pattern"


	public static class integer_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "integer"
	// WreslTree.g:117:1: integer : ( integer_std | integer_nonStd | integer_timeArray_std | integer_timeArray_nonStd );
	public final WreslTreeParser.integer_return integer() throws RecognitionException {
		WreslTreeParser.integer_return retval = new WreslTreeParser.integer_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope integer_std19 =null;
		ParserRuleReturnScope integer_nonStd20 =null;
		ParserRuleReturnScope integer_timeArray_std21 =null;
		ParserRuleReturnScope integer_timeArray_nonStd22 =null;


		try {
			// WreslTree.g:118:2: ( integer_std | integer_nonStd | integer_timeArray_std | integer_timeArray_nonStd )
			int alt5=4;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==DEFINE) ) {
				switch ( input.LA(2) ) {
				case 139:
					{
					int LA5_2 = input.LA(3);
					if ( (LA5_2==INTEGER) ) {
						int LA5_5 = input.LA(4);
						if ( (LA5_5==140) ) {
							int LA5_10 = input.LA(5);
							if ( (LA5_10==153) ) {
								int LA5_12 = input.LA(6);
								if ( (LA5_12==LOCAL) ) {
									int LA5_16 = input.LA(7);
									if ( (LA5_16==154) ) {
										int LA5_17 = input.LA(8);
										if ( (LA5_17==IDENT) ) {
											int LA5_13 = input.LA(9);
											if ( (LA5_13==157) ) {
												int LA5_18 = input.LA(10);
												if ( (LA5_18==INTEGER_WORD) ) {
													int LA5_19 = input.LA(11);
													if ( (LA5_19==STD) ) {
														alt5=3;
													}
													else if ( (LA5_19==LOWER||LA5_19==UPPER) ) {
														alt5=4;
													}

													else {
														if (state.backtracking>0) {state.failed=true; return retval;}
														int nvaeMark = input.mark();
														try {
															for (int nvaeConsume = 0; nvaeConsume < 11 - 1; nvaeConsume++) {
																input.consume();
															}
															NoViableAltException nvae =
																new NoViableAltException("", 5, 19, input);
															throw nvae;
														} finally {
															input.rewind(nvaeMark);
														}
													}

												}

												else {
													if (state.backtracking>0) {state.failed=true; return retval;}
													int nvaeMark = input.mark();
													try {
														for (int nvaeConsume = 0; nvaeConsume < 10 - 1; nvaeConsume++) {
															input.consume();
														}
														NoViableAltException nvae =
															new NoViableAltException("", 5, 18, input);
														throw nvae;
													} finally {
														input.rewind(nvaeMark);
													}
												}

											}

											else {
												if (state.backtracking>0) {state.failed=true; return retval;}
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 5, 13, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}

										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 5, 17, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 5, 16, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}
								else if ( (LA5_12==154) ) {
									int LA5_17 = input.LA(7);
									if ( (LA5_17==IDENT) ) {
										int LA5_13 = input.LA(8);
										if ( (LA5_13==157) ) {
											int LA5_18 = input.LA(9);
											if ( (LA5_18==INTEGER_WORD) ) {
												int LA5_19 = input.LA(10);
												if ( (LA5_19==STD) ) {
													alt5=3;
												}
												else if ( (LA5_19==LOWER||LA5_19==UPPER) ) {
													alt5=4;
												}

												else {
													if (state.backtracking>0) {state.failed=true; return retval;}
													int nvaeMark = input.mark();
													try {
														for (int nvaeConsume = 0; nvaeConsume < 10 - 1; nvaeConsume++) {
															input.consume();
														}
														NoViableAltException nvae =
															new NoViableAltException("", 5, 19, input);
														throw nvae;
													} finally {
														input.rewind(nvaeMark);
													}
												}

											}

											else {
												if (state.backtracking>0) {state.failed=true; return retval;}
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 5, 18, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}

										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 5, 13, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 5, 17, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 5, 12, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}
							else if ( (LA5_10==IDENT) ) {
								int LA5_13 = input.LA(6);
								if ( (LA5_13==157) ) {
									int LA5_18 = input.LA(7);
									if ( (LA5_18==INTEGER_WORD) ) {
										int LA5_19 = input.LA(8);
										if ( (LA5_19==STD) ) {
											alt5=3;
										}
										else if ( (LA5_19==LOWER||LA5_19==UPPER) ) {
											alt5=4;
										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 5, 19, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 5, 18, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 5, 13, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
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
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 5, 5, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA5_2==IDENT) ) {
						int LA5_6 = input.LA(4);
						if ( (LA5_6==140) ) {
							int LA5_10 = input.LA(5);
							if ( (LA5_10==153) ) {
								int LA5_12 = input.LA(6);
								if ( (LA5_12==LOCAL) ) {
									int LA5_16 = input.LA(7);
									if ( (LA5_16==154) ) {
										int LA5_17 = input.LA(8);
										if ( (LA5_17==IDENT) ) {
											int LA5_13 = input.LA(9);
											if ( (LA5_13==157) ) {
												int LA5_18 = input.LA(10);
												if ( (LA5_18==INTEGER_WORD) ) {
													int LA5_19 = input.LA(11);
													if ( (LA5_19==STD) ) {
														alt5=3;
													}
													else if ( (LA5_19==LOWER||LA5_19==UPPER) ) {
														alt5=4;
													}

													else {
														if (state.backtracking>0) {state.failed=true; return retval;}
														int nvaeMark = input.mark();
														try {
															for (int nvaeConsume = 0; nvaeConsume < 11 - 1; nvaeConsume++) {
																input.consume();
															}
															NoViableAltException nvae =
																new NoViableAltException("", 5, 19, input);
															throw nvae;
														} finally {
															input.rewind(nvaeMark);
														}
													}

												}

												else {
													if (state.backtracking>0) {state.failed=true; return retval;}
													int nvaeMark = input.mark();
													try {
														for (int nvaeConsume = 0; nvaeConsume < 10 - 1; nvaeConsume++) {
															input.consume();
														}
														NoViableAltException nvae =
															new NoViableAltException("", 5, 18, input);
														throw nvae;
													} finally {
														input.rewind(nvaeMark);
													}
												}

											}

											else {
												if (state.backtracking>0) {state.failed=true; return retval;}
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 5, 13, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}

										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 5, 17, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 5, 16, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}
								else if ( (LA5_12==154) ) {
									int LA5_17 = input.LA(7);
									if ( (LA5_17==IDENT) ) {
										int LA5_13 = input.LA(8);
										if ( (LA5_13==157) ) {
											int LA5_18 = input.LA(9);
											if ( (LA5_18==INTEGER_WORD) ) {
												int LA5_19 = input.LA(10);
												if ( (LA5_19==STD) ) {
													alt5=3;
												}
												else if ( (LA5_19==LOWER||LA5_19==UPPER) ) {
													alt5=4;
												}

												else {
													if (state.backtracking>0) {state.failed=true; return retval;}
													int nvaeMark = input.mark();
													try {
														for (int nvaeConsume = 0; nvaeConsume < 10 - 1; nvaeConsume++) {
															input.consume();
														}
														NoViableAltException nvae =
															new NoViableAltException("", 5, 19, input);
														throw nvae;
													} finally {
														input.rewind(nvaeMark);
													}
												}

											}

											else {
												if (state.backtracking>0) {state.failed=true; return retval;}
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 5, 18, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}

										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 5, 13, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 5, 17, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 5, 12, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}
							else if ( (LA5_10==IDENT) ) {
								int LA5_13 = input.LA(6);
								if ( (LA5_13==157) ) {
									int LA5_18 = input.LA(7);
									if ( (LA5_18==INTEGER_WORD) ) {
										int LA5_19 = input.LA(8);
										if ( (LA5_19==STD) ) {
											alt5=3;
										}
										else if ( (LA5_19==LOWER||LA5_19==UPPER) ) {
											alt5=4;
										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 5, 19, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 5, 18, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 5, 13, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
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
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 5, 6, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 5, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case 153:
					{
					int LA5_3 = input.LA(3);
					if ( (LA5_3==LOCAL) ) {
						int LA5_7 = input.LA(4);
						if ( (LA5_7==154) ) {
							int LA5_8 = input.LA(5);
							if ( (LA5_8==IDENT) ) {
								int LA5_4 = input.LA(6);
								if ( (LA5_4==157) ) {
									int LA5_9 = input.LA(7);
									if ( (LA5_9==INTEGER_WORD) ) {
										int LA5_11 = input.LA(8);
										if ( (LA5_11==STD) ) {
											alt5=1;
										}
										else if ( (LA5_11==LOWER||LA5_11==UPPER) ) {
											alt5=2;
										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
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
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 5, 9, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 5, 4, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 5, 8, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 5, 7, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA5_3==154) ) {
						int LA5_8 = input.LA(4);
						if ( (LA5_8==IDENT) ) {
							int LA5_4 = input.LA(5);
							if ( (LA5_4==157) ) {
								int LA5_9 = input.LA(6);
								if ( (LA5_9==INTEGER_WORD) ) {
									int LA5_11 = input.LA(7);
									if ( (LA5_11==STD) ) {
										alt5=1;
									}
									else if ( (LA5_11==LOWER||LA5_11==UPPER) ) {
										alt5=2;
									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
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
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 5, 9, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 5, 4, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 5, 8, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 5, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case IDENT:
					{
					int LA5_4 = input.LA(3);
					if ( (LA5_4==157) ) {
						int LA5_9 = input.LA(4);
						if ( (LA5_9==INTEGER_WORD) ) {
							int LA5_11 = input.LA(5);
							if ( (LA5_11==STD) ) {
								alt5=1;
							}
							else if ( (LA5_11==LOWER||LA5_11==UPPER) ) {
								alt5=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
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
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 5, 9, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 5, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
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

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// WreslTree.g:118:4: integer_std
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_integer_std_in_integer443);
					integer_std19=integer_std();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, integer_std19.getTree());

					}
					break;
				case 2 :
					// WreslTree.g:118:18: integer_nonStd
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_integer_nonStd_in_integer447);
					integer_nonStd20=integer_nonStd();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, integer_nonStd20.getTree());

					}
					break;
				case 3 :
					// WreslTree.g:118:35: integer_timeArray_std
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_integer_timeArray_std_in_integer451);
					integer_timeArray_std21=integer_timeArray_std();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, integer_timeArray_std21.getTree());

					}
					break;
				case 4 :
					// WreslTree.g:118:59: integer_timeArray_nonStd
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_integer_timeArray_nonStd_in_integer455);
					integer_timeArray_nonStd22=integer_timeArray_nonStd();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, integer_timeArray_nonStd22.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "integer"


	public static class integer_std_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "integer_std"
	// WreslTree.g:122:1: integer_std : DEFINE ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' INTEGER_WORD STD KIND k= STRING UNITS u= STRING '}' -> ^( Dvar_integer Scope[$sc.text] $i Kind[$k.text] Units[$u.text] ) ;
	public final WreslTreeParser.integer_std_return integer_std() throws RecognitionException {
		WreslTreeParser.integer_std_return retval = new WreslTreeParser.integer_std_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token i=null;
		Token k=null;
		Token u=null;
		Token DEFINE23=null;
		Token char_literal24=null;
		Token char_literal25=null;
		Token char_literal26=null;
		Token INTEGER_WORD27=null;
		Token STD28=null;
		Token KIND29=null;
		Token UNITS30=null;
		Token char_literal31=null;

		CommonTree sc_tree=null;
		CommonTree i_tree=null;
		CommonTree k_tree=null;
		CommonTree u_tree=null;
		CommonTree DEFINE23_tree=null;
		CommonTree char_literal24_tree=null;
		CommonTree char_literal25_tree=null;
		CommonTree char_literal26_tree=null;
		CommonTree INTEGER_WORD27_tree=null;
		CommonTree STD28_tree=null;
		CommonTree KIND29_tree=null;
		CommonTree UNITS30_tree=null;
		CommonTree char_literal31_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_STD=new RewriteRuleTokenStream(adaptor,"token STD");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_KIND=new RewriteRuleTokenStream(adaptor,"token KIND");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_INTEGER_WORD=new RewriteRuleTokenStream(adaptor,"token INTEGER_WORD");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleTokenStream stream_DEFINE=new RewriteRuleTokenStream(adaptor,"token DEFINE");
		RewriteRuleTokenStream stream_UNITS=new RewriteRuleTokenStream(adaptor,"token UNITS");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");

		try {
			// WreslTree.g:123:2: ( DEFINE ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' INTEGER_WORD STD KIND k= STRING UNITS u= STRING '}' -> ^( Dvar_integer Scope[$sc.text] $i Kind[$k.text] Units[$u.text] ) )
			// WreslTree.g:123:4: DEFINE ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' INTEGER_WORD STD KIND k= STRING UNITS u= STRING '}'
			{
			DEFINE23=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_integer_std468); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_DEFINE.add(DEFINE23);

			// WreslTree.g:123:11: ( '[' (sc= LOCAL )? ']' )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==153) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// WreslTree.g:123:13: '[' (sc= LOCAL )? ']'
					{
					char_literal24=(Token)match(input,153,FOLLOW_153_in_integer_std472); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal24);

					// WreslTree.g:123:19: (sc= LOCAL )?
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==LOCAL) ) {
						alt6=1;
					}
					switch (alt6) {
						case 1 :
							// WreslTree.g:123:19: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_integer_std476); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal25=(Token)match(input,154,FOLLOW_154_in_integer_std479); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal25);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_integer_std486); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal26=(Token)match(input,157,FOLLOW_157_in_integer_std488); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal26);

			INTEGER_WORD27=(Token)match(input,INTEGER_WORD,FOLLOW_INTEGER_WORD_in_integer_std490); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_INTEGER_WORD.add(INTEGER_WORD27);

			STD28=(Token)match(input,STD,FOLLOW_STD_in_integer_std492); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STD.add(STD28);

			KIND29=(Token)match(input,KIND,FOLLOW_KIND_in_integer_std494); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KIND.add(KIND29);

			k=(Token)match(input,STRING,FOLLOW_STRING_in_integer_std498); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(k);

			UNITS30=(Token)match(input,UNITS,FOLLOW_UNITS_in_integer_std500); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_UNITS.add(UNITS30);

			u=(Token)match(input,STRING,FOLLOW_STRING_in_integer_std504); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(u);

			char_literal31=(Token)match(input,158,FOLLOW_158_in_integer_std506); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal31);

			// AST REWRITE
			// elements: i
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 124:3: -> ^( Dvar_integer Scope[$sc.text] $i Kind[$k.text] Units[$u.text] )
			{
				// WreslTree.g:124:7: ^( Dvar_integer Scope[$sc.text] $i Kind[$k.text] Units[$u.text] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Dvar_integer, "Dvar_integer"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Kind, (k!=null?k.getText():null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Units, (u!=null?u.getText():null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "integer_std"


	public static class integer_nonStd_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "integer_nonStd"
	// WreslTree.g:127:1: integer_nonStd : DEFINE ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' INTEGER_WORD lower_and_or_upper KIND k= STRING UNITS u= STRING '}' -> ^( Dvar_integer Scope[$sc.text] $i lower_and_or_upper Kind[$k.text] Units[$u.text] ) ;
	public final WreslTreeParser.integer_nonStd_return integer_nonStd() throws RecognitionException {
		WreslTreeParser.integer_nonStd_return retval = new WreslTreeParser.integer_nonStd_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token i=null;
		Token k=null;
		Token u=null;
		Token DEFINE32=null;
		Token char_literal33=null;
		Token char_literal34=null;
		Token char_literal35=null;
		Token INTEGER_WORD36=null;
		Token KIND38=null;
		Token UNITS39=null;
		Token char_literal40=null;
		ParserRuleReturnScope lower_and_or_upper37 =null;

		CommonTree sc_tree=null;
		CommonTree i_tree=null;
		CommonTree k_tree=null;
		CommonTree u_tree=null;
		CommonTree DEFINE32_tree=null;
		CommonTree char_literal33_tree=null;
		CommonTree char_literal34_tree=null;
		CommonTree char_literal35_tree=null;
		CommonTree INTEGER_WORD36_tree=null;
		CommonTree KIND38_tree=null;
		CommonTree UNITS39_tree=null;
		CommonTree char_literal40_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_KIND=new RewriteRuleTokenStream(adaptor,"token KIND");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_INTEGER_WORD=new RewriteRuleTokenStream(adaptor,"token INTEGER_WORD");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleTokenStream stream_DEFINE=new RewriteRuleTokenStream(adaptor,"token DEFINE");
		RewriteRuleTokenStream stream_UNITS=new RewriteRuleTokenStream(adaptor,"token UNITS");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_lower_and_or_upper=new RewriteRuleSubtreeStream(adaptor,"rule lower_and_or_upper");

		try {
			// WreslTree.g:128:2: ( DEFINE ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' INTEGER_WORD lower_and_or_upper KIND k= STRING UNITS u= STRING '}' -> ^( Dvar_integer Scope[$sc.text] $i lower_and_or_upper Kind[$k.text] Units[$u.text] ) )
			// WreslTree.g:128:4: DEFINE ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' INTEGER_WORD lower_and_or_upper KIND k= STRING UNITS u= STRING '}'
			{
			DEFINE32=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_integer_nonStd540); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_DEFINE.add(DEFINE32);

			// WreslTree.g:128:11: ( '[' (sc= LOCAL )? ']' )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==153) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// WreslTree.g:128:13: '[' (sc= LOCAL )? ']'
					{
					char_literal33=(Token)match(input,153,FOLLOW_153_in_integer_nonStd544); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal33);

					// WreslTree.g:128:19: (sc= LOCAL )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==LOCAL) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// WreslTree.g:128:19: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_integer_nonStd548); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal34=(Token)match(input,154,FOLLOW_154_in_integer_nonStd551); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal34);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_integer_nonStd558); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal35=(Token)match(input,157,FOLLOW_157_in_integer_nonStd560); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal35);

			INTEGER_WORD36=(Token)match(input,INTEGER_WORD,FOLLOW_INTEGER_WORD_in_integer_nonStd562); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_INTEGER_WORD.add(INTEGER_WORD36);

			pushFollow(FOLLOW_lower_and_or_upper_in_integer_nonStd564);
			lower_and_or_upper37=lower_and_or_upper();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_lower_and_or_upper.add(lower_and_or_upper37.getTree());
			KIND38=(Token)match(input,KIND,FOLLOW_KIND_in_integer_nonStd566); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KIND.add(KIND38);

			k=(Token)match(input,STRING,FOLLOW_STRING_in_integer_nonStd570); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(k);

			UNITS39=(Token)match(input,UNITS,FOLLOW_UNITS_in_integer_nonStd572); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_UNITS.add(UNITS39);

			u=(Token)match(input,STRING,FOLLOW_STRING_in_integer_nonStd576); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(u);

			char_literal40=(Token)match(input,158,FOLLOW_158_in_integer_nonStd578); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal40);

			// AST REWRITE
			// elements: lower_and_or_upper, i
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 129:3: -> ^( Dvar_integer Scope[$sc.text] $i lower_and_or_upper Kind[$k.text] Units[$u.text] )
			{
				// WreslTree.g:129:7: ^( Dvar_integer Scope[$sc.text] $i lower_and_or_upper Kind[$k.text] Units[$u.text] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Dvar_integer, "Dvar_integer"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_lower_and_or_upper.nextTree());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Kind, (k!=null?k.getText():null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Units, (u!=null?u.getText():null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "integer_nonStd"


	public static class integer_timeArray_std_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "integer_timeArray_std"
	// WreslTree.g:132:1: integer_timeArray_std : DEFINE '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' INTEGER_WORD STD KIND k= STRING UNITS u= STRING '}' -> ^( Dvar_integer TimeArraySize[$ta.text] Scope[$sc.text] $i Kind[$k.text] Units[$u.text] ) ;
	public final WreslTreeParser.integer_timeArray_std_return integer_timeArray_std() throws RecognitionException {
		WreslTreeParser.integer_timeArray_std_return retval = new WreslTreeParser.integer_timeArray_std_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token i=null;
		Token k=null;
		Token u=null;
		Token DEFINE41=null;
		Token char_literal42=null;
		Token char_literal43=null;
		Token char_literal44=null;
		Token char_literal45=null;
		Token char_literal46=null;
		Token INTEGER_WORD47=null;
		Token STD48=null;
		Token KIND49=null;
		Token UNITS50=null;
		Token char_literal51=null;
		ParserRuleReturnScope ta =null;

		CommonTree sc_tree=null;
		CommonTree i_tree=null;
		CommonTree k_tree=null;
		CommonTree u_tree=null;
		CommonTree DEFINE41_tree=null;
		CommonTree char_literal42_tree=null;
		CommonTree char_literal43_tree=null;
		CommonTree char_literal44_tree=null;
		CommonTree char_literal45_tree=null;
		CommonTree char_literal46_tree=null;
		CommonTree INTEGER_WORD47_tree=null;
		CommonTree STD48_tree=null;
		CommonTree KIND49_tree=null;
		CommonTree UNITS50_tree=null;
		CommonTree char_literal51_tree=null;
		RewriteRuleTokenStream stream_STD=new RewriteRuleTokenStream(adaptor,"token STD");
		RewriteRuleTokenStream stream_140=new RewriteRuleTokenStream(adaptor,"token 140");
		RewriteRuleTokenStream stream_DEFINE=new RewriteRuleTokenStream(adaptor,"token DEFINE");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
		RewriteRuleTokenStream stream_KIND=new RewriteRuleTokenStream(adaptor,"token KIND");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_INTEGER_WORD=new RewriteRuleTokenStream(adaptor,"token INTEGER_WORD");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleTokenStream stream_UNITS=new RewriteRuleTokenStream(adaptor,"token UNITS");
		RewriteRuleSubtreeStream stream_timeArraySize=new RewriteRuleSubtreeStream(adaptor,"rule timeArraySize");

		try {
			// WreslTree.g:133:3: ( DEFINE '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' INTEGER_WORD STD KIND k= STRING UNITS u= STRING '}' -> ^( Dvar_integer TimeArraySize[$ta.text] Scope[$sc.text] $i Kind[$k.text] Units[$u.text] ) )
			// WreslTree.g:133:5: DEFINE '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' INTEGER_WORD STD KIND k= STRING UNITS u= STRING '}'
			{
			DEFINE41=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_integer_timeArray_std616); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_DEFINE.add(DEFINE41);

			char_literal42=(Token)match(input,139,FOLLOW_139_in_integer_timeArray_std618); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_139.add(char_literal42);

			pushFollow(FOLLOW_timeArraySize_in_integer_timeArray_std622);
			ta=timeArraySize();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_timeArraySize.add(ta.getTree());
			char_literal43=(Token)match(input,140,FOLLOW_140_in_integer_timeArray_std624); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_140.add(char_literal43);

			// WreslTree.g:133:37: ( '[' (sc= LOCAL )? ']' )?
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==153) ) {
				alt11=1;
			}
			switch (alt11) {
				case 1 :
					// WreslTree.g:133:39: '[' (sc= LOCAL )? ']'
					{
					char_literal44=(Token)match(input,153,FOLLOW_153_in_integer_timeArray_std628); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal44);

					// WreslTree.g:133:45: (sc= LOCAL )?
					int alt10=2;
					int LA10_0 = input.LA(1);
					if ( (LA10_0==LOCAL) ) {
						alt10=1;
					}
					switch (alt10) {
						case 1 :
							// WreslTree.g:133:45: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_integer_timeArray_std632); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal45=(Token)match(input,154,FOLLOW_154_in_integer_timeArray_std635); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal45);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_integer_timeArray_std642); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal46=(Token)match(input,157,FOLLOW_157_in_integer_timeArray_std644); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal46);

			INTEGER_WORD47=(Token)match(input,INTEGER_WORD,FOLLOW_INTEGER_WORD_in_integer_timeArray_std646); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_INTEGER_WORD.add(INTEGER_WORD47);

			STD48=(Token)match(input,STD,FOLLOW_STD_in_integer_timeArray_std648); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STD.add(STD48);

			KIND49=(Token)match(input,KIND,FOLLOW_KIND_in_integer_timeArray_std650); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KIND.add(KIND49);

			k=(Token)match(input,STRING,FOLLOW_STRING_in_integer_timeArray_std654); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(k);

			UNITS50=(Token)match(input,UNITS,FOLLOW_UNITS_in_integer_timeArray_std656); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_UNITS.add(UNITS50);

			u=(Token)match(input,STRING,FOLLOW_STRING_in_integer_timeArray_std660); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(u);

			char_literal51=(Token)match(input,158,FOLLOW_158_in_integer_timeArray_std662); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal51);

			// AST REWRITE
			// elements: i
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 134:5: -> ^( Dvar_integer TimeArraySize[$ta.text] Scope[$sc.text] $i Kind[$k.text] Units[$u.text] )
			{
				// WreslTree.g:134:9: ^( Dvar_integer TimeArraySize[$ta.text] Scope[$sc.text] $i Kind[$k.text] Units[$u.text] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Dvar_integer, "Dvar_integer"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TimeArraySize, (ta!=null?input.toString(ta.start,ta.stop):null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Kind, (k!=null?k.getText():null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Units, (u!=null?u.getText():null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "integer_timeArray_std"


	public static class integer_timeArray_nonStd_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "integer_timeArray_nonStd"
	// WreslTree.g:137:1: integer_timeArray_nonStd : DEFINE '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' INTEGER_WORD lower_and_or_upper KIND k= STRING UNITS u= STRING '}' -> ^( Dvar_integer TimeArraySize[$ta.text] Scope[$sc.text] $i lower_and_or_upper Kind[$k.text] Units[$u.text] ) ;
	public final WreslTreeParser.integer_timeArray_nonStd_return integer_timeArray_nonStd() throws RecognitionException {
		WreslTreeParser.integer_timeArray_nonStd_return retval = new WreslTreeParser.integer_timeArray_nonStd_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token i=null;
		Token k=null;
		Token u=null;
		Token DEFINE52=null;
		Token char_literal53=null;
		Token char_literal54=null;
		Token char_literal55=null;
		Token char_literal56=null;
		Token char_literal57=null;
		Token INTEGER_WORD58=null;
		Token KIND60=null;
		Token UNITS61=null;
		Token char_literal62=null;
		ParserRuleReturnScope ta =null;
		ParserRuleReturnScope lower_and_or_upper59 =null;

		CommonTree sc_tree=null;
		CommonTree i_tree=null;
		CommonTree k_tree=null;
		CommonTree u_tree=null;
		CommonTree DEFINE52_tree=null;
		CommonTree char_literal53_tree=null;
		CommonTree char_literal54_tree=null;
		CommonTree char_literal55_tree=null;
		CommonTree char_literal56_tree=null;
		CommonTree char_literal57_tree=null;
		CommonTree INTEGER_WORD58_tree=null;
		CommonTree KIND60_tree=null;
		CommonTree UNITS61_tree=null;
		CommonTree char_literal62_tree=null;
		RewriteRuleTokenStream stream_140=new RewriteRuleTokenStream(adaptor,"token 140");
		RewriteRuleTokenStream stream_DEFINE=new RewriteRuleTokenStream(adaptor,"token DEFINE");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
		RewriteRuleTokenStream stream_KIND=new RewriteRuleTokenStream(adaptor,"token KIND");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_INTEGER_WORD=new RewriteRuleTokenStream(adaptor,"token INTEGER_WORD");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleTokenStream stream_UNITS=new RewriteRuleTokenStream(adaptor,"token UNITS");
		RewriteRuleSubtreeStream stream_timeArraySize=new RewriteRuleSubtreeStream(adaptor,"rule timeArraySize");
		RewriteRuleSubtreeStream stream_lower_and_or_upper=new RewriteRuleSubtreeStream(adaptor,"rule lower_and_or_upper");

		try {
			// WreslTree.g:138:3: ( DEFINE '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' INTEGER_WORD lower_and_or_upper KIND k= STRING UNITS u= STRING '}' -> ^( Dvar_integer TimeArraySize[$ta.text] Scope[$sc.text] $i lower_and_or_upper Kind[$k.text] Units[$u.text] ) )
			// WreslTree.g:138:5: DEFINE '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' INTEGER_WORD lower_and_or_upper KIND k= STRING UNITS u= STRING '}'
			{
			DEFINE52=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_integer_timeArray_nonStd702); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_DEFINE.add(DEFINE52);

			char_literal53=(Token)match(input,139,FOLLOW_139_in_integer_timeArray_nonStd704); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_139.add(char_literal53);

			pushFollow(FOLLOW_timeArraySize_in_integer_timeArray_nonStd708);
			ta=timeArraySize();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_timeArraySize.add(ta.getTree());
			char_literal54=(Token)match(input,140,FOLLOW_140_in_integer_timeArray_nonStd710); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_140.add(char_literal54);

			// WreslTree.g:138:37: ( '[' (sc= LOCAL )? ']' )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==153) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// WreslTree.g:138:39: '[' (sc= LOCAL )? ']'
					{
					char_literal55=(Token)match(input,153,FOLLOW_153_in_integer_timeArray_nonStd714); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal55);

					// WreslTree.g:138:45: (sc= LOCAL )?
					int alt12=2;
					int LA12_0 = input.LA(1);
					if ( (LA12_0==LOCAL) ) {
						alt12=1;
					}
					switch (alt12) {
						case 1 :
							// WreslTree.g:138:45: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_integer_timeArray_nonStd718); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal56=(Token)match(input,154,FOLLOW_154_in_integer_timeArray_nonStd721); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal56);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_integer_timeArray_nonStd728); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal57=(Token)match(input,157,FOLLOW_157_in_integer_timeArray_nonStd730); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal57);

			INTEGER_WORD58=(Token)match(input,INTEGER_WORD,FOLLOW_INTEGER_WORD_in_integer_timeArray_nonStd732); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_INTEGER_WORD.add(INTEGER_WORD58);

			pushFollow(FOLLOW_lower_and_or_upper_in_integer_timeArray_nonStd734);
			lower_and_or_upper59=lower_and_or_upper();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_lower_and_or_upper.add(lower_and_or_upper59.getTree());
			KIND60=(Token)match(input,KIND,FOLLOW_KIND_in_integer_timeArray_nonStd736); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KIND.add(KIND60);

			k=(Token)match(input,STRING,FOLLOW_STRING_in_integer_timeArray_nonStd740); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(k);

			UNITS61=(Token)match(input,UNITS,FOLLOW_UNITS_in_integer_timeArray_nonStd742); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_UNITS.add(UNITS61);

			u=(Token)match(input,STRING,FOLLOW_STRING_in_integer_timeArray_nonStd746); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(u);

			char_literal62=(Token)match(input,158,FOLLOW_158_in_integer_timeArray_nonStd748); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal62);

			// AST REWRITE
			// elements: i, lower_and_or_upper
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 139:5: -> ^( Dvar_integer TimeArraySize[$ta.text] Scope[$sc.text] $i lower_and_or_upper Kind[$k.text] Units[$u.text] )
			{
				// WreslTree.g:139:9: ^( Dvar_integer TimeArraySize[$ta.text] Scope[$sc.text] $i lower_and_or_upper Kind[$k.text] Units[$u.text] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Dvar_integer, "Dvar_integer"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TimeArraySize, (ta!=null?input.toString(ta.start,ta.stop):null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_lower_and_or_upper.nextTree());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Kind, (k!=null?k.getText():null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Units, (u!=null?u.getText():null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "integer_timeArray_nonStd"


	public static class external_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "external"
	// WreslTree.g:142:1: external : DEFINE ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' EXTERNAL (e= DLL |e= F90 ) '}' -> ^( External Scope[$sc.text] $i Expression[$e.text] ) ;
	public final WreslTreeParser.external_return external() throws RecognitionException {
		WreslTreeParser.external_return retval = new WreslTreeParser.external_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token i=null;
		Token e=null;
		Token DEFINE63=null;
		Token char_literal64=null;
		Token char_literal65=null;
		Token char_literal66=null;
		Token EXTERNAL67=null;
		Token char_literal68=null;

		CommonTree sc_tree=null;
		CommonTree i_tree=null;
		CommonTree e_tree=null;
		CommonTree DEFINE63_tree=null;
		CommonTree char_literal64_tree=null;
		CommonTree char_literal65_tree=null;
		CommonTree char_literal66_tree=null;
		CommonTree EXTERNAL67_tree=null;
		CommonTree char_literal68_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_EXTERNAL=new RewriteRuleTokenStream(adaptor,"token EXTERNAL");
		RewriteRuleTokenStream stream_DLL=new RewriteRuleTokenStream(adaptor,"token DLL");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_F90=new RewriteRuleTokenStream(adaptor,"token F90");
		RewriteRuleTokenStream stream_DEFINE=new RewriteRuleTokenStream(adaptor,"token DEFINE");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");

		try {
			// WreslTree.g:142:10: ( DEFINE ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' EXTERNAL (e= DLL |e= F90 ) '}' -> ^( External Scope[$sc.text] $i Expression[$e.text] ) )
			// WreslTree.g:142:12: DEFINE ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' EXTERNAL (e= DLL |e= F90 ) '}'
			{
			DEFINE63=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_external788); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_DEFINE.add(DEFINE63);

			// WreslTree.g:142:19: ( '[' (sc= LOCAL )? ']' )?
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==153) ) {
				alt15=1;
			}
			switch (alt15) {
				case 1 :
					// WreslTree.g:142:21: '[' (sc= LOCAL )? ']'
					{
					char_literal64=(Token)match(input,153,FOLLOW_153_in_external792); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal64);

					// WreslTree.g:142:27: (sc= LOCAL )?
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==LOCAL) ) {
						alt14=1;
					}
					switch (alt14) {
						case 1 :
							// WreslTree.g:142:27: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_external796); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal65=(Token)match(input,154,FOLLOW_154_in_external799); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal65);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_external806); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal66=(Token)match(input,157,FOLLOW_157_in_external808); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal66);

			EXTERNAL67=(Token)match(input,EXTERNAL,FOLLOW_EXTERNAL_in_external810); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_EXTERNAL.add(EXTERNAL67);

			// WreslTree.g:142:63: (e= DLL |e= F90 )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==DLL) ) {
				alt16=1;
			}
			else if ( (LA16_0==F90) ) {
				alt16=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// WreslTree.g:142:64: e= DLL
					{
					e=(Token)match(input,DLL,FOLLOW_DLL_in_external815); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_DLL.add(e);

					}
					break;
				case 2 :
					// WreslTree.g:142:70: e= F90
					{
					e=(Token)match(input,F90,FOLLOW_F90_in_external819); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_F90.add(e);

					}
					break;

			}

			char_literal68=(Token)match(input,158,FOLLOW_158_in_external822); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal68);

			// AST REWRITE
			// elements: i
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 143:4: -> ^( External Scope[$sc.text] $i Expression[$e.text] )
			{
				// WreslTree.g:143:4: ^( External Scope[$sc.text] $i Expression[$e.text] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(External, "External"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Expression, (e!=null?e.getText():null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "external"


	public static class weight_table_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "weight_table"
	// WreslTree.g:147:1: weight_table : OBJECTIVE ( '[' (sc= LOCAL )? ']' )? IDENT '=' '{' (w+= weightItem )+ '}' -> ^( Weight_table Scope[$sc.text] ( $w)+ ) ;
	public final WreslTreeParser.weight_table_return weight_table() throws RecognitionException {
		WreslTreeParser.weight_table_return retval = new WreslTreeParser.weight_table_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token OBJECTIVE69=null;
		Token char_literal70=null;
		Token char_literal71=null;
		Token IDENT72=null;
		Token char_literal73=null;
		Token char_literal74=null;
		Token char_literal75=null;
		List<Object> list_w=null;
		RuleReturnScope w = null;
		CommonTree sc_tree=null;
		CommonTree OBJECTIVE69_tree=null;
		CommonTree char_literal70_tree=null;
		CommonTree char_literal71_tree=null;
		CommonTree IDENT72_tree=null;
		CommonTree char_literal73_tree=null;
		CommonTree char_literal74_tree=null;
		CommonTree char_literal75_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_149=new RewriteRuleTokenStream(adaptor,"token 149");
		RewriteRuleTokenStream stream_OBJECTIVE=new RewriteRuleTokenStream(adaptor,"token OBJECTIVE");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_weightItem=new RewriteRuleSubtreeStream(adaptor,"rule weightItem");

		try {
			// WreslTree.g:148:2: ( OBJECTIVE ( '[' (sc= LOCAL )? ']' )? IDENT '=' '{' (w+= weightItem )+ '}' -> ^( Weight_table Scope[$sc.text] ( $w)+ ) )
			// WreslTree.g:148:4: OBJECTIVE ( '[' (sc= LOCAL )? ']' )? IDENT '=' '{' (w+= weightItem )+ '}'
			{
			OBJECTIVE69=(Token)match(input,OBJECTIVE,FOLLOW_OBJECTIVE_in_weight_table852); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_OBJECTIVE.add(OBJECTIVE69);

			// WreslTree.g:148:14: ( '[' (sc= LOCAL )? ']' )?
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==153) ) {
				alt18=1;
			}
			switch (alt18) {
				case 1 :
					// WreslTree.g:148:16: '[' (sc= LOCAL )? ']'
					{
					char_literal70=(Token)match(input,153,FOLLOW_153_in_weight_table856); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal70);

					// WreslTree.g:148:22: (sc= LOCAL )?
					int alt17=2;
					int LA17_0 = input.LA(1);
					if ( (LA17_0==LOCAL) ) {
						alt17=1;
					}
					switch (alt17) {
						case 1 :
							// WreslTree.g:148:22: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_weight_table860); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal71=(Token)match(input,154,FOLLOW_154_in_weight_table863); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal71);

					}
					break;

			}

			IDENT72=(Token)match(input,IDENT,FOLLOW_IDENT_in_weight_table868); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(IDENT72);

			char_literal73=(Token)match(input,149,FOLLOW_149_in_weight_table870); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_149.add(char_literal73);

			char_literal74=(Token)match(input,157,FOLLOW_157_in_weight_table872); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal74);

			// WreslTree.g:148:53: (w+= weightItem )+
			int cnt19=0;
			loop19:
			while (true) {
				int alt19=2;
				int LA19_0 = input.LA(1);
				if ( (LA19_0==153) ) {
					alt19=1;
				}

				switch (alt19) {
				case 1 :
					// WreslTree.g:148:53: w+= weightItem
					{
					pushFollow(FOLLOW_weightItem_in_weight_table877);
					w=weightItem();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_weightItem.add(w.getTree());
					if (list_w==null) list_w=new ArrayList<Object>();
					list_w.add(w.getTree());
					}
					break;

				default :
					if ( cnt19 >= 1 ) break loop19;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(19, input);
					throw eee;
				}
				cnt19++;
			}

			char_literal75=(Token)match(input,158,FOLLOW_158_in_weight_table880); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal75);

			// AST REWRITE
			// elements: w
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: w
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);
			RewriteRuleSubtreeStream stream_w=new RewriteRuleSubtreeStream(adaptor,"token w",list_w);
			root_0 = (CommonTree)adaptor.nil();
			// 149:2: -> ^( Weight_table Scope[$sc.text] ( $w)+ )
			{
				// WreslTree.g:149:5: ^( Weight_table Scope[$sc.text] ( $w)+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Weight_table, "Weight_table"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				if ( !(stream_w.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_w.hasNext() ) {
					adaptor.addChild(root_1, stream_w.nextTree());
				}
				stream_w.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "weight_table"


	public static class weightItem_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "weightItem"
	// WreslTree.g:152:1: weightItem : '[' IDENT ( '(' ta= timeArraySize ')' )? ',' e= expression ']' ( ',' )? -> ^( IDENT TimeArraySize[r] Expression[$e.text] ) ;
	public final WreslTreeParser.weightItem_return weightItem() throws RecognitionException {
		WreslTreeParser.weightItem_return retval = new WreslTreeParser.weightItem_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal76=null;
		Token IDENT77=null;
		Token char_literal78=null;
		Token char_literal79=null;
		Token char_literal80=null;
		Token char_literal81=null;
		Token char_literal82=null;
		ParserRuleReturnScope ta =null;
		ParserRuleReturnScope e =null;

		CommonTree char_literal76_tree=null;
		CommonTree IDENT77_tree=null;
		CommonTree char_literal78_tree=null;
		CommonTree char_literal79_tree=null;
		CommonTree char_literal80_tree=null;
		CommonTree char_literal81_tree=null;
		CommonTree char_literal82_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_143=new RewriteRuleTokenStream(adaptor,"token 143");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
		RewriteRuleTokenStream stream_140=new RewriteRuleTokenStream(adaptor,"token 140");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_timeArraySize=new RewriteRuleSubtreeStream(adaptor,"rule timeArraySize");

		String r="0";
		try {
			// WreslTree.g:154:2: ( '[' IDENT ( '(' ta= timeArraySize ')' )? ',' e= expression ']' ( ',' )? -> ^( IDENT TimeArraySize[r] Expression[$e.text] ) )
			// WreslTree.g:154:4: '[' IDENT ( '(' ta= timeArraySize ')' )? ',' e= expression ']' ( ',' )?
			{
			char_literal76=(Token)match(input,153,FOLLOW_153_in_weightItem913); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_153.add(char_literal76);

			IDENT77=(Token)match(input,IDENT,FOLLOW_IDENT_in_weightItem916); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(IDENT77);

			// WreslTree.g:154:15: ( '(' ta= timeArraySize ')' )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==139) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// WreslTree.g:154:16: '(' ta= timeArraySize ')'
					{
					char_literal78=(Token)match(input,139,FOLLOW_139_in_weightItem919); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_139.add(char_literal78);

					pushFollow(FOLLOW_timeArraySize_in_weightItem923);
					ta=timeArraySize();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_timeArraySize.add(ta.getTree());
					char_literal79=(Token)match(input,140,FOLLOW_140_in_weightItem925); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_140.add(char_literal79);

					if ( state.backtracking==0 ) { r = (ta!=null?input.toString(ta.start,ta.stop):null);}
					}
					break;

			}

			char_literal80=(Token)match(input,143,FOLLOW_143_in_weightItem932); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_143.add(char_literal80);

			pushFollow(FOLLOW_expression_in_weightItem936);
			e=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expression.add(e.getTree());
			char_literal81=(Token)match(input,154,FOLLOW_154_in_weightItem938); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_154.add(char_literal81);

			// WreslTree.g:154:82: ( ',' )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==143) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// WreslTree.g:154:83: ','
					{
					char_literal82=(Token)match(input,143,FOLLOW_143_in_weightItem941); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_143.add(char_literal82);

					}
					break;

			}

			// AST REWRITE
			// elements: IDENT
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 155:5: -> ^( IDENT TimeArraySize[r] Expression[$e.text] )
			{
				// WreslTree.g:155:9: ^( IDENT TimeArraySize[r] Expression[$e.text] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_IDENT.nextNode(), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TimeArraySize, r));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Expression, (e!=null?((WreslTreeParser.expression_return)e).text:null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "weightItem"


	public static class model_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "model"
	// WreslTree.g:158:1: model : MODEL i= IDENT '{' ( pattern )+ '}' -> {model_in_sequence.contains(id)}? ^( Model IDENT[id] ( pattern )+ ) ->;
	public final WreslTreeParser.model_return model() throws RecognitionException {
		WreslTreeParser.model_return retval = new WreslTreeParser.model_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token MODEL83=null;
		Token char_literal84=null;
		Token char_literal86=null;
		ParserRuleReturnScope pattern85 =null;

		CommonTree i_tree=null;
		CommonTree MODEL83_tree=null;
		CommonTree char_literal84_tree=null;
		CommonTree char_literal86_tree=null;
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_MODEL=new RewriteRuleTokenStream(adaptor,"token MODEL");
		RewriteRuleSubtreeStream stream_pattern=new RewriteRuleSubtreeStream(adaptor,"rule pattern");

		 String id = null;
		try {
			// WreslTree.g:160:2: ( MODEL i= IDENT '{' ( pattern )+ '}' -> {model_in_sequence.contains(id)}? ^( Model IDENT[id] ( pattern )+ ) ->)
			// WreslTree.g:160:4: MODEL i= IDENT '{' ( pattern )+ '}'
			{
			MODEL83=(Token)match(input,MODEL,FOLLOW_MODEL_in_model979); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_MODEL.add(MODEL83);

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_model983); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal84=(Token)match(input,157,FOLLOW_157_in_model985); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal84);

			// WreslTree.g:160:22: ( pattern )+
			int cnt22=0;
			loop22:
			while (true) {
				int alt22=2;
				int LA22_0 = input.LA(1);
				if ( (LA22_0==DEFINE||LA22_0==GOAL||LA22_0==INCLUDE||LA22_0==OBJECTIVE) ) {
					alt22=1;
				}

				switch (alt22) {
				case 1 :
					// WreslTree.g:160:23: pattern
					{
					pushFollow(FOLLOW_pattern_in_model988);
					pattern85=pattern();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_pattern.add(pattern85.getTree());
					}
					break;

				default :
					if ( cnt22 >= 1 ) break loop22;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(22, input);
					throw eee;
				}
				cnt22++;
			}

			char_literal86=(Token)match(input,158,FOLLOW_158_in_model994); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal86);

			if ( state.backtracking==0 ) {id = (i!=null?i.getText():null).toLowerCase();  
				    model_list.add(id);}
			// AST REWRITE
			// elements: IDENT, pattern
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 163:2: -> {model_in_sequence.contains(id)}? ^( Model IDENT[id] ( pattern )+ )
			if (model_in_sequence.contains(id)) {
				// WreslTree.g:163:40: ^( Model IDENT[id] ( pattern )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Model, "Model"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(IDENT, id));
				if ( !(stream_pattern.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_pattern.hasNext() ) {
					adaptor.addChild(root_1, stream_pattern.nextTree());
				}
				stream_pattern.reset();

				adaptor.addChild(root_0, root_1);
				}

			}

			else // 164:2: ->
			{
				root_0 = null;
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "model"


	public static class sequence_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "sequence"
	// WreslTree.g:166:1: sequence : SEQUENCE s= IDENT '{' MODEL m= IDENT (c= condition )? ORDER INTEGER ( TIMESTEP t= TIMESTEPVALUE )? '}' -> ^( Sequence $s Model IDENT[id] Order INTEGER Condition[$c.text] TIMESTEP[timeStep] ) ;
	public final WreslTreeParser.sequence_return sequence() throws RecognitionException {
		WreslTreeParser.sequence_return retval = new WreslTreeParser.sequence_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		Token m=null;
		Token t=null;
		Token SEQUENCE87=null;
		Token char_literal88=null;
		Token MODEL89=null;
		Token ORDER90=null;
		Token INTEGER91=null;
		Token TIMESTEP92=null;
		Token char_literal93=null;
		ParserRuleReturnScope c =null;

		CommonTree s_tree=null;
		CommonTree m_tree=null;
		CommonTree t_tree=null;
		CommonTree SEQUENCE87_tree=null;
		CommonTree char_literal88_tree=null;
		CommonTree MODEL89_tree=null;
		CommonTree ORDER90_tree=null;
		CommonTree INTEGER91_tree=null;
		CommonTree TIMESTEP92_tree=null;
		CommonTree char_literal93_tree=null;
		RewriteRuleTokenStream stream_ORDER=new RewriteRuleTokenStream(adaptor,"token ORDER");
		RewriteRuleTokenStream stream_TIMESTEPVALUE=new RewriteRuleTokenStream(adaptor,"token TIMESTEPVALUE");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_SEQUENCE=new RewriteRuleTokenStream(adaptor,"token SEQUENCE");
		RewriteRuleTokenStream stream_MODEL=new RewriteRuleTokenStream(adaptor,"token MODEL");
		RewriteRuleTokenStream stream_TIMESTEP=new RewriteRuleTokenStream(adaptor,"token TIMESTEP");
		RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
		RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");

		 String id = null;String timeStep=Param.undefined;
		try {
			// WreslTree.g:168:2: ( SEQUENCE s= IDENT '{' MODEL m= IDENT (c= condition )? ORDER INTEGER ( TIMESTEP t= TIMESTEPVALUE )? '}' -> ^( Sequence $s Model IDENT[id] Order INTEGER Condition[$c.text] TIMESTEP[timeStep] ) )
			// WreslTree.g:168:4: SEQUENCE s= IDENT '{' MODEL m= IDENT (c= condition )? ORDER INTEGER ( TIMESTEP t= TIMESTEPVALUE )? '}'
			{
			SEQUENCE87=(Token)match(input,SEQUENCE,FOLLOW_SEQUENCE_in_sequence1046); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SEQUENCE.add(SEQUENCE87);

			s=(Token)match(input,IDENT,FOLLOW_IDENT_in_sequence1050); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(s);

			char_literal88=(Token)match(input,157,FOLLOW_157_in_sequence1052); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal88);

			MODEL89=(Token)match(input,MODEL,FOLLOW_MODEL_in_sequence1054); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_MODEL.add(MODEL89);

			m=(Token)match(input,IDENT,FOLLOW_IDENT_in_sequence1058); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(m);

			// WreslTree.g:168:39: (c= condition )?
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==CONDITION) ) {
				alt23=1;
			}
			switch (alt23) {
				case 1 :
					// WreslTree.g:168:41: c= condition
					{
					pushFollow(FOLLOW_condition_in_sequence1064);
					c=condition();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_condition.add(c.getTree());
					}
					break;

			}

			ORDER90=(Token)match(input,ORDER,FOLLOW_ORDER_in_sequence1068); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ORDER.add(ORDER90);

			INTEGER91=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sequence1070); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_INTEGER.add(INTEGER91);

			// WreslTree.g:168:69: ( TIMESTEP t= TIMESTEPVALUE )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==TIMESTEP) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// WreslTree.g:168:70: TIMESTEP t= TIMESTEPVALUE
					{
					TIMESTEP92=(Token)match(input,TIMESTEP,FOLLOW_TIMESTEP_in_sequence1073); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TIMESTEP.add(TIMESTEP92);

					t=(Token)match(input,TIMESTEPVALUE,FOLLOW_TIMESTEPVALUE_in_sequence1077); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_TIMESTEPVALUE.add(t);

					if ( state.backtracking==0 ) {timeStep=(t!=null?t.getText():null).toUpperCase();}
					}
					break;

			}

			char_literal93=(Token)match(input,158,FOLLOW_158_in_sequence1082); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal93);

			if ( state.backtracking==0 ) {id = (m!=null?m.getText():null).toLowerCase();
				  	model_in_sequence.add(id);}
			// AST REWRITE
			// elements: IDENT, s, TIMESTEP, INTEGER
			// token labels: s
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 171:2: -> ^( Sequence $s Model IDENT[id] Order INTEGER Condition[$c.text] TIMESTEP[timeStep] )
			{
				// WreslTree.g:171:6: ^( Sequence $s Model IDENT[id] Order INTEGER Condition[$c.text] TIMESTEP[timeStep] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Sequence, "Sequence"), root_1);
				adaptor.addChild(root_1, stream_s.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Model, "Model"));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(IDENT, id));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Order, "Order"));
				adaptor.addChild(root_1, stream_INTEGER.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Condition, (c!=null?((WreslTreeParser.condition_return)c).text:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TIMESTEP, timeStep));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "sequence"


	public static class condition_return extends ParserRuleReturnScope {
		public String text;
		public String dependants;
		public String varInCycle;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "condition"
	// WreslTree.g:174:1: condition returns [String text, String dependants, String varInCycle] : CONDITION (e= logical_expr | ALWAYS ) ;
	public final WreslTreeParser.condition_return condition() throws RecognitionException {
		WreslTreeParser.condition_return retval = new WreslTreeParser.condition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token CONDITION94=null;
		Token ALWAYS95=null;
		ParserRuleReturnScope e =null;

		CommonTree CONDITION94_tree=null;
		CommonTree ALWAYS95_tree=null;

		try {
			// WreslTree.g:175:2: ( CONDITION (e= logical_expr | ALWAYS ) )
			// WreslTree.g:175:4: CONDITION (e= logical_expr | ALWAYS )
			{
			root_0 = (CommonTree)adaptor.nil();


			CONDITION94=(Token)match(input,CONDITION,FOLLOW_CONDITION_in_condition1131); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CONDITION94_tree = (CommonTree)adaptor.create(CONDITION94);
			adaptor.addChild(root_0, CONDITION94_tree);
			}

			// WreslTree.g:176:2: (e= logical_expr | ALWAYS )
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==FLOAT||LA25_0==IDENT||(LA25_0 >= INT && LA25_0 <= INTEGER)||(LA25_0 >= MAX && LA25_0 <= MIN)||LA25_0==NOT||LA25_0==RANGE||LA25_0==ROUND||(LA25_0 >= 138 && LA25_0 <= 139)||LA25_0==142||LA25_0==144) ) {
				alt25=1;
			}
			else if ( (LA25_0==ALWAYS) ) {
				alt25=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 25, 0, input);
				throw nvae;
			}

			switch (alt25) {
				case 1 :
					// WreslTree.g:176:4: e= logical_expr
					{
					pushFollow(FOLLOW_logical_expr_in_condition1139);
					e=logical_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

					if ( state.backtracking==0 ) {retval.text =(e!=null?input.toString(e.start,e.stop):null); retval.dependants =(e!=null?((WreslTreeParser.logical_expr_return)e).dependants:null); retval.varInCycle =(e!=null?((WreslTreeParser.logical_expr_return)e).strVarInCycle:null);}
					}
					break;
				case 2 :
					// WreslTree.g:177:4: ALWAYS
					{
					ALWAYS95=(Token)match(input,ALWAYS,FOLLOW_ALWAYS_in_condition1146); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ALWAYS95_tree = (CommonTree)adaptor.create(ALWAYS95);
					adaptor.addChild(root_0, ALWAYS95_tree);
					}

					if ( state.backtracking==0 ) {retval.text = Param.always; }
					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "condition"


	public static class includeFile_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "includeFile"
	// WreslTree.g:181:1: includeFile : INCLUDE ( '[' (sc= LOCAL )? ']' )? FILE_PATH -> ^( Include Scope[$sc.text] FILE_PATH ) ;
	public final WreslTreeParser.includeFile_return includeFile() throws RecognitionException {
		WreslTreeParser.includeFile_return retval = new WreslTreeParser.includeFile_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token INCLUDE96=null;
		Token char_literal97=null;
		Token char_literal98=null;
		Token FILE_PATH99=null;

		CommonTree sc_tree=null;
		CommonTree INCLUDE96_tree=null;
		CommonTree char_literal97_tree=null;
		CommonTree char_literal98_tree=null;
		CommonTree FILE_PATH99_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_INCLUDE=new RewriteRuleTokenStream(adaptor,"token INCLUDE");
		RewriteRuleTokenStream stream_FILE_PATH=new RewriteRuleTokenStream(adaptor,"token FILE_PATH");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");

		try {
			// WreslTree.g:182:2: ( INCLUDE ( '[' (sc= LOCAL )? ']' )? FILE_PATH -> ^( Include Scope[$sc.text] FILE_PATH ) )
			// WreslTree.g:182:5: INCLUDE ( '[' (sc= LOCAL )? ']' )? FILE_PATH
			{
			INCLUDE96=(Token)match(input,INCLUDE,FOLLOW_INCLUDE_in_includeFile1166); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_INCLUDE.add(INCLUDE96);

			// WreslTree.g:182:13: ( '[' (sc= LOCAL )? ']' )?
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==153) ) {
				alt27=1;
			}
			switch (alt27) {
				case 1 :
					// WreslTree.g:182:15: '[' (sc= LOCAL )? ']'
					{
					char_literal97=(Token)match(input,153,FOLLOW_153_in_includeFile1170); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal97);

					// WreslTree.g:182:21: (sc= LOCAL )?
					int alt26=2;
					int LA26_0 = input.LA(1);
					if ( (LA26_0==LOCAL) ) {
						alt26=1;
					}
					switch (alt26) {
						case 1 :
							// WreslTree.g:182:21: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_includeFile1174); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal98=(Token)match(input,154,FOLLOW_154_in_includeFile1177); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal98);

					}
					break;

			}

			FILE_PATH99=(Token)match(input,FILE_PATH,FOLLOW_FILE_PATH_in_includeFile1182); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FILE_PATH.add(FILE_PATH99);

			// AST REWRITE
			// elements: FILE_PATH
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 183:2: -> ^( Include Scope[$sc.text] FILE_PATH )
			{
				// WreslTree.g:183:7: ^( Include Scope[$sc.text] FILE_PATH )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Include, "Include"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_FILE_PATH.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "includeFile"


	public static class alias_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "alias"
	// WreslTree.g:186:1: alias : DEFINE ! ( alias_simple | alias_timeArray_simple ) ;
	public final WreslTreeParser.alias_return alias() throws RecognitionException {
		WreslTreeParser.alias_return retval = new WreslTreeParser.alias_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DEFINE100=null;
		ParserRuleReturnScope alias_simple101 =null;
		ParserRuleReturnScope alias_timeArray_simple102 =null;

		CommonTree DEFINE100_tree=null;

		try {
			// WreslTree.g:186:6: ( DEFINE ! ( alias_simple | alias_timeArray_simple ) )
			// WreslTree.g:186:8: DEFINE ! ( alias_simple | alias_timeArray_simple )
			{
			root_0 = (CommonTree)adaptor.nil();


			DEFINE100=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_alias1207); if (state.failed) return retval;
			// WreslTree.g:186:16: ( alias_simple | alias_timeArray_simple )
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==IDENT||LA28_0==153) ) {
				alt28=1;
			}
			else if ( (LA28_0==139) ) {
				alt28=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 28, 0, input);
				throw nvae;
			}

			switch (alt28) {
				case 1 :
					// WreslTree.g:186:17: alias_simple
					{
					pushFollow(FOLLOW_alias_simple_in_alias1211);
					alias_simple101=alias_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, alias_simple101.getTree());

					}
					break;
				case 2 :
					// WreslTree.g:186:30: alias_timeArray_simple
					{
					pushFollow(FOLLOW_alias_timeArray_simple_in_alias1213);
					alias_timeArray_simple102=alias_timeArray_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, alias_timeArray_simple102.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "alias"


	public static class alias_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "alias_simple"
	// WreslTree.g:188:1: alias_simple : ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' ALIAS e= expression ( KIND k= STRING )? ( UNITS u= STRING )? '}' -> ^( Alias Scope[$sc.text] $i Expression[$e.text] Kind[$k.text] Units[$u.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle] ) ;
	public final WreslTreeParser.alias_simple_return alias_simple() throws RecognitionException {
		WreslTreeParser.alias_simple_return retval = new WreslTreeParser.alias_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token i=null;
		Token k=null;
		Token u=null;
		Token char_literal103=null;
		Token char_literal104=null;
		Token char_literal105=null;
		Token ALIAS106=null;
		Token KIND107=null;
		Token UNITS108=null;
		Token char_literal109=null;
		ParserRuleReturnScope e =null;

		CommonTree sc_tree=null;
		CommonTree i_tree=null;
		CommonTree k_tree=null;
		CommonTree u_tree=null;
		CommonTree char_literal103_tree=null;
		CommonTree char_literal104_tree=null;
		CommonTree char_literal105_tree=null;
		CommonTree ALIAS106_tree=null;
		CommonTree KIND107_tree=null;
		CommonTree UNITS108_tree=null;
		CommonTree char_literal109_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_ALIAS=new RewriteRuleTokenStream(adaptor,"token ALIAS");
		RewriteRuleTokenStream stream_KIND=new RewriteRuleTokenStream(adaptor,"token KIND");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleTokenStream stream_UNITS=new RewriteRuleTokenStream(adaptor,"token UNITS");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// WreslTree.g:188:14: ( ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' ALIAS e= expression ( KIND k= STRING )? ( UNITS u= STRING )? '}' -> ^( Alias Scope[$sc.text] $i Expression[$e.text] Kind[$k.text] Units[$u.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle] ) )
			// WreslTree.g:188:16: ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' ALIAS e= expression ( KIND k= STRING )? ( UNITS u= STRING )? '}'
			{
			// WreslTree.g:188:16: ( '[' (sc= LOCAL )? ']' )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==153) ) {
				alt30=1;
			}
			switch (alt30) {
				case 1 :
					// WreslTree.g:188:18: '[' (sc= LOCAL )? ']'
					{
					char_literal103=(Token)match(input,153,FOLLOW_153_in_alias_simple1224); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal103);

					// WreslTree.g:188:24: (sc= LOCAL )?
					int alt29=2;
					int LA29_0 = input.LA(1);
					if ( (LA29_0==LOCAL) ) {
						alt29=1;
					}
					switch (alt29) {
						case 1 :
							// WreslTree.g:188:24: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_alias_simple1228); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal104=(Token)match(input,154,FOLLOW_154_in_alias_simple1231); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal104);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_alias_simple1238); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal105=(Token)match(input,157,FOLLOW_157_in_alias_simple1240); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal105);

			ALIAS106=(Token)match(input,ALIAS,FOLLOW_ALIAS_in_alias_simple1242); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ALIAS.add(ALIAS106);

			pushFollow(FOLLOW_expression_in_alias_simple1246);
			e=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expression.add(e.getTree());
			// WreslTree.g:188:70: ( KIND k= STRING )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==KIND) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// WreslTree.g:188:71: KIND k= STRING
					{
					KIND107=(Token)match(input,KIND,FOLLOW_KIND_in_alias_simple1249); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KIND.add(KIND107);

					k=(Token)match(input,STRING,FOLLOW_STRING_in_alias_simple1253); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STRING.add(k);

					}
					break;

			}

			// WreslTree.g:188:87: ( UNITS u= STRING )?
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==UNITS) ) {
				alt32=1;
			}
			switch (alt32) {
				case 1 :
					// WreslTree.g:188:88: UNITS u= STRING
					{
					UNITS108=(Token)match(input,UNITS,FOLLOW_UNITS_in_alias_simple1258); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UNITS.add(UNITS108);

					u=(Token)match(input,STRING,FOLLOW_STRING_in_alias_simple1262); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STRING.add(u);

					}
					break;

			}

			char_literal109=(Token)match(input,158,FOLLOW_158_in_alias_simple1266); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal109);

			// AST REWRITE
			// elements: i
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 189:2: -> ^( Alias Scope[$sc.text] $i Expression[$e.text] Kind[$k.text] Units[$u.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle] )
			{
				// WreslTree.g:189:6: ^( Alias Scope[$sc.text] $i Expression[$e.text] Kind[$k.text] Units[$u.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Alias, "Alias"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Expression, (e!=null?((WreslTreeParser.expression_return)e).text:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Kind, (k!=null?k.getText():null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Units, (u!=null?u.getText():null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, (e!=null?((WreslTreeParser.expression_return)e).dependants:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(VarInCycle, (e!=null?((WreslTreeParser.expression_return)e).strVarInCycle:null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "alias_simple"


	public static class alias_timeArray_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "alias_timeArray_simple"
	// WreslTree.g:192:1: alias_timeArray_simple : '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' ALIAS e= expression ( KIND k= STRING )? ( UNITS u= STRING )? '}' -> ^( Alias TimeArraySize[$ta.text] Scope[$sc.text] $i Expression[$e.text] Kind[$k.text] Units[$u.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle] ) ;
	public final WreslTreeParser.alias_timeArray_simple_return alias_timeArray_simple() throws RecognitionException {
		WreslTreeParser.alias_timeArray_simple_return retval = new WreslTreeParser.alias_timeArray_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token i=null;
		Token k=null;
		Token u=null;
		Token char_literal110=null;
		Token char_literal111=null;
		Token char_literal112=null;
		Token char_literal113=null;
		Token char_literal114=null;
		Token ALIAS115=null;
		Token KIND116=null;
		Token UNITS117=null;
		Token char_literal118=null;
		ParserRuleReturnScope ta =null;
		ParserRuleReturnScope e =null;

		CommonTree sc_tree=null;
		CommonTree i_tree=null;
		CommonTree k_tree=null;
		CommonTree u_tree=null;
		CommonTree char_literal110_tree=null;
		CommonTree char_literal111_tree=null;
		CommonTree char_literal112_tree=null;
		CommonTree char_literal113_tree=null;
		CommonTree char_literal114_tree=null;
		CommonTree ALIAS115_tree=null;
		CommonTree KIND116_tree=null;
		CommonTree UNITS117_tree=null;
		CommonTree char_literal118_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
		RewriteRuleTokenStream stream_ALIAS=new RewriteRuleTokenStream(adaptor,"token ALIAS");
		RewriteRuleTokenStream stream_KIND=new RewriteRuleTokenStream(adaptor,"token KIND");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleTokenStream stream_140=new RewriteRuleTokenStream(adaptor,"token 140");
		RewriteRuleTokenStream stream_UNITS=new RewriteRuleTokenStream(adaptor,"token UNITS");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_timeArraySize=new RewriteRuleSubtreeStream(adaptor,"rule timeArraySize");

		try {
			// WreslTree.g:192:24: ( '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' ALIAS e= expression ( KIND k= STRING )? ( UNITS u= STRING )? '}' -> ^( Alias TimeArraySize[$ta.text] Scope[$sc.text] $i Expression[$e.text] Kind[$k.text] Units[$u.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle] ) )
			// WreslTree.g:192:26: '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' ALIAS e= expression ( KIND k= STRING )? ( UNITS u= STRING )? '}'
			{
			char_literal110=(Token)match(input,139,FOLLOW_139_in_alias_timeArray_simple1306); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_139.add(char_literal110);

			pushFollow(FOLLOW_timeArraySize_in_alias_timeArray_simple1310);
			ta=timeArraySize();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_timeArraySize.add(ta.getTree());
			char_literal111=(Token)match(input,140,FOLLOW_140_in_alias_timeArray_simple1312); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_140.add(char_literal111);

			// WreslTree.g:192:51: ( '[' (sc= LOCAL )? ']' )?
			int alt34=2;
			int LA34_0 = input.LA(1);
			if ( (LA34_0==153) ) {
				alt34=1;
			}
			switch (alt34) {
				case 1 :
					// WreslTree.g:192:53: '[' (sc= LOCAL )? ']'
					{
					char_literal112=(Token)match(input,153,FOLLOW_153_in_alias_timeArray_simple1316); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal112);

					// WreslTree.g:192:59: (sc= LOCAL )?
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0==LOCAL) ) {
						alt33=1;
					}
					switch (alt33) {
						case 1 :
							// WreslTree.g:192:59: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_alias_timeArray_simple1320); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal113=(Token)match(input,154,FOLLOW_154_in_alias_timeArray_simple1323); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal113);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_alias_timeArray_simple1330); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal114=(Token)match(input,157,FOLLOW_157_in_alias_timeArray_simple1332); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal114);

			ALIAS115=(Token)match(input,ALIAS,FOLLOW_ALIAS_in_alias_timeArray_simple1334); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_ALIAS.add(ALIAS115);

			pushFollow(FOLLOW_expression_in_alias_timeArray_simple1338);
			e=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expression.add(e.getTree());
			// WreslTree.g:192:105: ( KIND k= STRING )?
			int alt35=2;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==KIND) ) {
				alt35=1;
			}
			switch (alt35) {
				case 1 :
					// WreslTree.g:192:106: KIND k= STRING
					{
					KIND116=(Token)match(input,KIND,FOLLOW_KIND_in_alias_timeArray_simple1341); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_KIND.add(KIND116);

					k=(Token)match(input,STRING,FOLLOW_STRING_in_alias_timeArray_simple1345); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STRING.add(k);

					}
					break;

			}

			// WreslTree.g:192:122: ( UNITS u= STRING )?
			int alt36=2;
			int LA36_0 = input.LA(1);
			if ( (LA36_0==UNITS) ) {
				alt36=1;
			}
			switch (alt36) {
				case 1 :
					// WreslTree.g:192:123: UNITS u= STRING
					{
					UNITS117=(Token)match(input,UNITS,FOLLOW_UNITS_in_alias_timeArray_simple1350); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UNITS.add(UNITS117);

					u=(Token)match(input,STRING,FOLLOW_STRING_in_alias_timeArray_simple1354); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STRING.add(u);

					}
					break;

			}

			char_literal118=(Token)match(input,158,FOLLOW_158_in_alias_timeArray_simple1358); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal118);

			// AST REWRITE
			// elements: i
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 193:3: -> ^( Alias TimeArraySize[$ta.text] Scope[$sc.text] $i Expression[$e.text] Kind[$k.text] Units[$u.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle] )
			{
				// WreslTree.g:193:7: ^( Alias TimeArraySize[$ta.text] Scope[$sc.text] $i Expression[$e.text] Kind[$k.text] Units[$u.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Alias, "Alias"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TimeArraySize, (ta!=null?input.toString(ta.start,ta.stop):null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Expression, (e!=null?((WreslTreeParser.expression_return)e).text:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Kind, (k!=null?k.getText():null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Units, (u!=null?u.getText():null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, (e!=null?((WreslTreeParser.expression_return)e).dependants:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(VarInCycle, (e!=null?((WreslTreeParser.expression_return)e).strVarInCycle:null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "alias_timeArray_simple"


	protected static class goal_scope {
		String goalName;
		String caseName;
		int caseNumber;
	}
	protected Stack<goal_scope> goal_stack = new Stack<goal_scope>();

	public static class goal_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goal"
	// WreslTree.g:196:1: goal : GOAL ! ( goal_simple | goal_case_or_nocase | goal_timeArray_simple | goal_timeArray_case_or_nocase ) ;
	public final WreslTreeParser.goal_return goal() throws RecognitionException {
		goal_stack.push(new goal_scope());
		WreslTreeParser.goal_return retval = new WreslTreeParser.goal_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token GOAL119=null;
		ParserRuleReturnScope goal_simple120 =null;
		ParserRuleReturnScope goal_case_or_nocase121 =null;
		ParserRuleReturnScope goal_timeArray_simple122 =null;
		ParserRuleReturnScope goal_timeArray_case_or_nocase123 =null;

		CommonTree GOAL119_tree=null;

		 goal_stack.peek().caseNumber = 0; 
		try {
			// WreslTree.g:199:2: ( GOAL ! ( goal_simple | goal_case_or_nocase | goal_timeArray_simple | goal_timeArray_case_or_nocase ) )
			// WreslTree.g:199:4: GOAL ! ( goal_simple | goal_case_or_nocase | goal_timeArray_simple | goal_timeArray_case_or_nocase )
			{
			root_0 = (CommonTree)adaptor.nil();


			GOAL119=(Token)match(input,GOAL,FOLLOW_GOAL_in_goal1413); if (state.failed) return retval;
			// WreslTree.g:199:10: ( goal_simple | goal_case_or_nocase | goal_timeArray_simple | goal_timeArray_case_or_nocase )
			int alt37=4;
			switch ( input.LA(1) ) {
			case 153:
				{
				int LA37_1 = input.LA(2);
				if ( (LA37_1==LOCAL) ) {
					int LA37_4 = input.LA(3);
					if ( (LA37_4==154) ) {
						int LA37_5 = input.LA(4);
						if ( (LA37_5==IDENT) ) {
							int LA37_2 = input.LA(5);
							if ( (LA37_2==157) ) {
								int LA37_6 = input.LA(6);
								if ( (LA37_6==LHS) ) {
									alt37=2;
								}
								else if ( (LA37_6==FLOAT||LA37_6==IDENT||(LA37_6 >= INT && LA37_6 <= INTEGER)||(LA37_6 >= MAX && LA37_6 <= MIN)||LA37_6==ROUND||(LA37_6 >= 138 && LA37_6 <= 139)||LA37_6==142||LA37_6==144) ) {
									alt37=1;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 37, 6, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 37, 2, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 37, 5, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 37, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA37_1==154) ) {
					int LA37_5 = input.LA(3);
					if ( (LA37_5==IDENT) ) {
						int LA37_2 = input.LA(4);
						if ( (LA37_2==157) ) {
							int LA37_6 = input.LA(5);
							if ( (LA37_6==LHS) ) {
								alt37=2;
							}
							else if ( (LA37_6==FLOAT||LA37_6==IDENT||(LA37_6 >= INT && LA37_6 <= INTEGER)||(LA37_6 >= MAX && LA37_6 <= MIN)||LA37_6==ROUND||(LA37_6 >= 138 && LA37_6 <= 139)||LA37_6==142||LA37_6==144) ) {
								alt37=1;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 37, 6, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 37, 2, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 37, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 37, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case IDENT:
				{
				int LA37_2 = input.LA(2);
				if ( (LA37_2==157) ) {
					int LA37_6 = input.LA(3);
					if ( (LA37_6==LHS) ) {
						alt37=2;
					}
					else if ( (LA37_6==FLOAT||LA37_6==IDENT||(LA37_6 >= INT && LA37_6 <= INTEGER)||(LA37_6 >= MAX && LA37_6 <= MIN)||LA37_6==ROUND||(LA37_6 >= 138 && LA37_6 <= 139)||LA37_6==142||LA37_6==144) ) {
						alt37=1;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 37, 6, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 37, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 139:
				{
				int LA37_3 = input.LA(2);
				if ( (LA37_3==INTEGER) ) {
					int LA37_7 = input.LA(3);
					if ( (LA37_7==140) ) {
						int LA37_11 = input.LA(4);
						if ( (LA37_11==153) ) {
							int LA37_12 = input.LA(5);
							if ( (LA37_12==LOCAL) ) {
								int LA37_14 = input.LA(6);
								if ( (LA37_14==154) ) {
									int LA37_15 = input.LA(7);
									if ( (LA37_15==IDENT) ) {
										int LA37_13 = input.LA(8);
										if ( (LA37_13==157) ) {
											int LA37_16 = input.LA(9);
											if ( (LA37_16==LHS) ) {
												alt37=4;
											}
											else if ( (LA37_16==FLOAT||LA37_16==IDENT||(LA37_16 >= INT && LA37_16 <= INTEGER)||(LA37_16 >= MAX && LA37_16 <= MIN)||LA37_16==ROUND||(LA37_16 >= 138 && LA37_16 <= 139)||LA37_16==142||LA37_16==144) ) {
												alt37=3;
											}

											else {
												if (state.backtracking>0) {state.failed=true; return retval;}
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 37, 16, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}

										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 37, 13, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 37, 15, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 37, 14, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}
							else if ( (LA37_12==154) ) {
								int LA37_15 = input.LA(6);
								if ( (LA37_15==IDENT) ) {
									int LA37_13 = input.LA(7);
									if ( (LA37_13==157) ) {
										int LA37_16 = input.LA(8);
										if ( (LA37_16==LHS) ) {
											alt37=4;
										}
										else if ( (LA37_16==FLOAT||LA37_16==IDENT||(LA37_16 >= INT && LA37_16 <= INTEGER)||(LA37_16 >= MAX && LA37_16 <= MIN)||LA37_16==ROUND||(LA37_16 >= 138 && LA37_16 <= 139)||LA37_16==142||LA37_16==144) ) {
											alt37=3;
										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 37, 16, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 37, 13, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 37, 15, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 37, 12, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}
						else if ( (LA37_11==IDENT) ) {
							int LA37_13 = input.LA(5);
							if ( (LA37_13==157) ) {
								int LA37_16 = input.LA(6);
								if ( (LA37_16==LHS) ) {
									alt37=4;
								}
								else if ( (LA37_16==FLOAT||LA37_16==IDENT||(LA37_16 >= INT && LA37_16 <= INTEGER)||(LA37_16 >= MAX && LA37_16 <= MIN)||LA37_16==ROUND||(LA37_16 >= 138 && LA37_16 <= 139)||LA37_16==142||LA37_16==144) ) {
									alt37=3;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 37, 16, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 37, 13, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 37, 11, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 37, 7, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA37_3==IDENT) ) {
					int LA37_8 = input.LA(3);
					if ( (LA37_8==140) ) {
						int LA37_11 = input.LA(4);
						if ( (LA37_11==153) ) {
							int LA37_12 = input.LA(5);
							if ( (LA37_12==LOCAL) ) {
								int LA37_14 = input.LA(6);
								if ( (LA37_14==154) ) {
									int LA37_15 = input.LA(7);
									if ( (LA37_15==IDENT) ) {
										int LA37_13 = input.LA(8);
										if ( (LA37_13==157) ) {
											int LA37_16 = input.LA(9);
											if ( (LA37_16==LHS) ) {
												alt37=4;
											}
											else if ( (LA37_16==FLOAT||LA37_16==IDENT||(LA37_16 >= INT && LA37_16 <= INTEGER)||(LA37_16 >= MAX && LA37_16 <= MIN)||LA37_16==ROUND||(LA37_16 >= 138 && LA37_16 <= 139)||LA37_16==142||LA37_16==144) ) {
												alt37=3;
											}

											else {
												if (state.backtracking>0) {state.failed=true; return retval;}
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 37, 16, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}

										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 37, 13, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 37, 15, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 37, 14, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}
							else if ( (LA37_12==154) ) {
								int LA37_15 = input.LA(6);
								if ( (LA37_15==IDENT) ) {
									int LA37_13 = input.LA(7);
									if ( (LA37_13==157) ) {
										int LA37_16 = input.LA(8);
										if ( (LA37_16==LHS) ) {
											alt37=4;
										}
										else if ( (LA37_16==FLOAT||LA37_16==IDENT||(LA37_16 >= INT && LA37_16 <= INTEGER)||(LA37_16 >= MAX && LA37_16 <= MIN)||LA37_16==ROUND||(LA37_16 >= 138 && LA37_16 <= 139)||LA37_16==142||LA37_16==144) ) {
											alt37=3;
										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 37, 16, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 37, 13, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 37, 15, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 37, 12, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}
						else if ( (LA37_11==IDENT) ) {
							int LA37_13 = input.LA(5);
							if ( (LA37_13==157) ) {
								int LA37_16 = input.LA(6);
								if ( (LA37_16==LHS) ) {
									alt37=4;
								}
								else if ( (LA37_16==FLOAT||LA37_16==IDENT||(LA37_16 >= INT && LA37_16 <= INTEGER)||(LA37_16 >= MAX && LA37_16 <= MIN)||LA37_16==ROUND||(LA37_16 >= 138 && LA37_16 <= 139)||LA37_16==142||LA37_16==144) ) {
									alt37=3;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 37, 16, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 37, 13, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 37, 11, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 37, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 37, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 37, 0, input);
				throw nvae;
			}
			switch (alt37) {
				case 1 :
					// WreslTree.g:199:11: goal_simple
					{
					pushFollow(FOLLOW_goal_simple_in_goal1417);
					goal_simple120=goal_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goal_simple120.getTree());

					}
					break;
				case 2 :
					// WreslTree.g:199:25: goal_case_or_nocase
					{
					pushFollow(FOLLOW_goal_case_or_nocase_in_goal1421);
					goal_case_or_nocase121=goal_case_or_nocase();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goal_case_or_nocase121.getTree());

					}
					break;
				case 3 :
					// WreslTree.g:199:47: goal_timeArray_simple
					{
					pushFollow(FOLLOW_goal_timeArray_simple_in_goal1425);
					goal_timeArray_simple122=goal_timeArray_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goal_timeArray_simple122.getTree());

					}
					break;
				case 4 :
					// WreslTree.g:199:71: goal_timeArray_case_or_nocase
					{
					pushFollow(FOLLOW_goal_timeArray_case_or_nocase_in_goal1429);
					goal_timeArray_case_or_nocase123=goal_timeArray_case_or_nocase();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goal_timeArray_case_or_nocase123.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			goal_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "goal"


	public static class goal_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goal_simple"
	// WreslTree.g:202:1: goal_simple : ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' v= constraint_statement '}' -> ^( Goal_simple Scope[$sc.text] $i Dependants[$v.dependants] Constraint_content[Tools.replace_ignoreChar($v.text)] VarInCycle[$v.varInCycle] ) ;
	public final WreslTreeParser.goal_simple_return goal_simple() throws RecognitionException {
		WreslTreeParser.goal_simple_return retval = new WreslTreeParser.goal_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token i=null;
		Token char_literal124=null;
		Token char_literal125=null;
		Token char_literal126=null;
		Token char_literal127=null;
		ParserRuleReturnScope v =null;

		CommonTree sc_tree=null;
		CommonTree i_tree=null;
		CommonTree char_literal124_tree=null;
		CommonTree char_literal125_tree=null;
		CommonTree char_literal126_tree=null;
		CommonTree char_literal127_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_constraint_statement=new RewriteRuleSubtreeStream(adaptor,"rule constraint_statement");

		try {
			// WreslTree.g:203:2: ( ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' v= constraint_statement '}' -> ^( Goal_simple Scope[$sc.text] $i Dependants[$v.dependants] Constraint_content[Tools.replace_ignoreChar($v.text)] VarInCycle[$v.varInCycle] ) )
			// WreslTree.g:203:5: ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' v= constraint_statement '}'
			{
			// WreslTree.g:203:5: ( '[' (sc= LOCAL )? ']' )?
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==153) ) {
				alt39=1;
			}
			switch (alt39) {
				case 1 :
					// WreslTree.g:203:7: '[' (sc= LOCAL )? ']'
					{
					char_literal124=(Token)match(input,153,FOLLOW_153_in_goal_simple1447); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal124);

					// WreslTree.g:203:13: (sc= LOCAL )?
					int alt38=2;
					int LA38_0 = input.LA(1);
					if ( (LA38_0==LOCAL) ) {
						alt38=1;
					}
					switch (alt38) {
						case 1 :
							// WreslTree.g:203:13: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_goal_simple1451); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal125=(Token)match(input,154,FOLLOW_154_in_goal_simple1454); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal125);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_goal_simple1461); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal126=(Token)match(input,157,FOLLOW_157_in_goal_simple1463); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal126);

			pushFollow(FOLLOW_constraint_statement_in_goal_simple1467);
			v=constraint_statement();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_constraint_statement.add(v.getTree());
			char_literal127=(Token)match(input,158,FOLLOW_158_in_goal_simple1469); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal127);

			// AST REWRITE
			// elements: i
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 204:2: -> ^( Goal_simple Scope[$sc.text] $i Dependants[$v.dependants] Constraint_content[Tools.replace_ignoreChar($v.text)] VarInCycle[$v.varInCycle] )
			{
				// WreslTree.g:204:5: ^( Goal_simple Scope[$sc.text] $i Dependants[$v.dependants] Constraint_content[Tools.replace_ignoreChar($v.text)] VarInCycle[$v.varInCycle] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Goal_simple, "Goal_simple"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, (v!=null?((WreslTreeParser.constraint_statement_return)v).dependants:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Constraint_content, Tools.replace_ignoreChar((v!=null?((WreslTreeParser.constraint_statement_return)v).text:null))));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(VarInCycle, (v!=null?((WreslTreeParser.constraint_statement_return)v).varInCycle:null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "goal_simple"


	public static class goal_timeArray_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goal_timeArray_simple"
	// WreslTree.g:207:1: goal_timeArray_simple : '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' v= constraint_statement '}' -> ^( Goal_simple TimeArraySize[$ta.text] Scope[$sc.text] $i Dependants[$v.dependants+\" \"+$ta.dependant] Constraint_content[Tools.replace_ignoreChar($v.text)] VarInCycle[$v.varInCycle] ) ;
	public final WreslTreeParser.goal_timeArray_simple_return goal_timeArray_simple() throws RecognitionException {
		WreslTreeParser.goal_timeArray_simple_return retval = new WreslTreeParser.goal_timeArray_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token i=null;
		Token char_literal128=null;
		Token char_literal129=null;
		Token char_literal130=null;
		Token char_literal131=null;
		Token char_literal132=null;
		Token char_literal133=null;
		ParserRuleReturnScope ta =null;
		ParserRuleReturnScope v =null;

		CommonTree sc_tree=null;
		CommonTree i_tree=null;
		CommonTree char_literal128_tree=null;
		CommonTree char_literal129_tree=null;
		CommonTree char_literal130_tree=null;
		CommonTree char_literal131_tree=null;
		CommonTree char_literal132_tree=null;
		CommonTree char_literal133_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_140=new RewriteRuleTokenStream(adaptor,"token 140");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_timeArraySize=new RewriteRuleSubtreeStream(adaptor,"rule timeArraySize");
		RewriteRuleSubtreeStream stream_constraint_statement=new RewriteRuleSubtreeStream(adaptor,"rule constraint_statement");

		try {
			// WreslTree.g:208:3: ( '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' v= constraint_statement '}' -> ^( Goal_simple TimeArraySize[$ta.text] Scope[$sc.text] $i Dependants[$v.dependants+\" \"+$ta.dependant] Constraint_content[Tools.replace_ignoreChar($v.text)] VarInCycle[$v.varInCycle] ) )
			// WreslTree.g:208:6: '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' v= constraint_statement '}'
			{
			char_literal128=(Token)match(input,139,FOLLOW_139_in_goal_timeArray_simple1510); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_139.add(char_literal128);

			pushFollow(FOLLOW_timeArraySize_in_goal_timeArray_simple1514);
			ta=timeArraySize();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_timeArraySize.add(ta.getTree());
			char_literal129=(Token)match(input,140,FOLLOW_140_in_goal_timeArray_simple1516); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_140.add(char_literal129);

			// WreslTree.g:208:31: ( '[' (sc= LOCAL )? ']' )?
			int alt41=2;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==153) ) {
				alt41=1;
			}
			switch (alt41) {
				case 1 :
					// WreslTree.g:208:33: '[' (sc= LOCAL )? ']'
					{
					char_literal130=(Token)match(input,153,FOLLOW_153_in_goal_timeArray_simple1520); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal130);

					// WreslTree.g:208:39: (sc= LOCAL )?
					int alt40=2;
					int LA40_0 = input.LA(1);
					if ( (LA40_0==LOCAL) ) {
						alt40=1;
					}
					switch (alt40) {
						case 1 :
							// WreslTree.g:208:39: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_goal_timeArray_simple1524); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal131=(Token)match(input,154,FOLLOW_154_in_goal_timeArray_simple1527); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal131);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_goal_timeArray_simple1534); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal132=(Token)match(input,157,FOLLOW_157_in_goal_timeArray_simple1536); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal132);

			pushFollow(FOLLOW_constraint_statement_in_goal_timeArray_simple1540);
			v=constraint_statement();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_constraint_statement.add(v.getTree());
			char_literal133=(Token)match(input,158,FOLLOW_158_in_goal_timeArray_simple1542); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal133);

			// AST REWRITE
			// elements: i
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 209:3: -> ^( Goal_simple TimeArraySize[$ta.text] Scope[$sc.text] $i Dependants[$v.dependants+\" \"+$ta.dependant] Constraint_content[Tools.replace_ignoreChar($v.text)] VarInCycle[$v.varInCycle] )
			{
				// WreslTree.g:209:5: ^( Goal_simple TimeArraySize[$ta.text] Scope[$sc.text] $i Dependants[$v.dependants+\" \"+$ta.dependant] Constraint_content[Tools.replace_ignoreChar($v.text)] VarInCycle[$v.varInCycle] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Goal_simple, "Goal_simple"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TimeArraySize, (ta!=null?input.toString(ta.start,ta.stop):null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, (v!=null?((WreslTreeParser.constraint_statement_return)v).dependants:null)+" "+(ta!=null?((WreslTreeParser.timeArraySize_return)ta).dependant:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Constraint_content, Tools.replace_ignoreChar((v!=null?((WreslTreeParser.constraint_statement_return)v).text:null))));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(VarInCycle, (v!=null?((WreslTreeParser.constraint_statement_return)v).varInCycle:null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "goal_timeArray_simple"


	public static class goal_case_or_nocase_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goal_case_or_nocase"
	// WreslTree.g:212:1: goal_case_or_nocase : ( '[' (s= LOCAL )? ']' )? i= IDENT '{' LHS l= expression ( ( goal_no_case_content[$l.text, $l.dependants, $l.strVarInCycle] -> ^( Goal_no_case Scope[$s.text] $i goal_no_case_content ) ) | ( ( goal_case_content[$l.text, $l.dependants, $l.strVarInCycle] )+ -> ^( Goal_case Scope[$s.text] $i ( goal_case_content )+ ) ) ) '}' ;
	public final WreslTreeParser.goal_case_or_nocase_return goal_case_or_nocase() throws RecognitionException {
		WreslTreeParser.goal_case_or_nocase_return retval = new WreslTreeParser.goal_case_or_nocase_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		Token i=null;
		Token char_literal134=null;
		Token char_literal135=null;
		Token char_literal136=null;
		Token LHS137=null;
		Token char_literal140=null;
		ParserRuleReturnScope l =null;
		ParserRuleReturnScope goal_no_case_content138 =null;
		ParserRuleReturnScope goal_case_content139 =null;

		CommonTree s_tree=null;
		CommonTree i_tree=null;
		CommonTree char_literal134_tree=null;
		CommonTree char_literal135_tree=null;
		CommonTree char_literal136_tree=null;
		CommonTree LHS137_tree=null;
		CommonTree char_literal140_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_LHS=new RewriteRuleTokenStream(adaptor,"token LHS");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_goal_no_case_content=new RewriteRuleSubtreeStream(adaptor,"rule goal_no_case_content");
		RewriteRuleSubtreeStream stream_goal_case_content=new RewriteRuleSubtreeStream(adaptor,"rule goal_case_content");

		try {
			// WreslTree.g:213:2: ( ( '[' (s= LOCAL )? ']' )? i= IDENT '{' LHS l= expression ( ( goal_no_case_content[$l.text, $l.dependants, $l.strVarInCycle] -> ^( Goal_no_case Scope[$s.text] $i goal_no_case_content ) ) | ( ( goal_case_content[$l.text, $l.dependants, $l.strVarInCycle] )+ -> ^( Goal_case Scope[$s.text] $i ( goal_case_content )+ ) ) ) '}' )
			// WreslTree.g:213:5: ( '[' (s= LOCAL )? ']' )? i= IDENT '{' LHS l= expression ( ( goal_no_case_content[$l.text, $l.dependants, $l.strVarInCycle] -> ^( Goal_no_case Scope[$s.text] $i goal_no_case_content ) ) | ( ( goal_case_content[$l.text, $l.dependants, $l.strVarInCycle] )+ -> ^( Goal_case Scope[$s.text] $i ( goal_case_content )+ ) ) ) '}'
			{
			// WreslTree.g:213:5: ( '[' (s= LOCAL )? ']' )?
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==153) ) {
				alt43=1;
			}
			switch (alt43) {
				case 1 :
					// WreslTree.g:213:7: '[' (s= LOCAL )? ']'
					{
					char_literal134=(Token)match(input,153,FOLLOW_153_in_goal_case_or_nocase1590); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal134);

					// WreslTree.g:213:12: (s= LOCAL )?
					int alt42=2;
					int LA42_0 = input.LA(1);
					if ( (LA42_0==LOCAL) ) {
						alt42=1;
					}
					switch (alt42) {
						case 1 :
							// WreslTree.g:213:12: s= LOCAL
							{
							s=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_goal_case_or_nocase1594); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(s);

							}
							break;

					}

					char_literal135=(Token)match(input,154,FOLLOW_154_in_goal_case_or_nocase1597); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal135);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_goal_case_or_nocase1604); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			if ( state.backtracking==0 ) { goal_stack.peek().goalName = (i!=null?i.getText():null);  }
			char_literal136=(Token)match(input,157,FOLLOW_157_in_goal_case_or_nocase1610); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal136);

			LHS137=(Token)match(input,LHS,FOLLOW_LHS_in_goal_case_or_nocase1612); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LHS.add(LHS137);

			pushFollow(FOLLOW_expression_in_goal_case_or_nocase1616);
			l=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expression.add(l.getTree());
			// WreslTree.g:215:2: ( ( goal_no_case_content[$l.text, $l.dependants, $l.strVarInCycle] -> ^( Goal_no_case Scope[$s.text] $i goal_no_case_content ) ) | ( ( goal_case_content[$l.text, $l.dependants, $l.strVarInCycle] )+ -> ^( Goal_case Scope[$s.text] $i ( goal_case_content )+ ) ) )
			int alt45=2;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==RHS) ) {
				alt45=1;
			}
			else if ( (LA45_0==CASE) ) {
				alt45=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 45, 0, input);
				throw nvae;
			}

			switch (alt45) {
				case 1 :
					// WreslTree.g:216:4: ( goal_no_case_content[$l.text, $l.dependants, $l.strVarInCycle] -> ^( Goal_no_case Scope[$s.text] $i goal_no_case_content ) )
					{
					// WreslTree.g:216:4: ( goal_no_case_content[$l.text, $l.dependants, $l.strVarInCycle] -> ^( Goal_no_case Scope[$s.text] $i goal_no_case_content ) )
					// WreslTree.g:216:6: goal_no_case_content[$l.text, $l.dependants, $l.strVarInCycle]
					{
					pushFollow(FOLLOW_goal_no_case_content_in_goal_case_or_nocase1628);
					goal_no_case_content138=goal_no_case_content((l!=null?((WreslTreeParser.expression_return)l).text:null), (l!=null?((WreslTreeParser.expression_return)l).dependants:null), (l!=null?((WreslTreeParser.expression_return)l).strVarInCycle:null));
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goal_no_case_content.add(goal_no_case_content138.getTree());
					// AST REWRITE
					// elements: goal_no_case_content, i
					// token labels: i
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 216:69: -> ^( Goal_no_case Scope[$s.text] $i goal_no_case_content )
					{
						// WreslTree.g:216:73: ^( Goal_no_case Scope[$s.text] $i goal_no_case_content )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Goal_no_case, "Goal_no_case"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (s!=null?s.getText():null)));
						adaptor.addChild(root_1, stream_i.nextNode());
						adaptor.addChild(root_1, stream_goal_no_case_content.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}

					}
					break;
				case 2 :
					// WreslTree.g:217:7: ( ( goal_case_content[$l.text, $l.dependants, $l.strVarInCycle] )+ -> ^( Goal_case Scope[$s.text] $i ( goal_case_content )+ ) )
					{
					// WreslTree.g:217:7: ( ( goal_case_content[$l.text, $l.dependants, $l.strVarInCycle] )+ -> ^( Goal_case Scope[$s.text] $i ( goal_case_content )+ ) )
					// WreslTree.g:217:9: ( goal_case_content[$l.text, $l.dependants, $l.strVarInCycle] )+
					{
					// WreslTree.g:217:9: ( goal_case_content[$l.text, $l.dependants, $l.strVarInCycle] )+
					int cnt44=0;
					loop44:
					while (true) {
						int alt44=2;
						int LA44_0 = input.LA(1);
						if ( (LA44_0==CASE) ) {
							alt44=1;
						}

						switch (alt44) {
						case 1 :
							// WreslTree.g:217:9: goal_case_content[$l.text, $l.dependants, $l.strVarInCycle]
							{
							pushFollow(FOLLOW_goal_case_content_in_goal_case_or_nocase1661);
							goal_case_content139=goal_case_content((l!=null?((WreslTreeParser.expression_return)l).text:null), (l!=null?((WreslTreeParser.expression_return)l).dependants:null), (l!=null?((WreslTreeParser.expression_return)l).strVarInCycle:null));
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goal_case_content.add(goal_case_content139.getTree());
							}
							break;

						default :
							if ( cnt44 >= 1 ) break loop44;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(44, input);
							throw eee;
						}
						cnt44++;
					}

					// AST REWRITE
					// elements: goal_case_content, i
					// token labels: i
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 217:72: -> ^( Goal_case Scope[$s.text] $i ( goal_case_content )+ )
					{
						// WreslTree.g:217:76: ^( Goal_case Scope[$s.text] $i ( goal_case_content )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Goal_case, "Goal_case"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (s!=null?s.getText():null)));
						adaptor.addChild(root_1, stream_i.nextNode());
						if ( !(stream_goal_case_content.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_goal_case_content.hasNext() ) {
							adaptor.addChild(root_1, stream_goal_case_content.nextTree());
						}
						stream_goal_case_content.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}

					}
					break;

			}

			char_literal140=(Token)match(input,158,FOLLOW_158_in_goal_case_or_nocase1698); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal140);

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "goal_case_or_nocase"


	public static class goal_timeArray_case_or_nocase_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goal_timeArray_case_or_nocase"
	// WreslTree.g:221:1: goal_timeArray_case_or_nocase : '(' ta= timeArraySize ')' ( '[' (s= LOCAL )? ']' )? i= IDENT '{' LHS l= expression ( ( goal_no_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle] -> ^( Goal_no_case TimeArraySize[$ta.text] Scope[$s.text] $i goal_no_case_content ) ) | ( ( goal_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle] )+ -> ^( Goal_case TimeArraySize[$ta.text] Scope[$s.text] $i ( goal_case_content )+ ) ) ) '}' ;
	public final WreslTreeParser.goal_timeArray_case_or_nocase_return goal_timeArray_case_or_nocase() throws RecognitionException {
		WreslTreeParser.goal_timeArray_case_or_nocase_return retval = new WreslTreeParser.goal_timeArray_case_or_nocase_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		Token i=null;
		Token char_literal141=null;
		Token char_literal142=null;
		Token char_literal143=null;
		Token char_literal144=null;
		Token char_literal145=null;
		Token LHS146=null;
		Token char_literal149=null;
		ParserRuleReturnScope ta =null;
		ParserRuleReturnScope l =null;
		ParserRuleReturnScope goal_no_case_content147 =null;
		ParserRuleReturnScope goal_case_content148 =null;

		CommonTree s_tree=null;
		CommonTree i_tree=null;
		CommonTree char_literal141_tree=null;
		CommonTree char_literal142_tree=null;
		CommonTree char_literal143_tree=null;
		CommonTree char_literal144_tree=null;
		CommonTree char_literal145_tree=null;
		CommonTree LHS146_tree=null;
		CommonTree char_literal149_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_LHS=new RewriteRuleTokenStream(adaptor,"token LHS");
		RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_140=new RewriteRuleTokenStream(adaptor,"token 140");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_goal_no_case_content=new RewriteRuleSubtreeStream(adaptor,"rule goal_no_case_content");
		RewriteRuleSubtreeStream stream_timeArraySize=new RewriteRuleSubtreeStream(adaptor,"rule timeArraySize");
		RewriteRuleSubtreeStream stream_goal_case_content=new RewriteRuleSubtreeStream(adaptor,"rule goal_case_content");

		try {
			// WreslTree.g:222:3: ( '(' ta= timeArraySize ')' ( '[' (s= LOCAL )? ']' )? i= IDENT '{' LHS l= expression ( ( goal_no_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle] -> ^( Goal_no_case TimeArraySize[$ta.text] Scope[$s.text] $i goal_no_case_content ) ) | ( ( goal_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle] )+ -> ^( Goal_case TimeArraySize[$ta.text] Scope[$s.text] $i ( goal_case_content )+ ) ) ) '}' )
			// WreslTree.g:222:6: '(' ta= timeArraySize ')' ( '[' (s= LOCAL )? ']' )? i= IDENT '{' LHS l= expression ( ( goal_no_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle] -> ^( Goal_no_case TimeArraySize[$ta.text] Scope[$s.text] $i goal_no_case_content ) ) | ( ( goal_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle] )+ -> ^( Goal_case TimeArraySize[$ta.text] Scope[$s.text] $i ( goal_case_content )+ ) ) ) '}'
			{
			char_literal141=(Token)match(input,139,FOLLOW_139_in_goal_timeArray_case_or_nocase1714); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_139.add(char_literal141);

			pushFollow(FOLLOW_timeArraySize_in_goal_timeArray_case_or_nocase1718);
			ta=timeArraySize();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_timeArraySize.add(ta.getTree());
			char_literal142=(Token)match(input,140,FOLLOW_140_in_goal_timeArray_case_or_nocase1720); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_140.add(char_literal142);

			// WreslTree.g:222:31: ( '[' (s= LOCAL )? ']' )?
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==153) ) {
				alt47=1;
			}
			switch (alt47) {
				case 1 :
					// WreslTree.g:222:33: '[' (s= LOCAL )? ']'
					{
					char_literal143=(Token)match(input,153,FOLLOW_153_in_goal_timeArray_case_or_nocase1724); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal143);

					// WreslTree.g:222:38: (s= LOCAL )?
					int alt46=2;
					int LA46_0 = input.LA(1);
					if ( (LA46_0==LOCAL) ) {
						alt46=1;
					}
					switch (alt46) {
						case 1 :
							// WreslTree.g:222:38: s= LOCAL
							{
							s=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_goal_timeArray_case_or_nocase1728); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(s);

							}
							break;

					}

					char_literal144=(Token)match(input,154,FOLLOW_154_in_goal_timeArray_case_or_nocase1731); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal144);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_goal_timeArray_case_or_nocase1738); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			if ( state.backtracking==0 ) { goal_stack.peek().goalName = (i!=null?i.getText():null);  }
			char_literal145=(Token)match(input,157,FOLLOW_157_in_goal_timeArray_case_or_nocase1745); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal145);

			LHS146=(Token)match(input,LHS,FOLLOW_LHS_in_goal_timeArray_case_or_nocase1747); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LHS.add(LHS146);

			pushFollow(FOLLOW_expression_in_goal_timeArray_case_or_nocase1751);
			l=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expression.add(l.getTree());
			// WreslTree.g:224:3: ( ( goal_no_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle] -> ^( Goal_no_case TimeArraySize[$ta.text] Scope[$s.text] $i goal_no_case_content ) ) | ( ( goal_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle] )+ -> ^( Goal_case TimeArraySize[$ta.text] Scope[$s.text] $i ( goal_case_content )+ ) ) )
			int alt49=2;
			int LA49_0 = input.LA(1);
			if ( (LA49_0==RHS) ) {
				alt49=1;
			}
			else if ( (LA49_0==CASE) ) {
				alt49=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 49, 0, input);
				throw nvae;
			}

			switch (alt49) {
				case 1 :
					// WreslTree.g:225:5: ( goal_no_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle] -> ^( Goal_no_case TimeArraySize[$ta.text] Scope[$s.text] $i goal_no_case_content ) )
					{
					// WreslTree.g:225:5: ( goal_no_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle] -> ^( Goal_no_case TimeArraySize[$ta.text] Scope[$s.text] $i goal_no_case_content ) )
					// WreslTree.g:225:7: goal_no_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle]
					{
					pushFollow(FOLLOW_goal_no_case_content_in_goal_timeArray_case_or_nocase1765);
					goal_no_case_content147=goal_no_case_content((l!=null?((WreslTreeParser.expression_return)l).text:null), (ta!=null?((WreslTreeParser.timeArraySize_return)ta).dependant:null)+" "+(l!=null?((WreslTreeParser.expression_return)l).dependants:null), (l!=null?((WreslTreeParser.expression_return)l).strVarInCycle:null));
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_goal_no_case_content.add(goal_no_case_content147.getTree());
					// AST REWRITE
					// elements: i, goal_no_case_content
					// token labels: i
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 225:88: -> ^( Goal_no_case TimeArraySize[$ta.text] Scope[$s.text] $i goal_no_case_content )
					{
						// WreslTree.g:225:92: ^( Goal_no_case TimeArraySize[$ta.text] Scope[$s.text] $i goal_no_case_content )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Goal_no_case, "Goal_no_case"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(TimeArraySize, (ta!=null?input.toString(ta.start,ta.stop):null)));
						adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (s!=null?s.getText():null)));
						adaptor.addChild(root_1, stream_i.nextNode());
						adaptor.addChild(root_1, stream_goal_no_case_content.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}

					}
					break;
				case 2 :
					// WreslTree.g:226:7: ( ( goal_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle] )+ -> ^( Goal_case TimeArraySize[$ta.text] Scope[$s.text] $i ( goal_case_content )+ ) )
					{
					// WreslTree.g:226:7: ( ( goal_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle] )+ -> ^( Goal_case TimeArraySize[$ta.text] Scope[$s.text] $i ( goal_case_content )+ ) )
					// WreslTree.g:226:9: ( goal_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle] )+
					{
					// WreslTree.g:226:9: ( goal_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle] )+
					int cnt48=0;
					loop48:
					while (true) {
						int alt48=2;
						int LA48_0 = input.LA(1);
						if ( (LA48_0==CASE) ) {
							alt48=1;
						}

						switch (alt48) {
						case 1 :
							// WreslTree.g:226:9: goal_case_content[$l.text, $ta.dependant+\" \"+$l.dependants, $l.strVarInCycle]
							{
							pushFollow(FOLLOW_goal_case_content_in_goal_timeArray_case_or_nocase1801);
							goal_case_content148=goal_case_content((l!=null?((WreslTreeParser.expression_return)l).text:null), (ta!=null?((WreslTreeParser.timeArraySize_return)ta).dependant:null)+" "+(l!=null?((WreslTreeParser.expression_return)l).dependants:null), (l!=null?((WreslTreeParser.expression_return)l).strVarInCycle:null));
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_goal_case_content.add(goal_case_content148.getTree());
							}
							break;

						default :
							if ( cnt48 >= 1 ) break loop48;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(48, input);
							throw eee;
						}
						cnt48++;
					}

					// AST REWRITE
					// elements: i, goal_case_content
					// token labels: i
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 226:90: -> ^( Goal_case TimeArraySize[$ta.text] Scope[$s.text] $i ( goal_case_content )+ )
					{
						// WreslTree.g:226:94: ^( Goal_case TimeArraySize[$ta.text] Scope[$s.text] $i ( goal_case_content )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Goal_case, "Goal_case"), root_1);
						adaptor.addChild(root_1, (CommonTree)adaptor.create(TimeArraySize, (ta!=null?input.toString(ta.start,ta.stop):null)));
						adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (s!=null?s.getText():null)));
						adaptor.addChild(root_1, stream_i.nextNode());
						if ( !(stream_goal_case_content.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_goal_case_content.hasNext() ) {
							adaptor.addChild(root_1, stream_goal_case_content.nextTree());
						}
						stream_goal_case_content.reset();

						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}

					}
					break;

			}

			char_literal149=(Token)match(input,158,FOLLOW_158_in_goal_timeArray_case_or_nocase1839); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal149);

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "goal_timeArray_case_or_nocase"


	public static class goal_case_content_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goal_case_content"
	// WreslTree.g:230:1: goal_case_content[String l, String d, String vc] : CASE i= IDENT '{' c= condition RHS r= expression (s= sub_content[$l,$r.text] )? '}' -> {s!=null}? ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] $s) -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] Simple Lhs[$l] Op[\"=\"] Rhs[$r.text] ) ;
	public final WreslTreeParser.goal_case_content_return goal_case_content(String l, String d, String vc) throws RecognitionException {
		WreslTreeParser.goal_case_content_return retval = new WreslTreeParser.goal_case_content_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token CASE150=null;
		Token char_literal151=null;
		Token RHS152=null;
		Token char_literal153=null;
		ParserRuleReturnScope c =null;
		ParserRuleReturnScope r =null;
		ParserRuleReturnScope s =null;

		CommonTree i_tree=null;
		CommonTree CASE150_tree=null;
		CommonTree char_literal151_tree=null;
		CommonTree RHS152_tree=null;
		CommonTree char_literal153_tree=null;
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_RHS=new RewriteRuleTokenStream(adaptor,"token RHS");
		RewriteRuleTokenStream stream_CASE=new RewriteRuleTokenStream(adaptor,"token CASE");
		RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_sub_content=new RewriteRuleSubtreeStream(adaptor,"rule sub_content");

		 String varInCycle_nullsRemoved = null; String dependants_nullsRemoved = null; 
		try {
			// WreslTree.g:232:2: ( CASE i= IDENT '{' c= condition RHS r= expression (s= sub_content[$l,$r.text] )? '}' -> {s!=null}? ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] $s) -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] Simple Lhs[$l] Op[\"=\"] Rhs[$r.text] ) )
			// WreslTree.g:232:4: CASE i= IDENT '{' c= condition RHS r= expression (s= sub_content[$l,$r.text] )? '}'
			{
			CASE150=(Token)match(input,CASE,FOLLOW_CASE_in_goal_case_content1858); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_CASE.add(CASE150);

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_goal_case_content1862); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			if ( state.backtracking==0 ) { goal_stack.peek().caseName = (i!=null?i.getText():null);  goal_stack.peek().caseNumber++; }
			char_literal151=(Token)match(input,157,FOLLOW_157_in_goal_case_content1868); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal151);

			pushFollow(FOLLOW_condition_in_goal_case_content1872);
			c=condition();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_condition.add(c.getTree());
			RHS152=(Token)match(input,RHS,FOLLOW_RHS_in_goal_case_content1874); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RHS.add(RHS152);

			pushFollow(FOLLOW_expression_in_goal_case_content1878);
			r=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expression.add(r.getTree());
			// WreslTree.g:233:35: (s= sub_content[$l,$r.text] )?
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==LHS) ) {
				alt50=1;
			}
			switch (alt50) {
				case 1 :
					// WreslTree.g:233:36: s= sub_content[$l,$r.text]
					{
					pushFollow(FOLLOW_sub_content_in_goal_case_content1883);
					s=sub_content(l, (r!=null?((WreslTreeParser.expression_return)r).text:null));
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_sub_content.add(s.getTree());
					}
					break;

			}

			char_literal153=(Token)match(input,158,FOLLOW_158_in_goal_case_content1888); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal153);

			if ( state.backtracking==0 ) { varInCycle_nullsRemoved =   Tools.remove_nulls(vc+" "+(r!=null?((WreslTreeParser.expression_return)r).strVarInCycle:null)+" "+(c!=null?((WreslTreeParser.condition_return)c).varInCycle:null));
				  dependants_nullsRemoved =   Tools.remove_nulls(d+" "+(r!=null?((WreslTreeParser.expression_return)r).dependants:null)+" "+(c!=null?((WreslTreeParser.condition_return)c).dependants:null));   
				}
			// AST REWRITE
			// elements: i, i, s
			// token labels: i
			// rule labels: s, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 237:2: -> {s!=null}? ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] $s)
			if (s!=null) {
				// WreslTree.g:237:16: ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] $s)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Case, "Case"), root_1);
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Condition, (c!=null?((WreslTreeParser.condition_return)c).text:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, dependants_nullsRemoved));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(VarInCycle, varInCycle_nullsRemoved));
				adaptor.addChild(root_1, stream_s.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}

			else // 238:2: -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] Simple Lhs[$l] Op[\"=\"] Rhs[$r.text] )
			{
				// WreslTree.g:238:16: ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] Simple Lhs[$l] Op[\"=\"] Rhs[$r.text] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Case, "Case"), root_1);
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Condition, (c!=null?((WreslTreeParser.condition_return)c).text:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, dependants_nullsRemoved));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(VarInCycle, varInCycle_nullsRemoved));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Simple, "Simple"));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Lhs, l));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Op, "="));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Rhs, (r!=null?((WreslTreeParser.expression_return)r).text:null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "goal_case_content"


	public static class goal_no_case_content_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goal_no_case_content"
	// WreslTree.g:241:1: goal_no_case_content[String l, String d, String vc] : RHS r= expression (s= sub_content[$l,$r.text] )? -> {s!=null}? Dependants[$d+\" \"+$r.dependants] VarInCycle[$vc+\" \"+$r.strVarInCycle] $s -> Dependants[$d+\" \"+$r.dependants] VarInCycle[$vc+\" \"+$r.strVarInCycle] Simple Lhs[$l] Op[\"=\"] Rhs[$r.text] ;
	public final WreslTreeParser.goal_no_case_content_return goal_no_case_content(String l, String d, String vc) throws RecognitionException {
		WreslTreeParser.goal_no_case_content_return retval = new WreslTreeParser.goal_no_case_content_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token RHS154=null;
		ParserRuleReturnScope r =null;
		ParserRuleReturnScope s =null;

		CommonTree RHS154_tree=null;
		RewriteRuleTokenStream stream_RHS=new RewriteRuleTokenStream(adaptor,"token RHS");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_sub_content=new RewriteRuleSubtreeStream(adaptor,"rule sub_content");

		 goal_stack.peek().caseName = "default";   goal_stack.peek().caseNumber =1;
		try {
			// WreslTree.g:243:2: ( RHS r= expression (s= sub_content[$l,$r.text] )? -> {s!=null}? Dependants[$d+\" \"+$r.dependants] VarInCycle[$vc+\" \"+$r.strVarInCycle] $s -> Dependants[$d+\" \"+$r.dependants] VarInCycle[$vc+\" \"+$r.strVarInCycle] Simple Lhs[$l] Op[\"=\"] Rhs[$r.text] )
			// WreslTree.g:243:4: RHS r= expression (s= sub_content[$l,$r.text] )?
			{
			RHS154=(Token)match(input,RHS,FOLLOW_RHS_in_goal_no_case_content1977); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RHS.add(RHS154);

			pushFollow(FOLLOW_expression_in_goal_no_case_content1981);
			r=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expression.add(r.getTree());
			// WreslTree.g:243:21: (s= sub_content[$l,$r.text] )?
			int alt51=2;
			int LA51_0 = input.LA(1);
			if ( (LA51_0==LHS) ) {
				alt51=1;
			}
			switch (alt51) {
				case 1 :
					// WreslTree.g:243:22: s= sub_content[$l,$r.text]
					{
					pushFollow(FOLLOW_sub_content_in_goal_no_case_content1986);
					s=sub_content(l, (r!=null?((WreslTreeParser.expression_return)r).text:null));
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_sub_content.add(s.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: s
			// token labels: 
			// rule labels: s, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_s=new RewriteRuleSubtreeStream(adaptor,"rule s",s!=null?s.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 244:8: -> {s!=null}? Dependants[$d+\" \"+$r.dependants] VarInCycle[$vc+\" \"+$r.strVarInCycle] $s
			if (s!=null) {
				adaptor.addChild(root_0, (CommonTree)adaptor.create(Dependants, d+" "+(r!=null?((WreslTreeParser.expression_return)r).dependants:null)));
				adaptor.addChild(root_0, (CommonTree)adaptor.create(VarInCycle, vc+" "+(r!=null?((WreslTreeParser.expression_return)r).strVarInCycle:null)));
				adaptor.addChild(root_0, stream_s.nextTree());
			}

			else // 245:8: -> Dependants[$d+\" \"+$r.dependants] VarInCycle[$vc+\" \"+$r.strVarInCycle] Simple Lhs[$l] Op[\"=\"] Rhs[$r.text]
			{
				adaptor.addChild(root_0, (CommonTree)adaptor.create(Dependants, d+" "+(r!=null?((WreslTreeParser.expression_return)r).dependants:null)));
				adaptor.addChild(root_0, (CommonTree)adaptor.create(VarInCycle, vc+" "+(r!=null?((WreslTreeParser.expression_return)r).strVarInCycle:null)));
				adaptor.addChild(root_0, (CommonTree)adaptor.create(Simple, "Simple"));
				adaptor.addChild(root_0, (CommonTree)adaptor.create(Lhs, l));
				adaptor.addChild(root_0, (CommonTree)adaptor.create(Op, "="));
				adaptor.addChild(root_0, (CommonTree)adaptor.create(Rhs, (r!=null?((WreslTreeParser.expression_return)r).text:null)));
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "goal_no_case_content"


	public static class sub_content_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "sub_content"
	// WreslTree.g:248:1: sub_content[String l, String r] : ( (a= lhs_gt_rhs[$l,$r] (b= lhs_lt_rhs[$l,$r] )? -> {b==null}? One[$a.type] $a -> Two[$a.type+$b.type] $a $b) | (c= lhs_lt_rhs[$l,$r] (d= lhs_gt_rhs[$l,$r] -> Two[$c.type+$d.type] $c $d)? -> {d==null}? One[$c.type] $c -> Two[$c.type+$d.type] $c $d) );
	public final WreslTreeParser.sub_content_return sub_content(String l, String r) throws RecognitionException {
		WreslTreeParser.sub_content_return retval = new WreslTreeParser.sub_content_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope a =null;
		ParserRuleReturnScope b =null;
		ParserRuleReturnScope c =null;
		ParserRuleReturnScope d =null;

		RewriteRuleSubtreeStream stream_lhs_gt_rhs=new RewriteRuleSubtreeStream(adaptor,"rule lhs_gt_rhs");
		RewriteRuleSubtreeStream stream_lhs_lt_rhs=new RewriteRuleSubtreeStream(adaptor,"rule lhs_lt_rhs");

		try {
			// WreslTree.g:249:2: ( (a= lhs_gt_rhs[$l,$r] (b= lhs_lt_rhs[$l,$r] )? -> {b==null}? One[$a.type] $a -> Two[$a.type+$b.type] $a $b) | (c= lhs_lt_rhs[$l,$r] (d= lhs_gt_rhs[$l,$r] -> Two[$c.type+$d.type] $c $d)? -> {d==null}? One[$c.type] $c -> Two[$c.type+$d.type] $c $d) )
			int alt54=2;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==LHS) ) {
				int LA54_1 = input.LA(2);
				if ( (LA54_1==151) ) {
					alt54=1;
				}
				else if ( (LA54_1==147) ) {
					alt54=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 54, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 54, 0, input);
				throw nvae;
			}

			switch (alt54) {
				case 1 :
					// WreslTree.g:249:4: (a= lhs_gt_rhs[$l,$r] (b= lhs_lt_rhs[$l,$r] )? -> {b==null}? One[$a.type] $a -> Two[$a.type+$b.type] $a $b)
					{
					// WreslTree.g:249:4: (a= lhs_gt_rhs[$l,$r] (b= lhs_lt_rhs[$l,$r] )? -> {b==null}? One[$a.type] $a -> Two[$a.type+$b.type] $a $b)
					// WreslTree.g:249:6: a= lhs_gt_rhs[$l,$r] (b= lhs_lt_rhs[$l,$r] )?
					{
					pushFollow(FOLLOW_lhs_gt_rhs_in_sub_content2072);
					a=lhs_gt_rhs(l, r);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_lhs_gt_rhs.add(a.getTree());
					// WreslTree.g:249:26: (b= lhs_lt_rhs[$l,$r] )?
					int alt52=2;
					int LA52_0 = input.LA(1);
					if ( (LA52_0==LHS) ) {
						alt52=1;
					}
					switch (alt52) {
						case 1 :
							// WreslTree.g:249:28: b= lhs_lt_rhs[$l,$r]
							{
							pushFollow(FOLLOW_lhs_lt_rhs_in_sub_content2079);
							b=lhs_lt_rhs(l, r);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_lhs_lt_rhs.add(b.getTree());
							}
							break;

					}

					// AST REWRITE
					// elements: a, b, a
					// token labels: 
					// rule labels: a, b, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_a=new RewriteRuleSubtreeStream(adaptor,"rule a",a!=null?a.getTree():null);
					RewriteRuleSubtreeStream stream_b=new RewriteRuleSubtreeStream(adaptor,"rule b",b!=null?b.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 250:3: -> {b==null}? One[$a.type] $a
					if (b==null) {
						adaptor.addChild(root_0, (CommonTree)adaptor.create(One, (a!=null?((WreslTreeParser.lhs_gt_rhs_return)a).type:null)));
						adaptor.addChild(root_0, stream_a.nextTree());
					}

					else // 251:3: -> Two[$a.type+$b.type] $a $b
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Two, (a!=null?((WreslTreeParser.lhs_gt_rhs_return)a).type:null)+(b!=null?((WreslTreeParser.lhs_lt_rhs_return)b).type:null)));
						adaptor.addChild(root_0, stream_a.nextTree());
						adaptor.addChild(root_0, stream_b.nextTree());
					}


					retval.tree = root_0;
					}

					}

					}
					break;
				case 2 :
					// WreslTree.g:254:4: (c= lhs_lt_rhs[$l,$r] (d= lhs_gt_rhs[$l,$r] -> Two[$c.type+$d.type] $c $d)? -> {d==null}? One[$c.type] $c -> Two[$c.type+$d.type] $c $d)
					{
					// WreslTree.g:254:4: (c= lhs_lt_rhs[$l,$r] (d= lhs_gt_rhs[$l,$r] -> Two[$c.type+$d.type] $c $d)? -> {d==null}? One[$c.type] $c -> Two[$c.type+$d.type] $c $d)
					// WreslTree.g:254:6: c= lhs_lt_rhs[$l,$r] (d= lhs_gt_rhs[$l,$r] -> Two[$c.type+$d.type] $c $d)?
					{
					pushFollow(FOLLOW_lhs_lt_rhs_in_sub_content2136);
					c=lhs_lt_rhs(l, r);
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_lhs_lt_rhs.add(c.getTree());
					// WreslTree.g:254:26: (d= lhs_gt_rhs[$l,$r] -> Two[$c.type+$d.type] $c $d)?
					int alt53=2;
					int LA53_0 = input.LA(1);
					if ( (LA53_0==LHS) ) {
						alt53=1;
					}
					switch (alt53) {
						case 1 :
							// WreslTree.g:254:28: d= lhs_gt_rhs[$l,$r]
							{
							pushFollow(FOLLOW_lhs_gt_rhs_in_sub_content2143);
							d=lhs_gt_rhs(l, r);
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) stream_lhs_gt_rhs.add(d.getTree());
							// AST REWRITE
							// elements: d, c
							// token labels: 
							// rule labels: c, d, retval
							// token list labels: 
							// rule list labels: 
							// wildcard labels: 
							if ( state.backtracking==0 ) {
							retval.tree = root_0;
							RewriteRuleSubtreeStream stream_c=new RewriteRuleSubtreeStream(adaptor,"rule c",c!=null?c.getTree():null);
							RewriteRuleSubtreeStream stream_d=new RewriteRuleSubtreeStream(adaptor,"rule d",d!=null?d.getTree():null);
							RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

							root_0 = (CommonTree)adaptor.nil();
							// 254:48: -> Two[$c.type+$d.type] $c $d
							{
								adaptor.addChild(root_0, (CommonTree)adaptor.create(Two, (c!=null?((WreslTreeParser.lhs_lt_rhs_return)c).type:null)+(d!=null?((WreslTreeParser.lhs_gt_rhs_return)d).type:null)));
								adaptor.addChild(root_0, stream_c.nextTree());
								adaptor.addChild(root_0, stream_d.nextTree());
							}


							retval.tree = root_0;
							}

							}
							break;

					}

					// AST REWRITE
					// elements: c, d, c
					// token labels: 
					// rule labels: c, d, retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_c=new RewriteRuleSubtreeStream(adaptor,"rule c",c!=null?c.getTree():null);
					RewriteRuleSubtreeStream stream_d=new RewriteRuleSubtreeStream(adaptor,"rule d",d!=null?d.getTree():null);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 255:3: -> {d==null}? One[$c.type] $c
					if (d==null) {
						adaptor.addChild(root_0, (CommonTree)adaptor.create(One, (c!=null?((WreslTreeParser.lhs_lt_rhs_return)c).type:null)));
						adaptor.addChild(root_0, stream_c.nextTree());
					}

					else // 256:3: -> Two[$c.type+$d.type] $c $d
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Two, (c!=null?((WreslTreeParser.lhs_lt_rhs_return)c).type:null)+(d!=null?((WreslTreeParser.lhs_gt_rhs_return)d).type:null)));
						adaptor.addChild(root_0, stream_c.nextTree());
						adaptor.addChild(root_0, stream_d.nextTree());
					}


					retval.tree = root_0;
					}

					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "sub_content"


	public static class lhs_gt_rhs_return extends ParserRuleReturnScope {
		public String type;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lhs_gt_rhs"
	// WreslTree.g:260:1: lhs_gt_rhs[String l, String r] returns [String type] : LHS '>' RHS ( ( CONSTRAIN -> Constrain Lhs[$l] Op[\"<\"] Rhs[$r] ) | (p= penalty -> {$p.isZero}? Free Lhs[$l] Op[\">\"] Rhs[$r] -> Penalty Lhs[$l] Op[\"=\"] Rhs[$r] Sign[\"-\"] Kind[\"surplus\"] Slack_Surplus[\"surplus__\"+$goal::goalName+\"_\"+Integer.toString($goal::caseNumber)] Weight[penalty2Weight] ) ) ;
	public final WreslTreeParser.lhs_gt_rhs_return lhs_gt_rhs(String l, String r) throws RecognitionException {
		WreslTreeParser.lhs_gt_rhs_return retval = new WreslTreeParser.lhs_gt_rhs_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LHS155=null;
		Token char_literal156=null;
		Token RHS157=null;
		Token CONSTRAIN158=null;
		ParserRuleReturnScope p =null;

		CommonTree LHS155_tree=null;
		CommonTree char_literal156_tree=null;
		CommonTree RHS157_tree=null;
		CommonTree CONSTRAIN158_tree=null;
		RewriteRuleTokenStream stream_CONSTRAIN=new RewriteRuleTokenStream(adaptor,"token CONSTRAIN");
		RewriteRuleTokenStream stream_LHS=new RewriteRuleTokenStream(adaptor,"token LHS");
		RewriteRuleTokenStream stream_RHS=new RewriteRuleTokenStream(adaptor,"token RHS");
		RewriteRuleTokenStream stream_151=new RewriteRuleTokenStream(adaptor,"token 151");
		RewriteRuleSubtreeStream stream_penalty=new RewriteRuleSubtreeStream(adaptor,"rule penalty");

		 String penalty2Weight = "";
		try {
			// WreslTree.g:262:2: ( LHS '>' RHS ( ( CONSTRAIN -> Constrain Lhs[$l] Op[\"<\"] Rhs[$r] ) | (p= penalty -> {$p.isZero}? Free Lhs[$l] Op[\">\"] Rhs[$r] -> Penalty Lhs[$l] Op[\"=\"] Rhs[$r] Sign[\"-\"] Kind[\"surplus\"] Slack_Surplus[\"surplus__\"+$goal::goalName+\"_\"+Integer.toString($goal::caseNumber)] Weight[penalty2Weight] ) ) )
			// WreslTree.g:263:1: LHS '>' RHS ( ( CONSTRAIN -> Constrain Lhs[$l] Op[\"<\"] Rhs[$r] ) | (p= penalty -> {$p.isZero}? Free Lhs[$l] Op[\">\"] Rhs[$r] -> Penalty Lhs[$l] Op[\"=\"] Rhs[$r] Sign[\"-\"] Kind[\"surplus\"] Slack_Surplus[\"surplus__\"+$goal::goalName+\"_\"+Integer.toString($goal::caseNumber)] Weight[penalty2Weight] ) )
			{
			LHS155=(Token)match(input,LHS,FOLLOW_LHS_in_lhs_gt_rhs2224); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LHS.add(LHS155);

			char_literal156=(Token)match(input,151,FOLLOW_151_in_lhs_gt_rhs2226); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_151.add(char_literal156);

			RHS157=(Token)match(input,RHS,FOLLOW_RHS_in_lhs_gt_rhs2228); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RHS.add(RHS157);

			// WreslTree.g:264:2: ( ( CONSTRAIN -> Constrain Lhs[$l] Op[\"<\"] Rhs[$r] ) | (p= penalty -> {$p.isZero}? Free Lhs[$l] Op[\">\"] Rhs[$r] -> Penalty Lhs[$l] Op[\"=\"] Rhs[$r] Sign[\"-\"] Kind[\"surplus\"] Slack_Surplus[\"surplus__\"+$goal::goalName+\"_\"+Integer.toString($goal::caseNumber)] Weight[penalty2Weight] ) )
			int alt55=2;
			int LA55_0 = input.LA(1);
			if ( (LA55_0==CONSTRAIN) ) {
				alt55=1;
			}
			else if ( (LA55_0==PENALTY) ) {
				alt55=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 55, 0, input);
				throw nvae;
			}

			switch (alt55) {
				case 1 :
					// WreslTree.g:264:4: ( CONSTRAIN -> Constrain Lhs[$l] Op[\"<\"] Rhs[$r] )
					{
					// WreslTree.g:264:4: ( CONSTRAIN -> Constrain Lhs[$l] Op[\"<\"] Rhs[$r] )
					// WreslTree.g:264:6: CONSTRAIN
					{
					CONSTRAIN158=(Token)match(input,CONSTRAIN,FOLLOW_CONSTRAIN_in_lhs_gt_rhs2236); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CONSTRAIN.add(CONSTRAIN158);

					if ( state.backtracking==0 ) { retval.type = "c"; }
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 264:34: -> Constrain Lhs[$l] Op[\"<\"] Rhs[$r]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Constrain, "Constrain"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Lhs, l));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Op, "<"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Rhs, r));
					}


					retval.tree = root_0;
					}

					}

					}
					break;
				case 2 :
					// WreslTree.g:265:4: (p= penalty -> {$p.isZero}? Free Lhs[$l] Op[\">\"] Rhs[$r] -> Penalty Lhs[$l] Op[\"=\"] Rhs[$r] Sign[\"-\"] Kind[\"surplus\"] Slack_Surplus[\"surplus__\"+$goal::goalName+\"_\"+Integer.toString($goal::caseNumber)] Weight[penalty2Weight] )
					{
					// WreslTree.g:265:4: (p= penalty -> {$p.isZero}? Free Lhs[$l] Op[\">\"] Rhs[$r] -> Penalty Lhs[$l] Op[\"=\"] Rhs[$r] Sign[\"-\"] Kind[\"surplus\"] Slack_Surplus[\"surplus__\"+$goal::goalName+\"_\"+Integer.toString($goal::caseNumber)] Weight[penalty2Weight] )
					// WreslTree.g:265:6: p= penalty
					{
					pushFollow(FOLLOW_penalty_in_lhs_gt_rhs2263);
					p=penalty();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_penalty.add(p.getTree());
					if ( state.backtracking==0 ) { 
										if      ((p!=null?((WreslTreeParser.penalty_return)p).isZero:false))       { retval.type = "f";   }
										else if ((p!=null?((WreslTreeParser.penalty_return)p).isNegative:false))   { retval.type = "p"; penalty2Weight = (p!=null?((WreslTreeParser.penalty_return)p).w:null); }
										else 		              { retval.type = "p"; penalty2Weight = "-"+(p!=null?((WreslTreeParser.penalty_return)p).w:null); }
									  }
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 270:3: -> {$p.isZero}? Free Lhs[$l] Op[\">\"] Rhs[$r]
					if ((p!=null?((WreslTreeParser.penalty_return)p).isZero:false)) {
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Free, "Free"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Lhs, l));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Op, ">"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Rhs, r));
					}

					else // 271:3: -> Penalty Lhs[$l] Op[\"=\"] Rhs[$r] Sign[\"-\"] Kind[\"surplus\"] Slack_Surplus[\"surplus__\"+$goal::goalName+\"_\"+Integer.toString($goal::caseNumber)] Weight[penalty2Weight]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Penalty, "Penalty"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Lhs, l));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Op, "="));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Rhs, r));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Sign, "-"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Kind, "surplus"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Slack_Surplus, "surplus__"+goal_stack.peek().goalName+"_"+Integer.toString(goal_stack.peek().caseNumber)));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Weight, penalty2Weight));
					}


					retval.tree = root_0;
					}

					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "lhs_gt_rhs"


	public static class lhs_lt_rhs_return extends ParserRuleReturnScope {
		public String type;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lhs_lt_rhs"
	// WreslTree.g:276:1: lhs_lt_rhs[String l, String r] returns [String type] : LHS '<' RHS ( ( CONSTRAIN -> Constrain Lhs[$l] Op[\">\"] Rhs[$r] ) | (p= penalty -> {$p.isZero}? Free Lhs[$l] Op[\"<\"] Rhs[$r] -> Penalty Lhs[$l] Op[\"=\"] Rhs[$r] Sign[\"+\"] Kind[\"slack\"] Slack_Surplus[\"slack__\"+$goal::goalName+\"_\"+Integer.toString($goal::caseNumber)] Weight[penalty2Weight] ) ) ;
	public final WreslTreeParser.lhs_lt_rhs_return lhs_lt_rhs(String l, String r) throws RecognitionException {
		WreslTreeParser.lhs_lt_rhs_return retval = new WreslTreeParser.lhs_lt_rhs_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LHS159=null;
		Token char_literal160=null;
		Token RHS161=null;
		Token CONSTRAIN162=null;
		ParserRuleReturnScope p =null;

		CommonTree LHS159_tree=null;
		CommonTree char_literal160_tree=null;
		CommonTree RHS161_tree=null;
		CommonTree CONSTRAIN162_tree=null;
		RewriteRuleTokenStream stream_CONSTRAIN=new RewriteRuleTokenStream(adaptor,"token CONSTRAIN");
		RewriteRuleTokenStream stream_147=new RewriteRuleTokenStream(adaptor,"token 147");
		RewriteRuleTokenStream stream_LHS=new RewriteRuleTokenStream(adaptor,"token LHS");
		RewriteRuleTokenStream stream_RHS=new RewriteRuleTokenStream(adaptor,"token RHS");
		RewriteRuleSubtreeStream stream_penalty=new RewriteRuleSubtreeStream(adaptor,"rule penalty");

		 String penalty2Weight = "";
		try {
			// WreslTree.g:278:2: ( LHS '<' RHS ( ( CONSTRAIN -> Constrain Lhs[$l] Op[\">\"] Rhs[$r] ) | (p= penalty -> {$p.isZero}? Free Lhs[$l] Op[\"<\"] Rhs[$r] -> Penalty Lhs[$l] Op[\"=\"] Rhs[$r] Sign[\"+\"] Kind[\"slack\"] Slack_Surplus[\"slack__\"+$goal::goalName+\"_\"+Integer.toString($goal::caseNumber)] Weight[penalty2Weight] ) ) )
			// WreslTree.g:279:1: LHS '<' RHS ( ( CONSTRAIN -> Constrain Lhs[$l] Op[\">\"] Rhs[$r] ) | (p= penalty -> {$p.isZero}? Free Lhs[$l] Op[\"<\"] Rhs[$r] -> Penalty Lhs[$l] Op[\"=\"] Rhs[$r] Sign[\"+\"] Kind[\"slack\"] Slack_Surplus[\"slack__\"+$goal::goalName+\"_\"+Integer.toString($goal::caseNumber)] Weight[penalty2Weight] ) )
			{
			LHS159=(Token)match(input,LHS,FOLLOW_LHS_in_lhs_lt_rhs2358); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LHS.add(LHS159);

			char_literal160=(Token)match(input,147,FOLLOW_147_in_lhs_lt_rhs2360); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_147.add(char_literal160);

			RHS161=(Token)match(input,RHS,FOLLOW_RHS_in_lhs_lt_rhs2362); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_RHS.add(RHS161);

			// WreslTree.g:280:2: ( ( CONSTRAIN -> Constrain Lhs[$l] Op[\">\"] Rhs[$r] ) | (p= penalty -> {$p.isZero}? Free Lhs[$l] Op[\"<\"] Rhs[$r] -> Penalty Lhs[$l] Op[\"=\"] Rhs[$r] Sign[\"+\"] Kind[\"slack\"] Slack_Surplus[\"slack__\"+$goal::goalName+\"_\"+Integer.toString($goal::caseNumber)] Weight[penalty2Weight] ) )
			int alt56=2;
			int LA56_0 = input.LA(1);
			if ( (LA56_0==CONSTRAIN) ) {
				alt56=1;
			}
			else if ( (LA56_0==PENALTY) ) {
				alt56=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 56, 0, input);
				throw nvae;
			}

			switch (alt56) {
				case 1 :
					// WreslTree.g:280:4: ( CONSTRAIN -> Constrain Lhs[$l] Op[\">\"] Rhs[$r] )
					{
					// WreslTree.g:280:4: ( CONSTRAIN -> Constrain Lhs[$l] Op[\">\"] Rhs[$r] )
					// WreslTree.g:280:6: CONSTRAIN
					{
					CONSTRAIN162=(Token)match(input,CONSTRAIN,FOLLOW_CONSTRAIN_in_lhs_lt_rhs2370); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CONSTRAIN.add(CONSTRAIN162);

					if ( state.backtracking==0 ) { retval.type = "c"; }
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 280:34: -> Constrain Lhs[$l] Op[\">\"] Rhs[$r]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Constrain, "Constrain"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Lhs, l));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Op, ">"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Rhs, r));
					}


					retval.tree = root_0;
					}

					}

					}
					break;
				case 2 :
					// WreslTree.g:281:4: (p= penalty -> {$p.isZero}? Free Lhs[$l] Op[\"<\"] Rhs[$r] -> Penalty Lhs[$l] Op[\"=\"] Rhs[$r] Sign[\"+\"] Kind[\"slack\"] Slack_Surplus[\"slack__\"+$goal::goalName+\"_\"+Integer.toString($goal::caseNumber)] Weight[penalty2Weight] )
					{
					// WreslTree.g:281:4: (p= penalty -> {$p.isZero}? Free Lhs[$l] Op[\"<\"] Rhs[$r] -> Penalty Lhs[$l] Op[\"=\"] Rhs[$r] Sign[\"+\"] Kind[\"slack\"] Slack_Surplus[\"slack__\"+$goal::goalName+\"_\"+Integer.toString($goal::caseNumber)] Weight[penalty2Weight] )
					// WreslTree.g:281:6: p= penalty
					{
					pushFollow(FOLLOW_penalty_in_lhs_lt_rhs2396);
					p=penalty();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_penalty.add(p.getTree());
					if ( state.backtracking==0 ) { 
										if      ((p!=null?((WreslTreeParser.penalty_return)p).isZero:false))       { retval.type = "f";   }
										else if ((p!=null?((WreslTreeParser.penalty_return)p).isNegative:false))   { retval.type = "p"; penalty2Weight = (p!=null?((WreslTreeParser.penalty_return)p).w:null); }
										else 		              { retval.type = "p"; penalty2Weight = "-"+(p!=null?((WreslTreeParser.penalty_return)p).w:null); }					
									  }
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 286:3: -> {$p.isZero}? Free Lhs[$l] Op[\"<\"] Rhs[$r]
					if ((p!=null?((WreslTreeParser.penalty_return)p).isZero:false)) {
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Free, "Free"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Lhs, l));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Op, "<"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Rhs, r));
					}

					else // 287:3: -> Penalty Lhs[$l] Op[\"=\"] Rhs[$r] Sign[\"+\"] Kind[\"slack\"] Slack_Surplus[\"slack__\"+$goal::goalName+\"_\"+Integer.toString($goal::caseNumber)] Weight[penalty2Weight]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Penalty, "Penalty"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Lhs, l));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Op, "="));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Rhs, r));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Sign, "+"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Kind, "slack"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Slack_Surplus, "slack__"+goal_stack.peek().goalName+"_"+Integer.toString(goal_stack.peek().caseNumber)));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Weight, penalty2Weight));
					}


					retval.tree = root_0;
					}

					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "lhs_lt_rhs"


	public static class penalty_return extends ParserRuleReturnScope {
		public String w;
		public boolean isZero;
		public boolean isNegative;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "penalty"
	// WreslTree.g:292:1: penalty returns [String w, boolean isZero, boolean isNegative] : PENALTY n= expression ;
	public final WreslTreeParser.penalty_return penalty() throws RecognitionException {
		WreslTreeParser.penalty_return retval = new WreslTreeParser.penalty_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token PENALTY163=null;
		ParserRuleReturnScope n =null;

		CommonTree PENALTY163_tree=null;

		try {
			// WreslTree.g:293:2: ( PENALTY n= expression )
			// WreslTree.g:293:4: PENALTY n= expression
			{
			root_0 = (CommonTree)adaptor.nil();


			PENALTY163=(Token)match(input,PENALTY,FOLLOW_PENALTY_in_penalty2479); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			PENALTY163_tree = (CommonTree)adaptor.create(PENALTY163);
			adaptor.addChild(root_0, PENALTY163_tree);
			}

			pushFollow(FOLLOW_expression_in_penalty2483);
			n=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, n.getTree());

			if ( state.backtracking==0 ) {	retval.w =(n!=null?((WreslTreeParser.expression_return)n).text:null); 
						retval.isZero = false;
						retval.isNegative = false;
						
						try { 
							double p = Double.parseDouble((n!=null?((WreslTreeParser.expression_return)n).text:null)); 
							if      ( p == 0 ) { retval.isZero = true;     retval.w = "0";}
							else if ( p < 0  ) { retval.isNegative = true; retval.w = (n!=null?((WreslTreeParser.expression_return)n).text:null).replace("-","");} 
							else               { retval.w = (n!=null?((WreslTreeParser.expression_return)n).text:null);} 
						}
						catch (Exception e) { 
						
							retval.w = "("+(n!=null?((WreslTreeParser.expression_return)n).text:null)+")";
			//				String ptext=(n!=null?((WreslTreeParser.expression_return)n).text:null);
			//				Integer lineNumber=$pt.getLine();
			//				Integer columnNumber=$pt.getCharPositionInLine();
			//				if (ptext.substring(0,1).equals("-")) {
			//					retval.isNegative = true;
			//				    retval.w = ptext.substring(1,ptext.length());
			//				}
						}
					}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "penalty"


	public static class svar_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar"
	// WreslTree.g:317:1: svar : DEFINE ! ( svar_dss | svar_expr | svar_sum | svar_table | svar_case ) ;
	public final WreslTreeParser.svar_return svar() throws RecognitionException {
		WreslTreeParser.svar_return retval = new WreslTreeParser.svar_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DEFINE164=null;
		ParserRuleReturnScope svar_dss165 =null;
		ParserRuleReturnScope svar_expr166 =null;
		ParserRuleReturnScope svar_sum167 =null;
		ParserRuleReturnScope svar_table168 =null;
		ParserRuleReturnScope svar_case169 =null;

		CommonTree DEFINE164_tree=null;

		try {
			// WreslTree.g:317:6: ( DEFINE ! ( svar_dss | svar_expr | svar_sum | svar_table | svar_case ) )
			// WreslTree.g:317:8: DEFINE ! ( svar_dss | svar_expr | svar_sum | svar_table | svar_case )
			{
			root_0 = (CommonTree)adaptor.nil();


			DEFINE164=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_svar2497); if (state.failed) return retval;
			// WreslTree.g:317:16: ( svar_dss | svar_expr | svar_sum | svar_table | svar_case )
			int alt57=5;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==153) ) {
				int LA57_1 = input.LA(2);
				if ( (LA57_1==LOCAL) ) {
					int LA57_3 = input.LA(3);
					if ( (LA57_3==154) ) {
						int LA57_6 = input.LA(4);
						if ( (LA57_6==IDENT) ) {
							int LA57_2 = input.LA(5);
							if ( (LA57_2==157) ) {
								switch ( input.LA(6) ) {
								case TIMESERIES:
									{
									alt57=1;
									}
									break;
								case VALUE:
									{
									alt57=2;
									}
									break;
								case SUM:
									{
									alt57=3;
									}
									break;
								case SELECT:
									{
									alt57=4;
									}
									break;
								case CASE:
									{
									alt57=5;
									}
									break;
								default:
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 57, 5, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 57, 2, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 57, 6, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 57, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA57_1==154) ) {
					int LA57_4 = input.LA(3);
					if ( (LA57_4==IDENT) ) {
						int LA57_7 = input.LA(4);
						if ( (LA57_7==157) ) {
							int LA57_13 = input.LA(5);
							if ( (LA57_13==SELECT) ) {
								alt57=4;
							}
							else if ( (LA57_13==CASE) ) {
								alt57=5;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 57, 13, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 57, 7, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 57, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 57, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA57_0==IDENT) ) {
				int LA57_2 = input.LA(2);
				if ( (LA57_2==157) ) {
					switch ( input.LA(3) ) {
					case TIMESERIES:
						{
						alt57=1;
						}
						break;
					case VALUE:
						{
						alt57=2;
						}
						break;
					case SUM:
						{
						alt57=3;
						}
						break;
					case SELECT:
						{
						alt57=4;
						}
						break;
					case CASE:
						{
						alt57=5;
						}
						break;
					default:
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 57, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 57, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 57, 0, input);
				throw nvae;
			}

			switch (alt57) {
				case 1 :
					// WreslTree.g:317:17: svar_dss
					{
					pushFollow(FOLLOW_svar_dss_in_svar2501);
					svar_dss165=svar_dss();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_dss165.getTree());

					}
					break;
				case 2 :
					// WreslTree.g:317:28: svar_expr
					{
					pushFollow(FOLLOW_svar_expr_in_svar2505);
					svar_expr166=svar_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_expr166.getTree());

					}
					break;
				case 3 :
					// WreslTree.g:317:40: svar_sum
					{
					pushFollow(FOLLOW_svar_sum_in_svar2509);
					svar_sum167=svar_sum();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_sum167.getTree());

					}
					break;
				case 4 :
					// WreslTree.g:317:51: svar_table
					{
					pushFollow(FOLLOW_svar_table_in_svar2513);
					svar_table168=svar_table();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_table168.getTree());

					}
					break;
				case 5 :
					// WreslTree.g:317:64: svar_case
					{
					pushFollow(FOLLOW_svar_case_in_svar2517);
					svar_case169=svar_case();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_case169.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "svar"


	public static class svar_timeArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_timeArray"
	// WreslTree.g:319:1: svar_timeArray : DEFINE ! ( svar_timeArray_expr | svar_timeArray_case | svar_timeArray_table | svar_timeArray_sum ) ;
	public final WreslTreeParser.svar_timeArray_return svar_timeArray() throws RecognitionException {
		WreslTreeParser.svar_timeArray_return retval = new WreslTreeParser.svar_timeArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DEFINE170=null;
		ParserRuleReturnScope svar_timeArray_expr171 =null;
		ParserRuleReturnScope svar_timeArray_case172 =null;
		ParserRuleReturnScope svar_timeArray_table173 =null;
		ParserRuleReturnScope svar_timeArray_sum174 =null;

		CommonTree DEFINE170_tree=null;

		try {
			// WreslTree.g:319:16: ( DEFINE ! ( svar_timeArray_expr | svar_timeArray_case | svar_timeArray_table | svar_timeArray_sum ) )
			// WreslTree.g:319:19: DEFINE ! ( svar_timeArray_expr | svar_timeArray_case | svar_timeArray_table | svar_timeArray_sum )
			{
			root_0 = (CommonTree)adaptor.nil();


			DEFINE170=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_svar_timeArray2529); if (state.failed) return retval;
			// WreslTree.g:319:27: ( svar_timeArray_expr | svar_timeArray_case | svar_timeArray_table | svar_timeArray_sum )
			int alt58=4;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==139) ) {
				int LA58_1 = input.LA(2);
				if ( (LA58_1==INTEGER) ) {
					int LA58_2 = input.LA(3);
					if ( (LA58_2==140) ) {
						int LA58_4 = input.LA(4);
						if ( (LA58_4==153) ) {
							int LA58_5 = input.LA(5);
							if ( (LA58_5==LOCAL) ) {
								int LA58_7 = input.LA(6);
								if ( (LA58_7==154) ) {
									int LA58_10 = input.LA(7);
									if ( (LA58_10==IDENT) ) {
										int LA58_6 = input.LA(8);
										if ( (LA58_6==157) ) {
											switch ( input.LA(9) ) {
											case VALUE:
												{
												alt58=1;
												}
												break;
											case CASE:
												{
												alt58=2;
												}
												break;
											case SELECT:
												{
												alt58=3;
												}
												break;
											case SUM:
												{
												alt58=4;
												}
												break;
											default:
												if (state.backtracking>0) {state.failed=true; return retval;}
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 58, 9, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}
										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 58, 6, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 58, 10, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 58, 7, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}
							else if ( (LA58_5==154) ) {
								int LA58_8 = input.LA(6);
								if ( (LA58_8==IDENT) ) {
									int LA58_11 = input.LA(7);
									if ( (LA58_11==157) ) {
										int LA58_16 = input.LA(8);
										if ( (LA58_16==CASE) ) {
											alt58=2;
										}
										else if ( (LA58_16==SELECT) ) {
											alt58=3;
										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 58, 16, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 58, 11, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 58, 8, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 58, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}
						else if ( (LA58_4==IDENT) ) {
							int LA58_6 = input.LA(5);
							if ( (LA58_6==157) ) {
								switch ( input.LA(6) ) {
								case VALUE:
									{
									alt58=1;
									}
									break;
								case CASE:
									{
									alt58=2;
									}
									break;
								case SELECT:
									{
									alt58=3;
									}
									break;
								case SUM:
									{
									alt58=4;
									}
									break;
								default:
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 58, 9, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 58, 6, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 58, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 58, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA58_1==IDENT) ) {
					int LA58_3 = input.LA(3);
					if ( (LA58_3==140) ) {
						int LA58_4 = input.LA(4);
						if ( (LA58_4==153) ) {
							int LA58_5 = input.LA(5);
							if ( (LA58_5==LOCAL) ) {
								int LA58_7 = input.LA(6);
								if ( (LA58_7==154) ) {
									int LA58_10 = input.LA(7);
									if ( (LA58_10==IDENT) ) {
										int LA58_6 = input.LA(8);
										if ( (LA58_6==157) ) {
											switch ( input.LA(9) ) {
											case VALUE:
												{
												alt58=1;
												}
												break;
											case CASE:
												{
												alt58=2;
												}
												break;
											case SELECT:
												{
												alt58=3;
												}
												break;
											case SUM:
												{
												alt58=4;
												}
												break;
											default:
												if (state.backtracking>0) {state.failed=true; return retval;}
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 58, 9, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}
										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 58, 6, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 58, 10, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 58, 7, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}
							else if ( (LA58_5==154) ) {
								int LA58_8 = input.LA(6);
								if ( (LA58_8==IDENT) ) {
									int LA58_11 = input.LA(7);
									if ( (LA58_11==157) ) {
										int LA58_16 = input.LA(8);
										if ( (LA58_16==CASE) ) {
											alt58=2;
										}
										else if ( (LA58_16==SELECT) ) {
											alt58=3;
										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 58, 16, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 58, 11, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 58, 8, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 58, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}
						else if ( (LA58_4==IDENT) ) {
							int LA58_6 = input.LA(5);
							if ( (LA58_6==157) ) {
								switch ( input.LA(6) ) {
								case VALUE:
									{
									alt58=1;
									}
									break;
								case CASE:
									{
									alt58=2;
									}
									break;
								case SELECT:
									{
									alt58=3;
									}
									break;
								case SUM:
									{
									alt58=4;
									}
									break;
								default:
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 58, 9, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 58, 6, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 58, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 58, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 58, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 58, 0, input);
				throw nvae;
			}

			switch (alt58) {
				case 1 :
					// WreslTree.g:319:29: svar_timeArray_expr
					{
					pushFollow(FOLLOW_svar_timeArray_expr_in_svar_timeArray2534);
					svar_timeArray_expr171=svar_timeArray_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_timeArray_expr171.getTree());

					}
					break;
				case 2 :
					// WreslTree.g:319:51: svar_timeArray_case
					{
					pushFollow(FOLLOW_svar_timeArray_case_in_svar_timeArray2538);
					svar_timeArray_case172=svar_timeArray_case();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_timeArray_case172.getTree());

					}
					break;
				case 3 :
					// WreslTree.g:319:72: svar_timeArray_table
					{
					pushFollow(FOLLOW_svar_timeArray_table_in_svar_timeArray2541);
					svar_timeArray_table173=svar_timeArray_table();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_timeArray_table173.getTree());

					}
					break;
				case 4 :
					// WreslTree.g:319:95: svar_timeArray_sum
					{
					pushFollow(FOLLOW_svar_timeArray_sum_in_svar_timeArray2545);
					svar_timeArray_sum174=svar_timeArray_sum();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_timeArray_sum174.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "svar_timeArray"


	public static class dvar_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvar"
	// WreslTree.g:321:1: dvar : DEFINE ! ( dvar_std | dvar_nonStd ) ;
	public final WreslTreeParser.dvar_return dvar() throws RecognitionException {
		WreslTreeParser.dvar_return retval = new WreslTreeParser.dvar_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DEFINE175=null;
		ParserRuleReturnScope dvar_std176 =null;
		ParserRuleReturnScope dvar_nonStd177 =null;

		CommonTree DEFINE175_tree=null;

		try {
			// WreslTree.g:321:6: ( DEFINE ! ( dvar_std | dvar_nonStd ) )
			// WreslTree.g:321:8: DEFINE ! ( dvar_std | dvar_nonStd )
			{
			root_0 = (CommonTree)adaptor.nil();


			DEFINE175=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_dvar2558); if (state.failed) return retval;
			// WreslTree.g:321:16: ( dvar_std | dvar_nonStd )
			int alt59=2;
			switch ( input.LA(1) ) {
			case 139:
				{
				int LA59_1 = input.LA(2);
				if ( (LA59_1==INTEGER) ) {
					int LA59_4 = input.LA(3);
					if ( (LA59_4==140) ) {
						int LA59_8 = input.LA(4);
						if ( (LA59_8==153) ) {
							int LA59_2 = input.LA(5);
							if ( (LA59_2==LOCAL) ) {
								int LA59_6 = input.LA(6);
								if ( (LA59_6==154) ) {
									int LA59_9 = input.LA(7);
									if ( (LA59_9==IDENT) ) {
										int LA59_3 = input.LA(8);
										if ( (LA59_3==157) ) {
											int LA59_7 = input.LA(9);
											if ( (LA59_7==STD) ) {
												alt59=1;
											}
											else if ( (LA59_7==LOWER||LA59_7==UPPER) ) {
												alt59=2;
											}

											else {
												if (state.backtracking>0) {state.failed=true; return retval;}
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 59, 7, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}

										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 59, 3, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 59, 9, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 59, 6, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 59, 2, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}
						else if ( (LA59_8==IDENT) ) {
							int LA59_3 = input.LA(5);
							if ( (LA59_3==157) ) {
								int LA59_7 = input.LA(6);
								if ( (LA59_7==STD) ) {
									alt59=1;
								}
								else if ( (LA59_7==LOWER||LA59_7==UPPER) ) {
									alt59=2;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 59, 7, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 59, 3, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 59, 8, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 59, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA59_1==IDENT) ) {
					int LA59_5 = input.LA(3);
					if ( (LA59_5==140) ) {
						int LA59_8 = input.LA(4);
						if ( (LA59_8==153) ) {
							int LA59_2 = input.LA(5);
							if ( (LA59_2==LOCAL) ) {
								int LA59_6 = input.LA(6);
								if ( (LA59_6==154) ) {
									int LA59_9 = input.LA(7);
									if ( (LA59_9==IDENT) ) {
										int LA59_3 = input.LA(8);
										if ( (LA59_3==157) ) {
											int LA59_7 = input.LA(9);
											if ( (LA59_7==STD) ) {
												alt59=1;
											}
											else if ( (LA59_7==LOWER||LA59_7==UPPER) ) {
												alt59=2;
											}

											else {
												if (state.backtracking>0) {state.failed=true; return retval;}
												int nvaeMark = input.mark();
												try {
													for (int nvaeConsume = 0; nvaeConsume < 9 - 1; nvaeConsume++) {
														input.consume();
													}
													NoViableAltException nvae =
														new NoViableAltException("", 59, 7, input);
													throw nvae;
												} finally {
													input.rewind(nvaeMark);
												}
											}

										}

										else {
											if (state.backtracking>0) {state.failed=true; return retval;}
											int nvaeMark = input.mark();
											try {
												for (int nvaeConsume = 0; nvaeConsume < 8 - 1; nvaeConsume++) {
													input.consume();
												}
												NoViableAltException nvae =
													new NoViableAltException("", 59, 3, input);
												throw nvae;
											} finally {
												input.rewind(nvaeMark);
											}
										}

									}

									else {
										if (state.backtracking>0) {state.failed=true; return retval;}
										int nvaeMark = input.mark();
										try {
											for (int nvaeConsume = 0; nvaeConsume < 7 - 1; nvaeConsume++) {
												input.consume();
											}
											NoViableAltException nvae =
												new NoViableAltException("", 59, 9, input);
											throw nvae;
										} finally {
											input.rewind(nvaeMark);
										}
									}

								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 59, 6, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 59, 2, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}
						else if ( (LA59_8==IDENT) ) {
							int LA59_3 = input.LA(5);
							if ( (LA59_3==157) ) {
								int LA59_7 = input.LA(6);
								if ( (LA59_7==STD) ) {
									alt59=1;
								}
								else if ( (LA59_7==LOWER||LA59_7==UPPER) ) {
									alt59=2;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 59, 7, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 59, 3, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 59, 8, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 59, 5, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 59, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 153:
				{
				int LA59_2 = input.LA(2);
				if ( (LA59_2==LOCAL) ) {
					int LA59_6 = input.LA(3);
					if ( (LA59_6==154) ) {
						int LA59_9 = input.LA(4);
						if ( (LA59_9==IDENT) ) {
							int LA59_3 = input.LA(5);
							if ( (LA59_3==157) ) {
								int LA59_7 = input.LA(6);
								if ( (LA59_7==STD) ) {
									alt59=1;
								}
								else if ( (LA59_7==LOWER||LA59_7==UPPER) ) {
									alt59=2;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 59, 7, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 59, 3, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 59, 9, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 59, 6, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 59, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case IDENT:
				{
				int LA59_3 = input.LA(2);
				if ( (LA59_3==157) ) {
					int LA59_7 = input.LA(3);
					if ( (LA59_7==STD) ) {
						alt59=1;
					}
					else if ( (LA59_7==LOWER||LA59_7==UPPER) ) {
						alt59=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 59, 7, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 59, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 59, 0, input);
				throw nvae;
			}
			switch (alt59) {
				case 1 :
					// WreslTree.g:321:17: dvar_std
					{
					pushFollow(FOLLOW_dvar_std_in_dvar2562);
					dvar_std176=dvar_std();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dvar_std176.getTree());

					}
					break;
				case 2 :
					// WreslTree.g:321:28: dvar_nonStd
					{
					pushFollow(FOLLOW_dvar_nonStd_in_dvar2566);
					dvar_nonStd177=dvar_nonStd();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dvar_nonStd177.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "dvar"


	public static class svar_case_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_case"
	// WreslTree.g:323:1: svar_case : ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' ( case_content )+ '}' -> ^( Svar_case Scope[$sc.text] $i ( case_content )+ ) ;
	public final WreslTreeParser.svar_case_return svar_case() throws RecognitionException {
		WreslTreeParser.svar_case_return retval = new WreslTreeParser.svar_case_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token i=null;
		Token char_literal178=null;
		Token char_literal179=null;
		Token char_literal180=null;
		Token char_literal182=null;
		ParserRuleReturnScope case_content181 =null;

		CommonTree sc_tree=null;
		CommonTree i_tree=null;
		CommonTree char_literal178_tree=null;
		CommonTree char_literal179_tree=null;
		CommonTree char_literal180_tree=null;
		CommonTree char_literal182_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_case_content=new RewriteRuleSubtreeStream(adaptor,"rule case_content");

		try {
			// WreslTree.g:323:11: ( ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' ( case_content )+ '}' -> ^( Svar_case Scope[$sc.text] $i ( case_content )+ ) )
			// WreslTree.g:323:13: ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' ( case_content )+ '}'
			{
			// WreslTree.g:323:13: ( '[' (sc= LOCAL )? ']' )?
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==153) ) {
				alt61=1;
			}
			switch (alt61) {
				case 1 :
					// WreslTree.g:323:15: '[' (sc= LOCAL )? ']'
					{
					char_literal178=(Token)match(input,153,FOLLOW_153_in_svar_case2580); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal178);

					// WreslTree.g:323:21: (sc= LOCAL )?
					int alt60=2;
					int LA60_0 = input.LA(1);
					if ( (LA60_0==LOCAL) ) {
						alt60=1;
					}
					switch (alt60) {
						case 1 :
							// WreslTree.g:323:21: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_svar_case2584); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal179=(Token)match(input,154,FOLLOW_154_in_svar_case2587); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal179);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_svar_case2594); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal180=(Token)match(input,157,FOLLOW_157_in_svar_case2596); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal180);

			// WreslTree.g:323:48: ( case_content )+
			int cnt62=0;
			loop62:
			while (true) {
				int alt62=2;
				int LA62_0 = input.LA(1);
				if ( (LA62_0==CASE) ) {
					alt62=1;
				}

				switch (alt62) {
				case 1 :
					// WreslTree.g:323:48: case_content
					{
					pushFollow(FOLLOW_case_content_in_svar_case2598);
					case_content181=case_content();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_case_content.add(case_content181.getTree());
					}
					break;

				default :
					if ( cnt62 >= 1 ) break loop62;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(62, input);
					throw eee;
				}
				cnt62++;
			}

			char_literal182=(Token)match(input,158,FOLLOW_158_in_svar_case2601); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal182);

			// AST REWRITE
			// elements: i, case_content
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 324:57: -> ^( Svar_case Scope[$sc.text] $i ( case_content )+ )
			{
				// WreslTree.g:324:8: ^( Svar_case Scope[$sc.text] $i ( case_content )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Svar_case, "Svar_case"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_i.nextNode());
				if ( !(stream_case_content.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_case_content.hasNext() ) {
					adaptor.addChild(root_1, stream_case_content.nextTree());
				}
				stream_case_content.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "svar_case"


	public static class svar_timeArray_case_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_timeArray_case"
	// WreslTree.g:326:1: svar_timeArray_case : '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' ( case_content )+ '}' -> ^( SvarTimeArray_case TimeArraySize[$ta.text] Dependants[$ta.dependant] Scope[$sc.text] $i ( case_content )+ ) ;
	public final WreslTreeParser.svar_timeArray_case_return svar_timeArray_case() throws RecognitionException {
		WreslTreeParser.svar_timeArray_case_return retval = new WreslTreeParser.svar_timeArray_case_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token i=null;
		Token char_literal183=null;
		Token char_literal184=null;
		Token char_literal185=null;
		Token char_literal186=null;
		Token char_literal187=null;
		Token char_literal189=null;
		ParserRuleReturnScope ta =null;
		ParserRuleReturnScope case_content188 =null;

		CommonTree sc_tree=null;
		CommonTree i_tree=null;
		CommonTree char_literal183_tree=null;
		CommonTree char_literal184_tree=null;
		CommonTree char_literal185_tree=null;
		CommonTree char_literal186_tree=null;
		CommonTree char_literal187_tree=null;
		CommonTree char_literal189_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_140=new RewriteRuleTokenStream(adaptor,"token 140");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_timeArraySize=new RewriteRuleSubtreeStream(adaptor,"rule timeArraySize");
		RewriteRuleSubtreeStream stream_case_content=new RewriteRuleSubtreeStream(adaptor,"rule case_content");

		try {
			// WreslTree.g:326:21: ( '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' ( case_content )+ '}' -> ^( SvarTimeArray_case TimeArraySize[$ta.text] Dependants[$ta.dependant] Scope[$sc.text] $i ( case_content )+ ) )
			// WreslTree.g:326:23: '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' ( case_content )+ '}'
			{
			char_literal183=(Token)match(input,139,FOLLOW_139_in_svar_timeArray_case2632); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_139.add(char_literal183);

			pushFollow(FOLLOW_timeArraySize_in_svar_timeArray_case2636);
			ta=timeArraySize();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_timeArraySize.add(ta.getTree());
			char_literal184=(Token)match(input,140,FOLLOW_140_in_svar_timeArray_case2638); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_140.add(char_literal184);

			// WreslTree.g:326:48: ( '[' (sc= LOCAL )? ']' )?
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==153) ) {
				alt64=1;
			}
			switch (alt64) {
				case 1 :
					// WreslTree.g:326:50: '[' (sc= LOCAL )? ']'
					{
					char_literal185=(Token)match(input,153,FOLLOW_153_in_svar_timeArray_case2642); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal185);

					// WreslTree.g:326:56: (sc= LOCAL )?
					int alt63=2;
					int LA63_0 = input.LA(1);
					if ( (LA63_0==LOCAL) ) {
						alt63=1;
					}
					switch (alt63) {
						case 1 :
							// WreslTree.g:326:56: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_svar_timeArray_case2646); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal186=(Token)match(input,154,FOLLOW_154_in_svar_timeArray_case2649); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal186);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_svar_timeArray_case2656); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal187=(Token)match(input,157,FOLLOW_157_in_svar_timeArray_case2658); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal187);

			// WreslTree.g:326:83: ( case_content )+
			int cnt65=0;
			loop65:
			while (true) {
				int alt65=2;
				int LA65_0 = input.LA(1);
				if ( (LA65_0==CASE) ) {
					alt65=1;
				}

				switch (alt65) {
				case 1 :
					// WreslTree.g:326:83: case_content
					{
					pushFollow(FOLLOW_case_content_in_svar_timeArray_case2660);
					case_content188=case_content();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_case_content.add(case_content188.getTree());
					}
					break;

				default :
					if ( cnt65 >= 1 ) break loop65;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(65, input);
					throw eee;
				}
				cnt65++;
			}

			char_literal189=(Token)match(input,158,FOLLOW_158_in_svar_timeArray_case2663); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal189);

			// AST REWRITE
			// elements: case_content, i
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 327:116: -> ^( SvarTimeArray_case TimeArraySize[$ta.text] Dependants[$ta.dependant] Scope[$sc.text] $i ( case_content )+ )
			{
				// WreslTree.g:327:8: ^( SvarTimeArray_case TimeArraySize[$ta.text] Dependants[$ta.dependant] Scope[$sc.text] $i ( case_content )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SvarTimeArray_case, "SvarTimeArray_case"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TimeArraySize, (ta!=null?input.toString(ta.start,ta.stop):null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, (ta!=null?((WreslTreeParser.timeArraySize_return)ta).dependant:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_i.nextNode());
				if ( !(stream_case_content.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_case_content.hasNext() ) {
					adaptor.addChild(root_1, stream_case_content.nextTree());
				}
				stream_case_content.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "svar_timeArray_case"


	public static class case_content_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "case_content"
	// WreslTree.g:329:1: case_content : CASE i= IDENT '{' c= condition ( table_content -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] table_content ) | value_content -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] value_content ) | sum_content -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] sum_content ) ) '}' ;
	public final WreslTreeParser.case_content_return case_content() throws RecognitionException {
		WreslTreeParser.case_content_return retval = new WreslTreeParser.case_content_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token CASE190=null;
		Token char_literal191=null;
		Token char_literal195=null;
		ParserRuleReturnScope c =null;
		ParserRuleReturnScope table_content192 =null;
		ParserRuleReturnScope value_content193 =null;
		ParserRuleReturnScope sum_content194 =null;

		CommonTree i_tree=null;
		CommonTree CASE190_tree=null;
		CommonTree char_literal191_tree=null;
		CommonTree char_literal195_tree=null;
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_CASE=new RewriteRuleTokenStream(adaptor,"token CASE");
		RewriteRuleSubtreeStream stream_condition=new RewriteRuleSubtreeStream(adaptor,"rule condition");
		RewriteRuleSubtreeStream stream_sum_content=new RewriteRuleSubtreeStream(adaptor,"rule sum_content");
		RewriteRuleSubtreeStream stream_table_content=new RewriteRuleSubtreeStream(adaptor,"rule table_content");
		RewriteRuleSubtreeStream stream_value_content=new RewriteRuleSubtreeStream(adaptor,"rule value_content");

		 String dependants_nullsRemoved = ""; String varInCycle_nullsRemoved = ""; 
		try {
			// WreslTree.g:331:2: ( CASE i= IDENT '{' c= condition ( table_content -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] table_content ) | value_content -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] value_content ) | sum_content -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] sum_content ) ) '}' )
			// WreslTree.g:331:4: CASE i= IDENT '{' c= condition ( table_content -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] table_content ) | value_content -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] value_content ) | sum_content -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] sum_content ) ) '}'
			{
			CASE190=(Token)match(input,CASE,FOLLOW_CASE_in_case_content2707); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_CASE.add(CASE190);

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_case_content2711); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal191=(Token)match(input,157,FOLLOW_157_in_case_content2713); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal191);

			pushFollow(FOLLOW_condition_in_case_content2717);
			c=condition();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_condition.add(c.getTree());
			if ( state.backtracking==0 ) {   varInCycle_nullsRemoved =   Tools.remove_nulls((c!=null?((WreslTreeParser.condition_return)c).varInCycle:null));
					dependants_nullsRemoved =   Tools.remove_nulls((c!=null?((WreslTreeParser.condition_return)c).dependants:null)); }
			// WreslTree.g:335:5: ( table_content -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] table_content ) | value_content -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] value_content ) | sum_content -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] sum_content ) )
			int alt66=3;
			switch ( input.LA(1) ) {
			case SELECT:
				{
				alt66=1;
				}
				break;
			case VALUE:
				{
				alt66=2;
				}
				break;
			case SUM:
				{
				alt66=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 66, 0, input);
				throw nvae;
			}
			switch (alt66) {
				case 1 :
					// WreslTree.g:335:7: table_content
					{
					pushFollow(FOLLOW_table_content_in_case_content2730);
					table_content192=table_content();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_table_content.add(table_content192.getTree());
					// AST REWRITE
					// elements: table_content, i
					// token labels: i
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 336:2: -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] table_content )
					{
						// WreslTree.g:336:5: ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] table_content )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Case, "Case"), root_1);
						adaptor.addChild(root_1, stream_i.nextNode());
						adaptor.addChild(root_1, (CommonTree)adaptor.create(Condition, (c!=null?((WreslTreeParser.condition_return)c).text:null)));
						adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, dependants_nullsRemoved));
						adaptor.addChild(root_1, (CommonTree)adaptor.create(VarInCycle, varInCycle_nullsRemoved));
						adaptor.addChild(root_1, stream_table_content.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// WreslTree.g:338:4: value_content
					{
					pushFollow(FOLLOW_value_content_in_case_content2760);
					value_content193=value_content();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_value_content.add(value_content193.getTree());
					// AST REWRITE
					// elements: i, value_content
					// token labels: i
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 339:2: -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] value_content )
					{
						// WreslTree.g:339:5: ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] value_content )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Case, "Case"), root_1);
						adaptor.addChild(root_1, stream_i.nextNode());
						adaptor.addChild(root_1, (CommonTree)adaptor.create(Condition, (c!=null?((WreslTreeParser.condition_return)c).text:null)));
						adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, dependants_nullsRemoved));
						adaptor.addChild(root_1, (CommonTree)adaptor.create(VarInCycle, varInCycle_nullsRemoved));
						adaptor.addChild(root_1, stream_value_content.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;
				case 3 :
					// WreslTree.g:341:4: sum_content
					{
					pushFollow(FOLLOW_sum_content_in_case_content2791);
					sum_content194=sum_content();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_sum_content.add(sum_content194.getTree());
					// AST REWRITE
					// elements: sum_content, i
					// token labels: i
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 342:2: -> ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] sum_content )
					{
						// WreslTree.g:342:5: ^( Case $i Condition[$c.text] Dependants[dependants_nullsRemoved] VarInCycle[varInCycle_nullsRemoved] sum_content )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Case, "Case"), root_1);
						adaptor.addChild(root_1, stream_i.nextNode());
						adaptor.addChild(root_1, (CommonTree)adaptor.create(Condition, (c!=null?((WreslTreeParser.condition_return)c).text:null)));
						adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, dependants_nullsRemoved));
						adaptor.addChild(root_1, (CommonTree)adaptor.create(VarInCycle, varInCycle_nullsRemoved));
						adaptor.addChild(root_1, stream_sum_content.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;
					}

					}
					break;

			}

			char_literal195=(Token)match(input,158,FOLLOW_158_in_case_content2820); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal195);

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "case_content"


	public static class value_content_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "value_content"
	// WreslTree.g:347:1: value_content : VALUE e= expression -> Value[$e.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle] ;
	public final WreslTreeParser.value_content_return value_content() throws RecognitionException {
		WreslTreeParser.value_content_return retval = new WreslTreeParser.value_content_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VALUE196=null;
		ParserRuleReturnScope e =null;

		CommonTree VALUE196_tree=null;
		RewriteRuleTokenStream stream_VALUE=new RewriteRuleTokenStream(adaptor,"token VALUE");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// WreslTree.g:347:15: ( VALUE e= expression -> Value[$e.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle] )
			// WreslTree.g:347:17: VALUE e= expression
			{
			VALUE196=(Token)match(input,VALUE,FOLLOW_VALUE_in_value_content2830); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_VALUE.add(VALUE196);

			pushFollow(FOLLOW_expression_in_value_content2834);
			e=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expression.add(e.getTree());
			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 347:36: -> Value[$e.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle]
			{
				adaptor.addChild(root_0, (CommonTree)adaptor.create(Value, (e!=null?((WreslTreeParser.expression_return)e).text:null)));
				adaptor.addChild(root_0, (CommonTree)adaptor.create(Dependants, (e!=null?((WreslTreeParser.expression_return)e).dependants:null)));
				adaptor.addChild(root_0, (CommonTree)adaptor.create(VarInCycle, (e!=null?((WreslTreeParser.expression_return)e).strVarInCycle:null)));
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "value_content"


	public static class svar_table_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_table"
	// WreslTree.g:349:1: svar_table : ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' table_content '}' -> ^( Svar_table Scope[$sc.text] $i table_content ) ;
	public final WreslTreeParser.svar_table_return svar_table() throws RecognitionException {
		WreslTreeParser.svar_table_return retval = new WreslTreeParser.svar_table_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token i=null;
		Token char_literal197=null;
		Token char_literal198=null;
		Token char_literal199=null;
		Token char_literal201=null;
		ParserRuleReturnScope table_content200 =null;

		CommonTree sc_tree=null;
		CommonTree i_tree=null;
		CommonTree char_literal197_tree=null;
		CommonTree char_literal198_tree=null;
		CommonTree char_literal199_tree=null;
		CommonTree char_literal201_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_table_content=new RewriteRuleSubtreeStream(adaptor,"rule table_content");

		try {
			// WreslTree.g:349:12: ( ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' table_content '}' -> ^( Svar_table Scope[$sc.text] $i table_content ) )
			// WreslTree.g:350:2: ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' table_content '}'
			{
			// WreslTree.g:350:2: ( '[' (sc= LOCAL )? ']' )?
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==153) ) {
				alt68=1;
			}
			switch (alt68) {
				case 1 :
					// WreslTree.g:350:4: '[' (sc= LOCAL )? ']'
					{
					char_literal197=(Token)match(input,153,FOLLOW_153_in_svar_table2857); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal197);

					// WreslTree.g:350:10: (sc= LOCAL )?
					int alt67=2;
					int LA67_0 = input.LA(1);
					if ( (LA67_0==LOCAL) ) {
						alt67=1;
					}
					switch (alt67) {
						case 1 :
							// WreslTree.g:350:10: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_svar_table2861); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal198=(Token)match(input,154,FOLLOW_154_in_svar_table2864); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal198);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_svar_table2872); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal199=(Token)match(input,157,FOLLOW_157_in_svar_table2874); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal199);

			pushFollow(FOLLOW_table_content_in_svar_table2876);
			table_content200=table_content();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_table_content.add(table_content200.getTree());
			char_literal201=(Token)match(input,158,FOLLOW_158_in_svar_table2878); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal201);

			// AST REWRITE
			// elements: table_content, i
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 351:2: -> ^( Svar_table Scope[$sc.text] $i table_content )
			{
				// WreslTree.g:351:5: ^( Svar_table Scope[$sc.text] $i table_content )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Svar_table, "Svar_table"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_table_content.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "svar_table"


	public static class svar_timeArray_table_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_timeArray_table"
	// WreslTree.g:354:1: svar_timeArray_table : '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' table_content '}' -> ^( Svar_table TimeArraySize[$ta.text] Scope[$sc.text] $i table_content ) ;
	public final WreslTreeParser.svar_timeArray_table_return svar_timeArray_table() throws RecognitionException {
		WreslTreeParser.svar_timeArray_table_return retval = new WreslTreeParser.svar_timeArray_table_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token i=null;
		Token char_literal202=null;
		Token char_literal203=null;
		Token char_literal204=null;
		Token char_literal205=null;
		Token char_literal206=null;
		Token char_literal208=null;
		ParserRuleReturnScope ta =null;
		ParserRuleReturnScope table_content207 =null;

		CommonTree sc_tree=null;
		CommonTree i_tree=null;
		CommonTree char_literal202_tree=null;
		CommonTree char_literal203_tree=null;
		CommonTree char_literal204_tree=null;
		CommonTree char_literal205_tree=null;
		CommonTree char_literal206_tree=null;
		CommonTree char_literal208_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_140=new RewriteRuleTokenStream(adaptor,"token 140");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_timeArraySize=new RewriteRuleSubtreeStream(adaptor,"rule timeArraySize");
		RewriteRuleSubtreeStream stream_table_content=new RewriteRuleSubtreeStream(adaptor,"rule table_content");

		try {
			// WreslTree.g:354:22: ( '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' table_content '}' -> ^( Svar_table TimeArraySize[$ta.text] Scope[$sc.text] $i table_content ) )
			// WreslTree.g:355:3: '(' ta= timeArraySize ')' ( '[' (sc= LOCAL )? ']' )? i= IDENT '{' table_content '}'
			{
			char_literal202=(Token)match(input,139,FOLLOW_139_in_svar_timeArray_table2910); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_139.add(char_literal202);

			pushFollow(FOLLOW_timeArraySize_in_svar_timeArray_table2914);
			ta=timeArraySize();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_timeArraySize.add(ta.getTree());
			char_literal203=(Token)match(input,140,FOLLOW_140_in_svar_timeArray_table2916); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_140.add(char_literal203);

			// WreslTree.g:355:28: ( '[' (sc= LOCAL )? ']' )?
			int alt70=2;
			int LA70_0 = input.LA(1);
			if ( (LA70_0==153) ) {
				alt70=1;
			}
			switch (alt70) {
				case 1 :
					// WreslTree.g:355:30: '[' (sc= LOCAL )? ']'
					{
					char_literal204=(Token)match(input,153,FOLLOW_153_in_svar_timeArray_table2920); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal204);

					// WreslTree.g:355:36: (sc= LOCAL )?
					int alt69=2;
					int LA69_0 = input.LA(1);
					if ( (LA69_0==LOCAL) ) {
						alt69=1;
					}
					switch (alt69) {
						case 1 :
							// WreslTree.g:355:36: sc= LOCAL
							{
							sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_svar_timeArray_table2924); if (state.failed) return retval; 
							if ( state.backtracking==0 ) stream_LOCAL.add(sc);

							}
							break;

					}

					char_literal205=(Token)match(input,154,FOLLOW_154_in_svar_timeArray_table2927); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal205);

					}
					break;

			}

			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_svar_timeArray_table2934); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(i);

			char_literal206=(Token)match(input,157,FOLLOW_157_in_svar_timeArray_table2936); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal206);

			pushFollow(FOLLOW_table_content_in_svar_timeArray_table2938);
			table_content207=table_content();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_table_content.add(table_content207.getTree());
			char_literal208=(Token)match(input,158,FOLLOW_158_in_svar_timeArray_table2940); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal208);

			// AST REWRITE
			// elements: i, table_content
			// token labels: i
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_i=new RewriteRuleTokenStream(adaptor,"token i",i);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 356:3: -> ^( Svar_table TimeArraySize[$ta.text] Scope[$sc.text] $i table_content )
			{
				// WreslTree.g:356:5: ^( Svar_table TimeArraySize[$ta.text] Scope[$sc.text] $i table_content )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Svar_table, "Svar_table"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TimeArraySize, (ta!=null?input.toString(ta.start,ta.stop):null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_i.nextNode());
				adaptor.addChild(root_1, stream_table_content.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "svar_timeArray_table"


	public static class table_content_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "table_content"
	// WreslTree.g:359:1: table_content : SELECT s= IDENT FROM f= IDENT ( GIVEN g= assignment USE u= IDENT )? ( WHERE w= where_items )? -> ^( SELECT $s FROM $f ( GIVEN $g Dependants[$g.dependants] VarInCycle[$g.varInCycle] USE $u)? ( WHERE $w Dependants[$w.dependants] )? ) ;
	public final WreslTreeParser.table_content_return table_content() throws RecognitionException {
		WreslTreeParser.table_content_return retval = new WreslTreeParser.table_content_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		Token f=null;
		Token u=null;
		Token SELECT209=null;
		Token FROM210=null;
		Token GIVEN211=null;
		Token USE212=null;
		Token WHERE213=null;
		ParserRuleReturnScope g =null;
		ParserRuleReturnScope w =null;

		CommonTree s_tree=null;
		CommonTree f_tree=null;
		CommonTree u_tree=null;
		CommonTree SELECT209_tree=null;
		CommonTree FROM210_tree=null;
		CommonTree GIVEN211_tree=null;
		CommonTree USE212_tree=null;
		CommonTree WHERE213_tree=null;
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_USE=new RewriteRuleTokenStream(adaptor,"token USE");
		RewriteRuleTokenStream stream_GIVEN=new RewriteRuleTokenStream(adaptor,"token GIVEN");
		RewriteRuleTokenStream stream_FROM=new RewriteRuleTokenStream(adaptor,"token FROM");
		RewriteRuleTokenStream stream_WHERE=new RewriteRuleTokenStream(adaptor,"token WHERE");
		RewriteRuleTokenStream stream_SELECT=new RewriteRuleTokenStream(adaptor,"token SELECT");
		RewriteRuleSubtreeStream stream_where_items=new RewriteRuleSubtreeStream(adaptor,"rule where_items");
		RewriteRuleSubtreeStream stream_assignment=new RewriteRuleSubtreeStream(adaptor,"rule assignment");

		try {
			// WreslTree.g:359:15: ( SELECT s= IDENT FROM f= IDENT ( GIVEN g= assignment USE u= IDENT )? ( WHERE w= where_items )? -> ^( SELECT $s FROM $f ( GIVEN $g Dependants[$g.dependants] VarInCycle[$g.varInCycle] USE $u)? ( WHERE $w Dependants[$w.dependants] )? ) )
			// WreslTree.g:359:17: SELECT s= IDENT FROM f= IDENT ( GIVEN g= assignment USE u= IDENT )? ( WHERE w= where_items )?
			{
			SELECT209=(Token)match(input,SELECT,FOLLOW_SELECT_in_table_content2973); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SELECT.add(SELECT209);

			s=(Token)match(input,IDENT,FOLLOW_IDENT_in_table_content2977); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(s);

			FROM210=(Token)match(input,FROM,FOLLOW_FROM_in_table_content2979); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_FROM.add(FROM210);

			f=(Token)match(input,IDENT,FOLLOW_IDENT_in_table_content2983); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(f);

			// WreslTree.g:360:5: ( GIVEN g= assignment USE u= IDENT )?
			int alt71=2;
			int LA71_0 = input.LA(1);
			if ( (LA71_0==GIVEN) ) {
				alt71=1;
			}
			switch (alt71) {
				case 1 :
					// WreslTree.g:360:6: GIVEN g= assignment USE u= IDENT
					{
					GIVEN211=(Token)match(input,GIVEN,FOLLOW_GIVEN_in_table_content2991); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_GIVEN.add(GIVEN211);

					pushFollow(FOLLOW_assignment_in_table_content2995);
					g=assignment();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_assignment.add(g.getTree());
					USE212=(Token)match(input,USE,FOLLOW_USE_in_table_content2997); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_USE.add(USE212);

					u=(Token)match(input,IDENT,FOLLOW_IDENT_in_table_content3001); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_IDENT.add(u);

					}
					break;

			}

			// WreslTree.g:361:5: ( WHERE w= where_items )?
			int alt72=2;
			int LA72_0 = input.LA(1);
			if ( (LA72_0==WHERE) ) {
				alt72=1;
			}
			switch (alt72) {
				case 1 :
					// WreslTree.g:361:6: WHERE w= where_items
					{
					WHERE213=(Token)match(input,WHERE,FOLLOW_WHERE_in_table_content3011); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_WHERE.add(WHERE213);

					pushFollow(FOLLOW_where_items_in_table_content3015);
					w=where_items();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_where_items.add(w.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: f, SELECT, g, w, s, GIVEN, WHERE, USE, u, FROM
			// token labels: s, u, f
			// rule labels: g, w, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_s=new RewriteRuleTokenStream(adaptor,"token s",s);
			RewriteRuleTokenStream stream_u=new RewriteRuleTokenStream(adaptor,"token u",u);
			RewriteRuleTokenStream stream_f=new RewriteRuleTokenStream(adaptor,"token f",f);
			RewriteRuleSubtreeStream stream_g=new RewriteRuleSubtreeStream(adaptor,"rule g",g!=null?g.getTree():null);
			RewriteRuleSubtreeStream stream_w=new RewriteRuleSubtreeStream(adaptor,"rule w",w!=null?w.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 363:5: -> ^( SELECT $s FROM $f ( GIVEN $g Dependants[$g.dependants] VarInCycle[$g.varInCycle] USE $u)? ( WHERE $w Dependants[$w.dependants] )? )
			{
				// WreslTree.g:363:5: ^( SELECT $s FROM $f ( GIVEN $g Dependants[$g.dependants] VarInCycle[$g.varInCycle] USE $u)? ( WHERE $w Dependants[$w.dependants] )? )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_SELECT.nextNode(), root_1);
				adaptor.addChild(root_1, stream_s.nextNode());
				adaptor.addChild(root_1, stream_FROM.nextNode());
				adaptor.addChild(root_1, stream_f.nextNode());
				// WreslTree.g:363:26: ( GIVEN $g Dependants[$g.dependants] VarInCycle[$g.varInCycle] USE $u)?
				if ( stream_g.hasNext()||stream_GIVEN.hasNext()||stream_USE.hasNext()||stream_u.hasNext() ) {
					adaptor.addChild(root_1, stream_GIVEN.nextNode());
					adaptor.addChild(root_1, stream_g.nextTree());
					adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, (g!=null?((WreslTreeParser.assignment_return)g).dependants:null)));
					adaptor.addChild(root_1, (CommonTree)adaptor.create(VarInCycle, (g!=null?((WreslTreeParser.assignment_return)g).varInCycle:null)));
					adaptor.addChild(root_1, stream_USE.nextNode());
					adaptor.addChild(root_1, stream_u.nextNode());
				}
				stream_g.reset();
				stream_GIVEN.reset();
				stream_USE.reset();
				stream_u.reset();

				// WreslTree.g:363:98: ( WHERE $w Dependants[$w.dependants] )?
				if ( stream_w.hasNext()||stream_WHERE.hasNext() ) {
					adaptor.addChild(root_1, stream_WHERE.nextNode());
					adaptor.addChild(root_1, stream_w.nextTree());
					adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, (w!=null?((WreslTreeParser.where_items_return)w).dependants:null)));
				}
				stream_w.reset();
				stream_WHERE.reset();

				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "table_content"


	public static class where_items_return extends ParserRuleReturnScope {
		public String dependants;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "where_items"
	// WreslTree.g:366:1: where_items returns [String dependants] : ai= assignment ( ',' a= assignment )* ;
	public final WreslTreeParser.where_items_return where_items() throws RecognitionException {
		WreslTreeParser.where_items_return retval = new WreslTreeParser.where_items_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal214=null;
		ParserRuleReturnScope ai =null;
		ParserRuleReturnScope a =null;

		CommonTree char_literal214_tree=null;

		try {
			// WreslTree.g:367:2: (ai= assignment ( ',' a= assignment )* )
			// WreslTree.g:367:4: ai= assignment ( ',' a= assignment )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_assignment_in_where_items3086);
			ai=assignment();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, ai.getTree());

			// WreslTree.g:367:18: ( ',' a= assignment )*
			loop73:
			while (true) {
				int alt73=2;
				int LA73_0 = input.LA(1);
				if ( (LA73_0==143) ) {
					alt73=1;
				}

				switch (alt73) {
				case 1 :
					// WreslTree.g:367:19: ',' a= assignment
					{
					char_literal214=(Token)match(input,143,FOLLOW_143_in_where_items3089); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal214_tree = (CommonTree)adaptor.create(char_literal214);
					adaptor.addChild(root_0, char_literal214_tree);
					}

					pushFollow(FOLLOW_assignment_in_where_items3093);
					a=assignment();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, a.getTree());

					if ( state.backtracking==0 ) {retval.dependants =retval.dependants + " " + (a!=null?((WreslTreeParser.assignment_return)a).dependants:null); }
					}
					break;

				default :
					break loop73;
				}
			}

			if ( state.backtracking==0 ) {retval.dependants =retval.dependants + " " + (ai!=null?((WreslTreeParser.assignment_return)ai).dependants:null); }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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


	public static class svar_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_expr"
	// WreslTree.g:371:1: svar_expr : ( '[' sc= LOCAL ']' )? IDENT '{' VALUE e= expression '}' -> ^( Svar_const Scope[$sc.text] IDENT Expression[$e.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle] ) ;
	public final WreslTreeParser.svar_expr_return svar_expr() throws RecognitionException {
		WreslTreeParser.svar_expr_return retval = new WreslTreeParser.svar_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token char_literal215=null;
		Token char_literal216=null;
		Token IDENT217=null;
		Token char_literal218=null;
		Token VALUE219=null;
		Token char_literal220=null;
		ParserRuleReturnScope e =null;

		CommonTree sc_tree=null;
		CommonTree char_literal215_tree=null;
		CommonTree char_literal216_tree=null;
		CommonTree IDENT217_tree=null;
		CommonTree char_literal218_tree=null;
		CommonTree VALUE219_tree=null;
		CommonTree char_literal220_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_VALUE=new RewriteRuleTokenStream(adaptor,"token VALUE");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// WreslTree.g:371:11: ( ( '[' sc= LOCAL ']' )? IDENT '{' VALUE e= expression '}' -> ^( Svar_const Scope[$sc.text] IDENT Expression[$e.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle] ) )
			// WreslTree.g:372:2: ( '[' sc= LOCAL ']' )? IDENT '{' VALUE e= expression '}'
			{
			// WreslTree.g:372:2: ( '[' sc= LOCAL ']' )?
			int alt74=2;
			int LA74_0 = input.LA(1);
			if ( (LA74_0==153) ) {
				alt74=1;
			}
			switch (alt74) {
				case 1 :
					// WreslTree.g:372:4: '[' sc= LOCAL ']'
					{
					char_literal215=(Token)match(input,153,FOLLOW_153_in_svar_expr3116); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal215);

					sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_svar_expr3120); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LOCAL.add(sc);

					char_literal216=(Token)match(input,154,FOLLOW_154_in_svar_expr3122); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal216);

					}
					break;

			}

			IDENT217=(Token)match(input,IDENT,FOLLOW_IDENT_in_svar_expr3127); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(IDENT217);

			char_literal218=(Token)match(input,157,FOLLOW_157_in_svar_expr3129); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal218);

			VALUE219=(Token)match(input,VALUE,FOLLOW_VALUE_in_svar_expr3131); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_VALUE.add(VALUE219);

			pushFollow(FOLLOW_expression_in_svar_expr3136);
			e=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expression.add(e.getTree());
			char_literal220=(Token)match(input,158,FOLLOW_158_in_svar_expr3137); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal220);

			// AST REWRITE
			// elements: IDENT
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 373:2: -> ^( Svar_const Scope[$sc.text] IDENT Expression[$e.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle] )
			{
				// WreslTree.g:373:6: ^( Svar_const Scope[$sc.text] IDENT Expression[$e.text] Dependants[$e.dependants] VarInCycle[$e.strVarInCycle] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Svar_const, "Svar_const"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_IDENT.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Expression, (e!=null?((WreslTreeParser.expression_return)e).text:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, (e!=null?((WreslTreeParser.expression_return)e).dependants:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(VarInCycle, (e!=null?((WreslTreeParser.expression_return)e).strVarInCycle:null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "svar_expr"


	public static class svar_timeArray_expr_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_timeArray_expr"
	// WreslTree.g:376:1: svar_timeArray_expr : '(' ta= timeArraySize ')' ( '[' sc= LOCAL ']' )? IDENT '{' VALUE e= expression '}' -> ^( SvarTimeArray_const TimeArraySize[$ta.text] Scope[$sc.text] IDENT Expression[$e.text] Dependants[$e.dependants+\" \"+$ta.dependant] VarInCycle[$e.strVarInCycle] ) ;
	public final WreslTreeParser.svar_timeArray_expr_return svar_timeArray_expr() throws RecognitionException {
		WreslTreeParser.svar_timeArray_expr_return retval = new WreslTreeParser.svar_timeArray_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token char_literal221=null;
		Token char_literal222=null;
		Token char_literal223=null;
		Token char_literal224=null;
		Token IDENT225=null;
		Token char_literal226=null;
		Token VALUE227=null;
		Token char_literal228=null;
		ParserRuleReturnScope ta =null;
		ParserRuleReturnScope e =null;

		CommonTree sc_tree=null;
		CommonTree char_literal221_tree=null;
		CommonTree char_literal222_tree=null;
		CommonTree char_literal223_tree=null;
		CommonTree char_literal224_tree=null;
		CommonTree IDENT225_tree=null;
		CommonTree char_literal226_tree=null;
		CommonTree VALUE227_tree=null;
		CommonTree char_literal228_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_VALUE=new RewriteRuleTokenStream(adaptor,"token VALUE");
		RewriteRuleTokenStream stream_140=new RewriteRuleTokenStream(adaptor,"token 140");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_timeArraySize=new RewriteRuleSubtreeStream(adaptor,"rule timeArraySize");

		try {
			// WreslTree.g:376:21: ( '(' ta= timeArraySize ')' ( '[' sc= LOCAL ']' )? IDENT '{' VALUE e= expression '}' -> ^( SvarTimeArray_const TimeArraySize[$ta.text] Scope[$sc.text] IDENT Expression[$e.text] Dependants[$e.dependants+\" \"+$ta.dependant] VarInCycle[$e.strVarInCycle] ) )
			// WreslTree.g:377:2: '(' ta= timeArraySize ')' ( '[' sc= LOCAL ']' )? IDENT '{' VALUE e= expression '}'
			{
			char_literal221=(Token)match(input,139,FOLLOW_139_in_svar_timeArray_expr3174); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_139.add(char_literal221);

			pushFollow(FOLLOW_timeArraySize_in_svar_timeArray_expr3178);
			ta=timeArraySize();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_timeArraySize.add(ta.getTree());
			char_literal222=(Token)match(input,140,FOLLOW_140_in_svar_timeArray_expr3180); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_140.add(char_literal222);

			// WreslTree.g:377:27: ( '[' sc= LOCAL ']' )?
			int alt75=2;
			int LA75_0 = input.LA(1);
			if ( (LA75_0==153) ) {
				alt75=1;
			}
			switch (alt75) {
				case 1 :
					// WreslTree.g:377:29: '[' sc= LOCAL ']'
					{
					char_literal223=(Token)match(input,153,FOLLOW_153_in_svar_timeArray_expr3184); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal223);

					sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_svar_timeArray_expr3188); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LOCAL.add(sc);

					char_literal224=(Token)match(input,154,FOLLOW_154_in_svar_timeArray_expr3190); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal224);

					}
					break;

			}

			IDENT225=(Token)match(input,IDENT,FOLLOW_IDENT_in_svar_timeArray_expr3195); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(IDENT225);

			char_literal226=(Token)match(input,157,FOLLOW_157_in_svar_timeArray_expr3197); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal226);

			VALUE227=(Token)match(input,VALUE,FOLLOW_VALUE_in_svar_timeArray_expr3199); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_VALUE.add(VALUE227);

			pushFollow(FOLLOW_expression_in_svar_timeArray_expr3204);
			e=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expression.add(e.getTree());
			char_literal228=(Token)match(input,158,FOLLOW_158_in_svar_timeArray_expr3205); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal228);

			// AST REWRITE
			// elements: IDENT
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 378:2: -> ^( SvarTimeArray_const TimeArraySize[$ta.text] Scope[$sc.text] IDENT Expression[$e.text] Dependants[$e.dependants+\" \"+$ta.dependant] VarInCycle[$e.strVarInCycle] )
			{
				// WreslTree.g:378:6: ^( SvarTimeArray_const TimeArraySize[$ta.text] Scope[$sc.text] IDENT Expression[$e.text] Dependants[$e.dependants+\" \"+$ta.dependant] VarInCycle[$e.strVarInCycle] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(SvarTimeArray_const, "SvarTimeArray_const"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TimeArraySize, (ta!=null?input.toString(ta.start,ta.stop):null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_IDENT.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Expression, (e!=null?((WreslTreeParser.expression_return)e).text:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, (e!=null?((WreslTreeParser.expression_return)e).dependants:null)+" "+(ta!=null?((WreslTreeParser.timeArraySize_return)ta).dependant:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(VarInCycle, (e!=null?((WreslTreeParser.expression_return)e).strVarInCycle:null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "svar_timeArray_expr"


	public static class svar_sum_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_sum"
	// WreslTree.g:381:1: svar_sum : ( '[' sc= LOCAL ']' )? IDENT '{' sum_content '}' -> ^( Svar_sum Scope[$sc.text] IDENT sum_content ) ;
	public final WreslTreeParser.svar_sum_return svar_sum() throws RecognitionException {
		WreslTreeParser.svar_sum_return retval = new WreslTreeParser.svar_sum_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token char_literal229=null;
		Token char_literal230=null;
		Token IDENT231=null;
		Token char_literal232=null;
		Token char_literal234=null;
		ParserRuleReturnScope sum_content233 =null;

		CommonTree sc_tree=null;
		CommonTree char_literal229_tree=null;
		CommonTree char_literal230_tree=null;
		CommonTree IDENT231_tree=null;
		CommonTree char_literal232_tree=null;
		CommonTree char_literal234_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_sum_content=new RewriteRuleSubtreeStream(adaptor,"rule sum_content");

		try {
			// WreslTree.g:381:10: ( ( '[' sc= LOCAL ']' )? IDENT '{' sum_content '}' -> ^( Svar_sum Scope[$sc.text] IDENT sum_content ) )
			// WreslTree.g:381:12: ( '[' sc= LOCAL ']' )? IDENT '{' sum_content '}'
			{
			// WreslTree.g:381:12: ( '[' sc= LOCAL ']' )?
			int alt76=2;
			int LA76_0 = input.LA(1);
			if ( (LA76_0==153) ) {
				alt76=1;
			}
			switch (alt76) {
				case 1 :
					// WreslTree.g:381:14: '[' sc= LOCAL ']'
					{
					char_literal229=(Token)match(input,153,FOLLOW_153_in_svar_sum3245); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal229);

					sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_svar_sum3249); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LOCAL.add(sc);

					char_literal230=(Token)match(input,154,FOLLOW_154_in_svar_sum3251); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal230);

					}
					break;

			}

			IDENT231=(Token)match(input,IDENT,FOLLOW_IDENT_in_svar_sum3256); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(IDENT231);

			char_literal232=(Token)match(input,157,FOLLOW_157_in_svar_sum3258); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal232);

			pushFollow(FOLLOW_sum_content_in_svar_sum3260);
			sum_content233=sum_content();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_sum_content.add(sum_content233.getTree());
			char_literal234=(Token)match(input,158,FOLLOW_158_in_svar_sum3262); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal234);

			// AST REWRITE
			// elements: IDENT, sum_content
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 382:3: -> ^( Svar_sum Scope[$sc.text] IDENT sum_content )
			{
				// WreslTree.g:382:7: ^( Svar_sum Scope[$sc.text] IDENT sum_content )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Svar_sum, "Svar_sum"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_IDENT.nextNode());
				adaptor.addChild(root_1, stream_sum_content.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "svar_sum"


	public static class svar_timeArray_sum_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_timeArray_sum"
	// WreslTree.g:385:1: svar_timeArray_sum : '(' ta= timeArraySize ')' ( '[' sc= LOCAL ']' )? IDENT '{' sum_content '}' -> ^( Svar_sum TimeArraySize[$ta.text] Scope[$sc.text] IDENT sum_content ) ;
	public final WreslTreeParser.svar_timeArray_sum_return svar_timeArray_sum() throws RecognitionException {
		WreslTreeParser.svar_timeArray_sum_return retval = new WreslTreeParser.svar_timeArray_sum_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token char_literal235=null;
		Token char_literal236=null;
		Token char_literal237=null;
		Token char_literal238=null;
		Token IDENT239=null;
		Token char_literal240=null;
		Token char_literal242=null;
		ParserRuleReturnScope ta =null;
		ParserRuleReturnScope sum_content241 =null;

		CommonTree sc_tree=null;
		CommonTree char_literal235_tree=null;
		CommonTree char_literal236_tree=null;
		CommonTree char_literal237_tree=null;
		CommonTree char_literal238_tree=null;
		CommonTree IDENT239_tree=null;
		CommonTree char_literal240_tree=null;
		CommonTree char_literal242_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_140=new RewriteRuleTokenStream(adaptor,"token 140");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_sum_content=new RewriteRuleSubtreeStream(adaptor,"rule sum_content");
		RewriteRuleSubtreeStream stream_timeArraySize=new RewriteRuleSubtreeStream(adaptor,"rule timeArraySize");

		try {
			// WreslTree.g:385:20: ( '(' ta= timeArraySize ')' ( '[' sc= LOCAL ']' )? IDENT '{' sum_content '}' -> ^( Svar_sum TimeArraySize[$ta.text] Scope[$sc.text] IDENT sum_content ) )
			// WreslTree.g:385:22: '(' ta= timeArraySize ')' ( '[' sc= LOCAL ']' )? IDENT '{' sum_content '}'
			{
			char_literal235=(Token)match(input,139,FOLLOW_139_in_svar_timeArray_sum3294); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_139.add(char_literal235);

			pushFollow(FOLLOW_timeArraySize_in_svar_timeArray_sum3298);
			ta=timeArraySize();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_timeArraySize.add(ta.getTree());
			char_literal236=(Token)match(input,140,FOLLOW_140_in_svar_timeArray_sum3300); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_140.add(char_literal236);

			// WreslTree.g:385:47: ( '[' sc= LOCAL ']' )?
			int alt77=2;
			int LA77_0 = input.LA(1);
			if ( (LA77_0==153) ) {
				alt77=1;
			}
			switch (alt77) {
				case 1 :
					// WreslTree.g:385:49: '[' sc= LOCAL ']'
					{
					char_literal237=(Token)match(input,153,FOLLOW_153_in_svar_timeArray_sum3304); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal237);

					sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_svar_timeArray_sum3308); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LOCAL.add(sc);

					char_literal238=(Token)match(input,154,FOLLOW_154_in_svar_timeArray_sum3310); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal238);

					}
					break;

			}

			IDENT239=(Token)match(input,IDENT,FOLLOW_IDENT_in_svar_timeArray_sum3315); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(IDENT239);

			char_literal240=(Token)match(input,157,FOLLOW_157_in_svar_timeArray_sum3317); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal240);

			pushFollow(FOLLOW_sum_content_in_svar_timeArray_sum3319);
			sum_content241=sum_content();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_sum_content.add(sum_content241.getTree());
			char_literal242=(Token)match(input,158,FOLLOW_158_in_svar_timeArray_sum3321); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal242);

			// AST REWRITE
			// elements: sum_content, IDENT
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 386:2: -> ^( Svar_sum TimeArraySize[$ta.text] Scope[$sc.text] IDENT sum_content )
			{
				// WreslTree.g:386:6: ^( Svar_sum TimeArraySize[$ta.text] Scope[$sc.text] IDENT sum_content )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Svar_sum, "Svar_sum"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TimeArraySize, (ta!=null?input.toString(ta.start,ta.stop):null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_IDENT.nextNode());
				adaptor.addChild(root_1, stream_sum_content.nextTree());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "svar_timeArray_sum"


	public static class sum_content_return extends ParserRuleReturnScope {
		public Set<String> setVarInCycle;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "sum_content"
	// WreslTree.g:389:1: sum_content returns [Set<String> setVarInCycle] : SUM hdr= sum_header e= expression -> ^( Sum_hdr[$hdr.text] Expression[$e.text] Dependants[$hdr.dependants+\" \"+$e.dependants] VarInCycle[$e.strVarInCycle] ) ;
	public final WreslTreeParser.sum_content_return sum_content() throws RecognitionException {
		WreslTreeParser.sum_content_return retval = new WreslTreeParser.sum_content_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SUM243=null;
		ParserRuleReturnScope hdr =null;
		ParserRuleReturnScope e =null;

		CommonTree SUM243_tree=null;
		RewriteRuleTokenStream stream_SUM=new RewriteRuleTokenStream(adaptor,"token SUM");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_sum_header=new RewriteRuleSubtreeStream(adaptor,"rule sum_header");

		try {
			// WreslTree.g:389:48: ( SUM hdr= sum_header e= expression -> ^( Sum_hdr[$hdr.text] Expression[$e.text] Dependants[$hdr.dependants+\" \"+$e.dependants] VarInCycle[$e.strVarInCycle] ) )
			// WreslTree.g:389:49: SUM hdr= sum_header e= expression
			{
			SUM243=(Token)match(input,SUM,FOLLOW_SUM_in_sum_content3356); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_SUM.add(SUM243);

			pushFollow(FOLLOW_sum_header_in_sum_content3360);
			hdr=sum_header();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_sum_header.add(hdr.getTree());
			pushFollow(FOLLOW_expression_in_sum_content3364);
			e=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expression.add(e.getTree());
			if ( state.backtracking==0 ) {
			  retval.setVarInCycle = (e!=null?((WreslTreeParser.expression_return)e).setVarInCycle:null);
			}
			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 393:4: -> ^( Sum_hdr[$hdr.text] Expression[$e.text] Dependants[$hdr.dependants+\" \"+$e.dependants] VarInCycle[$e.strVarInCycle] )
			{
				// WreslTree.g:393:4: ^( Sum_hdr[$hdr.text] Expression[$e.text] Dependants[$hdr.dependants+\" \"+$e.dependants] VarInCycle[$e.strVarInCycle] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Sum_hdr, (hdr!=null?input.toString(hdr.start,hdr.stop):null)), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Expression, (e!=null?((WreslTreeParser.expression_return)e).text:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Dependants, (hdr!=null?((WreslTreeParser.sum_header_return)hdr).dependants:null)+" "+(e!=null?((WreslTreeParser.expression_return)e).dependants:null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(VarInCycle, (e!=null?((WreslTreeParser.expression_return)e).strVarInCycle:null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "sum_content"


	public static class sum_header_return extends ParserRuleReturnScope {
		public String dependants;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "sum_header"
	// WreslTree.g:396:1: sum_header returns [String dependants] : ( '(' 'i=' e1= expression ',' e2= expression ( ',' ( '-' )? INTEGER )? ')' ) ;
	public final WreslTreeParser.sum_header_return sum_header() throws RecognitionException {
		WreslTreeParser.sum_header_return retval = new WreslTreeParser.sum_header_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal244=null;
		Token string_literal245=null;
		Token char_literal246=null;
		Token char_literal247=null;
		Token char_literal248=null;
		Token INTEGER249=null;
		Token char_literal250=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;

		CommonTree char_literal244_tree=null;
		CommonTree string_literal245_tree=null;
		CommonTree char_literal246_tree=null;
		CommonTree char_literal247_tree=null;
		CommonTree char_literal248_tree=null;
		CommonTree INTEGER249_tree=null;
		CommonTree char_literal250_tree=null;

		try {
			// WreslTree.g:397:2: ( ( '(' 'i=' e1= expression ',' e2= expression ( ',' ( '-' )? INTEGER )? ')' ) )
			// WreslTree.g:397:4: ( '(' 'i=' e1= expression ',' e2= expression ( ',' ( '-' )? INTEGER )? ')' )
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslTree.g:397:4: ( '(' 'i=' e1= expression ',' e2= expression ( ',' ( '-' )? INTEGER )? ')' )
			// WreslTree.g:397:6: '(' 'i=' e1= expression ',' e2= expression ( ',' ( '-' )? INTEGER )? ')'
			{
			char_literal244=(Token)match(input,139,FOLLOW_139_in_sum_header3399); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal244_tree = (CommonTree)adaptor.create(char_literal244);
			adaptor.addChild(root_0, char_literal244_tree);
			}

			string_literal245=(Token)match(input,155,FOLLOW_155_in_sum_header3401); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal245_tree = (CommonTree)adaptor.create(string_literal245);
			adaptor.addChild(root_0, string_literal245_tree);
			}

			pushFollow(FOLLOW_expression_in_sum_header3405);
			e1=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e1.getTree());

			char_literal246=(Token)match(input,143,FOLLOW_143_in_sum_header3407); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal246_tree = (CommonTree)adaptor.create(char_literal246);
			adaptor.addChild(root_0, char_literal246_tree);
			}

			pushFollow(FOLLOW_expression_in_sum_header3411);
			e2=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e2.getTree());

			// WreslTree.g:397:47: ( ',' ( '-' )? INTEGER )?
			int alt79=2;
			int LA79_0 = input.LA(1);
			if ( (LA79_0==143) ) {
				alt79=1;
			}
			switch (alt79) {
				case 1 :
					// WreslTree.g:397:48: ',' ( '-' )? INTEGER
					{
					char_literal247=(Token)match(input,143,FOLLOW_143_in_sum_header3414); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal247_tree = (CommonTree)adaptor.create(char_literal247);
					adaptor.addChild(root_0, char_literal247_tree);
					}

					// WreslTree.g:397:52: ( '-' )?
					int alt78=2;
					int LA78_0 = input.LA(1);
					if ( (LA78_0==144) ) {
						alt78=1;
					}
					switch (alt78) {
						case 1 :
							// WreslTree.g:397:52: '-'
							{
							char_literal248=(Token)match(input,144,FOLLOW_144_in_sum_header3416); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							char_literal248_tree = (CommonTree)adaptor.create(char_literal248);
							adaptor.addChild(root_0, char_literal248_tree);
							}

							}
							break;

					}

					INTEGER249=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_sum_header3419); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INTEGER249_tree = (CommonTree)adaptor.create(INTEGER249);
					adaptor.addChild(root_0, INTEGER249_tree);
					}

					}
					break;

			}

			char_literal250=(Token)match(input,140,FOLLOW_140_in_sum_header3424); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal250_tree = (CommonTree)adaptor.create(char_literal250);
			adaptor.addChild(root_0, char_literal250_tree);
			}

			}

			if ( state.backtracking==0 ) {retval.dependants = (e1!=null?((WreslTreeParser.expression_return)e1).dependants:null) + " " +(e2!=null?((WreslTreeParser.expression_return)e2).dependants:null);}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "sum_header"


	public static class svar_dss_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_dss"
	// WreslTree.g:401:1: svar_dss : ( '[' sc= LOCAL ']' )? IDENT '{' TIMESERIES (b= STRING )? KIND k= STRING UNITS u= STRING ( CONVERT c= STRING )? '}' -> ^( Svar_dss Scope[$sc.text] IDENT B_part[$b.text] Kind $k Units $u CONVERT[$c.text] ) ;
	public final WreslTreeParser.svar_dss_return svar_dss() throws RecognitionException {
		WreslTreeParser.svar_dss_return retval = new WreslTreeParser.svar_dss_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token b=null;
		Token k=null;
		Token u=null;
		Token c=null;
		Token char_literal251=null;
		Token char_literal252=null;
		Token IDENT253=null;
		Token char_literal254=null;
		Token TIMESERIES255=null;
		Token KIND256=null;
		Token UNITS257=null;
		Token CONVERT258=null;
		Token char_literal259=null;

		CommonTree sc_tree=null;
		CommonTree b_tree=null;
		CommonTree k_tree=null;
		CommonTree u_tree=null;
		CommonTree c_tree=null;
		CommonTree char_literal251_tree=null;
		CommonTree char_literal252_tree=null;
		CommonTree IDENT253_tree=null;
		CommonTree char_literal254_tree=null;
		CommonTree TIMESERIES255_tree=null;
		CommonTree KIND256_tree=null;
		CommonTree UNITS257_tree=null;
		CommonTree CONVERT258_tree=null;
		CommonTree char_literal259_tree=null;
		RewriteRuleTokenStream stream_CONVERT=new RewriteRuleTokenStream(adaptor,"token CONVERT");
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_KIND=new RewriteRuleTokenStream(adaptor,"token KIND");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleTokenStream stream_UNITS=new RewriteRuleTokenStream(adaptor,"token UNITS");
		RewriteRuleTokenStream stream_TIMESERIES=new RewriteRuleTokenStream(adaptor,"token TIMESERIES");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");

		try {
			// WreslTree.g:401:10: ( ( '[' sc= LOCAL ']' )? IDENT '{' TIMESERIES (b= STRING )? KIND k= STRING UNITS u= STRING ( CONVERT c= STRING )? '}' -> ^( Svar_dss Scope[$sc.text] IDENT B_part[$b.text] Kind $k Units $u CONVERT[$c.text] ) )
			// WreslTree.g:402:2: ( '[' sc= LOCAL ']' )? IDENT '{' TIMESERIES (b= STRING )? KIND k= STRING UNITS u= STRING ( CONVERT c= STRING )? '}'
			{
			// WreslTree.g:402:2: ( '[' sc= LOCAL ']' )?
			int alt80=2;
			int LA80_0 = input.LA(1);
			if ( (LA80_0==153) ) {
				alt80=1;
			}
			switch (alt80) {
				case 1 :
					// WreslTree.g:402:4: '[' sc= LOCAL ']'
					{
					char_literal251=(Token)match(input,153,FOLLOW_153_in_svar_dss3444); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal251);

					sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_svar_dss3448); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LOCAL.add(sc);

					char_literal252=(Token)match(input,154,FOLLOW_154_in_svar_dss3450); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal252);

					}
					break;

			}

			IDENT253=(Token)match(input,IDENT,FOLLOW_IDENT_in_svar_dss3455); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(IDENT253);

			char_literal254=(Token)match(input,157,FOLLOW_157_in_svar_dss3457); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal254);

			TIMESERIES255=(Token)match(input,TIMESERIES,FOLLOW_TIMESERIES_in_svar_dss3459); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_TIMESERIES.add(TIMESERIES255);

			// WreslTree.g:402:46: (b= STRING )?
			int alt81=2;
			int LA81_0 = input.LA(1);
			if ( (LA81_0==STRING) ) {
				alt81=1;
			}
			switch (alt81) {
				case 1 :
					// WreslTree.g:402:46: b= STRING
					{
					b=(Token)match(input,STRING,FOLLOW_STRING_in_svar_dss3463); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STRING.add(b);

					}
					break;

			}

			KIND256=(Token)match(input,KIND,FOLLOW_KIND_in_svar_dss3466); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KIND.add(KIND256);

			k=(Token)match(input,STRING,FOLLOW_STRING_in_svar_dss3470); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(k);

			UNITS257=(Token)match(input,UNITS,FOLLOW_UNITS_in_svar_dss3472); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_UNITS.add(UNITS257);

			u=(Token)match(input,STRING,FOLLOW_STRING_in_svar_dss3476); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(u);

			// WreslTree.g:402:84: ( CONVERT c= STRING )?
			int alt82=2;
			int LA82_0 = input.LA(1);
			if ( (LA82_0==CONVERT) ) {
				alt82=1;
			}
			switch (alt82) {
				case 1 :
					// WreslTree.g:402:85: CONVERT c= STRING
					{
					CONVERT258=(Token)match(input,CONVERT,FOLLOW_CONVERT_in_svar_dss3479); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_CONVERT.add(CONVERT258);

					c=(Token)match(input,STRING,FOLLOW_STRING_in_svar_dss3483); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_STRING.add(c);

					}
					break;

			}

			char_literal259=(Token)match(input,158,FOLLOW_158_in_svar_dss3487); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal259);

			// AST REWRITE
			// elements: u, k, IDENT, CONVERT
			// token labels: u, k
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_u=new RewriteRuleTokenStream(adaptor,"token u",u);
			RewriteRuleTokenStream stream_k=new RewriteRuleTokenStream(adaptor,"token k",k);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 403:2: -> ^( Svar_dss Scope[$sc.text] IDENT B_part[$b.text] Kind $k Units $u CONVERT[$c.text] )
			{
				// WreslTree.g:403:5: ^( Svar_dss Scope[$sc.text] IDENT B_part[$b.text] Kind $k Units $u CONVERT[$c.text] )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Svar_dss, "Svar_dss"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_IDENT.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(B_part, (b!=null?b.getText():null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Kind, "Kind"));
				adaptor.addChild(root_1, stream_k.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Units, "Units"));
				adaptor.addChild(root_1, stream_u.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(CONVERT, (c!=null?c.getText():null)));
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "svar_dss"


	public static class timeArraySize_return extends ParserRuleReturnScope {
		public String dependant;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "timeArraySize"
	// WreslTree.g:406:1: timeArraySize returns [String dependant] : ( INTEGER | (i= IDENT ) );
	public final WreslTreeParser.timeArraySize_return timeArraySize() throws RecognitionException {
		WreslTreeParser.timeArraySize_return retval = new WreslTreeParser.timeArraySize_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token INTEGER260=null;

		CommonTree i_tree=null;
		CommonTree INTEGER260_tree=null;

		 String dependant = ""; 
		try {
			// WreslTree.g:409:2: ( INTEGER | (i= IDENT ) )
			int alt83=2;
			int LA83_0 = input.LA(1);
			if ( (LA83_0==INTEGER) ) {
				alt83=1;
			}
			else if ( (LA83_0==IDENT) ) {
				alt83=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 83, 0, input);
				throw nvae;
			}

			switch (alt83) {
				case 1 :
					// WreslTree.g:409:4: INTEGER
					{
					root_0 = (CommonTree)adaptor.nil();


					INTEGER260=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_timeArraySize3542); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INTEGER260_tree = (CommonTree)adaptor.create(INTEGER260);
					adaptor.addChild(root_0, INTEGER260_tree);
					}

					}
					break;
				case 2 :
					// WreslTree.g:410:4: (i= IDENT )
					{
					root_0 = (CommonTree)adaptor.nil();


					// WreslTree.g:410:4: (i= IDENT )
					// WreslTree.g:410:6: i= IDENT
					{
					i=(Token)match(input,IDENT,FOLLOW_IDENT_in_timeArraySize3553); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					i_tree = (CommonTree)adaptor.create(i);
					adaptor.addChild(root_0, i_tree);
					}

					if ( state.backtracking==0 ) { retval.dependant =(i!=null?i.getText():null); }
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "timeArraySize"


	public static class dvar_std_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvar_std"
	// WreslTree.g:413:1: dvar_std : ( '(' ta= timeArraySize ')' )? ( '[' sc= LOCAL ']' )? IDENT '{' STD KIND k= STRING UNITS u= STRING '}' -> {ta==null}? ^( Dvar_std Scope[$sc.text] IDENT Kind $k Units $u) -> ^( DvarTimeArray_std TimeArraySize[$ta.text] Scope[$sc.text] IDENT Kind $k Units $u) ;
	public final WreslTreeParser.dvar_std_return dvar_std() throws RecognitionException {
		WreslTreeParser.dvar_std_return retval = new WreslTreeParser.dvar_std_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token k=null;
		Token u=null;
		Token char_literal261=null;
		Token char_literal262=null;
		Token char_literal263=null;
		Token char_literal264=null;
		Token IDENT265=null;
		Token char_literal266=null;
		Token STD267=null;
		Token KIND268=null;
		Token UNITS269=null;
		Token char_literal270=null;
		ParserRuleReturnScope ta =null;

		CommonTree sc_tree=null;
		CommonTree k_tree=null;
		CommonTree u_tree=null;
		CommonTree char_literal261_tree=null;
		CommonTree char_literal262_tree=null;
		CommonTree char_literal263_tree=null;
		CommonTree char_literal264_tree=null;
		CommonTree IDENT265_tree=null;
		CommonTree char_literal266_tree=null;
		CommonTree STD267_tree=null;
		CommonTree KIND268_tree=null;
		CommonTree UNITS269_tree=null;
		CommonTree char_literal270_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_STD=new RewriteRuleTokenStream(adaptor,"token STD");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
		RewriteRuleTokenStream stream_KIND=new RewriteRuleTokenStream(adaptor,"token KIND");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleTokenStream stream_140=new RewriteRuleTokenStream(adaptor,"token 140");
		RewriteRuleTokenStream stream_UNITS=new RewriteRuleTokenStream(adaptor,"token UNITS");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_timeArraySize=new RewriteRuleSubtreeStream(adaptor,"rule timeArraySize");

		try {
			// WreslTree.g:413:10: ( ( '(' ta= timeArraySize ')' )? ( '[' sc= LOCAL ']' )? IDENT '{' STD KIND k= STRING UNITS u= STRING '}' -> {ta==null}? ^( Dvar_std Scope[$sc.text] IDENT Kind $k Units $u) -> ^( DvarTimeArray_std TimeArraySize[$ta.text] Scope[$sc.text] IDENT Kind $k Units $u) )
			// WreslTree.g:414:2: ( '(' ta= timeArraySize ')' )? ( '[' sc= LOCAL ']' )? IDENT '{' STD KIND k= STRING UNITS u= STRING '}'
			{
			// WreslTree.g:414:2: ( '(' ta= timeArraySize ')' )?
			int alt84=2;
			int LA84_0 = input.LA(1);
			if ( (LA84_0==139) ) {
				alt84=1;
			}
			switch (alt84) {
				case 1 :
					// WreslTree.g:414:4: '(' ta= timeArraySize ')'
					{
					char_literal261=(Token)match(input,139,FOLLOW_139_in_dvar_std3576); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_139.add(char_literal261);

					pushFollow(FOLLOW_timeArraySize_in_dvar_std3580);
					ta=timeArraySize();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_timeArraySize.add(ta.getTree());
					char_literal262=(Token)match(input,140,FOLLOW_140_in_dvar_std3582); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_140.add(char_literal262);

					}
					break;

			}

			// WreslTree.g:414:31: ( '[' sc= LOCAL ']' )?
			int alt85=2;
			int LA85_0 = input.LA(1);
			if ( (LA85_0==153) ) {
				alt85=1;
			}
			switch (alt85) {
				case 1 :
					// WreslTree.g:414:33: '[' sc= LOCAL ']'
					{
					char_literal263=(Token)match(input,153,FOLLOW_153_in_dvar_std3588); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal263);

					sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_dvar_std3592); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LOCAL.add(sc);

					char_literal264=(Token)match(input,154,FOLLOW_154_in_dvar_std3594); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal264);

					}
					break;

			}

			IDENT265=(Token)match(input,IDENT,FOLLOW_IDENT_in_dvar_std3599); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(IDENT265);

			char_literal266=(Token)match(input,157,FOLLOW_157_in_dvar_std3601); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal266);

			STD267=(Token)match(input,STD,FOLLOW_STD_in_dvar_std3603); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STD.add(STD267);

			KIND268=(Token)match(input,KIND,FOLLOW_KIND_in_dvar_std3605); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KIND.add(KIND268);

			k=(Token)match(input,STRING,FOLLOW_STRING_in_dvar_std3609); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(k);

			UNITS269=(Token)match(input,UNITS,FOLLOW_UNITS_in_dvar_std3611); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_UNITS.add(UNITS269);

			u=(Token)match(input,STRING,FOLLOW_STRING_in_dvar_std3615); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(u);

			char_literal270=(Token)match(input,158,FOLLOW_158_in_dvar_std3617); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal270);

			// AST REWRITE
			// elements: u, u, k, k, IDENT, IDENT
			// token labels: u, k
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_u=new RewriteRuleTokenStream(adaptor,"token u",u);
			RewriteRuleTokenStream stream_k=new RewriteRuleTokenStream(adaptor,"token k",k);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 415:2: -> {ta==null}? ^( Dvar_std Scope[$sc.text] IDENT Kind $k Units $u)
			if (ta==null) {
				// WreslTree.g:415:18: ^( Dvar_std Scope[$sc.text] IDENT Kind $k Units $u)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Dvar_std, "Dvar_std"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_IDENT.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Kind, "Kind"));
				adaptor.addChild(root_1, stream_k.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Units, "Units"));
				adaptor.addChild(root_1, stream_u.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}

			else // 416:2: -> ^( DvarTimeArray_std TimeArraySize[$ta.text] Scope[$sc.text] IDENT Kind $k Units $u)
			{
				// WreslTree.g:416:17: ^( DvarTimeArray_std TimeArraySize[$ta.text] Scope[$sc.text] IDENT Kind $k Units $u)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DvarTimeArray_std, "DvarTimeArray_std"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TimeArraySize, (ta!=null?input.toString(ta.start,ta.stop):null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_IDENT.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Kind, "Kind"));
				adaptor.addChild(root_1, stream_k.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Units, "Units"));
				adaptor.addChild(root_1, stream_u.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "dvar_std"


	public static class dvar_nonStd_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvar_nonStd"
	// WreslTree.g:419:1: dvar_nonStd : ( '(' ta= timeArraySize ')' )? ( '[' sc= LOCAL ']' )? IDENT '{' lower_and_or_upper KIND k= STRING UNITS u= STRING '}' -> {ta==null}? ^( Dvar_nonStd Scope[$sc.text] IDENT lower_and_or_upper Kind $k Units $u) -> ^( DvarTimeArray_nonStd TimeArraySize[$ta.text] Scope[$sc.text] IDENT lower_and_or_upper Kind $k Units $u) ;
	public final WreslTreeParser.dvar_nonStd_return dvar_nonStd() throws RecognitionException {
		WreslTreeParser.dvar_nonStd_return retval = new WreslTreeParser.dvar_nonStd_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token sc=null;
		Token k=null;
		Token u=null;
		Token char_literal271=null;
		Token char_literal272=null;
		Token char_literal273=null;
		Token char_literal274=null;
		Token IDENT275=null;
		Token char_literal276=null;
		Token KIND278=null;
		Token UNITS279=null;
		Token char_literal280=null;
		ParserRuleReturnScope ta =null;
		ParserRuleReturnScope lower_and_or_upper277 =null;

		CommonTree sc_tree=null;
		CommonTree k_tree=null;
		CommonTree u_tree=null;
		CommonTree char_literal271_tree=null;
		CommonTree char_literal272_tree=null;
		CommonTree char_literal273_tree=null;
		CommonTree char_literal274_tree=null;
		CommonTree IDENT275_tree=null;
		CommonTree char_literal276_tree=null;
		CommonTree KIND278_tree=null;
		CommonTree UNITS279_tree=null;
		CommonTree char_literal280_tree=null;
		RewriteRuleTokenStream stream_154=new RewriteRuleTokenStream(adaptor,"token 154");
		RewriteRuleTokenStream stream_157=new RewriteRuleTokenStream(adaptor,"token 157");
		RewriteRuleTokenStream stream_158=new RewriteRuleTokenStream(adaptor,"token 158");
		RewriteRuleTokenStream stream_IDENT=new RewriteRuleTokenStream(adaptor,"token IDENT");
		RewriteRuleTokenStream stream_139=new RewriteRuleTokenStream(adaptor,"token 139");
		RewriteRuleTokenStream stream_KIND=new RewriteRuleTokenStream(adaptor,"token KIND");
		RewriteRuleTokenStream stream_LOCAL=new RewriteRuleTokenStream(adaptor,"token LOCAL");
		RewriteRuleTokenStream stream_STRING=new RewriteRuleTokenStream(adaptor,"token STRING");
		RewriteRuleTokenStream stream_140=new RewriteRuleTokenStream(adaptor,"token 140");
		RewriteRuleTokenStream stream_UNITS=new RewriteRuleTokenStream(adaptor,"token UNITS");
		RewriteRuleTokenStream stream_153=new RewriteRuleTokenStream(adaptor,"token 153");
		RewriteRuleSubtreeStream stream_timeArraySize=new RewriteRuleSubtreeStream(adaptor,"rule timeArraySize");
		RewriteRuleSubtreeStream stream_lower_and_or_upper=new RewriteRuleSubtreeStream(adaptor,"rule lower_and_or_upper");

		try {
			// WreslTree.g:419:13: ( ( '(' ta= timeArraySize ')' )? ( '[' sc= LOCAL ']' )? IDENT '{' lower_and_or_upper KIND k= STRING UNITS u= STRING '}' -> {ta==null}? ^( Dvar_nonStd Scope[$sc.text] IDENT lower_and_or_upper Kind $k Units $u) -> ^( DvarTimeArray_nonStd TimeArraySize[$ta.text] Scope[$sc.text] IDENT lower_and_or_upper Kind $k Units $u) )
			// WreslTree.g:420:2: ( '(' ta= timeArraySize ')' )? ( '[' sc= LOCAL ']' )? IDENT '{' lower_and_or_upper KIND k= STRING UNITS u= STRING '}'
			{
			// WreslTree.g:420:2: ( '(' ta= timeArraySize ')' )?
			int alt86=2;
			int LA86_0 = input.LA(1);
			if ( (LA86_0==139) ) {
				alt86=1;
			}
			switch (alt86) {
				case 1 :
					// WreslTree.g:420:4: '(' ta= timeArraySize ')'
					{
					char_literal271=(Token)match(input,139,FOLLOW_139_in_dvar_nonStd3730); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_139.add(char_literal271);

					pushFollow(FOLLOW_timeArraySize_in_dvar_nonStd3734);
					ta=timeArraySize();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_timeArraySize.add(ta.getTree());
					char_literal272=(Token)match(input,140,FOLLOW_140_in_dvar_nonStd3736); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_140.add(char_literal272);

					}
					break;

			}

			// WreslTree.g:420:31: ( '[' sc= LOCAL ']' )?
			int alt87=2;
			int LA87_0 = input.LA(1);
			if ( (LA87_0==153) ) {
				alt87=1;
			}
			switch (alt87) {
				case 1 :
					// WreslTree.g:420:33: '[' sc= LOCAL ']'
					{
					char_literal273=(Token)match(input,153,FOLLOW_153_in_dvar_nonStd3742); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_153.add(char_literal273);

					sc=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_dvar_nonStd3746); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_LOCAL.add(sc);

					char_literal274=(Token)match(input,154,FOLLOW_154_in_dvar_nonStd3748); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_154.add(char_literal274);

					}
					break;

			}

			IDENT275=(Token)match(input,IDENT,FOLLOW_IDENT_in_dvar_nonStd3753); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_IDENT.add(IDENT275);

			char_literal276=(Token)match(input,157,FOLLOW_157_in_dvar_nonStd3755); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_157.add(char_literal276);

			pushFollow(FOLLOW_lower_and_or_upper_in_dvar_nonStd3757);
			lower_and_or_upper277=lower_and_or_upper();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_lower_and_or_upper.add(lower_and_or_upper277.getTree());
			KIND278=(Token)match(input,KIND,FOLLOW_KIND_in_dvar_nonStd3759); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_KIND.add(KIND278);

			k=(Token)match(input,STRING,FOLLOW_STRING_in_dvar_nonStd3763); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(k);

			UNITS279=(Token)match(input,UNITS,FOLLOW_UNITS_in_dvar_nonStd3765); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_UNITS.add(UNITS279);

			u=(Token)match(input,STRING,FOLLOW_STRING_in_dvar_nonStd3769); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_STRING.add(u);

			char_literal280=(Token)match(input,158,FOLLOW_158_in_dvar_nonStd3771); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_158.add(char_literal280);

			// AST REWRITE
			// elements: u, IDENT, IDENT, k, lower_and_or_upper, u, k, lower_and_or_upper
			// token labels: u, k
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleTokenStream stream_u=new RewriteRuleTokenStream(adaptor,"token u",u);
			RewriteRuleTokenStream stream_k=new RewriteRuleTokenStream(adaptor,"token k",k);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 421:2: -> {ta==null}? ^( Dvar_nonStd Scope[$sc.text] IDENT lower_and_or_upper Kind $k Units $u)
			if (ta==null) {
				// WreslTree.g:421:18: ^( Dvar_nonStd Scope[$sc.text] IDENT lower_and_or_upper Kind $k Units $u)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(Dvar_nonStd, "Dvar_nonStd"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_IDENT.nextNode());
				adaptor.addChild(root_1, stream_lower_and_or_upper.nextTree());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Kind, "Kind"));
				adaptor.addChild(root_1, stream_k.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Units, "Units"));
				adaptor.addChild(root_1, stream_u.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}

			else // 422:2: -> ^( DvarTimeArray_nonStd TimeArraySize[$ta.text] Scope[$sc.text] IDENT lower_and_or_upper Kind $k Units $u)
			{
				// WreslTree.g:422:18: ^( DvarTimeArray_nonStd TimeArraySize[$ta.text] Scope[$sc.text] IDENT lower_and_or_upper Kind $k Units $u)
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(DvarTimeArray_nonStd, "DvarTimeArray_nonStd"), root_1);
				adaptor.addChild(root_1, (CommonTree)adaptor.create(TimeArraySize, (ta!=null?input.toString(ta.start,ta.stop):null)));
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Scope, (sc!=null?sc.getText():null)));
				adaptor.addChild(root_1, stream_IDENT.nextNode());
				adaptor.addChild(root_1, stream_lower_and_or_upper.nextTree());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Kind, "Kind"));
				adaptor.addChild(root_1, stream_k.nextNode());
				adaptor.addChild(root_1, (CommonTree)adaptor.create(Units, "Units"));
				adaptor.addChild(root_1, stream_u.nextNode());
				adaptor.addChild(root_0, root_1);
				}

			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "dvar_nonStd"


	public static class lower_and_or_upper_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lower_and_or_upper"
	// WreslTree.g:425:1: lower_and_or_upper : ( lower_upper | upper_lower );
	public final WreslTreeParser.lower_and_or_upper_return lower_and_or_upper() throws RecognitionException {
		WreslTreeParser.lower_and_or_upper_return retval = new WreslTreeParser.lower_and_or_upper_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope lower_upper281 =null;
		ParserRuleReturnScope upper_lower282 =null;


		try {
			// WreslTree.g:425:20: ( lower_upper | upper_lower )
			int alt88=2;
			int LA88_0 = input.LA(1);
			if ( (LA88_0==LOWER) ) {
				alt88=1;
			}
			else if ( (LA88_0==UPPER) ) {
				alt88=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 88, 0, input);
				throw nvae;
			}

			switch (alt88) {
				case 1 :
					// WreslTree.g:425:22: lower_upper
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_lower_upper_in_lower_and_or_upper3885);
					lower_upper281=lower_upper();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, lower_upper281.getTree());

					}
					break;
				case 2 :
					// WreslTree.g:426:10: upper_lower
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_upper_lower_in_lower_and_or_upper3896);
					upper_lower282=upper_lower();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, upper_lower282.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "lower_and_or_upper"


	public static class lower_upper_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lower_upper"
	// WreslTree.g:428:1: lower_upper : lower (u= upper )? -> {u==null}? lower Upper LimitType[Param.upper_unbounded] -> lower $u;
	public final WreslTreeParser.lower_upper_return lower_upper() throws RecognitionException {
		WreslTreeParser.lower_upper_return retval = new WreslTreeParser.lower_upper_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope u =null;
		ParserRuleReturnScope lower283 =null;

		RewriteRuleSubtreeStream stream_lower=new RewriteRuleSubtreeStream(adaptor,"rule lower");
		RewriteRuleSubtreeStream stream_upper=new RewriteRuleSubtreeStream(adaptor,"rule upper");

		try {
			// WreslTree.g:428:13: ( lower (u= upper )? -> {u==null}? lower Upper LimitType[Param.upper_unbounded] -> lower $u)
			// WreslTree.g:428:15: lower (u= upper )?
			{
			pushFollow(FOLLOW_lower_in_lower_upper3912);
			lower283=lower();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_lower.add(lower283.getTree());
			// WreslTree.g:428:21: (u= upper )?
			int alt89=2;
			int LA89_0 = input.LA(1);
			if ( (LA89_0==UPPER) ) {
				alt89=1;
			}
			switch (alt89) {
				case 1 :
					// WreslTree.g:428:22: u= upper
					{
					pushFollow(FOLLOW_upper_in_lower_upper3917);
					u=upper();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_upper.add(u.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: lower, lower, u
			// token labels: 
			// rule labels: u, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_u=new RewriteRuleSubtreeStream(adaptor,"rule u",u!=null?u.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 429:5: -> {u==null}? lower Upper LimitType[Param.upper_unbounded]
			if (u==null) {
				adaptor.addChild(root_0, stream_lower.nextTree());
				adaptor.addChild(root_0, (CommonTree)adaptor.create(Upper, "Upper"));
				adaptor.addChild(root_0, (CommonTree)adaptor.create(LimitType, Param.upper_unbounded));
			}

			else // 430:5: -> lower $u
			{
				adaptor.addChild(root_0, stream_lower.nextTree());
				adaptor.addChild(root_0, stream_u.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "lower_upper"


	public static class upper_lower_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "upper_lower"
	// WreslTree.g:432:1: upper_lower : upper (l= lower )? -> {l==null}? Lower LimitType[\"0\"] upper -> $l upper ;
	public final WreslTreeParser.upper_lower_return upper_lower() throws RecognitionException {
		WreslTreeParser.upper_lower_return retval = new WreslTreeParser.upper_lower_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope l =null;
		ParserRuleReturnScope upper284 =null;

		RewriteRuleSubtreeStream stream_upper=new RewriteRuleSubtreeStream(adaptor,"rule upper");
		RewriteRuleSubtreeStream stream_lower=new RewriteRuleSubtreeStream(adaptor,"rule lower");

		try {
			// WreslTree.g:432:13: ( upper (l= lower )? -> {l==null}? Lower LimitType[\"0\"] upper -> $l upper )
			// WreslTree.g:432:15: upper (l= lower )?
			{
			pushFollow(FOLLOW_upper_in_upper_lower3969);
			upper284=upper();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_upper.add(upper284.getTree());
			// WreslTree.g:432:21: (l= lower )?
			int alt90=2;
			int LA90_0 = input.LA(1);
			if ( (LA90_0==LOWER) ) {
				alt90=1;
			}
			switch (alt90) {
				case 1 :
					// WreslTree.g:432:22: l= lower
					{
					pushFollow(FOLLOW_lower_in_upper_lower3974);
					l=lower();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_lower.add(l.getTree());
					}
					break;

			}

			// AST REWRITE
			// elements: upper, l, upper
			// token labels: 
			// rule labels: l, retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_l=new RewriteRuleSubtreeStream(adaptor,"rule l",l!=null?l.getTree():null);
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 433:17: -> {l==null}? Lower LimitType[\"0\"] upper
			if (l==null) {
				adaptor.addChild(root_0, (CommonTree)adaptor.create(Lower, "Lower"));
				adaptor.addChild(root_0, (CommonTree)adaptor.create(LimitType, "0"));
				adaptor.addChild(root_0, stream_upper.nextTree());
			}

			else // 434:17: -> $l upper
			{
				adaptor.addChild(root_0, stream_l.nextTree());
				adaptor.addChild(root_0, stream_upper.nextTree());
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "upper_lower"


	public static class lower_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lower"
	// WreslTree.g:437:1: lower : LOWER ( UNBOUNDED -> Lower LimitType[Param.lower_unbounded] |e= expression -> Lower LimitType[$e.tree.toStringTree().replaceAll(\"\\\\s+\", \"\")] ) ;
	public final WreslTreeParser.lower_return lower() throws RecognitionException {
		WreslTreeParser.lower_return retval = new WreslTreeParser.lower_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LOWER285=null;
		Token UNBOUNDED286=null;
		ParserRuleReturnScope e =null;

		CommonTree LOWER285_tree=null;
		CommonTree UNBOUNDED286_tree=null;
		RewriteRuleTokenStream stream_UNBOUNDED=new RewriteRuleTokenStream(adaptor,"token UNBOUNDED");
		RewriteRuleTokenStream stream_LOWER=new RewriteRuleTokenStream(adaptor,"token LOWER");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// WreslTree.g:437:6: ( LOWER ( UNBOUNDED -> Lower LimitType[Param.lower_unbounded] |e= expression -> Lower LimitType[$e.tree.toStringTree().replaceAll(\"\\\\s+\", \"\")] ) )
			// WreslTree.g:437:8: LOWER ( UNBOUNDED -> Lower LimitType[Param.lower_unbounded] |e= expression -> Lower LimitType[$e.tree.toStringTree().replaceAll(\"\\\\s+\", \"\")] )
			{
			LOWER285=(Token)match(input,LOWER,FOLLOW_LOWER_in_lower4061); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_LOWER.add(LOWER285);

			// WreslTree.g:437:14: ( UNBOUNDED -> Lower LimitType[Param.lower_unbounded] |e= expression -> Lower LimitType[$e.tree.toStringTree().replaceAll(\"\\\\s+\", \"\")] )
			int alt91=2;
			int LA91_0 = input.LA(1);
			if ( (LA91_0==UNBOUNDED) ) {
				alt91=1;
			}
			else if ( (LA91_0==FLOAT||LA91_0==IDENT||(LA91_0 >= INT && LA91_0 <= INTEGER)||(LA91_0 >= MAX && LA91_0 <= MIN)||LA91_0==ROUND||(LA91_0 >= 138 && LA91_0 <= 139)||LA91_0==142||LA91_0==144) ) {
				alt91=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 91, 0, input);
				throw nvae;
			}

			switch (alt91) {
				case 1 :
					// WreslTree.g:437:16: UNBOUNDED
					{
					UNBOUNDED286=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_lower4065); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED286);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 437:26: -> Lower LimitType[Param.lower_unbounded]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Lower, "Lower"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LimitType, Param.lower_unbounded));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// WreslTree.g:437:70: e= expression
					{
					pushFollow(FOLLOW_expression_in_lower4078);
					e=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expression.add(e.getTree());
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 437:83: -> Lower LimitType[$e.tree.toStringTree().replaceAll(\"\\\\s+\", \"\")]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Lower, "Lower"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LimitType, (e!=null?((CommonTree)e.getTree()):null).toStringTree().replaceAll("\\s+", "")));
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "lower"


	public static class upper_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "upper"
	// WreslTree.g:438:1: upper : UPPER ( UNBOUNDED -> Upper LimitType[Param.upper_unbounded] |e= expression -> Upper LimitType[$e.tree.toStringTree().replaceAll(\"\\\\s+\", \"\")] ) ;
	public final WreslTreeParser.upper_return upper() throws RecognitionException {
		WreslTreeParser.upper_return retval = new WreslTreeParser.upper_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token UPPER287=null;
		Token UNBOUNDED288=null;
		ParserRuleReturnScope e =null;

		CommonTree UPPER287_tree=null;
		CommonTree UNBOUNDED288_tree=null;
		RewriteRuleTokenStream stream_UPPER=new RewriteRuleTokenStream(adaptor,"token UPPER");
		RewriteRuleTokenStream stream_UNBOUNDED=new RewriteRuleTokenStream(adaptor,"token UNBOUNDED");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");

		try {
			// WreslTree.g:438:6: ( UPPER ( UNBOUNDED -> Upper LimitType[Param.upper_unbounded] |e= expression -> Upper LimitType[$e.tree.toStringTree().replaceAll(\"\\\\s+\", \"\")] ) )
			// WreslTree.g:438:8: UPPER ( UNBOUNDED -> Upper LimitType[Param.upper_unbounded] |e= expression -> Upper LimitType[$e.tree.toStringTree().replaceAll(\"\\\\s+\", \"\")] )
			{
			UPPER287=(Token)match(input,UPPER,FOLLOW_UPPER_in_upper4094); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_UPPER.add(UPPER287);

			// WreslTree.g:438:14: ( UNBOUNDED -> Upper LimitType[Param.upper_unbounded] |e= expression -> Upper LimitType[$e.tree.toStringTree().replaceAll(\"\\\\s+\", \"\")] )
			int alt92=2;
			int LA92_0 = input.LA(1);
			if ( (LA92_0==UNBOUNDED) ) {
				alt92=1;
			}
			else if ( (LA92_0==FLOAT||LA92_0==IDENT||(LA92_0 >= INT && LA92_0 <= INTEGER)||(LA92_0 >= MAX && LA92_0 <= MIN)||LA92_0==ROUND||(LA92_0 >= 138 && LA92_0 <= 139)||LA92_0==142||LA92_0==144) ) {
				alt92=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 92, 0, input);
				throw nvae;
			}

			switch (alt92) {
				case 1 :
					// WreslTree.g:438:16: UNBOUNDED
					{
					UNBOUNDED288=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_upper4098); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_UNBOUNDED.add(UNBOUNDED288);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 438:26: -> Upper LimitType[Param.upper_unbounded]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Upper, "Upper"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LimitType, Param.upper_unbounded));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// WreslTree.g:438:70: e= expression
					{
					pushFollow(FOLLOW_expression_in_upper4111);
					e=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) stream_expression.add(e.getTree());
					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 438:83: -> Upper LimitType[$e.tree.toStringTree().replaceAll(\"\\\\s+\", \"\")]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(Upper, "Upper"));
						adaptor.addChild(root_0, (CommonTree)adaptor.create(LimitType, (e!=null?((CommonTree)e.getTree()):null).toStringTree().replaceAll("\\s+", "")));
					}


					retval.tree = root_0;
					}

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "upper"


	public static class constraint_statement_return extends ParserRuleReturnScope {
		public String text;
		public String dependants;
		public String varInCycle;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "constraint_statement"
	// WreslTree.g:444:1: constraint_statement returns [String text, String dependants, String varInCycle] : c= constraint_statement_preprocessed ;
	public final WreslTreeParser.constraint_statement_return constraint_statement() throws RecognitionException {
		WreslTreeParser.constraint_statement_return retval = new WreslTreeParser.constraint_statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope c =null;


		try {
			// WreslTree.g:445:2: (c= constraint_statement_preprocessed )
			// WreslTree.g:445:4: c= constraint_statement_preprocessed
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_constraint_statement_preprocessed_in_constraint_statement4139);
			c=constraint_statement_preprocessed();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());

			if ( state.backtracking==0 ) {  retval.text = Tools.replace_ignoreChar((c!=null?input.toString(c.start,c.stop):null)); 
				    retval.text = Tools.replace_seperator(retval.text); 
				    retval.dependants = (c!=null?((WreslTreeParser.constraint_statement_preprocessed_return)c).dependants:null);
				    retval.varInCycle = (c!=null?((WreslTreeParser.constraint_statement_preprocessed_return)c).varInCycle:null);
				 }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "constraint_statement"


	public static class constraint_statement_preprocessed_return extends ParserRuleReturnScope {
		public String dependants;
		public String varInCycle;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "constraint_statement_preprocessed"
	// WreslTree.g:453:1: constraint_statement_preprocessed returns [String dependants, String varInCycle] : c= expression ( '<' | '>' | '=' ) d= expression ;
	public final WreslTreeParser.constraint_statement_preprocessed_return constraint_statement_preprocessed() throws RecognitionException {
		WreslTreeParser.constraint_statement_preprocessed_return retval = new WreslTreeParser.constraint_statement_preprocessed_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set289=null;
		ParserRuleReturnScope c =null;
		ParserRuleReturnScope d =null;

		CommonTree set289_tree=null;

		try {
			// WreslTree.g:454:2: (c= expression ( '<' | '>' | '=' ) d= expression )
			// WreslTree.g:454:4: c= expression ( '<' | '>' | '=' ) d= expression
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expression_in_constraint_statement_preprocessed4161);
			c=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());

			set289=input.LT(1);
			if ( input.LA(1)==147||input.LA(1)==149||input.LA(1)==151 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set289));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			pushFollow(FOLLOW_expression_in_constraint_statement_preprocessed4180);
			d=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, d.getTree());

			if ( state.backtracking==0 ) { retval.dependants = (c!=null?((WreslTreeParser.expression_return)c).dependants:null) + " " + (d!=null?((WreslTreeParser.expression_return)d).dependants:null);
				  retval.varInCycle = (c!=null?((WreslTreeParser.expression_return)c).strVarInCycle:null) + " " + (d!=null?((WreslTreeParser.expression_return)d).strVarInCycle:null);
				}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "constraint_statement_preprocessed"


	public static class assignment_return extends ParserRuleReturnScope {
		public String dependants;
		public String varInCycle;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assignment"
	// WreslTree.g:462:1: assignment returns [String dependants, String varInCycle] : t= term_simple '=' e= expression -> Assignment[$t.text+\"=\"+$e.text] ;
	public final WreslTreeParser.assignment_return assignment() throws RecognitionException {
		WreslTreeParser.assignment_return retval = new WreslTreeParser.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal290=null;
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope e =null;

		CommonTree char_literal290_tree=null;
		RewriteRuleTokenStream stream_149=new RewriteRuleTokenStream(adaptor,"token 149");
		RewriteRuleSubtreeStream stream_expression=new RewriteRuleSubtreeStream(adaptor,"rule expression");
		RewriteRuleSubtreeStream stream_term_simple=new RewriteRuleSubtreeStream(adaptor,"rule term_simple");

		try {
			// WreslTree.g:463:2: (t= term_simple '=' e= expression -> Assignment[$t.text+\"=\"+$e.text] )
			// WreslTree.g:463:5: t= term_simple '=' e= expression
			{
			pushFollow(FOLLOW_term_simple_in_assignment4204);
			t=term_simple();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_term_simple.add(t.getTree());
			char_literal290=(Token)match(input,149,FOLLOW_149_in_assignment4207); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_149.add(char_literal290);

			pushFollow(FOLLOW_expression_in_assignment4211);
			e=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) stream_expression.add(e.getTree());
			if ( state.backtracking==0 ) { retval.dependants = Tools.remove_nulls((e!=null?((WreslTreeParser.expression_return)e).dependants:null)); 
					  retval.varInCycle = Tools.remove_nulls((e!=null?((WreslTreeParser.expression_return)e).strVarInCycle:null));}
			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 466:2: -> Assignment[$t.text+\"=\"+$e.text]
			{
				adaptor.addChild(root_0, (CommonTree)adaptor.create(Assignment, (t!=null?input.toString(t.start,t.stop):null)+"="+(e!=null?((WreslTreeParser.expression_return)e).text:null)));
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "assignment"


	public static class lt_or_gt_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lt_or_gt"
	// WreslTree.g:469:1: lt_or_gt : term_simple ( '<' | '>' ) expression ;
	public final WreslTreeParser.lt_or_gt_return lt_or_gt() throws RecognitionException {
		WreslTreeParser.lt_or_gt_return retval = new WreslTreeParser.lt_or_gt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set292=null;
		ParserRuleReturnScope term_simple291 =null;
		ParserRuleReturnScope expression293 =null;

		CommonTree set292_tree=null;

		try {
			// WreslTree.g:469:10: ( term_simple ( '<' | '>' ) expression )
			// WreslTree.g:469:25: term_simple ( '<' | '>' ) expression
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_term_simple_in_lt_or_gt4249);
			term_simple291=term_simple();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term_simple291.getTree());

			set292=input.LT(1);
			if ( input.LA(1)==147||input.LA(1)==151 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set292));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			pushFollow(FOLLOW_expression_in_lt_or_gt4263);
			expression293=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression293.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "lt_or_gt"


	public static class le_or_ge_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "le_or_ge"
	// WreslTree.g:470:1: le_or_ge : term_simple ( '<=' | '>=' ) expression ;
	public final WreslTreeParser.le_or_ge_return le_or_ge() throws RecognitionException {
		WreslTreeParser.le_or_ge_return retval = new WreslTreeParser.le_or_ge_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set295=null;
		ParserRuleReturnScope term_simple294 =null;
		ParserRuleReturnScope expression296 =null;

		CommonTree set295_tree=null;

		try {
			// WreslTree.g:470:10: ( term_simple ( '<=' | '>=' ) expression )
			// WreslTree.g:470:25: term_simple ( '<=' | '>=' ) expression
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_term_simple_in_le_or_ge4284);
			term_simple294=term_simple();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term_simple294.getTree());

			set295=input.LT(1);
			if ( input.LA(1)==148||input.LA(1)==152 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set295));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			pushFollow(FOLLOW_expression_in_le_or_ge4296);
			expression296=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression296.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "le_or_ge"


	public static class equal_statement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "equal_statement"
	// WreslTree.g:471:1: equal_statement : term_simple '==' expression ;
	public final WreslTreeParser.equal_statement_return equal_statement() throws RecognitionException {
		WreslTreeParser.equal_statement_return retval = new WreslTreeParser.equal_statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal298=null;
		ParserRuleReturnScope term_simple297 =null;
		ParserRuleReturnScope expression299 =null;

		CommonTree string_literal298_tree=null;

		try {
			// WreslTree.g:471:17: ( term_simple '==' expression )
			// WreslTree.g:471:25: term_simple '==' expression
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_term_simple_in_equal_statement4310);
			term_simple297=term_simple();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term_simple297.getTree());

			string_literal298=(Token)match(input,150,FOLLOW_150_in_equal_statement4312); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal298_tree = (CommonTree)adaptor.create(string_literal298);
			adaptor.addChild(root_0, string_literal298_tree);
			}

			pushFollow(FOLLOW_expression_in_equal_statement4314);
			expression299=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expression299.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "equal_statement"


	public static class number_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "number"
	// WreslTree.g:474:1: number : ( INTEGER | FLOAT );
	public final WreslTreeParser.number_return number() throws RecognitionException {
		WreslTreeParser.number_return retval = new WreslTreeParser.number_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set300=null;

		CommonTree set300_tree=null;

		try {
			// WreslTree.g:474:8: ( INTEGER | FLOAT )
			// WreslTree.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set300=input.LT(1);
			if ( input.LA(1)==FLOAT||input.LA(1)==INTEGER ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set300));
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

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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


	public static class term_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "term_simple"
	// WreslTree.g:476:1: term_simple : ( ident | number | function );
	public final WreslTreeParser.term_simple_return term_simple() throws RecognitionException {
		WreslTreeParser.term_simple_return retval = new WreslTreeParser.term_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope ident301 =null;
		ParserRuleReturnScope number302 =null;
		ParserRuleReturnScope function303 =null;


		try {
			// WreslTree.g:476:13: ( ident | number | function )
			int alt93=3;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				int LA93_1 = input.LA(2);
				if ( (LA93_1==139||LA93_1==153) ) {
					alt93=3;
				}
				else if ( ((LA93_1 >= 147 && LA93_1 <= 152)) ) {
					alt93=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 93, 1, input);
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
				alt93=2;
				}
				break;
			case INT:
			case MAX:
			case MIN:
			case ROUND:
				{
				alt93=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 93, 0, input);
				throw nvae;
			}
			switch (alt93) {
				case 1 :
					// WreslTree.g:476:15: ident
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_ident_in_term_simple4337);
					ident301=ident();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ident301.getTree());

					}
					break;
				case 2 :
					// WreslTree.g:476:23: number
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_number_in_term_simple4341);
					number302=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, number302.getTree());

					}
					break;
				case 3 :
					// WreslTree.g:476:32: function
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_function_in_term_simple4345);
					function303=function();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, function303.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "term_simple"


	public static class ident_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ident"
	// WreslTree.g:478:1: ident : IDENT ;
	public final WreslTreeParser.ident_return ident() throws RecognitionException {
		WreslTreeParser.ident_return retval = new WreslTreeParser.ident_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT304=null;

		CommonTree IDENT304_tree=null;

		try {
			// WreslTree.g:478:6: ( IDENT )
			// WreslTree.g:478:8: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT304=(Token)match(input,IDENT,FOLLOW_IDENT_in_ident4354); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENT304_tree = (CommonTree)adaptor.create(IDENT304);
			adaptor.addChild(root_0, IDENT304_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "ident"


	public static class array_iterator_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "array_iterator"
	// WreslTree.g:480:1: array_iterator : '$m' ;
	public final WreslTreeParser.array_iterator_return array_iterator() throws RecognitionException {
		WreslTreeParser.array_iterator_return retval = new WreslTreeParser.array_iterator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal305=null;

		CommonTree string_literal305_tree=null;

		try {
			// WreslTree.g:480:16: ( '$m' )
			// WreslTree.g:480:18: '$m'
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal305=(Token)match(input,138,FOLLOW_138_in_array_iterator4363); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal305_tree = (CommonTree)adaptor.create(string_literal305);
			adaptor.addChild(root_0, string_literal305_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "array_iterator"


	public static class term_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "term"
	// WreslTree.g:482:1: term : (i= ident | array_iterator | number | function | '(' e= expression ')' | '(' s= sum_content ')' );
	public final WreslTreeParser.term_return term() throws RecognitionException {
		WreslTreeParser.term_return retval = new WreslTreeParser.term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal309=null;
		Token char_literal310=null;
		Token char_literal311=null;
		Token char_literal312=null;
		ParserRuleReturnScope i =null;
		ParserRuleReturnScope e =null;
		ParserRuleReturnScope s =null;
		ParserRuleReturnScope array_iterator306 =null;
		ParserRuleReturnScope number307 =null;
		ParserRuleReturnScope function308 =null;

		CommonTree char_literal309_tree=null;
		CommonTree char_literal310_tree=null;
		CommonTree char_literal311_tree=null;
		CommonTree char_literal312_tree=null;

		try {
			// WreslTree.g:482:6: (i= ident | array_iterator | number | function | '(' e= expression ')' | '(' s= sum_content ')' )
			int alt94=6;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				int LA94_1 = input.LA(2);
				if ( (LA94_1==139||LA94_1==153) ) {
					alt94=4;
				}
				else if ( (LA94_1==EOF||LA94_1==AND||LA94_1==CASE||LA94_1==KIND||LA94_1==LHS||LA94_1==LOWER||(LA94_1 >= OR && LA94_1 <= ORDER)||LA94_1==RHS||LA94_1==SELECT||LA94_1==SUM||(LA94_1 >= UNITS && LA94_1 <= USE)||LA94_1==VALUE||(LA94_1 >= 140 && LA94_1 <= 152)||LA94_1==154||LA94_1==158) ) {
					alt94=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 94, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 138:
				{
				alt94=2;
				}
				break;
			case FLOAT:
			case INTEGER:
				{
				alt94=3;
				}
				break;
			case INT:
			case MAX:
			case MIN:
			case ROUND:
				{
				alt94=4;
				}
				break;
			case 139:
				{
				int LA94_5 = input.LA(2);
				if ( (LA94_5==FLOAT||LA94_5==IDENT||(LA94_5 >= INT && LA94_5 <= INTEGER)||(LA94_5 >= MAX && LA94_5 <= MIN)||LA94_5==ROUND||(LA94_5 >= 138 && LA94_5 <= 139)||LA94_5==142||LA94_5==144) ) {
					alt94=5;
				}
				else if ( (LA94_5==SUM) ) {
					alt94=6;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 94, 5, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 94, 0, input);
				throw nvae;
			}
			switch (alt94) {
				case 1 :
					// WreslTree.g:482:14: i= ident
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_ident_in_term4380);
					i=ident();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, i.getTree());

					if ( state.backtracking==0 ) {expression_stack.peek().SV.add((i!=null?input.toString(i.start,i.stop):null).toLowerCase());}
					}
					break;
				case 2 :
					// WreslTree.g:483:12: array_iterator
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_array_iterator_in_term4396);
					array_iterator306=array_iterator();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, array_iterator306.getTree());

					}
					break;
				case 3 :
					// WreslTree.g:484:13: number
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_number_in_term4410);
					number307=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, number307.getTree());

					}
					break;
				case 4 :
					// WreslTree.g:485:12: function
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_function_in_term4424);
					function308=function();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, function308.getTree());

					}
					break;
				case 5 :
					// WreslTree.g:486:11: '(' e= expression ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal309=(Token)match(input,139,FOLLOW_139_in_term4437); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal309_tree = (CommonTree)adaptor.create(char_literal309);
					adaptor.addChild(root_0, char_literal309_tree);
					}

					pushFollow(FOLLOW_expression_in_term4441);
					e=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

					char_literal310=(Token)match(input,140,FOLLOW_140_in_term4443); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal310_tree = (CommonTree)adaptor.create(char_literal310);
					adaptor.addChild(root_0, char_literal310_tree);
					}

					if ( state.backtracking==0 ) {expression_stack.peek().SV.addAll((e!=null?((WreslTreeParser.expression_return)e).members:null));expression_stack.peek().varInCycle.addAll((e!=null?((WreslTreeParser.expression_return)e).setVarInCycle:null));}
					}
					break;
				case 6 :
					// WreslTree.g:487:11: '(' s= sum_content ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal311=(Token)match(input,139,FOLLOW_139_in_term4457); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal311_tree = (CommonTree)adaptor.create(char_literal311);
					adaptor.addChild(root_0, char_literal311_tree);
					}

					pushFollow(FOLLOW_sum_content_in_term4461);
					s=sum_content();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, s.getTree());

					char_literal312=(Token)match(input,140,FOLLOW_140_in_term4463); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal312_tree = (CommonTree)adaptor.create(char_literal312);
					adaptor.addChild(root_0, char_literal312_tree);
					}

					if ( state.backtracking==0 ) {expression_stack.peek().varInCycle.addAll((s!=null?((WreslTreeParser.sum_content_return)s).setVarInCycle:null));}
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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


	public static class unary_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "unary"
	// WreslTree.g:490:1: unary : ( '+' !| negation )? term ;
	public final WreslTreeParser.unary_return unary() throws RecognitionException {
		WreslTreeParser.unary_return retval = new WreslTreeParser.unary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal313=null;
		ParserRuleReturnScope negation314 =null;
		ParserRuleReturnScope term315 =null;

		CommonTree char_literal313_tree=null;

		try {
			// WreslTree.g:490:7: ( ( '+' !| negation )? term )
			// WreslTree.g:490:9: ( '+' !| negation )? term
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslTree.g:490:9: ( '+' !| negation )?
			int alt95=3;
			int LA95_0 = input.LA(1);
			if ( (LA95_0==142) ) {
				alt95=1;
			}
			else if ( (LA95_0==144) ) {
				alt95=2;
			}
			switch (alt95) {
				case 1 :
					// WreslTree.g:490:10: '+' !
					{
					char_literal313=(Token)match(input,142,FOLLOW_142_in_unary4479); if (state.failed) return retval;
					}
					break;
				case 2 :
					// WreslTree.g:490:17: negation
					{
					pushFollow(FOLLOW_negation_in_unary4484);
					negation314=negation();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, negation314.getTree());

					}
					break;

			}

			pushFollow(FOLLOW_term_in_unary4488);
			term315=term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, term315.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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


	public static class negation_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "negation"
	// WreslTree.g:492:1: negation : '-' -> NEGATION[\"-\"] ;
	public final WreslTreeParser.negation_return negation() throws RecognitionException {
		WreslTreeParser.negation_return retval = new WreslTreeParser.negation_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal316=null;

		CommonTree char_literal316_tree=null;
		RewriteRuleTokenStream stream_144=new RewriteRuleTokenStream(adaptor,"token 144");

		try {
			// WreslTree.g:492:10: ( '-' -> NEGATION[\"-\"] )
			// WreslTree.g:492:12: '-'
			{
			char_literal316=(Token)match(input,144,FOLLOW_144_in_negation4498); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_144.add(char_literal316);

			// AST REWRITE
			// elements: 
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 492:16: -> NEGATION[\"-\"]
			{
				adaptor.addChild(root_0, (CommonTree)adaptor.create(NEGATION, "-"));
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "negation"


	public static class mult_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "mult"
	// WreslTree.g:494:1: mult : unary ( ( '*' | '/' ) unary )* ;
	public final WreslTreeParser.mult_return mult() throws RecognitionException {
		WreslTreeParser.mult_return retval = new WreslTreeParser.mult_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set318=null;
		ParserRuleReturnScope unary317 =null;
		ParserRuleReturnScope unary319 =null;

		CommonTree set318_tree=null;

		try {
			// WreslTree.g:494:6: ( unary ( ( '*' | '/' ) unary )* )
			// WreslTree.g:494:8: unary ( ( '*' | '/' ) unary )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_unary_in_mult4512);
			unary317=unary();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, unary317.getTree());

			// WreslTree.g:494:14: ( ( '*' | '/' ) unary )*
			loop96:
			while (true) {
				int alt96=2;
				int LA96_0 = input.LA(1);
				if ( (LA96_0==141||LA96_0==145) ) {
					alt96=1;
				}

				switch (alt96) {
				case 1 :
					// WreslTree.g:494:15: ( '*' | '/' ) unary
					{
					set318=input.LT(1);
					if ( input.LA(1)==141||input.LA(1)==145 ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set318));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unary_in_mult4524);
					unary319=unary();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, unary319.getTree());

					}
					break;

				default :
					break loop96;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// WreslTree.g:496:1: add : mult ( ( '+' | '-' ) mult )* ;
	public final WreslTreeParser.add_return add() throws RecognitionException {
		WreslTreeParser.add_return retval = new WreslTreeParser.add_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set321=null;
		ParserRuleReturnScope mult320 =null;
		ParserRuleReturnScope mult322 =null;

		CommonTree set321_tree=null;

		try {
			// WreslTree.g:496:5: ( mult ( ( '+' | '-' ) mult )* )
			// WreslTree.g:496:7: mult ( ( '+' | '-' ) mult )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_mult_in_add4537);
			mult320=mult();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, mult320.getTree());

			// WreslTree.g:496:12: ( ( '+' | '-' ) mult )*
			loop97:
			while (true) {
				int alt97=2;
				int LA97_0 = input.LA(1);
				if ( (LA97_0==142||LA97_0==144) ) {
					alt97=1;
				}

				switch (alt97) {
				case 1 :
					// WreslTree.g:496:13: ( '+' | '-' ) mult
					{
					set321=input.LT(1);
					if ( input.LA(1)==142||input.LA(1)==144 ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set321));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mult_in_add4548);
					mult322=mult();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mult322.getTree());

					}
					break;

				default :
					break loop97;
				}
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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


	protected static class logical_expr_scope {
		Set<String> SV;
		Set<String> varInCycle;
	}
	protected Stack<logical_expr_scope> logical_expr_stack = new Stack<logical_expr_scope>();

	public static class logical_expr_return extends ParserRuleReturnScope {
		public Set<String> members;
		public String dependants;
		public Set<String> setVarInCycle;
		public String strVarInCycle;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "logical_expr"
	// WreslTree.g:498:1: logical_expr returns [Set<String> members, String dependants, Set<String> setVarInCycle, String strVarInCycle] : c_unary ( bin c_unary )* ;
	public final WreslTreeParser.logical_expr_return logical_expr() throws RecognitionException {
		logical_expr_stack.push(new logical_expr_scope());
		WreslTreeParser.logical_expr_return retval = new WreslTreeParser.logical_expr_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope c_unary323 =null;
		ParserRuleReturnScope bin324 =null;
		ParserRuleReturnScope c_unary325 =null;


		 logical_expr_stack.peek().SV = new HashSet<String>(); 
		        logical_expr_stack.peek().varInCycle = new HashSet<String>(); 
		        String dependants = null; 
		        String strVarInCycle = null; 
		try {
			// WreslTree.g:504:2: ( c_unary ( bin c_unary )* )
			// WreslTree.g:504:5: c_unary ( bin c_unary )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_c_unary_in_logical_expr4576);
			c_unary323=c_unary();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, c_unary323.getTree());

			// WreslTree.g:504:13: ( bin c_unary )*
			loop98:
			while (true) {
				int alt98=2;
				int LA98_0 = input.LA(1);
				if ( (LA98_0==AND||LA98_0==OR) ) {
					alt98=1;
				}

				switch (alt98) {
				case 1 :
					// WreslTree.g:504:15: bin c_unary
					{
					pushFollow(FOLLOW_bin_in_logical_expr4580);
					bin324=bin();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, bin324.getTree());

					pushFollow(FOLLOW_c_unary_in_logical_expr4582);
					c_unary325=c_unary();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, c_unary325.getTree());

					}
					break;

				default :
					break loop98;
				}
			}

			if ( state.backtracking==0 ) {  
				   //logical_expr_stack.peek().SV.removeAll(reservedSet);
				   retval.members = logical_expr_stack.peek().SV;
			       for (String s : logical_expr_stack.peek().SV) {
			       
				   	retval.dependants = retval.dependants +" "+s;
				   }
				   
				   retval.setVarInCycle = logical_expr_stack.peek().varInCycle;
				   for (String s : logical_expr_stack.peek().varInCycle) {
			       
				   	retval.strVarInCycle = retval.strVarInCycle +" "+s;
				   } 	   
				}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			logical_expr_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "logical_expr"


	protected static class expression_scope {
		Set<String> SV;
		Set<String> varInCycle;
	}
	protected Stack<expression_scope> expression_stack = new Stack<expression_scope>();

	public static class expression_return extends ParserRuleReturnScope {
		public String text;
		public Set<String> members;
		public String dependants;
		public Set<String> setVarInCycle;
		public String strVarInCycle;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expression"
	// WreslTree.g:521:1: expression returns [String text, Set<String> members, String dependants, Set<String> setVarInCycle, String strVarInCycle] : add ;
	public final WreslTreeParser.expression_return expression() throws RecognitionException {
		expression_stack.push(new expression_scope());
		WreslTreeParser.expression_return retval = new WreslTreeParser.expression_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope add326 =null;


		 expression_stack.peek().SV = new HashSet<String>(); 
				expression_stack.peek().varInCycle = new HashSet<String>(); 
				String dependants = "";
				String strVarInCycle = ""; 
		try {
			// WreslTree.g:527:2: ( add )
			// WreslTree.g:528:2: add
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_add_in_expression4618);
			add326=add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, add326.getTree());

			if ( state.backtracking==0 ) {  retval.text = Tools.replace_ignoreChar((add326!=null?input.toString(add326.start,add326.stop):null)); 
				   retval.text = Tools.replace_seperator(retval.text);
				   
				   //expression_stack.peek().SV.removeAll(reservedSet);
				   retval.members = expression_stack.peek().SV;
			       for (String s : expression_stack.peek().SV) {
			       
				   	retval.dependants = retval.dependants +" "+s;
				   }
				   
				   retval.setVarInCycle = expression_stack.peek().varInCycle;
				   for (String s : expression_stack.peek().varInCycle) {
			       
				   	retval.strVarInCycle = retval.strVarInCycle +" "+s;
				   }    
				}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			expression_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "expression"


	public static class c_term_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "c_term"
	// WreslTree.g:546:1: c_term : ( ( expression relation expression )=>e1= expression relation e2= expression | function_logical | ( '(' logical_expr ')' )=> '(' e= logical_expr ')' );
	public final WreslTreeParser.c_term_return c_term() throws RecognitionException {
		WreslTreeParser.c_term_return retval = new WreslTreeParser.c_term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal329=null;
		Token char_literal330=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;
		ParserRuleReturnScope e =null;
		ParserRuleReturnScope relation327 =null;
		ParserRuleReturnScope function_logical328 =null;

		CommonTree char_literal329_tree=null;
		CommonTree char_literal330_tree=null;

		try {
			// WreslTree.g:547:2: ( ( expression relation expression )=>e1= expression relation e2= expression | function_logical | ( '(' logical_expr ')' )=> '(' e= logical_expr ')' )
			int alt99=3;
			int LA99_0 = input.LA(1);
			if ( (LA99_0==142) && (synpred1_WreslTree())) {
				alt99=1;
			}
			else if ( (LA99_0==144) && (synpred1_WreslTree())) {
				alt99=1;
			}
			else if ( (LA99_0==IDENT) && (synpred1_WreslTree())) {
				alt99=1;
			}
			else if ( (LA99_0==138) && (synpred1_WreslTree())) {
				alt99=1;
			}
			else if ( (LA99_0==FLOAT||LA99_0==INTEGER) && (synpred1_WreslTree())) {
				alt99=1;
			}
			else if ( (LA99_0==MAX) && (synpred1_WreslTree())) {
				alt99=1;
			}
			else if ( (LA99_0==MIN) && (synpred1_WreslTree())) {
				alt99=1;
			}
			else if ( (LA99_0==INT) && (synpred1_WreslTree())) {
				alt99=1;
			}
			else if ( (LA99_0==ROUND) && (synpred1_WreslTree())) {
				alt99=1;
			}
			else if ( (LA99_0==139) ) {
				int LA99_10 = input.LA(2);
				if ( (synpred1_WreslTree()) ) {
					alt99=1;
				}
				else if ( (synpred2_WreslTree()) ) {
					alt99=3;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 99, 10, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA99_0==RANGE) ) {
				alt99=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 99, 0, input);
				throw nvae;
			}

			switch (alt99) {
				case 1 :
					// WreslTree.g:547:4: ( expression relation expression )=>e1= expression relation e2= expression
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_expression_in_c_term4647);
					e1=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e1.getTree());

					pushFollow(FOLLOW_relation_in_c_term4649);
					relation327=relation();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, relation327.getTree());

					pushFollow(FOLLOW_expression_in_c_term4653);
					e2=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e2.getTree());

					if ( state.backtracking==0 ) {
								logical_expr_stack.peek().SV.addAll((e1!=null?((WreslTreeParser.expression_return)e1).members:null)); 
								logical_expr_stack.peek().SV.addAll((e2!=null?((WreslTreeParser.expression_return)e2).members:null));
								logical_expr_stack.peek().varInCycle.addAll((e1!=null?((WreslTreeParser.expression_return)e1).setVarInCycle:null));
								logical_expr_stack.peek().varInCycle.addAll((e2!=null?((WreslTreeParser.expression_return)e2).setVarInCycle:null));
							}
					}
					break;
				case 2 :
					// WreslTree.g:554:4: function_logical
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_function_logical_in_c_term4664);
					function_logical328=function_logical();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, function_logical328.getTree());

					}
					break;
				case 3 :
					// WreslTree.g:555:4: ( '(' logical_expr ')' )=> '(' e= logical_expr ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal329=(Token)match(input,139,FOLLOW_139_in_c_term4681); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal329_tree = (CommonTree)adaptor.create(char_literal329);
					adaptor.addChild(root_0, char_literal329_tree);
					}

					pushFollow(FOLLOW_logical_expr_in_c_term4685);
					e=logical_expr();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

					char_literal330=(Token)match(input,140,FOLLOW_140_in_c_term4687); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal330_tree = (CommonTree)adaptor.create(char_literal330);
					adaptor.addChild(root_0, char_literal330_tree);
					}

					if ( state.backtracking==0 ) {
								logical_expr_stack.peek().SV.addAll((e!=null?((WreslTreeParser.logical_expr_return)e).members:null));
								logical_expr_stack.peek().varInCycle.addAll((e!=null?((WreslTreeParser.logical_expr_return)e).setVarInCycle:null));
							}
					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "c_term"


	public static class c_unary_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "c_unary"
	// WreslTree.g:562:1: c_unary : ( c_negation )? c_term ;
	public final WreslTreeParser.c_unary_return c_unary() throws RecognitionException {
		WreslTreeParser.c_unary_return retval = new WreslTreeParser.c_unary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope c_negation331 =null;
		ParserRuleReturnScope c_term332 =null;


		try {
			// WreslTree.g:562:9: ( ( c_negation )? c_term )
			// WreslTree.g:562:11: ( c_negation )? c_term
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslTree.g:562:11: ( c_negation )?
			int alt100=2;
			int LA100_0 = input.LA(1);
			if ( (LA100_0==NOT) ) {
				alt100=1;
			}
			switch (alt100) {
				case 1 :
					// WreslTree.g:562:12: c_negation
					{
					pushFollow(FOLLOW_c_negation_in_c_unary4705);
					c_negation331=c_negation();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, c_negation331.getTree());

					}
					break;

			}

			pushFollow(FOLLOW_c_term_in_c_unary4709);
			c_term332=c_term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, c_term332.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "c_unary"


	public static class c_negation_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "c_negation"
	// WreslTree.g:564:1: c_negation : NOT -> NOT[\".NOT.\"] ;
	public final WreslTreeParser.c_negation_return c_negation() throws RecognitionException {
		WreslTreeParser.c_negation_return retval = new WreslTreeParser.c_negation_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token NOT333=null;

		CommonTree NOT333_tree=null;
		RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");

		try {
			// WreslTree.g:564:12: ( NOT -> NOT[\".NOT.\"] )
			// WreslTree.g:564:14: NOT
			{
			NOT333=(Token)match(input,NOT,FOLLOW_NOT_in_c_negation4720); if (state.failed) return retval; 
			if ( state.backtracking==0 ) stream_NOT.add(NOT333);

			// AST REWRITE
			// elements: NOT
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			if ( state.backtracking==0 ) {
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 564:18: -> NOT[\".NOT.\"]
			{
				adaptor.addChild(root_0, (CommonTree)adaptor.create(NOT, ".NOT."));
			}


			retval.tree = root_0;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "c_negation"


	public static class relation_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "relation"
	// WreslTree.g:568:1: relation : ( '>' | '<' | '>=' | '<=' | '==' | '/=' );
	public final WreslTreeParser.relation_return relation() throws RecognitionException {
		WreslTreeParser.relation_return retval = new WreslTreeParser.relation_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set334=null;

		CommonTree set334_tree=null;

		try {
			// WreslTree.g:568:10: ( '>' | '<' | '>=' | '<=' | '==' | '/=' )
			// WreslTree.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set334=input.LT(1);
			if ( (input.LA(1) >= 146 && input.LA(1) <= 148)||(input.LA(1) >= 150 && input.LA(1) <= 152) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set334));
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

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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


	public static class bin_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "bin"
	// WreslTree.g:570:1: bin : ( OR -> OR[\".OR.\"] | AND -> AND[\".AND.\"] );
	public final WreslTreeParser.bin_return bin() throws RecognitionException {
		WreslTreeParser.bin_return retval = new WreslTreeParser.bin_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OR335=null;
		Token AND336=null;

		CommonTree OR335_tree=null;
		CommonTree AND336_tree=null;
		RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
		RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");

		try {
			// WreslTree.g:570:5: ( OR -> OR[\".OR.\"] | AND -> AND[\".AND.\"] )
			int alt101=2;
			int LA101_0 = input.LA(1);
			if ( (LA101_0==OR) ) {
				alt101=1;
			}
			else if ( (LA101_0==AND) ) {
				alt101=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 101, 0, input);
				throw nvae;
			}

			switch (alt101) {
				case 1 :
					// WreslTree.g:570:7: OR
					{
					OR335=(Token)match(input,OR,FOLLOW_OR_in_bin4768); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_OR.add(OR335);

					// AST REWRITE
					// elements: OR
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 570:10: -> OR[\".OR.\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(OR, ".OR."));
					}


					retval.tree = root_0;
					}

					}
					break;
				case 2 :
					// WreslTree.g:570:26: AND
					{
					AND336=(Token)match(input,AND,FOLLOW_AND_in_bin4777); if (state.failed) return retval; 
					if ( state.backtracking==0 ) stream_AND.add(AND336);

					// AST REWRITE
					// elements: AND
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					if ( state.backtracking==0 ) {
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 570:30: -> AND[\".AND.\"]
					{
						adaptor.addChild(root_0, (CommonTree)adaptor.create(AND, ".AND."));
					}


					retval.tree = root_0;
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "bin"


	public static class function_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "function"
	// WreslTree.g:579:1: function : ( external_func | max_func | min_func | int_func | round_func | var_model );
	public final WreslTreeParser.function_return function() throws RecognitionException {
		WreslTreeParser.function_return retval = new WreslTreeParser.function_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope external_func337 =null;
		ParserRuleReturnScope max_func338 =null;
		ParserRuleReturnScope min_func339 =null;
		ParserRuleReturnScope int_func340 =null;
		ParserRuleReturnScope round_func341 =null;
		ParserRuleReturnScope var_model342 =null;


		try {
			// WreslTree.g:579:10: ( external_func | max_func | min_func | int_func | round_func | var_model )
			int alt102=6;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				int LA102_1 = input.LA(2);
				if ( (LA102_1==153) ) {
					alt102=6;
				}
				else if ( (LA102_1==139) ) {
					alt102=1;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 102, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case MAX:
				{
				alt102=2;
				}
				break;
			case MIN:
				{
				alt102=3;
				}
				break;
			case INT:
				{
				alt102=4;
				}
				break;
			case ROUND:
				{
				alt102=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 102, 0, input);
				throw nvae;
			}
			switch (alt102) {
				case 1 :
					// WreslTree.g:579:12: external_func
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_external_func_in_function4800);
					external_func337=external_func();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, external_func337.getTree());

					}
					break;
				case 2 :
					// WreslTree.g:579:28: max_func
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_max_func_in_function4804);
					max_func338=max_func();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, max_func338.getTree());

					}
					break;
				case 3 :
					// WreslTree.g:579:39: min_func
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_min_func_in_function4808);
					min_func339=min_func();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, min_func339.getTree());

					}
					break;
				case 4 :
					// WreslTree.g:579:50: int_func
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_int_func_in_function4812);
					int_func340=int_func();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, int_func340.getTree());

					}
					break;
				case 5 :
					// WreslTree.g:579:61: round_func
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_round_func_in_function4816);
					round_func341=round_func();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, round_func341.getTree());

					}
					break;
				case 6 :
					// WreslTree.g:579:74: var_model
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_var_model_in_function4820);
					var_model342=var_model();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var_model342.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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


	public static class function_logical_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "function_logical"
	// WreslTree.g:581:1: function_logical : range_func ;
	public final WreslTreeParser.function_logical_return function_logical() throws RecognitionException {
		WreslTreeParser.function_logical_return retval = new WreslTreeParser.function_logical_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope range_func343 =null;


		try {
			// WreslTree.g:581:18: ( range_func )
			// WreslTree.g:581:20: range_func
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_range_func_in_function_logical4829);
			range_func343=range_func();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, range_func343.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "function_logical"


	public static class var_model_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var_model"
	// WreslTree.g:583:1: var_model : ( var_model_noTimeArray | var_model_timeArray | var_modelindex_noTimeArray | var_modelindex_TimeArray );
	public final WreslTreeParser.var_model_return var_model() throws RecognitionException {
		WreslTreeParser.var_model_return retval = new WreslTreeParser.var_model_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope var_model_noTimeArray344 =null;
		ParserRuleReturnScope var_model_timeArray345 =null;
		ParserRuleReturnScope var_modelindex_noTimeArray346 =null;
		ParserRuleReturnScope var_modelindex_TimeArray347 =null;


		try {
			// WreslTree.g:583:10: ( var_model_noTimeArray | var_model_timeArray | var_modelindex_noTimeArray | var_modelindex_TimeArray )
			int alt103=4;
			int LA103_0 = input.LA(1);
			if ( (LA103_0==IDENT) ) {
				int LA103_1 = input.LA(2);
				if ( (LA103_1==153) ) {
					int LA103_2 = input.LA(3);
					if ( (LA103_2==IDENT) ) {
						int LA103_3 = input.LA(4);
						if ( (LA103_3==154) ) {
							int LA103_5 = input.LA(5);
							if ( (LA103_5==139) ) {
								alt103=2;
							}
							else if ( (LA103_5==EOF||LA103_5==AND||LA103_5==CASE||LA103_5==KIND||LA103_5==LHS||LA103_5==LOWER||(LA103_5 >= OR && LA103_5 <= ORDER)||LA103_5==RHS||LA103_5==SELECT||LA103_5==SUM||(LA103_5 >= UNITS && LA103_5 <= USE)||LA103_5==VALUE||(LA103_5 >= 140 && LA103_5 <= 152)||LA103_5==154||LA103_5==158) ) {
								alt103=1;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 103, 5, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 103, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}
					else if ( (LA103_2==144) ) {
						int LA103_4 = input.LA(4);
						if ( (LA103_4==INTEGER) ) {
							int LA103_6 = input.LA(5);
							if ( (LA103_6==154) ) {
								int LA103_9 = input.LA(6);
								if ( (LA103_9==139) ) {
									alt103=4;
								}
								else if ( (LA103_9==EOF||LA103_9==AND||LA103_9==CASE||LA103_9==KIND||LA103_9==LHS||LA103_9==LOWER||(LA103_9 >= OR && LA103_9 <= ORDER)||LA103_9==RHS||LA103_9==SELECT||LA103_9==SUM||(LA103_9 >= UNITS && LA103_9 <= USE)||LA103_9==VALUE||(LA103_9 >= 140 && LA103_9 <= 152)||LA103_9==154||LA103_9==158) ) {
									alt103=3;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return retval;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 103, 9, input);
										throw nvae;
									} finally {
										input.rewind(nvaeMark);
									}
								}

							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 103, 6, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 103, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 103, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 103, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 103, 0, input);
				throw nvae;
			}

			switch (alt103) {
				case 1 :
					// WreslTree.g:583:12: var_model_noTimeArray
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_var_model_noTimeArray_in_var_model4837);
					var_model_noTimeArray344=var_model_noTimeArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var_model_noTimeArray344.getTree());

					}
					break;
				case 2 :
					// WreslTree.g:583:34: var_model_timeArray
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_var_model_timeArray_in_var_model4839);
					var_model_timeArray345=var_model_timeArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var_model_timeArray345.getTree());

					}
					break;
				case 3 :
					// WreslTree.g:583:54: var_modelindex_noTimeArray
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_var_modelindex_noTimeArray_in_var_model4841);
					var_modelindex_noTimeArray346=var_modelindex_noTimeArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var_modelindex_noTimeArray346.getTree());

					}
					break;
				case 4 :
					// WreslTree.g:583:81: var_modelindex_TimeArray
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_var_modelindex_TimeArray_in_var_model4843);
					var_modelindex_TimeArray347=var_modelindex_TimeArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, var_modelindex_TimeArray347.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "var_model"


	public static class var_model_noTimeArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var_model_noTimeArray"
	// WreslTree.g:586:1: var_model_noTimeArray : varName= IDENT '[' cycleName= IDENT ']' ;
	public final WreslTreeParser.var_model_noTimeArray_return var_model_noTimeArray() throws RecognitionException {
		WreslTreeParser.var_model_noTimeArray_return retval = new WreslTreeParser.var_model_noTimeArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token varName=null;
		Token cycleName=null;
		Token char_literal348=null;
		Token char_literal349=null;

		CommonTree varName_tree=null;
		CommonTree cycleName_tree=null;
		CommonTree char_literal348_tree=null;
		CommonTree char_literal349_tree=null;

		try {
			// WreslTree.g:587:2: (varName= IDENT '[' cycleName= IDENT ']' )
			// WreslTree.g:587:4: varName= IDENT '[' cycleName= IDENT ']'
			{
			root_0 = (CommonTree)adaptor.nil();


			varName=(Token)match(input,IDENT,FOLLOW_IDENT_in_var_model_noTimeArray4867); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			varName_tree = (CommonTree)adaptor.create(varName);
			adaptor.addChild(root_0, varName_tree);
			}

			char_literal348=(Token)match(input,153,FOLLOW_153_in_var_model_noTimeArray4869); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal348_tree = (CommonTree)adaptor.create(char_literal348);
			adaptor.addChild(root_0, char_literal348_tree);
			}

			cycleName=(Token)match(input,IDENT,FOLLOW_IDENT_in_var_model_noTimeArray4875); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			cycleName_tree = (CommonTree)adaptor.create(cycleName);
			adaptor.addChild(root_0, cycleName_tree);
			}

			char_literal349=(Token)match(input,154,FOLLOW_154_in_var_model_noTimeArray4877); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal349_tree = (CommonTree)adaptor.create(char_literal349);
			adaptor.addChild(root_0, char_literal349_tree);
			}

			if ( state.backtracking==0 ) {  expression_stack.peek().varInCycle.add((varName!=null?varName.getText():null)+'['+(cycleName!=null?cycleName.getText():null)+']' );}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "var_model_noTimeArray"


	public static class var_model_timeArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var_model_timeArray"
	// WreslTree.g:590:1: var_model_timeArray : varName= IDENT '[' cycleName= IDENT ']' '(' e= expression ')' ;
	public final WreslTreeParser.var_model_timeArray_return var_model_timeArray() throws RecognitionException {
		WreslTreeParser.var_model_timeArray_return retval = new WreslTreeParser.var_model_timeArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token varName=null;
		Token cycleName=null;
		Token char_literal350=null;
		Token char_literal351=null;
		Token char_literal352=null;
		Token char_literal353=null;
		ParserRuleReturnScope e =null;

		CommonTree varName_tree=null;
		CommonTree cycleName_tree=null;
		CommonTree char_literal350_tree=null;
		CommonTree char_literal351_tree=null;
		CommonTree char_literal352_tree=null;
		CommonTree char_literal353_tree=null;

		try {
			// WreslTree.g:591:3: (varName= IDENT '[' cycleName= IDENT ']' '(' e= expression ')' )
			// WreslTree.g:591:5: varName= IDENT '[' cycleName= IDENT ']' '(' e= expression ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			varName=(Token)match(input,IDENT,FOLLOW_IDENT_in_var_model_timeArray4898); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			varName_tree = (CommonTree)adaptor.create(varName);
			adaptor.addChild(root_0, varName_tree);
			}

			char_literal350=(Token)match(input,153,FOLLOW_153_in_var_model_timeArray4900); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal350_tree = (CommonTree)adaptor.create(char_literal350);
			adaptor.addChild(root_0, char_literal350_tree);
			}

			cycleName=(Token)match(input,IDENT,FOLLOW_IDENT_in_var_model_timeArray4906); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			cycleName_tree = (CommonTree)adaptor.create(cycleName);
			adaptor.addChild(root_0, cycleName_tree);
			}

			char_literal351=(Token)match(input,154,FOLLOW_154_in_var_model_timeArray4908); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal351_tree = (CommonTree)adaptor.create(char_literal351);
			adaptor.addChild(root_0, char_literal351_tree);
			}

			char_literal352=(Token)match(input,139,FOLLOW_139_in_var_model_timeArray4910); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal352_tree = (CommonTree)adaptor.create(char_literal352);
			adaptor.addChild(root_0, char_literal352_tree);
			}

			pushFollow(FOLLOW_expression_in_var_model_timeArray4914);
			e=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

			char_literal353=(Token)match(input,140,FOLLOW_140_in_var_model_timeArray4916); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal353_tree = (CommonTree)adaptor.create(char_literal353);
			adaptor.addChild(root_0, char_literal353_tree);
			}

			if ( state.backtracking==0 ) {  expression_stack.peek().varInCycle.add((varName!=null?varName.getText():null)+'['+(cycleName!=null?cycleName.getText():null)+']'+'(' + (e!=null?((WreslTreeParser.expression_return)e).text:null) +')' );}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "var_model_timeArray"


	public static class var_modelindex_noTimeArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var_modelindex_noTimeArray"
	// WreslTree.g:594:1: var_modelindex_noTimeArray : varName= IDENT '[' cycleIndex= ( '-' INTEGER ) ']' ;
	public final WreslTreeParser.var_modelindex_noTimeArray_return var_modelindex_noTimeArray() throws RecognitionException {
		WreslTreeParser.var_modelindex_noTimeArray_return retval = new WreslTreeParser.var_modelindex_noTimeArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token varName=null;
		Token cycleIndex=null;
		Token char_literal354=null;
		Token char_literal355=null;

		CommonTree varName_tree=null;
		CommonTree cycleIndex_tree=null;
		CommonTree char_literal354_tree=null;
		CommonTree char_literal355_tree=null;

		try {
			// WreslTree.g:595:3: (varName= IDENT '[' cycleIndex= ( '-' INTEGER ) ']' )
			// WreslTree.g:595:5: varName= IDENT '[' cycleIndex= ( '-' INTEGER ) ']'
			{
			root_0 = (CommonTree)adaptor.nil();


			varName=(Token)match(input,IDENT,FOLLOW_IDENT_in_var_modelindex_noTimeArray4937); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			varName_tree = (CommonTree)adaptor.create(varName);
			adaptor.addChild(root_0, varName_tree);
			}

			char_literal354=(Token)match(input,153,FOLLOW_153_in_var_modelindex_noTimeArray4939); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal354_tree = (CommonTree)adaptor.create(char_literal354);
			adaptor.addChild(root_0, char_literal354_tree);
			}

			// WreslTree.g:595:34: ( '-' INTEGER )
			// WreslTree.g:595:35: '-' INTEGER
			{
			cycleIndex=(Token)match(input,144,FOLLOW_144_in_var_modelindex_noTimeArray4944); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			cycleIndex_tree = (CommonTree)adaptor.create(cycleIndex);
			adaptor.addChild(root_0, cycleIndex_tree);
			}

			cycleIndex=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_var_modelindex_noTimeArray4946); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			cycleIndex_tree = (CommonTree)adaptor.create(cycleIndex);
			adaptor.addChild(root_0, cycleIndex_tree);
			}

			}

			char_literal355=(Token)match(input,154,FOLLOW_154_in_var_modelindex_noTimeArray4949); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal355_tree = (CommonTree)adaptor.create(char_literal355);
			adaptor.addChild(root_0, char_literal355_tree);
			}

			if ( state.backtracking==0 ) {
			      if (!VarCycleIndex.varCycleIndexList.contains(varName)){
			        VarCycleIndex.varCycleIndexList.add((varName!=null?varName.getText():null).toLowerCase());
			      }
			    }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "var_modelindex_noTimeArray"


	public static class var_modelindex_TimeArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "var_modelindex_TimeArray"
	// WreslTree.g:601:1: var_modelindex_TimeArray : varName= IDENT '[' cycleIndex= ( '-' INTEGER ) ']' '(' e= expression ')' ;
	public final WreslTreeParser.var_modelindex_TimeArray_return var_modelindex_TimeArray() throws RecognitionException {
		WreslTreeParser.var_modelindex_TimeArray_return retval = new WreslTreeParser.var_modelindex_TimeArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token varName=null;
		Token cycleIndex=null;
		Token char_literal356=null;
		Token char_literal357=null;
		Token char_literal358=null;
		Token char_literal359=null;
		ParserRuleReturnScope e =null;

		CommonTree varName_tree=null;
		CommonTree cycleIndex_tree=null;
		CommonTree char_literal356_tree=null;
		CommonTree char_literal357_tree=null;
		CommonTree char_literal358_tree=null;
		CommonTree char_literal359_tree=null;

		try {
			// WreslTree.g:602:3: (varName= IDENT '[' cycleIndex= ( '-' INTEGER ) ']' '(' e= expression ')' )
			// WreslTree.g:602:5: varName= IDENT '[' cycleIndex= ( '-' INTEGER ) ']' '(' e= expression ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			varName=(Token)match(input,IDENT,FOLLOW_IDENT_in_var_modelindex_TimeArray4968); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			varName_tree = (CommonTree)adaptor.create(varName);
			adaptor.addChild(root_0, varName_tree);
			}

			char_literal356=(Token)match(input,153,FOLLOW_153_in_var_modelindex_TimeArray4970); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal356_tree = (CommonTree)adaptor.create(char_literal356);
			adaptor.addChild(root_0, char_literal356_tree);
			}

			// WreslTree.g:602:34: ( '-' INTEGER )
			// WreslTree.g:602:35: '-' INTEGER
			{
			cycleIndex=(Token)match(input,144,FOLLOW_144_in_var_modelindex_TimeArray4975); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			cycleIndex_tree = (CommonTree)adaptor.create(cycleIndex);
			adaptor.addChild(root_0, cycleIndex_tree);
			}

			cycleIndex=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_var_modelindex_TimeArray4977); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			cycleIndex_tree = (CommonTree)adaptor.create(cycleIndex);
			adaptor.addChild(root_0, cycleIndex_tree);
			}

			}

			char_literal357=(Token)match(input,154,FOLLOW_154_in_var_modelindex_TimeArray4980); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal357_tree = (CommonTree)adaptor.create(char_literal357);
			adaptor.addChild(root_0, char_literal357_tree);
			}

			char_literal358=(Token)match(input,139,FOLLOW_139_in_var_modelindex_TimeArray4982); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal358_tree = (CommonTree)adaptor.create(char_literal358);
			adaptor.addChild(root_0, char_literal358_tree);
			}

			pushFollow(FOLLOW_expression_in_var_modelindex_TimeArray4986);
			e=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

			char_literal359=(Token)match(input,140,FOLLOW_140_in_var_modelindex_TimeArray4988); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal359_tree = (CommonTree)adaptor.create(char_literal359);
			adaptor.addChild(root_0, char_literal359_tree);
			}

			if ( state.backtracking==0 ) {
			      if (!VarCycleIndex.varCycleIndexList.contains(varName)){
			        VarCycleIndex.varCycleIndexList.add((varName!=null?varName.getText():null).toLowerCase());
			      }
			  }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "var_modelindex_TimeArray"


	public static class external_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "external_func"
	// WreslTree.g:608:1: external_func : i= IDENT '(' ie= expression ( ',' e= expression )* ')' ;
	public final WreslTreeParser.external_func_return external_func() throws RecognitionException {
		WreslTreeParser.external_func_return retval = new WreslTreeParser.external_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token char_literal360=null;
		Token char_literal361=null;
		Token char_literal362=null;
		ParserRuleReturnScope ie =null;
		ParserRuleReturnScope e =null;

		CommonTree i_tree=null;
		CommonTree char_literal360_tree=null;
		CommonTree char_literal361_tree=null;
		CommonTree char_literal362_tree=null;

		try {
			// WreslTree.g:609:2: (i= IDENT '(' ie= expression ( ',' e= expression )* ')' )
			// WreslTree.g:609:4: i= IDENT '(' ie= expression ( ',' e= expression )* ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			i=(Token)match(input,IDENT,FOLLOW_IDENT_in_external_func5003); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) {expression_stack.peek().SV.add((i!=null?i.getText():null));}
			char_literal360=(Token)match(input,139,FOLLOW_139_in_external_func5007); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal360_tree = (CommonTree)adaptor.create(char_literal360);
			adaptor.addChild(root_0, char_literal360_tree);
			}

			pushFollow(FOLLOW_expression_in_external_func5012);
			ie=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, ie.getTree());

			// WreslTree.g:609:63: ( ',' e= expression )*
			loop104:
			while (true) {
				int alt104=2;
				int LA104_0 = input.LA(1);
				if ( (LA104_0==143) ) {
					alt104=1;
				}

				switch (alt104) {
				case 1 :
					// WreslTree.g:609:64: ',' e= expression
					{
					char_literal361=(Token)match(input,143,FOLLOW_143_in_external_func5015); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal361_tree = (CommonTree)adaptor.create(char_literal361);
					adaptor.addChild(root_0, char_literal361_tree);
					}

					pushFollow(FOLLOW_expression_in_external_func5019);
					e=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

					if ( state.backtracking==0 ) {expression_stack.peek().SV.addAll((e!=null?((WreslTreeParser.expression_return)e).members:null));expression_stack.peek().varInCycle.addAll((e!=null?((WreslTreeParser.expression_return)e).setVarInCycle:null));}
					}
					break;

				default :
					break loop104;
				}
			}

			char_literal362=(Token)match(input,140,FOLLOW_140_in_external_func5029); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal362_tree = (CommonTree)adaptor.create(char_literal362);
			adaptor.addChild(root_0, char_literal362_tree);
			}

			if ( state.backtracking==0 ) {  expression_stack.peek().SV.addAll((ie!=null?((WreslTreeParser.expression_return)ie).members:null));expression_stack.peek().varInCycle.addAll((ie!=null?((WreslTreeParser.expression_return)ie).setVarInCycle:null));}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "external_func"


	public static class range_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "range_func"
	// WreslTree.g:614:1: range_func : RANGE '(' IDENT ',' ( IDENT | number ) ',' ( IDENT | number ) ')' ;
	public final WreslTreeParser.range_func_return range_func() throws RecognitionException {
		WreslTreeParser.range_func_return retval = new WreslTreeParser.range_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token RANGE363=null;
		Token char_literal364=null;
		Token IDENT365=null;
		Token char_literal366=null;
		Token IDENT367=null;
		Token char_literal369=null;
		Token IDENT370=null;
		Token char_literal372=null;
		ParserRuleReturnScope number368 =null;
		ParserRuleReturnScope number371 =null;

		CommonTree RANGE363_tree=null;
		CommonTree char_literal364_tree=null;
		CommonTree IDENT365_tree=null;
		CommonTree char_literal366_tree=null;
		CommonTree IDENT367_tree=null;
		CommonTree char_literal369_tree=null;
		CommonTree IDENT370_tree=null;
		CommonTree char_literal372_tree=null;

		try {
			// WreslTree.g:614:12: ( RANGE '(' IDENT ',' ( IDENT | number ) ',' ( IDENT | number ) ')' )
			// WreslTree.g:614:14: RANGE '(' IDENT ',' ( IDENT | number ) ',' ( IDENT | number ) ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			RANGE363=(Token)match(input,RANGE,FOLLOW_RANGE_in_range_func5054); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RANGE363_tree = (CommonTree)adaptor.create(RANGE363);
			adaptor.addChild(root_0, RANGE363_tree);
			}

			char_literal364=(Token)match(input,139,FOLLOW_139_in_range_func5056); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal364_tree = (CommonTree)adaptor.create(char_literal364);
			adaptor.addChild(root_0, char_literal364_tree);
			}

			IDENT365=(Token)match(input,IDENT,FOLLOW_IDENT_in_range_func5058); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			IDENT365_tree = (CommonTree)adaptor.create(IDENT365);
			adaptor.addChild(root_0, IDENT365_tree);
			}

			char_literal366=(Token)match(input,143,FOLLOW_143_in_range_func5060); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal366_tree = (CommonTree)adaptor.create(char_literal366);
			adaptor.addChild(root_0, char_literal366_tree);
			}

			// WreslTree.g:614:34: ( IDENT | number )
			int alt105=2;
			int LA105_0 = input.LA(1);
			if ( (LA105_0==IDENT) ) {
				alt105=1;
			}
			else if ( (LA105_0==FLOAT||LA105_0==INTEGER) ) {
				alt105=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 105, 0, input);
				throw nvae;
			}

			switch (alt105) {
				case 1 :
					// WreslTree.g:614:36: IDENT
					{
					IDENT367=(Token)match(input,IDENT,FOLLOW_IDENT_in_range_func5064); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENT367_tree = (CommonTree)adaptor.create(IDENT367);
					adaptor.addChild(root_0, IDENT367_tree);
					}

					}
					break;
				case 2 :
					// WreslTree.g:614:44: number
					{
					pushFollow(FOLLOW_number_in_range_func5068);
					number368=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, number368.getTree());

					}
					break;

			}

			char_literal369=(Token)match(input,143,FOLLOW_143_in_range_func5072); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal369_tree = (CommonTree)adaptor.create(char_literal369);
			adaptor.addChild(root_0, char_literal369_tree);
			}

			// WreslTree.g:614:57: ( IDENT | number )
			int alt106=2;
			int LA106_0 = input.LA(1);
			if ( (LA106_0==IDENT) ) {
				alt106=1;
			}
			else if ( (LA106_0==FLOAT||LA106_0==INTEGER) ) {
				alt106=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 106, 0, input);
				throw nvae;
			}

			switch (alt106) {
				case 1 :
					// WreslTree.g:614:59: IDENT
					{
					IDENT370=(Token)match(input,IDENT,FOLLOW_IDENT_in_range_func5076); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					IDENT370_tree = (CommonTree)adaptor.create(IDENT370);
					adaptor.addChild(root_0, IDENT370_tree);
					}

					}
					break;
				case 2 :
					// WreslTree.g:614:67: number
					{
					pushFollow(FOLLOW_number_in_range_func5080);
					number371=number();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, number371.getTree());

					}
					break;

			}

			char_literal372=(Token)match(input,140,FOLLOW_140_in_range_func5084); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal372_tree = (CommonTree)adaptor.create(char_literal372);
			adaptor.addChild(root_0, char_literal372_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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


	public static class max_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "max_func"
	// WreslTree.g:616:1: max_func : MAX '(' ie= expression ( ',' e= expression )+ ')' ;
	public final WreslTreeParser.max_func_return max_func() throws RecognitionException {
		WreslTreeParser.max_func_return retval = new WreslTreeParser.max_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MAX373=null;
		Token char_literal374=null;
		Token char_literal375=null;
		Token char_literal376=null;
		ParserRuleReturnScope ie =null;
		ParserRuleReturnScope e =null;

		CommonTree MAX373_tree=null;
		CommonTree char_literal374_tree=null;
		CommonTree char_literal375_tree=null;
		CommonTree char_literal376_tree=null;

		try {
			// WreslTree.g:617:2: ( MAX '(' ie= expression ( ',' e= expression )+ ')' )
			// WreslTree.g:617:4: MAX '(' ie= expression ( ',' e= expression )+ ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			MAX373=(Token)match(input,MAX,FOLLOW_MAX_in_max_func5094); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MAX373_tree = (CommonTree)adaptor.create(MAX373);
			adaptor.addChild(root_0, MAX373_tree);
			}

			char_literal374=(Token)match(input,139,FOLLOW_139_in_max_func5096); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal374_tree = (CommonTree)adaptor.create(char_literal374);
			adaptor.addChild(root_0, char_literal374_tree);
			}

			pushFollow(FOLLOW_expression_in_max_func5100);
			ie=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, ie.getTree());

			// WreslTree.g:617:26: ( ',' e= expression )+
			int cnt107=0;
			loop107:
			while (true) {
				int alt107=2;
				int LA107_0 = input.LA(1);
				if ( (LA107_0==143) ) {
					alt107=1;
				}

				switch (alt107) {
				case 1 :
					// WreslTree.g:617:27: ',' e= expression
					{
					char_literal375=(Token)match(input,143,FOLLOW_143_in_max_func5103); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal375_tree = (CommonTree)adaptor.create(char_literal375);
					adaptor.addChild(root_0, char_literal375_tree);
					}

					pushFollow(FOLLOW_expression_in_max_func5107);
					e=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

					if ( state.backtracking==0 ) {
										expression_stack.peek().SV.addAll((e!=null?((WreslTreeParser.expression_return)e).members:null));
										expression_stack.peek().varInCycle.addAll((e!=null?((WreslTreeParser.expression_return)e).setVarInCycle:null));
									}
					}
					break;

				default :
					if ( cnt107 >= 1 ) break loop107;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(107, input);
					throw eee;
				}
				cnt107++;
			}

			char_literal376=(Token)match(input,140,FOLLOW_140_in_max_func5131); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal376_tree = (CommonTree)adaptor.create(char_literal376);
			adaptor.addChild(root_0, char_literal376_tree);
			}

			if ( state.backtracking==0 ) {
				        		expression_stack.peek().SV.addAll((ie!=null?((WreslTreeParser.expression_return)ie).members:null));
				        		expression_stack.peek().varInCycle.addAll((ie!=null?((WreslTreeParser.expression_return)ie).setVarInCycle:null));
				        	}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// WreslTree.g:631:1: min_func : MIN '(' ie= expression ( ',' e= expression )+ ')' ;
	public final WreslTreeParser.min_func_return min_func() throws RecognitionException {
		WreslTreeParser.min_func_return retval = new WreslTreeParser.min_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MIN377=null;
		Token char_literal378=null;
		Token char_literal379=null;
		Token char_literal380=null;
		ParserRuleReturnScope ie =null;
		ParserRuleReturnScope e =null;

		CommonTree MIN377_tree=null;
		CommonTree char_literal378_tree=null;
		CommonTree char_literal379_tree=null;
		CommonTree char_literal380_tree=null;

		try {
			// WreslTree.g:632:2: ( MIN '(' ie= expression ( ',' e= expression )+ ')' )
			// WreslTree.g:632:4: MIN '(' ie= expression ( ',' e= expression )+ ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			MIN377=(Token)match(input,MIN,FOLLOW_MIN_in_min_func5166); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MIN377_tree = (CommonTree)adaptor.create(MIN377);
			adaptor.addChild(root_0, MIN377_tree);
			}

			char_literal378=(Token)match(input,139,FOLLOW_139_in_min_func5168); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal378_tree = (CommonTree)adaptor.create(char_literal378);
			adaptor.addChild(root_0, char_literal378_tree);
			}

			pushFollow(FOLLOW_expression_in_min_func5172);
			ie=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, ie.getTree());

			// WreslTree.g:632:26: ( ',' e= expression )+
			int cnt108=0;
			loop108:
			while (true) {
				int alt108=2;
				int LA108_0 = input.LA(1);
				if ( (LA108_0==143) ) {
					alt108=1;
				}

				switch (alt108) {
				case 1 :
					// WreslTree.g:632:27: ',' e= expression
					{
					char_literal379=(Token)match(input,143,FOLLOW_143_in_min_func5175); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal379_tree = (CommonTree)adaptor.create(char_literal379);
					adaptor.addChild(root_0, char_literal379_tree);
					}

					pushFollow(FOLLOW_expression_in_min_func5179);
					e=expression();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

					if ( state.backtracking==0 ) {
										expression_stack.peek().SV.addAll((e!=null?((WreslTreeParser.expression_return)e).members:null));
										expression_stack.peek().varInCycle.addAll((e!=null?((WreslTreeParser.expression_return)e).setVarInCycle:null));
									}
					}
					break;

				default :
					if ( cnt108 >= 1 ) break loop108;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(108, input);
					throw eee;
				}
				cnt108++;
			}

			char_literal380=(Token)match(input,140,FOLLOW_140_in_min_func5204); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal380_tree = (CommonTree)adaptor.create(char_literal380);
			adaptor.addChild(root_0, char_literal380_tree);
			}

			if ( state.backtracking==0 ) {	
				        		expression_stack.peek().SV.addAll((ie!=null?((WreslTreeParser.expression_return)ie).members:null));
				        		expression_stack.peek().varInCycle.addAll((ie!=null?((WreslTreeParser.expression_return)ie).setVarInCycle:null));
				        	}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// WreslTree.g:646:1: int_func : INT '(' e= expression ')' ;
	public final WreslTreeParser.int_func_return int_func() throws RecognitionException {
		WreslTreeParser.int_func_return retval = new WreslTreeParser.int_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INT381=null;
		Token char_literal382=null;
		Token char_literal383=null;
		ParserRuleReturnScope e =null;

		CommonTree INT381_tree=null;
		CommonTree char_literal382_tree=null;
		CommonTree char_literal383_tree=null;

		try {
			// WreslTree.g:647:2: ( INT '(' e= expression ')' )
			// WreslTree.g:647:4: INT '(' e= expression ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			INT381=(Token)match(input,INT,FOLLOW_INT_in_int_func5241); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INT381_tree = (CommonTree)adaptor.create(INT381);
			adaptor.addChild(root_0, INT381_tree);
			}

			char_literal382=(Token)match(input,139,FOLLOW_139_in_int_func5243); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal382_tree = (CommonTree)adaptor.create(char_literal382);
			adaptor.addChild(root_0, char_literal382_tree);
			}

			pushFollow(FOLLOW_expression_in_int_func5247);
			e=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

			char_literal383=(Token)match(input,140,FOLLOW_140_in_int_func5249); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal383_tree = (CommonTree)adaptor.create(char_literal383);
			adaptor.addChild(root_0, char_literal383_tree);
			}

			if ( state.backtracking==0 ) {
					expression_stack.peek().SV.addAll((e!=null?((WreslTreeParser.expression_return)e).members:null));
					expression_stack.peek().varInCycle.addAll((e!=null?((WreslTreeParser.expression_return)e).setVarInCycle:null));
				}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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


	public static class round_func_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "round_func"
	// WreslTree.g:654:1: round_func : ROUND '(' e= expression ')' ;
	public final WreslTreeParser.round_func_return round_func() throws RecognitionException {
		WreslTreeParser.round_func_return retval = new WreslTreeParser.round_func_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ROUND384=null;
		Token char_literal385=null;
		Token char_literal386=null;
		ParserRuleReturnScope e =null;

		CommonTree ROUND384_tree=null;
		CommonTree char_literal385_tree=null;
		CommonTree char_literal386_tree=null;

		try {
			// WreslTree.g:655:3: ( ROUND '(' e= expression ')' )
			// WreslTree.g:655:5: ROUND '(' e= expression ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			ROUND384=(Token)match(input,ROUND,FOLLOW_ROUND_in_round_func5267); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ROUND384_tree = (CommonTree)adaptor.create(ROUND384);
			adaptor.addChild(root_0, ROUND384_tree);
			}

			char_literal385=(Token)match(input,139,FOLLOW_139_in_round_func5269); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal385_tree = (CommonTree)adaptor.create(char_literal385);
			adaptor.addChild(root_0, char_literal385_tree);
			}

			pushFollow(FOLLOW_expression_in_round_func5273);
			e=expression();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

			char_literal386=(Token)match(input,140,FOLLOW_140_in_round_func5275); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal386_tree = (CommonTree)adaptor.create(char_literal386);
			adaptor.addChild(root_0, char_literal386_tree);
			}

			if ( state.backtracking==0 ) {
			    expression_stack.peek().SV.addAll((e!=null?((WreslTreeParser.expression_return)e).members:null));
			    expression_stack.peek().varInCycle.addAll((e!=null?((WreslTreeParser.expression_return)e).setVarInCycle:null));
			  }
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
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
	// $ANTLR end "round_func"

	// $ANTLR start synpred1_WreslTree
	public final void synpred1_WreslTree_fragment() throws RecognitionException {
		// WreslTree.g:547:4: ( expression relation expression )
		// WreslTree.g:547:6: expression relation expression
		{
		pushFollow(FOLLOW_expression_in_synpred1_WreslTree4635);
		expression();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_relation_in_synpred1_WreslTree4637);
		relation();
		state._fsp--;
		if (state.failed) return;

		pushFollow(FOLLOW_expression_in_synpred1_WreslTree4639);
		expression();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_WreslTree

	// $ANTLR start synpred2_WreslTree
	public final void synpred2_WreslTree_fragment() throws RecognitionException {
		// WreslTree.g:555:4: ( '(' logical_expr ')' )
		// WreslTree.g:555:6: '(' logical_expr ')'
		{
		match(input,139,FOLLOW_139_in_synpred2_WreslTree4671); if (state.failed) return;

		pushFollow(FOLLOW_logical_expr_in_synpred2_WreslTree4673);
		logical_expr();
		state._fsp--;
		if (state.failed) return;

		match(input,140,FOLLOW_140_in_synpred2_WreslTree4675); if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_WreslTree

	// Delegated rules

	public final boolean synpred2_WreslTree() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_WreslTree_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_WreslTree() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_WreslTree_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_sequence_in_mainFile330 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000400L});
	public static final BitSet FOLLOW_model_in_mainFile333 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_EOF_in_mainFile339 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_153_in_version_tag351 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_156_in_version_tag353 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_version_number_in_version_tag357 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_version_tag359 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FLOAT_in_version_number371 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_pattern_in_evaluator380 = new BitSet(new long[]{0x0040400000200000L,0x0000000000020000L});
	public static final BitSet FOLLOW_EOF_in_evaluator387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dvar_in_pattern399 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_in_pattern403 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goal_in_pattern407 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_includeFile_in_pattern411 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alias_in_pattern415 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_weight_table_in_pattern419 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_external_in_pattern423 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_in_pattern427 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_timeArray_in_pattern432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_std_in_integer443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_nonStd_in_integer447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_timeArray_std_in_integer451 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_timeArray_nonStd_in_integer455 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_integer_std468 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_integer_std472 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_integer_std476 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_integer_std479 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_integer_std486 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_integer_std488 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_INTEGER_WORD_in_integer_std490 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_STD_in_integer_std492 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_KIND_in_integer_std494 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_integer_std498 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_UNITS_in_integer_std500 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_integer_std504 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_integer_std506 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_integer_nonStd540 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_integer_nonStd544 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_integer_nonStd548 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_integer_nonStd551 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_integer_nonStd558 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_integer_nonStd560 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_INTEGER_WORD_in_integer_nonStd562 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000002L});
	public static final BitSet FOLLOW_lower_and_or_upper_in_integer_nonStd564 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_KIND_in_integer_nonStd566 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_integer_nonStd570 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_UNITS_in_integer_nonStd572 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_integer_nonStd576 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_integer_nonStd578 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_integer_timeArray_std616 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_139_in_integer_timeArray_std618 = new BitSet(new long[]{0x0110000000000000L});
	public static final BitSet FOLLOW_timeArraySize_in_integer_timeArray_std622 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_integer_timeArray_std624 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_integer_timeArray_std628 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_integer_timeArray_std632 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_integer_timeArray_std635 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_integer_timeArray_std642 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_integer_timeArray_std644 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_INTEGER_WORD_in_integer_timeArray_std646 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_STD_in_integer_timeArray_std648 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_KIND_in_integer_timeArray_std650 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_integer_timeArray_std654 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_UNITS_in_integer_timeArray_std656 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_integer_timeArray_std660 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_integer_timeArray_std662 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_integer_timeArray_nonStd702 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_139_in_integer_timeArray_nonStd704 = new BitSet(new long[]{0x0110000000000000L});
	public static final BitSet FOLLOW_timeArraySize_in_integer_timeArray_nonStd708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_integer_timeArray_nonStd710 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_integer_timeArray_nonStd714 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_integer_timeArray_nonStd718 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_integer_timeArray_nonStd721 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_integer_timeArray_nonStd728 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_integer_timeArray_nonStd730 = new BitSet(new long[]{0x0400000000000000L});
	public static final BitSet FOLLOW_INTEGER_WORD_in_integer_timeArray_nonStd732 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000002L});
	public static final BitSet FOLLOW_lower_and_or_upper_in_integer_timeArray_nonStd734 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_KIND_in_integer_timeArray_nonStd736 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_integer_timeArray_nonStd740 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_UNITS_in_integer_timeArray_nonStd742 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_integer_timeArray_nonStd746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_integer_timeArray_nonStd748 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_external788 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_external792 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_external796 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_external799 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_external806 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_external808 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_EXTERNAL_in_external810 = new BitSet(new long[]{0x0000008004000000L});
	public static final BitSet FOLLOW_DLL_in_external815 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_F90_in_external819 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_external822 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OBJECTIVE_in_weight_table852 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_weight_table856 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_weight_table860 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_weight_table863 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_weight_table868 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_149_in_weight_table870 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_weight_table872 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_weightItem_in_weight_table877 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000042000000L});
	public static final BitSet FOLLOW_158_in_weight_table880 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_153_in_weightItem913 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_weightItem916 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008800L});
	public static final BitSet FOLLOW_139_in_weightItem919 = new BitSet(new long[]{0x0110000000000000L});
	public static final BitSet FOLLOW_timeArraySize_in_weightItem923 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_weightItem925 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_143_in_weightItem932 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_weightItem936 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_weightItem938 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_143_in_weightItem941 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MODEL_in_model979 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_model983 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_model985 = new BitSet(new long[]{0x0040400000200000L,0x0000000000020000L});
	public static final BitSet FOLLOW_pattern_in_model988 = new BitSet(new long[]{0x0040400000200000L,0x0000000000020000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_model994 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEQUENCE_in_sequence1046 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_sequence1050 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_sequence1052 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
	public static final BitSet FOLLOW_MODEL_in_sequence1054 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_sequence1058 = new BitSet(new long[]{0x0000000000004000L,0x0000000000080000L});
	public static final BitSet FOLLOW_condition_in_sequence1064 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_ORDER_in_sequence1068 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_INTEGER_in_sequence1070 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_TIMESTEP_in_sequence1073 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
	public static final BitSet FOLLOW_TIMESTEPVALUE_in_sequence1077 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_sequence1082 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONDITION_in_condition1131 = new BitSet(new long[]{0x0190020000000020L,0x000000000A008300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_logical_expr_in_condition1139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALWAYS_in_condition1146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INCLUDE_in_includeFile1166 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_includeFile1170 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_includeFile1174 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_includeFile1177 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_FILE_PATH_in_includeFile1182 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_alias1207 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000800L});
	public static final BitSet FOLLOW_alias_simple_in_alias1211 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alias_timeArray_simple_in_alias1213 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_153_in_alias_simple1224 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_alias_simple1228 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_alias_simple1231 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_alias_simple1238 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_alias_simple1240 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ALIAS_in_alias_simple1242 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_alias_simple1246 = new BitSet(new long[]{0x1000000000000000L,0x0100000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_KIND_in_alias_simple1249 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_alias_simple1253 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_UNITS_in_alias_simple1258 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_alias_simple1262 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_alias_simple1266 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_alias_timeArray_simple1306 = new BitSet(new long[]{0x0110000000000000L});
	public static final BitSet FOLLOW_timeArraySize_in_alias_timeArray_simple1310 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_alias_timeArray_simple1312 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_alias_timeArray_simple1316 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_alias_timeArray_simple1320 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_alias_timeArray_simple1323 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_alias_timeArray_simple1330 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_alias_timeArray_simple1332 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ALIAS_in_alias_timeArray_simple1334 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_alias_timeArray_simple1338 = new BitSet(new long[]{0x1000000000000000L,0x0100000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_KIND_in_alias_timeArray_simple1341 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_alias_timeArray_simple1345 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_UNITS_in_alias_timeArray_simple1350 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_alias_timeArray_simple1354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_alias_timeArray_simple1358 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_goal1413 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000800L});
	public static final BitSet FOLLOW_goal_simple_in_goal1417 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goal_case_or_nocase_in_goal1421 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goal_timeArray_simple_in_goal1425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goal_timeArray_case_or_nocase_in_goal1429 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_153_in_goal_simple1447 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_goal_simple1451 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_goal_simple1454 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_goal_simple1461 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_goal_simple1463 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_constraint_statement_in_goal_simple1467 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_goal_simple1469 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_goal_timeArray_simple1510 = new BitSet(new long[]{0x0110000000000000L});
	public static final BitSet FOLLOW_timeArraySize_in_goal_timeArray_simple1514 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_goal_timeArray_simple1516 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_goal_timeArray_simple1520 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_goal_timeArray_simple1524 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_goal_timeArray_simple1527 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_goal_timeArray_simple1534 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_goal_timeArray_simple1536 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_constraint_statement_in_goal_timeArray_simple1540 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_goal_timeArray_simple1542 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_153_in_goal_case_or_nocase1590 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_goal_case_or_nocase1594 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_goal_case_or_nocase1597 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_goal_case_or_nocase1604 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_goal_case_or_nocase1610 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_LHS_in_goal_case_or_nocase1612 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_goal_case_or_nocase1616 = new BitSet(new long[]{0x0000000000000800L,0x0000000004000000L});
	public static final BitSet FOLLOW_goal_no_case_content_in_goal_case_or_nocase1628 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_goal_case_content_in_goal_case_or_nocase1661 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_goal_case_or_nocase1698 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_goal_timeArray_case_or_nocase1714 = new BitSet(new long[]{0x0110000000000000L});
	public static final BitSet FOLLOW_timeArraySize_in_goal_timeArray_case_or_nocase1718 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_goal_timeArray_case_or_nocase1720 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_goal_timeArray_case_or_nocase1724 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_goal_timeArray_case_or_nocase1728 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_goal_timeArray_case_or_nocase1731 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_goal_timeArray_case_or_nocase1738 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_goal_timeArray_case_or_nocase1745 = new BitSet(new long[]{0x8000000000000000L});
	public static final BitSet FOLLOW_LHS_in_goal_timeArray_case_or_nocase1747 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_goal_timeArray_case_or_nocase1751 = new BitSet(new long[]{0x0000000000000800L,0x0000000004000000L});
	public static final BitSet FOLLOW_goal_no_case_content_in_goal_timeArray_case_or_nocase1765 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_goal_case_content_in_goal_timeArray_case_or_nocase1801 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_goal_timeArray_case_or_nocase1839 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CASE_in_goal_case_content1858 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_goal_case_content1862 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_goal_case_content1868 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_condition_in_goal_case_content1872 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_RHS_in_goal_case_content1874 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_goal_case_content1878 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_sub_content_in_goal_case_content1883 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_goal_case_content1888 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RHS_in_goal_no_case_content1977 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_goal_no_case_content1981 = new BitSet(new long[]{0x8000000000000002L});
	public static final BitSet FOLLOW_sub_content_in_goal_no_case_content1986 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lhs_gt_rhs_in_sub_content2072 = new BitSet(new long[]{0x8000000000000002L});
	public static final BitSet FOLLOW_lhs_lt_rhs_in_sub_content2079 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lhs_lt_rhs_in_sub_content2136 = new BitSet(new long[]{0x8000000000000002L});
	public static final BitSet FOLLOW_lhs_gt_rhs_in_sub_content2143 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LHS_in_lhs_gt_rhs2224 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_151_in_lhs_gt_rhs2226 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_RHS_in_lhs_gt_rhs2228 = new BitSet(new long[]{0x0000000000008000L,0x0000000000800000L});
	public static final BitSet FOLLOW_CONSTRAIN_in_lhs_gt_rhs2236 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_penalty_in_lhs_gt_rhs2263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LHS_in_lhs_lt_rhs2358 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000080000L});
	public static final BitSet FOLLOW_147_in_lhs_lt_rhs2360 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_RHS_in_lhs_lt_rhs2362 = new BitSet(new long[]{0x0000000000008000L,0x0000000000800000L});
	public static final BitSet FOLLOW_CONSTRAIN_in_lhs_lt_rhs2370 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_penalty_in_lhs_lt_rhs2396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_PENALTY_in_penalty2479 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_penalty2483 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_svar2497 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_svar_dss_in_svar2501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_expr_in_svar2505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_sum_in_svar2509 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_table_in_svar2513 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_case_in_svar2517 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_svar_timeArray2529 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_svar_timeArray_expr_in_svar_timeArray2534 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_timeArray_case_in_svar_timeArray2538 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_timeArray_table_in_svar_timeArray2541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_timeArray_sum_in_svar_timeArray2545 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_dvar2558 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000800L});
	public static final BitSet FOLLOW_dvar_std_in_dvar2562 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dvar_nonStd_in_dvar2566 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_153_in_svar_case2580 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_svar_case2584 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_svar_case2587 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_case2594 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_svar_case2596 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_case_content_in_svar_case2598 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_svar_case2601 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_svar_timeArray_case2632 = new BitSet(new long[]{0x0110000000000000L});
	public static final BitSet FOLLOW_timeArraySize_in_svar_timeArray_case2636 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_svar_timeArray_case2638 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_svar_timeArray_case2642 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_svar_timeArray_case2646 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_svar_timeArray_case2649 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_timeArray_case2656 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_svar_timeArray_case2658 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_case_content_in_svar_timeArray_case2660 = new BitSet(new long[]{0x0000000000000800L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_svar_timeArray_case2663 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CASE_in_case_content2707 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_case_content2711 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_case_content2713 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_condition_in_case_content2717 = new BitSet(new long[]{0x0000000000000000L,0x8000000220000000L});
	public static final BitSet FOLLOW_table_content_in_case_content2730 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_value_content_in_case_content2760 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_sum_content_in_case_content2791 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_case_content2820 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VALUE_in_value_content2830 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_value_content2834 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_153_in_svar_table2857 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_svar_table2861 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_svar_table2864 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_table2872 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_svar_table2874 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_table_content_in_svar_table2876 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_svar_table2878 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_svar_timeArray_table2910 = new BitSet(new long[]{0x0110000000000000L});
	public static final BitSet FOLLOW_timeArraySize_in_svar_timeArray_table2914 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_svar_timeArray_table2916 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_svar_timeArray_table2920 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L,0x0000000004000000L});
	public static final BitSet FOLLOW_LOCAL_in_svar_timeArray_table2924 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_svar_timeArray_table2927 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_timeArray_table2934 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_svar_timeArray_table2936 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_table_content_in_svar_timeArray_table2938 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_svar_timeArray_table2940 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_table_content2973 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_table_content2977 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_FROM_in_table_content2979 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_table_content2983 = new BitSet(new long[]{0x0000200000000002L,0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_GIVEN_in_table_content2991 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L});
	public static final BitSet FOLLOW_assignment_in_table_content2995 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_USE_in_table_content2997 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_table_content3001 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_WHERE_in_table_content3011 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L});
	public static final BitSet FOLLOW_where_items_in_table_content3015 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_where_items3086 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_143_in_where_items3089 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L});
	public static final BitSet FOLLOW_assignment_in_where_items3093 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_153_in_svar_expr3116 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_LOCAL_in_svar_expr3120 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_svar_expr3122 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_expr3127 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_svar_expr3129 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
	public static final BitSet FOLLOW_VALUE_in_svar_expr3131 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_svar_expr3136 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_svar_expr3137 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_svar_timeArray_expr3174 = new BitSet(new long[]{0x0110000000000000L});
	public static final BitSet FOLLOW_timeArraySize_in_svar_timeArray_expr3178 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_svar_timeArray_expr3180 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_svar_timeArray_expr3184 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_LOCAL_in_svar_timeArray_expr3188 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_svar_timeArray_expr3190 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_timeArray_expr3195 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_svar_timeArray_expr3197 = new BitSet(new long[]{0x0000000000000000L,0x8000000000000000L});
	public static final BitSet FOLLOW_VALUE_in_svar_timeArray_expr3199 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_svar_timeArray_expr3204 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_svar_timeArray_expr3205 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_153_in_svar_sum3245 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_LOCAL_in_svar_sum3249 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_svar_sum3251 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_sum3256 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_svar_sum3258 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_sum_content_in_svar_sum3260 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_svar_sum3262 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_svar_timeArray_sum3294 = new BitSet(new long[]{0x0110000000000000L});
	public static final BitSet FOLLOW_timeArraySize_in_svar_timeArray_sum3298 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_svar_timeArray_sum3300 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_svar_timeArray_sum3304 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_LOCAL_in_svar_timeArray_sum3308 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_svar_timeArray_sum3310 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_timeArray_sum3315 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_svar_timeArray_sum3317 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_sum_content_in_svar_timeArray_sum3319 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_svar_timeArray_sum3321 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SUM_in_sum_content3356 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_sum_header_in_sum_content3360 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_sum_content3364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_sum_header3399 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000008000000L});
	public static final BitSet FOLLOW_155_in_sum_header3401 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_sum_header3405 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_143_in_sum_header3407 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_sum_header3411 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000009000L});
	public static final BitSet FOLLOW_143_in_sum_header3414 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_144_in_sum_header3416 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_INTEGER_in_sum_header3419 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_sum_header3424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_153_in_svar_dss3444 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_LOCAL_in_svar_dss3448 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_svar_dss3450 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_dss3455 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_svar_dss3457 = new BitSet(new long[]{0x0000000000000000L,0x0004000000000000L});
	public static final BitSet FOLLOW_TIMESERIES_in_svar_dss3459 = new BitSet(new long[]{0x1000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_svar_dss3463 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_KIND_in_svar_dss3466 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_svar_dss3470 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_UNITS_in_svar_dss3472 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_svar_dss3476 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_CONVERT_in_svar_dss3479 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_svar_dss3483 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_svar_dss3487 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_timeArraySize3542 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_timeArraySize3553 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_dvar_std3576 = new BitSet(new long[]{0x0110000000000000L});
	public static final BitSet FOLLOW_timeArraySize_in_dvar_std3580 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_dvar_std3582 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_dvar_std3588 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_LOCAL_in_dvar_std3592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_dvar_std3594 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_dvar_std3599 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_dvar_std3601 = new BitSet(new long[]{0x0000000000000000L,0x0000000080000000L});
	public static final BitSet FOLLOW_STD_in_dvar_std3603 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_KIND_in_dvar_std3605 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_dvar_std3609 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_UNITS_in_dvar_std3611 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_dvar_std3615 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_dvar_std3617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_dvar_nonStd3730 = new BitSet(new long[]{0x0110000000000000L});
	public static final BitSet FOLLOW_timeArraySize_in_dvar_nonStd3734 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_dvar_nonStd3736 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_dvar_nonStd3742 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_LOCAL_in_dvar_nonStd3746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_dvar_nonStd3748 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_dvar_nonStd3753 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_157_in_dvar_nonStd3755 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000002L});
	public static final BitSet FOLLOW_lower_and_or_upper_in_dvar_nonStd3757 = new BitSet(new long[]{0x1000000000000000L});
	public static final BitSet FOLLOW_KIND_in_dvar_nonStd3759 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_dvar_nonStd3763 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_UNITS_in_dvar_nonStd3765 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_dvar_nonStd3769 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_158_in_dvar_nonStd3771 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lower_upper_in_lower_and_or_upper3885 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_upper_lower_in_lower_and_or_upper3896 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lower_in_lower_upper3912 = new BitSet(new long[]{0x0000000000000002L,0x0200000000000000L});
	public static final BitSet FOLLOW_upper_in_lower_upper3917 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_upper_in_upper_lower3969 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_lower_in_upper_lower3974 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOWER_in_lower4061 = new BitSet(new long[]{0x0190020000000000L,0x0080000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_UNBOUNDED_in_lower4065 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_lower4078 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPPER_in_upper4094 = new BitSet(new long[]{0x0190020000000000L,0x0080000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_UNBOUNDED_in_upper4098 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_upper4111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constraint_statement_preprocessed_in_constraint_statement4139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_constraint_statement_preprocessed4161 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000A80000L});
	public static final BitSet FOLLOW_set_in_constraint_statement_preprocessed4163 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_constraint_statement_preprocessed4180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_simple_in_assignment4204 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_149_in_assignment4207 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_assignment4211 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_simple_in_lt_or_gt4249 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000880000L});
	public static final BitSet FOLLOW_set_in_lt_or_gt4251 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_lt_or_gt4263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_simple_in_le_or_ge4284 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001100000L});
	public static final BitSet FOLLOW_set_in_le_or_ge4286 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_le_or_ge4296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_term_simple_in_equal_statement4310 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_150_in_equal_statement4312 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_equal_statement4314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_term_simple4337 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_term_simple4341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_term_simple4345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_ident4354 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_138_in_array_iterator4363 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ident_in_term4380 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_array_iterator_in_term4396 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_in_term4410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_in_term4424 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_term4437 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_term4441 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_term4443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_term4457 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
	public static final BitSet FOLLOW_sum_content_in_term4461 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_term4463 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_142_in_unary4479 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000000C00L});
	public static final BitSet FOLLOW_negation_in_unary4484 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000000C00L});
	public static final BitSet FOLLOW_term_in_unary4488 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_144_in_negation4498 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unary_in_mult4512 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000022000L});
	public static final BitSet FOLLOW_set_in_mult4515 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_unary_in_mult4524 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000022000L});
	public static final BitSet FOLLOW_mult_in_add4537 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000014000L});
	public static final BitSet FOLLOW_set_in_add4540 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_mult_in_add4548 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000014000L});
	public static final BitSet FOLLOW_c_unary_in_logical_expr4576 = new BitSet(new long[]{0x0000000000000042L,0x0000000000040000L});
	public static final BitSet FOLLOW_bin_in_logical_expr4580 = new BitSet(new long[]{0x0190020000000000L,0x000000000A008300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_c_unary_in_logical_expr4582 = new BitSet(new long[]{0x0000000000000042L,0x0000000000040000L});
	public static final BitSet FOLLOW_add_in_expression4618 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_c_term4647 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001DC0000L});
	public static final BitSet FOLLOW_relation_in_c_term4649 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_c_term4653 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_function_logical_in_c_term4664 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_c_term4681 = new BitSet(new long[]{0x0190020000000000L,0x000000000A008300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_logical_expr_in_c_term4685 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_c_term4687 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_c_negation_in_c_unary4705 = new BitSet(new long[]{0x0190020000000000L,0x000000000A000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_c_term_in_c_unary4709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_c_negation4720 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_bin4768 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_bin4777 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_external_func_in_function4800 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_max_func_in_function4804 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_min_func_in_function4808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_int_func_in_function4812 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_round_func_in_function4816 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_model_in_function4820 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_range_func_in_function_logical4829 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_model_noTimeArray_in_var_model4837 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_model_timeArray_in_var_model4839 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_modelindex_noTimeArray_in_var_model4841 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_var_modelindex_TimeArray_in_var_model4843 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_var_model_noTimeArray4867 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_var_model_noTimeArray4869 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_var_model_noTimeArray4875 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_var_model_noTimeArray4877 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_var_model_timeArray4898 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_var_model_timeArray4900 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_var_model_timeArray4906 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_var_model_timeArray4908 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_139_in_var_model_timeArray4910 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_var_model_timeArray4914 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_var_model_timeArray4916 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_var_modelindex_noTimeArray4937 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_var_modelindex_noTimeArray4939 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_144_in_var_modelindex_noTimeArray4944 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_INTEGER_in_var_modelindex_noTimeArray4946 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_var_modelindex_noTimeArray4949 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_var_modelindex_TimeArray4968 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000002000000L});
	public static final BitSet FOLLOW_153_in_var_modelindex_TimeArray4970 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_144_in_var_modelindex_TimeArray4975 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_INTEGER_in_var_modelindex_TimeArray4977 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_154_in_var_modelindex_TimeArray4980 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_139_in_var_modelindex_TimeArray4982 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_var_modelindex_TimeArray4986 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_var_modelindex_TimeArray4988 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_external_func5003 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_139_in_external_func5007 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_external_func5012 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000009000L});
	public static final BitSet FOLLOW_143_in_external_func5015 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_external_func5019 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000009000L});
	public static final BitSet FOLLOW_140_in_external_func5029 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANGE_in_range_func5054 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_139_in_range_func5056 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_range_func5058 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_143_in_range_func5060 = new BitSet(new long[]{0x0110020000000000L});
	public static final BitSet FOLLOW_IDENT_in_range_func5064 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_number_in_range_func5068 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_143_in_range_func5072 = new BitSet(new long[]{0x0110020000000000L});
	public static final BitSet FOLLOW_IDENT_in_range_func5076 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_number_in_range_func5080 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_range_func5084 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MAX_in_max_func5094 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_139_in_max_func5096 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_max_func5100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_143_in_max_func5103 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_max_func5107 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000009000L});
	public static final BitSet FOLLOW_140_in_max_func5131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MIN_in_min_func5166 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_139_in_min_func5168 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_min_func5172 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_143_in_min_func5175 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_min_func5179 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000009000L});
	public static final BitSet FOLLOW_140_in_min_func5204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_int_func5241 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_139_in_int_func5243 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_int_func5247 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_int_func5249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ROUND_in_round_func5267 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_139_in_round_func5269 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_round_func5273 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_round_func5275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expression_in_synpred1_WreslTree4635 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001DC0000L});
	public static final BitSet FOLLOW_relation_in_synpred1_WreslTree4637 = new BitSet(new long[]{0x0190020000000000L,0x0000000008000300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_expression_in_synpred1_WreslTree4639 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_synpred2_WreslTree4671 = new BitSet(new long[]{0x0190020000000000L,0x000000000A008300L,0x0000000000014C00L});
	public static final BitSet FOLLOW_logical_expr_in_synpred2_WreslTree4673 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_synpred2_WreslTree4675 = new BitSet(new long[]{0x0000000000000002L});
}
