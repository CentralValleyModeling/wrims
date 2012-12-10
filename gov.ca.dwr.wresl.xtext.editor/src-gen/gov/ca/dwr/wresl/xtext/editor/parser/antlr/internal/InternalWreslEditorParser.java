package gov.ca.dwr.wresl.xtext.editor.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import gov.ca.dwr.wresl.xtext.editor.services.WreslEditorGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalWreslEditorParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_53", "KEYWORD_49", "KEYWORD_50", "KEYWORD_51", "KEYWORD_52", "KEYWORD_47", "KEYWORD_48", "KEYWORD_42", "KEYWORD_43", "KEYWORD_44", "KEYWORD_45", "KEYWORD_46", "KEYWORD_40", "KEYWORD_41", "KEYWORD_31", "KEYWORD_32", "KEYWORD_33", "KEYWORD_34", "KEYWORD_35", "KEYWORD_36", "KEYWORD_37", "KEYWORD_38", "KEYWORD_39", "KEYWORD_26", "KEYWORD_27", "KEYWORD_28", "KEYWORD_29", "KEYWORD_30", "KEYWORD_20", "KEYWORD_21", "KEYWORD_22", "KEYWORD_23", "KEYWORD_24", "KEYWORD_25", "KEYWORD_15", "KEYWORD_16", "KEYWORD_17", "KEYWORD_18", "KEYWORD_19", "KEYWORD_1", "KEYWORD_2", "KEYWORD_3", "KEYWORD_4", "KEYWORD_5", "KEYWORD_6", "KEYWORD_7", "KEYWORD_8", "KEYWORD_9", "KEYWORD_10", "KEYWORD_11", "KEYWORD_12", "KEYWORD_13", "KEYWORD_14", "RULE_RANGE", "RULE_MIN", "RULE_MAX", "RULE_INT", "RULE_FLOAT", "RULE_AND", "RULE_OR", "RULE_NOT", "RULE_ALWAYS", "RULE_ORDER", "RULE_STRING", "RULE_SL_COMMENT", "RULE_ID", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=69;
    public static final int RULE_ANY_OTHER=72;
    public static final int RULE_OR=63;
    public static final int KEYWORD_19=42;
    public static final int KEYWORD_17=40;
    public static final int RULE_MAX=59;
    public static final int KEYWORD_18=41;
    public static final int KEYWORD_53=4;
    public static final int KEYWORD_15=38;
    public static final int KEYWORD_52=8;
    public static final int RULE_AND=62;
    public static final int KEYWORD_16=39;
    public static final int KEYWORD_51=7;
    public static final int KEYWORD_50=6;
    public static final int KEYWORD_13=55;
    public static final int KEYWORD_14=56;
    public static final int KEYWORD_11=53;
    public static final int EOF=-1;
    public static final int KEYWORD_12=54;
    public static final int RULE_NOT=64;
    public static final int KEYWORD_10=52;
    public static final int KEYWORD_6=48;
    public static final int KEYWORD_7=49;
    public static final int KEYWORD_8=50;
    public static final int KEYWORD_9=51;
    public static final int KEYWORD_28=29;
    public static final int KEYWORD_29=30;
    public static final int RULE_INT=60;
    public static final int KEYWORD_24=36;
    public static final int KEYWORD_25=37;
    public static final int KEYWORD_26=27;
    public static final int KEYWORD_27=28;
    public static final int KEYWORD_20=32;
    public static final int KEYWORD_21=33;
    public static final int KEYWORD_22=34;
    public static final int KEYWORD_23=35;
    public static final int RULE_ORDER=66;
    public static final int RULE_MIN=58;
    public static final int KEYWORD_30=31;
    public static final int KEYWORD_1=43;
    public static final int KEYWORD_34=21;
    public static final int KEYWORD_5=47;
    public static final int KEYWORD_33=20;
    public static final int KEYWORD_4=46;
    public static final int KEYWORD_32=19;
    public static final int KEYWORD_3=45;
    public static final int KEYWORD_31=18;
    public static final int KEYWORD_2=44;
    public static final int KEYWORD_38=25;
    public static final int RULE_FLOAT=61;
    public static final int KEYWORD_37=24;
    public static final int RULE_SL_COMMENT=68;
    public static final int KEYWORD_36=23;
    public static final int KEYWORD_35=22;
    public static final int RULE_RANGE=57;
    public static final int RULE_ML_COMMENT=70;
    public static final int KEYWORD_39=26;
    public static final int RULE_STRING=67;
    public static final int KEYWORD_41=17;
    public static final int RULE_ALWAYS=65;
    public static final int KEYWORD_40=16;
    public static final int KEYWORD_43=12;
    public static final int KEYWORD_42=11;
    public static final int KEYWORD_45=14;
    public static final int KEYWORD_44=13;
    public static final int KEYWORD_47=9;
    public static final int RULE_WS=71;
    public static final int KEYWORD_46=15;
    public static final int KEYWORD_49=5;
    public static final int KEYWORD_48=10;

    // delegates
    // delegators


        public InternalWreslEditorParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalWreslEditorParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalWreslEditorParser.tokenNames; }
    public String getGrammarFileName() { return "../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     

    	private WreslEditorGrammarAccess grammarAccess;
    	 	
    	public InternalWreslEditorParser(TokenStream input, WreslEditorGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "WreslEvaluator";	
    	} 
    	   	   	
    	@Override
    	protected WreslEditorGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleWreslEvaluator"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:67:1: entryRuleWreslEvaluator returns [EObject current=null] : iv_ruleWreslEvaluator= ruleWreslEvaluator EOF ;
    public final EObject entryRuleWreslEvaluator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWreslEvaluator = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:68:2: (iv_ruleWreslEvaluator= ruleWreslEvaluator EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:69:2: iv_ruleWreslEvaluator= ruleWreslEvaluator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWreslEvaluatorRule()); 
            }
            pushFollow(FOLLOW_ruleWreslEvaluator_in_entryRuleWreslEvaluator73);
            iv_ruleWreslEvaluator=ruleWreslEvaluator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWreslEvaluator; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWreslEvaluator83); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWreslEvaluator"


    // $ANTLR start "ruleWreslEvaluator"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:76:1: ruleWreslEvaluator returns [EObject current=null] : ( ( ( (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern ) ) )+ | ( ( (lv_initial_1_0= ruleInitial ) )? ( (lv_sequence_2_0= ruleSequence ) )+ ( (lv_model_3_0= ruleModel ) )+ ) ) ;
    public final EObject ruleWreslEvaluator() throws RecognitionException {
        EObject current = null;

        EObject lv_pattern_0_1 = null;

        EObject lv_pattern_0_2 = null;

        EObject lv_initial_1_0 = null;

        EObject lv_sequence_2_0 = null;

        EObject lv_model_3_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:79:28: ( ( ( ( (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern ) ) )+ | ( ( (lv_initial_1_0= ruleInitial ) )? ( (lv_sequence_2_0= ruleSequence ) )+ ( (lv_model_3_0= ruleModel ) )+ ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:80:1: ( ( ( (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern ) ) )+ | ( ( (lv_initial_1_0= ruleInitial ) )? ( (lv_sequence_2_0= ruleSequence ) )+ ( (lv_model_3_0= ruleModel ) )+ ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:80:1: ( ( ( (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern ) ) )+ | ( ( (lv_initial_1_0= ruleInitial ) )? ( (lv_sequence_2_0= ruleSequence ) )+ ( (lv_model_3_0= ruleModel ) )+ ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==KEYWORD_51||LA6_0==KEYWORD_43||LA6_0==KEYWORD_40||LA6_0==KEYWORD_29) ) {
                alt6=1;
            }
            else if ( (LA6_0==KEYWORD_48||LA6_0==KEYWORD_44) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:80:2: ( ( (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern ) ) )+
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:80:2: ( ( (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern ) ) )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==KEYWORD_51||LA2_0==KEYWORD_43||LA2_0==KEYWORD_40||LA2_0==KEYWORD_29) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:81:1: ( (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern ) )
                    	    {
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:81:1: ( (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern ) )
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:82:1: (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern )
                    	    {
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:82:1: (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern )
                    	    int alt1=2;
                    	    int LA1_0 = input.LA(1);

                    	    if ( (LA1_0==KEYWORD_40) ) {
                    	        int LA1_1 = input.LA(2);

                    	        if ( (LA1_1==KEYWORD_11) ) {
                    	            int LA1_3 = input.LA(3);

                    	            if ( (LA1_3==KEYWORD_33) ) {
                    	                int LA1_5 = input.LA(4);

                    	                if ( (LA1_5==KEYWORD_12) ) {
                    	                    int LA1_7 = input.LA(5);

                    	                    if ( (LA1_7==RULE_ID) ) {
                    	                        int LA1_4 = input.LA(6);

                    	                        if ( (LA1_4==KEYWORD_13) ) {
                    	                            int LA1_6 = input.LA(7);

                    	                            if ( (LA1_6==KEYWORD_31) ) {
                    	                                alt1=1;
                    	                            }
                    	                            else if ( (LA1_6==KEYWORD_53||LA1_6==KEYWORD_47||LA1_6==KEYWORD_45||LA1_6==KEYWORD_41||LA1_6==KEYWORD_34||(LA1_6>=KEYWORD_37 && LA1_6<=KEYWORD_38)||LA1_6==KEYWORD_27||(LA1_6>=KEYWORD_23 && LA1_6<=KEYWORD_24)) ) {
                    	                                alt1=2;
                    	                            }
                    	                            else {
                    	                                if (state.backtracking>0) {state.failed=true; return current;}
                    	                                NoViableAltException nvae =
                    	                                    new NoViableAltException("", 1, 6, input);

                    	                                throw nvae;
                    	                            }
                    	                        }
                    	                        else {
                    	                            if (state.backtracking>0) {state.failed=true; return current;}
                    	                            NoViableAltException nvae =
                    	                                new NoViableAltException("", 1, 4, input);

                    	                            throw nvae;
                    	                        }
                    	                    }
                    	                    else {
                    	                        if (state.backtracking>0) {state.failed=true; return current;}
                    	                        NoViableAltException nvae =
                    	                            new NoViableAltException("", 1, 7, input);

                    	                        throw nvae;
                    	                    }
                    	                }
                    	                else {
                    	                    if (state.backtracking>0) {state.failed=true; return current;}
                    	                    NoViableAltException nvae =
                    	                        new NoViableAltException("", 1, 5, input);

                    	                    throw nvae;
                    	                }
                    	            }
                    	            else {
                    	                if (state.backtracking>0) {state.failed=true; return current;}
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 1, 3, input);

                    	                throw nvae;
                    	            }
                    	        }
                    	        else if ( (LA1_1==RULE_ID) ) {
                    	            int LA1_4 = input.LA(3);

                    	            if ( (LA1_4==KEYWORD_13) ) {
                    	                int LA1_6 = input.LA(4);

                    	                if ( (LA1_6==KEYWORD_31) ) {
                    	                    alt1=1;
                    	                }
                    	                else if ( (LA1_6==KEYWORD_53||LA1_6==KEYWORD_47||LA1_6==KEYWORD_45||LA1_6==KEYWORD_41||LA1_6==KEYWORD_34||(LA1_6>=KEYWORD_37 && LA1_6<=KEYWORD_38)||LA1_6==KEYWORD_27||(LA1_6>=KEYWORD_23 && LA1_6<=KEYWORD_24)) ) {
                    	                    alt1=2;
                    	                }
                    	                else {
                    	                    if (state.backtracking>0) {state.failed=true; return current;}
                    	                    NoViableAltException nvae =
                    	                        new NoViableAltException("", 1, 6, input);

                    	                    throw nvae;
                    	                }
                    	            }
                    	            else {
                    	                if (state.backtracking>0) {state.failed=true; return current;}
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 1, 4, input);

                    	                throw nvae;
                    	            }
                    	        }
                    	        else {
                    	            if (state.backtracking>0) {state.failed=true; return current;}
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 1, 1, input);

                    	            throw nvae;
                    	        }
                    	    }
                    	    else if ( (LA1_0==KEYWORD_51||LA1_0==KEYWORD_43||LA1_0==KEYWORD_29) ) {
                    	        alt1=2;
                    	    }
                    	    else {
                    	        if (state.backtracking>0) {state.failed=true; return current;}
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 1, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt1) {
                    	        case 1 :
                    	            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:83:3: lv_pattern_0_1= ruleAlias
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getWreslEvaluatorAccess().getPatternAliasParserRuleCall_0_0_0()); 
                    	              	    
                    	            }
                    	            pushFollow(FOLLOW_ruleAlias_in_ruleWreslEvaluator131);
                    	            lv_pattern_0_1=ruleAlias();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getWreslEvaluatorRule());
                    	              	        }
                    	                     		add(
                    	                     			current, 
                    	                     			"pattern",
                    	                      		lv_pattern_0_1, 
                    	                      		"Alias");
                    	              	        afterParserOrEnumRuleCall();
                    	              	    
                    	            }

                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:98:8: lv_pattern_0_2= rulePattern
                    	            {
                    	            if ( state.backtracking==0 ) {
                    	               
                    	              	        newCompositeNode(grammarAccess.getWreslEvaluatorAccess().getPatternPatternParserRuleCall_0_0_1()); 
                    	              	    
                    	            }
                    	            pushFollow(FOLLOW_rulePattern_in_ruleWreslEvaluator150);
                    	            lv_pattern_0_2=rulePattern();

                    	            state._fsp--;
                    	            if (state.failed) return current;
                    	            if ( state.backtracking==0 ) {

                    	              	        if (current==null) {
                    	              	            current = createModelElementForParent(grammarAccess.getWreslEvaluatorRule());
                    	              	        }
                    	                     		add(
                    	                     			current, 
                    	                     			"pattern",
                    	                      		lv_pattern_0_2, 
                    	                      		"Pattern");
                    	              	        afterParserOrEnumRuleCall();
                    	              	    
                    	            }

                    	            }
                    	            break;

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:117:6: ( ( (lv_initial_1_0= ruleInitial ) )? ( (lv_sequence_2_0= ruleSequence ) )+ ( (lv_model_3_0= ruleModel ) )+ )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:117:6: ( ( (lv_initial_1_0= ruleInitial ) )? ( (lv_sequence_2_0= ruleSequence ) )+ ( (lv_model_3_0= ruleModel ) )+ )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:117:7: ( (lv_initial_1_0= ruleInitial ) )? ( (lv_sequence_2_0= ruleSequence ) )+ ( (lv_model_3_0= ruleModel ) )+
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:117:7: ( (lv_initial_1_0= ruleInitial ) )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==KEYWORD_44) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:118:1: (lv_initial_1_0= ruleInitial )
                            {
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:118:1: (lv_initial_1_0= ruleInitial )
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:119:3: lv_initial_1_0= ruleInitial
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getWreslEvaluatorAccess().getInitialInitialParserRuleCall_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleInitial_in_ruleWreslEvaluator182);
                            lv_initial_1_0=ruleInitial();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getWreslEvaluatorRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"initial",
                                      		true, 
                                      		"Initial");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:135:3: ( (lv_sequence_2_0= ruleSequence ) )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==KEYWORD_48) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:136:1: (lv_sequence_2_0= ruleSequence )
                    	    {
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:136:1: (lv_sequence_2_0= ruleSequence )
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:137:3: lv_sequence_2_0= ruleSequence
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getWreslEvaluatorAccess().getSequenceSequenceParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleSequence_in_ruleWreslEvaluator204);
                    	    lv_sequence_2_0=ruleSequence();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getWreslEvaluatorRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"sequence",
                    	              		lv_sequence_2_0, 
                    	              		"Sequence");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:153:3: ( (lv_model_3_0= ruleModel ) )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==KEYWORD_35) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:154:1: (lv_model_3_0= ruleModel )
                    	    {
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:154:1: (lv_model_3_0= ruleModel )
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:155:3: lv_model_3_0= ruleModel
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getWreslEvaluatorAccess().getModelModelParserRuleCall_1_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleModel_in_ruleWreslEvaluator226);
                    	    lv_model_3_0=ruleModel();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getWreslEvaluatorRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"model",
                    	              		lv_model_3_0, 
                    	              		"Model");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWreslEvaluator"


    // $ANTLR start "entryRulePattern"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:179:1: entryRulePattern returns [EObject current=null] : iv_rulePattern= rulePattern EOF ;
    public final EObject entryRulePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePattern = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:180:2: (iv_rulePattern= rulePattern EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:181:2: iv_rulePattern= rulePattern EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternRule()); 
            }
            pushFollow(FOLLOW_rulePattern_in_entryRulePattern263);
            iv_rulePattern=rulePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePattern; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePattern273); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePattern"


    // $ANTLR start "rulePattern"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:188:1: rulePattern returns [EObject current=null] : (this_Define_0= ruleDefine | this_IncludeFile_1= ruleIncludeFile | ruleIncludeModel | this_Goal_3= ruleGoal | this_Objective_4= ruleObjective ) ;
    public final EObject rulePattern() throws RecognitionException {
        EObject current = null;

        EObject this_Define_0 = null;

        EObject this_IncludeFile_1 = null;

        EObject this_Goal_3 = null;

        EObject this_Objective_4 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:191:28: ( (this_Define_0= ruleDefine | this_IncludeFile_1= ruleIncludeFile | ruleIncludeModel | this_Goal_3= ruleGoal | this_Objective_4= ruleObjective ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:192:1: (this_Define_0= ruleDefine | this_IncludeFile_1= ruleIncludeFile | ruleIncludeModel | this_Goal_3= ruleGoal | this_Objective_4= ruleObjective )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:192:1: (this_Define_0= ruleDefine | this_IncludeFile_1= ruleIncludeFile | ruleIncludeModel | this_Goal_3= ruleGoal | this_Objective_4= ruleObjective )
            int alt7=5;
            switch ( input.LA(1) ) {
            case KEYWORD_40:
                {
                alt7=1;
                }
                break;
            case KEYWORD_43:
                {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==KEYWORD_35) ) {
                    alt7=3;
                }
                else if ( (LA7_2==KEYWORD_11||LA7_2==RULE_STRING) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case KEYWORD_29:
                {
                alt7=4;
                }
                break;
            case KEYWORD_51:
                {
                alt7=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:193:2: this_Define_0= ruleDefine
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatternAccess().getDefineParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDefine_in_rulePattern323);
                    this_Define_0=ruleDefine();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Define_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:206:2: this_IncludeFile_1= ruleIncludeFile
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatternAccess().getIncludeFileParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIncludeFile_in_rulePattern353);
                    this_IncludeFile_1=ruleIncludeFile();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_IncludeFile_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:219:2: ruleIncludeModel
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatternAccess().getIncludeModelParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIncludeModel_in_rulePattern377);
                    ruleIncludeModel();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:231:2: this_Goal_3= ruleGoal
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatternAccess().getGoalParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleGoal_in_rulePattern407);
                    this_Goal_3=ruleGoal();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Goal_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:244:2: this_Objective_4= ruleObjective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatternAccess().getObjectiveParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleObjective_in_rulePattern437);
                    this_Objective_4=ruleObjective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Objective_4;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePattern"


    // $ANTLR start "entryRuleObjective"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:263:1: entryRuleObjective returns [EObject current=null] : iv_ruleObjective= ruleObjective EOF ;
    public final EObject entryRuleObjective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjective = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:264:2: (iv_ruleObjective= ruleObjective EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:265:2: iv_ruleObjective= ruleObjective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectiveRule()); 
            }
            pushFollow(FOLLOW_ruleObjective_in_entryRuleObjective471);
            iv_ruleObjective=ruleObjective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjective; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjective481); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjective"


    // $ANTLR start "ruleObjective"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:272:1: ruleObjective returns [EObject current=null] : ( (otherlv_0= KEYWORD_51 | otherlv_1= KEYWORD_51 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_9 otherlv_7= KEYWORD_13 ( (lv_weights_8_0= ruleWeightItem ) )+ otherlv_9= KEYWORD_14 ) ;
    public final EObject ruleObjective() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_local_3_1=null;
        Token lv_local_3_2=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_weights_8_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:275:28: ( ( (otherlv_0= KEYWORD_51 | otherlv_1= KEYWORD_51 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_9 otherlv_7= KEYWORD_13 ( (lv_weights_8_0= ruleWeightItem ) )+ otherlv_9= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:276:1: ( (otherlv_0= KEYWORD_51 | otherlv_1= KEYWORD_51 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_9 otherlv_7= KEYWORD_13 ( (lv_weights_8_0= ruleWeightItem ) )+ otherlv_9= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:276:1: ( (otherlv_0= KEYWORD_51 | otherlv_1= KEYWORD_51 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_9 otherlv_7= KEYWORD_13 ( (lv_weights_8_0= ruleWeightItem ) )+ otherlv_9= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:276:2: (otherlv_0= KEYWORD_51 | otherlv_1= KEYWORD_51 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_9 otherlv_7= KEYWORD_13 ( (lv_weights_8_0= ruleWeightItem ) )+ otherlv_9= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:276:2: (otherlv_0= KEYWORD_51 | otherlv_1= KEYWORD_51 )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==KEYWORD_51) ) {
                int LA8_1 = input.LA(2);

                if ( (synpred11_InternalWreslEditorParser()) ) {
                    alt8=1;
                }
                else if ( (true) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:277:2: otherlv_0= KEYWORD_51
                    {
                    otherlv_0=(Token)match(input,KEYWORD_51,FOLLOW_KEYWORD_51_in_ruleObjective520); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getObjectiveAccess().getObjectiveKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:283:2: otherlv_1= KEYWORD_51
                    {
                    otherlv_1=(Token)match(input,KEYWORD_51,FOLLOW_KEYWORD_51_in_ruleObjective538); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getObjectiveAccess().getOBJECTIVEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:287:2: (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==KEYWORD_11) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:288:2: otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12
                    {
                    otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleObjective552); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getObjectiveAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:292:1: ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:293:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:293:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:294:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:294:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==KEYWORD_33) ) {
                        int LA9_1 = input.LA(2);

                        if ( (synpred12_InternalWreslEditorParser()) ) {
                            alt9=1;
                        }
                        else if ( (true) ) {
                            alt9=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;
                    }
                    switch (alt9) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:295:3: lv_local_3_1= KEYWORD_33
                            {
                            lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleObjective572); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_local_3_1, grammarAccess.getObjectiveAccess().getLocalLocalKeyword_1_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getObjectiveRule());
                              	        }
                                     		setWithLastConsumed(current, "local", true, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:308:8: lv_local_3_2= KEYWORD_33
                            {
                            lv_local_3_2=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleObjective600); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_local_3_2, grammarAccess.getObjectiveAccess().getLocalLOCALKeyword_1_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getObjectiveRule());
                              	        }
                                     		setWithLastConsumed(current, "local", true, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_4=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleObjective627); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getObjectiveAccess().getRightSquareBracketKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:329:3: ( (lv_name_5_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:330:1: (lv_name_5_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:330:1: (lv_name_5_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:331:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjective645); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_5_0, grammarAccess.getObjectiveAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getObjectiveRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_5_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_ruleObjective663); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getObjectiveAccess().getEqualsSignKeyword_3());
                  
            }
            otherlv_7=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleObjective675); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getObjectiveAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:357:1: ( (lv_weights_8_0= ruleWeightItem ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==KEYWORD_11) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:358:1: (lv_weights_8_0= ruleWeightItem )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:358:1: (lv_weights_8_0= ruleWeightItem )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:359:3: lv_weights_8_0= ruleWeightItem
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getObjectiveAccess().getWeightsWeightItemParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleWeightItem_in_ruleObjective695);
            	    lv_weights_8_0=ruleWeightItem();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getObjectiveRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"weights",
            	              		lv_weights_8_0, 
            	              		"WeightItem");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

            otherlv_9=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleObjective709); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getObjectiveAccess().getRightCurlyBracketKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjective"


    // $ANTLR start "entryRuleWeightItem"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:388:1: entryRuleWeightItem returns [EObject current=null] : iv_ruleWeightItem= ruleWeightItem EOF ;
    public final EObject entryRuleWeightItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWeightItem = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:389:2: (iv_ruleWeightItem= ruleWeightItem EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:390:2: iv_ruleWeightItem= ruleWeightItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWeightItemRule()); 
            }
            pushFollow(FOLLOW_ruleWeightItem_in_entryRuleWeightItem743);
            iv_ruleWeightItem=ruleWeightItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWeightItem; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWeightItem753); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWeightItem"


    // $ANTLR start "ruleWeightItem"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:397:1: ruleWeightItem returns [EObject current=null] : (otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) ) otherlv_2= KEYWORD_5 ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= KEYWORD_12 (otherlv_5= KEYWORD_5 )? ) ;
    public final EObject ruleWeightItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:400:28: ( (otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) ) otherlv_2= KEYWORD_5 ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= KEYWORD_12 (otherlv_5= KEYWORD_5 )? ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:401:1: (otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) ) otherlv_2= KEYWORD_5 ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= KEYWORD_12 (otherlv_5= KEYWORD_5 )? )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:401:1: (otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) ) otherlv_2= KEYWORD_5 ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= KEYWORD_12 (otherlv_5= KEYWORD_5 )? )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:402:2: otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) ) otherlv_2= KEYWORD_5 ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= KEYWORD_12 (otherlv_5= KEYWORD_5 )?
            {
            otherlv_0=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleWeightItem791); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getWeightItemAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:406:1: ( (lv_name_1_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:407:1: (lv_name_1_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:407:1: (lv_name_1_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:408:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWeightItem807); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getWeightItemAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getWeightItemRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleWeightItem825); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getWeightItemAccess().getCommaKeyword_2());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:429:1: ( (lv_expression_3_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:430:1: (lv_expression_3_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:430:1: (lv_expression_3_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:431:3: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getWeightItemAccess().getExpressionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleWeightItem845);
            lv_expression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getWeightItemRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_3_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleWeightItem858); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getWeightItemAccess().getRightSquareBracketKeyword_4());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:452:1: (otherlv_5= KEYWORD_5 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==KEYWORD_5) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:453:2: otherlv_5= KEYWORD_5
                    {
                    otherlv_5=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleWeightItem871); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getWeightItemAccess().getCommaKeyword_5());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWeightItem"


    // $ANTLR start "entryRuleDefine"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:465:1: entryRuleDefine returns [EObject current=null] : iv_ruleDefine= ruleDefine EOF ;
    public final EObject entryRuleDefine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefine = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:466:2: (iv_ruleDefine= ruleDefine EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:467:2: iv_ruleDefine= ruleDefine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefineRule()); 
            }
            pushFollow(FOLLOW_ruleDefine_in_entryRuleDefine907);
            iv_ruleDefine=ruleDefine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefine; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefine917); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefine"


    // $ANTLR start "ruleDefine"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:474:1: ruleDefine returns [EObject current=null] : ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) ) ) otherlv_8= KEYWORD_14 ) ;
    public final EObject ruleDefine() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_local_3_1=null;
        Token lv_local_3_2=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_definition_7_1 = null;

        EObject lv_definition_7_2 = null;

        EObject lv_definition_7_3 = null;

        EObject lv_definition_7_4 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:477:28: ( ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) ) ) otherlv_8= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:478:1: ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) ) ) otherlv_8= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:478:1: ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) ) ) otherlv_8= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:478:2: (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) ) ) otherlv_8= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:478:2: (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==KEYWORD_40) ) {
                int LA13_1 = input.LA(2);

                if ( (synpred16_InternalWreslEditorParser()) ) {
                    alt13=1;
                }
                else if ( (true) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:479:2: otherlv_0= KEYWORD_40
                    {
                    otherlv_0=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_ruleDefine956); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getDefineAccess().getDefineKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:485:2: otherlv_1= KEYWORD_40
                    {
                    otherlv_1=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_ruleDefine974); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDefineAccess().getDEFINEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:489:2: (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==KEYWORD_11) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:490:2: otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12
                    {
                    otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleDefine988); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDefineAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:494:1: ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:495:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:495:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:496:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:496:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==KEYWORD_33) ) {
                        int LA14_1 = input.LA(2);

                        if ( (synpred17_InternalWreslEditorParser()) ) {
                            alt14=1;
                        }
                        else if ( (true) ) {
                            alt14=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 14, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 14, 0, input);

                        throw nvae;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:497:3: lv_local_3_1= KEYWORD_33
                            {
                            lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleDefine1008); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_local_3_1, grammarAccess.getDefineAccess().getLocalLocalKeyword_1_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getDefineRule());
                              	        }
                                     		setWithLastConsumed(current, "local", true, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:510:8: lv_local_3_2= KEYWORD_33
                            {
                            lv_local_3_2=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleDefine1036); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_local_3_2, grammarAccess.getDefineAccess().getLocalLOCALKeyword_1_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getDefineRule());
                              	        }
                                     		setWithLastConsumed(current, "local", true, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_4=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleDefine1063); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDefineAccess().getRightSquareBracketKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:531:3: ( (lv_name_5_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:532:1: (lv_name_5_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:532:1: (lv_name_5_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:533:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefine1081); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_5_0, grammarAccess.getDefineAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDefineRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_5_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleDefine1099); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getDefineAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:554:1: ( ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:555:1: ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:555:1: ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:556:1: (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:556:1: (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal )
            int alt16=4;
            switch ( input.LA(1) ) {
            case KEYWORD_34:
            case KEYWORD_37:
            case KEYWORD_23:
                {
                alt16=1;
                }
                break;
            case KEYWORD_53:
            case KEYWORD_41:
            case KEYWORD_38:
            case KEYWORD_27:
            case KEYWORD_24:
                {
                alt16=2;
                }
                break;
            case KEYWORD_45:
                {
                alt16=3;
                }
                break;
            case KEYWORD_47:
                {
                alt16=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:557:3: lv_definition_7_1= ruleDVar
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineAccess().getDefinitionDVarParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDVar_in_ruleDefine1121);
                    lv_definition_7_1=ruleDVar();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDefineRule());
                      	        }
                             		set(
                             			current, 
                             			"definition",
                              		lv_definition_7_1, 
                              		"DVar");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:572:8: lv_definition_7_2= ruleSVar
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineAccess().getDefinitionSVarParserRuleCall_4_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSVar_in_ruleDefine1140);
                    lv_definition_7_2=ruleSVar();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDefineRule());
                      	        }
                             		set(
                             			current, 
                             			"definition",
                              		lv_definition_7_2, 
                              		"SVar");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:587:8: lv_definition_7_3= ruleDVarInteger
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineAccess().getDefinitionDVarIntegerParserRuleCall_4_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDVarInteger_in_ruleDefine1159);
                    lv_definition_7_3=ruleDVarInteger();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDefineRule());
                      	        }
                             		set(
                             			current, 
                             			"definition",
                              		lv_definition_7_3, 
                              		"DVarInteger");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 4 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:602:8: lv_definition_7_4= ruleExternal
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineAccess().getDefinitionExternalParserRuleCall_4_0_3()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExternal_in_ruleDefine1178);
                    lv_definition_7_4=ruleExternal();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getDefineRule());
                      	        }
                             		set(
                             			current, 
                             			"definition",
                              		lv_definition_7_4, 
                              		"External");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


            }


            }

            otherlv_8=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleDefine1194); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getDefineAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefine"


    // $ANTLR start "entryRuleExternal"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:633:1: entryRuleExternal returns [EObject current=null] : iv_ruleExternal= ruleExternal EOF ;
    public final EObject entryRuleExternal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternal = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:634:2: (iv_ruleExternal= ruleExternal EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:635:2: iv_ruleExternal= ruleExternal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExternalRule()); 
            }
            pushFollow(FOLLOW_ruleExternal_in_entryRuleExternal1228);
            iv_ruleExternal=ruleExternal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExternal; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternal1238); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternal"


    // $ANTLR start "ruleExternal"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:642:1: ruleExternal returns [EObject current=null] : ( (otherlv_0= KEYWORD_47 | otherlv_1= KEYWORD_47 ) ( ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) ) | ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) ) ) ) ;
    public final EObject ruleExternal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:645:28: ( ( (otherlv_0= KEYWORD_47 | otherlv_1= KEYWORD_47 ) ( ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) ) | ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:646:1: ( (otherlv_0= KEYWORD_47 | otherlv_1= KEYWORD_47 ) ( ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) ) | ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:646:1: ( (otherlv_0= KEYWORD_47 | otherlv_1= KEYWORD_47 ) ( ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) ) | ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:646:2: (otherlv_0= KEYWORD_47 | otherlv_1= KEYWORD_47 ) ( ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) ) | ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:646:2: (otherlv_0= KEYWORD_47 | otherlv_1= KEYWORD_47 )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==KEYWORD_47) ) {
                int LA17_1 = input.LA(2);

                if ( (synpred22_InternalWreslEditorParser()) ) {
                    alt17=1;
                }
                else if ( (true) ) {
                    alt17=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:647:2: otherlv_0= KEYWORD_47
                    {
                    otherlv_0=(Token)match(input,KEYWORD_47,FOLLOW_KEYWORD_47_in_ruleExternal1277); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getExternalAccess().getExternalKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:653:2: otherlv_1= KEYWORD_47
                    {
                    otherlv_1=(Token)match(input,KEYWORD_47,FOLLOW_KEYWORD_47_in_ruleExternal1295); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExternalAccess().getEXTERNALKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:657:2: ( ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) ) | ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            else if ( (LA20_0==KEYWORD_20) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:657:3: ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:657:3: ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:657:4: ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:657:4: ( (lv_name_2_0= RULE_ID ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:658:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:658:1: (lv_name_2_0= RULE_ID )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:659:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternal1314); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_name_2_0, grammarAccess.getExternalAccess().getNameIDTerminalRuleCall_1_0_0_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getExternalRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"name",
                              		lv_name_2_0, 
                              		"ID");
                      	    
                    }

                    }


                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:675:2: (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==KEYWORD_26) ) {
                        int LA18_1 = input.LA(2);

                        if ( (synpred23_InternalWreslEditorParser()) ) {
                            alt18=1;
                        }
                        else if ( (true) ) {
                            alt18=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 18, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;
                    }
                    switch (alt18) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:676:2: otherlv_3= KEYWORD_26
                            {
                            otherlv_3=(Token)match(input,KEYWORD_26,FOLLOW_KEYWORD_26_in_ruleExternal1333); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getExternalAccess().getDllKeyword_1_0_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:682:2: otherlv_4= KEYWORD_26
                            {
                            otherlv_4=(Token)match(input,KEYWORD_26,FOLLOW_KEYWORD_26_in_ruleExternal1351); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getExternalAccess().getDLLKeyword_1_0_1_1());
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:687:6: ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:687:6: ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:687:7: () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:687:7: ()
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:688:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getExternalAccess().getExternalAction_1_1_0(),
                                  current);
                          
                    }

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:696:2: (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==KEYWORD_20) ) {
                        int LA19_1 = input.LA(2);

                        if ( (synpred25_InternalWreslEditorParser()) ) {
                            alt19=1;
                        }
                        else if ( (true) ) {
                            alt19=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:697:2: otherlv_6= KEYWORD_20
                            {
                            otherlv_6=(Token)match(input,KEYWORD_20,FOLLOW_KEYWORD_20_in_ruleExternal1385); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getExternalAccess().getF90Keyword_1_1_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:703:2: otherlv_7= KEYWORD_20
                            {
                            otherlv_7=(Token)match(input,KEYWORD_20,FOLLOW_KEYWORD_20_in_ruleExternal1403); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getExternalAccess().getF90Keyword_1_1_1_1());
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternal"


    // $ANTLR start "entryRuleAlias"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:715:1: entryRuleAlias returns [EObject current=null] : iv_ruleAlias= ruleAlias EOF ;
    public final EObject entryRuleAlias() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlias = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:716:2: (iv_ruleAlias= ruleAlias EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:717:2: iv_ruleAlias= ruleAlias EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAliasRule()); 
            }
            pushFollow(FOLLOW_ruleAlias_in_entryRuleAlias1440);
            iv_ruleAlias=ruleAlias();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlias; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlias1450); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAlias"


    // $ANTLR start "ruleAlias"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:724:1: ruleAlias returns [EObject current=null] : ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 (otherlv_7= KEYWORD_31 | otherlv_8= KEYWORD_31 ) ( (lv_expression_9_0= ruleExpression ) ) ( (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 ) ( (lv_kind_12_0= RULE_STRING ) ) )? ( (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 ) ( (lv_units_15_0= RULE_STRING ) ) )? otherlv_16= KEYWORD_14 ) ;
    public final EObject ruleAlias() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_local_3_1=null;
        Token lv_local_3_2=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token lv_kind_12_0=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token lv_units_15_0=null;
        Token otherlv_16=null;
        EObject lv_expression_9_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:727:28: ( ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 (otherlv_7= KEYWORD_31 | otherlv_8= KEYWORD_31 ) ( (lv_expression_9_0= ruleExpression ) ) ( (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 ) ( (lv_kind_12_0= RULE_STRING ) ) )? ( (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 ) ( (lv_units_15_0= RULE_STRING ) ) )? otherlv_16= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:728:1: ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 (otherlv_7= KEYWORD_31 | otherlv_8= KEYWORD_31 ) ( (lv_expression_9_0= ruleExpression ) ) ( (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 ) ( (lv_kind_12_0= RULE_STRING ) ) )? ( (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 ) ( (lv_units_15_0= RULE_STRING ) ) )? otherlv_16= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:728:1: ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 (otherlv_7= KEYWORD_31 | otherlv_8= KEYWORD_31 ) ( (lv_expression_9_0= ruleExpression ) ) ( (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 ) ( (lv_kind_12_0= RULE_STRING ) ) )? ( (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 ) ( (lv_units_15_0= RULE_STRING ) ) )? otherlv_16= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:728:2: (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 (otherlv_7= KEYWORD_31 | otherlv_8= KEYWORD_31 ) ( (lv_expression_9_0= ruleExpression ) ) ( (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 ) ( (lv_kind_12_0= RULE_STRING ) ) )? ( (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 ) ( (lv_units_15_0= RULE_STRING ) ) )? otherlv_16= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:728:2: (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==KEYWORD_40) ) {
                int LA21_1 = input.LA(2);

                if ( (synpred26_InternalWreslEditorParser()) ) {
                    alt21=1;
                }
                else if ( (true) ) {
                    alt21=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:729:2: otherlv_0= KEYWORD_40
                    {
                    otherlv_0=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_ruleAlias1489); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getAliasAccess().getDefineKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:735:2: otherlv_1= KEYWORD_40
                    {
                    otherlv_1=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_ruleAlias1507); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getAliasAccess().getDEFINEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:739:2: (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==KEYWORD_11) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:740:2: otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12
                    {
                    otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleAlias1521); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAliasAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:744:1: ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:745:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:745:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:746:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:746:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==KEYWORD_33) ) {
                        int LA22_1 = input.LA(2);

                        if ( (synpred27_InternalWreslEditorParser()) ) {
                            alt22=1;
                        }
                        else if ( (true) ) {
                            alt22=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 22, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:747:3: lv_local_3_1= KEYWORD_33
                            {
                            lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleAlias1541); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_local_3_1, grammarAccess.getAliasAccess().getLocalLocalKeyword_1_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAliasRule());
                              	        }
                                     		setWithLastConsumed(current, "local", true, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:760:8: lv_local_3_2= KEYWORD_33
                            {
                            lv_local_3_2=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleAlias1569); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_local_3_2, grammarAccess.getAliasAccess().getLocalLOCALKeyword_1_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getAliasRule());
                              	        }
                                     		setWithLastConsumed(current, "local", true, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_4=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleAlias1596); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getAliasAccess().getRightSquareBracketKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:781:3: ( (lv_name_5_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:782:1: (lv_name_5_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:782:1: (lv_name_5_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:783:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAlias1614); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_5_0, grammarAccess.getAliasAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getAliasRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_5_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleAlias1632); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAliasAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:804:1: (otherlv_7= KEYWORD_31 | otherlv_8= KEYWORD_31 )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==KEYWORD_31) ) {
                int LA24_1 = input.LA(2);

                if ( (synpred29_InternalWreslEditorParser()) ) {
                    alt24=1;
                }
                else if ( (true) ) {
                    alt24=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:805:2: otherlv_7= KEYWORD_31
                    {
                    otherlv_7=(Token)match(input,KEYWORD_31,FOLLOW_KEYWORD_31_in_ruleAlias1645); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getAliasAccess().getAliasKeyword_4_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:811:2: otherlv_8= KEYWORD_31
                    {
                    otherlv_8=(Token)match(input,KEYWORD_31,FOLLOW_KEYWORD_31_in_ruleAlias1663); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getAliasAccess().getALIASKeyword_4_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:815:2: ( (lv_expression_9_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:816:1: (lv_expression_9_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:816:1: (lv_expression_9_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:817:3: lv_expression_9_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAliasAccess().getExpressionExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleAlias1684);
            lv_expression_9_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAliasRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_9_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:833:2: ( (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 ) ( (lv_kind_12_0= RULE_STRING ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==KEYWORD_30) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:833:3: (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 ) ( (lv_kind_12_0= RULE_STRING ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:833:3: (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==KEYWORD_30) ) {
                        int LA25_1 = input.LA(2);

                        if ( (synpred30_InternalWreslEditorParser()) ) {
                            alt25=1;
                        }
                        else if ( (true) ) {
                            alt25=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 25, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;
                    }
                    switch (alt25) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:834:2: otherlv_10= KEYWORD_30
                            {
                            otherlv_10=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleAlias1699); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_10, grammarAccess.getAliasAccess().getKindKeyword_6_0_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:840:2: otherlv_11= KEYWORD_30
                            {
                            otherlv_11=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleAlias1717); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_11, grammarAccess.getAliasAccess().getKINDKeyword_6_0_1());
                                  
                            }

                            }
                            break;

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:844:2: ( (lv_kind_12_0= RULE_STRING ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:845:1: (lv_kind_12_0= RULE_STRING )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:845:1: (lv_kind_12_0= RULE_STRING )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:846:3: lv_kind_12_0= RULE_STRING
                    {
                    lv_kind_12_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAlias1734); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_kind_12_0, grammarAccess.getAliasAccess().getKindSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAliasRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"kind",
                              		lv_kind_12_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:862:4: ( (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 ) ( (lv_units_15_0= RULE_STRING ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==KEYWORD_36) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:862:5: (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 ) ( (lv_units_15_0= RULE_STRING ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:862:5: (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 )
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==KEYWORD_36) ) {
                        int LA27_1 = input.LA(2);

                        if ( (synpred32_InternalWreslEditorParser()) ) {
                            alt27=1;
                        }
                        else if ( (true) ) {
                            alt27=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 27, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 27, 0, input);

                        throw nvae;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:863:2: otherlv_13= KEYWORD_36
                            {
                            otherlv_13=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleAlias1756); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_13, grammarAccess.getAliasAccess().getUnitsKeyword_7_0_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:869:2: otherlv_14= KEYWORD_36
                            {
                            otherlv_14=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleAlias1774); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_14, grammarAccess.getAliasAccess().getUNITSKeyword_7_0_1());
                                  
                            }

                            }
                            break;

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:873:2: ( (lv_units_15_0= RULE_STRING ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:874:1: (lv_units_15_0= RULE_STRING )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:874:1: (lv_units_15_0= RULE_STRING )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:875:3: lv_units_15_0= RULE_STRING
                    {
                    lv_units_15_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAlias1791); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_units_15_0, grammarAccess.getAliasAccess().getUnitsSTRINGTerminalRuleCall_7_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getAliasRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"units",
                              		lv_units_15_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_16=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleAlias1811); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_16, grammarAccess.getAliasAccess().getRightCurlyBracketKeyword_8());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAlias"


    // $ANTLR start "entryRuleDVar"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:904:1: entryRuleDVar returns [EObject current=null] : iv_ruleDVar= ruleDVar EOF ;
    public final EObject entryRuleDVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDVar = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:905:2: (iv_ruleDVar= ruleDVar EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:906:2: iv_ruleDVar= ruleDVar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDVarRule()); 
            }
            pushFollow(FOLLOW_ruleDVar_in_entryRuleDVar1845);
            iv_ruleDVar=ruleDVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDVar; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDVar1855); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDVar"


    // $ANTLR start "ruleDVar"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:913:1: ruleDVar returns [EObject current=null] : (this_DVarStd_0= ruleDVarStd | this_DVarNonStd_1= ruleDVarNonStd ) ;
    public final EObject ruleDVar() throws RecognitionException {
        EObject current = null;

        EObject this_DVarStd_0 = null;

        EObject this_DVarNonStd_1 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:916:28: ( (this_DVarStd_0= ruleDVarStd | this_DVarNonStd_1= ruleDVarNonStd ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:917:1: (this_DVarStd_0= ruleDVarStd | this_DVarNonStd_1= ruleDVarNonStd )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:917:1: (this_DVarStd_0= ruleDVarStd | this_DVarNonStd_1= ruleDVarNonStd )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==KEYWORD_23) ) {
                alt29=1;
            }
            else if ( (LA29_0==KEYWORD_34||LA29_0==KEYWORD_37) ) {
                alt29=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:918:2: this_DVarStd_0= ruleDVarStd
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDVarAccess().getDVarStdParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDVarStd_in_ruleDVar1905);
                    this_DVarStd_0=ruleDVarStd();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_DVarStd_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:931:2: this_DVarNonStd_1= ruleDVarNonStd
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDVarAccess().getDVarNonStdParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDVarNonStd_in_ruleDVar1935);
                    this_DVarNonStd_1=ruleDVarNonStd();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_DVarNonStd_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDVar"


    // $ANTLR start "entryRuleDVarNonStd"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:950:1: entryRuleDVarNonStd returns [EObject current=null] : iv_ruleDVarNonStd= ruleDVarNonStd EOF ;
    public final EObject entryRuleDVarNonStd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDVarNonStd = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:951:2: (iv_ruleDVarNonStd= ruleDVarNonStd EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:952:2: iv_ruleDVarNonStd= ruleDVarNonStd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDVarNonStdRule()); 
            }
            pushFollow(FOLLOW_ruleDVarNonStd_in_entryRuleDVarNonStd1969);
            iv_ruleDVarNonStd=ruleDVarNonStd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDVarNonStd; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDVarNonStd1979); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDVarNonStd"


    // $ANTLR start "ruleDVarNonStd"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:959:1: ruleDVarNonStd returns [EObject current=null] : ( ( (lv_lowerUpper_0_0= ruleLowerAndOrUpper ) ) (otherlv_1= KEYWORD_30 | otherlv_2= KEYWORD_30 ) ( (lv_kind_3_0= RULE_STRING ) ) (otherlv_4= KEYWORD_36 | otherlv_5= KEYWORD_36 ) ( (lv_units_6_0= RULE_STRING ) ) ) ;
    public final EObject ruleDVarNonStd() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_kind_3_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_units_6_0=null;
        EObject lv_lowerUpper_0_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:962:28: ( ( ( (lv_lowerUpper_0_0= ruleLowerAndOrUpper ) ) (otherlv_1= KEYWORD_30 | otherlv_2= KEYWORD_30 ) ( (lv_kind_3_0= RULE_STRING ) ) (otherlv_4= KEYWORD_36 | otherlv_5= KEYWORD_36 ) ( (lv_units_6_0= RULE_STRING ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:963:1: ( ( (lv_lowerUpper_0_0= ruleLowerAndOrUpper ) ) (otherlv_1= KEYWORD_30 | otherlv_2= KEYWORD_30 ) ( (lv_kind_3_0= RULE_STRING ) ) (otherlv_4= KEYWORD_36 | otherlv_5= KEYWORD_36 ) ( (lv_units_6_0= RULE_STRING ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:963:1: ( ( (lv_lowerUpper_0_0= ruleLowerAndOrUpper ) ) (otherlv_1= KEYWORD_30 | otherlv_2= KEYWORD_30 ) ( (lv_kind_3_0= RULE_STRING ) ) (otherlv_4= KEYWORD_36 | otherlv_5= KEYWORD_36 ) ( (lv_units_6_0= RULE_STRING ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:963:2: ( (lv_lowerUpper_0_0= ruleLowerAndOrUpper ) ) (otherlv_1= KEYWORD_30 | otherlv_2= KEYWORD_30 ) ( (lv_kind_3_0= RULE_STRING ) ) (otherlv_4= KEYWORD_36 | otherlv_5= KEYWORD_36 ) ( (lv_units_6_0= RULE_STRING ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:963:2: ( (lv_lowerUpper_0_0= ruleLowerAndOrUpper ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:964:1: (lv_lowerUpper_0_0= ruleLowerAndOrUpper )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:964:1: (lv_lowerUpper_0_0= ruleLowerAndOrUpper )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:965:3: lv_lowerUpper_0_0= ruleLowerAndOrUpper
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDVarNonStdAccess().getLowerUpperLowerAndOrUpperParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLowerAndOrUpper_in_ruleDVarNonStd2025);
            lv_lowerUpper_0_0=ruleLowerAndOrUpper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getDVarNonStdRule());
              	        }
                     		set(
                     			current, 
                     			"lowerUpper",
                      		lv_lowerUpper_0_0, 
                      		"LowerAndOrUpper");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:981:2: (otherlv_1= KEYWORD_30 | otherlv_2= KEYWORD_30 )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==KEYWORD_30) ) {
                int LA30_1 = input.LA(2);

                if ( (synpred35_InternalWreslEditorParser()) ) {
                    alt30=1;
                }
                else if ( (true) ) {
                    alt30=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:982:2: otherlv_1= KEYWORD_30
                    {
                    otherlv_1=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarNonStd2039); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDVarNonStdAccess().getKindKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:988:2: otherlv_2= KEYWORD_30
                    {
                    otherlv_2=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarNonStd2057); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDVarNonStdAccess().getKINDKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:992:2: ( (lv_kind_3_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:993:1: (lv_kind_3_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:993:1: (lv_kind_3_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:994:3: lv_kind_3_0= RULE_STRING
            {
            lv_kind_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarNonStd2074); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_kind_3_0, grammarAccess.getDVarNonStdAccess().getKindSTRINGTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDVarNonStdRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"kind",
                      		lv_kind_3_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1010:2: (otherlv_4= KEYWORD_36 | otherlv_5= KEYWORD_36 )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==KEYWORD_36) ) {
                int LA31_1 = input.LA(2);

                if ( (synpred36_InternalWreslEditorParser()) ) {
                    alt31=1;
                }
                else if ( (true) ) {
                    alt31=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1011:2: otherlv_4= KEYWORD_36
                    {
                    otherlv_4=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarNonStd2093); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDVarNonStdAccess().getUnitsKeyword_3_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1017:2: otherlv_5= KEYWORD_36
                    {
                    otherlv_5=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarNonStd2111); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getDVarNonStdAccess().getUNITSKeyword_3_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1021:2: ( (lv_units_6_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1022:1: (lv_units_6_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1022:1: (lv_units_6_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1023:3: lv_units_6_0= RULE_STRING
            {
            lv_units_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarNonStd2128); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_units_6_0, grammarAccess.getDVarNonStdAccess().getUnitsSTRINGTerminalRuleCall_4_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDVarNonStdRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"units",
                      		lv_units_6_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDVarNonStd"


    // $ANTLR start "entryRuleDVarStd"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1047:1: entryRuleDVarStd returns [EObject current=null] : iv_ruleDVarStd= ruleDVarStd EOF ;
    public final EObject entryRuleDVarStd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDVarStd = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1048:2: (iv_ruleDVarStd= ruleDVarStd EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1049:2: iv_ruleDVarStd= ruleDVarStd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDVarStdRule()); 
            }
            pushFollow(FOLLOW_ruleDVarStd_in_entryRuleDVarStd2168);
            iv_ruleDVarStd=ruleDVarStd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDVarStd; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDVarStd2178); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDVarStd"


    // $ANTLR start "ruleDVarStd"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1056:1: ruleDVarStd returns [EObject current=null] : ( (otherlv_0= KEYWORD_23 | otherlv_1= KEYWORD_23 ) (otherlv_2= KEYWORD_30 | otherlv_3= KEYWORD_30 ) ( (lv_kind_4_0= RULE_STRING ) ) (otherlv_5= KEYWORD_36 | otherlv_6= KEYWORD_36 ) ( (lv_units_7_0= RULE_STRING ) ) ) ;
    public final EObject ruleDVarStd() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_kind_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_units_7_0=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1059:28: ( ( (otherlv_0= KEYWORD_23 | otherlv_1= KEYWORD_23 ) (otherlv_2= KEYWORD_30 | otherlv_3= KEYWORD_30 ) ( (lv_kind_4_0= RULE_STRING ) ) (otherlv_5= KEYWORD_36 | otherlv_6= KEYWORD_36 ) ( (lv_units_7_0= RULE_STRING ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1060:1: ( (otherlv_0= KEYWORD_23 | otherlv_1= KEYWORD_23 ) (otherlv_2= KEYWORD_30 | otherlv_3= KEYWORD_30 ) ( (lv_kind_4_0= RULE_STRING ) ) (otherlv_5= KEYWORD_36 | otherlv_6= KEYWORD_36 ) ( (lv_units_7_0= RULE_STRING ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1060:1: ( (otherlv_0= KEYWORD_23 | otherlv_1= KEYWORD_23 ) (otherlv_2= KEYWORD_30 | otherlv_3= KEYWORD_30 ) ( (lv_kind_4_0= RULE_STRING ) ) (otherlv_5= KEYWORD_36 | otherlv_6= KEYWORD_36 ) ( (lv_units_7_0= RULE_STRING ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1060:2: (otherlv_0= KEYWORD_23 | otherlv_1= KEYWORD_23 ) (otherlv_2= KEYWORD_30 | otherlv_3= KEYWORD_30 ) ( (lv_kind_4_0= RULE_STRING ) ) (otherlv_5= KEYWORD_36 | otherlv_6= KEYWORD_36 ) ( (lv_units_7_0= RULE_STRING ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1060:2: (otherlv_0= KEYWORD_23 | otherlv_1= KEYWORD_23 )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==KEYWORD_23) ) {
                int LA32_1 = input.LA(2);

                if ( (synpred37_InternalWreslEditorParser()) ) {
                    alt32=1;
                }
                else if ( (true) ) {
                    alt32=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1061:2: otherlv_0= KEYWORD_23
                    {
                    otherlv_0=(Token)match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_ruleDVarStd2217); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getDVarStdAccess().getStdKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1067:2: otherlv_1= KEYWORD_23
                    {
                    otherlv_1=(Token)match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_ruleDVarStd2235); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDVarStdAccess().getSTDKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1071:2: (otherlv_2= KEYWORD_30 | otherlv_3= KEYWORD_30 )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==KEYWORD_30) ) {
                int LA33_1 = input.LA(2);

                if ( (synpred38_InternalWreslEditorParser()) ) {
                    alt33=1;
                }
                else if ( (true) ) {
                    alt33=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1072:2: otherlv_2= KEYWORD_30
                    {
                    otherlv_2=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarStd2249); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDVarStdAccess().getKindKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1078:2: otherlv_3= KEYWORD_30
                    {
                    otherlv_3=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarStd2267); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getDVarStdAccess().getKINDKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1082:2: ( (lv_kind_4_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1083:1: (lv_kind_4_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1083:1: (lv_kind_4_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1084:3: lv_kind_4_0= RULE_STRING
            {
            lv_kind_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarStd2284); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_kind_4_0, grammarAccess.getDVarStdAccess().getKindSTRINGTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDVarStdRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"kind",
                      		lv_kind_4_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1100:2: (otherlv_5= KEYWORD_36 | otherlv_6= KEYWORD_36 )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==KEYWORD_36) ) {
                int LA34_1 = input.LA(2);

                if ( (synpred39_InternalWreslEditorParser()) ) {
                    alt34=1;
                }
                else if ( (true) ) {
                    alt34=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1101:2: otherlv_5= KEYWORD_36
                    {
                    otherlv_5=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarStd2303); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getDVarStdAccess().getUnitsKeyword_3_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1107:2: otherlv_6= KEYWORD_36
                    {
                    otherlv_6=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarStd2321); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDVarStdAccess().getUNITSKeyword_3_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1111:2: ( (lv_units_7_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1112:1: (lv_units_7_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1112:1: (lv_units_7_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1113:3: lv_units_7_0= RULE_STRING
            {
            lv_units_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarStd2338); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_units_7_0, grammarAccess.getDVarStdAccess().getUnitsSTRINGTerminalRuleCall_4_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDVarStdRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"units",
                      		lv_units_7_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDVarStd"


    // $ANTLR start "entryRuleDVarInteger"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1137:1: entryRuleDVarInteger returns [EObject current=null] : iv_ruleDVarInteger= ruleDVarInteger EOF ;
    public final EObject entryRuleDVarInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDVarInteger = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1138:2: (iv_ruleDVarInteger= ruleDVarInteger EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1139:2: iv_ruleDVarInteger= ruleDVarInteger EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDVarIntegerRule()); 
            }
            pushFollow(FOLLOW_ruleDVarInteger_in_entryRuleDVarInteger2378);
            iv_ruleDVarInteger=ruleDVarInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDVarInteger; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDVarInteger2388); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDVarInteger"


    // $ANTLR start "ruleDVarInteger"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1146:1: ruleDVarInteger returns [EObject current=null] : (this_DVarIntegerStd_0= ruleDVarIntegerStd | this_DVarIntegerNonStd_1= ruleDVarIntegerNonStd ) ;
    public final EObject ruleDVarInteger() throws RecognitionException {
        EObject current = null;

        EObject this_DVarIntegerStd_0 = null;

        EObject this_DVarIntegerNonStd_1 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1149:28: ( (this_DVarIntegerStd_0= ruleDVarIntegerStd | this_DVarIntegerNonStd_1= ruleDVarIntegerNonStd ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1150:1: (this_DVarIntegerStd_0= ruleDVarIntegerStd | this_DVarIntegerNonStd_1= ruleDVarIntegerNonStd )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1150:1: (this_DVarIntegerStd_0= ruleDVarIntegerStd | this_DVarIntegerNonStd_1= ruleDVarIntegerNonStd )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==KEYWORD_45) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==KEYWORD_34||LA35_1==KEYWORD_37) ) {
                    alt35=2;
                }
                else if ( (LA35_1==KEYWORD_23) ) {
                    alt35=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1151:2: this_DVarIntegerStd_0= ruleDVarIntegerStd
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDVarIntegerAccess().getDVarIntegerStdParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDVarIntegerStd_in_ruleDVarInteger2438);
                    this_DVarIntegerStd_0=ruleDVarIntegerStd();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_DVarIntegerStd_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1164:2: this_DVarIntegerNonStd_1= ruleDVarIntegerNonStd
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDVarIntegerAccess().getDVarIntegerNonStdParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDVarIntegerNonStd_in_ruleDVarInteger2468);
                    this_DVarIntegerNonStd_1=ruleDVarIntegerNonStd();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_DVarIntegerNonStd_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDVarInteger"


    // $ANTLR start "entryRuleDVarIntegerStd"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1183:1: entryRuleDVarIntegerStd returns [EObject current=null] : iv_ruleDVarIntegerStd= ruleDVarIntegerStd EOF ;
    public final EObject entryRuleDVarIntegerStd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDVarIntegerStd = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1184:2: (iv_ruleDVarIntegerStd= ruleDVarIntegerStd EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1185:2: iv_ruleDVarIntegerStd= ruleDVarIntegerStd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDVarIntegerStdRule()); 
            }
            pushFollow(FOLLOW_ruleDVarIntegerStd_in_entryRuleDVarIntegerStd2502);
            iv_ruleDVarIntegerStd=ruleDVarIntegerStd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDVarIntegerStd; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDVarIntegerStd2512); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDVarIntegerStd"


    // $ANTLR start "ruleDVarIntegerStd"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1192:1: ruleDVarIntegerStd returns [EObject current=null] : ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) (otherlv_2= KEYWORD_23 | otherlv_3= KEYWORD_23 ) (otherlv_4= KEYWORD_30 | otherlv_5= KEYWORD_30 ) ( (lv_kind_6_0= RULE_STRING ) ) (otherlv_7= KEYWORD_36 | otherlv_8= KEYWORD_36 ) ( (lv_units_9_0= RULE_STRING ) ) ) ;
    public final EObject ruleDVarIntegerStd() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token lv_kind_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_units_9_0=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1195:28: ( ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) (otherlv_2= KEYWORD_23 | otherlv_3= KEYWORD_23 ) (otherlv_4= KEYWORD_30 | otherlv_5= KEYWORD_30 ) ( (lv_kind_6_0= RULE_STRING ) ) (otherlv_7= KEYWORD_36 | otherlv_8= KEYWORD_36 ) ( (lv_units_9_0= RULE_STRING ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1196:1: ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) (otherlv_2= KEYWORD_23 | otherlv_3= KEYWORD_23 ) (otherlv_4= KEYWORD_30 | otherlv_5= KEYWORD_30 ) ( (lv_kind_6_0= RULE_STRING ) ) (otherlv_7= KEYWORD_36 | otherlv_8= KEYWORD_36 ) ( (lv_units_9_0= RULE_STRING ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1196:1: ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) (otherlv_2= KEYWORD_23 | otherlv_3= KEYWORD_23 ) (otherlv_4= KEYWORD_30 | otherlv_5= KEYWORD_30 ) ( (lv_kind_6_0= RULE_STRING ) ) (otherlv_7= KEYWORD_36 | otherlv_8= KEYWORD_36 ) ( (lv_units_9_0= RULE_STRING ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1196:2: (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) (otherlv_2= KEYWORD_23 | otherlv_3= KEYWORD_23 ) (otherlv_4= KEYWORD_30 | otherlv_5= KEYWORD_30 ) ( (lv_kind_6_0= RULE_STRING ) ) (otherlv_7= KEYWORD_36 | otherlv_8= KEYWORD_36 ) ( (lv_units_9_0= RULE_STRING ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1196:2: (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==KEYWORD_45) ) {
                int LA36_1 = input.LA(2);

                if ( (synpred41_InternalWreslEditorParser()) ) {
                    alt36=1;
                }
                else if ( (true) ) {
                    alt36=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1197:2: otherlv_0= KEYWORD_45
                    {
                    otherlv_0=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_ruleDVarIntegerStd2551); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getDVarIntegerStdAccess().getIntegerKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1203:2: otherlv_1= KEYWORD_45
                    {
                    otherlv_1=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_ruleDVarIntegerStd2569); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDVarIntegerStdAccess().getINTEGERKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1207:2: (otherlv_2= KEYWORD_23 | otherlv_3= KEYWORD_23 )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==KEYWORD_23) ) {
                int LA37_1 = input.LA(2);

                if ( (synpred42_InternalWreslEditorParser()) ) {
                    alt37=1;
                }
                else if ( (true) ) {
                    alt37=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1208:2: otherlv_2= KEYWORD_23
                    {
                    otherlv_2=(Token)match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_ruleDVarIntegerStd2583); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDVarIntegerStdAccess().getStdKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1214:2: otherlv_3= KEYWORD_23
                    {
                    otherlv_3=(Token)match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_ruleDVarIntegerStd2601); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getDVarIntegerStdAccess().getSTDKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1218:2: (otherlv_4= KEYWORD_30 | otherlv_5= KEYWORD_30 )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==KEYWORD_30) ) {
                int LA38_1 = input.LA(2);

                if ( (synpred43_InternalWreslEditorParser()) ) {
                    alt38=1;
                }
                else if ( (true) ) {
                    alt38=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1219:2: otherlv_4= KEYWORD_30
                    {
                    otherlv_4=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarIntegerStd2615); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDVarIntegerStdAccess().getKindKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1225:2: otherlv_5= KEYWORD_30
                    {
                    otherlv_5=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarIntegerStd2633); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getDVarIntegerStdAccess().getKINDKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1229:2: ( (lv_kind_6_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1230:1: (lv_kind_6_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1230:1: (lv_kind_6_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1231:3: lv_kind_6_0= RULE_STRING
            {
            lv_kind_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarIntegerStd2650); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_kind_6_0, grammarAccess.getDVarIntegerStdAccess().getKindSTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDVarIntegerStdRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"kind",
                      		lv_kind_6_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1247:2: (otherlv_7= KEYWORD_36 | otherlv_8= KEYWORD_36 )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==KEYWORD_36) ) {
                int LA39_1 = input.LA(2);

                if ( (synpred44_InternalWreslEditorParser()) ) {
                    alt39=1;
                }
                else if ( (true) ) {
                    alt39=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1248:2: otherlv_7= KEYWORD_36
                    {
                    otherlv_7=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarIntegerStd2669); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getDVarIntegerStdAccess().getUnitsKeyword_4_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1254:2: otherlv_8= KEYWORD_36
                    {
                    otherlv_8=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarIntegerStd2687); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDVarIntegerStdAccess().getUNITSKeyword_4_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1258:2: ( (lv_units_9_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1259:1: (lv_units_9_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1259:1: (lv_units_9_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1260:3: lv_units_9_0= RULE_STRING
            {
            lv_units_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarIntegerStd2704); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_units_9_0, grammarAccess.getDVarIntegerStdAccess().getUnitsSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDVarIntegerStdRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"units",
                      		lv_units_9_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDVarIntegerStd"


    // $ANTLR start "entryRuleDVarIntegerNonStd"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1284:1: entryRuleDVarIntegerNonStd returns [EObject current=null] : iv_ruleDVarIntegerNonStd= ruleDVarIntegerNonStd EOF ;
    public final EObject entryRuleDVarIntegerNonStd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDVarIntegerNonStd = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1285:2: (iv_ruleDVarIntegerNonStd= ruleDVarIntegerNonStd EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1286:2: iv_ruleDVarIntegerNonStd= ruleDVarIntegerNonStd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDVarIntegerNonStdRule()); 
            }
            pushFollow(FOLLOW_ruleDVarIntegerNonStd_in_entryRuleDVarIntegerNonStd2744);
            iv_ruleDVarIntegerNonStd=ruleDVarIntegerNonStd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDVarIntegerNonStd; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDVarIntegerNonStd2754); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDVarIntegerNonStd"


    // $ANTLR start "ruleDVarIntegerNonStd"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1293:1: ruleDVarIntegerNonStd returns [EObject current=null] : ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) this_LowerAndOrUpper_2= ruleLowerAndOrUpper (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) ) ;
    public final EObject ruleDVarIntegerNonStd() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_kind_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_units_8_0=null;
        EObject this_LowerAndOrUpper_2 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1296:28: ( ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) this_LowerAndOrUpper_2= ruleLowerAndOrUpper (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1297:1: ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) this_LowerAndOrUpper_2= ruleLowerAndOrUpper (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1297:1: ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) this_LowerAndOrUpper_2= ruleLowerAndOrUpper (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1297:2: (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) this_LowerAndOrUpper_2= ruleLowerAndOrUpper (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1297:2: (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==KEYWORD_45) ) {
                int LA40_1 = input.LA(2);

                if ( (synpred45_InternalWreslEditorParser()) ) {
                    alt40=1;
                }
                else if ( (true) ) {
                    alt40=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1298:2: otherlv_0= KEYWORD_45
                    {
                    otherlv_0=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_ruleDVarIntegerNonStd2793); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getDVarIntegerNonStdAccess().getIntegerKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1304:2: otherlv_1= KEYWORD_45
                    {
                    otherlv_1=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_ruleDVarIntegerNonStd2811); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDVarIntegerNonStdAccess().getINTEGERKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getDVarIntegerNonStdAccess().getLowerAndOrUpperParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleLowerAndOrUpper_in_ruleDVarIntegerNonStd2836);
            this_LowerAndOrUpper_2=ruleLowerAndOrUpper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_LowerAndOrUpper_2;
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1320:1: (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==KEYWORD_30) ) {
                int LA41_1 = input.LA(2);

                if ( (synpred46_InternalWreslEditorParser()) ) {
                    alt41=1;
                }
                else if ( (true) ) {
                    alt41=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1321:2: otherlv_3= KEYWORD_30
                    {
                    otherlv_3=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarIntegerNonStd2849); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getDVarIntegerNonStdAccess().getKindKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1327:2: otherlv_4= KEYWORD_30
                    {
                    otherlv_4=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarIntegerNonStd2867); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDVarIntegerNonStdAccess().getKINDKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1331:2: ( (lv_kind_5_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1332:1: (lv_kind_5_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1332:1: (lv_kind_5_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1333:3: lv_kind_5_0= RULE_STRING
            {
            lv_kind_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarIntegerNonStd2884); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_kind_5_0, grammarAccess.getDVarIntegerNonStdAccess().getKindSTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDVarIntegerNonStdRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"kind",
                      		lv_kind_5_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1349:2: (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==KEYWORD_36) ) {
                int LA42_1 = input.LA(2);

                if ( (synpred47_InternalWreslEditorParser()) ) {
                    alt42=1;
                }
                else if ( (true) ) {
                    alt42=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 42, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1350:2: otherlv_6= KEYWORD_36
                    {
                    otherlv_6=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarIntegerNonStd2903); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDVarIntegerNonStdAccess().getUnitsKeyword_4_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1356:2: otherlv_7= KEYWORD_36
                    {
                    otherlv_7=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarIntegerNonStd2921); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getDVarIntegerNonStdAccess().getUNITSKeyword_4_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1360:2: ( (lv_units_8_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1361:1: (lv_units_8_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1361:1: (lv_units_8_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1362:3: lv_units_8_0= RULE_STRING
            {
            lv_units_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarIntegerNonStd2938); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_units_8_0, grammarAccess.getDVarIntegerNonStdAccess().getUnitsSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getDVarIntegerNonStdRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"units",
                      		lv_units_8_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDVarIntegerNonStd"


    // $ANTLR start "entryRuleSVar"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1386:1: entryRuleSVar returns [EObject current=null] : iv_ruleSVar= ruleSVar EOF ;
    public final EObject entryRuleSVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSVar = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1387:2: (iv_ruleSVar= ruleSVar EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1388:2: iv_ruleSVar= ruleSVar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSVarRule()); 
            }
            pushFollow(FOLLOW_ruleSVar_in_entryRuleSVar2978);
            iv_ruleSVar=ruleSVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSVar; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSVar2988); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSVar"


    // $ANTLR start "ruleSVar"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1395:1: ruleSVar returns [EObject current=null] : (this_SVarDSS_0= ruleSVarDSS | this_SVarExpression_1= ruleSVarExpression | this_SVarSum_2= ruleSVarSum | this_SVarTable_3= ruleSVarTable | this_SVarCase_4= ruleSVarCase ) ;
    public final EObject ruleSVar() throws RecognitionException {
        EObject current = null;

        EObject this_SVarDSS_0 = null;

        EObject this_SVarExpression_1 = null;

        EObject this_SVarSum_2 = null;

        EObject this_SVarTable_3 = null;

        EObject this_SVarCase_4 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1398:28: ( (this_SVarDSS_0= ruleSVarDSS | this_SVarExpression_1= ruleSVarExpression | this_SVarSum_2= ruleSVarSum | this_SVarTable_3= ruleSVarTable | this_SVarCase_4= ruleSVarCase ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1399:1: (this_SVarDSS_0= ruleSVarDSS | this_SVarExpression_1= ruleSVarExpression | this_SVarSum_2= ruleSVarSum | this_SVarTable_3= ruleSVarTable | this_SVarCase_4= ruleSVarCase )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1399:1: (this_SVarDSS_0= ruleSVarDSS | this_SVarExpression_1= ruleSVarExpression | this_SVarSum_2= ruleSVarSum | this_SVarTable_3= ruleSVarTable | this_SVarCase_4= ruleSVarCase )
            int alt43=5;
            switch ( input.LA(1) ) {
            case KEYWORD_53:
                {
                alt43=1;
                }
                break;
            case KEYWORD_38:
                {
                alt43=2;
                }
                break;
            case KEYWORD_24:
                {
                alt43=3;
                }
                break;
            case KEYWORD_41:
                {
                alt43=4;
                }
                break;
            case KEYWORD_27:
                {
                alt43=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1400:2: this_SVarDSS_0= ruleSVarDSS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSVarAccess().getSVarDSSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSVarDSS_in_ruleSVar3038);
                    this_SVarDSS_0=ruleSVarDSS();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_SVarDSS_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1413:2: this_SVarExpression_1= ruleSVarExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSVarAccess().getSVarExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSVarExpression_in_ruleSVar3068);
                    this_SVarExpression_1=ruleSVarExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_SVarExpression_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1426:2: this_SVarSum_2= ruleSVarSum
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSVarAccess().getSVarSumParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSVarSum_in_ruleSVar3098);
                    this_SVarSum_2=ruleSVarSum();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_SVarSum_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1439:2: this_SVarTable_3= ruleSVarTable
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSVarAccess().getSVarTableParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSVarTable_in_ruleSVar3128);
                    this_SVarTable_3=ruleSVarTable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_SVarTable_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1452:2: this_SVarCase_4= ruleSVarCase
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSVarAccess().getSVarCaseParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSVarCase_in_ruleSVar3158);
                    this_SVarCase_4=ruleSVarCase();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_SVarCase_4;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSVar"


    // $ANTLR start "entryRuleSVarDSS"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1471:1: entryRuleSVarDSS returns [EObject current=null] : iv_ruleSVarDSS= ruleSVarDSS EOF ;
    public final EObject entryRuleSVarDSS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSVarDSS = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1472:2: (iv_ruleSVarDSS= ruleSVarDSS EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1473:2: iv_ruleSVarDSS= ruleSVarDSS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSVarDSSRule()); 
            }
            pushFollow(FOLLOW_ruleSVarDSS_in_entryRuleSVarDSS3192);
            iv_ruleSVarDSS=ruleSVarDSS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSVarDSS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSVarDSS3202); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSVarDSS"


    // $ANTLR start "ruleSVarDSS"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1480:1: ruleSVarDSS returns [EObject current=null] : ( (otherlv_0= KEYWORD_53 | otherlv_1= KEYWORD_53 ) ( (lv_bPart_2_0= RULE_STRING ) )? (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) ( (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 ) ( (lv_convert_11_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleSVarDSS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_bPart_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_kind_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token lv_units_8_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_convert_11_0=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1483:28: ( ( (otherlv_0= KEYWORD_53 | otherlv_1= KEYWORD_53 ) ( (lv_bPart_2_0= RULE_STRING ) )? (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) ( (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 ) ( (lv_convert_11_0= RULE_STRING ) ) )? ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1484:1: ( (otherlv_0= KEYWORD_53 | otherlv_1= KEYWORD_53 ) ( (lv_bPart_2_0= RULE_STRING ) )? (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) ( (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 ) ( (lv_convert_11_0= RULE_STRING ) ) )? )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1484:1: ( (otherlv_0= KEYWORD_53 | otherlv_1= KEYWORD_53 ) ( (lv_bPart_2_0= RULE_STRING ) )? (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) ( (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 ) ( (lv_convert_11_0= RULE_STRING ) ) )? )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1484:2: (otherlv_0= KEYWORD_53 | otherlv_1= KEYWORD_53 ) ( (lv_bPart_2_0= RULE_STRING ) )? (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) ( (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 ) ( (lv_convert_11_0= RULE_STRING ) ) )?
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1484:2: (otherlv_0= KEYWORD_53 | otherlv_1= KEYWORD_53 )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==KEYWORD_53) ) {
                int LA44_1 = input.LA(2);

                if ( (synpred52_InternalWreslEditorParser()) ) {
                    alt44=1;
                }
                else if ( (true) ) {
                    alt44=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1485:2: otherlv_0= KEYWORD_53
                    {
                    otherlv_0=(Token)match(input,KEYWORD_53,FOLLOW_KEYWORD_53_in_ruleSVarDSS3241); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getSVarDSSAccess().getTimeseriesKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1491:2: otherlv_1= KEYWORD_53
                    {
                    otherlv_1=(Token)match(input,KEYWORD_53,FOLLOW_KEYWORD_53_in_ruleSVarDSS3259); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getSVarDSSAccess().getTIMESERIESKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1495:2: ( (lv_bPart_2_0= RULE_STRING ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_STRING) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1496:1: (lv_bPart_2_0= RULE_STRING )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1496:1: (lv_bPart_2_0= RULE_STRING )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1497:3: lv_bPart_2_0= RULE_STRING
                    {
                    lv_bPart_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSVarDSS3276); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_bPart_2_0, grammarAccess.getSVarDSSAccess().getBPartSTRINGTerminalRuleCall_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSVarDSSRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"bPart",
                              		lv_bPart_2_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1513:3: (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==KEYWORD_30) ) {
                int LA46_1 = input.LA(2);

                if ( (synpred54_InternalWreslEditorParser()) ) {
                    alt46=1;
                }
                else if ( (true) ) {
                    alt46=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 46, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1514:2: otherlv_3= KEYWORD_30
                    {
                    otherlv_3=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleSVarDSS3296); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getSVarDSSAccess().getKindKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1520:2: otherlv_4= KEYWORD_30
                    {
                    otherlv_4=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleSVarDSS3314); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getSVarDSSAccess().getKINDKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1524:2: ( (lv_kind_5_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1525:1: (lv_kind_5_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1525:1: (lv_kind_5_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1526:3: lv_kind_5_0= RULE_STRING
            {
            lv_kind_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSVarDSS3331); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_kind_5_0, grammarAccess.getSVarDSSAccess().getKindSTRINGTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getSVarDSSRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"kind",
                      		lv_kind_5_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1542:2: (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==KEYWORD_36) ) {
                int LA47_1 = input.LA(2);

                if ( (synpred55_InternalWreslEditorParser()) ) {
                    alt47=1;
                }
                else if ( (true) ) {
                    alt47=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1543:2: otherlv_6= KEYWORD_36
                    {
                    otherlv_6=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleSVarDSS3350); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getSVarDSSAccess().getUnitsKeyword_4_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1549:2: otherlv_7= KEYWORD_36
                    {
                    otherlv_7=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleSVarDSS3368); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSVarDSSAccess().getUNITSKeyword_4_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1553:2: ( (lv_units_8_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1554:1: (lv_units_8_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1554:1: (lv_units_8_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1555:3: lv_units_8_0= RULE_STRING
            {
            lv_units_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSVarDSS3385); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_units_8_0, grammarAccess.getSVarDSSAccess().getUnitsSTRINGTerminalRuleCall_5_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getSVarDSSRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"units",
                      		lv_units_8_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1571:2: ( (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 ) ( (lv_convert_11_0= RULE_STRING ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==KEYWORD_42) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1571:3: (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 ) ( (lv_convert_11_0= RULE_STRING ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1571:3: (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 )
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==KEYWORD_42) ) {
                        int LA48_1 = input.LA(2);

                        if ( (synpred56_InternalWreslEditorParser()) ) {
                            alt48=1;
                        }
                        else if ( (true) ) {
                            alt48=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 48, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 48, 0, input);

                        throw nvae;
                    }
                    switch (alt48) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1572:2: otherlv_9= KEYWORD_42
                            {
                            otherlv_9=(Token)match(input,KEYWORD_42,FOLLOW_KEYWORD_42_in_ruleSVarDSS3405); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_9, grammarAccess.getSVarDSSAccess().getConvertKeyword_6_0_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1578:2: otherlv_10= KEYWORD_42
                            {
                            otherlv_10=(Token)match(input,KEYWORD_42,FOLLOW_KEYWORD_42_in_ruleSVarDSS3423); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_10, grammarAccess.getSVarDSSAccess().getCONVERTKeyword_6_0_1());
                                  
                            }

                            }
                            break;

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1582:2: ( (lv_convert_11_0= RULE_STRING ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1583:1: (lv_convert_11_0= RULE_STRING )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1583:1: (lv_convert_11_0= RULE_STRING )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1584:3: lv_convert_11_0= RULE_STRING
                    {
                    lv_convert_11_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSVarDSS3440); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_convert_11_0, grammarAccess.getSVarDSSAccess().getConvertSTRINGTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSVarDSSRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"convert",
                              		lv_convert_11_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSVarDSS"


    // $ANTLR start "entryRuleSVarExpression"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1608:1: entryRuleSVarExpression returns [EObject current=null] : iv_ruleSVarExpression= ruleSVarExpression EOF ;
    public final EObject entryRuleSVarExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSVarExpression = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1609:2: (iv_ruleSVarExpression= ruleSVarExpression EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1610:2: iv_ruleSVarExpression= ruleSVarExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSVarExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleSVarExpression_in_entryRuleSVarExpression3482);
            iv_ruleSVarExpression=ruleSVarExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSVarExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSVarExpression3492); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSVarExpression"


    // $ANTLR start "ruleSVarExpression"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1617:1: ruleSVarExpression returns [EObject current=null] : ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleSVarExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1620:28: ( ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1621:1: ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1621:1: ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1621:2: (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1621:2: (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==KEYWORD_38) ) {
                int LA50_1 = input.LA(2);

                if ( (synpred58_InternalWreslEditorParser()) ) {
                    alt50=1;
                }
                else if ( (true) ) {
                    alt50=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 50, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1622:2: otherlv_0= KEYWORD_38
                    {
                    otherlv_0=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_ruleSVarExpression3531); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getSVarExpressionAccess().getValueKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1628:2: otherlv_1= KEYWORD_38
                    {
                    otherlv_1=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_ruleSVarExpression3549); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getSVarExpressionAccess().getVALUEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1632:2: ( (lv_expression_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1633:1: (lv_expression_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1633:1: (lv_expression_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1634:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSVarExpressionAccess().getExpressionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSVarExpression3570);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSVarExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSVarExpression"


    // $ANTLR start "entryRuleSVarSum"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1658:1: entryRuleSVarSum returns [EObject current=null] : iv_ruleSVarSum= ruleSVarSum EOF ;
    public final EObject entryRuleSVarSum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSVarSum = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1659:2: (iv_ruleSVarSum= ruleSVarSum EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1660:2: iv_ruleSVarSum= ruleSVarSum EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSVarSumRule()); 
            }
            pushFollow(FOLLOW_ruleSVarSum_in_entryRuleSVarSum3605);
            iv_ruleSVarSum=ruleSVarSum();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSVarSum; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSVarSum3615); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSVarSum"


    // $ANTLR start "ruleSVarSum"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1667:1: ruleSVarSum returns [EObject current=null] : ( (lv_sumContent_0_0= ruleSumContent ) ) ;
    public final EObject ruleSVarSum() throws RecognitionException {
        EObject current = null;

        EObject lv_sumContent_0_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1670:28: ( ( (lv_sumContent_0_0= ruleSumContent ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1671:1: ( (lv_sumContent_0_0= ruleSumContent ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1671:1: ( (lv_sumContent_0_0= ruleSumContent ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1672:1: (lv_sumContent_0_0= ruleSumContent )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1672:1: (lv_sumContent_0_0= ruleSumContent )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1673:3: lv_sumContent_0_0= ruleSumContent
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSVarSumAccess().getSumContentSumContentParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSumContent_in_ruleSVarSum3660);
            lv_sumContent_0_0=ruleSumContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSVarSumRule());
              	        }
                     		set(
                     			current, 
                     			"sumContent",
                      		lv_sumContent_0_0, 
                      		"SumContent");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSVarSum"


    // $ANTLR start "entryRuleSVarTable"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1697:1: entryRuleSVarTable returns [EObject current=null] : iv_ruleSVarTable= ruleSVarTable EOF ;
    public final EObject entryRuleSVarTable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSVarTable = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1698:2: (iv_ruleSVarTable= ruleSVarTable EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1699:2: iv_ruleSVarTable= ruleSVarTable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSVarTableRule()); 
            }
            pushFollow(FOLLOW_ruleSVarTable_in_entryRuleSVarTable3694);
            iv_ruleSVarTable=ruleSVarTable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSVarTable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSVarTable3704); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSVarTable"


    // $ANTLR start "ruleSVarTable"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1706:1: ruleSVarTable returns [EObject current=null] : ( (lv_tableContent_0_0= ruleTableContent ) ) ;
    public final EObject ruleSVarTable() throws RecognitionException {
        EObject current = null;

        EObject lv_tableContent_0_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1709:28: ( ( (lv_tableContent_0_0= ruleTableContent ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1710:1: ( (lv_tableContent_0_0= ruleTableContent ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1710:1: ( (lv_tableContent_0_0= ruleTableContent ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1711:1: (lv_tableContent_0_0= ruleTableContent )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1711:1: (lv_tableContent_0_0= ruleTableContent )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1712:3: lv_tableContent_0_0= ruleTableContent
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSVarTableAccess().getTableContentTableContentParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTableContent_in_ruleSVarTable3749);
            lv_tableContent_0_0=ruleTableContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSVarTableRule());
              	        }
                     		set(
                     			current, 
                     			"tableContent",
                      		lv_tableContent_0_0, 
                      		"TableContent");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSVarTable"


    // $ANTLR start "entryRuleSVarCase"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1736:1: entryRuleSVarCase returns [EObject current=null] : iv_ruleSVarCase= ruleSVarCase EOF ;
    public final EObject entryRuleSVarCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSVarCase = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1737:2: (iv_ruleSVarCase= ruleSVarCase EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1738:2: iv_ruleSVarCase= ruleSVarCase EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSVarCaseRule()); 
            }
            pushFollow(FOLLOW_ruleSVarCase_in_entryRuleSVarCase3783);
            iv_ruleSVarCase=ruleSVarCase();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSVarCase; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSVarCase3793); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSVarCase"


    // $ANTLR start "ruleSVarCase"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1745:1: ruleSVarCase returns [EObject current=null] : ( (lv_caseContent_0_0= ruleCaseContent ) )+ ;
    public final EObject ruleSVarCase() throws RecognitionException {
        EObject current = null;

        EObject lv_caseContent_0_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1748:28: ( ( (lv_caseContent_0_0= ruleCaseContent ) )+ )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1749:1: ( (lv_caseContent_0_0= ruleCaseContent ) )+
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1749:1: ( (lv_caseContent_0_0= ruleCaseContent ) )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==KEYWORD_27) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1750:1: (lv_caseContent_0_0= ruleCaseContent )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1750:1: (lv_caseContent_0_0= ruleCaseContent )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1751:3: lv_caseContent_0_0= ruleCaseContent
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSVarCaseAccess().getCaseContentCaseContentParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCaseContent_in_ruleSVarCase3838);
            	    lv_caseContent_0_0=ruleCaseContent();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSVarCaseRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"caseContent",
            	              		lv_caseContent_0_0, 
            	              		"CaseContent");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt51 >= 1 ) break loop51;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
            } while (true);


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSVarCase"


    // $ANTLR start "entryRuleCaseContent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1775:1: entryRuleCaseContent returns [EObject current=null] : iv_ruleCaseContent= ruleCaseContent EOF ;
    public final EObject entryRuleCaseContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseContent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1776:2: (iv_ruleCaseContent= ruleCaseContent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1777:2: iv_ruleCaseContent= ruleCaseContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseContentRule()); 
            }
            pushFollow(FOLLOW_ruleCaseContent_in_entryRuleCaseContent3873);
            iv_ruleCaseContent=ruleCaseContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCaseContent3883); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseContent"


    // $ANTLR start "ruleCaseContent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1784:1: ruleCaseContent returns [EObject current=null] : ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) ( ( (lv_content_5_0= ruleTableContent ) ) | ( (lv_content_6_0= ruleValueContent ) ) | ( (lv_content_7_0= ruleSumContent ) ) ) otherlv_8= KEYWORD_14 ) ;
    public final EObject ruleCaseContent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_caseName_2_0=null;
        Token otherlv_3=null;
        Token otherlv_8=null;
        EObject lv_condition_4_0 = null;

        EObject lv_content_5_0 = null;

        EObject lv_content_6_0 = null;

        EObject lv_content_7_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1787:28: ( ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) ( ( (lv_content_5_0= ruleTableContent ) ) | ( (lv_content_6_0= ruleValueContent ) ) | ( (lv_content_7_0= ruleSumContent ) ) ) otherlv_8= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1788:1: ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) ( ( (lv_content_5_0= ruleTableContent ) ) | ( (lv_content_6_0= ruleValueContent ) ) | ( (lv_content_7_0= ruleSumContent ) ) ) otherlv_8= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1788:1: ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) ( ( (lv_content_5_0= ruleTableContent ) ) | ( (lv_content_6_0= ruleValueContent ) ) | ( (lv_content_7_0= ruleSumContent ) ) ) otherlv_8= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1788:2: (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) ( ( (lv_content_5_0= ruleTableContent ) ) | ( (lv_content_6_0= ruleValueContent ) ) | ( (lv_content_7_0= ruleSumContent ) ) ) otherlv_8= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1788:2: (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==KEYWORD_27) ) {
                int LA52_1 = input.LA(2);

                if ( (synpred60_InternalWreslEditorParser()) ) {
                    alt52=1;
                }
                else if ( (true) ) {
                    alt52=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1789:2: otherlv_0= KEYWORD_27
                    {
                    otherlv_0=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_ruleCaseContent3922); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getCaseContentAccess().getCaseKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1795:2: otherlv_1= KEYWORD_27
                    {
                    otherlv_1=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_ruleCaseContent3940); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCaseContentAccess().getCASEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1799:2: ( (lv_caseName_2_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1800:1: (lv_caseName_2_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1800:1: (lv_caseName_2_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1801:3: lv_caseName_2_0= RULE_ID
            {
            lv_caseName_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCaseContent3957); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_caseName_2_0, grammarAccess.getCaseContentAccess().getCaseNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getCaseContentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"caseName",
                      		lv_caseName_2_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleCaseContent3975); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getCaseContentAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1822:1: ( (lv_condition_4_0= ruleCondition ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1823:1: (lv_condition_4_0= ruleCondition )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1823:1: (lv_condition_4_0= ruleCondition )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1824:3: lv_condition_4_0= ruleCondition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCaseContentAccess().getConditionConditionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCondition_in_ruleCaseContent3995);
            lv_condition_4_0=ruleCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCaseContentRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_4_0, 
                      		"Condition");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1840:2: ( ( (lv_content_5_0= ruleTableContent ) ) | ( (lv_content_6_0= ruleValueContent ) ) | ( (lv_content_7_0= ruleSumContent ) ) )
            int alt53=3;
            switch ( input.LA(1) ) {
            case KEYWORD_41:
                {
                alt53=1;
                }
                break;
            case KEYWORD_38:
                {
                alt53=2;
                }
                break;
            case KEYWORD_24:
                {
                alt53=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1840:3: ( (lv_content_5_0= ruleTableContent ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1840:3: ( (lv_content_5_0= ruleTableContent ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1841:1: (lv_content_5_0= ruleTableContent )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1841:1: (lv_content_5_0= ruleTableContent )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1842:3: lv_content_5_0= ruleTableContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseContentAccess().getContentTableContentParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTableContent_in_ruleCaseContent4017);
                    lv_content_5_0=ruleTableContent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCaseContentRule());
                      	        }
                             		set(
                             			current, 
                             			"content",
                              		lv_content_5_0, 
                              		"TableContent");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1859:6: ( (lv_content_6_0= ruleValueContent ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1859:6: ( (lv_content_6_0= ruleValueContent ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1860:1: (lv_content_6_0= ruleValueContent )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1860:1: (lv_content_6_0= ruleValueContent )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1861:3: lv_content_6_0= ruleValueContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseContentAccess().getContentValueContentParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValueContent_in_ruleCaseContent4044);
                    lv_content_6_0=ruleValueContent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCaseContentRule());
                      	        }
                             		set(
                             			current, 
                             			"content",
                              		lv_content_6_0, 
                              		"ValueContent");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1878:6: ( (lv_content_7_0= ruleSumContent ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1878:6: ( (lv_content_7_0= ruleSumContent ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1879:1: (lv_content_7_0= ruleSumContent )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1879:1: (lv_content_7_0= ruleSumContent )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1880:3: lv_content_7_0= ruleSumContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseContentAccess().getContentSumContentParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSumContent_in_ruleCaseContent4071);
                    lv_content_7_0=ruleSumContent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getCaseContentRule());
                      	        }
                             		set(
                             			current, 
                             			"content",
                              		lv_content_7_0, 
                              		"SumContent");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleCaseContent4085); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getCaseContentAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseContent"


    // $ANTLR start "entryRuleSumContent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1909:1: entryRuleSumContent returns [EObject current=null] : iv_ruleSumContent= ruleSumContent EOF ;
    public final EObject entryRuleSumContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSumContent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1910:2: (iv_ruleSumContent= ruleSumContent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1911:2: iv_ruleSumContent= ruleSumContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSumContentRule()); 
            }
            pushFollow(FOLLOW_ruleSumContent_in_entryRuleSumContent4119);
            iv_ruleSumContent=ruleSumContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSumContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSumContent4129); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSumContent"


    // $ANTLR start "ruleSumContent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1918:1: ruleSumContent returns [EObject current=null] : ( (otherlv_0= KEYWORD_24 | otherlv_1= KEYWORD_24 ) ( (lv_header_2_0= ruleSumHeader ) ) ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleSumContent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_header_2_0 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1921:28: ( ( (otherlv_0= KEYWORD_24 | otherlv_1= KEYWORD_24 ) ( (lv_header_2_0= ruleSumHeader ) ) ( (lv_expression_3_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1922:1: ( (otherlv_0= KEYWORD_24 | otherlv_1= KEYWORD_24 ) ( (lv_header_2_0= ruleSumHeader ) ) ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1922:1: ( (otherlv_0= KEYWORD_24 | otherlv_1= KEYWORD_24 ) ( (lv_header_2_0= ruleSumHeader ) ) ( (lv_expression_3_0= ruleExpression ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1922:2: (otherlv_0= KEYWORD_24 | otherlv_1= KEYWORD_24 ) ( (lv_header_2_0= ruleSumHeader ) ) ( (lv_expression_3_0= ruleExpression ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1922:2: (otherlv_0= KEYWORD_24 | otherlv_1= KEYWORD_24 )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==KEYWORD_24) ) {
                int LA54_1 = input.LA(2);

                if ( (synpred63_InternalWreslEditorParser()) ) {
                    alt54=1;
                }
                else if ( (true) ) {
                    alt54=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1923:2: otherlv_0= KEYWORD_24
                    {
                    otherlv_0=(Token)match(input,KEYWORD_24,FOLLOW_KEYWORD_24_in_ruleSumContent4168); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getSumContentAccess().getSumKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1929:2: otherlv_1= KEYWORD_24
                    {
                    otherlv_1=(Token)match(input,KEYWORD_24,FOLLOW_KEYWORD_24_in_ruleSumContent4186); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getSumContentAccess().getSUMKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1933:2: ( (lv_header_2_0= ruleSumHeader ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1934:1: (lv_header_2_0= ruleSumHeader )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1934:1: (lv_header_2_0= ruleSumHeader )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1935:3: lv_header_2_0= ruleSumHeader
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSumContentAccess().getHeaderSumHeaderParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSumHeader_in_ruleSumContent4207);
            lv_header_2_0=ruleSumHeader();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSumContentRule());
              	        }
                     		set(
                     			current, 
                     			"header",
                      		lv_header_2_0, 
                      		"SumHeader");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1951:2: ( (lv_expression_3_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1952:1: (lv_expression_3_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1952:1: (lv_expression_3_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1953:3: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSumContentAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSumContent4228);
            lv_expression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSumContentRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_3_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSumContent"


    // $ANTLR start "entryRuleSumHeader"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1977:1: entryRuleSumHeader returns [EObject current=null] : iv_ruleSumHeader= ruleSumHeader EOF ;
    public final EObject entryRuleSumHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSumHeader = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1978:2: (iv_ruleSumHeader= ruleSumHeader EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1979:2: iv_ruleSumHeader= ruleSumHeader EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSumHeaderRule()); 
            }
            pushFollow(FOLLOW_ruleSumHeader_in_entryRuleSumHeader4263);
            iv_ruleSumHeader=ruleSumHeader();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSumHeader; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSumHeader4273); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSumHeader"


    // $ANTLR start "ruleSumHeader"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1986:1: ruleSumHeader returns [EObject current=null] : (otherlv_0= KEYWORD_1 otherlv_1= KEYWORD_19 ( (lv_expression1_2_0= ruleExpression ) ) otherlv_3= KEYWORD_5 ( (lv_expression2_4_0= ruleExpression ) ) (otherlv_5= KEYWORD_5 (otherlv_6= KEYWORD_6 )? this_INT_7= RULE_INT )? otherlv_8= KEYWORD_2 ) ;
    public final EObject ruleSumHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token this_INT_7=null;
        Token otherlv_8=null;
        EObject lv_expression1_2_0 = null;

        EObject lv_expression2_4_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1989:28: ( (otherlv_0= KEYWORD_1 otherlv_1= KEYWORD_19 ( (lv_expression1_2_0= ruleExpression ) ) otherlv_3= KEYWORD_5 ( (lv_expression2_4_0= ruleExpression ) ) (otherlv_5= KEYWORD_5 (otherlv_6= KEYWORD_6 )? this_INT_7= RULE_INT )? otherlv_8= KEYWORD_2 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1990:1: (otherlv_0= KEYWORD_1 otherlv_1= KEYWORD_19 ( (lv_expression1_2_0= ruleExpression ) ) otherlv_3= KEYWORD_5 ( (lv_expression2_4_0= ruleExpression ) ) (otherlv_5= KEYWORD_5 (otherlv_6= KEYWORD_6 )? this_INT_7= RULE_INT )? otherlv_8= KEYWORD_2 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1990:1: (otherlv_0= KEYWORD_1 otherlv_1= KEYWORD_19 ( (lv_expression1_2_0= ruleExpression ) ) otherlv_3= KEYWORD_5 ( (lv_expression2_4_0= ruleExpression ) ) (otherlv_5= KEYWORD_5 (otherlv_6= KEYWORD_6 )? this_INT_7= RULE_INT )? otherlv_8= KEYWORD_2 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1991:2: otherlv_0= KEYWORD_1 otherlv_1= KEYWORD_19 ( (lv_expression1_2_0= ruleExpression ) ) otherlv_3= KEYWORD_5 ( (lv_expression2_4_0= ruleExpression ) ) (otherlv_5= KEYWORD_5 (otherlv_6= KEYWORD_6 )? this_INT_7= RULE_INT )? otherlv_8= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleSumHeader4311); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSumHeaderAccess().getLeftParenthesisKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,KEYWORD_19,FOLLOW_KEYWORD_19_in_ruleSumHeader4323); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSumHeaderAccess().getIKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2000:1: ( (lv_expression1_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2001:1: (lv_expression1_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2001:1: (lv_expression1_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2002:3: lv_expression1_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSumHeaderAccess().getExpression1ExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSumHeader4343);
            lv_expression1_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSumHeaderRule());
              	        }
                     		set(
                     			current, 
                     			"expression1",
                      		lv_expression1_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleSumHeader4356); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSumHeaderAccess().getCommaKeyword_3());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2023:1: ( (lv_expression2_4_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2024:1: (lv_expression2_4_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2024:1: (lv_expression2_4_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2025:3: lv_expression2_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSumHeaderAccess().getExpression2ExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSumHeader4376);
            lv_expression2_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSumHeaderRule());
              	        }
                     		set(
                     			current, 
                     			"expression2",
                      		lv_expression2_4_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2041:2: (otherlv_5= KEYWORD_5 (otherlv_6= KEYWORD_6 )? this_INT_7= RULE_INT )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==KEYWORD_5) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2042:2: otherlv_5= KEYWORD_5 (otherlv_6= KEYWORD_6 )? this_INT_7= RULE_INT
                    {
                    otherlv_5=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleSumHeader4390); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSumHeaderAccess().getCommaKeyword_5_0());
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2046:1: (otherlv_6= KEYWORD_6 )?
                    int alt55=2;
                    int LA55_0 = input.LA(1);

                    if ( (LA55_0==KEYWORD_6) ) {
                        alt55=1;
                    }
                    switch (alt55) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2047:2: otherlv_6= KEYWORD_6
                            {
                            otherlv_6=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleSumHeader4403); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getSumHeaderAccess().getHyphenMinusKeyword_5_1());
                                  
                            }

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSumHeader4415); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_7, grammarAccess.getSumHeaderAccess().getINTTerminalRuleCall_5_2()); 
                          
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleSumHeader4429); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getSumHeaderAccess().getRightParenthesisKeyword_6());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSumHeader"


    // $ANTLR start "entryRuleValueContent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2068:1: entryRuleValueContent returns [EObject current=null] : iv_ruleValueContent= ruleValueContent EOF ;
    public final EObject entryRuleValueContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueContent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2069:2: (iv_ruleValueContent= ruleValueContent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2070:2: iv_ruleValueContent= ruleValueContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueContentRule()); 
            }
            pushFollow(FOLLOW_ruleValueContent_in_entryRuleValueContent4463);
            iv_ruleValueContent=ruleValueContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueContent4473); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueContent"


    // $ANTLR start "ruleValueContent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2077:1: ruleValueContent returns [EObject current=null] : ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleValueContent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2080:28: ( ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2081:1: ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2081:1: ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2081:2: (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2081:2: (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==KEYWORD_38) ) {
                int LA57_1 = input.LA(2);

                if ( (synpred66_InternalWreslEditorParser()) ) {
                    alt57=1;
                }
                else if ( (true) ) {
                    alt57=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 57, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2082:2: otherlv_0= KEYWORD_38
                    {
                    otherlv_0=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_ruleValueContent4512); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getValueContentAccess().getValueKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2088:2: otherlv_1= KEYWORD_38
                    {
                    otherlv_1=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_ruleValueContent4530); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getValueContentAccess().getVALUEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2092:2: ( (lv_expression_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2093:1: (lv_expression_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2093:1: (lv_expression_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2094:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueContentAccess().getExpressionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleValueContent4551);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getValueContentRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueContent"


    // $ANTLR start "entryRuleTableContent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2118:1: entryRuleTableContent returns [EObject current=null] : iv_ruleTableContent= ruleTableContent EOF ;
    public final EObject entryRuleTableContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableContent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2119:2: (iv_ruleTableContent= ruleTableContent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2120:2: iv_ruleTableContent= ruleTableContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTableContentRule()); 
            }
            pushFollow(FOLLOW_ruleTableContent_in_entryRuleTableContent4586);
            iv_ruleTableContent=ruleTableContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTableContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableContent4596); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTableContent"


    // $ANTLR start "ruleTableContent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2127:1: ruleTableContent returns [EObject current=null] : ( (otherlv_0= KEYWORD_41 | otherlv_1= KEYWORD_41 ) ( (lv_tableName_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_28 | otherlv_4= KEYWORD_28 ) ( (lv_from_5_0= RULE_ID ) ) ( (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 ) ( (lv_given_8_0= ruleAssignment ) ) (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 ) ( (lv_use_11_0= RULE_ID ) ) )? ( (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 ) ( (lv_where_14_0= ruleWhereItems ) ) )? ) ;
    public final EObject ruleTableContent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_tableName_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_from_5_0=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token lv_use_11_0=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        EObject lv_given_8_0 = null;

        EObject lv_where_14_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2130:28: ( ( (otherlv_0= KEYWORD_41 | otherlv_1= KEYWORD_41 ) ( (lv_tableName_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_28 | otherlv_4= KEYWORD_28 ) ( (lv_from_5_0= RULE_ID ) ) ( (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 ) ( (lv_given_8_0= ruleAssignment ) ) (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 ) ( (lv_use_11_0= RULE_ID ) ) )? ( (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 ) ( (lv_where_14_0= ruleWhereItems ) ) )? ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2131:1: ( (otherlv_0= KEYWORD_41 | otherlv_1= KEYWORD_41 ) ( (lv_tableName_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_28 | otherlv_4= KEYWORD_28 ) ( (lv_from_5_0= RULE_ID ) ) ( (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 ) ( (lv_given_8_0= ruleAssignment ) ) (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 ) ( (lv_use_11_0= RULE_ID ) ) )? ( (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 ) ( (lv_where_14_0= ruleWhereItems ) ) )? )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2131:1: ( (otherlv_0= KEYWORD_41 | otherlv_1= KEYWORD_41 ) ( (lv_tableName_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_28 | otherlv_4= KEYWORD_28 ) ( (lv_from_5_0= RULE_ID ) ) ( (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 ) ( (lv_given_8_0= ruleAssignment ) ) (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 ) ( (lv_use_11_0= RULE_ID ) ) )? ( (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 ) ( (lv_where_14_0= ruleWhereItems ) ) )? )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2131:2: (otherlv_0= KEYWORD_41 | otherlv_1= KEYWORD_41 ) ( (lv_tableName_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_28 | otherlv_4= KEYWORD_28 ) ( (lv_from_5_0= RULE_ID ) ) ( (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 ) ( (lv_given_8_0= ruleAssignment ) ) (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 ) ( (lv_use_11_0= RULE_ID ) ) )? ( (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 ) ( (lv_where_14_0= ruleWhereItems ) ) )?
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2131:2: (otherlv_0= KEYWORD_41 | otherlv_1= KEYWORD_41 )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==KEYWORD_41) ) {
                int LA58_1 = input.LA(2);

                if ( (synpred67_InternalWreslEditorParser()) ) {
                    alt58=1;
                }
                else if ( (true) ) {
                    alt58=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2132:2: otherlv_0= KEYWORD_41
                    {
                    otherlv_0=(Token)match(input,KEYWORD_41,FOLLOW_KEYWORD_41_in_ruleTableContent4635); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getTableContentAccess().getSelectKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2138:2: otherlv_1= KEYWORD_41
                    {
                    otherlv_1=(Token)match(input,KEYWORD_41,FOLLOW_KEYWORD_41_in_ruleTableContent4653); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTableContentAccess().getSELECTKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2142:2: ( (lv_tableName_2_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2143:1: (lv_tableName_2_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2143:1: (lv_tableName_2_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2144:3: lv_tableName_2_0= RULE_ID
            {
            lv_tableName_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTableContent4670); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_tableName_2_0, grammarAccess.getTableContentAccess().getTableNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTableContentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"tableName",
                      		lv_tableName_2_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2160:2: (otherlv_3= KEYWORD_28 | otherlv_4= KEYWORD_28 )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==KEYWORD_28) ) {
                int LA59_1 = input.LA(2);

                if ( (synpred68_InternalWreslEditorParser()) ) {
                    alt59=1;
                }
                else if ( (true) ) {
                    alt59=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2161:2: otherlv_3= KEYWORD_28
                    {
                    otherlv_3=(Token)match(input,KEYWORD_28,FOLLOW_KEYWORD_28_in_ruleTableContent4689); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTableContentAccess().getFromKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2167:2: otherlv_4= KEYWORD_28
                    {
                    otherlv_4=(Token)match(input,KEYWORD_28,FOLLOW_KEYWORD_28_in_ruleTableContent4707); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getTableContentAccess().getFROMKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2171:2: ( (lv_from_5_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2172:1: (lv_from_5_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2172:1: (lv_from_5_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2173:3: lv_from_5_0= RULE_ID
            {
            lv_from_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTableContent4724); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_from_5_0, grammarAccess.getTableContentAccess().getFromIDTerminalRuleCall_3_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getTableContentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"from",
                      		lv_from_5_0, 
                      		"ID");
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2189:2: ( (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 ) ( (lv_given_8_0= ruleAssignment ) ) (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 ) ( (lv_use_11_0= RULE_ID ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==KEYWORD_32) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2189:3: (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 ) ( (lv_given_8_0= ruleAssignment ) ) (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 ) ( (lv_use_11_0= RULE_ID ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2189:3: (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 )
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==KEYWORD_32) ) {
                        int LA60_1 = input.LA(2);

                        if ( (synpred69_InternalWreslEditorParser()) ) {
                            alt60=1;
                        }
                        else if ( (true) ) {
                            alt60=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 60, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 60, 0, input);

                        throw nvae;
                    }
                    switch (alt60) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2190:2: otherlv_6= KEYWORD_32
                            {
                            otherlv_6=(Token)match(input,KEYWORD_32,FOLLOW_KEYWORD_32_in_ruleTableContent4744); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getTableContentAccess().getGivenKeyword_4_0_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2196:2: otherlv_7= KEYWORD_32
                            {
                            otherlv_7=(Token)match(input,KEYWORD_32,FOLLOW_KEYWORD_32_in_ruleTableContent4762); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getTableContentAccess().getGIVENKeyword_4_0_1());
                                  
                            }

                            }
                            break;

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2200:2: ( (lv_given_8_0= ruleAssignment ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2201:1: (lv_given_8_0= ruleAssignment )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2201:1: (lv_given_8_0= ruleAssignment )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2202:3: lv_given_8_0= ruleAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTableContentAccess().getGivenAssignmentParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAssignment_in_ruleTableContent4783);
                    lv_given_8_0=ruleAssignment();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTableContentRule());
                      	        }
                             		set(
                             			current, 
                             			"given",
                              		lv_given_8_0, 
                              		"Assignment");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2218:2: (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 )
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==KEYWORD_25) ) {
                        int LA61_1 = input.LA(2);

                        if ( (synpred70_InternalWreslEditorParser()) ) {
                            alt61=1;
                        }
                        else if ( (true) ) {
                            alt61=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 61, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 61, 0, input);

                        throw nvae;
                    }
                    switch (alt61) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2219:2: otherlv_9= KEYWORD_25
                            {
                            otherlv_9=(Token)match(input,KEYWORD_25,FOLLOW_KEYWORD_25_in_ruleTableContent4797); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_9, grammarAccess.getTableContentAccess().getUseKeyword_4_2_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2225:2: otherlv_10= KEYWORD_25
                            {
                            otherlv_10=(Token)match(input,KEYWORD_25,FOLLOW_KEYWORD_25_in_ruleTableContent4815); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_10, grammarAccess.getTableContentAccess().getUSEKeyword_4_2_1());
                                  
                            }

                            }
                            break;

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2229:2: ( (lv_use_11_0= RULE_ID ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2230:1: (lv_use_11_0= RULE_ID )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2230:1: (lv_use_11_0= RULE_ID )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2231:3: lv_use_11_0= RULE_ID
                    {
                    lv_use_11_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTableContent4832); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_use_11_0, grammarAccess.getTableContentAccess().getUseIDTerminalRuleCall_4_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getTableContentRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"use",
                              		lv_use_11_0, 
                              		"ID");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2247:4: ( (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 ) ( (lv_where_14_0= ruleWhereItems ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==KEYWORD_39) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2247:5: (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 ) ( (lv_where_14_0= ruleWhereItems ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2247:5: (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 )
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==KEYWORD_39) ) {
                        int LA63_1 = input.LA(2);

                        if ( (synpred72_InternalWreslEditorParser()) ) {
                            alt63=1;
                        }
                        else if ( (true) ) {
                            alt63=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 63, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 63, 0, input);

                        throw nvae;
                    }
                    switch (alt63) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2248:2: otherlv_12= KEYWORD_39
                            {
                            otherlv_12=(Token)match(input,KEYWORD_39,FOLLOW_KEYWORD_39_in_ruleTableContent4854); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_12, grammarAccess.getTableContentAccess().getWhereKeyword_5_0_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2254:2: otherlv_13= KEYWORD_39
                            {
                            otherlv_13=(Token)match(input,KEYWORD_39,FOLLOW_KEYWORD_39_in_ruleTableContent4872); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_13, grammarAccess.getTableContentAccess().getWHEREKeyword_5_0_1());
                                  
                            }

                            }
                            break;

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2258:2: ( (lv_where_14_0= ruleWhereItems ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2259:1: (lv_where_14_0= ruleWhereItems )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2259:1: (lv_where_14_0= ruleWhereItems )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2260:3: lv_where_14_0= ruleWhereItems
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTableContentAccess().getWhereWhereItemsParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleWhereItems_in_ruleTableContent4893);
                    lv_where_14_0=ruleWhereItems();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTableContentRule());
                      	        }
                             		set(
                             			current, 
                             			"where",
                              		lv_where_14_0, 
                              		"WhereItems");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTableContent"


    // $ANTLR start "entryRuleWhereItems"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2284:1: entryRuleWhereItems returns [EObject current=null] : iv_ruleWhereItems= ruleWhereItems EOF ;
    public final EObject entryRuleWhereItems() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhereItems = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2285:2: (iv_ruleWhereItems= ruleWhereItems EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2286:2: iv_ruleWhereItems= ruleWhereItems EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhereItemsRule()); 
            }
            pushFollow(FOLLOW_ruleWhereItems_in_entryRuleWhereItems4930);
            iv_ruleWhereItems=ruleWhereItems();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhereItems; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhereItems4940); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWhereItems"


    // $ANTLR start "ruleWhereItems"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2293:1: ruleWhereItems returns [EObject current=null] : ( ( (lv_assignment_0_0= ruleAssignment ) ) (otherlv_1= KEYWORD_5 ( (lv_assignment_2_0= ruleAssignment ) ) )* ) ;
    public final EObject ruleWhereItems() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_assignment_0_0 = null;

        EObject lv_assignment_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2296:28: ( ( ( (lv_assignment_0_0= ruleAssignment ) ) (otherlv_1= KEYWORD_5 ( (lv_assignment_2_0= ruleAssignment ) ) )* ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2297:1: ( ( (lv_assignment_0_0= ruleAssignment ) ) (otherlv_1= KEYWORD_5 ( (lv_assignment_2_0= ruleAssignment ) ) )* )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2297:1: ( ( (lv_assignment_0_0= ruleAssignment ) ) (otherlv_1= KEYWORD_5 ( (lv_assignment_2_0= ruleAssignment ) ) )* )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2297:2: ( (lv_assignment_0_0= ruleAssignment ) ) (otherlv_1= KEYWORD_5 ( (lv_assignment_2_0= ruleAssignment ) ) )*
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2297:2: ( (lv_assignment_0_0= ruleAssignment ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2298:1: (lv_assignment_0_0= ruleAssignment )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2298:1: (lv_assignment_0_0= ruleAssignment )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2299:3: lv_assignment_0_0= ruleAssignment
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getWhereItemsAccess().getAssignmentAssignmentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAssignment_in_ruleWhereItems4986);
            lv_assignment_0_0=ruleAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getWhereItemsRule());
              	        }
                     		add(
                     			current, 
                     			"assignment",
                      		lv_assignment_0_0, 
                      		"Assignment");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2315:2: (otherlv_1= KEYWORD_5 ( (lv_assignment_2_0= ruleAssignment ) ) )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==KEYWORD_5) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2316:2: otherlv_1= KEYWORD_5 ( (lv_assignment_2_0= ruleAssignment ) )
            	    {
            	    otherlv_1=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleWhereItems5000); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getWhereItemsAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2320:1: ( (lv_assignment_2_0= ruleAssignment ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2321:1: (lv_assignment_2_0= ruleAssignment )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2321:1: (lv_assignment_2_0= ruleAssignment )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2322:3: lv_assignment_2_0= ruleAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getWhereItemsAccess().getAssignmentAssignmentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAssignment_in_ruleWhereItems5020);
            	    lv_assignment_2_0=ruleAssignment();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getWhereItemsRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"assignment",
            	              		lv_assignment_2_0, 
            	              		"Assignment");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWhereItems"


    // $ANTLR start "entryRuleAssignment"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2346:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2347:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2348:2: iv_ruleAssignment= ruleAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment5057);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment5067); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2355:1: ruleAssignment returns [EObject current=null] : ( ( (lv_term_0_0= ruleTermSimple ) ) otherlv_1= KEYWORD_9 ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_term_0_0 = null;

        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2358:28: ( ( ( (lv_term_0_0= ruleTermSimple ) ) otherlv_1= KEYWORD_9 ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2359:1: ( ( (lv_term_0_0= ruleTermSimple ) ) otherlv_1= KEYWORD_9 ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2359:1: ( ( (lv_term_0_0= ruleTermSimple ) ) otherlv_1= KEYWORD_9 ( (lv_expression_2_0= ruleExpression ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2359:2: ( (lv_term_0_0= ruleTermSimple ) ) otherlv_1= KEYWORD_9 ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2359:2: ( (lv_term_0_0= ruleTermSimple ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2360:1: (lv_term_0_0= ruleTermSimple )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2360:1: (lv_term_0_0= ruleTermSimple )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2361:3: lv_term_0_0= ruleTermSimple
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentAccess().getTermTermSimpleParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTermSimple_in_ruleAssignment5113);
            lv_term_0_0=ruleTermSimple();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
              	        }
                     		set(
                     			current, 
                     			"term",
                      		lv_term_0_0, 
                      		"TermSimple");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_ruleAssignment5126); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2382:1: ( (lv_expression_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2383:1: (lv_expression_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2383:1: (lv_expression_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2384:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleAssignment5146);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAssignmentRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleTermSimple"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2408:1: entryRuleTermSimple returns [EObject current=null] : iv_ruleTermSimple= ruleTermSimple EOF ;
    public final EObject entryRuleTermSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTermSimple = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2409:2: (iv_ruleTermSimple= ruleTermSimple EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2410:2: iv_ruleTermSimple= ruleTermSimple EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTermSimpleRule()); 
            }
            pushFollow(FOLLOW_ruleTermSimple_in_entryRuleTermSimple5181);
            iv_ruleTermSimple=ruleTermSimple();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTermSimple; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTermSimple5191); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTermSimple"


    // $ANTLR start "ruleTermSimple"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2417:1: ruleTermSimple returns [EObject current=null] : (this_ID_0= RULE_ID | ruleNumber | this_Function_2= ruleFunction ) ;
    public final EObject ruleTermSimple() throws RecognitionException {
        EObject current = null;

        Token this_ID_0=null;
        EObject this_Function_2 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2420:28: ( (this_ID_0= RULE_ID | ruleNumber | this_Function_2= ruleFunction ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2421:1: (this_ID_0= RULE_ID | ruleNumber | this_Function_2= ruleFunction )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2421:1: (this_ID_0= RULE_ID | ruleNumber | this_Function_2= ruleFunction )
            int alt66=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==KEYWORD_1||LA66_1==KEYWORD_11) ) {
                    alt66=3;
                }
                else if ( (LA66_1==EOF||LA66_1==KEYWORD_9) ) {
                    alt66=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 66, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA66_2 = input.LA(2);

                if ( (LA66_2==KEYWORD_1) ) {
                    alt66=3;
                }
                else if ( (LA66_2==EOF||LA66_2==KEYWORD_9) ) {
                    alt66=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 66, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_FLOAT:
                {
                alt66=2;
                }
                break;
            case RULE_MIN:
            case RULE_MAX:
                {
                alt66=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2421:2: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTermSimple5227); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getTermSimpleAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2427:2: ruleNumber
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTermSimpleAccess().getNumberParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNumber_in_ruleTermSimple5251);
                    ruleNumber();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2439:2: this_Function_2= ruleFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTermSimpleAccess().getFunctionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFunction_in_ruleTermSimple5281);
                    this_Function_2=ruleFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Function_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTermSimple"


    // $ANTLR start "entryRuleLowerAndOrUpper"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2458:1: entryRuleLowerAndOrUpper returns [EObject current=null] : iv_ruleLowerAndOrUpper= ruleLowerAndOrUpper EOF ;
    public final EObject entryRuleLowerAndOrUpper() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerAndOrUpper = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2459:2: (iv_ruleLowerAndOrUpper= ruleLowerAndOrUpper EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2460:2: iv_ruleLowerAndOrUpper= ruleLowerAndOrUpper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerAndOrUpperRule()); 
            }
            pushFollow(FOLLOW_ruleLowerAndOrUpper_in_entryRuleLowerAndOrUpper5315);
            iv_ruleLowerAndOrUpper=ruleLowerAndOrUpper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLowerAndOrUpper; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLowerAndOrUpper5325); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLowerAndOrUpper"


    // $ANTLR start "ruleLowerAndOrUpper"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2467:1: ruleLowerAndOrUpper returns [EObject current=null] : (this_lowerUpper_0= rulelowerUpper | this_upperLower_1= ruleupperLower ) ;
    public final EObject ruleLowerAndOrUpper() throws RecognitionException {
        EObject current = null;

        EObject this_lowerUpper_0 = null;

        EObject this_upperLower_1 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2470:28: ( (this_lowerUpper_0= rulelowerUpper | this_upperLower_1= ruleupperLower ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2471:1: (this_lowerUpper_0= rulelowerUpper | this_upperLower_1= ruleupperLower )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2471:1: (this_lowerUpper_0= rulelowerUpper | this_upperLower_1= ruleupperLower )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==KEYWORD_34) ) {
                alt67=1;
            }
            else if ( (LA67_0==KEYWORD_37) ) {
                alt67=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2472:2: this_lowerUpper_0= rulelowerUpper
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLowerAndOrUpperAccess().getLowerUpperParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulelowerUpper_in_ruleLowerAndOrUpper5375);
                    this_lowerUpper_0=rulelowerUpper();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_lowerUpper_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2485:2: this_upperLower_1= ruleupperLower
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLowerAndOrUpperAccess().getUpperLowerParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleupperLower_in_ruleLowerAndOrUpper5405);
                    this_upperLower_1=ruleupperLower();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_upperLower_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLowerAndOrUpper"


    // $ANTLR start "entryRuleupperLower"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2504:1: entryRuleupperLower returns [EObject current=null] : iv_ruleupperLower= ruleupperLower EOF ;
    public final EObject entryRuleupperLower() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleupperLower = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2505:2: (iv_ruleupperLower= ruleupperLower EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2506:2: iv_ruleupperLower= ruleupperLower EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUpperLowerRule()); 
            }
            pushFollow(FOLLOW_ruleupperLower_in_entryRuleupperLower5439);
            iv_ruleupperLower=ruleupperLower();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleupperLower; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleupperLower5449); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleupperLower"


    // $ANTLR start "ruleupperLower"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2513:1: ruleupperLower returns [EObject current=null] : ( ( (lv_upper_0_0= ruleUpper ) ) ( (lv_lower_1_0= ruleLower ) )? ) ;
    public final EObject ruleupperLower() throws RecognitionException {
        EObject current = null;

        EObject lv_upper_0_0 = null;

        EObject lv_lower_1_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2516:28: ( ( ( (lv_upper_0_0= ruleUpper ) ) ( (lv_lower_1_0= ruleLower ) )? ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2517:1: ( ( (lv_upper_0_0= ruleUpper ) ) ( (lv_lower_1_0= ruleLower ) )? )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2517:1: ( ( (lv_upper_0_0= ruleUpper ) ) ( (lv_lower_1_0= ruleLower ) )? )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2517:2: ( (lv_upper_0_0= ruleUpper ) ) ( (lv_lower_1_0= ruleLower ) )?
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2517:2: ( (lv_upper_0_0= ruleUpper ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2518:1: (lv_upper_0_0= ruleUpper )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2518:1: (lv_upper_0_0= ruleUpper )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2519:3: lv_upper_0_0= ruleUpper
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUpperLowerAccess().getUpperUpperParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUpper_in_ruleupperLower5495);
            lv_upper_0_0=ruleUpper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getUpperLowerRule());
              	        }
                     		set(
                     			current, 
                     			"upper",
                      		lv_upper_0_0, 
                      		"Upper");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2535:2: ( (lv_lower_1_0= ruleLower ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==KEYWORD_34) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2536:1: (lv_lower_1_0= ruleLower )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2536:1: (lv_lower_1_0= ruleLower )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2537:3: lv_lower_1_0= ruleLower
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUpperLowerAccess().getLowerLowerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLower_in_ruleupperLower5516);
                    lv_lower_1_0=ruleLower();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUpperLowerRule());
                      	        }
                             		set(
                             			current, 
                             			"lower",
                              		lv_lower_1_0, 
                              		"Lower");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleupperLower"


    // $ANTLR start "entryRulelowerUpper"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2561:1: entryRulelowerUpper returns [EObject current=null] : iv_rulelowerUpper= rulelowerUpper EOF ;
    public final EObject entryRulelowerUpper() throws RecognitionException {
        EObject current = null;

        EObject iv_rulelowerUpper = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2562:2: (iv_rulelowerUpper= rulelowerUpper EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2563:2: iv_rulelowerUpper= rulelowerUpper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerUpperRule()); 
            }
            pushFollow(FOLLOW_rulelowerUpper_in_entryRulelowerUpper5552);
            iv_rulelowerUpper=rulelowerUpper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulelowerUpper; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulelowerUpper5562); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulelowerUpper"


    // $ANTLR start "rulelowerUpper"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2570:1: rulelowerUpper returns [EObject current=null] : ( ( (lv_lower_0_0= ruleLower ) ) ( (lv_upper_1_0= ruleUpper ) )? ) ;
    public final EObject rulelowerUpper() throws RecognitionException {
        EObject current = null;

        EObject lv_lower_0_0 = null;

        EObject lv_upper_1_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2573:28: ( ( ( (lv_lower_0_0= ruleLower ) ) ( (lv_upper_1_0= ruleUpper ) )? ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2574:1: ( ( (lv_lower_0_0= ruleLower ) ) ( (lv_upper_1_0= ruleUpper ) )? )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2574:1: ( ( (lv_lower_0_0= ruleLower ) ) ( (lv_upper_1_0= ruleUpper ) )? )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2574:2: ( (lv_lower_0_0= ruleLower ) ) ( (lv_upper_1_0= ruleUpper ) )?
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2574:2: ( (lv_lower_0_0= ruleLower ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2575:1: (lv_lower_0_0= ruleLower )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2575:1: (lv_lower_0_0= ruleLower )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2576:3: lv_lower_0_0= ruleLower
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerUpperAccess().getLowerLowerParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLower_in_rulelowerUpper5608);
            lv_lower_0_0=ruleLower();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLowerUpperRule());
              	        }
                     		set(
                     			current, 
                     			"lower",
                      		lv_lower_0_0, 
                      		"Lower");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2592:2: ( (lv_upper_1_0= ruleUpper ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==KEYWORD_37) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2593:1: (lv_upper_1_0= ruleUpper )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2593:1: (lv_upper_1_0= ruleUpper )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2594:3: lv_upper_1_0= ruleUpper
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLowerUpperAccess().getUpperUpperParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUpper_in_rulelowerUpper5629);
                    lv_upper_1_0=ruleUpper();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLowerUpperRule());
                      	        }
                             		set(
                             			current, 
                             			"upper",
                              		lv_upper_1_0, 
                              		"Upper");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulelowerUpper"


    // $ANTLR start "entryRuleUpper"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2618:1: entryRuleUpper returns [EObject current=null] : iv_ruleUpper= ruleUpper EOF ;
    public final EObject entryRuleUpper() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpper = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2619:2: (iv_ruleUpper= ruleUpper EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2620:2: iv_ruleUpper= ruleUpper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUpperRule()); 
            }
            pushFollow(FOLLOW_ruleUpper_in_entryRuleUpper5665);
            iv_ruleUpper=ruleUpper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUpper; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpper5675); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUpper"


    // $ANTLR start "ruleUpper"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2627:1: ruleUpper returns [EObject current=null] : ( (otherlv_0= KEYWORD_37 | otherlv_1= KEYWORD_37 ) ( ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) ) ;
    public final EObject ruleUpper() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2630:28: ( ( (otherlv_0= KEYWORD_37 | otherlv_1= KEYWORD_37 ) ( ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2631:1: ( (otherlv_0= KEYWORD_37 | otherlv_1= KEYWORD_37 ) ( ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2631:1: ( (otherlv_0= KEYWORD_37 | otherlv_1= KEYWORD_37 ) ( ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2631:2: (otherlv_0= KEYWORD_37 | otherlv_1= KEYWORD_37 ) ( ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) ) | ( (lv_expression_5_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2631:2: (otherlv_0= KEYWORD_37 | otherlv_1= KEYWORD_37 )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==KEYWORD_37) ) {
                int LA70_1 = input.LA(2);

                if ( (synpred80_InternalWreslEditorParser()) ) {
                    alt70=1;
                }
                else if ( (true) ) {
                    alt70=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 70, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2632:2: otherlv_0= KEYWORD_37
                    {
                    otherlv_0=(Token)match(input,KEYWORD_37,FOLLOW_KEYWORD_37_in_ruleUpper5714); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getUpperAccess().getUpperKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2638:2: otherlv_1= KEYWORD_37
                    {
                    otherlv_1=(Token)match(input,KEYWORD_37,FOLLOW_KEYWORD_37_in_ruleUpper5732); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getUpperAccess().getUPPERKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2642:2: ( ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) ) | ( (lv_expression_5_0= ruleExpression ) ) )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==KEYWORD_52) ) {
                alt72=1;
            }
            else if ( (LA72_0==KEYWORD_1||LA72_0==KEYWORD_4||LA72_0==KEYWORD_6||(LA72_0>=RULE_MIN && LA72_0<=RULE_FLOAT)||LA72_0==RULE_ID) ) {
                alt72=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2642:3: ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2642:3: ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2642:4: () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2642:4: ()
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2643:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getUpperAccess().getUpperAction_1_0_0(),
                                  current);
                          
                    }

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2651:2: (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 )
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==KEYWORD_52) ) {
                        int LA71_1 = input.LA(2);

                        if ( (synpred81_InternalWreslEditorParser()) ) {
                            alt71=1;
                        }
                        else if ( (true) ) {
                            alt71=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 71, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 0, input);

                        throw nvae;
                    }
                    switch (alt71) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2652:2: otherlv_3= KEYWORD_52
                            {
                            otherlv_3=(Token)match(input,KEYWORD_52,FOLLOW_KEYWORD_52_in_ruleUpper5760); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getUpperAccess().getUnboundedKeyword_1_0_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2658:2: otherlv_4= KEYWORD_52
                            {
                            otherlv_4=(Token)match(input,KEYWORD_52,FOLLOW_KEYWORD_52_in_ruleUpper5778); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getUpperAccess().getUNBOUNDEDKeyword_1_0_1_1());
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2663:6: ( (lv_expression_5_0= ruleExpression ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2663:6: ( (lv_expression_5_0= ruleExpression ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2664:1: (lv_expression_5_0= ruleExpression )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2664:1: (lv_expression_5_0= ruleExpression )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2665:3: lv_expression_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUpperAccess().getExpressionExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleUpper5806);
                    lv_expression_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getUpperRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_5_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUpper"


    // $ANTLR start "entryRuleLower"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2689:1: entryRuleLower returns [EObject current=null] : iv_ruleLower= ruleLower EOF ;
    public final EObject entryRuleLower() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLower = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2690:2: (iv_ruleLower= ruleLower EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2691:2: iv_ruleLower= ruleLower EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerRule()); 
            }
            pushFollow(FOLLOW_ruleLower_in_entryRuleLower5842);
            iv_ruleLower=ruleLower();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLower; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLower5852); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLower"


    // $ANTLR start "ruleLower"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2698:1: ruleLower returns [EObject current=null] : ( (otherlv_0= KEYWORD_34 | otherlv_1= KEYWORD_34 ) ( ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) ) ;
    public final EObject ruleLower() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2701:28: ( ( (otherlv_0= KEYWORD_34 | otherlv_1= KEYWORD_34 ) ( ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2702:1: ( (otherlv_0= KEYWORD_34 | otherlv_1= KEYWORD_34 ) ( ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2702:1: ( (otherlv_0= KEYWORD_34 | otherlv_1= KEYWORD_34 ) ( ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2702:2: (otherlv_0= KEYWORD_34 | otherlv_1= KEYWORD_34 ) ( ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) ) | ( (lv_expression_5_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2702:2: (otherlv_0= KEYWORD_34 | otherlv_1= KEYWORD_34 )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==KEYWORD_34) ) {
                int LA73_1 = input.LA(2);

                if ( (synpred83_InternalWreslEditorParser()) ) {
                    alt73=1;
                }
                else if ( (true) ) {
                    alt73=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 73, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }
            switch (alt73) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2703:2: otherlv_0= KEYWORD_34
                    {
                    otherlv_0=(Token)match(input,KEYWORD_34,FOLLOW_KEYWORD_34_in_ruleLower5891); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getLowerAccess().getLowerKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2709:2: otherlv_1= KEYWORD_34
                    {
                    otherlv_1=(Token)match(input,KEYWORD_34,FOLLOW_KEYWORD_34_in_ruleLower5909); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLowerAccess().getLOWERKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2713:2: ( ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) ) | ( (lv_expression_5_0= ruleExpression ) ) )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==KEYWORD_52) ) {
                alt75=1;
            }
            else if ( (LA75_0==KEYWORD_1||LA75_0==KEYWORD_4||LA75_0==KEYWORD_6||(LA75_0>=RULE_MIN && LA75_0<=RULE_FLOAT)||LA75_0==RULE_ID) ) {
                alt75=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2713:3: ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2713:3: ( () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2713:4: () (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2713:4: ()
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2714:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLowerAccess().getLowerAction_1_0_0(),
                                  current);
                          
                    }

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2722:2: (otherlv_3= KEYWORD_52 | otherlv_4= KEYWORD_52 )
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==KEYWORD_52) ) {
                        int LA74_1 = input.LA(2);

                        if ( (synpred84_InternalWreslEditorParser()) ) {
                            alt74=1;
                        }
                        else if ( (true) ) {
                            alt74=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 74, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 74, 0, input);

                        throw nvae;
                    }
                    switch (alt74) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2723:2: otherlv_3= KEYWORD_52
                            {
                            otherlv_3=(Token)match(input,KEYWORD_52,FOLLOW_KEYWORD_52_in_ruleLower5937); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getLowerAccess().getUnboundedKeyword_1_0_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2729:2: otherlv_4= KEYWORD_52
                            {
                            otherlv_4=(Token)match(input,KEYWORD_52,FOLLOW_KEYWORD_52_in_ruleLower5955); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_4, grammarAccess.getLowerAccess().getUNBOUNDEDKeyword_1_0_1_1());
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2734:6: ( (lv_expression_5_0= ruleExpression ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2734:6: ( (lv_expression_5_0= ruleExpression ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2735:1: (lv_expression_5_0= ruleExpression )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2735:1: (lv_expression_5_0= ruleExpression )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2736:3: lv_expression_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLowerAccess().getExpressionExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleLower5983);
                    lv_expression_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLowerRule());
                      	        }
                             		set(
                             			current, 
                             			"expression",
                              		lv_expression_5_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLower"


    // $ANTLR start "entryRuleGoal"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2760:1: entryRuleGoal returns [EObject current=null] : iv_ruleGoal= ruleGoal EOF ;
    public final EObject entryRuleGoal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoal = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2761:2: (iv_ruleGoal= ruleGoal EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2762:2: iv_ruleGoal= ruleGoal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGoalRule()); 
            }
            pushFollow(FOLLOW_ruleGoal_in_entryRuleGoal6019);
            iv_ruleGoal=ruleGoal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGoal; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoal6029); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGoal"


    // $ANTLR start "ruleGoal"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2769:1: ruleGoal returns [EObject current=null] : ( (otherlv_0= KEYWORD_29 | otherlv_1= KEYWORD_29 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) ) ) otherlv_8= KEYWORD_14 ) ;
    public final EObject ruleGoal() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_local_3_1=null;
        Token lv_local_3_2=null;
        Token otherlv_4=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_definition_7_1 = null;

        EObject lv_definition_7_2 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2772:28: ( ( (otherlv_0= KEYWORD_29 | otherlv_1= KEYWORD_29 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) ) ) otherlv_8= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2773:1: ( (otherlv_0= KEYWORD_29 | otherlv_1= KEYWORD_29 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) ) ) otherlv_8= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2773:1: ( (otherlv_0= KEYWORD_29 | otherlv_1= KEYWORD_29 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) ) ) otherlv_8= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2773:2: (otherlv_0= KEYWORD_29 | otherlv_1= KEYWORD_29 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) ) ) otherlv_8= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2773:2: (otherlv_0= KEYWORD_29 | otherlv_1= KEYWORD_29 )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==KEYWORD_29) ) {
                int LA76_1 = input.LA(2);

                if ( (synpred86_InternalWreslEditorParser()) ) {
                    alt76=1;
                }
                else if ( (true) ) {
                    alt76=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 76, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2774:2: otherlv_0= KEYWORD_29
                    {
                    otherlv_0=(Token)match(input,KEYWORD_29,FOLLOW_KEYWORD_29_in_ruleGoal6068); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getGoalAccess().getGoalKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2780:2: otherlv_1= KEYWORD_29
                    {
                    otherlv_1=(Token)match(input,KEYWORD_29,FOLLOW_KEYWORD_29_in_ruleGoal6086); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getGoalAccess().getGOALKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2784:2: (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==KEYWORD_11) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2785:2: otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12
                    {
                    otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleGoal6100); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2789:1: ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2790:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2790:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2791:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2791:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==KEYWORD_33) ) {
                        int LA77_1 = input.LA(2);

                        if ( (synpred87_InternalWreslEditorParser()) ) {
                            alt77=1;
                        }
                        else if ( (true) ) {
                            alt77=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 77, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 77, 0, input);

                        throw nvae;
                    }
                    switch (alt77) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2792:3: lv_local_3_1= KEYWORD_33
                            {
                            lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleGoal6120); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_local_3_1, grammarAccess.getGoalAccess().getLocalLocalKeyword_1_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getGoalRule());
                              	        }
                                     		setWithLastConsumed(current, "local", true, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2805:8: lv_local_3_2= KEYWORD_33
                            {
                            lv_local_3_2=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleGoal6148); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_local_3_2, grammarAccess.getGoalAccess().getLocalLOCALKeyword_1_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getGoalRule());
                              	        }
                                     		setWithLastConsumed(current, "local", true, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_4=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleGoal6175); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getGoalAccess().getRightSquareBracketKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2826:3: ( (lv_name_5_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2827:1: (lv_name_5_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2827:1: (lv_name_5_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2828:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal6193); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_5_0, grammarAccess.getGoalAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getGoalRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_5_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_6=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleGoal6211); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getGoalAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2849:1: ( ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2850:1: ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2850:1: ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2851:1: (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2851:1: (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==KEYWORD_1||LA79_0==KEYWORD_4||LA79_0==KEYWORD_6||(LA79_0>=RULE_MIN && LA79_0<=RULE_FLOAT)||LA79_0==RULE_ID) ) {
                alt79=1;
            }
            else if ( (LA79_0==KEYWORD_21) ) {
                alt79=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2852:3: lv_definition_7_1= ruleGoalSimple
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGoalAccess().getDefinitionGoalSimpleParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleGoalSimple_in_ruleGoal6233);
                    lv_definition_7_1=ruleGoalSimple();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getGoalRule());
                      	        }
                             		set(
                             			current, 
                             			"definition",
                              		lv_definition_7_1, 
                              		"GoalSimple");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2867:8: lv_definition_7_2= ruleGoalCase
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGoalAccess().getDefinitionGoalCaseParserRuleCall_4_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleGoalCase_in_ruleGoal6252);
                    lv_definition_7_2=ruleGoalCase();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getGoalRule());
                      	        }
                             		set(
                             			current, 
                             			"definition",
                              		lv_definition_7_2, 
                              		"GoalCase");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }
                    break;

            }


            }


            }

            otherlv_8=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleGoal6268); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getGoalAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGoal"


    // $ANTLR start "entryRuleGoalCase"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2898:1: entryRuleGoalCase returns [EObject current=null] : iv_ruleGoalCase= ruleGoalCase EOF ;
    public final EObject entryRuleGoalCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoalCase = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2899:2: (iv_ruleGoalCase= ruleGoalCase EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2900:2: iv_ruleGoalCase= ruleGoalCase EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGoalCaseRule()); 
            }
            pushFollow(FOLLOW_ruleGoalCase_in_entryRuleGoalCase6302);
            iv_ruleGoalCase=ruleGoalCase();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGoalCase; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoalCase6312); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGoalCase"


    // $ANTLR start "ruleGoalCase"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2907:1: ruleGoalCase returns [EObject current=null] : ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) ( (lv_lhs_2_0= ruleExpression ) ) ( ( (lv_content_3_0= ruleGoalNoCaseContent ) ) | ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+ ) ) ;
    public final EObject ruleGoalCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_lhs_2_0 = null;

        EObject lv_content_3_0 = null;

        EObject lv_caseContent_4_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2910:28: ( ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) ( (lv_lhs_2_0= ruleExpression ) ) ( ( (lv_content_3_0= ruleGoalNoCaseContent ) ) | ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+ ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2911:1: ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) ( (lv_lhs_2_0= ruleExpression ) ) ( ( (lv_content_3_0= ruleGoalNoCaseContent ) ) | ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+ ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2911:1: ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) ( (lv_lhs_2_0= ruleExpression ) ) ( ( (lv_content_3_0= ruleGoalNoCaseContent ) ) | ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+ ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2911:2: (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) ( (lv_lhs_2_0= ruleExpression ) ) ( ( (lv_content_3_0= ruleGoalNoCaseContent ) ) | ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+ )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2911:2: (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 )
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==KEYWORD_21) ) {
                int LA80_1 = input.LA(2);

                if ( (synpred90_InternalWreslEditorParser()) ) {
                    alt80=1;
                }
                else if ( (true) ) {
                    alt80=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 80, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 80, 0, input);

                throw nvae;
            }
            switch (alt80) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2912:2: otherlv_0= KEYWORD_21
                    {
                    otherlv_0=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleGoalCase6351); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getGoalCaseAccess().getLhsKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2918:2: otherlv_1= KEYWORD_21
                    {
                    otherlv_1=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleGoalCase6369); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getGoalCaseAccess().getLHSKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2922:2: ( (lv_lhs_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2923:1: (lv_lhs_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2923:1: (lv_lhs_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2924:3: lv_lhs_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGoalCaseAccess().getLhsExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleGoalCase6390);
            lv_lhs_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGoalCaseRule());
              	        }
                     		set(
                     			current, 
                     			"lhs",
                      		lv_lhs_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2940:2: ( ( (lv_content_3_0= ruleGoalNoCaseContent ) ) | ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+ )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==KEYWORD_22) ) {
                alt82=1;
            }
            else if ( (LA82_0==KEYWORD_27) ) {
                alt82=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2940:3: ( (lv_content_3_0= ruleGoalNoCaseContent ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2940:3: ( (lv_content_3_0= ruleGoalNoCaseContent ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2941:1: (lv_content_3_0= ruleGoalNoCaseContent )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2941:1: (lv_content_3_0= ruleGoalNoCaseContent )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2942:3: lv_content_3_0= ruleGoalNoCaseContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGoalCaseAccess().getContentGoalNoCaseContentParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleGoalNoCaseContent_in_ruleGoalCase6412);
                    lv_content_3_0=ruleGoalNoCaseContent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getGoalCaseRule());
                      	        }
                             		set(
                             			current, 
                             			"content",
                              		lv_content_3_0, 
                              		"GoalNoCaseContent");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2959:6: ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2959:6: ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+
                    int cnt81=0;
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==KEYWORD_27) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2960:1: (lv_caseContent_4_0= ruleGoalCaseContent )
                    	    {
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2960:1: (lv_caseContent_4_0= ruleGoalCaseContent )
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2961:3: lv_caseContent_4_0= ruleGoalCaseContent
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGoalCaseAccess().getCaseContentGoalCaseContentParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleGoalCaseContent_in_ruleGoalCase6439);
                    	    lv_caseContent_4_0=ruleGoalCaseContent();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getGoalCaseRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"caseContent",
                    	              		lv_caseContent_4_0, 
                    	              		"GoalCaseContent");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt81 >= 1 ) break loop81;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(81, input);
                                throw eee;
                        }
                        cnt81++;
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGoalCase"


    // $ANTLR start "entryRuleGoalCaseContent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2985:1: entryRuleGoalCaseContent returns [EObject current=null] : iv_ruleGoalCaseContent= ruleGoalCaseContent EOF ;
    public final EObject entryRuleGoalCaseContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoalCaseContent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2986:2: (iv_ruleGoalCaseContent= ruleGoalCaseContent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2987:2: iv_ruleGoalCaseContent= ruleGoalCaseContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGoalCaseContentRule()); 
            }
            pushFollow(FOLLOW_ruleGoalCaseContent_in_entryRuleGoalCaseContent6476);
            iv_ruleGoalCaseContent=ruleGoalCaseContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGoalCaseContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoalCaseContent6486); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGoalCaseContent"


    // $ANTLR start "ruleGoalCaseContent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2994:1: ruleGoalCaseContent returns [EObject current=null] : ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) (otherlv_5= KEYWORD_22 | otherlv_6= KEYWORD_22 ) ( (lv_rhs_7_0= ruleExpression ) ) ( (lv_subContent_8_0= ruleSubContent ) )? otherlv_9= KEYWORD_14 ) ;
    public final EObject ruleGoalCaseContent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_caseName_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_condition_4_0 = null;

        EObject lv_rhs_7_0 = null;

        EObject lv_subContent_8_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2997:28: ( ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) (otherlv_5= KEYWORD_22 | otherlv_6= KEYWORD_22 ) ( (lv_rhs_7_0= ruleExpression ) ) ( (lv_subContent_8_0= ruleSubContent ) )? otherlv_9= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2998:1: ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) (otherlv_5= KEYWORD_22 | otherlv_6= KEYWORD_22 ) ( (lv_rhs_7_0= ruleExpression ) ) ( (lv_subContent_8_0= ruleSubContent ) )? otherlv_9= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2998:1: ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) (otherlv_5= KEYWORD_22 | otherlv_6= KEYWORD_22 ) ( (lv_rhs_7_0= ruleExpression ) ) ( (lv_subContent_8_0= ruleSubContent ) )? otherlv_9= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2998:2: (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) (otherlv_5= KEYWORD_22 | otherlv_6= KEYWORD_22 ) ( (lv_rhs_7_0= ruleExpression ) ) ( (lv_subContent_8_0= ruleSubContent ) )? otherlv_9= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2998:2: (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==KEYWORD_27) ) {
                int LA83_1 = input.LA(2);

                if ( (synpred93_InternalWreslEditorParser()) ) {
                    alt83=1;
                }
                else if ( (true) ) {
                    alt83=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }
            switch (alt83) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2999:2: otherlv_0= KEYWORD_27
                    {
                    otherlv_0=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_ruleGoalCaseContent6525); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getGoalCaseContentAccess().getCaseKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3005:2: otherlv_1= KEYWORD_27
                    {
                    otherlv_1=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_ruleGoalCaseContent6543); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getGoalCaseContentAccess().getCASEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3009:2: ( (lv_caseName_2_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3010:1: (lv_caseName_2_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3010:1: (lv_caseName_2_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3011:3: lv_caseName_2_0= RULE_ID
            {
            lv_caseName_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoalCaseContent6560); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_caseName_2_0, grammarAccess.getGoalCaseContentAccess().getCaseNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getGoalCaseContentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"caseName",
                      		lv_caseName_2_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleGoalCaseContent6578); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getGoalCaseContentAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3032:1: ( (lv_condition_4_0= ruleCondition ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3033:1: (lv_condition_4_0= ruleCondition )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3033:1: (lv_condition_4_0= ruleCondition )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3034:3: lv_condition_4_0= ruleCondition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGoalCaseContentAccess().getConditionConditionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCondition_in_ruleGoalCaseContent6598);
            lv_condition_4_0=ruleCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGoalCaseContentRule());
              	        }
                     		set(
                     			current, 
                     			"condition",
                      		lv_condition_4_0, 
                      		"Condition");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3050:2: (otherlv_5= KEYWORD_22 | otherlv_6= KEYWORD_22 )
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==KEYWORD_22) ) {
                int LA84_1 = input.LA(2);

                if ( (synpred94_InternalWreslEditorParser()) ) {
                    alt84=1;
                }
                else if ( (true) ) {
                    alt84=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 84, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }
            switch (alt84) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3051:2: otherlv_5= KEYWORD_22
                    {
                    otherlv_5=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleGoalCaseContent6612); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getGoalCaseContentAccess().getRhsKeyword_4_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3057:2: otherlv_6= KEYWORD_22
                    {
                    otherlv_6=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleGoalCaseContent6630); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getGoalCaseContentAccess().getRHSKeyword_4_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3061:2: ( (lv_rhs_7_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3062:1: (lv_rhs_7_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3062:1: (lv_rhs_7_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3063:3: lv_rhs_7_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGoalCaseContentAccess().getRhsExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleGoalCaseContent6651);
            lv_rhs_7_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGoalCaseContentRule());
              	        }
                     		set(
                     			current, 
                     			"rhs",
                      		lv_rhs_7_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3079:2: ( (lv_subContent_8_0= ruleSubContent ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==KEYWORD_21) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3080:1: (lv_subContent_8_0= ruleSubContent )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3080:1: (lv_subContent_8_0= ruleSubContent )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3081:3: lv_subContent_8_0= ruleSubContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGoalCaseContentAccess().getSubContentSubContentParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSubContent_in_ruleGoalCaseContent6672);
                    lv_subContent_8_0=ruleSubContent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getGoalCaseContentRule());
                      	        }
                             		set(
                             			current, 
                             			"subContent",
                              		lv_subContent_8_0, 
                              		"SubContent");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleGoalCaseContent6686); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_9, grammarAccess.getGoalCaseContentAccess().getRightCurlyBracketKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGoalCaseContent"


    // $ANTLR start "entryRuleGoalNoCaseContent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3110:1: entryRuleGoalNoCaseContent returns [EObject current=null] : iv_ruleGoalNoCaseContent= ruleGoalNoCaseContent EOF ;
    public final EObject entryRuleGoalNoCaseContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoalNoCaseContent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3111:2: (iv_ruleGoalNoCaseContent= ruleGoalNoCaseContent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3112:2: iv_ruleGoalNoCaseContent= ruleGoalNoCaseContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGoalNoCaseContentRule()); 
            }
            pushFollow(FOLLOW_ruleGoalNoCaseContent_in_entryRuleGoalNoCaseContent6720);
            iv_ruleGoalNoCaseContent=ruleGoalNoCaseContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGoalNoCaseContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoalNoCaseContent6730); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGoalNoCaseContent"


    // $ANTLR start "ruleGoalNoCaseContent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3119:1: ruleGoalNoCaseContent returns [EObject current=null] : ( (otherlv_0= KEYWORD_22 | otherlv_1= KEYWORD_22 ) ( (lv_rhs_2_0= ruleExpression ) ) ( (lv_subContent_3_0= ruleSubContent ) )? ) ;
    public final EObject ruleGoalNoCaseContent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_rhs_2_0 = null;

        EObject lv_subContent_3_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3122:28: ( ( (otherlv_0= KEYWORD_22 | otherlv_1= KEYWORD_22 ) ( (lv_rhs_2_0= ruleExpression ) ) ( (lv_subContent_3_0= ruleSubContent ) )? ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3123:1: ( (otherlv_0= KEYWORD_22 | otherlv_1= KEYWORD_22 ) ( (lv_rhs_2_0= ruleExpression ) ) ( (lv_subContent_3_0= ruleSubContent ) )? )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3123:1: ( (otherlv_0= KEYWORD_22 | otherlv_1= KEYWORD_22 ) ( (lv_rhs_2_0= ruleExpression ) ) ( (lv_subContent_3_0= ruleSubContent ) )? )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3123:2: (otherlv_0= KEYWORD_22 | otherlv_1= KEYWORD_22 ) ( (lv_rhs_2_0= ruleExpression ) ) ( (lv_subContent_3_0= ruleSubContent ) )?
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3123:2: (otherlv_0= KEYWORD_22 | otherlv_1= KEYWORD_22 )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==KEYWORD_22) ) {
                int LA86_1 = input.LA(2);

                if ( (synpred96_InternalWreslEditorParser()) ) {
                    alt86=1;
                }
                else if ( (true) ) {
                    alt86=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3124:2: otherlv_0= KEYWORD_22
                    {
                    otherlv_0=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleGoalNoCaseContent6769); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getGoalNoCaseContentAccess().getRhsKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3130:2: otherlv_1= KEYWORD_22
                    {
                    otherlv_1=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleGoalNoCaseContent6787); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getGoalNoCaseContentAccess().getRHSKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3134:2: ( (lv_rhs_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3135:1: (lv_rhs_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3135:1: (lv_rhs_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3136:3: lv_rhs_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGoalNoCaseContentAccess().getRhsExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleGoalNoCaseContent6808);
            lv_rhs_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGoalNoCaseContentRule());
              	        }
                     		set(
                     			current, 
                     			"rhs",
                      		lv_rhs_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3152:2: ( (lv_subContent_3_0= ruleSubContent ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==KEYWORD_21) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3153:1: (lv_subContent_3_0= ruleSubContent )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3153:1: (lv_subContent_3_0= ruleSubContent )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3154:3: lv_subContent_3_0= ruleSubContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGoalNoCaseContentAccess().getSubContentSubContentParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSubContent_in_ruleGoalNoCaseContent6829);
                    lv_subContent_3_0=ruleSubContent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getGoalNoCaseContentRule());
                      	        }
                             		set(
                             			current, 
                             			"subContent",
                              		lv_subContent_3_0, 
                              		"SubContent");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGoalNoCaseContent"


    // $ANTLR start "entryRuleSubContent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3178:1: entryRuleSubContent returns [EObject current=null] : iv_ruleSubContent= ruleSubContent EOF ;
    public final EObject entryRuleSubContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubContent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3179:2: (iv_ruleSubContent= ruleSubContent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3180:2: iv_ruleSubContent= ruleSubContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubContentRule()); 
            }
            pushFollow(FOLLOW_ruleSubContent_in_entryRuleSubContent6865);
            iv_ruleSubContent=ruleSubContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubContent6875); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubContent"


    // $ANTLR start "ruleSubContent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3187:1: ruleSubContent returns [EObject current=null] : ( ( ( (lv_gt_0_0= ruleLhsGtRhs ) ) ( (lv_lt_1_0= ruleLhsLtRhs ) )? ) | ( ( (lv_lt_2_0= ruleLhsLtRhs ) ) ( (lv_gt_3_0= ruleLhsGtRhs ) )? ) ) ;
    public final EObject ruleSubContent() throws RecognitionException {
        EObject current = null;

        EObject lv_gt_0_0 = null;

        EObject lv_lt_1_0 = null;

        EObject lv_lt_2_0 = null;

        EObject lv_gt_3_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3190:28: ( ( ( ( (lv_gt_0_0= ruleLhsGtRhs ) ) ( (lv_lt_1_0= ruleLhsLtRhs ) )? ) | ( ( (lv_lt_2_0= ruleLhsLtRhs ) ) ( (lv_gt_3_0= ruleLhsGtRhs ) )? ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3191:1: ( ( ( (lv_gt_0_0= ruleLhsGtRhs ) ) ( (lv_lt_1_0= ruleLhsLtRhs ) )? ) | ( ( (lv_lt_2_0= ruleLhsLtRhs ) ) ( (lv_gt_3_0= ruleLhsGtRhs ) )? ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3191:1: ( ( ( (lv_gt_0_0= ruleLhsGtRhs ) ) ( (lv_lt_1_0= ruleLhsLtRhs ) )? ) | ( ( (lv_lt_2_0= ruleLhsLtRhs ) ) ( (lv_gt_3_0= ruleLhsGtRhs ) )? ) )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==KEYWORD_21) ) {
                int LA90_1 = input.LA(2);

                if ( (LA90_1==KEYWORD_8) ) {
                    alt90=2;
                }
                else if ( (LA90_1==KEYWORD_10) ) {
                    alt90=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3191:2: ( ( (lv_gt_0_0= ruleLhsGtRhs ) ) ( (lv_lt_1_0= ruleLhsLtRhs ) )? )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3191:2: ( ( (lv_gt_0_0= ruleLhsGtRhs ) ) ( (lv_lt_1_0= ruleLhsLtRhs ) )? )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3191:3: ( (lv_gt_0_0= ruleLhsGtRhs ) ) ( (lv_lt_1_0= ruleLhsLtRhs ) )?
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3191:3: ( (lv_gt_0_0= ruleLhsGtRhs ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3192:1: (lv_gt_0_0= ruleLhsGtRhs )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3192:1: (lv_gt_0_0= ruleLhsGtRhs )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3193:3: lv_gt_0_0= ruleLhsGtRhs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubContentAccess().getGtLhsGtRhsParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLhsGtRhs_in_ruleSubContent6922);
                    lv_gt_0_0=ruleLhsGtRhs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSubContentRule());
                      	        }
                             		set(
                             			current, 
                             			"gt",
                              		lv_gt_0_0, 
                              		"LhsGtRhs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3209:2: ( (lv_lt_1_0= ruleLhsLtRhs ) )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==KEYWORD_21) ) {
                        alt88=1;
                    }
                    switch (alt88) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3210:1: (lv_lt_1_0= ruleLhsLtRhs )
                            {
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3210:1: (lv_lt_1_0= ruleLhsLtRhs )
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3211:3: lv_lt_1_0= ruleLhsLtRhs
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getSubContentAccess().getLtLhsLtRhsParserRuleCall_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLhsLtRhs_in_ruleSubContent6943);
                            lv_lt_1_0=ruleLhsLtRhs();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getSubContentRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"lt",
                                      		lv_lt_1_0, 
                                      		"LhsLtRhs");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3228:6: ( ( (lv_lt_2_0= ruleLhsLtRhs ) ) ( (lv_gt_3_0= ruleLhsGtRhs ) )? )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3228:6: ( ( (lv_lt_2_0= ruleLhsLtRhs ) ) ( (lv_gt_3_0= ruleLhsGtRhs ) )? )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3228:7: ( (lv_lt_2_0= ruleLhsLtRhs ) ) ( (lv_gt_3_0= ruleLhsGtRhs ) )?
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3228:7: ( (lv_lt_2_0= ruleLhsLtRhs ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3229:1: (lv_lt_2_0= ruleLhsLtRhs )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3229:1: (lv_lt_2_0= ruleLhsLtRhs )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3230:3: lv_lt_2_0= ruleLhsLtRhs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubContentAccess().getLtLhsLtRhsParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLhsLtRhs_in_ruleSubContent6973);
                    lv_lt_2_0=ruleLhsLtRhs();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSubContentRule());
                      	        }
                             		set(
                             			current, 
                             			"lt",
                              		lv_lt_2_0, 
                              		"LhsLtRhs");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3246:2: ( (lv_gt_3_0= ruleLhsGtRhs ) )?
                    int alt89=2;
                    int LA89_0 = input.LA(1);

                    if ( (LA89_0==KEYWORD_21) ) {
                        alt89=1;
                    }
                    switch (alt89) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3247:1: (lv_gt_3_0= ruleLhsGtRhs )
                            {
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3247:1: (lv_gt_3_0= ruleLhsGtRhs )
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3248:3: lv_gt_3_0= ruleLhsGtRhs
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getSubContentAccess().getGtLhsGtRhsParserRuleCall_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLhsGtRhs_in_ruleSubContent6994);
                            lv_gt_3_0=ruleLhsGtRhs();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getSubContentRule());
                              	        }
                                     		set(
                                     			current, 
                                     			"gt",
                                      		lv_gt_3_0, 
                                      		"LhsGtRhs");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubContent"


    // $ANTLR start "entryRuleLhsGtRhs"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3272:1: entryRuleLhsGtRhs returns [EObject current=null] : iv_ruleLhsGtRhs= ruleLhsGtRhs EOF ;
    public final EObject entryRuleLhsGtRhs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLhsGtRhs = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3273:2: (iv_ruleLhsGtRhs= ruleLhsGtRhs EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3274:2: iv_ruleLhsGtRhs= ruleLhsGtRhs EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLhsGtRhsRule()); 
            }
            pushFollow(FOLLOW_ruleLhsGtRhs_in_entryRuleLhsGtRhs7031);
            iv_ruleLhsGtRhs=ruleLhsGtRhs();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLhsGtRhs; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLhsGtRhs7041); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLhsGtRhs"


    // $ANTLR start "ruleLhsGtRhs"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3281:1: ruleLhsGtRhs returns [EObject current=null] : ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_10 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) ) ;
    public final EObject ruleLhsGtRhs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_penalty_8_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3284:28: ( ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_10 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3285:1: ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_10 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3285:1: ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_10 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3285:2: (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_10 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3285:2: (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==KEYWORD_21) ) {
                int LA91_1 = input.LA(2);

                if ( (synpred101_InternalWreslEditorParser()) ) {
                    alt91=1;
                }
                else if ( (true) ) {
                    alt91=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 91, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3286:2: otherlv_0= KEYWORD_21
                    {
                    otherlv_0=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleLhsGtRhs7080); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getLhsGtRhsAccess().getLhsKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3292:2: otherlv_1= KEYWORD_21
                    {
                    otherlv_1=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleLhsGtRhs7098); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLhsGtRhsAccess().getLHSKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            otherlv_2=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleLhsGtRhs7111); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLhsGtRhsAccess().getGreaterThanSignKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3301:1: (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==KEYWORD_22) ) {
                int LA92_1 = input.LA(2);

                if ( (synpred102_InternalWreslEditorParser()) ) {
                    alt92=1;
                }
                else if ( (true) ) {
                    alt92=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 92, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3302:2: otherlv_3= KEYWORD_22
                    {
                    otherlv_3=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleLhsGtRhs7124); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getLhsGtRhsAccess().getRhsKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3308:2: otherlv_4= KEYWORD_22
                    {
                    otherlv_4=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleLhsGtRhs7142); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getLhsGtRhsAccess().getRHSKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3312:2: ( ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==KEYWORD_50) ) {
                alt94=1;
            }
            else if ( (LA94_0==KEYWORD_46) ) {
                alt94=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3312:3: ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3312:3: ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3312:4: () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3312:4: ()
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3313:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLhsGtRhsAccess().getLhsGtRhsAction_3_0_0(),
                                  current);
                          
                    }

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3321:2: (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 )
                    int alt93=2;
                    int LA93_0 = input.LA(1);

                    if ( (LA93_0==KEYWORD_50) ) {
                        int LA93_1 = input.LA(2);

                        if ( (synpred103_InternalWreslEditorParser()) ) {
                            alt93=1;
                        }
                        else if ( (true) ) {
                            alt93=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 93, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 93, 0, input);

                        throw nvae;
                    }
                    switch (alt93) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3322:2: otherlv_6= KEYWORD_50
                            {
                            otherlv_6=(Token)match(input,KEYWORD_50,FOLLOW_KEYWORD_50_in_ruleLhsGtRhs7170); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getLhsGtRhsAccess().getConstrainKeyword_3_0_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3328:2: otherlv_7= KEYWORD_50
                            {
                            otherlv_7=(Token)match(input,KEYWORD_50,FOLLOW_KEYWORD_50_in_ruleLhsGtRhs7188); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getLhsGtRhsAccess().getCONSTRAINKeyword_3_0_1_1());
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3333:6: ( (lv_penalty_8_0= rulePenalty ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3333:6: ( (lv_penalty_8_0= rulePenalty ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3334:1: (lv_penalty_8_0= rulePenalty )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3334:1: (lv_penalty_8_0= rulePenalty )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3335:3: lv_penalty_8_0= rulePenalty
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLhsGtRhsAccess().getPenaltyPenaltyParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePenalty_in_ruleLhsGtRhs7216);
                    lv_penalty_8_0=rulePenalty();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLhsGtRhsRule());
                      	        }
                             		set(
                             			current, 
                             			"penalty",
                              		lv_penalty_8_0, 
                              		"Penalty");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLhsGtRhs"


    // $ANTLR start "entryRuleLhsLtRhs"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3359:1: entryRuleLhsLtRhs returns [EObject current=null] : iv_ruleLhsLtRhs= ruleLhsLtRhs EOF ;
    public final EObject entryRuleLhsLtRhs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLhsLtRhs = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3360:2: (iv_ruleLhsLtRhs= ruleLhsLtRhs EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3361:2: iv_ruleLhsLtRhs= ruleLhsLtRhs EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLhsLtRhsRule()); 
            }
            pushFollow(FOLLOW_ruleLhsLtRhs_in_entryRuleLhsLtRhs7252);
            iv_ruleLhsLtRhs=ruleLhsLtRhs();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLhsLtRhs; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLhsLtRhs7262); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLhsLtRhs"


    // $ANTLR start "ruleLhsLtRhs"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3368:1: ruleLhsLtRhs returns [EObject current=null] : ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_8 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) ) ;
    public final EObject ruleLhsLtRhs() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_penalty_8_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3371:28: ( ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_8 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3372:1: ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_8 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3372:1: ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_8 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3372:2: (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_8 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3372:2: (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==KEYWORD_21) ) {
                int LA95_1 = input.LA(2);

                if ( (synpred105_InternalWreslEditorParser()) ) {
                    alt95=1;
                }
                else if ( (true) ) {
                    alt95=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 95, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3373:2: otherlv_0= KEYWORD_21
                    {
                    otherlv_0=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleLhsLtRhs7301); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getLhsLtRhsAccess().getLhsKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3379:2: otherlv_1= KEYWORD_21
                    {
                    otherlv_1=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleLhsLtRhs7319); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLhsLtRhsAccess().getLHSKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            otherlv_2=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleLhsLtRhs7332); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLhsLtRhsAccess().getLessThanSignKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3388:1: (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==KEYWORD_22) ) {
                int LA96_1 = input.LA(2);

                if ( (synpred106_InternalWreslEditorParser()) ) {
                    alt96=1;
                }
                else if ( (true) ) {
                    alt96=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 96, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3389:2: otherlv_3= KEYWORD_22
                    {
                    otherlv_3=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleLhsLtRhs7345); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getLhsLtRhsAccess().getRhsKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3395:2: otherlv_4= KEYWORD_22
                    {
                    otherlv_4=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleLhsLtRhs7363); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getLhsLtRhsAccess().getRHSKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3399:2: ( ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==KEYWORD_50) ) {
                alt98=1;
            }
            else if ( (LA98_0==KEYWORD_46) ) {
                alt98=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3399:3: ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3399:3: ( () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3399:4: () (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3399:4: ()
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3400:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getLhsLtRhsAccess().getLhsLtRhsAction_3_0_0(),
                                  current);
                          
                    }

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3408:2: (otherlv_6= KEYWORD_50 | otherlv_7= KEYWORD_50 )
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==KEYWORD_50) ) {
                        int LA97_1 = input.LA(2);

                        if ( (synpred107_InternalWreslEditorParser()) ) {
                            alt97=1;
                        }
                        else if ( (true) ) {
                            alt97=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 97, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 97, 0, input);

                        throw nvae;
                    }
                    switch (alt97) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3409:2: otherlv_6= KEYWORD_50
                            {
                            otherlv_6=(Token)match(input,KEYWORD_50,FOLLOW_KEYWORD_50_in_ruleLhsLtRhs7391); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getLhsLtRhsAccess().getConstrainKeyword_3_0_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3415:2: otherlv_7= KEYWORD_50
                            {
                            otherlv_7=(Token)match(input,KEYWORD_50,FOLLOW_KEYWORD_50_in_ruleLhsLtRhs7409); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getLhsLtRhsAccess().getCONSTRAINKeyword_3_0_1_1());
                                  
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3420:6: ( (lv_penalty_8_0= rulePenalty ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3420:6: ( (lv_penalty_8_0= rulePenalty ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3421:1: (lv_penalty_8_0= rulePenalty )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3421:1: (lv_penalty_8_0= rulePenalty )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3422:3: lv_penalty_8_0= rulePenalty
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLhsLtRhsAccess().getPenaltyPenaltyParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePenalty_in_ruleLhsLtRhs7437);
                    lv_penalty_8_0=rulePenalty();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getLhsLtRhsRule());
                      	        }
                             		set(
                             			current, 
                             			"penalty",
                              		lv_penalty_8_0, 
                              		"Penalty");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLhsLtRhs"


    // $ANTLR start "entryRulePenalty"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3446:1: entryRulePenalty returns [EObject current=null] : iv_rulePenalty= rulePenalty EOF ;
    public final EObject entryRulePenalty() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePenalty = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3447:2: (iv_rulePenalty= rulePenalty EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3448:2: iv_rulePenalty= rulePenalty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPenaltyRule()); 
            }
            pushFollow(FOLLOW_rulePenalty_in_entryRulePenalty7473);
            iv_rulePenalty=rulePenalty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePenalty; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePenalty7483); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePenalty"


    // $ANTLR start "rulePenalty"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3455:1: rulePenalty returns [EObject current=null] : ( (otherlv_0= KEYWORD_46 | otherlv_1= KEYWORD_46 ) ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject rulePenalty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3458:28: ( ( (otherlv_0= KEYWORD_46 | otherlv_1= KEYWORD_46 ) ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3459:1: ( (otherlv_0= KEYWORD_46 | otherlv_1= KEYWORD_46 ) ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3459:1: ( (otherlv_0= KEYWORD_46 | otherlv_1= KEYWORD_46 ) ( (lv_expression_2_0= ruleExpression ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3459:2: (otherlv_0= KEYWORD_46 | otherlv_1= KEYWORD_46 ) ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3459:2: (otherlv_0= KEYWORD_46 | otherlv_1= KEYWORD_46 )
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==KEYWORD_46) ) {
                int LA99_1 = input.LA(2);

                if ( (synpred109_InternalWreslEditorParser()) ) {
                    alt99=1;
                }
                else if ( (true) ) {
                    alt99=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 99, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }
            switch (alt99) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3460:2: otherlv_0= KEYWORD_46
                    {
                    otherlv_0=(Token)match(input,KEYWORD_46,FOLLOW_KEYWORD_46_in_rulePenalty7522); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getPenaltyAccess().getPenaltyKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3466:2: otherlv_1= KEYWORD_46
                    {
                    otherlv_1=(Token)match(input,KEYWORD_46,FOLLOW_KEYWORD_46_in_rulePenalty7540); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPenaltyAccess().getPENALTYKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3470:2: ( (lv_expression_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3471:1: (lv_expression_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3471:1: (lv_expression_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3472:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPenaltyAccess().getExpressionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_rulePenalty7561);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getPenaltyRule());
              	        }
                     		set(
                     			current, 
                     			"expression",
                      		lv_expression_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePenalty"


    // $ANTLR start "entryRuleGoalSimple"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3496:1: entryRuleGoalSimple returns [EObject current=null] : iv_ruleGoalSimple= ruleGoalSimple EOF ;
    public final EObject entryRuleGoalSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoalSimple = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3497:2: (iv_ruleGoalSimple= ruleGoalSimple EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3498:2: iv_ruleGoalSimple= ruleGoalSimple EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGoalSimpleRule()); 
            }
            pushFollow(FOLLOW_ruleGoalSimple_in_entryRuleGoalSimple7596);
            iv_ruleGoalSimple=ruleGoalSimple();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGoalSimple; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoalSimple7606); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGoalSimple"


    // $ANTLR start "ruleGoalSimple"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3505:1: ruleGoalSimple returns [EObject current=null] : ( (lv_constraint_0_0= ruleConstraint ) ) ;
    public final EObject ruleGoalSimple() throws RecognitionException {
        EObject current = null;

        EObject lv_constraint_0_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3508:28: ( ( (lv_constraint_0_0= ruleConstraint ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3509:1: ( (lv_constraint_0_0= ruleConstraint ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3509:1: ( (lv_constraint_0_0= ruleConstraint ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3510:1: (lv_constraint_0_0= ruleConstraint )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3510:1: (lv_constraint_0_0= ruleConstraint )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3511:3: lv_constraint_0_0= ruleConstraint
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGoalSimpleAccess().getConstraintConstraintParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConstraint_in_ruleGoalSimple7651);
            lv_constraint_0_0=ruleConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getGoalSimpleRule());
              	        }
                     		set(
                     			current, 
                     			"constraint",
                      		lv_constraint_0_0, 
                      		"Constraint");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGoalSimple"


    // $ANTLR start "entryRuleConstraint"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3535:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3536:2: (iv_ruleConstraint= ruleConstraint EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3537:2: iv_ruleConstraint= ruleConstraint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstraintRule()); 
            }
            pushFollow(FOLLOW_ruleConstraint_in_entryRuleConstraint7685);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstraint; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraint7695); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3544:1: ruleConstraint returns [EObject current=null] : ( ( (lv_lhs_0_0= ruleExpression ) ) ( ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) ) ) ( (lv_rhs_2_0= ruleExpression ) ) ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        Token lv_operator_1_1=null;
        Token lv_operator_1_2=null;
        Token lv_operator_1_3=null;
        EObject lv_lhs_0_0 = null;

        EObject lv_rhs_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3547:28: ( ( ( (lv_lhs_0_0= ruleExpression ) ) ( ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) ) ) ( (lv_rhs_2_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3548:1: ( ( (lv_lhs_0_0= ruleExpression ) ) ( ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) ) ) ( (lv_rhs_2_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3548:1: ( ( (lv_lhs_0_0= ruleExpression ) ) ( ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) ) ) ( (lv_rhs_2_0= ruleExpression ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3548:2: ( (lv_lhs_0_0= ruleExpression ) ) ( ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) ) ) ( (lv_rhs_2_0= ruleExpression ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3548:2: ( (lv_lhs_0_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3549:1: (lv_lhs_0_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3549:1: (lv_lhs_0_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3550:3: lv_lhs_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstraintAccess().getLhsExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleConstraint7741);
            lv_lhs_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConstraintRule());
              	        }
                     		set(
                     			current, 
                     			"lhs",
                      		lv_lhs_0_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3566:2: ( ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3567:1: ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3567:1: ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3568:1: (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3568:1: (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 )
            int alt100=3;
            switch ( input.LA(1) ) {
            case KEYWORD_8:
                {
                alt100=1;
                }
                break;
            case KEYWORD_10:
                {
                alt100=2;
                }
                break;
            case KEYWORD_9:
                {
                alt100=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }

            switch (alt100) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3569:3: lv_operator_1_1= KEYWORD_8
                    {
                    lv_operator_1_1=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleConstraint7762); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_operator_1_1, grammarAccess.getConstraintAccess().getOperatorLessThanSignKeyword_1_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getConstraintRule());
                      	        }
                             		setWithLastConsumed(current, "operator", lv_operator_1_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3582:8: lv_operator_1_2= KEYWORD_10
                    {
                    lv_operator_1_2=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleConstraint7790); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_operator_1_2, grammarAccess.getConstraintAccess().getOperatorGreaterThanSignKeyword_1_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getConstraintRule());
                      	        }
                             		setWithLastConsumed(current, "operator", lv_operator_1_2, null);
                      	    
                    }

                    }
                    break;
                case 3 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3595:8: lv_operator_1_3= KEYWORD_9
                    {
                    lv_operator_1_3=(Token)match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_ruleConstraint7818); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_operator_1_3, grammarAccess.getConstraintAccess().getOperatorEqualsSignKeyword_1_0_2());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getConstraintRule());
                      	        }
                             		setWithLastConsumed(current, "operator", lv_operator_1_3, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3611:2: ( (lv_rhs_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3612:1: (lv_rhs_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3612:1: (lv_rhs_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3613:3: lv_rhs_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstraintAccess().getRhsExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleConstraint7853);
            lv_rhs_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getConstraintRule());
              	        }
                     		set(
                     			current, 
                     			"rhs",
                      		lv_rhs_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleModel"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3637:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3638:2: (iv_ruleModel= ruleModel EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3639:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel7888);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel7898); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3646:1: ruleModel returns [EObject current=null] : ( (otherlv_0= KEYWORD_35 | otherlv_1= KEYWORD_35 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( ( (lv_pattern_4_0= rulePattern ) ) | ( (lv_alias_5_0= ruleAlias ) ) )+ otherlv_6= KEYWORD_14 ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        EObject lv_pattern_4_0 = null;

        EObject lv_alias_5_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3649:28: ( ( (otherlv_0= KEYWORD_35 | otherlv_1= KEYWORD_35 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( ( (lv_pattern_4_0= rulePattern ) ) | ( (lv_alias_5_0= ruleAlias ) ) )+ otherlv_6= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3650:1: ( (otherlv_0= KEYWORD_35 | otherlv_1= KEYWORD_35 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( ( (lv_pattern_4_0= rulePattern ) ) | ( (lv_alias_5_0= ruleAlias ) ) )+ otherlv_6= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3650:1: ( (otherlv_0= KEYWORD_35 | otherlv_1= KEYWORD_35 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( ( (lv_pattern_4_0= rulePattern ) ) | ( (lv_alias_5_0= ruleAlias ) ) )+ otherlv_6= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3650:2: (otherlv_0= KEYWORD_35 | otherlv_1= KEYWORD_35 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( ( (lv_pattern_4_0= rulePattern ) ) | ( (lv_alias_5_0= ruleAlias ) ) )+ otherlv_6= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3650:2: (otherlv_0= KEYWORD_35 | otherlv_1= KEYWORD_35 )
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==KEYWORD_35) ) {
                int LA101_1 = input.LA(2);

                if ( (synpred112_InternalWreslEditorParser()) ) {
                    alt101=1;
                }
                else if ( (true) ) {
                    alt101=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 101, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }
            switch (alt101) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3651:2: otherlv_0= KEYWORD_35
                    {
                    otherlv_0=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_ruleModel7937); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getModelKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3657:2: otherlv_1= KEYWORD_35
                    {
                    otherlv_1=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_ruleModel7955); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getMODELKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3661:2: ( (lv_name_2_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3662:1: (lv_name_2_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3662:1: (lv_name_2_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3663:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel7972); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getModelRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleModel7990); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3684:1: ( ( (lv_pattern_4_0= rulePattern ) ) | ( (lv_alias_5_0= ruleAlias ) ) )+
            int cnt102=0;
            loop102:
            do {
                int alt102=3;
                alt102 = dfa102.predict(input);
                switch (alt102) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3684:2: ( (lv_pattern_4_0= rulePattern ) )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3684:2: ( (lv_pattern_4_0= rulePattern ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3685:1: (lv_pattern_4_0= rulePattern )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3685:1: (lv_pattern_4_0= rulePattern )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3686:3: lv_pattern_4_0= rulePattern
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getPatternPatternParserRuleCall_3_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePattern_in_ruleModel8011);
            	    lv_pattern_4_0=rulePattern();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"pattern",
            	              		lv_pattern_4_0, 
            	              		"Pattern");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3703:6: ( (lv_alias_5_0= ruleAlias ) )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3703:6: ( (lv_alias_5_0= ruleAlias ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3704:1: (lv_alias_5_0= ruleAlias )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3704:1: (lv_alias_5_0= ruleAlias )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3705:3: lv_alias_5_0= ruleAlias
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getAliasAliasParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAlias_in_ruleModel8038);
            	    lv_alias_5_0=ruleAlias();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"alias",
            	              		lv_alias_5_0, 
            	              		"Alias");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt102 >= 1 ) break loop102;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(102, input);
                        throw eee;
                }
                cnt102++;
            } while (true);

            otherlv_6=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleModel8053); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleInitial"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3734:1: entryRuleInitial returns [EObject current=null] : iv_ruleInitial= ruleInitial EOF ;
    public final EObject entryRuleInitial() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitial = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3735:2: (iv_ruleInitial= ruleInitial EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3736:2: iv_ruleInitial= ruleInitial EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInitialRule()); 
            }
            pushFollow(FOLLOW_ruleInitial_in_entryRuleInitial8087);
            iv_ruleInitial=ruleInitial();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInitial; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleInitial8097); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInitial"


    // $ANTLR start "ruleInitial"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3743:1: ruleInitial returns [EObject current=null] : ( (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 | otherlv_2= KEYWORD_44 ) otherlv_3= KEYWORD_13 ( (lv_pattern_4_0= rulePattern ) )+ otherlv_5= KEYWORD_14 ) ;
    public final EObject ruleInitial() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_pattern_4_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3746:28: ( ( (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 | otherlv_2= KEYWORD_44 ) otherlv_3= KEYWORD_13 ( (lv_pattern_4_0= rulePattern ) )+ otherlv_5= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3747:1: ( (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 | otherlv_2= KEYWORD_44 ) otherlv_3= KEYWORD_13 ( (lv_pattern_4_0= rulePattern ) )+ otherlv_5= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3747:1: ( (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 | otherlv_2= KEYWORD_44 ) otherlv_3= KEYWORD_13 ( (lv_pattern_4_0= rulePattern ) )+ otherlv_5= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3747:2: (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 | otherlv_2= KEYWORD_44 ) otherlv_3= KEYWORD_13 ( (lv_pattern_4_0= rulePattern ) )+ otherlv_5= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3747:2: (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 | otherlv_2= KEYWORD_44 )
            int alt103=3;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==KEYWORD_44) ) {
                int LA103_1 = input.LA(2);

                if ( (synpred115_InternalWreslEditorParser()) ) {
                    alt103=1;
                }
                else if ( (synpred116_InternalWreslEditorParser()) ) {
                    alt103=2;
                }
                else if ( (true) ) {
                    alt103=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 103, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }
            switch (alt103) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3748:2: otherlv_0= KEYWORD_44
                    {
                    otherlv_0=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_ruleInitial8136); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getInitialAccess().getInitialKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3754:2: otherlv_1= KEYWORD_44
                    {
                    otherlv_1=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_ruleInitial8154); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getInitialAccess().getInitialKeyword_0_1());
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3760:2: otherlv_2= KEYWORD_44
                    {
                    otherlv_2=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_ruleInitial8172); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getInitialAccess().getINITIALKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            otherlv_3=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleInitial8185); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getInitialAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3769:1: ( (lv_pattern_4_0= rulePattern ) )+
            int cnt104=0;
            loop104:
            do {
                int alt104=2;
                int LA104_0 = input.LA(1);

                if ( (LA104_0==KEYWORD_51||LA104_0==KEYWORD_43||LA104_0==KEYWORD_40||LA104_0==KEYWORD_29) ) {
                    alt104=1;
                }


                switch (alt104) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3770:1: (lv_pattern_4_0= rulePattern )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3770:1: (lv_pattern_4_0= rulePattern )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3771:3: lv_pattern_4_0= rulePattern
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getInitialAccess().getPatternPatternParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePattern_in_ruleInitial8205);
            	    lv_pattern_4_0=rulePattern();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getInitialRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"pattern",
            	              		lv_pattern_4_0, 
            	              		"Pattern");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt104 >= 1 ) break loop104;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(104, input);
                        throw eee;
                }
                cnt104++;
            } while (true);

            otherlv_5=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleInitial8219); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getInitialAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInitial"


    // $ANTLR start "entryRuleSequence"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3800:1: entryRuleSequence returns [EObject current=null] : iv_ruleSequence= ruleSequence EOF ;
    public final EObject entryRuleSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequence = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3801:2: (iv_ruleSequence= ruleSequence EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3802:2: iv_ruleSequence= ruleSequence EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSequenceRule()); 
            }
            pushFollow(FOLLOW_ruleSequence_in_entryRuleSequence8253);
            iv_ruleSequence=ruleSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSequence; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequence8263); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequence"


    // $ANTLR start "ruleSequence"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3809:1: ruleSequence returns [EObject current=null] : ( (otherlv_0= KEYWORD_48 | otherlv_1= KEYWORD_48 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 (otherlv_4= KEYWORD_35 | otherlv_5= KEYWORD_35 ) ( (otherlv_6= RULE_ID ) ) ( (lv_condition_7_0= ruleCondition ) )? (this_ORDER_8= RULE_ORDER ( (lv_order_9_0= RULE_INT ) ) )? otherlv_10= KEYWORD_14 ) ;
    public final EObject ruleSequence() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token this_ORDER_8=null;
        Token lv_order_9_0=null;
        Token otherlv_10=null;
        EObject lv_condition_7_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3812:28: ( ( (otherlv_0= KEYWORD_48 | otherlv_1= KEYWORD_48 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 (otherlv_4= KEYWORD_35 | otherlv_5= KEYWORD_35 ) ( (otherlv_6= RULE_ID ) ) ( (lv_condition_7_0= ruleCondition ) )? (this_ORDER_8= RULE_ORDER ( (lv_order_9_0= RULE_INT ) ) )? otherlv_10= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3813:1: ( (otherlv_0= KEYWORD_48 | otherlv_1= KEYWORD_48 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 (otherlv_4= KEYWORD_35 | otherlv_5= KEYWORD_35 ) ( (otherlv_6= RULE_ID ) ) ( (lv_condition_7_0= ruleCondition ) )? (this_ORDER_8= RULE_ORDER ( (lv_order_9_0= RULE_INT ) ) )? otherlv_10= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3813:1: ( (otherlv_0= KEYWORD_48 | otherlv_1= KEYWORD_48 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 (otherlv_4= KEYWORD_35 | otherlv_5= KEYWORD_35 ) ( (otherlv_6= RULE_ID ) ) ( (lv_condition_7_0= ruleCondition ) )? (this_ORDER_8= RULE_ORDER ( (lv_order_9_0= RULE_INT ) ) )? otherlv_10= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3813:2: (otherlv_0= KEYWORD_48 | otherlv_1= KEYWORD_48 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 (otherlv_4= KEYWORD_35 | otherlv_5= KEYWORD_35 ) ( (otherlv_6= RULE_ID ) ) ( (lv_condition_7_0= ruleCondition ) )? (this_ORDER_8= RULE_ORDER ( (lv_order_9_0= RULE_INT ) ) )? otherlv_10= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3813:2: (otherlv_0= KEYWORD_48 | otherlv_1= KEYWORD_48 )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==KEYWORD_48) ) {
                int LA105_1 = input.LA(2);

                if ( (synpred118_InternalWreslEditorParser()) ) {
                    alt105=1;
                }
                else if ( (true) ) {
                    alt105=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 105, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3814:2: otherlv_0= KEYWORD_48
                    {
                    otherlv_0=(Token)match(input,KEYWORD_48,FOLLOW_KEYWORD_48_in_ruleSequence8302); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getSequenceAccess().getSequenceKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3820:2: otherlv_1= KEYWORD_48
                    {
                    otherlv_1=(Token)match(input,KEYWORD_48,FOLLOW_KEYWORD_48_in_ruleSequence8320); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getSequenceAccess().getSEQUENCEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3824:2: ( (lv_name_2_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3825:1: (lv_name_2_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3825:1: (lv_name_2_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3826:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSequence8337); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getSequenceAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getSequenceRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleSequence8355); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSequenceAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3847:1: (otherlv_4= KEYWORD_35 | otherlv_5= KEYWORD_35 )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==KEYWORD_35) ) {
                int LA106_1 = input.LA(2);

                if ( (synpred119_InternalWreslEditorParser()) ) {
                    alt106=1;
                }
                else if ( (true) ) {
                    alt106=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 106, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3848:2: otherlv_4= KEYWORD_35
                    {
                    otherlv_4=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_ruleSequence8368); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getSequenceAccess().getModelKeyword_3_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3854:2: otherlv_5= KEYWORD_35
                    {
                    otherlv_5=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_ruleSequence8386); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSequenceAccess().getMODELKeyword_3_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3858:2: ( (otherlv_6= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3859:1: (otherlv_6= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3859:1: (otherlv_6= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3860:3: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getSequenceRule());
              	        }
                      
            }
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSequence8410); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_6, grammarAccess.getSequenceAccess().getModelModelCrossReference_4_0()); 
              	
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3874:2: ( (lv_condition_7_0= ruleCondition ) )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==KEYWORD_49) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3875:1: (lv_condition_7_0= ruleCondition )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3875:1: (lv_condition_7_0= ruleCondition )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3876:3: lv_condition_7_0= ruleCondition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSequenceAccess().getConditionConditionParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCondition_in_ruleSequence8431);
                    lv_condition_7_0=ruleCondition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSequenceRule());
                      	        }
                             		set(
                             			current, 
                             			"condition",
                              		lv_condition_7_0, 
                              		"Condition");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3892:3: (this_ORDER_8= RULE_ORDER ( (lv_order_9_0= RULE_INT ) ) )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==RULE_ORDER) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3892:4: this_ORDER_8= RULE_ORDER ( (lv_order_9_0= RULE_INT ) )
                    {
                    this_ORDER_8=(Token)match(input,RULE_ORDER,FOLLOW_RULE_ORDER_in_ruleSequence8444); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ORDER_8, grammarAccess.getSequenceAccess().getORDERTerminalRuleCall_6_0()); 
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3896:1: ( (lv_order_9_0= RULE_INT ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3897:1: (lv_order_9_0= RULE_INT )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3897:1: (lv_order_9_0= RULE_INT )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3898:3: lv_order_9_0= RULE_INT
                    {
                    lv_order_9_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSequence8460); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_order_9_0, grammarAccess.getSequenceAccess().getOrderINTTerminalRuleCall_6_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getSequenceRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"order",
                              		lv_order_9_0, 
                              		"INT");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_10=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleSequence8480); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getSequenceAccess().getRightCurlyBracketKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequence"


    // $ANTLR start "entryRuleCondition"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3927:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3928:2: (iv_ruleCondition= ruleCondition EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3929:2: iv_ruleCondition= ruleCondition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionRule()); 
            }
            pushFollow(FOLLOW_ruleCondition_in_entryRuleCondition8514);
            iv_ruleCondition=ruleCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCondition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCondition8524); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3936:1: ruleCondition returns [EObject current=null] : ( (otherlv_0= KEYWORD_49 | otherlv_1= KEYWORD_49 ) ( ( (lv_logical_2_0= ruleLogicalExpression ) ) | ( () this_ALWAYS_4= RULE_ALWAYS ) ) ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_ALWAYS_4=null;
        EObject lv_logical_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3939:28: ( ( (otherlv_0= KEYWORD_49 | otherlv_1= KEYWORD_49 ) ( ( (lv_logical_2_0= ruleLogicalExpression ) ) | ( () this_ALWAYS_4= RULE_ALWAYS ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3940:1: ( (otherlv_0= KEYWORD_49 | otherlv_1= KEYWORD_49 ) ( ( (lv_logical_2_0= ruleLogicalExpression ) ) | ( () this_ALWAYS_4= RULE_ALWAYS ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3940:1: ( (otherlv_0= KEYWORD_49 | otherlv_1= KEYWORD_49 ) ( ( (lv_logical_2_0= ruleLogicalExpression ) ) | ( () this_ALWAYS_4= RULE_ALWAYS ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3940:2: (otherlv_0= KEYWORD_49 | otherlv_1= KEYWORD_49 ) ( ( (lv_logical_2_0= ruleLogicalExpression ) ) | ( () this_ALWAYS_4= RULE_ALWAYS ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3940:2: (otherlv_0= KEYWORD_49 | otherlv_1= KEYWORD_49 )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==KEYWORD_49) ) {
                int LA109_1 = input.LA(2);

                if ( (synpred122_InternalWreslEditorParser()) ) {
                    alt109=1;
                }
                else if ( (true) ) {
                    alt109=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 109, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }
            switch (alt109) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3941:2: otherlv_0= KEYWORD_49
                    {
                    otherlv_0=(Token)match(input,KEYWORD_49,FOLLOW_KEYWORD_49_in_ruleCondition8563); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getConditionKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3947:2: otherlv_1= KEYWORD_49
                    {
                    otherlv_1=(Token)match(input,KEYWORD_49,FOLLOW_KEYWORD_49_in_ruleCondition8581); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getConditionAccess().getCONDITIONKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3951:2: ( ( (lv_logical_2_0= ruleLogicalExpression ) ) | ( () this_ALWAYS_4= RULE_ALWAYS ) )
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==KEYWORD_1||LA110_0==KEYWORD_4||LA110_0==KEYWORD_6||(LA110_0>=RULE_RANGE && LA110_0<=RULE_FLOAT)||LA110_0==RULE_NOT||LA110_0==RULE_ID) ) {
                alt110=1;
            }
            else if ( (LA110_0==RULE_ALWAYS) ) {
                alt110=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 110, 0, input);

                throw nvae;
            }
            switch (alt110) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3951:3: ( (lv_logical_2_0= ruleLogicalExpression ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3951:3: ( (lv_logical_2_0= ruleLogicalExpression ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3952:1: (lv_logical_2_0= ruleLogicalExpression )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3952:1: (lv_logical_2_0= ruleLogicalExpression )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3953:3: lv_logical_2_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionAccess().getLogicalLogicalExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleCondition8603);
                    lv_logical_2_0=ruleLogicalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConditionRule());
                      	        }
                             		set(
                             			current, 
                             			"logical",
                              		lv_logical_2_0, 
                              		"LogicalExpression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3970:6: ( () this_ALWAYS_4= RULE_ALWAYS )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3970:6: ( () this_ALWAYS_4= RULE_ALWAYS )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3970:7: () this_ALWAYS_4= RULE_ALWAYS
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3970:7: ()
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3971:2: 
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {

                              current = forceCreateModelElement(
                                  grammarAccess.getConditionAccess().getConditionAction_1_1_0(),
                                  current);
                          
                    }

                    }

                    this_ALWAYS_4=(Token)match(input,RULE_ALWAYS,FOLLOW_RULE_ALWAYS_in_ruleCondition8633); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ALWAYS_4, grammarAccess.getConditionAccess().getALWAYSTerminalRuleCall_1_1_1()); 
                          
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleLogicalExpression"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3991:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3992:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3993:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression8669);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression8679); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalExpression"


    // $ANTLR start "ruleLogicalExpression"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4000:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_c1_0_0= ruleConditionalUnary ) ) ( ruleBinaryOp ( (lv_c2_2_0= ruleConditionalUnary ) ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_c1_0_0 = null;

        EObject lv_c2_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4003:28: ( ( ( (lv_c1_0_0= ruleConditionalUnary ) ) ( ruleBinaryOp ( (lv_c2_2_0= ruleConditionalUnary ) ) )* ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4004:1: ( ( (lv_c1_0_0= ruleConditionalUnary ) ) ( ruleBinaryOp ( (lv_c2_2_0= ruleConditionalUnary ) ) )* )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4004:1: ( ( (lv_c1_0_0= ruleConditionalUnary ) ) ( ruleBinaryOp ( (lv_c2_2_0= ruleConditionalUnary ) ) )* )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4004:2: ( (lv_c1_0_0= ruleConditionalUnary ) ) ( ruleBinaryOp ( (lv_c2_2_0= ruleConditionalUnary ) ) )*
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4004:2: ( (lv_c1_0_0= ruleConditionalUnary ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4005:1: (lv_c1_0_0= ruleConditionalUnary )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4005:1: (lv_c1_0_0= ruleConditionalUnary )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4006:3: lv_c1_0_0= ruleConditionalUnary
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getC1ConditionalUnaryParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConditionalUnary_in_ruleLogicalExpression8725);
            lv_c1_0_0=ruleConditionalUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLogicalExpressionRule());
              	        }
                     		set(
                     			current, 
                     			"c1",
                      		lv_c1_0_0, 
                      		"ConditionalUnary");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4022:2: ( ruleBinaryOp ( (lv_c2_2_0= ruleConditionalUnary ) ) )*
            loop111:
            do {
                int alt111=2;
                int LA111_0 = input.LA(1);

                if ( ((LA111_0>=RULE_AND && LA111_0<=RULE_OR)) ) {
                    alt111=1;
                }


                switch (alt111) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4023:2: ruleBinaryOp ( (lv_c2_2_0= ruleConditionalUnary ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getLogicalExpressionAccess().getBinaryOpParserRuleCall_1_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleBinaryOp_in_ruleLogicalExpression8745);
            	    ruleBinaryOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4033:1: ( (lv_c2_2_0= ruleConditionalUnary ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4034:1: (lv_c2_2_0= ruleConditionalUnary )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4034:1: (lv_c2_2_0= ruleConditionalUnary )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4035:3: lv_c2_2_0= ruleConditionalUnary
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getC2ConditionalUnaryParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleConditionalUnary_in_ruleLogicalExpression8765);
            	    lv_c2_2_0=ruleConditionalUnary();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getLogicalExpressionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"c2",
            	              		lv_c2_2_0, 
            	              		"ConditionalUnary");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop111;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalExpression"


    // $ANTLR start "entryRuleBinaryOp"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4059:1: entryRuleBinaryOp returns [String current=null] : iv_ruleBinaryOp= ruleBinaryOp EOF ;
    public final String entryRuleBinaryOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBinaryOp = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4060:1: (iv_ruleBinaryOp= ruleBinaryOp EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4061:2: iv_ruleBinaryOp= ruleBinaryOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryOpRule()); 
            }
            pushFollow(FOLLOW_ruleBinaryOp_in_entryRuleBinaryOp8803);
            iv_ruleBinaryOp=ruleBinaryOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryOp.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBinaryOp8814); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryOp"


    // $ANTLR start "ruleBinaryOp"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4068:1: ruleBinaryOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_OR_0= RULE_OR | this_AND_1= RULE_AND ) ;
    public final AntlrDatatypeRuleToken ruleBinaryOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_OR_0=null;
        Token this_AND_1=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4072:6: ( (this_OR_0= RULE_OR | this_AND_1= RULE_AND ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4073:1: (this_OR_0= RULE_OR | this_AND_1= RULE_AND )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4073:1: (this_OR_0= RULE_OR | this_AND_1= RULE_AND )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==RULE_OR) ) {
                alt112=1;
            }
            else if ( (LA112_0==RULE_AND) ) {
                alt112=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }
            switch (alt112) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4073:6: this_OR_0= RULE_OR
                    {
                    this_OR_0=(Token)match(input,RULE_OR,FOLLOW_RULE_OR_in_ruleBinaryOp8854); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_OR_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_OR_0, grammarAccess.getBinaryOpAccess().getORTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4081:10: this_AND_1= RULE_AND
                    {
                    this_AND_1=(Token)match(input,RULE_AND,FOLLOW_RULE_AND_in_ruleBinaryOp8880); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_AND_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_AND_1, grammarAccess.getBinaryOpAccess().getANDTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryOp"


    // $ANTLR start "entryRuleConditionalUnary"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4096:1: entryRuleConditionalUnary returns [EObject current=null] : iv_ruleConditionalUnary= ruleConditionalUnary EOF ;
    public final EObject entryRuleConditionalUnary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalUnary = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4097:2: (iv_ruleConditionalUnary= ruleConditionalUnary EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4098:2: iv_ruleConditionalUnary= ruleConditionalUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleConditionalUnary_in_entryRuleConditionalUnary8924);
            iv_ruleConditionalUnary=ruleConditionalUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalUnary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalUnary8934); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalUnary"


    // $ANTLR start "ruleConditionalUnary"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4105:1: ruleConditionalUnary returns [EObject current=null] : ( ( ruleConditionalNegation )? this_ConditionalTerm_1= ruleConditionalTerm ) ;
    public final EObject ruleConditionalUnary() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalTerm_1 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4108:28: ( ( ( ruleConditionalNegation )? this_ConditionalTerm_1= ruleConditionalTerm ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4109:1: ( ( ruleConditionalNegation )? this_ConditionalTerm_1= ruleConditionalTerm )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4109:1: ( ( ruleConditionalNegation )? this_ConditionalTerm_1= ruleConditionalTerm )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4109:2: ( ruleConditionalNegation )? this_ConditionalTerm_1= ruleConditionalTerm
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4109:2: ( ruleConditionalNegation )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==RULE_NOT) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4110:2: ruleConditionalNegation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConditionalUnaryAccess().getConditionalNegationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleConditionalNegation_in_ruleConditionalUnary8979);
                    ruleConditionalNegation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getConditionalUnaryAccess().getConditionalTermParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleConditionalTerm_in_ruleConditionalUnary9005);
            this_ConditionalTerm_1=ruleConditionalTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_ConditionalTerm_1;
                      afterParserOrEnumRuleCall();
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalUnary"


    // $ANTLR start "entryRuleConditionalNegation"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4140:1: entryRuleConditionalNegation returns [String current=null] : iv_ruleConditionalNegation= ruleConditionalNegation EOF ;
    public final String entryRuleConditionalNegation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConditionalNegation = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4141:1: (iv_ruleConditionalNegation= ruleConditionalNegation EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4142:2: iv_ruleConditionalNegation= ruleConditionalNegation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalNegationRule()); 
            }
            pushFollow(FOLLOW_ruleConditionalNegation_in_entryRuleConditionalNegation9040);
            iv_ruleConditionalNegation=ruleConditionalNegation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalNegation.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalNegation9051); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalNegation"


    // $ANTLR start "ruleConditionalNegation"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4149:1: ruleConditionalNegation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_NOT_0= RULE_NOT ;
    public final AntlrDatatypeRuleToken ruleConditionalNegation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NOT_0=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4153:6: (this_NOT_0= RULE_NOT )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4154:5: this_NOT_0= RULE_NOT
            {
            this_NOT_0=(Token)match(input,RULE_NOT,FOLLOW_RULE_NOT_in_ruleConditionalNegation9090); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_NOT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_NOT_0, grammarAccess.getConditionalNegationAccess().getNOTTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalNegation"


    // $ANTLR start "entryRuleConditionalTerm"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4169:1: entryRuleConditionalTerm returns [EObject current=null] : iv_ruleConditionalTerm= ruleConditionalTerm EOF ;
    public final EObject entryRuleConditionalTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalTerm = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4170:2: (iv_ruleConditionalTerm= ruleConditionalTerm EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4171:2: iv_ruleConditionalTerm= ruleConditionalTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalTermRule()); 
            }
            pushFollow(FOLLOW_ruleConditionalTerm_in_entryRuleConditionalTerm9133);
            iv_ruleConditionalTerm=ruleConditionalTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalTerm9143); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionalTerm"


    // $ANTLR start "ruleConditionalTerm"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4178:1: ruleConditionalTerm returns [EObject current=null] : ( ( ( (lv_e1_0_0= ruleExpression ) ) ruleRelation ( (lv_e2_2_0= ruleExpression ) ) ) | ruleLogicalFunction ) ;
    public final EObject ruleConditionalTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_e1_0_0 = null;

        EObject lv_e2_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4181:28: ( ( ( ( (lv_e1_0_0= ruleExpression ) ) ruleRelation ( (lv_e2_2_0= ruleExpression ) ) ) | ruleLogicalFunction ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4182:1: ( ( ( (lv_e1_0_0= ruleExpression ) ) ruleRelation ( (lv_e2_2_0= ruleExpression ) ) ) | ruleLogicalFunction )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4182:1: ( ( ( (lv_e1_0_0= ruleExpression ) ) ruleRelation ( (lv_e2_2_0= ruleExpression ) ) ) | ruleLogicalFunction )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==KEYWORD_1||LA114_0==KEYWORD_4||LA114_0==KEYWORD_6||(LA114_0>=RULE_MIN && LA114_0<=RULE_FLOAT)||LA114_0==RULE_ID) ) {
                alt114=1;
            }
            else if ( (LA114_0==RULE_RANGE) ) {
                alt114=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }
            switch (alt114) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4182:2: ( ( (lv_e1_0_0= ruleExpression ) ) ruleRelation ( (lv_e2_2_0= ruleExpression ) ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4182:2: ( ( (lv_e1_0_0= ruleExpression ) ) ruleRelation ( (lv_e2_2_0= ruleExpression ) ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4182:3: ( (lv_e1_0_0= ruleExpression ) ) ruleRelation ( (lv_e2_2_0= ruleExpression ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4182:3: ( (lv_e1_0_0= ruleExpression ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4183:1: (lv_e1_0_0= ruleExpression )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4183:1: (lv_e1_0_0= ruleExpression )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4184:3: lv_e1_0_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalTermAccess().getE1ExpressionParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleConditionalTerm9190);
                    lv_e1_0_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConditionalTermRule());
                      	        }
                             		set(
                             			current, 
                             			"e1",
                              		lv_e1_0_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConditionalTermAccess().getRelationParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRelation_in_ruleConditionalTerm9209);
                    ruleRelation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4211:1: ( (lv_e2_2_0= ruleExpression ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4212:1: (lv_e2_2_0= ruleExpression )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4212:1: (lv_e2_2_0= ruleExpression )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4213:3: lv_e2_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalTermAccess().getE2ExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleConditionalTerm9229);
                    lv_e2_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getConditionalTermRule());
                      	        }
                             		set(
                             			current, 
                             			"e2",
                              		lv_e2_2_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4231:2: ruleLogicalFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConditionalTermAccess().getLogicalFunctionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLogicalFunction_in_ruleConditionalTerm9255);
                    ruleLogicalFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionalTerm"


    // $ANTLR start "entryRuleRelation"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4249:1: entryRuleRelation returns [String current=null] : iv_ruleRelation= ruleRelation EOF ;
    public final String entryRuleRelation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelation = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4250:1: (iv_ruleRelation= ruleRelation EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4251:2: iv_ruleRelation= ruleRelation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationRule()); 
            }
            pushFollow(FOLLOW_ruleRelation_in_entryRuleRelation9290);
            iv_ruleRelation=ruleRelation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelation.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelation9301); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelation"


    // $ANTLR start "ruleRelation"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4258:1: ruleRelation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= KEYWORD_10 | kw= KEYWORD_8 | kw= KEYWORD_18 | kw= KEYWORD_16 | kw= KEYWORD_17 | kw= KEYWORD_15 ) ;
    public final AntlrDatatypeRuleToken ruleRelation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4262:6: ( (kw= KEYWORD_10 | kw= KEYWORD_8 | kw= KEYWORD_18 | kw= KEYWORD_16 | kw= KEYWORD_17 | kw= KEYWORD_15 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4263:1: (kw= KEYWORD_10 | kw= KEYWORD_8 | kw= KEYWORD_18 | kw= KEYWORD_16 | kw= KEYWORD_17 | kw= KEYWORD_15 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4263:1: (kw= KEYWORD_10 | kw= KEYWORD_8 | kw= KEYWORD_18 | kw= KEYWORD_16 | kw= KEYWORD_17 | kw= KEYWORD_15 )
            int alt115=6;
            switch ( input.LA(1) ) {
            case KEYWORD_10:
                {
                alt115=1;
                }
                break;
            case KEYWORD_8:
                {
                alt115=2;
                }
                break;
            case KEYWORD_18:
                {
                alt115=3;
                }
                break;
            case KEYWORD_16:
                {
                alt115=4;
                }
                break;
            case KEYWORD_17:
                {
                alt115=5;
                }
                break;
            case KEYWORD_15:
                {
                alt115=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;
            }

            switch (alt115) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4264:2: kw= KEYWORD_10
                    {
                    kw=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleRelation9339); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4271:2: kw= KEYWORD_8
                    {
                    kw=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleRelation9358); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4278:2: kw= KEYWORD_18
                    {
                    kw=(Token)match(input,KEYWORD_18,FOLLOW_KEYWORD_18_in_ruleRelation9377); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4285:2: kw= KEYWORD_16
                    {
                    kw=(Token)match(input,KEYWORD_16,FOLLOW_KEYWORD_16_in_ruleRelation9396); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationAccess().getLessThanSignEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4292:2: kw= KEYWORD_17
                    {
                    kw=(Token)match(input,KEYWORD_17,FOLLOW_KEYWORD_17_in_ruleRelation9415); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationAccess().getEqualsSignEqualsSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4299:2: kw= KEYWORD_15
                    {
                    kw=(Token)match(input,KEYWORD_15,FOLLOW_KEYWORD_15_in_ruleRelation9434); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationAccess().getSolidusEqualsSignKeyword_5()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelation"


    // $ANTLR start "entryRuleExpression"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4312:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4313:2: (iv_ruleExpression= ruleExpression EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4314:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression9473);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression9483); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4321:1: ruleExpression returns [EObject current=null] : this_Add_0= ruleAdd ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Add_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4324:28: (this_Add_0= ruleAdd )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4326:2: this_Add_0= ruleAdd
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpressionAccess().getAddParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleAdd_in_ruleExpression9532);
            this_Add_0=ruleAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_Add_0;
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleAdd"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4345:1: entryRuleAdd returns [EObject current=null] : iv_ruleAdd= ruleAdd EOF ;
    public final EObject entryRuleAdd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdd = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4346:2: (iv_ruleAdd= ruleAdd EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4347:2: iv_ruleAdd= ruleAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAddRule()); 
            }
            pushFollow(FOLLOW_ruleAdd_in_entryRuleAdd9565);
            iv_ruleAdd=ruleAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdd; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdd9575); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdd"


    // $ANTLR start "ruleAdd"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4354:1: ruleAdd returns [EObject current=null] : ( ( (lv_m1_0_0= ruleMultiply ) ) ( (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 ) ( (lv_m2_3_0= ruleMultiply ) ) )* ) ;
    public final EObject ruleAdd() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_m1_0_0 = null;

        EObject lv_m2_3_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4357:28: ( ( ( (lv_m1_0_0= ruleMultiply ) ) ( (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 ) ( (lv_m2_3_0= ruleMultiply ) ) )* ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4358:1: ( ( (lv_m1_0_0= ruleMultiply ) ) ( (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 ) ( (lv_m2_3_0= ruleMultiply ) ) )* )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4358:1: ( ( (lv_m1_0_0= ruleMultiply ) ) ( (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 ) ( (lv_m2_3_0= ruleMultiply ) ) )* )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4358:2: ( (lv_m1_0_0= ruleMultiply ) ) ( (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 ) ( (lv_m2_3_0= ruleMultiply ) ) )*
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4358:2: ( (lv_m1_0_0= ruleMultiply ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4359:1: (lv_m1_0_0= ruleMultiply )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4359:1: (lv_m1_0_0= ruleMultiply )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4360:3: lv_m1_0_0= ruleMultiply
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAddAccess().getM1MultiplyParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiply_in_ruleAdd9621);
            lv_m1_0_0=ruleMultiply();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getAddRule());
              	        }
                     		set(
                     			current, 
                     			"m1",
                      		lv_m1_0_0, 
                      		"Multiply");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4376:2: ( (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 ) ( (lv_m2_3_0= ruleMultiply ) ) )*
            loop117:
            do {
                int alt117=2;
                int LA117_0 = input.LA(1);

                if ( (LA117_0==KEYWORD_4||LA117_0==KEYWORD_6) ) {
                    alt117=1;
                }


                switch (alt117) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4376:3: (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 ) ( (lv_m2_3_0= ruleMultiply ) )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4376:3: (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 )
            	    int alt116=2;
            	    int LA116_0 = input.LA(1);

            	    if ( (LA116_0==KEYWORD_4) ) {
            	        alt116=1;
            	    }
            	    else if ( (LA116_0==KEYWORD_6) ) {
            	        alt116=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 116, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt116) {
            	        case 1 :
            	            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4377:2: otherlv_1= KEYWORD_4
            	            {
            	            otherlv_1=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleAdd9636); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_1, grammarAccess.getAddAccess().getPlusSignKeyword_1_0_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4383:2: otherlv_2= KEYWORD_6
            	            {
            	            otherlv_2=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleAdd9654); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getAddAccess().getHyphenMinusKeyword_1_0_1());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4387:2: ( (lv_m2_3_0= ruleMultiply ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4388:1: (lv_m2_3_0= ruleMultiply )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4388:1: (lv_m2_3_0= ruleMultiply )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4389:3: lv_m2_3_0= ruleMultiply
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAddAccess().getM2MultiplyParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiply_in_ruleAdd9675);
            	    lv_m2_3_0=ruleMultiply();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAddRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"m2",
            	              		lv_m2_3_0, 
            	              		"Multiply");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop117;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdd"


    // $ANTLR start "entryRuleMultiply"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4413:1: entryRuleMultiply returns [EObject current=null] : iv_ruleMultiply= ruleMultiply EOF ;
    public final EObject entryRuleMultiply() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiply = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4414:2: (iv_ruleMultiply= ruleMultiply EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4415:2: iv_ruleMultiply= ruleMultiply EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplyRule()); 
            }
            pushFollow(FOLLOW_ruleMultiply_in_entryRuleMultiply9712);
            iv_ruleMultiply=ruleMultiply();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiply; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiply9722); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiply"


    // $ANTLR start "ruleMultiply"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4422:1: ruleMultiply returns [EObject current=null] : ( ( (lv_u1_0_0= ruleUnary ) ) ( (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 ) ( (lv_u2_3_0= ruleUnary ) ) )* ) ;
    public final EObject ruleMultiply() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_u1_0_0 = null;

        EObject lv_u2_3_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4425:28: ( ( ( (lv_u1_0_0= ruleUnary ) ) ( (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 ) ( (lv_u2_3_0= ruleUnary ) ) )* ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4426:1: ( ( (lv_u1_0_0= ruleUnary ) ) ( (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 ) ( (lv_u2_3_0= ruleUnary ) ) )* )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4426:1: ( ( (lv_u1_0_0= ruleUnary ) ) ( (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 ) ( (lv_u2_3_0= ruleUnary ) ) )* )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4426:2: ( (lv_u1_0_0= ruleUnary ) ) ( (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 ) ( (lv_u2_3_0= ruleUnary ) ) )*
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4426:2: ( (lv_u1_0_0= ruleUnary ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4427:1: (lv_u1_0_0= ruleUnary )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4427:1: (lv_u1_0_0= ruleUnary )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4428:3: lv_u1_0_0= ruleUnary
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplyAccess().getU1UnaryParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnary_in_ruleMultiply9768);
            lv_u1_0_0=ruleUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMultiplyRule());
              	        }
                     		set(
                     			current, 
                     			"u1",
                      		lv_u1_0_0, 
                      		"Unary");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4444:2: ( (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 ) ( (lv_u2_3_0= ruleUnary ) ) )*
            loop119:
            do {
                int alt119=2;
                int LA119_0 = input.LA(1);

                if ( (LA119_0==KEYWORD_3||LA119_0==KEYWORD_7) ) {
                    alt119=1;
                }


                switch (alt119) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4444:3: (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 ) ( (lv_u2_3_0= ruleUnary ) )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4444:3: (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 )
            	    int alt118=2;
            	    int LA118_0 = input.LA(1);

            	    if ( (LA118_0==KEYWORD_3) ) {
            	        alt118=1;
            	    }
            	    else if ( (LA118_0==KEYWORD_7) ) {
            	        alt118=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 118, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt118) {
            	        case 1 :
            	            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4445:2: otherlv_1= KEYWORD_3
            	            {
            	            otherlv_1=(Token)match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_ruleMultiply9783); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_1, grammarAccess.getMultiplyAccess().getAsteriskKeyword_1_0_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4451:2: otherlv_2= KEYWORD_7
            	            {
            	            otherlv_2=(Token)match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_ruleMultiply9801); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getMultiplyAccess().getSolidusKeyword_1_0_1());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4455:2: ( (lv_u2_3_0= ruleUnary ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4456:1: (lv_u2_3_0= ruleUnary )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4456:1: (lv_u2_3_0= ruleUnary )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4457:3: lv_u2_3_0= ruleUnary
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplyAccess().getU2UnaryParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnary_in_ruleMultiply9822);
            	    lv_u2_3_0=ruleUnary();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMultiplyRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"u2",
            	              		lv_u2_3_0, 
            	              		"Unary");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop119;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiply"


    // $ANTLR start "entryRuleUnary"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4481:1: entryRuleUnary returns [EObject current=null] : iv_ruleUnary= ruleUnary EOF ;
    public final EObject entryRuleUnary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnary = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4482:2: (iv_ruleUnary= ruleUnary EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4483:2: iv_ruleUnary= ruleUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleUnary_in_entryRuleUnary9859);
            iv_ruleUnary=ruleUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnary9869); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnary"


    // $ANTLR start "ruleUnary"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4490:1: ruleUnary returns [EObject current=null] : ( (otherlv_0= KEYWORD_4 | ruleNegation )? this_Term_2= ruleTerm ) ;
    public final EObject ruleUnary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Term_2 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4493:28: ( ( (otherlv_0= KEYWORD_4 | ruleNegation )? this_Term_2= ruleTerm ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4494:1: ( (otherlv_0= KEYWORD_4 | ruleNegation )? this_Term_2= ruleTerm )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4494:1: ( (otherlv_0= KEYWORD_4 | ruleNegation )? this_Term_2= ruleTerm )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4494:2: (otherlv_0= KEYWORD_4 | ruleNegation )? this_Term_2= ruleTerm
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4494:2: (otherlv_0= KEYWORD_4 | ruleNegation )?
            int alt120=3;
            int LA120_0 = input.LA(1);

            if ( (LA120_0==KEYWORD_4) ) {
                alt120=1;
            }
            else if ( (LA120_0==KEYWORD_6) ) {
                alt120=2;
            }
            switch (alt120) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4495:2: otherlv_0= KEYWORD_4
                    {
                    otherlv_0=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleUnary9908); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getUnaryAccess().getPlusSignKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4501:2: ruleNegation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryAccess().getNegationParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNegation_in_ruleUnary9932);
                    ruleNegation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnaryAccess().getTermParserRuleCall_1()); 
                  
            }
            pushFollow(FOLLOW_ruleTerm_in_ruleUnary9958);
            this_Term_2=ruleTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_Term_2;
                      afterParserOrEnumRuleCall();
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnary"


    // $ANTLR start "entryRuleNegation"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4531:1: entryRuleNegation returns [String current=null] : iv_ruleNegation= ruleNegation EOF ;
    public final String entryRuleNegation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNegation = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4532:1: (iv_ruleNegation= ruleNegation EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4533:2: iv_ruleNegation= ruleNegation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNegationRule()); 
            }
            pushFollow(FOLLOW_ruleNegation_in_entryRuleNegation9993);
            iv_ruleNegation=ruleNegation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNegation.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegation10004); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNegation"


    // $ANTLR start "ruleNegation"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4540:1: ruleNegation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= KEYWORD_6 ;
    public final AntlrDatatypeRuleToken ruleNegation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4544:6: (kw= KEYWORD_6 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4546:2: kw= KEYWORD_6
            {
            kw=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleNegation10041); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getNegationAccess().getHyphenMinusKeyword()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNegation"


    // $ANTLR start "entryRuleTerm"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4559:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4560:2: (iv_ruleTerm= ruleTerm EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4561:2: iv_ruleTerm= ruleTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTermRule()); 
            }
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm10079);
            iv_ruleTerm=ruleTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm10089); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTerm"


    // $ANTLR start "ruleTerm"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4568:1: ruleTerm returns [EObject current=null] : ( ( (lv_i_0_0= ruleIdent ) ) | ( (lv_n_1_0= ruleNumber ) ) | ( (lv_f_2_0= ruleFunction ) ) | (otherlv_3= KEYWORD_1 ( (lv_e2_4_0= ruleExpression ) ) otherlv_5= KEYWORD_2 ) ) ;
    public final EObject ruleTerm() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_i_0_0 = null;

        AntlrDatatypeRuleToken lv_n_1_0 = null;

        EObject lv_f_2_0 = null;

        EObject lv_e2_4_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4571:28: ( ( ( (lv_i_0_0= ruleIdent ) ) | ( (lv_n_1_0= ruleNumber ) ) | ( (lv_f_2_0= ruleFunction ) ) | (otherlv_3= KEYWORD_1 ( (lv_e2_4_0= ruleExpression ) ) otherlv_5= KEYWORD_2 ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4572:1: ( ( (lv_i_0_0= ruleIdent ) ) | ( (lv_n_1_0= ruleNumber ) ) | ( (lv_f_2_0= ruleFunction ) ) | (otherlv_3= KEYWORD_1 ( (lv_e2_4_0= ruleExpression ) ) otherlv_5= KEYWORD_2 ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4572:1: ( ( (lv_i_0_0= ruleIdent ) ) | ( (lv_n_1_0= ruleNumber ) ) | ( (lv_f_2_0= ruleFunction ) ) | (otherlv_3= KEYWORD_1 ( (lv_e2_4_0= ruleExpression ) ) otherlv_5= KEYWORD_2 ) )
            int alt121=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA121_1 = input.LA(2);

                if ( (LA121_1==KEYWORD_1||LA121_1==KEYWORD_11) ) {
                    alt121=3;
                }
                else if ( (LA121_1==EOF||LA121_1==KEYWORD_41||LA121_1==KEYWORD_34||(LA121_1>=KEYWORD_36 && LA121_1<=KEYWORD_38)||LA121_1==KEYWORD_27||LA121_1==KEYWORD_30||(LA121_1>=KEYWORD_21 && LA121_1<=KEYWORD_22)||(LA121_1>=KEYWORD_24 && LA121_1<=KEYWORD_18)||(LA121_1>=KEYWORD_2 && LA121_1<=KEYWORD_10)||LA121_1==KEYWORD_12||LA121_1==KEYWORD_14||(LA121_1>=RULE_AND && LA121_1<=RULE_OR)||LA121_1==RULE_ORDER) ) {
                    alt121=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 121, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA121_2 = input.LA(2);

                if ( (LA121_2==KEYWORD_1) ) {
                    alt121=3;
                }
                else if ( (LA121_2==EOF||LA121_2==KEYWORD_41||LA121_2==KEYWORD_34||(LA121_2>=KEYWORD_36 && LA121_2<=KEYWORD_38)||LA121_2==KEYWORD_27||LA121_2==KEYWORD_30||(LA121_2>=KEYWORD_21 && LA121_2<=KEYWORD_22)||(LA121_2>=KEYWORD_24 && LA121_2<=KEYWORD_18)||(LA121_2>=KEYWORD_2 && LA121_2<=KEYWORD_10)||LA121_2==KEYWORD_12||LA121_2==KEYWORD_14||(LA121_2>=RULE_AND && LA121_2<=RULE_OR)||LA121_2==RULE_ORDER) ) {
                    alt121=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 121, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_FLOAT:
                {
                alt121=2;
                }
                break;
            case RULE_MIN:
            case RULE_MAX:
                {
                alt121=3;
                }
                break;
            case KEYWORD_1:
                {
                alt121=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }

            switch (alt121) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4572:2: ( (lv_i_0_0= ruleIdent ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4572:2: ( (lv_i_0_0= ruleIdent ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4573:1: (lv_i_0_0= ruleIdent )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4573:1: (lv_i_0_0= ruleIdent )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4574:3: lv_i_0_0= ruleIdent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTermAccess().getIIdentParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdent_in_ruleTerm10135);
                    lv_i_0_0=ruleIdent();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTermRule());
                      	        }
                             		set(
                             			current, 
                             			"i",
                              		lv_i_0_0, 
                              		"Ident");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4591:6: ( (lv_n_1_0= ruleNumber ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4591:6: ( (lv_n_1_0= ruleNumber ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4592:1: (lv_n_1_0= ruleNumber )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4592:1: (lv_n_1_0= ruleNumber )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4593:3: lv_n_1_0= ruleNumber
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTermAccess().getNNumberParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumber_in_ruleTerm10162);
                    lv_n_1_0=ruleNumber();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTermRule());
                      	        }
                             		set(
                             			current, 
                             			"n",
                              		lv_n_1_0, 
                              		"Number");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4610:6: ( (lv_f_2_0= ruleFunction ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4610:6: ( (lv_f_2_0= ruleFunction ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4611:1: (lv_f_2_0= ruleFunction )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4611:1: (lv_f_2_0= ruleFunction )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4612:3: lv_f_2_0= ruleFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTermAccess().getFFunctionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFunction_in_ruleTerm10189);
                    lv_f_2_0=ruleFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTermRule());
                      	        }
                             		set(
                             			current, 
                             			"f",
                              		lv_f_2_0, 
                              		"Function");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 4 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4629:6: (otherlv_3= KEYWORD_1 ( (lv_e2_4_0= ruleExpression ) ) otherlv_5= KEYWORD_2 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4629:6: (otherlv_3= KEYWORD_1 ( (lv_e2_4_0= ruleExpression ) ) otherlv_5= KEYWORD_2 )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4630:2: otherlv_3= KEYWORD_1 ( (lv_e2_4_0= ruleExpression ) ) otherlv_5= KEYWORD_2
                    {
                    otherlv_3=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleTerm10209); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTermAccess().getLeftParenthesisKeyword_3_0());
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4634:1: ( (lv_e2_4_0= ruleExpression ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4635:1: (lv_e2_4_0= ruleExpression )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4635:1: (lv_e2_4_0= ruleExpression )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4636:3: lv_e2_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTermAccess().getE2ExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleTerm10229);
                    lv_e2_4_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTermRule());
                      	        }
                             		set(
                             			current, 
                             			"e2",
                              		lv_e2_4_0, 
                              		"Expression");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_5=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleTerm10242); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getTermAccess().getRightParenthesisKeyword_3_2());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTerm"


    // $ANTLR start "entryRuleFunction"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4665:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4666:2: (iv_ruleFunction= ruleFunction EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4667:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction10277);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction10287); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4674:1: ruleFunction returns [EObject current=null] : (this_ExternalFunction_0= ruleExternalFunction | this_MaxFunction_1= ruleMaxFunction | this_MinFunction_2= ruleMinFunction | this_IntFunction_3= ruleIntFunction | ruleVarModel ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        EObject this_ExternalFunction_0 = null;

        EObject this_MaxFunction_1 = null;

        EObject this_MinFunction_2 = null;

        EObject this_IntFunction_3 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4677:28: ( (this_ExternalFunction_0= ruleExternalFunction | this_MaxFunction_1= ruleMaxFunction | this_MinFunction_2= ruleMinFunction | this_IntFunction_3= ruleIntFunction | ruleVarModel ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4678:1: (this_ExternalFunction_0= ruleExternalFunction | this_MaxFunction_1= ruleMaxFunction | this_MinFunction_2= ruleMinFunction | this_IntFunction_3= ruleIntFunction | ruleVarModel )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4678:1: (this_ExternalFunction_0= ruleExternalFunction | this_MaxFunction_1= ruleMaxFunction | this_MinFunction_2= ruleMinFunction | this_IntFunction_3= ruleIntFunction | ruleVarModel )
            int alt122=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA122_1 = input.LA(2);

                if ( (LA122_1==KEYWORD_1) ) {
                    alt122=1;
                }
                else if ( (LA122_1==KEYWORD_11) ) {
                    alt122=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 122, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_MAX:
                {
                alt122=2;
                }
                break;
            case RULE_MIN:
                {
                alt122=3;
                }
                break;
            case RULE_INT:
                {
                alt122=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;
            }

            switch (alt122) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4679:2: this_ExternalFunction_0= ruleExternalFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFunctionAccess().getExternalFunctionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExternalFunction_in_ruleFunction10337);
                    this_ExternalFunction_0=ruleExternalFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_ExternalFunction_0;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4692:2: this_MaxFunction_1= ruleMaxFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFunctionAccess().getMaxFunctionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleMaxFunction_in_ruleFunction10367);
                    this_MaxFunction_1=ruleMaxFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_MaxFunction_1;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4705:2: this_MinFunction_2= ruleMinFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFunctionAccess().getMinFunctionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleMinFunction_in_ruleFunction10397);
                    this_MinFunction_2=ruleMinFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_MinFunction_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4718:2: this_IntFunction_3= ruleIntFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFunctionAccess().getIntFunctionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntFunction_in_ruleFunction10427);
                    this_IntFunction_3=ruleIntFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_IntFunction_3;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4731:2: ruleVarModel
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFunctionAccess().getVarModelParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleVarModel_in_ruleFunction10451);
                    ruleVarModel();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleExternalFunction"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4749:1: entryRuleExternalFunction returns [EObject current=null] : iv_ruleExternalFunction= ruleExternalFunction EOF ;
    public final EObject entryRuleExternalFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalFunction = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4750:2: (iv_ruleExternalFunction= ruleExternalFunction EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4751:2: iv_ruleExternalFunction= ruleExternalFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExternalFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleExternalFunction_in_entryRuleExternalFunction10485);
            iv_ruleExternalFunction=ruleExternalFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExternalFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalFunction10495); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExternalFunction"


    // $ANTLR start "ruleExternalFunction"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4758:1: ruleExternalFunction returns [EObject current=null] : (this_ID_0= RULE_ID otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 ) ;
    public final EObject ruleExternalFunction() throws RecognitionException {
        EObject current = null;

        Token this_ID_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_e1_2_0 = null;

        EObject lv_e2_4_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4761:28: ( (this_ID_0= RULE_ID otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4762:1: (this_ID_0= RULE_ID otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4762:1: (this_ID_0= RULE_ID otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4762:2: this_ID_0= RULE_ID otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalFunction10531); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getExternalFunctionAccess().getIDTerminalRuleCall_0()); 
                  
            }
            otherlv_1=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleExternalFunction10543); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getExternalFunctionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4771:1: ( (lv_e1_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4772:1: (lv_e1_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4772:1: (lv_e1_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4773:3: lv_e1_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExternalFunctionAccess().getE1ExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleExternalFunction10563);
            lv_e1_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getExternalFunctionRule());
              	        }
                     		set(
                     			current, 
                     			"e1",
                      		lv_e1_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4789:2: (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )*
            loop123:
            do {
                int alt123=2;
                int LA123_0 = input.LA(1);

                if ( (LA123_0==KEYWORD_5) ) {
                    alt123=1;
                }


                switch (alt123) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4790:2: otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleExternalFunction10577); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getExternalFunctionAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4794:1: ( (lv_e2_4_0= ruleExpression ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4795:1: (lv_e2_4_0= ruleExpression )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4795:1: (lv_e2_4_0= ruleExpression )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4796:3: lv_e2_4_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExternalFunctionAccess().getE2ExpressionParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpression_in_ruleExternalFunction10597);
            	    lv_e2_4_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getExternalFunctionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"e2",
            	              		lv_e2_4_0, 
            	              		"Expression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop123;
                }
            } while (true);

            otherlv_5=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleExternalFunction10612); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getExternalFunctionAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExternalFunction"


    // $ANTLR start "entryRuleMaxFunction"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4825:1: entryRuleMaxFunction returns [EObject current=null] : iv_ruleMaxFunction= ruleMaxFunction EOF ;
    public final EObject entryRuleMaxFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxFunction = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4826:2: (iv_ruleMaxFunction= ruleMaxFunction EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4827:2: iv_ruleMaxFunction= ruleMaxFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleMaxFunction_in_entryRuleMaxFunction10646);
            iv_ruleMaxFunction=ruleMaxFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMaxFunction10656); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaxFunction"


    // $ANTLR start "ruleMaxFunction"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4834:1: ruleMaxFunction returns [EObject current=null] : (this_MAX_0= RULE_MAX otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 ) ;
    public final EObject ruleMaxFunction() throws RecognitionException {
        EObject current = null;

        Token this_MAX_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_e1_2_0 = null;

        EObject lv_e2_4_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4837:28: ( (this_MAX_0= RULE_MAX otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4838:1: (this_MAX_0= RULE_MAX otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4838:1: (this_MAX_0= RULE_MAX otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4838:2: this_MAX_0= RULE_MAX otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2
            {
            this_MAX_0=(Token)match(input,RULE_MAX,FOLLOW_RULE_MAX_in_ruleMaxFunction10692); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_MAX_0, grammarAccess.getMaxFunctionAccess().getMAXTerminalRuleCall_0()); 
                  
            }
            otherlv_1=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleMaxFunction10704); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMaxFunctionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4847:1: ( (lv_e1_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4848:1: (lv_e1_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4848:1: (lv_e1_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4849:3: lv_e1_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMaxFunctionAccess().getE1ExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleMaxFunction10724);
            lv_e1_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMaxFunctionRule());
              	        }
                     		set(
                     			current, 
                     			"e1",
                      		lv_e1_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4865:2: (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )*
            loop124:
            do {
                int alt124=2;
                int LA124_0 = input.LA(1);

                if ( (LA124_0==KEYWORD_5) ) {
                    alt124=1;
                }


                switch (alt124) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4866:2: otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleMaxFunction10738); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getMaxFunctionAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4870:1: ( (lv_e2_4_0= ruleExpression ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4871:1: (lv_e2_4_0= ruleExpression )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4871:1: (lv_e2_4_0= ruleExpression )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4872:3: lv_e2_4_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMaxFunctionAccess().getE2ExpressionParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpression_in_ruleMaxFunction10758);
            	    lv_e2_4_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMaxFunctionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"e2",
            	              		lv_e2_4_0, 
            	              		"Expression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop124;
                }
            } while (true);

            otherlv_5=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleMaxFunction10773); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMaxFunctionAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaxFunction"


    // $ANTLR start "entryRuleMinFunction"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4901:1: entryRuleMinFunction returns [EObject current=null] : iv_ruleMinFunction= ruleMinFunction EOF ;
    public final EObject entryRuleMinFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinFunction = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4902:2: (iv_ruleMinFunction= ruleMinFunction EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4903:2: iv_ruleMinFunction= ruleMinFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMinFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleMinFunction_in_entryRuleMinFunction10807);
            iv_ruleMinFunction=ruleMinFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMinFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMinFunction10817); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMinFunction"


    // $ANTLR start "ruleMinFunction"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4910:1: ruleMinFunction returns [EObject current=null] : (this_MIN_0= RULE_MIN otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 ) ;
    public final EObject ruleMinFunction() throws RecognitionException {
        EObject current = null;

        Token this_MIN_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_e1_2_0 = null;

        EObject lv_e2_4_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4913:28: ( (this_MIN_0= RULE_MIN otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4914:1: (this_MIN_0= RULE_MIN otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4914:1: (this_MIN_0= RULE_MIN otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4914:2: this_MIN_0= RULE_MIN otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2
            {
            this_MIN_0=(Token)match(input,RULE_MIN,FOLLOW_RULE_MIN_in_ruleMinFunction10853); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_MIN_0, grammarAccess.getMinFunctionAccess().getMINTerminalRuleCall_0()); 
                  
            }
            otherlv_1=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleMinFunction10865); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMinFunctionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4923:1: ( (lv_e1_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4924:1: (lv_e1_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4924:1: (lv_e1_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4925:3: lv_e1_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMinFunctionAccess().getE1ExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleMinFunction10885);
            lv_e1_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMinFunctionRule());
              	        }
                     		set(
                     			current, 
                     			"e1",
                      		lv_e1_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4941:2: (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )*
            loop125:
            do {
                int alt125=2;
                int LA125_0 = input.LA(1);

                if ( (LA125_0==KEYWORD_5) ) {
                    alt125=1;
                }


                switch (alt125) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4942:2: otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleMinFunction10899); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getMinFunctionAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4946:1: ( (lv_e2_4_0= ruleExpression ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4947:1: (lv_e2_4_0= ruleExpression )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4947:1: (lv_e2_4_0= ruleExpression )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4948:3: lv_e2_4_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMinFunctionAccess().getE2ExpressionParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpression_in_ruleMinFunction10919);
            	    lv_e2_4_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getMinFunctionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"e2",
            	              		lv_e2_4_0, 
            	              		"Expression");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop125;
                }
            } while (true);

            otherlv_5=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleMinFunction10934); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getMinFunctionAccess().getRightParenthesisKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMinFunction"


    // $ANTLR start "entryRuleIntFunction"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4977:1: entryRuleIntFunction returns [EObject current=null] : iv_ruleIntFunction= ruleIntFunction EOF ;
    public final EObject entryRuleIntFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntFunction = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4978:2: (iv_ruleIntFunction= ruleIntFunction EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4979:2: iv_ruleIntFunction= ruleIntFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleIntFunction_in_entryRuleIntFunction10968);
            iv_ruleIntFunction=ruleIntFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntFunction10978); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntFunction"


    // $ANTLR start "ruleIntFunction"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4986:1: ruleIntFunction returns [EObject current=null] : (this_INT_0= RULE_INT otherlv_1= KEYWORD_1 ( (lv_e_2_0= ruleExpression ) ) otherlv_3= KEYWORD_2 ) ;
    public final EObject ruleIntFunction() throws RecognitionException {
        EObject current = null;

        Token this_INT_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_e_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4989:28: ( (this_INT_0= RULE_INT otherlv_1= KEYWORD_1 ( (lv_e_2_0= ruleExpression ) ) otherlv_3= KEYWORD_2 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4990:1: (this_INT_0= RULE_INT otherlv_1= KEYWORD_1 ( (lv_e_2_0= ruleExpression ) ) otherlv_3= KEYWORD_2 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4990:1: (this_INT_0= RULE_INT otherlv_1= KEYWORD_1 ( (lv_e_2_0= ruleExpression ) ) otherlv_3= KEYWORD_2 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4990:2: this_INT_0= RULE_INT otherlv_1= KEYWORD_1 ( (lv_e_2_0= ruleExpression ) ) otherlv_3= KEYWORD_2
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntFunction11014); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getIntFunctionAccess().getINTTerminalRuleCall_0()); 
                  
            }
            otherlv_1=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleIntFunction11026); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIntFunctionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4999:1: ( (lv_e_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5000:1: (lv_e_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5000:1: (lv_e_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5001:3: lv_e_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIntFunctionAccess().getEExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIntFunction11046);
            lv_e_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getIntFunctionRule());
              	        }
                     		set(
                     			current, 
                     			"e",
                      		lv_e_2_0, 
                      		"Expression");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleIntFunction11059); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getIntFunctionAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntFunction"


    // $ANTLR start "entryRuleLogicalFunction"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5030:1: entryRuleLogicalFunction returns [String current=null] : iv_ruleLogicalFunction= ruleLogicalFunction EOF ;
    public final String entryRuleLogicalFunction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalFunction = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5031:1: (iv_ruleLogicalFunction= ruleLogicalFunction EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5032:2: iv_ruleLogicalFunction= ruleLogicalFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalFunction_in_entryRuleLogicalFunction11094);
            iv_ruleLogicalFunction=ruleLogicalFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalFunction.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalFunction11105); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalFunction"


    // $ANTLR start "ruleLogicalFunction"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5039:1: ruleLogicalFunction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_RangeFunction_0= ruleRangeFunction ;
    public final AntlrDatatypeRuleToken ruleLogicalFunction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_RangeFunction_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5043:6: (this_RangeFunction_0= ruleRangeFunction )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5045:5: this_RangeFunction_0= ruleRangeFunction
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalFunctionAccess().getRangeFunctionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleRangeFunction_in_ruleLogicalFunction11151);
            this_RangeFunction_0=ruleRangeFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_RangeFunction_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalFunction"


    // $ANTLR start "entryRuleVarModel"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5063:1: entryRuleVarModel returns [String current=null] : iv_ruleVarModel= ruleVarModel EOF ;
    public final String entryRuleVarModel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVarModel = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5064:1: (iv_ruleVarModel= ruleVarModel EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5065:2: iv_ruleVarModel= ruleVarModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarModelRule()); 
            }
            pushFollow(FOLLOW_ruleVarModel_in_entryRuleVarModel11195);
            iv_ruleVarModel=ruleVarModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarModel.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarModel11206); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVarModel"


    // $ANTLR start "ruleVarModel"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5072:1: ruleVarModel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= KEYWORD_11 this_ID_2= RULE_ID kw= KEYWORD_12 ) ;
    public final AntlrDatatypeRuleToken ruleVarModel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5076:6: ( (this_ID_0= RULE_ID kw= KEYWORD_11 this_ID_2= RULE_ID kw= KEYWORD_12 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5077:1: (this_ID_0= RULE_ID kw= KEYWORD_11 this_ID_2= RULE_ID kw= KEYWORD_12 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5077:1: (this_ID_0= RULE_ID kw= KEYWORD_11 this_ID_2= RULE_ID kw= KEYWORD_12 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5077:6: this_ID_0= RULE_ID kw= KEYWORD_11 this_ID_2= RULE_ID kw= KEYWORD_12
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarModel11246); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getVarModelAccess().getIDTerminalRuleCall_0()); 
                  
            }
            kw=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleVarModel11264); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getVarModelAccess().getLeftSquareBracketKeyword_1()); 
                  
            }
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarModel11279); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getVarModelAccess().getIDTerminalRuleCall_2()); 
                  
            }
            kw=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleVarModel11297); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getVarModelAccess().getRightSquareBracketKeyword_3()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVarModel"


    // $ANTLR start "entryRuleRangeFunction"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5111:1: entryRuleRangeFunction returns [String current=null] : iv_ruleRangeFunction= ruleRangeFunction EOF ;
    public final String entryRuleRangeFunction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRangeFunction = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5112:1: (iv_ruleRangeFunction= ruleRangeFunction EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5113:2: iv_ruleRangeFunction= ruleRangeFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleRangeFunction_in_entryRuleRangeFunction11337);
            iv_ruleRangeFunction=ruleRangeFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRangeFunction.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeFunction11348); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRangeFunction"


    // $ANTLR start "ruleRangeFunction"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5120:1: ruleRangeFunction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_RANGE_0= RULE_RANGE kw= KEYWORD_1 this_ID_2= RULE_ID kw= KEYWORD_5 this_ID_4= RULE_ID kw= KEYWORD_5 this_ID_6= RULE_ID kw= KEYWORD_2 ) ;
    public final AntlrDatatypeRuleToken ruleRangeFunction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_RANGE_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;
        Token this_ID_6=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5124:6: ( (this_RANGE_0= RULE_RANGE kw= KEYWORD_1 this_ID_2= RULE_ID kw= KEYWORD_5 this_ID_4= RULE_ID kw= KEYWORD_5 this_ID_6= RULE_ID kw= KEYWORD_2 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5125:1: (this_RANGE_0= RULE_RANGE kw= KEYWORD_1 this_ID_2= RULE_ID kw= KEYWORD_5 this_ID_4= RULE_ID kw= KEYWORD_5 this_ID_6= RULE_ID kw= KEYWORD_2 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5125:1: (this_RANGE_0= RULE_RANGE kw= KEYWORD_1 this_ID_2= RULE_ID kw= KEYWORD_5 this_ID_4= RULE_ID kw= KEYWORD_5 this_ID_6= RULE_ID kw= KEYWORD_2 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5125:6: this_RANGE_0= RULE_RANGE kw= KEYWORD_1 this_ID_2= RULE_ID kw= KEYWORD_5 this_ID_4= RULE_ID kw= KEYWORD_5 this_ID_6= RULE_ID kw= KEYWORD_2
            {
            this_RANGE_0=(Token)match(input,RULE_RANGE,FOLLOW_RULE_RANGE_in_ruleRangeFunction11388); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_RANGE_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RANGE_0, grammarAccess.getRangeFunctionAccess().getRANGETerminalRuleCall_0()); 
                  
            }
            kw=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleRangeFunction11406); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getRangeFunctionAccess().getLeftParenthesisKeyword_1()); 
                  
            }
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRangeFunction11421); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getRangeFunctionAccess().getIDTerminalRuleCall_2()); 
                  
            }
            kw=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleRangeFunction11439); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getRangeFunctionAccess().getCommaKeyword_3()); 
                  
            }
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRangeFunction11454); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_4);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_4, grammarAccess.getRangeFunctionAccess().getIDTerminalRuleCall_4()); 
                  
            }
            kw=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleRangeFunction11472); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getRangeFunctionAccess().getCommaKeyword_5()); 
                  
            }
            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRangeFunction11487); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_6);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_6, grammarAccess.getRangeFunctionAccess().getIDTerminalRuleCall_6()); 
                  
            }
            kw=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleRangeFunction11505); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getRangeFunctionAccess().getRightParenthesisKeyword_7()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRangeFunction"


    // $ANTLR start "entryRuleIdent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5185:1: entryRuleIdent returns [EObject current=null] : iv_ruleIdent= ruleIdent EOF ;
    public final EObject entryRuleIdent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5186:2: (iv_ruleIdent= ruleIdent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5187:2: iv_ruleIdent= ruleIdent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentRule()); 
            }
            pushFollow(FOLLOW_ruleIdent_in_entryRuleIdent11544);
            iv_ruleIdent=ruleIdent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdent11554); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdent"


    // $ANTLR start "ruleIdent"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5194:1: ruleIdent returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleIdent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5197:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5198:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5198:1: ( (lv_name_0_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5199:1: (lv_name_0_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5199:1: (lv_name_0_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5200:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdent11595); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_0_0, grammarAccess.getIdentAccess().getNameIDTerminalRuleCall_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIdentRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"ID");
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdent"


    // $ANTLR start "entryRuleNumber"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5224:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5225:1: (iv_ruleNumber= ruleNumber EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5226:2: iv_ruleNumber= ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberRule()); 
            }
            pushFollow(FOLLOW_ruleNumber_in_entryRuleNumber11635);
            iv_ruleNumber=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumber11646); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5233:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_FLOAT_1= RULE_FLOAT ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_FLOAT_1=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5237:6: ( (this_INT_0= RULE_INT | this_FLOAT_1= RULE_FLOAT ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5238:1: (this_INT_0= RULE_INT | this_FLOAT_1= RULE_FLOAT )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5238:1: (this_INT_0= RULE_INT | this_FLOAT_1= RULE_FLOAT )
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==RULE_INT) ) {
                alt126=1;
            }
            else if ( (LA126_0==RULE_FLOAT) ) {
                alt126=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 126, 0, input);

                throw nvae;
            }
            switch (alt126) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5238:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber11686); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getNumberAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5246:10: this_FLOAT_1= RULE_FLOAT
                    {
                    this_FLOAT_1=(Token)match(input,RULE_FLOAT,FOLLOW_RULE_FLOAT_in_ruleNumber11712); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_FLOAT_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_FLOAT_1, grammarAccess.getNumberAccess().getFLOATTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleIncludeFile"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5261:1: entryRuleIncludeFile returns [EObject current=null] : iv_ruleIncludeFile= ruleIncludeFile EOF ;
    public final EObject entryRuleIncludeFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeFile = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5262:2: (iv_ruleIncludeFile= ruleIncludeFile EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5263:2: iv_ruleIncludeFile= ruleIncludeFile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIncludeFileRule()); 
            }
            pushFollow(FOLLOW_ruleIncludeFile_in_entryRuleIncludeFile11756);
            iv_ruleIncludeFile=ruleIncludeFile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIncludeFile; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeFile11766); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIncludeFile"


    // $ANTLR start "ruleIncludeFile"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5270:1: ruleIncludeFile returns [EObject current=null] : ( (otherlv_0= KEYWORD_43 | otherlv_1= KEYWORD_43 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_file_5_0= RULE_STRING ) ) ) ;
    public final EObject ruleIncludeFile() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_local_3_1=null;
        Token lv_local_3_2=null;
        Token otherlv_4=null;
        Token lv_file_5_0=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5273:28: ( ( (otherlv_0= KEYWORD_43 | otherlv_1= KEYWORD_43 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_file_5_0= RULE_STRING ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5274:1: ( (otherlv_0= KEYWORD_43 | otherlv_1= KEYWORD_43 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_file_5_0= RULE_STRING ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5274:1: ( (otherlv_0= KEYWORD_43 | otherlv_1= KEYWORD_43 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_file_5_0= RULE_STRING ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5274:2: (otherlv_0= KEYWORD_43 | otherlv_1= KEYWORD_43 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_file_5_0= RULE_STRING ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5274:2: (otherlv_0= KEYWORD_43 | otherlv_1= KEYWORD_43 )
            int alt127=2;
            int LA127_0 = input.LA(1);

            if ( (LA127_0==KEYWORD_43) ) {
                int LA127_1 = input.LA(2);

                if ( (synpred150_InternalWreslEditorParser()) ) {
                    alt127=1;
                }
                else if ( (true) ) {
                    alt127=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 127, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 127, 0, input);

                throw nvae;
            }
            switch (alt127) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5275:2: otherlv_0= KEYWORD_43
                    {
                    otherlv_0=(Token)match(input,KEYWORD_43,FOLLOW_KEYWORD_43_in_ruleIncludeFile11805); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getIncludeFileAccess().getIncludeKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5281:2: otherlv_1= KEYWORD_43
                    {
                    otherlv_1=(Token)match(input,KEYWORD_43,FOLLOW_KEYWORD_43_in_ruleIncludeFile11823); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getIncludeFileAccess().getINCLUDEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5285:2: (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )?
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==KEYWORD_11) ) {
                alt129=1;
            }
            switch (alt129) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5286:2: otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12
                    {
                    otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleIncludeFile11837); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getIncludeFileAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5290:1: ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5291:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5291:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5292:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5292:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    int alt128=2;
                    int LA128_0 = input.LA(1);

                    if ( (LA128_0==KEYWORD_33) ) {
                        int LA128_1 = input.LA(2);

                        if ( (synpred151_InternalWreslEditorParser()) ) {
                            alt128=1;
                        }
                        else if ( (true) ) {
                            alt128=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 128, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 128, 0, input);

                        throw nvae;
                    }
                    switch (alt128) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5293:3: lv_local_3_1= KEYWORD_33
                            {
                            lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleIncludeFile11857); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_local_3_1, grammarAccess.getIncludeFileAccess().getLocalLocalKeyword_1_1_0_0());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getIncludeFileRule());
                              	        }
                                     		setWithLastConsumed(current, "local", true, null);
                              	    
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5306:8: lv_local_3_2= KEYWORD_33
                            {
                            lv_local_3_2=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleIncludeFile11885); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                      newLeafNode(lv_local_3_2, grammarAccess.getIncludeFileAccess().getLocalLOCALKeyword_1_1_0_1());
                                  
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getIncludeFileRule());
                              	        }
                                     		setWithLastConsumed(current, "local", true, null);
                              	    
                            }

                            }
                            break;

                    }


                    }


                    }

                    otherlv_4=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleIncludeFile11912); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getIncludeFileAccess().getRightSquareBracketKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5327:3: ( (lv_file_5_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5328:1: (lv_file_5_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5328:1: (lv_file_5_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5329:3: lv_file_5_0= RULE_STRING
            {
            lv_file_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIncludeFile11930); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_file_5_0, grammarAccess.getIncludeFileAccess().getFileSTRINGTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getIncludeFileRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"file",
                      		lv_file_5_0, 
                      		"STRING");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIncludeFile"


    // $ANTLR start "entryRuleIncludeModel"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5353:1: entryRuleIncludeModel returns [String current=null] : iv_ruleIncludeModel= ruleIncludeModel EOF ;
    public final String entryRuleIncludeModel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIncludeModel = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5354:1: (iv_ruleIncludeModel= ruleIncludeModel EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5355:2: iv_ruleIncludeModel= ruleIncludeModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIncludeModelRule()); 
            }
            pushFollow(FOLLOW_ruleIncludeModel_in_entryRuleIncludeModel11971);
            iv_ruleIncludeModel=ruleIncludeModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIncludeModel.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeModel11982); if (state.failed) return current;

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIncludeModel"


    // $ANTLR start "ruleIncludeModel"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5362:1: ruleIncludeModel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= KEYWORD_43 | kw= KEYWORD_43 ) (kw= KEYWORD_35 | kw= KEYWORD_35 ) this_ID_4= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleIncludeModel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5366:6: ( ( (kw= KEYWORD_43 | kw= KEYWORD_43 ) (kw= KEYWORD_35 | kw= KEYWORD_35 ) this_ID_4= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5367:1: ( (kw= KEYWORD_43 | kw= KEYWORD_43 ) (kw= KEYWORD_35 | kw= KEYWORD_35 ) this_ID_4= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5367:1: ( (kw= KEYWORD_43 | kw= KEYWORD_43 ) (kw= KEYWORD_35 | kw= KEYWORD_35 ) this_ID_4= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5367:2: (kw= KEYWORD_43 | kw= KEYWORD_43 ) (kw= KEYWORD_35 | kw= KEYWORD_35 ) this_ID_4= RULE_ID
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5367:2: (kw= KEYWORD_43 | kw= KEYWORD_43 )
            int alt130=2;
            int LA130_0 = input.LA(1);

            if ( (LA130_0==KEYWORD_43) ) {
                int LA130_1 = input.LA(2);

                if ( (synpred153_InternalWreslEditorParser()) ) {
                    alt130=1;
                }
                else if ( (true) ) {
                    alt130=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 130, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;
            }
            switch (alt130) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5368:2: kw= KEYWORD_43
                    {
                    kw=(Token)match(input,KEYWORD_43,FOLLOW_KEYWORD_43_in_ruleIncludeModel12021); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIncludeModelAccess().getIncludeKeyword_0_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5375:2: kw= KEYWORD_43
                    {
                    kw=(Token)match(input,KEYWORD_43,FOLLOW_KEYWORD_43_in_ruleIncludeModel12040); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIncludeModelAccess().getINCLUDEKeyword_0_1()); 
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5380:2: (kw= KEYWORD_35 | kw= KEYWORD_35 )
            int alt131=2;
            int LA131_0 = input.LA(1);

            if ( (LA131_0==KEYWORD_35) ) {
                int LA131_1 = input.LA(2);

                if ( (synpred154_InternalWreslEditorParser()) ) {
                    alt131=1;
                }
                else if ( (true) ) {
                    alt131=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 131, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 131, 0, input);

                throw nvae;
            }
            switch (alt131) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5381:2: kw= KEYWORD_35
                    {
                    kw=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_ruleIncludeModel12055); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIncludeModelAccess().getModelKeyword_1_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5388:2: kw= KEYWORD_35
                    {
                    kw=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_ruleIncludeModel12074); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getIncludeModelAccess().getMODELKeyword_1_1()); 
                          
                    }

                    }
                    break;

            }

            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIncludeModel12090); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_4);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_4, grammarAccess.getIncludeModelAccess().getIDTerminalRuleCall_2()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule();
                  
            }
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIncludeModel"

    // $ANTLR start synpred11_InternalWreslEditorParser
    public final void synpred11_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:277:2: (otherlv_0= KEYWORD_51 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:277:2: otherlv_0= KEYWORD_51
        {
        otherlv_0=(Token)match(input,KEYWORD_51,FOLLOW_KEYWORD_51_in_synpred11_InternalWreslEditorParser520); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_InternalWreslEditorParser

    // $ANTLR start synpred12_InternalWreslEditorParser
    public final void synpred12_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token lv_local_3_1=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:295:3: (lv_local_3_1= KEYWORD_33 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:295:3: lv_local_3_1= KEYWORD_33
        {
        lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_synpred12_InternalWreslEditorParser572); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred12_InternalWreslEditorParser

    // $ANTLR start synpred16_InternalWreslEditorParser
    public final void synpred16_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:479:2: (otherlv_0= KEYWORD_40 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:479:2: otherlv_0= KEYWORD_40
        {
        otherlv_0=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_synpred16_InternalWreslEditorParser956); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred16_InternalWreslEditorParser

    // $ANTLR start synpred17_InternalWreslEditorParser
    public final void synpred17_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token lv_local_3_1=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:497:3: (lv_local_3_1= KEYWORD_33 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:497:3: lv_local_3_1= KEYWORD_33
        {
        lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_synpred17_InternalWreslEditorParser1008); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_InternalWreslEditorParser

    // $ANTLR start synpred22_InternalWreslEditorParser
    public final void synpred22_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:647:2: (otherlv_0= KEYWORD_47 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:647:2: otherlv_0= KEYWORD_47
        {
        otherlv_0=(Token)match(input,KEYWORD_47,FOLLOW_KEYWORD_47_in_synpred22_InternalWreslEditorParser1277); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_InternalWreslEditorParser

    // $ANTLR start synpred23_InternalWreslEditorParser
    public final void synpred23_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:676:2: (otherlv_3= KEYWORD_26 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:676:2: otherlv_3= KEYWORD_26
        {
        otherlv_3=(Token)match(input,KEYWORD_26,FOLLOW_KEYWORD_26_in_synpred23_InternalWreslEditorParser1333); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalWreslEditorParser

    // $ANTLR start synpred25_InternalWreslEditorParser
    public final void synpred25_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:697:2: (otherlv_6= KEYWORD_20 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:697:2: otherlv_6= KEYWORD_20
        {
        otherlv_6=(Token)match(input,KEYWORD_20,FOLLOW_KEYWORD_20_in_synpred25_InternalWreslEditorParser1385); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_InternalWreslEditorParser

    // $ANTLR start synpred26_InternalWreslEditorParser
    public final void synpred26_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:729:2: (otherlv_0= KEYWORD_40 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:729:2: otherlv_0= KEYWORD_40
        {
        otherlv_0=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_synpred26_InternalWreslEditorParser1489); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_InternalWreslEditorParser

    // $ANTLR start synpred27_InternalWreslEditorParser
    public final void synpred27_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token lv_local_3_1=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:747:3: (lv_local_3_1= KEYWORD_33 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:747:3: lv_local_3_1= KEYWORD_33
        {
        lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_synpred27_InternalWreslEditorParser1541); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalWreslEditorParser

    // $ANTLR start synpred29_InternalWreslEditorParser
    public final void synpred29_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_7=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:805:2: (otherlv_7= KEYWORD_31 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:805:2: otherlv_7= KEYWORD_31
        {
        otherlv_7=(Token)match(input,KEYWORD_31,FOLLOW_KEYWORD_31_in_synpred29_InternalWreslEditorParser1645); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred29_InternalWreslEditorParser

    // $ANTLR start synpred30_InternalWreslEditorParser
    public final void synpred30_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_10=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:834:2: (otherlv_10= KEYWORD_30 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:834:2: otherlv_10= KEYWORD_30
        {
        otherlv_10=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_synpred30_InternalWreslEditorParser1699); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalWreslEditorParser

    // $ANTLR start synpred32_InternalWreslEditorParser
    public final void synpred32_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_13=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:863:2: (otherlv_13= KEYWORD_36 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:863:2: otherlv_13= KEYWORD_36
        {
        otherlv_13=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_synpred32_InternalWreslEditorParser1756); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred32_InternalWreslEditorParser

    // $ANTLR start synpred35_InternalWreslEditorParser
    public final void synpred35_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_1=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:982:2: (otherlv_1= KEYWORD_30 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:982:2: otherlv_1= KEYWORD_30
        {
        otherlv_1=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_synpred35_InternalWreslEditorParser2039); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalWreslEditorParser

    // $ANTLR start synpred36_InternalWreslEditorParser
    public final void synpred36_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_4=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1011:2: (otherlv_4= KEYWORD_36 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1011:2: otherlv_4= KEYWORD_36
        {
        otherlv_4=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_synpred36_InternalWreslEditorParser2093); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_InternalWreslEditorParser

    // $ANTLR start synpred37_InternalWreslEditorParser
    public final void synpred37_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1061:2: (otherlv_0= KEYWORD_23 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1061:2: otherlv_0= KEYWORD_23
        {
        otherlv_0=(Token)match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_synpred37_InternalWreslEditorParser2217); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_InternalWreslEditorParser

    // $ANTLR start synpred38_InternalWreslEditorParser
    public final void synpred38_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1072:2: (otherlv_2= KEYWORD_30 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1072:2: otherlv_2= KEYWORD_30
        {
        otherlv_2=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_synpred38_InternalWreslEditorParser2249); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred38_InternalWreslEditorParser

    // $ANTLR start synpred39_InternalWreslEditorParser
    public final void synpred39_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_5=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1101:2: (otherlv_5= KEYWORD_36 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1101:2: otherlv_5= KEYWORD_36
        {
        otherlv_5=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_synpred39_InternalWreslEditorParser2303); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_InternalWreslEditorParser

    // $ANTLR start synpred41_InternalWreslEditorParser
    public final void synpred41_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1197:2: (otherlv_0= KEYWORD_45 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1197:2: otherlv_0= KEYWORD_45
        {
        otherlv_0=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_synpred41_InternalWreslEditorParser2551); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_InternalWreslEditorParser

    // $ANTLR start synpred42_InternalWreslEditorParser
    public final void synpred42_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1208:2: (otherlv_2= KEYWORD_23 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1208:2: otherlv_2= KEYWORD_23
        {
        otherlv_2=(Token)match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_synpred42_InternalWreslEditorParser2583); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_InternalWreslEditorParser

    // $ANTLR start synpred43_InternalWreslEditorParser
    public final void synpred43_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_4=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1219:2: (otherlv_4= KEYWORD_30 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1219:2: otherlv_4= KEYWORD_30
        {
        otherlv_4=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_synpred43_InternalWreslEditorParser2615); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_InternalWreslEditorParser

    // $ANTLR start synpred44_InternalWreslEditorParser
    public final void synpred44_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_7=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1248:2: (otherlv_7= KEYWORD_36 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1248:2: otherlv_7= KEYWORD_36
        {
        otherlv_7=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_synpred44_InternalWreslEditorParser2669); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_InternalWreslEditorParser

    // $ANTLR start synpred45_InternalWreslEditorParser
    public final void synpred45_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1298:2: (otherlv_0= KEYWORD_45 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1298:2: otherlv_0= KEYWORD_45
        {
        otherlv_0=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_synpred45_InternalWreslEditorParser2793); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_InternalWreslEditorParser

    // $ANTLR start synpred46_InternalWreslEditorParser
    public final void synpred46_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1321:2: (otherlv_3= KEYWORD_30 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1321:2: otherlv_3= KEYWORD_30
        {
        otherlv_3=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_synpred46_InternalWreslEditorParser2849); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred46_InternalWreslEditorParser

    // $ANTLR start synpred47_InternalWreslEditorParser
    public final void synpred47_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1350:2: (otherlv_6= KEYWORD_36 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1350:2: otherlv_6= KEYWORD_36
        {
        otherlv_6=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_synpred47_InternalWreslEditorParser2903); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred47_InternalWreslEditorParser

    // $ANTLR start synpred52_InternalWreslEditorParser
    public final void synpred52_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1485:2: (otherlv_0= KEYWORD_53 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1485:2: otherlv_0= KEYWORD_53
        {
        otherlv_0=(Token)match(input,KEYWORD_53,FOLLOW_KEYWORD_53_in_synpred52_InternalWreslEditorParser3241); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_InternalWreslEditorParser

    // $ANTLR start synpred54_InternalWreslEditorParser
    public final void synpred54_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1514:2: (otherlv_3= KEYWORD_30 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1514:2: otherlv_3= KEYWORD_30
        {
        otherlv_3=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_synpred54_InternalWreslEditorParser3296); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_InternalWreslEditorParser

    // $ANTLR start synpred55_InternalWreslEditorParser
    public final void synpred55_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1543:2: (otherlv_6= KEYWORD_36 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1543:2: otherlv_6= KEYWORD_36
        {
        otherlv_6=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_synpred55_InternalWreslEditorParser3350); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred55_InternalWreslEditorParser

    // $ANTLR start synpred56_InternalWreslEditorParser
    public final void synpred56_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_9=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1572:2: (otherlv_9= KEYWORD_42 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1572:2: otherlv_9= KEYWORD_42
        {
        otherlv_9=(Token)match(input,KEYWORD_42,FOLLOW_KEYWORD_42_in_synpred56_InternalWreslEditorParser3405); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_InternalWreslEditorParser

    // $ANTLR start synpred58_InternalWreslEditorParser
    public final void synpred58_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1622:2: (otherlv_0= KEYWORD_38 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1622:2: otherlv_0= KEYWORD_38
        {
        otherlv_0=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_synpred58_InternalWreslEditorParser3531); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_InternalWreslEditorParser

    // $ANTLR start synpred60_InternalWreslEditorParser
    public final void synpred60_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1789:2: (otherlv_0= KEYWORD_27 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1789:2: otherlv_0= KEYWORD_27
        {
        otherlv_0=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_synpred60_InternalWreslEditorParser3922); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred60_InternalWreslEditorParser

    // $ANTLR start synpred63_InternalWreslEditorParser
    public final void synpred63_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1923:2: (otherlv_0= KEYWORD_24 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1923:2: otherlv_0= KEYWORD_24
        {
        otherlv_0=(Token)match(input,KEYWORD_24,FOLLOW_KEYWORD_24_in_synpred63_InternalWreslEditorParser4168); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred63_InternalWreslEditorParser

    // $ANTLR start synpred66_InternalWreslEditorParser
    public final void synpred66_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2082:2: (otherlv_0= KEYWORD_38 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2082:2: otherlv_0= KEYWORD_38
        {
        otherlv_0=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_synpred66_InternalWreslEditorParser4512); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred66_InternalWreslEditorParser

    // $ANTLR start synpred67_InternalWreslEditorParser
    public final void synpred67_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2132:2: (otherlv_0= KEYWORD_41 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2132:2: otherlv_0= KEYWORD_41
        {
        otherlv_0=(Token)match(input,KEYWORD_41,FOLLOW_KEYWORD_41_in_synpred67_InternalWreslEditorParser4635); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred67_InternalWreslEditorParser

    // $ANTLR start synpred68_InternalWreslEditorParser
    public final void synpred68_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2161:2: (otherlv_3= KEYWORD_28 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2161:2: otherlv_3= KEYWORD_28
        {
        otherlv_3=(Token)match(input,KEYWORD_28,FOLLOW_KEYWORD_28_in_synpred68_InternalWreslEditorParser4689); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred68_InternalWreslEditorParser

    // $ANTLR start synpred69_InternalWreslEditorParser
    public final void synpred69_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2190:2: (otherlv_6= KEYWORD_32 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2190:2: otherlv_6= KEYWORD_32
        {
        otherlv_6=(Token)match(input,KEYWORD_32,FOLLOW_KEYWORD_32_in_synpred69_InternalWreslEditorParser4744); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred69_InternalWreslEditorParser

    // $ANTLR start synpred70_InternalWreslEditorParser
    public final void synpred70_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_9=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2219:2: (otherlv_9= KEYWORD_25 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2219:2: otherlv_9= KEYWORD_25
        {
        otherlv_9=(Token)match(input,KEYWORD_25,FOLLOW_KEYWORD_25_in_synpred70_InternalWreslEditorParser4797); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred70_InternalWreslEditorParser

    // $ANTLR start synpred72_InternalWreslEditorParser
    public final void synpred72_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_12=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2248:2: (otherlv_12= KEYWORD_39 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2248:2: otherlv_12= KEYWORD_39
        {
        otherlv_12=(Token)match(input,KEYWORD_39,FOLLOW_KEYWORD_39_in_synpred72_InternalWreslEditorParser4854); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred72_InternalWreslEditorParser

    // $ANTLR start synpred80_InternalWreslEditorParser
    public final void synpred80_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2632:2: (otherlv_0= KEYWORD_37 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2632:2: otherlv_0= KEYWORD_37
        {
        otherlv_0=(Token)match(input,KEYWORD_37,FOLLOW_KEYWORD_37_in_synpred80_InternalWreslEditorParser5714); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred80_InternalWreslEditorParser

    // $ANTLR start synpred81_InternalWreslEditorParser
    public final void synpred81_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2652:2: (otherlv_3= KEYWORD_52 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2652:2: otherlv_3= KEYWORD_52
        {
        otherlv_3=(Token)match(input,KEYWORD_52,FOLLOW_KEYWORD_52_in_synpred81_InternalWreslEditorParser5760); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred81_InternalWreslEditorParser

    // $ANTLR start synpred83_InternalWreslEditorParser
    public final void synpred83_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2703:2: (otherlv_0= KEYWORD_34 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2703:2: otherlv_0= KEYWORD_34
        {
        otherlv_0=(Token)match(input,KEYWORD_34,FOLLOW_KEYWORD_34_in_synpred83_InternalWreslEditorParser5891); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred83_InternalWreslEditorParser

    // $ANTLR start synpred84_InternalWreslEditorParser
    public final void synpred84_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2723:2: (otherlv_3= KEYWORD_52 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2723:2: otherlv_3= KEYWORD_52
        {
        otherlv_3=(Token)match(input,KEYWORD_52,FOLLOW_KEYWORD_52_in_synpred84_InternalWreslEditorParser5937); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred84_InternalWreslEditorParser

    // $ANTLR start synpred86_InternalWreslEditorParser
    public final void synpred86_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2774:2: (otherlv_0= KEYWORD_29 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2774:2: otherlv_0= KEYWORD_29
        {
        otherlv_0=(Token)match(input,KEYWORD_29,FOLLOW_KEYWORD_29_in_synpred86_InternalWreslEditorParser6068); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred86_InternalWreslEditorParser

    // $ANTLR start synpred87_InternalWreslEditorParser
    public final void synpred87_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token lv_local_3_1=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2792:3: (lv_local_3_1= KEYWORD_33 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2792:3: lv_local_3_1= KEYWORD_33
        {
        lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_synpred87_InternalWreslEditorParser6120); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred87_InternalWreslEditorParser

    // $ANTLR start synpred90_InternalWreslEditorParser
    public final void synpred90_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2912:2: (otherlv_0= KEYWORD_21 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2912:2: otherlv_0= KEYWORD_21
        {
        otherlv_0=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_synpred90_InternalWreslEditorParser6351); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred90_InternalWreslEditorParser

    // $ANTLR start synpred93_InternalWreslEditorParser
    public final void synpred93_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2999:2: (otherlv_0= KEYWORD_27 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2999:2: otherlv_0= KEYWORD_27
        {
        otherlv_0=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_synpred93_InternalWreslEditorParser6525); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred93_InternalWreslEditorParser

    // $ANTLR start synpred94_InternalWreslEditorParser
    public final void synpred94_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_5=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3051:2: (otherlv_5= KEYWORD_22 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3051:2: otherlv_5= KEYWORD_22
        {
        otherlv_5=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_synpred94_InternalWreslEditorParser6612); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred94_InternalWreslEditorParser

    // $ANTLR start synpred96_InternalWreslEditorParser
    public final void synpred96_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3124:2: (otherlv_0= KEYWORD_22 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3124:2: otherlv_0= KEYWORD_22
        {
        otherlv_0=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_synpred96_InternalWreslEditorParser6769); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred96_InternalWreslEditorParser

    // $ANTLR start synpred101_InternalWreslEditorParser
    public final void synpred101_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3286:2: (otherlv_0= KEYWORD_21 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3286:2: otherlv_0= KEYWORD_21
        {
        otherlv_0=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_synpred101_InternalWreslEditorParser7080); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred101_InternalWreslEditorParser

    // $ANTLR start synpred102_InternalWreslEditorParser
    public final void synpred102_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3302:2: (otherlv_3= KEYWORD_22 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3302:2: otherlv_3= KEYWORD_22
        {
        otherlv_3=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_synpred102_InternalWreslEditorParser7124); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred102_InternalWreslEditorParser

    // $ANTLR start synpred103_InternalWreslEditorParser
    public final void synpred103_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3322:2: (otherlv_6= KEYWORD_50 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3322:2: otherlv_6= KEYWORD_50
        {
        otherlv_6=(Token)match(input,KEYWORD_50,FOLLOW_KEYWORD_50_in_synpred103_InternalWreslEditorParser7170); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred103_InternalWreslEditorParser

    // $ANTLR start synpred105_InternalWreslEditorParser
    public final void synpred105_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3373:2: (otherlv_0= KEYWORD_21 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3373:2: otherlv_0= KEYWORD_21
        {
        otherlv_0=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_synpred105_InternalWreslEditorParser7301); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred105_InternalWreslEditorParser

    // $ANTLR start synpred106_InternalWreslEditorParser
    public final void synpred106_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3389:2: (otherlv_3= KEYWORD_22 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3389:2: otherlv_3= KEYWORD_22
        {
        otherlv_3=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_synpred106_InternalWreslEditorParser7345); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred106_InternalWreslEditorParser

    // $ANTLR start synpred107_InternalWreslEditorParser
    public final void synpred107_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3409:2: (otherlv_6= KEYWORD_50 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3409:2: otherlv_6= KEYWORD_50
        {
        otherlv_6=(Token)match(input,KEYWORD_50,FOLLOW_KEYWORD_50_in_synpred107_InternalWreslEditorParser7391); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred107_InternalWreslEditorParser

    // $ANTLR start synpred109_InternalWreslEditorParser
    public final void synpred109_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3460:2: (otherlv_0= KEYWORD_46 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3460:2: otherlv_0= KEYWORD_46
        {
        otherlv_0=(Token)match(input,KEYWORD_46,FOLLOW_KEYWORD_46_in_synpred109_InternalWreslEditorParser7522); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred109_InternalWreslEditorParser

    // $ANTLR start synpred112_InternalWreslEditorParser
    public final void synpred112_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3651:2: (otherlv_0= KEYWORD_35 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3651:2: otherlv_0= KEYWORD_35
        {
        otherlv_0=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_synpred112_InternalWreslEditorParser7937); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred112_InternalWreslEditorParser

    // $ANTLR start synpred115_InternalWreslEditorParser
    public final void synpred115_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3748:2: (otherlv_0= KEYWORD_44 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3748:2: otherlv_0= KEYWORD_44
        {
        otherlv_0=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_synpred115_InternalWreslEditorParser8136); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred115_InternalWreslEditorParser

    // $ANTLR start synpred116_InternalWreslEditorParser
    public final void synpred116_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_1=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3754:2: (otherlv_1= KEYWORD_44 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3754:2: otherlv_1= KEYWORD_44
        {
        otherlv_1=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_synpred116_InternalWreslEditorParser8154); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred116_InternalWreslEditorParser

    // $ANTLR start synpred118_InternalWreslEditorParser
    public final void synpred118_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3814:2: (otherlv_0= KEYWORD_48 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3814:2: otherlv_0= KEYWORD_48
        {
        otherlv_0=(Token)match(input,KEYWORD_48,FOLLOW_KEYWORD_48_in_synpred118_InternalWreslEditorParser8302); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred118_InternalWreslEditorParser

    // $ANTLR start synpred119_InternalWreslEditorParser
    public final void synpred119_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_4=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3848:2: (otherlv_4= KEYWORD_35 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3848:2: otherlv_4= KEYWORD_35
        {
        otherlv_4=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_synpred119_InternalWreslEditorParser8368); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred119_InternalWreslEditorParser

    // $ANTLR start synpred122_InternalWreslEditorParser
    public final void synpred122_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3941:2: (otherlv_0= KEYWORD_49 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3941:2: otherlv_0= KEYWORD_49
        {
        otherlv_0=(Token)match(input,KEYWORD_49,FOLLOW_KEYWORD_49_in_synpred122_InternalWreslEditorParser8563); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred122_InternalWreslEditorParser

    // $ANTLR start synpred150_InternalWreslEditorParser
    public final void synpred150_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5275:2: (otherlv_0= KEYWORD_43 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5275:2: otherlv_0= KEYWORD_43
        {
        otherlv_0=(Token)match(input,KEYWORD_43,FOLLOW_KEYWORD_43_in_synpred150_InternalWreslEditorParser11805); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred150_InternalWreslEditorParser

    // $ANTLR start synpred151_InternalWreslEditorParser
    public final void synpred151_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token lv_local_3_1=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5293:3: (lv_local_3_1= KEYWORD_33 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5293:3: lv_local_3_1= KEYWORD_33
        {
        lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_synpred151_InternalWreslEditorParser11857); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred151_InternalWreslEditorParser

    // $ANTLR start synpred153_InternalWreslEditorParser
    public final void synpred153_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token kw=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5368:2: (kw= KEYWORD_43 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5368:2: kw= KEYWORD_43
        {
        kw=(Token)match(input,KEYWORD_43,FOLLOW_KEYWORD_43_in_synpred153_InternalWreslEditorParser12021); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred153_InternalWreslEditorParser

    // $ANTLR start synpred154_InternalWreslEditorParser
    public final void synpred154_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token kw=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5381:2: (kw= KEYWORD_35 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5381:2: kw= KEYWORD_35
        {
        kw=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_synpred154_InternalWreslEditorParser12055); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred154_InternalWreslEditorParser

    // Delegated rules

    public final boolean synpred27_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred68_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred68_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred38_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred38_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred151_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred151_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred29_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred29_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred70_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred109_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred109_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred41_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred41_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred66_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred66_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred46_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred46_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred12_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred12_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred69_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred69_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred118_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred118_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred96_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred67_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred55_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred55_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred72_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred72_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred44_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred44_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred116_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred116_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred115_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred115_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred47_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred47_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred23_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred23_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred35_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred35_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred56_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred56_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred87_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred87_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred83_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred83_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred58_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred58_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred60_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred60_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred90_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred90_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred86_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred86_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred37_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred37_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred150_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred150_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred106_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred106_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred63_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred63_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred101_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred101_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred25_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred25_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred43_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred43_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred93_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred93_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred36_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred36_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred122_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred122_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred54_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred54_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred107_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred107_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred94_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred84_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred84_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred45_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred45_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred16_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred16_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred80_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred80_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred153_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred153_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred119_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred119_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred52_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred52_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred154_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred154_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred32_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred32_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred39_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred39_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred103_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred103_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred81_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred81_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA102 dfa102 = new DFA102(this);
    static final String DFA102_eotS =
        "\12\uffff";
    static final String DFA102_eofS =
        "\12\uffff";
    static final String DFA102_minS =
        "\1\7\1\uffff\1\65\1\uffff\1\24\1\67\1\66\1\4\1\105\1\uffff";
    static final String DFA102_maxS =
        "\1\70\1\uffff\1\105\1\uffff\1\24\1\67\1\66\1\44\1\105\1\uffff";
    static final String DFA102_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\5\uffff\1\2";
    static final String DFA102_specialS =
        "\12\uffff}>";
    static final String[] DFA102_transitionS = {
            "\1\3\4\uffff\1\3\3\uffff\1\2\15\uffff\1\3\31\uffff\1\1",
            "",
            "\1\4\17\uffff\1\5",
            "",
            "\1\6",
            "\1\7",
            "\1\10",
            "\1\3\4\uffff\1\3\4\uffff\1\3\2\uffff\1\3\1\11\2\uffff\1\3"+
            "\2\uffff\2\3\2\uffff\1\3\6\uffff\2\3",
            "\1\5",
            ""
    };

    static final short[] DFA102_eot = DFA.unpackEncodedString(DFA102_eotS);
    static final short[] DFA102_eof = DFA.unpackEncodedString(DFA102_eofS);
    static final char[] DFA102_min = DFA.unpackEncodedStringToUnsignedChars(DFA102_minS);
    static final char[] DFA102_max = DFA.unpackEncodedStringToUnsignedChars(DFA102_maxS);
    static final short[] DFA102_accept = DFA.unpackEncodedString(DFA102_acceptS);
    static final short[] DFA102_special = DFA.unpackEncodedString(DFA102_specialS);
    static final short[][] DFA102_transition;

    static {
        int numStates = DFA102_transitionS.length;
        DFA102_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA102_transition[i] = DFA.unpackEncodedString(DFA102_transitionS[i]);
        }
    }

    class DFA102 extends DFA {

        public DFA102(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 102;
            this.eot = DFA102_eot;
            this.eof = DFA102_eof;
            this.min = DFA102_min;
            this.max = DFA102_max;
            this.accept = DFA102_accept;
            this.special = DFA102_special;
            this.transition = DFA102_transition;
        }
        public String getDescription() {
            return "()+ loopback of 3684:1: ( ( (lv_pattern_4_0= rulePattern ) ) | ( (lv_alias_5_0= ruleAlias ) ) )+";
        }
    }
 

    public static final BitSet FOLLOW_ruleWreslEvaluator_in_entryRuleWreslEvaluator73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWreslEvaluator83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlias_in_ruleWreslEvaluator131 = new BitSet(new long[]{0x0000000040011082L});
    public static final BitSet FOLLOW_rulePattern_in_ruleWreslEvaluator150 = new BitSet(new long[]{0x0000000040011082L});
    public static final BitSet FOLLOW_ruleInitial_in_ruleWreslEvaluator182 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ruleSequence_in_ruleWreslEvaluator204 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleModel_in_ruleWreslEvaluator226 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rulePattern_in_entryRulePattern263 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePattern273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefine_in_rulePattern323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeFile_in_rulePattern353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeModel_in_rulePattern377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoal_in_rulePattern407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjective_in_rulePattern437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjective_in_entryRuleObjective471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjective481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_51_in_ruleObjective520 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_51_in_ruleObjective538 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleObjective552 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleObjective572 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleObjective600 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleObjective627 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjective645 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_KEYWORD_9_in_ruleObjective663 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleObjective675 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_ruleWeightItem_in_ruleObjective695 = new BitSet(new long[]{0x0120000000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleObjective709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWeightItem_in_entryRuleWeightItem743 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWeightItem753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleWeightItem791 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWeightItem807 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleWeightItem825 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleWeightItem845 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleWeightItem858 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleWeightItem871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefine_in_entryRuleDefine907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefine917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_40_in_ruleDefine956 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_40_in_ruleDefine974 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleDefine988 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleDefine1008 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleDefine1036 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleDefine1063 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefine1081 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleDefine1099 = new BitSet(new long[]{0x0000001813224210L});
    public static final BitSet FOLLOW_ruleDVar_in_ruleDefine1121 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ruleSVar_in_ruleDefine1140 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ruleDVarInteger_in_ruleDefine1159 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ruleExternal_in_ruleDefine1178 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleDefine1194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternal_in_entryRuleExternal1228 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternal1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_47_in_ruleExternal1277 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_47_in_ruleExternal1295 = new BitSet(new long[]{0x0000000100000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternal1314 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_KEYWORD_26_in_ruleExternal1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_26_in_ruleExternal1351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_20_in_ruleExternal1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_20_in_ruleExternal1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlias_in_entryRuleAlias1440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlias1450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_40_in_ruleAlias1489 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_40_in_ruleAlias1507 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleAlias1521 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleAlias1541 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleAlias1569 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleAlias1596 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAlias1614 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleAlias1632 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_KEYWORD_31_in_ruleAlias1645 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_31_in_ruleAlias1663 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAlias1684 = new BitSet(new long[]{0x0100000080800000L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleAlias1699 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleAlias1717 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAlias1734 = new BitSet(new long[]{0x0100000000800000L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleAlias1756 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleAlias1774 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAlias1791 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleAlias1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVar_in_entryRuleDVar1845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDVar1855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarStd_in_ruleDVar1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarNonStd_in_ruleDVar1935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarNonStd_in_entryRuleDVarNonStd1969 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDVarNonStd1979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLowerAndOrUpper_in_ruleDVarNonStd2025 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarNonStd2039 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarNonStd2057 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarNonStd2074 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarNonStd2093 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarNonStd2111 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarNonStd2128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarStd_in_entryRuleDVarStd2168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDVarStd2178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_23_in_ruleDVarStd2217 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_KEYWORD_23_in_ruleDVarStd2235 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarStd2249 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarStd2267 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarStd2284 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarStd2303 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarStd2321 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarStd2338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarInteger_in_entryRuleDVarInteger2378 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDVarInteger2388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarIntegerStd_in_ruleDVarInteger2438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarIntegerNonStd_in_ruleDVarInteger2468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarIntegerStd_in_entryRuleDVarIntegerStd2502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDVarIntegerStd2512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_45_in_ruleDVarIntegerStd2551 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_KEYWORD_45_in_ruleDVarIntegerStd2569 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_KEYWORD_23_in_ruleDVarIntegerStd2583 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_KEYWORD_23_in_ruleDVarIntegerStd2601 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarIntegerStd2615 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarIntegerStd2633 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarIntegerStd2650 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarIntegerStd2669 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarIntegerStd2687 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarIntegerStd2704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarIntegerNonStd_in_entryRuleDVarIntegerNonStd2744 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDVarIntegerNonStd2754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_45_in_ruleDVarIntegerNonStd2793 = new BitSet(new long[]{0x0000000801200000L});
    public static final BitSet FOLLOW_KEYWORD_45_in_ruleDVarIntegerNonStd2811 = new BitSet(new long[]{0x0000000801200000L});
    public static final BitSet FOLLOW_ruleLowerAndOrUpper_in_ruleDVarIntegerNonStd2836 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarIntegerNonStd2849 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarIntegerNonStd2867 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarIntegerNonStd2884 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarIntegerNonStd2903 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarIntegerNonStd2921 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarIntegerNonStd2938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVar_in_entryRuleSVar2978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSVar2988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarDSS_in_ruleSVar3038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarExpression_in_ruleSVar3068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarSum_in_ruleSVar3098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarTable_in_ruleSVar3128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarCase_in_ruleSVar3158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarDSS_in_entryRuleSVarDSS3192 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSVarDSS3202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_53_in_ruleSVarDSS3241 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_53_in_ruleSVarDSS3259 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSVarDSS3276 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleSVarDSS3296 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleSVarDSS3314 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSVarDSS3331 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleSVarDSS3350 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleSVarDSS3368 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSVarDSS3385 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_KEYWORD_42_in_ruleSVarDSS3405 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_42_in_ruleSVarDSS3423 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSVarDSS3440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarExpression_in_entryRuleSVarExpression3482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSVarExpression3492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_38_in_ruleSVarExpression3531 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_38_in_ruleSVarExpression3549 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSVarExpression3570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarSum_in_entryRuleSVarSum3605 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSVarSum3615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSumContent_in_ruleSVarSum3660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarTable_in_entryRuleSVarTable3694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSVarTable3704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableContent_in_ruleSVarTable3749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarCase_in_entryRuleSVarCase3783 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSVarCase3793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseContent_in_ruleSVarCase3838 = new BitSet(new long[]{0x0000001012020012L});
    public static final BitSet FOLLOW_ruleCaseContent_in_entryRuleCaseContent3873 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCaseContent3883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_27_in_ruleCaseContent3922 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_27_in_ruleCaseContent3940 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCaseContent3957 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleCaseContent3975 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCondition_in_ruleCaseContent3995 = new BitSet(new long[]{0x0000001002020000L});
    public static final BitSet FOLLOW_ruleTableContent_in_ruleCaseContent4017 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ruleValueContent_in_ruleCaseContent4044 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ruleSumContent_in_ruleCaseContent4071 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleCaseContent4085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSumContent_in_entryRuleSumContent4119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSumContent4129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_24_in_ruleSumContent4168 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_KEYWORD_24_in_ruleSumContent4186 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_ruleSumHeader_in_ruleSumContent4207 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSumContent4228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSumHeader_in_entryRuleSumHeader4263 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSumHeader4273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleSumHeader4311 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_KEYWORD_19_in_ruleSumHeader4323 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSumHeader4343 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleSumHeader4356 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSumHeader4376 = new BitSet(new long[]{0x0000900000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleSumHeader4390 = new BitSet(new long[]{0x1001000000000000L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleSumHeader4403 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSumHeader4415 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleSumHeader4429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueContent_in_entryRuleValueContent4463 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueContent4473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_38_in_ruleValueContent4512 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_38_in_ruleValueContent4530 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueContent4551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableContent_in_entryRuleTableContent4586 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableContent4596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_41_in_ruleTableContent4635 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_41_in_ruleTableContent4653 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTableContent4670 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_KEYWORD_28_in_ruleTableContent4689 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_28_in_ruleTableContent4707 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTableContent4724 = new BitSet(new long[]{0x0000000004080002L});
    public static final BitSet FOLLOW_KEYWORD_32_in_ruleTableContent4744 = new BitSet(new long[]{0x3C00000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_32_in_ruleTableContent4762 = new BitSet(new long[]{0x3C00000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleTableContent4783 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_KEYWORD_25_in_ruleTableContent4797 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_25_in_ruleTableContent4815 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTableContent4832 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_KEYWORD_39_in_ruleTableContent4854 = new BitSet(new long[]{0x3C00000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_39_in_ruleTableContent4872 = new BitSet(new long[]{0x3C00000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleWhereItems_in_ruleTableContent4893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereItems_in_entryRuleWhereItems4930 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhereItems4940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleWhereItems4986 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleWhereItems5000 = new BitSet(new long[]{0x3C00000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleWhereItems5020 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment5057 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment5067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTermSimple_in_ruleAssignment5113 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_KEYWORD_9_in_ruleAssignment5126 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssignment5146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTermSimple_in_entryRuleTermSimple5181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTermSimple5191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTermSimple5227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleTermSimple5251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleTermSimple5281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLowerAndOrUpper_in_entryRuleLowerAndOrUpper5315 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLowerAndOrUpper5325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelowerUpper_in_ruleLowerAndOrUpper5375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleupperLower_in_ruleLowerAndOrUpper5405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleupperLower_in_entryRuleupperLower5439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleupperLower5449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpper_in_ruleupperLower5495 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleLower_in_ruleupperLower5516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelowerUpper_in_entryRulelowerUpper5552 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulelowerUpper5562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLower_in_rulelowerUpper5608 = new BitSet(new long[]{0x0000000801200002L});
    public static final BitSet FOLLOW_ruleUpper_in_rulelowerUpper5629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpper_in_entryRuleUpper5665 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpper5675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_37_in_ruleUpper5714 = new BitSet(new long[]{0x3C01480000000100L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_37_in_ruleUpper5732 = new BitSet(new long[]{0x3C01480000000100L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_52_in_ruleUpper5760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_52_in_ruleUpper5778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleUpper5806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLower_in_entryRuleLower5842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLower5852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_34_in_ruleLower5891 = new BitSet(new long[]{0x3C01480000000100L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_34_in_ruleLower5909 = new BitSet(new long[]{0x3C01480000000100L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_52_in_ruleLower5937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_52_in_ruleLower5955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLower5983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoal_in_entryRuleGoal6019 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoal6029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_29_in_ruleGoal6068 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_29_in_ruleGoal6086 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleGoal6100 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleGoal6120 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleGoal6148 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleGoal6175 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal6193 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleGoal6211 = new BitSet(new long[]{0x3C01480200000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleGoalSimple_in_ruleGoal6233 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_ruleGoalCase_in_ruleGoal6252 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleGoal6268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoalCase_in_entryRuleGoalCase6302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoalCase6312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleGoalCase6351 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleGoalCase6369 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleGoalCase6390 = new BitSet(new long[]{0x0000000410000000L});
    public static final BitSet FOLLOW_ruleGoalNoCaseContent_in_ruleGoalCase6412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoalCaseContent_in_ruleGoalCase6439 = new BitSet(new long[]{0x0000000410000002L});
    public static final BitSet FOLLOW_ruleGoalCaseContent_in_entryRuleGoalCaseContent6476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoalCaseContent6486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_27_in_ruleGoalCaseContent6525 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_27_in_ruleGoalCaseContent6543 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoalCaseContent6560 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleGoalCaseContent6578 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCondition_in_ruleGoalCaseContent6598 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleGoalCaseContent6612 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleGoalCaseContent6630 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleGoalCaseContent6651 = new BitSet(new long[]{0x0100000200000000L});
    public static final BitSet FOLLOW_ruleSubContent_in_ruleGoalCaseContent6672 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleGoalCaseContent6686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoalNoCaseContent_in_entryRuleGoalNoCaseContent6720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoalNoCaseContent6730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleGoalNoCaseContent6769 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleGoalNoCaseContent6787 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleGoalNoCaseContent6808 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleSubContent_in_ruleGoalNoCaseContent6829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubContent_in_entryRuleSubContent6865 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubContent6875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLhsGtRhs_in_ruleSubContent6922 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleLhsLtRhs_in_ruleSubContent6943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLhsLtRhs_in_ruleSubContent6973 = new BitSet(new long[]{0x0000000200000002L});
    public static final BitSet FOLLOW_ruleLhsGtRhs_in_ruleSubContent6994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLhsGtRhs_in_entryRuleLhsGtRhs7031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLhsGtRhs7041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleLhsGtRhs7080 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleLhsGtRhs7098 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleLhsGtRhs7111 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleLhsGtRhs7124 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleLhsGtRhs7142 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_KEYWORD_50_in_ruleLhsGtRhs7170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_50_in_ruleLhsGtRhs7188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePenalty_in_ruleLhsGtRhs7216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLhsLtRhs_in_entryRuleLhsLtRhs7252 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLhsLtRhs7262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleLhsLtRhs7301 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleLhsLtRhs7319 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleLhsLtRhs7332 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleLhsLtRhs7345 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleLhsLtRhs7363 = new BitSet(new long[]{0x0000000000008040L});
    public static final BitSet FOLLOW_KEYWORD_50_in_ruleLhsLtRhs7391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_50_in_ruleLhsLtRhs7409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePenalty_in_ruleLhsLtRhs7437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePenalty_in_entryRulePenalty7473 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePenalty7483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_46_in_rulePenalty7522 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_46_in_rulePenalty7540 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePenalty7561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoalSimple_in_entryRuleGoalSimple7596 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoalSimple7606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_ruleGoalSimple7651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_entryRuleConstraint7685 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraint7695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConstraint7741 = new BitSet(new long[]{0x001C000000000000L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleConstraint7762 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleConstraint7790 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_9_in_ruleConstraint7818 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConstraint7853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel7888 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel7898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_35_in_ruleModel7937 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_35_in_ruleModel7955 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel7972 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleModel7990 = new BitSet(new long[]{0x0100000040011080L});
    public static final BitSet FOLLOW_rulePattern_in_ruleModel8011 = new BitSet(new long[]{0x0100000040011080L});
    public static final BitSet FOLLOW_ruleAlias_in_ruleModel8038 = new BitSet(new long[]{0x0100000040011080L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleModel8053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInitial_in_entryRuleInitial8087 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInitial8097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_44_in_ruleInitial8136 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_44_in_ruleInitial8154 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_44_in_ruleInitial8172 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleInitial8185 = new BitSet(new long[]{0x0100000040011080L});
    public static final BitSet FOLLOW_rulePattern_in_ruleInitial8205 = new BitSet(new long[]{0x0100000040011080L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleInitial8219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_entryRuleSequence8253 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequence8263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_48_in_ruleSequence8302 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_48_in_ruleSequence8320 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSequence8337 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleSequence8355 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_KEYWORD_35_in_ruleSequence8368 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_35_in_ruleSequence8386 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSequence8410 = new BitSet(new long[]{0x0100000000000020L,0x0000000000000004L});
    public static final BitSet FOLLOW_ruleCondition_in_ruleSequence8431 = new BitSet(new long[]{0x0100000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_ORDER_in_ruleSequence8444 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSequence8460 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleSequence8480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondition_in_entryRuleCondition8514 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCondition8524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_49_in_ruleCondition8563 = new BitSet(new long[]{0x3E01480000000000L,0x0000000000000023L});
    public static final BitSet FOLLOW_KEYWORD_49_in_ruleCondition8581 = new BitSet(new long[]{0x3E01480000000000L,0x0000000000000023L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleCondition8603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ALWAYS_in_ruleCondition8633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression8669 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression8679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalUnary_in_ruleLogicalExpression8725 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_ruleBinaryOp_in_ruleLogicalExpression8745 = new BitSet(new long[]{0x3E01480000000000L,0x0000000000000021L});
    public static final BitSet FOLLOW_ruleConditionalUnary_in_ruleLogicalExpression8765 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_ruleBinaryOp_in_entryRuleBinaryOp8803 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOp8814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OR_in_ruleBinaryOp8854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_AND_in_ruleBinaryOp8880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalUnary_in_entryRuleConditionalUnary8924 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalUnary8934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalNegation_in_ruleConditionalUnary8979 = new BitSet(new long[]{0x3E01480000000000L,0x0000000000000021L});
    public static final BitSet FOLLOW_ruleConditionalTerm_in_ruleConditionalUnary9005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalNegation_in_entryRuleConditionalNegation9040 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalNegation9051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NOT_in_ruleConditionalNegation9090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalTerm_in_entryRuleConditionalTerm9133 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalTerm9143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalTerm9190 = new BitSet(new long[]{0x001403C000000000L});
    public static final BitSet FOLLOW_ruleRelation_in_ruleConditionalTerm9209 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalTerm9229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalFunction_in_ruleConditionalTerm9255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelation_in_entryRuleRelation9290 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelation9301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleRelation9339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleRelation9358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_18_in_ruleRelation9377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_16_in_ruleRelation9396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_17_in_ruleRelation9415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_15_in_ruleRelation9434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression9473 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression9483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdd_in_ruleExpression9532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdd_in_entryRuleAdd9565 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdd9575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiply_in_ruleAdd9621 = new BitSet(new long[]{0x0001400000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleAdd9636 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleAdd9654 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleMultiply_in_ruleAdd9675 = new BitSet(new long[]{0x0001400000000002L});
    public static final BitSet FOLLOW_ruleMultiply_in_entryRuleMultiply9712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiply9722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleMultiply9768 = new BitSet(new long[]{0x0002200000000002L});
    public static final BitSet FOLLOW_KEYWORD_3_in_ruleMultiply9783 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_7_in_ruleMultiply9801 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleMultiply9822 = new BitSet(new long[]{0x0002200000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_entryRuleUnary9859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnary9869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleUnary9908 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleNegation_in_ruleUnary9932 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleUnary9958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_entryRuleNegation9993 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegation10004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleNegation10041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm10079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm10089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdent_in_ruleTerm10135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleTerm10162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleTerm10189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleTerm10209 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleTerm10229 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleTerm10242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction10277 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction10287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalFunction_in_ruleFunction10337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMaxFunction_in_ruleFunction10367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMinFunction_in_ruleFunction10397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntFunction_in_ruleFunction10427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarModel_in_ruleFunction10451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalFunction_in_entryRuleExternalFunction10485 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalFunction10495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalFunction10531 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleExternalFunction10543 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExternalFunction10563 = new BitSet(new long[]{0x0000900000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleExternalFunction10577 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExternalFunction10597 = new BitSet(new long[]{0x0000900000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleExternalFunction10612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMaxFunction_in_entryRuleMaxFunction10646 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMaxFunction10656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MAX_in_ruleMaxFunction10692 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleMaxFunction10704 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleMaxFunction10724 = new BitSet(new long[]{0x0000900000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleMaxFunction10738 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleMaxFunction10758 = new BitSet(new long[]{0x0000900000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleMaxFunction10773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMinFunction_in_entryRuleMinFunction10807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMinFunction10817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MIN_in_ruleMinFunction10853 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleMinFunction10865 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleMinFunction10885 = new BitSet(new long[]{0x0000900000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleMinFunction10899 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleMinFunction10919 = new BitSet(new long[]{0x0000900000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleMinFunction10934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntFunction_in_entryRuleIntFunction10968 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntFunction10978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntFunction11014 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleIntFunction11026 = new BitSet(new long[]{0x3C01480000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIntFunction11046 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleIntFunction11059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalFunction_in_entryRuleLogicalFunction11094 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalFunction11105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeFunction_in_ruleLogicalFunction11151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarModel_in_entryRuleVarModel11195 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarModel11206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarModel11246 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleVarModel11264 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarModel11279 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleVarModel11297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeFunction_in_entryRuleRangeFunction11337 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeFunction11348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RANGE_in_ruleRangeFunction11388 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleRangeFunction11406 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRangeFunction11421 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleRangeFunction11439 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRangeFunction11454 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleRangeFunction11472 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRangeFunction11487 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleRangeFunction11505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdent_in_entryRuleIdent11544 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdent11554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdent11595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_entryRuleNumber11635 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumber11646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber11686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_FLOAT_in_ruleNumber11712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeFile_in_entryRuleIncludeFile11756 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeFile11766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_43_in_ruleIncludeFile11805 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_43_in_ruleIncludeFile11823 = new BitSet(new long[]{0x0020000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleIncludeFile11837 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleIncludeFile11857 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleIncludeFile11885 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleIncludeFile11912 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIncludeFile11930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeModel_in_entryRuleIncludeModel11971 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeModel11982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_43_in_ruleIncludeModel12021 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_KEYWORD_43_in_ruleIncludeModel12040 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_KEYWORD_35_in_ruleIncludeModel12055 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_KEYWORD_35_in_ruleIncludeModel12074 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIncludeModel12090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_51_in_synpred11_InternalWreslEditorParser520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_33_in_synpred12_InternalWreslEditorParser572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_40_in_synpred16_InternalWreslEditorParser956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_33_in_synpred17_InternalWreslEditorParser1008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_47_in_synpred22_InternalWreslEditorParser1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_26_in_synpred23_InternalWreslEditorParser1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_20_in_synpred25_InternalWreslEditorParser1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_40_in_synpred26_InternalWreslEditorParser1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_33_in_synpred27_InternalWreslEditorParser1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_31_in_synpred29_InternalWreslEditorParser1645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_30_in_synpred30_InternalWreslEditorParser1699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_synpred32_InternalWreslEditorParser1756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_30_in_synpred35_InternalWreslEditorParser2039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_synpred36_InternalWreslEditorParser2093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_23_in_synpred37_InternalWreslEditorParser2217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_30_in_synpred38_InternalWreslEditorParser2249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_synpred39_InternalWreslEditorParser2303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_45_in_synpred41_InternalWreslEditorParser2551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_23_in_synpred42_InternalWreslEditorParser2583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_30_in_synpred43_InternalWreslEditorParser2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_synpred44_InternalWreslEditorParser2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_45_in_synpred45_InternalWreslEditorParser2793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_30_in_synpred46_InternalWreslEditorParser2849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_synpred47_InternalWreslEditorParser2903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_53_in_synpred52_InternalWreslEditorParser3241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_30_in_synpred54_InternalWreslEditorParser3296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_synpred55_InternalWreslEditorParser3350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_42_in_synpred56_InternalWreslEditorParser3405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_38_in_synpred58_InternalWreslEditorParser3531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_27_in_synpred60_InternalWreslEditorParser3922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_24_in_synpred63_InternalWreslEditorParser4168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_38_in_synpred66_InternalWreslEditorParser4512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_41_in_synpred67_InternalWreslEditorParser4635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_28_in_synpred68_InternalWreslEditorParser4689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_32_in_synpred69_InternalWreslEditorParser4744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_25_in_synpred70_InternalWreslEditorParser4797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_39_in_synpred72_InternalWreslEditorParser4854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_37_in_synpred80_InternalWreslEditorParser5714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_52_in_synpred81_InternalWreslEditorParser5760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_34_in_synpred83_InternalWreslEditorParser5891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_52_in_synpred84_InternalWreslEditorParser5937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_29_in_synpred86_InternalWreslEditorParser6068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_33_in_synpred87_InternalWreslEditorParser6120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_synpred90_InternalWreslEditorParser6351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_27_in_synpred93_InternalWreslEditorParser6525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_22_in_synpred94_InternalWreslEditorParser6612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_22_in_synpred96_InternalWreslEditorParser6769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_synpred101_InternalWreslEditorParser7080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_22_in_synpred102_InternalWreslEditorParser7124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_50_in_synpred103_InternalWreslEditorParser7170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_synpred105_InternalWreslEditorParser7301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_22_in_synpred106_InternalWreslEditorParser7345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_50_in_synpred107_InternalWreslEditorParser7391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_46_in_synpred109_InternalWreslEditorParser7522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_35_in_synpred112_InternalWreslEditorParser7937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_44_in_synpred115_InternalWreslEditorParser8136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_44_in_synpred116_InternalWreslEditorParser8154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_48_in_synpred118_InternalWreslEditorParser8302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_35_in_synpred119_InternalWreslEditorParser8368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_49_in_synpred122_InternalWreslEditorParser8563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_43_in_synpred150_InternalWreslEditorParser11805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_33_in_synpred151_InternalWreslEditorParser11857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_43_in_synpred153_InternalWreslEditorParser12021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_35_in_synpred154_InternalWreslEditorParser12055 = new BitSet(new long[]{0x0000000000000002L});

}