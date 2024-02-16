// $ANTLR 3.5.2 WreslTreeWalker.g 2024-02-12 13:15:30

  package wrimsv2.wreslparser.grammar;
  import java.util.Map;
  import java.util.HashMap;
  import wrimsv2.wreslparser.elements.StructTree;
  import wrimsv2.wreslparser.elements.SimulationDataSet;
  import wrimsv2.wreslparser.elements.Tools;
  import wrimsv2.wreslparser.elements.LogUtils; 
  import wrimsv2.commondata.wresldata.Param;
  import wrimsv2.commondata.wresldata.Goal;
  import wrimsv2.commondata.wresldata.Svar;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings("all")
public class WreslTreeWalker extends TreeParser {
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
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public WreslTreeWalker(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public WreslTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return WreslTreeWalker.tokenNames; }
	@Override public String getGrammarFileName() { return "WreslTreeWalker.g"; }



	  public int result;
	  public CommonTree commonTree;
	  public String currentAbsolutePath;
	  public String currentAbsoluteParent;
	  
	  	public StructTree F = new StructTree();	
	  	public SimulationDataSet thisFileDataSet = new SimulationDataSet();
	  	private SimulationDataSet S;
	  	  	
	  	public Map<String, SimulationDataSet> modelDataMap = new HashMap<String, SimulationDataSet>();  	
	  		/// error message	
	    public void displayRecognitionError(String[] tokenNames,
	                                        RecognitionException e) {
	        String hdr = getErrorHeader(e);
	        String msg = getErrorMessage(e, tokenNames);
	        LogUtils.errMsg(hdr + " " + msg);
	    }



	// $ANTLR start "evaluator"
	// WreslTreeWalker.g:39:1: evaluator : ( ( pattern )+ | ( ( sequence )+ ( model )+ ) ) EOF ;
	public final void evaluator() throws RecognitionException {
		 
				F.S = thisFileDataSet;
				F.S.currentAbsolutePath = currentAbsolutePath;
				F.S.currentAbsoluteParent = currentAbsoluteParent;
			  
		try {
			// WreslTreeWalker.g:45:2: ( ( ( pattern )+ | ( ( sequence )+ ( model )+ ) ) EOF )
			// WreslTreeWalker.g:46:2: ( ( pattern )+ | ( ( sequence )+ ( model )+ ) ) EOF
			{
			// WreslTreeWalker.g:46:2: ( ( pattern )+ | ( ( sequence )+ ( model )+ ) )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==Alias||(LA4_0 >= DvarTimeArray_nonStd && LA4_0 <= Dvar_nonStd)||LA4_0==Dvar_std||LA4_0==External||(LA4_0 >= Goal_case && LA4_0 <= Goal_simple)||LA4_0==Include||(LA4_0 >= SvarTimeArray_case && LA4_0 <= Svar_table)||LA4_0==Weight_table) ) {
				alt4=1;
			}
			else if ( (LA4_0==Sequence) ) {
				alt4=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// WreslTreeWalker.g:46:10: ( pattern )+
					{
					// WreslTreeWalker.g:46:10: ( pattern )+
					int cnt1=0;
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( (LA1_0==Alias||(LA1_0 >= DvarTimeArray_nonStd && LA1_0 <= Dvar_nonStd)||LA1_0==Dvar_std||LA1_0==External||(LA1_0 >= Goal_case && LA1_0 <= Goal_simple)||LA1_0==Include||(LA1_0 >= SvarTimeArray_case && LA1_0 <= Svar_table)||LA1_0==Weight_table) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// WreslTreeWalker.g:46:10: pattern
							{
							pushFollow(FOLLOW_pattern_in_evaluator68);
							pattern();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt1 >= 1 ) break loop1;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(1, input);
							throw eee;
						}
						cnt1++;
					}

					}
					break;
				case 2 :
					// WreslTreeWalker.g:47:8: ( ( sequence )+ ( model )+ )
					{
					// WreslTreeWalker.g:47:8: ( ( sequence )+ ( model )+ )
					// WreslTreeWalker.g:47:10: ( sequence )+ ( model )+
					{
					// WreslTreeWalker.g:47:10: ( sequence )+
					int cnt2=0;
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0==Sequence) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// WreslTreeWalker.g:47:10: sequence
							{
							pushFollow(FOLLOW_sequence_in_evaluator81);
							sequence();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt2 >= 1 ) break loop2;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(2, input);
							throw eee;
						}
						cnt2++;
					}

					// WreslTreeWalker.g:47:21: ( model )+
					int cnt3=0;
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==Model) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// WreslTreeWalker.g:47:21: model
							{
							pushFollow(FOLLOW_model_in_evaluator85);
							model();
							state._fsp--;
							if (state.failed) return;
							}
							break;

