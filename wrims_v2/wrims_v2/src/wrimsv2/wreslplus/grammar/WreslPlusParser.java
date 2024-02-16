// $ANTLR 3.5.2 WreslPlus.g 2024-02-12 13:11:30

  package wrimsv2.wreslplus.grammar;
  import wrimsv2.wreslparser.elements.LogUtils; 
  import java.util.HashMap;
  import java.util.LinkedHashMap;
  import java.util.Set;
  import java.util.HashSet;
  import java.util.LinkedHashSet;
  import wrimsv2.wreslplus.elements.Tools;
  import wrimsv2.wreslplus.elements.IncFileTemp;
  import wrimsv2.wreslplus.elements.IfIncItemGroup;
  import wrimsv2.wreslplus.elements.TimeseriesTemp;
  import wrimsv2.wreslplus.elements.ExternalTemp;
  import wrimsv2.wreslplus.elements.DvarTemp;
  import wrimsv2.wreslplus.elements.SvarTemp;
  import wrimsv2.wreslplus.elements.ParamTemp;
  import wrimsv2.wreslplus.elements.WeightTable;
  import wrimsv2.wreslplus.elements.WeightSubgroup;
  import wrimsv2.wreslplus.elements.AliasTemp;
  import wrimsv2.wreslplus.elements.GoalTemp;
  import wrimsv2.wreslplus.elements.GoalHS;
  import wrimsv2.wreslplus.elements.GoalCase;
  import wrimsv2.wreslplus.elements.ModelTemp;
  import wrimsv2.wreslplus.elements.SequenceTemp;
  import wrimsv2.wreslplus.elements.StudyTemp;
  import wrimsv2.wreslplus.elements.VarCycleIndex;
  import wrimsv2.commondata.wresldata.Param;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class WreslPlusParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACOS", "ACOT", "ALIAS", "ALWAYS", 
		"AND", "ASIN", "ATAN", "BINARY", "CASE", "CFS_TAF", "CONDITION", "CONFIG", 
		"CONVERT", "COS", "COT", "Const", "DAY", "DEFINE", "DVAR", "DeviationPenalty", 
		"DeviationTolerance", "Digit", "EXCEEDANCE", "EXCEEDANCE_TSI", "EXTERNAL", 
		"Else", "Elseif", "FALSE", "FLOW", "FROM", "GIVEN", "GOAL", "GROUP", "ID", 
		"INCLUDE", "INFLOW", "INT", "INTEGER", "INT_word", "If", "Initial", "KIND", 
		"LABEL", "LHS", "LOCAL", "LOG", "LOWER", "Letter", "MAX", "MIN", "ML_COMMENT", 
		"MOD", "MODEL", "MONTH", "NAME", "NETWORK", "NODE", "NOT", "NOT_EQUAL", 
		"NoSolver", "OBJECTIVE", "OR", "ORDER", "OUTFLOW", "PENALTY", "QUOTE", 
		"RANGE", "REAL", "RHS", "ROUND", "SELECT", "SEQUENCE", "SIN", "SL_COMMENT", 
		"SORTING", "STD", "SUM", "SVAR", "TAF_CFS", "TAN", "TEMPLATE", "TIMESERIES", 
		"TIMESTEP", "TIMESTEPVALUE", "TRUE", "UNBOUNDED", "UNITS", "UPPER", "USE", 
		"VALUE", "VARIABLE", "WATERYEAR", "WEIGHT", "WHERE", "WS", "'$M'", "'$m'", 
		"'%dvar'", "'%svar'", "'('", "')'", "'*'", "'+'", "','", "'-'", "'.'", 
		"'/'", "'/='", "':'", "'<'", "'<='", "'='", "'=='", "'>'", "'>='", "'['", 
		"']'", "'constrain'", "'extern:('", "'i'", "'table'", "'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__99=99;
	public static final int T__100=100;
	public static final int T__101=101;
	public static final int T__102=102;
	public static final int T__103=103;
	public static final int T__104=104;
	public static final int T__105=105;
	public static final int T__106=106;
	public static final int T__107=107;
	public static final int T__108=108;
	public static final int T__109=109;
	public static final int T__110=110;
	public static final int T__111=111;
	public static final int T__112=112;
	public static final int T__113=113;
	public static final int T__114=114;
	public static final int T__115=115;
	public static final int T__116=116;
	public static final int T__117=117;
	public static final int T__118=118;
	public static final int T__119=119;
	public static final int T__120=120;
	public static final int T__121=121;
	public static final int T__122=122;
	public static final int T__123=123;
	public static final int T__124=124;
	public static final int T__125=125;
	public static final int T__126=126;
	public static final int ACOS=4;
	public static final int ACOT=5;
	public static final int ALIAS=6;
	public static final int ALWAYS=7;
	public static final int AND=8;
	public static final int ASIN=9;
	public static final int ATAN=10;
	public static final int BINARY=11;
	public static final int CASE=12;
	public static final int CFS_TAF=13;
	public static final int CONDITION=14;
	public static final int CONFIG=15;
	public static final int CONVERT=16;
	public static final int COS=17;
	public static final int COT=18;
	public static final int Const=19;
	public static final int DAY=20;
	public static final int DEFINE=21;
	public static final int DVAR=22;
	public static final int DeviationPenalty=23;
	public static final int DeviationTolerance=24;
	public static final int Digit=25;
	public static final int EXCEEDANCE=26;
	public static final int EXCEEDANCE_TSI=27;
	public static final int EXTERNAL=28;
	public static final int Else=29;
	public static final int Elseif=30;
	public static final int FALSE=31;
	public static final int FLOW=32;
	public static final int FROM=33;
	public static final int GIVEN=34;
	public static final int GOAL=35;
	public static final int GROUP=36;
	public static final int ID=37;
	public static final int INCLUDE=38;
	public static final int INFLOW=39;
	public static final int INT=40;
	public static final int INTEGER=41;
	public static final int INT_word=42;
	public static final int If=43;
	public static final int Initial=44;
	public static final int KIND=45;
	public static final int LABEL=46;
	public static final int LHS=47;
	public static final int LOCAL=48;
	public static final int LOG=49;
	public static final int LOWER=50;
	public static final int Letter=51;
	public static final int MAX=52;
	public static final int MIN=53;
	public static final int ML_COMMENT=54;
	public static final int MOD=55;
	public static final int MODEL=56;
	public static final int MONTH=57;
	public static final int NAME=58;
	public static final int NETWORK=59;
	public static final int NODE=60;
	public static final int NOT=61;
	public static final int NOT_EQUAL=62;
	public static final int NoSolver=63;
	public static final int OBJECTIVE=64;
	public static final int OR=65;
	public static final int ORDER=66;
	public static final int OUTFLOW=67;
	public static final int PENALTY=68;
	public static final int QUOTE=69;
	public static final int RANGE=70;
	public static final int REAL=71;
	public static final int RHS=72;
	public static final int ROUND=73;
	public static final int SELECT=74;
	public static final int SEQUENCE=75;
	public static final int SIN=76;
	public static final int SL_COMMENT=77;
	public static final int SORTING=78;
	public static final int STD=79;
	public static final int SUM=80;
	public static final int SVAR=81;
	public static final int TAF_CFS=82;
	public static final int TAN=83;
	public static final int TEMPLATE=84;
	public static final int TIMESERIES=85;
	public static final int TIMESTEP=86;
	public static final int TIMESTEPVALUE=87;
	public static final int TRUE=88;
	public static final int UNBOUNDED=89;
	public static final int UNITS=90;
	public static final int UPPER=91;
	public static final int USE=92;
	public static final int VALUE=93;
	public static final int VARIABLE=94;
	public static final int WATERYEAR=95;
	public static final int WEIGHT=96;
	public static final int WHERE=97;
	public static final int WS=98;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public WreslPlusParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public WreslPlusParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return WreslPlusParser.tokenNames; }
	@Override public String getGrammarFileName() { return "WreslPlus.g"; }


		public CommonTree commonTree;
		public String currentAbsolutePath;
	  	public String currentAbsoluteParent;
	  	public String pathRelativeToRunDir;
	  	public StudyTemp styObj;
	  	public ModelTemp mObj;
	  	public Set<String> dependants;
	  	public Set<Integer> dependantTypes; 
	  	public Set<String> dependants_notAllowed;
	  	public Set<String> varInCycle;
	  	public Map<String, HashSet<String>> neededCycleVarMap;
	  	boolean addDep = true;
	  	boolean isParameter = false;
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


	public static class wreslFile_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "wreslFile"
	// WreslPlus.g:86:1: wreslFile : ( ( '{' t= mt '}' EOF ) | (t= mt EOF ) );
	public final WreslPlusParser.wreslFile_return wreslFile() throws RecognitionException {
		WreslPlusParser.wreslFile_return retval = new WreslPlusParser.wreslFile_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal1=null;
		Token char_literal2=null;
		Token EOF3=null;
		Token EOF4=null;
		ParserRuleReturnScope t =null;

		CommonTree char_literal1_tree=null;
		CommonTree char_literal2_tree=null;
		CommonTree EOF3_tree=null;
		CommonTree EOF4_tree=null;

		try {
			// WreslPlus.g:88:2: ( ( '{' t= mt '}' EOF ) | (t= mt EOF ) )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==125) ) {
				alt1=1;
			}
			else if ( (LA1_0==ALIAS||(LA1_0 >= DEFINE && LA1_0 <= DVAR)||LA1_0==GOAL||LA1_0==INCLUDE||LA1_0==If||LA1_0==NETWORK||LA1_0==OBJECTIVE||LA1_0==SVAR||LA1_0==TIMESERIES) ) {
				alt1=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// WreslPlus.g:88:4: ( '{' t= mt '}' EOF )
					{
					root_0 = (CommonTree)adaptor.nil();


					// WreslPlus.g:88:4: ( '{' t= mt '}' EOF )
					// WreslPlus.g:88:5: '{' t= mt '}' EOF
					{
					char_literal1=(Token)match(input,125,FOLLOW_125_in_wreslFile76); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal1_tree = (CommonTree)adaptor.create(char_literal1);
					adaptor.addChild(root_0, char_literal1_tree);
					}

					pushFollow(FOLLOW_mt_in_wreslFile80);
					t=mt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

					char_literal2=(Token)match(input,126,FOLLOW_126_in_wreslFile82); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal2_tree = (CommonTree)adaptor.create(char_literal2);
					adaptor.addChild(root_0, char_literal2_tree);
					}

					EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_wreslFile84); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EOF3_tree = (CommonTree)adaptor.create(EOF3);
					adaptor.addChild(root_0, EOF3_tree);
					}

					}

					}
					break;
				case 2 :
					// WreslPlus.g:88:26: (t= mt EOF )
					{
					root_0 = (CommonTree)adaptor.nil();


					// WreslPlus.g:88:26: (t= mt EOF )
					// WreslPlus.g:88:28: t= mt EOF
					{
					pushFollow(FOLLOW_mt_in_wreslFile94);
					t=mt();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

					EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_wreslFile96); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					EOF4_tree = (CommonTree)adaptor.create(EOF4);
					adaptor.addChild(root_0, EOF4_tree);
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
			if ( state.backtracking==0 ) { mObj = (t!=null?((WreslPlusParser.mt_return)t).modelObj:null);}
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
	// $ANTLR end "wreslFile"


	protected static class wreslMain_scope {
		StudyTemp sty;
	}
	protected Stack<wreslMain_scope> wreslMain_stack = new Stack<wreslMain_scope>();

	public static class wreslMain_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "wreslMain"
	// WreslPlus.g:90:1: wreslMain : ( initial )? (seq= sequence )+ (g= group )* (m= model )+ EOF ;
	public final WreslPlusParser.wreslMain_return wreslMain() throws RecognitionException {
		wreslMain_stack.push(new wreslMain_scope());
		WreslPlusParser.wreslMain_return retval = new WreslPlusParser.wreslMain_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EOF6=null;
		ParserRuleReturnScope seq =null;
		ParserRuleReturnScope g =null;
		ParserRuleReturnScope m =null;
		ParserRuleReturnScope initial5 =null;

		CommonTree EOF6_tree=null;

		  wreslMain_stack.peek().sty = new StudyTemp();
		try {
			// WreslPlus.g:95:2: ( ( initial )? (seq= sequence )+ (g= group )* (m= model )+ EOF )
			// WreslPlus.g:96:4: ( initial )? (seq= sequence )+ (g= group )* (m= model )+ EOF
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:96:4: ( initial )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==Initial) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// WreslPlus.g:96:4: initial
					{
					pushFollow(FOLLOW_initial_in_wreslMain127);
					initial5=initial();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, initial5.getTree());

					}
					break;

			}

			// WreslPlus.g:97:2: (seq= sequence )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==SEQUENCE) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// WreslPlus.g:97:4: seq= sequence
					{
					pushFollow(FOLLOW_sequence_in_wreslMain135);
					seq=sequence();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, seq.getTree());

					if ( state.backtracking==0 ) { wreslMain_stack.peek().sty.seqList.add((seq!=null?((WreslPlusParser.sequence_return)seq).id:null)); wreslMain_stack.peek().sty.seqMap.put((seq!=null?((WreslPlusParser.sequence_return)seq).id:null),(seq!=null?((WreslPlusParser.sequence_return)seq).seqObj:null));  }
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

			// WreslPlus.g:98:2: (g= group )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==GROUP) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// WreslPlus.g:98:4: g= group
					{
					pushFollow(FOLLOW_group_in_wreslMain151);
					g=group();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, g.getTree());

					if ( state.backtracking==0 ) { wreslMain_stack.peek().sty.modelList.add((g!=null?((WreslPlusParser.group_return)g).id:null)); wreslMain_stack.peek().sty.modelMap.put((g!=null?((WreslPlusParser.group_return)g).id:null), (g!=null?((WreslPlusParser.group_return)g).modelObj:null));  }
					}
					break;

				default :
					break loop4;
				}
			}

			// WreslPlus.g:99:2: (m= model )+
			int cnt5=0;
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==MODEL) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// WreslPlus.g:99:4: m= model
					{
					pushFollow(FOLLOW_model_in_wreslMain171);
					m=model();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, m.getTree());

					if ( state.backtracking==0 ) { wreslMain_stack.peek().sty.modelList.add((m!=null?((WreslPlusParser.model_return)m).id:null)); wreslMain_stack.peek().sty.modelMap.put((m!=null?((WreslPlusParser.model_return)m).id:null), (m!=null?((WreslPlusParser.model_return)m).modelObj:null));  }
					}
					break;

				default :
					if ( cnt5 >= 1 ) break loop5;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(5, input);
					throw eee;
				}
				cnt5++;
			}

			EOF6=(Token)match(input,EOF,FOLLOW_EOF_in_wreslMain188); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			EOF6_tree = (CommonTree)adaptor.create(EOF6);
			adaptor.addChild(root_0, EOF6_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { styObj = wreslMain_stack.peek().sty; }
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			wreslMain_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "wreslMain"


	public static class local_deprecated_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "local_deprecated"
	// WreslPlus.g:102:1: local_deprecated : '[' LOCAL ']' ;
	public final WreslPlusParser.local_deprecated_return local_deprecated() throws RecognitionException {
		WreslPlusParser.local_deprecated_return retval = new WreslPlusParser.local_deprecated_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal7=null;
		Token LOCAL8=null;
		Token char_literal9=null;

		CommonTree char_literal7_tree=null;
		CommonTree LOCAL8_tree=null;
		CommonTree char_literal9_tree=null;

		try {
			// WreslPlus.g:103:3: ( '[' LOCAL ']' )
			// WreslPlus.g:103:5: '[' LOCAL ']'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal7=(Token)match(input,119,FOLLOW_119_in_local_deprecated199); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal7_tree = (CommonTree)adaptor.create(char_literal7);
			adaptor.addChild(root_0, char_literal7_tree);
			}

			LOCAL8=(Token)match(input,LOCAL,FOLLOW_LOCAL_in_local_deprecated201); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LOCAL8_tree = (CommonTree)adaptor.create(LOCAL8);
			adaptor.addChild(root_0, LOCAL8_tree);
			}

			char_literal9=(Token)match(input,120,FOLLOW_120_in_local_deprecated203); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal9_tree = (CommonTree)adaptor.create(char_literal9);
			adaptor.addChild(root_0, char_literal9_tree);
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
	// $ANTLR end "local_deprecated"


	public static class initial_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "initial"
	// WreslPlus.g:106:1: initial : Initial '{' ( (c= constant ) | (s= svar_initial ) )+ '}' ;
	public final WreslPlusParser.initial_return initial() throws RecognitionException {
		WreslPlusParser.initial_return retval = new WreslPlusParser.initial_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Initial10=null;
		Token char_literal11=null;
		Token char_literal12=null;
		ParserRuleReturnScope c =null;
		ParserRuleReturnScope s =null;

		CommonTree Initial10_tree=null;
		CommonTree char_literal11_tree=null;
		CommonTree char_literal12_tree=null;

		  isParameter=true; 
		try {
			// WreslPlus.g:109:3: ( Initial '{' ( (c= constant ) | (s= svar_initial ) )+ '}' )
			// WreslPlus.g:110:3: Initial '{' ( (c= constant ) | (s= svar_initial ) )+ '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			Initial10=(Token)match(input,Initial,FOLLOW_Initial_in_initial232); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			Initial10_tree = (CommonTree)adaptor.create(Initial10);
			adaptor.addChild(root_0, Initial10_tree);
			}

			char_literal11=(Token)match(input,125,FOLLOW_125_in_initial234); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal11_tree = (CommonTree)adaptor.create(char_literal11);
			adaptor.addChild(root_0, char_literal11_tree);
			}

			// WreslPlus.g:112:5: ( (c= constant ) | (s= svar_initial ) )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=3;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==Const) ) {
					alt6=1;
				}
				else if ( (LA6_0==SVAR) ) {
					alt6=2;
				}

				switch (alt6) {
				case 1 :
					// WreslPlus.g:113:9: (c= constant )
					{
					// WreslPlus.g:113:9: (c= constant )
					// WreslPlus.g:113:11: c= constant
					{
					pushFollow(FOLLOW_constant_in_initial260);
					c=constant();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());

					if ( state.backtracking==0 ) {wreslMain_stack.peek().sty.parameterList.add((c!=null?((WreslPlusParser.constant_return)c).id:null)); wreslMain_stack.peek().sty.parameterConstList.add((c!=null?((WreslPlusParser.constant_return)c).id:null)); wreslMain_stack.peek().sty.parameterMap.put((c!=null?((WreslPlusParser.constant_return)c).id:null), (c!=null?((WreslPlusParser.constant_return)c).ptObj:null));}
					}

					}
					break;
				case 2 :
					// WreslPlus.g:114:9: (s= svar_initial )
					{
					// WreslPlus.g:114:9: (s= svar_initial )
					// WreslPlus.g:114:11: s= svar_initial
					{
					pushFollow(FOLLOW_svar_initial_in_initial280);
					s=svar_initial();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, s.getTree());

					if ( state.backtracking==0 ) {wreslMain_stack.peek().sty.parameterList.add((s!=null?((WreslPlusParser.svar_initial_return)s).id:null)); wreslMain_stack.peek().sty.parameterMap.put((s!=null?((WreslPlusParser.svar_initial_return)s).id:null), (s!=null?((WreslPlusParser.svar_initial_return)s).svObj:null));}
					}

					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			char_literal12=(Token)match(input,126,FOLLOW_126_in_initial296); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal12_tree = (CommonTree)adaptor.create(char_literal12);
			adaptor.addChild(root_0, char_literal12_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {  isParameter=false; }
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
	// $ANTLR end "initial"


	public static class constant_return extends ParserRuleReturnScope {
		public String id;
		public SvarTemp ptObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "constant"
	// WreslPlus.g:120:1: constant returns [String id, SvarTemp ptObj] : Const i= ID '{' n= number '}' ;
	public final WreslPlusParser.constant_return constant() throws RecognitionException {
		WreslPlusParser.constant_return retval = new WreslPlusParser.constant_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token Const13=null;
		Token char_literal14=null;
		Token char_literal15=null;
		ParserRuleReturnScope n =null;

		CommonTree i_tree=null;
		CommonTree Const13_tree=null;
		CommonTree char_literal14_tree=null;
		CommonTree char_literal15_tree=null;

		  retval.ptObj = new SvarTemp();
		        dependants = new LinkedHashSet<String>(); 
		try {
			// WreslPlus.g:123:3: ( Const i= ID '{' n= number '}' )
			// WreslPlus.g:123:5: Const i= ID '{' n= number '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			Const13=(Token)match(input,Const,FOLLOW_Const_in_constant315); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			Const13_tree = (CommonTree)adaptor.create(Const13);
			adaptor.addChild(root_0, Const13_tree);
			}

			i=(Token)match(input,ID,FOLLOW_ID_in_constant319); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			char_literal14=(Token)match(input,125,FOLLOW_125_in_constant321); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal14_tree = (CommonTree)adaptor.create(char_literal14);
			adaptor.addChild(root_0, char_literal14_tree);
			}

			pushFollow(FOLLOW_number_in_constant325);
			n=number();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, n.getTree());

			char_literal15=(Token)match(input,126,FOLLOW_126_in_constant327); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal15_tree = (CommonTree)adaptor.create(char_literal15);
			adaptor.addChild(root_0, char_literal15_tree);
			}

			if ( state.backtracking==0 ) { 
			            retval.id = (i!=null?i.getText():null);
			            retval.ptObj.id = (i!=null?i.getText():null);
			            retval.ptObj.caseName.add(Param.defaultCaseName);
			            retval.ptObj.caseCondition.add(Param.always);
			            retval.ptObj.caseExpression.add((n!=null?input.toString(n.start,n.stop):null));
			            retval.ptObj.dependants = dependants;

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
	// $ANTLR end "constant"


	public static class svar_initial_return extends ParserRuleReturnScope {
		public String id;
		public SvarTemp svObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_initial"
	// WreslPlus.g:135:1: svar_initial returns [String id, SvarTemp svObj] : SVAR svar_g ;
	public final WreslPlusParser.svar_initial_return svar_initial() throws RecognitionException {
		WreslPlusParser.svar_initial_return retval = new WreslPlusParser.svar_initial_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SVAR16=null;
		ParserRuleReturnScope svar_g17 =null;

		CommonTree SVAR16_tree=null;

		  dependants = new LinkedHashSet<String>(); 
		        dependantTypes = new LinkedHashSet<Integer>();
		        dependants_notAllowed = new LinkedHashSet<String>(); 
		try {
			// WreslPlus.g:139:3: ( SVAR svar_g )
			// WreslPlus.g:139:6: SVAR svar_g
			{
			root_0 = (CommonTree)adaptor.nil();


			SVAR16=(Token)match(input,SVAR,FOLLOW_SVAR_in_svar_initial361); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SVAR16_tree = (CommonTree)adaptor.create(SVAR16);
			adaptor.addChild(root_0, SVAR16_tree);
			}

			pushFollow(FOLLOW_svar_g_in_svar_initial364);
			svar_g17=svar_g();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_g17.getTree());

			if ( state.backtracking==0 ) { retval.id =(svar_g17!=null?((WreslPlusParser.svar_g_return)svar_g17).id:null);  retval.svObj =(svar_g17!=null?((WreslPlusParser.svar_g_return)svar_g17).svObj:null); retval.svObj.dependants_notAllowed=dependants_notAllowed;  }
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
	// $ANTLR end "svar_initial"


	public static class expression_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expression_simple"
	// WreslPlus.g:143:1: expression_simple : expr_add_simple ;
	public final WreslPlusParser.expression_simple_return expression_simple() throws RecognitionException {
		WreslPlusParser.expression_simple_return retval = new WreslPlusParser.expression_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr_add_simple18 =null;


		 dependants = new LinkedHashSet<String>(); 
		try {
			// WreslPlus.g:145:3: ( expr_add_simple )
			// WreslPlus.g:145:5: expr_add_simple
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_add_simple_in_expression_simple404);
			expr_add_simple18=expr_add_simple();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple18.getTree());

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
	// $ANTLR end "expression_simple"


	public static class template_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "template"
	// WreslPlus.g:157:1: template : TEMPLATE ID '{' ( template_svar | template_dvar | template_dvar_array )* '}' ;
	public final WreslPlusParser.template_return template() throws RecognitionException {
		WreslPlusParser.template_return retval = new WreslPlusParser.template_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token TEMPLATE19=null;
		Token ID20=null;
		Token char_literal21=null;
		Token char_literal25=null;
		ParserRuleReturnScope template_svar22 =null;
		ParserRuleReturnScope template_dvar23 =null;
		ParserRuleReturnScope template_dvar_array24 =null;

		CommonTree TEMPLATE19_tree=null;
		CommonTree ID20_tree=null;
		CommonTree char_literal21_tree=null;
		CommonTree char_literal25_tree=null;

		try {
			// WreslPlus.g:157:10: ( TEMPLATE ID '{' ( template_svar | template_dvar | template_dvar_array )* '}' )
			// WreslPlus.g:157:12: TEMPLATE ID '{' ( template_svar | template_dvar | template_dvar_array )* '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			TEMPLATE19=(Token)match(input,TEMPLATE,FOLLOW_TEMPLATE_in_template443); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			TEMPLATE19_tree = (CommonTree)adaptor.create(TEMPLATE19);
			adaptor.addChild(root_0, TEMPLATE19_tree);
			}

			ID20=(Token)match(input,ID,FOLLOW_ID_in_template445); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID20_tree = (CommonTree)adaptor.create(ID20);
			adaptor.addChild(root_0, ID20_tree);
			}

			char_literal21=(Token)match(input,125,FOLLOW_125_in_template447); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal21_tree = (CommonTree)adaptor.create(char_literal21);
			adaptor.addChild(root_0, char_literal21_tree);
			}

			// WreslPlus.g:157:28: ( template_svar | template_dvar | template_dvar_array )*
			loop7:
			while (true) {
				int alt7=4;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==102) ) {
					alt7=1;
				}
				else if ( (LA7_0==101) ) {
					int LA7_3 = input.LA(2);
					if ( (LA7_3==ID) ) {
						alt7=2;
					}
					else if ( (LA7_3==119) ) {
						alt7=3;
					}

				}

				switch (alt7) {
				case 1 :
					// WreslPlus.g:157:30: template_svar
					{
					pushFollow(FOLLOW_template_svar_in_template451);
					template_svar22=template_svar();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, template_svar22.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:157:46: template_dvar
					{
					pushFollow(FOLLOW_template_dvar_in_template455);
					template_dvar23=template_dvar();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, template_dvar23.getTree());

					}
					break;
				case 3 :
					// WreslPlus.g:157:62: template_dvar_array
					{
					pushFollow(FOLLOW_template_dvar_array_in_template459);
					template_dvar_array24=template_dvar_array();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, template_dvar_array24.getTree());

					}
					break;

				default :
					break loop7;
				}
			}

			char_literal25=(Token)match(input,126,FOLLOW_126_in_template465); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal25_tree = (CommonTree)adaptor.create(char_literal25);
			adaptor.addChild(root_0, char_literal25_tree);
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
	// $ANTLR end "template"


	public static class template_dvar_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "template_dvar"
	// WreslPlus.g:159:1: template_dvar : '%dvar' varID '{' dvar_trunk '}' ;
	public final WreslPlusParser.template_dvar_return template_dvar() throws RecognitionException {
		WreslPlusParser.template_dvar_return retval = new WreslPlusParser.template_dvar_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal26=null;
		Token char_literal28=null;
		Token char_literal30=null;
		ParserRuleReturnScope varID27 =null;
		ParserRuleReturnScope dvar_trunk29 =null;

		CommonTree string_literal26_tree=null;
		CommonTree char_literal28_tree=null;
		CommonTree char_literal30_tree=null;

		try {
			// WreslPlus.g:159:15: ( '%dvar' varID '{' dvar_trunk '}' )
			// WreslPlus.g:159:17: '%dvar' varID '{' dvar_trunk '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal26=(Token)match(input,101,FOLLOW_101_in_template_dvar474); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal26_tree = (CommonTree)adaptor.create(string_literal26);
			adaptor.addChild(root_0, string_literal26_tree);
			}

			pushFollow(FOLLOW_varID_in_template_dvar476);
			varID27=varID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, varID27.getTree());

			char_literal28=(Token)match(input,125,FOLLOW_125_in_template_dvar478); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal28_tree = (CommonTree)adaptor.create(char_literal28);
			adaptor.addChild(root_0, char_literal28_tree);
			}

			pushFollow(FOLLOW_dvar_trunk_in_template_dvar480);
			dvar_trunk29=dvar_trunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, dvar_trunk29.getTree());

			char_literal30=(Token)match(input,126,FOLLOW_126_in_template_dvar482); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal30_tree = (CommonTree)adaptor.create(char_literal30);
			adaptor.addChild(root_0, char_literal30_tree);
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
	// $ANTLR end "template_dvar"


	public static class template_dvar_array_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "template_dvar_array"
	// WreslPlus.g:161:1: template_dvar_array : '%dvar' dimension varID '{' dvar_trunk '}' ;
	public final WreslPlusParser.template_dvar_array_return template_dvar_array() throws RecognitionException {
		WreslPlusParser.template_dvar_array_return retval = new WreslPlusParser.template_dvar_array_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal31=null;
		Token char_literal34=null;
		Token char_literal36=null;
		ParserRuleReturnScope dimension32 =null;
		ParserRuleReturnScope varID33 =null;
		ParserRuleReturnScope dvar_trunk35 =null;

		CommonTree string_literal31_tree=null;
		CommonTree char_literal34_tree=null;
		CommonTree char_literal36_tree=null;

		try {
			// WreslPlus.g:161:21: ( '%dvar' dimension varID '{' dvar_trunk '}' )
			// WreslPlus.g:161:23: '%dvar' dimension varID '{' dvar_trunk '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal31=(Token)match(input,101,FOLLOW_101_in_template_dvar_array491); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal31_tree = (CommonTree)adaptor.create(string_literal31);
			adaptor.addChild(root_0, string_literal31_tree);
			}

			pushFollow(FOLLOW_dimension_in_template_dvar_array493);
			dimension32=dimension();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, dimension32.getTree());

			pushFollow(FOLLOW_varID_in_template_dvar_array495);
			varID33=varID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, varID33.getTree());

			char_literal34=(Token)match(input,125,FOLLOW_125_in_template_dvar_array497); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal34_tree = (CommonTree)adaptor.create(char_literal34);
			adaptor.addChild(root_0, char_literal34_tree);
			}

			pushFollow(FOLLOW_dvar_trunk_in_template_dvar_array499);
			dvar_trunk35=dvar_trunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, dvar_trunk35.getTree());

			char_literal36=(Token)match(input,126,FOLLOW_126_in_template_dvar_array501); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal36_tree = (CommonTree)adaptor.create(char_literal36);
			adaptor.addChild(root_0, char_literal36_tree);
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
	// $ANTLR end "template_dvar_array"


	public static class template_svar_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "template_svar"
	// WreslPlus.g:163:1: template_svar : '%svar' varID svar_trunk ;
	public final WreslPlusParser.template_svar_return template_svar() throws RecognitionException {
		WreslPlusParser.template_svar_return retval = new WreslPlusParser.template_svar_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal37=null;
		ParserRuleReturnScope varID38 =null;
		ParserRuleReturnScope svar_trunk39 =null;

		CommonTree string_literal37_tree=null;

		try {
			// WreslPlus.g:163:15: ( '%svar' varID svar_trunk )
			// WreslPlus.g:163:17: '%svar' varID svar_trunk
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal37=(Token)match(input,102,FOLLOW_102_in_template_svar510); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal37_tree = (CommonTree)adaptor.create(string_literal37);
			adaptor.addChild(root_0, string_literal37_tree);
			}

			pushFollow(FOLLOW_varID_in_template_svar512);
			varID38=varID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, varID38.getTree());

			pushFollow(FOLLOW_svar_trunk_in_template_svar515);
			svar_trunk39=svar_trunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_trunk39.getTree());

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
	// $ANTLR end "template_svar"


	public static class sequence_return extends ParserRuleReturnScope {
		public String id;
		public SequenceTemp seqObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "sequence"
	// WreslPlus.g:165:1: sequence returns [String id, SequenceTemp seqObj] : SEQUENCE i= ID '{' MODEL m= ID ( ( CONDITION cc= logical_main ORDER o= INT ) | ( ORDER o= INT ( CONDITION cc= logical_main )? ) ) ( TIMESTEP t= TIMESTEPVALUE )? '}' ;
	public final WreslPlusParser.sequence_return sequence() throws RecognitionException {
		WreslPlusParser.sequence_return retval = new WreslPlusParser.sequence_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token m=null;
		Token o=null;
		Token t=null;
		Token SEQUENCE40=null;
		Token char_literal41=null;
		Token MODEL42=null;
		Token CONDITION43=null;
		Token ORDER44=null;
		Token ORDER45=null;
		Token CONDITION46=null;
		Token TIMESTEP47=null;
		Token char_literal48=null;
		ParserRuleReturnScope cc =null;

		CommonTree i_tree=null;
		CommonTree m_tree=null;
		CommonTree o_tree=null;
		CommonTree t_tree=null;
		CommonTree SEQUENCE40_tree=null;
		CommonTree char_literal41_tree=null;
		CommonTree MODEL42_tree=null;
		CommonTree CONDITION43_tree=null;
		CommonTree ORDER44_tree=null;
		CommonTree ORDER45_tree=null;
		CommonTree CONDITION46_tree=null;
		CommonTree TIMESTEP47_tree=null;
		CommonTree char_literal48_tree=null;

		retval.seqObj = new SequenceTemp();
		       dependants = new LinkedHashSet<String>();
		       retval.seqObj.fromWresl = this.currentAbsolutePath; 
		       
		       // for condition expression if previous cycle var is used
		       neededCycleVarMap = new HashMap<String, HashSet<String>>();
		       
		try {
			// WreslPlus.g:179:2: ( SEQUENCE i= ID '{' MODEL m= ID ( ( CONDITION cc= logical_main ORDER o= INT ) | ( ORDER o= INT ( CONDITION cc= logical_main )? ) ) ( TIMESTEP t= TIMESTEPVALUE )? '}' )
			// WreslPlus.g:179:4: SEQUENCE i= ID '{' MODEL m= ID ( ( CONDITION cc= logical_main ORDER o= INT ) | ( ORDER o= INT ( CONDITION cc= logical_main )? ) ) ( TIMESTEP t= TIMESTEPVALUE )? '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			SEQUENCE40=(Token)match(input,SEQUENCE,FOLLOW_SEQUENCE_in_sequence555); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SEQUENCE40_tree = (CommonTree)adaptor.create(SEQUENCE40);
			adaptor.addChild(root_0, SEQUENCE40_tree);
			}

			i=(Token)match(input,ID,FOLLOW_ID_in_sequence559); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) {retval.id =(i!=null?i.getText():null); retval.seqObj.id=(i!=null?i.getText():null);}
			char_literal41=(Token)match(input,125,FOLLOW_125_in_sequence566); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal41_tree = (CommonTree)adaptor.create(char_literal41);
			adaptor.addChild(root_0, char_literal41_tree);
			}

			MODEL42=(Token)match(input,MODEL,FOLLOW_MODEL_in_sequence568); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MODEL42_tree = (CommonTree)adaptor.create(MODEL42);
			adaptor.addChild(root_0, MODEL42_tree);
			}

			m=(Token)match(input,ID,FOLLOW_ID_in_sequence572); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			m_tree = (CommonTree)adaptor.create(m);
			adaptor.addChild(root_0, m_tree);
			}

			// WreslPlus.g:181:6: ( ( CONDITION cc= logical_main ORDER o= INT ) | ( ORDER o= INT ( CONDITION cc= logical_main )? ) )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==CONDITION) ) {
				alt9=1;
			}
			else if ( (LA9_0==ORDER) ) {
				alt9=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// WreslPlus.g:181:7: ( CONDITION cc= logical_main ORDER o= INT )
					{
					// WreslPlus.g:181:7: ( CONDITION cc= logical_main ORDER o= INT )
					// WreslPlus.g:181:9: CONDITION cc= logical_main ORDER o= INT
					{
					CONDITION43=(Token)match(input,CONDITION,FOLLOW_CONDITION_in_sequence583); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					CONDITION43_tree = (CommonTree)adaptor.create(CONDITION43);
					adaptor.addChild(root_0, CONDITION43_tree);
					}

					pushFollow(FOLLOW_logical_main_in_sequence587);
					cc=logical_main();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, cc.getTree());

					if ( state.backtracking==0 ) {retval.seqObj.condition=(cc!=null?input.toString(cc.start,cc.stop):null);}
					ORDER44=(Token)match(input,ORDER,FOLLOW_ORDER_in_sequence591); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ORDER44_tree = (CommonTree)adaptor.create(ORDER44);
					adaptor.addChild(root_0, ORDER44_tree);
					}

					o=(Token)match(input,INT,FOLLOW_INT_in_sequence595); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					o_tree = (CommonTree)adaptor.create(o);
					adaptor.addChild(root_0, o_tree);
					}

					}

					}
					break;
				case 2 :
					// WreslPlus.g:182:7: ( ORDER o= INT ( CONDITION cc= logical_main )? )
					{
					// WreslPlus.g:182:7: ( ORDER o= INT ( CONDITION cc= logical_main )? )
					// WreslPlus.g:182:9: ORDER o= INT ( CONDITION cc= logical_main )?
					{
					ORDER45=(Token)match(input,ORDER,FOLLOW_ORDER_in_sequence612); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ORDER45_tree = (CommonTree)adaptor.create(ORDER45);
					adaptor.addChild(root_0, ORDER45_tree);
					}

					o=(Token)match(input,INT,FOLLOW_INT_in_sequence616); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					o_tree = (CommonTree)adaptor.create(o);
					adaptor.addChild(root_0, o_tree);
					}

					// WreslPlus.g:182:21: ( CONDITION cc= logical_main )?
					int alt8=2;
					int LA8_0 = input.LA(1);
					if ( (LA8_0==CONDITION) ) {
						alt8=1;
					}
					switch (alt8) {
						case 1 :
							// WreslPlus.g:182:22: CONDITION cc= logical_main
							{
							CONDITION46=(Token)match(input,CONDITION,FOLLOW_CONDITION_in_sequence619); if (state.failed) return retval;
							if ( state.backtracking==0 ) {
							CONDITION46_tree = (CommonTree)adaptor.create(CONDITION46);
							adaptor.addChild(root_0, CONDITION46_tree);
							}

							pushFollow(FOLLOW_logical_main_in_sequence623);
							cc=logical_main();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, cc.getTree());

							if ( state.backtracking==0 ) {retval.seqObj.condition=(cc!=null?input.toString(cc.start,cc.stop):null);}
							}
							break;

					}

					}

					}
					break;

			}

			// WreslPlus.g:183:6: ( TIMESTEP t= TIMESTEPVALUE )?
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==TIMESTEP) ) {
				alt10=1;
			}
			switch (alt10) {
				case 1 :
					// WreslPlus.g:183:8: TIMESTEP t= TIMESTEPVALUE
					{
					TIMESTEP47=(Token)match(input,TIMESTEP,FOLLOW_TIMESTEP_in_sequence640); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TIMESTEP47_tree = (CommonTree)adaptor.create(TIMESTEP47);
					adaptor.addChild(root_0, TIMESTEP47_tree);
					}

					t=(Token)match(input,TIMESTEPVALUE,FOLLOW_TIMESTEPVALUE_in_sequence644); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					t_tree = (CommonTree)adaptor.create(t);
					adaptor.addChild(root_0, t_tree);
					}

					if ( state.backtracking==0 ) {retval.seqObj.timeStep=(t!=null?t.getText():null).toUpperCase();}
					}
					break;

			}

			char_literal48=(Token)match(input,126,FOLLOW_126_in_sequence658); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal48_tree = (CommonTree)adaptor.create(char_literal48);
			adaptor.addChild(root_0, char_literal48_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {retval.seqObj.model=(m!=null?m.getText():null); retval.seqObj.order=(o!=null?o.getText():null);
			       retval.seqObj.dependants= dependants; retval.seqObj.line=line;
			       retval.seqObj.neededCycleVarMap = neededCycleVarMap;
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


	public static class group_return extends ParserRuleReturnScope {
		public String id;
		public ModelTemp modelObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "group"
	// WreslPlus.g:189:1: group returns [String id, ModelTemp modelObj] : GROUP i= ID '{' t= mt '}' ;
	public final WreslPlusParser.group_return group() throws RecognitionException {
		WreslPlusParser.group_return retval = new WreslPlusParser.group_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token GROUP49=null;
		Token char_literal50=null;
		Token char_literal51=null;
		ParserRuleReturnScope t =null;

		CommonTree i_tree=null;
		CommonTree GROUP49_tree=null;
		CommonTree char_literal50_tree=null;
		CommonTree char_literal51_tree=null;

		try {
			// WreslPlus.g:190:3: ( GROUP i= ID '{' t= mt '}' )
			// WreslPlus.g:190:3: GROUP i= ID '{' t= mt '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			GROUP49=(Token)match(input,GROUP,FOLLOW_GROUP_in_group674); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			GROUP49_tree = (CommonTree)adaptor.create(GROUP49);
			adaptor.addChild(root_0, GROUP49_tree);
			}

			i=(Token)match(input,ID,FOLLOW_ID_in_group678); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) {retval.id =(i!=null?i.getText():null);}
			char_literal50=(Token)match(input,125,FOLLOW_125_in_group682); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal50_tree = (CommonTree)adaptor.create(char_literal50);
			adaptor.addChild(root_0, char_literal50_tree);
			}

			pushFollow(FOLLOW_mt_in_group686);
			t=mt();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

			char_literal51=(Token)match(input,126,FOLLOW_126_in_group688); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal51_tree = (CommonTree)adaptor.create(char_literal51);
			adaptor.addChild(root_0, char_literal51_tree);
			}

			if ( state.backtracking==0 ) {retval.modelObj =(t!=null?((WreslPlusParser.mt_return)t).modelObj:null); retval.modelObj.id=retval.id;}
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
	// $ANTLR end "group"


	public static class model_standalone_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "model_standalone"
	// WreslPlus.g:194:1: model_standalone : model ;
	public final WreslPlusParser.model_standalone_return model_standalone() throws RecognitionException {
		WreslPlusParser.model_standalone_return retval = new WreslPlusParser.model_standalone_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope model52 =null;


		try {
			// WreslPlus.g:194:18: ( model )
			// WreslPlus.g:194:20: model
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_model_in_model_standalone701);
			model52=model();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, model52.getTree());

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
	// $ANTLR end "model_standalone"


	public static class model_return extends ParserRuleReturnScope {
		public String id;
		public ModelTemp modelObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "model"
	// WreslPlus.g:196:1: model returns [String id, ModelTemp modelObj] : MODEL i= modelName '{' t= mt '}' ;
	public final WreslPlusParser.model_return model() throws RecognitionException {
		WreslPlusParser.model_return retval = new WreslPlusParser.model_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token MODEL53=null;
		Token char_literal54=null;
		Token char_literal55=null;
		ParserRuleReturnScope i =null;
		ParserRuleReturnScope t =null;

		CommonTree MODEL53_tree=null;
		CommonTree char_literal54_tree=null;
		CommonTree char_literal55_tree=null;

		try {
			// WreslPlus.g:197:3: ( MODEL i= modelName '{' t= mt '}' )
			// WreslPlus.g:197:3: MODEL i= modelName '{' t= mt '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			MODEL53=(Token)match(input,MODEL,FOLLOW_MODEL_in_model713); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			MODEL53_tree = (CommonTree)adaptor.create(MODEL53);
			adaptor.addChild(root_0, MODEL53_tree);
			}

			pushFollow(FOLLOW_modelName_in_model717);
			i=modelName();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, i.getTree());

			if ( state.backtracking==0 ) {retval.id =(i!=null?input.toString(i.start,i.stop):null);}
			char_literal54=(Token)match(input,125,FOLLOW_125_in_model726); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal54_tree = (CommonTree)adaptor.create(char_literal54);
			adaptor.addChild(root_0, char_literal54_tree);
			}

			pushFollow(FOLLOW_mt_in_model730);
			t=mt();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

			char_literal55=(Token)match(input,126,FOLLOW_126_in_model732); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal55_tree = (CommonTree)adaptor.create(char_literal55);
			adaptor.addChild(root_0, char_literal55_tree);
			}

			if ( state.backtracking==0 ) {retval.modelObj =(t!=null?((WreslPlusParser.mt_return)t).modelObj:null); retval.modelObj.id=retval.id;}
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


	public static class modelName_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "modelName"
	// WreslPlus.g:202:1: modelName : ID ;
	public final WreslPlusParser.modelName_return modelName() throws RecognitionException {
		WreslPlusParser.modelName_return retval = new WreslPlusParser.modelName_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID56=null;

		CommonTree ID56_tree=null;

		try {
			// WreslPlus.g:202:10: ( ID )
			// WreslPlus.g:202:12: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			ID56=(Token)match(input,ID,FOLLOW_ID_in_modelName751); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID56_tree = (CommonTree)adaptor.create(ID56);
			adaptor.addChild(root_0, ID56_tree);
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
	// $ANTLR end "modelName"


	protected static class mt_scope {
		ModelTemp m_;
	}
	protected Stack<mt_scope> mt_stack = new Stack<mt_scope>();

	public static class mt_return extends ParserRuleReturnScope {
		public ModelTemp modelObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "mt"
	// WreslPlus.g:205:1: mt returns [ModelTemp modelObj] : (fi= include_file |ts= timeseries |sv= svar_group |dv= dvar_g |ex= ex_g |as= alias |gl1= goal_s |gl2= goal_hs | network |wt= weight |im= include_model |ifig= if_inc_items )+ ;
	public final WreslPlusParser.mt_return mt() throws RecognitionException {
		mt_stack.push(new mt_scope());
		WreslPlusParser.mt_return retval = new WreslPlusParser.mt_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope fi =null;
		ParserRuleReturnScope ts =null;
		ParserRuleReturnScope sv =null;
		ParserRuleReturnScope dv =null;
		ParserRuleReturnScope ex =null;
		ParserRuleReturnScope as =null;
		ParserRuleReturnScope gl1 =null;
		ParserRuleReturnScope gl2 =null;
		ParserRuleReturnScope wt =null;
		ParserRuleReturnScope im =null;
		ParserRuleReturnScope ifig =null;
		ParserRuleReturnScope network57 =null;


		 neededCycleVarMap = new HashMap<String, HashSet<String>>();
		       mt_stack.peek().m_ = new ModelTemp(); 
			   mt_stack.peek().m_.absPath = currentAbsolutePath; 
			   mt_stack.peek().m_.parentAbsPath = currentAbsoluteParent; 
		try {
			// WreslPlus.g:215:5: ( (fi= include_file |ts= timeseries |sv= svar_group |dv= dvar_g |ex= ex_g |as= alias |gl1= goal_s |gl2= goal_hs | network |wt= weight |im= include_model |ifig= if_inc_items )+ )
			// WreslPlus.g:216:5: (fi= include_file |ts= timeseries |sv= svar_group |dv= dvar_g |ex= ex_g |as= alias |gl1= goal_s |gl2= goal_hs | network |wt= weight |im= include_model |ifig= if_inc_items )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:216:5: (fi= include_file |ts= timeseries |sv= svar_group |dv= dvar_g |ex= ex_g |as= alias |gl1= goal_s |gl2= goal_hs | network |wt= weight |im= include_model |ifig= if_inc_items )+
			int cnt11=0;
			loop11:
			while (true) {
				int alt11=13;
				switch ( input.LA(1) ) {
				case INCLUDE:
					{
					int LA11_2 = input.LA(2);
					if ( (LA11_2==GROUP||LA11_2==MODEL) ) {
						alt11=11;
					}
					else if ( (LA11_2==QUOTE||LA11_2==119) ) {
						alt11=1;
					}

					}
					break;
				case TIMESERIES:
					{
					alt11=2;
					}
					break;
				case DEFINE:
					{
					switch ( input.LA(2) ) {
					case 119:
						{
						int LA11_14 = input.LA(3);
						if ( (LA11_14==LOCAL) ) {
							int LA11_20 = input.LA(4);
							if ( (LA11_20==120) ) {
								switch ( input.LA(5) ) {
								case ID:
									{
									int LA11_15 = input.LA(6);
									if ( (LA11_15==125) ) {
										switch ( input.LA(7) ) {
										case TIMESERIES:
											{
											alt11=2;
											}
											break;
										case EXTERNAL:
											{
											alt11=5;
											}
											break;
										case ALIAS:
											{
											alt11=6;
											}
											break;
										case CASE:
										case SELECT:
										case SUM:
										case VALUE:
										case 124:
											{
											alt11=3;
											}
											break;
										case BINARY:
										case INTEGER:
										case LOWER:
										case STD:
										case UPPER:
										case 113:
											{
											alt11=4;
											}
											break;
										}
									}

									}
									break;
								case 119:
									{
									int LA11_37 = input.LA(6);
									if ( (LA11_37==ID||LA11_37==INT) ) {
										int LA11_21 = input.LA(7);
										if ( (LA11_21==120) ) {
											int LA11_29 = input.LA(8);
											if ( (LA11_29==ID) ) {
												int LA11_38 = input.LA(9);
												if ( (LA11_38==125) ) {
													switch ( input.LA(10) ) {
													case ALIAS:
														{
														alt11=6;
														}
														break;
													case CASE:
													case SELECT:
													case SUM:
													case VALUE:
													case 124:
														{
														alt11=3;
														}
														break;
													case BINARY:
													case INTEGER:
													case LOWER:
													case STD:
													case UPPER:
													case 113:
														{
														alt11=4;
														}
														break;
													}
												}

											}

										}

									}

									}
									break;
								case 103:
									{
									int LA11_16 = input.LA(6);
									if ( (LA11_16==ID||LA11_16==INT) ) {
										int LA11_23 = input.LA(7);
										if ( (LA11_23==104) ) {
											int LA11_31 = input.LA(8);
											if ( (LA11_31==ID) ) {
												int LA11_39 = input.LA(9);
												if ( (LA11_39==125) ) {
													switch ( input.LA(10) ) {
													case ALIAS:
														{
														alt11=6;
														}
														break;
													case CASE:
													case SELECT:
													case SUM:
													case VALUE:
													case 124:
														{
														alt11=3;
														}
														break;
													case BINARY:
													case INTEGER:
													case LOWER:
													case STD:
													case UPPER:
													case 113:
														{
														alt11=4;
														}
														break;
													}
												}

											}

										}

									}

									}
									break;
								}
							}

						}
						else if ( (LA11_14==ID||LA11_14==INT) ) {
							int LA11_21 = input.LA(4);
							if ( (LA11_21==120) ) {
								int LA11_29 = input.LA(5);
								if ( (LA11_29==ID) ) {
									int LA11_38 = input.LA(6);
									if ( (LA11_38==125) ) {
										switch ( input.LA(7) ) {
										case ALIAS:
											{
											alt11=6;
											}
											break;
										case CASE:
										case SELECT:
										case SUM:
										case VALUE:
										case 124:
											{
											alt11=3;
											}
											break;
										case BINARY:
										case INTEGER:
										case LOWER:
										case STD:
										case UPPER:
										case 113:
											{
											alt11=4;
											}
											break;
										}
									}

								}

							}

						}

						}
						break;
					case ID:
						{
						int LA11_15 = input.LA(3);
						if ( (LA11_15==125) ) {
							switch ( input.LA(4) ) {
							case TIMESERIES:
								{
								alt11=2;
								}
								break;
							case EXTERNAL:
								{
								alt11=5;
								}
								break;
							case ALIAS:
								{
								alt11=6;
								}
								break;
							case CASE:
							case SELECT:
							case SUM:
							case VALUE:
							case 124:
								{
								alt11=3;
								}
								break;
							case BINARY:
							case INTEGER:
							case LOWER:
							case STD:
							case UPPER:
							case 113:
								{
								alt11=4;
								}
								break;
							}
						}

						}
						break;
					case 103:
						{
						int LA11_16 = input.LA(3);
						if ( (LA11_16==ID||LA11_16==INT) ) {
							int LA11_23 = input.LA(4);
							if ( (LA11_23==104) ) {
								int LA11_31 = input.LA(5);
								if ( (LA11_31==ID) ) {
									int LA11_39 = input.LA(6);
									if ( (LA11_39==125) ) {
										switch ( input.LA(7) ) {
										case ALIAS:
											{
											alt11=6;
											}
											break;
										case CASE:
										case SELECT:
										case SUM:
										case VALUE:
										case 124:
											{
											alt11=3;
											}
											break;
										case BINARY:
										case INTEGER:
										case LOWER:
										case STD:
										case UPPER:
										case 113:
											{
											alt11=4;
											}
											break;
										}
									}

								}

							}

						}

						}
						break;
					}
					}
					break;
				case SVAR:
					{
					alt11=3;
					}
					break;
				case DVAR:
					{
					alt11=4;
					}
					break;
				case ALIAS:
					{
					alt11=6;
					}
					break;
				case GOAL:
					{
					switch ( input.LA(2) ) {
					case 119:
						{
						int LA11_17 = input.LA(3);
						if ( (LA11_17==LOCAL) ) {
							int LA11_24 = input.LA(4);
							if ( (LA11_24==120) ) {
								switch ( input.LA(5) ) {
								case 119:
									{
									int LA11_40 = input.LA(6);
									if ( (LA11_40==ID||LA11_40==INT) ) {
										int LA11_25 = input.LA(7);
										if ( (LA11_25==120) ) {
											int LA11_33 = input.LA(8);
											if ( (LA11_33==ID) ) {
												int LA11_19 = input.LA(9);
												if ( (LA11_19==125) ) {
													int LA11_27 = input.LA(10);
													if ( ((LA11_27 >= ACOS && LA11_27 <= ACOT)||(LA11_27 >= ASIN && LA11_27 <= ATAN)||LA11_27==CFS_TAF||(LA11_27 >= COS && LA11_27 <= COT)||LA11_27==DAY||(LA11_27 >= EXCEEDANCE && LA11_27 <= EXCEEDANCE_TSI)||LA11_27==ID||LA11_27==INT||LA11_27==INT_word||LA11_27==LOG||(LA11_27 >= MAX && LA11_27 <= MIN)||LA11_27==MOD||LA11_27==MONTH||LA11_27==REAL||LA11_27==ROUND||LA11_27==SIN||(LA11_27 >= TAF_CFS && LA11_27 <= TAN)||LA11_27==WATERYEAR||(LA11_27 >= 99 && LA11_27 <= 100)||LA11_27==103||LA11_27==106||LA11_27==108||(LA11_27 >= 122 && LA11_27 <= 124)) ) {
														alt11=7;
													}
													else if ( (LA11_27==LHS) ) {
														alt11=8;
													}

												}

											}

										}

									}

									}
									break;
								case 103:
									{
									int LA11_18 = input.LA(6);
									if ( (LA11_18==ID||LA11_18==INT) ) {
										int LA11_26 = input.LA(7);
										if ( (LA11_26==104) ) {
											int LA11_34 = input.LA(8);
											if ( (LA11_34==ID) ) {
												int LA11_19 = input.LA(9);
												if ( (LA11_19==125) ) {
													int LA11_27 = input.LA(10);
													if ( ((LA11_27 >= ACOS && LA11_27 <= ACOT)||(LA11_27 >= ASIN && LA11_27 <= ATAN)||LA11_27==CFS_TAF||(LA11_27 >= COS && LA11_27 <= COT)||LA11_27==DAY||(LA11_27 >= EXCEEDANCE && LA11_27 <= EXCEEDANCE_TSI)||LA11_27==ID||LA11_27==INT||LA11_27==INT_word||LA11_27==LOG||(LA11_27 >= MAX && LA11_27 <= MIN)||LA11_27==MOD||LA11_27==MONTH||LA11_27==REAL||LA11_27==ROUND||LA11_27==SIN||(LA11_27 >= TAF_CFS && LA11_27 <= TAN)||LA11_27==WATERYEAR||(LA11_27 >= 99 && LA11_27 <= 100)||LA11_27==103||LA11_27==106||LA11_27==108||(LA11_27 >= 122 && LA11_27 <= 124)) ) {
														alt11=7;
													}
													else if ( (LA11_27==LHS) ) {
														alt11=8;
													}

												}

											}

										}

									}

									}
									break;
								case ID:
									{
									int LA11_19 = input.LA(6);
									if ( (LA11_19==125) ) {
										int LA11_27 = input.LA(7);
										if ( ((LA11_27 >= ACOS && LA11_27 <= ACOT)||(LA11_27 >= ASIN && LA11_27 <= ATAN)||LA11_27==CFS_TAF||(LA11_27 >= COS && LA11_27 <= COT)||LA11_27==DAY||(LA11_27 >= EXCEEDANCE && LA11_27 <= EXCEEDANCE_TSI)||LA11_27==ID||LA11_27==INT||LA11_27==INT_word||LA11_27==LOG||(LA11_27 >= MAX && LA11_27 <= MIN)||LA11_27==MOD||LA11_27==MONTH||LA11_27==REAL||LA11_27==ROUND||LA11_27==SIN||(LA11_27 >= TAF_CFS && LA11_27 <= TAN)||LA11_27==WATERYEAR||(LA11_27 >= 99 && LA11_27 <= 100)||LA11_27==103||LA11_27==106||LA11_27==108||(LA11_27 >= 122 && LA11_27 <= 124)) ) {
											alt11=7;
										}
										else if ( (LA11_27==LHS) ) {
											alt11=8;
										}

									}

									}
									break;
								}
							}

						}
						else if ( (LA11_17==ID||LA11_17==INT) ) {
							int LA11_25 = input.LA(4);
							if ( (LA11_25==120) ) {
								int LA11_33 = input.LA(5);
								if ( (LA11_33==ID) ) {
									int LA11_19 = input.LA(6);
									if ( (LA11_19==125) ) {
										int LA11_27 = input.LA(7);
										if ( ((LA11_27 >= ACOS && LA11_27 <= ACOT)||(LA11_27 >= ASIN && LA11_27 <= ATAN)||LA11_27==CFS_TAF||(LA11_27 >= COS && LA11_27 <= COT)||LA11_27==DAY||(LA11_27 >= EXCEEDANCE && LA11_27 <= EXCEEDANCE_TSI)||LA11_27==ID||LA11_27==INT||LA11_27==INT_word||LA11_27==LOG||(LA11_27 >= MAX && LA11_27 <= MIN)||LA11_27==MOD||LA11_27==MONTH||LA11_27==REAL||LA11_27==ROUND||LA11_27==SIN||(LA11_27 >= TAF_CFS && LA11_27 <= TAN)||LA11_27==WATERYEAR||(LA11_27 >= 99 && LA11_27 <= 100)||LA11_27==103||LA11_27==106||LA11_27==108||(LA11_27 >= 122 && LA11_27 <= 124)) ) {
											alt11=7;
										}
										else if ( (LA11_27==LHS) ) {
											alt11=8;
										}

									}

								}

							}

						}

						}
						break;
					case 103:
						{
						int LA11_18 = input.LA(3);
						if ( (LA11_18==ID||LA11_18==INT) ) {
							int LA11_26 = input.LA(4);
							if ( (LA11_26==104) ) {
								int LA11_34 = input.LA(5);
								if ( (LA11_34==ID) ) {
									int LA11_19 = input.LA(6);
									if ( (LA11_19==125) ) {
										int LA11_27 = input.LA(7);
										if ( ((LA11_27 >= ACOS && LA11_27 <= ACOT)||(LA11_27 >= ASIN && LA11_27 <= ATAN)||LA11_27==CFS_TAF||(LA11_27 >= COS && LA11_27 <= COT)||LA11_27==DAY||(LA11_27 >= EXCEEDANCE && LA11_27 <= EXCEEDANCE_TSI)||LA11_27==ID||LA11_27==INT||LA11_27==INT_word||LA11_27==LOG||(LA11_27 >= MAX && LA11_27 <= MIN)||LA11_27==MOD||LA11_27==MONTH||LA11_27==REAL||LA11_27==ROUND||LA11_27==SIN||(LA11_27 >= TAF_CFS && LA11_27 <= TAN)||LA11_27==WATERYEAR||(LA11_27 >= 99 && LA11_27 <= 100)||LA11_27==103||LA11_27==106||LA11_27==108||(LA11_27 >= 122 && LA11_27 <= 124)) ) {
											alt11=7;
										}
										else if ( (LA11_27==LHS) ) {
											alt11=8;
										}

									}

								}

							}

						}

						}
						break;
					case ID:
						{
						int LA11_19 = input.LA(3);
						if ( (LA11_19==125) ) {
							int LA11_27 = input.LA(4);
							if ( ((LA11_27 >= ACOS && LA11_27 <= ACOT)||(LA11_27 >= ASIN && LA11_27 <= ATAN)||LA11_27==CFS_TAF||(LA11_27 >= COS && LA11_27 <= COT)||LA11_27==DAY||(LA11_27 >= EXCEEDANCE && LA11_27 <= EXCEEDANCE_TSI)||LA11_27==ID||LA11_27==INT||LA11_27==INT_word||LA11_27==LOG||(LA11_27 >= MAX && LA11_27 <= MIN)||LA11_27==MOD||LA11_27==MONTH||LA11_27==REAL||LA11_27==ROUND||LA11_27==SIN||(LA11_27 >= TAF_CFS && LA11_27 <= TAN)||LA11_27==WATERYEAR||(LA11_27 >= 99 && LA11_27 <= 100)||LA11_27==103||LA11_27==106||LA11_27==108||(LA11_27 >= 122 && LA11_27 <= 124)) ) {
								alt11=7;
							}
							else if ( (LA11_27==LHS) ) {
								alt11=8;
							}

						}

						}
						break;
					}
					}
					break;
				case NETWORK:
					{
					alt11=9;
					}
					break;
				case OBJECTIVE:
					{
					alt11=10;
					}
					break;
				case If:
					{
					alt11=12;
					}
					break;
				}
				switch (alt11) {
				case 1 :
					// WreslPlus.g:216:7: fi= include_file
					{
					pushFollow(FOLLOW_include_file_in_mt796);
					fi=include_file();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fi.getTree());

					if ( state.backtracking==0 ) {mt_stack.peek().m_.itemTypeList.add(Param.incFileType); mt_stack.peek().m_.itemList.add((fi!=null?((WreslPlusParser.include_file_return)fi).id:null)); mt_stack.peek().m_.incFileIDList.add((fi!=null?((WreslPlusParser.include_file_return)fi).id:null)); mt_stack.peek().m_.incFileMap.put((fi!=null?((WreslPlusParser.include_file_return)fi).id:null), (fi!=null?((WreslPlusParser.include_file_return)fi).incFileObj:null)); }
					}
					break;
				case 2 :
					// WreslPlus.g:217:7: ts= timeseries
					{
					pushFollow(FOLLOW_timeseries_in_mt808);
					ts=timeseries();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ts.getTree());

					if ( state.backtracking==0 ) {mt_stack.peek().m_.itemTypeList.add(Param.tsType);mt_stack.peek().m_.itemList.add((ts!=null?((WreslPlusParser.timeseries_return)ts).id:null)); mt_stack.peek().m_.tsList.add((ts!=null?((WreslPlusParser.timeseries_return)ts).id:null)); mt_stack.peek().m_.tsMap.put((ts!=null?((WreslPlusParser.timeseries_return)ts).id:null), (ts!=null?((WreslPlusParser.timeseries_return)ts).tsObj:null)); }
					}
					break;
				case 3 :
					// WreslPlus.g:218:7: sv= svar_group
					{
					pushFollow(FOLLOW_svar_group_in_mt822);
					sv=svar_group();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, sv.getTree());

					if ( state.backtracking==0 ) {mt_stack.peek().m_.itemTypeList.add(Param.svType);mt_stack.peek().m_.itemList.add((sv!=null?((WreslPlusParser.svar_group_return)sv).id:null)); mt_stack.peek().m_.svList.add((sv!=null?((WreslPlusParser.svar_group_return)sv).id:null)); mt_stack.peek().m_.svMap.put((sv!=null?((WreslPlusParser.svar_group_return)sv).id:null), (sv!=null?((WreslPlusParser.svar_group_return)sv).svObj:null)); }
					}
					break;
				case 4 :
					// WreslPlus.g:219:7: dv= dvar_g
					{
					pushFollow(FOLLOW_dvar_g_in_mt837);
					dv=dvar_g();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dv.getTree());

					if ( state.backtracking==0 ) {mt_stack.peek().m_.itemTypeList.add(Param.dvType);mt_stack.peek().m_.itemList.add((dv!=null?((WreslPlusParser.dvar_g_return)dv).id:null)); mt_stack.peek().m_.dvList.add((dv!=null?((WreslPlusParser.dvar_g_return)dv).id:null)); mt_stack.peek().m_.dvMap.put((dv!=null?((WreslPlusParser.dvar_g_return)dv).id:null), (dv!=null?((WreslPlusParser.dvar_g_return)dv).dvObj:null)); }
					}
					break;
				case 5 :
					// WreslPlus.g:220:7: ex= ex_g
					{
					pushFollow(FOLLOW_ex_g_in_mt856);
					ex=ex_g();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ex.getTree());

					if ( state.backtracking==0 ) {mt_stack.peek().m_.itemTypeList.add(Param.exType);mt_stack.peek().m_.itemList.add((ex!=null?((WreslPlusParser.ex_g_return)ex).id:null)); mt_stack.peek().m_.exList.add((ex!=null?((WreslPlusParser.ex_g_return)ex).id:null)); mt_stack.peek().m_.exMap.put((ex!=null?((WreslPlusParser.ex_g_return)ex).id:null), (ex!=null?((WreslPlusParser.ex_g_return)ex).exObj:null)); }
					}
					break;
				case 6 :
					// WreslPlus.g:221:7: as= alias
					{
					pushFollow(FOLLOW_alias_in_mt876);
					as=alias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, as.getTree());

					if ( state.backtracking==0 ) {mt_stack.peek().m_.itemTypeList.add(Param.asType);mt_stack.peek().m_.itemList.add((as!=null?((WreslPlusParser.alias_return)as).id:null)); mt_stack.peek().m_.asList.add((as!=null?((WreslPlusParser.alias_return)as).id:null)); mt_stack.peek().m_.asMap.put((as!=null?((WreslPlusParser.alias_return)as).id:null), (as!=null?((WreslPlusParser.alias_return)as).asObj:null)); }
					}
					break;
				case 7 :
					// WreslPlus.g:222:7: gl1= goal_s
					{
					pushFollow(FOLLOW_goal_s_in_mt895);
					gl1=goal_s();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, gl1.getTree());

					if ( state.backtracking==0 ) {mt_stack.peek().m_.itemTypeList.add(Param.gl1Type);mt_stack.peek().m_.itemList.add((gl1!=null?((WreslPlusParser.goal_s_return)gl1).id:null));mt_stack.peek().m_.glList.add((gl1!=null?((WreslPlusParser.goal_s_return)gl1).id:null));mt_stack.peek().m_.glMap.put((gl1!=null?((WreslPlusParser.goal_s_return)gl1).id:null), (gl1!=null?((WreslPlusParser.goal_s_return)gl1).glObj:null)); }
					}
					break;
				case 8 :
					// WreslPlus.g:223:7: gl2= goal_hs
					{
					pushFollow(FOLLOW_goal_hs_in_mt912);
					gl2=goal_hs();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, gl2.getTree());

					if ( state.backtracking==0 ) {mt_stack.peek().m_.itemTypeList.add(Param.gl2Type);mt_stack.peek().m_.itemList.add((gl2!=null?((WreslPlusParser.goal_hs_return)gl2).id:null));mt_stack.peek().m_.glList.add((gl2!=null?((WreslPlusParser.goal_hs_return)gl2).id:null));mt_stack.peek().m_.glMap.put((gl2!=null?((WreslPlusParser.goal_hs_return)gl2).id:null), (gl2!=null?((WreslPlusParser.goal_hs_return)gl2).glObj:null)); mt_stack.peek().m_.gl2List.add((gl2!=null?((WreslPlusParser.goal_hs_return)gl2).id:null)); }
					}
					break;
				case 9 :
					// WreslPlus.g:224:7: network
					{
					pushFollow(FOLLOW_network_in_mt926);
					network57=network();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, network57.getTree());

					}
					break;
				case 10 :
					// WreslPlus.g:225:7: wt= weight
					{
					pushFollow(FOLLOW_weight_in_mt938);
					wt=weight();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, wt.getTree());

					if ( state.backtracking==0 ) {mt_stack.peek().m_.wTableObjList.add((wt!=null?((WreslPlusParser.weight_return)wt).wtObj:null));}
					}
					break;
				case 11 :
					// WreslPlus.g:226:7: im= include_model
					{
					pushFollow(FOLLOW_include_model_in_mt956);
					im=include_model();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, im.getTree());

					if ( state.backtracking==0 ) {mt_stack.peek().m_.itemTypeList.add(Param.incModelType);mt_stack.peek().m_.itemList.add(Param.model_label+(im!=null?((WreslPlusParser.include_model_return)im).id:null)); mt_stack.peek().m_.incModelList.add((im!=null?((WreslPlusParser.include_model_return)im).id:null));
						                       mt_stack.peek().m_.incFileIDList.add((im!=null?((WreslPlusParser.include_model_return)im).id:null)); mt_stack.peek().m_.incFileMap.put((im!=null?((WreslPlusParser.include_model_return)im).id:null), null);
						                       }
					}
					break;
				case 12 :
					// WreslPlus.g:229:7: ifig= if_inc_items
					{
					pushFollow(FOLLOW_if_inc_items_in_mt968);
					ifig=if_inc_items();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ifig.getTree());

					if ( state.backtracking==0 ) {mt_stack.peek().m_.itemTypeList.add(Param.ifIncItemGroupType); mt_stack.peek().m_.itemList.add((ifig!=null?((WreslPlusParser.if_inc_items_return)ifig).id:null)); mt_stack.peek().m_.ifIncItemGroupIDList.add((ifig!=null?((WreslPlusParser.if_inc_items_return)ifig).id:null)); mt_stack.peek().m_.ifIncItemGroupMap.put((ifig!=null?((WreslPlusParser.if_inc_items_return)ifig).id:null), (ifig!=null?((WreslPlusParser.if_inc_items_return)ifig).ifIncItemGroupObj:null)); }
					}
					break;

				default :
					if ( cnt11 >= 1 ) break loop11;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(11, input);
					throw eee;
				}
				cnt11++;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {retval.modelObj =mt_stack.peek().m_; 
			       retval.modelObj.neededCycleVarMap = neededCycleVarMap;
			       retval.modelObj.id=Param.legacywresl;}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			mt_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "mt"


	protected static class if_inc_items_scope {
		IfIncItemGroup incg_;
		ArrayList<String> _arr;
		HashMap<String, IncFileTemp> _incfmap;
		HashMap<String, SvarTemp> _incSvarMap;
		HashMap<String, DvarTemp> _incDvarMap;
		LinkedHashMap<String, AliasTemp> _incAliasMap;
		HashMap<String, TimeseriesTemp> _incTimeseriesMap;
		HashMap<String, GoalTemp> _incGoalSimpleMap;
		HashMap<String, GoalTemp> _incGoalComplexMap;
		HashMap<String, WeightTable> _incWeightTableMap;
	}
	protected Stack<if_inc_items_scope> if_inc_items_stack = new Stack<if_inc_items_scope>();

	public static class if_inc_items_return extends ParserRuleReturnScope {
		public String id;
		public IfIncItemGroup ifIncItemGroupObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "if_inc_items"
	// WreslPlus.g:233:1: if_inc_items returns [String id, IfIncItemGroup ifIncItemGroupObj] : if_ ( elseif_ )* ( else_ )? ;
	public final WreslPlusParser.if_inc_items_return if_inc_items() throws RecognitionException {
		if_inc_items_stack.push(new if_inc_items_scope());
		WreslPlusParser.if_inc_items_return retval = new WreslPlusParser.if_inc_items_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope if_58 =null;
		ParserRuleReturnScope elseif_59 =null;
		ParserRuleReturnScope else_60 =null;


		 if_inc_items_stack.peek().incg_ = new IfIncItemGroup();
		       if_inc_items_stack.peek().incg_.id = "__item__"+Integer.toString(mt_stack.peek().m_.ifIncItemGroupIDList.size());
		       retval.id = if_inc_items_stack.peek().incg_.id;
		       retval.ifIncItemGroupObj = if_inc_items_stack.peek().incg_;
		       //dependants = new LinkedHashSet<String>();
		       if_inc_items_stack.peek().incg_.dependants = new HashSet<String>();
		      // $incg_.id = "__incfilegroup__"+Integer.toString(mt_stack.peek().m_.incFileGroupIDList.size()); 

		       
		try {
			// WreslPlus.g:268:3: ( if_ ( elseif_ )* ( else_ )? )
			// WreslPlus.g:268:5: if_ ( elseif_ )* ( else_ )?
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_if__in_if_inc_items1027);
			if_58=if_();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, if_58.getTree());

			// WreslPlus.g:268:10: ( elseif_ )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==Elseif) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// WreslPlus.g:268:10: elseif_
					{
					pushFollow(FOLLOW_elseif__in_if_inc_items1030);
					elseif_59=elseif_();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, elseif_59.getTree());

					}
					break;

				default :
					break loop12;
				}
			}

			// WreslPlus.g:268:19: ( else_ )?
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==Else) ) {
				alt13=1;
			}
			switch (alt13) {
				case 1 :
					// WreslPlus.g:268:19: else_
					{
					pushFollow(FOLLOW_else__in_if_inc_items1033);
					else_60=else_();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, else_60.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { 
			        // reserve space
			        mt_stack.peek().m_.svList.add(if_inc_items_stack.peek().incg_.id); 
			        mt_stack.peek().m_.dvList.add(if_inc_items_stack.peek().incg_.id);
			        mt_stack.peek().m_.asList.add(if_inc_items_stack.peek().incg_.id); 
			        mt_stack.peek().m_.tsList.add(if_inc_items_stack.peek().incg_.id); 
			        mt_stack.peek().m_.glList.add(if_inc_items_stack.peek().incg_.id); 
			        mt_stack.peek().m_.gl2List.add(if_inc_items_stack.peek().incg_.id); 
			        //if_inc_items_stack.peek().incg_.dependants = dependants;
			        if_inc_items_stack.peek().incg_.fromWresl = this.currentAbsolutePath;
			        if_inc_items_stack.peek().incg_.line=line; 
			       // mt_stack.peek().m_.wTableObjList.add(if_inc_items_stack.peek().incg_.id);         

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			if_inc_items_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "if_inc_items"


	public static class if__return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "if_"
	// WreslPlus.g:270:1: if_ : If e= logical_main '{' include_item_group '}' ;
	public final WreslPlusParser.if__return if_() throws RecognitionException {
		WreslPlusParser.if__return retval = new WreslPlusParser.if__return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token If61=null;
		Token char_literal62=null;
		Token char_literal64=null;
		ParserRuleReturnScope e =null;
		ParserRuleReturnScope include_item_group63 =null;

		CommonTree If61_tree=null;
		CommonTree char_literal62_tree=null;
		CommonTree char_literal64_tree=null;

		 dependants = new LinkedHashSet<String>(); 
		try {
			// WreslPlus.g:272:3: ( If e= logical_main '{' include_item_group '}' )
			// WreslPlus.g:273:3: If e= logical_main '{' include_item_group '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			If61=(Token)match(input,If,FOLLOW_If_in_if_1053); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			If61_tree = (CommonTree)adaptor.create(If61);
			adaptor.addChild(root_0, If61_tree);
			}

			if ( state.backtracking==0 ) {line=(If61!=null?If61.getLine():0);}
			pushFollow(FOLLOW_logical_main_in_if_1058);
			e=logical_main();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

			if ( state.backtracking==0 ) {if_inc_items_stack.peek().incg_.dependants.addAll(dependants);}
			char_literal62=(Token)match(input,125,FOLLOW_125_in_if_1064); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal62_tree = (CommonTree)adaptor.create(char_literal62);
			adaptor.addChild(root_0, char_literal62_tree);
			}

			pushFollow(FOLLOW_include_item_group_in_if_1066);
			include_item_group63=include_item_group();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, include_item_group63.getTree());

			char_literal64=(Token)match(input,126,FOLLOW_126_in_if_1068); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal64_tree = (CommonTree)adaptor.create(char_literal64);
			adaptor.addChild(root_0, char_literal64_tree);
			}

			if ( state.backtracking==0 ) {if_inc_items_stack.peek().incg_.conditionList.add((e!=null?input.toString(e.start,e.stop):null));}
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
	// $ANTLR end "if_"


	public static class elseif__return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "elseif_"
	// WreslPlus.g:277:1: elseif_ : Elseif e= logical_main '{' include_item_group '}' ;
	public final WreslPlusParser.elseif__return elseif_() throws RecognitionException {
		WreslPlusParser.elseif__return retval = new WreslPlusParser.elseif__return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Elseif65=null;
		Token char_literal66=null;
		Token char_literal68=null;
		ParserRuleReturnScope e =null;
		ParserRuleReturnScope include_item_group67 =null;

		CommonTree Elseif65_tree=null;
		CommonTree char_literal66_tree=null;
		CommonTree char_literal68_tree=null;

		 dependants = new LinkedHashSet<String>(); 
		try {
			// WreslPlus.g:279:3: ( Elseif e= logical_main '{' include_item_group '}' )
			// WreslPlus.g:280:3: Elseif e= logical_main '{' include_item_group '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			Elseif65=(Token)match(input,Elseif,FOLLOW_Elseif_in_elseif_1093); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			Elseif65_tree = (CommonTree)adaptor.create(Elseif65);
			adaptor.addChild(root_0, Elseif65_tree);
			}

			pushFollow(FOLLOW_logical_main_in_elseif_1097);
			e=logical_main();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

			if ( state.backtracking==0 ) {if_inc_items_stack.peek().incg_.dependants.addAll(dependants);}
			char_literal66=(Token)match(input,125,FOLLOW_125_in_elseif_1103); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal66_tree = (CommonTree)adaptor.create(char_literal66);
			adaptor.addChild(root_0, char_literal66_tree);
			}

			pushFollow(FOLLOW_include_item_group_in_elseif_1105);
			include_item_group67=include_item_group();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, include_item_group67.getTree());

			char_literal68=(Token)match(input,126,FOLLOW_126_in_elseif_1107); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal68_tree = (CommonTree)adaptor.create(char_literal68);
			adaptor.addChild(root_0, char_literal68_tree);
			}

			if ( state.backtracking==0 ) {if_inc_items_stack.peek().incg_.conditionList.add((e!=null?input.toString(e.start,e.stop):null));}
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
	// $ANTLR end "elseif_"


	public static class else__return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "else_"
	// WreslPlus.g:284:1: else_ : Else '{' include_item_group '}' ;
	public final WreslPlusParser.else__return else_() throws RecognitionException {
		WreslPlusParser.else__return retval = new WreslPlusParser.else__return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token Else69=null;
		Token char_literal70=null;
		Token char_literal72=null;
		ParserRuleReturnScope include_item_group71 =null;

		CommonTree Else69_tree=null;
		CommonTree char_literal70_tree=null;
		CommonTree char_literal72_tree=null;

		try {
			// WreslPlus.g:284:8: ( Else '{' include_item_group '}' )
			// WreslPlus.g:285:3: Else '{' include_item_group '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			Else69=(Token)match(input,Else,FOLLOW_Else_in_else_1125); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			Else69_tree = (CommonTree)adaptor.create(Else69);
			adaptor.addChild(root_0, Else69_tree);
			}

			char_literal70=(Token)match(input,125,FOLLOW_125_in_else_1127); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal70_tree = (CommonTree)adaptor.create(char_literal70);
			adaptor.addChild(root_0, char_literal70_tree);
			}

			pushFollow(FOLLOW_include_item_group_in_else_1129);
			include_item_group71=include_item_group();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, include_item_group71.getTree());

			char_literal72=(Token)match(input,126,FOLLOW_126_in_else_1131); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal72_tree = (CommonTree)adaptor.create(char_literal72);
			adaptor.addChild(root_0, char_literal72_tree);
			}

			if ( state.backtracking==0 ) {if_inc_items_stack.peek().incg_.conditionList.add(Param.always);}
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
	// $ANTLR end "else_"


	public static class include_item_group_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "include_item_group"
	// WreslPlus.g:288:1: include_item_group : ( (fi= include_file ) | (si= svar_group ) | (di= dvar_g ) | (ai= alias ) | (ti= timeseries ) | (gsi= goal_s ) | (ghi= goal_hs ) | (wti= weight ) )+ ;
	public final WreslPlusParser.include_item_group_return include_item_group() throws RecognitionException {
		WreslPlusParser.include_item_group_return retval = new WreslPlusParser.include_item_group_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope fi =null;
		ParserRuleReturnScope si =null;
		ParserRuleReturnScope di =null;
		ParserRuleReturnScope ai =null;
		ParserRuleReturnScope ti =null;
		ParserRuleReturnScope gsi =null;
		ParserRuleReturnScope ghi =null;
		ParserRuleReturnScope wti =null;


		 if_inc_items_stack.peek()._arr = new ArrayList<String>(); 
		       if_inc_items_stack.peek()._incfmap = new HashMap<String, IncFileTemp>();
		       if_inc_items_stack.peek()._incSvarMap = new HashMap<String, SvarTemp>();
		       if_inc_items_stack.peek()._incDvarMap = new HashMap<String, DvarTemp>();
		       if_inc_items_stack.peek()._incAliasMap = new LinkedHashMap<String, AliasTemp>();
		       if_inc_items_stack.peek()._incTimeseriesMap = new HashMap<String, TimeseriesTemp>(); 
		       if_inc_items_stack.peek()._incGoalSimpleMap = new HashMap<String, GoalTemp>();              
		       if_inc_items_stack.peek()._incGoalComplexMap = new HashMap<String, GoalTemp>(); 
		       if_inc_items_stack.peek()._incWeightTableMap = new HashMap<String, WeightTable>(); 

		try {
			// WreslPlus.g:310:4: ( ( (fi= include_file ) | (si= svar_group ) | (di= dvar_g ) | (ai= alias ) | (ti= timeseries ) | (gsi= goal_s ) | (ghi= goal_hs ) | (wti= weight ) )+ )
			// WreslPlus.g:311:4: ( (fi= include_file ) | (si= svar_group ) | (di= dvar_g ) | (ai= alias ) | (ti= timeseries ) | (gsi= goal_s ) | (ghi= goal_hs ) | (wti= weight ) )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:311:4: ( (fi= include_file ) | (si= svar_group ) | (di= dvar_g ) | (ai= alias ) | (ti= timeseries ) | (gsi= goal_s ) | (ghi= goal_hs ) | (wti= weight ) )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=9;
				switch ( input.LA(1) ) {
				case INCLUDE:
					{
					alt14=1;
					}
					break;
				case SVAR:
					{
					alt14=2;
					}
					break;
				case DEFINE:
					{
					switch ( input.LA(2) ) {
					case 119:
						{
						int LA14_10 = input.LA(3);
						if ( (LA14_10==LOCAL) ) {
							int LA14_16 = input.LA(4);
							if ( (LA14_16==120) ) {
								switch ( input.LA(5) ) {
								case ID:
									{
									int LA14_11 = input.LA(6);
									if ( (LA14_11==125) ) {
										switch ( input.LA(7) ) {
										case ALIAS:
											{
											alt14=4;
											}
											break;
										case TIMESERIES:
											{
											alt14=5;
											}
											break;
										case CASE:
										case SELECT:
										case SUM:
										case VALUE:
										case 124:
											{
											alt14=2;
											}
											break;
										case BINARY:
										case INTEGER:
										case LOWER:
										case STD:
										case UPPER:
										case 113:
											{
											alt14=3;
											}
											break;
										}
									}

									}
									break;
								case 119:
									{
									int LA14_32 = input.LA(6);
									if ( (LA14_32==ID||LA14_32==INT) ) {
										int LA14_17 = input.LA(7);
										if ( (LA14_17==120) ) {
											int LA14_25 = input.LA(8);
											if ( (LA14_25==ID) ) {
												int LA14_33 = input.LA(9);
												if ( (LA14_33==125) ) {
													switch ( input.LA(10) ) {
													case ALIAS:
														{
														alt14=4;
														}
														break;
													case CASE:
													case SELECT:
													case SUM:
													case VALUE:
													case 124:
														{
														alt14=2;
														}
														break;
													case BINARY:
													case INTEGER:
													case LOWER:
													case STD:
													case UPPER:
													case 113:
														{
														alt14=3;
														}
														break;
													}
												}

											}

										}

									}

									}
									break;
								case 103:
									{
									int LA14_12 = input.LA(6);
									if ( (LA14_12==ID||LA14_12==INT) ) {
										int LA14_19 = input.LA(7);
										if ( (LA14_19==104) ) {
											int LA14_26 = input.LA(8);
											if ( (LA14_26==ID) ) {
												int LA14_34 = input.LA(9);
												if ( (LA14_34==125) ) {
													switch ( input.LA(10) ) {
													case ALIAS:
														{
														alt14=4;
														}
														break;
													case CASE:
													case SELECT:
													case SUM:
													case VALUE:
													case 124:
														{
														alt14=2;
														}
														break;
													case BINARY:
													case INTEGER:
													case LOWER:
													case STD:
													case UPPER:
													case 113:
														{
														alt14=3;
														}
														break;
													}
												}

											}

										}

									}

									}
									break;
								}
							}

						}
						else if ( (LA14_10==ID||LA14_10==INT) ) {
							int LA14_17 = input.LA(4);
							if ( (LA14_17==120) ) {
								int LA14_25 = input.LA(5);
								if ( (LA14_25==ID) ) {
									int LA14_33 = input.LA(6);
									if ( (LA14_33==125) ) {
										switch ( input.LA(7) ) {
										case ALIAS:
											{
											alt14=4;
											}
											break;
										case CASE:
										case SELECT:
										case SUM:
										case VALUE:
										case 124:
											{
											alt14=2;
											}
											break;
										case BINARY:
										case INTEGER:
										case LOWER:
										case STD:
										case UPPER:
										case 113:
											{
											alt14=3;
											}
											break;
										}
									}

								}

							}

						}

						}
						break;
					case ID:
						{
						int LA14_11 = input.LA(3);
						if ( (LA14_11==125) ) {
							switch ( input.LA(4) ) {
							case ALIAS:
								{
								alt14=4;
								}
								break;
							case TIMESERIES:
								{
								alt14=5;
								}
								break;
							case CASE:
							case SELECT:
							case SUM:
							case VALUE:
							case 124:
								{
								alt14=2;
								}
								break;
							case BINARY:
							case INTEGER:
							case LOWER:
							case STD:
							case UPPER:
							case 113:
								{
								alt14=3;
								}
								break;
							}
						}

						}
						break;
					case 103:
						{
						int LA14_12 = input.LA(3);
						if ( (LA14_12==ID||LA14_12==INT) ) {
							int LA14_19 = input.LA(4);
							if ( (LA14_19==104) ) {
								int LA14_26 = input.LA(5);
								if ( (LA14_26==ID) ) {
									int LA14_34 = input.LA(6);
									if ( (LA14_34==125) ) {
										switch ( input.LA(7) ) {
										case ALIAS:
											{
											alt14=4;
											}
											break;
										case CASE:
										case SELECT:
										case SUM:
										case VALUE:
										case 124:
											{
											alt14=2;
											}
											break;
										case BINARY:
										case INTEGER:
										case LOWER:
										case STD:
										case UPPER:
										case 113:
											{
											alt14=3;
											}
											break;
										}
									}

								}

							}

						}

						}
						break;
					}
					}
					break;
				case DVAR:
					{
					alt14=3;
					}
					break;
				case ALIAS:
					{
					alt14=4;
					}
					break;
				case TIMESERIES:
					{
					alt14=5;
					}
					break;
				case GOAL:
					{
					switch ( input.LA(2) ) {
					case 119:
						{
						int LA14_13 = input.LA(3);
						if ( (LA14_13==LOCAL) ) {
							int LA14_20 = input.LA(4);
							if ( (LA14_20==120) ) {
								switch ( input.LA(5) ) {
								case 119:
									{
									int LA14_35 = input.LA(6);
									if ( (LA14_35==ID||LA14_35==INT) ) {
										int LA14_21 = input.LA(7);
										if ( (LA14_21==120) ) {
											int LA14_28 = input.LA(8);
											if ( (LA14_28==ID) ) {
												int LA14_15 = input.LA(9);
												if ( (LA14_15==125) ) {
													int LA14_23 = input.LA(10);
													if ( ((LA14_23 >= ACOS && LA14_23 <= ACOT)||(LA14_23 >= ASIN && LA14_23 <= ATAN)||LA14_23==CFS_TAF||(LA14_23 >= COS && LA14_23 <= COT)||LA14_23==DAY||(LA14_23 >= EXCEEDANCE && LA14_23 <= EXCEEDANCE_TSI)||LA14_23==ID||LA14_23==INT||LA14_23==INT_word||LA14_23==LOG||(LA14_23 >= MAX && LA14_23 <= MIN)||LA14_23==MOD||LA14_23==MONTH||LA14_23==REAL||LA14_23==ROUND||LA14_23==SIN||(LA14_23 >= TAF_CFS && LA14_23 <= TAN)||LA14_23==WATERYEAR||(LA14_23 >= 99 && LA14_23 <= 100)||LA14_23==103||LA14_23==106||LA14_23==108||(LA14_23 >= 122 && LA14_23 <= 124)) ) {
														alt14=6;
													}
													else if ( (LA14_23==LHS) ) {
														alt14=7;
													}

												}

											}

										}

									}

									}
									break;
								case 103:
									{
									int LA14_14 = input.LA(6);
									if ( (LA14_14==ID||LA14_14==INT) ) {
										int LA14_22 = input.LA(7);
										if ( (LA14_22==104) ) {
											int LA14_29 = input.LA(8);
											if ( (LA14_29==ID) ) {
												int LA14_15 = input.LA(9);
												if ( (LA14_15==125) ) {
													int LA14_23 = input.LA(10);
													if ( ((LA14_23 >= ACOS && LA14_23 <= ACOT)||(LA14_23 >= ASIN && LA14_23 <= ATAN)||LA14_23==CFS_TAF||(LA14_23 >= COS && LA14_23 <= COT)||LA14_23==DAY||(LA14_23 >= EXCEEDANCE && LA14_23 <= EXCEEDANCE_TSI)||LA14_23==ID||LA14_23==INT||LA14_23==INT_word||LA14_23==LOG||(LA14_23 >= MAX && LA14_23 <= MIN)||LA14_23==MOD||LA14_23==MONTH||LA14_23==REAL||LA14_23==ROUND||LA14_23==SIN||(LA14_23 >= TAF_CFS && LA14_23 <= TAN)||LA14_23==WATERYEAR||(LA14_23 >= 99 && LA14_23 <= 100)||LA14_23==103||LA14_23==106||LA14_23==108||(LA14_23 >= 122 && LA14_23 <= 124)) ) {
														alt14=6;
													}
													else if ( (LA14_23==LHS) ) {
														alt14=7;
													}

												}

											}

										}

									}

									}
									break;
								case ID:
									{
									int LA14_15 = input.LA(6);
									if ( (LA14_15==125) ) {
										int LA14_23 = input.LA(7);
										if ( ((LA14_23 >= ACOS && LA14_23 <= ACOT)||(LA14_23 >= ASIN && LA14_23 <= ATAN)||LA14_23==CFS_TAF||(LA14_23 >= COS && LA14_23 <= COT)||LA14_23==DAY||(LA14_23 >= EXCEEDANCE && LA14_23 <= EXCEEDANCE_TSI)||LA14_23==ID||LA14_23==INT||LA14_23==INT_word||LA14_23==LOG||(LA14_23 >= MAX && LA14_23 <= MIN)||LA14_23==MOD||LA14_23==MONTH||LA14_23==REAL||LA14_23==ROUND||LA14_23==SIN||(LA14_23 >= TAF_CFS && LA14_23 <= TAN)||LA14_23==WATERYEAR||(LA14_23 >= 99 && LA14_23 <= 100)||LA14_23==103||LA14_23==106||LA14_23==108||(LA14_23 >= 122 && LA14_23 <= 124)) ) {
											alt14=6;
										}
										else if ( (LA14_23==LHS) ) {
											alt14=7;
										}

									}

									}
									break;
								}
							}

						}
						else if ( (LA14_13==ID||LA14_13==INT) ) {
							int LA14_21 = input.LA(4);
							if ( (LA14_21==120) ) {
								int LA14_28 = input.LA(5);
								if ( (LA14_28==ID) ) {
									int LA14_15 = input.LA(6);
									if ( (LA14_15==125) ) {
										int LA14_23 = input.LA(7);
										if ( ((LA14_23 >= ACOS && LA14_23 <= ACOT)||(LA14_23 >= ASIN && LA14_23 <= ATAN)||LA14_23==CFS_TAF||(LA14_23 >= COS && LA14_23 <= COT)||LA14_23==DAY||(LA14_23 >= EXCEEDANCE && LA14_23 <= EXCEEDANCE_TSI)||LA14_23==ID||LA14_23==INT||LA14_23==INT_word||LA14_23==LOG||(LA14_23 >= MAX && LA14_23 <= MIN)||LA14_23==MOD||LA14_23==MONTH||LA14_23==REAL||LA14_23==ROUND||LA14_23==SIN||(LA14_23 >= TAF_CFS && LA14_23 <= TAN)||LA14_23==WATERYEAR||(LA14_23 >= 99 && LA14_23 <= 100)||LA14_23==103||LA14_23==106||LA14_23==108||(LA14_23 >= 122 && LA14_23 <= 124)) ) {
											alt14=6;
										}
										else if ( (LA14_23==LHS) ) {
											alt14=7;
										}

									}

								}

							}

						}

						}
						break;
					case 103:
						{
						int LA14_14 = input.LA(3);
						if ( (LA14_14==ID||LA14_14==INT) ) {
							int LA14_22 = input.LA(4);
							if ( (LA14_22==104) ) {
								int LA14_29 = input.LA(5);
								if ( (LA14_29==ID) ) {
									int LA14_15 = input.LA(6);
									if ( (LA14_15==125) ) {
										int LA14_23 = input.LA(7);
										if ( ((LA14_23 >= ACOS && LA14_23 <= ACOT)||(LA14_23 >= ASIN && LA14_23 <= ATAN)||LA14_23==CFS_TAF||(LA14_23 >= COS && LA14_23 <= COT)||LA14_23==DAY||(LA14_23 >= EXCEEDANCE && LA14_23 <= EXCEEDANCE_TSI)||LA14_23==ID||LA14_23==INT||LA14_23==INT_word||LA14_23==LOG||(LA14_23 >= MAX && LA14_23 <= MIN)||LA14_23==MOD||LA14_23==MONTH||LA14_23==REAL||LA14_23==ROUND||LA14_23==SIN||(LA14_23 >= TAF_CFS && LA14_23 <= TAN)||LA14_23==WATERYEAR||(LA14_23 >= 99 && LA14_23 <= 100)||LA14_23==103||LA14_23==106||LA14_23==108||(LA14_23 >= 122 && LA14_23 <= 124)) ) {
											alt14=6;
										}
										else if ( (LA14_23==LHS) ) {
											alt14=7;
										}

									}

								}

							}

						}

						}
						break;
					case ID:
						{
						int LA14_15 = input.LA(3);
						if ( (LA14_15==125) ) {
							int LA14_23 = input.LA(4);
							if ( ((LA14_23 >= ACOS && LA14_23 <= ACOT)||(LA14_23 >= ASIN && LA14_23 <= ATAN)||LA14_23==CFS_TAF||(LA14_23 >= COS && LA14_23 <= COT)||LA14_23==DAY||(LA14_23 >= EXCEEDANCE && LA14_23 <= EXCEEDANCE_TSI)||LA14_23==ID||LA14_23==INT||LA14_23==INT_word||LA14_23==LOG||(LA14_23 >= MAX && LA14_23 <= MIN)||LA14_23==MOD||LA14_23==MONTH||LA14_23==REAL||LA14_23==ROUND||LA14_23==SIN||(LA14_23 >= TAF_CFS && LA14_23 <= TAN)||LA14_23==WATERYEAR||(LA14_23 >= 99 && LA14_23 <= 100)||LA14_23==103||LA14_23==106||LA14_23==108||(LA14_23 >= 122 && LA14_23 <= 124)) ) {
								alt14=6;
							}
							else if ( (LA14_23==LHS) ) {
								alt14=7;
							}

						}

						}
						break;
					}
					}
					break;
				case OBJECTIVE:
					{
					alt14=8;
					}
					break;
				}
				switch (alt14) {
				case 1 :
					// WreslPlus.g:312:7: (fi= include_file )
					{
					// WreslPlus.g:312:7: (fi= include_file )
					// WreslPlus.g:312:9: fi= include_file
					{
					pushFollow(FOLLOW_include_file_in_include_item_group1168);
					fi=include_file();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, fi.getTree());

					if ( state.backtracking==0 ) { 
					        if_inc_items_stack.peek()._arr.add((fi!=null?((WreslPlusParser.include_file_return)fi).id:null));  
					        if_inc_items_stack.peek()._incfmap.put((fi!=null?((WreslPlusParser.include_file_return)fi).id:null), (fi!=null?((WreslPlusParser.include_file_return)fi).incFileObj:null));
					        mt_stack.peek().m_.incFileIDList.add(if_inc_items_stack.peek().incg_.id); 
					        }
					}

					}
					break;
				case 2 :
					// WreslPlus.g:317:7: (si= svar_group )
					{
					// WreslPlus.g:317:7: (si= svar_group )
					// WreslPlus.g:317:9: si= svar_group
					{
					pushFollow(FOLLOW_svar_group_in_include_item_group1183);
					si=svar_group();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, si.getTree());

					if ( state.backtracking==0 ) { 
					        if_inc_items_stack.peek()._arr.add((si!=null?((WreslPlusParser.svar_group_return)si).id:null));  
					        if_inc_items_stack.peek()._incSvarMap.put((si!=null?((WreslPlusParser.svar_group_return)si).id:null), (si!=null?((WreslPlusParser.svar_group_return)si).svObj:null));
					        }
					}

					}
					break;
				case 3 :
					// WreslPlus.g:321:7: (di= dvar_g )
					{
					// WreslPlus.g:321:7: (di= dvar_g )
					// WreslPlus.g:321:9: di= dvar_g
					{
					pushFollow(FOLLOW_dvar_g_in_include_item_group1198);
					di=dvar_g();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, di.getTree());

					if ( state.backtracking==0 ) { 
					        if_inc_items_stack.peek()._arr.add((di!=null?((WreslPlusParser.dvar_g_return)di).id:null));  
					        if_inc_items_stack.peek()._incDvarMap.put((di!=null?((WreslPlusParser.dvar_g_return)di).id:null), (di!=null?((WreslPlusParser.dvar_g_return)di).dvObj:null));
					        }
					}

					}
					break;
				case 4 :
					// WreslPlus.g:325:7: (ai= alias )
					{
					// WreslPlus.g:325:7: (ai= alias )
					// WreslPlus.g:325:9: ai= alias
					{
					pushFollow(FOLLOW_alias_in_include_item_group1213);
					ai=alias();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ai.getTree());

					if ( state.backtracking==0 ) { 
					        if_inc_items_stack.peek()._arr.add((ai!=null?((WreslPlusParser.alias_return)ai).id:null));  
					        if_inc_items_stack.peek()._incAliasMap.put((ai!=null?((WreslPlusParser.alias_return)ai).id:null), (ai!=null?((WreslPlusParser.alias_return)ai).asObj:null));
					        }
					}

					}
					break;
				case 5 :
					// WreslPlus.g:329:7: (ti= timeseries )
					{
					// WreslPlus.g:329:7: (ti= timeseries )
					// WreslPlus.g:329:9: ti= timeseries
					{
					pushFollow(FOLLOW_timeseries_in_include_item_group1229);
					ti=timeseries();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ti.getTree());

					if ( state.backtracking==0 ) { 
					        if_inc_items_stack.peek()._arr.add((ti!=null?((WreslPlusParser.timeseries_return)ti).id:null));  
					        if_inc_items_stack.peek()._incTimeseriesMap.put((ti!=null?((WreslPlusParser.timeseries_return)ti).id:null), (ti!=null?((WreslPlusParser.timeseries_return)ti).tsObj:null));
					        }
					}

					}
					break;
				case 6 :
					// WreslPlus.g:333:7: (gsi= goal_s )
					{
					// WreslPlus.g:333:7: (gsi= goal_s )
					// WreslPlus.g:333:9: gsi= goal_s
					{
					pushFollow(FOLLOW_goal_s_in_include_item_group1244);
					gsi=goal_s();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, gsi.getTree());

					if ( state.backtracking==0 ) { 
					        if_inc_items_stack.peek()._arr.add((gsi!=null?((WreslPlusParser.goal_s_return)gsi).id:null));  
					        if_inc_items_stack.peek()._incGoalSimpleMap.put((gsi!=null?((WreslPlusParser.goal_s_return)gsi).id:null), (gsi!=null?((WreslPlusParser.goal_s_return)gsi).glObj:null));
					        }
					}

					}
					break;
				case 7 :
					// WreslPlus.g:337:7: (ghi= goal_hs )
					{
					// WreslPlus.g:337:7: (ghi= goal_hs )
					// WreslPlus.g:337:9: ghi= goal_hs
					{
					pushFollow(FOLLOW_goal_hs_in_include_item_group1261);
					ghi=goal_hs();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ghi.getTree());

					if ( state.backtracking==0 ) { 
					        if_inc_items_stack.peek()._arr.add((ghi!=null?((WreslPlusParser.goal_hs_return)ghi).id:null));  
					        if_inc_items_stack.peek()._incGoalComplexMap.put((ghi!=null?((WreslPlusParser.goal_hs_return)ghi).id:null), (ghi!=null?((WreslPlusParser.goal_hs_return)ghi).glObj:null));
					        }
					}

					}
					break;
				case 8 :
					// WreslPlus.g:341:7: (wti= weight )
					{
					// WreslPlus.g:341:7: (wti= weight )
					// WreslPlus.g:341:9: wti= weight
					{
					pushFollow(FOLLOW_weight_in_include_item_group1306);
					wti=weight();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, wti.getTree());

					if ( state.backtracking==0 ) {   
					        if_inc_items_stack.peek()._incWeightTableMap.put((wti!=null?((WreslPlusParser.weight_return)wti).id:null), (wti!=null?((WreslPlusParser.weight_return)wti).wtObj:null));
					        }
					}

					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {
			        if_inc_items_stack.peek().incg_.inc_item_list.add(if_inc_items_stack.peek()._arr); 
			        if_inc_items_stack.peek().incg_.inc_files_map_list.add(if_inc_items_stack.peek()._incfmap);
			        if_inc_items_stack.peek().incg_.inc_svar_map_list.add(if_inc_items_stack.peek()._incSvarMap);
			        if_inc_items_stack.peek().incg_.inc_dvar_map_list.add(if_inc_items_stack.peek()._incDvarMap);
			        if_inc_items_stack.peek().incg_.inc_alias_map_list.add(if_inc_items_stack.peek()._incAliasMap);
			        if_inc_items_stack.peek().incg_.inc_timeseries_map_list.add(if_inc_items_stack.peek()._incTimeseriesMap);
			        if_inc_items_stack.peek().incg_.inc_goalSimple_map_list.add(if_inc_items_stack.peek()._incGoalSimpleMap);
			        if_inc_items_stack.peek().incg_.inc_goalComplex_map_list.add(if_inc_items_stack.peek()._incGoalComplexMap);        
			        if_inc_items_stack.peek().incg_.inc_weightTable_map_list.add(if_inc_items_stack.peek()._incWeightTableMap); 
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
	// $ANTLR end "include_item_group"


	protected static class weight_scope {
		WeightTable wt_;
		String id_;
	}
	protected Stack<weight_scope> weight_stack = new Stack<weight_scope>();

	public static class weight_return extends ParserRuleReturnScope {
		public String id;
		public WeightTable wtObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "weight"
	// WreslPlus.g:367:1: weight returns [String id, WeightTable wtObj] : ( weight_legacy | weight_new );
	public final WreslPlusParser.weight_return weight() throws RecognitionException {
		weight_stack.push(new weight_scope());
		WreslPlusParser.weight_return retval = new WreslPlusParser.weight_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope weight_legacy73 =null;
		ParserRuleReturnScope weight_new74 =null;


		 weight_stack.peek().wt_ = new WeightTable(); 
		       weight_stack.peek().wt_.fromWresl = this.currentAbsolutePath; 
		       weight_stack.peek().wt_.line = line;
		       dependants = new LinkedHashSet<String>();
			 
		try {
			// WreslPlus.g:377:2: ( weight_legacy | weight_new )
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==OBJECTIVE) ) {
				int LA15_1 = input.LA(2);
				if ( (LA15_1==119) ) {
					alt15=1;
				}
				else if ( (LA15_1==ID) ) {
					int LA15_3 = input.LA(3);
					if ( (LA15_3==115) ) {
						alt15=1;
					}
					else if ( (LA15_3==125) ) {
						int LA15_4 = input.LA(4);
						if ( (LA15_4==119) ) {
							alt15=1;
						}
						else if ( (LA15_4==WEIGHT) ) {
							alt15=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 15, 4, input);
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
								new NoViableAltException("", 15, 3, input);
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
							new NoViableAltException("", 15, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// WreslPlus.g:377:4: weight_legacy
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_weight_legacy_in_weight1364);
					weight_legacy73=weight_legacy();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, weight_legacy73.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:377:20: weight_new
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_weight_new_in_weight1368);
					weight_new74=weight_new();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, weight_new74.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { retval.id = weight_stack.peek().wt_.id_lowcase; retval.wtObj =weight_stack.peek().wt_; retval.wtObj.dependants= dependants;}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			weight_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "weight"


	public static class weight_legacy_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "weight_legacy"
	// WreslPlus.g:379:1: weight_legacy : OBJECTIVE ( local_deprecated )? objGroupName ( '=' )? '{' ( weight_legacy_unit )+ '}' ;
	public final WreslPlusParser.weight_legacy_return weight_legacy() throws RecognitionException {
		WreslPlusParser.weight_legacy_return retval = new WreslPlusParser.weight_legacy_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OBJECTIVE75=null;
		Token char_literal78=null;
		Token char_literal79=null;
		Token char_literal81=null;
		ParserRuleReturnScope local_deprecated76 =null;
		ParserRuleReturnScope objGroupName77 =null;
		ParserRuleReturnScope weight_legacy_unit80 =null;

		CommonTree OBJECTIVE75_tree=null;
		CommonTree char_literal78_tree=null;
		CommonTree char_literal79_tree=null;
		CommonTree char_literal81_tree=null;

		try {
			// WreslPlus.g:379:15: ( OBJECTIVE ( local_deprecated )? objGroupName ( '=' )? '{' ( weight_legacy_unit )+ '}' )
			// WreslPlus.g:379:17: OBJECTIVE ( local_deprecated )? objGroupName ( '=' )? '{' ( weight_legacy_unit )+ '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			OBJECTIVE75=(Token)match(input,OBJECTIVE,FOLLOW_OBJECTIVE_in_weight_legacy1377); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			OBJECTIVE75_tree = (CommonTree)adaptor.create(OBJECTIVE75);
			adaptor.addChild(root_0, OBJECTIVE75_tree);
			}

			if ( state.backtracking==0 ) {line=(OBJECTIVE75!=null?OBJECTIVE75.getLine():0);}
			// WreslPlus.g:379:50: ( local_deprecated )?
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==119) ) {
				alt16=1;
			}
			switch (alt16) {
				case 1 :
					// WreslPlus.g:379:51: local_deprecated
					{
					pushFollow(FOLLOW_local_deprecated_in_weight_legacy1381);
					local_deprecated76=local_deprecated();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, local_deprecated76.getTree());

					}
					break;

			}

			pushFollow(FOLLOW_objGroupName_in_weight_legacy1385);
			objGroupName77=objGroupName();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, objGroupName77.getTree());

			// WreslPlus.g:379:83: ( '=' )?
			int alt17=2;
			int LA17_0 = input.LA(1);
			if ( (LA17_0==115) ) {
				alt17=1;
			}
			switch (alt17) {
				case 1 :
					// WreslPlus.g:379:83: '='
					{
					char_literal78=(Token)match(input,115,FOLLOW_115_in_weight_legacy1387); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal78_tree = (CommonTree)adaptor.create(char_literal78);
					adaptor.addChild(root_0, char_literal78_tree);
					}

					}
					break;

			}

			char_literal79=(Token)match(input,125,FOLLOW_125_in_weight_legacy1390); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal79_tree = (CommonTree)adaptor.create(char_literal79);
			adaptor.addChild(root_0, char_literal79_tree);
			}

			// WreslPlus.g:379:92: ( weight_legacy_unit )+
			int cnt18=0;
			loop18:
			while (true) {
				int alt18=2;
				int LA18_0 = input.LA(1);
				if ( (LA18_0==119) ) {
					alt18=1;
				}

				switch (alt18) {
				case 1 :
					// WreslPlus.g:379:92: weight_legacy_unit
					{
					pushFollow(FOLLOW_weight_legacy_unit_in_weight_legacy1392);
					weight_legacy_unit80=weight_legacy_unit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, weight_legacy_unit80.getTree());

					}
					break;

				default :
					if ( cnt18 >= 1 ) break loop18;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(18, input);
					throw eee;
				}
				cnt18++;
			}

			char_literal81=(Token)match(input,126,FOLLOW_126_in_weight_legacy1395); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal81_tree = (CommonTree)adaptor.create(char_literal81);
			adaptor.addChild(root_0, char_literal81_tree);
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
	// $ANTLR end "weight_legacy"


	public static class objGroupName_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "objGroupName"
	// WreslPlus.g:382:1: objGroupName : i= ID ;
	public final WreslPlusParser.objGroupName_return objGroupName() throws RecognitionException {
		WreslPlusParser.objGroupName_return retval = new WreslPlusParser.objGroupName_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;

		CommonTree i_tree=null;

		try {
			// WreslPlus.g:382:14: (i= ID )
			// WreslPlus.g:382:16: i= ID
			{
			root_0 = (CommonTree)adaptor.nil();


			i=(Token)match(input,ID,FOLLOW_ID_in_objGroupName1408); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) {weight_stack.peek().wt_.id_lowcase=(i!=null?i.getText():null).toLowerCase();
			                     weight_stack.peek().wt_.id_raw=(i!=null?i.getText():null);}
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
	// $ANTLR end "objGroupName"


	public static class weight_legacy_unit_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "weight_legacy_unit"
	// WreslPlus.g:385:1: weight_legacy_unit : '[' i= ID (ta= weightTimeArray )? ',' e= expr_add ']' ( ',' )? ;
	public final WreslPlusParser.weight_legacy_unit_return weight_legacy_unit() throws RecognitionException {
		WreslPlusParser.weight_legacy_unit_return retval = new WreslPlusParser.weight_legacy_unit_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token char_literal82=null;
		Token char_literal83=null;
		Token char_literal84=null;
		Token char_literal85=null;
		ParserRuleReturnScope ta =null;
		ParserRuleReturnScope e =null;

		CommonTree i_tree=null;
		CommonTree char_literal82_tree=null;
		CommonTree char_literal83_tree=null;
		CommonTree char_literal84_tree=null;
		CommonTree char_literal85_tree=null;

		try {
			// WreslPlus.g:386:2: ( '[' i= ID (ta= weightTimeArray )? ',' e= expr_add ']' ( ',' )? )
			// WreslPlus.g:386:4: '[' i= ID (ta= weightTimeArray )? ',' e= expr_add ']' ( ',' )?
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal82=(Token)match(input,119,FOLLOW_119_in_weight_legacy_unit1421); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal82_tree = (CommonTree)adaptor.create(char_literal82);
			adaptor.addChild(root_0, char_literal82_tree);
			}

			i=(Token)match(input,ID,FOLLOW_ID_in_weight_legacy_unit1425); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) {line=(i!=null?i.getLine():0);}
			// WreslPlus.g:386:28: (ta= weightTimeArray )?
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==103) ) {
				alt19=1;
			}
			switch (alt19) {
				case 1 :
					// WreslPlus.g:386:29: ta= weightTimeArray
					{
					pushFollow(FOLLOW_weightTimeArray_in_weight_legacy_unit1431);
					ta=weightTimeArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, ta.getTree());

					if ( state.backtracking==0 ) {weight_stack.peek().wt_.varTimeArraySizeMap.put((i!=null?i.getText():null),(ta!=null?input.toString(ta.start,ta.stop):null));}
					}
					break;

			}

			char_literal83=(Token)match(input,107,FOLLOW_107_in_weight_legacy_unit1437); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal83_tree = (CommonTree)adaptor.create(char_literal83);
			adaptor.addChild(root_0, char_literal83_tree);
			}

			pushFollow(FOLLOW_expr_add_in_weight_legacy_unit1441);
			e=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

			char_literal84=(Token)match(input,120,FOLLOW_120_in_weight_legacy_unit1443); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal84_tree = (CommonTree)adaptor.create(char_literal84);
			adaptor.addChild(root_0, char_literal84_tree);
			}

			// WreslPlus.g:386:127: ( ',' )?
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==107) ) {
				alt20=1;
			}
			switch (alt20) {
				case 1 :
					// WreslPlus.g:386:127: ','
					{
					char_literal85=(Token)match(input,107,FOLLOW_107_in_weight_legacy_unit1445); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal85_tree = (CommonTree)adaptor.create(char_literal85);
					adaptor.addChild(root_0, char_literal85_tree);
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {weight_stack.peek().wt_.varList.add((i!=null?i.getText():null));
				weight_stack.peek().wt_.varWeightMap.put((i!=null?i.getText():null),(e!=null?input.toString(e.start,e.stop):null));
				weight_stack.peek().wt_.varLineMap.put((i!=null?i.getText():null), line);}
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
	// $ANTLR end "weight_legacy_unit"


	public static class weightTimeArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "weightTimeArray"
	// WreslPlus.g:391:1: weightTimeArray : '(' d= ( INT | ID ) ')' ;
	public final WreslPlusParser.weightTimeArray_return weightTimeArray() throws RecognitionException {
		WreslPlusParser.weightTimeArray_return retval = new WreslPlusParser.weightTimeArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token d=null;
		Token char_literal86=null;
		Token char_literal87=null;

		CommonTree d_tree=null;
		CommonTree char_literal86_tree=null;
		CommonTree char_literal87_tree=null;

		try {
			// WreslPlus.g:391:17: ( '(' d= ( INT | ID ) ')' )
			// WreslPlus.g:391:19: '(' d= ( INT | ID ) ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal86=(Token)match(input,103,FOLLOW_103_in_weightTimeArray1459); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal86_tree = (CommonTree)adaptor.create(char_literal86);
			adaptor.addChild(root_0, char_literal86_tree);
			}

			d=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(d));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal87=(Token)match(input,104,FOLLOW_104_in_weightTimeArray1473); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal87_tree = (CommonTree)adaptor.create(char_literal87);
			adaptor.addChild(root_0, char_literal87_tree);
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
	// $ANTLR end "weightTimeArray"


	public static class weight_new_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "weight_new"
	// WreslPlus.g:393:1: weight_new : OBJECTIVE weightTableID '{' weight_group '}' ;
	public final WreslPlusParser.weight_new_return weight_new() throws RecognitionException {
		WreslPlusParser.weight_new_return retval = new WreslPlusParser.weight_new_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OBJECTIVE88=null;
		Token char_literal90=null;
		Token char_literal92=null;
		ParserRuleReturnScope weightTableID89 =null;
		ParserRuleReturnScope weight_group91 =null;

		CommonTree OBJECTIVE88_tree=null;
		CommonTree char_literal90_tree=null;
		CommonTree char_literal92_tree=null;

		try {
			// WreslPlus.g:393:12: ( OBJECTIVE weightTableID '{' weight_group '}' )
			// WreslPlus.g:393:14: OBJECTIVE weightTableID '{' weight_group '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			OBJECTIVE88=(Token)match(input,OBJECTIVE,FOLLOW_OBJECTIVE_in_weight_new1483); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			OBJECTIVE88_tree = (CommonTree)adaptor.create(OBJECTIVE88);
			adaptor.addChild(root_0, OBJECTIVE88_tree);
			}

			if ( state.backtracking==0 ) {line=(OBJECTIVE88!=null?OBJECTIVE88.getLine():0);}
			pushFollow(FOLLOW_weightTableID_in_weight_new1486);
			weightTableID89=weightTableID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, weightTableID89.getTree());

			char_literal90=(Token)match(input,125,FOLLOW_125_in_weight_new1488); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal90_tree = (CommonTree)adaptor.create(char_literal90);
			adaptor.addChild(root_0, char_literal90_tree);
			}

			pushFollow(FOLLOW_weight_group_in_weight_new1490);
			weight_group91=weight_group();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, weight_group91.getTree());

			char_literal92=(Token)match(input,126,FOLLOW_126_in_weight_new1492); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal92_tree = (CommonTree)adaptor.create(char_literal92);
			adaptor.addChild(root_0, char_literal92_tree);
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
	// $ANTLR end "weight_new"


	public static class weightTableID_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "weightTableID"
	// WreslPlus.g:395:1: weightTableID : i= ID ;
	public final WreslPlusParser.weightTableID_return weightTableID() throws RecognitionException {
		WreslPlusParser.weightTableID_return retval = new WreslPlusParser.weightTableID_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;

		CommonTree i_tree=null;

		try {
			// WreslPlus.g:395:15: (i= ID )
			// WreslPlus.g:395:17: i= ID
			{
			root_0 = (CommonTree)adaptor.nil();


			i=(Token)match(input,ID,FOLLOW_ID_in_weightTableID1504); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) {weight_stack.peek().wt_.id_lowcase=(i!=null?i.getText():null).toLowerCase();
			                      weight_stack.peek().wt_.id_raw=(i!=null?i.getText():null);
			                      weight_stack.peek().wt_.line=i.getLine();}
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
	// $ANTLR end "weightTableID"


	public static class weight_group_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "weight_group"
	// WreslPlus.g:399:1: weight_group : WEIGHT w= expr_add weight_trunk ;
	public final WreslPlusParser.weight_group_return weight_group() throws RecognitionException {
		WreslPlusParser.weight_group_return retval = new WreslPlusParser.weight_group_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token WEIGHT93=null;
		ParserRuleReturnScope w =null;
		ParserRuleReturnScope weight_trunk94 =null;

		CommonTree WEIGHT93_tree=null;

		 weight_stack.peek().wt_.isWeightGroup=true; 
		try {
			// WreslPlus.g:401:2: ( WEIGHT w= expr_add weight_trunk )
			// WreslPlus.g:401:5: WEIGHT w= expr_add weight_trunk
			{
			root_0 = (CommonTree)adaptor.nil();


			WEIGHT93=(Token)match(input,WEIGHT,FOLLOW_WEIGHT_in_weight_group1522); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			WEIGHT93_tree = (CommonTree)adaptor.create(WEIGHT93);
			adaptor.addChild(root_0, WEIGHT93_tree);
			}

			pushFollow(FOLLOW_expr_add_in_weight_group1526);
			w=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, w.getTree());

			if ( state.backtracking==0 ) {weight_stack.peek().wt_.commonWeight=(w!=null?input.toString(w.start,w.stop):null);}
			pushFollow(FOLLOW_weight_trunk_in_weight_group1536);
			weight_trunk94=weight_trunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, weight_trunk94.getTree());

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
	// $ANTLR end "weight_group"


	public static class weight_trunk_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "weight_trunk"
	// WreslPlus.g:405:1: weight_trunk : ( DeviationPenalty p= expr_add )? ( DeviationTolerance t= expr_add )? VARIABLE ( weight_group_unit | weight_subgroup )+ ;
	public final WreslPlusParser.weight_trunk_return weight_trunk() throws RecognitionException {
		WreslPlusParser.weight_trunk_return retval = new WreslPlusParser.weight_trunk_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DeviationPenalty95=null;
		Token DeviationTolerance96=null;
		Token VARIABLE97=null;
		ParserRuleReturnScope p =null;
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope weight_group_unit98 =null;
		ParserRuleReturnScope weight_subgroup99 =null;

		CommonTree DeviationPenalty95_tree=null;
		CommonTree DeviationTolerance96_tree=null;
		CommonTree VARIABLE97_tree=null;

		try {
			// WreslPlus.g:406:2: ( ( DeviationPenalty p= expr_add )? ( DeviationTolerance t= expr_add )? VARIABLE ( weight_group_unit | weight_subgroup )+ )
			// WreslPlus.g:406:5: ( DeviationPenalty p= expr_add )? ( DeviationTolerance t= expr_add )? VARIABLE ( weight_group_unit | weight_subgroup )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:406:5: ( DeviationPenalty p= expr_add )?
			int alt21=2;
			int LA21_0 = input.LA(1);
			if ( (LA21_0==DeviationPenalty) ) {
				alt21=1;
			}
			switch (alt21) {
				case 1 :
					// WreslPlus.g:406:7: DeviationPenalty p= expr_add
					{
					DeviationPenalty95=(Token)match(input,DeviationPenalty,FOLLOW_DeviationPenalty_in_weight_trunk1553); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DeviationPenalty95_tree = (CommonTree)adaptor.create(DeviationPenalty95);
					adaptor.addChild(root_0, DeviationPenalty95_tree);
					}

					pushFollow(FOLLOW_expr_add_in_weight_trunk1559);
					p=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, p.getTree());

					if ( state.backtracking==0 ) {weight_stack.peek().wt_.deviationPenalty=(p!=null?input.toString(p.start,p.stop):null);}
					}
					break;

			}

			// WreslPlus.g:407:5: ( DeviationTolerance t= expr_add )?
			int alt22=2;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==DeviationTolerance) ) {
				alt22=1;
			}
			switch (alt22) {
				case 1 :
					// WreslPlus.g:407:7: DeviationTolerance t= expr_add
					{
					DeviationTolerance96=(Token)match(input,DeviationTolerance,FOLLOW_DeviationTolerance_in_weight_trunk1573); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DeviationTolerance96_tree = (CommonTree)adaptor.create(DeviationTolerance96);
					adaptor.addChild(root_0, DeviationTolerance96_tree);
					}

					pushFollow(FOLLOW_expr_add_in_weight_trunk1577);
					t=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

					if ( state.backtracking==0 ) {weight_stack.peek().wt_.deviationTolerance=(t!=null?input.toString(t.start,t.stop):null);}
					}
					break;

			}

			VARIABLE97=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_weight_trunk1589); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			VARIABLE97_tree = (CommonTree)adaptor.create(VARIABLE97);
			adaptor.addChild(root_0, VARIABLE97_tree);
			}

			// WreslPlus.g:408:14: ( weight_group_unit | weight_subgroup )+
			int cnt23=0;
			loop23:
			while (true) {
				int alt23=3;
				int LA23_0 = input.LA(1);
				if ( (LA23_0==ID) ) {
					int LA23_2 = input.LA(2);
					if ( (LA23_2==125) ) {
						alt23=2;
					}
					else if ( (LA23_2==ID||LA23_2==126) ) {
						alt23=1;
					}

				}

				switch (alt23) {
				case 1 :
					// WreslPlus.g:408:16: weight_group_unit
					{
					pushFollow(FOLLOW_weight_group_unit_in_weight_trunk1593);
					weight_group_unit98=weight_group_unit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, weight_group_unit98.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:408:36: weight_subgroup
					{
					pushFollow(FOLLOW_weight_subgroup_in_weight_trunk1597);
					weight_subgroup99=weight_subgroup();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, weight_subgroup99.getTree());

					}
					break;

				default :
					if ( cnt23 >= 1 ) break loop23;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(23, input);
					throw eee;
				}
				cnt23++;
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
	// $ANTLR end "weight_trunk"


	public static class weight_group_unit_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "weight_group_unit"
	// WreslPlus.g:411:1: weight_group_unit : i= ID ;
	public final WreslPlusParser.weight_group_unit_return weight_group_unit() throws RecognitionException {
		WreslPlusParser.weight_group_unit_return retval = new WreslPlusParser.weight_group_unit_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;

		CommonTree i_tree=null;

		try {
			// WreslPlus.g:411:19: (i= ID )
			// WreslPlus.g:411:21: i= ID
			{
			root_0 = (CommonTree)adaptor.nil();


			i=(Token)match(input,ID,FOLLOW_ID_in_weight_group_unit1619); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) {weight_stack.peek().wt_.varList.add((i!=null?i.getText():null));}
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
	// $ANTLR end "weight_group_unit"


	protected static class weight_subgroup_scope {
		WeightSubgroup sub_;
	}
	protected Stack<weight_subgroup_scope> weight_subgroup_stack = new Stack<weight_subgroup_scope>();

	public static class weight_subgroup_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "weight_subgroup"
	// WreslPlus.g:413:1: weight_subgroup : i= ID '{' weight_subgroup_trunk '}' ;
	public final WreslPlusParser.weight_subgroup_return weight_subgroup() throws RecognitionException {
		weight_subgroup_stack.push(new weight_subgroup_scope());
		WreslPlusParser.weight_subgroup_return retval = new WreslPlusParser.weight_subgroup_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token char_literal100=null;
		Token char_literal102=null;
		ParserRuleReturnScope weight_subgroup_trunk101 =null;

		CommonTree i_tree=null;
		CommonTree char_literal100_tree=null;
		CommonTree char_literal102_tree=null;

		 weight_subgroup_stack.peek().sub_ = new WeightSubgroup(); 
		try {
			// WreslPlus.g:421:2: (i= ID '{' weight_subgroup_trunk '}' )
			// WreslPlus.g:421:5: i= ID '{' weight_subgroup_trunk '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			i=(Token)match(input,ID,FOLLOW_ID_in_weight_subgroup1649); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			char_literal100=(Token)match(input,125,FOLLOW_125_in_weight_subgroup1656); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal100_tree = (CommonTree)adaptor.create(char_literal100);
			adaptor.addChild(root_0, char_literal100_tree);
			}

			pushFollow(FOLLOW_weight_subgroup_trunk_in_weight_subgroup1658);
			weight_subgroup_trunk101=weight_subgroup_trunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, weight_subgroup_trunk101.getTree());

			char_literal102=(Token)match(input,126,FOLLOW_126_in_weight_subgroup1660); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal102_tree = (CommonTree)adaptor.create(char_literal102);
			adaptor.addChild(root_0, char_literal102_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { weight_subgroup_stack.peek().sub_.id=(i!=null?i.getText():null);
			        weight_stack.peek().wt_.subgroupMap.put((i!=null?i.getText():null),weight_subgroup_stack.peek().sub_); 
			        //weight_stack.peek().wt_.varList.add((i!=null?i.getText():null));
			        //System.out.println("subgroup: "+weight_stack.peek().wt_.subgroupMap.keySet());
			      }
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			weight_subgroup_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "weight_subgroup"


	public static class weight_subgroup_trunk_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "weight_subgroup_trunk"
	// WreslPlus.g:425:1: weight_subgroup_trunk : ( DeviationPenalty p= expr_add )? ( DeviationTolerance t= expr_add )? VARIABLE ( ( weight_subgroup_unit )+ ) ;
	public final WreslPlusParser.weight_subgroup_trunk_return weight_subgroup_trunk() throws RecognitionException {
		WreslPlusParser.weight_subgroup_trunk_return retval = new WreslPlusParser.weight_subgroup_trunk_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DeviationPenalty103=null;
		Token DeviationTolerance104=null;
		Token VARIABLE105=null;
		ParserRuleReturnScope p =null;
		ParserRuleReturnScope t =null;
		ParserRuleReturnScope weight_subgroup_unit106 =null;

		CommonTree DeviationPenalty103_tree=null;
		CommonTree DeviationTolerance104_tree=null;
		CommonTree VARIABLE105_tree=null;

		try {
			// WreslPlus.g:426:2: ( ( DeviationPenalty p= expr_add )? ( DeviationTolerance t= expr_add )? VARIABLE ( ( weight_subgroup_unit )+ ) )
			// WreslPlus.g:426:5: ( DeviationPenalty p= expr_add )? ( DeviationTolerance t= expr_add )? VARIABLE ( ( weight_subgroup_unit )+ )
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:426:5: ( DeviationPenalty p= expr_add )?
			int alt24=2;
			int LA24_0 = input.LA(1);
			if ( (LA24_0==DeviationPenalty) ) {
				alt24=1;
			}
			switch (alt24) {
				case 1 :
					// WreslPlus.g:426:7: DeviationPenalty p= expr_add
					{
					DeviationPenalty103=(Token)match(input,DeviationPenalty,FOLLOW_DeviationPenalty_in_weight_subgroup_trunk1675); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DeviationPenalty103_tree = (CommonTree)adaptor.create(DeviationPenalty103);
					adaptor.addChild(root_0, DeviationPenalty103_tree);
					}

					pushFollow(FOLLOW_expr_add_in_weight_subgroup_trunk1681);
					p=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, p.getTree());

					if ( state.backtracking==0 ) {weight_subgroup_stack.peek().sub_.deviationPenalty=(p!=null?input.toString(p.start,p.stop):null);}
					}
					break;

			}

			// WreslPlus.g:427:5: ( DeviationTolerance t= expr_add )?
			int alt25=2;
			int LA25_0 = input.LA(1);
			if ( (LA25_0==DeviationTolerance) ) {
				alt25=1;
			}
			switch (alt25) {
				case 1 :
					// WreslPlus.g:427:7: DeviationTolerance t= expr_add
					{
					DeviationTolerance104=(Token)match(input,DeviationTolerance,FOLLOW_DeviationTolerance_in_weight_subgroup_trunk1695); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DeviationTolerance104_tree = (CommonTree)adaptor.create(DeviationTolerance104);
					adaptor.addChild(root_0, DeviationTolerance104_tree);
					}

					pushFollow(FOLLOW_expr_add_in_weight_subgroup_trunk1699);
					t=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

					if ( state.backtracking==0 ) {weight_subgroup_stack.peek().sub_.deviationTolerance=(t!=null?input.toString(t.start,t.stop):null);}
					}
					break;

			}

			VARIABLE105=(Token)match(input,VARIABLE,FOLLOW_VARIABLE_in_weight_subgroup_trunk1711); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			VARIABLE105_tree = (CommonTree)adaptor.create(VARIABLE105);
			adaptor.addChild(root_0, VARIABLE105_tree);
			}

			// WreslPlus.g:428:14: ( ( weight_subgroup_unit )+ )
			// WreslPlus.g:428:16: ( weight_subgroup_unit )+
			{
			// WreslPlus.g:428:16: ( weight_subgroup_unit )+
			int cnt26=0;
			loop26:
			while (true) {
				int alt26=2;
				int LA26_0 = input.LA(1);
				if ( (LA26_0==ID) ) {
					alt26=1;
				}

				switch (alt26) {
				case 1 :
					// WreslPlus.g:428:16: weight_subgroup_unit
					{
					pushFollow(FOLLOW_weight_subgroup_unit_in_weight_subgroup_trunk1715);
					weight_subgroup_unit106=weight_subgroup_unit();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, weight_subgroup_unit106.getTree());

					}
					break;

				default :
					if ( cnt26 >= 1 ) break loop26;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(26, input);
					throw eee;
				}
				cnt26++;
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
	// $ANTLR end "weight_subgroup_trunk"


	public static class weight_subgroup_unit_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "weight_subgroup_unit"
	// WreslPlus.g:431:1: weight_subgroup_unit : i= ID ;
	public final WreslPlusParser.weight_subgroup_unit_return weight_subgroup_unit() throws RecognitionException {
		WreslPlusParser.weight_subgroup_unit_return retval = new WreslPlusParser.weight_subgroup_unit_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;

		CommonTree i_tree=null;

		try {
			// WreslPlus.g:431:22: (i= ID )
			// WreslPlus.g:431:24: i= ID
			{
			root_0 = (CommonTree)adaptor.nil();


			i=(Token)match(input,ID,FOLLOW_ID_in_weight_subgroup_unit1733); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) {weight_subgroup_stack.peek().sub_.varList.add((i!=null?i.getText():null));}
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
	// $ANTLR end "weight_subgroup_unit"


	public static class include_model_return extends ParserRuleReturnScope {
		public String id;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "include_model"
	// WreslPlus.g:434:1: include_model returns [String id] : INCLUDE ( MODEL | GROUP ) i= ID ;
	public final WreslPlusParser.include_model_return include_model() throws RecognitionException {
		WreslPlusParser.include_model_return retval = new WreslPlusParser.include_model_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token INCLUDE107=null;
		Token set108=null;

		CommonTree i_tree=null;
		CommonTree INCLUDE107_tree=null;
		CommonTree set108_tree=null;

		try {
			// WreslPlus.g:434:34: ( INCLUDE ( MODEL | GROUP ) i= ID )
			// WreslPlus.g:434:36: INCLUDE ( MODEL | GROUP ) i= ID
			{
			root_0 = (CommonTree)adaptor.nil();


			INCLUDE107=(Token)match(input,INCLUDE,FOLLOW_INCLUDE_in_include_model1749); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INCLUDE107_tree = (CommonTree)adaptor.create(INCLUDE107);
			adaptor.addChild(root_0, INCLUDE107_tree);
			}

			set108=input.LT(1);
			if ( input.LA(1)==GROUP||input.LA(1)==MODEL ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set108));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			i=(Token)match(input,ID,FOLLOW_ID_in_include_model1759); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) {retval.id =(i!=null?i.getText():null);}
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
	// $ANTLR end "include_model"


	public static class include_file_return extends ParserRuleReturnScope {
		public String id;
		public IncFileTemp incFileObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "include_file"
	// WreslPlus.g:436:1: include_file returns [String id, IncFileTemp incFileObj] : INCLUDE ( local_deprecated )? fp= file_path ;
	public final WreslPlusParser.include_file_return include_file() throws RecognitionException {
		WreslPlusParser.include_file_return retval = new WreslPlusParser.include_file_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INCLUDE109=null;
		ParserRuleReturnScope fp =null;
		ParserRuleReturnScope local_deprecated110 =null;

		CommonTree INCLUDE109_tree=null;

		 retval.incFileObj = new IncFileTemp();
		       retval.incFileObj.id = "__file__"+Integer.toString(mt_stack.peek().m_.incFileIDList.size()); 
		       retval.id = retval.incFileObj.id;
		       
		try {
			// WreslPlus.g:441:7: ( INCLUDE ( local_deprecated )? fp= file_path )
			// WreslPlus.g:441:9: INCLUDE ( local_deprecated )? fp= file_path
			{
			root_0 = (CommonTree)adaptor.nil();


			INCLUDE109=(Token)match(input,INCLUDE,FOLLOW_INCLUDE_in_include_file1785); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INCLUDE109_tree = (CommonTree)adaptor.create(INCLUDE109);
			adaptor.addChild(root_0, INCLUDE109_tree);
			}

			// WreslPlus.g:441:17: ( local_deprecated )?
			int alt27=2;
			int LA27_0 = input.LA(1);
			if ( (LA27_0==119) ) {
				alt27=1;
			}
			switch (alt27) {
				case 1 :
					// WreslPlus.g:441:18: local_deprecated
					{
					pushFollow(FOLLOW_local_deprecated_in_include_file1788);
					local_deprecated110=local_deprecated();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, local_deprecated110.getTree());

					}
					break;

			}

			pushFollow(FOLLOW_file_path_in_include_file1794);
			fp=file_path();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, fp.getTree());

			if ( state.backtracking==0 ) {retval.incFileObj.rawPath=Tools.strip((fp!=null?input.toString(fp.start,fp.stop):null));}
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
	// $ANTLR end "include_file"


	public static class file_path_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "file_path"
	// WreslPlus.g:443:1: file_path : QUOTE ;
	public final WreslPlusParser.file_path_return file_path() throws RecognitionException {
		WreslPlusParser.file_path_return retval = new WreslPlusParser.file_path_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token QUOTE111=null;

		CommonTree QUOTE111_tree=null;

		try {
			// WreslPlus.g:443:11: ( QUOTE )
			// WreslPlus.g:443:13: QUOTE
			{
			root_0 = (CommonTree)adaptor.nil();


			QUOTE111=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_file_path1807); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTE111_tree = (CommonTree)adaptor.create(QUOTE111);
			adaptor.addChild(root_0, QUOTE111_tree);
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
	// $ANTLR end "file_path"


	protected static class goal_s_scope {
		GoalTemp gl_;
		String id_;
	}
	protected Stack<goal_s_scope> goal_s_stack = new Stack<goal_s_scope>();

	public static class goal_s_return extends ParserRuleReturnScope {
		public String id;
		public GoalTemp glObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goal_s"
	// WreslPlus.g:447:1: goal_s returns [String id, GoalTemp glObj] : GOAL ( local_deprecated )? ( goalSimpleArray | goalSimpleTimeArray )? i= ID '{' (e= expr_constraint ) '}' ;
	public final WreslPlusParser.goal_s_return goal_s() throws RecognitionException {
		goal_s_stack.push(new goal_s_scope());
		WreslPlusParser.goal_s_return retval = new WreslPlusParser.goal_s_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token GOAL112=null;
		Token char_literal116=null;
		Token char_literal117=null;
		ParserRuleReturnScope e =null;
		ParserRuleReturnScope local_deprecated113 =null;
		ParserRuleReturnScope goalSimpleArray114 =null;
		ParserRuleReturnScope goalSimpleTimeArray115 =null;

		CommonTree i_tree=null;
		CommonTree GOAL112_tree=null;
		CommonTree char_literal116_tree=null;
		CommonTree char_literal117_tree=null;

		 goal_s_stack.peek().gl_ = new GoalTemp(); 
		       goal_s_stack.peek().gl_.fromWresl = this.currentAbsolutePath;
		       goal_s_stack.peek().gl_.hasCase = false; 
		       dependants = new LinkedHashSet<String>();
		       varInCycle = new LinkedHashSet<String>();    
			 
		try {
			// WreslPlus.g:464:2: ( GOAL ( local_deprecated )? ( goalSimpleArray | goalSimpleTimeArray )? i= ID '{' (e= expr_constraint ) '}' )
			// WreslPlus.g:464:4: GOAL ( local_deprecated )? ( goalSimpleArray | goalSimpleTimeArray )? i= ID '{' (e= expr_constraint ) '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			GOAL112=(Token)match(input,GOAL,FOLLOW_GOAL_in_goal_s1839); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			GOAL112_tree = (CommonTree)adaptor.create(GOAL112);
			adaptor.addChild(root_0, GOAL112_tree);
			}

			if ( state.backtracking==0 ) {line=(GOAL112!=null?GOAL112.getLine():0);}
			// WreslPlus.g:464:27: ( local_deprecated )?
			int alt28=2;
			int LA28_0 = input.LA(1);
			if ( (LA28_0==119) ) {
				int LA28_1 = input.LA(2);
				if ( (LA28_1==LOCAL) ) {
					alt28=1;
				}
			}
			switch (alt28) {
				case 1 :
					// WreslPlus.g:464:28: local_deprecated
					{
					pushFollow(FOLLOW_local_deprecated_in_goal_s1843);
					local_deprecated113=local_deprecated();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, local_deprecated113.getTree());

					}
					break;

			}

			// WreslPlus.g:464:47: ( goalSimpleArray | goalSimpleTimeArray )?
			int alt29=3;
			int LA29_0 = input.LA(1);
			if ( (LA29_0==119) ) {
				alt29=1;
			}
			else if ( (LA29_0==103) ) {
				alt29=2;
			}
			switch (alt29) {
				case 1 :
					// WreslPlus.g:464:48: goalSimpleArray
					{
					pushFollow(FOLLOW_goalSimpleArray_in_goal_s1848);
					goalSimpleArray114=goalSimpleArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalSimpleArray114.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:464:64: goalSimpleTimeArray
					{
					pushFollow(FOLLOW_goalSimpleTimeArray_in_goal_s1850);
					goalSimpleTimeArray115=goalSimpleTimeArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalSimpleTimeArray115.getTree());

					}
					break;

			}

			i=(Token)match(input,ID,FOLLOW_ID_in_goal_s1856); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			char_literal116=(Token)match(input,125,FOLLOW_125_in_goal_s1859); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal116_tree = (CommonTree)adaptor.create(char_literal116);
			adaptor.addChild(root_0, char_literal116_tree);
			}

			// WreslPlus.g:464:96: (e= expr_constraint )
			// WreslPlus.g:464:98: e= expr_constraint
			{
			pushFollow(FOLLOW_expr_constraint_in_goal_s1865);
			e=expr_constraint();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

			}

			char_literal117=(Token)match(input,126,FOLLOW_126_in_goal_s1868); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal117_tree = (CommonTree)adaptor.create(char_literal117);
			adaptor.addChild(root_0, char_literal117_tree);
			}

			if ( state.backtracking==0 ) {goal_s_stack.peek().gl_.id=(i!=null?i.getText():null); 
				 goal_s_stack.peek().gl_.caseCondition.add(Param.always);
				 goal_s_stack.peek().gl_.caseName.add(Param.defaultCaseName);
				 goal_s_stack.peek().gl_.caseExpression.add((e!=null?input.toString(e.start,e.stop):null));}
			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { retval.id = goal_s_stack.peek().gl_.id; 
			        retval.glObj =goal_s_stack.peek().gl_; 
			        retval.glObj.dependants= dependants;
			        retval.glObj.neededVarInCycleSet= varInCycle;
			        retval.glObj.needVarFromEarlierCycle = (varInCycle!=null);
			        retval.glObj.line=line;}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			goal_s_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "goal_s"


	public static class goalSimpleArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goalSimpleArray"
	// WreslPlus.g:470:1: goalSimpleArray : '[' d= ( INT | ID ) ']' ;
	public final WreslPlusParser.goalSimpleArray_return goalSimpleArray() throws RecognitionException {
		WreslPlusParser.goalSimpleArray_return retval = new WreslPlusParser.goalSimpleArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token d=null;
		Token char_literal118=null;
		Token char_literal119=null;

		CommonTree d_tree=null;
		CommonTree char_literal118_tree=null;
		CommonTree char_literal119_tree=null;

		try {
			// WreslPlus.g:470:17: ( '[' d= ( INT | ID ) ']' )
			// WreslPlus.g:470:23: '[' d= ( INT | ID ) ']'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal118=(Token)match(input,119,FOLLOW_119_in_goalSimpleArray1884); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal118_tree = (CommonTree)adaptor.create(char_literal118);
			adaptor.addChild(root_0, char_literal118_tree);
			}

			d=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(d));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal119=(Token)match(input,120,FOLLOW_120_in_goalSimpleArray1898); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal119_tree = (CommonTree)adaptor.create(char_literal119);
			adaptor.addChild(root_0, char_literal119_tree);
			}

			if ( state.backtracking==0 ) {goal_s_stack.peek().gl_.arraySize=(d!=null?d.getText():null); }
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
	// $ANTLR end "goalSimpleArray"


	public static class goalSimpleTimeArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goalSimpleTimeArray"
	// WreslPlus.g:471:1: goalSimpleTimeArray : '(' d= ( INT | ID ) ')' ;
	public final WreslPlusParser.goalSimpleTimeArray_return goalSimpleTimeArray() throws RecognitionException {
		WreslPlusParser.goalSimpleTimeArray_return retval = new WreslPlusParser.goalSimpleTimeArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token d=null;
		Token char_literal120=null;
		Token char_literal121=null;

		CommonTree d_tree=null;
		CommonTree char_literal120_tree=null;
		CommonTree char_literal121_tree=null;

		try {
			// WreslPlus.g:471:21: ( '(' d= ( INT | ID ) ')' )
			// WreslPlus.g:471:23: '(' d= ( INT | ID ) ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal120=(Token)match(input,103,FOLLOW_103_in_goalSimpleTimeArray1908); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal120_tree = (CommonTree)adaptor.create(char_literal120);
			adaptor.addChild(root_0, char_literal120_tree);
			}

			d=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(d));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal121=(Token)match(input,104,FOLLOW_104_in_goalSimpleTimeArray1922); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal121_tree = (CommonTree)adaptor.create(char_literal121);
			adaptor.addChild(root_0, char_literal121_tree);
			}

			if ( state.backtracking==0 ) {goal_s_stack.peek().gl_.timeArraySize=(d!=null?d.getText():null); }
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
	// $ANTLR end "goalSimpleTimeArray"


	protected static class goal_hs_scope {
		GoalTemp gl_;
		String id_;
	}
	protected Stack<goal_hs_scope> goal_hs_stack = new Stack<goal_hs_scope>();

	public static class goal_hs_return extends ParserRuleReturnScope {
		public String id;
		public GoalTemp glObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goal_hs"
	// WreslPlus.g:475:1: goal_hs returns [String id, GoalTemp glObj] : GOAL ( local_deprecated )? ( goalHsArray | goalHsTimeArray )? i= ID '{' lhs ( goal_hs_nocase | goal_hs_cases ) '}' ;
	public final WreslPlusParser.goal_hs_return goal_hs() throws RecognitionException {
		goal_hs_stack.push(new goal_hs_scope());
		WreslPlusParser.goal_hs_return retval = new WreslPlusParser.goal_hs_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;
		Token GOAL122=null;
		Token char_literal126=null;
		Token char_literal130=null;
		ParserRuleReturnScope local_deprecated123 =null;
		ParserRuleReturnScope goalHsArray124 =null;
		ParserRuleReturnScope goalHsTimeArray125 =null;
		ParserRuleReturnScope lhs127 =null;
		ParserRuleReturnScope goal_hs_nocase128 =null;
		ParserRuleReturnScope goal_hs_cases129 =null;

		CommonTree i_tree=null;
		CommonTree GOAL122_tree=null;
		CommonTree char_literal126_tree=null;
		CommonTree char_literal130_tree=null;

		 goal_hs_stack.peek().gl_ = new GoalTemp(); 
		       goal_hs_stack.peek().gl_.fromWresl = this.currentAbsolutePath; 
		       dependants = new LinkedHashSet<String>();
		       varInCycle = new LinkedHashSet<String>();  
		       goal_hs_stack.peek().gl_.hasLhs=true;
			 
		try {
			// WreslPlus.g:491:2: ( GOAL ( local_deprecated )? ( goalHsArray | goalHsTimeArray )? i= ID '{' lhs ( goal_hs_nocase | goal_hs_cases ) '}' )
			// WreslPlus.g:491:4: GOAL ( local_deprecated )? ( goalHsArray | goalHsTimeArray )? i= ID '{' lhs ( goal_hs_nocase | goal_hs_cases ) '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			GOAL122=(Token)match(input,GOAL,FOLLOW_GOAL_in_goal_hs1954); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			GOAL122_tree = (CommonTree)adaptor.create(GOAL122);
			adaptor.addChild(root_0, GOAL122_tree);
			}

			if ( state.backtracking==0 ) {line=(GOAL122!=null?GOAL122.getLine():0);}
			// WreslPlus.g:491:27: ( local_deprecated )?
			int alt30=2;
			int LA30_0 = input.LA(1);
			if ( (LA30_0==119) ) {
				int LA30_1 = input.LA(2);
				if ( (LA30_1==LOCAL) ) {
					alt30=1;
				}
			}
			switch (alt30) {
				case 1 :
					// WreslPlus.g:491:28: local_deprecated
					{
					pushFollow(FOLLOW_local_deprecated_in_goal_hs1958);
					local_deprecated123=local_deprecated();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, local_deprecated123.getTree());

					}
					break;

			}

			// WreslPlus.g:491:47: ( goalHsArray | goalHsTimeArray )?
			int alt31=3;
			int LA31_0 = input.LA(1);
			if ( (LA31_0==119) ) {
				alt31=1;
			}
			else if ( (LA31_0==103) ) {
				alt31=2;
			}
			switch (alt31) {
				case 1 :
					// WreslPlus.g:491:48: goalHsArray
					{
					pushFollow(FOLLOW_goalHsArray_in_goal_hs1963);
					goalHsArray124=goalHsArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalHsArray124.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:491:60: goalHsTimeArray
					{
					pushFollow(FOLLOW_goalHsTimeArray_in_goal_hs1965);
					goalHsTimeArray125=goalHsTimeArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goalHsTimeArray125.getTree());

					}
					break;

			}

			i=(Token)match(input,ID,FOLLOW_ID_in_goal_hs1971); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) {goal_hs_stack.peek().gl_.id=(i!=null?i.getText():null);}
			char_literal126=(Token)match(input,125,FOLLOW_125_in_goal_hs1979); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal126_tree = (CommonTree)adaptor.create(char_literal126);
			adaptor.addChild(root_0, char_literal126_tree);
			}

			pushFollow(FOLLOW_lhs_in_goal_hs1981);
			lhs127=lhs();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs127.getTree());

			// WreslPlus.g:493:4: ( goal_hs_nocase | goal_hs_cases )
			int alt32=2;
			int LA32_0 = input.LA(1);
			if ( (LA32_0==RHS) ) {
				alt32=1;
			}
			else if ( (LA32_0==CASE) ) {
				alt32=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 32, 0, input);
				throw nvae;
			}

			switch (alt32) {
				case 1 :
					// WreslPlus.g:493:6: goal_hs_nocase
					{
					pushFollow(FOLLOW_goal_hs_nocase_in_goal_hs1989);
					goal_hs_nocase128=goal_hs_nocase();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goal_hs_nocase128.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:494:6: goal_hs_cases
					{
					pushFollow(FOLLOW_goal_hs_cases_in_goal_hs1999);
					goal_hs_cases129=goal_hs_cases();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goal_hs_cases129.getTree());

					}
					break;

			}

			char_literal130=(Token)match(input,126,FOLLOW_126_in_goal_hs2007); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal130_tree = (CommonTree)adaptor.create(char_literal130);
			adaptor.addChild(root_0, char_literal130_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { retval.id = goal_hs_stack.peek().gl_.id; 
			        retval.glObj =goal_hs_stack.peek().gl_; 
			        retval.glObj.dependants= dependants;
			        retval.glObj.neededVarInCycleSet= varInCycle;
			        retval.glObj.needVarFromEarlierCycle = (varInCycle!=null);
			        retval.glObj.line=line;}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			goal_hs_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "goal_hs"


	public static class goalHsArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goalHsArray"
	// WreslPlus.g:497:1: goalHsArray : '[' d= ( INT | ID ) ']' ;
	public final WreslPlusParser.goalHsArray_return goalHsArray() throws RecognitionException {
		WreslPlusParser.goalHsArray_return retval = new WreslPlusParser.goalHsArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token d=null;
		Token char_literal131=null;
		Token char_literal132=null;

		CommonTree d_tree=null;
		CommonTree char_literal131_tree=null;
		CommonTree char_literal132_tree=null;

		try {
			// WreslPlus.g:497:13: ( '[' d= ( INT | ID ) ']' )
			// WreslPlus.g:497:19: '[' d= ( INT | ID ) ']'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal131=(Token)match(input,119,FOLLOW_119_in_goalHsArray2019); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal131_tree = (CommonTree)adaptor.create(char_literal131);
			adaptor.addChild(root_0, char_literal131_tree);
			}

			d=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(d));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal132=(Token)match(input,120,FOLLOW_120_in_goalHsArray2033); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal132_tree = (CommonTree)adaptor.create(char_literal132);
			adaptor.addChild(root_0, char_literal132_tree);
			}

			if ( state.backtracking==0 ) {goal_hs_stack.peek().gl_.arraySize=(d!=null?d.getText():null); }
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
	// $ANTLR end "goalHsArray"


	public static class goalHsTimeArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goalHsTimeArray"
	// WreslPlus.g:498:1: goalHsTimeArray : '(' d= ( INT | ID ) ')' ;
	public final WreslPlusParser.goalHsTimeArray_return goalHsTimeArray() throws RecognitionException {
		WreslPlusParser.goalHsTimeArray_return retval = new WreslPlusParser.goalHsTimeArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token d=null;
		Token char_literal133=null;
		Token char_literal134=null;

		CommonTree d_tree=null;
		CommonTree char_literal133_tree=null;
		CommonTree char_literal134_tree=null;

		try {
			// WreslPlus.g:498:17: ( '(' d= ( INT | ID ) ')' )
			// WreslPlus.g:498:19: '(' d= ( INT | ID ) ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal133=(Token)match(input,103,FOLLOW_103_in_goalHsTimeArray2043); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal133_tree = (CommonTree)adaptor.create(char_literal133);
			adaptor.addChild(root_0, char_literal133_tree);
			}

			d=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(d));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal134=(Token)match(input,104,FOLLOW_104_in_goalHsTimeArray2057); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal134_tree = (CommonTree)adaptor.create(char_literal134);
			adaptor.addChild(root_0, char_literal134_tree);
			}

			if ( state.backtracking==0 ) {goal_hs_stack.peek().gl_.timeArraySize=(d!=null?d.getText():null); }
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
	// $ANTLR end "goalHsTimeArray"


	public static class goal_hs_nocase_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goal_hs_nocase"
	// WreslPlus.g:500:1: goal_hs_nocase : t= goal_hs_trunk ;
	public final WreslPlusParser.goal_hs_nocase_return goal_hs_nocase() throws RecognitionException {
		WreslPlusParser.goal_hs_nocase_return retval = new WreslPlusParser.goal_hs_nocase_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope t =null;


		try {
			// WreslPlus.g:506:2: (t= goal_hs_trunk )
			// WreslPlus.g:506:4: t= goal_hs_trunk
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_goal_hs_trunk_in_goal_hs_nocase2075);
			t=goal_hs_trunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { (t!=null?((WreslPlusParser.goal_hs_trunk_return)t).gc:null).id = Param.defaultCaseName;
					goal_hs_stack.peek().gl_.caseName.add((t!=null?((WreslPlusParser.goal_hs_trunk_return)t).gc:null).id); 
					goal_hs_stack.peek().gl_.caseMap.put((t!=null?((WreslPlusParser.goal_hs_trunk_return)t).gc:null).id, (t!=null?((WreslPlusParser.goal_hs_trunk_return)t).gc:null));
					goal_hs_stack.peek().gl_.hasCase = false;
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
	// $ANTLR end "goal_hs_nocase"


	protected static class goal_hs_trunk_scope {
		GoalCase gc_;
	}
	protected Stack<goal_hs_trunk_scope> goal_hs_trunk_stack = new Stack<goal_hs_trunk_scope>();

	public static class goal_hs_trunk_return extends ParserRuleReturnScope {
		public GoalCase gc;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goal_hs_trunk"
	// WreslPlus.g:508:1: goal_hs_trunk returns [GoalCase gc] : rhs ( ( lhs_gt_rhs ( lhs_lt_rhs )? ) | ( lhs_lt_rhs ( lhs_gt_rhs )? ) )? ;
	public final WreslPlusParser.goal_hs_trunk_return goal_hs_trunk() throws RecognitionException {
		goal_hs_trunk_stack.push(new goal_hs_trunk_scope());
		WreslPlusParser.goal_hs_trunk_return retval = new WreslPlusParser.goal_hs_trunk_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope rhs135 =null;
		ParserRuleReturnScope lhs_gt_rhs136 =null;
		ParserRuleReturnScope lhs_lt_rhs137 =null;
		ParserRuleReturnScope lhs_lt_rhs138 =null;
		ParserRuleReturnScope lhs_gt_rhs139 =null;


		 goal_hs_trunk_stack.peek().gc_ = new GoalCase();
		try {
			// WreslPlus.g:512:2: ( rhs ( ( lhs_gt_rhs ( lhs_lt_rhs )? ) | ( lhs_lt_rhs ( lhs_gt_rhs )? ) )? )
			// WreslPlus.g:512:5: rhs ( ( lhs_gt_rhs ( lhs_lt_rhs )? ) | ( lhs_lt_rhs ( lhs_gt_rhs )? ) )?
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_rhs_in_goal_hs_trunk2103);
			rhs135=rhs();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rhs135.getTree());

			// WreslPlus.g:512:9: ( ( lhs_gt_rhs ( lhs_lt_rhs )? ) | ( lhs_lt_rhs ( lhs_gt_rhs )? ) )?
			int alt35=3;
			int LA35_0 = input.LA(1);
			if ( (LA35_0==LHS) ) {
				int LA35_1 = input.LA(2);
				if ( (LA35_1==117) ) {
					alt35=1;
				}
				else if ( (LA35_1==113) ) {
					alt35=2;
				}
			}
			switch (alt35) {
				case 1 :
					// WreslPlus.g:512:10: ( lhs_gt_rhs ( lhs_lt_rhs )? )
					{
					// WreslPlus.g:512:10: ( lhs_gt_rhs ( lhs_lt_rhs )? )
					// WreslPlus.g:512:11: lhs_gt_rhs ( lhs_lt_rhs )?
					{
					pushFollow(FOLLOW_lhs_gt_rhs_in_goal_hs_trunk2107);
					lhs_gt_rhs136=lhs_gt_rhs();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs_gt_rhs136.getTree());

					// WreslPlus.g:512:22: ( lhs_lt_rhs )?
					int alt33=2;
					int LA33_0 = input.LA(1);
					if ( (LA33_0==LHS) ) {
						alt33=1;
					}
					switch (alt33) {
						case 1 :
							// WreslPlus.g:512:22: lhs_lt_rhs
							{
							pushFollow(FOLLOW_lhs_lt_rhs_in_goal_hs_trunk2109);
							lhs_lt_rhs137=lhs_lt_rhs();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs_lt_rhs137.getTree());

							}
							break;

					}

					}

					}
					break;
				case 2 :
					// WreslPlus.g:512:37: ( lhs_lt_rhs ( lhs_gt_rhs )? )
					{
					// WreslPlus.g:512:37: ( lhs_lt_rhs ( lhs_gt_rhs )? )
					// WreslPlus.g:512:38: lhs_lt_rhs ( lhs_gt_rhs )?
					{
					pushFollow(FOLLOW_lhs_lt_rhs_in_goal_hs_trunk2116);
					lhs_lt_rhs138=lhs_lt_rhs();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs_lt_rhs138.getTree());

					// WreslPlus.g:512:49: ( lhs_gt_rhs )?
					int alt34=2;
					int LA34_0 = input.LA(1);
					if ( (LA34_0==LHS) ) {
						alt34=1;
					}
					switch (alt34) {
						case 1 :
							// WreslPlus.g:512:49: lhs_gt_rhs
							{
							pushFollow(FOLLOW_lhs_gt_rhs_in_goal_hs_trunk2118);
							lhs_gt_rhs139=lhs_gt_rhs();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, lhs_gt_rhs139.getTree());

							}
							break;

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
			if ( state.backtracking==0 ) { retval.gc =goal_hs_trunk_stack.peek().gc_;}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			goal_hs_trunk_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "goal_hs_trunk"


	public static class goal_hs_cases_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goal_hs_cases"
	// WreslPlus.g:514:1: goal_hs_cases : ( goal_hs_case )+ ;
	public final WreslPlusParser.goal_hs_cases_return goal_hs_cases() throws RecognitionException {
		WreslPlusParser.goal_hs_cases_return retval = new WreslPlusParser.goal_hs_cases_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope goal_hs_case140 =null;


		try {
			// WreslPlus.g:514:15: ( ( goal_hs_case )+ )
			// WreslPlus.g:514:17: ( goal_hs_case )+
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:514:17: ( goal_hs_case )+
			int cnt36=0;
			loop36:
			while (true) {
				int alt36=2;
				int LA36_0 = input.LA(1);
				if ( (LA36_0==CASE) ) {
					alt36=1;
				}

				switch (alt36) {
				case 1 :
					// WreslPlus.g:514:17: goal_hs_case
					{
					pushFollow(FOLLOW_goal_hs_case_in_goal_hs_cases2131);
					goal_hs_case140=goal_hs_case();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, goal_hs_case140.getTree());

					}
					break;

				default :
					if ( cnt36 >= 1 ) break loop36;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(36, input);
					throw eee;
				}
				cnt36++;
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
	// $ANTLR end "goal_hs_cases"


	public static class goal_hs_case_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "goal_hs_case"
	// WreslPlus.g:516:1: goal_hs_case : CASE ci= ID '{' CONDITION cc= logical_main t= goal_hs_trunk '}' ;
	public final WreslPlusParser.goal_hs_case_return goal_hs_case() throws RecognitionException {
		WreslPlusParser.goal_hs_case_return retval = new WreslPlusParser.goal_hs_case_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ci=null;
		Token CASE141=null;
		Token char_literal142=null;
		Token CONDITION143=null;
		Token char_literal144=null;
		ParserRuleReturnScope cc =null;
		ParserRuleReturnScope t =null;

		CommonTree ci_tree=null;
		CommonTree CASE141_tree=null;
		CommonTree char_literal142_tree=null;
		CommonTree CONDITION143_tree=null;
		CommonTree char_literal144_tree=null;

		try {
			// WreslPlus.g:522:2: ( CASE ci= ID '{' CONDITION cc= logical_main t= goal_hs_trunk '}' )
			// WreslPlus.g:522:4: CASE ci= ID '{' CONDITION cc= logical_main t= goal_hs_trunk '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			CASE141=(Token)match(input,CASE,FOLLOW_CASE_in_goal_hs_case2146); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CASE141_tree = (CommonTree)adaptor.create(CASE141);
			adaptor.addChild(root_0, CASE141_tree);
			}

			ci=(Token)match(input,ID,FOLLOW_ID_in_goal_hs_case2150); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ci_tree = (CommonTree)adaptor.create(ci);
			adaptor.addChild(root_0, ci_tree);
			}

			char_literal142=(Token)match(input,125,FOLLOW_125_in_goal_hs_case2152); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal142_tree = (CommonTree)adaptor.create(char_literal142);
			adaptor.addChild(root_0, char_literal142_tree);
			}

			CONDITION143=(Token)match(input,CONDITION,FOLLOW_CONDITION_in_goal_hs_case2154); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CONDITION143_tree = (CommonTree)adaptor.create(CONDITION143);
			adaptor.addChild(root_0, CONDITION143_tree);
			}

			pushFollow(FOLLOW_logical_main_in_goal_hs_case2158);
			cc=logical_main();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, cc.getTree());

			pushFollow(FOLLOW_goal_hs_trunk_in_goal_hs_case2162);
			t=goal_hs_trunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, t.getTree());

			char_literal144=(Token)match(input,126,FOLLOW_126_in_goal_hs_case2165); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal144_tree = (CommonTree)adaptor.create(char_literal144);
			adaptor.addChild(root_0, char_literal144_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { (t!=null?((WreslPlusParser.goal_hs_trunk_return)t).gc:null).id = (ci!=null?ci.getText():null);
					(t!=null?((WreslPlusParser.goal_hs_trunk_return)t).gc:null).condition = (cc!=null?input.toString(cc.start,cc.stop):null);
					goal_hs_stack.peek().gl_.caseName.add((t!=null?((WreslPlusParser.goal_hs_trunk_return)t).gc:null).id); 
					goal_hs_stack.peek().gl_.caseMap.put((t!=null?((WreslPlusParser.goal_hs_trunk_return)t).gc:null).id, (t!=null?((WreslPlusParser.goal_hs_trunk_return)t).gc:null));
					goal_hs_stack.peek().gl_.hasCase = true;}
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
	// $ANTLR end "goal_hs_case"


	public static class lhs_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lhs"
	// WreslPlus.g:525:1: lhs : LHS e= expr_add ;
	public final WreslPlusParser.lhs_return lhs() throws RecognitionException {
		WreslPlusParser.lhs_return retval = new WreslPlusParser.lhs_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LHS145=null;
		ParserRuleReturnScope e =null;

		CommonTree LHS145_tree=null;

		try {
			// WreslPlus.g:525:5: ( LHS e= expr_add )
			// WreslPlus.g:525:7: LHS e= expr_add
			{
			root_0 = (CommonTree)adaptor.nil();


			LHS145=(Token)match(input,LHS,FOLLOW_LHS_in_lhs2175); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LHS145_tree = (CommonTree)adaptor.create(LHS145);
			adaptor.addChild(root_0, LHS145_tree);
			}

			pushFollow(FOLLOW_expr_add_in_lhs2179);
			e=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

			if ( state.backtracking==0 ) {goal_hs_stack.peek().gl_.lhs=(e!=null?input.toString(e.start,e.stop):null);}
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
	// $ANTLR end "lhs"


	public static class rhs_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rhs"
	// WreslPlus.g:526:1: rhs : RHS e= expr_add ;
	public final WreslPlusParser.rhs_return rhs() throws RecognitionException {
		WreslPlusParser.rhs_return retval = new WreslPlusParser.rhs_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token RHS146=null;
		ParserRuleReturnScope e =null;

		CommonTree RHS146_tree=null;

		try {
			// WreslPlus.g:526:5: ( RHS e= expr_add )
			// WreslPlus.g:526:7: RHS e= expr_add
			{
			root_0 = (CommonTree)adaptor.nil();


			RHS146=(Token)match(input,RHS,FOLLOW_RHS_in_rhs2189); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RHS146_tree = (CommonTree)adaptor.create(RHS146);
			adaptor.addChild(root_0, RHS146_tree);
			}

			pushFollow(FOLLOW_expr_add_in_rhs2193);
			e=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

			if ( state.backtracking==0 ) {goal_hs_trunk_stack.peek().gc_.rhs=(e!=null?input.toString(e.start,e.stop):null);}
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
	// $ANTLR end "rhs"


	public static class lhs_gt_rhs_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lhs_gt_rhs"
	// WreslPlus.g:527:1: lhs_gt_rhs : LHS '>' RHS ( PENALTY p= expr_add | constrain ) ;
	public final WreslPlusParser.lhs_gt_rhs_return lhs_gt_rhs() throws RecognitionException {
		WreslPlusParser.lhs_gt_rhs_return retval = new WreslPlusParser.lhs_gt_rhs_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LHS147=null;
		Token char_literal148=null;
		Token RHS149=null;
		Token PENALTY150=null;
		ParserRuleReturnScope p =null;
		ParserRuleReturnScope constrain151 =null;

		CommonTree LHS147_tree=null;
		CommonTree char_literal148_tree=null;
		CommonTree RHS149_tree=null;
		CommonTree PENALTY150_tree=null;

		try {
			// WreslPlus.g:527:12: ( LHS '>' RHS ( PENALTY p= expr_add | constrain ) )
			// WreslPlus.g:527:14: LHS '>' RHS ( PENALTY p= expr_add | constrain )
			{
			root_0 = (CommonTree)adaptor.nil();


			LHS147=(Token)match(input,LHS,FOLLOW_LHS_in_lhs_gt_rhs2203); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LHS147_tree = (CommonTree)adaptor.create(LHS147);
			adaptor.addChild(root_0, LHS147_tree);
			}

			char_literal148=(Token)match(input,117,FOLLOW_117_in_lhs_gt_rhs2205); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal148_tree = (CommonTree)adaptor.create(char_literal148);
			adaptor.addChild(root_0, char_literal148_tree);
			}

			RHS149=(Token)match(input,RHS,FOLLOW_RHS_in_lhs_gt_rhs2207); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RHS149_tree = (CommonTree)adaptor.create(RHS149);
			adaptor.addChild(root_0, RHS149_tree);
			}

			// WreslPlus.g:527:26: ( PENALTY p= expr_add | constrain )
			int alt37=2;
			int LA37_0 = input.LA(1);
			if ( (LA37_0==PENALTY) ) {
				alt37=1;
			}
			else if ( (LA37_0==121) ) {
				alt37=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 37, 0, input);
				throw nvae;
			}

			switch (alt37) {
				case 1 :
					// WreslPlus.g:527:28: PENALTY p= expr_add
					{
					PENALTY150=(Token)match(input,PENALTY,FOLLOW_PENALTY_in_lhs_gt_rhs2211); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PENALTY150_tree = (CommonTree)adaptor.create(PENALTY150);
					adaptor.addChild(root_0, PENALTY150_tree);
					}

					pushFollow(FOLLOW_expr_add_in_lhs_gt_rhs2215);
					p=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, p.getTree());

					if ( state.backtracking==0 ) {goal_hs_trunk_stack.peek().gc_.lhs_gt_rhs=(p!=null?input.toString(p.start,p.stop):null);}
					}
					break;
				case 2 :
					// WreslPlus.g:527:91: constrain
					{
					pushFollow(FOLLOW_constrain_in_lhs_gt_rhs2221);
					constrain151=constrain();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constrain151.getTree());

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
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lhs_lt_rhs"
	// WreslPlus.g:528:1: lhs_lt_rhs : LHS '<' RHS ( PENALTY p= expr_add | constrain ) ;
	public final WreslPlusParser.lhs_lt_rhs_return lhs_lt_rhs() throws RecognitionException {
		WreslPlusParser.lhs_lt_rhs_return retval = new WreslPlusParser.lhs_lt_rhs_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LHS152=null;
		Token char_literal153=null;
		Token RHS154=null;
		Token PENALTY155=null;
		ParserRuleReturnScope p =null;
		ParserRuleReturnScope constrain156 =null;

		CommonTree LHS152_tree=null;
		CommonTree char_literal153_tree=null;
		CommonTree RHS154_tree=null;
		CommonTree PENALTY155_tree=null;

		try {
			// WreslPlus.g:528:12: ( LHS '<' RHS ( PENALTY p= expr_add | constrain ) )
			// WreslPlus.g:528:14: LHS '<' RHS ( PENALTY p= expr_add | constrain )
			{
			root_0 = (CommonTree)adaptor.nil();


			LHS152=(Token)match(input,LHS,FOLLOW_LHS_in_lhs_lt_rhs2231); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LHS152_tree = (CommonTree)adaptor.create(LHS152);
			adaptor.addChild(root_0, LHS152_tree);
			}

			char_literal153=(Token)match(input,113,FOLLOW_113_in_lhs_lt_rhs2233); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal153_tree = (CommonTree)adaptor.create(char_literal153);
			adaptor.addChild(root_0, char_literal153_tree);
			}

			RHS154=(Token)match(input,RHS,FOLLOW_RHS_in_lhs_lt_rhs2235); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RHS154_tree = (CommonTree)adaptor.create(RHS154);
			adaptor.addChild(root_0, RHS154_tree);
			}

			// WreslPlus.g:528:26: ( PENALTY p= expr_add | constrain )
			int alt38=2;
			int LA38_0 = input.LA(1);
			if ( (LA38_0==PENALTY) ) {
				alt38=1;
			}
			else if ( (LA38_0==121) ) {
				alt38=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 38, 0, input);
				throw nvae;
			}

			switch (alt38) {
				case 1 :
					// WreslPlus.g:528:28: PENALTY p= expr_add
					{
					PENALTY155=(Token)match(input,PENALTY,FOLLOW_PENALTY_in_lhs_lt_rhs2239); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					PENALTY155_tree = (CommonTree)adaptor.create(PENALTY155);
					adaptor.addChild(root_0, PENALTY155_tree);
					}

					pushFollow(FOLLOW_expr_add_in_lhs_lt_rhs2243);
					p=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, p.getTree());

					if ( state.backtracking==0 ) {goal_hs_trunk_stack.peek().gc_.lhs_lt_rhs=(p!=null?input.toString(p.start,p.stop):null);}
					}
					break;
				case 2 :
					// WreslPlus.g:528:91: constrain
					{
					pushFollow(FOLLOW_constrain_in_lhs_lt_rhs2249);
					constrain156=constrain();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, constrain156.getTree());

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


	public static class constrain_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "constrain"
	// WreslPlus.g:530:1: constrain : 'constrain' ;
	public final WreslPlusParser.constrain_return constrain() throws RecognitionException {
		WreslPlusParser.constrain_return retval = new WreslPlusParser.constrain_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal157=null;

		CommonTree string_literal157_tree=null;

		try {
			// WreslPlus.g:530:11: ( 'constrain' )
			// WreslPlus.g:530:13: 'constrain'
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal157=(Token)match(input,121,FOLLOW_121_in_constrain2260); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal157_tree = (CommonTree)adaptor.create(string_literal157);
			adaptor.addChild(root_0, string_literal157_tree);
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
	// $ANTLR end "constrain"


	protected static class alias_scope {
		AliasTemp as_;
	}
	protected Stack<alias_scope> alias_stack = new Stack<alias_scope>();

	public static class alias_return extends ParserRuleReturnScope {
		public String id;
		public AliasTemp asObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "alias"
	// WreslPlus.g:534:1: alias returns [String id, AliasTemp asObj] : ( alias_new | alias_old );
	public final WreslPlusParser.alias_return alias() throws RecognitionException {
		alias_stack.push(new alias_scope());
		WreslPlusParser.alias_return retval = new WreslPlusParser.alias_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope alias_new158 =null;
		ParserRuleReturnScope alias_old159 =null;


		 alias_stack.peek().as_ = new AliasTemp(); 
		       alias_stack.peek().as_.fromWresl = this.currentAbsolutePath; 
		       dependants = new LinkedHashSet<String>();
		       varInCycle = new LinkedHashSet<String>();  
			 
		try {
			// WreslPlus.g:547:2: ( alias_new | alias_old )
			int alt39=2;
			int LA39_0 = input.LA(1);
			if ( (LA39_0==ALIAS) ) {
				alt39=1;
			}
			else if ( (LA39_0==DEFINE) ) {
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
					// WreslPlus.g:547:4: alias_new
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_alias_new_in_alias2290);
					alias_new158=alias_new();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, alias_new158.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:547:16: alias_old
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_alias_old_in_alias2294);
					alias_old159=alias_old();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, alias_old159.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { retval.id = alias_stack.peek().as_.id; 
			        retval.asObj =alias_stack.peek().as_; 
			        retval.asObj.dependants= dependants;
			        retval.asObj.neededVarInCycleSet= varInCycle;
			        retval.asObj.needVarFromEarlierCycle = (varInCycle!=null);
			        retval.asObj.line=line;}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			alias_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "alias"


	public static class alias_old_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "alias_old"
	// WreslPlus.g:550:1: alias_old : DEFINE ( local_deprecated )? ( aliasArray | aliasTimeArray )? aliasID '{' ALIAS aliasExpresion ( aliasKind )? ( aliasUnits )? ( aliasNoSolver )? '}' ;
	public final WreslPlusParser.alias_old_return alias_old() throws RecognitionException {
		WreslPlusParser.alias_old_return retval = new WreslPlusParser.alias_old_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DEFINE160=null;
		Token char_literal165=null;
		Token ALIAS166=null;
		Token char_literal171=null;
		ParserRuleReturnScope local_deprecated161 =null;
		ParserRuleReturnScope aliasArray162 =null;
		ParserRuleReturnScope aliasTimeArray163 =null;
		ParserRuleReturnScope aliasID164 =null;
		ParserRuleReturnScope aliasExpresion167 =null;
		ParserRuleReturnScope aliasKind168 =null;
		ParserRuleReturnScope aliasUnits169 =null;
		ParserRuleReturnScope aliasNoSolver170 =null;

		CommonTree DEFINE160_tree=null;
		CommonTree char_literal165_tree=null;
		CommonTree ALIAS166_tree=null;
		CommonTree char_literal171_tree=null;

		try {
			// WreslPlus.g:550:11: ( DEFINE ( local_deprecated )? ( aliasArray | aliasTimeArray )? aliasID '{' ALIAS aliasExpresion ( aliasKind )? ( aliasUnits )? ( aliasNoSolver )? '}' )
			// WreslPlus.g:550:13: DEFINE ( local_deprecated )? ( aliasArray | aliasTimeArray )? aliasID '{' ALIAS aliasExpresion ( aliasKind )? ( aliasUnits )? ( aliasNoSolver )? '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			DEFINE160=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_alias_old2305); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DEFINE160_tree = (CommonTree)adaptor.create(DEFINE160);
			adaptor.addChild(root_0, DEFINE160_tree);
			}

			if ( state.backtracking==0 ) {line=(DEFINE160!=null?DEFINE160.getLine():0);}
			// WreslPlus.g:550:41: ( local_deprecated )?
			int alt40=2;
			int LA40_0 = input.LA(1);
			if ( (LA40_0==119) ) {
				int LA40_1 = input.LA(2);
				if ( (LA40_1==LOCAL) ) {
					alt40=1;
				}
			}
			switch (alt40) {
				case 1 :
					// WreslPlus.g:550:42: local_deprecated
					{
					pushFollow(FOLLOW_local_deprecated_in_alias_old2310);
					local_deprecated161=local_deprecated();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, local_deprecated161.getTree());

					}
					break;

			}

			// WreslPlus.g:550:61: ( aliasArray | aliasTimeArray )?
			int alt41=3;
			int LA41_0 = input.LA(1);
			if ( (LA41_0==119) ) {
				alt41=1;
			}
			else if ( (LA41_0==103) ) {
				alt41=2;
			}
			switch (alt41) {
				case 1 :
					// WreslPlus.g:550:62: aliasArray
					{
					pushFollow(FOLLOW_aliasArray_in_alias_old2315);
					aliasArray162=aliasArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, aliasArray162.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:550:73: aliasTimeArray
					{
					pushFollow(FOLLOW_aliasTimeArray_in_alias_old2317);
					aliasTimeArray163=aliasTimeArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, aliasTimeArray163.getTree());

					}
					break;

			}

			pushFollow(FOLLOW_aliasID_in_alias_old2321);
			aliasID164=aliasID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, aliasID164.getTree());

			char_literal165=(Token)match(input,125,FOLLOW_125_in_alias_old2323); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal165_tree = (CommonTree)adaptor.create(char_literal165);
			adaptor.addChild(root_0, char_literal165_tree);
			}

			ALIAS166=(Token)match(input,ALIAS,FOLLOW_ALIAS_in_alias_old2325); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ALIAS166_tree = (CommonTree)adaptor.create(ALIAS166);
			adaptor.addChild(root_0, ALIAS166_tree);
			}

			pushFollow(FOLLOW_aliasExpresion_in_alias_old2328);
			aliasExpresion167=aliasExpresion();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, aliasExpresion167.getTree());

			// WreslPlus.g:550:125: ( aliasKind )?
			int alt42=2;
			int LA42_0 = input.LA(1);
			if ( (LA42_0==KIND) ) {
				alt42=1;
			}
			switch (alt42) {
				case 1 :
					// WreslPlus.g:550:125: aliasKind
					{
					pushFollow(FOLLOW_aliasKind_in_alias_old2331);
					aliasKind168=aliasKind();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, aliasKind168.getTree());

					}
					break;

			}

			// WreslPlus.g:550:137: ( aliasUnits )?
			int alt43=2;
			int LA43_0 = input.LA(1);
			if ( (LA43_0==UNITS) ) {
				alt43=1;
			}
			switch (alt43) {
				case 1 :
					// WreslPlus.g:550:137: aliasUnits
					{
					pushFollow(FOLLOW_aliasUnits_in_alias_old2335);
					aliasUnits169=aliasUnits();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, aliasUnits169.getTree());

					}
					break;

			}

			// WreslPlus.g:550:149: ( aliasNoSolver )?
			int alt44=2;
			int LA44_0 = input.LA(1);
			if ( (LA44_0==NoSolver) ) {
				alt44=1;
			}
			switch (alt44) {
				case 1 :
					// WreslPlus.g:550:149: aliasNoSolver
					{
					pushFollow(FOLLOW_aliasNoSolver_in_alias_old2338);
					aliasNoSolver170=aliasNoSolver();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, aliasNoSolver170.getTree());

					}
					break;

			}

			char_literal171=(Token)match(input,126,FOLLOW_126_in_alias_old2341); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal171_tree = (CommonTree)adaptor.create(char_literal171);
			adaptor.addChild(root_0, char_literal171_tree);
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
	// $ANTLR end "alias_old"


	public static class alias_new_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "alias_new"
	// WreslPlus.g:551:1: alias_new : ALIAS ( aliasArray | aliasTimeArray )? aliasID '{' aliasExpresion ( aliasKind )? ( aliasUnits )? ( aliasNoSolver )? '}' ;
	public final WreslPlusParser.alias_new_return alias_new() throws RecognitionException {
		WreslPlusParser.alias_new_return retval = new WreslPlusParser.alias_new_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ALIAS172=null;
		Token char_literal176=null;
		Token char_literal181=null;
		ParserRuleReturnScope aliasArray173 =null;
		ParserRuleReturnScope aliasTimeArray174 =null;
		ParserRuleReturnScope aliasID175 =null;
		ParserRuleReturnScope aliasExpresion177 =null;
		ParserRuleReturnScope aliasKind178 =null;
		ParserRuleReturnScope aliasUnits179 =null;
		ParserRuleReturnScope aliasNoSolver180 =null;

		CommonTree ALIAS172_tree=null;
		CommonTree char_literal176_tree=null;
		CommonTree char_literal181_tree=null;

		try {
			// WreslPlus.g:551:11: ( ALIAS ( aliasArray | aliasTimeArray )? aliasID '{' aliasExpresion ( aliasKind )? ( aliasUnits )? ( aliasNoSolver )? '}' )
			// WreslPlus.g:551:13: ALIAS ( aliasArray | aliasTimeArray )? aliasID '{' aliasExpresion ( aliasKind )? ( aliasUnits )? ( aliasNoSolver )? '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			ALIAS172=(Token)match(input,ALIAS,FOLLOW_ALIAS_in_alias_new2349); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ALIAS172_tree = (CommonTree)adaptor.create(ALIAS172);
			adaptor.addChild(root_0, ALIAS172_tree);
			}

			if ( state.backtracking==0 ) {line=(ALIAS172!=null?ALIAS172.getLine():0);}
			// WreslPlus.g:551:38: ( aliasArray | aliasTimeArray )?
			int alt45=3;
			int LA45_0 = input.LA(1);
			if ( (LA45_0==119) ) {
				alt45=1;
			}
			else if ( (LA45_0==103) ) {
				alt45=2;
			}
			switch (alt45) {
				case 1 :
					// WreslPlus.g:551:39: aliasArray
					{
					pushFollow(FOLLOW_aliasArray_in_alias_new2353);
					aliasArray173=aliasArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, aliasArray173.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:551:50: aliasTimeArray
					{
					pushFollow(FOLLOW_aliasTimeArray_in_alias_new2355);
					aliasTimeArray174=aliasTimeArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, aliasTimeArray174.getTree());

					}
					break;

			}

			pushFollow(FOLLOW_aliasID_in_alias_new2359);
			aliasID175=aliasID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, aliasID175.getTree());

			char_literal176=(Token)match(input,125,FOLLOW_125_in_alias_new2361); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal176_tree = (CommonTree)adaptor.create(char_literal176);
			adaptor.addChild(root_0, char_literal176_tree);
			}

			pushFollow(FOLLOW_aliasExpresion_in_alias_new2363);
			aliasExpresion177=aliasExpresion();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, aliasExpresion177.getTree());

			// WreslPlus.g:551:95: ( aliasKind )?
			int alt46=2;
			int LA46_0 = input.LA(1);
			if ( (LA46_0==KIND) ) {
				alt46=1;
			}
			switch (alt46) {
				case 1 :
					// WreslPlus.g:551:95: aliasKind
					{
					pushFollow(FOLLOW_aliasKind_in_alias_new2366);
					aliasKind178=aliasKind();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, aliasKind178.getTree());

					}
					break;

			}

			// WreslPlus.g:551:107: ( aliasUnits )?
			int alt47=2;
			int LA47_0 = input.LA(1);
			if ( (LA47_0==UNITS) ) {
				alt47=1;
			}
			switch (alt47) {
				case 1 :
					// WreslPlus.g:551:107: aliasUnits
					{
					pushFollow(FOLLOW_aliasUnits_in_alias_new2370);
					aliasUnits179=aliasUnits();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, aliasUnits179.getTree());

					}
					break;

			}

			// WreslPlus.g:551:119: ( aliasNoSolver )?
			int alt48=2;
			int LA48_0 = input.LA(1);
			if ( (LA48_0==NoSolver) ) {
				alt48=1;
			}
			switch (alt48) {
				case 1 :
					// WreslPlus.g:551:119: aliasNoSolver
					{
					pushFollow(FOLLOW_aliasNoSolver_in_alias_new2373);
					aliasNoSolver180=aliasNoSolver();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, aliasNoSolver180.getTree());

					}
					break;

			}

			char_literal181=(Token)match(input,126,FOLLOW_126_in_alias_new2376); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal181_tree = (CommonTree)adaptor.create(char_literal181);
			adaptor.addChild(root_0, char_literal181_tree);
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
	// $ANTLR end "alias_new"


	public static class aliasExpresion_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "aliasExpresion"
	// WreslPlus.g:553:1: aliasExpresion : e= expr_add ;
	public final WreslPlusParser.aliasExpresion_return aliasExpresion() throws RecognitionException {
		WreslPlusParser.aliasExpresion_return retval = new WreslPlusParser.aliasExpresion_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope e =null;


		try {
			// WreslPlus.g:553:16: (e= expr_add )
			// WreslPlus.g:553:18: e= expr_add
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_add_in_aliasExpresion2387);
			e=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

			if ( state.backtracking==0 ) {alias_stack.peek().as_.expression=(e!=null?input.toString(e.start,e.stop):null);}
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
	// $ANTLR end "aliasExpresion"


	public static class aliasID_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "aliasID"
	// WreslPlus.g:554:1: aliasID : i= ID ;
	public final WreslPlusParser.aliasID_return aliasID() throws RecognitionException {
		WreslPlusParser.aliasID_return retval = new WreslPlusParser.aliasID_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;

		CommonTree i_tree=null;

		try {
			// WreslPlus.g:554:9: (i= ID )
			// WreslPlus.g:554:11: i= ID
			{
			root_0 = (CommonTree)adaptor.nil();


			i=(Token)match(input,ID,FOLLOW_ID_in_aliasID2399); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) {alias_stack.peek().as_.id=(i!=null?i.getText():null);}
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
	// $ANTLR end "aliasID"


	public static class aliasUnits_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "aliasUnits"
	// WreslPlus.g:555:1: aliasUnits : UNITS s= QUOTE ;
	public final WreslPlusParser.aliasUnits_return aliasUnits() throws RecognitionException {
		WreslPlusParser.aliasUnits_return retval = new WreslPlusParser.aliasUnits_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		Token UNITS182=null;

		CommonTree s_tree=null;
		CommonTree UNITS182_tree=null;

		try {
			// WreslPlus.g:555:11: ( UNITS s= QUOTE )
			// WreslPlus.g:555:13: UNITS s= QUOTE
			{
			root_0 = (CommonTree)adaptor.nil();


			UNITS182=(Token)match(input,UNITS,FOLLOW_UNITS_in_aliasUnits2408); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			UNITS182_tree = (CommonTree)adaptor.create(UNITS182);
			adaptor.addChild(root_0, UNITS182_tree);
			}

			s=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_aliasUnits2412); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			s_tree = (CommonTree)adaptor.create(s);
			adaptor.addChild(root_0, s_tree);
			}

			if ( state.backtracking==0 ) {alias_stack.peek().as_.units=Tools.strip((s!=null?s.getText():null));}
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
	// $ANTLR end "aliasUnits"


	public static class aliasKind_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "aliasKind"
	// WreslPlus.g:556:1: aliasKind : KIND s= QUOTE ;
	public final WreslPlusParser.aliasKind_return aliasKind() throws RecognitionException {
		WreslPlusParser.aliasKind_return retval = new WreslPlusParser.aliasKind_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		Token KIND183=null;

		CommonTree s_tree=null;
		CommonTree KIND183_tree=null;

		try {
			// WreslPlus.g:556:10: ( KIND s= QUOTE )
			// WreslPlus.g:556:13: KIND s= QUOTE
			{
			root_0 = (CommonTree)adaptor.nil();


			KIND183=(Token)match(input,KIND,FOLLOW_KIND_in_aliasKind2421); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			KIND183_tree = (CommonTree)adaptor.create(KIND183);
			adaptor.addChild(root_0, KIND183_tree);
			}

			s=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_aliasKind2425); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			s_tree = (CommonTree)adaptor.create(s);
			adaptor.addChild(root_0, s_tree);
			}

			if ( state.backtracking==0 ) {alias_stack.peek().as_.kind=Tools.strip((s!=null?s.getText():null));}
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
	// $ANTLR end "aliasKind"


	public static class aliasNoSolver_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "aliasNoSolver"
	// WreslPlus.g:557:1: aliasNoSolver : NoSolver ;
	public final WreslPlusParser.aliasNoSolver_return aliasNoSolver() throws RecognitionException {
		WreslPlusParser.aliasNoSolver_return retval = new WreslPlusParser.aliasNoSolver_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token NoSolver184=null;

		CommonTree NoSolver184_tree=null;

		try {
			// WreslPlus.g:557:15: ( NoSolver )
			// WreslPlus.g:557:17: NoSolver
			{
			root_0 = (CommonTree)adaptor.nil();


			NoSolver184=(Token)match(input,NoSolver,FOLLOW_NoSolver_in_aliasNoSolver2434); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NoSolver184_tree = (CommonTree)adaptor.create(NoSolver184);
			adaptor.addChild(root_0, NoSolver184_tree);
			}

			if ( state.backtracking==0 ) {alias_stack.peek().as_.noSolver=true;}
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
	// $ANTLR end "aliasNoSolver"


	public static class aliasArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "aliasArray"
	// WreslPlus.g:559:1: aliasArray : '[' d= ( INT | ID ) ']' ;
	public final WreslPlusParser.aliasArray_return aliasArray() throws RecognitionException {
		WreslPlusParser.aliasArray_return retval = new WreslPlusParser.aliasArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token d=null;
		Token char_literal185=null;
		Token char_literal186=null;

		CommonTree d_tree=null;
		CommonTree char_literal185_tree=null;
		CommonTree char_literal186_tree=null;

		try {
			// WreslPlus.g:559:12: ( '[' d= ( INT | ID ) ']' )
			// WreslPlus.g:559:18: '[' d= ( INT | ID ) ']'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal185=(Token)match(input,119,FOLLOW_119_in_aliasArray2448); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal185_tree = (CommonTree)adaptor.create(char_literal185);
			adaptor.addChild(root_0, char_literal185_tree);
			}

			d=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(d));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal186=(Token)match(input,120,FOLLOW_120_in_aliasArray2462); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal186_tree = (CommonTree)adaptor.create(char_literal186);
			adaptor.addChild(root_0, char_literal186_tree);
			}

			if ( state.backtracking==0 ) {alias_stack.peek().as_.arraySize=(d!=null?d.getText():null); }
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
	// $ANTLR end "aliasArray"


	public static class aliasTimeArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "aliasTimeArray"
	// WreslPlus.g:560:1: aliasTimeArray : '(' d= ( INT | ID ) ')' ;
	public final WreslPlusParser.aliasTimeArray_return aliasTimeArray() throws RecognitionException {
		WreslPlusParser.aliasTimeArray_return retval = new WreslPlusParser.aliasTimeArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token d=null;
		Token char_literal187=null;
		Token char_literal188=null;

		CommonTree d_tree=null;
		CommonTree char_literal187_tree=null;
		CommonTree char_literal188_tree=null;

		try {
			// WreslPlus.g:560:16: ( '(' d= ( INT | ID ) ')' )
			// WreslPlus.g:560:18: '(' d= ( INT | ID ) ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal187=(Token)match(input,103,FOLLOW_103_in_aliasTimeArray2472); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal187_tree = (CommonTree)adaptor.create(char_literal187);
			adaptor.addChild(root_0, char_literal187_tree);
			}

			d=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(d));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal188=(Token)match(input,104,FOLLOW_104_in_aliasTimeArray2486); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal188_tree = (CommonTree)adaptor.create(char_literal188);
			adaptor.addChild(root_0, char_literal188_tree);
			}

			if ( state.backtracking==0 ) {alias_stack.peek().as_.timeArraySize=(d!=null?d.getText():null); }
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
	// $ANTLR end "aliasTimeArray"


	public static class svar_group_return extends ParserRuleReturnScope {
		public String id;
		public SvarTemp svObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_group"
	// WreslPlus.g:564:1: svar_group returns [String id, SvarTemp svObj] : ( SVAR | DEFINE ( local_deprecated )? ) svar_g ;
	public final WreslPlusParser.svar_group_return svar_group() throws RecognitionException {
		WreslPlusParser.svar_group_return retval = new WreslPlusParser.svar_group_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SVAR189=null;
		Token DEFINE190=null;
		ParserRuleReturnScope local_deprecated191 =null;
		ParserRuleReturnScope svar_g192 =null;

		CommonTree SVAR189_tree=null;
		CommonTree DEFINE190_tree=null;

		try {
			// WreslPlus.g:565:3: ( ( SVAR | DEFINE ( local_deprecated )? ) svar_g )
			// WreslPlus.g:565:5: ( SVAR | DEFINE ( local_deprecated )? ) svar_g
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:565:5: ( SVAR | DEFINE ( local_deprecated )? )
			int alt50=2;
			int LA50_0 = input.LA(1);
			if ( (LA50_0==SVAR) ) {
				alt50=1;
			}
			else if ( (LA50_0==DEFINE) ) {
				alt50=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 50, 0, input);
				throw nvae;
			}

			switch (alt50) {
				case 1 :
					// WreslPlus.g:565:7: SVAR
					{
					SVAR189=(Token)match(input,SVAR,FOLLOW_SVAR_in_svar_group2506); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SVAR189_tree = (CommonTree)adaptor.create(SVAR189);
					adaptor.addChild(root_0, SVAR189_tree);
					}

					if ( state.backtracking==0 ) {line=(SVAR189!=null?SVAR189.getLine():0);}
					}
					break;
				case 2 :
					// WreslPlus.g:565:32: DEFINE ( local_deprecated )?
					{
					DEFINE190=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_svar_group2511); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					DEFINE190_tree = (CommonTree)adaptor.create(DEFINE190);
					adaptor.addChild(root_0, DEFINE190_tree);
					}

					if ( state.backtracking==0 ) {line=(DEFINE190!=null?DEFINE190.getLine():0);}
					// WreslPlus.g:565:60: ( local_deprecated )?
					int alt49=2;
					int LA49_0 = input.LA(1);
					if ( (LA49_0==119) ) {
						int LA49_1 = input.LA(2);
						if ( (LA49_1==LOCAL) ) {
							alt49=1;
						}
					}
					switch (alt49) {
						case 1 :
							// WreslPlus.g:565:61: local_deprecated
							{
							pushFollow(FOLLOW_local_deprecated_in_svar_group2516);
							local_deprecated191=local_deprecated();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, local_deprecated191.getTree());

							}
							break;

					}

					}
					break;

			}

			pushFollow(FOLLOW_svar_g_in_svar_group2522);
			svar_g192=svar_g();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_g192.getTree());

			if ( state.backtracking==0 ) { retval.id =(svar_g192!=null?((WreslPlusParser.svar_g_return)svar_g192).id:null);  retval.svObj =(svar_g192!=null?((WreslPlusParser.svar_g_return)svar_g192).svObj:null);  retval.svObj.line=line;}
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
	// $ANTLR end "svar_group"


	protected static class svar_g_scope {
		SvarTemp sv_;
		String id_;
	}
	protected Stack<svar_g_scope> svar_g_stack = new Stack<svar_g_scope>();

	public static class svar_g_return extends ParserRuleReturnScope {
		public String id;
		public SvarTemp svObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_g"
	// WreslPlus.g:568:1: svar_g returns [String id, SvarTemp svObj] : ( svar | svar_array | svar_timeArray ) ;
	public final WreslPlusParser.svar_g_return svar_g() throws RecognitionException {
		svar_g_stack.push(new svar_g_scope());
		WreslPlusParser.svar_g_return retval = new WreslPlusParser.svar_g_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope svar193 =null;
		ParserRuleReturnScope svar_array194 =null;
		ParserRuleReturnScope svar_timeArray195 =null;


		 svar_g_stack.peek().sv_ = new SvarTemp(); 
		       svar_g_stack.peek().sv_.fromWresl = this.currentAbsolutePath; 
		       dependants = new LinkedHashSet<String>();
		       varInCycle = new LinkedHashSet<String>();
		       
			 
		try {
			// WreslPlus.g:584:2: ( ( svar | svar_array | svar_timeArray ) )
			// WreslPlus.g:584:5: ( svar | svar_array | svar_timeArray )
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:584:5: ( svar | svar_array | svar_timeArray )
			int alt51=3;
			switch ( input.LA(1) ) {
			case ID:
				{
				alt51=1;
				}
				break;
			case 119:
				{
				alt51=2;
				}
				break;
			case 103:
				{
				alt51=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 51, 0, input);
				throw nvae;
			}
			switch (alt51) {
				case 1 :
					// WreslPlus.g:584:7: svar
					{
					pushFollow(FOLLOW_svar_in_svar_g2556);
					svar193=svar();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar193.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:584:14: svar_array
					{
					pushFollow(FOLLOW_svar_array_in_svar_g2560);
					svar_array194=svar_array();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_array194.getTree());

					}
					break;
				case 3 :
					// WreslPlus.g:584:27: svar_timeArray
					{
					pushFollow(FOLLOW_svar_timeArray_in_svar_g2564);
					svar_timeArray195=svar_timeArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_timeArray195.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { retval.id = svar_g_stack.peek().sv_.id; 
			        retval.svObj =svar_g_stack.peek().sv_; 
			        retval.svObj.dependants= dependants;
			        retval.svObj.neededVarInCycleSet= varInCycle;
			        retval.svObj.needVarFromEarlierCycle = (varInCycle!=null);
			        }
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			svar_g_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "svar_g"


	public static class svarID_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svarID"
	// WreslPlus.g:587:1: svarID : i= ID ;
	public final WreslPlusParser.svarID_return svarID() throws RecognitionException {
		WreslPlusParser.svarID_return retval = new WreslPlusParser.svarID_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;

		CommonTree i_tree=null;

		try {
			// WreslPlus.g:587:8: (i= ID )
			// WreslPlus.g:587:10: i= ID
			{
			root_0 = (CommonTree)adaptor.nil();


			i=(Token)match(input,ID,FOLLOW_ID_in_svarID2578); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) {svar_g_stack.peek().sv_.id =(i!=null?i.getText():null);}
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
	// $ANTLR end "svarID"


	public static class svar_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar"
	// WreslPlus.g:589:1: svar : svarID '{' svar_trunk '}' ;
	public final WreslPlusParser.svar_return svar() throws RecognitionException {
		WreslPlusParser.svar_return retval = new WreslPlusParser.svar_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal197=null;
		Token char_literal199=null;
		ParserRuleReturnScope svarID196 =null;
		ParserRuleReturnScope svar_trunk198 =null;

		CommonTree char_literal197_tree=null;
		CommonTree char_literal199_tree=null;

		try {
			// WreslPlus.g:589:5: ( svarID '{' svar_trunk '}' )
			// WreslPlus.g:589:7: svarID '{' svar_trunk '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_svarID_in_svar2589);
			svarID196=svarID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, svarID196.getTree());

			char_literal197=(Token)match(input,125,FOLLOW_125_in_svar2591); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal197_tree = (CommonTree)adaptor.create(char_literal197);
			adaptor.addChild(root_0, char_literal197_tree);
			}

			pushFollow(FOLLOW_svar_trunk_in_svar2593);
			svar_trunk198=svar_trunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_trunk198.getTree());

			char_literal199=(Token)match(input,126,FOLLOW_126_in_svar2595); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal199_tree = (CommonTree)adaptor.create(char_literal199);
			adaptor.addChild(root_0, char_literal199_tree);
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


	public static class svar_array_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_array"
	// WreslPlus.g:591:1: svar_array : svarArray svar ;
	public final WreslPlusParser.svar_array_return svar_array() throws RecognitionException {
		WreslPlusParser.svar_array_return retval = new WreslPlusParser.svar_array_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope svarArray200 =null;
		ParserRuleReturnScope svar201 =null;


		try {
			// WreslPlus.g:591:11: ( svarArray svar )
			// WreslPlus.g:591:13: svarArray svar
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_svarArray_in_svar_array2603);
			svarArray200=svarArray();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, svarArray200.getTree());

			pushFollow(FOLLOW_svar_in_svar_array2605);
			svar201=svar();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, svar201.getTree());

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
	// $ANTLR end "svar_array"


	public static class svar_timeArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_timeArray"
	// WreslPlus.g:593:1: svar_timeArray : svarTimeArray svar ;
	public final WreslPlusParser.svar_timeArray_return svar_timeArray() throws RecognitionException {
		WreslPlusParser.svar_timeArray_return retval = new WreslPlusParser.svar_timeArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope svarTimeArray202 =null;
		ParserRuleReturnScope svar203 =null;


		try {
			// WreslPlus.g:593:15: ( svarTimeArray svar )
			// WreslPlus.g:593:17: svarTimeArray svar
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_svarTimeArray_in_svar_timeArray2612);
			svarTimeArray202=svarTimeArray();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, svarTimeArray202.getTree());

			pushFollow(FOLLOW_svar_in_svar_timeArray2614);
			svar203=svar();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, svar203.getTree());

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


	public static class svarArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svarArray"
	// WreslPlus.g:595:1: svarArray : '[' d= ( INT | ID ) ']' ;
	public final WreslPlusParser.svarArray_return svarArray() throws RecognitionException {
		WreslPlusParser.svarArray_return retval = new WreslPlusParser.svarArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token d=null;
		Token char_literal204=null;
		Token char_literal205=null;

		CommonTree d_tree=null;
		CommonTree char_literal204_tree=null;
		CommonTree char_literal205_tree=null;

		try {
			// WreslPlus.g:595:11: ( '[' d= ( INT | ID ) ']' )
			// WreslPlus.g:595:17: '[' d= ( INT | ID ) ']'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal204=(Token)match(input,119,FOLLOW_119_in_svarArray2627); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal204_tree = (CommonTree)adaptor.create(char_literal204);
			adaptor.addChild(root_0, char_literal204_tree);
			}

			d=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(d));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal205=(Token)match(input,120,FOLLOW_120_in_svarArray2641); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal205_tree = (CommonTree)adaptor.create(char_literal205);
			adaptor.addChild(root_0, char_literal205_tree);
			}

			if ( state.backtracking==0 ) {svar_g_stack.peek().sv_.arraySize=(d!=null?d.getText():null); }
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
	// $ANTLR end "svarArray"


	public static class svarTimeArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svarTimeArray"
	// WreslPlus.g:596:1: svarTimeArray : '(' d= ( INT | ID ) ')' ;
	public final WreslPlusParser.svarTimeArray_return svarTimeArray() throws RecognitionException {
		WreslPlusParser.svarTimeArray_return retval = new WreslPlusParser.svarTimeArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token d=null;
		Token char_literal206=null;
		Token char_literal207=null;

		CommonTree d_tree=null;
		CommonTree char_literal206_tree=null;
		CommonTree char_literal207_tree=null;

		try {
			// WreslPlus.g:596:15: ( '(' d= ( INT | ID ) ')' )
			// WreslPlus.g:596:17: '(' d= ( INT | ID ) ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal206=(Token)match(input,103,FOLLOW_103_in_svarTimeArray2651); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal206_tree = (CommonTree)adaptor.create(char_literal206);
			adaptor.addChild(root_0, char_literal206_tree);
			}

			d=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(d));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal207=(Token)match(input,104,FOLLOW_104_in_svarTimeArray2665); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal207_tree = (CommonTree)adaptor.create(char_literal207);
			adaptor.addChild(root_0, char_literal207_tree);
			}

			if ( state.backtracking==0 ) {svar_g_stack.peek().sv_.timeArraySize=(d!=null?d.getText():null); }
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
	// $ANTLR end "svarTimeArray"


	public static class svar_trunk_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_trunk"
	// WreslPlus.g:600:1: svar_trunk : ( svar_noCase | ( svar_case )+ ) ( svarKind svarUnits )? ;
	public final WreslPlusParser.svar_trunk_return svar_trunk() throws RecognitionException {
		WreslPlusParser.svar_trunk_return retval = new WreslPlusParser.svar_trunk_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope svar_noCase208 =null;
		ParserRuleReturnScope svar_case209 =null;
		ParserRuleReturnScope svarKind210 =null;
		ParserRuleReturnScope svarUnits211 =null;


		try {
			// WreslPlus.g:601:2: ( ( svar_noCase | ( svar_case )+ ) ( svarKind svarUnits )? )
			// WreslPlus.g:601:4: ( svar_noCase | ( svar_case )+ ) ( svarKind svarUnits )?
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:601:4: ( svar_noCase | ( svar_case )+ )
			int alt53=2;
			int LA53_0 = input.LA(1);
			if ( (LA53_0==SELECT||LA53_0==SUM||LA53_0==VALUE||LA53_0==124) ) {
				alt53=1;
			}
			else if ( (LA53_0==CASE) ) {
				alt53=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 53, 0, input);
				throw nvae;
			}

			switch (alt53) {
				case 1 :
					// WreslPlus.g:601:6: svar_noCase
					{
					pushFollow(FOLLOW_svar_noCase_in_svar_trunk2682);
					svar_noCase208=svar_noCase();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_noCase208.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:601:20: ( svar_case )+
					{
					// WreslPlus.g:601:20: ( svar_case )+
					int cnt52=0;
					loop52:
					while (true) {
						int alt52=2;
						int LA52_0 = input.LA(1);
						if ( (LA52_0==CASE) ) {
							alt52=1;
						}

						switch (alt52) {
						case 1 :
							// WreslPlus.g:601:20: svar_case
							{
							pushFollow(FOLLOW_svar_case_in_svar_trunk2686);
							svar_case209=svar_case();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_case209.getTree());

							}
							break;

						default :
							if ( cnt52 >= 1 ) break loop52;
							if (state.backtracking>0) {state.failed=true; return retval;}
							EarlyExitException eee = new EarlyExitException(52, input);
							throw eee;
						}
						cnt52++;
					}

					}
					break;

			}

			// WreslPlus.g:601:33: ( svarKind svarUnits )?
			int alt54=2;
			int LA54_0 = input.LA(1);
			if ( (LA54_0==KIND) ) {
				alt54=1;
			}
			switch (alt54) {
				case 1 :
					// WreslPlus.g:601:35: svarKind svarUnits
					{
					pushFollow(FOLLOW_svarKind_in_svar_trunk2693);
					svarKind210=svarKind();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svarKind210.getTree());

					pushFollow(FOLLOW_svarUnits_in_svar_trunk2695);
					svarUnits211=svarUnits();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svarUnits211.getTree());

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
	// $ANTLR end "svar_trunk"


	public static class svarUnits_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svarUnits"
	// WreslPlus.g:603:1: svarUnits : UNITS QUOTE ;
	public final WreslPlusParser.svarUnits_return svarUnits() throws RecognitionException {
		WreslPlusParser.svarUnits_return retval = new WreslPlusParser.svarUnits_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token UNITS212=null;
		Token QUOTE213=null;

		CommonTree UNITS212_tree=null;
		CommonTree QUOTE213_tree=null;

		try {
			// WreslPlus.g:603:10: ( UNITS QUOTE )
			// WreslPlus.g:603:12: UNITS QUOTE
			{
			root_0 = (CommonTree)adaptor.nil();


			UNITS212=(Token)match(input,UNITS,FOLLOW_UNITS_in_svarUnits2707); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			UNITS212_tree = (CommonTree)adaptor.create(UNITS212);
			adaptor.addChild(root_0, UNITS212_tree);
			}

			QUOTE213=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_svarUnits2709); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTE213_tree = (CommonTree)adaptor.create(QUOTE213);
			adaptor.addChild(root_0, QUOTE213_tree);
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
	// $ANTLR end "svarUnits"


	public static class svarKind_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svarKind"
	// WreslPlus.g:604:1: svarKind : KIND QUOTE ;
	public final WreslPlusParser.svarKind_return svarKind() throws RecognitionException {
		WreslPlusParser.svarKind_return retval = new WreslPlusParser.svarKind_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token KIND214=null;
		Token QUOTE215=null;

		CommonTree KIND214_tree=null;
		CommonTree QUOTE215_tree=null;

		try {
			// WreslPlus.g:604:9: ( KIND QUOTE )
			// WreslPlus.g:604:12: KIND QUOTE
			{
			root_0 = (CommonTree)adaptor.nil();


			KIND214=(Token)match(input,KIND,FOLLOW_KIND_in_svarKind2717); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			KIND214_tree = (CommonTree)adaptor.create(KIND214);
			adaptor.addChild(root_0, KIND214_tree);
			}

			QUOTE215=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_svarKind2719); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			QUOTE215_tree = (CommonTree)adaptor.create(QUOTE215);
			adaptor.addChild(root_0, QUOTE215_tree);
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
	// $ANTLR end "svarKind"


	public static class svar_noCase_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_noCase"
	// WreslPlus.g:606:1: svar_noCase : ( svar_value | svar_sum | svar_table );
	public final WreslPlusParser.svar_noCase_return svar_noCase() throws RecognitionException {
		WreslPlusParser.svar_noCase_return retval = new WreslPlusParser.svar_noCase_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope svar_value216 =null;
		ParserRuleReturnScope svar_sum217 =null;
		ParserRuleReturnScope svar_table218 =null;


		try {
			// WreslPlus.g:608:2: ( svar_value | svar_sum | svar_table )
			int alt55=3;
			switch ( input.LA(1) ) {
			case VALUE:
				{
				alt55=1;
				}
				break;
			case SUM:
				{
				alt55=2;
				}
				break;
			case SELECT:
			case 124:
				{
				alt55=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 55, 0, input);
				throw nvae;
			}
			switch (alt55) {
				case 1 :
					// WreslPlus.g:608:4: svar_value
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_svar_value_in_svar_noCase2735);
					svar_value216=svar_value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_value216.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:608:17: svar_sum
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_svar_sum_in_svar_noCase2739);
					svar_sum217=svar_sum();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_sum217.getTree());

					}
					break;
				case 3 :
					// WreslPlus.g:608:28: svar_table
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_svar_table_in_svar_noCase2743);
					svar_table218=svar_table();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_table218.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {svar_g_stack.peek().sv_.caseName.add(Param.defaultCaseName); svar_g_stack.peek().sv_.caseCondition.add(Param.always);}
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
	// $ANTLR end "svar_noCase"


	public static class svar_case_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_case"
	// WreslPlus.g:611:1: svar_case : CASE ci= ID '{' CONDITION cc= logical_main ( svar_value | svar_sum | svar_table ) '}' ;
	public final WreslPlusParser.svar_case_return svar_case() throws RecognitionException {
		WreslPlusParser.svar_case_return retval = new WreslPlusParser.svar_case_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ci=null;
		Token CASE219=null;
		Token char_literal220=null;
		Token CONDITION221=null;
		Token char_literal225=null;
		ParserRuleReturnScope cc =null;
		ParserRuleReturnScope svar_value222 =null;
		ParserRuleReturnScope svar_sum223 =null;
		ParserRuleReturnScope svar_table224 =null;

		CommonTree ci_tree=null;
		CommonTree CASE219_tree=null;
		CommonTree char_literal220_tree=null;
		CommonTree CONDITION221_tree=null;
		CommonTree char_literal225_tree=null;

		try {
			// WreslPlus.g:613:2: ( CASE ci= ID '{' CONDITION cc= logical_main ( svar_value | svar_sum | svar_table ) '}' )
			// WreslPlus.g:613:4: CASE ci= ID '{' CONDITION cc= logical_main ( svar_value | svar_sum | svar_table ) '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			CASE219=(Token)match(input,CASE,FOLLOW_CASE_in_svar_case2761); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CASE219_tree = (CommonTree)adaptor.create(CASE219);
			adaptor.addChild(root_0, CASE219_tree);
			}

			ci=(Token)match(input,ID,FOLLOW_ID_in_svar_case2765); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ci_tree = (CommonTree)adaptor.create(ci);
			adaptor.addChild(root_0, ci_tree);
			}

			char_literal220=(Token)match(input,125,FOLLOW_125_in_svar_case2767); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal220_tree = (CommonTree)adaptor.create(char_literal220);
			adaptor.addChild(root_0, char_literal220_tree);
			}

			CONDITION221=(Token)match(input,CONDITION,FOLLOW_CONDITION_in_svar_case2769); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CONDITION221_tree = (CommonTree)adaptor.create(CONDITION221);
			adaptor.addChild(root_0, CONDITION221_tree);
			}

			pushFollow(FOLLOW_logical_main_in_svar_case2773);
			cc=logical_main();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, cc.getTree());

			// WreslPlus.g:613:45: ( svar_value | svar_sum | svar_table )
			int alt56=3;
			switch ( input.LA(1) ) {
			case VALUE:
				{
				alt56=1;
				}
				break;
			case SUM:
				{
				alt56=2;
				}
				break;
			case SELECT:
			case 124:
				{
				alt56=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 56, 0, input);
				throw nvae;
			}
			switch (alt56) {
				case 1 :
					// WreslPlus.g:613:47: svar_value
					{
					pushFollow(FOLLOW_svar_value_in_svar_case2777);
					svar_value222=svar_value();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_value222.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:613:60: svar_sum
					{
					pushFollow(FOLLOW_svar_sum_in_svar_case2781);
					svar_sum223=svar_sum();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_sum223.getTree());

					}
					break;
				case 3 :
					// WreslPlus.g:613:71: svar_table
					{
					pushFollow(FOLLOW_svar_table_in_svar_case2785);
					svar_table224=svar_table();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_table224.getTree());

					}
					break;

			}

			char_literal225=(Token)match(input,126,FOLLOW_126_in_svar_case2790); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal225_tree = (CommonTree)adaptor.create(char_literal225);
			adaptor.addChild(root_0, char_literal225_tree);
			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) {svar_g_stack.peek().sv_.caseName.add((ci!=null?ci.getText():null)); svar_g_stack.peek().sv_.caseCondition.add((cc!=null?input.toString(cc.start,cc.stop):null));}
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


	public static class svar_value_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_value"
	// WreslPlus.g:615:1: svar_value : VALUE e= expr_add ;
	public final WreslPlusParser.svar_value_return svar_value() throws RecognitionException {
		WreslPlusParser.svar_value_return retval = new WreslPlusParser.svar_value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VALUE226=null;
		ParserRuleReturnScope e =null;

		CommonTree VALUE226_tree=null;

		try {
			// WreslPlus.g:616:2: ( VALUE e= expr_add )
			// WreslPlus.g:616:4: VALUE e= expr_add
			{
			root_0 = (CommonTree)adaptor.nil();


			VALUE226=(Token)match(input,VALUE,FOLLOW_VALUE_in_svar_value2801); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			VALUE226_tree = (CommonTree)adaptor.create(VALUE226);
			adaptor.addChild(root_0, VALUE226_tree);
			}

			pushFollow(FOLLOW_expr_add_in_svar_value2805);
			e=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

			if ( state.backtracking==0 ) { svar_g_stack.peek().sv_.caseExpression.add((e!=null?input.toString(e.start,e.stop):null)); }
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
	// $ANTLR end "svar_value"


	public static class svar_sum_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_sum"
	// WreslPlus.g:619:1: svar_sum : h= sum_header c= sum_content ;
	public final WreslPlusParser.svar_sum_return svar_sum() throws RecognitionException {
		WreslPlusParser.svar_sum_return retval = new WreslPlusParser.svar_sum_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope h =null;
		ParserRuleReturnScope c =null;


		try {
			// WreslPlus.g:620:2: (h= sum_header c= sum_content )
			// WreslPlus.g:620:4: h= sum_header c= sum_content
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_sum_header_in_svar_sum2819);
			h=sum_header();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, h.getTree());

			pushFollow(FOLLOW_sum_content_in_svar_sum2823);
			c=sum_content();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, c.getTree());

			if ( state.backtracking==0 ) { svar_g_stack.peek().sv_.caseExpression.add((h!=null?input.toString(h.start,h.stop):null)+" "+(c!=null?input.toString(c.start,c.stop):null)); }
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


	public static class sum_header_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "sum_header"
	// WreslPlus.g:623:1: sum_header : SUM '(' 'i' '=' e1= expr_add ',' e2= expr_add ( ',' integer )? ')' ;
	public final WreslPlusParser.sum_header_return sum_header() throws RecognitionException {
		WreslPlusParser.sum_header_return retval = new WreslPlusParser.sum_header_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SUM227=null;
		Token char_literal228=null;
		Token char_literal229=null;
		Token char_literal230=null;
		Token char_literal231=null;
		Token char_literal232=null;
		Token char_literal234=null;
		ParserRuleReturnScope e1 =null;
		ParserRuleReturnScope e2 =null;
		ParserRuleReturnScope integer233 =null;

		CommonTree SUM227_tree=null;
		CommonTree char_literal228_tree=null;
		CommonTree char_literal229_tree=null;
		CommonTree char_literal230_tree=null;
		CommonTree char_literal231_tree=null;
		CommonTree char_literal232_tree=null;
		CommonTree char_literal234_tree=null;

		try {
			// WreslPlus.g:624:2: ( SUM '(' 'i' '=' e1= expr_add ',' e2= expr_add ( ',' integer )? ')' )
			// WreslPlus.g:624:4: SUM '(' 'i' '=' e1= expr_add ',' e2= expr_add ( ',' integer )? ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			SUM227=(Token)match(input,SUM,FOLLOW_SUM_in_sum_header2836); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			SUM227_tree = (CommonTree)adaptor.create(SUM227);
			adaptor.addChild(root_0, SUM227_tree);
			}

			char_literal228=(Token)match(input,103,FOLLOW_103_in_sum_header2838); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal228_tree = (CommonTree)adaptor.create(char_literal228);
			adaptor.addChild(root_0, char_literal228_tree);
			}

			char_literal229=(Token)match(input,123,FOLLOW_123_in_sum_header2840); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal229_tree = (CommonTree)adaptor.create(char_literal229);
			adaptor.addChild(root_0, char_literal229_tree);
			}

			char_literal230=(Token)match(input,115,FOLLOW_115_in_sum_header2842); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal230_tree = (CommonTree)adaptor.create(char_literal230);
			adaptor.addChild(root_0, char_literal230_tree);
			}

			pushFollow(FOLLOW_expr_add_in_sum_header2846);
			e1=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e1.getTree());

			char_literal231=(Token)match(input,107,FOLLOW_107_in_sum_header2848); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal231_tree = (CommonTree)adaptor.create(char_literal231);
			adaptor.addChild(root_0, char_literal231_tree);
			}

			pushFollow(FOLLOW_expr_add_in_sum_header2852);
			e2=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e2.getTree());

			// WreslPlus.g:624:48: ( ',' integer )?
			int alt57=2;
			int LA57_0 = input.LA(1);
			if ( (LA57_0==107) ) {
				alt57=1;
			}
			switch (alt57) {
				case 1 :
					// WreslPlus.g:624:49: ',' integer
					{
					char_literal232=(Token)match(input,107,FOLLOW_107_in_sum_header2855); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal232_tree = (CommonTree)adaptor.create(char_literal232);
					adaptor.addChild(root_0, char_literal232_tree);
					}

					pushFollow(FOLLOW_integer_in_sum_header2857);
					integer233=integer();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, integer233.getTree());

					}
					break;

			}

			char_literal234=(Token)match(input,104,FOLLOW_104_in_sum_header2862); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal234_tree = (CommonTree)adaptor.create(char_literal234);
			adaptor.addChild(root_0, char_literal234_tree);
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
	// $ANTLR end "sum_header"


	public static class sum_content_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "sum_content"
	// WreslPlus.g:627:1: sum_content : e= expr_add ;
	public final WreslPlusParser.sum_content_return sum_content() throws RecognitionException {
		WreslPlusParser.sum_content_return retval = new WreslPlusParser.sum_content_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope e =null;


		try {
			// WreslPlus.g:628:2: (e= expr_add )
			// WreslPlus.g:628:4: e= expr_add
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_add_in_sum_content2877);
			e=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

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


	public static class svar_table_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_table"
	// WreslPlus.g:630:1: svar_table : (t1= svar_table_1 | svar_table_2 );
	public final WreslPlusParser.svar_table_return svar_table() throws RecognitionException {
		WreslPlusParser.svar_table_return retval = new WreslPlusParser.svar_table_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope svar_table_2235 =null;


		try {
			// WreslPlus.g:631:2: (t1= svar_table_1 | svar_table_2 )
			int alt58=2;
			int LA58_0 = input.LA(1);
			if ( (LA58_0==SELECT) ) {
				alt58=1;
			}
			else if ( (LA58_0==124) ) {
				alt58=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 58, 0, input);
				throw nvae;
			}

			switch (alt58) {
				case 1 :
					// WreslPlus.g:631:4: t1= svar_table_1
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_svar_table_1_in_svar_table2890);
					t1=svar_table_1();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, t1.getTree());

					if ( state.backtracking==0 ) { svar_g_stack.peek().sv_.caseExpression.add((t1!=null?input.toString(t1.start,t1.stop):null)); 
						  //System.out.println((t1!=null?input.toString(t1.start,t1.stop):null));
						  }
					}
					break;
				case 2 :
					// WreslPlus.g:634:4: svar_table_2
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_svar_table_2_in_svar_table2898);
					svar_table_2235=svar_table_2();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, svar_table_2235.getTree());

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
	// $ANTLR end "svar_table"


	public static class svar_table_1_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_table_1"
	// WreslPlus.g:636:1: svar_table_1 : s= SELECT ( ID | reservedID ) f= FROM ID (g= GIVEN expr_assign u= USE ID )? (w= WHERE where )? ;
	public final WreslPlusParser.svar_table_1_return svar_table_1() throws RecognitionException {
		WreslPlusParser.svar_table_1_return retval = new WreslPlusParser.svar_table_1_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		Token f=null;
		Token g=null;
		Token u=null;
		Token w=null;
		Token ID236=null;
		Token ID238=null;
		Token ID240=null;
		ParserRuleReturnScope reservedID237 =null;
		ParserRuleReturnScope expr_assign239 =null;
		ParserRuleReturnScope where241 =null;

		CommonTree s_tree=null;
		CommonTree f_tree=null;
		CommonTree g_tree=null;
		CommonTree u_tree=null;
		CommonTree w_tree=null;
		CommonTree ID236_tree=null;
		CommonTree ID238_tree=null;
		CommonTree ID240_tree=null;

		try {
			// WreslPlus.g:637:2: (s= SELECT ( ID | reservedID ) f= FROM ID (g= GIVEN expr_assign u= USE ID )? (w= WHERE where )? )
			// WreslPlus.g:637:4: s= SELECT ( ID | reservedID ) f= FROM ID (g= GIVEN expr_assign u= USE ID )? (w= WHERE where )?
			{
			root_0 = (CommonTree)adaptor.nil();


			s=(Token)match(input,SELECT,FOLLOW_SELECT_in_svar_table_12911); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			s_tree = (CommonTree)adaptor.create(s);
			adaptor.addChild(root_0, s_tree);
			}

			if ( state.backtracking==0 ) { s.setText("select ");}
			// WreslPlus.g:637:39: ( ID | reservedID )
			int alt59=2;
			int LA59_0 = input.LA(1);
			if ( (LA59_0==ID) ) {
				alt59=1;
			}
			else if ( (LA59_0==DAY||LA59_0==MONTH||LA59_0==WATERYEAR) ) {
				alt59=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 59, 0, input);
				throw nvae;
			}

			switch (alt59) {
				case 1 :
					// WreslPlus.g:637:40: ID
					{
					ID236=(Token)match(input,ID,FOLLOW_ID_in_svar_table_12916); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID236_tree = (CommonTree)adaptor.create(ID236);
					adaptor.addChild(root_0, ID236_tree);
					}

					}
					break;
				case 2 :
					// WreslPlus.g:637:43: reservedID
					{
					pushFollow(FOLLOW_reservedID_in_svar_table_12918);
					reservedID237=reservedID();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, reservedID237.getTree());

					}
					break;

			}

			f=(Token)match(input,FROM,FOLLOW_FROM_in_svar_table_12927); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			f_tree = (CommonTree)adaptor.create(f);
			adaptor.addChild(root_0, f_tree);
			}

			if ( state.backtracking==0 ) { f.setText(" from ");}
			ID238=(Token)match(input,ID,FOLLOW_ID_in_svar_table_12933); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID238_tree = (CommonTree)adaptor.create(ID238);
			adaptor.addChild(root_0, ID238_tree);
			}

			// WreslPlus.g:639:4: (g= GIVEN expr_assign u= USE ID )?
			int alt60=2;
			int LA60_0 = input.LA(1);
			if ( (LA60_0==GIVEN) ) {
				alt60=1;
			}
			switch (alt60) {
				case 1 :
					// WreslPlus.g:639:5: g= GIVEN expr_assign u= USE ID
					{
					g=(Token)match(input,GIVEN,FOLLOW_GIVEN_in_svar_table_12942); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					g_tree = (CommonTree)adaptor.create(g);
					adaptor.addChild(root_0, g_tree);
					}

					if ( state.backtracking==0 ) { g.setText(" given ");}
					pushFollow(FOLLOW_expr_assign_in_svar_table_12946);
					expr_assign239=expr_assign();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_assign239.getTree());

					u=(Token)match(input,USE,FOLLOW_USE_in_svar_table_12955); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					u_tree = (CommonTree)adaptor.create(u);
					adaptor.addChild(root_0, u_tree);
					}

					if ( state.backtracking==0 ) { u.setText(" use ");}
					ID240=(Token)match(input,ID,FOLLOW_ID_in_svar_table_12962); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID240_tree = (CommonTree)adaptor.create(ID240);
					adaptor.addChild(root_0, ID240_tree);
					}

					}
					break;

			}

			// WreslPlus.g:641:4: (w= WHERE where )?
			int alt61=2;
			int LA61_0 = input.LA(1);
			if ( (LA61_0==WHERE) ) {
				alt61=1;
			}
			switch (alt61) {
				case 1 :
					// WreslPlus.g:641:5: w= WHERE where
					{
					w=(Token)match(input,WHERE,FOLLOW_WHERE_in_svar_table_12973); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					w_tree = (CommonTree)adaptor.create(w);
					adaptor.addChild(root_0, w_tree);
					}

					if ( state.backtracking==0 ) { w.setText(" where ");}
					pushFollow(FOLLOW_where_in_svar_table_12977);
					where241=where();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, where241.getTree());

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
	// $ANTLR end "svar_table_1"


	public static class where_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "where"
	// WreslPlus.g:644:1: where : expr_assign ( ',' expr_assign )* ;
	public final WreslPlusParser.where_return where() throws RecognitionException {
		WreslPlusParser.where_return retval = new WreslPlusParser.where_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal243=null;
		ParserRuleReturnScope expr_assign242 =null;
		ParserRuleReturnScope expr_assign244 =null;

		CommonTree char_literal243_tree=null;

		try {
			// WreslPlus.g:644:6: ( expr_assign ( ',' expr_assign )* )
			// WreslPlus.g:644:8: expr_assign ( ',' expr_assign )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_assign_in_where2991);
			expr_assign242=expr_assign();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_assign242.getTree());

			// WreslPlus.g:644:20: ( ',' expr_assign )*
			loop62:
			while (true) {
				int alt62=2;
				int LA62_0 = input.LA(1);
				if ( (LA62_0==107) ) {
					alt62=1;
				}

				switch (alt62) {
				case 1 :
					// WreslPlus.g:644:21: ',' expr_assign
					{
					char_literal243=(Token)match(input,107,FOLLOW_107_in_where2994); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal243_tree = (CommonTree)adaptor.create(char_literal243);
					adaptor.addChild(root_0, char_literal243_tree);
					}

					pushFollow(FOLLOW_expr_assign_in_where2996);
					expr_assign244=expr_assign();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_assign244.getTree());

					}
					break;

				default :
					break loop62;
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
	// $ANTLR end "where"


	public static class svar_table_2_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "svar_table_2"
	// WreslPlus.g:646:1: svar_table_2 : 'table' '(' ')' ;
	public final WreslPlusParser.svar_table_2_return svar_table_2() throws RecognitionException {
		WreslPlusParser.svar_table_2_return retval = new WreslPlusParser.svar_table_2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal245=null;
		Token char_literal246=null;
		Token char_literal247=null;

		CommonTree string_literal245_tree=null;
		CommonTree char_literal246_tree=null;
		CommonTree char_literal247_tree=null;

		try {
			// WreslPlus.g:647:2: ( 'table' '(' ')' )
			// WreslPlus.g:647:4: 'table' '(' ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal245=(Token)match(input,124,FOLLOW_124_in_svar_table_23008); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal245_tree = (CommonTree)adaptor.create(string_literal245);
			adaptor.addChild(root_0, string_literal245_tree);
			}

			char_literal246=(Token)match(input,103,FOLLOW_103_in_svar_table_23010); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal246_tree = (CommonTree)adaptor.create(char_literal246);
			adaptor.addChild(root_0, char_literal246_tree);
			}

			char_literal247=(Token)match(input,104,FOLLOW_104_in_svar_table_23012); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal247_tree = (CommonTree)adaptor.create(char_literal247);
			adaptor.addChild(root_0, char_literal247_tree);
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
	// $ANTLR end "svar_table_2"


	public static class dimension_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dimension"
	// WreslPlus.g:652:1: dimension : '[' ( INT | ID ) ']' ;
	public final WreslPlusParser.dimension_return dimension() throws RecognitionException {
		WreslPlusParser.dimension_return retval = new WreslPlusParser.dimension_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal248=null;
		Token set249=null;
		Token char_literal250=null;

		CommonTree char_literal248_tree=null;
		CommonTree set249_tree=null;
		CommonTree char_literal250_tree=null;

		try {
			// WreslPlus.g:652:11: ( '[' ( INT | ID ) ']' )
			// WreslPlus.g:652:13: '[' ( INT | ID ) ']'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal248=(Token)match(input,119,FOLLOW_119_in_dimension3024); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal248_tree = (CommonTree)adaptor.create(char_literal248);
			adaptor.addChild(root_0, char_literal248_tree);
			}

			set249=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set249));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal250=(Token)match(input,120,FOLLOW_120_in_dimension3036); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal250_tree = (CommonTree)adaptor.create(char_literal250);
			adaptor.addChild(root_0, char_literal250_tree);
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
	// $ANTLR end "dimension"


	public static class dimension_time_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dimension_time"
	// WreslPlus.g:654:1: dimension_time : '(' ( INT | ID ) ')' ;
	public final WreslPlusParser.dimension_time_return dimension_time() throws RecognitionException {
		WreslPlusParser.dimension_time_return retval = new WreslPlusParser.dimension_time_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal251=null;
		Token set252=null;
		Token char_literal253=null;

		CommonTree char_literal251_tree=null;
		CommonTree set252_tree=null;
		CommonTree char_literal253_tree=null;

		try {
			// WreslPlus.g:654:16: ( '(' ( INT | ID ) ')' )
			// WreslPlus.g:654:18: '(' ( INT | ID ) ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal251=(Token)match(input,103,FOLLOW_103_in_dimension_time3045); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal251_tree = (CommonTree)adaptor.create(char_literal251);
			adaptor.addChild(root_0, char_literal251_tree);
			}

			set252=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set252));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal253=(Token)match(input,104,FOLLOW_104_in_dimension_time3057); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal253_tree = (CommonTree)adaptor.create(char_literal253);
			adaptor.addChild(root_0, char_literal253_tree);
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
	// $ANTLR end "dimension_time"


	protected static class timeseries_scope {
		TimeseriesTemp ts_;
		String id_;
	}
	protected Stack<timeseries_scope> timeseries_stack = new Stack<timeseries_scope>();

	public static class timeseries_return extends ParserRuleReturnScope {
		public String id;
		public TimeseriesTemp tsObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "timeseries"
	// WreslPlus.g:669:1: timeseries returns [String id, TimeseriesTemp tsObj] : ( timeseries_new | timeseries_old );
	public final WreslPlusParser.timeseries_return timeseries() throws RecognitionException {
		timeseries_stack.push(new timeseries_scope());
		WreslPlusParser.timeseries_return retval = new WreslPlusParser.timeseries_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope timeseries_new254 =null;
		ParserRuleReturnScope timeseries_old255 =null;


		 timeseries_stack.peek().ts_ = new TimeseriesTemp(); 
		       timeseries_stack.peek().ts_.fromWresl = this.currentAbsolutePath; 
			 
		try {
			// WreslPlus.g:680:2: ( timeseries_new | timeseries_old )
			int alt63=2;
			int LA63_0 = input.LA(1);
			if ( (LA63_0==TIMESERIES) ) {
				alt63=1;
			}
			else if ( (LA63_0==DEFINE) ) {
				alt63=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 63, 0, input);
				throw nvae;
			}

			switch (alt63) {
				case 1 :
					// WreslPlus.g:680:4: timeseries_new
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_timeseries_new_in_timeseries3096);
					timeseries_new254=timeseries_new();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeseries_new254.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:680:21: timeseries_old
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_timeseries_old_in_timeseries3100);
					timeseries_old255=timeseries_old();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeseries_old255.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { retval.id = timeseries_stack.peek().ts_.id; 
			        retval.tsObj = timeseries_stack.peek().ts_; 
			        retval.tsObj.line = line;
				 }
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			timeseries_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "timeseries"


	public static class timeseries_new_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "timeseries_new"
	// WreslPlus.g:682:1: timeseries_new : TIMESERIES tsID '{' ( NAME bpart_id )? tsKind tsUnits ( convert )? '}' ;
	public final WreslPlusParser.timeseries_new_return timeseries_new() throws RecognitionException {
		WreslPlusParser.timeseries_new_return retval = new WreslPlusParser.timeseries_new_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token TIMESERIES256=null;
		Token char_literal258=null;
		Token NAME259=null;
		Token char_literal264=null;
		ParserRuleReturnScope tsID257 =null;
		ParserRuleReturnScope bpart_id260 =null;
		ParserRuleReturnScope tsKind261 =null;
		ParserRuleReturnScope tsUnits262 =null;
		ParserRuleReturnScope convert263 =null;

		CommonTree TIMESERIES256_tree=null;
		CommonTree char_literal258_tree=null;
		CommonTree NAME259_tree=null;
		CommonTree char_literal264_tree=null;

		try {
			// WreslPlus.g:682:16: ( TIMESERIES tsID '{' ( NAME bpart_id )? tsKind tsUnits ( convert )? '}' )
			// WreslPlus.g:682:18: TIMESERIES tsID '{' ( NAME bpart_id )? tsKind tsUnits ( convert )? '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			TIMESERIES256=(Token)match(input,TIMESERIES,FOLLOW_TIMESERIES_in_timeseries_new3109); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			TIMESERIES256_tree = (CommonTree)adaptor.create(TIMESERIES256);
			adaptor.addChild(root_0, TIMESERIES256_tree);
			}

			if ( state.backtracking==0 ) {line=(TIMESERIES256!=null?TIMESERIES256.getLine():0);}
			pushFollow(FOLLOW_tsID_in_timeseries_new3112);
			tsID257=tsID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, tsID257.getTree());

			char_literal258=(Token)match(input,125,FOLLOW_125_in_timeseries_new3119); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal258_tree = (CommonTree)adaptor.create(char_literal258);
			adaptor.addChild(root_0, char_literal258_tree);
			}

			// WreslPlus.g:682:67: ( NAME bpart_id )?
			int alt64=2;
			int LA64_0 = input.LA(1);
			if ( (LA64_0==NAME) ) {
				alt64=1;
			}
			switch (alt64) {
				case 1 :
					// WreslPlus.g:682:68: NAME bpart_id
					{
					NAME259=(Token)match(input,NAME,FOLLOW_NAME_in_timeseries_new3122); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NAME259_tree = (CommonTree)adaptor.create(NAME259);
					adaptor.addChild(root_0, NAME259_tree);
					}

					pushFollow(FOLLOW_bpart_id_in_timeseries_new3129);
					bpart_id260=bpart_id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, bpart_id260.getTree());

					}
					break;

			}

			pushFollow(FOLLOW_tsKind_in_timeseries_new3133);
			tsKind261=tsKind();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, tsKind261.getTree());

			pushFollow(FOLLOW_tsUnits_in_timeseries_new3135);
			tsUnits262=tsUnits();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, tsUnits262.getTree());

			// WreslPlus.g:682:104: ( convert )?
			int alt65=2;
			int LA65_0 = input.LA(1);
			if ( (LA65_0==CONVERT) ) {
				alt65=1;
			}
			switch (alt65) {
				case 1 :
					// WreslPlus.g:682:104: convert
					{
					pushFollow(FOLLOW_convert_in_timeseries_new3137);
					convert263=convert();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, convert263.getTree());

					}
					break;

			}

			char_literal264=(Token)match(input,126,FOLLOW_126_in_timeseries_new3140); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal264_tree = (CommonTree)adaptor.create(char_literal264);
			adaptor.addChild(root_0, char_literal264_tree);
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
	// $ANTLR end "timeseries_new"


	public static class timeseries_old_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "timeseries_old"
	// WreslPlus.g:683:1: timeseries_old : DEFINE ( local_deprecated )? tsID '{' TIMESERIES ( bpart_id )? tsKind tsUnits ( convert )? '}' ;
	public final WreslPlusParser.timeseries_old_return timeseries_old() throws RecognitionException {
		WreslPlusParser.timeseries_old_return retval = new WreslPlusParser.timeseries_old_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DEFINE265=null;
		Token char_literal268=null;
		Token TIMESERIES269=null;
		Token char_literal274=null;
		ParserRuleReturnScope local_deprecated266 =null;
		ParserRuleReturnScope tsID267 =null;
		ParserRuleReturnScope bpart_id270 =null;
		ParserRuleReturnScope tsKind271 =null;
		ParserRuleReturnScope tsUnits272 =null;
		ParserRuleReturnScope convert273 =null;

		CommonTree DEFINE265_tree=null;
		CommonTree char_literal268_tree=null;
		CommonTree TIMESERIES269_tree=null;
		CommonTree char_literal274_tree=null;

		try {
			// WreslPlus.g:683:16: ( DEFINE ( local_deprecated )? tsID '{' TIMESERIES ( bpart_id )? tsKind tsUnits ( convert )? '}' )
			// WreslPlus.g:683:18: DEFINE ( local_deprecated )? tsID '{' TIMESERIES ( bpart_id )? tsKind tsUnits ( convert )? '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			DEFINE265=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_timeseries_old3148); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DEFINE265_tree = (CommonTree)adaptor.create(DEFINE265);
			adaptor.addChild(root_0, DEFINE265_tree);
			}

			if ( state.backtracking==0 ) {line=(DEFINE265!=null?DEFINE265.getLine():0);}
			// WreslPlus.g:683:45: ( local_deprecated )?
			int alt66=2;
			int LA66_0 = input.LA(1);
			if ( (LA66_0==119) ) {
				alt66=1;
			}
			switch (alt66) {
				case 1 :
					// WreslPlus.g:683:46: local_deprecated
					{
					pushFollow(FOLLOW_local_deprecated_in_timeseries_old3152);
					local_deprecated266=local_deprecated();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, local_deprecated266.getTree());

					}
					break;

			}

			pushFollow(FOLLOW_tsID_in_timeseries_old3156);
			tsID267=tsID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, tsID267.getTree());

			char_literal268=(Token)match(input,125,FOLLOW_125_in_timeseries_old3160); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal268_tree = (CommonTree)adaptor.create(char_literal268);
			adaptor.addChild(root_0, char_literal268_tree);
			}

			TIMESERIES269=(Token)match(input,TIMESERIES,FOLLOW_TIMESERIES_in_timeseries_old3162); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			TIMESERIES269_tree = (CommonTree)adaptor.create(TIMESERIES269);
			adaptor.addChild(root_0, TIMESERIES269_tree);
			}

			// WreslPlus.g:683:87: ( bpart_id )?
			int alt67=2;
			int LA67_0 = input.LA(1);
			if ( (LA67_0==QUOTE) ) {
				alt67=1;
			}
			switch (alt67) {
				case 1 :
					// WreslPlus.g:683:87: bpart_id
					{
					pushFollow(FOLLOW_bpart_id_in_timeseries_old3164);
					bpart_id270=bpart_id();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, bpart_id270.getTree());

					}
					break;

			}

			pushFollow(FOLLOW_tsKind_in_timeseries_old3167);
			tsKind271=tsKind();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, tsKind271.getTree());

			pushFollow(FOLLOW_tsUnits_in_timeseries_old3169);
			tsUnits272=tsUnits();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, tsUnits272.getTree());

			// WreslPlus.g:683:112: ( convert )?
			int alt68=2;
			int LA68_0 = input.LA(1);
			if ( (LA68_0==CONVERT) ) {
				alt68=1;
			}
			switch (alt68) {
				case 1 :
					// WreslPlus.g:683:112: convert
					{
					pushFollow(FOLLOW_convert_in_timeseries_old3171);
					convert273=convert();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, convert273.getTree());

					}
					break;

			}

			char_literal274=(Token)match(input,126,FOLLOW_126_in_timeseries_old3174); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal274_tree = (CommonTree)adaptor.create(char_literal274);
			adaptor.addChild(root_0, char_literal274_tree);
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
	// $ANTLR end "timeseries_old"


	public static class tsID_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tsID"
	// WreslPlus.g:685:1: tsID : i= ID ;
	public final WreslPlusParser.tsID_return tsID() throws RecognitionException {
		WreslPlusParser.tsID_return retval = new WreslPlusParser.tsID_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;

		CommonTree i_tree=null;

		try {
			// WreslPlus.g:685:6: (i= ID )
			// WreslPlus.g:685:8: i= ID
			{
			root_0 = (CommonTree)adaptor.nil();


			i=(Token)match(input,ID,FOLLOW_ID_in_tsID3188); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) {timeseries_stack.peek().ts_.id=(i!=null?i.getText():null);timeseries_stack.peek().ts_.dssBPart=(i!=null?i.getText():null);}
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
	// $ANTLR end "tsID"


	public static class tsUnits_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tsUnits"
	// WreslPlus.g:686:1: tsUnits : UNITS s= QUOTE ;
	public final WreslPlusParser.tsUnits_return tsUnits() throws RecognitionException {
		WreslPlusParser.tsUnits_return retval = new WreslPlusParser.tsUnits_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		Token UNITS275=null;

		CommonTree s_tree=null;
		CommonTree UNITS275_tree=null;

		try {
			// WreslPlus.g:686:8: ( UNITS s= QUOTE )
			// WreslPlus.g:686:10: UNITS s= QUOTE
			{
			root_0 = (CommonTree)adaptor.nil();


			UNITS275=(Token)match(input,UNITS,FOLLOW_UNITS_in_tsUnits3200); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			UNITS275_tree = (CommonTree)adaptor.create(UNITS275);
			adaptor.addChild(root_0, UNITS275_tree);
			}

			s=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_tsUnits3204); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			s_tree = (CommonTree)adaptor.create(s);
			adaptor.addChild(root_0, s_tree);
			}

			if ( state.backtracking==0 ) {timeseries_stack.peek().ts_.units=Tools.strip((s!=null?s.getText():null));}
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
	// $ANTLR end "tsUnits"


	public static class tsKind_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tsKind"
	// WreslPlus.g:687:1: tsKind : KIND s= QUOTE ;
	public final WreslPlusParser.tsKind_return tsKind() throws RecognitionException {
		WreslPlusParser.tsKind_return retval = new WreslPlusParser.tsKind_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		Token KIND276=null;

		CommonTree s_tree=null;
		CommonTree KIND276_tree=null;

		try {
			// WreslPlus.g:687:7: ( KIND s= QUOTE )
			// WreslPlus.g:687:10: KIND s= QUOTE
			{
			root_0 = (CommonTree)adaptor.nil();


			KIND276=(Token)match(input,KIND,FOLLOW_KIND_in_tsKind3214); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			KIND276_tree = (CommonTree)adaptor.create(KIND276);
			adaptor.addChild(root_0, KIND276_tree);
			}

			s=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_tsKind3218); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			s_tree = (CommonTree)adaptor.create(s);
			adaptor.addChild(root_0, s_tree);
			}

			if ( state.backtracking==0 ) {timeseries_stack.peek().ts_.kind=Tools.strip((s!=null?s.getText():null));}
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
	// $ANTLR end "tsKind"


	public static class bpart_id_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "bpart_id"
	// WreslPlus.g:688:1: bpart_id : s= QUOTE ;
	public final WreslPlusParser.bpart_id_return bpart_id() throws RecognitionException {
		WreslPlusParser.bpart_id_return retval = new WreslPlusParser.bpart_id_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;

		CommonTree s_tree=null;

		try {
			// WreslPlus.g:688:10: (s= QUOTE )
			// WreslPlus.g:688:12: s= QUOTE
			{
			root_0 = (CommonTree)adaptor.nil();


			s=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_bpart_id3233); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			s_tree = (CommonTree)adaptor.create(s);
			adaptor.addChild(root_0, s_tree);
			}

			if ( state.backtracking==0 ) {timeseries_stack.peek().ts_.dssBPart=Tools.strip((s!=null?s.getText():null));}
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
	// $ANTLR end "bpart_id"


	public static class convert_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "convert"
	// WreslPlus.g:689:1: convert : CONVERT s= QUOTE ;
	public final WreslPlusParser.convert_return convert() throws RecognitionException {
		WreslPlusParser.convert_return retval = new WreslPlusParser.convert_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		Token CONVERT277=null;

		CommonTree s_tree=null;
		CommonTree CONVERT277_tree=null;

		try {
			// WreslPlus.g:689:9: ( CONVERT s= QUOTE )
			// WreslPlus.g:689:11: CONVERT s= QUOTE
			{
			root_0 = (CommonTree)adaptor.nil();


			CONVERT277=(Token)match(input,CONVERT,FOLLOW_CONVERT_in_convert3242); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			CONVERT277_tree = (CommonTree)adaptor.create(CONVERT277);
			adaptor.addChild(root_0, CONVERT277_tree);
			}

			s=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_convert3246); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			s_tree = (CommonTree)adaptor.create(s);
			adaptor.addChild(root_0, s_tree);
			}

			if ( state.backtracking==0 ) {timeseries_stack.peek().ts_.convertToUnits=Tools.strip((s!=null?s.getText():null));}
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
	// $ANTLR end "convert"


	public static class network_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "network"
	// WreslPlus.g:692:1: network : NETWORK ID '{' ( node )? ( connection )+ '}' ;
	public final WreslPlusParser.network_return network() throws RecognitionException {
		WreslPlusParser.network_return retval = new WreslPlusParser.network_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token NETWORK278=null;
		Token ID279=null;
		Token char_literal280=null;
		Token char_literal283=null;
		ParserRuleReturnScope node281 =null;
		ParserRuleReturnScope connection282 =null;

		CommonTree NETWORK278_tree=null;
		CommonTree ID279_tree=null;
		CommonTree char_literal280_tree=null;
		CommonTree char_literal283_tree=null;

		try {
			// WreslPlus.g:692:9: ( NETWORK ID '{' ( node )? ( connection )+ '}' )
			// WreslPlus.g:692:11: NETWORK ID '{' ( node )? ( connection )+ '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			NETWORK278=(Token)match(input,NETWORK,FOLLOW_NETWORK_in_network3257); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NETWORK278_tree = (CommonTree)adaptor.create(NETWORK278);
			adaptor.addChild(root_0, NETWORK278_tree);
			}

			ID279=(Token)match(input,ID,FOLLOW_ID_in_network3259); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID279_tree = (CommonTree)adaptor.create(ID279);
			adaptor.addChild(root_0, ID279_tree);
			}

			char_literal280=(Token)match(input,125,FOLLOW_125_in_network3261); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal280_tree = (CommonTree)adaptor.create(char_literal280);
			adaptor.addChild(root_0, char_literal280_tree);
			}

			// WreslPlus.g:692:26: ( node )?
			int alt69=2;
			int LA69_0 = input.LA(1);
			if ( (LA69_0==NODE) ) {
				alt69=1;
			}
			switch (alt69) {
				case 1 :
					// WreslPlus.g:692:26: node
					{
					pushFollow(FOLLOW_node_in_network3263);
					node281=node();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, node281.getTree());

					}
					break;

			}

			// WreslPlus.g:692:32: ( connection )+
			int cnt70=0;
			loop70:
			while (true) {
				int alt70=2;
				int LA70_0 = input.LA(1);
				if ( (LA70_0==ID||LA70_0==INFLOW) ) {
					alt70=1;
				}

				switch (alt70) {
				case 1 :
					// WreslPlus.g:692:32: connection
					{
					pushFollow(FOLLOW_connection_in_network3266);
					connection282=connection();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, connection282.getTree());

					}
					break;

				default :
					if ( cnt70 >= 1 ) break loop70;
					if (state.backtracking>0) {state.failed=true; return retval;}
					EarlyExitException eee = new EarlyExitException(70, input);
					throw eee;
				}
				cnt70++;
			}

			char_literal283=(Token)match(input,126,FOLLOW_126_in_network3269); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal283_tree = (CommonTree)adaptor.create(char_literal283);
			adaptor.addChild(root_0, char_literal283_tree);
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
	// $ANTLR end "network"


	public static class node_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "node"
	// WreslPlus.g:696:1: node : NODE ID ( ',' ID )* ;
	public final WreslPlusParser.node_return node() throws RecognitionException {
		WreslPlusParser.node_return retval = new WreslPlusParser.node_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token NODE284=null;
		Token ID285=null;
		Token char_literal286=null;
		Token ID287=null;

		CommonTree NODE284_tree=null;
		CommonTree ID285_tree=null;
		CommonTree char_literal286_tree=null;
		CommonTree ID287_tree=null;

		try {
			// WreslPlus.g:696:5: ( NODE ID ( ',' ID )* )
			// WreslPlus.g:696:9: NODE ID ( ',' ID )*
			{
			root_0 = (CommonTree)adaptor.nil();


			NODE284=(Token)match(input,NODE,FOLLOW_NODE_in_node3280); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			NODE284_tree = (CommonTree)adaptor.create(NODE284);
			adaptor.addChild(root_0, NODE284_tree);
			}

			ID285=(Token)match(input,ID,FOLLOW_ID_in_node3285); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID285_tree = (CommonTree)adaptor.create(ID285);
			adaptor.addChild(root_0, ID285_tree);
			}

			// WreslPlus.g:696:20: ( ',' ID )*
			loop71:
			while (true) {
				int alt71=2;
				int LA71_0 = input.LA(1);
				if ( (LA71_0==107) ) {
					alt71=1;
				}

				switch (alt71) {
				case 1 :
					// WreslPlus.g:696:22: ',' ID
					{
					char_literal286=(Token)match(input,107,FOLLOW_107_in_node3289); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal286_tree = (CommonTree)adaptor.create(char_literal286);
					adaptor.addChild(root_0, char_literal286_tree);
					}

					ID287=(Token)match(input,ID,FOLLOW_ID_in_node3291); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID287_tree = (CommonTree)adaptor.create(ID287);
					adaptor.addChild(root_0, ID287_tree);
					}

					}
					break;

				default :
					break loop71;
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
	// $ANTLR end "node"


	public static class connection_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "connection"
	// WreslPlus.g:698:1: connection : ( branch | branch_short );
	public final WreslPlusParser.connection_return connection() throws RecognitionException {
		WreslPlusParser.connection_return retval = new WreslPlusParser.connection_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope branch288 =null;
		ParserRuleReturnScope branch_short289 =null;


		try {
			// WreslPlus.g:698:11: ( branch | branch_short )
			int alt72=2;
			int LA72_0 = input.LA(1);
			if ( (LA72_0==ID) ) {
				alt72=1;
			}
			else if ( (LA72_0==INFLOW) ) {
				int LA72_2 = input.LA(2);
				if ( (LA72_2==ID) ) {
					switch ( input.LA(3) ) {
					case 109:
						{
						int LA72_4 = input.LA(4);
						if ( (LA72_4==ID) ) {
							int LA72_6 = input.LA(5);
							if ( (LA72_6==FLOW) ) {
								alt72=1;
							}
							else if ( (LA72_6==OUTFLOW) ) {
								alt72=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 72, 6, input);
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
									new NoViableAltException("", 72, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case FLOW:
						{
						alt72=1;
						}
						break;
					case OUTFLOW:
						{
						alt72=2;
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
								new NoViableAltException("", 72, 3, input);
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
							new NoViableAltException("", 72, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 72, 0, input);
				throw nvae;
			}

			switch (alt72) {
				case 1 :
					// WreslPlus.g:698:16: branch
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_branch_in_connection3304);
					branch288=branch();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, branch288.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:698:25: branch_short
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_branch_short_in_connection3308);
					branch_short289=branch_short();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, branch_short289.getTree());

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
	// $ANTLR end "connection"


	public static class inlet_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "inlet"
	// WreslPlus.g:700:1: inlet : INFLOW element ;
	public final WreslPlusParser.inlet_return inlet() throws RecognitionException {
		WreslPlusParser.inlet_return retval = new WreslPlusParser.inlet_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INFLOW290=null;
		ParserRuleReturnScope element291 =null;

		CommonTree INFLOW290_tree=null;

		try {
			// WreslPlus.g:700:13: ( INFLOW element )
			// WreslPlus.g:700:16: INFLOW element
			{
			root_0 = (CommonTree)adaptor.nil();


			INFLOW290=(Token)match(input,INFLOW,FOLLOW_INFLOW_in_inlet3324); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INFLOW290_tree = (CommonTree)adaptor.create(INFLOW290);
			adaptor.addChild(root_0, INFLOW290_tree);
			}

			pushFollow(FOLLOW_element_in_inlet3327);
			element291=element();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, element291.getTree());

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
	// $ANTLR end "inlet"


	public static class outlet_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "outlet"
	// WreslPlus.g:701:1: outlet : element OUTFLOW ;
	public final WreslPlusParser.outlet_return outlet() throws RecognitionException {
		WreslPlusParser.outlet_return retval = new WreslPlusParser.outlet_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OUTFLOW293=null;
		ParserRuleReturnScope element292 =null;

		CommonTree OUTFLOW293_tree=null;

		try {
			// WreslPlus.g:701:13: ( element OUTFLOW )
			// WreslPlus.g:701:16: element OUTFLOW
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_element_in_outlet3341);
			element292=element();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, element292.getTree());

			OUTFLOW293=(Token)match(input,OUTFLOW,FOLLOW_OUTFLOW_in_outlet3343); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			OUTFLOW293_tree = (CommonTree)adaptor.create(OUTFLOW293);
			adaptor.addChild(root_0, OUTFLOW293_tree);
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
	// $ANTLR end "outlet"


	public static class inoutlet_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "inoutlet"
	// WreslPlus.g:702:1: inoutlet : INFLOW element OUTFLOW ;
	public final WreslPlusParser.inoutlet_return inoutlet() throws RecognitionException {
		WreslPlusParser.inoutlet_return retval = new WreslPlusParser.inoutlet_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INFLOW294=null;
		Token OUTFLOW296=null;
		ParserRuleReturnScope element295 =null;

		CommonTree INFLOW294_tree=null;
		CommonTree OUTFLOW296_tree=null;

		try {
			// WreslPlus.g:702:13: ( INFLOW element OUTFLOW )
			// WreslPlus.g:702:16: INFLOW element OUTFLOW
			{
			root_0 = (CommonTree)adaptor.nil();


			INFLOW294=(Token)match(input,INFLOW,FOLLOW_INFLOW_in_inoutlet3355); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INFLOW294_tree = (CommonTree)adaptor.create(INFLOW294);
			adaptor.addChild(root_0, INFLOW294_tree);
			}

			pushFollow(FOLLOW_element_in_inoutlet3357);
			element295=element();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, element295.getTree());

			OUTFLOW296=(Token)match(input,OUTFLOW,FOLLOW_OUTFLOW_in_inoutlet3359); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			OUTFLOW296_tree = (CommonTree)adaptor.create(OUTFLOW296);
			adaptor.addChild(root_0, OUTFLOW296_tree);
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
	// $ANTLR end "inoutlet"


	public static class branch_short_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "branch_short"
	// WreslPlus.g:704:1: branch_short : inoutlet ;
	public final WreslPlusParser.branch_short_return branch_short() throws RecognitionException {
		WreslPlusParser.branch_short_return retval = new WreslPlusParser.branch_short_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope inoutlet297 =null;


		try {
			// WreslPlus.g:704:14: ( inoutlet )
			// WreslPlus.g:704:16: inoutlet
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_inoutlet_in_branch_short3368);
			inoutlet297=inoutlet();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, inoutlet297.getTree());

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
	// $ANTLR end "branch_short"


	public static class branch_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "branch"
	// WreslPlus.g:706:1: branch : ( elements | inlet ) FLOW ( element FLOW )* ( elements | outlet ) ;
	public final WreslPlusParser.branch_return branch() throws RecognitionException {
		WreslPlusParser.branch_return retval = new WreslPlusParser.branch_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FLOW300=null;
		Token FLOW302=null;
		ParserRuleReturnScope elements298 =null;
		ParserRuleReturnScope inlet299 =null;
		ParserRuleReturnScope element301 =null;
		ParserRuleReturnScope elements303 =null;
		ParserRuleReturnScope outlet304 =null;

		CommonTree FLOW300_tree=null;
		CommonTree FLOW302_tree=null;

		try {
			// WreslPlus.g:706:8: ( ( elements | inlet ) FLOW ( element FLOW )* ( elements | outlet ) )
			// WreslPlus.g:706:10: ( elements | inlet ) FLOW ( element FLOW )* ( elements | outlet )
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:706:10: ( elements | inlet )
			int alt73=2;
			int LA73_0 = input.LA(1);
			if ( (LA73_0==ID) ) {
				alt73=1;
			}
			else if ( (LA73_0==INFLOW) ) {
				alt73=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 73, 0, input);
				throw nvae;
			}

			switch (alt73) {
				case 1 :
					// WreslPlus.g:706:11: elements
					{
					pushFollow(FOLLOW_elements_in_branch3378);
					elements298=elements();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, elements298.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:706:22: inlet
					{
					pushFollow(FOLLOW_inlet_in_branch3382);
					inlet299=inlet();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, inlet299.getTree());

					}
					break;

			}

			FLOW300=(Token)match(input,FLOW,FOLLOW_FLOW_in_branch3385); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			FLOW300_tree = (CommonTree)adaptor.create(FLOW300);
			adaptor.addChild(root_0, FLOW300_tree);
			}

			// WreslPlus.g:706:35: ( element FLOW )*
			loop74:
			while (true) {
				int alt74=2;
				int LA74_0 = input.LA(1);
				if ( (LA74_0==ID) ) {
					int LA74_1 = input.LA(2);
					if ( (LA74_1==109) ) {
						int LA74_2 = input.LA(3);
						if ( (LA74_2==ID) ) {
							int LA74_5 = input.LA(4);
							if ( (LA74_5==FLOW) ) {
								alt74=1;
							}

						}

					}
					else if ( (LA74_1==FLOW) ) {
						alt74=1;
					}

				}

				switch (alt74) {
				case 1 :
					// WreslPlus.g:706:36: element FLOW
					{
					pushFollow(FOLLOW_element_in_branch3389);
					element301=element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, element301.getTree());

					FLOW302=(Token)match(input,FLOW,FOLLOW_FLOW_in_branch3391); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					FLOW302_tree = (CommonTree)adaptor.create(FLOW302);
					adaptor.addChild(root_0, FLOW302_tree);
					}

					}
					break;

				default :
					break loop74;
				}
			}

			// WreslPlus.g:706:52: ( elements | outlet )
			int alt75=2;
			int LA75_0 = input.LA(1);
			if ( (LA75_0==ID) ) {
				switch ( input.LA(2) ) {
				case 109:
					{
					int LA75_2 = input.LA(3);
					if ( (LA75_2==ID) ) {
						int LA75_5 = input.LA(4);
						if ( (LA75_5==ID||LA75_5==INFLOW||LA75_5==107||LA75_5==126) ) {
							alt75=1;
						}
						else if ( (LA75_5==OUTFLOW) ) {
							alt75=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 75, 5, input);
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
								new NoViableAltException("", 75, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case ID:
				case INFLOW:
				case 107:
				case 126:
					{
					alt75=1;
					}
					break;
				case OUTFLOW:
					{
					alt75=2;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 75, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 75, 0, input);
				throw nvae;
			}

			switch (alt75) {
				case 1 :
					// WreslPlus.g:706:53: elements
					{
					pushFollow(FOLLOW_elements_in_branch3397);
					elements303=elements();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, elements303.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:706:64: outlet
					{
					pushFollow(FOLLOW_outlet_in_branch3401);
					outlet304=outlet();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, outlet304.getTree());

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
	// $ANTLR end "branch"


	public static class elements_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "elements"
	// WreslPlus.g:708:1: elements : element ( ',' element )* ;
	public final WreslPlusParser.elements_return elements() throws RecognitionException {
		WreslPlusParser.elements_return retval = new WreslPlusParser.elements_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal306=null;
		ParserRuleReturnScope element305 =null;
		ParserRuleReturnScope element307 =null;

		CommonTree char_literal306_tree=null;

		try {
			// WreslPlus.g:708:14: ( element ( ',' element )* )
			// WreslPlus.g:708:17: element ( ',' element )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_element_in_elements3416);
			element305=element();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, element305.getTree());

			// WreslPlus.g:708:25: ( ',' element )*
			loop76:
			while (true) {
				int alt76=2;
				int LA76_0 = input.LA(1);
				if ( (LA76_0==107) ) {
					alt76=1;
				}

				switch (alt76) {
				case 1 :
					// WreslPlus.g:708:27: ',' element
					{
					char_literal306=(Token)match(input,107,FOLLOW_107_in_elements3420); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal306_tree = (CommonTree)adaptor.create(char_literal306);
					adaptor.addChild(root_0, char_literal306_tree);
					}

					pushFollow(FOLLOW_element_in_elements3422);
					element307=element();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, element307.getTree());

					}
					break;

				default :
					break loop76;
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
	// $ANTLR end "elements"


	public static class element_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "element"
	// WreslPlus.g:710:1: element : ID ( '.' ID )? ;
	public final WreslPlusParser.element_return element() throws RecognitionException {
		WreslPlusParser.element_return retval = new WreslPlusParser.element_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID308=null;
		Token char_literal309=null;
		Token ID310=null;

		CommonTree ID308_tree=null;
		CommonTree char_literal309_tree=null;
		CommonTree ID310_tree=null;

		try {
			// WreslPlus.g:710:14: ( ID ( '.' ID )? )
			// WreslPlus.g:710:17: ID ( '.' ID )?
			{
			root_0 = (CommonTree)adaptor.nil();


			ID308=(Token)match(input,ID,FOLLOW_ID_in_element3439); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID308_tree = (CommonTree)adaptor.create(ID308);
			adaptor.addChild(root_0, ID308_tree);
			}

			// WreslPlus.g:710:20: ( '.' ID )?
			int alt77=2;
			int LA77_0 = input.LA(1);
			if ( (LA77_0==109) ) {
				alt77=1;
			}
			switch (alt77) {
				case 1 :
					// WreslPlus.g:710:21: '.' ID
					{
					char_literal309=(Token)match(input,109,FOLLOW_109_in_element3442); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal309_tree = (CommonTree)adaptor.create(char_literal309);
					adaptor.addChild(root_0, char_literal309_tree);
					}

					ID310=(Token)match(input,ID,FOLLOW_ID_in_element3444); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID310_tree = (CommonTree)adaptor.create(ID310);
					adaptor.addChild(root_0, ID310_tree);
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
	// $ANTLR end "element"


	protected static class ex_g_scope {
		ExternalTemp ex_;
		String id_;
	}
	protected Stack<ex_g_scope> ex_g_stack = new Stack<ex_g_scope>();

	public static class ex_g_return extends ParserRuleReturnScope {
		public String id;
		public ExternalTemp exObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ex_g"
	// WreslPlus.g:727:1: ex_g returns [String id, ExternalTemp exObj] : ex_old ;
	public final WreslPlusParser.ex_g_return ex_g() throws RecognitionException {
		ex_g_stack.push(new ex_g_scope());
		WreslPlusParser.ex_g_return retval = new WreslPlusParser.ex_g_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope ex_old311 =null;


		 ex_g_stack.peek().ex_ = new ExternalTemp(); 
		       ex_g_stack.peek().ex_.fromWresl = this.currentAbsolutePath; 
			 
		try {
			// WreslPlus.g:738:3: ( ex_old )
			// WreslPlus.g:738:5: ex_old
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_ex_old_in_ex_g3489);
			ex_old311=ex_old();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, ex_old311.getTree());

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { retval.id = ex_g_stack.peek().ex_.id; 
			        retval.exObj = ex_g_stack.peek().ex_; 
			        retval.exObj.line=line;
				 }
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			ex_g_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "ex_g"


	public static class ex_id_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ex_id"
	// WreslPlus.g:740:1: ex_id : i= ID ;
	public final WreslPlusParser.ex_id_return ex_id() throws RecognitionException {
		WreslPlusParser.ex_id_return retval = new WreslPlusParser.ex_id_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;

		CommonTree i_tree=null;

		try {
			// WreslPlus.g:740:7: (i= ID )
			// WreslPlus.g:740:9: i= ID
			{
			root_0 = (CommonTree)adaptor.nil();


			i=(Token)match(input,ID,FOLLOW_ID_in_ex_id3501); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) {ex_g_stack.peek().ex_.id=(i!=null?i.getText():null);}
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
	// $ANTLR end "ex_id"


	public static class ex_old_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ex_old"
	// WreslPlus.g:742:1: ex_old : DEFINE ( local_deprecated )? ex_id '{' EXTERNAL f= ex_fileName '}' ;
	public final WreslPlusParser.ex_old_return ex_old() throws RecognitionException {
		WreslPlusParser.ex_old_return retval = new WreslPlusParser.ex_old_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DEFINE312=null;
		Token char_literal315=null;
		Token EXTERNAL316=null;
		Token char_literal317=null;
		ParserRuleReturnScope f =null;
		ParserRuleReturnScope local_deprecated313 =null;
		ParserRuleReturnScope ex_id314 =null;

		CommonTree DEFINE312_tree=null;
		CommonTree char_literal315_tree=null;
		CommonTree EXTERNAL316_tree=null;
		CommonTree char_literal317_tree=null;

		try {
			// WreslPlus.g:742:8: ( DEFINE ( local_deprecated )? ex_id '{' EXTERNAL f= ex_fileName '}' )
			// WreslPlus.g:742:10: DEFINE ( local_deprecated )? ex_id '{' EXTERNAL f= ex_fileName '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			DEFINE312=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_ex_old3512); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DEFINE312_tree = (CommonTree)adaptor.create(DEFINE312);
			adaptor.addChild(root_0, DEFINE312_tree);
			}

			if ( state.backtracking==0 ) {line=(DEFINE312!=null?DEFINE312.getLine():0);}
			// WreslPlus.g:742:37: ( local_deprecated )?
			int alt78=2;
			int LA78_0 = input.LA(1);
			if ( (LA78_0==119) ) {
				alt78=1;
			}
			switch (alt78) {
				case 1 :
					// WreslPlus.g:742:38: local_deprecated
					{
					pushFollow(FOLLOW_local_deprecated_in_ex_old3516);
					local_deprecated313=local_deprecated();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, local_deprecated313.getTree());

					}
					break;

			}

			pushFollow(FOLLOW_ex_id_in_ex_old3520);
			ex_id314=ex_id();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, ex_id314.getTree());

			char_literal315=(Token)match(input,125,FOLLOW_125_in_ex_old3522); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal315_tree = (CommonTree)adaptor.create(char_literal315);
			adaptor.addChild(root_0, char_literal315_tree);
			}

			EXTERNAL316=(Token)match(input,EXTERNAL,FOLLOW_EXTERNAL_in_ex_old3524); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			EXTERNAL316_tree = (CommonTree)adaptor.create(EXTERNAL316);
			adaptor.addChild(root_0, EXTERNAL316_tree);
			}

			pushFollow(FOLLOW_ex_fileName_in_ex_old3528);
			f=ex_fileName();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, f.getTree());

			if ( state.backtracking==0 ) {ex_g_stack.peek().ex_.fileName=(f!=null?input.toString(f.start,f.stop):null);}
			char_literal317=(Token)match(input,126,FOLLOW_126_in_ex_old3532); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal317_tree = (CommonTree)adaptor.create(char_literal317);
			adaptor.addChild(root_0, char_literal317_tree);
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
	// $ANTLR end "ex_old"


	public static class ex_fileName_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "ex_fileName"
	// WreslPlus.g:744:1: ex_fileName : ID ( '.' ID )? ;
	public final WreslPlusParser.ex_fileName_return ex_fileName() throws RecognitionException {
		WreslPlusParser.ex_fileName_return retval = new WreslPlusParser.ex_fileName_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID318=null;
		Token char_literal319=null;
		Token ID320=null;

		CommonTree ID318_tree=null;
		CommonTree char_literal319_tree=null;
		CommonTree ID320_tree=null;

		try {
			// WreslPlus.g:744:13: ( ID ( '.' ID )? )
			// WreslPlus.g:744:15: ID ( '.' ID )?
			{
			root_0 = (CommonTree)adaptor.nil();


			ID318=(Token)match(input,ID,FOLLOW_ID_in_ex_fileName3541); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID318_tree = (CommonTree)adaptor.create(ID318);
			adaptor.addChild(root_0, ID318_tree);
			}

			// WreslPlus.g:744:18: ( '.' ID )?
			int alt79=2;
			int LA79_0 = input.LA(1);
			if ( (LA79_0==109) ) {
				alt79=1;
			}
			switch (alt79) {
				case 1 :
					// WreslPlus.g:744:19: '.' ID
					{
					char_literal319=(Token)match(input,109,FOLLOW_109_in_ex_fileName3544); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal319_tree = (CommonTree)adaptor.create(char_literal319);
					adaptor.addChild(root_0, char_literal319_tree);
					}

					ID320=(Token)match(input,ID,FOLLOW_ID_in_ex_fileName3546); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID320_tree = (CommonTree)adaptor.create(ID320);
					adaptor.addChild(root_0, ID320_tree);
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
	// $ANTLR end "ex_fileName"


	protected static class dvar_g_scope {
		DvarTemp dvar_;
		String id_;
	}
	protected Stack<dvar_g_scope> dvar_g_stack = new Stack<dvar_g_scope>();

	public static class dvar_g_return extends ParserRuleReturnScope {
		public String id;
		public DvarTemp dvObj;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvar_g"
	// WreslPlus.g:757:1: dvar_g returns [String id, DvarTemp dvObj] : ( dvar_group_new | dvar_group_old ) ;
	public final WreslPlusParser.dvar_g_return dvar_g() throws RecognitionException {
		dvar_g_stack.push(new dvar_g_scope());
		WreslPlusParser.dvar_g_return retval = new WreslPlusParser.dvar_g_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope dvar_group_new321 =null;
		ParserRuleReturnScope dvar_group_old322 =null;


		 dvar_g_stack.peek().dvar_ = new DvarTemp(); 
		       dvar_g_stack.peek().dvar_.fromWresl = this.currentAbsolutePath; 
			 
		try {
			// WreslPlus.g:765:2: ( ( dvar_group_new | dvar_group_old ) )
			// WreslPlus.g:765:4: ( dvar_group_new | dvar_group_old )
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:765:4: ( dvar_group_new | dvar_group_old )
			int alt80=2;
			int LA80_0 = input.LA(1);
			if ( (LA80_0==DVAR) ) {
				alt80=1;
			}
			else if ( (LA80_0==DEFINE) ) {
				alt80=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 80, 0, input);
				throw nvae;
			}

			switch (alt80) {
				case 1 :
					// WreslPlus.g:765:6: dvar_group_new
					{
					pushFollow(FOLLOW_dvar_group_new_in_dvar_g3587);
					dvar_group_new321=dvar_group_new();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dvar_group_new321.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:765:23: dvar_group_old
					{
					pushFollow(FOLLOW_dvar_group_old_in_dvar_g3591);
					dvar_group_old322=dvar_group_old();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dvar_group_old322.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			if ( state.backtracking==0 ) {
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
			}
			if ( state.backtracking==0 ) { retval.id = dvar_g_stack.peek().id_; retval.dvObj = dvar_g_stack.peek().dvar_; retval.dvObj.line=line; }
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
			dvar_g_stack.pop();
		}
		return retval;
	}
	// $ANTLR end "dvar_g"


	public static class dvarID_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvarID"
	// WreslPlus.g:768:1: dvarID : i= ID ;
	public final WreslPlusParser.dvarID_return dvarID() throws RecognitionException {
		WreslPlusParser.dvarID_return retval = new WreslPlusParser.dvarID_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token i=null;

		CommonTree i_tree=null;

		try {
			// WreslPlus.g:768:8: (i= ID )
			// WreslPlus.g:768:10: i= ID
			{
			root_0 = (CommonTree)adaptor.nil();


			i=(Token)match(input,ID,FOLLOW_ID_in_dvarID3606); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			i_tree = (CommonTree)adaptor.create(i);
			adaptor.addChild(root_0, i_tree);
			}

			if ( state.backtracking==0 ) { dvar_g_stack.peek().dvar_.id=(i!=null?i.getText():null); dvar_g_stack.peek().id_ =(i!=null?i.getText():null); }
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
	// $ANTLR end "dvarID"


	public static class dvar_group_old_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvar_group_old"
	// WreslPlus.g:770:1: dvar_group_old : DEFINE ( local_deprecated )? dvar ;
	public final WreslPlusParser.dvar_group_old_return dvar_group_old() throws RecognitionException {
		WreslPlusParser.dvar_group_old_return retval = new WreslPlusParser.dvar_group_old_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DEFINE323=null;
		ParserRuleReturnScope local_deprecated324 =null;
		ParserRuleReturnScope dvar325 =null;

		CommonTree DEFINE323_tree=null;

		try {
			// WreslPlus.g:770:15: ( DEFINE ( local_deprecated )? dvar )
			// WreslPlus.g:770:17: DEFINE ( local_deprecated )? dvar
			{
			root_0 = (CommonTree)adaptor.nil();


			DEFINE323=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_dvar_group_old3615); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DEFINE323_tree = (CommonTree)adaptor.create(DEFINE323);
			adaptor.addChild(root_0, DEFINE323_tree);
			}

			if ( state.backtracking==0 ) {line=(DEFINE323!=null?DEFINE323.getLine():0);}
			// WreslPlus.g:770:44: ( local_deprecated )?
			int alt81=2;
			int LA81_0 = input.LA(1);
			if ( (LA81_0==119) ) {
				int LA81_1 = input.LA(2);
				if ( (LA81_1==LOCAL) ) {
					alt81=1;
				}
			}
			switch (alt81) {
				case 1 :
					// WreslPlus.g:770:45: local_deprecated
					{
					pushFollow(FOLLOW_local_deprecated_in_dvar_group_old3619);
					local_deprecated324=local_deprecated();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, local_deprecated324.getTree());

					}
					break;

			}

			pushFollow(FOLLOW_dvar_in_dvar_group_old3623);
			dvar325=dvar();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, dvar325.getTree());

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
	// $ANTLR end "dvar_group_old"


	public static class dvar_group_new_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvar_group_new"
	// WreslPlus.g:771:1: dvar_group_new : DVAR dvar ;
	public final WreslPlusParser.dvar_group_new_return dvar_group_new() throws RecognitionException {
		WreslPlusParser.dvar_group_new_return retval = new WreslPlusParser.dvar_group_new_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DVAR326=null;
		ParserRuleReturnScope dvar327 =null;

		CommonTree DVAR326_tree=null;

		try {
			// WreslPlus.g:771:15: ( DVAR dvar )
			// WreslPlus.g:771:17: DVAR dvar
			{
			root_0 = (CommonTree)adaptor.nil();


			DVAR326=(Token)match(input,DVAR,FOLLOW_DVAR_in_dvar_group_new3630); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			DVAR326_tree = (CommonTree)adaptor.create(DVAR326);
			adaptor.addChild(root_0, DVAR326_tree);
			}

			if ( state.backtracking==0 ) {line=(DVAR326!=null?DVAR326.getLine():0);}
			pushFollow(FOLLOW_dvar_in_dvar_group_new3636);
			dvar327=dvar();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, dvar327.getTree());

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
	// $ANTLR end "dvar_group_new"


	public static class dvar_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvar"
	// WreslPlus.g:773:1: dvar : ( dvarArray | dvarTimeArray )? dvarID '{' dvar_trunk '}' ;
	public final WreslPlusParser.dvar_return dvar() throws RecognitionException {
		WreslPlusParser.dvar_return retval = new WreslPlusParser.dvar_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal331=null;
		Token char_literal333=null;
		ParserRuleReturnScope dvarArray328 =null;
		ParserRuleReturnScope dvarTimeArray329 =null;
		ParserRuleReturnScope dvarID330 =null;
		ParserRuleReturnScope dvar_trunk332 =null;

		CommonTree char_literal331_tree=null;
		CommonTree char_literal333_tree=null;

		try {
			// WreslPlus.g:773:5: ( ( dvarArray | dvarTimeArray )? dvarID '{' dvar_trunk '}' )
			// WreslPlus.g:773:7: ( dvarArray | dvarTimeArray )? dvarID '{' dvar_trunk '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:773:7: ( dvarArray | dvarTimeArray )?
			int alt82=3;
			int LA82_0 = input.LA(1);
			if ( (LA82_0==119) ) {
				alt82=1;
			}
			else if ( (LA82_0==103) ) {
				alt82=2;
			}
			switch (alt82) {
				case 1 :
					// WreslPlus.g:773:8: dvarArray
					{
					pushFollow(FOLLOW_dvarArray_in_dvar3645);
					dvarArray328=dvarArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dvarArray328.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:773:18: dvarTimeArray
					{
					pushFollow(FOLLOW_dvarTimeArray_in_dvar3647);
					dvarTimeArray329=dvarTimeArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dvarTimeArray329.getTree());

					}
					break;

			}

			pushFollow(FOLLOW_dvarID_in_dvar3651);
			dvarID330=dvarID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, dvarID330.getTree());

			char_literal331=(Token)match(input,125,FOLLOW_125_in_dvar3653); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal331_tree = (CommonTree)adaptor.create(char_literal331);
			adaptor.addChild(root_0, char_literal331_tree);
			}

			pushFollow(FOLLOW_dvar_trunk_in_dvar3655);
			dvar_trunk332=dvar_trunk();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, dvar_trunk332.getTree());

			char_literal333=(Token)match(input,126,FOLLOW_126_in_dvar3657); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal333_tree = (CommonTree)adaptor.create(char_literal333);
			adaptor.addChild(root_0, char_literal333_tree);
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


	public static class dvarArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvarArray"
	// WreslPlus.g:775:1: dvarArray : '[' d= ( INT | ID ) ']' ;
	public final WreslPlusParser.dvarArray_return dvarArray() throws RecognitionException {
		WreslPlusParser.dvarArray_return retval = new WreslPlusParser.dvarArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token d=null;
		Token char_literal334=null;
		Token char_literal335=null;

		CommonTree d_tree=null;
		CommonTree char_literal334_tree=null;
		CommonTree char_literal335_tree=null;

		try {
			// WreslPlus.g:775:11: ( '[' d= ( INT | ID ) ']' )
			// WreslPlus.g:775:17: '[' d= ( INT | ID ) ']'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal334=(Token)match(input,119,FOLLOW_119_in_dvarArray3671); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal334_tree = (CommonTree)adaptor.create(char_literal334);
			adaptor.addChild(root_0, char_literal334_tree);
			}

			d=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(d));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal335=(Token)match(input,120,FOLLOW_120_in_dvarArray3685); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal335_tree = (CommonTree)adaptor.create(char_literal335);
			adaptor.addChild(root_0, char_literal335_tree);
			}

			if ( state.backtracking==0 ) {dvar_g_stack.peek().dvar_.arraySize=(d!=null?d.getText():null); }
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
	// $ANTLR end "dvarArray"


	public static class dvarTimeArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvarTimeArray"
	// WreslPlus.g:776:1: dvarTimeArray : '(' d= ( INT | ID ) ')' ;
	public final WreslPlusParser.dvarTimeArray_return dvarTimeArray() throws RecognitionException {
		WreslPlusParser.dvarTimeArray_return retval = new WreslPlusParser.dvarTimeArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token d=null;
		Token char_literal336=null;
		Token char_literal337=null;

		CommonTree d_tree=null;
		CommonTree char_literal336_tree=null;
		CommonTree char_literal337_tree=null;

		try {
			// WreslPlus.g:776:15: ( '(' d= ( INT | ID ) ')' )
			// WreslPlus.g:776:17: '(' d= ( INT | ID ) ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal336=(Token)match(input,103,FOLLOW_103_in_dvarTimeArray3695); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal336_tree = (CommonTree)adaptor.create(char_literal336);
			adaptor.addChild(root_0, char_literal336_tree);
			}

			d=input.LT(1);
			if ( input.LA(1)==ID||input.LA(1)==INT ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(d));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal337=(Token)match(input,104,FOLLOW_104_in_dvarTimeArray3709); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal337_tree = (CommonTree)adaptor.create(char_literal337);
			adaptor.addChild(root_0, char_literal337_tree);
			}

			if ( state.backtracking==0 ) {dvar_g_stack.peek().dvar_.timeArraySize=(d!=null?d.getText():null); }
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
	// $ANTLR end "dvarTimeArray"


	public static class dvar_trunk_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvar_trunk"
	// WreslPlus.g:782:1: dvar_trunk : ( ( ( ( ( dvarIsInteger )? ( std | ( lower_upper ) ) ) | dvarIsBinary ) dvKindUnits ) | ( '<' ID '>' ) );
	public final WreslPlusParser.dvar_trunk_return dvar_trunk() throws RecognitionException {
		WreslPlusParser.dvar_trunk_return retval = new WreslPlusParser.dvar_trunk_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal343=null;
		Token ID344=null;
		Token char_literal345=null;
		ParserRuleReturnScope dvarIsInteger338 =null;
		ParserRuleReturnScope std339 =null;
		ParserRuleReturnScope lower_upper340 =null;
		ParserRuleReturnScope dvarIsBinary341 =null;
		ParserRuleReturnScope dvKindUnits342 =null;

		CommonTree char_literal343_tree=null;
		CommonTree ID344_tree=null;
		CommonTree char_literal345_tree=null;

		try {
			// WreslPlus.g:783:2: ( ( ( ( ( dvarIsInteger )? ( std | ( lower_upper ) ) ) | dvarIsBinary ) dvKindUnits ) | ( '<' ID '>' ) )
			int alt86=2;
			int LA86_0 = input.LA(1);
			if ( (LA86_0==BINARY||LA86_0==INTEGER||LA86_0==LOWER||LA86_0==STD||LA86_0==UPPER) ) {
				alt86=1;
			}
			else if ( (LA86_0==113) ) {
				alt86=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 86, 0, input);
				throw nvae;
			}

			switch (alt86) {
				case 1 :
					// WreslPlus.g:785:2: ( ( ( ( dvarIsInteger )? ( std | ( lower_upper ) ) ) | dvarIsBinary ) dvKindUnits )
					{
					root_0 = (CommonTree)adaptor.nil();


					// WreslPlus.g:785:2: ( ( ( ( dvarIsInteger )? ( std | ( lower_upper ) ) ) | dvarIsBinary ) dvKindUnits )
					// WreslPlus.g:785:4: ( ( ( dvarIsInteger )? ( std | ( lower_upper ) ) ) | dvarIsBinary ) dvKindUnits
					{
					// WreslPlus.g:785:4: ( ( ( dvarIsInteger )? ( std | ( lower_upper ) ) ) | dvarIsBinary )
					int alt85=2;
					int LA85_0 = input.LA(1);
					if ( (LA85_0==INTEGER||LA85_0==LOWER||LA85_0==STD||LA85_0==UPPER) ) {
						alt85=1;
					}
					else if ( (LA85_0==BINARY) ) {
						alt85=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						NoViableAltException nvae =
							new NoViableAltException("", 85, 0, input);
						throw nvae;
					}

					switch (alt85) {
						case 1 :
							// WreslPlus.g:785:6: ( ( dvarIsInteger )? ( std | ( lower_upper ) ) )
							{
							// WreslPlus.g:785:6: ( ( dvarIsInteger )? ( std | ( lower_upper ) ) )
							// WreslPlus.g:785:8: ( dvarIsInteger )? ( std | ( lower_upper ) )
							{
							// WreslPlus.g:785:8: ( dvarIsInteger )?
							int alt83=2;
							int LA83_0 = input.LA(1);
							if ( (LA83_0==INTEGER) ) {
								alt83=1;
							}
							switch (alt83) {
								case 1 :
									// WreslPlus.g:785:8: dvarIsInteger
									{
									pushFollow(FOLLOW_dvarIsInteger_in_dvar_trunk3737);
									dvarIsInteger338=dvarIsInteger();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) adaptor.addChild(root_0, dvarIsInteger338.getTree());

									}
									break;

							}

							// WreslPlus.g:785:23: ( std | ( lower_upper ) )
							int alt84=2;
							int LA84_0 = input.LA(1);
							if ( (LA84_0==STD) ) {
								alt84=1;
							}
							else if ( (LA84_0==LOWER||LA84_0==UPPER) ) {
								alt84=2;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								NoViableAltException nvae =
									new NoViableAltException("", 84, 0, input);
								throw nvae;
							}

							switch (alt84) {
								case 1 :
									// WreslPlus.g:785:25: std
									{
									pushFollow(FOLLOW_std_in_dvar_trunk3742);
									std339=std();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) adaptor.addChild(root_0, std339.getTree());

									}
									break;
								case 2 :
									// WreslPlus.g:785:31: ( lower_upper )
									{
									// WreslPlus.g:785:31: ( lower_upper )
									// WreslPlus.g:785:33: lower_upper
									{
									if ( state.backtracking==0 ) {addDep = false;}
									pushFollow(FOLLOW_lower_upper_in_dvar_trunk3750);
									lower_upper340=lower_upper();
									state._fsp--;
									if (state.failed) return retval;
									if ( state.backtracking==0 ) adaptor.addChild(root_0, lower_upper340.getTree());

									if ( state.backtracking==0 ) {addDep = true;}
									}

									}
									break;

							}

							}

							}
							break;
						case 2 :
							// WreslPlus.g:786:6: dvarIsBinary
							{
							pushFollow(FOLLOW_dvarIsBinary_in_dvar_trunk3766);
							dvarIsBinary341=dvarIsBinary();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, dvarIsBinary341.getTree());

							}
							break;

					}

					pushFollow(FOLLOW_dvKindUnits_in_dvar_trunk3772);
					dvKindUnits342=dvKindUnits();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dvKindUnits342.getTree());

					}

					}
					break;
				case 2 :
					// WreslPlus.g:788:4: ( '<' ID '>' )
					{
					root_0 = (CommonTree)adaptor.nil();


					// WreslPlus.g:788:4: ( '<' ID '>' )
					// WreslPlus.g:788:5: '<' ID '>'
					{
					char_literal343=(Token)match(input,113,FOLLOW_113_in_dvar_trunk3780); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal343_tree = (CommonTree)adaptor.create(char_literal343);
					adaptor.addChild(root_0, char_literal343_tree);
					}

					ID344=(Token)match(input,ID,FOLLOW_ID_in_dvar_trunk3782); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID344_tree = (CommonTree)adaptor.create(ID344);
					adaptor.addChild(root_0, ID344_tree);
					}

					char_literal345=(Token)match(input,117,FOLLOW_117_in_dvar_trunk3784); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal345_tree = (CommonTree)adaptor.create(char_literal345);
					adaptor.addChild(root_0, char_literal345_tree);
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
	// $ANTLR end "dvar_trunk"


	public static class dvarIsInteger_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvarIsInteger"
	// WreslPlus.g:793:1: dvarIsInteger : INTEGER ;
	public final WreslPlusParser.dvarIsInteger_return dvarIsInteger() throws RecognitionException {
		WreslPlusParser.dvarIsInteger_return retval = new WreslPlusParser.dvarIsInteger_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INTEGER346=null;

		CommonTree INTEGER346_tree=null;

		try {
			// WreslPlus.g:793:15: ( INTEGER )
			// WreslPlus.g:793:17: INTEGER
			{
			root_0 = (CommonTree)adaptor.nil();


			INTEGER346=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_dvarIsInteger3797); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INTEGER346_tree = (CommonTree)adaptor.create(INTEGER346);
			adaptor.addChild(root_0, INTEGER346_tree);
			}

			if ( state.backtracking==0 ) {dvar_g_stack.peek().dvar_.isInteger=true; dvar_g_stack.peek().dvar_.upperBound="1";dvar_g_stack.peek().dvar_.lowerBound="0";}
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
	// $ANTLR end "dvarIsInteger"


	public static class dvarIsBinary_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvarIsBinary"
	// WreslPlus.g:794:1: dvarIsBinary : BINARY ;
	public final WreslPlusParser.dvarIsBinary_return dvarIsBinary() throws RecognitionException {
		WreslPlusParser.dvarIsBinary_return retval = new WreslPlusParser.dvarIsBinary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token BINARY347=null;

		CommonTree BINARY347_tree=null;

		try {
			// WreslPlus.g:794:15: ( BINARY )
			// WreslPlus.g:794:17: BINARY
			{
			root_0 = (CommonTree)adaptor.nil();


			BINARY347=(Token)match(input,BINARY,FOLLOW_BINARY_in_dvarIsBinary3808); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			BINARY347_tree = (CommonTree)adaptor.create(BINARY347);
			adaptor.addChild(root_0, BINARY347_tree);
			}

			if ( state.backtracking==0 ) {dvar_g_stack.peek().dvar_.isInteger=true; dvar_g_stack.peek().dvar_.upperBound="1";dvar_g_stack.peek().dvar_.lowerBound="0";}
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
	// $ANTLR end "dvarIsBinary"


	public static class index_assign_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "index_assign"
	// WreslPlus.g:795:1: index_assign : '[' INT ( ':' INT )? ']' ;
	public final WreslPlusParser.index_assign_return index_assign() throws RecognitionException {
		WreslPlusParser.index_assign_return retval = new WreslPlusParser.index_assign_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal348=null;
		Token INT349=null;
		Token char_literal350=null;
		Token INT351=null;
		Token char_literal352=null;

		CommonTree char_literal348_tree=null;
		CommonTree INT349_tree=null;
		CommonTree char_literal350_tree=null;
		CommonTree INT351_tree=null;
		CommonTree char_literal352_tree=null;

		try {
			// WreslPlus.g:795:14: ( '[' INT ( ':' INT )? ']' )
			// WreslPlus.g:795:16: '[' INT ( ':' INT )? ']'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal348=(Token)match(input,119,FOLLOW_119_in_index_assign3819); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal348_tree = (CommonTree)adaptor.create(char_literal348);
			adaptor.addChild(root_0, char_literal348_tree);
			}

			INT349=(Token)match(input,INT,FOLLOW_INT_in_index_assign3821); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INT349_tree = (CommonTree)adaptor.create(INT349);
			adaptor.addChild(root_0, INT349_tree);
			}

			// WreslPlus.g:795:24: ( ':' INT )?
			int alt87=2;
			int LA87_0 = input.LA(1);
			if ( (LA87_0==112) ) {
				alt87=1;
			}
			switch (alt87) {
				case 1 :
					// WreslPlus.g:795:25: ':' INT
					{
					char_literal350=(Token)match(input,112,FOLLOW_112_in_index_assign3824); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal350_tree = (CommonTree)adaptor.create(char_literal350);
					adaptor.addChild(root_0, char_literal350_tree);
					}

					INT351=(Token)match(input,INT,FOLLOW_INT_in_index_assign3826); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT351_tree = (CommonTree)adaptor.create(INT351);
					adaptor.addChild(root_0, INT351_tree);
					}

					}
					break;

			}

			char_literal352=(Token)match(input,120,FOLLOW_120_in_index_assign3830); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal352_tree = (CommonTree)adaptor.create(char_literal352);
			adaptor.addChild(root_0, char_literal352_tree);
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
	// $ANTLR end "index_assign"


	public static class timeIndex_assign_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "timeIndex_assign"
	// WreslPlus.g:796:1: timeIndex_assign : '(' INT ( ':' INT )? ')' ;
	public final WreslPlusParser.timeIndex_assign_return timeIndex_assign() throws RecognitionException {
		WreslPlusParser.timeIndex_assign_return retval = new WreslPlusParser.timeIndex_assign_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal353=null;
		Token INT354=null;
		Token char_literal355=null;
		Token INT356=null;
		Token char_literal357=null;

		CommonTree char_literal353_tree=null;
		CommonTree INT354_tree=null;
		CommonTree char_literal355_tree=null;
		CommonTree INT356_tree=null;
		CommonTree char_literal357_tree=null;

		try {
			// WreslPlus.g:796:18: ( '(' INT ( ':' INT )? ')' )
			// WreslPlus.g:796:20: '(' INT ( ':' INT )? ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal353=(Token)match(input,103,FOLLOW_103_in_timeIndex_assign3838); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal353_tree = (CommonTree)adaptor.create(char_literal353);
			adaptor.addChild(root_0, char_literal353_tree);
			}

			INT354=(Token)match(input,INT,FOLLOW_INT_in_timeIndex_assign3840); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INT354_tree = (CommonTree)adaptor.create(INT354);
			adaptor.addChild(root_0, INT354_tree);
			}

			// WreslPlus.g:796:28: ( ':' INT )?
			int alt88=2;
			int LA88_0 = input.LA(1);
			if ( (LA88_0==112) ) {
				alt88=1;
			}
			switch (alt88) {
				case 1 :
					// WreslPlus.g:796:29: ':' INT
					{
					char_literal355=(Token)match(input,112,FOLLOW_112_in_timeIndex_assign3843); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal355_tree = (CommonTree)adaptor.create(char_literal355);
					adaptor.addChild(root_0, char_literal355_tree);
					}

					INT356=(Token)match(input,INT,FOLLOW_INT_in_timeIndex_assign3845); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT356_tree = (CommonTree)adaptor.create(INT356);
					adaptor.addChild(root_0, INT356_tree);
					}

					}
					break;

			}

			char_literal357=(Token)match(input,104,FOLLOW_104_in_timeIndex_assign3849); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal357_tree = (CommonTree)adaptor.create(char_literal357);
			adaptor.addChild(root_0, char_literal357_tree);
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
	// $ANTLR end "timeIndex_assign"


	public static class lower_upper_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lower_upper"
	// WreslPlus.g:798:1: lower_upper : ( lower ( upper )? | upper ( lower )? );
	public final WreslPlusParser.lower_upper_return lower_upper() throws RecognitionException {
		WreslPlusParser.lower_upper_return retval = new WreslPlusParser.lower_upper_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope lower358 =null;
		ParserRuleReturnScope upper359 =null;
		ParserRuleReturnScope upper360 =null;
		ParserRuleReturnScope lower361 =null;


		try {
			// WreslPlus.g:798:13: ( lower ( upper )? | upper ( lower )? )
			int alt91=2;
			int LA91_0 = input.LA(1);
			if ( (LA91_0==LOWER) ) {
				alt91=1;
			}
			else if ( (LA91_0==UPPER) ) {
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
					// WreslPlus.g:798:15: lower ( upper )?
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_lower_in_lower_upper3858);
					lower358=lower();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, lower358.getTree());

					// WreslPlus.g:798:21: ( upper )?
					int alt89=2;
					int LA89_0 = input.LA(1);
					if ( (LA89_0==UPPER) ) {
						alt89=1;
					}
					switch (alt89) {
						case 1 :
							// WreslPlus.g:798:21: upper
							{
							pushFollow(FOLLOW_upper_in_lower_upper3860);
							upper359=upper();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, upper359.getTree());

							}
							break;

					}

					}
					break;
				case 2 :
					// WreslPlus.g:798:30: upper ( lower )?
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_upper_in_lower_upper3865);
					upper360=upper();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, upper360.getTree());

					// WreslPlus.g:798:36: ( lower )?
					int alt90=2;
					int LA90_0 = input.LA(1);
					if ( (LA90_0==LOWER) ) {
						alt90=1;
					}
					switch (alt90) {
						case 1 :
							// WreslPlus.g:798:36: lower
							{
							pushFollow(FOLLOW_lower_in_lower_upper3867);
							lower361=lower();
							state._fsp--;
							if (state.failed) return retval;
							if ( state.backtracking==0 ) adaptor.addChild(root_0, lower361.getTree());

							}
							break;

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
	// $ANTLR end "lower_upper"


	public static class upper_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "upper"
	// WreslPlus.g:799:1: upper : UPPER (e= expr_limited | UNBOUNDED ) ;
	public final WreslPlusParser.upper_return upper() throws RecognitionException {
		WreslPlusParser.upper_return retval = new WreslPlusParser.upper_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token UPPER362=null;
		Token UNBOUNDED363=null;
		ParserRuleReturnScope e =null;

		CommonTree UPPER362_tree=null;
		CommonTree UNBOUNDED363_tree=null;

		try {
			// WreslPlus.g:799:6: ( UPPER (e= expr_limited | UNBOUNDED ) )
			// WreslPlus.g:799:8: UPPER (e= expr_limited | UNBOUNDED )
			{
			root_0 = (CommonTree)adaptor.nil();


			UPPER362=(Token)match(input,UPPER,FOLLOW_UPPER_in_upper3875); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			UPPER362_tree = (CommonTree)adaptor.create(UPPER362);
			adaptor.addChild(root_0, UPPER362_tree);
			}

			// WreslPlus.g:799:14: (e= expr_limited | UNBOUNDED )
			int alt92=2;
			int LA92_0 = input.LA(1);
			if ( ((LA92_0 >= ACOS && LA92_0 <= ACOT)||(LA92_0 >= ASIN && LA92_0 <= ATAN)||LA92_0==CFS_TAF||(LA92_0 >= COS && LA92_0 <= COT)||LA92_0==DAY||(LA92_0 >= EXCEEDANCE && LA92_0 <= EXCEEDANCE_TSI)||LA92_0==ID||LA92_0==INT||LA92_0==INT_word||LA92_0==LOG||(LA92_0 >= MAX && LA92_0 <= MIN)||LA92_0==MOD||LA92_0==MONTH||LA92_0==REAL||LA92_0==ROUND||LA92_0==SIN||(LA92_0 >= TAF_CFS && LA92_0 <= TAN)||LA92_0==WATERYEAR||(LA92_0 >= 99 && LA92_0 <= 100)||LA92_0==103||LA92_0==106||LA92_0==108||(LA92_0 >= 122 && LA92_0 <= 124)) ) {
				alt92=1;
			}
			else if ( (LA92_0==UNBOUNDED) ) {
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
					// WreslPlus.g:799:16: e= expr_limited
					{
					pushFollow(FOLLOW_expr_limited_in_upper3881);
					e=expr_limited();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

					if ( state.backtracking==0 ) {dvar_g_stack.peek().dvar_.upperBound=(e!=null?input.toString(e.start,e.stop):null);}
					}
					break;
				case 2 :
					// WreslPlus.g:799:70: UNBOUNDED
					{
					UNBOUNDED363=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_upper3887); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UNBOUNDED363_tree = (CommonTree)adaptor.create(UNBOUNDED363);
					adaptor.addChild(root_0, UNBOUNDED363_tree);
					}

					if ( state.backtracking==0 ) {dvar_g_stack.peek().dvar_.upperBound=Param.upper_unbounded;}
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


	public static class lower_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lower"
	// WreslPlus.g:800:1: lower : LOWER (e= expr_limited | UNBOUNDED ) ;
	public final WreslPlusParser.lower_return lower() throws RecognitionException {
		WreslPlusParser.lower_return retval = new WreslPlusParser.lower_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LOWER364=null;
		Token UNBOUNDED365=null;
		ParserRuleReturnScope e =null;

		CommonTree LOWER364_tree=null;
		CommonTree UNBOUNDED365_tree=null;

		try {
			// WreslPlus.g:800:6: ( LOWER (e= expr_limited | UNBOUNDED ) )
			// WreslPlus.g:800:8: LOWER (e= expr_limited | UNBOUNDED )
			{
			root_0 = (CommonTree)adaptor.nil();


			LOWER364=(Token)match(input,LOWER,FOLLOW_LOWER_in_lower3897); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			LOWER364_tree = (CommonTree)adaptor.create(LOWER364);
			adaptor.addChild(root_0, LOWER364_tree);
			}

			// WreslPlus.g:800:14: (e= expr_limited | UNBOUNDED )
			int alt93=2;
			int LA93_0 = input.LA(1);
			if ( ((LA93_0 >= ACOS && LA93_0 <= ACOT)||(LA93_0 >= ASIN && LA93_0 <= ATAN)||LA93_0==CFS_TAF||(LA93_0 >= COS && LA93_0 <= COT)||LA93_0==DAY||(LA93_0 >= EXCEEDANCE && LA93_0 <= EXCEEDANCE_TSI)||LA93_0==ID||LA93_0==INT||LA93_0==INT_word||LA93_0==LOG||(LA93_0 >= MAX && LA93_0 <= MIN)||LA93_0==MOD||LA93_0==MONTH||LA93_0==REAL||LA93_0==ROUND||LA93_0==SIN||(LA93_0 >= TAF_CFS && LA93_0 <= TAN)||LA93_0==WATERYEAR||(LA93_0 >= 99 && LA93_0 <= 100)||LA93_0==103||LA93_0==106||LA93_0==108||(LA93_0 >= 122 && LA93_0 <= 124)) ) {
				alt93=1;
			}
			else if ( (LA93_0==UNBOUNDED) ) {
				alt93=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 93, 0, input);
				throw nvae;
			}

			switch (alt93) {
				case 1 :
					// WreslPlus.g:800:16: e= expr_limited
					{
					pushFollow(FOLLOW_expr_limited_in_lower3903);
					e=expr_limited();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

					if ( state.backtracking==0 ) {dvar_g_stack.peek().dvar_.lowerBound=(e!=null?input.toString(e.start,e.stop):null);}
					}
					break;
				case 2 :
					// WreslPlus.g:800:70: UNBOUNDED
					{
					UNBOUNDED365=(Token)match(input,UNBOUNDED,FOLLOW_UNBOUNDED_in_lower3909); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					UNBOUNDED365_tree = (CommonTree)adaptor.create(UNBOUNDED365);
					adaptor.addChild(root_0, UNBOUNDED365_tree);
					}

					if ( state.backtracking==0 ) {dvar_g_stack.peek().dvar_.lowerBound=Param.lower_unbounded;}
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


	public static class expr_limited_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_limited"
	// WreslPlus.g:802:1: expr_limited : expr_add ;
	public final WreslPlusParser.expr_limited_return expr_limited() throws RecognitionException {
		WreslPlusParser.expr_limited_return retval = new WreslPlusParser.expr_limited_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr_add366 =null;


		try {
			// WreslPlus.g:802:13: ( expr_add )
			// WreslPlus.g:802:15: expr_add
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_add_in_expr_limited3920);
			expr_add366=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add366.getTree());

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
	// $ANTLR end "expr_limited"


	public static class std_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "std"
	// WreslPlus.g:804:1: std : STD ;
	public final WreslPlusParser.std_return std() throws RecognitionException {
		WreslPlusParser.std_return retval = new WreslPlusParser.std_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token STD367=null;

		CommonTree STD367_tree=null;

		try {
			// WreslPlus.g:804:4: ( STD )
			// WreslPlus.g:804:6: STD
			{
			root_0 = (CommonTree)adaptor.nil();


			STD367=(Token)match(input,STD,FOLLOW_STD_in_std3929); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			STD367_tree = (CommonTree)adaptor.create(STD367);
			adaptor.addChild(root_0, STD367_tree);
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
	// $ANTLR end "std"


	public static class dvKindUnits_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvKindUnits"
	// WreslPlus.g:806:1: dvKindUnits : ( dvKind dvUnits | dvUnits dvKind );
	public final WreslPlusParser.dvKindUnits_return dvKindUnits() throws RecognitionException {
		WreslPlusParser.dvKindUnits_return retval = new WreslPlusParser.dvKindUnits_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope dvKind368 =null;
		ParserRuleReturnScope dvUnits369 =null;
		ParserRuleReturnScope dvUnits370 =null;
		ParserRuleReturnScope dvKind371 =null;


		try {
			// WreslPlus.g:806:13: ( dvKind dvUnits | dvUnits dvKind )
			int alt94=2;
			int LA94_0 = input.LA(1);
			if ( (LA94_0==KIND) ) {
				alt94=1;
			}
			else if ( (LA94_0==UNITS) ) {
				alt94=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 94, 0, input);
				throw nvae;
			}

			switch (alt94) {
				case 1 :
					// WreslPlus.g:806:15: dvKind dvUnits
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_dvKind_in_dvKindUnits3938);
					dvKind368=dvKind();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dvKind368.getTree());

					pushFollow(FOLLOW_dvUnits_in_dvKindUnits3940);
					dvUnits369=dvUnits();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dvUnits369.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:806:32: dvUnits dvKind
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_dvUnits_in_dvKindUnits3944);
					dvUnits370=dvUnits();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dvUnits370.getTree());

					pushFollow(FOLLOW_dvKind_in_dvKindUnits3946);
					dvKind371=dvKind();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, dvKind371.getTree());

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
	// $ANTLR end "dvKindUnits"


	public static class dvKind_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvKind"
	// WreslPlus.g:807:1: dvKind : KIND s= QUOTE ;
	public final WreslPlusParser.dvKind_return dvKind() throws RecognitionException {
		WreslPlusParser.dvKind_return retval = new WreslPlusParser.dvKind_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		Token KIND372=null;

		CommonTree s_tree=null;
		CommonTree KIND372_tree=null;

		try {
			// WreslPlus.g:807:7: ( KIND s= QUOTE )
			// WreslPlus.g:807:10: KIND s= QUOTE
			{
			root_0 = (CommonTree)adaptor.nil();


			KIND372=(Token)match(input,KIND,FOLLOW_KIND_in_dvKind3954); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			KIND372_tree = (CommonTree)adaptor.create(KIND372);
			adaptor.addChild(root_0, KIND372_tree);
			}

			s=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_dvKind3958); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			s_tree = (CommonTree)adaptor.create(s);
			adaptor.addChild(root_0, s_tree);
			}

			if ( state.backtracking==0 ) {dvar_g_stack.peek().dvar_.kind=Tools.strip((s!=null?s.getText():null));}
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
	// $ANTLR end "dvKind"


	public static class dvUnits_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dvUnits"
	// WreslPlus.g:808:1: dvUnits : UNITS s= QUOTE ;
	public final WreslPlusParser.dvUnits_return dvUnits() throws RecognitionException {
		WreslPlusParser.dvUnits_return retval = new WreslPlusParser.dvUnits_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token s=null;
		Token UNITS373=null;

		CommonTree s_tree=null;
		CommonTree UNITS373_tree=null;

		try {
			// WreslPlus.g:808:8: ( UNITS s= QUOTE )
			// WreslPlus.g:808:10: UNITS s= QUOTE
			{
			root_0 = (CommonTree)adaptor.nil();


			UNITS373=(Token)match(input,UNITS,FOLLOW_UNITS_in_dvUnits3967); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			UNITS373_tree = (CommonTree)adaptor.create(UNITS373);
			adaptor.addChild(root_0, UNITS373_tree);
			}

			s=(Token)match(input,QUOTE,FOLLOW_QUOTE_in_dvUnits3971); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			s_tree = (CommonTree)adaptor.create(s);
			adaptor.addChild(root_0, s_tree);
			}

			if ( state.backtracking==0 ) {dvar_g_stack.peek().dvar_.units=Tools.strip((s!=null?s.getText():null));}
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
	// $ANTLR end "dvUnits"


	public static class logical_main_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "logical_main"
	// WreslPlus.g:818:1: logical_main : ( logical_or | ALWAYS );
	public final WreslPlusParser.logical_main_return logical_main() throws RecognitionException {
		WreslPlusParser.logical_main_return retval = new WreslPlusParser.logical_main_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ALWAYS375=null;
		ParserRuleReturnScope logical_or374 =null;

		CommonTree ALWAYS375_tree=null;

		try {
			// WreslPlus.g:818:13: ( logical_or | ALWAYS )
			int alt95=2;
			int LA95_0 = input.LA(1);
			if ( ((LA95_0 >= ACOS && LA95_0 <= ACOT)||(LA95_0 >= ASIN && LA95_0 <= ATAN)||LA95_0==CFS_TAF||(LA95_0 >= COS && LA95_0 <= COT)||LA95_0==DAY||(LA95_0 >= EXCEEDANCE && LA95_0 <= EXCEEDANCE_TSI)||LA95_0==ID||LA95_0==INT||LA95_0==INT_word||LA95_0==LOG||(LA95_0 >= MAX && LA95_0 <= MIN)||LA95_0==MOD||LA95_0==MONTH||LA95_0==NOT||(LA95_0 >= RANGE && LA95_0 <= REAL)||LA95_0==ROUND||LA95_0==SIN||(LA95_0 >= TAF_CFS && LA95_0 <= TAN)||LA95_0==WATERYEAR||(LA95_0 >= 99 && LA95_0 <= 100)||LA95_0==103||LA95_0==106||LA95_0==108||(LA95_0 >= 122 && LA95_0 <= 124)) ) {
				alt95=1;
			}
			else if ( (LA95_0==ALWAYS) ) {
				alt95=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 95, 0, input);
				throw nvae;
			}

			switch (alt95) {
				case 1 :
					// WreslPlus.g:818:15: logical_or
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_logical_or_in_logical_main3988);
					logical_or374=logical_or();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, logical_or374.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:818:28: ALWAYS
					{
					root_0 = (CommonTree)adaptor.nil();


					ALWAYS375=(Token)match(input,ALWAYS,FOLLOW_ALWAYS_in_logical_main3992); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ALWAYS375_tree = (CommonTree)adaptor.create(ALWAYS375);
					adaptor.addChild(root_0, ALWAYS375_tree);
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
	// $ANTLR end "logical_main"


	public static class logical_or_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "logical_or"
	// WreslPlus.g:820:1: logical_or : logical_and (o= OR logical_and )* ;
	public final WreslPlusParser.logical_or_return logical_or() throws RecognitionException {
		WreslPlusParser.logical_or_return retval = new WreslPlusParser.logical_or_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token o=null;
		ParserRuleReturnScope logical_and376 =null;
		ParserRuleReturnScope logical_and377 =null;

		CommonTree o_tree=null;

		try {
			// WreslPlus.g:821:5: ( logical_and (o= OR logical_and )* )
			// WreslPlus.g:821:9: logical_and (o= OR logical_and )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_logical_and_in_logical_or4007);
			logical_and376=logical_and();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, logical_and376.getTree());

			// WreslPlus.g:822:9: (o= OR logical_and )*
			loop96:
			while (true) {
				int alt96=2;
				int LA96_0 = input.LA(1);
				if ( (LA96_0==OR) ) {
					alt96=1;
				}

				switch (alt96) {
				case 1 :
					// WreslPlus.g:822:13: o= OR logical_and
					{
					o=(Token)match(input,OR,FOLLOW_OR_in_logical_or4030); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					o_tree = (CommonTree)adaptor.create(o);
					adaptor.addChild(root_0, o_tree);
					}

					if ( state.backtracking==0 ) {o.setText(" .or. ");}
					pushFollow(FOLLOW_logical_and_in_logical_or4035);
					logical_and377=logical_and();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, logical_and377.getTree());

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
	// $ANTLR end "logical_or"


	public static class logical_and_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "logical_and"
	// WreslPlus.g:825:1: logical_and : logical_unary (a= AND logical_unary )* ;
	public final WreslPlusParser.logical_and_return logical_and() throws RecognitionException {
		WreslPlusParser.logical_and_return retval = new WreslPlusParser.logical_and_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token a=null;
		ParserRuleReturnScope logical_unary378 =null;
		ParserRuleReturnScope logical_unary379 =null;

		CommonTree a_tree=null;

		try {
			// WreslPlus.g:826:5: ( logical_unary (a= AND logical_unary )* )
			// WreslPlus.g:826:9: logical_unary (a= AND logical_unary )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_logical_unary_in_logical_and4062);
			logical_unary378=logical_unary();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, logical_unary378.getTree());

			// WreslPlus.g:827:9: (a= AND logical_unary )*
			loop97:
			while (true) {
				int alt97=2;
				int LA97_0 = input.LA(1);
				if ( (LA97_0==AND) ) {
					alt97=1;
				}

				switch (alt97) {
				case 1 :
					// WreslPlus.g:827:13: a= AND logical_unary
					{
					a=(Token)match(input,AND,FOLLOW_AND_in_logical_and4085); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					a_tree = (CommonTree)adaptor.create(a);
					adaptor.addChild(root_0, a_tree);
					}

					if ( state.backtracking==0 ) {a.setText(" .and. ");}
					pushFollow(FOLLOW_logical_unary_in_logical_and4091);
					logical_unary379=logical_unary();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, logical_unary379.getTree());

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
	// $ANTLR end "logical_and"


	public static class logical_unary_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "logical_unary"
	// WreslPlus.g:830:1: logical_unary : ( NOT )? logical_term ;
	public final WreslPlusParser.logical_unary_return logical_unary() throws RecognitionException {
		WreslPlusParser.logical_unary_return retval = new WreslPlusParser.logical_unary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token NOT380=null;
		ParserRuleReturnScope logical_term381 =null;

		CommonTree NOT380_tree=null;

		try {
			// WreslPlus.g:830:15: ( ( NOT )? logical_term )
			// WreslPlus.g:830:17: ( NOT )? logical_term
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:830:17: ( NOT )?
			int alt98=2;
			int LA98_0 = input.LA(1);
			if ( (LA98_0==NOT) ) {
				alt98=1;
			}
			switch (alt98) {
				case 1 :
					// WreslPlus.g:830:17: NOT
					{
					NOT380=(Token)match(input,NOT,FOLLOW_NOT_in_logical_unary4112); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					NOT380_tree = (CommonTree)adaptor.create(NOT380);
					adaptor.addChild(root_0, NOT380_tree);
					}

					}
					break;

			}

			pushFollow(FOLLOW_logical_term_in_logical_unary4115);
			logical_term381=logical_term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, logical_term381.getTree());

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
	// $ANTLR end "logical_unary"


	public static class logical_term_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "logical_term"
	// WreslPlus.g:832:1: logical_term : ( ( logical_relation )=> logical_relation | ( logical_or_p )=> logical_or_p | logical_relation_p | logicalFunc );
	public final WreslPlusParser.logical_term_return logical_term() throws RecognitionException {
		WreslPlusParser.logical_term_return retval = new WreslPlusParser.logical_term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope logical_relation382 =null;
		ParserRuleReturnScope logical_or_p383 =null;
		ParserRuleReturnScope logical_relation_p384 =null;
		ParserRuleReturnScope logicalFunc385 =null;


		try {
			// WreslPlus.g:833:5: ( ( logical_relation )=> logical_relation | ( logical_or_p )=> logical_or_p | logical_relation_p | logicalFunc )
			int alt99=4;
			int LA99_0 = input.LA(1);
			if ( (LA99_0==106||LA99_0==108) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==INT) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==REAL) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==ID) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==LOG) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==INT_word) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==ROUND) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==MOD) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==SIN) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==COS) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==TAN) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==COT) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==ASIN) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==ACOS) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==ATAN) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==ACOT) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==EXCEEDANCE) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==EXCEEDANCE_TSI) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( ((LA99_0 >= MAX && LA99_0 <= MIN)) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==CFS_TAF||LA99_0==TAF_CFS) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==124) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==DAY||LA99_0==MONTH||LA99_0==WATERYEAR) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==103) ) {
				int LA99_23 = input.LA(2);
				if ( (synpred1_WreslPlus()) ) {
					alt99=1;
				}
				else if ( (synpred2_WreslPlus()) ) {
					alt99=2;
				}
				else if ( (true) ) {
					alt99=3;
				}

			}
			else if ( ((LA99_0 >= 99 && LA99_0 <= 100)||LA99_0==123) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==122) && (synpred1_WreslPlus())) {
				alt99=1;
			}
			else if ( (LA99_0==RANGE) ) {
				alt99=4;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 99, 0, input);
				throw nvae;
			}

			switch (alt99) {
				case 1 :
					// WreslPlus.g:833:10: ( logical_relation )=> logical_relation
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_logical_relation_in_logical_term4138);
					logical_relation382=logical_relation();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, logical_relation382.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:834:10: ( logical_or_p )=> logical_or_p
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_logical_or_p_in_logical_term4157);
					logical_or_p383=logical_or_p();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, logical_or_p383.getTree());

					}
					break;
				case 3 :
					// WreslPlus.g:835:10: logical_relation_p
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_logical_relation_p_in_logical_term4168);
					logical_relation_p384=logical_relation_p();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, logical_relation_p384.getTree());

					}
					break;
				case 4 :
					// WreslPlus.g:836:10: logicalFunc
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_logicalFunc_in_logical_term4179);
					logicalFunc385=logicalFunc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalFunc385.getTree());

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
	// $ANTLR end "logical_term"


	public static class logical_or_p_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "logical_or_p"
	// WreslPlus.g:839:1: logical_or_p : '(' logical_or ')' ;
	public final WreslPlusParser.logical_or_p_return logical_or_p() throws RecognitionException {
		WreslPlusParser.logical_or_p_return retval = new WreslPlusParser.logical_or_p_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal386=null;
		Token char_literal388=null;
		ParserRuleReturnScope logical_or387 =null;

		CommonTree char_literal386_tree=null;
		CommonTree char_literal388_tree=null;

		try {
			// WreslPlus.g:839:14: ( '(' logical_or ')' )
			// WreslPlus.g:839:16: '(' logical_or ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal386=(Token)match(input,103,FOLLOW_103_in_logical_or_p4196); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal386_tree = (CommonTree)adaptor.create(char_literal386);
			adaptor.addChild(root_0, char_literal386_tree);
			}

			pushFollow(FOLLOW_logical_or_in_logical_or_p4198);
			logical_or387=logical_or();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, logical_or387.getTree());

			char_literal388=(Token)match(input,104,FOLLOW_104_in_logical_or_p4200); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal388_tree = (CommonTree)adaptor.create(char_literal388);
			adaptor.addChild(root_0, char_literal388_tree);
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
	// $ANTLR end "logical_or_p"


	public static class logical_relation_p_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "logical_relation_p"
	// WreslPlus.g:841:1: logical_relation_p : '(' logical_relation ')' ;
	public final WreslPlusParser.logical_relation_p_return logical_relation_p() throws RecognitionException {
		WreslPlusParser.logical_relation_p_return retval = new WreslPlusParser.logical_relation_p_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal389=null;
		Token char_literal391=null;
		ParserRuleReturnScope logical_relation390 =null;

		CommonTree char_literal389_tree=null;
		CommonTree char_literal391_tree=null;

		try {
			// WreslPlus.g:842:2: ( '(' logical_relation ')' )
			// WreslPlus.g:842:5: '(' logical_relation ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal389=(Token)match(input,103,FOLLOW_103_in_logical_relation_p4211); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal389_tree = (CommonTree)adaptor.create(char_literal389);
			adaptor.addChild(root_0, char_literal389_tree);
			}

			pushFollow(FOLLOW_logical_relation_in_logical_relation_p4213);
			logical_relation390=logical_relation();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, logical_relation390.getTree());

			char_literal391=(Token)match(input,104,FOLLOW_104_in_logical_relation_p4215); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal391_tree = (CommonTree)adaptor.create(char_literal391);
			adaptor.addChild(root_0, char_literal391_tree);
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
	// $ANTLR end "logical_relation_p"


	public static class logical_relation_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "logical_relation"
	// WreslPlus.g:845:1: logical_relation : expr_add relation_token expr_add ;
	public final WreslPlusParser.logical_relation_return logical_relation() throws RecognitionException {
		WreslPlusParser.logical_relation_return retval = new WreslPlusParser.logical_relation_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr_add392 =null;
		ParserRuleReturnScope relation_token393 =null;
		ParserRuleReturnScope expr_add394 =null;


		try {
			// WreslPlus.g:846:2: ( expr_add relation_token expr_add )
			// WreslPlus.g:846:5: expr_add relation_token expr_add
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_add_in_logical_relation4227);
			expr_add392=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add392.getTree());

			pushFollow(FOLLOW_relation_token_in_logical_relation4230);
			relation_token393=relation_token();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, relation_token393.getTree());

			pushFollow(FOLLOW_expr_add_in_logical_relation4233);
			expr_add394=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add394.getTree());

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
	// $ANTLR end "logical_relation"


	public static class logicalFunc_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "logicalFunc"
	// WreslPlus.g:849:1: logicalFunc : RANGE '(' expr_add ',' expr_add ',' expr_add ')' ;
	public final WreslPlusParser.logicalFunc_return logicalFunc() throws RecognitionException {
		WreslPlusParser.logicalFunc_return retval = new WreslPlusParser.logicalFunc_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token RANGE395=null;
		Token char_literal396=null;
		Token char_literal398=null;
		Token char_literal400=null;
		Token char_literal402=null;
		ParserRuleReturnScope expr_add397 =null;
		ParserRuleReturnScope expr_add399 =null;
		ParserRuleReturnScope expr_add401 =null;

		CommonTree RANGE395_tree=null;
		CommonTree char_literal396_tree=null;
		CommonTree char_literal398_tree=null;
		CommonTree char_literal400_tree=null;
		CommonTree char_literal402_tree=null;

		try {
			// WreslPlus.g:850:2: ( RANGE '(' expr_add ',' expr_add ',' expr_add ')' )
			// WreslPlus.g:850:4: RANGE '(' expr_add ',' expr_add ',' expr_add ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			RANGE395=(Token)match(input,RANGE,FOLLOW_RANGE_in_logicalFunc4245); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			RANGE395_tree = (CommonTree)adaptor.create(RANGE395);
			adaptor.addChild(root_0, RANGE395_tree);
			}

			char_literal396=(Token)match(input,103,FOLLOW_103_in_logicalFunc4247); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal396_tree = (CommonTree)adaptor.create(char_literal396);
			adaptor.addChild(root_0, char_literal396_tree);
			}

			pushFollow(FOLLOW_expr_add_in_logicalFunc4249);
			expr_add397=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add397.getTree());

			char_literal398=(Token)match(input,107,FOLLOW_107_in_logicalFunc4251); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal398_tree = (CommonTree)adaptor.create(char_literal398);
			adaptor.addChild(root_0, char_literal398_tree);
			}

			pushFollow(FOLLOW_expr_add_in_logicalFunc4253);
			expr_add399=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add399.getTree());

			char_literal400=(Token)match(input,107,FOLLOW_107_in_logicalFunc4255); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal400_tree = (CommonTree)adaptor.create(char_literal400);
			adaptor.addChild(root_0, char_literal400_tree);
			}

			pushFollow(FOLLOW_expr_add_in_logicalFunc4257);
			expr_add401=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add401.getTree());

			char_literal402=(Token)match(input,104,FOLLOW_104_in_logicalFunc4259); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal402_tree = (CommonTree)adaptor.create(char_literal402);
			adaptor.addChild(root_0, char_literal402_tree);
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
	// $ANTLR end "logicalFunc"


	public static class constraint_token_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "constraint_token"
	// WreslPlus.g:855:1: constraint_token : ( '>' | '<' | '>=' | '<=' | '=' );
	public final WreslPlusParser.constraint_token_return constraint_token() throws RecognitionException {
		WreslPlusParser.constraint_token_return retval = new WreslPlusParser.constraint_token_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set403=null;

		CommonTree set403_tree=null;

		try {
			// WreslPlus.g:855:18: ( '>' | '<' | '>=' | '<=' | '=' )
			// WreslPlus.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set403=input.LT(1);
			if ( (input.LA(1) >= 113 && input.LA(1) <= 115)||(input.LA(1) >= 117 && input.LA(1) <= 118) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set403));
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
	// $ANTLR end "constraint_token"


	public static class expr_constraint_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_constraint"
	// WreslPlus.g:857:1: expr_constraint : expr_add constraint_token expr_add ;
	public final WreslPlusParser.expr_constraint_return expr_constraint() throws RecognitionException {
		WreslPlusParser.expr_constraint_return retval = new WreslPlusParser.expr_constraint_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr_add404 =null;
		ParserRuleReturnScope constraint_token405 =null;
		ParserRuleReturnScope expr_add406 =null;


		try {
			// WreslPlus.g:858:2: ( expr_add constraint_token expr_add )
			// WreslPlus.g:858:4: expr_add constraint_token expr_add
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_add_in_expr_constraint4298);
			expr_add404=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add404.getTree());

			pushFollow(FOLLOW_constraint_token_in_expr_constraint4300);
			constraint_token405=constraint_token();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, constraint_token405.getTree());

			pushFollow(FOLLOW_expr_add_in_expr_constraint4302);
			expr_add406=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add406.getTree());

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
	// $ANTLR end "expr_constraint"


	public static class relation_token_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "relation_token"
	// WreslPlus.g:862:1: relation_token : ( '>' | '<' | '>=' | '<=' | '==' | '/=' );
	public final WreslPlusParser.relation_token_return relation_token() throws RecognitionException {
		WreslPlusParser.relation_token_return retval = new WreslPlusParser.relation_token_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set407=null;

		CommonTree set407_tree=null;

		try {
			// WreslPlus.g:862:15: ( '>' | '<' | '>=' | '<=' | '==' | '/=' )
			// WreslPlus.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set407=input.LT(1);
			if ( input.LA(1)==111||(input.LA(1) >= 113 && input.LA(1) <= 114)||(input.LA(1) >= 116 && input.LA(1) <= 118) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set407));
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
	// $ANTLR end "relation_token"


	public static class expr_relation_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_relation"
	// WreslPlus.g:864:1: expr_relation : expr_add relation_token expr_add ;
	public final WreslPlusParser.expr_relation_return expr_relation() throws RecognitionException {
		WreslPlusParser.expr_relation_return retval = new WreslPlusParser.expr_relation_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr_add408 =null;
		ParserRuleReturnScope relation_token409 =null;
		ParserRuleReturnScope expr_add410 =null;


		try {
			// WreslPlus.g:865:2: ( expr_add relation_token expr_add )
			// WreslPlus.g:865:5: expr_add relation_token expr_add
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_add_in_expr_relation4343);
			expr_add408=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add408.getTree());

			pushFollow(FOLLOW_relation_token_in_expr_relation4346);
			relation_token409=relation_token();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, relation_token409.getTree());

			pushFollow(FOLLOW_expr_add_in_expr_relation4349);
			expr_add410=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add410.getTree());

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
	// $ANTLR end "expr_relation"


	public static class expr_assign_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_assign"
	// WreslPlus.g:869:1: expr_assign : expr_add '=' expr_add ;
	public final WreslPlusParser.expr_assign_return expr_assign() throws RecognitionException {
		WreslPlusParser.expr_assign_return retval = new WreslPlusParser.expr_assign_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal412=null;
		ParserRuleReturnScope expr_add411 =null;
		ParserRuleReturnScope expr_add413 =null;

		CommonTree char_literal412_tree=null;

		 Set<String> backup = new LinkedHashSet<String>(dependants);
		try {
			// WreslPlus.g:871:5: ( expr_add '=' expr_add )
			// WreslPlus.g:871:9: expr_add '=' expr_add
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_add_in_expr_assign4370);
			expr_add411=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add411.getTree());

			if ( state.backtracking==0 ) {dependants = backup;}
			char_literal412=(Token)match(input,115,FOLLOW_115_in_expr_assign4374); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal412_tree = (CommonTree)adaptor.create(char_literal412);
			adaptor.addChild(root_0, char_literal412_tree);
			}

			pushFollow(FOLLOW_expr_add_in_expr_assign4377);
			expr_add413=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add413.getTree());

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
	// $ANTLR end "expr_assign"


	public static class expr_add_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_add_simple"
	// WreslPlus.g:874:1: expr_add_simple : expr_mult_simple ( ( '+' | '-' ) expr_mult_simple )* ;
	public final WreslPlusParser.expr_add_simple_return expr_add_simple() throws RecognitionException {
		WreslPlusParser.expr_add_simple_return retval = new WreslPlusParser.expr_add_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set415=null;
		ParserRuleReturnScope expr_mult_simple414 =null;
		ParserRuleReturnScope expr_mult_simple416 =null;

		CommonTree set415_tree=null;

		try {
			// WreslPlus.g:875:5: ( expr_mult_simple ( ( '+' | '-' ) expr_mult_simple )* )
			// WreslPlus.g:875:9: expr_mult_simple ( ( '+' | '-' ) expr_mult_simple )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_mult_simple_in_expr_add_simple4398);
			expr_mult_simple414=expr_mult_simple();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_mult_simple414.getTree());

			// WreslPlus.g:875:27: ( ( '+' | '-' ) expr_mult_simple )*
			loop100:
			while (true) {
				int alt100=2;
				int LA100_0 = input.LA(1);
				if ( (LA100_0==106||LA100_0==108) ) {
					alt100=1;
				}

				switch (alt100) {
				case 1 :
					// WreslPlus.g:875:29: ( '+' | '-' ) expr_mult_simple
					{
					set415=input.LT(1);
					if ( input.LA(1)==106||input.LA(1)==108 ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set415));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_expr_mult_simple_in_expr_add_simple4414);
					expr_mult_simple416=expr_mult_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_mult_simple416.getTree());

					}
					break;

				default :
					break loop100;
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
	// $ANTLR end "expr_add_simple"


	public static class expr_mult_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_mult_simple"
	// WreslPlus.g:878:1: expr_mult_simple : expr_unary_simple ( ( '*' | '/' ) expr_unary_simple )* ;
	public final WreslPlusParser.expr_mult_simple_return expr_mult_simple() throws RecognitionException {
		WreslPlusParser.expr_mult_simple_return retval = new WreslPlusParser.expr_mult_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set418=null;
		ParserRuleReturnScope expr_unary_simple417 =null;
		ParserRuleReturnScope expr_unary_simple419 =null;

		CommonTree set418_tree=null;

		try {
			// WreslPlus.g:879:5: ( expr_unary_simple ( ( '*' | '/' ) expr_unary_simple )* )
			// WreslPlus.g:879:10: expr_unary_simple ( ( '*' | '/' ) expr_unary_simple )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_unary_simple_in_expr_mult_simple4440);
			expr_unary_simple417=expr_unary_simple();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_unary_simple417.getTree());

			// WreslPlus.g:879:29: ( ( '*' | '/' ) expr_unary_simple )*
			loop101:
			while (true) {
				int alt101=2;
				int LA101_0 = input.LA(1);
				if ( (LA101_0==105||LA101_0==110) ) {
					alt101=1;
				}

				switch (alt101) {
				case 1 :
					// WreslPlus.g:879:31: ( '*' | '/' ) expr_unary_simple
					{
					set418=input.LT(1);
					if ( input.LA(1)==105||input.LA(1)==110 ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set418));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_expr_unary_simple_in_expr_mult_simple4456);
					expr_unary_simple419=expr_unary_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_unary_simple419.getTree());

					}
					break;

				default :
					break loop101;
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
	// $ANTLR end "expr_mult_simple"


	public static class expr_unary_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_unary_simple"
	// WreslPlus.g:882:1: expr_unary_simple : ( '-' )? expr_term_simple ;
	public final WreslPlusParser.expr_unary_simple_return expr_unary_simple() throws RecognitionException {
		WreslPlusParser.expr_unary_simple_return retval = new WreslPlusParser.expr_unary_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal420=null;
		ParserRuleReturnScope expr_term_simple421 =null;

		CommonTree char_literal420_tree=null;

		try {
			// WreslPlus.g:882:18: ( ( '-' )? expr_term_simple )
			// WreslPlus.g:882:20: ( '-' )? expr_term_simple
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:882:20: ( '-' )?
			int alt102=2;
			int LA102_0 = input.LA(1);
			if ( (LA102_0==108) ) {
				alt102=1;
			}
			switch (alt102) {
				case 1 :
					// WreslPlus.g:882:20: '-'
					{
					char_literal420=(Token)match(input,108,FOLLOW_108_in_expr_unary_simple4474); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal420_tree = (CommonTree)adaptor.create(char_literal420);
					adaptor.addChild(root_0, char_literal420_tree);
					}

					}
					break;

			}

			pushFollow(FOLLOW_expr_term_simple_in_expr_unary_simple4477);
			expr_term_simple421=expr_term_simple();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_term_simple421.getTree());

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
	// $ANTLR end "expr_unary_simple"


	public static class expr_term_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_term_simple"
	// WreslPlus.g:884:1: expr_term_simple : ( atom_simple | '(' expr_add_simple ')' );
	public final WreslPlusParser.expr_term_simple_return expr_term_simple() throws RecognitionException {
		WreslPlusParser.expr_term_simple_return retval = new WreslPlusParser.expr_term_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal423=null;
		Token char_literal425=null;
		ParserRuleReturnScope atom_simple422 =null;
		ParserRuleReturnScope expr_add_simple424 =null;

		CommonTree char_literal423_tree=null;
		CommonTree char_literal425_tree=null;

		try {
			// WreslPlus.g:885:5: ( atom_simple | '(' expr_add_simple ')' )
			int alt103=2;
			int LA103_0 = input.LA(1);
			if ( ((LA103_0 >= ACOS && LA103_0 <= ACOT)||(LA103_0 >= ASIN && LA103_0 <= ATAN)||LA103_0==CFS_TAF||(LA103_0 >= COS && LA103_0 <= COT)||(LA103_0 >= EXCEEDANCE && LA103_0 <= EXCEEDANCE_TSI)||LA103_0==ID||LA103_0==INT||LA103_0==INT_word||LA103_0==LOG||(LA103_0 >= MAX && LA103_0 <= MIN)||LA103_0==MOD||LA103_0==REAL||LA103_0==ROUND||LA103_0==SIN||(LA103_0 >= TAF_CFS && LA103_0 <= TAN)) ) {
				alt103=1;
			}
			else if ( (LA103_0==103) ) {
				alt103=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 103, 0, input);
				throw nvae;
			}

			switch (alt103) {
				case 1 :
					// WreslPlus.g:885:9: atom_simple
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_atom_simple_in_expr_term_simple4493);
					atom_simple422=atom_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atom_simple422.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:886:9: '(' expr_add_simple ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal423=(Token)match(input,103,FOLLOW_103_in_expr_term_simple4503); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal423_tree = (CommonTree)adaptor.create(char_literal423);
					adaptor.addChild(root_0, char_literal423_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_expr_term_simple4505);
					expr_add_simple424=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple424.getTree());

					char_literal425=(Token)match(input,104,FOLLOW_104_in_expr_term_simple4507); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal425_tree = (CommonTree)adaptor.create(char_literal425);
					adaptor.addChild(root_0, char_literal425_tree);
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
	// $ANTLR end "expr_term_simple"


	public static class atom_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom_simple"
	// WreslPlus.g:889:1: atom_simple : ( number_p |v= varID | intrinsicFunc_simple );
	public final WreslPlusParser.atom_simple_return atom_simple() throws RecognitionException {
		WreslPlusParser.atom_simple_return retval = new WreslPlusParser.atom_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope v =null;
		ParserRuleReturnScope number_p426 =null;
		ParserRuleReturnScope intrinsicFunc_simple427 =null;


		try {
			// WreslPlus.g:890:5: ( number_p |v= varID | intrinsicFunc_simple )
			int alt104=3;
			switch ( input.LA(1) ) {
			case INT:
			case REAL:
				{
				alt104=1;
				}
				break;
			case ID:
				{
				alt104=2;
				}
				break;
			case ACOS:
			case ACOT:
			case ASIN:
			case ATAN:
			case CFS_TAF:
			case COS:
			case COT:
			case EXCEEDANCE:
			case EXCEEDANCE_TSI:
			case INT_word:
			case LOG:
			case MAX:
			case MIN:
			case MOD:
			case ROUND:
			case SIN:
			case TAF_CFS:
			case TAN:
				{
				alt104=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 104, 0, input);
				throw nvae;
			}
			switch (alt104) {
				case 1 :
					// WreslPlus.g:890:8: number_p
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_number_p_in_atom_simple4529);
					number_p426=number_p();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, number_p426.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:891:8: v= varID
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_varID_in_atom_simple4540);
					v=varID();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());

					if ( state.backtracking==0 ) {dependants.add((v!=null?input.toString(v.start,v.stop):null));}
					}
					break;
				case 3 :
					// WreslPlus.g:892:8: intrinsicFunc_simple
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_intrinsicFunc_simple_in_atom_simple4552);
					intrinsicFunc_simple427=intrinsicFunc_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, intrinsicFunc_simple427.getTree());

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
	// $ANTLR end "atom_simple"


	public static class intrinsicFunc_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "intrinsicFunc_simple"
	// WreslPlus.g:895:1: intrinsicFunc_simple : ( mathFunc_simple | multiInputFunc_simple | unitFunc_simple );
	public final WreslPlusParser.intrinsicFunc_simple_return intrinsicFunc_simple() throws RecognitionException {
		WreslPlusParser.intrinsicFunc_simple_return retval = new WreslPlusParser.intrinsicFunc_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope mathFunc_simple428 =null;
		ParserRuleReturnScope multiInputFunc_simple429 =null;
		ParserRuleReturnScope unitFunc_simple430 =null;


		try {
			// WreslPlus.g:896:3: ( mathFunc_simple | multiInputFunc_simple | unitFunc_simple )
			int alt105=3;
			switch ( input.LA(1) ) {
			case ACOS:
			case ACOT:
			case ASIN:
			case ATAN:
			case COS:
			case COT:
			case EXCEEDANCE:
			case EXCEEDANCE_TSI:
			case INT_word:
			case LOG:
			case MOD:
			case ROUND:
			case SIN:
			case TAN:
				{
				alt105=1;
				}
				break;
			case MAX:
			case MIN:
				{
				alt105=2;
				}
				break;
			case CFS_TAF:
			case TAF_CFS:
				{
				alt105=3;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 105, 0, input);
				throw nvae;
			}
			switch (alt105) {
				case 1 :
					// WreslPlus.g:896:5: mathFunc_simple
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_mathFunc_simple_in_intrinsicFunc_simple4571);
					mathFunc_simple428=mathFunc_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mathFunc_simple428.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:897:5: multiInputFunc_simple
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_multiInputFunc_simple_in_intrinsicFunc_simple4578);
					multiInputFunc_simple429=multiInputFunc_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, multiInputFunc_simple429.getTree());

					}
					break;
				case 3 :
					// WreslPlus.g:898:5: unitFunc_simple
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_unitFunc_simple_in_intrinsicFunc_simple4584);
					unitFunc_simple430=unitFunc_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, unitFunc_simple430.getTree());

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
	// $ANTLR end "intrinsicFunc_simple"


	public static class mathFunc_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "mathFunc_simple"
	// WreslPlus.g:901:1: mathFunc_simple : ( LOG '(' expr_add_simple ')' | INT_word '(' expr_add_simple ')' | ROUND '(' expr_add_simple ')' | MOD '(' expr_add_simple ',' expr_add_simple ')' | SIN '(' expr_add_simple ')' | COS '(' expr_add_simple ')' | TAN '(' expr_add_simple ')' | COT '(' expr_add_simple ')' | ASIN '(' expr_add_simple ')' | ACOS '(' expr_add_simple ')' | ATAN '(' expr_add_simple ')' | ACOT '(' expr_add_simple ')' | exceedFunc | exceedtsiFunc );
	public final WreslPlusParser.mathFunc_simple_return mathFunc_simple() throws RecognitionException {
		WreslPlusParser.mathFunc_simple_return retval = new WreslPlusParser.mathFunc_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LOG431=null;
		Token char_literal432=null;
		Token char_literal434=null;
		Token INT_word435=null;
		Token char_literal436=null;
		Token char_literal438=null;
		Token ROUND439=null;
		Token char_literal440=null;
		Token char_literal442=null;
		Token MOD443=null;
		Token char_literal444=null;
		Token char_literal446=null;
		Token char_literal448=null;
		Token SIN449=null;
		Token char_literal450=null;
		Token char_literal452=null;
		Token COS453=null;
		Token char_literal454=null;
		Token char_literal456=null;
		Token TAN457=null;
		Token char_literal458=null;
		Token char_literal460=null;
		Token COT461=null;
		Token char_literal462=null;
		Token char_literal464=null;
		Token ASIN465=null;
		Token char_literal466=null;
		Token char_literal468=null;
		Token ACOS469=null;
		Token char_literal470=null;
		Token char_literal472=null;
		Token ATAN473=null;
		Token char_literal474=null;
		Token char_literal476=null;
		Token ACOT477=null;
		Token char_literal478=null;
		Token char_literal480=null;
		ParserRuleReturnScope expr_add_simple433 =null;
		ParserRuleReturnScope expr_add_simple437 =null;
		ParserRuleReturnScope expr_add_simple441 =null;
		ParserRuleReturnScope expr_add_simple445 =null;
		ParserRuleReturnScope expr_add_simple447 =null;
		ParserRuleReturnScope expr_add_simple451 =null;
		ParserRuleReturnScope expr_add_simple455 =null;
		ParserRuleReturnScope expr_add_simple459 =null;
		ParserRuleReturnScope expr_add_simple463 =null;
		ParserRuleReturnScope expr_add_simple467 =null;
		ParserRuleReturnScope expr_add_simple471 =null;
		ParserRuleReturnScope expr_add_simple475 =null;
		ParserRuleReturnScope expr_add_simple479 =null;
		ParserRuleReturnScope exceedFunc481 =null;
		ParserRuleReturnScope exceedtsiFunc482 =null;

		CommonTree LOG431_tree=null;
		CommonTree char_literal432_tree=null;
		CommonTree char_literal434_tree=null;
		CommonTree INT_word435_tree=null;
		CommonTree char_literal436_tree=null;
		CommonTree char_literal438_tree=null;
		CommonTree ROUND439_tree=null;
		CommonTree char_literal440_tree=null;
		CommonTree char_literal442_tree=null;
		CommonTree MOD443_tree=null;
		CommonTree char_literal444_tree=null;
		CommonTree char_literal446_tree=null;
		CommonTree char_literal448_tree=null;
		CommonTree SIN449_tree=null;
		CommonTree char_literal450_tree=null;
		CommonTree char_literal452_tree=null;
		CommonTree COS453_tree=null;
		CommonTree char_literal454_tree=null;
		CommonTree char_literal456_tree=null;
		CommonTree TAN457_tree=null;
		CommonTree char_literal458_tree=null;
		CommonTree char_literal460_tree=null;
		CommonTree COT461_tree=null;
		CommonTree char_literal462_tree=null;
		CommonTree char_literal464_tree=null;
		CommonTree ASIN465_tree=null;
		CommonTree char_literal466_tree=null;
		CommonTree char_literal468_tree=null;
		CommonTree ACOS469_tree=null;
		CommonTree char_literal470_tree=null;
		CommonTree char_literal472_tree=null;
		CommonTree ATAN473_tree=null;
		CommonTree char_literal474_tree=null;
		CommonTree char_literal476_tree=null;
		CommonTree ACOT477_tree=null;
		CommonTree char_literal478_tree=null;
		CommonTree char_literal480_tree=null;

		try {
			// WreslPlus.g:902:3: ( LOG '(' expr_add_simple ')' | INT_word '(' expr_add_simple ')' | ROUND '(' expr_add_simple ')' | MOD '(' expr_add_simple ',' expr_add_simple ')' | SIN '(' expr_add_simple ')' | COS '(' expr_add_simple ')' | TAN '(' expr_add_simple ')' | COT '(' expr_add_simple ')' | ASIN '(' expr_add_simple ')' | ACOS '(' expr_add_simple ')' | ATAN '(' expr_add_simple ')' | ACOT '(' expr_add_simple ')' | exceedFunc | exceedtsiFunc )
			int alt106=14;
			switch ( input.LA(1) ) {
			case LOG:
				{
				alt106=1;
				}
				break;
			case INT_word:
				{
				alt106=2;
				}
				break;
			case ROUND:
				{
				alt106=3;
				}
				break;
			case MOD:
				{
				alt106=4;
				}
				break;
			case SIN:
				{
				alt106=5;
				}
				break;
			case COS:
				{
				alt106=6;
				}
				break;
			case TAN:
				{
				alt106=7;
				}
				break;
			case COT:
				{
				alt106=8;
				}
				break;
			case ASIN:
				{
				alt106=9;
				}
				break;
			case ACOS:
				{
				alt106=10;
				}
				break;
			case ATAN:
				{
				alt106=11;
				}
				break;
			case ACOT:
				{
				alt106=12;
				}
				break;
			case EXCEEDANCE:
				{
				alt106=13;
				}
				break;
			case EXCEEDANCE_TSI:
				{
				alt106=14;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 106, 0, input);
				throw nvae;
			}
			switch (alt106) {
				case 1 :
					// WreslPlus.g:902:6: LOG '(' expr_add_simple ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					LOG431=(Token)match(input,LOG,FOLLOW_LOG_in_mathFunc_simple4599); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LOG431_tree = (CommonTree)adaptor.create(LOG431);
					adaptor.addChild(root_0, LOG431_tree);
					}

					char_literal432=(Token)match(input,103,FOLLOW_103_in_mathFunc_simple4601); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal432_tree = (CommonTree)adaptor.create(char_literal432);
					adaptor.addChild(root_0, char_literal432_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_mathFunc_simple4603);
					expr_add_simple433=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple433.getTree());

					char_literal434=(Token)match(input,104,FOLLOW_104_in_mathFunc_simple4605); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal434_tree = (CommonTree)adaptor.create(char_literal434);
					adaptor.addChild(root_0, char_literal434_tree);
					}

					}
					break;
				case 2 :
					// WreslPlus.g:903:6: INT_word '(' expr_add_simple ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					INT_word435=(Token)match(input,INT_word,FOLLOW_INT_word_in_mathFunc_simple4613); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT_word435_tree = (CommonTree)adaptor.create(INT_word435);
					adaptor.addChild(root_0, INT_word435_tree);
					}

					char_literal436=(Token)match(input,103,FOLLOW_103_in_mathFunc_simple4615); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal436_tree = (CommonTree)adaptor.create(char_literal436);
					adaptor.addChild(root_0, char_literal436_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_mathFunc_simple4617);
					expr_add_simple437=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple437.getTree());

					char_literal438=(Token)match(input,104,FOLLOW_104_in_mathFunc_simple4619); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal438_tree = (CommonTree)adaptor.create(char_literal438);
					adaptor.addChild(root_0, char_literal438_tree);
					}

					}
					break;
				case 3 :
					// WreslPlus.g:904:6: ROUND '(' expr_add_simple ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					ROUND439=(Token)match(input,ROUND,FOLLOW_ROUND_in_mathFunc_simple4627); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ROUND439_tree = (CommonTree)adaptor.create(ROUND439);
					adaptor.addChild(root_0, ROUND439_tree);
					}

					char_literal440=(Token)match(input,103,FOLLOW_103_in_mathFunc_simple4629); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal440_tree = (CommonTree)adaptor.create(char_literal440);
					adaptor.addChild(root_0, char_literal440_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_mathFunc_simple4631);
					expr_add_simple441=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple441.getTree());

					char_literal442=(Token)match(input,104,FOLLOW_104_in_mathFunc_simple4633); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal442_tree = (CommonTree)adaptor.create(char_literal442);
					adaptor.addChild(root_0, char_literal442_tree);
					}

					}
					break;
				case 4 :
					// WreslPlus.g:905:6: MOD '(' expr_add_simple ',' expr_add_simple ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					MOD443=(Token)match(input,MOD,FOLLOW_MOD_in_mathFunc_simple4641); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MOD443_tree = (CommonTree)adaptor.create(MOD443);
					adaptor.addChild(root_0, MOD443_tree);
					}

					char_literal444=(Token)match(input,103,FOLLOW_103_in_mathFunc_simple4643); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal444_tree = (CommonTree)adaptor.create(char_literal444);
					adaptor.addChild(root_0, char_literal444_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_mathFunc_simple4645);
					expr_add_simple445=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple445.getTree());

					char_literal446=(Token)match(input,107,FOLLOW_107_in_mathFunc_simple4647); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal446_tree = (CommonTree)adaptor.create(char_literal446);
					adaptor.addChild(root_0, char_literal446_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_mathFunc_simple4649);
					expr_add_simple447=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple447.getTree());

					char_literal448=(Token)match(input,104,FOLLOW_104_in_mathFunc_simple4651); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal448_tree = (CommonTree)adaptor.create(char_literal448);
					adaptor.addChild(root_0, char_literal448_tree);
					}

					}
					break;
				case 5 :
					// WreslPlus.g:906:6: SIN '(' expr_add_simple ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					SIN449=(Token)match(input,SIN,FOLLOW_SIN_in_mathFunc_simple4659); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SIN449_tree = (CommonTree)adaptor.create(SIN449);
					adaptor.addChild(root_0, SIN449_tree);
					}

					char_literal450=(Token)match(input,103,FOLLOW_103_in_mathFunc_simple4661); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal450_tree = (CommonTree)adaptor.create(char_literal450);
					adaptor.addChild(root_0, char_literal450_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_mathFunc_simple4663);
					expr_add_simple451=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple451.getTree());

					char_literal452=(Token)match(input,104,FOLLOW_104_in_mathFunc_simple4665); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal452_tree = (CommonTree)adaptor.create(char_literal452);
					adaptor.addChild(root_0, char_literal452_tree);
					}

					}
					break;
				case 6 :
					// WreslPlus.g:907:6: COS '(' expr_add_simple ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					COS453=(Token)match(input,COS,FOLLOW_COS_in_mathFunc_simple4673); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COS453_tree = (CommonTree)adaptor.create(COS453);
					adaptor.addChild(root_0, COS453_tree);
					}

					char_literal454=(Token)match(input,103,FOLLOW_103_in_mathFunc_simple4675); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal454_tree = (CommonTree)adaptor.create(char_literal454);
					adaptor.addChild(root_0, char_literal454_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_mathFunc_simple4677);
					expr_add_simple455=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple455.getTree());

					char_literal456=(Token)match(input,104,FOLLOW_104_in_mathFunc_simple4679); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal456_tree = (CommonTree)adaptor.create(char_literal456);
					adaptor.addChild(root_0, char_literal456_tree);
					}

					}
					break;
				case 7 :
					// WreslPlus.g:908:6: TAN '(' expr_add_simple ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					TAN457=(Token)match(input,TAN,FOLLOW_TAN_in_mathFunc_simple4687); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TAN457_tree = (CommonTree)adaptor.create(TAN457);
					adaptor.addChild(root_0, TAN457_tree);
					}

					char_literal458=(Token)match(input,103,FOLLOW_103_in_mathFunc_simple4689); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal458_tree = (CommonTree)adaptor.create(char_literal458);
					adaptor.addChild(root_0, char_literal458_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_mathFunc_simple4691);
					expr_add_simple459=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple459.getTree());

					char_literal460=(Token)match(input,104,FOLLOW_104_in_mathFunc_simple4693); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal460_tree = (CommonTree)adaptor.create(char_literal460);
					adaptor.addChild(root_0, char_literal460_tree);
					}

					}
					break;
				case 8 :
					// WreslPlus.g:909:6: COT '(' expr_add_simple ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					COT461=(Token)match(input,COT,FOLLOW_COT_in_mathFunc_simple4701); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COT461_tree = (CommonTree)adaptor.create(COT461);
					adaptor.addChild(root_0, COT461_tree);
					}

					char_literal462=(Token)match(input,103,FOLLOW_103_in_mathFunc_simple4703); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal462_tree = (CommonTree)adaptor.create(char_literal462);
					adaptor.addChild(root_0, char_literal462_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_mathFunc_simple4705);
					expr_add_simple463=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple463.getTree());

					char_literal464=(Token)match(input,104,FOLLOW_104_in_mathFunc_simple4707); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal464_tree = (CommonTree)adaptor.create(char_literal464);
					adaptor.addChild(root_0, char_literal464_tree);
					}

					}
					break;
				case 9 :
					// WreslPlus.g:910:6: ASIN '(' expr_add_simple ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					ASIN465=(Token)match(input,ASIN,FOLLOW_ASIN_in_mathFunc_simple4715); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASIN465_tree = (CommonTree)adaptor.create(ASIN465);
					adaptor.addChild(root_0, ASIN465_tree);
					}

					char_literal466=(Token)match(input,103,FOLLOW_103_in_mathFunc_simple4717); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal466_tree = (CommonTree)adaptor.create(char_literal466);
					adaptor.addChild(root_0, char_literal466_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_mathFunc_simple4719);
					expr_add_simple467=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple467.getTree());

					char_literal468=(Token)match(input,104,FOLLOW_104_in_mathFunc_simple4721); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal468_tree = (CommonTree)adaptor.create(char_literal468);
					adaptor.addChild(root_0, char_literal468_tree);
					}

					}
					break;
				case 10 :
					// WreslPlus.g:911:6: ACOS '(' expr_add_simple ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					ACOS469=(Token)match(input,ACOS,FOLLOW_ACOS_in_mathFunc_simple4729); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ACOS469_tree = (CommonTree)adaptor.create(ACOS469);
					adaptor.addChild(root_0, ACOS469_tree);
					}

					char_literal470=(Token)match(input,103,FOLLOW_103_in_mathFunc_simple4731); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal470_tree = (CommonTree)adaptor.create(char_literal470);
					adaptor.addChild(root_0, char_literal470_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_mathFunc_simple4733);
					expr_add_simple471=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple471.getTree());

					char_literal472=(Token)match(input,104,FOLLOW_104_in_mathFunc_simple4735); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal472_tree = (CommonTree)adaptor.create(char_literal472);
					adaptor.addChild(root_0, char_literal472_tree);
					}

					}
					break;
				case 11 :
					// WreslPlus.g:912:6: ATAN '(' expr_add_simple ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					ATAN473=(Token)match(input,ATAN,FOLLOW_ATAN_in_mathFunc_simple4743); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ATAN473_tree = (CommonTree)adaptor.create(ATAN473);
					adaptor.addChild(root_0, ATAN473_tree);
					}

					char_literal474=(Token)match(input,103,FOLLOW_103_in_mathFunc_simple4745); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal474_tree = (CommonTree)adaptor.create(char_literal474);
					adaptor.addChild(root_0, char_literal474_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_mathFunc_simple4747);
					expr_add_simple475=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple475.getTree());

					char_literal476=(Token)match(input,104,FOLLOW_104_in_mathFunc_simple4749); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal476_tree = (CommonTree)adaptor.create(char_literal476);
					adaptor.addChild(root_0, char_literal476_tree);
					}

					}
					break;
				case 12 :
					// WreslPlus.g:913:6: ACOT '(' expr_add_simple ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					ACOT477=(Token)match(input,ACOT,FOLLOW_ACOT_in_mathFunc_simple4757); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ACOT477_tree = (CommonTree)adaptor.create(ACOT477);
					adaptor.addChild(root_0, ACOT477_tree);
					}

					char_literal478=(Token)match(input,103,FOLLOW_103_in_mathFunc_simple4759); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal478_tree = (CommonTree)adaptor.create(char_literal478);
					adaptor.addChild(root_0, char_literal478_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_mathFunc_simple4761);
					expr_add_simple479=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple479.getTree());

					char_literal480=(Token)match(input,104,FOLLOW_104_in_mathFunc_simple4763); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal480_tree = (CommonTree)adaptor.create(char_literal480);
					adaptor.addChild(root_0, char_literal480_tree);
					}

					}
					break;
				case 13 :
					// WreslPlus.g:914:6: exceedFunc
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_exceedFunc_in_mathFunc_simple4771);
					exceedFunc481=exceedFunc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exceedFunc481.getTree());

					}
					break;
				case 14 :
					// WreslPlus.g:915:6: exceedtsiFunc
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_exceedtsiFunc_in_mathFunc_simple4778);
					exceedtsiFunc482=exceedtsiFunc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exceedtsiFunc482.getTree());

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
	// $ANTLR end "mathFunc_simple"


	public static class unitFunc_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "unitFunc_simple"
	// WreslPlus.g:918:1: unitFunc_simple : ( CFS_TAF | TAF_CFS ) ( '(' expr_add_simple ')' )? ;
	public final WreslPlusParser.unitFunc_simple_return unitFunc_simple() throws RecognitionException {
		WreslPlusParser.unitFunc_simple_return retval = new WreslPlusParser.unitFunc_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set483=null;
		Token char_literal484=null;
		Token char_literal486=null;
		ParserRuleReturnScope expr_add_simple485 =null;

		CommonTree set483_tree=null;
		CommonTree char_literal484_tree=null;
		CommonTree char_literal486_tree=null;

		try {
			// WreslPlus.g:919:3: ( ( CFS_TAF | TAF_CFS ) ( '(' expr_add_simple ')' )? )
			// WreslPlus.g:919:5: ( CFS_TAF | TAF_CFS ) ( '(' expr_add_simple ')' )?
			{
			root_0 = (CommonTree)adaptor.nil();


			set483=input.LT(1);
			if ( input.LA(1)==CFS_TAF||input.LA(1)==TAF_CFS ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set483));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			// WreslPlus.g:919:27: ( '(' expr_add_simple ')' )?
			int alt107=2;
			int LA107_0 = input.LA(1);
			if ( (LA107_0==103) ) {
				alt107=1;
			}
			switch (alt107) {
				case 1 :
					// WreslPlus.g:919:28: '(' expr_add_simple ')'
					{
					char_literal484=(Token)match(input,103,FOLLOW_103_in_unitFunc_simple4806); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal484_tree = (CommonTree)adaptor.create(char_literal484);
					adaptor.addChild(root_0, char_literal484_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_unitFunc_simple4808);
					expr_add_simple485=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple485.getTree());

					char_literal486=(Token)match(input,104,FOLLOW_104_in_unitFunc_simple4810); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal486_tree = (CommonTree)adaptor.create(char_literal486);
					adaptor.addChild(root_0, char_literal486_tree);
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
	// $ANTLR end "unitFunc_simple"


	public static class multiInputFunc_simple_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "multiInputFunc_simple"
	// WreslPlus.g:921:1: multiInputFunc_simple : ( MIN | MAX ) '(' expr_add_simple ( ',' expr_add_simple )* ')' ;
	public final WreslPlusParser.multiInputFunc_simple_return multiInputFunc_simple() throws RecognitionException {
		WreslPlusParser.multiInputFunc_simple_return retval = new WreslPlusParser.multiInputFunc_simple_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set487=null;
		Token char_literal488=null;
		Token char_literal490=null;
		Token char_literal492=null;
		ParserRuleReturnScope expr_add_simple489 =null;
		ParserRuleReturnScope expr_add_simple491 =null;

		CommonTree set487_tree=null;
		CommonTree char_literal488_tree=null;
		CommonTree char_literal490_tree=null;
		CommonTree char_literal492_tree=null;

		try {
			// WreslPlus.g:922:3: ( ( MIN | MAX ) '(' expr_add_simple ( ',' expr_add_simple )* ')' )
			// WreslPlus.g:922:5: ( MIN | MAX ) '(' expr_add_simple ( ',' expr_add_simple )* ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			set487=input.LT(1);
			if ( (input.LA(1) >= MAX && input.LA(1) <= MIN) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set487));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal488=(Token)match(input,103,FOLLOW_103_in_multiInputFunc_simple4837); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal488_tree = (CommonTree)adaptor.create(char_literal488);
			adaptor.addChild(root_0, char_literal488_tree);
			}

			pushFollow(FOLLOW_expr_add_simple_in_multiInputFunc_simple4839);
			expr_add_simple489=expr_add_simple();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple489.getTree());

			// WreslPlus.g:922:39: ( ',' expr_add_simple )*
			loop108:
			while (true) {
				int alt108=2;
				int LA108_0 = input.LA(1);
				if ( (LA108_0==107) ) {
					alt108=1;
				}

				switch (alt108) {
				case 1 :
					// WreslPlus.g:922:41: ',' expr_add_simple
					{
					char_literal490=(Token)match(input,107,FOLLOW_107_in_multiInputFunc_simple4843); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal490_tree = (CommonTree)adaptor.create(char_literal490);
					adaptor.addChild(root_0, char_literal490_tree);
					}

					pushFollow(FOLLOW_expr_add_simple_in_multiInputFunc_simple4845);
					expr_add_simple491=expr_add_simple();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add_simple491.getTree());

					}
					break;

				default :
					break loop108;
				}
			}

			char_literal492=(Token)match(input,104,FOLLOW_104_in_multiInputFunc_simple4850); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal492_tree = (CommonTree)adaptor.create(char_literal492);
			adaptor.addChild(root_0, char_literal492_tree);
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
	// $ANTLR end "multiInputFunc_simple"


	public static class expr_add_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_add"
	// WreslPlus.g:927:1: expr_add : expr_mult ( ( '+' | '-' ) expr_mult )* ;
	public final WreslPlusParser.expr_add_return expr_add() throws RecognitionException {
		WreslPlusParser.expr_add_return retval = new WreslPlusParser.expr_add_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set494=null;
		ParserRuleReturnScope expr_mult493 =null;
		ParserRuleReturnScope expr_mult495 =null;

		CommonTree set494_tree=null;

		try {
			// WreslPlus.g:928:5: ( expr_mult ( ( '+' | '-' ) expr_mult )* )
			// WreslPlus.g:928:9: expr_mult ( ( '+' | '-' ) expr_mult )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_mult_in_expr_add4876);
			expr_mult493=expr_mult();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_mult493.getTree());

			// WreslPlus.g:928:20: ( ( '+' | '-' ) expr_mult )*
			loop109:
			while (true) {
				int alt109=2;
				int LA109_0 = input.LA(1);
				if ( (LA109_0==106||LA109_0==108) ) {
					alt109=1;
				}

				switch (alt109) {
				case 1 :
					// WreslPlus.g:928:22: ( '+' | '-' ) expr_mult
					{
					set494=input.LT(1);
					if ( input.LA(1)==106||input.LA(1)==108 ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set494));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_expr_mult_in_expr_add4892);
					expr_mult495=expr_mult();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_mult495.getTree());

					}
					break;

				default :
					break loop109;
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
	// $ANTLR end "expr_add"


	public static class expr_mult_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_mult"
	// WreslPlus.g:931:1: expr_mult : expr_unary ( ( '*' | '/' ) expr_unary )* ;
	public final WreslPlusParser.expr_mult_return expr_mult() throws RecognitionException {
		WreslPlusParser.expr_mult_return retval = new WreslPlusParser.expr_mult_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set497=null;
		ParserRuleReturnScope expr_unary496 =null;
		ParserRuleReturnScope expr_unary498 =null;

		CommonTree set497_tree=null;

		try {
			// WreslPlus.g:932:5: ( expr_unary ( ( '*' | '/' ) expr_unary )* )
			// WreslPlus.g:932:10: expr_unary ( ( '*' | '/' ) expr_unary )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_expr_unary_in_expr_mult4918);
			expr_unary496=expr_unary();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_unary496.getTree());

			// WreslPlus.g:932:22: ( ( '*' | '/' ) expr_unary )*
			loop110:
			while (true) {
				int alt110=2;
				int LA110_0 = input.LA(1);
				if ( (LA110_0==105||LA110_0==110) ) {
					alt110=1;
				}

				switch (alt110) {
				case 1 :
					// WreslPlus.g:932:24: ( '*' | '/' ) expr_unary
					{
					set497=input.LT(1);
					if ( input.LA(1)==105||input.LA(1)==110 ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set497));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_expr_unary_in_expr_mult4934);
					expr_unary498=expr_unary();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_unary498.getTree());

					}
					break;

				default :
					break loop110;
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
	// $ANTLR end "expr_mult"


	public static class expr_unary_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_unary"
	// WreslPlus.g:935:1: expr_unary : ( '-' | '+' )? expr_term ;
	public final WreslPlusParser.expr_unary_return expr_unary() throws RecognitionException {
		WreslPlusParser.expr_unary_return retval = new WreslPlusParser.expr_unary_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set499=null;
		ParserRuleReturnScope expr_term500 =null;

		CommonTree set499_tree=null;

		try {
			// WreslPlus.g:935:11: ( ( '-' | '+' )? expr_term )
			// WreslPlus.g:935:13: ( '-' | '+' )? expr_term
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:935:13: ( '-' | '+' )?
			int alt111=2;
			int LA111_0 = input.LA(1);
			if ( (LA111_0==106||LA111_0==108) ) {
				alt111=1;
			}
			switch (alt111) {
				case 1 :
					// WreslPlus.g:
					{
					set499=input.LT(1);
					if ( input.LA(1)==106||input.LA(1)==108 ) {
						input.consume();
						if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set499));
						state.errorRecovery=false;
						state.failed=false;
					}
					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					}
					break;

			}

			pushFollow(FOLLOW_expr_term_in_expr_unary4960);
			expr_term500=expr_term();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_term500.getTree());

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
	// $ANTLR end "expr_unary"


	public static class expr_term_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "expr_term"
	// WreslPlus.g:937:1: expr_term : ( atom | '(' expr_add ')' );
	public final WreslPlusParser.expr_term_return expr_term() throws RecognitionException {
		WreslPlusParser.expr_term_return retval = new WreslPlusParser.expr_term_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal502=null;
		Token char_literal504=null;
		ParserRuleReturnScope atom501 =null;
		ParserRuleReturnScope expr_add503 =null;

		CommonTree char_literal502_tree=null;
		CommonTree char_literal504_tree=null;

		try {
			// WreslPlus.g:938:5: ( atom | '(' expr_add ')' )
			int alt112=2;
			int LA112_0 = input.LA(1);
			if ( ((LA112_0 >= ACOS && LA112_0 <= ACOT)||(LA112_0 >= ASIN && LA112_0 <= ATAN)||LA112_0==CFS_TAF||(LA112_0 >= COS && LA112_0 <= COT)||LA112_0==DAY||(LA112_0 >= EXCEEDANCE && LA112_0 <= EXCEEDANCE_TSI)||LA112_0==ID||LA112_0==INT||LA112_0==INT_word||LA112_0==LOG||(LA112_0 >= MAX && LA112_0 <= MIN)||LA112_0==MOD||LA112_0==MONTH||LA112_0==REAL||LA112_0==ROUND||LA112_0==SIN||(LA112_0 >= TAF_CFS && LA112_0 <= TAN)||LA112_0==WATERYEAR||(LA112_0 >= 99 && LA112_0 <= 100)||(LA112_0 >= 122 && LA112_0 <= 124)) ) {
				alt112=1;
			}
			else if ( (LA112_0==103) ) {
				int LA112_2 = input.LA(2);
				if ( (LA112_2==SUM) ) {
					alt112=1;
				}
				else if ( ((LA112_2 >= ACOS && LA112_2 <= ACOT)||(LA112_2 >= ASIN && LA112_2 <= ATAN)||LA112_2==CFS_TAF||(LA112_2 >= COS && LA112_2 <= COT)||LA112_2==DAY||(LA112_2 >= EXCEEDANCE && LA112_2 <= EXCEEDANCE_TSI)||LA112_2==ID||LA112_2==INT||LA112_2==INT_word||LA112_2==LOG||(LA112_2 >= MAX && LA112_2 <= MIN)||LA112_2==MOD||LA112_2==MONTH||LA112_2==REAL||LA112_2==ROUND||LA112_2==SIN||(LA112_2 >= TAF_CFS && LA112_2 <= TAN)||LA112_2==WATERYEAR||(LA112_2 >= 99 && LA112_2 <= 100)||LA112_2==103||LA112_2==106||LA112_2==108||(LA112_2 >= 122 && LA112_2 <= 124)) ) {
					alt112=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 112, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 112, 0, input);
				throw nvae;
			}

			switch (alt112) {
				case 1 :
					// WreslPlus.g:938:9: atom
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_atom_in_expr_term4976);
					atom501=atom();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, atom501.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:939:9: '(' expr_add ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal502=(Token)match(input,103,FOLLOW_103_in_expr_term4986); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal502_tree = (CommonTree)adaptor.create(char_literal502);
					adaptor.addChild(root_0, char_literal502_tree);
					}

					pushFollow(FOLLOW_expr_add_in_expr_term4988);
					expr_add503=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add503.getTree());

					char_literal504=(Token)match(input,104,FOLLOW_104_in_expr_term4990); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal504_tree = (CommonTree)adaptor.create(char_literal504);
					adaptor.addChild(root_0, char_literal504_tree);
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
	// $ANTLR end "expr_term"


	public static class atom_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// WreslPlus.g:943:1: atom : ( number_p |v= varID | intrinsicFunc |s= specialVar | externalFunc |vf= varFunc |p= preCycleVar );
	public final WreslPlusParser.atom_return atom() throws RecognitionException {
		WreslPlusParser.atom_return retval = new WreslPlusParser.atom_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope v =null;
		ParserRuleReturnScope s =null;
		ParserRuleReturnScope vf =null;
		ParserRuleReturnScope p =null;
		ParserRuleReturnScope number_p505 =null;
		ParserRuleReturnScope intrinsicFunc506 =null;
		ParserRuleReturnScope externalFunc507 =null;


		try {
			// WreslPlus.g:944:5: ( number_p |v= varID | intrinsicFunc |s= specialVar | externalFunc |vf= varFunc |p= preCycleVar )
			int alt113=7;
			switch ( input.LA(1) ) {
			case INT:
			case REAL:
				{
				alt113=1;
				}
				break;
			case ID:
				{
				switch ( input.LA(2) ) {
				case 119:
					{
					alt113=7;
					}
					break;
				case EOF:
				case AND:
				case CASE:
				case DeviationPenalty:
				case DeviationTolerance:
				case KIND:
				case LHS:
				case LOWER:
				case NoSolver:
				case OR:
				case ORDER:
				case RHS:
				case SELECT:
				case SUM:
				case TIMESTEP:
				case UNITS:
				case UPPER:
				case USE:
				case VALUE:
				case VARIABLE:
				case 101:
				case 102:
				case 104:
				case 105:
				case 106:
				case 107:
				case 108:
				case 110:
				case 111:
				case 113:
				case 114:
				case 115:
				case 116:
				case 117:
				case 118:
				case 120:
				case 124:
				case 125:
				case 126:
					{
					alt113=2;
					}
					break;
				case 103:
					{
					alt113=6;
					}
					break;
				default:
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 113, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case ACOS:
			case ACOT:
			case ASIN:
			case ATAN:
			case CFS_TAF:
			case COS:
			case COT:
			case DAY:
			case EXCEEDANCE:
			case EXCEEDANCE_TSI:
			case INT_word:
			case LOG:
			case MAX:
			case MIN:
			case MOD:
			case MONTH:
			case ROUND:
			case SIN:
			case TAF_CFS:
			case TAN:
			case WATERYEAR:
			case 103:
			case 124:
				{
				alt113=3;
				}
				break;
			case 99:
			case 100:
			case 123:
				{
				alt113=4;
				}
				break;
			case 122:
				{
				alt113=5;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 113, 0, input);
				throw nvae;
			}
			switch (alt113) {
				case 1 :
					// WreslPlus.g:944:8: number_p
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_number_p_in_atom5013);
					number_p505=number_p();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, number_p505.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:945:8: v= varID
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_varID_in_atom5024);
					v=varID();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());

					if ( state.backtracking==0 ) {if (addDep) dependants.add((v!=null?input.toString(v.start,v.stop):null));}
					}
					break;
				case 3 :
					// WreslPlus.g:946:8: intrinsicFunc
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_intrinsicFunc_in_atom5037);
					intrinsicFunc506=intrinsicFunc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, intrinsicFunc506.getTree());

					}
					break;
				case 4 :
					// WreslPlus.g:948:8: s= specialVar
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_specialVar_in_atom5052);
					s=specialVar();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, s.getTree());

					if ( state.backtracking==0 ) {if (isParameter) dependants_notAllowed.add((s!=null?input.toString(s.start,s.stop):null));}
					}
					break;
				case 5 :
					// WreslPlus.g:949:8: externalFunc
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_externalFunc_in_atom5067);
					externalFunc507=externalFunc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, externalFunc507.getTree());

					}
					break;
				case 6 :
					// WreslPlus.g:950:8: vf= varFunc
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_varFunc_in_atom5078);
					vf=varFunc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, vf.getTree());

					if ( state.backtracking==0 ) {if (isParameter) dependants_notAllowed.add((vf!=null?input.toString(vf.start,vf.stop):null));}
					}
					break;
				case 7 :
					// WreslPlus.g:951:8: p= preCycleVar
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_preCycleVar_in_atom5099);
					p=preCycleVar();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, p.getTree());

					if ( state.backtracking==0 ) {if (isParameter) dependants_notAllowed.add((p!=null?input.toString(p.start,p.stop):null));}
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
	// $ANTLR end "atom"


	public static class specialVar_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "specialVar"
	// WreslPlus.g:954:1: specialVar : ( 'i' | '$m' | '$M' );
	public final WreslPlusParser.specialVar_return specialVar() throws RecognitionException {
		WreslPlusParser.specialVar_return retval = new WreslPlusParser.specialVar_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set508=null;

		CommonTree set508_tree=null;

		try {
			// WreslPlus.g:954:12: ( 'i' | '$m' | '$M' )
			// WreslPlus.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set508=input.LT(1);
			if ( (input.LA(1) >= 99 && input.LA(1) <= 100)||input.LA(1)==123 ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set508));
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
	// $ANTLR end "specialVar"


	public static class preCycleVar_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "preCycleVar"
	// WreslPlus.g:956:1: preCycleVar : (p1= preCycleVar_old |p2= preCycleVarIndex );
	public final WreslPlusParser.preCycleVar_return preCycleVar() throws RecognitionException {
		WreslPlusParser.preCycleVar_return retval = new WreslPlusParser.preCycleVar_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope p1 =null;
		ParserRuleReturnScope p2 =null;


		try {
			// WreslPlus.g:957:2: (p1= preCycleVar_old |p2= preCycleVarIndex )
			int alt114=2;
			int LA114_0 = input.LA(1);
			if ( (LA114_0==ID) ) {
				int LA114_1 = input.LA(2);
				if ( (LA114_1==119) ) {
					int LA114_2 = input.LA(3);
					if ( (LA114_2==ID) ) {
						alt114=1;
					}
					else if ( (LA114_2==108) ) {
						alt114=2;
					}

					else {
						if (state.backtracking>0) {state.failed=true; return retval;}
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 114, 2, input);
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
							new NoViableAltException("", 114, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 114, 0, input);
				throw nvae;
			}

			switch (alt114) {
				case 1 :
					// WreslPlus.g:957:5: p1= preCycleVar_old
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_preCycleVar_old_in_preCycleVar5138);
					p1=preCycleVar_old();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, p1.getTree());

					if ( state.backtracking==0 ) {varInCycle.add((p1!=null?input.toString(p1.start,p1.stop):null));}
					}
					break;
				case 2 :
					// WreslPlus.g:957:54: p2= preCycleVarIndex
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_preCycleVarIndex_in_preCycleVar5146);
					p2=preCycleVarIndex();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, p2.getTree());

					if ( state.backtracking==0 ) {varInCycle.add((p2!=null?input.toString(p2.start,p2.stop):null));}
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
	// $ANTLR end "preCycleVar"


	public static class preCycleVar_old_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "preCycleVar_old"
	// WreslPlus.g:960:1: preCycleVar_old : var= ID '[' cycle= ID ']' ( '(' e= expr_add ')' )? ;
	public final WreslPlusParser.preCycleVar_old_return preCycleVar_old() throws RecognitionException {
		WreslPlusParser.preCycleVar_old_return retval = new WreslPlusParser.preCycleVar_old_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token var=null;
		Token cycle=null;
		Token char_literal509=null;
		Token char_literal510=null;
		Token char_literal511=null;
		Token char_literal512=null;
		ParserRuleReturnScope e =null;

		CommonTree var_tree=null;
		CommonTree cycle_tree=null;
		CommonTree char_literal509_tree=null;
		CommonTree char_literal510_tree=null;
		CommonTree char_literal511_tree=null;
		CommonTree char_literal512_tree=null;

		try {
			// WreslPlus.g:960:17: (var= ID '[' cycle= ID ']' ( '(' e= expr_add ')' )? )
			// WreslPlus.g:960:20: var= ID '[' cycle= ID ']' ( '(' e= expr_add ')' )?
			{
			root_0 = (CommonTree)adaptor.nil();


			var=(Token)match(input,ID,FOLLOW_ID_in_preCycleVar_old5161); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			var_tree = (CommonTree)adaptor.create(var);
			adaptor.addChild(root_0, var_tree);
			}

			char_literal509=(Token)match(input,119,FOLLOW_119_in_preCycleVar_old5163); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal509_tree = (CommonTree)adaptor.create(char_literal509);
			adaptor.addChild(root_0, char_literal509_tree);
			}

			cycle=(Token)match(input,ID,FOLLOW_ID_in_preCycleVar_old5167); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			cycle_tree = (CommonTree)adaptor.create(cycle);
			adaptor.addChild(root_0, cycle_tree);
			}

			char_literal510=(Token)match(input,120,FOLLOW_120_in_preCycleVar_old5169); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal510_tree = (CommonTree)adaptor.create(char_literal510);
			adaptor.addChild(root_0, char_literal510_tree);
			}

			// WreslPlus.g:960:44: ( '(' e= expr_add ')' )?
			int alt115=2;
			int LA115_0 = input.LA(1);
			if ( (LA115_0==103) ) {
				alt115=1;
			}
			switch (alt115) {
				case 1 :
					// WreslPlus.g:960:45: '(' e= expr_add ')'
					{
					char_literal511=(Token)match(input,103,FOLLOW_103_in_preCycleVar_old5172); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal511_tree = (CommonTree)adaptor.create(char_literal511);
					adaptor.addChild(root_0, char_literal511_tree);
					}

					pushFollow(FOLLOW_expr_add_in_preCycleVar_old5176);
					e=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

					char_literal512=(Token)match(input,104,FOLLOW_104_in_preCycleVar_old5178); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal512_tree = (CommonTree)adaptor.create(char_literal512);
					adaptor.addChild(root_0, char_literal512_tree);
					}

					}
					break;

			}

			if ( state.backtracking==0 ) { 
			  // TODO: don't convert to lower case here!
			  if (!isParameter){
			    String cnl = (cycle!=null?cycle.getText():null).toLowerCase();
			    String vl = (var!=null?var.getText():null).toLowerCase();
			    if (neededCycleVarMap.keySet().contains(cnl)) {
			      neededCycleVarMap.get(cnl).add(vl);
			    } else {
			      HashSet<String> t = new HashSet<String>();
			      t.add(vl);
			      neededCycleVarMap.put(cnl, t);
			    }
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
	// $ANTLR end "preCycleVar_old"


	public static class preCycleVarIndex_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "preCycleVarIndex"
	// WreslPlus.g:976:1: preCycleVarIndex : var= ID '[' '-' INT ']' ( '(' e= expr_add ')' )? ;
	public final WreslPlusParser.preCycleVarIndex_return preCycleVarIndex() throws RecognitionException {
		WreslPlusParser.preCycleVarIndex_return retval = new WreslPlusParser.preCycleVarIndex_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token var=null;
		Token char_literal513=null;
		Token char_literal514=null;
		Token INT515=null;
		Token char_literal516=null;
		Token char_literal517=null;
		Token char_literal518=null;
		ParserRuleReturnScope e =null;

		CommonTree var_tree=null;
		CommonTree char_literal513_tree=null;
		CommonTree char_literal514_tree=null;
		CommonTree INT515_tree=null;
		CommonTree char_literal516_tree=null;
		CommonTree char_literal517_tree=null;
		CommonTree char_literal518_tree=null;

		try {
			// WreslPlus.g:976:18: (var= ID '[' '-' INT ']' ( '(' e= expr_add ')' )? )
			// WreslPlus.g:976:21: var= ID '[' '-' INT ']' ( '(' e= expr_add ')' )?
			{
			root_0 = (CommonTree)adaptor.nil();


			var=(Token)match(input,ID,FOLLOW_ID_in_preCycleVarIndex5195); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			var_tree = (CommonTree)adaptor.create(var);
			adaptor.addChild(root_0, var_tree);
			}

			char_literal513=(Token)match(input,119,FOLLOW_119_in_preCycleVarIndex5197); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal513_tree = (CommonTree)adaptor.create(char_literal513);
			adaptor.addChild(root_0, char_literal513_tree);
			}

			char_literal514=(Token)match(input,108,FOLLOW_108_in_preCycleVarIndex5199); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal514_tree = (CommonTree)adaptor.create(char_literal514);
			adaptor.addChild(root_0, char_literal514_tree);
			}

			INT515=(Token)match(input,INT,FOLLOW_INT_in_preCycleVarIndex5201); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INT515_tree = (CommonTree)adaptor.create(INT515);
			adaptor.addChild(root_0, INT515_tree);
			}

			char_literal516=(Token)match(input,120,FOLLOW_120_in_preCycleVarIndex5203); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal516_tree = (CommonTree)adaptor.create(char_literal516);
			adaptor.addChild(root_0, char_literal516_tree);
			}

			// WreslPlus.g:976:44: ( '(' e= expr_add ')' )?
			int alt116=2;
			int LA116_0 = input.LA(1);
			if ( (LA116_0==103) ) {
				alt116=1;
			}
			switch (alt116) {
				case 1 :
					// WreslPlus.g:976:45: '(' e= expr_add ')'
					{
					char_literal517=(Token)match(input,103,FOLLOW_103_in_preCycleVarIndex5206); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal517_tree = (CommonTree)adaptor.create(char_literal517);
					adaptor.addChild(root_0, char_literal517_tree);
					}

					pushFollow(FOLLOW_expr_add_in_preCycleVarIndex5210);
					e=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());

					char_literal518=(Token)match(input,104,FOLLOW_104_in_preCycleVarIndex5212); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal518_tree = (CommonTree)adaptor.create(char_literal518);
					adaptor.addChild(root_0, char_literal518_tree);
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {
			  if (!VarCycleIndex.varCycleIndexList.contains((var!=null?var.getText():null))){
			    VarCycleIndex.varCycleIndexList.add((var!=null?var.getText():null).toLowerCase());
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
	// $ANTLR end "preCycleVarIndex"


	public static class externalFunc_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "externalFunc"
	// WreslPlus.g:982:1: externalFunc : 'extern:(' ID '(' expr_add ')' ')' ;
	public final WreslPlusParser.externalFunc_return externalFunc() throws RecognitionException {
		WreslPlusParser.externalFunc_return retval = new WreslPlusParser.externalFunc_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal519=null;
		Token ID520=null;
		Token char_literal521=null;
		Token char_literal523=null;
		Token char_literal524=null;
		ParserRuleReturnScope expr_add522 =null;

		CommonTree string_literal519_tree=null;
		CommonTree ID520_tree=null;
		CommonTree char_literal521_tree=null;
		CommonTree char_literal523_tree=null;
		CommonTree char_literal524_tree=null;

		try {
			// WreslPlus.g:983:2: ( 'extern:(' ID '(' expr_add ')' ')' )
			// WreslPlus.g:983:5: 'extern:(' ID '(' expr_add ')' ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal519=(Token)match(input,122,FOLLOW_122_in_externalFunc5227); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal519_tree = (CommonTree)adaptor.create(string_literal519);
			adaptor.addChild(root_0, string_literal519_tree);
			}

			ID520=(Token)match(input,ID,FOLLOW_ID_in_externalFunc5229); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID520_tree = (CommonTree)adaptor.create(ID520);
			adaptor.addChild(root_0, ID520_tree);
			}

			char_literal521=(Token)match(input,103,FOLLOW_103_in_externalFunc5231); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal521_tree = (CommonTree)adaptor.create(char_literal521);
			adaptor.addChild(root_0, char_literal521_tree);
			}

			pushFollow(FOLLOW_expr_add_in_externalFunc5233);
			expr_add522=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add522.getTree());

			char_literal523=(Token)match(input,104,FOLLOW_104_in_externalFunc5235); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal523_tree = (CommonTree)adaptor.create(char_literal523);
			adaptor.addChild(root_0, char_literal523_tree);
			}

			char_literal524=(Token)match(input,104,FOLLOW_104_in_externalFunc5237); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal524_tree = (CommonTree)adaptor.create(char_literal524);
			adaptor.addChild(root_0, char_literal524_tree);
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
	// $ANTLR end "externalFunc"


	public static class intrinsicFunc_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "intrinsicFunc"
	// WreslPlus.g:985:1: intrinsicFunc : ( mathFunc | multiInputFunc | unitFunc | tableFunc | timeFunc | sumFunc );
	public final WreslPlusParser.intrinsicFunc_return intrinsicFunc() throws RecognitionException {
		WreslPlusParser.intrinsicFunc_return retval = new WreslPlusParser.intrinsicFunc_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope mathFunc525 =null;
		ParserRuleReturnScope multiInputFunc526 =null;
		ParserRuleReturnScope unitFunc527 =null;
		ParserRuleReturnScope tableFunc528 =null;
		ParserRuleReturnScope timeFunc529 =null;
		ParserRuleReturnScope sumFunc530 =null;


		try {
			// WreslPlus.g:986:2: ( mathFunc | multiInputFunc | unitFunc | tableFunc | timeFunc | sumFunc )
			int alt117=6;
			switch ( input.LA(1) ) {
			case ACOS:
			case ACOT:
			case ASIN:
			case ATAN:
			case COS:
			case COT:
			case EXCEEDANCE:
			case EXCEEDANCE_TSI:
			case INT_word:
			case LOG:
			case MOD:
			case ROUND:
			case SIN:
			case TAN:
				{
				alt117=1;
				}
				break;
			case MAX:
			case MIN:
				{
				alt117=2;
				}
				break;
			case CFS_TAF:
			case TAF_CFS:
				{
				alt117=3;
				}
				break;
			case 124:
				{
				alt117=4;
				}
				break;
			case DAY:
			case MONTH:
			case WATERYEAR:
				{
				alt117=5;
				}
				break;
			case 103:
				{
				alt117=6;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 117, 0, input);
				throw nvae;
			}
			switch (alt117) {
				case 1 :
					// WreslPlus.g:986:4: mathFunc
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_mathFunc_in_intrinsicFunc5247);
					mathFunc525=mathFunc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, mathFunc525.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:987:4: multiInputFunc
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_multiInputFunc_in_intrinsicFunc5253);
					multiInputFunc526=multiInputFunc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, multiInputFunc526.getTree());

					}
					break;
				case 3 :
					// WreslPlus.g:988:4: unitFunc
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_unitFunc_in_intrinsicFunc5258);
					unitFunc527=unitFunc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, unitFunc527.getTree());

					}
					break;
				case 4 :
					// WreslPlus.g:989:4: tableFunc
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_tableFunc_in_intrinsicFunc5263);
					tableFunc528=tableFunc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, tableFunc528.getTree());

					}
					break;
				case 5 :
					// WreslPlus.g:990:4: timeFunc
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_timeFunc_in_intrinsicFunc5268);
					timeFunc529=timeFunc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, timeFunc529.getTree());

					}
					break;
				case 6 :
					// WreslPlus.g:991:4: sumFunc
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_sumFunc_in_intrinsicFunc5273);
					sumFunc530=sumFunc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, sumFunc530.getTree());

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
	// $ANTLR end "intrinsicFunc"


	public static class sumFunc_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "sumFunc"
	// WreslPlus.g:994:1: sumFunc : '(' sum_header sum_content ')' ;
	public final WreslPlusParser.sumFunc_return sumFunc() throws RecognitionException {
		WreslPlusParser.sumFunc_return retval = new WreslPlusParser.sumFunc_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal531=null;
		Token char_literal534=null;
		ParserRuleReturnScope sum_header532 =null;
		ParserRuleReturnScope sum_content533 =null;

		CommonTree char_literal531_tree=null;
		CommonTree char_literal534_tree=null;

		try {
			// WreslPlus.g:994:8: ( '(' sum_header sum_content ')' )
			// WreslPlus.g:994:10: '(' sum_header sum_content ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal531=(Token)match(input,103,FOLLOW_103_in_sumFunc5283); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal531_tree = (CommonTree)adaptor.create(char_literal531);
			adaptor.addChild(root_0, char_literal531_tree);
			}

			pushFollow(FOLLOW_sum_header_in_sumFunc5285);
			sum_header532=sum_header();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, sum_header532.getTree());

			pushFollow(FOLLOW_sum_content_in_sumFunc5287);
			sum_content533=sum_content();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, sum_content533.getTree());

			char_literal534=(Token)match(input,104,FOLLOW_104_in_sumFunc5289); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal534_tree = (CommonTree)adaptor.create(char_literal534);
			adaptor.addChild(root_0, char_literal534_tree);
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
	// $ANTLR end "sumFunc"


	public static class timeFunc_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "timeFunc"
	// WreslPlus.g:996:1: timeFunc : ( DAY | MONTH | WATERYEAR ) ( '(' expr_add ')' )? ;
	public final WreslPlusParser.timeFunc_return timeFunc() throws RecognitionException {
		WreslPlusParser.timeFunc_return retval = new WreslPlusParser.timeFunc_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set535=null;
		Token char_literal536=null;
		Token char_literal538=null;
		ParserRuleReturnScope expr_add537 =null;

		CommonTree set535_tree=null;
		CommonTree char_literal536_tree=null;
		CommonTree char_literal538_tree=null;

		try {
			// WreslPlus.g:996:9: ( ( DAY | MONTH | WATERYEAR ) ( '(' expr_add ')' )? )
			// WreslPlus.g:996:12: ( DAY | MONTH | WATERYEAR ) ( '(' expr_add ')' )?
			{
			root_0 = (CommonTree)adaptor.nil();


			set535=input.LT(1);
			if ( input.LA(1)==DAY||input.LA(1)==MONTH||input.LA(1)==WATERYEAR ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set535));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			// WreslPlus.g:996:40: ( '(' expr_add ')' )?
			int alt118=2;
			int LA118_0 = input.LA(1);
			if ( (LA118_0==103) ) {
				alt118=1;
			}
			switch (alt118) {
				case 1 :
					// WreslPlus.g:996:42: '(' expr_add ')'
					{
					char_literal536=(Token)match(input,103,FOLLOW_103_in_timeFunc5314); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal536_tree = (CommonTree)adaptor.create(char_literal536);
					adaptor.addChild(root_0, char_literal536_tree);
					}

					pushFollow(FOLLOW_expr_add_in_timeFunc5316);
					expr_add537=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add537.getTree());

					char_literal538=(Token)match(input,104,FOLLOW_104_in_timeFunc5318); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal538_tree = (CommonTree)adaptor.create(char_literal538);
					adaptor.addChild(root_0, char_literal538_tree);
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
	// $ANTLR end "timeFunc"


	public static class tableFunc_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tableFunc"
	// WreslPlus.g:998:1: tableFunc : 'table' '(' tableName ',' columnNumber ',' rowNumber ')' ;
	public final WreslPlusParser.tableFunc_return tableFunc() throws RecognitionException {
		WreslPlusParser.tableFunc_return retval = new WreslPlusParser.tableFunc_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal539=null;
		Token char_literal540=null;
		Token char_literal542=null;
		Token char_literal544=null;
		Token char_literal546=null;
		ParserRuleReturnScope tableName541 =null;
		ParserRuleReturnScope columnNumber543 =null;
		ParserRuleReturnScope rowNumber545 =null;

		CommonTree string_literal539_tree=null;
		CommonTree char_literal540_tree=null;
		CommonTree char_literal542_tree=null;
		CommonTree char_literal544_tree=null;
		CommonTree char_literal546_tree=null;

		try {
			// WreslPlus.g:998:11: ( 'table' '(' tableName ',' columnNumber ',' rowNumber ')' )
			// WreslPlus.g:998:13: 'table' '(' tableName ',' columnNumber ',' rowNumber ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal539=(Token)match(input,124,FOLLOW_124_in_tableFunc5330); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			string_literal539_tree = (CommonTree)adaptor.create(string_literal539);
			adaptor.addChild(root_0, string_literal539_tree);
			}

			char_literal540=(Token)match(input,103,FOLLOW_103_in_tableFunc5332); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal540_tree = (CommonTree)adaptor.create(char_literal540);
			adaptor.addChild(root_0, char_literal540_tree);
			}

			pushFollow(FOLLOW_tableName_in_tableFunc5334);
			tableName541=tableName();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, tableName541.getTree());

			char_literal542=(Token)match(input,107,FOLLOW_107_in_tableFunc5336); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal542_tree = (CommonTree)adaptor.create(char_literal542);
			adaptor.addChild(root_0, char_literal542_tree);
			}

			pushFollow(FOLLOW_columnNumber_in_tableFunc5338);
			columnNumber543=columnNumber();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, columnNumber543.getTree());

			char_literal544=(Token)match(input,107,FOLLOW_107_in_tableFunc5340); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal544_tree = (CommonTree)adaptor.create(char_literal544);
			adaptor.addChild(root_0, char_literal544_tree);
			}

			pushFollow(FOLLOW_rowNumber_in_tableFunc5342);
			rowNumber545=rowNumber();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, rowNumber545.getTree());

			char_literal546=(Token)match(input,104,FOLLOW_104_in_tableFunc5344); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal546_tree = (CommonTree)adaptor.create(char_literal546);
			adaptor.addChild(root_0, char_literal546_tree);
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
	// $ANTLR end "tableFunc"


	public static class tableName_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tableName"
	// WreslPlus.g:1000:1: tableName : ID ;
	public final WreslPlusParser.tableName_return tableName() throws RecognitionException {
		WreslPlusParser.tableName_return retval = new WreslPlusParser.tableName_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID547=null;

		CommonTree ID547_tree=null;

		try {
			// WreslPlus.g:1000:11: ( ID )
			// WreslPlus.g:1000:13: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			ID547=(Token)match(input,ID,FOLLOW_ID_in_tableName5353); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID547_tree = (CommonTree)adaptor.create(ID547);
			adaptor.addChild(root_0, ID547_tree);
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
	// $ANTLR end "tableName"


	public static class columnNumber_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "columnNumber"
	// WreslPlus.g:1001:1: columnNumber : INT ;
	public final WreslPlusParser.columnNumber_return columnNumber() throws RecognitionException {
		WreslPlusParser.columnNumber_return retval = new WreslPlusParser.columnNumber_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INT548=null;

		CommonTree INT548_tree=null;

		try {
			// WreslPlus.g:1001:14: ( INT )
			// WreslPlus.g:1001:16: INT
			{
			root_0 = (CommonTree)adaptor.nil();


			INT548=(Token)match(input,INT,FOLLOW_INT_in_columnNumber5361); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INT548_tree = (CommonTree)adaptor.create(INT548);
			adaptor.addChild(root_0, INT548_tree);
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
	// $ANTLR end "columnNumber"


	public static class rowNumber_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "rowNumber"
	// WreslPlus.g:1002:1: rowNumber : INT ;
	public final WreslPlusParser.rowNumber_return rowNumber() throws RecognitionException {
		WreslPlusParser.rowNumber_return retval = new WreslPlusParser.rowNumber_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INT549=null;

		CommonTree INT549_tree=null;

		try {
			// WreslPlus.g:1002:11: ( INT )
			// WreslPlus.g:1002:13: INT
			{
			root_0 = (CommonTree)adaptor.nil();


			INT549=(Token)match(input,INT,FOLLOW_INT_in_rowNumber5369); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INT549_tree = (CommonTree)adaptor.create(INT549);
			adaptor.addChild(root_0, INT549_tree);
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
	// $ANTLR end "rowNumber"


	public static class varFunc_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "varFunc"
	// WreslPlus.g:1004:1: varFunc : v= varID '(' func_arg ( ',' func_arg )* ')' ( '(' expr_add ')' )? ;
	public final WreslPlusParser.varFunc_return varFunc() throws RecognitionException {
		WreslPlusParser.varFunc_return retval = new WreslPlusParser.varFunc_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal550=null;
		Token char_literal552=null;
		Token char_literal554=null;
		Token char_literal555=null;
		Token char_literal557=null;
		ParserRuleReturnScope v =null;
		ParserRuleReturnScope func_arg551 =null;
		ParserRuleReturnScope func_arg553 =null;
		ParserRuleReturnScope expr_add556 =null;

		CommonTree char_literal550_tree=null;
		CommonTree char_literal552_tree=null;
		CommonTree char_literal554_tree=null;
		CommonTree char_literal555_tree=null;
		CommonTree char_literal557_tree=null;

		try {
			// WreslPlus.g:1005:2: (v= varID '(' func_arg ( ',' func_arg )* ')' ( '(' expr_add ')' )? )
			// WreslPlus.g:1005:4: v= varID '(' func_arg ( ',' func_arg )* ')' ( '(' expr_add ')' )?
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_varID_in_varFunc5382);
			v=varID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());

			char_literal550=(Token)match(input,103,FOLLOW_103_in_varFunc5384); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal550_tree = (CommonTree)adaptor.create(char_literal550);
			adaptor.addChild(root_0, char_literal550_tree);
			}

			pushFollow(FOLLOW_func_arg_in_varFunc5386);
			func_arg551=func_arg();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, func_arg551.getTree());

			// WreslPlus.g:1005:26: ( ',' func_arg )*
			loop119:
			while (true) {
				int alt119=2;
				int LA119_0 = input.LA(1);
				if ( (LA119_0==107) ) {
					alt119=1;
				}

				switch (alt119) {
				case 1 :
					// WreslPlus.g:1005:27: ',' func_arg
					{
					char_literal552=(Token)match(input,107,FOLLOW_107_in_varFunc5390); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal552_tree = (CommonTree)adaptor.create(char_literal552);
					adaptor.addChild(root_0, char_literal552_tree);
					}

					pushFollow(FOLLOW_func_arg_in_varFunc5392);
					func_arg553=func_arg();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, func_arg553.getTree());

					}
					break;

				default :
					break loop119;
				}
			}

			char_literal554=(Token)match(input,104,FOLLOW_104_in_varFunc5399); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal554_tree = (CommonTree)adaptor.create(char_literal554);
			adaptor.addChild(root_0, char_literal554_tree);
			}

			// WreslPlus.g:1005:50: ( '(' expr_add ')' )?
			int alt120=2;
			int LA120_0 = input.LA(1);
			if ( (LA120_0==103) ) {
				alt120=1;
			}
			switch (alt120) {
				case 1 :
					// WreslPlus.g:1005:51: '(' expr_add ')'
					{
					char_literal555=(Token)match(input,103,FOLLOW_103_in_varFunc5403); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal555_tree = (CommonTree)adaptor.create(char_literal555);
					adaptor.addChild(root_0, char_literal555_tree);
					}

					pushFollow(FOLLOW_expr_add_in_varFunc5405);
					expr_add556=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add556.getTree());

					char_literal557=(Token)match(input,104,FOLLOW_104_in_varFunc5407); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal557_tree = (CommonTree)adaptor.create(char_literal557);
					adaptor.addChild(root_0, char_literal557_tree);
					}

					}
					break;

			}

			if ( state.backtracking==0 ) {dependants.add((v!=null?input.toString(v.start,v.stop):null));
				 //System.out.println(dependants);
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
	// $ANTLR end "varFunc"


	public static class varID_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "varID"
	// WreslPlus.g:1011:1: varID : ID ;
	public final WreslPlusParser.varID_return varID() throws RecognitionException {
		WreslPlusParser.varID_return retval = new WreslPlusParser.varID_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID558=null;

		CommonTree ID558_tree=null;

		try {
			// WreslPlus.g:1011:7: ( ID )
			// WreslPlus.g:1011:9: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			ID558=(Token)match(input,ID,FOLLOW_ID_in_varID5422); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID558_tree = (CommonTree)adaptor.create(ID558);
			adaptor.addChild(root_0, ID558_tree);
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
	// $ANTLR end "varID"


	public static class func_arg_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "func_arg"
	// WreslPlus.g:1013:1: func_arg : ( expr_add | trunk_timeArray );
	public final WreslPlusParser.func_arg_return func_arg() throws RecognitionException {
		WreslPlusParser.func_arg_return retval = new WreslPlusParser.func_arg_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope expr_add559 =null;
		ParserRuleReturnScope trunk_timeArray560 =null;


		try {
			// WreslPlus.g:1013:9: ( expr_add | trunk_timeArray )
			int alt121=2;
			int LA121_0 = input.LA(1);
			if ( ((LA121_0 >= ACOS && LA121_0 <= ACOT)||(LA121_0 >= ASIN && LA121_0 <= ATAN)||LA121_0==CFS_TAF||(LA121_0 >= COS && LA121_0 <= COT)||LA121_0==DAY||(LA121_0 >= EXCEEDANCE && LA121_0 <= EXCEEDANCE_TSI)||LA121_0==INT||LA121_0==INT_word||LA121_0==LOG||(LA121_0 >= MAX && LA121_0 <= MIN)||LA121_0==MOD||LA121_0==MONTH||LA121_0==REAL||LA121_0==ROUND||LA121_0==SIN||(LA121_0 >= TAF_CFS && LA121_0 <= TAN)||LA121_0==WATERYEAR||(LA121_0 >= 99 && LA121_0 <= 100)||LA121_0==103||LA121_0==106||LA121_0==108||(LA121_0 >= 122 && LA121_0 <= 124)) ) {
				alt121=1;
			}
			else if ( (LA121_0==ID) ) {
				int LA121_2 = input.LA(2);
				if ( ((LA121_2 >= 104 && LA121_2 <= 108)||LA121_2==110||LA121_2==119) ) {
					alt121=1;
				}
				else if ( (LA121_2==103) ) {
					switch ( input.LA(3) ) {
					case 108:
						{
						int LA121_4 = input.LA(4);
						if ( (LA121_4==INT) ) {
							int LA121_7 = input.LA(5);
							if ( (LA121_7==112) ) {
								alt121=2;
							}
							else if ( ((LA121_7 >= 104 && LA121_7 <= 108)||LA121_7==110) ) {
								alt121=1;
							}

							else {
								if (state.backtracking>0) {state.failed=true; return retval;}
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 121, 7, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}
						else if ( ((LA121_4 >= ACOS && LA121_4 <= ACOT)||(LA121_4 >= ASIN && LA121_4 <= ATAN)||LA121_4==CFS_TAF||(LA121_4 >= COS && LA121_4 <= COT)||LA121_4==DAY||(LA121_4 >= EXCEEDANCE && LA121_4 <= EXCEEDANCE_TSI)||LA121_4==ID||LA121_4==INT_word||LA121_4==LOG||(LA121_4 >= MAX && LA121_4 <= MIN)||LA121_4==MOD||LA121_4==MONTH||LA121_4==REAL||LA121_4==ROUND||LA121_4==SIN||(LA121_4 >= TAF_CFS && LA121_4 <= TAN)||LA121_4==WATERYEAR||(LA121_4 >= 99 && LA121_4 <= 100)||LA121_4==103||(LA121_4 >= 122 && LA121_4 <= 124)) ) {
							alt121=1;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 121, 4, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case INT:
						{
						int LA121_5 = input.LA(4);
						if ( ((LA121_5 >= 104 && LA121_5 <= 108)||LA121_5==110) ) {
							alt121=1;
						}
						else if ( (LA121_5==112) ) {
							alt121=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 121, 5, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

						}
						break;
					case ACOS:
					case ACOT:
					case ASIN:
					case ATAN:
					case CFS_TAF:
					case COS:
					case COT:
					case DAY:
					case EXCEEDANCE:
					case EXCEEDANCE_TSI:
					case INT_word:
					case LOG:
					case MAX:
					case MIN:
					case MOD:
					case MONTH:
					case REAL:
					case ROUND:
					case SIN:
					case TAF_CFS:
					case TAN:
					case WATERYEAR:
					case 99:
					case 100:
					case 103:
					case 106:
					case 122:
					case 123:
					case 124:
						{
						alt121=1;
						}
						break;
					case ID:
						{
						int LA121_6 = input.LA(4);
						if ( ((LA121_6 >= 103 && LA121_6 <= 108)||LA121_6==110||LA121_6==119) ) {
							alt121=1;
						}
						else if ( (LA121_6==112) ) {
							alt121=2;
						}

						else {
							if (state.backtracking>0) {state.failed=true; return retval;}
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 121, 6, input);
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
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 121, 3, input);
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
							new NoViableAltException("", 121, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 121, 0, input);
				throw nvae;
			}

			switch (alt121) {
				case 1 :
					// WreslPlus.g:1013:11: expr_add
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_expr_add_in_func_arg5430);
					expr_add559=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add559.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:1013:20: trunk_timeArray
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_trunk_timeArray_in_func_arg5432);
					trunk_timeArray560=trunk_timeArray();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, trunk_timeArray560.getTree());

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
	// $ANTLR end "func_arg"


	public static class trunk_timeArray_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "trunk_timeArray"
	// WreslPlus.g:1015:1: trunk_timeArray : v1= varID '(' ( integer |v2= varID ) ':' ( integer |v3= varID ) ')' ;
	public final WreslPlusParser.trunk_timeArray_return trunk_timeArray() throws RecognitionException {
		WreslPlusParser.trunk_timeArray_return retval = new WreslPlusParser.trunk_timeArray_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal561=null;
		Token char_literal563=null;
		Token char_literal565=null;
		ParserRuleReturnScope v1 =null;
		ParserRuleReturnScope v2 =null;
		ParserRuleReturnScope v3 =null;
		ParserRuleReturnScope integer562 =null;
		ParserRuleReturnScope integer564 =null;

		CommonTree char_literal561_tree=null;
		CommonTree char_literal563_tree=null;
		CommonTree char_literal565_tree=null;

		try {
			// WreslPlus.g:1016:3: (v1= varID '(' ( integer |v2= varID ) ':' ( integer |v3= varID ) ')' )
			// WreslPlus.g:1016:5: v1= varID '(' ( integer |v2= varID ) ':' ( integer |v3= varID ) ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_varID_in_trunk_timeArray5444);
			v1=varID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, v1.getTree());

			char_literal561=(Token)match(input,103,FOLLOW_103_in_trunk_timeArray5446); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal561_tree = (CommonTree)adaptor.create(char_literal561);
			adaptor.addChild(root_0, char_literal561_tree);
			}

			// WreslPlus.g:1016:18: ( integer |v2= varID )
			int alt122=2;
			int LA122_0 = input.LA(1);
			if ( (LA122_0==INT||LA122_0==108) ) {
				alt122=1;
			}
			else if ( (LA122_0==ID) ) {
				alt122=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 122, 0, input);
				throw nvae;
			}

			switch (alt122) {
				case 1 :
					// WreslPlus.g:1016:19: integer
					{
					pushFollow(FOLLOW_integer_in_trunk_timeArray5449);
					integer562=integer();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, integer562.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:1016:27: v2= varID
					{
					pushFollow(FOLLOW_varID_in_trunk_timeArray5453);
					v2=varID();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, v2.getTree());

					if ( state.backtracking==0 ) {dependants.add((v2!=null?input.toString(v2.start,v2.stop):null));}
					}
					break;

			}

			char_literal563=(Token)match(input,112,FOLLOW_112_in_trunk_timeArray5457); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal563_tree = (CommonTree)adaptor.create(char_literal563);
			adaptor.addChild(root_0, char_literal563_tree);
			}

			// WreslPlus.g:1016:68: ( integer |v3= varID )
			int alt123=2;
			int LA123_0 = input.LA(1);
			if ( (LA123_0==INT||LA123_0==108) ) {
				alt123=1;
			}
			else if ( (LA123_0==ID) ) {
				alt123=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 123, 0, input);
				throw nvae;
			}

			switch (alt123) {
				case 1 :
					// WreslPlus.g:1016:69: integer
					{
					pushFollow(FOLLOW_integer_in_trunk_timeArray5460);
					integer564=integer();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, integer564.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:1016:77: v3= varID
					{
					pushFollow(FOLLOW_varID_in_trunk_timeArray5464);
					v3=varID();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, v3.getTree());

					if ( state.backtracking==0 ) {dependants.add((v3!=null?input.toString(v3.start,v3.stop):null));}
					}
					break;

			}

			char_literal565=(Token)match(input,104,FOLLOW_104_in_trunk_timeArray5468); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal565_tree = (CommonTree)adaptor.create(char_literal565);
			adaptor.addChild(root_0, char_literal565_tree);
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
	// $ANTLR end "trunk_timeArray"


	public static class number_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "number"
	// WreslPlus.g:1018:1: number : ( integer | real );
	public final WreslPlusParser.number_return number() throws RecognitionException {
		WreslPlusParser.number_return retval = new WreslPlusParser.number_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope integer566 =null;
		ParserRuleReturnScope real567 =null;


		try {
			// WreslPlus.g:1018:8: ( integer | real )
			int alt124=2;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt124=1;
				}
				break;
			case 108:
				{
				int LA124_2 = input.LA(2);
				if ( (LA124_2==INT) ) {
					alt124=1;
				}
				else if ( (LA124_2==REAL) ) {
					alt124=2;
				}

				else {
					if (state.backtracking>0) {state.failed=true; return retval;}
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 124, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case REAL:
				{
				alt124=2;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 124, 0, input);
				throw nvae;
			}
			switch (alt124) {
				case 1 :
					// WreslPlus.g:1018:10: integer
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_integer_in_number5479);
					integer566=integer();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, integer566.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:1018:20: real
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_real_in_number5483);
					real567=real();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, real567.getTree());

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
	// $ANTLR end "number"


	public static class number_p_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "number_p"
	// WreslPlus.g:1019:1: number_p : ( integer_p | real_p );
	public final WreslPlusParser.number_p_return number_p() throws RecognitionException {
		WreslPlusParser.number_p_return retval = new WreslPlusParser.number_p_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope integer_p568 =null;
		ParserRuleReturnScope real_p569 =null;


		try {
			// WreslPlus.g:1019:10: ( integer_p | real_p )
			int alt125=2;
			int LA125_0 = input.LA(1);
			if ( (LA125_0==INT) ) {
				alt125=1;
			}
			else if ( (LA125_0==REAL) ) {
				alt125=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 125, 0, input);
				throw nvae;
			}

			switch (alt125) {
				case 1 :
					// WreslPlus.g:1019:12: integer_p
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_integer_p_in_number_p5491);
					integer_p568=integer_p();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, integer_p568.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:1019:24: real_p
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_real_p_in_number_p5495);
					real_p569=real_p();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, real_p569.getTree());

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
	// $ANTLR end "number_p"


	public static class integer_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "integer"
	// WreslPlus.g:1021:1: integer : ( integer_p | integer_n );
	public final WreslPlusParser.integer_return integer() throws RecognitionException {
		WreslPlusParser.integer_return retval = new WreslPlusParser.integer_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope integer_p570 =null;
		ParserRuleReturnScope integer_n571 =null;


		try {
			// WreslPlus.g:1021:9: ( integer_p | integer_n )
			int alt126=2;
			int LA126_0 = input.LA(1);
			if ( (LA126_0==INT) ) {
				alt126=1;
			}
			else if ( (LA126_0==108) ) {
				alt126=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 126, 0, input);
				throw nvae;
			}

			switch (alt126) {
				case 1 :
					// WreslPlus.g:1021:11: integer_p
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_integer_p_in_integer5504);
					integer_p570=integer_p();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, integer_p570.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:1021:21: integer_n
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_integer_n_in_integer5506);
					integer_n571=integer_n();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, integer_n571.getTree());

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


	public static class real_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "real"
	// WreslPlus.g:1022:1: real : ( real_p | real_n );
	public final WreslPlusParser.real_return real() throws RecognitionException {
		WreslPlusParser.real_return retval = new WreslPlusParser.real_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope real_p572 =null;
		ParserRuleReturnScope real_n573 =null;


		try {
			// WreslPlus.g:1022:8: ( real_p | real_n )
			int alt127=2;
			int LA127_0 = input.LA(1);
			if ( (LA127_0==REAL) ) {
				alt127=1;
			}
			else if ( (LA127_0==108) ) {
				alt127=2;
			}

			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 127, 0, input);
				throw nvae;
			}

			switch (alt127) {
				case 1 :
					// WreslPlus.g:1022:10: real_p
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_real_p_in_real5516);
					real_p572=real_p();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, real_p572.getTree());

					}
					break;
				case 2 :
					// WreslPlus.g:1022:17: real_n
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_real_n_in_real5518);
					real_n573=real_n();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, real_n573.getTree());

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
	// $ANTLR end "real"


	public static class integer_p_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "integer_p"
	// WreslPlus.g:1024:1: integer_p : INT ;
	public final WreslPlusParser.integer_p_return integer_p() throws RecognitionException {
		WreslPlusParser.integer_p_return retval = new WreslPlusParser.integer_p_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INT574=null;

		CommonTree INT574_tree=null;

		try {
			// WreslPlus.g:1024:11: ( INT )
			// WreslPlus.g:1024:13: INT
			{
			root_0 = (CommonTree)adaptor.nil();


			INT574=(Token)match(input,INT,FOLLOW_INT_in_integer_p5527); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INT574_tree = (CommonTree)adaptor.create(INT574);
			adaptor.addChild(root_0, INT574_tree);
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
	// $ANTLR end "integer_p"


	public static class integer_n_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "integer_n"
	// WreslPlus.g:1025:1: integer_n : '-' INT ;
	public final WreslPlusParser.integer_n_return integer_n() throws RecognitionException {
		WreslPlusParser.integer_n_return retval = new WreslPlusParser.integer_n_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal575=null;
		Token INT576=null;

		CommonTree char_literal575_tree=null;
		CommonTree INT576_tree=null;

		try {
			// WreslPlus.g:1025:11: ( '-' INT )
			// WreslPlus.g:1025:13: '-' INT
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal575=(Token)match(input,108,FOLLOW_108_in_integer_n5535); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal575_tree = (CommonTree)adaptor.create(char_literal575);
			adaptor.addChild(root_0, char_literal575_tree);
			}

			INT576=(Token)match(input,INT,FOLLOW_INT_in_integer_n5537); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			INT576_tree = (CommonTree)adaptor.create(INT576);
			adaptor.addChild(root_0, INT576_tree);
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
	// $ANTLR end "integer_n"


	public static class real_p_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "real_p"
	// WreslPlus.g:1026:1: real_p : REAL ;
	public final WreslPlusParser.real_p_return real_p() throws RecognitionException {
		WreslPlusParser.real_p_return retval = new WreslPlusParser.real_p_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token REAL577=null;

		CommonTree REAL577_tree=null;

		try {
			// WreslPlus.g:1026:8: ( REAL )
			// WreslPlus.g:1026:10: REAL
			{
			root_0 = (CommonTree)adaptor.nil();


			REAL577=(Token)match(input,REAL,FOLLOW_REAL_in_real_p5545); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			REAL577_tree = (CommonTree)adaptor.create(REAL577);
			adaptor.addChild(root_0, REAL577_tree);
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
	// $ANTLR end "real_p"


	public static class real_n_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "real_n"
	// WreslPlus.g:1027:1: real_n : '-' REAL ;
	public final WreslPlusParser.real_n_return real_n() throws RecognitionException {
		WreslPlusParser.real_n_return retval = new WreslPlusParser.real_n_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal578=null;
		Token REAL579=null;

		CommonTree char_literal578_tree=null;
		CommonTree REAL579_tree=null;

		try {
			// WreslPlus.g:1027:8: ( '-' REAL )
			// WreslPlus.g:1027:10: '-' REAL
			{
			root_0 = (CommonTree)adaptor.nil();


			char_literal578=(Token)match(input,108,FOLLOW_108_in_real_n5553); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal578_tree = (CommonTree)adaptor.create(char_literal578);
			adaptor.addChild(root_0, char_literal578_tree);
			}

			REAL579=(Token)match(input,REAL,FOLLOW_REAL_in_real_n5555); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			REAL579_tree = (CommonTree)adaptor.create(REAL579);
			adaptor.addChild(root_0, REAL579_tree);
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
	// $ANTLR end "real_n"


	public static class id_domain_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "id_domain"
	// WreslPlus.g:1030:1: id_domain : ( ID '.' )? ID ;
	public final WreslPlusParser.id_domain_return id_domain() throws RecognitionException {
		WreslPlusParser.id_domain_return retval = new WreslPlusParser.id_domain_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID580=null;
		Token char_literal581=null;
		Token ID582=null;

		CommonTree ID580_tree=null;
		CommonTree char_literal581_tree=null;
		CommonTree ID582_tree=null;

		try {
			// WreslPlus.g:1030:11: ( ( ID '.' )? ID )
			// WreslPlus.g:1030:13: ( ID '.' )? ID
			{
			root_0 = (CommonTree)adaptor.nil();


			// WreslPlus.g:1030:13: ( ID '.' )?
			int alt128=2;
			int LA128_0 = input.LA(1);
			if ( (LA128_0==ID) ) {
				int LA128_1 = input.LA(2);
				if ( (LA128_1==109) ) {
					alt128=1;
				}
			}
			switch (alt128) {
				case 1 :
					// WreslPlus.g:1030:15: ID '.'
					{
					ID580=(Token)match(input,ID,FOLLOW_ID_in_id_domain5567); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ID580_tree = (CommonTree)adaptor.create(ID580);
					adaptor.addChild(root_0, ID580_tree);
					}

					char_literal581=(Token)match(input,109,FOLLOW_109_in_id_domain5569); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal581_tree = (CommonTree)adaptor.create(char_literal581);
					adaptor.addChild(root_0, char_literal581_tree);
					}

					}
					break;

			}

			ID582=(Token)match(input,ID,FOLLOW_ID_in_id_domain5575); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			ID582_tree = (CommonTree)adaptor.create(ID582);
			adaptor.addChild(root_0, ID582_tree);
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
	// $ANTLR end "id_domain"


	public static class mathFunc_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "mathFunc"
	// WreslPlus.g:1034:1: mathFunc : ( LOG '(' expr_add ')' | INT_word '(' expr_add ')' | ROUND '(' expr_add ')' | MOD '(' expr_add ',' expr_add ')' | SIN '(' expr_add ')' | COS '(' expr_add ')' | TAN '(' expr_add ')' | COT '(' expr_add ')' | ASIN '(' expr_add ')' | ACOS '(' expr_add ')' | ATAN '(' expr_add ')' | ACOT '(' expr_add ')' | exceedFunc | exceedtsiFunc );
	public final WreslPlusParser.mathFunc_return mathFunc() throws RecognitionException {
		WreslPlusParser.mathFunc_return retval = new WreslPlusParser.mathFunc_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LOG583=null;
		Token char_literal584=null;
		Token char_literal586=null;
		Token INT_word587=null;
		Token char_literal588=null;
		Token char_literal590=null;
		Token ROUND591=null;
		Token char_literal592=null;
		Token char_literal594=null;
		Token MOD595=null;
		Token char_literal596=null;
		Token char_literal598=null;
		Token char_literal600=null;
		Token SIN601=null;
		Token char_literal602=null;
		Token char_literal604=null;
		Token COS605=null;
		Token char_literal606=null;
		Token char_literal608=null;
		Token TAN609=null;
		Token char_literal610=null;
		Token char_literal612=null;
		Token COT613=null;
		Token char_literal614=null;
		Token char_literal616=null;
		Token ASIN617=null;
		Token char_literal618=null;
		Token char_literal620=null;
		Token ACOS621=null;
		Token char_literal622=null;
		Token char_literal624=null;
		Token ATAN625=null;
		Token char_literal626=null;
		Token char_literal628=null;
		Token ACOT629=null;
		Token char_literal630=null;
		Token char_literal632=null;
		ParserRuleReturnScope expr_add585 =null;
		ParserRuleReturnScope expr_add589 =null;
		ParserRuleReturnScope expr_add593 =null;
		ParserRuleReturnScope expr_add597 =null;
		ParserRuleReturnScope expr_add599 =null;
		ParserRuleReturnScope expr_add603 =null;
		ParserRuleReturnScope expr_add607 =null;
		ParserRuleReturnScope expr_add611 =null;
		ParserRuleReturnScope expr_add615 =null;
		ParserRuleReturnScope expr_add619 =null;
		ParserRuleReturnScope expr_add623 =null;
		ParserRuleReturnScope expr_add627 =null;
		ParserRuleReturnScope expr_add631 =null;
		ParserRuleReturnScope exceedFunc633 =null;
		ParserRuleReturnScope exceedtsiFunc634 =null;

		CommonTree LOG583_tree=null;
		CommonTree char_literal584_tree=null;
		CommonTree char_literal586_tree=null;
		CommonTree INT_word587_tree=null;
		CommonTree char_literal588_tree=null;
		CommonTree char_literal590_tree=null;
		CommonTree ROUND591_tree=null;
		CommonTree char_literal592_tree=null;
		CommonTree char_literal594_tree=null;
		CommonTree MOD595_tree=null;
		CommonTree char_literal596_tree=null;
		CommonTree char_literal598_tree=null;
		CommonTree char_literal600_tree=null;
		CommonTree SIN601_tree=null;
		CommonTree char_literal602_tree=null;
		CommonTree char_literal604_tree=null;
		CommonTree COS605_tree=null;
		CommonTree char_literal606_tree=null;
		CommonTree char_literal608_tree=null;
		CommonTree TAN609_tree=null;
		CommonTree char_literal610_tree=null;
		CommonTree char_literal612_tree=null;
		CommonTree COT613_tree=null;
		CommonTree char_literal614_tree=null;
		CommonTree char_literal616_tree=null;
		CommonTree ASIN617_tree=null;
		CommonTree char_literal618_tree=null;
		CommonTree char_literal620_tree=null;
		CommonTree ACOS621_tree=null;
		CommonTree char_literal622_tree=null;
		CommonTree char_literal624_tree=null;
		CommonTree ATAN625_tree=null;
		CommonTree char_literal626_tree=null;
		CommonTree char_literal628_tree=null;
		CommonTree ACOT629_tree=null;
		CommonTree char_literal630_tree=null;
		CommonTree char_literal632_tree=null;

		try {
			// WreslPlus.g:1035:3: ( LOG '(' expr_add ')' | INT_word '(' expr_add ')' | ROUND '(' expr_add ')' | MOD '(' expr_add ',' expr_add ')' | SIN '(' expr_add ')' | COS '(' expr_add ')' | TAN '(' expr_add ')' | COT '(' expr_add ')' | ASIN '(' expr_add ')' | ACOS '(' expr_add ')' | ATAN '(' expr_add ')' | ACOT '(' expr_add ')' | exceedFunc | exceedtsiFunc )
			int alt129=14;
			switch ( input.LA(1) ) {
			case LOG:
				{
				alt129=1;
				}
				break;
			case INT_word:
				{
				alt129=2;
				}
				break;
			case ROUND:
				{
				alt129=3;
				}
				break;
			case MOD:
				{
				alt129=4;
				}
				break;
			case SIN:
				{
				alt129=5;
				}
				break;
			case COS:
				{
				alt129=6;
				}
				break;
			case TAN:
				{
				alt129=7;
				}
				break;
			case COT:
				{
				alt129=8;
				}
				break;
			case ASIN:
				{
				alt129=9;
				}
				break;
			case ACOS:
				{
				alt129=10;
				}
				break;
			case ATAN:
				{
				alt129=11;
				}
				break;
			case ACOT:
				{
				alt129=12;
				}
				break;
			case EXCEEDANCE:
				{
				alt129=13;
				}
				break;
			case EXCEEDANCE_TSI:
				{
				alt129=14;
				}
				break;
			default:
				if (state.backtracking>0) {state.failed=true; return retval;}
				NoViableAltException nvae =
					new NoViableAltException("", 129, 0, input);
				throw nvae;
			}
			switch (alt129) {
				case 1 :
					// WreslPlus.g:1035:6: LOG '(' expr_add ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					LOG583=(Token)match(input,LOG,FOLLOW_LOG_in_mathFunc5591); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					LOG583_tree = (CommonTree)adaptor.create(LOG583);
					adaptor.addChild(root_0, LOG583_tree);
					}

					char_literal584=(Token)match(input,103,FOLLOW_103_in_mathFunc5593); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal584_tree = (CommonTree)adaptor.create(char_literal584);
					adaptor.addChild(root_0, char_literal584_tree);
					}

					pushFollow(FOLLOW_expr_add_in_mathFunc5595);
					expr_add585=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add585.getTree());

					char_literal586=(Token)match(input,104,FOLLOW_104_in_mathFunc5597); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal586_tree = (CommonTree)adaptor.create(char_literal586);
					adaptor.addChild(root_0, char_literal586_tree);
					}

					}
					break;
				case 2 :
					// WreslPlus.g:1036:6: INT_word '(' expr_add ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					INT_word587=(Token)match(input,INT_word,FOLLOW_INT_word_in_mathFunc5605); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					INT_word587_tree = (CommonTree)adaptor.create(INT_word587);
					adaptor.addChild(root_0, INT_word587_tree);
					}

					char_literal588=(Token)match(input,103,FOLLOW_103_in_mathFunc5607); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal588_tree = (CommonTree)adaptor.create(char_literal588);
					adaptor.addChild(root_0, char_literal588_tree);
					}

					pushFollow(FOLLOW_expr_add_in_mathFunc5609);
					expr_add589=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add589.getTree());

					char_literal590=(Token)match(input,104,FOLLOW_104_in_mathFunc5611); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal590_tree = (CommonTree)adaptor.create(char_literal590);
					adaptor.addChild(root_0, char_literal590_tree);
					}

					}
					break;
				case 3 :
					// WreslPlus.g:1037:6: ROUND '(' expr_add ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					ROUND591=(Token)match(input,ROUND,FOLLOW_ROUND_in_mathFunc5619); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ROUND591_tree = (CommonTree)adaptor.create(ROUND591);
					adaptor.addChild(root_0, ROUND591_tree);
					}

					char_literal592=(Token)match(input,103,FOLLOW_103_in_mathFunc5621); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal592_tree = (CommonTree)adaptor.create(char_literal592);
					adaptor.addChild(root_0, char_literal592_tree);
					}

					pushFollow(FOLLOW_expr_add_in_mathFunc5623);
					expr_add593=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add593.getTree());

					char_literal594=(Token)match(input,104,FOLLOW_104_in_mathFunc5625); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal594_tree = (CommonTree)adaptor.create(char_literal594);
					adaptor.addChild(root_0, char_literal594_tree);
					}

					}
					break;
				case 4 :
					// WreslPlus.g:1038:6: MOD '(' expr_add ',' expr_add ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					MOD595=(Token)match(input,MOD,FOLLOW_MOD_in_mathFunc5633); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					MOD595_tree = (CommonTree)adaptor.create(MOD595);
					adaptor.addChild(root_0, MOD595_tree);
					}

					char_literal596=(Token)match(input,103,FOLLOW_103_in_mathFunc5635); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal596_tree = (CommonTree)adaptor.create(char_literal596);
					adaptor.addChild(root_0, char_literal596_tree);
					}

					pushFollow(FOLLOW_expr_add_in_mathFunc5637);
					expr_add597=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add597.getTree());

					char_literal598=(Token)match(input,107,FOLLOW_107_in_mathFunc5639); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal598_tree = (CommonTree)adaptor.create(char_literal598);
					adaptor.addChild(root_0, char_literal598_tree);
					}

					pushFollow(FOLLOW_expr_add_in_mathFunc5641);
					expr_add599=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add599.getTree());

					char_literal600=(Token)match(input,104,FOLLOW_104_in_mathFunc5643); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal600_tree = (CommonTree)adaptor.create(char_literal600);
					adaptor.addChild(root_0, char_literal600_tree);
					}

					}
					break;
				case 5 :
					// WreslPlus.g:1039:6: SIN '(' expr_add ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					SIN601=(Token)match(input,SIN,FOLLOW_SIN_in_mathFunc5651); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					SIN601_tree = (CommonTree)adaptor.create(SIN601);
					adaptor.addChild(root_0, SIN601_tree);
					}

					char_literal602=(Token)match(input,103,FOLLOW_103_in_mathFunc5653); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal602_tree = (CommonTree)adaptor.create(char_literal602);
					adaptor.addChild(root_0, char_literal602_tree);
					}

					pushFollow(FOLLOW_expr_add_in_mathFunc5655);
					expr_add603=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add603.getTree());

					char_literal604=(Token)match(input,104,FOLLOW_104_in_mathFunc5657); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal604_tree = (CommonTree)adaptor.create(char_literal604);
					adaptor.addChild(root_0, char_literal604_tree);
					}

					}
					break;
				case 6 :
					// WreslPlus.g:1040:6: COS '(' expr_add ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					COS605=(Token)match(input,COS,FOLLOW_COS_in_mathFunc5665); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COS605_tree = (CommonTree)adaptor.create(COS605);
					adaptor.addChild(root_0, COS605_tree);
					}

					char_literal606=(Token)match(input,103,FOLLOW_103_in_mathFunc5667); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal606_tree = (CommonTree)adaptor.create(char_literal606);
					adaptor.addChild(root_0, char_literal606_tree);
					}

					pushFollow(FOLLOW_expr_add_in_mathFunc5669);
					expr_add607=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add607.getTree());

					char_literal608=(Token)match(input,104,FOLLOW_104_in_mathFunc5671); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal608_tree = (CommonTree)adaptor.create(char_literal608);
					adaptor.addChild(root_0, char_literal608_tree);
					}

					}
					break;
				case 7 :
					// WreslPlus.g:1041:6: TAN '(' expr_add ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					TAN609=(Token)match(input,TAN,FOLLOW_TAN_in_mathFunc5679); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					TAN609_tree = (CommonTree)adaptor.create(TAN609);
					adaptor.addChild(root_0, TAN609_tree);
					}

					char_literal610=(Token)match(input,103,FOLLOW_103_in_mathFunc5681); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal610_tree = (CommonTree)adaptor.create(char_literal610);
					adaptor.addChild(root_0, char_literal610_tree);
					}

					pushFollow(FOLLOW_expr_add_in_mathFunc5683);
					expr_add611=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add611.getTree());

					char_literal612=(Token)match(input,104,FOLLOW_104_in_mathFunc5685); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal612_tree = (CommonTree)adaptor.create(char_literal612);
					adaptor.addChild(root_0, char_literal612_tree);
					}

					}
					break;
				case 8 :
					// WreslPlus.g:1042:6: COT '(' expr_add ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					COT613=(Token)match(input,COT,FOLLOW_COT_in_mathFunc5693); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					COT613_tree = (CommonTree)adaptor.create(COT613);
					adaptor.addChild(root_0, COT613_tree);
					}

					char_literal614=(Token)match(input,103,FOLLOW_103_in_mathFunc5695); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal614_tree = (CommonTree)adaptor.create(char_literal614);
					adaptor.addChild(root_0, char_literal614_tree);
					}

					pushFollow(FOLLOW_expr_add_in_mathFunc5697);
					expr_add615=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add615.getTree());

					char_literal616=(Token)match(input,104,FOLLOW_104_in_mathFunc5699); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal616_tree = (CommonTree)adaptor.create(char_literal616);
					adaptor.addChild(root_0, char_literal616_tree);
					}

					}
					break;
				case 9 :
					// WreslPlus.g:1043:6: ASIN '(' expr_add ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					ASIN617=(Token)match(input,ASIN,FOLLOW_ASIN_in_mathFunc5707); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ASIN617_tree = (CommonTree)adaptor.create(ASIN617);
					adaptor.addChild(root_0, ASIN617_tree);
					}

					char_literal618=(Token)match(input,103,FOLLOW_103_in_mathFunc5709); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal618_tree = (CommonTree)adaptor.create(char_literal618);
					adaptor.addChild(root_0, char_literal618_tree);
					}

					pushFollow(FOLLOW_expr_add_in_mathFunc5711);
					expr_add619=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add619.getTree());

					char_literal620=(Token)match(input,104,FOLLOW_104_in_mathFunc5713); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal620_tree = (CommonTree)adaptor.create(char_literal620);
					adaptor.addChild(root_0, char_literal620_tree);
					}

					}
					break;
				case 10 :
					// WreslPlus.g:1044:6: ACOS '(' expr_add ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					ACOS621=(Token)match(input,ACOS,FOLLOW_ACOS_in_mathFunc5721); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ACOS621_tree = (CommonTree)adaptor.create(ACOS621);
					adaptor.addChild(root_0, ACOS621_tree);
					}

					char_literal622=(Token)match(input,103,FOLLOW_103_in_mathFunc5723); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal622_tree = (CommonTree)adaptor.create(char_literal622);
					adaptor.addChild(root_0, char_literal622_tree);
					}

					pushFollow(FOLLOW_expr_add_in_mathFunc5725);
					expr_add623=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add623.getTree());

					char_literal624=(Token)match(input,104,FOLLOW_104_in_mathFunc5727); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal624_tree = (CommonTree)adaptor.create(char_literal624);
					adaptor.addChild(root_0, char_literal624_tree);
					}

					}
					break;
				case 11 :
					// WreslPlus.g:1045:6: ATAN '(' expr_add ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					ATAN625=(Token)match(input,ATAN,FOLLOW_ATAN_in_mathFunc5735); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ATAN625_tree = (CommonTree)adaptor.create(ATAN625);
					adaptor.addChild(root_0, ATAN625_tree);
					}

					char_literal626=(Token)match(input,103,FOLLOW_103_in_mathFunc5737); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal626_tree = (CommonTree)adaptor.create(char_literal626);
					adaptor.addChild(root_0, char_literal626_tree);
					}

					pushFollow(FOLLOW_expr_add_in_mathFunc5739);
					expr_add627=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add627.getTree());

					char_literal628=(Token)match(input,104,FOLLOW_104_in_mathFunc5741); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal628_tree = (CommonTree)adaptor.create(char_literal628);
					adaptor.addChild(root_0, char_literal628_tree);
					}

					}
					break;
				case 12 :
					// WreslPlus.g:1046:6: ACOT '(' expr_add ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					ACOT629=(Token)match(input,ACOT,FOLLOW_ACOT_in_mathFunc5749); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					ACOT629_tree = (CommonTree)adaptor.create(ACOT629);
					adaptor.addChild(root_0, ACOT629_tree);
					}

					char_literal630=(Token)match(input,103,FOLLOW_103_in_mathFunc5751); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal630_tree = (CommonTree)adaptor.create(char_literal630);
					adaptor.addChild(root_0, char_literal630_tree);
					}

					pushFollow(FOLLOW_expr_add_in_mathFunc5753);
					expr_add631=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add631.getTree());

					char_literal632=(Token)match(input,104,FOLLOW_104_in_mathFunc5755); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal632_tree = (CommonTree)adaptor.create(char_literal632);
					adaptor.addChild(root_0, char_literal632_tree);
					}

					}
					break;
				case 13 :
					// WreslPlus.g:1047:6: exceedFunc
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_exceedFunc_in_mathFunc5763);
					exceedFunc633=exceedFunc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exceedFunc633.getTree());

					}
					break;
				case 14 :
					// WreslPlus.g:1048:6: exceedtsiFunc
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_exceedtsiFunc_in_mathFunc5770);
					exceedtsiFunc634=exceedtsiFunc();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, exceedtsiFunc634.getTree());

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
	// $ANTLR end "mathFunc"


	public static class unitFunc_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "unitFunc"
	// WreslPlus.g:1051:1: unitFunc : ( CFS_TAF | TAF_CFS ) ( '(' expr_add ')' )? ;
	public final WreslPlusParser.unitFunc_return unitFunc() throws RecognitionException {
		WreslPlusParser.unitFunc_return retval = new WreslPlusParser.unitFunc_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set635=null;
		Token char_literal636=null;
		Token char_literal638=null;
		ParserRuleReturnScope expr_add637 =null;

		CommonTree set635_tree=null;
		CommonTree char_literal636_tree=null;
		CommonTree char_literal638_tree=null;

		try {
			// WreslPlus.g:1052:3: ( ( CFS_TAF | TAF_CFS ) ( '(' expr_add ')' )? )
			// WreslPlus.g:1052:5: ( CFS_TAF | TAF_CFS ) ( '(' expr_add ')' )?
			{
			root_0 = (CommonTree)adaptor.nil();


			set635=input.LT(1);
			if ( input.LA(1)==CFS_TAF||input.LA(1)==TAF_CFS ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set635));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			// WreslPlus.g:1052:27: ( '(' expr_add ')' )?
			int alt130=2;
			int LA130_0 = input.LA(1);
			if ( (LA130_0==103) ) {
				alt130=1;
			}
			switch (alt130) {
				case 1 :
					// WreslPlus.g:1052:28: '(' expr_add ')'
					{
					char_literal636=(Token)match(input,103,FOLLOW_103_in_unitFunc5796); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal636_tree = (CommonTree)adaptor.create(char_literal636);
					adaptor.addChild(root_0, char_literal636_tree);
					}

					pushFollow(FOLLOW_expr_add_in_unitFunc5798);
					expr_add637=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add637.getTree());

					char_literal638=(Token)match(input,104,FOLLOW_104_in_unitFunc5800); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal638_tree = (CommonTree)adaptor.create(char_literal638);
					adaptor.addChild(root_0, char_literal638_tree);
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
	// $ANTLR end "unitFunc"


	public static class multiInputFunc_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "multiInputFunc"
	// WreslPlus.g:1054:1: multiInputFunc : ( MIN | MAX ) '(' expr_add ( ',' expr_add )* ')' ;
	public final WreslPlusParser.multiInputFunc_return multiInputFunc() throws RecognitionException {
		WreslPlusParser.multiInputFunc_return retval = new WreslPlusParser.multiInputFunc_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set639=null;
		Token char_literal640=null;
		Token char_literal642=null;
		Token char_literal644=null;
		ParserRuleReturnScope expr_add641 =null;
		ParserRuleReturnScope expr_add643 =null;

		CommonTree set639_tree=null;
		CommonTree char_literal640_tree=null;
		CommonTree char_literal642_tree=null;
		CommonTree char_literal644_tree=null;

		try {
			// WreslPlus.g:1055:3: ( ( MIN | MAX ) '(' expr_add ( ',' expr_add )* ')' )
			// WreslPlus.g:1055:5: ( MIN | MAX ) '(' expr_add ( ',' expr_add )* ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			set639=input.LT(1);
			if ( (input.LA(1) >= MAX && input.LA(1) <= MIN) ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set639));
				state.errorRecovery=false;
				state.failed=false;
			}
			else {
				if (state.backtracking>0) {state.failed=true; return retval;}
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			char_literal640=(Token)match(input,103,FOLLOW_103_in_multiInputFunc5827); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal640_tree = (CommonTree)adaptor.create(char_literal640);
			adaptor.addChild(root_0, char_literal640_tree);
			}

			pushFollow(FOLLOW_expr_add_in_multiInputFunc5829);
			expr_add641=expr_add();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add641.getTree());

			// WreslPlus.g:1055:32: ( ',' expr_add )*
			loop131:
			while (true) {
				int alt131=2;
				int LA131_0 = input.LA(1);
				if ( (LA131_0==107) ) {
					alt131=1;
				}

				switch (alt131) {
				case 1 :
					// WreslPlus.g:1055:34: ',' expr_add
					{
					char_literal642=(Token)match(input,107,FOLLOW_107_in_multiInputFunc5833); if (state.failed) return retval;
					if ( state.backtracking==0 ) {
					char_literal642_tree = (CommonTree)adaptor.create(char_literal642);
					adaptor.addChild(root_0, char_literal642_tree);
					}

					pushFollow(FOLLOW_expr_add_in_multiInputFunc5835);
					expr_add643=expr_add();
					state._fsp--;
					if (state.failed) return retval;
					if ( state.backtracking==0 ) adaptor.addChild(root_0, expr_add643.getTree());

					}
					break;

				default :
					break loop131;
				}
			}

			char_literal644=(Token)match(input,104,FOLLOW_104_in_multiInputFunc5840); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal644_tree = (CommonTree)adaptor.create(char_literal644);
			adaptor.addChild(root_0, char_literal644_tree);
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
	// $ANTLR end "multiInputFunc"


	public static class exceedFunc_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "exceedFunc"
	// WreslPlus.g:1058:1: exceedFunc : EXCEEDANCE '(' varID ',' number_p ',' varID ',' integer_p ',' varID ',' integer ',' integer_p ',' varID ',' integer ')' ;
	public final WreslPlusParser.exceedFunc_return exceedFunc() throws RecognitionException {
		WreslPlusParser.exceedFunc_return retval = new WreslPlusParser.exceedFunc_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EXCEEDANCE645=null;
		Token char_literal646=null;
		Token char_literal648=null;
		Token char_literal650=null;
		Token char_literal652=null;
		Token char_literal654=null;
		Token char_literal656=null;
		Token char_literal658=null;
		Token char_literal660=null;
		Token char_literal662=null;
		Token char_literal664=null;
		ParserRuleReturnScope varID647 =null;
		ParserRuleReturnScope number_p649 =null;
		ParserRuleReturnScope varID651 =null;
		ParserRuleReturnScope integer_p653 =null;
		ParserRuleReturnScope varID655 =null;
		ParserRuleReturnScope integer657 =null;
		ParserRuleReturnScope integer_p659 =null;
		ParserRuleReturnScope varID661 =null;
		ParserRuleReturnScope integer663 =null;

		CommonTree EXCEEDANCE645_tree=null;
		CommonTree char_literal646_tree=null;
		CommonTree char_literal648_tree=null;
		CommonTree char_literal650_tree=null;
		CommonTree char_literal652_tree=null;
		CommonTree char_literal654_tree=null;
		CommonTree char_literal656_tree=null;
		CommonTree char_literal658_tree=null;
		CommonTree char_literal660_tree=null;
		CommonTree char_literal662_tree=null;
		CommonTree char_literal664_tree=null;

		try {
			// WreslPlus.g:1059:3: ( EXCEEDANCE '(' varID ',' number_p ',' varID ',' integer_p ',' varID ',' integer ',' integer_p ',' varID ',' integer ')' )
			// WreslPlus.g:1059:5: EXCEEDANCE '(' varID ',' number_p ',' varID ',' integer_p ',' varID ',' integer ',' integer_p ',' varID ',' integer ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			EXCEEDANCE645=(Token)match(input,EXCEEDANCE,FOLLOW_EXCEEDANCE_in_exceedFunc5854); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			EXCEEDANCE645_tree = (CommonTree)adaptor.create(EXCEEDANCE645);
			adaptor.addChild(root_0, EXCEEDANCE645_tree);
			}

			char_literal646=(Token)match(input,103,FOLLOW_103_in_exceedFunc5856); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal646_tree = (CommonTree)adaptor.create(char_literal646);
			adaptor.addChild(root_0, char_literal646_tree);
			}

			pushFollow(FOLLOW_varID_in_exceedFunc5858);
			varID647=varID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, varID647.getTree());

			char_literal648=(Token)match(input,107,FOLLOW_107_in_exceedFunc5860); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal648_tree = (CommonTree)adaptor.create(char_literal648);
			adaptor.addChild(root_0, char_literal648_tree);
			}

			pushFollow(FOLLOW_number_p_in_exceedFunc5862);
			number_p649=number_p();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, number_p649.getTree());

			char_literal650=(Token)match(input,107,FOLLOW_107_in_exceedFunc5864); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal650_tree = (CommonTree)adaptor.create(char_literal650);
			adaptor.addChild(root_0, char_literal650_tree);
			}

			pushFollow(FOLLOW_varID_in_exceedFunc5866);
			varID651=varID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, varID651.getTree());

			char_literal652=(Token)match(input,107,FOLLOW_107_in_exceedFunc5868); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal652_tree = (CommonTree)adaptor.create(char_literal652);
			adaptor.addChild(root_0, char_literal652_tree);
			}

			pushFollow(FOLLOW_integer_p_in_exceedFunc5870);
			integer_p653=integer_p();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, integer_p653.getTree());

			char_literal654=(Token)match(input,107,FOLLOW_107_in_exceedFunc5872); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal654_tree = (CommonTree)adaptor.create(char_literal654);
			adaptor.addChild(root_0, char_literal654_tree);
			}

			pushFollow(FOLLOW_varID_in_exceedFunc5874);
			varID655=varID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, varID655.getTree());

			char_literal656=(Token)match(input,107,FOLLOW_107_in_exceedFunc5876); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal656_tree = (CommonTree)adaptor.create(char_literal656);
			adaptor.addChild(root_0, char_literal656_tree);
			}

			pushFollow(FOLLOW_integer_in_exceedFunc5878);
			integer657=integer();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, integer657.getTree());

			char_literal658=(Token)match(input,107,FOLLOW_107_in_exceedFunc5880); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal658_tree = (CommonTree)adaptor.create(char_literal658);
			adaptor.addChild(root_0, char_literal658_tree);
			}

			pushFollow(FOLLOW_integer_p_in_exceedFunc5882);
			integer_p659=integer_p();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, integer_p659.getTree());

			char_literal660=(Token)match(input,107,FOLLOW_107_in_exceedFunc5884); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal660_tree = (CommonTree)adaptor.create(char_literal660);
			adaptor.addChild(root_0, char_literal660_tree);
			}

			pushFollow(FOLLOW_varID_in_exceedFunc5886);
			varID661=varID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, varID661.getTree());

			char_literal662=(Token)match(input,107,FOLLOW_107_in_exceedFunc5888); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal662_tree = (CommonTree)adaptor.create(char_literal662);
			adaptor.addChild(root_0, char_literal662_tree);
			}

			pushFollow(FOLLOW_integer_in_exceedFunc5890);
			integer663=integer();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, integer663.getTree());

			char_literal664=(Token)match(input,104,FOLLOW_104_in_exceedFunc5892); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal664_tree = (CommonTree)adaptor.create(char_literal664);
			adaptor.addChild(root_0, char_literal664_tree);
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
	// $ANTLR end "exceedFunc"


	public static class exceedtsiFunc_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "exceedtsiFunc"
	// WreslPlus.g:1062:1: exceedtsiFunc : EXCEEDANCE_TSI '(' varID ',' number_p ',' varID ',' integer_p ',' varID ',' integer ',' integer_p ',' varID ',' integer ')' ;
	public final WreslPlusParser.exceedtsiFunc_return exceedtsiFunc() throws RecognitionException {
		WreslPlusParser.exceedtsiFunc_return retval = new WreslPlusParser.exceedtsiFunc_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EXCEEDANCE_TSI665=null;
		Token char_literal666=null;
		Token char_literal668=null;
		Token char_literal670=null;
		Token char_literal672=null;
		Token char_literal674=null;
		Token char_literal676=null;
		Token char_literal678=null;
		Token char_literal680=null;
		Token char_literal682=null;
		Token char_literal684=null;
		ParserRuleReturnScope varID667 =null;
		ParserRuleReturnScope number_p669 =null;
		ParserRuleReturnScope varID671 =null;
		ParserRuleReturnScope integer_p673 =null;
		ParserRuleReturnScope varID675 =null;
		ParserRuleReturnScope integer677 =null;
		ParserRuleReturnScope integer_p679 =null;
		ParserRuleReturnScope varID681 =null;
		ParserRuleReturnScope integer683 =null;

		CommonTree EXCEEDANCE_TSI665_tree=null;
		CommonTree char_literal666_tree=null;
		CommonTree char_literal668_tree=null;
		CommonTree char_literal670_tree=null;
		CommonTree char_literal672_tree=null;
		CommonTree char_literal674_tree=null;
		CommonTree char_literal676_tree=null;
		CommonTree char_literal678_tree=null;
		CommonTree char_literal680_tree=null;
		CommonTree char_literal682_tree=null;
		CommonTree char_literal684_tree=null;

		try {
			// WreslPlus.g:1063:3: ( EXCEEDANCE_TSI '(' varID ',' number_p ',' varID ',' integer_p ',' varID ',' integer ',' integer_p ',' varID ',' integer ')' )
			// WreslPlus.g:1063:5: EXCEEDANCE_TSI '(' varID ',' number_p ',' varID ',' integer_p ',' varID ',' integer ',' integer_p ',' varID ',' integer ')'
			{
			root_0 = (CommonTree)adaptor.nil();


			EXCEEDANCE_TSI665=(Token)match(input,EXCEEDANCE_TSI,FOLLOW_EXCEEDANCE_TSI_in_exceedtsiFunc5910); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			EXCEEDANCE_TSI665_tree = (CommonTree)adaptor.create(EXCEEDANCE_TSI665);
			adaptor.addChild(root_0, EXCEEDANCE_TSI665_tree);
			}

			char_literal666=(Token)match(input,103,FOLLOW_103_in_exceedtsiFunc5912); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal666_tree = (CommonTree)adaptor.create(char_literal666);
			adaptor.addChild(root_0, char_literal666_tree);
			}

			pushFollow(FOLLOW_varID_in_exceedtsiFunc5914);
			varID667=varID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, varID667.getTree());

			char_literal668=(Token)match(input,107,FOLLOW_107_in_exceedtsiFunc5916); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal668_tree = (CommonTree)adaptor.create(char_literal668);
			adaptor.addChild(root_0, char_literal668_tree);
			}

			pushFollow(FOLLOW_number_p_in_exceedtsiFunc5918);
			number_p669=number_p();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, number_p669.getTree());

			char_literal670=(Token)match(input,107,FOLLOW_107_in_exceedtsiFunc5920); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal670_tree = (CommonTree)adaptor.create(char_literal670);
			adaptor.addChild(root_0, char_literal670_tree);
			}

			pushFollow(FOLLOW_varID_in_exceedtsiFunc5922);
			varID671=varID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, varID671.getTree());

			char_literal672=(Token)match(input,107,FOLLOW_107_in_exceedtsiFunc5924); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal672_tree = (CommonTree)adaptor.create(char_literal672);
			adaptor.addChild(root_0, char_literal672_tree);
			}

			pushFollow(FOLLOW_integer_p_in_exceedtsiFunc5926);
			integer_p673=integer_p();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, integer_p673.getTree());

			char_literal674=(Token)match(input,107,FOLLOW_107_in_exceedtsiFunc5928); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal674_tree = (CommonTree)adaptor.create(char_literal674);
			adaptor.addChild(root_0, char_literal674_tree);
			}

			pushFollow(FOLLOW_varID_in_exceedtsiFunc5930);
			varID675=varID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, varID675.getTree());

			char_literal676=(Token)match(input,107,FOLLOW_107_in_exceedtsiFunc5932); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal676_tree = (CommonTree)adaptor.create(char_literal676);
			adaptor.addChild(root_0, char_literal676_tree);
			}

			pushFollow(FOLLOW_integer_in_exceedtsiFunc5934);
			integer677=integer();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, integer677.getTree());

			char_literal678=(Token)match(input,107,FOLLOW_107_in_exceedtsiFunc5936); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal678_tree = (CommonTree)adaptor.create(char_literal678);
			adaptor.addChild(root_0, char_literal678_tree);
			}

			pushFollow(FOLLOW_integer_p_in_exceedtsiFunc5938);
			integer_p679=integer_p();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, integer_p679.getTree());

			char_literal680=(Token)match(input,107,FOLLOW_107_in_exceedtsiFunc5940); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal680_tree = (CommonTree)adaptor.create(char_literal680);
			adaptor.addChild(root_0, char_literal680_tree);
			}

			pushFollow(FOLLOW_varID_in_exceedtsiFunc5942);
			varID681=varID();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, varID681.getTree());

			char_literal682=(Token)match(input,107,FOLLOW_107_in_exceedtsiFunc5944); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal682_tree = (CommonTree)adaptor.create(char_literal682);
			adaptor.addChild(root_0, char_literal682_tree);
			}

			pushFollow(FOLLOW_integer_in_exceedtsiFunc5946);
			integer683=integer();
			state._fsp--;
			if (state.failed) return retval;
			if ( state.backtracking==0 ) adaptor.addChild(root_0, integer683.getTree());

			char_literal684=(Token)match(input,104,FOLLOW_104_in_exceedtsiFunc5948); if (state.failed) return retval;
			if ( state.backtracking==0 ) {
			char_literal684_tree = (CommonTree)adaptor.create(char_literal684);
			adaptor.addChild(root_0, char_literal684_tree);
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
	// $ANTLR end "exceedtsiFunc"


	public static class reservedID_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "reservedID"
	// WreslPlus.g:1073:1: reservedID : ( DAY | MONTH | WATERYEAR );
	public final WreslPlusParser.reservedID_return reservedID() throws RecognitionException {
		WreslPlusParser.reservedID_return retval = new WreslPlusParser.reservedID_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set685=null;

		CommonTree set685_tree=null;

		try {
			// WreslPlus.g:1073:12: ( DAY | MONTH | WATERYEAR )
			// WreslPlus.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set685=input.LT(1);
			if ( input.LA(1)==DAY||input.LA(1)==MONTH||input.LA(1)==WATERYEAR ) {
				input.consume();
				if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set685));
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
	// $ANTLR end "reservedID"

	// $ANTLR start synpred1_WreslPlus
	public final void synpred1_WreslPlus_fragment() throws RecognitionException {
		// WreslPlus.g:833:10: ( logical_relation )
		// WreslPlus.g:833:12: logical_relation
		{
		pushFollow(FOLLOW_logical_relation_in_synpred1_WreslPlus4132);
		logical_relation();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred1_WreslPlus

	// $ANTLR start synpred2_WreslPlus
	public final void synpred2_WreslPlus_fragment() throws RecognitionException {
		// WreslPlus.g:834:10: ( logical_or_p )
		// WreslPlus.g:834:12: logical_or_p
		{
		pushFollow(FOLLOW_logical_or_p_in_synpred2_WreslPlus4151);
		logical_or_p();
		state._fsp--;
		if (state.failed) return;

		}

	}
	// $ANTLR end synpred2_WreslPlus

	// Delegated rules

	public final boolean synpred2_WreslPlus() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred2_WreslPlus_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}
	public final boolean synpred1_WreslPlus() {
		state.backtracking++;
		int start = input.mark();
		try {
			synpred1_WreslPlus_fragment(); // can never throw exception
		} catch (RecognitionException re) {
			System.err.println("impossible: "+re);
		}
		boolean success = !state.failed;
		input.rewind(start);
		state.backtracking--;
		state.failed=false;
		return success;
	}



	public static final BitSet FOLLOW_125_in_wreslFile76 = new BitSet(new long[]{0x0800084800600040L,0x0000000000220001L});
	public static final BitSet FOLLOW_mt_in_wreslFile80 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_wreslFile82 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_wreslFile84 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mt_in_wreslFile94 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_EOF_in_wreslFile96 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_initial_in_wreslMain127 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_sequence_in_wreslMain135 = new BitSet(new long[]{0x0100001000000000L,0x0000000000000800L});
	public static final BitSet FOLLOW_group_in_wreslMain151 = new BitSet(new long[]{0x0100001000000000L});
	public static final BitSet FOLLOW_model_in_wreslMain171 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_EOF_in_wreslMain188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_119_in_local_deprecated199 = new BitSet(new long[]{0x0001000000000000L});
	public static final BitSet FOLLOW_LOCAL_in_local_deprecated201 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_local_deprecated203 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Initial_in_initial232 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_initial234 = new BitSet(new long[]{0x0000000000080000L,0x0000000000020000L});
	public static final BitSet FOLLOW_constant_in_initial260 = new BitSet(new long[]{0x0000000000080000L,0x4000000000020000L});
	public static final BitSet FOLLOW_svar_initial_in_initial280 = new BitSet(new long[]{0x0000000000080000L,0x4000000000020000L});
	public static final BitSet FOLLOW_126_in_initial296 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Const_in_constant315 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_constant319 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_constant321 = new BitSet(new long[]{0x0000010000000000L,0x0000100000000080L});
	public static final BitSet FOLLOW_number_in_constant325 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_constant327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SVAR_in_svar_initial361 = new BitSet(new long[]{0x0000002000000000L,0x0080008000000000L});
	public static final BitSet FOLLOW_svar_g_in_svar_initial364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_add_simple_in_expression_simple404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TEMPLATE_in_template443 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_template445 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_template447 = new BitSet(new long[]{0x0000000000000000L,0x4000006000000000L});
	public static final BitSet FOLLOW_template_svar_in_template451 = new BitSet(new long[]{0x0000000000000000L,0x4000006000000000L});
	public static final BitSet FOLLOW_template_dvar_in_template455 = new BitSet(new long[]{0x0000000000000000L,0x4000006000000000L});
	public static final BitSet FOLLOW_template_dvar_array_in_template459 = new BitSet(new long[]{0x0000000000000000L,0x4000006000000000L});
	public static final BitSet FOLLOW_126_in_template465 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_101_in_template_dvar474 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_varID_in_template_dvar476 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_template_dvar478 = new BitSet(new long[]{0x0004020000000800L,0x0002000008008000L});
	public static final BitSet FOLLOW_dvar_trunk_in_template_dvar480 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_template_dvar482 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_101_in_template_dvar_array491 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_dimension_in_template_dvar_array493 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_varID_in_template_dvar_array495 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_template_dvar_array497 = new BitSet(new long[]{0x0004020000000800L,0x0002000008008000L});
	public static final BitSet FOLLOW_dvar_trunk_in_template_dvar_array499 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_template_dvar_array501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_102_in_template_svar510 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_varID_in_template_svar512 = new BitSet(new long[]{0x0000000000001000L,0x1000000020010400L});
	public static final BitSet FOLLOW_svar_trunk_in_template_svar515 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SEQUENCE_in_sequence555 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_sequence559 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_sequence566 = new BitSet(new long[]{0x0100000000000000L});
	public static final BitSet FOLLOW_MODEL_in_sequence568 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_sequence572 = new BitSet(new long[]{0x0000000000004000L,0x0000000000000004L});
	public static final BitSet FOLLOW_CONDITION_in_sequence583 = new BitSet(new long[]{0x22B205200C1626B0L,0x1C001498800C12C0L});
	public static final BitSet FOLLOW_logical_main_in_sequence587 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
	public static final BitSet FOLLOW_ORDER_in_sequence591 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_INT_in_sequence595 = new BitSet(new long[]{0x0000000000000000L,0x4000000000400000L});
	public static final BitSet FOLLOW_ORDER_in_sequence612 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_INT_in_sequence616 = new BitSet(new long[]{0x0000000000004000L,0x4000000000400000L});
	public static final BitSet FOLLOW_CONDITION_in_sequence619 = new BitSet(new long[]{0x22B205200C1626B0L,0x1C001498800C12C0L});
	public static final BitSet FOLLOW_logical_main_in_sequence623 = new BitSet(new long[]{0x0000000000000000L,0x4000000000400000L});
	public static final BitSet FOLLOW_TIMESTEP_in_sequence640 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
	public static final BitSet FOLLOW_TIMESTEPVALUE_in_sequence644 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_sequence658 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GROUP_in_group674 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_group678 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_group682 = new BitSet(new long[]{0x0800084800600040L,0x0000000000220001L});
	public static final BitSet FOLLOW_mt_in_group686 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_group688 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_model_in_model_standalone701 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MODEL_in_model713 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_modelName_in_model717 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_model726 = new BitSet(new long[]{0x0800084800600040L,0x0000000000220001L});
	public static final BitSet FOLLOW_mt_in_model730 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_model732 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_modelName751 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_include_file_in_mt796 = new BitSet(new long[]{0x0800084800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_timeseries_in_mt808 = new BitSet(new long[]{0x0800084800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_svar_group_in_mt822 = new BitSet(new long[]{0x0800084800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_dvar_g_in_mt837 = new BitSet(new long[]{0x0800084800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_ex_g_in_mt856 = new BitSet(new long[]{0x0800084800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_alias_in_mt876 = new BitSet(new long[]{0x0800084800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_goal_s_in_mt895 = new BitSet(new long[]{0x0800084800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_goal_hs_in_mt912 = new BitSet(new long[]{0x0800084800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_network_in_mt926 = new BitSet(new long[]{0x0800084800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_weight_in_mt938 = new BitSet(new long[]{0x0800084800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_include_model_in_mt956 = new BitSet(new long[]{0x0800084800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_if_inc_items_in_mt968 = new BitSet(new long[]{0x0800084800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_if__in_if_inc_items1027 = new BitSet(new long[]{0x0000000060000002L});
	public static final BitSet FOLLOW_elseif__in_if_inc_items1030 = new BitSet(new long[]{0x0000000060000002L});
	public static final BitSet FOLLOW_else__in_if_inc_items1033 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_If_in_if_1053 = new BitSet(new long[]{0x22B205200C1626B0L,0x1C001498800C12C0L});
	public static final BitSet FOLLOW_logical_main_in_if_1058 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_if_1064 = new BitSet(new long[]{0x0000004800600040L,0x0000000000220001L});
	public static final BitSet FOLLOW_include_item_group_in_if_1066 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_if_1068 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Elseif_in_elseif_1093 = new BitSet(new long[]{0x22B205200C1626B0L,0x1C001498800C12C0L});
	public static final BitSet FOLLOW_logical_main_in_elseif_1097 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_elseif_1103 = new BitSet(new long[]{0x0000004800600040L,0x0000000000220001L});
	public static final BitSet FOLLOW_include_item_group_in_elseif_1105 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_elseif_1107 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_Else_in_else_1125 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_else_1127 = new BitSet(new long[]{0x0000004800600040L,0x0000000000220001L});
	public static final BitSet FOLLOW_include_item_group_in_else_1129 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_else_1131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_include_file_in_include_item_group1168 = new BitSet(new long[]{0x0000004800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_svar_group_in_include_item_group1183 = new BitSet(new long[]{0x0000004800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_dvar_g_in_include_item_group1198 = new BitSet(new long[]{0x0000004800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_alias_in_include_item_group1213 = new BitSet(new long[]{0x0000004800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_timeseries_in_include_item_group1229 = new BitSet(new long[]{0x0000004800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_goal_s_in_include_item_group1244 = new BitSet(new long[]{0x0000004800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_goal_hs_in_include_item_group1261 = new BitSet(new long[]{0x0000004800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_weight_in_include_item_group1306 = new BitSet(new long[]{0x0000004800600042L,0x0000000000220001L});
	public static final BitSet FOLLOW_weight_legacy_in_weight1364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_weight_new_in_weight1368 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OBJECTIVE_in_weight_legacy1377 = new BitSet(new long[]{0x0000002000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_local_deprecated_in_weight_legacy1381 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_objGroupName_in_weight_legacy1385 = new BitSet(new long[]{0x0000000000000000L,0x2008000000000000L});
	public static final BitSet FOLLOW_115_in_weight_legacy1387 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_weight_legacy1390 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_weight_legacy_unit_in_weight_legacy1392 = new BitSet(new long[]{0x0000000000000000L,0x4080000000000000L});
	public static final BitSet FOLLOW_126_in_weight_legacy1395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_objGroupName1408 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_119_in_weight_legacy_unit1421 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_weight_legacy_unit1425 = new BitSet(new long[]{0x0000000000000000L,0x0000088000000000L});
	public static final BitSet FOLLOW_weightTimeArray_in_weight_legacy_unit1431 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_weight_legacy_unit1437 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_weight_legacy_unit1441 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_weight_legacy_unit1443 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_weight_legacy_unit1445 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_weightTimeArray1459 = new BitSet(new long[]{0x0000012000000000L});
	public static final BitSet FOLLOW_set_in_weightTimeArray1463 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_weightTimeArray1473 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OBJECTIVE_in_weight_new1483 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_weightTableID_in_weight_new1486 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_weight_new1488 = new BitSet(new long[]{0x0000000000000000L,0x0000000100000000L});
	public static final BitSet FOLLOW_weight_group_in_weight_new1490 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_weight_new1492 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_weightTableID1504 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WEIGHT_in_weight_group1522 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_weight_group1526 = new BitSet(new long[]{0x0000000001800000L,0x0000000040000000L});
	public static final BitSet FOLLOW_weight_trunk_in_weight_group1536 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DeviationPenalty_in_weight_trunk1553 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_weight_trunk1559 = new BitSet(new long[]{0x0000000001000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_DeviationTolerance_in_weight_trunk1573 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_weight_trunk1577 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_VARIABLE_in_weight_trunk1589 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_weight_group_unit_in_weight_trunk1593 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_weight_subgroup_in_weight_trunk1597 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_ID_in_weight_group_unit1619 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_weight_subgroup1649 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_weight_subgroup1656 = new BitSet(new long[]{0x0000000001800000L,0x0000000040000000L});
	public static final BitSet FOLLOW_weight_subgroup_trunk_in_weight_subgroup1658 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_weight_subgroup1660 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DeviationPenalty_in_weight_subgroup_trunk1675 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_weight_subgroup_trunk1681 = new BitSet(new long[]{0x0000000001000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_DeviationTolerance_in_weight_subgroup_trunk1695 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_weight_subgroup_trunk1699 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
	public static final BitSet FOLLOW_VARIABLE_in_weight_subgroup_trunk1711 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_weight_subgroup_unit_in_weight_subgroup_trunk1715 = new BitSet(new long[]{0x0000002000000002L});
	public static final BitSet FOLLOW_ID_in_weight_subgroup_unit1733 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INCLUDE_in_include_model1749 = new BitSet(new long[]{0x0100001000000000L});
	public static final BitSet FOLLOW_set_in_include_model1751 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_include_model1759 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INCLUDE_in_include_file1785 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000020L});
	public static final BitSet FOLLOW_local_deprecated_in_include_file1788 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_file_path_in_include_file1794 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QUOTE_in_file_path1807 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_goal_s1839 = new BitSet(new long[]{0x0000002000000000L,0x0080008000000000L});
	public static final BitSet FOLLOW_local_deprecated_in_goal_s1843 = new BitSet(new long[]{0x0000002000000000L,0x0080008000000000L});
	public static final BitSet FOLLOW_goalSimpleArray_in_goal_s1848 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_goalSimpleTimeArray_in_goal_s1850 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_goal_s1856 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_goal_s1859 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_constraint_in_goal_s1865 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_goal_s1868 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_119_in_goalSimpleArray1884 = new BitSet(new long[]{0x0000012000000000L});
	public static final BitSet FOLLOW_set_in_goalSimpleArray1888 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_goalSimpleArray1898 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_goalSimpleTimeArray1908 = new BitSet(new long[]{0x0000012000000000L});
	public static final BitSet FOLLOW_set_in_goalSimpleTimeArray1912 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_goalSimpleTimeArray1922 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_GOAL_in_goal_hs1954 = new BitSet(new long[]{0x0000002000000000L,0x0080008000000000L});
	public static final BitSet FOLLOW_local_deprecated_in_goal_hs1958 = new BitSet(new long[]{0x0000002000000000L,0x0080008000000000L});
	public static final BitSet FOLLOW_goalHsArray_in_goal_hs1963 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_goalHsTimeArray_in_goal_hs1965 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_goal_hs1971 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_goal_hs1979 = new BitSet(new long[]{0x0000800000000000L});
	public static final BitSet FOLLOW_lhs_in_goal_hs1981 = new BitSet(new long[]{0x0000000000001000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goal_hs_nocase_in_goal_hs1989 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_goal_hs_cases_in_goal_hs1999 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_goal_hs2007 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_119_in_goalHsArray2019 = new BitSet(new long[]{0x0000012000000000L});
	public static final BitSet FOLLOW_set_in_goalHsArray2023 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_goalHsArray2033 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_goalHsTimeArray2043 = new BitSet(new long[]{0x0000012000000000L});
	public static final BitSet FOLLOW_set_in_goalHsTimeArray2047 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_goalHsTimeArray2057 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goal_hs_trunk_in_goal_hs_nocase2075 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_rhs_in_goal_hs_trunk2103 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_lhs_gt_rhs_in_goal_hs_trunk2107 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_lhs_lt_rhs_in_goal_hs_trunk2109 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lhs_lt_rhs_in_goal_hs_trunk2116 = new BitSet(new long[]{0x0000800000000002L});
	public static final BitSet FOLLOW_lhs_gt_rhs_in_goal_hs_trunk2118 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_goal_hs_case_in_goal_hs_cases2131 = new BitSet(new long[]{0x0000000000001002L});
	public static final BitSet FOLLOW_CASE_in_goal_hs_case2146 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_goal_hs_case2150 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_goal_hs_case2152 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CONDITION_in_goal_hs_case2154 = new BitSet(new long[]{0x22B205200C1626B0L,0x1C001498800C12C0L});
	public static final BitSet FOLLOW_logical_main_in_goal_hs_case2158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_goal_hs_trunk_in_goal_hs_case2162 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_goal_hs_case2165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LHS_in_lhs2175 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_lhs2179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RHS_in_rhs2189 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_rhs2193 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LHS_in_lhs_gt_rhs2203 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
	public static final BitSet FOLLOW_117_in_lhs_gt_rhs2205 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_RHS_in_lhs_gt_rhs2207 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000010L});
	public static final BitSet FOLLOW_PENALTY_in_lhs_gt_rhs2211 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_lhs_gt_rhs2215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constrain_in_lhs_gt_rhs2221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LHS_in_lhs_lt_rhs2231 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
	public static final BitSet FOLLOW_113_in_lhs_lt_rhs2233 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
	public static final BitSet FOLLOW_RHS_in_lhs_lt_rhs2235 = new BitSet(new long[]{0x0000000000000000L,0x0200000000000010L});
	public static final BitSet FOLLOW_PENALTY_in_lhs_lt_rhs2239 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_lhs_lt_rhs2243 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_constrain_in_lhs_lt_rhs2249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_121_in_constrain2260 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alias_new_in_alias2290 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_alias_old_in_alias2294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_alias_old2305 = new BitSet(new long[]{0x0000002000000000L,0x0080008000000000L});
	public static final BitSet FOLLOW_local_deprecated_in_alias_old2310 = new BitSet(new long[]{0x0000002000000000L,0x0080008000000000L});
	public static final BitSet FOLLOW_aliasArray_in_alias_old2315 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_aliasTimeArray_in_alias_old2317 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_aliasID_in_alias_old2321 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_alias_old2323 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_ALIAS_in_alias_old2325 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_aliasExpresion_in_alias_old2328 = new BitSet(new long[]{0x8000200000000000L,0x4000000004000000L});
	public static final BitSet FOLLOW_aliasKind_in_alias_old2331 = new BitSet(new long[]{0x8000000000000000L,0x4000000004000000L});
	public static final BitSet FOLLOW_aliasUnits_in_alias_old2335 = new BitSet(new long[]{0x8000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_aliasNoSolver_in_alias_old2338 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_alias_old2341 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALIAS_in_alias_new2349 = new BitSet(new long[]{0x0000002000000000L,0x0080008000000000L});
	public static final BitSet FOLLOW_aliasArray_in_alias_new2353 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_aliasTimeArray_in_alias_new2355 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_aliasID_in_alias_new2359 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_alias_new2361 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_aliasExpresion_in_alias_new2363 = new BitSet(new long[]{0x8000200000000000L,0x4000000004000000L});
	public static final BitSet FOLLOW_aliasKind_in_alias_new2366 = new BitSet(new long[]{0x8000000000000000L,0x4000000004000000L});
	public static final BitSet FOLLOW_aliasUnits_in_alias_new2370 = new BitSet(new long[]{0x8000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_aliasNoSolver_in_alias_new2373 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_alias_new2376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_add_in_aliasExpresion2387 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_aliasID2399 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNITS_in_aliasUnits2408 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_QUOTE_in_aliasUnits2412 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KIND_in_aliasKind2421 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_QUOTE_in_aliasKind2425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NoSolver_in_aliasNoSolver2434 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_119_in_aliasArray2448 = new BitSet(new long[]{0x0000012000000000L});
	public static final BitSet FOLLOW_set_in_aliasArray2452 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_aliasArray2462 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_aliasTimeArray2472 = new BitSet(new long[]{0x0000012000000000L});
	public static final BitSet FOLLOW_set_in_aliasTimeArray2476 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_aliasTimeArray2486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SVAR_in_svar_group2506 = new BitSet(new long[]{0x0000002000000000L,0x0080008000000000L});
	public static final BitSet FOLLOW_DEFINE_in_svar_group2511 = new BitSet(new long[]{0x0000002000000000L,0x0080008000000000L});
	public static final BitSet FOLLOW_local_deprecated_in_svar_group2516 = new BitSet(new long[]{0x0000002000000000L,0x0080008000000000L});
	public static final BitSet FOLLOW_svar_g_in_svar_group2522 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_in_svar_g2556 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_array_in_svar_g2560 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_timeArray_in_svar_g2564 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_svarID2578 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svarID_in_svar2589 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_svar2591 = new BitSet(new long[]{0x0000000000001000L,0x1000000020010400L});
	public static final BitSet FOLLOW_svar_trunk_in_svar2593 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_svar2595 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svarArray_in_svar_array2603 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_svar_in_svar_array2605 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svarTimeArray_in_svar_timeArray2612 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_svar_in_svar_timeArray2614 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_119_in_svarArray2627 = new BitSet(new long[]{0x0000012000000000L});
	public static final BitSet FOLLOW_set_in_svarArray2631 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_svarArray2641 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_svarTimeArray2651 = new BitSet(new long[]{0x0000012000000000L});
	public static final BitSet FOLLOW_set_in_svarTimeArray2655 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_svarTimeArray2665 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_noCase_in_svar_trunk2682 = new BitSet(new long[]{0x0000200000000002L});
	public static final BitSet FOLLOW_svar_case_in_svar_trunk2686 = new BitSet(new long[]{0x0000200000001002L});
	public static final BitSet FOLLOW_svarKind_in_svar_trunk2693 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_svarUnits_in_svar_trunk2695 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNITS_in_svarUnits2707 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_QUOTE_in_svarUnits2709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KIND_in_svarKind2717 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_QUOTE_in_svarKind2719 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_value_in_svar_noCase2735 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_sum_in_svar_noCase2739 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_table_in_svar_noCase2743 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CASE_in_svar_case2761 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_svar_case2765 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_svar_case2767 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_CONDITION_in_svar_case2769 = new BitSet(new long[]{0x22B205200C1626B0L,0x1C001498800C12C0L});
	public static final BitSet FOLLOW_logical_main_in_svar_case2773 = new BitSet(new long[]{0x0000000000000000L,0x1000000020010400L});
	public static final BitSet FOLLOW_svar_value_in_svar_case2777 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_svar_sum_in_svar_case2781 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_svar_table_in_svar_case2785 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_svar_case2790 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VALUE_in_svar_value2801 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_svar_value2805 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sum_header_in_svar_sum2819 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_sum_content_in_svar_sum2823 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SUM_in_sum_header2836 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_sum_header2838 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
	public static final BitSet FOLLOW_123_in_sum_header2840 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_115_in_sum_header2842 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_sum_header2846 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_sum_header2848 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_sum_header2852 = new BitSet(new long[]{0x0000000000000000L,0x0000090000000000L});
	public static final BitSet FOLLOW_107_in_sum_header2855 = new BitSet(new long[]{0x0000010000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_integer_in_sum_header2857 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_sum_header2862 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_add_in_sum_content2877 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_table_1_in_svar_table2890 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_svar_table_2_in_svar_table2898 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_svar_table_12911 = new BitSet(new long[]{0x0200002000100000L,0x0000000080000000L});
	public static final BitSet FOLLOW_ID_in_svar_table_12916 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_reservedID_in_svar_table_12918 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_FROM_in_svar_table_12927 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_svar_table_12933 = new BitSet(new long[]{0x0000000400000002L,0x0000000200000000L});
	public static final BitSet FOLLOW_GIVEN_in_svar_table_12942 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_assign_in_svar_table_12946 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
	public static final BitSet FOLLOW_USE_in_svar_table_12955 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_svar_table_12962 = new BitSet(new long[]{0x0000000000000002L,0x0000000200000000L});
	public static final BitSet FOLLOW_WHERE_in_svar_table_12973 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_where_in_svar_table_12977 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_assign_in_where2991 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_where2994 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_assign_in_where2996 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
	public static final BitSet FOLLOW_124_in_svar_table_23008 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_svar_table_23010 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_svar_table_23012 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_119_in_dimension3024 = new BitSet(new long[]{0x0000012000000000L});
	public static final BitSet FOLLOW_set_in_dimension3026 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_dimension3036 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_dimension_time3045 = new BitSet(new long[]{0x0000012000000000L});
	public static final BitSet FOLLOW_set_in_dimension_time3047 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_dimension_time3057 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timeseries_new_in_timeseries3096 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timeseries_old_in_timeseries3100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TIMESERIES_in_timeseries_new3109 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_tsID_in_timeseries_new3112 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_timeseries_new3119 = new BitSet(new long[]{0x0400200000000000L});
	public static final BitSet FOLLOW_NAME_in_timeseries_new3122 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_bpart_id_in_timeseries_new3129 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_tsKind_in_timeseries_new3133 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_tsUnits_in_timeseries_new3135 = new BitSet(new long[]{0x0000000000010000L,0x4000000000000000L});
	public static final BitSet FOLLOW_convert_in_timeseries_new3137 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_timeseries_new3140 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_timeseries_old3148 = new BitSet(new long[]{0x0000002000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_local_deprecated_in_timeseries_old3152 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_tsID_in_timeseries_old3156 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_timeseries_old3160 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
	public static final BitSet FOLLOW_TIMESERIES_in_timeseries_old3162 = new BitSet(new long[]{0x0000200000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_bpart_id_in_timeseries_old3164 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_tsKind_in_timeseries_old3167 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_tsUnits_in_timeseries_old3169 = new BitSet(new long[]{0x0000000000010000L,0x4000000000000000L});
	public static final BitSet FOLLOW_convert_in_timeseries_old3171 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_timeseries_old3174 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_tsID3188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNITS_in_tsUnits3200 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_QUOTE_in_tsUnits3204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KIND_in_tsKind3214 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_QUOTE_in_tsKind3218 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_QUOTE_in_bpart_id3233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CONVERT_in_convert3242 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_QUOTE_in_convert3246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NETWORK_in_network3257 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_network3259 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_network3261 = new BitSet(new long[]{0x100000A000000000L});
	public static final BitSet FOLLOW_node_in_network3263 = new BitSet(new long[]{0x000000A000000000L});
	public static final BitSet FOLLOW_connection_in_network3266 = new BitSet(new long[]{0x000000A000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_network3269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NODE_in_node3280 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_node3285 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_node3289 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_node3291 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
	public static final BitSet FOLLOW_branch_in_connection3304 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_branch_short_in_connection3308 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INFLOW_in_inlet3324 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_element_in_inlet3327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_element_in_outlet3341 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_OUTFLOW_in_outlet3343 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INFLOW_in_inoutlet3355 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_element_in_inoutlet3357 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
	public static final BitSet FOLLOW_OUTFLOW_in_inoutlet3359 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_inoutlet_in_branch_short3368 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_elements_in_branch3378 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_inlet_in_branch3382 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_FLOW_in_branch3385 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_element_in_branch3389 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_FLOW_in_branch3391 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_elements_in_branch3397 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_outlet_in_branch3401 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_element_in_elements3416 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_elements3420 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_element_in_elements3422 = new BitSet(new long[]{0x0000000000000002L,0x0000080000000000L});
	public static final BitSet FOLLOW_ID_in_element3439 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_element3442 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_element3444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ex_old_in_ex_g3489 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ex_id3501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_ex_old3512 = new BitSet(new long[]{0x0000002000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_local_deprecated_in_ex_old3516 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ex_id_in_ex_old3520 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_ex_old3522 = new BitSet(new long[]{0x0000000010000000L});
	public static final BitSet FOLLOW_EXTERNAL_in_ex_old3524 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ex_fileName_in_ex_old3528 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_ex_old3532 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_ex_fileName3541 = new BitSet(new long[]{0x0000000000000002L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_ex_fileName3544 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_ex_fileName3546 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dvar_group_new_in_dvar_g3587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dvar_group_old_in_dvar_g3591 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_dvarID3606 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEFINE_in_dvar_group_old3615 = new BitSet(new long[]{0x0000002000000000L,0x0080008000000000L});
	public static final BitSet FOLLOW_local_deprecated_in_dvar_group_old3619 = new BitSet(new long[]{0x0000002000000000L,0x0080008000000000L});
	public static final BitSet FOLLOW_dvar_in_dvar_group_old3623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DVAR_in_dvar_group_new3630 = new BitSet(new long[]{0x0000002000000000L,0x0080008000000000L});
	public static final BitSet FOLLOW_dvar_in_dvar_group_new3636 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dvarArray_in_dvar3645 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_dvarTimeArray_in_dvar3647 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_dvarID_in_dvar3651 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
	public static final BitSet FOLLOW_125_in_dvar3653 = new BitSet(new long[]{0x0004020000000800L,0x0002000008008000L});
	public static final BitSet FOLLOW_dvar_trunk_in_dvar3655 = new BitSet(new long[]{0x0000000000000000L,0x4000000000000000L});
	public static final BitSet FOLLOW_126_in_dvar3657 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_119_in_dvarArray3671 = new BitSet(new long[]{0x0000012000000000L});
	public static final BitSet FOLLOW_set_in_dvarArray3675 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_dvarArray3685 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_dvarTimeArray3695 = new BitSet(new long[]{0x0000012000000000L});
	public static final BitSet FOLLOW_set_in_dvarTimeArray3699 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_dvarTimeArray3709 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dvarIsInteger_in_dvar_trunk3737 = new BitSet(new long[]{0x0004000000000000L,0x0000000008008000L});
	public static final BitSet FOLLOW_std_in_dvar_trunk3742 = new BitSet(new long[]{0x0000200000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_lower_upper_in_dvar_trunk3750 = new BitSet(new long[]{0x0000200000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_dvarIsBinary_in_dvar_trunk3766 = new BitSet(new long[]{0x0000200000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_dvKindUnits_in_dvar_trunk3772 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_113_in_dvar_trunk3780 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_dvar_trunk3782 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
	public static final BitSet FOLLOW_117_in_dvar_trunk3784 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_dvarIsInteger3797 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_BINARY_in_dvarIsBinary3808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_119_in_index_assign3819 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_INT_in_index_assign3821 = new BitSet(new long[]{0x0000000000000000L,0x0101000000000000L});
	public static final BitSet FOLLOW_112_in_index_assign3824 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_INT_in_index_assign3826 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_index_assign3830 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_timeIndex_assign3838 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_INT_in_timeIndex_assign3840 = new BitSet(new long[]{0x0000000000000000L,0x0001010000000000L});
	public static final BitSet FOLLOW_112_in_timeIndex_assign3843 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_INT_in_timeIndex_assign3845 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_timeIndex_assign3849 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_lower_in_lower_upper3858 = new BitSet(new long[]{0x0000000000000002L,0x0000000008000000L});
	public static final BitSet FOLLOW_upper_in_lower_upper3860 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_upper_in_lower_upper3865 = new BitSet(new long[]{0x0004000000000002L});
	public static final BitSet FOLLOW_lower_in_lower_upper3867 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPPER_in_upper3875 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498820C1280L});
	public static final BitSet FOLLOW_expr_limited_in_upper3881 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNBOUNDED_in_upper3887 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOWER_in_lower3897 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498820C1280L});
	public static final BitSet FOLLOW_expr_limited_in_lower3903 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNBOUNDED_in_lower3909 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_add_in_expr_limited3920 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STD_in_std3929 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dvKind_in_dvKindUnits3938 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
	public static final BitSet FOLLOW_dvUnits_in_dvKindUnits3940 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dvUnits_in_dvKindUnits3944 = new BitSet(new long[]{0x0000200000000000L});
	public static final BitSet FOLLOW_dvKind_in_dvKindUnits3946 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_KIND_in_dvKind3954 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_QUOTE_in_dvKind3958 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UNITS_in_dvUnits3967 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
	public static final BitSet FOLLOW_QUOTE_in_dvUnits3971 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_or_in_logical_main3988 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALWAYS_in_logical_main3992 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_and_in_logical_or4007 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_logical_or4030 = new BitSet(new long[]{0x22B205200C162630L,0x1C001498800C12C0L});
	public static final BitSet FOLLOW_logical_and_in_logical_or4035 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
	public static final BitSet FOLLOW_logical_unary_in_logical_and4062 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_AND_in_logical_and4085 = new BitSet(new long[]{0x22B205200C162630L,0x1C001498800C12C0L});
	public static final BitSet FOLLOW_logical_unary_in_logical_and4091 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_NOT_in_logical_unary4112 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C12C0L});
	public static final BitSet FOLLOW_logical_term_in_logical_unary4115 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_relation_in_logical_term4138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_or_p_in_logical_term4157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_relation_p_in_logical_term4168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logicalFunc_in_logical_term4179 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_logical_or_p4196 = new BitSet(new long[]{0x22B205200C162630L,0x1C001498800C12C0L});
	public static final BitSet FOLLOW_logical_or_in_logical_or_p4198 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_logical_or_p4200 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_logical_relation_p4211 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_logical_relation_in_logical_relation_p4213 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_logical_relation_p4215 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_add_in_logical_relation4227 = new BitSet(new long[]{0x0000000000000000L,0x0076800000000000L});
	public static final BitSet FOLLOW_relation_token_in_logical_relation4230 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_logical_relation4233 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_RANGE_in_logicalFunc4245 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_logicalFunc4247 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_logicalFunc4249 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_logicalFunc4251 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_logicalFunc4253 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_logicalFunc4255 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_logicalFunc4257 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_logicalFunc4259 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_add_in_expr_constraint4298 = new BitSet(new long[]{0x0000000000000000L,0x006E000000000000L});
	public static final BitSet FOLLOW_constraint_token_in_expr_constraint4300 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_expr_constraint4302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_add_in_expr_relation4343 = new BitSet(new long[]{0x0000000000000000L,0x0076800000000000L});
	public static final BitSet FOLLOW_relation_token_in_expr_relation4346 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_expr_relation4349 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_add_in_expr_assign4370 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
	public static final BitSet FOLLOW_115_in_expr_assign4374 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_expr_assign4377 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_mult_simple_in_expr_add_simple4398 = new BitSet(new long[]{0x0000000000000002L,0x0000140000000000L});
	public static final BitSet FOLLOW_set_in_expr_add_simple4403 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_mult_simple_in_expr_add_simple4414 = new BitSet(new long[]{0x0000000000000002L,0x0000140000000000L});
	public static final BitSet FOLLOW_expr_unary_simple_in_expr_mult_simple4440 = new BitSet(new long[]{0x0000000000000002L,0x0000420000000000L});
	public static final BitSet FOLLOW_set_in_expr_mult_simple4445 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_unary_simple_in_expr_mult_simple4456 = new BitSet(new long[]{0x0000000000000002L,0x0000420000000000L});
	public static final BitSet FOLLOW_108_in_expr_unary_simple4474 = new BitSet(new long[]{0x00B205200C062630L,0x00000080000C1280L});
	public static final BitSet FOLLOW_expr_term_simple_in_expr_unary_simple4477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_simple_in_expr_term_simple4493 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_expr_term_simple4503 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_expr_term_simple4505 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_expr_term_simple4507 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_p_in_atom_simple4529 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_varID_in_atom_simple4540 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intrinsicFunc_simple_in_atom_simple4552 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mathFunc_simple_in_intrinsicFunc_simple4571 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multiInputFunc_simple_in_intrinsicFunc_simple4578 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unitFunc_simple_in_intrinsicFunc_simple4584 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOG_in_mathFunc_simple4599 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc_simple4601 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_mathFunc_simple4603 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc_simple4605 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_word_in_mathFunc_simple4613 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc_simple4615 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_mathFunc_simple4617 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc_simple4619 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ROUND_in_mathFunc_simple4627 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc_simple4629 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_mathFunc_simple4631 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc_simple4633 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_mathFunc_simple4641 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc_simple4643 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_mathFunc_simple4645 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_mathFunc_simple4647 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_mathFunc_simple4649 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc_simple4651 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SIN_in_mathFunc_simple4659 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc_simple4661 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_mathFunc_simple4663 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc_simple4665 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COS_in_mathFunc_simple4673 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc_simple4675 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_mathFunc_simple4677 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc_simple4679 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TAN_in_mathFunc_simple4687 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc_simple4689 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_mathFunc_simple4691 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc_simple4693 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COT_in_mathFunc_simple4701 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc_simple4703 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_mathFunc_simple4705 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc_simple4707 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASIN_in_mathFunc_simple4715 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc_simple4717 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_mathFunc_simple4719 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc_simple4721 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACOS_in_mathFunc_simple4729 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc_simple4731 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_mathFunc_simple4733 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc_simple4735 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATAN_in_mathFunc_simple4743 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc_simple4745 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_mathFunc_simple4747 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc_simple4749 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACOT_in_mathFunc_simple4757 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc_simple4759 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_mathFunc_simple4761 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc_simple4763 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exceedFunc_in_mathFunc_simple4771 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exceedtsiFunc_in_mathFunc_simple4778 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_unitFunc_simple4795 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_unitFunc_simple4806 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_unitFunc_simple4808 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_unitFunc_simple4810 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_multiInputFunc_simple4827 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_multiInputFunc_simple4837 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_multiInputFunc_simple4839 = new BitSet(new long[]{0x0000000000000000L,0x0000090000000000L});
	public static final BitSet FOLLOW_107_in_multiInputFunc_simple4843 = new BitSet(new long[]{0x00B205200C062630L,0x00001080000C1280L});
	public static final BitSet FOLLOW_expr_add_simple_in_multiInputFunc_simple4845 = new BitSet(new long[]{0x0000000000000000L,0x0000090000000000L});
	public static final BitSet FOLLOW_104_in_multiInputFunc_simple4850 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_mult_in_expr_add4876 = new BitSet(new long[]{0x0000000000000002L,0x0000140000000000L});
	public static final BitSet FOLLOW_set_in_expr_add4881 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_mult_in_expr_add4892 = new BitSet(new long[]{0x0000000000000002L,0x0000140000000000L});
	public static final BitSet FOLLOW_expr_unary_in_expr_mult4918 = new BitSet(new long[]{0x0000000000000002L,0x0000420000000000L});
	public static final BitSet FOLLOW_set_in_expr_mult4923 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_unary_in_expr_mult4934 = new BitSet(new long[]{0x0000000000000002L,0x0000420000000000L});
	public static final BitSet FOLLOW_expr_term_in_expr_unary4960 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_expr_term4976 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_expr_term4986 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_expr_term4988 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_expr_term4990 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_number_p_in_atom5013 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_varID_in_atom5024 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_intrinsicFunc_in_atom5037 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_specialVar_in_atom5052 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_externalFunc_in_atom5067 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_varFunc_in_atom5078 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_preCycleVar_in_atom5099 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_preCycleVar_old_in_preCycleVar5138 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_preCycleVarIndex_in_preCycleVar5146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_preCycleVar_old5161 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_119_in_preCycleVar_old5163 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_preCycleVar_old5167 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_preCycleVar_old5169 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_preCycleVar_old5172 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_preCycleVar_old5176 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_preCycleVar_old5178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_preCycleVarIndex5195 = new BitSet(new long[]{0x0000000000000000L,0x0080000000000000L});
	public static final BitSet FOLLOW_119_in_preCycleVarIndex5197 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_108_in_preCycleVarIndex5199 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_INT_in_preCycleVarIndex5201 = new BitSet(new long[]{0x0000000000000000L,0x0100000000000000L});
	public static final BitSet FOLLOW_120_in_preCycleVarIndex5203 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_preCycleVarIndex5206 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_preCycleVarIndex5210 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_preCycleVarIndex5212 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_122_in_externalFunc5227 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_externalFunc5229 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_externalFunc5231 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_externalFunc5233 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_externalFunc5235 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_externalFunc5237 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_mathFunc_in_intrinsicFunc5247 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multiInputFunc_in_intrinsicFunc5253 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_unitFunc_in_intrinsicFunc5258 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tableFunc_in_intrinsicFunc5263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_timeFunc_in_intrinsicFunc5268 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_sumFunc_in_intrinsicFunc5273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_103_in_sumFunc5283 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
	public static final BitSet FOLLOW_sum_header_in_sumFunc5285 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_sum_content_in_sumFunc5287 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_sumFunc5289 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_timeFunc5298 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_timeFunc5314 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_timeFunc5316 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_timeFunc5318 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_124_in_tableFunc5330 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_tableFunc5332 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_tableName_in_tableFunc5334 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_tableFunc5336 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_columnNumber_in_tableFunc5338 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_tableFunc5340 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_rowNumber_in_tableFunc5342 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_tableFunc5344 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_tableName5353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_columnNumber5361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_rowNumber5369 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_varID_in_varFunc5382 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_varFunc5384 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_func_arg_in_varFunc5386 = new BitSet(new long[]{0x0000000000000000L,0x0000090000000000L});
	public static final BitSet FOLLOW_107_in_varFunc5390 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_func_arg_in_varFunc5392 = new BitSet(new long[]{0x0000000000000000L,0x0000090000000000L});
	public static final BitSet FOLLOW_104_in_varFunc5399 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_varFunc5403 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_varFunc5405 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_varFunc5407 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_varID5422 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_expr_add_in_func_arg5430 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_trunk_timeArray_in_func_arg5432 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_varID_in_trunk_timeArray5444 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_trunk_timeArray5446 = new BitSet(new long[]{0x0000012000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_integer_in_trunk_timeArray5449 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_varID_in_trunk_timeArray5453 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
	public static final BitSet FOLLOW_112_in_trunk_timeArray5457 = new BitSet(new long[]{0x0000012000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_integer_in_trunk_timeArray5460 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_varID_in_trunk_timeArray5464 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_trunk_timeArray5468 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_in_number5479 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_real_in_number5483 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_p_in_number_p5491 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_real_p_in_number_p5495 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_p_in_integer5504 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_integer_n_in_integer5506 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_real_p_in_real5516 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_real_n_in_real5518 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_integer_p5527 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_108_in_integer_n5535 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_INT_in_integer_n5537 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_REAL_in_real_p5545 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_108_in_real_n5553 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_REAL_in_real_n5555 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_id_domain5567 = new BitSet(new long[]{0x0000000000000000L,0x0000200000000000L});
	public static final BitSet FOLLOW_109_in_id_domain5569 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_ID_in_id_domain5575 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LOG_in_mathFunc5591 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc5593 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_mathFunc5595 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc5597 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_word_in_mathFunc5605 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc5607 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_mathFunc5609 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc5611 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ROUND_in_mathFunc5619 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc5621 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_mathFunc5623 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc5625 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_MOD_in_mathFunc5633 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc5635 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_mathFunc5637 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_mathFunc5639 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_mathFunc5641 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc5643 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SIN_in_mathFunc5651 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc5653 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_mathFunc5655 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc5657 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COS_in_mathFunc5665 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc5667 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_mathFunc5669 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc5671 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TAN_in_mathFunc5679 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc5681 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_mathFunc5683 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc5685 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_COT_in_mathFunc5693 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc5695 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_mathFunc5697 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc5699 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ASIN_in_mathFunc5707 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc5709 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_mathFunc5711 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc5713 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACOS_in_mathFunc5721 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc5723 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_mathFunc5725 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc5727 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ATAN_in_mathFunc5735 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc5737 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_mathFunc5739 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc5741 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ACOT_in_mathFunc5749 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_mathFunc5751 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_mathFunc5753 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_mathFunc5755 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exceedFunc_in_mathFunc5763 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_exceedtsiFunc_in_mathFunc5770 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_unitFunc5785 = new BitSet(new long[]{0x0000000000000002L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_unitFunc5796 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_unitFunc5798 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_unitFunc5800 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_multiInputFunc5817 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_multiInputFunc5827 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_multiInputFunc5829 = new BitSet(new long[]{0x0000000000000000L,0x0000090000000000L});
	public static final BitSet FOLLOW_107_in_multiInputFunc5833 = new BitSet(new long[]{0x02B205200C162630L,0x1C001498800C1280L});
	public static final BitSet FOLLOW_expr_add_in_multiInputFunc5835 = new BitSet(new long[]{0x0000000000000000L,0x0000090000000000L});
	public static final BitSet FOLLOW_104_in_multiInputFunc5840 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXCEEDANCE_in_exceedFunc5854 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_exceedFunc5856 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_varID_in_exceedFunc5858 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedFunc5860 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_number_p_in_exceedFunc5862 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedFunc5864 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_varID_in_exceedFunc5866 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedFunc5868 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_integer_p_in_exceedFunc5870 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedFunc5872 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_varID_in_exceedFunc5874 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedFunc5876 = new BitSet(new long[]{0x0000010000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_integer_in_exceedFunc5878 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedFunc5880 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_integer_p_in_exceedFunc5882 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedFunc5884 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_varID_in_exceedFunc5886 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedFunc5888 = new BitSet(new long[]{0x0000010000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_integer_in_exceedFunc5890 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_exceedFunc5892 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EXCEEDANCE_TSI_in_exceedtsiFunc5910 = new BitSet(new long[]{0x0000000000000000L,0x0000008000000000L});
	public static final BitSet FOLLOW_103_in_exceedtsiFunc5912 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_varID_in_exceedtsiFunc5914 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedtsiFunc5916 = new BitSet(new long[]{0x0000010000000000L,0x0000000000000080L});
	public static final BitSet FOLLOW_number_p_in_exceedtsiFunc5918 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedtsiFunc5920 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_varID_in_exceedtsiFunc5922 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedtsiFunc5924 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_integer_p_in_exceedtsiFunc5926 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedtsiFunc5928 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_varID_in_exceedtsiFunc5930 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedtsiFunc5932 = new BitSet(new long[]{0x0000010000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_integer_in_exceedtsiFunc5934 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedtsiFunc5936 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_integer_p_in_exceedtsiFunc5938 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedtsiFunc5940 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_varID_in_exceedtsiFunc5942 = new BitSet(new long[]{0x0000000000000000L,0x0000080000000000L});
	public static final BitSet FOLLOW_107_in_exceedtsiFunc5944 = new BitSet(new long[]{0x0000010000000000L,0x0000100000000000L});
	public static final BitSet FOLLOW_integer_in_exceedtsiFunc5946 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
	public static final BitSet FOLLOW_104_in_exceedtsiFunc5948 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_relation_in_synpred1_WreslPlus4132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_logical_or_p_in_synpred2_WreslPlus4151 = new BitSet(new long[]{0x0000000000000002L});
}