						default :
							if ( cnt3 >= 1 ) break loop3;
							if (state.backtracking>0) {state.failed=true; return;}
							EarlyExitException eee = new EarlyExitException(3, input);
							throw eee;
						}
						cnt3++;
					}

					}

					}
					break;

			}

			match(input,EOF,FOLLOW_EOF_in_evaluator100); if (state.failed) return;
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



	// $ANTLR start "pattern"
	// WreslTreeWalker.g:52:1: pattern : ( dvar | svar | goal | includeFile | alias | weight_table | external | integer | svar_timeArray );
	public final void pattern() throws RecognitionException {
		try {
			// WreslTreeWalker.g:53:2: ( dvar | svar | goal | includeFile | alias | weight_table | external | integer | svar_timeArray )
			int alt5=9;
			switch ( input.LA(1) ) {
			case DvarTimeArray_nonStd:
			case DvarTimeArray_std:
			case Dvar_nonStd:
			case Dvar_std:
				{
				alt5=1;
				}
				break;
			case Svar_case:
			case Svar_const:
			case Svar_dss:
				{
				alt5=2;
				}
				break;
			case Svar_sum:
				{
				int LA5_3 = input.LA(2);
				if ( (LA5_3==DOWN) ) {
					int LA5_12 = input.LA(3);
					if ( (LA5_12==Scope) ) {
						alt5=2;
					}
					else if ( (LA5_12==TimeArraySize) ) {
						alt5=9;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
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

				else {
					if (state.backtracking>0) {state.failed=true; return;}
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
			case Svar_table:
				{
				int LA5_4 = input.LA(2);
				if ( (LA5_4==DOWN) ) {
					int LA5_13 = input.LA(3);
					if ( (LA5_13==Scope) ) {
						alt5=2;
					}
					else if ( (LA5_13==TimeArraySize) ) {
						alt5=9;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
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
					if (state.backtracking>0) {state.failed=true; return;}
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
			case Goal_case:
			case Goal_no_case:
			case Goal_simple:
				{
				alt5=3;
				}
				break;
			case Include:
				{
				alt5=4;
				}
				break;
			case Alias:
				{
				alt5=5;
				}
				break;
			case Weight_table:
				{
				alt5=6;
				}
				break;
			case External:
				{
				alt5=7;
				}
				break;
			case Dvar_integer:
				{
				alt5=8;
				}
				break;
			case SvarTimeArray_case:
			case SvarTimeArray_const:
				{
				alt5=9;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// WreslTreeWalker.g:53:4: dvar
					{
					pushFollow(FOLLOW_dvar_in_pattern111);
					dvar();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// WreslTreeWalker.g:53:11: svar
					{
					pushFollow(FOLLOW_svar_in_pattern115);
					svar();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// WreslTreeWalker.g:53:18: goal
					{
					pushFollow(FOLLOW_goal_in_pattern119);
					goal();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 4 :
					// WreslTreeWalker.g:53:25: includeFile
					{
					pushFollow(FOLLOW_includeFile_in_pattern123);
					includeFile();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 5 :
					// WreslTreeWalker.g:53:39: alias
					{
					pushFollow(FOLLOW_alias_in_pattern127);
					alias();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 6 :
					// WreslTreeWalker.g:53:47: weight_table
					{
					pushFollow(FOLLOW_weight_table_in_pattern131);
					weight_table();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 7 :
					// WreslTreeWalker.g:53:62: external
					{
					pushFollow(FOLLOW_external_in_pattern135);
					external();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 8 :
					// WreslTreeWalker.g:53:73: integer
					{
					pushFollow(FOLLOW_integer_in_pattern139);
					integer();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 9 :
					// WreslTreeWalker.g:54:4: svar_timeArray
					{
					pushFollow(FOLLOW_svar_timeArray_in_pattern144);
					svar_timeArray();
					state._fsp--;
					if (state.failed) return;
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
	// $ANTLR end "pattern"



	// $ANTLR start "integer"
	// WreslTreeWalker.g:57:1: integer : ( integer_std | integer_nonStd | integer_timeArray_std | integer_timeArray_nonStd );
	public final void integer() throws RecognitionException {
		try {
			// WreslTreeWalker.g:58:2: ( integer_std | integer_nonStd | integer_timeArray_std | integer_timeArray_nonStd )
			int alt6=4;
			int LA6_0 = input.LA(1);
			if ( (LA6_0==Dvar_integer) ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1==DOWN) ) {
					int LA6_2 = input.LA(3);
					if ( (LA6_2==Scope) ) {
						int LA6_3 = input.LA(4);
						if ( (LA6_3==IDENT) ) {
							int LA6_5 = input.LA(5);
							if ( (LA6_5==Kind) ) {
								alt6=1;
							}
							else if ( (LA6_5==Lower) ) {
								alt6=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
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

						else {
							if (state.backtracking>0) {state.failed=true; return;}
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
					else if ( (LA6_2==TimeArraySize) ) {
						int LA6_4 = input.LA(4);
						if ( (LA6_4==Scope) ) {
							int LA6_6 = input.LA(5);
							if ( (LA6_6==IDENT) ) {
								int LA6_9 = input.LA(6);
								if ( (LA6_9==Kind) ) {
									alt6=3;
								}
								else if ( (LA6_9==Lower) ) {
									alt6=4;
								}

								else {
									if (state.backtracking>0) {state.failed=true; return;}
									int nvaeMark = input.mark();
									try {
										for (int nvaeConsume = 0; nvaeConsume < 6 - 1; nvaeConsume++) {
											input.consume();
										}
										NoViableAltException nvae =
											new NoViableAltException("", 6, 9, input);
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
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 6, 6, input);
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
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
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
						if (state.backtracking>0) {state.failed=true; return;}
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
					if (state.backtracking>0) {state.failed=true; return;}
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
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// WreslTreeWalker.g:58:4: integer_std
					{
					pushFollow(FOLLOW_integer_std_in_integer155);
					integer_std();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// WreslTreeWalker.g:58:18: integer_nonStd
					{
					pushFollow(FOLLOW_integer_nonStd_in_integer159);
					integer_nonStd();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// WreslTreeWalker.g:58:35: integer_timeArray_std
					{
					pushFollow(FOLLOW_integer_timeArray_std_in_integer163);
					integer_timeArray_std();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 4 :
					// WreslTreeWalker.g:58:59: integer_timeArray_nonStd
					{
					pushFollow(FOLLOW_integer_timeArray_nonStd_in_integer167);
					integer_timeArray_nonStd();
					state._fsp--;
					if (state.failed) return;
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
	// $ANTLR end "integer"



	// $ANTLR start "integer_std"
	// WreslTreeWalker.g:61:1: integer_std : ^( Dvar_integer sc= Scope i= IDENT k= Kind u= Units ) ;
	public final void integer_std() throws RecognitionException {
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree k=null;
		CommonTree u=null;

		try {
			// WreslTreeWalker.g:62:2: ( ^( Dvar_integer sc= Scope i= IDENT k= Kind u= Units ) )
			// WreslTreeWalker.g:62:5: ^( Dvar_integer sc= Scope i= IDENT k= Kind u= Units )
			{
			match(input,Dvar_integer,FOLLOW_Dvar_integer_in_integer_std182); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_integer_std186); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_integer_std190); if (state.failed) return;
			k=(CommonTree)match(input,Kind,FOLLOW_Kind_in_integer_std194); if (state.failed) return;
			u=(CommonTree)match(input,Units,FOLLOW_Units_in_integer_std198); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {F.dvarStd((i!=null?i.getText():null), (sc!=null?sc.getText():null), "integer", Tools.strip((k!=null?k.getText():null)), Tools.strip((u!=null?u.getText():null))); }
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
	// $ANTLR end "integer_std"



	// $ANTLR start "integer_nonStd"
	// WreslTreeWalker.g:66:1: integer_nonStd : ^( Dvar_integer sc= Scope i= IDENT Lower lowerbound= LimitType Upper upperbound= LimitType k= Kind u= Units ) ;
	public final void integer_nonStd() throws RecognitionException {
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree lowerbound=null;
		CommonTree upperbound=null;
		CommonTree k=null;
		CommonTree u=null;

		try {
			// WreslTreeWalker.g:67:2: ( ^( Dvar_integer sc= Scope i= IDENT Lower lowerbound= LimitType Upper upperbound= LimitType k= Kind u= Units ) )
			// WreslTreeWalker.g:67:5: ^( Dvar_integer sc= Scope i= IDENT Lower lowerbound= LimitType Upper upperbound= LimitType k= Kind u= Units )
			{
			match(input,Dvar_integer,FOLLOW_Dvar_integer_in_integer_nonStd222); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_integer_nonStd226); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_integer_nonStd230); if (state.failed) return;
			match(input,Lower,FOLLOW_Lower_in_integer_nonStd232); if (state.failed) return;
			lowerbound=(CommonTree)match(input,LimitType,FOLLOW_LimitType_in_integer_nonStd236); if (state.failed) return;
			match(input,Upper,FOLLOW_Upper_in_integer_nonStd238); if (state.failed) return;
			upperbound=(CommonTree)match(input,LimitType,FOLLOW_LimitType_in_integer_nonStd242); if (state.failed) return;
			k=(CommonTree)match(input,Kind,FOLLOW_Kind_in_integer_nonStd246); if (state.failed) return;
			u=(CommonTree)match(input,Units,FOLLOW_Units_in_integer_nonStd250); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {F.dvarNonStd((i!=null?i.getText():null), (sc!=null?sc.getText():null), "integer", Tools.strip((k!=null?k.getText():null)), Tools.strip((u!=null?u.getText():null)),  (lowerbound!=null?lowerbound.getText():null), (upperbound!=null?upperbound.getText():null)); }
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
	// $ANTLR end "integer_nonStd"



	// $ANTLR start "integer_timeArray_std"
	// WreslTreeWalker.g:71:1: integer_timeArray_std : ^( Dvar_integer ta= TimeArraySize sc= Scope i= IDENT k= Kind u= Units ) ;
	public final void integer_timeArray_std() throws RecognitionException {
		CommonTree ta=null;
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree k=null;
		CommonTree u=null;

		try {
			// WreslTreeWalker.g:72:3: ( ^( Dvar_integer ta= TimeArraySize sc= Scope i= IDENT k= Kind u= Units ) )
			// WreslTreeWalker.g:72:6: ^( Dvar_integer ta= TimeArraySize sc= Scope i= IDENT k= Kind u= Units )
			{
			match(input,Dvar_integer,FOLLOW_Dvar_integer_in_integer_timeArray_std275); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			ta=(CommonTree)match(input,TimeArraySize,FOLLOW_TimeArraySize_in_integer_timeArray_std279); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_integer_timeArray_std283); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_integer_timeArray_std287); if (state.failed) return;
			k=(CommonTree)match(input,Kind,FOLLOW_Kind_in_integer_timeArray_std291); if (state.failed) return;
			u=(CommonTree)match(input,Units,FOLLOW_Units_in_integer_timeArray_std295); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {F.dvarStd((i!=null?i.getText():null), (sc!=null?sc.getText():null), "integer", Tools.strip((k!=null?k.getText():null)), Tools.strip((u!=null?u.getText():null)), (ta!=null?ta.getText():null)); }
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
	// $ANTLR end "integer_timeArray_std"



	// $ANTLR start "integer_timeArray_nonStd"
	// WreslTreeWalker.g:76:1: integer_timeArray_nonStd : ^( Dvar_integer ta= TimeArraySize sc= Scope i= IDENT Lower lowerbound= LimitType Upper upperbound= LimitType k= Kind u= Units ) ;
	public final void integer_timeArray_nonStd() throws RecognitionException {
		CommonTree ta=null;
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree lowerbound=null;
		CommonTree upperbound=null;
		CommonTree k=null;
		CommonTree u=null;

		try {
			// WreslTreeWalker.g:77:3: ( ^( Dvar_integer ta= TimeArraySize sc= Scope i= IDENT Lower lowerbound= LimitType Upper upperbound= LimitType k= Kind u= Units ) )
			// WreslTreeWalker.g:77:6: ^( Dvar_integer ta= TimeArraySize sc= Scope i= IDENT Lower lowerbound= LimitType Upper upperbound= LimitType k= Kind u= Units )
			{
			match(input,Dvar_integer,FOLLOW_Dvar_integer_in_integer_timeArray_nonStd323); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			ta=(CommonTree)match(input,TimeArraySize,FOLLOW_TimeArraySize_in_integer_timeArray_nonStd327); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_integer_timeArray_nonStd331); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_integer_timeArray_nonStd335); if (state.failed) return;
			match(input,Lower,FOLLOW_Lower_in_integer_timeArray_nonStd337); if (state.failed) return;
			lowerbound=(CommonTree)match(input,LimitType,FOLLOW_LimitType_in_integer_timeArray_nonStd341); if (state.failed) return;
			match(input,Upper,FOLLOW_Upper_in_integer_timeArray_nonStd343); if (state.failed) return;
			upperbound=(CommonTree)match(input,LimitType,FOLLOW_LimitType_in_integer_timeArray_nonStd347); if (state.failed) return;
			k=(CommonTree)match(input,Kind,FOLLOW_Kind_in_integer_timeArray_nonStd351); if (state.failed) return;
			u=(CommonTree)match(input,Units,FOLLOW_Units_in_integer_timeArray_nonStd355); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {F.dvarNonStd((i!=null?i.getText():null), (sc!=null?sc.getText():null), "integer", Tools.strip((k!=null?k.getText():null)), Tools.strip((u!=null?u.getText():null)),  (lowerbound!=null?lowerbound.getText():null), (upperbound!=null?upperbound.getText():null), (ta!=null?ta.getText():null)); }
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
	// $ANTLR end "integer_timeArray_nonStd"



	// $ANTLR start "external"
	// WreslTreeWalker.g:81:1: external : ^( External sc= Scope i= IDENT e= Expression ) ;
	public final void external() throws RecognitionException {
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree e=null;

		try {
			// WreslTreeWalker.g:82:2: ( ^( External sc= Scope i= IDENT e= Expression ) )
			// WreslTreeWalker.g:82:5: ^( External sc= Scope i= IDENT e= Expression )
			{
			match(input,External,FOLLOW_External_in_external381); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_external385); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_external389); if (state.failed) return;
			e=(CommonTree)match(input,Expression,FOLLOW_Expression_in_external393); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {F.external((i!=null?i.getText():null), (sc!=null?sc.getText():null), (e!=null?e.getText():null));}
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
	// $ANTLR end "external"



	// $ANTLR start "sequence"
	// WreslTreeWalker.g:86:1: sequence : ^( Sequence s= IDENT Model m= IDENT Order i= INTEGER c= Condition t= TIMESTEP ) ;
	public final void sequence() throws RecognitionException {
		CommonTree s=null;
		CommonTree m=null;
		CommonTree i=null;
		CommonTree c=null;
		CommonTree t=null;

		try {
			// WreslTreeWalker.g:87:2: ( ^( Sequence s= IDENT Model m= IDENT Order i= INTEGER c= Condition t= TIMESTEP ) )
			// WreslTreeWalker.g:87:5: ^( Sequence s= IDENT Model m= IDENT Order i= INTEGER c= Condition t= TIMESTEP )
			{
			match(input,Sequence,FOLLOW_Sequence_in_sequence413); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_sequence417); if (state.failed) return;
			match(input,Model,FOLLOW_Model_in_sequence419); if (state.failed) return;
			m=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_sequence423); if (state.failed) return;
			match(input,Order,FOLLOW_Order_in_sequence425); if (state.failed) return;
			i=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_sequence429); if (state.failed) return;
			c=(CommonTree)match(input,Condition,FOLLOW_Condition_in_sequence433); if (state.failed) return;
			t=(CommonTree)match(input,TIMESTEP,FOLLOW_TIMESTEP_in_sequence437); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {
						F.sequenceOrder((s!=null?s.getText():null), (i!=null?i.getText():null), (m!=null?m.getText():null), (c!=null?c.getText():null), (t!=null?t.getText():null));
						
						SimulationDataSet M = new SimulationDataSet();
						M.currentAbsolutePath=currentAbsolutePath;
						M.currentAbsoluteParent=currentAbsoluteParent;
						modelDataMap.put((m!=null?m.getText():null).toLowerCase(), M);
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
	// $ANTLR end "sequence"



	// $ANTLR start "model"
	// WreslTreeWalker.g:100:1: model : ^( Model i= IDENT ( pattern )+ ) ;
	public final void model() throws RecognitionException {
		CommonTree i=null;

		try {
			// WreslTreeWalker.g:102:2: ( ^( Model i= IDENT ( pattern )+ ) )
			// WreslTreeWalker.g:102:4: ^( Model i= IDENT ( pattern )+ )
			{
			match(input,Model,FOLLOW_Model_in_model461); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_model465); if (state.failed) return;
			if ( state.backtracking==0 ) {   
								F.S = thisFileDataSet; F.modelList((i!=null?i.getText():null).toLowerCase()); 
								
							    F.S = modelDataMap.get((i!=null?i.getText():null).toLowerCase());
							}
			// WreslTreeWalker.g:109:5: ( pattern )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==Alias||(LA7_0 >= DvarTimeArray_nonStd && LA7_0 <= Dvar_nonStd)||LA7_0==Dvar_std||LA7_0==External||(LA7_0 >= Goal_case && LA7_0 <= Goal_simple)||LA7_0==Include||(LA7_0 >= SvarTimeArray_case && LA7_0 <= Svar_table)||LA7_0==Weight_table) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// WreslTreeWalker.g:109:6: pattern
					{
					pushFollow(FOLLOW_pattern_in_model489);
					pattern();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			match(input, Token.UP, null); if (state.failed) return;

			}

			if ( state.backtracking==0 ) { F.S = thisFileDataSet; }
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "model"



	// $ANTLR start "includeFile"
	// WreslTreeWalker.g:112:1: includeFile : ^( Include sc= Scope f= FILE_PATH ) ;
	public final void includeFile() throws RecognitionException {
		CommonTree sc=null;
		CommonTree f=null;

		try {
			// WreslTreeWalker.g:113:2: ( ^( Include sc= Scope f= FILE_PATH ) )
			// WreslTreeWalker.g:113:5: ^( Include sc= Scope f= FILE_PATH )
			{
			match(input,Include,FOLLOW_Include_in_includeFile509); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_includeFile513); if (state.failed) return;
			f=(CommonTree)match(input,FILE_PATH,FOLLOW_FILE_PATH_in_includeFile517); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {F.includeFile(Tools.strip((f!=null?f.getText():null)), (sc!=null?sc.getText():null));}
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
	// $ANTLR end "includeFile"



	// $ANTLR start "weight_table"
	// WreslTreeWalker.g:116:1: weight_table : ^( Weight_table sc= Scope ( ^(i= IDENT ta= TimeArraySize e= Expression ) )+ ) ;
	public final void weight_table() throws RecognitionException {
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree ta=null;
		CommonTree e=null;

		try {
			// WreslTreeWalker.g:117:2: ( ^( Weight_table sc= Scope ( ^(i= IDENT ta= TimeArraySize e= Expression ) )+ ) )
			// WreslTreeWalker.g:117:5: ^( Weight_table sc= Scope ( ^(i= IDENT ta= TimeArraySize e= Expression ) )+ )
			{
			match(input,Weight_table,FOLLOW_Weight_table_in_weight_table534); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_weight_table538); if (state.failed) return;
			// WreslTreeWalker.g:117:29: ( ^(i= IDENT ta= TimeArraySize e= Expression ) )+
			int cnt8=0;
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==IDENT) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// WreslTreeWalker.g:117:31: ^(i= IDENT ta= TimeArraySize e= Expression )
					{
					i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_weight_table545); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					ta=(CommonTree)match(input,TimeArraySize,FOLLOW_TimeArraySize_in_weight_table549); if (state.failed) return;
					e=(CommonTree)match(input,Expression,FOLLOW_Expression_in_weight_table553); if (state.failed) return;
					if ( state.backtracking==0 ) { 	     
						     F.mergeWeightTable((i!=null?i.getText():null), (e!=null?e.getText():null), (sc!=null?sc.getText():null), (ta!=null?ta.getText():null));
						    }
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;

				default :
					if ( cnt8 >= 1 ) break loop8;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(8, input);
					throw eee;
				}
				cnt8++;
			}

			match(input, Token.UP, null); if (state.failed) return;

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
	// $ANTLR end "weight_table"


	protected static class goal_scope {
		String ta;
		String scop;
		Goal gl;
		String case_condition;
		int caseNumber;
		Map<String, String> dvarWeightMap;
		ArrayList<String> dvarSlackSurplus;
	}
	protected Stack<goal_scope> goal_stack = new Stack<goal_scope>();


	// $ANTLR start "goal"
	// WreslTreeWalker.g:129:1: goal : ( goal_simple | goal_nocase | goal_case );
	public final void goal() throws RecognitionException {
		goal_stack.push(new goal_scope());
		 goal_stack.peek().ta =null; goal_stack.peek().scop = null; goal_stack.peek().gl = new Goal(); goal_stack.peek().caseNumber =0; goal_stack.peek().case_condition ="always";
		try {
			// WreslTreeWalker.g:132:3: ( goal_simple | goal_nocase | goal_case )
			int alt9=3;
			switch ( input.LA(1) ) {
			case Goal_simple:
				{
				alt9=1;
				}
				break;
			case Goal_no_case:
				{
				alt9=2;
				}
				break;
			case Goal_case:
				{
				alt9=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}
			switch (alt9) {
				case 1 :
					// WreslTreeWalker.g:132:3: goal_simple
					{
					pushFollow(FOLLOW_goal_simple_in_goal599);
					goal_simple();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// WreslTreeWalker.g:132:17: goal_nocase
					{
					pushFollow(FOLLOW_goal_nocase_in_goal603);
					goal_nocase();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// WreslTreeWalker.g:132:31: goal_case
					{
					pushFollow(FOLLOW_goal_case_in_goal607);
					goal_case();
					state._fsp--;
					if (state.failed) return;
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
			goal_stack.pop();
		}
	}
	// $ANTLR end "goal"



	// $ANTLR start "dvar"
	// WreslTreeWalker.g:134:1: dvar : ( dvar_std | dvar_nonStd | dvar_timeArray_std | dvar_timeArray_nonStd );
	public final void dvar() throws RecognitionException {
		try {
			// WreslTreeWalker.g:134:6: ( dvar_std | dvar_nonStd | dvar_timeArray_std | dvar_timeArray_nonStd )
			int alt10=4;
			switch ( input.LA(1) ) {
			case Dvar_std:
				{
				alt10=1;
				}
				break;
			case Dvar_nonStd:
				{
				alt10=2;
				}
				break;
			case DvarTimeArray_std:
				{
				alt10=3;
				}
				break;
			case DvarTimeArray_nonStd:
				{
				alt10=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// WreslTreeWalker.g:134:8: dvar_std
					{
					pushFollow(FOLLOW_dvar_std_in_dvar616);
					dvar_std();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// WreslTreeWalker.g:134:19: dvar_nonStd
					{
					pushFollow(FOLLOW_dvar_nonStd_in_dvar620);
					dvar_nonStd();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// WreslTreeWalker.g:134:33: dvar_timeArray_std
					{
					pushFollow(FOLLOW_dvar_timeArray_std_in_dvar624);
					dvar_timeArray_std();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 4 :
					// WreslTreeWalker.g:134:54: dvar_timeArray_nonStd
					{
					pushFollow(FOLLOW_dvar_timeArray_nonStd_in_dvar628);
					dvar_timeArray_nonStd();
					state._fsp--;
					if (state.failed) return;
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
	// $ANTLR end "dvar"



	// $ANTLR start "svar"
	// WreslTreeWalker.g:136:1: svar : ( svar_dss | svar_expr | svar_sum | svar_table | svar_case );
	public final void svar() throws RecognitionException {
		try {
			// WreslTreeWalker.g:136:6: ( svar_dss | svar_expr | svar_sum | svar_table | svar_case )
			int alt11=5;
			switch ( input.LA(1) ) {
			case Svar_dss:
				{
				alt11=1;
				}
				break;
			case Svar_const:
				{
				alt11=2;
				}
				break;
			case Svar_sum:
				{
				alt11=3;
				}
				break;
			case Svar_table:
				{
				alt11=4;
				}
				break;
			case Svar_case:
				{
				alt11=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// WreslTreeWalker.g:136:8: svar_dss
					{
					pushFollow(FOLLOW_svar_dss_in_svar639);
					svar_dss();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// WreslTreeWalker.g:136:19: svar_expr
					{
					pushFollow(FOLLOW_svar_expr_in_svar643);
					svar_expr();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// WreslTreeWalker.g:136:31: svar_sum
					{
					pushFollow(FOLLOW_svar_sum_in_svar647);
					svar_sum();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 4 :
					// WreslTreeWalker.g:136:42: svar_table
					{
					pushFollow(FOLLOW_svar_table_in_svar651);
					svar_table();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 5 :
					// WreslTreeWalker.g:136:55: svar_case
					{
					pushFollow(FOLLOW_svar_case_in_svar655);
					svar_case();
					state._fsp--;
					if (state.failed) return;
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
	// $ANTLR end "svar"



	// $ANTLR start "svar_timeArray"
	// WreslTreeWalker.g:138:1: svar_timeArray : ( svar_timeArray_expr | svar_timeArray_case | svar_timeArray_table | svar_timeArray_sum );
	public final void svar_timeArray() throws RecognitionException {
		try {
			// WreslTreeWalker.g:138:16: ( svar_timeArray_expr | svar_timeArray_case | svar_timeArray_table | svar_timeArray_sum )
			int alt12=4;
			switch ( input.LA(1) ) {
			case SvarTimeArray_const:
				{
				alt12=1;
				}
				break;
			case SvarTimeArray_case:
				{
				alt12=2;
				}
				break;
			case Svar_table:
				{
				alt12=3;
				}
				break;
			case Svar_sum:
				{
				alt12=4;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}
			switch (alt12) {
				case 1 :
					// WreslTreeWalker.g:138:18: svar_timeArray_expr
					{
					pushFollow(FOLLOW_svar_timeArray_expr_in_svar_timeArray663);
					svar_timeArray_expr();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// WreslTreeWalker.g:138:40: svar_timeArray_case
					{
					pushFollow(FOLLOW_svar_timeArray_case_in_svar_timeArray667);
					svar_timeArray_case();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 3 :
					// WreslTreeWalker.g:138:61: svar_timeArray_table
					{
					pushFollow(FOLLOW_svar_timeArray_table_in_svar_timeArray670);
					svar_timeArray_table();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 4 :
					// WreslTreeWalker.g:138:84: svar_timeArray_sum
					{
					pushFollow(FOLLOW_svar_timeArray_sum_in_svar_timeArray674);
					svar_timeArray_sum();
					state._fsp--;
					if (state.failed) return;
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
	// $ANTLR end "svar_timeArray"



	// $ANTLR start "svar_timeArray_case"
	// WreslTreeWalker.g:140:1: svar_timeArray_case : ^( SvarTimeArray_case ta= TimeArraySize tad= Dependants sc= Scope i= IDENT (c= case_content )+ ) ;
	public final void svar_timeArray_case() throws RecognitionException {
		CommonTree ta=null;
		CommonTree tad=null;
		CommonTree sc=null;
		CommonTree i=null;
		TreeRuleReturnScope c =null;

		 Svar sv = new Svar(); String dependants=null; String varInCycle=null;
		try {
			// WreslTreeWalker.g:142:2: ( ^( SvarTimeArray_case ta= TimeArraySize tad= Dependants sc= Scope i= IDENT (c= case_content )+ ) )
			// WreslTreeWalker.g:142:4: ^( SvarTimeArray_case ta= TimeArraySize tad= Dependants sc= Scope i= IDENT (c= case_content )+ )
			{
			match(input,SvarTimeArray_case,FOLLOW_SvarTimeArray_case_in_svar_timeArray_case691); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			ta=(CommonTree)match(input,TimeArraySize,FOLLOW_TimeArraySize_in_svar_timeArray_case695); if (state.failed) return;
			tad=(CommonTree)match(input,Dependants,FOLLOW_Dependants_in_svar_timeArray_case699); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_svar_timeArray_case703); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_svar_timeArray_case707); if (state.failed) return;
			// WreslTreeWalker.g:142:75: (c= case_content )+
			int cnt13=0;
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==Case) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// WreslTreeWalker.g:142:77: c= case_content
					{
					pushFollow(FOLLOW_case_content_in_svar_timeArray_case714);
					c=case_content();
					state._fsp--;
					if (state.failed) return;
					if ( state.backtracking==0 ) {	
									sv.caseName.add((c!=null?((WreslTreeWalker.case_content_return)c).name:null).toLowerCase());
									sv.caseCondition.add( Tools.add_space_between_logical( (c!=null?((WreslTreeWalker.case_content_return)c).condition:null).toLowerCase() ) );
									sv.caseExpression.add((c!=null?((WreslTreeWalker.case_content_return)c).expression:null).toLowerCase());
									dependants = dependants + " " + (c!=null?((WreslTreeWalker.case_content_return)c).dependants:null);
									varInCycle = varInCycle + " " + (c!=null?((WreslTreeWalker.case_content_return)c).varInCycle:null);
								}
					}
					break;

				default :
					if ( cnt13 >= 1 ) break loop13;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(13, input);
					throw eee;
				}
				cnt13++;
			}

			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {
						 	F.svarCase((i!=null?i.getText():null), (sc!=null?sc.getText():null), sv, dependants+" "+(tad!=null?tad.getText():null), varInCycle, (ta!=null?ta.getText():null)); }
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
	// $ANTLR end "svar_timeArray_case"



	// $ANTLR start "svar_case"
	// WreslTreeWalker.g:157:1: svar_case : ^( Svar_case sc= Scope i= IDENT (c= case_content )+ ) ;
	public final void svar_case() throws RecognitionException {
		CommonTree sc=null;
		CommonTree i=null;
		TreeRuleReturnScope c =null;

		 Svar sv = new Svar(); String dependants=null; String varInCycle=null;
		try {
			// WreslTreeWalker.g:159:2: ( ^( Svar_case sc= Scope i= IDENT (c= case_content )+ ) )
			// WreslTreeWalker.g:159:4: ^( Svar_case sc= Scope i= IDENT (c= case_content )+ )
			{
			match(input,Svar_case,FOLLOW_Svar_case_in_svar_case755); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_svar_case759); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_svar_case763); if (state.failed) return;
			// WreslTreeWalker.g:159:34: (c= case_content )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==Case) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// WreslTreeWalker.g:159:36: c= case_content
					{
					pushFollow(FOLLOW_case_content_in_svar_case770);
					c=case_content();
					state._fsp--;
					if (state.failed) return;
					if ( state.backtracking==0 ) {	
									sv.caseName.add((c!=null?((WreslTreeWalker.case_content_return)c).name:null).toLowerCase());
									sv.caseCondition.add( Tools.add_space_between_logical( (c!=null?((WreslTreeWalker.case_content_return)c).condition:null).toLowerCase() ) );
									sv.caseExpression.add((c!=null?((WreslTreeWalker.case_content_return)c).expression:null).toLowerCase());
									dependants = dependants + " " + (c!=null?((WreslTreeWalker.case_content_return)c).dependants:null);
									varInCycle = varInCycle + " " + (c!=null?((WreslTreeWalker.case_content_return)c).varInCycle:null);
								}
					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {
						 	F.svarCase((i!=null?i.getText():null), (sc!=null?sc.getText():null), sv, dependants, varInCycle); }
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
	// $ANTLR end "svar_case"


	public static class case_content_return extends TreeRuleReturnScope {
		public String name;
		public String condition;
		public String expression;
		public String dependants;
		public String varInCycle;
	};


	// $ANTLR start "case_content"
	// WreslTreeWalker.g:175:1: case_content returns [String name, String condition, String expression, String dependants, String varInCycle] : ^( Case i= IDENT c= Condition d= Dependants cvc= VarInCycle (t= table_content |v= Value vd= Dependants vvc= VarInCycle |sum= sum_content ) ) ;
	public final WreslTreeWalker.case_content_return case_content() throws RecognitionException {
		WreslTreeWalker.case_content_return retval = new WreslTreeWalker.case_content_return();
		retval.start = input.LT(1);

		CommonTree i=null;
		CommonTree c=null;
		CommonTree d=null;
		CommonTree cvc=null;
		CommonTree v=null;
		CommonTree vd=null;
		CommonTree vvc=null;
		TreeRuleReturnScope t =null;
		TreeRuleReturnScope sum =null;

		 String expr = null;
		try {
			// WreslTreeWalker.g:176:29: ( ^( Case i= IDENT c= Condition d= Dependants cvc= VarInCycle (t= table_content |v= Value vd= Dependants vvc= VarInCycle |sum= sum_content ) ) )
			// WreslTreeWalker.g:177:3: ^( Case i= IDENT c= Condition d= Dependants cvc= VarInCycle (t= table_content |v= Value vd= Dependants vvc= VarInCycle |sum= sum_content ) )
			{
			match(input,Case,FOLLOW_Case_in_case_content811); if (state.failed) return retval;
			match(input, Token.DOWN, null); if (state.failed) return retval;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_case_content815); if (state.failed) return retval;
			c=(CommonTree)match(input,Condition,FOLLOW_Condition_in_case_content819); if (state.failed) return retval;
			d=(CommonTree)match(input,Dependants,FOLLOW_Dependants_in_case_content823); if (state.failed) return retval;
			cvc=(CommonTree)match(input,VarInCycle,FOLLOW_VarInCycle_in_case_content827); if (state.failed) return retval;
			// WreslTreeWalker.g:179:2: (t= table_content |v= Value vd= Dependants vvc= VarInCycle |sum= sum_content )
			int alt15=3;
			switch ( input.LA(1) ) {
			case SELECT:
				{
				alt15=1;
				}
				break;
			case Value:
				{
				alt15=2;
				}
				break;
			case Sum_hdr:
				{
				alt15=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// WreslTreeWalker.g:179:4: t= table_content
					{
					pushFollow(FOLLOW_table_content_in_case_content836);
					t=table_content();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {expr =(t!=null?((WreslTreeWalker.table_content_return)t).text:null);}
					}
					break;
				case 2 :
					// WreslTreeWalker.g:180:4: v= Value vd= Dependants vvc= VarInCycle
					{
					v=(CommonTree)match(input,Value,FOLLOW_Value_in_case_content847); if (state.failed) return retval;
					vd=(CommonTree)match(input,Dependants,FOLLOW_Dependants_in_case_content852); if (state.failed) return retval;
					vvc=(CommonTree)match(input,VarInCycle,FOLLOW_VarInCycle_in_case_content856); if (state.failed) return retval;
					if ( state.backtracking==0 ) {expr =(v!=null?v.getText():null); }
					}
					break;
				case 3 :
					// WreslTreeWalker.g:181:4: sum= sum_content
					{
					pushFollow(FOLLOW_sum_content_in_case_content865);
					sum=sum_content();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) {expr =(sum!=null?((WreslTreeWalker.sum_content_return)sum).hdr:null)+" "+(sum!=null?((WreslTreeWalker.sum_content_return)sum).expr:null); }
					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;

			if ( state.backtracking==0 ) { retval.name = (i!=null?i.getText():null); retval.condition =(c!=null?c.getText():null); retval.expression = expr; 
			  retval.dependants = (d!=null?d.getText():null) + " " + (t!=null?((WreslTreeWalker.table_content_return)t).dependants:null) + " " + (vd!=null?vd.getText():null) + " " + (sum!=null?((WreslTreeWalker.sum_content_return)sum).dependants:null); 
			  retval.varInCycle = (cvc!=null?cvc.getText():null) + " "+ (t!=null?((WreslTreeWalker.table_content_return)t).varInCycle:null) + " " + (sum!=null?((WreslTreeWalker.sum_content_return)sum).varInCycle:null) + " " + (vvc!=null?vvc.getText():null);

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
	// $ANTLR end "case_content"


	public static class table_content_return extends TreeRuleReturnScope {
		public String text;
		public String dependants;
		public String varInCycle;
	};


	// $ANTLR start "table_content"
	// WreslTreeWalker.g:200:1: table_content returns [String text, String dependants, String varInCycle] : ^( SELECT s= IDENT FROM f= IDENT ( GIVEN g= Assignment d= Dependants vc= VarInCycle USE u= IDENT )? ( WHERE w= where_items wd= Dependants )? ) ;
	public final WreslTreeWalker.table_content_return table_content() throws RecognitionException {
		WreslTreeWalker.table_content_return retval = new WreslTreeWalker.table_content_return();
		retval.start = input.LT(1);

		CommonTree s=null;
		CommonTree f=null;
		CommonTree g=null;
		CommonTree d=null;
		CommonTree vc=null;
		CommonTree u=null;
		CommonTree wd=null;
		String w =null;

		try {
			// WreslTreeWalker.g:201:2: ( ^( SELECT s= IDENT FROM f= IDENT ( GIVEN g= Assignment d= Dependants vc= VarInCycle USE u= IDENT )? ( WHERE w= where_items wd= Dependants )? ) )
			// WreslTreeWalker.g:202:2: ^( SELECT s= IDENT FROM f= IDENT ( GIVEN g= Assignment d= Dependants vc= VarInCycle USE u= IDENT )? ( WHERE w= where_items wd= Dependants )? )
			{
			match(input,SELECT,FOLLOW_SELECT_in_table_content904); if (state.failed) return retval;
			match(input, Token.DOWN, null); if (state.failed) return retval;
			s=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_table_content908); if (state.failed) return retval;
			match(input,FROM,FOLLOW_FROM_in_table_content910); if (state.failed) return retval;
			f=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_table_content914); if (state.failed) return retval;
			if ( state.backtracking==0 ) {retval.text = "select "+(s!=null?s.getText():null)+" from "+(f!=null?f.getText():null); }
			// WreslTreeWalker.g:203:3: ( GIVEN g= Assignment d= Dependants vc= VarInCycle USE u= IDENT )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==GIVEN) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// WreslTreeWalker.g:203:4: GIVEN g= Assignment d= Dependants vc= VarInCycle USE u= IDENT
					{
					match(input,GIVEN,FOLLOW_GIVEN_in_table_content923); if (state.failed) return retval;
					g=(CommonTree)match(input,Assignment,FOLLOW_Assignment_in_table_content927); if (state.failed) return retval;
					d=(CommonTree)match(input,Dependants,FOLLOW_Dependants_in_table_content931); if (state.failed) return retval;
					vc=(CommonTree)match(input,VarInCycle,FOLLOW_VarInCycle_in_table_content935); if (state.failed) return retval;
					match(input,USE,FOLLOW_USE_in_table_content937); if (state.failed) return retval;
					u=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_table_content941); if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.text = retval.text+" given "+(g!=null?g.getText():null)+" use "+(u!=null?u.getText():null);}
					}
					break;

			}

			// WreslTreeWalker.g:204:3: ( WHERE w= where_items wd= Dependants )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==WHERE) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// WreslTreeWalker.g:204:4: WHERE w= where_items wd= Dependants
					{
					match(input,WHERE,FOLLOW_WHERE_in_table_content952); if (state.failed) return retval;
					pushFollow(FOLLOW_where_items_in_table_content956);
					w=where_items();
					state._fsp--;
					if (state.failed) return retval;
					wd=(CommonTree)match(input,Dependants,FOLLOW_Dependants_in_table_content960); if (state.failed) return retval;
					if ( state.backtracking==0 ) {retval.text = retval.text+" where "+ Tools.replace_ignoreChar(Tools.replace_seperator(w)); }
					}
					break;

			}

			match(input, Token.UP, null); if (state.failed) return retval;

			if ( state.backtracking==0 ) {retval.dependants = (d!=null?d.getText():null) +" " + (wd!=null?wd.getText():null);  retval.varInCycle = (vc!=null?vc.getText():null);    }
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
	// $ANTLR end "table_content"



	// $ANTLR start "where_items"
	// WreslTreeWalker.g:209:1: where_items returns [String text] : a= Assignment ( ',' b= Assignment )* ;
	public final String where_items() throws RecognitionException {
		String text = null;


		CommonTree a=null;
		CommonTree b=null;

		try {
			// WreslTreeWalker.g:210:2: (a= Assignment ( ',' b= Assignment )* )
			// WreslTreeWalker.g:210:4: a= Assignment ( ',' b= Assignment )*
			{
			a=(CommonTree)match(input,Assignment,FOLLOW_Assignment_in_where_items1000); if (state.failed) return text;
			if ( state.backtracking==0 ) {text = (a!=null?a.getText():null);}
			// WreslTreeWalker.g:210:36: ( ',' b= Assignment )*
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==143) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// WreslTreeWalker.g:210:37: ',' b= Assignment
					{
					match(input,143,FOLLOW_143_in_where_items1005); if (state.failed) return text;
					b=(CommonTree)match(input,Assignment,FOLLOW_Assignment_in_where_items1009); if (state.failed) return text;
					if ( state.backtracking==0 ) {text = text+","+(b!=null?b.getText():null);}
					}
					break;

				default :
					break loop18;
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
		return text;
	}
	// $ANTLR end "where_items"



	// $ANTLR start "alias"
	// WreslTreeWalker.g:214:1: alias : ( alias_simple | alias_timeArray_simple ) ;
	public final void alias() throws RecognitionException {
		try {
			// WreslTreeWalker.g:214:8: ( ( alias_simple | alias_timeArray_simple ) )
			// WreslTreeWalker.g:214:10: ( alias_simple | alias_timeArray_simple )
			{
			// WreslTreeWalker.g:214:10: ( alias_simple | alias_timeArray_simple )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==Alias) ) {
				int LA19_1 = input.LA(2);
				if ( (LA19_1==DOWN) ) {
					int LA19_2 = input.LA(3);
					if ( (LA19_2==Scope) ) {
						alt19=1;
					}
					else if ( (LA19_2==TimeArraySize) ) {
						alt19=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 19, 2, input);
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
							new NoViableAltException("", 19, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// WreslTreeWalker.g:214:11: alias_simple
					{
					pushFollow(FOLLOW_alias_simple_in_alias1026);
					alias_simple();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// WreslTreeWalker.g:214:24: alias_timeArray_simple
					{
					pushFollow(FOLLOW_alias_timeArray_simple_in_alias1028);
					alias_timeArray_simple();
					state._fsp--;
					if (state.failed) return;
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
	}
	// $ANTLR end "alias"



	// $ANTLR start "alias_simple"
	// WreslTreeWalker.g:216:1: alias_simple : ^( Alias sc= Scope i= IDENT e= Expression k= Kind u= Units d= Dependants vc= VarInCycle ) ;
	public final void alias_simple() throws RecognitionException {
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree e=null;
		CommonTree k=null;
		CommonTree u=null;
		CommonTree d=null;
		CommonTree vc=null;

		try {
			// WreslTreeWalker.g:216:13: ( ^( Alias sc= Scope i= IDENT e= Expression k= Kind u= Units d= Dependants vc= VarInCycle ) )
			// WreslTreeWalker.g:216:15: ^( Alias sc= Scope i= IDENT e= Expression k= Kind u= Units d= Dependants vc= VarInCycle )
			{
			match(input,Alias,FOLLOW_Alias_in_alias_simple1037); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_alias_simple1041); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_alias_simple1045); if (state.failed) return;
			e=(CommonTree)match(input,Expression,FOLLOW_Expression_in_alias_simple1049); if (state.failed) return;
			k=(CommonTree)match(input,Kind,FOLLOW_Kind_in_alias_simple1053); if (state.failed) return;
			u=(CommonTree)match(input,Units,FOLLOW_Units_in_alias_simple1057); if (state.failed) return;
			d=(CommonTree)match(input,Dependants,FOLLOW_Dependants_in_alias_simple1061); if (state.failed) return;
			vc=(CommonTree)match(input,VarInCycle,FOLLOW_VarInCycle_in_alias_simple1065); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) { F.alias((i!=null?i.getText():null), (sc!=null?sc.getText():null), Tools.strip((k!=null?k.getText():null)), Tools.strip((u!=null?u.getText():null)), (e!=null?e.getText():null), (d!=null?d.getText():null), (vc!=null?vc.getText():null)  ); }
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
	// $ANTLR end "alias_simple"



	// $ANTLR start "alias_timeArray_simple"
	// WreslTreeWalker.g:220:1: alias_timeArray_simple : ^( Alias ta= TimeArraySize sc= Scope i= IDENT e= Expression k= Kind u= Units d= Dependants vc= VarInCycle ) ;
	public final void alias_timeArray_simple() throws RecognitionException {
		CommonTree ta=null;
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree e=null;
		CommonTree k=null;
		CommonTree u=null;
		CommonTree d=null;
		CommonTree vc=null;

		try {
			// WreslTreeWalker.g:220:23: ( ^( Alias ta= TimeArraySize sc= Scope i= IDENT e= Expression k= Kind u= Units d= Dependants vc= VarInCycle ) )
			// WreslTreeWalker.g:220:25: ^( Alias ta= TimeArraySize sc= Scope i= IDENT e= Expression k= Kind u= Units d= Dependants vc= VarInCycle )
			{
			match(input,Alias,FOLLOW_Alias_in_alias_timeArray_simple1085); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			ta=(CommonTree)match(input,TimeArraySize,FOLLOW_TimeArraySize_in_alias_timeArray_simple1089); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_alias_timeArray_simple1093); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_alias_timeArray_simple1097); if (state.failed) return;
			e=(CommonTree)match(input,Expression,FOLLOW_Expression_in_alias_timeArray_simple1101); if (state.failed) return;
			k=(CommonTree)match(input,Kind,FOLLOW_Kind_in_alias_timeArray_simple1105); if (state.failed) return;
			u=(CommonTree)match(input,Units,FOLLOW_Units_in_alias_timeArray_simple1109); if (state.failed) return;
			d=(CommonTree)match(input,Dependants,FOLLOW_Dependants_in_alias_timeArray_simple1113); if (state.failed) return;
			vc=(CommonTree)match(input,VarInCycle,FOLLOW_VarInCycle_in_alias_timeArray_simple1117); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) { F.alias((i!=null?i.getText():null), (sc!=null?sc.getText():null), Tools.strip((k!=null?k.getText():null)), Tools.strip((u!=null?u.getText():null)), (e!=null?e.getText():null), (d!=null?d.getText():null), (vc!=null?vc.getText():null), (ta!=null?ta.getText():null)); }
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
	// $ANTLR end "alias_timeArray_simple"



	// $ANTLR start "goal_simple"
	// WreslTreeWalker.g:224:1: goal_simple : ^( Goal_simple (ta= TimeArraySize )? sc= Scope i= IDENT d= Dependants v= Constraint_content vc= VarInCycle ) ;
	public final void goal_simple() throws RecognitionException {
		CommonTree ta=null;
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree d=null;
		CommonTree v=null;
		CommonTree vc=null;

		try {
			// WreslTreeWalker.g:225:3: ( ^( Goal_simple (ta= TimeArraySize )? sc= Scope i= IDENT d= Dependants v= Constraint_content vc= VarInCycle ) )
			// WreslTreeWalker.g:225:6: ^( Goal_simple (ta= TimeArraySize )? sc= Scope i= IDENT d= Dependants v= Constraint_content vc= VarInCycle )
			{
			match(input,Goal_simple,FOLLOW_Goal_simple_in_goal_simple1144); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// WreslTreeWalker.g:225:20: (ta= TimeArraySize )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==TimeArraySize) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// WreslTreeWalker.g:225:21: ta= TimeArraySize
					{
					ta=(CommonTree)match(input,TimeArraySize,FOLLOW_TimeArraySize_in_goal_simple1149); if (state.failed) return;
					if ( state.backtracking==0 ) {goal_stack.peek().ta =(ta!=null?ta.getText():null);}
					}
					break;

			}

			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_goal_simple1156); if (state.failed) return;
			if ( state.backtracking==0 ) {goal_stack.peek().scop = (sc!=null?sc.getText():null);}
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_goal_simple1162); if (state.failed) return;
			d=(CommonTree)match(input,Dependants,FOLLOW_Dependants_in_goal_simple1166); if (state.failed) return;
			v=(CommonTree)match(input,Constraint_content,FOLLOW_Constraint_content_in_goal_simple1170); if (state.failed) return;
			vc=(CommonTree)match(input,VarInCycle,FOLLOW_VarInCycle_in_goal_simple1174); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) { 
			      if (ta==null){
			        F.goalSimple((i!=null?i.getText():null), (sc!=null?sc.getText():null), (v!=null?v.getText():null), (d!=null?d.getText():null), (vc!=null?vc.getText():null));
			      }else{
			        F.goalSimple((i!=null?i.getText():null), (sc!=null?sc.getText():null), (v!=null?v.getText():null), (d!=null?d.getText():null), (vc!=null?vc.getText():null), (ta!=null?ta.getText():null));
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
	// $ANTLR end "goal_simple"



	// $ANTLR start "goal_nocase"
	// WreslTreeWalker.g:235:1: goal_nocase : ^( Goal_no_case (ta= TimeArraySize )? sc= Scope i= IDENT d= Dependants vc= VarInCycle c= goal_contents ) ;
	public final void goal_nocase() throws RecognitionException {
		CommonTree ta=null;
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree d=null;
		CommonTree vc=null;
		String c =null;

		 goal_stack.peek().gl = new Goal(); goal_stack.peek().caseNumber =0; goal_stack.peek().case_condition ="always";
		try {
			// WreslTreeWalker.g:237:3: ( ^( Goal_no_case (ta= TimeArraySize )? sc= Scope i= IDENT d= Dependants vc= VarInCycle c= goal_contents ) )
			// WreslTreeWalker.g:237:6: ^( Goal_no_case (ta= TimeArraySize )? sc= Scope i= IDENT d= Dependants vc= VarInCycle c= goal_contents )
			{
			match(input,Goal_no_case,FOLLOW_Goal_no_case_in_goal_nocase1207); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// WreslTreeWalker.g:237:22: (ta= TimeArraySize )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==TimeArraySize) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// WreslTreeWalker.g:237:23: ta= TimeArraySize
					{
					ta=(CommonTree)match(input,TimeArraySize,FOLLOW_TimeArraySize_in_goal_nocase1212); if (state.failed) return;
					if ( state.backtracking==0 ) {goal_stack.peek().ta =(ta!=null?ta.getText():null);}
					}
					break;

			}

			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_goal_nocase1219); if (state.failed) return;
			if ( state.backtracking==0 ) {goal_stack.peek().scop = (sc!=null?sc.getText():null);}
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_goal_nocase1225); if (state.failed) return;
			d=(CommonTree)match(input,Dependants,FOLLOW_Dependants_in_goal_nocase1230); if (state.failed) return;
			vc=(CommonTree)match(input,VarInCycle,FOLLOW_VarInCycle_in_goal_nocase1234); if (state.failed) return;
			if ( state.backtracking==0 ) {   
			        if (ta==null){
			          goal_stack.peek().gl = F.goalSimple((i!=null?i.getText():null), (sc!=null?sc.getText():null), "", (d!=null?d.getText():null), (vc!=null?vc.getText():null));
			        }else{
			          goal_stack.peek().gl = F.goalSimple((i!=null?i.getText():null), (sc!=null?sc.getText():null), "", (d!=null?d.getText():null), (vc!=null?vc.getText():null), (ta!=null?ta.getText():null));
			        }
			        goal_stack.peek().gl.dvarWeightMapList.add(null);
			        goal_stack.peek().gl.dvarSlackSurplusList.add(null);
			        goal_stack.peek().dvarWeightMap = new HashMap<String, String>(); 
			        goal_stack.peek().dvarSlackSurplus = new ArrayList<String>();         
			        //goal_stack.peek().gl.dvarName.add(""); goal_stack.peek().gl.dvarWeight.add("");
			      }
			pushFollow(FOLLOW_goal_contents_in_goal_nocase1253);
			c=goal_contents();
			state._fsp--;
			if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) { 
			       goal_stack.peek().gl.caseExpression.set(0, c.toLowerCase());             
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
	// $ANTLR end "goal_nocase"



	// $ANTLR start "goal_case"
	// WreslTreeWalker.g:257:1: goal_case : ^( Goal_case (ta= TimeArraySize )? sc= Scope i= IDENT ( ^( Case n= IDENT c= Condition d= Dependants vc= VarInCycle e= goal_contents ) )+ ) ;
	public final void goal_case() throws RecognitionException {
		CommonTree ta=null;
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree n=null;
		CommonTree c=null;
		CommonTree d=null;
		CommonTree vc=null;
		String e =null;

		 goal_stack.peek().gl = new Goal(); goal_stack.peek().caseNumber =0; goal_stack.peek().case_condition =Param.conditional; 
		try {
			// WreslTreeWalker.g:259:2: ( ^( Goal_case (ta= TimeArraySize )? sc= Scope i= IDENT ( ^( Case n= IDENT c= Condition d= Dependants vc= VarInCycle e= goal_contents ) )+ ) )
			// WreslTreeWalker.g:259:5: ^( Goal_case (ta= TimeArraySize )? sc= Scope i= IDENT ( ^( Case n= IDENT c= Condition d= Dependants vc= VarInCycle e= goal_contents ) )+ )
			{
			match(input,Goal_case,FOLLOW_Goal_case_in_goal_case1294); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			// WreslTreeWalker.g:259:18: (ta= TimeArraySize )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==TimeArraySize) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// WreslTreeWalker.g:259:19: ta= TimeArraySize
					{
					ta=(CommonTree)match(input,TimeArraySize,FOLLOW_TimeArraySize_in_goal_case1299); if (state.failed) return;
					if ( state.backtracking==0 ) {goal_stack.peek().ta =(ta!=null?ta.getText():null);}
					}
					break;

			}

			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_goal_case1306); if (state.failed) return;
			if ( state.backtracking==0 ) {goal_stack.peek().scop = (sc!=null?sc.getText():null);}
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_goal_case1312); if (state.failed) return;
			// WreslTreeWalker.g:260:3: ( ^( Case n= IDENT c= Condition d= Dependants vc= VarInCycle e= goal_contents ) )+
			int cnt23=0;
			loop23:
			while (true) {
				int alt23=2;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==Case) ) {
					alt23=1;
				}

				switch (alt23) {
				case 1 :
					// WreslTreeWalker.g:261:4: ^( Case n= IDENT c= Condition d= Dependants vc= VarInCycle e= goal_contents )
					{
					if ( state.backtracking==0 ) { 	goal_stack.peek().gl.dvarWeightMapList.add(null);	
									goal_stack.peek().gl.dvarSlackSurplusList.add(null);	
									goal_stack.peek().dvarWeightMap = new HashMap<String, String>();
									goal_stack.peek().dvarSlackSurplus = new ArrayList<String>();	
									//goal_stack.peek().gl.dvarName.add(""); goal_stack.peek().gl.dvarWeight.add(""); 
								}
					match(input,Case,FOLLOW_Case_in_goal_case1335); if (state.failed) return;
					match(input, Token.DOWN, null); if (state.failed) return;
					n=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_goal_case1339); if (state.failed) return;
					c=(CommonTree)match(input,Condition,FOLLOW_Condition_in_goal_case1343); if (state.failed) return;
					d=(CommonTree)match(input,Dependants,FOLLOW_Dependants_in_goal_case1347); if (state.failed) return;
					vc=(CommonTree)match(input,VarInCycle,FOLLOW_VarInCycle_in_goal_case1351); if (state.failed) return;
					pushFollow(FOLLOW_goal_contents_in_goal_case1355);
					e=goal_contents();
					state._fsp--;
					if (state.failed) return;
					if ( state.backtracking==0 ) {	goal_stack.peek().caseNumber++;
									goal_stack.peek().dvarWeightMap = new HashMap<String, String>();	
									goal_stack.peek().dvarSlackSurplus = new ArrayList<String>();	
									goal_stack.peek().gl.caseName.add((n!=null?n.getText():null).toLowerCase());
									goal_stack.peek().gl.caseCondition.add( Tools.add_space_between_logical( (c!=null?c.getText():null).toLowerCase() ) );
									goal_stack.peek().gl.caseExpression.add(e.toLowerCase());
									if (d != null) {
										String dependants = (d!=null?d.getText():null).toLowerCase();
										goal_stack.peek().gl.expressionDependants.addAll(Tools.convertStrToSet(dependants));
										goal_stack.peek().gl.expressionDependants.removeAll(Param.reservedSet);
									}
									if (vc != null) {
										String varInCycle = (vc!=null?vc.getText():null).toLowerCase();
										goal_stack.peek().gl.neededVarInCycleSet.addAll(Tools.convertStrToSet(varInCycle));
										goal_stack.peek().gl.needVarFromEarlierCycle = true;
									}
								}
					match(input, Token.UP, null); if (state.failed) return;

					}
					break;

				default :
					if ( cnt23 >= 1 ) break loop23;
					if (state.backtracking>0) {state.failed=true; return;}
					EarlyExitException eee = new EarlyExitException(23, input);
					throw eee;
				}
				cnt23++;
			}

			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) { 
						 if (ta==null){
						   F.goalCase((i!=null?i.getText():null), (sc!=null?sc.getText():null), goal_stack.peek().gl);
						 }else{
						   F.goalCase((i!=null?i.getText():null), (sc!=null?sc.getText():null), goal_stack.peek().gl, (ta!=null?ta.getText():null));  
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
	// $ANTLR end "goal_case"



	// $ANTLR start "goal_contents"
	// WreslTreeWalker.g:297:1: goal_contents returns [String str] : (g= goal_contents_process_2 |g= goal_contents_process_1 |g= goal_content_simple ) ;
	public final String goal_contents() throws RecognitionException {
		String str = null;


		String g =null;

		try {
			// WreslTreeWalker.g:298:3: ( (g= goal_contents_process_2 |g= goal_contents_process_1 |g= goal_content_simple ) )
			// WreslTreeWalker.g:298:5: (g= goal_contents_process_2 |g= goal_contents_process_1 |g= goal_content_simple )
			{
			// WreslTreeWalker.g:298:5: (g= goal_contents_process_2 |g= goal_contents_process_1 |g= goal_content_simple )
			int alt24=3;
			switch ( input.LA(1) ) {
			case Two:
				{
				alt24=1;
				}
				break;
			case One:
				{
				alt24=2;
				}
				break;
			case Simple:
				{
				alt24=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return str;}
				NoViableAltException nvae =
					new NoViableAltException("", 24, 0, input);
				throw nvae;
			}
			switch (alt24) {
				case 1 :
					// WreslTreeWalker.g:298:7: g= goal_contents_process_2
					{
					pushFollow(FOLLOW_goal_contents_process_2_in_goal_contents1401);
					g=goal_contents_process_2();
					state._fsp--;
					if (state.failed) return str;
					}
					break;
				case 2 :
					// WreslTreeWalker.g:298:34: g= goal_contents_process_1
					{
					pushFollow(FOLLOW_goal_contents_process_1_in_goal_contents1406);
					g=goal_contents_process_1();
					state._fsp--;
					if (state.failed) return str;
					}
					break;
				case 3 :
					// WreslTreeWalker.g:298:62: g= goal_content_simple
					{
					pushFollow(FOLLOW_goal_content_simple_in_goal_contents1412);
					g=goal_content_simple();
					state._fsp--;
					if (state.failed) return str;
					}
					break;

			}

			if ( state.backtracking==0 ) {str = g;}
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return str;
	}
	// $ANTLR end "goal_contents"



	// $ANTLR start "goal_contents_process_1"
	// WreslTreeWalker.g:303:1: goal_contents_process_1 returns [String str] : t= One c1= goal_content ;
	public final String goal_contents_process_1() throws RecognitionException {
		String str = null;


		CommonTree t=null;
		TreeRuleReturnScope c1 =null;

		try {
			// WreslTreeWalker.g:303:45: (t= One c1= goal_content )
			// WreslTreeWalker.g:303:47: t= One c1= goal_content
			{
			t=(CommonTree)match(input,One,FOLLOW_One_in_goal_contents_process_11439); if (state.failed) return str;
			pushFollow(FOLLOW_goal_content_in_goal_contents_process_11443);
			c1=goal_content();
			state._fsp--;
			if (state.failed) return str;
			if ( state.backtracking==0 ) { 
							// c -> =
							// f -> f
							// p -> =
					  
					  		if ( (t!=null?t.getText():null).equals("c") ) { 
					  		
					   			str = (c1!=null?((WreslTreeWalker.goal_content_return)c1).lhs:null) + "=" + (c1!=null?((WreslTreeWalker.goal_content_return)c1).rhs:null) ; 
					  		
					  		} else if ( (t!=null?t.getText():null).equals("f") ) { 
					  		
					   			str = (c1!=null?((WreslTreeWalker.goal_content_return)c1).str:null) ;  
					   			
					   		} else {  
					   		
					   			str = (c1!=null?((WreslTreeWalker.goal_content_return)c1).lhs:null) + (c1!=null?((WreslTreeWalker.goal_content_return)c1).ss:null) + "=" + (c1!=null?((WreslTreeWalker.goal_content_return)c1).rhs:null) ;  
					   		
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
		return str;
	}
	// $ANTLR end "goal_contents_process_1"



	// $ANTLR start "goal_contents_process_2"
	// WreslTreeWalker.g:326:1: goal_contents_process_2 returns [String str] : t= Two c1= goal_content c2= goal_content ;
	public final String goal_contents_process_2() throws RecognitionException {
		String str = null;


		CommonTree t=null;
		TreeRuleReturnScope c1 =null;
		TreeRuleReturnScope c2 =null;

		try {
			// WreslTreeWalker.g:326:45: (t= Two c1= goal_content c2= goal_content )
			// WreslTreeWalker.g:326:47: t= Two c1= goal_content c2= goal_content
			{
			t=(CommonTree)match(input,Two,FOLLOW_Two_in_goal_contents_process_21464); if (state.failed) return str;
			pushFollow(FOLLOW_goal_content_in_goal_contents_process_21468);
			c1=goal_content();
			state._fsp--;
			if (state.failed) return str;
			pushFollow(FOLLOW_goal_content_in_goal_contents_process_21472);
			c2=goal_content();
			state._fsp--;
			if (state.failed) return str;
			if ( state.backtracking==0 ) { 
					      // p: penalty f: free c: constrain
					      // pp -> =
					      // pc or cp -> =
					      // pf or fp  -> f
					      // fc or cf  -> f (same as c)		      
					      // cc -> =  (simple string)
					      // ff -> error

					   
					  		if ( (t!=null?t.getText():null).equals("pp") ) { 
					  				
					  			str = (c1!=null?((WreslTreeWalker.goal_content_return)c1).lhs:null) + (c1!=null?((WreslTreeWalker.goal_content_return)c1).ss:null) + (c2!=null?((WreslTreeWalker.goal_content_return)c2).ss:null) + "=" + (c1!=null?((WreslTreeWalker.goal_content_return)c1).rhs:null) ;
					  			 
					  		} else if  ( (t!=null?t.getText():null).equals("pc") ) {
					  		
					  			str = (c1!=null?((WreslTreeWalker.goal_content_return)c1).lhs:null) + (c1!=null?((WreslTreeWalker.goal_content_return)c1).ss:null) + "=" + (c1!=null?((WreslTreeWalker.goal_content_return)c1).rhs:null) ; 
					  			
					  		} else if  ( (t!=null?t.getText():null).equals("cp") ) {
					  		
					  			str = (c2!=null?((WreslTreeWalker.goal_content_return)c2).lhs:null) + (c2!=null?((WreslTreeWalker.goal_content_return)c2).ss:null) + "=" + (c2!=null?((WreslTreeWalker.goal_content_return)c2).rhs:null); 	

					  		} else if  ( (t!=null?t.getText():null).equals("pf") ) {
					  		
					  			str = (c1!=null?((WreslTreeWalker.goal_content_return)c1).lhs:null) + (c1!=null?((WreslTreeWalker.goal_content_return)c1).ss:null) + (c2!=null?((WreslTreeWalker.goal_content_return)c2).op:null) + (c1!=null?((WreslTreeWalker.goal_content_return)c1).rhs:null) ; 			
					  		
					  		} else if ( (t!=null?t.getText():null).equals("fp"))  {
					  		
					  			str = (c2!=null?((WreslTreeWalker.goal_content_return)c2).lhs:null) + (c2!=null?((WreslTreeWalker.goal_content_return)c2).ss:null) + (c1!=null?((WreslTreeWalker.goal_content_return)c1).op:null) + (c2!=null?((WreslTreeWalker.goal_content_return)c2).rhs:null); 
					  		
					  		} else if ( (t!=null?t.getText():null).equals("fc"))  {  
					  		
					  			str = (c1!=null?((WreslTreeWalker.goal_content_return)c1).lhs:null) + (c1!=null?((WreslTreeWalker.goal_content_return)c1).op:null) + (c1!=null?((WreslTreeWalker.goal_content_return)c1).rhs:null) ;
					  			
					  		} else if ( (t!=null?t.getText():null).equals("cf"))  {  
					  		
					  			str = (c1!=null?((WreslTreeWalker.goal_content_return)c1).lhs:null) + (c2!=null?((WreslTreeWalker.goal_content_return)c2).op:null) + (c1!=null?((WreslTreeWalker.goal_content_return)c1).rhs:null) ;
					  					  		
					  			
					  		} else if ( (t!=null?t.getText():null).equals("cc"))  {  
					  		
					  			str = (c1!=null?((WreslTreeWalker.goal_content_return)c1).lhs:null)+"="+(c1!=null?((WreslTreeWalker.goal_content_return)c1).rhs:null) ;
					  			
					  		} else  {  // ff
					  		
					  			str = " 1 > 0 ";  // do something
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
		return str;
	}
	// $ANTLR end "goal_contents_process_2"


	public static class goal_content_return extends TreeRuleReturnScope {
		public boolean hasDvar;
		public String str;
		public String ss;
		public String weight;
		public String lhs;
		public String rhs;
		public String type;
		public String op;
	};


	// $ANTLR start "goal_content"
	// WreslTreeWalker.g:380:1: goal_content returns [boolean hasDvar, String str, String ss, String weight, String lhs, String rhs, String type, String op] : ( Constrain | Free | Penalty ) l= Lhs o= Op r= Rhs ( Sign Kind s= Slack_Surplus w= Weight )? ;
	public final WreslTreeWalker.goal_content_return goal_content() throws RecognitionException {
		WreslTreeWalker.goal_content_return retval = new WreslTreeWalker.goal_content_return();
		retval.start = input.LT(1);

		CommonTree l=null;
		CommonTree o=null;
		CommonTree r=null;
		CommonTree s=null;
		CommonTree w=null;
		CommonTree Kind1=null;
		CommonTree Sign2=null;

		retval.hasDvar =false; String kind=null; retval.type ="constrain";
		try {
			// WreslTreeWalker.g:382:2: ( ( Constrain | Free | Penalty ) l= Lhs o= Op r= Rhs ( Sign Kind s= Slack_Surplus w= Weight )? )
			// WreslTreeWalker.g:383:4: ( Constrain | Free | Penalty ) l= Lhs o= Op r= Rhs ( Sign Kind s= Slack_Surplus w= Weight )?
			{
			if ( input.LA(1)==Constrain||input.LA(1)==Free||input.LA(1)==Penalty ) {
				input.consume();
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			l=(CommonTree)match(input,Lhs,FOLLOW_Lhs_in_goal_content1517); if (state.failed) return retval;
			o=(CommonTree)match(input,Op,FOLLOW_Op_in_goal_content1521); if (state.failed) return retval;
			r=(CommonTree)match(input,Rhs,FOLLOW_Rhs_in_goal_content1525); if (state.failed) return retval;
			// WreslTreeWalker.g:383:56: ( Sign Kind s= Slack_Surplus w= Weight )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==Sign) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// WreslTreeWalker.g:383:58: Sign Kind s= Slack_Surplus w= Weight
					{
					Sign2=(CommonTree)match(input,Sign,FOLLOW_Sign_in_goal_content1531); if (state.failed) return retval;
					Kind1=(CommonTree)match(input,Kind,FOLLOW_Kind_in_goal_content1534); if (state.failed) return retval;
					s=(CommonTree)match(input,Slack_Surplus,FOLLOW_Slack_Surplus_in_goal_content1539); if (state.failed) return retval;
					w=(CommonTree)match(input,Weight,FOLLOW_Weight_in_goal_content1544); if (state.failed) return retval;
					}
					break;

			}

			if ( state.backtracking==0 ) {  retval.str = (l!=null?l.getText():null) + (o!=null?o.getText():null) + (r!=null?r.getText():null); 
					 
					    if (s!=null) { 
					    	
					    	if (goal_stack.peek().case_condition.equalsIgnoreCase(Param.conditional)){
					    		
					    		goal_stack.peek().dvarWeightMap.put((s!=null?s.getText():null).toLowerCase(), (w!=null?w.getText():null).toLowerCase());
					    		goal_stack.peek().dvarSlackSurplus.add((s!=null?s.getText():null).toLowerCase());
					    		goal_stack.peek().gl.dvarWeightMapList.set(goal_stack.peek().caseNumber,goal_stack.peek().dvarWeightMap);	
					    		goal_stack.peek().gl.dvarSlackSurplusList.set(goal_stack.peek().caseNumber,goal_stack.peek().dvarSlackSurplus);	
					    	}
					    	//System.out.println((s!=null?s.getText():null).toLowerCase()+": "+(w!=null?w.getText():null).toLowerCase());
					    	//goal_stack.peek().gl.dvarName.set(goal_stack.peek().caseNumber, (s!=null?s.getText():null).toLowerCase());
					    	//goal_stack.peek().gl.dvarWeight.set(goal_stack.peek().caseNumber, (w!=null?w.getText():null).toLowerCase());
					    	//F.dvarStd((s!=null?s.getText():null), goal_stack.peek().scop, null, (Kind1!=null?Kind1.getText():null), "");  
					    	if (goal_stack.peek().ta==null){ 
			            retval.ss = (Sign2!=null?Sign2.getText():null) + (s!=null?s.getText():null);
			            F.dvarSlackSurplus((s!=null?s.getText():null), goal_stack.peek().scop, (Kind1!=null?Kind1.getText():null), "", goal_stack.peek().case_condition, "0");
			            F.mergeSlackSurplusIntoWeightTable((s!=null?s.getText():null), (w!=null?w.getText():null), goal_stack.peek().scop, goal_stack.peek().case_condition, "0");
			          }else if (goal_stack.peek().ta.equals("0")){
			            retval.ss = (Sign2!=null?Sign2.getText():null) + (s!=null?s.getText():null);
			            F.dvarSlackSurplus((s!=null?s.getText():null), goal_stack.peek().scop, (Kind1!=null?Kind1.getText():null), "", goal_stack.peek().case_condition, "0");
			            F.mergeSlackSurplusIntoWeightTable((s!=null?s.getText():null), (w!=null?w.getText():null), goal_stack.peek().scop, goal_stack.peek().case_condition, "0");
			          }else{
			            retval.ss = (Sign2!=null?Sign2.getText():null) + (s!=null?s.getText():null)+"($m)";
			            F.dvarSlackSurplus((s!=null?s.getText():null), goal_stack.peek().scop, (Kind1!=null?Kind1.getText():null), "", goal_stack.peek().case_condition, goal_stack.peek().ta);
			            F.mergeSlackSurplusIntoWeightTable((s!=null?s.getText():null), (w!=null?w.getText():null), goal_stack.peek().scop, goal_stack.peek().case_condition, goal_stack.peek().ta);
			          } 
					 		retval.hasDvar = true; 
					 		retval.weight = (w!=null?w.getText():null); }
					 	//} else {
					 	
					 	 	retval.lhs = (l!=null?l.getText():null); retval.rhs = (r!=null?r.getText():null); retval.op = (o!=null?o.getText():null);
					 	//}
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
	// $ANTLR end "goal_content"



	// $ANTLR start "goal_content_simple"
	// WreslTreeWalker.g:422:1: goal_content_simple returns [String str] : Simple l= Lhs o= Op r= Rhs ;
	public final String goal_content_simple() throws RecognitionException {
		String str = null;


		CommonTree l=null;
		CommonTree o=null;
		CommonTree r=null;

		try {
			// WreslTreeWalker.g:423:2: ( Simple l= Lhs o= Op r= Rhs )
			// WreslTreeWalker.g:424:5: Simple l= Lhs o= Op r= Rhs
			{
			match(input,Simple,FOLLOW_Simple_in_goal_content_simple1578); if (state.failed) return str;
			l=(CommonTree)match(input,Lhs,FOLLOW_Lhs_in_goal_content_simple1583); if (state.failed) return str;
			o=(CommonTree)match(input,Op,FOLLOW_Op_in_goal_content_simple1587); if (state.failed) return str;
			r=(CommonTree)match(input,Rhs,FOLLOW_Rhs_in_goal_content_simple1591); if (state.failed) return str;
			if ( state.backtracking==0 ) {  str = (l!=null?l.getText():null) + (o!=null?o.getText():null) + (r!=null?r.getText():null); }
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return str;
	}
	// $ANTLR end "goal_content_simple"



	// $ANTLR start "svar_table"
	// WreslTreeWalker.g:428:1: svar_table : ^( Svar_table sc= Scope i= IDENT t= table_content ) ;
	public final void svar_table() throws RecognitionException {
		CommonTree sc=null;
		CommonTree i=null;
		TreeRuleReturnScope t =null;

		try {
			// WreslTreeWalker.g:428:12: ( ^( Svar_table sc= Scope i= IDENT t= table_content ) )
			// WreslTreeWalker.g:429:2: ^( Svar_table sc= Scope i= IDENT t= table_content )
			{
			match(input,Svar_table,FOLLOW_Svar_table_in_svar_table1612); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_svar_table1616); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_svar_table1620); if (state.failed) return;
			pushFollow(FOLLOW_table_content_in_svar_table1624);
			t=table_content();
			state._fsp--;
			if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) { F.svarTable((i!=null?i.getText():null), (sc!=null?sc.getText():null), (t!=null?((WreslTreeWalker.table_content_return)t).text:null), (t!=null?((WreslTreeWalker.table_content_return)t).dependants:null), (t!=null?((WreslTreeWalker.table_content_return)t).varInCycle:null)); }
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
	// $ANTLR end "svar_table"



	// $ANTLR start "svar_timeArray_table"
	// WreslTreeWalker.g:433:1: svar_timeArray_table : ^( Svar_table ta= TimeArraySize sc= Scope i= IDENT t= table_content ) ;
	public final void svar_timeArray_table() throws RecognitionException {
		CommonTree ta=null;
		CommonTree sc=null;
		CommonTree i=null;
		TreeRuleReturnScope t =null;

		try {
			// WreslTreeWalker.g:433:22: ( ^( Svar_table ta= TimeArraySize sc= Scope i= IDENT t= table_content ) )
			// WreslTreeWalker.g:434:3: ^( Svar_table ta= TimeArraySize sc= Scope i= IDENT t= table_content )
			{
			match(input,Svar_table,FOLLOW_Svar_table_in_svar_timeArray_table1647); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			ta=(CommonTree)match(input,TimeArraySize,FOLLOW_TimeArraySize_in_svar_timeArray_table1651); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_svar_timeArray_table1655); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_svar_timeArray_table1659); if (state.failed) return;
			pushFollow(FOLLOW_table_content_in_svar_timeArray_table1663);
			t=table_content();
			state._fsp--;
			if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) { F.svarTable((i!=null?i.getText():null), (sc!=null?sc.getText():null), (t!=null?((WreslTreeWalker.table_content_return)t).text:null), (t!=null?((WreslTreeWalker.table_content_return)t).dependants:null), (t!=null?((WreslTreeWalker.table_content_return)t).varInCycle:null), (ta!=null?ta.getText():null)); }
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
	// $ANTLR end "svar_timeArray_table"



	// $ANTLR start "svar_sum"
	// WreslTreeWalker.g:438:1: svar_sum : ^( Svar_sum sc= Scope i= IDENT sum= sum_content ) ;
	public final void svar_sum() throws RecognitionException {
		CommonTree sc=null;
		CommonTree i=null;
		TreeRuleReturnScope sum =null;

		try {
			// WreslTreeWalker.g:438:10: ( ^( Svar_sum sc= Scope i= IDENT sum= sum_content ) )
			// WreslTreeWalker.g:439:5: ^( Svar_sum sc= Scope i= IDENT sum= sum_content )
			{
			match(input,Svar_sum,FOLLOW_Svar_sum_in_svar_sum1689); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_svar_sum1693); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_svar_sum1697); if (state.failed) return;
			pushFollow(FOLLOW_sum_content_in_svar_sum1701);
			sum=sum_content();
			state._fsp--;
			if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) { F.svarSum((i!=null?i.getText():null), (sc!=null?sc.getText():null), (sum!=null?((WreslTreeWalker.sum_content_return)sum).hdr:null), (sum!=null?((WreslTreeWalker.sum_content_return)sum).expr:null), (sum!=null?((WreslTreeWalker.sum_content_return)sum).dependants:null), (sum!=null?((WreslTreeWalker.sum_content_return)sum).varInCycle:null) ); }
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
	// $ANTLR end "svar_sum"



	// $ANTLR start "svar_timeArray_sum"
	// WreslTreeWalker.g:443:1: svar_timeArray_sum : ^( Svar_sum ta= TimeArraySize sc= Scope i= IDENT sum= sum_content ) ;
	public final void svar_timeArray_sum() throws RecognitionException {
		CommonTree ta=null;
		CommonTree sc=null;
		CommonTree i=null;
		TreeRuleReturnScope sum =null;

		try {
			// WreslTreeWalker.g:443:20: ( ^( Svar_sum ta= TimeArraySize sc= Scope i= IDENT sum= sum_content ) )
			// WreslTreeWalker.g:444:3: ^( Svar_sum ta= TimeArraySize sc= Scope i= IDENT sum= sum_content )
			{
			match(input,Svar_sum,FOLLOW_Svar_sum_in_svar_timeArray_sum1727); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			ta=(CommonTree)match(input,TimeArraySize,FOLLOW_TimeArraySize_in_svar_timeArray_sum1731); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_svar_timeArray_sum1735); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_svar_timeArray_sum1739); if (state.failed) return;
			pushFollow(FOLLOW_sum_content_in_svar_timeArray_sum1743);
			sum=sum_content();
			state._fsp--;
			if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) { F.svarSum((i!=null?i.getText():null), (sc!=null?sc.getText():null), (sum!=null?((WreslTreeWalker.sum_content_return)sum).hdr:null), (sum!=null?((WreslTreeWalker.sum_content_return)sum).expr:null), (sum!=null?((WreslTreeWalker.sum_content_return)sum).dependants:null), (sum!=null?((WreslTreeWalker.sum_content_return)sum).varInCycle:null), (ta!=null?ta.getText():null) ); }
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
	// $ANTLR end "svar_timeArray_sum"


	public static class sum_content_return extends TreeRuleReturnScope {
		public String hdr;
		public String expr;
		public String dependants;
		public String varInCycle;
	};


	// $ANTLR start "sum_content"
	// WreslTreeWalker.g:448:1: sum_content returns [String hdr, String expr, String dependants, String varInCycle] : ^(h= Sum_hdr e= Expression d= Dependants vc= VarInCycle ) ;
	public final WreslTreeWalker.sum_content_return sum_content() throws RecognitionException {
		WreslTreeWalker.sum_content_return retval = new WreslTreeWalker.sum_content_return();
		retval.start = input.LT(1);

		CommonTree h=null;
		CommonTree e=null;
		CommonTree d=null;
		CommonTree vc=null;

		try {
			// WreslTreeWalker.g:448:83: ( ^(h= Sum_hdr e= Expression d= Dependants vc= VarInCycle ) )
			// WreslTreeWalker.g:449:4: ^(h= Sum_hdr e= Expression d= Dependants vc= VarInCycle )
			{
			h=(CommonTree)match(input,Sum_hdr,FOLLOW_Sum_hdr_in_sum_content1768); if (state.failed) return retval;
			match(input, Token.DOWN, null); if (state.failed) return retval;
			e=(CommonTree)match(input,Expression,FOLLOW_Expression_in_sum_content1772); if (state.failed) return retval;
			d=(CommonTree)match(input,Dependants,FOLLOW_Dependants_in_sum_content1776); if (state.failed) return retval;
			vc=(CommonTree)match(input,VarInCycle,FOLLOW_VarInCycle_in_sum_content1780); if (state.failed) return retval;
			match(input, Token.UP, null); if (state.failed) return retval;

			if ( state.backtracking==0 ) { 
					retval.hdr ="SUM"+Tools.replace_ignoreChar( Tools.replace_seperator((h!=null?h.getText():null))); 
			    	retval.expr = (e!=null?e.getText():null);
			    	retval.dependants = (d!=null?d.getText():null);
			    	retval.varInCycle = (vc!=null?vc.getText():null);
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
	// $ANTLR end "sum_content"



	// $ANTLR start "svar_expr"
	// WreslTreeWalker.g:458:1: svar_expr : ^( Svar_const sc= Scope i= IDENT v= Expression d= Dependants vc= VarInCycle ) ;
	public final void svar_expr() throws RecognitionException {
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree v=null;
		CommonTree d=null;
		CommonTree vc=null;

		try {
			// WreslTreeWalker.g:458:11: ( ^( Svar_const sc= Scope i= IDENT v= Expression d= Dependants vc= VarInCycle ) )
			// WreslTreeWalker.g:459:5: ^( Svar_const sc= Scope i= IDENT v= Expression d= Dependants vc= VarInCycle )
			{
			match(input,Svar_const,FOLLOW_Svar_const_in_svar_expr1801); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_svar_expr1805); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_svar_expr1809); if (state.failed) return;
			v=(CommonTree)match(input,Expression,FOLLOW_Expression_in_svar_expr1813); if (state.failed) return;
			d=(CommonTree)match(input,Dependants,FOLLOW_Dependants_in_svar_expr1817); if (state.failed) return;
			vc=(CommonTree)match(input,VarInCycle,FOLLOW_VarInCycle_in_svar_expr1821); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) { F.svarExpression((i!=null?i.getText():null), (sc!=null?sc.getText():null), Tools.replace_seperator((v!=null?v.getText():null)), (d!=null?d.getText():null), (vc!=null?vc.getText():null) ); }
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
	// $ANTLR end "svar_expr"



	// $ANTLR start "svar_timeArray_expr"
	// WreslTreeWalker.g:463:1: svar_timeArray_expr : ^( SvarTimeArray_const ta= TimeArraySize sc= Scope i= IDENT v= Expression d= Dependants vc= VarInCycle ) ;
	public final void svar_timeArray_expr() throws RecognitionException {
		CommonTree ta=null;
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree v=null;
		CommonTree d=null;
		CommonTree vc=null;

		try {
			// WreslTreeWalker.g:463:21: ( ^( SvarTimeArray_const ta= TimeArraySize sc= Scope i= IDENT v= Expression d= Dependants vc= VarInCycle ) )
			// WreslTreeWalker.g:464:5: ^( SvarTimeArray_const ta= TimeArraySize sc= Scope i= IDENT v= Expression d= Dependants vc= VarInCycle )
			{
			match(input,SvarTimeArray_const,FOLLOW_SvarTimeArray_const_in_svar_timeArray_expr1844); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			ta=(CommonTree)match(input,TimeArraySize,FOLLOW_TimeArraySize_in_svar_timeArray_expr1848); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_svar_timeArray_expr1852); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_svar_timeArray_expr1856); if (state.failed) return;
			v=(CommonTree)match(input,Expression,FOLLOW_Expression_in_svar_timeArray_expr1860); if (state.failed) return;
			d=(CommonTree)match(input,Dependants,FOLLOW_Dependants_in_svar_timeArray_expr1864); if (state.failed) return;
			vc=(CommonTree)match(input,VarInCycle,FOLLOW_VarInCycle_in_svar_timeArray_expr1868); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) { F.svarExpression((i!=null?i.getText():null), (sc!=null?sc.getText():null), Tools.replace_seperator((v!=null?v.getText():null)), (d!=null?d.getText():null), (vc!=null?vc.getText():null), (ta!=null?ta.getText():null) ); }
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
	// $ANTLR end "svar_timeArray_expr"



	// $ANTLR start "svar_dss"
	// WreslTreeWalker.g:468:1: svar_dss : ^( Svar_dss sc= Scope i= IDENT b= B_part Kind k= STRING Units u= STRING c= CONVERT ) ;
	public final void svar_dss() throws RecognitionException {
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree b=null;
		CommonTree k=null;
		CommonTree u=null;
		CommonTree c=null;

		try {
			// WreslTreeWalker.g:468:10: ( ^( Svar_dss sc= Scope i= IDENT b= B_part Kind k= STRING Units u= STRING c= CONVERT ) )
			// WreslTreeWalker.g:469:8: ^( Svar_dss sc= Scope i= IDENT b= B_part Kind k= STRING Units u= STRING c= CONVERT )
			{
			match(input,Svar_dss,FOLLOW_Svar_dss_in_svar_dss1893); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_svar_dss1897); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_svar_dss1901); if (state.failed) return;
			b=(CommonTree)match(input,B_part,FOLLOW_B_part_in_svar_dss1905); if (state.failed) return;
			match(input,Kind,FOLLOW_Kind_in_svar_dss1907); if (state.failed) return;
			k=(CommonTree)match(input,STRING,FOLLOW_STRING_in_svar_dss1911); if (state.failed) return;
			match(input,Units,FOLLOW_Units_in_svar_dss1913); if (state.failed) return;
			u=(CommonTree)match(input,STRING,FOLLOW_STRING_in_svar_dss1917); if (state.failed) return;
			c=(CommonTree)match(input,CONVERT,FOLLOW_CONVERT_in_svar_dss1921); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) { F.timeseriesDss((i!=null?i.getText():null), (sc!=null?sc.getText():null), Tools.strip((b!=null?b.getText():null)), Tools.strip((k!=null?k.getText():null)), Tools.strip((u!=null?u.getText():null)),  Tools.strip((c!=null?c.getText():null))); }
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
	// $ANTLR end "svar_dss"



	// $ANTLR start "dvar_std"
	// WreslTreeWalker.g:473:1: dvar_std : ^( Dvar_std sc= Scope i= IDENT Kind k= STRING Units u= STRING ) ;
	public final void dvar_std() throws RecognitionException {
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree k=null;
		CommonTree u=null;

		try {
			// WreslTreeWalker.g:473:11: ( ^( Dvar_std sc= Scope i= IDENT Kind k= STRING Units u= STRING ) )
			// WreslTreeWalker.g:474:8: ^( Dvar_std sc= Scope i= IDENT Kind k= STRING Units u= STRING )
			{
			match(input,Dvar_std,FOLLOW_Dvar_std_in_dvar_std1951); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_dvar_std1955); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_dvar_std1959); if (state.failed) return;
			match(input,Kind,FOLLOW_Kind_in_dvar_std1961); if (state.failed) return;
			k=(CommonTree)match(input,STRING,FOLLOW_STRING_in_dvar_std1965); if (state.failed) return;
			match(input,Units,FOLLOW_Units_in_dvar_std1967); if (state.failed) return;
			u=(CommonTree)match(input,STRING,FOLLOW_STRING_in_dvar_std1971); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) { F.dvarStd((i!=null?i.getText():null), (sc!=null?sc.getText():null), null, Tools.strip((k!=null?k.getText():null)), Tools.strip((u!=null?u.getText():null))); }
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
	// $ANTLR end "dvar_std"



	// $ANTLR start "dvar_nonStd"
	// WreslTreeWalker.g:478:1: dvar_nonStd : ^( Dvar_nonStd sc= Scope i= IDENT Lower lowerbound= LimitType Upper upperbound= LimitType Kind k= STRING Units u= STRING ) ;
	public final void dvar_nonStd() throws RecognitionException {
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree lowerbound=null;
		CommonTree upperbound=null;
		CommonTree k=null;
		CommonTree u=null;

		try {
			// WreslTreeWalker.g:478:13: ( ^( Dvar_nonStd sc= Scope i= IDENT Lower lowerbound= LimitType Upper upperbound= LimitType Kind k= STRING Units u= STRING ) )
			// WreslTreeWalker.g:479:5: ^( Dvar_nonStd sc= Scope i= IDENT Lower lowerbound= LimitType Upper upperbound= LimitType Kind k= STRING Units u= STRING )
			{
			match(input,Dvar_nonStd,FOLLOW_Dvar_nonStd_in_dvar_nonStd1997); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_dvar_nonStd2001); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_dvar_nonStd2005); if (state.failed) return;
			match(input,Lower,FOLLOW_Lower_in_dvar_nonStd2007); if (state.failed) return;
			lowerbound=(CommonTree)match(input,LimitType,FOLLOW_LimitType_in_dvar_nonStd2011); if (state.failed) return;
			match(input,Upper,FOLLOW_Upper_in_dvar_nonStd2013); if (state.failed) return;
			upperbound=(CommonTree)match(input,LimitType,FOLLOW_LimitType_in_dvar_nonStd2017); if (state.failed) return;
			match(input,Kind,FOLLOW_Kind_in_dvar_nonStd2019); if (state.failed) return;
			k=(CommonTree)match(input,STRING,FOLLOW_STRING_in_dvar_nonStd2023); if (state.failed) return;
			match(input,Units,FOLLOW_Units_in_dvar_nonStd2025); if (state.failed) return;
			u=(CommonTree)match(input,STRING,FOLLOW_STRING_in_dvar_nonStd2029); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {F.dvarNonStd((i!=null?i.getText():null), (sc!=null?sc.getText():null), null, Tools.strip((k!=null?k.getText():null)), Tools.strip((u!=null?u.getText():null)),  (lowerbound!=null?lowerbound.getText():null), (upperbound!=null?upperbound.getText():null));}
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
	// $ANTLR end "dvar_nonStd"



	// $ANTLR start "dvar_timeArray_std"
	// WreslTreeWalker.g:483:1: dvar_timeArray_std : ^( DvarTimeArray_std ta= TimeArraySize sc= Scope i= IDENT Kind k= STRING Units u= STRING ) ;
	public final void dvar_timeArray_std() throws RecognitionException {
		CommonTree ta=null;
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree k=null;
		CommonTree u=null;

		try {
			// WreslTreeWalker.g:483:21: ( ^( DvarTimeArray_std ta= TimeArraySize sc= Scope i= IDENT Kind k= STRING Units u= STRING ) )
			// WreslTreeWalker.g:484:8: ^( DvarTimeArray_std ta= TimeArraySize sc= Scope i= IDENT Kind k= STRING Units u= STRING )
			{
			match(input,DvarTimeArray_std,FOLLOW_DvarTimeArray_std_in_dvar_timeArray_std2055); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			ta=(CommonTree)match(input,TimeArraySize,FOLLOW_TimeArraySize_in_dvar_timeArray_std2059); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_dvar_timeArray_std2063); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_dvar_timeArray_std2067); if (state.failed) return;
			match(input,Kind,FOLLOW_Kind_in_dvar_timeArray_std2069); if (state.failed) return;
			k=(CommonTree)match(input,STRING,FOLLOW_STRING_in_dvar_timeArray_std2073); if (state.failed) return;
			match(input,Units,FOLLOW_Units_in_dvar_timeArray_std2075); if (state.failed) return;
			u=(CommonTree)match(input,STRING,FOLLOW_STRING_in_dvar_timeArray_std2079); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) { F.dvarStd((i!=null?i.getText():null), (sc!=null?sc.getText():null), null, Tools.strip((k!=null?k.getText():null)), Tools.strip((u!=null?u.getText():null)), (ta!=null?ta.getText():null) ); }
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
	// $ANTLR end "dvar_timeArray_std"



	// $ANTLR start "dvar_timeArray_nonStd"
	// WreslTreeWalker.g:488:1: dvar_timeArray_nonStd : ^( DvarTimeArray_nonStd ta= TimeArraySize sc= Scope i= IDENT Lower lowerbound= LimitType Upper upperbound= LimitType Kind k= STRING Units u= STRING ) ;
	public final void dvar_timeArray_nonStd() throws RecognitionException {
		CommonTree ta=null;
		CommonTree sc=null;
		CommonTree i=null;
		CommonTree lowerbound=null;
		CommonTree upperbound=null;
		CommonTree k=null;
		CommonTree u=null;

		try {
			// WreslTreeWalker.g:488:23: ( ^( DvarTimeArray_nonStd ta= TimeArraySize sc= Scope i= IDENT Lower lowerbound= LimitType Upper upperbound= LimitType Kind k= STRING Units u= STRING ) )
			// WreslTreeWalker.g:489:5: ^( DvarTimeArray_nonStd ta= TimeArraySize sc= Scope i= IDENT Lower lowerbound= LimitType Upper upperbound= LimitType Kind k= STRING Units u= STRING )
			{
			match(input,DvarTimeArray_nonStd,FOLLOW_DvarTimeArray_nonStd_in_dvar_timeArray_nonStd2108); if (state.failed) return;
			match(input, Token.DOWN, null); if (state.failed) return;
			ta=(CommonTree)match(input,TimeArraySize,FOLLOW_TimeArraySize_in_dvar_timeArray_nonStd2112); if (state.failed) return;
			sc=(CommonTree)match(input,Scope,FOLLOW_Scope_in_dvar_timeArray_nonStd2116); if (state.failed) return;
			i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_dvar_timeArray_nonStd2120); if (state.failed) return;
			match(input,Lower,FOLLOW_Lower_in_dvar_timeArray_nonStd2122); if (state.failed) return;
			lowerbound=(CommonTree)match(input,LimitType,FOLLOW_LimitType_in_dvar_timeArray_nonStd2126); if (state.failed) return;
			match(input,Upper,FOLLOW_Upper_in_dvar_timeArray_nonStd2128); if (state.failed) return;
			upperbound=(CommonTree)match(input,LimitType,FOLLOW_LimitType_in_dvar_timeArray_nonStd2132); if (state.failed) return;
			match(input,Kind,FOLLOW_Kind_in_dvar_timeArray_nonStd2134); if (state.failed) return;
			k=(CommonTree)match(input,STRING,FOLLOW_STRING_in_dvar_timeArray_nonStd2138); if (state.failed) return;
			match(input,Units,FOLLOW_Units_in_dvar_timeArray_nonStd2140); if (state.failed) return;
			u=(CommonTree)match(input,STRING,FOLLOW_STRING_in_dvar_timeArray_nonStd2144); if (state.failed) return;
			match(input, Token.UP, null); if (state.failed) return;

			if ( state.backtracking==0 ) {F.dvarNonStd((i!=null?i.getText():null), (sc!=null?sc.getText():null), null, Tools.strip((k!=null?k.getText():null)), Tools.strip((u!=null?u.getText():null)),  (lowerbound!=null?lowerbound.getText():null), (upperbound!=null?upperbound.getText():null), (ta!=null?ta.getText():null));}
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
	// $ANTLR end "dvar_timeArray_nonStd"



	// $ANTLR start "term"
	// WreslTreeWalker.g:494:1: term : ( IDENT | '(' expression ')' | INTEGER );
	public final void term() throws RecognitionException {
		try {
			// WreslTreeWalker.g:495:2: ( IDENT | '(' expression ')' | INTEGER )
			int alt26=3;
			switch ( input.LA(1) ) {
			case IDENT:
				{
				alt26=1;
				}
				break;
			case 139:
				{
				alt26=2;
				}
				break;
			case INTEGER:
				{
				alt26=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return;}
				NoViableAltException nvae =
					new NoViableAltException("", 26, 0, input);
				throw nvae;
			}
			switch (alt26) {
				case 1 :
					// WreslTreeWalker.g:495:4: IDENT
					{
					match(input,IDENT,FOLLOW_IDENT_in_term2164); if (state.failed) return;
					}
					break;
				case 2 :
					// WreslTreeWalker.g:496:4: '(' expression ')'
					{
					match(input,139,FOLLOW_139_in_term2169); if (state.failed) return;
					pushFollow(FOLLOW_expression_in_term2171);
					expression();
					state._fsp--;
					if (state.failed) return;
					match(input,140,FOLLOW_140_in_term2173); if (state.failed) return;
					}
					break;
				case 3 :
					// WreslTreeWalker.g:497:4: INTEGER
					{
					match(input,INTEGER,FOLLOW_INTEGER_in_term2178); if (state.failed) return;
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
	// $ANTLR end "term"



	// $ANTLR start "unary"
	// WreslTreeWalker.g:500:1: unary : ( NEGATION )? term ;
	public final void unary() throws RecognitionException {
		try {
			// WreslTreeWalker.g:500:7: ( ( NEGATION )? term )
			// WreslTreeWalker.g:500:9: ( NEGATION )? term
			{
			// WreslTreeWalker.g:500:9: ( NEGATION )?
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==NEGATION) ) {
				alt27=1;
			}
			switch (alt27) {
				case 1 :
					// WreslTreeWalker.g:500:9: NEGATION
					{
					match(input,NEGATION,FOLLOW_NEGATION_in_unary2189); if (state.failed) return;
					}
					break;

			}

			pushFollow(FOLLOW_term_in_unary2192);
			term();
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
	// $ANTLR end "unary"



	// $ANTLR start "mult"
	// WreslTreeWalker.g:502:1: mult : unary ( ( '*' | '/' ) unary )* ;
	public final void mult() throws RecognitionException {
		try {
			// WreslTreeWalker.g:502:6: ( unary ( ( '*' | '/' ) unary )* )
			// WreslTreeWalker.g:502:8: unary ( ( '*' | '/' ) unary )*
			{
			pushFollow(FOLLOW_unary_in_mult2202);
			unary();
			state._fsp--;
			if (state.failed) return;
			// WreslTreeWalker.g:502:14: ( ( '*' | '/' ) unary )*
			loop28:
			while (true) {
				int alt28=2;
				int LA28_0 = input.LA(1);
				if ( (LA28_0==141||LA28_0==145) ) {
					alt28=1;
				}

				switch (alt28) {
				case 1 :
					// WreslTreeWalker.g:502:15: ( '*' | '/' ) unary
					{
					if ( input.LA(1)==141||input.LA(1)==145 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_unary_in_mult2214);
					unary();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop28;
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
	// $ANTLR end "mult"



	// $ANTLR start "expression"
	// WreslTreeWalker.g:504:1: expression : mult ( ( '+' | '-' ) mult )* ;
	public final void expression() throws RecognitionException {
		try {
			// WreslTreeWalker.g:504:12: ( mult ( ( '+' | '-' ) mult )* )
			// WreslTreeWalker.g:504:14: mult ( ( '+' | '-' ) mult )*
			{
			pushFollow(FOLLOW_mult_in_expression2227);
			mult();
			state._fsp--;
			if (state.failed) return;
			// WreslTreeWalker.g:504:19: ( ( '+' | '-' ) mult )*
			loop29:
			while (true) {
				int alt29=2;
				int LA29_0 = input.LA(1);
				if ( (LA29_0==142||LA29_0==144) ) {
					alt29=1;
				}

				switch (alt29) {
				case 1 :
					// WreslTreeWalker.g:504:20: ( '+' | '-' ) mult
					{
					if ( input.LA(1)==142||input.LA(1)==144 ) {
						input.consume();
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_mult_in_expression2238);
					mult();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop29;
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
	// $ANTLR end "expression"



	// $ANTLR start "c_term"
	// WreslTreeWalker.g:506:1: c_term : ( ( expression relation expression )=> expression relation expression | ( '(' logical ')' )=> '(' logical ')' );
	public final void c_term() throws RecognitionException {
		try {
			// WreslTreeWalker.g:507:2: ( ( expression relation expression )=> expression relation expression | ( '(' logical ')' )=> '(' logical ')' )
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==NEGATION) && (synpred1_WreslTreeWalker())) {
				alt30=1;
			}
			else if ( (LA30_0==IDENT) && (synpred1_WreslTreeWalker())) {
				alt30=1;
			}
			else if ( (LA30_0==139) ) {
				int LA30_3 = input.LA(2);
				if ( (synpred1_WreslTreeWalker()) ) {
					alt30=1;
				}
				else if ( (synpred2_WreslTreeWalker()) ) {
					alt30=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 30, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA30_0==INTEGER) && (synpred1_WreslTreeWalker())) {
				alt30=1;
			}

			switch (alt30) {
				case 1 :
					// WreslTreeWalker.g:507:4: ( expression relation expression )=> expression relation expression
					{
					pushFollow(FOLLOW_expression_in_c_term2263);
					expression();
					state._fsp--;
					if (state.failed) return;
					pushFollow(FOLLOW_relation_in_c_term2265);
					relation();
					state._fsp--;
					if (state.failed) return;
					pushFollow(FOLLOW_expression_in_c_term2267);
					expression();
					state._fsp--;
					if (state.failed) return;
					}
					break;
				case 2 :
					// WreslTreeWalker.g:508:4: ( '(' logical ')' )=> '(' logical ')'
					{
					match(input,139,FOLLOW_139_in_c_term2284); if (state.failed) return;
					pushFollow(FOLLOW_logical_in_c_term2286);
					logical();
					state._fsp--;
					if (state.failed) return;
					match(input,140,FOLLOW_140_in_c_term2288); if (state.failed) return;
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
	// $ANTLR end "c_term"



	// $ANTLR start "c_unary"
	// WreslTreeWalker.g:511:1: c_unary : ( NOT )? c_term ;
	public final void c_unary() throws RecognitionException {
		try {
			// WreslTreeWalker.g:511:9: ( ( NOT )? c_term )
			// WreslTreeWalker.g:511:11: ( NOT )? c_term
			{
			// WreslTreeWalker.g:511:11: ( NOT )?
			int alt31=2;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==NOT) ) {
				alt31=1;
			}
			switch (alt31) {
				case 1 :
					// WreslTreeWalker.g:511:11: NOT
					{
					match(input,NOT,FOLLOW_NOT_in_c_unary2300); if (state.failed) return;
					}
					break;

			}

			pushFollow(FOLLOW_c_term_in_c_unary2303);
			c_term();
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
	// $ANTLR end "c_unary"



	// $ANTLR start "logical"
	// WreslTreeWalker.g:513:1: logical : c_unary ( bin c_unary )* ;
	public final void logical() throws RecognitionException {
		try {
			// WreslTreeWalker.g:513:9: ( c_unary ( bin c_unary )* )
			// WreslTreeWalker.g:513:12: c_unary ( bin c_unary )*
			{
			pushFollow(FOLLOW_c_unary_in_logical2315);
			c_unary();
			state._fsp--;
			if (state.failed) return;
			// WreslTreeWalker.g:513:20: ( bin c_unary )*
			loop32:
			while (true) {
				int alt32=2;
				int LA32_0 = input.LA(1);
				if ( (LA32_0==AND||LA32_0==OR) ) {
					alt32=1;
				}

				switch (alt32) {
				case 1 :
					// WreslTreeWalker.g:513:22: bin c_unary
					{
					pushFollow(FOLLOW_bin_in_logical2319);
					bin();
					state._fsp--;
					if (state.failed) return;
					pushFollow(FOLLOW_c_unary_in_logical2321);
					c_unary();
					state._fsp--;
					if (state.failed) return;
					}
					break;

				default :
					break loop32;
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
	// $ANTLR end "logical"



	// $ANTLR start "relation"
	// WreslTreeWalker.g:515:1: relation : ( '>' | '<' | '>=' | '<=' | '==' | '/=' );
	public final void relation() throws RecognitionException {
		try {
			// WreslTreeWalker.g:515:10: ( '>' | '<' | '>=' | '<=' | '==' | '/=' )
			// WreslTreeWalker.g:
			{
			if ( (input.LA(1) >= 146 && input.LA(1) <= 148)||(input.LA(1) >= 150 && input.LA(1) <= 152) ) {
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
	// $ANTLR end "relation"



	// $ANTLR start "bin"
	// WreslTreeWalker.g:517:1: bin : ( OR | AND );
	public final void bin() throws RecognitionException {
		try {
			// WreslTreeWalker.g:517:5: ( OR | AND )
			// WreslTreeWalker.g:
			{
			if ( input.LA(1)==AND||input.LA(1)==OR ) {
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
	// $ANTLR end "bin"

	// $ANTLR start synpred1_WreslTreeWalker
	public final void synpred1_WreslTreeWalker_fragment() throws RecognitionException {
		// WreslTreeWalker.g:507:4: ( expression relation expression )
		// WreslTreeWalker.g:507:6: expression relation expression
		{
		pushFollow(FOLLOW_expression_in_synpred1_WreslTreeWalker2253);
		expression();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_relation_in_synpred1_WreslTreeWalker2255);
		relation();
		state._fsp--;
		if (state.failed) return;
		pushFollow(FOLLOW_expression_in_synpred1_WreslTreeWalker2257);
		expression();
		state._fsp--;
		if (state.failed) return;
		}

	}
	// $ANTLR end synpred1_WreslTreeWalker

	// $ANTLR start synpred2_WreslTreeWalker
	public final void synpred2_WreslTreeWalker_fragment() throws RecognitionException {
		// WreslTreeWalker.g:508:4: ( '(' logical ')' )
		// WreslTreeWalker.g:508:6: '(' logical ')'
		{
		match(input,139,FOLLOW_139_in_synpred2_WreslTreeWalker2274); if (state.failed) return;
		pushFollow(FOLLOW_logical_in_synpred2_WreslTreeWalker2276);
		logical();
		state._fsp--;
		if (state.failed) return;
		match(input,140,FOLLOW_140_in_synpred2_WreslTreeWalker2278); if (state.failed) return;
		}

	}
	// $ANTLR end synpred2_WreslTreeWalker

	// Delegated rules

	public final boolean synpred2_WreslTreeWalker() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_WreslTreeWalker_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_WreslTreeWalker() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_WreslTreeWalker_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_pattern_in_evaluator68 = new BitSet(new long[]{0x080E0045E0000080L,0x0003F80000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_sequence_in_evaluator81 = new BitSet(new long[]{0x0000000000000000L,0x0000002000001000L});
	public static final BitSet FOLLOW_model_in_evaluator85 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_EOF_in_evaluator100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dvar_in_pattern111 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_in_pattern115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goal_in_pattern119 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_includeFile_in_pattern123 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alias_in_pattern127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_weight_table_in_pattern131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_external_in_pattern135 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_in_pattern139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_timeArray_in_pattern144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_std_in_integer155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_nonStd_in_integer159 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_timeArray_std_in_integer163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_timeArray_nonStd_in_integer167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Dvar_integer_in_integer_std182 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Scope_in_integer_std186 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_integer_std190 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_Kind_in_integer_std194 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_Units_in_integer_std198 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Dvar_integer_in_integer_nonStd222 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Scope_in_integer_nonStd226 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_integer_nonStd230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_Lower_in_integer_nonStd232 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_LimitType_in_integer_nonStd236 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_Upper_in_integer_nonStd238 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_LimitType_in_integer_nonStd242 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_Kind_in_integer_nonStd246 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_Units_in_integer_nonStd250 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Dvar_integer_in_integer_timeArray_std275 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TimeArraySize_in_integer_timeArray_std279 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Scope_in_integer_timeArray_std283 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_integer_timeArray_std287 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_Kind_in_integer_timeArray_std291 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_Units_in_integer_timeArray_std295 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Dvar_integer_in_integer_timeArray_nonStd323 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TimeArraySize_in_integer_timeArray_nonStd327 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Scope_in_integer_timeArray_nonStd331 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_integer_timeArray_nonStd335 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_Lower_in_integer_timeArray_nonStd337 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_LimitType_in_integer_timeArray_nonStd341 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_Upper_in_integer_timeArray_nonStd343 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_LimitType_in_integer_timeArray_nonStd347 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_Kind_in_integer_timeArray_nonStd351 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_Units_in_integer_timeArray_nonStd355 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_External_in_external381 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Scope_in_external385 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_external389 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_Expression_in_external393 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Sequence_in_sequence413 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_sequence417 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_Model_in_sequence419 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_sequence423 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
	public static final BitSet FOLLOW_Order_in_sequence425 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_INTEGER_in_sequence429 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_Condition_in_sequence433 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_TIMESTEP_in_sequence437 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Model_in_model461 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_model465 = new BitSet(new long[]{0x080E0045E0000080L,0x0003F80000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_pattern_in_model489 = new BitSet(new long[]{0x080E0045E0000088L,0x0003F80000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_Include_in_includeFile509 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Scope_in_includeFile513 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_FILE_PATH_in_includeFile517 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Weight_table_in_weight_table534 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Scope_in_weight_table538 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_weight_table545 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TimeArraySize_in_weight_table549 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_Expression_in_weight_table553 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_goal_simple_in_goal599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goal_nocase_in_goal603 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goal_case_in_goal607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dvar_std_in_dvar616 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dvar_nonStd_in_dvar620 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dvar_timeArray_std_in_dvar624 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dvar_timeArray_nonStd_in_dvar628 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_dss_in_svar639 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_expr_in_svar643 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_sum_in_svar647 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_table_in_svar651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_case_in_svar655 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_timeArray_expr_in_svar_timeArray663 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_timeArray_case_in_svar_timeArray667 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_timeArray_table_in_svar_timeArray670 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_timeArray_sum_in_svar_timeArray674 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SvarTimeArray_case_in_svar_timeArray_case691 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TimeArraySize_in_svar_timeArray_case695 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Dependants_in_svar_timeArray_case699 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Scope_in_svar_timeArray_case703 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_timeArray_case707 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_case_content_in_svar_timeArray_case714 = new BitSet(new long[]{0x0000000000020008L});
	public static final BitSet FOLLOW_Svar_case_in_svar_case755 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Scope_in_svar_case759 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_case763 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_case_content_in_svar_case770 = new BitSet(new long[]{0x0000000000020008L});
	public static final BitSet FOLLOW_Case_in_case_content811 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_case_content815 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_Condition_in_case_content819 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Dependants_in_case_content823 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_VarInCycle_in_case_content827 = new BitSet(new long[]{0x0000000000000000L,0x0000040020000000L,0x0000000000000001L});
	public static final BitSet FOLLOW_table_content_in_case_content836 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Value_in_case_content847 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Dependants_in_case_content852 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_VarInCycle_in_case_content856 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_sum_content_in_case_content865 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SELECT_in_table_content904 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_table_content908 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_FROM_in_table_content910 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_table_content914 = new BitSet(new long[]{0x0000200000000008L,0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_GIVEN_in_table_content923 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assignment_in_table_content927 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Dependants_in_table_content931 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_VarInCycle_in_table_content935 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
	public static final BitSet FOLLOW_USE_in_table_content937 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_table_content941 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_WHERE_in_table_content952 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_where_items_in_table_content956 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Dependants_in_table_content960 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Assignment_in_where_items1000 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_143_in_where_items1005 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_Assignment_in_where_items1009 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000008000L});
	public static final BitSet FOLLOW_alias_simple_in_alias1026 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alias_timeArray_simple_in_alias1028 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Alias_in_alias_simple1037 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Scope_in_alias_simple1041 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_alias_simple1045 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_Expression_in_alias_simple1049 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_Kind_in_alias_simple1053 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_Units_in_alias_simple1057 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Dependants_in_alias_simple1061 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_VarInCycle_in_alias_simple1065 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Alias_in_alias_timeArray_simple1085 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TimeArraySize_in_alias_timeArray_simple1089 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Scope_in_alias_timeArray_simple1093 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_alias_timeArray_simple1097 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_Expression_in_alias_timeArray_simple1101 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_Kind_in_alias_timeArray_simple1105 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_Units_in_alias_timeArray_simple1109 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Dependants_in_alias_timeArray_simple1113 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_VarInCycle_in_alias_timeArray_simple1117 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Goal_simple_in_goal_simple1144 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TimeArraySize_in_goal_simple1149 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Scope_in_goal_simple1156 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_goal_simple1162 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Dependants_in_goal_simple1166 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_Constraint_content_in_goal_simple1170 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_VarInCycle_in_goal_simple1174 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Goal_no_case_in_goal_nocase1207 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TimeArraySize_in_goal_nocase1212 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Scope_in_goal_nocase1219 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_goal_nocase1225 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Dependants_in_goal_nocase1230 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_VarInCycle_in_goal_nocase1234 = new BitSet(new long[]{0x0000000000000000L,0x0040008000100000L});
	public static final BitSet FOLLOW_goal_contents_in_goal_nocase1253 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Goal_case_in_goal_case1294 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TimeArraySize_in_goal_case1299 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Scope_in_goal_case1306 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_goal_case1312 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_Case_in_goal_case1335 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_IDENT_in_goal_case1339 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_Condition_in_goal_case1343 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Dependants_in_goal_case1347 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_VarInCycle_in_goal_case1351 = new BitSet(new long[]{0x0000000000000000L,0x0040008000100000L});
	public static final BitSet FOLLOW_goal_contents_in_goal_case1355 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_goal_contents_process_2_in_goal_contents1401 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goal_contents_process_1_in_goal_contents1406 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goal_content_simple_in_goal_contents1412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_One_in_goal_contents_process_11439 = new BitSet(new long[]{0x0000080000080000L,0x0000000001000000L});
	public static final BitSet FOLLOW_goal_content_in_goal_contents_process_11443 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Two_in_goal_contents_process_21464 = new BitSet(new long[]{0x0000080000080000L,0x0000000001000000L});
	public static final BitSet FOLLOW_goal_content_in_goal_contents_process_21468 = new BitSet(new long[]{0x0000080000080000L,0x0000000001000000L});
	public static final BitSet FOLLOW_goal_content_in_goal_contents_process_21472 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_goal_content1499 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Lhs_in_goal_content1517 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_Op_in_goal_content1521 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_Rhs_in_goal_content1525 = new BitSet(new long[]{0x0000000000000002L,0x0000004000000000L});
	public static final BitSet FOLLOW_Sign_in_goal_content1531 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_Kind_in_goal_content1534 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_Slack_Surplus_in_goal_content1539 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
	public static final BitSet FOLLOW_Weight_in_goal_content1544 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Simple_in_goal_content_simple1578 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_Lhs_in_goal_content_simple1583 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_Op_in_goal_content_simple1587 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_Rhs_in_goal_content_simple1591 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Svar_table_in_svar_table1612 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Scope_in_svar_table1616 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_table1620 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_table_content_in_svar_table1624 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Svar_table_in_svar_timeArray_table1647 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TimeArraySize_in_svar_timeArray_table1651 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Scope_in_svar_timeArray_table1655 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_timeArray_table1659 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
	public static final BitSet FOLLOW_table_content_in_svar_timeArray_table1663 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Svar_sum_in_svar_sum1689 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Scope_in_svar_sum1693 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_sum1697 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
	public static final BitSet FOLLOW_sum_content_in_svar_sum1701 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Svar_sum_in_svar_timeArray_sum1727 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TimeArraySize_in_svar_timeArray_sum1731 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Scope_in_svar_timeArray_sum1735 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_timeArray_sum1739 = new BitSet(new long[]{0x0000000000000000L,0x0000040000000000L});
	public static final BitSet FOLLOW_sum_content_in_svar_timeArray_sum1743 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Sum_hdr_in_sum_content1768 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Expression_in_sum_content1772 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Dependants_in_sum_content1776 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_VarInCycle_in_sum_content1780 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Svar_const_in_svar_expr1801 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Scope_in_svar_expr1805 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_expr1809 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_Expression_in_svar_expr1813 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Dependants_in_svar_expr1817 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_VarInCycle_in_svar_expr1821 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_SvarTimeArray_const_in_svar_timeArray_expr1844 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TimeArraySize_in_svar_timeArray_expr1848 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Scope_in_svar_timeArray_expr1852 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_timeArray_expr1856 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_Expression_in_svar_timeArray_expr1860 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_Dependants_in_svar_timeArray_expr1864 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000002L});
	public static final BitSet FOLLOW_VarInCycle_in_svar_timeArray_expr1868 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Svar_dss_in_svar_dss1893 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Scope_in_svar_dss1897 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_svar_dss1901 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_B_part_in_svar_dss1905 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_Kind_in_svar_dss1907 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_svar_dss1911 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_Units_in_svar_dss1913 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_svar_dss1917 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_CONVERT_in_svar_dss1921 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Dvar_std_in_dvar_std1951 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Scope_in_dvar_std1955 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_dvar_std1959 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_Kind_in_dvar_std1961 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_dvar_std1965 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_Units_in_dvar_std1967 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_dvar_std1971 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_Dvar_nonStd_in_dvar_nonStd1997 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_Scope_in_dvar_nonStd2001 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_dvar_nonStd2005 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_Lower_in_dvar_nonStd2007 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_LimitType_in_dvar_nonStd2011 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_Upper_in_dvar_nonStd2013 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_LimitType_in_dvar_nonStd2017 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_Kind_in_dvar_nonStd2019 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_dvar_nonStd2023 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_Units_in_dvar_nonStd2025 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_dvar_nonStd2029 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DvarTimeArray_std_in_dvar_timeArray_std2055 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TimeArraySize_in_dvar_timeArray_std2059 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Scope_in_dvar_timeArray_std2063 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_dvar_timeArray_std2067 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_Kind_in_dvar_timeArray_std2069 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_dvar_timeArray_std2073 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_Units_in_dvar_timeArray_std2075 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_dvar_timeArray_std2079 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_DvarTimeArray_nonStd_in_dvar_timeArray_nonStd2108 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_TimeArraySize_in_dvar_timeArray_nonStd2112 = new BitSet(new long[]{0x0000000000000000L,0x0000000400000000L});
	public static final BitSet FOLLOW_Scope_in_dvar_timeArray_nonStd2116 = new BitSet(new long[]{0x0010000000000000L});
	public static final BitSet FOLLOW_IDENT_in_dvar_timeArray_nonStd2120 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_Lower_in_dvar_timeArray_nonStd2122 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_LimitType_in_dvar_timeArray_nonStd2126 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_Upper_in_dvar_timeArray_nonStd2128 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_LimitType_in_dvar_timeArray_nonStd2132 = new BitSet(new long[]{0x2000000000000000L});
	public static final BitSet FOLLOW_Kind_in_dvar_timeArray_nonStd2134 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_dvar_timeArray_nonStd2138 = new BitSet(new long[]{0x0000000000000000L,0x1000000000000000L});
	public static final BitSet FOLLOW_Units_in_dvar_timeArray_nonStd2140 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_STRING_in_dvar_timeArray_nonStd2144 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IDENT_in_term2164 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_term2169 = new BitSet(new long[]{0x0110000000000000L,0x0000000000002000L,0x0000000000000800L});
	public static final BitSet FOLLOW_expression_in_term2171 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_term2173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_term2178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEGATION_in_unary2189 = new BitSet(new long[]{0x0110000000000000L,0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_term_in_unary2192 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unary_in_mult2202 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000022000L});
	public static final BitSet FOLLOW_set_in_mult2205 = new BitSet(new long[]{0x0110000000000000L,0x0000000000002000L,0x0000000000000800L});
	public static final BitSet FOLLOW_unary_in_mult2214 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000022000L});
	public static final BitSet FOLLOW_mult_in_expression2227 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000014000L});
	public static final BitSet FOLLOW_set_in_expression2230 = new BitSet(new long[]{0x0110000000000000L,0x0000000000002000L,0x0000000000000800L});
	public static final BitSet FOLLOW_mult_in_expression2238 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000014000L});
	public static final BitSet FOLLOW_expression_in_c_term2263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001DC0000L});
	public static final BitSet FOLLOW_relation_in_c_term2265 = new BitSet(new long[]{0x0110000000000000L,0x0000000000002000L,0x0000000000000800L});
	public static final BitSet FOLLOW_expression_in_c_term2267 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_c_term2284 = new BitSet(new long[]{0x0110000000000000L,0x000000000000A000L,0x0000000000000800L});
	public static final BitSet FOLLOW_logical_in_c_term2286 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_c_term2288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NOT_in_c_unary2300 = new BitSet(new long[]{0x0110000000000000L,0x0000000000002000L,0x0000000000000800L});
	public static final BitSet FOLLOW_c_term_in_c_unary2303 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_c_unary_in_logical2315 = new BitSet(new long[]{0x0000000000000042L,0x0000000000040000L});
	public static final BitSet FOLLOW_bin_in_logical2319 = new BitSet(new long[]{0x0110000000000000L,0x000000000000A000L,0x0000000000000800L});
	public static final BitSet FOLLOW_c_unary_in_logical2321 = new BitSet(new long[]{0x0000000000000042L,0x0000000000040000L});
	public static final BitSet FOLLOW_expression_in_synpred1_WreslTreeWalker2253 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000001DC0000L});
	public static final BitSet FOLLOW_relation_in_synpred1_WreslTreeWalker2255 = new BitSet(new long[]{0x0110000000000000L,0x0000000000002000L,0x0000000000000800L});
	public static final BitSet FOLLOW_expression_in_synpred1_WreslTreeWalker2257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_139_in_synpred2_WreslTreeWalker2274 = new BitSet(new long[]{0x0110000000000000L,0x000000000000A000L,0x0000000000000800L});
	public static final BitSet FOLLOW_logical_in_synpred2_WreslTreeWalker2276 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000001000L});
	public static final BitSet FOLLOW_140_in_synpred2_WreslTreeWalker2278 = new BitSet(new long[]{0x0000000000000002L});
}
