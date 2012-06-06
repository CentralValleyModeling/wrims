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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_52", "KEYWORD_48", "KEYWORD_49", "KEYWORD_50", "KEYWORD_51", "KEYWORD_46", "KEYWORD_47", "KEYWORD_42", "KEYWORD_43", "KEYWORD_44", "KEYWORD_45", "KEYWORD_40", "KEYWORD_41", "KEYWORD_31", "KEYWORD_32", "KEYWORD_33", "KEYWORD_34", "KEYWORD_35", "KEYWORD_36", "KEYWORD_37", "KEYWORD_38", "KEYWORD_39", "KEYWORD_26", "KEYWORD_27", "KEYWORD_28", "KEYWORD_29", "KEYWORD_30", "KEYWORD_20", "KEYWORD_21", "KEYWORD_22", "KEYWORD_23", "KEYWORD_24", "KEYWORD_25", "KEYWORD_15", "KEYWORD_16", "KEYWORD_17", "KEYWORD_18", "KEYWORD_19", "KEYWORD_1", "KEYWORD_2", "KEYWORD_3", "KEYWORD_4", "KEYWORD_5", "KEYWORD_6", "KEYWORD_7", "KEYWORD_8", "KEYWORD_9", "KEYWORD_10", "KEYWORD_11", "KEYWORD_12", "KEYWORD_13", "KEYWORD_14", "RULE_RANGE", "RULE_MIN", "RULE_MAX", "RULE_INT", "RULE_FLOAT", "RULE_AND", "RULE_OR", "RULE_NOT", "RULE_ALWAYS", "RULE_ORDER", "RULE_STRING", "RULE_SL_COMMENT", "RULE_ID", "RULE_ML_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=68;
    public static final int RULE_ANY_OTHER=71;
    public static final int RULE_OR=62;
    public static final int KEYWORD_19=41;
    public static final int KEYWORD_17=39;
    public static final int RULE_MAX=58;
    public static final int KEYWORD_18=40;
    public static final int KEYWORD_15=37;
    public static final int KEYWORD_52=4;
    public static final int RULE_AND=61;
    public static final int KEYWORD_16=38;
    public static final int KEYWORD_51=8;
    public static final int KEYWORD_50=7;
    public static final int KEYWORD_13=54;
    public static final int KEYWORD_14=55;
    public static final int KEYWORD_11=52;
    public static final int EOF=-1;
    public static final int KEYWORD_12=53;
    public static final int RULE_NOT=63;
    public static final int KEYWORD_10=51;
    public static final int KEYWORD_6=47;
    public static final int KEYWORD_7=48;
    public static final int KEYWORD_8=49;
    public static final int KEYWORD_9=50;
    public static final int KEYWORD_28=28;
    public static final int KEYWORD_29=29;
    public static final int RULE_INT=59;
    public static final int KEYWORD_24=35;
    public static final int KEYWORD_25=36;
    public static final int KEYWORD_26=26;
    public static final int KEYWORD_27=27;
    public static final int KEYWORD_20=31;
    public static final int KEYWORD_21=32;
    public static final int KEYWORD_22=33;
    public static final int KEYWORD_23=34;
    public static final int RULE_ORDER=65;
    public static final int RULE_MIN=57;
    public static final int KEYWORD_30=30;
    public static final int KEYWORD_1=42;
    public static final int KEYWORD_5=46;
    public static final int KEYWORD_34=20;
    public static final int KEYWORD_33=19;
    public static final int KEYWORD_4=45;
    public static final int KEYWORD_32=18;
    public static final int KEYWORD_3=44;
    public static final int KEYWORD_2=43;
    public static final int KEYWORD_31=17;
    public static final int KEYWORD_38=24;
    public static final int RULE_FLOAT=60;
    public static final int KEYWORD_37=23;
    public static final int RULE_SL_COMMENT=67;
    public static final int KEYWORD_36=22;
    public static final int KEYWORD_35=21;
    public static final int RULE_RANGE=56;
    public static final int RULE_ML_COMMENT=69;
    public static final int KEYWORD_39=25;
    public static final int RULE_STRING=66;
    public static final int KEYWORD_41=16;
    public static final int RULE_ALWAYS=64;
    public static final int KEYWORD_40=15;
    public static final int KEYWORD_43=12;
    public static final int KEYWORD_42=11;
    public static final int KEYWORD_45=14;
    public static final int KEYWORD_44=13;
    public static final int KEYWORD_47=10;
    public static final int RULE_WS=70;
    public static final int KEYWORD_46=9;
    public static final int KEYWORD_49=6;
    public static final int KEYWORD_48=5;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:76:1: ruleWreslEvaluator returns [EObject current=null] : ( ( ( (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern ) ) )+ | ( ( (lv_sequence_1_0= ruleSequence ) )+ ( (lv_model_2_0= ruleModel ) )+ ) ) ;
    public final EObject ruleWreslEvaluator() throws RecognitionException {
        EObject current = null;

        EObject lv_pattern_0_1 = null;

        EObject lv_pattern_0_2 = null;

        EObject lv_sequence_1_0 = null;

        EObject lv_model_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:79:28: ( ( ( ( (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern ) ) )+ | ( ( (lv_sequence_1_0= ruleSequence ) )+ ( (lv_model_2_0= ruleModel ) )+ ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:80:1: ( ( ( (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern ) ) )+ | ( ( (lv_sequence_1_0= ruleSequence ) )+ ( (lv_model_2_0= ruleModel ) )+ ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:80:1: ( ( ( (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern ) ) )+ | ( ( (lv_sequence_1_0= ruleSequence ) )+ ( (lv_model_2_0= ruleModel ) )+ ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==KEYWORD_50||LA5_0==KEYWORD_43||LA5_0==KEYWORD_40||LA5_0==KEYWORD_29) ) {
                alt5=1;
            }
            else if ( (LA5_0==KEYWORD_47) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:80:2: ( ( (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern ) ) )+
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:80:2: ( ( (lv_pattern_0_1= ruleAlias | lv_pattern_0_2= rulePattern ) ) )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==KEYWORD_50||LA2_0==KEYWORD_43||LA2_0==KEYWORD_40||LA2_0==KEYWORD_29) ) {
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

                    	                            if ( (LA1_6==KEYWORD_52||LA1_6==KEYWORD_46||LA1_6==KEYWORD_44||LA1_6==KEYWORD_41||LA1_6==KEYWORD_34||(LA1_6>=KEYWORD_37 && LA1_6<=KEYWORD_38)||LA1_6==KEYWORD_27||(LA1_6>=KEYWORD_23 && LA1_6<=KEYWORD_24)) ) {
                    	                                alt1=2;
                    	                            }
                    	                            else if ( (LA1_6==KEYWORD_31) ) {
                    	                                alt1=1;
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

                    	                if ( (LA1_6==KEYWORD_52||LA1_6==KEYWORD_46||LA1_6==KEYWORD_44||LA1_6==KEYWORD_41||LA1_6==KEYWORD_34||(LA1_6>=KEYWORD_37 && LA1_6<=KEYWORD_38)||LA1_6==KEYWORD_27||(LA1_6>=KEYWORD_23 && LA1_6<=KEYWORD_24)) ) {
                    	                    alt1=2;
                    	                }
                    	                else if ( (LA1_6==KEYWORD_31) ) {
                    	                    alt1=1;
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
                    	    else if ( (LA1_0==KEYWORD_50||LA1_0==KEYWORD_43||LA1_0==KEYWORD_29) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:117:6: ( ( (lv_sequence_1_0= ruleSequence ) )+ ( (lv_model_2_0= ruleModel ) )+ )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:117:6: ( ( (lv_sequence_1_0= ruleSequence ) )+ ( (lv_model_2_0= ruleModel ) )+ )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:117:7: ( (lv_sequence_1_0= ruleSequence ) )+ ( (lv_model_2_0= ruleModel ) )+
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:117:7: ( (lv_sequence_1_0= ruleSequence ) )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==KEYWORD_47) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:118:1: (lv_sequence_1_0= ruleSequence )
                    	    {
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:118:1: (lv_sequence_1_0= ruleSequence )
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:119:3: lv_sequence_1_0= ruleSequence
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getWreslEvaluatorAccess().getSequenceSequenceParserRuleCall_1_0_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleSequence_in_ruleWreslEvaluator182);
                    	    lv_sequence_1_0=ruleSequence();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getWreslEvaluatorRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"sequence",
                    	              		lv_sequence_1_0, 
                    	              		"Sequence");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:135:3: ( (lv_model_2_0= ruleModel ) )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==KEYWORD_35) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:136:1: (lv_model_2_0= ruleModel )
                    	    {
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:136:1: (lv_model_2_0= ruleModel )
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:137:3: lv_model_2_0= ruleModel
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getWreslEvaluatorAccess().getModelModelParserRuleCall_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleModel_in_ruleWreslEvaluator204);
                    	    lv_model_2_0=ruleModel();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getWreslEvaluatorRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"model",
                    	              		lv_model_2_0, 
                    	              		"Model");
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:161:1: entryRulePattern returns [EObject current=null] : iv_rulePattern= rulePattern EOF ;
    public final EObject entryRulePattern() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePattern = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:162:2: (iv_rulePattern= rulePattern EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:163:2: iv_rulePattern= rulePattern EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPatternRule()); 
            }
            pushFollow(FOLLOW_rulePattern_in_entryRulePattern241);
            iv_rulePattern=rulePattern();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePattern; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePattern251); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:170:1: rulePattern returns [EObject current=null] : (this_Define_0= ruleDefine | this_IncludeFile_1= ruleIncludeFile | this_Goal_2= ruleGoal | this_Objective_3= ruleObjective ) ;
    public final EObject rulePattern() throws RecognitionException {
        EObject current = null;

        EObject this_Define_0 = null;

        EObject this_IncludeFile_1 = null;

        EObject this_Goal_2 = null;

        EObject this_Objective_3 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:173:28: ( (this_Define_0= ruleDefine | this_IncludeFile_1= ruleIncludeFile | this_Goal_2= ruleGoal | this_Objective_3= ruleObjective ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:174:1: (this_Define_0= ruleDefine | this_IncludeFile_1= ruleIncludeFile | this_Goal_2= ruleGoal | this_Objective_3= ruleObjective )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:174:1: (this_Define_0= ruleDefine | this_IncludeFile_1= ruleIncludeFile | this_Goal_2= ruleGoal | this_Objective_3= ruleObjective )
            int alt6=4;
            switch ( input.LA(1) ) {
            case KEYWORD_40:
                {
                alt6=1;
                }
                break;
            case KEYWORD_43:
                {
                alt6=2;
                }
                break;
            case KEYWORD_29:
                {
                alt6=3;
                }
                break;
            case KEYWORD_50:
                {
                alt6=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:175:2: this_Define_0= ruleDefine
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatternAccess().getDefineParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDefine_in_rulePattern301);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:188:2: this_IncludeFile_1= ruleIncludeFile
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatternAccess().getIncludeFileParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIncludeFile_in_rulePattern331);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:201:2: this_Goal_2= ruleGoal
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatternAccess().getGoalParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleGoal_in_rulePattern361);
                    this_Goal_2=ruleGoal();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Goal_2;
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:214:2: this_Objective_3= ruleObjective
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getPatternAccess().getObjectiveParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleObjective_in_rulePattern391);
                    this_Objective_3=ruleObjective();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = this_Objective_3;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:233:1: entryRuleObjective returns [EObject current=null] : iv_ruleObjective= ruleObjective EOF ;
    public final EObject entryRuleObjective() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjective = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:234:2: (iv_ruleObjective= ruleObjective EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:235:2: iv_ruleObjective= ruleObjective EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getObjectiveRule()); 
            }
            pushFollow(FOLLOW_ruleObjective_in_entryRuleObjective425);
            iv_ruleObjective=ruleObjective();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleObjective; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleObjective435); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:242:1: ruleObjective returns [EObject current=null] : ( (otherlv_0= KEYWORD_50 | otherlv_1= KEYWORD_50 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_9 otherlv_7= KEYWORD_13 ( (lv_weights_8_0= ruleWeightItem ) )+ otherlv_9= KEYWORD_14 ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:245:28: ( ( (otherlv_0= KEYWORD_50 | otherlv_1= KEYWORD_50 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_9 otherlv_7= KEYWORD_13 ( (lv_weights_8_0= ruleWeightItem ) )+ otherlv_9= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:246:1: ( (otherlv_0= KEYWORD_50 | otherlv_1= KEYWORD_50 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_9 otherlv_7= KEYWORD_13 ( (lv_weights_8_0= ruleWeightItem ) )+ otherlv_9= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:246:1: ( (otherlv_0= KEYWORD_50 | otherlv_1= KEYWORD_50 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_9 otherlv_7= KEYWORD_13 ( (lv_weights_8_0= ruleWeightItem ) )+ otherlv_9= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:246:2: (otherlv_0= KEYWORD_50 | otherlv_1= KEYWORD_50 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_9 otherlv_7= KEYWORD_13 ( (lv_weights_8_0= ruleWeightItem ) )+ otherlv_9= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:246:2: (otherlv_0= KEYWORD_50 | otherlv_1= KEYWORD_50 )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==KEYWORD_50) ) {
                int LA7_1 = input.LA(2);

                if ( (synpred9_InternalWreslEditorParser()) ) {
                    alt7=1;
                }
                else if ( (true) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:247:2: otherlv_0= KEYWORD_50
                    {
                    otherlv_0=(Token)match(input,KEYWORD_50,FOLLOW_KEYWORD_50_in_ruleObjective474); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getObjectiveAccess().getObjectiveKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:253:2: otherlv_1= KEYWORD_50
                    {
                    otherlv_1=(Token)match(input,KEYWORD_50,FOLLOW_KEYWORD_50_in_ruleObjective492); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getObjectiveAccess().getOBJECTIVEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:257:2: (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==KEYWORD_11) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:258:2: otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12
                    {
                    otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleObjective506); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getObjectiveAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:262:1: ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:263:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:263:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:264:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:264:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==KEYWORD_33) ) {
                        int LA8_1 = input.LA(2);

                        if ( (synpred10_InternalWreslEditorParser()) ) {
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:265:3: lv_local_3_1= KEYWORD_33
                            {
                            lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleObjective526); if (state.failed) return current;
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:278:8: lv_local_3_2= KEYWORD_33
                            {
                            lv_local_3_2=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleObjective554); if (state.failed) return current;
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

                    otherlv_4=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleObjective581); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getObjectiveAccess().getRightSquareBracketKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:299:3: ( (lv_name_5_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:300:1: (lv_name_5_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:300:1: (lv_name_5_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:301:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleObjective599); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_ruleObjective617); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getObjectiveAccess().getEqualsSignKeyword_3());
                  
            }
            otherlv_7=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleObjective629); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getObjectiveAccess().getLeftCurlyBracketKeyword_4());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:327:1: ( (lv_weights_8_0= ruleWeightItem ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==KEYWORD_11) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:328:1: (lv_weights_8_0= ruleWeightItem )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:328:1: (lv_weights_8_0= ruleWeightItem )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:329:3: lv_weights_8_0= ruleWeightItem
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getObjectiveAccess().getWeightsWeightItemParserRuleCall_5_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleWeightItem_in_ruleObjective649);
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
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            otherlv_9=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleObjective663); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:358:1: entryRuleWeightItem returns [EObject current=null] : iv_ruleWeightItem= ruleWeightItem EOF ;
    public final EObject entryRuleWeightItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWeightItem = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:359:2: (iv_ruleWeightItem= ruleWeightItem EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:360:2: iv_ruleWeightItem= ruleWeightItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWeightItemRule()); 
            }
            pushFollow(FOLLOW_ruleWeightItem_in_entryRuleWeightItem697);
            iv_ruleWeightItem=ruleWeightItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWeightItem; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWeightItem707); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:367:1: ruleWeightItem returns [EObject current=null] : (otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) ) otherlv_2= KEYWORD_5 ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= KEYWORD_12 (otherlv_5= KEYWORD_5 )? ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:370:28: ( (otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) ) otherlv_2= KEYWORD_5 ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= KEYWORD_12 (otherlv_5= KEYWORD_5 )? ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:371:1: (otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) ) otherlv_2= KEYWORD_5 ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= KEYWORD_12 (otherlv_5= KEYWORD_5 )? )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:371:1: (otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) ) otherlv_2= KEYWORD_5 ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= KEYWORD_12 (otherlv_5= KEYWORD_5 )? )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:372:2: otherlv_0= KEYWORD_11 ( (lv_name_1_0= RULE_ID ) ) otherlv_2= KEYWORD_5 ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= KEYWORD_12 (otherlv_5= KEYWORD_5 )?
            {
            otherlv_0=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleWeightItem745); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getWeightItemAccess().getLeftSquareBracketKeyword_0());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:376:1: ( (lv_name_1_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:377:1: (lv_name_1_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:377:1: (lv_name_1_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:378:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleWeightItem761); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleWeightItem779); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getWeightItemAccess().getCommaKeyword_2());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:399:1: ( (lv_expression_3_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:400:1: (lv_expression_3_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:400:1: (lv_expression_3_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:401:3: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getWeightItemAccess().getExpressionExpressionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleWeightItem799);
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

            otherlv_4=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleWeightItem812); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getWeightItemAccess().getRightSquareBracketKeyword_4());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:422:1: (otherlv_5= KEYWORD_5 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==KEYWORD_5) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:423:2: otherlv_5= KEYWORD_5
                    {
                    otherlv_5=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleWeightItem825); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:435:1: entryRuleDefine returns [EObject current=null] : iv_ruleDefine= ruleDefine EOF ;
    public final EObject entryRuleDefine() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefine = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:436:2: (iv_ruleDefine= ruleDefine EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:437:2: iv_ruleDefine= ruleDefine EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefineRule()); 
            }
            pushFollow(FOLLOW_ruleDefine_in_entryRuleDefine861);
            iv_ruleDefine=ruleDefine();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefine; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefine871); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:444:1: ruleDefine returns [EObject current=null] : ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) ) ) otherlv_8= KEYWORD_14 ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:447:28: ( ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) ) ) otherlv_8= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:448:1: ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) ) ) otherlv_8= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:448:1: ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) ) ) otherlv_8= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:448:2: (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) ) ) otherlv_8= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:448:2: (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==KEYWORD_40) ) {
                int LA12_1 = input.LA(2);

                if ( (synpred14_InternalWreslEditorParser()) ) {
                    alt12=1;
                }
                else if ( (true) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:449:2: otherlv_0= KEYWORD_40
                    {
                    otherlv_0=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_ruleDefine910); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getDefineAccess().getDefineKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:455:2: otherlv_1= KEYWORD_40
                    {
                    otherlv_1=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_ruleDefine928); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDefineAccess().getDEFINEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:459:2: (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==KEYWORD_11) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:460:2: otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12
                    {
                    otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleDefine942); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDefineAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:464:1: ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:465:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:465:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:466:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:466:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==KEYWORD_33) ) {
                        int LA13_1 = input.LA(2);

                        if ( (synpred15_InternalWreslEditorParser()) ) {
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:467:3: lv_local_3_1= KEYWORD_33
                            {
                            lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleDefine962); if (state.failed) return current;
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:480:8: lv_local_3_2= KEYWORD_33
                            {
                            lv_local_3_2=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleDefine990); if (state.failed) return current;
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

                    otherlv_4=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleDefine1017); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDefineAccess().getRightSquareBracketKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:501:3: ( (lv_name_5_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:502:1: (lv_name_5_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:502:1: (lv_name_5_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:503:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleDefine1035); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleDefine1053); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getDefineAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:524:1: ( ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:525:1: ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:525:1: ( (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:526:1: (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:526:1: (lv_definition_7_1= ruleDVar | lv_definition_7_2= ruleSVar | lv_definition_7_3= ruleDVarInteger | lv_definition_7_4= ruleExternal )
            int alt15=4;
            switch ( input.LA(1) ) {
            case KEYWORD_34:
            case KEYWORD_37:
            case KEYWORD_23:
                {
                alt15=1;
                }
                break;
            case KEYWORD_52:
            case KEYWORD_41:
            case KEYWORD_38:
            case KEYWORD_27:
            case KEYWORD_24:
                {
                alt15=2;
                }
                break;
            case KEYWORD_44:
                {
                alt15=3;
                }
                break;
            case KEYWORD_46:
                {
                alt15=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:527:3: lv_definition_7_1= ruleDVar
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineAccess().getDefinitionDVarParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDVar_in_ruleDefine1075);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:542:8: lv_definition_7_2= ruleSVar
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineAccess().getDefinitionSVarParserRuleCall_4_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSVar_in_ruleDefine1094);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:557:8: lv_definition_7_3= ruleDVarInteger
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineAccess().getDefinitionDVarIntegerParserRuleCall_4_0_2()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleDVarInteger_in_ruleDefine1113);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:572:8: lv_definition_7_4= ruleExternal
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getDefineAccess().getDefinitionExternalParserRuleCall_4_0_3()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExternal_in_ruleDefine1132);
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

            otherlv_8=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleDefine1148); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:603:1: entryRuleExternal returns [EObject current=null] : iv_ruleExternal= ruleExternal EOF ;
    public final EObject entryRuleExternal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternal = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:604:2: (iv_ruleExternal= ruleExternal EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:605:2: iv_ruleExternal= ruleExternal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExternalRule()); 
            }
            pushFollow(FOLLOW_ruleExternal_in_entryRuleExternal1182);
            iv_ruleExternal=ruleExternal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExternal; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternal1192); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:612:1: ruleExternal returns [EObject current=null] : ( (otherlv_0= KEYWORD_46 | otherlv_1= KEYWORD_46 ) ( ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) ) | ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) ) ) ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:615:28: ( ( (otherlv_0= KEYWORD_46 | otherlv_1= KEYWORD_46 ) ( ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) ) | ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:616:1: ( (otherlv_0= KEYWORD_46 | otherlv_1= KEYWORD_46 ) ( ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) ) | ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:616:1: ( (otherlv_0= KEYWORD_46 | otherlv_1= KEYWORD_46 ) ( ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) ) | ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:616:2: (otherlv_0= KEYWORD_46 | otherlv_1= KEYWORD_46 ) ( ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) ) | ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:616:2: (otherlv_0= KEYWORD_46 | otherlv_1= KEYWORD_46 )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==KEYWORD_46) ) {
                int LA16_1 = input.LA(2);

                if ( (synpred20_InternalWreslEditorParser()) ) {
                    alt16=1;
                }
                else if ( (true) ) {
                    alt16=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 16, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:617:2: otherlv_0= KEYWORD_46
                    {
                    otherlv_0=(Token)match(input,KEYWORD_46,FOLLOW_KEYWORD_46_in_ruleExternal1231); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getExternalAccess().getExternalKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:623:2: otherlv_1= KEYWORD_46
                    {
                    otherlv_1=(Token)match(input,KEYWORD_46,FOLLOW_KEYWORD_46_in_ruleExternal1249); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getExternalAccess().getEXTERNALKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:627:2: ( ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) ) | ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            else if ( (LA19_0==KEYWORD_20) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:627:3: ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:627:3: ( ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:627:4: ( (lv_name_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:627:4: ( (lv_name_2_0= RULE_ID ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:628:1: (lv_name_2_0= RULE_ID )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:628:1: (lv_name_2_0= RULE_ID )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:629:3: lv_name_2_0= RULE_ID
                    {
                    lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternal1268); if (state.failed) return current;
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

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:645:2: (otherlv_3= KEYWORD_26 | otherlv_4= KEYWORD_26 )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==KEYWORD_26) ) {
                        int LA17_1 = input.LA(2);

                        if ( (synpred21_InternalWreslEditorParser()) ) {
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:646:2: otherlv_3= KEYWORD_26
                            {
                            otherlv_3=(Token)match(input,KEYWORD_26,FOLLOW_KEYWORD_26_in_ruleExternal1287); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getExternalAccess().getDllKeyword_1_0_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:652:2: otherlv_4= KEYWORD_26
                            {
                            otherlv_4=(Token)match(input,KEYWORD_26,FOLLOW_KEYWORD_26_in_ruleExternal1305); if (state.failed) return current;
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:657:6: ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:657:6: ( () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:657:7: () (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:657:7: ()
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:658:2: 
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

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:666:2: (otherlv_6= KEYWORD_20 | otherlv_7= KEYWORD_20 )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==KEYWORD_20) ) {
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:667:2: otherlv_6= KEYWORD_20
                            {
                            otherlv_6=(Token)match(input,KEYWORD_20,FOLLOW_KEYWORD_20_in_ruleExternal1339); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getExternalAccess().getF90Keyword_1_1_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:673:2: otherlv_7= KEYWORD_20
                            {
                            otherlv_7=(Token)match(input,KEYWORD_20,FOLLOW_KEYWORD_20_in_ruleExternal1357); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:685:1: entryRuleAlias returns [EObject current=null] : iv_ruleAlias= ruleAlias EOF ;
    public final EObject entryRuleAlias() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAlias = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:686:2: (iv_ruleAlias= ruleAlias EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:687:2: iv_ruleAlias= ruleAlias EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAliasRule()); 
            }
            pushFollow(FOLLOW_ruleAlias_in_entryRuleAlias1394);
            iv_ruleAlias=ruleAlias();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAlias; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAlias1404); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:694:1: ruleAlias returns [EObject current=null] : ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 (otherlv_7= KEYWORD_31 | otherlv_8= KEYWORD_31 ) ( (lv_expression_9_0= ruleExpression ) ) ( (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 ) ( (lv_kind_12_0= RULE_STRING ) ) )? ( (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 ) ( (lv_units_15_0= RULE_STRING ) ) )? otherlv_16= KEYWORD_14 ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:697:28: ( ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 (otherlv_7= KEYWORD_31 | otherlv_8= KEYWORD_31 ) ( (lv_expression_9_0= ruleExpression ) ) ( (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 ) ( (lv_kind_12_0= RULE_STRING ) ) )? ( (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 ) ( (lv_units_15_0= RULE_STRING ) ) )? otherlv_16= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:698:1: ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 (otherlv_7= KEYWORD_31 | otherlv_8= KEYWORD_31 ) ( (lv_expression_9_0= ruleExpression ) ) ( (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 ) ( (lv_kind_12_0= RULE_STRING ) ) )? ( (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 ) ( (lv_units_15_0= RULE_STRING ) ) )? otherlv_16= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:698:1: ( (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 (otherlv_7= KEYWORD_31 | otherlv_8= KEYWORD_31 ) ( (lv_expression_9_0= ruleExpression ) ) ( (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 ) ( (lv_kind_12_0= RULE_STRING ) ) )? ( (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 ) ( (lv_units_15_0= RULE_STRING ) ) )? otherlv_16= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:698:2: (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 (otherlv_7= KEYWORD_31 | otherlv_8= KEYWORD_31 ) ( (lv_expression_9_0= ruleExpression ) ) ( (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 ) ( (lv_kind_12_0= RULE_STRING ) ) )? ( (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 ) ( (lv_units_15_0= RULE_STRING ) ) )? otherlv_16= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:698:2: (otherlv_0= KEYWORD_40 | otherlv_1= KEYWORD_40 )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==KEYWORD_40) ) {
                int LA20_1 = input.LA(2);

                if ( (synpred24_InternalWreslEditorParser()) ) {
                    alt20=1;
                }
                else if ( (true) ) {
                    alt20=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:699:2: otherlv_0= KEYWORD_40
                    {
                    otherlv_0=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_ruleAlias1443); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getAliasAccess().getDefineKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:705:2: otherlv_1= KEYWORD_40
                    {
                    otherlv_1=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_ruleAlias1461); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getAliasAccess().getDEFINEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:709:2: (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==KEYWORD_11) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:710:2: otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12
                    {
                    otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleAlias1475); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getAliasAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:714:1: ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:715:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:715:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:716:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:716:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==KEYWORD_33) ) {
                        int LA21_1 = input.LA(2);

                        if ( (synpred25_InternalWreslEditorParser()) ) {
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:717:3: lv_local_3_1= KEYWORD_33
                            {
                            lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleAlias1495); if (state.failed) return current;
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:730:8: lv_local_3_2= KEYWORD_33
                            {
                            lv_local_3_2=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleAlias1523); if (state.failed) return current;
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

                    otherlv_4=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleAlias1550); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getAliasAccess().getRightSquareBracketKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:751:3: ( (lv_name_5_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:752:1: (lv_name_5_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:752:1: (lv_name_5_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:753:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAlias1568); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleAlias1586); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getAliasAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:774:1: (otherlv_7= KEYWORD_31 | otherlv_8= KEYWORD_31 )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==KEYWORD_31) ) {
                int LA23_1 = input.LA(2);

                if ( (synpred27_InternalWreslEditorParser()) ) {
                    alt23=1;
                }
                else if ( (true) ) {
                    alt23=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:775:2: otherlv_7= KEYWORD_31
                    {
                    otherlv_7=(Token)match(input,KEYWORD_31,FOLLOW_KEYWORD_31_in_ruleAlias1599); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getAliasAccess().getAliasKeyword_4_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:781:2: otherlv_8= KEYWORD_31
                    {
                    otherlv_8=(Token)match(input,KEYWORD_31,FOLLOW_KEYWORD_31_in_ruleAlias1617); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getAliasAccess().getALIASKeyword_4_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:785:2: ( (lv_expression_9_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:786:1: (lv_expression_9_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:786:1: (lv_expression_9_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:787:3: lv_expression_9_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAliasAccess().getExpressionExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleAlias1638);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:803:2: ( (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 ) ( (lv_kind_12_0= RULE_STRING ) ) )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==KEYWORD_30) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:803:3: (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 ) ( (lv_kind_12_0= RULE_STRING ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:803:3: (otherlv_10= KEYWORD_30 | otherlv_11= KEYWORD_30 )
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==KEYWORD_30) ) {
                        int LA24_1 = input.LA(2);

                        if ( (synpred28_InternalWreslEditorParser()) ) {
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:804:2: otherlv_10= KEYWORD_30
                            {
                            otherlv_10=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleAlias1653); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_10, grammarAccess.getAliasAccess().getKindKeyword_6_0_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:810:2: otherlv_11= KEYWORD_30
                            {
                            otherlv_11=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleAlias1671); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_11, grammarAccess.getAliasAccess().getKINDKeyword_6_0_1());
                                  
                            }

                            }
                            break;

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:814:2: ( (lv_kind_12_0= RULE_STRING ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:815:1: (lv_kind_12_0= RULE_STRING )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:815:1: (lv_kind_12_0= RULE_STRING )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:816:3: lv_kind_12_0= RULE_STRING
                    {
                    lv_kind_12_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAlias1688); if (state.failed) return current;
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:832:4: ( (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 ) ( (lv_units_15_0= RULE_STRING ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==KEYWORD_36) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:832:5: (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 ) ( (lv_units_15_0= RULE_STRING ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:832:5: (otherlv_13= KEYWORD_36 | otherlv_14= KEYWORD_36 )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==KEYWORD_36) ) {
                        int LA26_1 = input.LA(2);

                        if ( (synpred30_InternalWreslEditorParser()) ) {
                            alt26=1;
                        }
                        else if ( (true) ) {
                            alt26=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 26, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:833:2: otherlv_13= KEYWORD_36
                            {
                            otherlv_13=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleAlias1710); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_13, grammarAccess.getAliasAccess().getUnitsKeyword_7_0_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:839:2: otherlv_14= KEYWORD_36
                            {
                            otherlv_14=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleAlias1728); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_14, grammarAccess.getAliasAccess().getUNITSKeyword_7_0_1());
                                  
                            }

                            }
                            break;

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:843:2: ( (lv_units_15_0= RULE_STRING ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:844:1: (lv_units_15_0= RULE_STRING )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:844:1: (lv_units_15_0= RULE_STRING )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:845:3: lv_units_15_0= RULE_STRING
                    {
                    lv_units_15_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAlias1745); if (state.failed) return current;
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

            otherlv_16=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleAlias1765); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:874:1: entryRuleDVar returns [EObject current=null] : iv_ruleDVar= ruleDVar EOF ;
    public final EObject entryRuleDVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDVar = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:875:2: (iv_ruleDVar= ruleDVar EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:876:2: iv_ruleDVar= ruleDVar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDVarRule()); 
            }
            pushFollow(FOLLOW_ruleDVar_in_entryRuleDVar1799);
            iv_ruleDVar=ruleDVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDVar; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDVar1809); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:883:1: ruleDVar returns [EObject current=null] : (this_DVarStd_0= ruleDVarStd | this_DVarNonStd_1= ruleDVarNonStd ) ;
    public final EObject ruleDVar() throws RecognitionException {
        EObject current = null;

        EObject this_DVarStd_0 = null;

        EObject this_DVarNonStd_1 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:886:28: ( (this_DVarStd_0= ruleDVarStd | this_DVarNonStd_1= ruleDVarNonStd ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:887:1: (this_DVarStd_0= ruleDVarStd | this_DVarNonStd_1= ruleDVarNonStd )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:887:1: (this_DVarStd_0= ruleDVarStd | this_DVarNonStd_1= ruleDVarNonStd )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==KEYWORD_23) ) {
                alt28=1;
            }
            else if ( (LA28_0==KEYWORD_34||LA28_0==KEYWORD_37) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:888:2: this_DVarStd_0= ruleDVarStd
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDVarAccess().getDVarStdParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDVarStd_in_ruleDVar1859);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:901:2: this_DVarNonStd_1= ruleDVarNonStd
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDVarAccess().getDVarNonStdParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDVarNonStd_in_ruleDVar1889);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:920:1: entryRuleDVarNonStd returns [EObject current=null] : iv_ruleDVarNonStd= ruleDVarNonStd EOF ;
    public final EObject entryRuleDVarNonStd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDVarNonStd = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:921:2: (iv_ruleDVarNonStd= ruleDVarNonStd EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:922:2: iv_ruleDVarNonStd= ruleDVarNonStd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDVarNonStdRule()); 
            }
            pushFollow(FOLLOW_ruleDVarNonStd_in_entryRuleDVarNonStd1923);
            iv_ruleDVarNonStd=ruleDVarNonStd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDVarNonStd; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDVarNonStd1933); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:929:1: ruleDVarNonStd returns [EObject current=null] : ( ( (lv_lowerUpper_0_0= ruleLowerAndOrUpper ) ) (otherlv_1= KEYWORD_30 | otherlv_2= KEYWORD_30 ) ( (lv_kind_3_0= RULE_STRING ) ) (otherlv_4= KEYWORD_36 | otherlv_5= KEYWORD_36 ) ( (lv_units_6_0= RULE_STRING ) ) ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:932:28: ( ( ( (lv_lowerUpper_0_0= ruleLowerAndOrUpper ) ) (otherlv_1= KEYWORD_30 | otherlv_2= KEYWORD_30 ) ( (lv_kind_3_0= RULE_STRING ) ) (otherlv_4= KEYWORD_36 | otherlv_5= KEYWORD_36 ) ( (lv_units_6_0= RULE_STRING ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:933:1: ( ( (lv_lowerUpper_0_0= ruleLowerAndOrUpper ) ) (otherlv_1= KEYWORD_30 | otherlv_2= KEYWORD_30 ) ( (lv_kind_3_0= RULE_STRING ) ) (otherlv_4= KEYWORD_36 | otherlv_5= KEYWORD_36 ) ( (lv_units_6_0= RULE_STRING ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:933:1: ( ( (lv_lowerUpper_0_0= ruleLowerAndOrUpper ) ) (otherlv_1= KEYWORD_30 | otherlv_2= KEYWORD_30 ) ( (lv_kind_3_0= RULE_STRING ) ) (otherlv_4= KEYWORD_36 | otherlv_5= KEYWORD_36 ) ( (lv_units_6_0= RULE_STRING ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:933:2: ( (lv_lowerUpper_0_0= ruleLowerAndOrUpper ) ) (otherlv_1= KEYWORD_30 | otherlv_2= KEYWORD_30 ) ( (lv_kind_3_0= RULE_STRING ) ) (otherlv_4= KEYWORD_36 | otherlv_5= KEYWORD_36 ) ( (lv_units_6_0= RULE_STRING ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:933:2: ( (lv_lowerUpper_0_0= ruleLowerAndOrUpper ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:934:1: (lv_lowerUpper_0_0= ruleLowerAndOrUpper )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:934:1: (lv_lowerUpper_0_0= ruleLowerAndOrUpper )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:935:3: lv_lowerUpper_0_0= ruleLowerAndOrUpper
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getDVarNonStdAccess().getLowerUpperLowerAndOrUpperParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLowerAndOrUpper_in_ruleDVarNonStd1979);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:951:2: (otherlv_1= KEYWORD_30 | otherlv_2= KEYWORD_30 )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==KEYWORD_30) ) {
                int LA29_1 = input.LA(2);

                if ( (synpred33_InternalWreslEditorParser()) ) {
                    alt29=1;
                }
                else if ( (true) ) {
                    alt29=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:952:2: otherlv_1= KEYWORD_30
                    {
                    otherlv_1=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarNonStd1993); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDVarNonStdAccess().getKindKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:958:2: otherlv_2= KEYWORD_30
                    {
                    otherlv_2=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarNonStd2011); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDVarNonStdAccess().getKINDKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:962:2: ( (lv_kind_3_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:963:1: (lv_kind_3_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:963:1: (lv_kind_3_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:964:3: lv_kind_3_0= RULE_STRING
            {
            lv_kind_3_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarNonStd2028); if (state.failed) return current;
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:980:2: (otherlv_4= KEYWORD_36 | otherlv_5= KEYWORD_36 )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==KEYWORD_36) ) {
                int LA30_1 = input.LA(2);

                if ( (synpred34_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:981:2: otherlv_4= KEYWORD_36
                    {
                    otherlv_4=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarNonStd2047); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDVarNonStdAccess().getUnitsKeyword_3_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:987:2: otherlv_5= KEYWORD_36
                    {
                    otherlv_5=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarNonStd2065); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getDVarNonStdAccess().getUNITSKeyword_3_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:991:2: ( (lv_units_6_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:992:1: (lv_units_6_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:992:1: (lv_units_6_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:993:3: lv_units_6_0= RULE_STRING
            {
            lv_units_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarNonStd2082); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1017:1: entryRuleDVarStd returns [EObject current=null] : iv_ruleDVarStd= ruleDVarStd EOF ;
    public final EObject entryRuleDVarStd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDVarStd = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1018:2: (iv_ruleDVarStd= ruleDVarStd EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1019:2: iv_ruleDVarStd= ruleDVarStd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDVarStdRule()); 
            }
            pushFollow(FOLLOW_ruleDVarStd_in_entryRuleDVarStd2122);
            iv_ruleDVarStd=ruleDVarStd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDVarStd; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDVarStd2132); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1026:1: ruleDVarStd returns [EObject current=null] : ( (otherlv_0= KEYWORD_23 | otherlv_1= KEYWORD_23 ) (otherlv_2= KEYWORD_30 | otherlv_3= KEYWORD_30 ) ( (lv_kind_4_0= RULE_STRING ) ) (otherlv_5= KEYWORD_36 | otherlv_6= KEYWORD_36 ) ( (lv_units_7_0= RULE_STRING ) ) ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1029:28: ( ( (otherlv_0= KEYWORD_23 | otherlv_1= KEYWORD_23 ) (otherlv_2= KEYWORD_30 | otherlv_3= KEYWORD_30 ) ( (lv_kind_4_0= RULE_STRING ) ) (otherlv_5= KEYWORD_36 | otherlv_6= KEYWORD_36 ) ( (lv_units_7_0= RULE_STRING ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1030:1: ( (otherlv_0= KEYWORD_23 | otherlv_1= KEYWORD_23 ) (otherlv_2= KEYWORD_30 | otherlv_3= KEYWORD_30 ) ( (lv_kind_4_0= RULE_STRING ) ) (otherlv_5= KEYWORD_36 | otherlv_6= KEYWORD_36 ) ( (lv_units_7_0= RULE_STRING ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1030:1: ( (otherlv_0= KEYWORD_23 | otherlv_1= KEYWORD_23 ) (otherlv_2= KEYWORD_30 | otherlv_3= KEYWORD_30 ) ( (lv_kind_4_0= RULE_STRING ) ) (otherlv_5= KEYWORD_36 | otherlv_6= KEYWORD_36 ) ( (lv_units_7_0= RULE_STRING ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1030:2: (otherlv_0= KEYWORD_23 | otherlv_1= KEYWORD_23 ) (otherlv_2= KEYWORD_30 | otherlv_3= KEYWORD_30 ) ( (lv_kind_4_0= RULE_STRING ) ) (otherlv_5= KEYWORD_36 | otherlv_6= KEYWORD_36 ) ( (lv_units_7_0= RULE_STRING ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1030:2: (otherlv_0= KEYWORD_23 | otherlv_1= KEYWORD_23 )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==KEYWORD_23) ) {
                int LA31_1 = input.LA(2);

                if ( (synpred35_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1031:2: otherlv_0= KEYWORD_23
                    {
                    otherlv_0=(Token)match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_ruleDVarStd2171); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getDVarStdAccess().getStdKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1037:2: otherlv_1= KEYWORD_23
                    {
                    otherlv_1=(Token)match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_ruleDVarStd2189); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDVarStdAccess().getSTDKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1041:2: (otherlv_2= KEYWORD_30 | otherlv_3= KEYWORD_30 )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==KEYWORD_30) ) {
                int LA32_1 = input.LA(2);

                if ( (synpred36_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1042:2: otherlv_2= KEYWORD_30
                    {
                    otherlv_2=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarStd2203); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDVarStdAccess().getKindKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1048:2: otherlv_3= KEYWORD_30
                    {
                    otherlv_3=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarStd2221); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getDVarStdAccess().getKINDKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1052:2: ( (lv_kind_4_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1053:1: (lv_kind_4_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1053:1: (lv_kind_4_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1054:3: lv_kind_4_0= RULE_STRING
            {
            lv_kind_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarStd2238); if (state.failed) return current;
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1070:2: (otherlv_5= KEYWORD_36 | otherlv_6= KEYWORD_36 )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==KEYWORD_36) ) {
                int LA33_1 = input.LA(2);

                if ( (synpred37_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1071:2: otherlv_5= KEYWORD_36
                    {
                    otherlv_5=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarStd2257); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getDVarStdAccess().getUnitsKeyword_3_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1077:2: otherlv_6= KEYWORD_36
                    {
                    otherlv_6=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarStd2275); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDVarStdAccess().getUNITSKeyword_3_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1081:2: ( (lv_units_7_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1082:1: (lv_units_7_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1082:1: (lv_units_7_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1083:3: lv_units_7_0= RULE_STRING
            {
            lv_units_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarStd2292); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1107:1: entryRuleDVarInteger returns [EObject current=null] : iv_ruleDVarInteger= ruleDVarInteger EOF ;
    public final EObject entryRuleDVarInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDVarInteger = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1108:2: (iv_ruleDVarInteger= ruleDVarInteger EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1109:2: iv_ruleDVarInteger= ruleDVarInteger EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDVarIntegerRule()); 
            }
            pushFollow(FOLLOW_ruleDVarInteger_in_entryRuleDVarInteger2332);
            iv_ruleDVarInteger=ruleDVarInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDVarInteger; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDVarInteger2342); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1116:1: ruleDVarInteger returns [EObject current=null] : (this_DVarIntegerStd_0= ruleDVarIntegerStd | this_DVarIntegerNonStd_1= ruleDVarIntegerNonStd ) ;
    public final EObject ruleDVarInteger() throws RecognitionException {
        EObject current = null;

        EObject this_DVarIntegerStd_0 = null;

        EObject this_DVarIntegerNonStd_1 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1119:28: ( (this_DVarIntegerStd_0= ruleDVarIntegerStd | this_DVarIntegerNonStd_1= ruleDVarIntegerNonStd ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1120:1: (this_DVarIntegerStd_0= ruleDVarIntegerStd | this_DVarIntegerNonStd_1= ruleDVarIntegerNonStd )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1120:1: (this_DVarIntegerStd_0= ruleDVarIntegerStd | this_DVarIntegerNonStd_1= ruleDVarIntegerNonStd )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==KEYWORD_44) ) {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==KEYWORD_34||LA34_1==KEYWORD_37) ) {
                    alt34=2;
                }
                else if ( (LA34_1==KEYWORD_23) ) {
                    alt34=1;
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1121:2: this_DVarIntegerStd_0= ruleDVarIntegerStd
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDVarIntegerAccess().getDVarIntegerStdParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDVarIntegerStd_in_ruleDVarInteger2392);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1134:2: this_DVarIntegerNonStd_1= ruleDVarIntegerNonStd
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getDVarIntegerAccess().getDVarIntegerNonStdParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleDVarIntegerNonStd_in_ruleDVarInteger2422);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1153:1: entryRuleDVarIntegerStd returns [EObject current=null] : iv_ruleDVarIntegerStd= ruleDVarIntegerStd EOF ;
    public final EObject entryRuleDVarIntegerStd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDVarIntegerStd = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1154:2: (iv_ruleDVarIntegerStd= ruleDVarIntegerStd EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1155:2: iv_ruleDVarIntegerStd= ruleDVarIntegerStd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDVarIntegerStdRule()); 
            }
            pushFollow(FOLLOW_ruleDVarIntegerStd_in_entryRuleDVarIntegerStd2456);
            iv_ruleDVarIntegerStd=ruleDVarIntegerStd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDVarIntegerStd; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDVarIntegerStd2466); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1162:1: ruleDVarIntegerStd returns [EObject current=null] : ( (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 ) (otherlv_2= KEYWORD_23 | otherlv_3= KEYWORD_23 ) (otherlv_4= KEYWORD_30 | otherlv_5= KEYWORD_30 ) ( (lv_kind_6_0= RULE_STRING ) ) (otherlv_7= KEYWORD_36 | otherlv_8= KEYWORD_36 ) ( (lv_units_9_0= RULE_STRING ) ) ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1165:28: ( ( (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 ) (otherlv_2= KEYWORD_23 | otherlv_3= KEYWORD_23 ) (otherlv_4= KEYWORD_30 | otherlv_5= KEYWORD_30 ) ( (lv_kind_6_0= RULE_STRING ) ) (otherlv_7= KEYWORD_36 | otherlv_8= KEYWORD_36 ) ( (lv_units_9_0= RULE_STRING ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1166:1: ( (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 ) (otherlv_2= KEYWORD_23 | otherlv_3= KEYWORD_23 ) (otherlv_4= KEYWORD_30 | otherlv_5= KEYWORD_30 ) ( (lv_kind_6_0= RULE_STRING ) ) (otherlv_7= KEYWORD_36 | otherlv_8= KEYWORD_36 ) ( (lv_units_9_0= RULE_STRING ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1166:1: ( (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 ) (otherlv_2= KEYWORD_23 | otherlv_3= KEYWORD_23 ) (otherlv_4= KEYWORD_30 | otherlv_5= KEYWORD_30 ) ( (lv_kind_6_0= RULE_STRING ) ) (otherlv_7= KEYWORD_36 | otherlv_8= KEYWORD_36 ) ( (lv_units_9_0= RULE_STRING ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1166:2: (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 ) (otherlv_2= KEYWORD_23 | otherlv_3= KEYWORD_23 ) (otherlv_4= KEYWORD_30 | otherlv_5= KEYWORD_30 ) ( (lv_kind_6_0= RULE_STRING ) ) (otherlv_7= KEYWORD_36 | otherlv_8= KEYWORD_36 ) ( (lv_units_9_0= RULE_STRING ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1166:2: (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==KEYWORD_44) ) {
                int LA35_1 = input.LA(2);

                if ( (synpred39_InternalWreslEditorParser()) ) {
                    alt35=1;
                }
                else if ( (true) ) {
                    alt35=2;
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1167:2: otherlv_0= KEYWORD_44
                    {
                    otherlv_0=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_ruleDVarIntegerStd2505); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getDVarIntegerStdAccess().getIntegerKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1173:2: otherlv_1= KEYWORD_44
                    {
                    otherlv_1=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_ruleDVarIntegerStd2523); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getDVarIntegerStdAccess().getINTEGERKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1177:2: (otherlv_2= KEYWORD_23 | otherlv_3= KEYWORD_23 )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==KEYWORD_23) ) {
                int LA36_1 = input.LA(2);

                if ( (synpred40_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1178:2: otherlv_2= KEYWORD_23
                    {
                    otherlv_2=(Token)match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_ruleDVarIntegerStd2537); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getDVarIntegerStdAccess().getStdKeyword_1_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1184:2: otherlv_3= KEYWORD_23
                    {
                    otherlv_3=(Token)match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_ruleDVarIntegerStd2555); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getDVarIntegerStdAccess().getSTDKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1188:2: (otherlv_4= KEYWORD_30 | otherlv_5= KEYWORD_30 )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==KEYWORD_30) ) {
                int LA37_1 = input.LA(2);

                if ( (synpred41_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1189:2: otherlv_4= KEYWORD_30
                    {
                    otherlv_4=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarIntegerStd2569); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDVarIntegerStdAccess().getKindKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1195:2: otherlv_5= KEYWORD_30
                    {
                    otherlv_5=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarIntegerStd2587); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getDVarIntegerStdAccess().getKINDKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1199:2: ( (lv_kind_6_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1200:1: (lv_kind_6_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1200:1: (lv_kind_6_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1201:3: lv_kind_6_0= RULE_STRING
            {
            lv_kind_6_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarIntegerStd2604); if (state.failed) return current;
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1217:2: (otherlv_7= KEYWORD_36 | otherlv_8= KEYWORD_36 )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==KEYWORD_36) ) {
                int LA38_1 = input.LA(2);

                if ( (synpred42_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1218:2: otherlv_7= KEYWORD_36
                    {
                    otherlv_7=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarIntegerStd2623); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getDVarIntegerStdAccess().getUnitsKeyword_4_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1224:2: otherlv_8= KEYWORD_36
                    {
                    otherlv_8=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarIntegerStd2641); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getDVarIntegerStdAccess().getUNITSKeyword_4_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1228:2: ( (lv_units_9_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1229:1: (lv_units_9_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1229:1: (lv_units_9_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1230:3: lv_units_9_0= RULE_STRING
            {
            lv_units_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarIntegerStd2658); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1254:1: entryRuleDVarIntegerNonStd returns [EObject current=null] : iv_ruleDVarIntegerNonStd= ruleDVarIntegerNonStd EOF ;
    public final EObject entryRuleDVarIntegerNonStd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDVarIntegerNonStd = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1255:2: (iv_ruleDVarIntegerNonStd= ruleDVarIntegerNonStd EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1256:2: iv_ruleDVarIntegerNonStd= ruleDVarIntegerNonStd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDVarIntegerNonStdRule()); 
            }
            pushFollow(FOLLOW_ruleDVarIntegerNonStd_in_entryRuleDVarIntegerNonStd2698);
            iv_ruleDVarIntegerNonStd=ruleDVarIntegerNonStd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDVarIntegerNonStd; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleDVarIntegerNonStd2708); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1263:1: ruleDVarIntegerNonStd returns [EObject current=null] : ( (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 ) this_LowerAndOrUpper_2= ruleLowerAndOrUpper (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1266:28: ( ( (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 ) this_LowerAndOrUpper_2= ruleLowerAndOrUpper (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1267:1: ( (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 ) this_LowerAndOrUpper_2= ruleLowerAndOrUpper (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1267:1: ( (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 ) this_LowerAndOrUpper_2= ruleLowerAndOrUpper (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1267:2: (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 ) this_LowerAndOrUpper_2= ruleLowerAndOrUpper (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1267:2: (otherlv_0= KEYWORD_44 | otherlv_1= KEYWORD_44 )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==KEYWORD_44) ) {
                int LA39_1 = input.LA(2);

                if ( (synpred43_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1268:2: otherlv_0= KEYWORD_44
                    {
                    otherlv_0=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_ruleDVarIntegerNonStd2747); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getDVarIntegerNonStdAccess().getIntegerKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1274:2: otherlv_1= KEYWORD_44
                    {
                    otherlv_1=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_ruleDVarIntegerNonStd2765); if (state.failed) return current;
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
            pushFollow(FOLLOW_ruleLowerAndOrUpper_in_ruleDVarIntegerNonStd2790);
            this_LowerAndOrUpper_2=ruleLowerAndOrUpper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current = this_LowerAndOrUpper_2;
                      afterParserOrEnumRuleCall();
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1290:1: (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==KEYWORD_30) ) {
                int LA40_1 = input.LA(2);

                if ( (synpred44_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1291:2: otherlv_3= KEYWORD_30
                    {
                    otherlv_3=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarIntegerNonStd2803); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getDVarIntegerNonStdAccess().getKindKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1297:2: otherlv_4= KEYWORD_30
                    {
                    otherlv_4=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleDVarIntegerNonStd2821); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getDVarIntegerNonStdAccess().getKINDKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1301:2: ( (lv_kind_5_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1302:1: (lv_kind_5_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1302:1: (lv_kind_5_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1303:3: lv_kind_5_0= RULE_STRING
            {
            lv_kind_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarIntegerNonStd2838); if (state.failed) return current;
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1319:2: (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==KEYWORD_36) ) {
                int LA41_1 = input.LA(2);

                if ( (synpred45_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1320:2: otherlv_6= KEYWORD_36
                    {
                    otherlv_6=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarIntegerNonStd2857); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getDVarIntegerNonStdAccess().getUnitsKeyword_4_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1326:2: otherlv_7= KEYWORD_36
                    {
                    otherlv_7=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleDVarIntegerNonStd2875); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getDVarIntegerNonStdAccess().getUNITSKeyword_4_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1330:2: ( (lv_units_8_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1331:1: (lv_units_8_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1331:1: (lv_units_8_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1332:3: lv_units_8_0= RULE_STRING
            {
            lv_units_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleDVarIntegerNonStd2892); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1356:1: entryRuleSVar returns [EObject current=null] : iv_ruleSVar= ruleSVar EOF ;
    public final EObject entryRuleSVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSVar = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1357:2: (iv_ruleSVar= ruleSVar EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1358:2: iv_ruleSVar= ruleSVar EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSVarRule()); 
            }
            pushFollow(FOLLOW_ruleSVar_in_entryRuleSVar2932);
            iv_ruleSVar=ruleSVar();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSVar; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSVar2942); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1365:1: ruleSVar returns [EObject current=null] : (this_SVarDSS_0= ruleSVarDSS | this_SVarExpression_1= ruleSVarExpression | this_SVarSum_2= ruleSVarSum | this_SVarTable_3= ruleSVarTable | this_SVarCase_4= ruleSVarCase ) ;
    public final EObject ruleSVar() throws RecognitionException {
        EObject current = null;

        EObject this_SVarDSS_0 = null;

        EObject this_SVarExpression_1 = null;

        EObject this_SVarSum_2 = null;

        EObject this_SVarTable_3 = null;

        EObject this_SVarCase_4 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1368:28: ( (this_SVarDSS_0= ruleSVarDSS | this_SVarExpression_1= ruleSVarExpression | this_SVarSum_2= ruleSVarSum | this_SVarTable_3= ruleSVarTable | this_SVarCase_4= ruleSVarCase ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1369:1: (this_SVarDSS_0= ruleSVarDSS | this_SVarExpression_1= ruleSVarExpression | this_SVarSum_2= ruleSVarSum | this_SVarTable_3= ruleSVarTable | this_SVarCase_4= ruleSVarCase )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1369:1: (this_SVarDSS_0= ruleSVarDSS | this_SVarExpression_1= ruleSVarExpression | this_SVarSum_2= ruleSVarSum | this_SVarTable_3= ruleSVarTable | this_SVarCase_4= ruleSVarCase )
            int alt42=5;
            switch ( input.LA(1) ) {
            case KEYWORD_52:
                {
                alt42=1;
                }
                break;
            case KEYWORD_38:
                {
                alt42=2;
                }
                break;
            case KEYWORD_24:
                {
                alt42=3;
                }
                break;
            case KEYWORD_41:
                {
                alt42=4;
                }
                break;
            case KEYWORD_27:
                {
                alt42=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1370:2: this_SVarDSS_0= ruleSVarDSS
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSVarAccess().getSVarDSSParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSVarDSS_in_ruleSVar2992);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1383:2: this_SVarExpression_1= ruleSVarExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSVarAccess().getSVarExpressionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSVarExpression_in_ruleSVar3022);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1396:2: this_SVarSum_2= ruleSVarSum
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSVarAccess().getSVarSumParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSVarSum_in_ruleSVar3052);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1409:2: this_SVarTable_3= ruleSVarTable
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSVarAccess().getSVarTableParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSVarTable_in_ruleSVar3082);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1422:2: this_SVarCase_4= ruleSVarCase
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getSVarAccess().getSVarCaseParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleSVarCase_in_ruleSVar3112);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1441:1: entryRuleSVarDSS returns [EObject current=null] : iv_ruleSVarDSS= ruleSVarDSS EOF ;
    public final EObject entryRuleSVarDSS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSVarDSS = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1442:2: (iv_ruleSVarDSS= ruleSVarDSS EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1443:2: iv_ruleSVarDSS= ruleSVarDSS EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSVarDSSRule()); 
            }
            pushFollow(FOLLOW_ruleSVarDSS_in_entryRuleSVarDSS3146);
            iv_ruleSVarDSS=ruleSVarDSS();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSVarDSS; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSVarDSS3156); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1450:1: ruleSVarDSS returns [EObject current=null] : ( (otherlv_0= KEYWORD_52 | otherlv_1= KEYWORD_52 ) ( (lv_bPart_2_0= RULE_STRING ) )? (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) ( (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 ) ( (lv_convert_11_0= RULE_STRING ) ) )? ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1453:28: ( ( (otherlv_0= KEYWORD_52 | otherlv_1= KEYWORD_52 ) ( (lv_bPart_2_0= RULE_STRING ) )? (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) ( (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 ) ( (lv_convert_11_0= RULE_STRING ) ) )? ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1454:1: ( (otherlv_0= KEYWORD_52 | otherlv_1= KEYWORD_52 ) ( (lv_bPart_2_0= RULE_STRING ) )? (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) ( (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 ) ( (lv_convert_11_0= RULE_STRING ) ) )? )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1454:1: ( (otherlv_0= KEYWORD_52 | otherlv_1= KEYWORD_52 ) ( (lv_bPart_2_0= RULE_STRING ) )? (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) ( (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 ) ( (lv_convert_11_0= RULE_STRING ) ) )? )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1454:2: (otherlv_0= KEYWORD_52 | otherlv_1= KEYWORD_52 ) ( (lv_bPart_2_0= RULE_STRING ) )? (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 ) ( (lv_kind_5_0= RULE_STRING ) ) (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 ) ( (lv_units_8_0= RULE_STRING ) ) ( (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 ) ( (lv_convert_11_0= RULE_STRING ) ) )?
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1454:2: (otherlv_0= KEYWORD_52 | otherlv_1= KEYWORD_52 )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==KEYWORD_52) ) {
                int LA43_1 = input.LA(2);

                if ( (synpred50_InternalWreslEditorParser()) ) {
                    alt43=1;
                }
                else if ( (true) ) {
                    alt43=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 43, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1455:2: otherlv_0= KEYWORD_52
                    {
                    otherlv_0=(Token)match(input,KEYWORD_52,FOLLOW_KEYWORD_52_in_ruleSVarDSS3195); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getSVarDSSAccess().getTimeseriesKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1461:2: otherlv_1= KEYWORD_52
                    {
                    otherlv_1=(Token)match(input,KEYWORD_52,FOLLOW_KEYWORD_52_in_ruleSVarDSS3213); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getSVarDSSAccess().getTIMESERIESKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1465:2: ( (lv_bPart_2_0= RULE_STRING ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_STRING) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1466:1: (lv_bPart_2_0= RULE_STRING )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1466:1: (lv_bPart_2_0= RULE_STRING )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1467:3: lv_bPart_2_0= RULE_STRING
                    {
                    lv_bPart_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSVarDSS3230); if (state.failed) return current;
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1483:3: (otherlv_3= KEYWORD_30 | otherlv_4= KEYWORD_30 )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==KEYWORD_30) ) {
                int LA45_1 = input.LA(2);

                if ( (synpred52_InternalWreslEditorParser()) ) {
                    alt45=1;
                }
                else if ( (true) ) {
                    alt45=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1484:2: otherlv_3= KEYWORD_30
                    {
                    otherlv_3=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleSVarDSS3250); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getSVarDSSAccess().getKindKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1490:2: otherlv_4= KEYWORD_30
                    {
                    otherlv_4=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_ruleSVarDSS3268); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getSVarDSSAccess().getKINDKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1494:2: ( (lv_kind_5_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1495:1: (lv_kind_5_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1495:1: (lv_kind_5_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1496:3: lv_kind_5_0= RULE_STRING
            {
            lv_kind_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSVarDSS3285); if (state.failed) return current;
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1512:2: (otherlv_6= KEYWORD_36 | otherlv_7= KEYWORD_36 )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==KEYWORD_36) ) {
                int LA46_1 = input.LA(2);

                if ( (synpred53_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1513:2: otherlv_6= KEYWORD_36
                    {
                    otherlv_6=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleSVarDSS3304); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getSVarDSSAccess().getUnitsKeyword_4_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1519:2: otherlv_7= KEYWORD_36
                    {
                    otherlv_7=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_ruleSVarDSS3322); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getSVarDSSAccess().getUNITSKeyword_4_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1523:2: ( (lv_units_8_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1524:1: (lv_units_8_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1524:1: (lv_units_8_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1525:3: lv_units_8_0= RULE_STRING
            {
            lv_units_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSVarDSS3339); if (state.failed) return current;
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1541:2: ( (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 ) ( (lv_convert_11_0= RULE_STRING ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==KEYWORD_42) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1541:3: (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 ) ( (lv_convert_11_0= RULE_STRING ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1541:3: (otherlv_9= KEYWORD_42 | otherlv_10= KEYWORD_42 )
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==KEYWORD_42) ) {
                        int LA47_1 = input.LA(2);

                        if ( (synpred54_InternalWreslEditorParser()) ) {
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1542:2: otherlv_9= KEYWORD_42
                            {
                            otherlv_9=(Token)match(input,KEYWORD_42,FOLLOW_KEYWORD_42_in_ruleSVarDSS3359); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_9, grammarAccess.getSVarDSSAccess().getConvertKeyword_6_0_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1548:2: otherlv_10= KEYWORD_42
                            {
                            otherlv_10=(Token)match(input,KEYWORD_42,FOLLOW_KEYWORD_42_in_ruleSVarDSS3377); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_10, grammarAccess.getSVarDSSAccess().getCONVERTKeyword_6_0_1());
                                  
                            }

                            }
                            break;

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1552:2: ( (lv_convert_11_0= RULE_STRING ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1553:1: (lv_convert_11_0= RULE_STRING )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1553:1: (lv_convert_11_0= RULE_STRING )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1554:3: lv_convert_11_0= RULE_STRING
                    {
                    lv_convert_11_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleSVarDSS3394); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1578:1: entryRuleSVarExpression returns [EObject current=null] : iv_ruleSVarExpression= ruleSVarExpression EOF ;
    public final EObject entryRuleSVarExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSVarExpression = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1579:2: (iv_ruleSVarExpression= ruleSVarExpression EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1580:2: iv_ruleSVarExpression= ruleSVarExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSVarExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleSVarExpression_in_entryRuleSVarExpression3436);
            iv_ruleSVarExpression=ruleSVarExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSVarExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSVarExpression3446); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1587:1: ruleSVarExpression returns [EObject current=null] : ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleSVarExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1590:28: ( ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1591:1: ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1591:1: ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1591:2: (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1591:2: (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==KEYWORD_38) ) {
                int LA49_1 = input.LA(2);

                if ( (synpred56_InternalWreslEditorParser()) ) {
                    alt49=1;
                }
                else if ( (true) ) {
                    alt49=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 49, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1592:2: otherlv_0= KEYWORD_38
                    {
                    otherlv_0=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_ruleSVarExpression3485); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getSVarExpressionAccess().getValueKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1598:2: otherlv_1= KEYWORD_38
                    {
                    otherlv_1=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_ruleSVarExpression3503); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getSVarExpressionAccess().getVALUEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1602:2: ( (lv_expression_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1603:1: (lv_expression_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1603:1: (lv_expression_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1604:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSVarExpressionAccess().getExpressionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSVarExpression3524);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1628:1: entryRuleSVarSum returns [EObject current=null] : iv_ruleSVarSum= ruleSVarSum EOF ;
    public final EObject entryRuleSVarSum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSVarSum = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1629:2: (iv_ruleSVarSum= ruleSVarSum EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1630:2: iv_ruleSVarSum= ruleSVarSum EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSVarSumRule()); 
            }
            pushFollow(FOLLOW_ruleSVarSum_in_entryRuleSVarSum3559);
            iv_ruleSVarSum=ruleSVarSum();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSVarSum; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSVarSum3569); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1637:1: ruleSVarSum returns [EObject current=null] : ( (lv_sumContent_0_0= ruleSumContent ) ) ;
    public final EObject ruleSVarSum() throws RecognitionException {
        EObject current = null;

        EObject lv_sumContent_0_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1640:28: ( ( (lv_sumContent_0_0= ruleSumContent ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1641:1: ( (lv_sumContent_0_0= ruleSumContent ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1641:1: ( (lv_sumContent_0_0= ruleSumContent ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1642:1: (lv_sumContent_0_0= ruleSumContent )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1642:1: (lv_sumContent_0_0= ruleSumContent )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1643:3: lv_sumContent_0_0= ruleSumContent
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSVarSumAccess().getSumContentSumContentParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSumContent_in_ruleSVarSum3614);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1667:1: entryRuleSVarTable returns [EObject current=null] : iv_ruleSVarTable= ruleSVarTable EOF ;
    public final EObject entryRuleSVarTable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSVarTable = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1668:2: (iv_ruleSVarTable= ruleSVarTable EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1669:2: iv_ruleSVarTable= ruleSVarTable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSVarTableRule()); 
            }
            pushFollow(FOLLOW_ruleSVarTable_in_entryRuleSVarTable3648);
            iv_ruleSVarTable=ruleSVarTable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSVarTable; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSVarTable3658); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1676:1: ruleSVarTable returns [EObject current=null] : ( (lv_tableContent_0_0= ruleTableContent ) ) ;
    public final EObject ruleSVarTable() throws RecognitionException {
        EObject current = null;

        EObject lv_tableContent_0_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1679:28: ( ( (lv_tableContent_0_0= ruleTableContent ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1680:1: ( (lv_tableContent_0_0= ruleTableContent ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1680:1: ( (lv_tableContent_0_0= ruleTableContent ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1681:1: (lv_tableContent_0_0= ruleTableContent )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1681:1: (lv_tableContent_0_0= ruleTableContent )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1682:3: lv_tableContent_0_0= ruleTableContent
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSVarTableAccess().getTableContentTableContentParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTableContent_in_ruleSVarTable3703);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1706:1: entryRuleSVarCase returns [EObject current=null] : iv_ruleSVarCase= ruleSVarCase EOF ;
    public final EObject entryRuleSVarCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSVarCase = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1707:2: (iv_ruleSVarCase= ruleSVarCase EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1708:2: iv_ruleSVarCase= ruleSVarCase EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSVarCaseRule()); 
            }
            pushFollow(FOLLOW_ruleSVarCase_in_entryRuleSVarCase3737);
            iv_ruleSVarCase=ruleSVarCase();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSVarCase; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSVarCase3747); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1715:1: ruleSVarCase returns [EObject current=null] : ( (lv_caseContent_0_0= ruleCaseContent ) )+ ;
    public final EObject ruleSVarCase() throws RecognitionException {
        EObject current = null;

        EObject lv_caseContent_0_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1718:28: ( ( (lv_caseContent_0_0= ruleCaseContent ) )+ )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1719:1: ( (lv_caseContent_0_0= ruleCaseContent ) )+
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1719:1: ( (lv_caseContent_0_0= ruleCaseContent ) )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==KEYWORD_27) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1720:1: (lv_caseContent_0_0= ruleCaseContent )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1720:1: (lv_caseContent_0_0= ruleCaseContent )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1721:3: lv_caseContent_0_0= ruleCaseContent
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSVarCaseAccess().getCaseContentCaseContentParserRuleCall_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleCaseContent_in_ruleSVarCase3792);
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
            	    if ( cnt50 >= 1 ) break loop50;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1745:1: entryRuleCaseContent returns [EObject current=null] : iv_ruleCaseContent= ruleCaseContent EOF ;
    public final EObject entryRuleCaseContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseContent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1746:2: (iv_ruleCaseContent= ruleCaseContent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1747:2: iv_ruleCaseContent= ruleCaseContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseContentRule()); 
            }
            pushFollow(FOLLOW_ruleCaseContent_in_entryRuleCaseContent3827);
            iv_ruleCaseContent=ruleCaseContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCaseContent3837); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1754:1: ruleCaseContent returns [EObject current=null] : ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) ( ( (lv_content_5_0= ruleTableContent ) ) | ( (lv_content_6_0= ruleValueContent ) ) | ( (lv_content_7_0= ruleSumContent ) ) ) otherlv_8= KEYWORD_14 ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1757:28: ( ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) ( ( (lv_content_5_0= ruleTableContent ) ) | ( (lv_content_6_0= ruleValueContent ) ) | ( (lv_content_7_0= ruleSumContent ) ) ) otherlv_8= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1758:1: ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) ( ( (lv_content_5_0= ruleTableContent ) ) | ( (lv_content_6_0= ruleValueContent ) ) | ( (lv_content_7_0= ruleSumContent ) ) ) otherlv_8= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1758:1: ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) ( ( (lv_content_5_0= ruleTableContent ) ) | ( (lv_content_6_0= ruleValueContent ) ) | ( (lv_content_7_0= ruleSumContent ) ) ) otherlv_8= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1758:2: (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) ( ( (lv_content_5_0= ruleTableContent ) ) | ( (lv_content_6_0= ruleValueContent ) ) | ( (lv_content_7_0= ruleSumContent ) ) ) otherlv_8= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1758:2: (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==KEYWORD_27) ) {
                int LA51_1 = input.LA(2);

                if ( (synpred58_InternalWreslEditorParser()) ) {
                    alt51=1;
                }
                else if ( (true) ) {
                    alt51=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1759:2: otherlv_0= KEYWORD_27
                    {
                    otherlv_0=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_ruleCaseContent3876); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getCaseContentAccess().getCaseKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1765:2: otherlv_1= KEYWORD_27
                    {
                    otherlv_1=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_ruleCaseContent3894); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getCaseContentAccess().getCASEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1769:2: ( (lv_caseName_2_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1770:1: (lv_caseName_2_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1770:1: (lv_caseName_2_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1771:3: lv_caseName_2_0= RULE_ID
            {
            lv_caseName_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCaseContent3911); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleCaseContent3929); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getCaseContentAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1792:1: ( (lv_condition_4_0= ruleCondition ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1793:1: (lv_condition_4_0= ruleCondition )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1793:1: (lv_condition_4_0= ruleCondition )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1794:3: lv_condition_4_0= ruleCondition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCaseContentAccess().getConditionConditionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCondition_in_ruleCaseContent3949);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1810:2: ( ( (lv_content_5_0= ruleTableContent ) ) | ( (lv_content_6_0= ruleValueContent ) ) | ( (lv_content_7_0= ruleSumContent ) ) )
            int alt52=3;
            switch ( input.LA(1) ) {
            case KEYWORD_41:
                {
                alt52=1;
                }
                break;
            case KEYWORD_38:
                {
                alt52=2;
                }
                break;
            case KEYWORD_24:
                {
                alt52=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1810:3: ( (lv_content_5_0= ruleTableContent ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1810:3: ( (lv_content_5_0= ruleTableContent ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1811:1: (lv_content_5_0= ruleTableContent )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1811:1: (lv_content_5_0= ruleTableContent )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1812:3: lv_content_5_0= ruleTableContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseContentAccess().getContentTableContentParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTableContent_in_ruleCaseContent3971);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1829:6: ( (lv_content_6_0= ruleValueContent ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1829:6: ( (lv_content_6_0= ruleValueContent ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1830:1: (lv_content_6_0= ruleValueContent )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1830:1: (lv_content_6_0= ruleValueContent )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1831:3: lv_content_6_0= ruleValueContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseContentAccess().getContentValueContentParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleValueContent_in_ruleCaseContent3998);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1848:6: ( (lv_content_7_0= ruleSumContent ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1848:6: ( (lv_content_7_0= ruleSumContent ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1849:1: (lv_content_7_0= ruleSumContent )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1849:1: (lv_content_7_0= ruleSumContent )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1850:3: lv_content_7_0= ruleSumContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getCaseContentAccess().getContentSumContentParserRuleCall_4_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSumContent_in_ruleCaseContent4025);
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

            otherlv_8=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleCaseContent4039); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1879:1: entryRuleSumContent returns [EObject current=null] : iv_ruleSumContent= ruleSumContent EOF ;
    public final EObject entryRuleSumContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSumContent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1880:2: (iv_ruleSumContent= ruleSumContent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1881:2: iv_ruleSumContent= ruleSumContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSumContentRule()); 
            }
            pushFollow(FOLLOW_ruleSumContent_in_entryRuleSumContent4073);
            iv_ruleSumContent=ruleSumContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSumContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSumContent4083); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1888:1: ruleSumContent returns [EObject current=null] : ( (otherlv_0= KEYWORD_24 | otherlv_1= KEYWORD_24 ) ( (lv_header_2_0= ruleSumHeader ) ) ( (lv_expression_3_0= ruleExpression ) ) ) ;
    public final EObject ruleSumContent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_header_2_0 = null;

        EObject lv_expression_3_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1891:28: ( ( (otherlv_0= KEYWORD_24 | otherlv_1= KEYWORD_24 ) ( (lv_header_2_0= ruleSumHeader ) ) ( (lv_expression_3_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1892:1: ( (otherlv_0= KEYWORD_24 | otherlv_1= KEYWORD_24 ) ( (lv_header_2_0= ruleSumHeader ) ) ( (lv_expression_3_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1892:1: ( (otherlv_0= KEYWORD_24 | otherlv_1= KEYWORD_24 ) ( (lv_header_2_0= ruleSumHeader ) ) ( (lv_expression_3_0= ruleExpression ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1892:2: (otherlv_0= KEYWORD_24 | otherlv_1= KEYWORD_24 ) ( (lv_header_2_0= ruleSumHeader ) ) ( (lv_expression_3_0= ruleExpression ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1892:2: (otherlv_0= KEYWORD_24 | otherlv_1= KEYWORD_24 )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==KEYWORD_24) ) {
                int LA53_1 = input.LA(2);

                if ( (synpred61_InternalWreslEditorParser()) ) {
                    alt53=1;
                }
                else if ( (true) ) {
                    alt53=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1893:2: otherlv_0= KEYWORD_24
                    {
                    otherlv_0=(Token)match(input,KEYWORD_24,FOLLOW_KEYWORD_24_in_ruleSumContent4122); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getSumContentAccess().getSumKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1899:2: otherlv_1= KEYWORD_24
                    {
                    otherlv_1=(Token)match(input,KEYWORD_24,FOLLOW_KEYWORD_24_in_ruleSumContent4140); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getSumContentAccess().getSUMKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1903:2: ( (lv_header_2_0= ruleSumHeader ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1904:1: (lv_header_2_0= ruleSumHeader )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1904:1: (lv_header_2_0= ruleSumHeader )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1905:3: lv_header_2_0= ruleSumHeader
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSumContentAccess().getHeaderSumHeaderParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleSumHeader_in_ruleSumContent4161);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1921:2: ( (lv_expression_3_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1922:1: (lv_expression_3_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1922:1: (lv_expression_3_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1923:3: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSumContentAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSumContent4182);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1947:1: entryRuleSumHeader returns [EObject current=null] : iv_ruleSumHeader= ruleSumHeader EOF ;
    public final EObject entryRuleSumHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSumHeader = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1948:2: (iv_ruleSumHeader= ruleSumHeader EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1949:2: iv_ruleSumHeader= ruleSumHeader EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSumHeaderRule()); 
            }
            pushFollow(FOLLOW_ruleSumHeader_in_entryRuleSumHeader4217);
            iv_ruleSumHeader=ruleSumHeader();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSumHeader; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSumHeader4227); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1956:1: ruleSumHeader returns [EObject current=null] : (otherlv_0= KEYWORD_1 otherlv_1= KEYWORD_19 ( (lv_expression1_2_0= ruleExpression ) ) otherlv_3= KEYWORD_5 ( (lv_expression2_4_0= ruleExpression ) ) (otherlv_5= KEYWORD_5 (otherlv_6= KEYWORD_6 )? this_INT_7= RULE_INT )? otherlv_8= KEYWORD_2 ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1959:28: ( (otherlv_0= KEYWORD_1 otherlv_1= KEYWORD_19 ( (lv_expression1_2_0= ruleExpression ) ) otherlv_3= KEYWORD_5 ( (lv_expression2_4_0= ruleExpression ) ) (otherlv_5= KEYWORD_5 (otherlv_6= KEYWORD_6 )? this_INT_7= RULE_INT )? otherlv_8= KEYWORD_2 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1960:1: (otherlv_0= KEYWORD_1 otherlv_1= KEYWORD_19 ( (lv_expression1_2_0= ruleExpression ) ) otherlv_3= KEYWORD_5 ( (lv_expression2_4_0= ruleExpression ) ) (otherlv_5= KEYWORD_5 (otherlv_6= KEYWORD_6 )? this_INT_7= RULE_INT )? otherlv_8= KEYWORD_2 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1960:1: (otherlv_0= KEYWORD_1 otherlv_1= KEYWORD_19 ( (lv_expression1_2_0= ruleExpression ) ) otherlv_3= KEYWORD_5 ( (lv_expression2_4_0= ruleExpression ) ) (otherlv_5= KEYWORD_5 (otherlv_6= KEYWORD_6 )? this_INT_7= RULE_INT )? otherlv_8= KEYWORD_2 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1961:2: otherlv_0= KEYWORD_1 otherlv_1= KEYWORD_19 ( (lv_expression1_2_0= ruleExpression ) ) otherlv_3= KEYWORD_5 ( (lv_expression2_4_0= ruleExpression ) ) (otherlv_5= KEYWORD_5 (otherlv_6= KEYWORD_6 )? this_INT_7= RULE_INT )? otherlv_8= KEYWORD_2
            {
            otherlv_0=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleSumHeader4265); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSumHeaderAccess().getLeftParenthesisKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,KEYWORD_19,FOLLOW_KEYWORD_19_in_ruleSumHeader4277); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getSumHeaderAccess().getIKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1970:1: ( (lv_expression1_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1971:1: (lv_expression1_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1971:1: (lv_expression1_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1972:3: lv_expression1_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSumHeaderAccess().getExpression1ExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSumHeader4297);
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

            otherlv_3=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleSumHeader4310); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSumHeaderAccess().getCommaKeyword_3());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1993:1: ( (lv_expression2_4_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1994:1: (lv_expression2_4_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1994:1: (lv_expression2_4_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1995:3: lv_expression2_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSumHeaderAccess().getExpression2ExpressionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleSumHeader4330);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2011:2: (otherlv_5= KEYWORD_5 (otherlv_6= KEYWORD_6 )? this_INT_7= RULE_INT )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==KEYWORD_5) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2012:2: otherlv_5= KEYWORD_5 (otherlv_6= KEYWORD_6 )? this_INT_7= RULE_INT
                    {
                    otherlv_5=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleSumHeader4344); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSumHeaderAccess().getCommaKeyword_5_0());
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2016:1: (otherlv_6= KEYWORD_6 )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==KEYWORD_6) ) {
                        alt54=1;
                    }
                    switch (alt54) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2017:2: otherlv_6= KEYWORD_6
                            {
                            otherlv_6=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleSumHeader4357); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getSumHeaderAccess().getHyphenMinusKeyword_5_1());
                                  
                            }

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSumHeader4369); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_7, grammarAccess.getSumHeaderAccess().getINTTerminalRuleCall_5_2()); 
                          
                    }

                    }
                    break;

            }

            otherlv_8=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleSumHeader4383); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2038:1: entryRuleValueContent returns [EObject current=null] : iv_ruleValueContent= ruleValueContent EOF ;
    public final EObject entryRuleValueContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueContent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2039:2: (iv_ruleValueContent= ruleValueContent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2040:2: iv_ruleValueContent= ruleValueContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueContentRule()); 
            }
            pushFollow(FOLLOW_ruleValueContent_in_entryRuleValueContent4417);
            iv_ruleValueContent=ruleValueContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueContent4427); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2047:1: ruleValueContent returns [EObject current=null] : ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleValueContent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2050:28: ( ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2051:1: ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2051:1: ( (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2051:2: (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 ) ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2051:2: (otherlv_0= KEYWORD_38 | otherlv_1= KEYWORD_38 )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==KEYWORD_38) ) {
                int LA56_1 = input.LA(2);

                if ( (synpred64_InternalWreslEditorParser()) ) {
                    alt56=1;
                }
                else if ( (true) ) {
                    alt56=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2052:2: otherlv_0= KEYWORD_38
                    {
                    otherlv_0=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_ruleValueContent4466); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getValueContentAccess().getValueKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2058:2: otherlv_1= KEYWORD_38
                    {
                    otherlv_1=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_ruleValueContent4484); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getValueContentAccess().getVALUEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2062:2: ( (lv_expression_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2063:1: (lv_expression_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2063:1: (lv_expression_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2064:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getValueContentAccess().getExpressionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleValueContent4505);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2088:1: entryRuleTableContent returns [EObject current=null] : iv_ruleTableContent= ruleTableContent EOF ;
    public final EObject entryRuleTableContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableContent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2089:2: (iv_ruleTableContent= ruleTableContent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2090:2: iv_ruleTableContent= ruleTableContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTableContentRule()); 
            }
            pushFollow(FOLLOW_ruleTableContent_in_entryRuleTableContent4540);
            iv_ruleTableContent=ruleTableContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTableContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableContent4550); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2097:1: ruleTableContent returns [EObject current=null] : ( (otherlv_0= KEYWORD_41 | otherlv_1= KEYWORD_41 ) ( (lv_tableName_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_28 | otherlv_4= KEYWORD_28 ) ( (lv_from_5_0= RULE_ID ) ) ( (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 ) ( (lv_given_8_0= ruleAssignment ) ) (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 ) ( (lv_use_11_0= RULE_ID ) ) )? ( (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 ) ( (lv_where_14_0= ruleWhereItems ) ) )? ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2100:28: ( ( (otherlv_0= KEYWORD_41 | otherlv_1= KEYWORD_41 ) ( (lv_tableName_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_28 | otherlv_4= KEYWORD_28 ) ( (lv_from_5_0= RULE_ID ) ) ( (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 ) ( (lv_given_8_0= ruleAssignment ) ) (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 ) ( (lv_use_11_0= RULE_ID ) ) )? ( (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 ) ( (lv_where_14_0= ruleWhereItems ) ) )? ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2101:1: ( (otherlv_0= KEYWORD_41 | otherlv_1= KEYWORD_41 ) ( (lv_tableName_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_28 | otherlv_4= KEYWORD_28 ) ( (lv_from_5_0= RULE_ID ) ) ( (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 ) ( (lv_given_8_0= ruleAssignment ) ) (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 ) ( (lv_use_11_0= RULE_ID ) ) )? ( (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 ) ( (lv_where_14_0= ruleWhereItems ) ) )? )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2101:1: ( (otherlv_0= KEYWORD_41 | otherlv_1= KEYWORD_41 ) ( (lv_tableName_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_28 | otherlv_4= KEYWORD_28 ) ( (lv_from_5_0= RULE_ID ) ) ( (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 ) ( (lv_given_8_0= ruleAssignment ) ) (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 ) ( (lv_use_11_0= RULE_ID ) ) )? ( (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 ) ( (lv_where_14_0= ruleWhereItems ) ) )? )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2101:2: (otherlv_0= KEYWORD_41 | otherlv_1= KEYWORD_41 ) ( (lv_tableName_2_0= RULE_ID ) ) (otherlv_3= KEYWORD_28 | otherlv_4= KEYWORD_28 ) ( (lv_from_5_0= RULE_ID ) ) ( (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 ) ( (lv_given_8_0= ruleAssignment ) ) (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 ) ( (lv_use_11_0= RULE_ID ) ) )? ( (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 ) ( (lv_where_14_0= ruleWhereItems ) ) )?
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2101:2: (otherlv_0= KEYWORD_41 | otherlv_1= KEYWORD_41 )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==KEYWORD_41) ) {
                int LA57_1 = input.LA(2);

                if ( (synpred65_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2102:2: otherlv_0= KEYWORD_41
                    {
                    otherlv_0=(Token)match(input,KEYWORD_41,FOLLOW_KEYWORD_41_in_ruleTableContent4589); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getTableContentAccess().getSelectKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2108:2: otherlv_1= KEYWORD_41
                    {
                    otherlv_1=(Token)match(input,KEYWORD_41,FOLLOW_KEYWORD_41_in_ruleTableContent4607); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getTableContentAccess().getSELECTKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2112:2: ( (lv_tableName_2_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2113:1: (lv_tableName_2_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2113:1: (lv_tableName_2_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2114:3: lv_tableName_2_0= RULE_ID
            {
            lv_tableName_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTableContent4624); if (state.failed) return current;
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2130:2: (otherlv_3= KEYWORD_28 | otherlv_4= KEYWORD_28 )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==KEYWORD_28) ) {
                int LA58_1 = input.LA(2);

                if ( (synpred66_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2131:2: otherlv_3= KEYWORD_28
                    {
                    otherlv_3=(Token)match(input,KEYWORD_28,FOLLOW_KEYWORD_28_in_ruleTableContent4643); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTableContentAccess().getFromKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2137:2: otherlv_4= KEYWORD_28
                    {
                    otherlv_4=(Token)match(input,KEYWORD_28,FOLLOW_KEYWORD_28_in_ruleTableContent4661); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getTableContentAccess().getFROMKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2141:2: ( (lv_from_5_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2142:1: (lv_from_5_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2142:1: (lv_from_5_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2143:3: lv_from_5_0= RULE_ID
            {
            lv_from_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTableContent4678); if (state.failed) return current;
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2159:2: ( (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 ) ( (lv_given_8_0= ruleAssignment ) ) (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 ) ( (lv_use_11_0= RULE_ID ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==KEYWORD_32) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2159:3: (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 ) ( (lv_given_8_0= ruleAssignment ) ) (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 ) ( (lv_use_11_0= RULE_ID ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2159:3: (otherlv_6= KEYWORD_32 | otherlv_7= KEYWORD_32 )
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==KEYWORD_32) ) {
                        int LA59_1 = input.LA(2);

                        if ( (synpred67_InternalWreslEditorParser()) ) {
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2160:2: otherlv_6= KEYWORD_32
                            {
                            otherlv_6=(Token)match(input,KEYWORD_32,FOLLOW_KEYWORD_32_in_ruleTableContent4698); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getTableContentAccess().getGivenKeyword_4_0_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2166:2: otherlv_7= KEYWORD_32
                            {
                            otherlv_7=(Token)match(input,KEYWORD_32,FOLLOW_KEYWORD_32_in_ruleTableContent4716); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_7, grammarAccess.getTableContentAccess().getGIVENKeyword_4_0_1());
                                  
                            }

                            }
                            break;

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2170:2: ( (lv_given_8_0= ruleAssignment ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2171:1: (lv_given_8_0= ruleAssignment )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2171:1: (lv_given_8_0= ruleAssignment )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2172:3: lv_given_8_0= ruleAssignment
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTableContentAccess().getGivenAssignmentParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleAssignment_in_ruleTableContent4737);
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

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2188:2: (otherlv_9= KEYWORD_25 | otherlv_10= KEYWORD_25 )
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==KEYWORD_25) ) {
                        int LA60_1 = input.LA(2);

                        if ( (synpred68_InternalWreslEditorParser()) ) {
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2189:2: otherlv_9= KEYWORD_25
                            {
                            otherlv_9=(Token)match(input,KEYWORD_25,FOLLOW_KEYWORD_25_in_ruleTableContent4751); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_9, grammarAccess.getTableContentAccess().getUseKeyword_4_2_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2195:2: otherlv_10= KEYWORD_25
                            {
                            otherlv_10=(Token)match(input,KEYWORD_25,FOLLOW_KEYWORD_25_in_ruleTableContent4769); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_10, grammarAccess.getTableContentAccess().getUSEKeyword_4_2_1());
                                  
                            }

                            }
                            break;

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2199:2: ( (lv_use_11_0= RULE_ID ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2200:1: (lv_use_11_0= RULE_ID )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2200:1: (lv_use_11_0= RULE_ID )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2201:3: lv_use_11_0= RULE_ID
                    {
                    lv_use_11_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTableContent4786); if (state.failed) return current;
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2217:4: ( (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 ) ( (lv_where_14_0= ruleWhereItems ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==KEYWORD_39) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2217:5: (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 ) ( (lv_where_14_0= ruleWhereItems ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2217:5: (otherlv_12= KEYWORD_39 | otherlv_13= KEYWORD_39 )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==KEYWORD_39) ) {
                        int LA62_1 = input.LA(2);

                        if ( (synpred70_InternalWreslEditorParser()) ) {
                            alt62=1;
                        }
                        else if ( (true) ) {
                            alt62=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 62, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 0, input);

                        throw nvae;
                    }
                    switch (alt62) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2218:2: otherlv_12= KEYWORD_39
                            {
                            otherlv_12=(Token)match(input,KEYWORD_39,FOLLOW_KEYWORD_39_in_ruleTableContent4808); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_12, grammarAccess.getTableContentAccess().getWhereKeyword_5_0_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2224:2: otherlv_13= KEYWORD_39
                            {
                            otherlv_13=(Token)match(input,KEYWORD_39,FOLLOW_KEYWORD_39_in_ruleTableContent4826); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_13, grammarAccess.getTableContentAccess().getWHEREKeyword_5_0_1());
                                  
                            }

                            }
                            break;

                    }

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2228:2: ( (lv_where_14_0= ruleWhereItems ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2229:1: (lv_where_14_0= ruleWhereItems )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2229:1: (lv_where_14_0= ruleWhereItems )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2230:3: lv_where_14_0= ruleWhereItems
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTableContentAccess().getWhereWhereItemsParserRuleCall_5_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleWhereItems_in_ruleTableContent4847);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2254:1: entryRuleWhereItems returns [EObject current=null] : iv_ruleWhereItems= ruleWhereItems EOF ;
    public final EObject entryRuleWhereItems() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWhereItems = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2255:2: (iv_ruleWhereItems= ruleWhereItems EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2256:2: iv_ruleWhereItems= ruleWhereItems EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getWhereItemsRule()); 
            }
            pushFollow(FOLLOW_ruleWhereItems_in_entryRuleWhereItems4884);
            iv_ruleWhereItems=ruleWhereItems();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleWhereItems; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleWhereItems4894); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2263:1: ruleWhereItems returns [EObject current=null] : ( ( (lv_assignment_0_0= ruleAssignment ) ) (otherlv_1= KEYWORD_5 ( (lv_assignment_2_0= ruleAssignment ) ) )* ) ;
    public final EObject ruleWhereItems() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_assignment_0_0 = null;

        EObject lv_assignment_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2266:28: ( ( ( (lv_assignment_0_0= ruleAssignment ) ) (otherlv_1= KEYWORD_5 ( (lv_assignment_2_0= ruleAssignment ) ) )* ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2267:1: ( ( (lv_assignment_0_0= ruleAssignment ) ) (otherlv_1= KEYWORD_5 ( (lv_assignment_2_0= ruleAssignment ) ) )* )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2267:1: ( ( (lv_assignment_0_0= ruleAssignment ) ) (otherlv_1= KEYWORD_5 ( (lv_assignment_2_0= ruleAssignment ) ) )* )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2267:2: ( (lv_assignment_0_0= ruleAssignment ) ) (otherlv_1= KEYWORD_5 ( (lv_assignment_2_0= ruleAssignment ) ) )*
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2267:2: ( (lv_assignment_0_0= ruleAssignment ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2268:1: (lv_assignment_0_0= ruleAssignment )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2268:1: (lv_assignment_0_0= ruleAssignment )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2269:3: lv_assignment_0_0= ruleAssignment
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getWhereItemsAccess().getAssignmentAssignmentParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAssignment_in_ruleWhereItems4940);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2285:2: (otherlv_1= KEYWORD_5 ( (lv_assignment_2_0= ruleAssignment ) ) )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==KEYWORD_5) ) {
                    alt64=1;
                }


                switch (alt64) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2286:2: otherlv_1= KEYWORD_5 ( (lv_assignment_2_0= ruleAssignment ) )
            	    {
            	    otherlv_1=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleWhereItems4954); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getWhereItemsAccess().getCommaKeyword_1_0());
            	          
            	    }
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2290:1: ( (lv_assignment_2_0= ruleAssignment ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2291:1: (lv_assignment_2_0= ruleAssignment )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2291:1: (lv_assignment_2_0= ruleAssignment )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2292:3: lv_assignment_2_0= ruleAssignment
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getWhereItemsAccess().getAssignmentAssignmentParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAssignment_in_ruleWhereItems4974);
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
            	    break loop64;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2316:1: entryRuleAssignment returns [EObject current=null] : iv_ruleAssignment= ruleAssignment EOF ;
    public final EObject entryRuleAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignment = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2317:2: (iv_ruleAssignment= ruleAssignment EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2318:2: iv_ruleAssignment= ruleAssignment EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentRule()); 
            }
            pushFollow(FOLLOW_ruleAssignment_in_entryRuleAssignment5011);
            iv_ruleAssignment=ruleAssignment();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignment; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAssignment5021); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2325:1: ruleAssignment returns [EObject current=null] : ( ( (lv_term_0_0= ruleTermSimple ) ) otherlv_1= KEYWORD_9 ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_term_0_0 = null;

        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2328:28: ( ( ( (lv_term_0_0= ruleTermSimple ) ) otherlv_1= KEYWORD_9 ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2329:1: ( ( (lv_term_0_0= ruleTermSimple ) ) otherlv_1= KEYWORD_9 ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2329:1: ( ( (lv_term_0_0= ruleTermSimple ) ) otherlv_1= KEYWORD_9 ( (lv_expression_2_0= ruleExpression ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2329:2: ( (lv_term_0_0= ruleTermSimple ) ) otherlv_1= KEYWORD_9 ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2329:2: ( (lv_term_0_0= ruleTermSimple ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2330:1: (lv_term_0_0= ruleTermSimple )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2330:1: (lv_term_0_0= ruleTermSimple )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2331:3: lv_term_0_0= ruleTermSimple
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentAccess().getTermTermSimpleParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTermSimple_in_ruleAssignment5067);
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

            otherlv_1=(Token)match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_ruleAssignment5080); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2352:1: ( (lv_expression_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2353:1: (lv_expression_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2353:1: (lv_expression_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2354:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAssignmentAccess().getExpressionExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleAssignment5100);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2378:1: entryRuleTermSimple returns [EObject current=null] : iv_ruleTermSimple= ruleTermSimple EOF ;
    public final EObject entryRuleTermSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTermSimple = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2379:2: (iv_ruleTermSimple= ruleTermSimple EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2380:2: iv_ruleTermSimple= ruleTermSimple EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTermSimpleRule()); 
            }
            pushFollow(FOLLOW_ruleTermSimple_in_entryRuleTermSimple5135);
            iv_ruleTermSimple=ruleTermSimple();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTermSimple; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTermSimple5145); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2387:1: ruleTermSimple returns [EObject current=null] : (this_ID_0= RULE_ID | ruleNumber | this_Function_2= ruleFunction ) ;
    public final EObject ruleTermSimple() throws RecognitionException {
        EObject current = null;

        Token this_ID_0=null;
        EObject this_Function_2 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2390:28: ( (this_ID_0= RULE_ID | ruleNumber | this_Function_2= ruleFunction ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2391:1: (this_ID_0= RULE_ID | ruleNumber | this_Function_2= ruleFunction )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2391:1: (this_ID_0= RULE_ID | ruleNumber | this_Function_2= ruleFunction )
            int alt65=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==KEYWORD_1||LA65_1==KEYWORD_11) ) {
                    alt65=3;
                }
                else if ( (LA65_1==EOF||LA65_1==KEYWORD_9) ) {
                    alt65=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA65_2 = input.LA(2);

                if ( (LA65_2==EOF||LA65_2==KEYWORD_9) ) {
                    alt65=2;
                }
                else if ( (LA65_2==KEYWORD_1) ) {
                    alt65=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 65, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_FLOAT:
                {
                alt65=2;
                }
                break;
            case RULE_MIN:
            case RULE_MAX:
                {
                alt65=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2391:2: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTermSimple5181); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_0, grammarAccess.getTermSimpleAccess().getIDTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2397:2: ruleNumber
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTermSimpleAccess().getNumberParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNumber_in_ruleTermSimple5205);
                    ruleNumber();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2409:2: this_Function_2= ruleFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getTermSimpleAccess().getFunctionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleFunction_in_ruleTermSimple5235);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2428:1: entryRuleLowerAndOrUpper returns [EObject current=null] : iv_ruleLowerAndOrUpper= ruleLowerAndOrUpper EOF ;
    public final EObject entryRuleLowerAndOrUpper() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerAndOrUpper = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2429:2: (iv_ruleLowerAndOrUpper= ruleLowerAndOrUpper EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2430:2: iv_ruleLowerAndOrUpper= ruleLowerAndOrUpper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerAndOrUpperRule()); 
            }
            pushFollow(FOLLOW_ruleLowerAndOrUpper_in_entryRuleLowerAndOrUpper5269);
            iv_ruleLowerAndOrUpper=ruleLowerAndOrUpper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLowerAndOrUpper; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLowerAndOrUpper5279); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2437:1: ruleLowerAndOrUpper returns [EObject current=null] : (this_lowerUpper_0= rulelowerUpper | this_upperLower_1= ruleupperLower ) ;
    public final EObject ruleLowerAndOrUpper() throws RecognitionException {
        EObject current = null;

        EObject this_lowerUpper_0 = null;

        EObject this_upperLower_1 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2440:28: ( (this_lowerUpper_0= rulelowerUpper | this_upperLower_1= ruleupperLower ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2441:1: (this_lowerUpper_0= rulelowerUpper | this_upperLower_1= ruleupperLower )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2441:1: (this_lowerUpper_0= rulelowerUpper | this_upperLower_1= ruleupperLower )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==KEYWORD_34) ) {
                alt66=1;
            }
            else if ( (LA66_0==KEYWORD_37) ) {
                alt66=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2442:2: this_lowerUpper_0= rulelowerUpper
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLowerAndOrUpperAccess().getLowerUpperParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_rulelowerUpper_in_ruleLowerAndOrUpper5329);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2455:2: this_upperLower_1= ruleupperLower
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getLowerAndOrUpperAccess().getUpperLowerParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleupperLower_in_ruleLowerAndOrUpper5359);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2474:1: entryRuleupperLower returns [EObject current=null] : iv_ruleupperLower= ruleupperLower EOF ;
    public final EObject entryRuleupperLower() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleupperLower = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2475:2: (iv_ruleupperLower= ruleupperLower EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2476:2: iv_ruleupperLower= ruleupperLower EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUpperLowerRule()); 
            }
            pushFollow(FOLLOW_ruleupperLower_in_entryRuleupperLower5393);
            iv_ruleupperLower=ruleupperLower();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleupperLower; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleupperLower5403); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2483:1: ruleupperLower returns [EObject current=null] : ( ( (lv_upper_0_0= ruleUpper ) ) ( (lv_lower_1_0= ruleLower ) )? ) ;
    public final EObject ruleupperLower() throws RecognitionException {
        EObject current = null;

        EObject lv_upper_0_0 = null;

        EObject lv_lower_1_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2486:28: ( ( ( (lv_upper_0_0= ruleUpper ) ) ( (lv_lower_1_0= ruleLower ) )? ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2487:1: ( ( (lv_upper_0_0= ruleUpper ) ) ( (lv_lower_1_0= ruleLower ) )? )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2487:1: ( ( (lv_upper_0_0= ruleUpper ) ) ( (lv_lower_1_0= ruleLower ) )? )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2487:2: ( (lv_upper_0_0= ruleUpper ) ) ( (lv_lower_1_0= ruleLower ) )?
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2487:2: ( (lv_upper_0_0= ruleUpper ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2488:1: (lv_upper_0_0= ruleUpper )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2488:1: (lv_upper_0_0= ruleUpper )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2489:3: lv_upper_0_0= ruleUpper
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getUpperLowerAccess().getUpperUpperParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUpper_in_ruleupperLower5449);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2505:2: ( (lv_lower_1_0= ruleLower ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==KEYWORD_34) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2506:1: (lv_lower_1_0= ruleLower )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2506:1: (lv_lower_1_0= ruleLower )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2507:3: lv_lower_1_0= ruleLower
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUpperLowerAccess().getLowerLowerParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLower_in_ruleupperLower5470);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2531:1: entryRulelowerUpper returns [EObject current=null] : iv_rulelowerUpper= rulelowerUpper EOF ;
    public final EObject entryRulelowerUpper() throws RecognitionException {
        EObject current = null;

        EObject iv_rulelowerUpper = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2532:2: (iv_rulelowerUpper= rulelowerUpper EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2533:2: iv_rulelowerUpper= rulelowerUpper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerUpperRule()); 
            }
            pushFollow(FOLLOW_rulelowerUpper_in_entryRulelowerUpper5506);
            iv_rulelowerUpper=rulelowerUpper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulelowerUpper; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulelowerUpper5516); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2540:1: rulelowerUpper returns [EObject current=null] : ( ( (lv_lower_0_0= ruleLower ) ) ( (lv_upper_1_0= ruleUpper ) )? ) ;
    public final EObject rulelowerUpper() throws RecognitionException {
        EObject current = null;

        EObject lv_lower_0_0 = null;

        EObject lv_upper_1_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2543:28: ( ( ( (lv_lower_0_0= ruleLower ) ) ( (lv_upper_1_0= ruleUpper ) )? ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2544:1: ( ( (lv_lower_0_0= ruleLower ) ) ( (lv_upper_1_0= ruleUpper ) )? )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2544:1: ( ( (lv_lower_0_0= ruleLower ) ) ( (lv_upper_1_0= ruleUpper ) )? )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2544:2: ( (lv_lower_0_0= ruleLower ) ) ( (lv_upper_1_0= ruleUpper ) )?
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2544:2: ( (lv_lower_0_0= ruleLower ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2545:1: (lv_lower_0_0= ruleLower )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2545:1: (lv_lower_0_0= ruleLower )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2546:3: lv_lower_0_0= ruleLower
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerUpperAccess().getLowerLowerParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleLower_in_rulelowerUpper5562);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2562:2: ( (lv_upper_1_0= ruleUpper ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==KEYWORD_37) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2563:1: (lv_upper_1_0= ruleUpper )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2563:1: (lv_upper_1_0= ruleUpper )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2564:3: lv_upper_1_0= ruleUpper
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLowerUpperAccess().getUpperUpperParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleUpper_in_rulelowerUpper5583);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2588:1: entryRuleUpper returns [EObject current=null] : iv_ruleUpper= ruleUpper EOF ;
    public final EObject entryRuleUpper() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpper = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2589:2: (iv_ruleUpper= ruleUpper EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2590:2: iv_ruleUpper= ruleUpper EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUpperRule()); 
            }
            pushFollow(FOLLOW_ruleUpper_in_entryRuleUpper5619);
            iv_ruleUpper=ruleUpper();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUpper; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUpper5629); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2597:1: ruleUpper returns [EObject current=null] : ( (otherlv_0= KEYWORD_37 | otherlv_1= KEYWORD_37 ) ( ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) ) ;
    public final EObject ruleUpper() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2600:28: ( ( (otherlv_0= KEYWORD_37 | otherlv_1= KEYWORD_37 ) ( ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2601:1: ( (otherlv_0= KEYWORD_37 | otherlv_1= KEYWORD_37 ) ( ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2601:1: ( (otherlv_0= KEYWORD_37 | otherlv_1= KEYWORD_37 ) ( ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2601:2: (otherlv_0= KEYWORD_37 | otherlv_1= KEYWORD_37 ) ( ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) ) | ( (lv_expression_5_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2601:2: (otherlv_0= KEYWORD_37 | otherlv_1= KEYWORD_37 )
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==KEYWORD_37) ) {
                int LA69_1 = input.LA(2);

                if ( (synpred78_InternalWreslEditorParser()) ) {
                    alt69=1;
                }
                else if ( (true) ) {
                    alt69=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }
            switch (alt69) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2602:2: otherlv_0= KEYWORD_37
                    {
                    otherlv_0=(Token)match(input,KEYWORD_37,FOLLOW_KEYWORD_37_in_ruleUpper5668); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getUpperAccess().getUpperKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2608:2: otherlv_1= KEYWORD_37
                    {
                    otherlv_1=(Token)match(input,KEYWORD_37,FOLLOW_KEYWORD_37_in_ruleUpper5686); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getUpperAccess().getUPPERKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2612:2: ( ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) ) | ( (lv_expression_5_0= ruleExpression ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==KEYWORD_51) ) {
                alt71=1;
            }
            else if ( (LA71_0==KEYWORD_1||LA71_0==KEYWORD_4||LA71_0==KEYWORD_6||(LA71_0>=RULE_MIN && LA71_0<=RULE_FLOAT)||LA71_0==RULE_ID) ) {
                alt71=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2612:3: ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2612:3: ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2612:4: () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2612:4: ()
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2613:2: 
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

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2621:2: (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 )
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==KEYWORD_51) ) {
                        int LA70_1 = input.LA(2);

                        if ( (synpred79_InternalWreslEditorParser()) ) {
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2622:2: otherlv_3= KEYWORD_51
                            {
                            otherlv_3=(Token)match(input,KEYWORD_51,FOLLOW_KEYWORD_51_in_ruleUpper5714); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getUpperAccess().getUnboundedKeyword_1_0_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2628:2: otherlv_4= KEYWORD_51
                            {
                            otherlv_4=(Token)match(input,KEYWORD_51,FOLLOW_KEYWORD_51_in_ruleUpper5732); if (state.failed) return current;
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2633:6: ( (lv_expression_5_0= ruleExpression ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2633:6: ( (lv_expression_5_0= ruleExpression ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2634:1: (lv_expression_5_0= ruleExpression )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2634:1: (lv_expression_5_0= ruleExpression )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2635:3: lv_expression_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getUpperAccess().getExpressionExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleUpper5760);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2659:1: entryRuleLower returns [EObject current=null] : iv_ruleLower= ruleLower EOF ;
    public final EObject entryRuleLower() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLower = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2660:2: (iv_ruleLower= ruleLower EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2661:2: iv_ruleLower= ruleLower EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerRule()); 
            }
            pushFollow(FOLLOW_ruleLower_in_entryRuleLower5796);
            iv_ruleLower=ruleLower();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLower; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLower5806); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2668:1: ruleLower returns [EObject current=null] : ( (otherlv_0= KEYWORD_34 | otherlv_1= KEYWORD_34 ) ( ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) ) ;
    public final EObject ruleLower() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2671:28: ( ( (otherlv_0= KEYWORD_34 | otherlv_1= KEYWORD_34 ) ( ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2672:1: ( (otherlv_0= KEYWORD_34 | otherlv_1= KEYWORD_34 ) ( ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2672:1: ( (otherlv_0= KEYWORD_34 | otherlv_1= KEYWORD_34 ) ( ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) ) | ( (lv_expression_5_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2672:2: (otherlv_0= KEYWORD_34 | otherlv_1= KEYWORD_34 ) ( ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) ) | ( (lv_expression_5_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2672:2: (otherlv_0= KEYWORD_34 | otherlv_1= KEYWORD_34 )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==KEYWORD_34) ) {
                int LA72_1 = input.LA(2);

                if ( (synpred81_InternalWreslEditorParser()) ) {
                    alt72=1;
                }
                else if ( (true) ) {
                    alt72=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 72, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2673:2: otherlv_0= KEYWORD_34
                    {
                    otherlv_0=(Token)match(input,KEYWORD_34,FOLLOW_KEYWORD_34_in_ruleLower5845); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getLowerAccess().getLowerKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2679:2: otherlv_1= KEYWORD_34
                    {
                    otherlv_1=(Token)match(input,KEYWORD_34,FOLLOW_KEYWORD_34_in_ruleLower5863); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLowerAccess().getLOWERKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2683:2: ( ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) ) | ( (lv_expression_5_0= ruleExpression ) ) )
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==KEYWORD_51) ) {
                alt74=1;
            }
            else if ( (LA74_0==KEYWORD_1||LA74_0==KEYWORD_4||LA74_0==KEYWORD_6||(LA74_0>=RULE_MIN && LA74_0<=RULE_FLOAT)||LA74_0==RULE_ID) ) {
                alt74=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }
            switch (alt74) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2683:3: ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2683:3: ( () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2683:4: () (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2683:4: ()
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2684:2: 
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

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2692:2: (otherlv_3= KEYWORD_51 | otherlv_4= KEYWORD_51 )
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==KEYWORD_51) ) {
                        int LA73_1 = input.LA(2);

                        if ( (synpred82_InternalWreslEditorParser()) ) {
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2693:2: otherlv_3= KEYWORD_51
                            {
                            otherlv_3=(Token)match(input,KEYWORD_51,FOLLOW_KEYWORD_51_in_ruleLower5891); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_3, grammarAccess.getLowerAccess().getUnboundedKeyword_1_0_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2699:2: otherlv_4= KEYWORD_51
                            {
                            otherlv_4=(Token)match(input,KEYWORD_51,FOLLOW_KEYWORD_51_in_ruleLower5909); if (state.failed) return current;
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2704:6: ( (lv_expression_5_0= ruleExpression ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2704:6: ( (lv_expression_5_0= ruleExpression ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2705:1: (lv_expression_5_0= ruleExpression )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2705:1: (lv_expression_5_0= ruleExpression )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2706:3: lv_expression_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLowerAccess().getExpressionExpressionParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleLower5937);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2730:1: entryRuleGoal returns [EObject current=null] : iv_ruleGoal= ruleGoal EOF ;
    public final EObject entryRuleGoal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoal = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2731:2: (iv_ruleGoal= ruleGoal EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2732:2: iv_ruleGoal= ruleGoal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGoalRule()); 
            }
            pushFollow(FOLLOW_ruleGoal_in_entryRuleGoal5973);
            iv_ruleGoal=ruleGoal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGoal; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoal5983); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2739:1: ruleGoal returns [EObject current=null] : ( (otherlv_0= KEYWORD_29 | otherlv_1= KEYWORD_29 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) ) ) otherlv_8= KEYWORD_14 ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2742:28: ( ( (otherlv_0= KEYWORD_29 | otherlv_1= KEYWORD_29 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) ) ) otherlv_8= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2743:1: ( (otherlv_0= KEYWORD_29 | otherlv_1= KEYWORD_29 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) ) ) otherlv_8= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2743:1: ( (otherlv_0= KEYWORD_29 | otherlv_1= KEYWORD_29 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) ) ) otherlv_8= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2743:2: (otherlv_0= KEYWORD_29 | otherlv_1= KEYWORD_29 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_name_5_0= RULE_ID ) ) otherlv_6= KEYWORD_13 ( ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) ) ) otherlv_8= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2743:2: (otherlv_0= KEYWORD_29 | otherlv_1= KEYWORD_29 )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==KEYWORD_29) ) {
                int LA75_1 = input.LA(2);

                if ( (synpred84_InternalWreslEditorParser()) ) {
                    alt75=1;
                }
                else if ( (true) ) {
                    alt75=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 75, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2744:2: otherlv_0= KEYWORD_29
                    {
                    otherlv_0=(Token)match(input,KEYWORD_29,FOLLOW_KEYWORD_29_in_ruleGoal6022); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getGoalAccess().getGoalKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2750:2: otherlv_1= KEYWORD_29
                    {
                    otherlv_1=(Token)match(input,KEYWORD_29,FOLLOW_KEYWORD_29_in_ruleGoal6040); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getGoalAccess().getGOALKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2754:2: (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==KEYWORD_11) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2755:2: otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12
                    {
                    otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleGoal6054); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getGoalAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2759:1: ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2760:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2760:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2761:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2761:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    int alt76=2;
                    int LA76_0 = input.LA(1);

                    if ( (LA76_0==KEYWORD_33) ) {
                        int LA76_1 = input.LA(2);

                        if ( (synpred85_InternalWreslEditorParser()) ) {
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2762:3: lv_local_3_1= KEYWORD_33
                            {
                            lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleGoal6074); if (state.failed) return current;
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2775:8: lv_local_3_2= KEYWORD_33
                            {
                            lv_local_3_2=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleGoal6102); if (state.failed) return current;
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

                    otherlv_4=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleGoal6129); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getGoalAccess().getRightSquareBracketKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2796:3: ( (lv_name_5_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2797:1: (lv_name_5_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2797:1: (lv_name_5_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2798:3: lv_name_5_0= RULE_ID
            {
            lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoal6147); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleGoal6165); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getGoalAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2819:1: ( ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2820:1: ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2820:1: ( (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2821:1: (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2821:1: (lv_definition_7_1= ruleGoalSimple | lv_definition_7_2= ruleGoalCase )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==KEYWORD_1||LA78_0==KEYWORD_4||LA78_0==KEYWORD_6||(LA78_0>=RULE_MIN && LA78_0<=RULE_FLOAT)||LA78_0==RULE_ID) ) {
                alt78=1;
            }
            else if ( (LA78_0==KEYWORD_21) ) {
                alt78=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2822:3: lv_definition_7_1= ruleGoalSimple
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGoalAccess().getDefinitionGoalSimpleParserRuleCall_4_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleGoalSimple_in_ruleGoal6187);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2837:8: lv_definition_7_2= ruleGoalCase
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGoalAccess().getDefinitionGoalCaseParserRuleCall_4_0_1()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleGoalCase_in_ruleGoal6206);
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

            otherlv_8=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleGoal6222); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2868:1: entryRuleGoalCase returns [EObject current=null] : iv_ruleGoalCase= ruleGoalCase EOF ;
    public final EObject entryRuleGoalCase() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoalCase = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2869:2: (iv_ruleGoalCase= ruleGoalCase EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2870:2: iv_ruleGoalCase= ruleGoalCase EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGoalCaseRule()); 
            }
            pushFollow(FOLLOW_ruleGoalCase_in_entryRuleGoalCase6256);
            iv_ruleGoalCase=ruleGoalCase();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGoalCase; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoalCase6266); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2877:1: ruleGoalCase returns [EObject current=null] : ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) ( (lv_lhs_2_0= ruleExpression ) ) ( ( (lv_content_3_0= ruleGoalNoCaseContent ) ) | ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+ ) ) ;
    public final EObject ruleGoalCase() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_lhs_2_0 = null;

        EObject lv_content_3_0 = null;

        EObject lv_caseContent_4_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2880:28: ( ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) ( (lv_lhs_2_0= ruleExpression ) ) ( ( (lv_content_3_0= ruleGoalNoCaseContent ) ) | ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+ ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2881:1: ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) ( (lv_lhs_2_0= ruleExpression ) ) ( ( (lv_content_3_0= ruleGoalNoCaseContent ) ) | ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+ ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2881:1: ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) ( (lv_lhs_2_0= ruleExpression ) ) ( ( (lv_content_3_0= ruleGoalNoCaseContent ) ) | ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+ ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2881:2: (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) ( (lv_lhs_2_0= ruleExpression ) ) ( ( (lv_content_3_0= ruleGoalNoCaseContent ) ) | ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+ )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2881:2: (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 )
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==KEYWORD_21) ) {
                int LA79_1 = input.LA(2);

                if ( (synpred88_InternalWreslEditorParser()) ) {
                    alt79=1;
                }
                else if ( (true) ) {
                    alt79=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 79, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 79, 0, input);

                throw nvae;
            }
            switch (alt79) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2882:2: otherlv_0= KEYWORD_21
                    {
                    otherlv_0=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleGoalCase6305); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getGoalCaseAccess().getLhsKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2888:2: otherlv_1= KEYWORD_21
                    {
                    otherlv_1=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleGoalCase6323); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getGoalCaseAccess().getLHSKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2892:2: ( (lv_lhs_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2893:1: (lv_lhs_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2893:1: (lv_lhs_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2894:3: lv_lhs_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGoalCaseAccess().getLhsExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleGoalCase6344);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2910:2: ( ( (lv_content_3_0= ruleGoalNoCaseContent ) ) | ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+ )
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==KEYWORD_22) ) {
                alt81=1;
            }
            else if ( (LA81_0==KEYWORD_27) ) {
                alt81=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }
            switch (alt81) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2910:3: ( (lv_content_3_0= ruleGoalNoCaseContent ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2910:3: ( (lv_content_3_0= ruleGoalNoCaseContent ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2911:1: (lv_content_3_0= ruleGoalNoCaseContent )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2911:1: (lv_content_3_0= ruleGoalNoCaseContent )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2912:3: lv_content_3_0= ruleGoalNoCaseContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGoalCaseAccess().getContentGoalNoCaseContentParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleGoalNoCaseContent_in_ruleGoalCase6366);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2929:6: ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2929:6: ( (lv_caseContent_4_0= ruleGoalCaseContent ) )+
                    int cnt80=0;
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==KEYWORD_27) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2930:1: (lv_caseContent_4_0= ruleGoalCaseContent )
                    	    {
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2930:1: (lv_caseContent_4_0= ruleGoalCaseContent )
                    	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2931:3: lv_caseContent_4_0= ruleGoalCaseContent
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getGoalCaseAccess().getCaseContentGoalCaseContentParserRuleCall_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleGoalCaseContent_in_ruleGoalCase6393);
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
                    	    if ( cnt80 >= 1 ) break loop80;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(80, input);
                                throw eee;
                        }
                        cnt80++;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2955:1: entryRuleGoalCaseContent returns [EObject current=null] : iv_ruleGoalCaseContent= ruleGoalCaseContent EOF ;
    public final EObject entryRuleGoalCaseContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoalCaseContent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2956:2: (iv_ruleGoalCaseContent= ruleGoalCaseContent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2957:2: iv_ruleGoalCaseContent= ruleGoalCaseContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGoalCaseContentRule()); 
            }
            pushFollow(FOLLOW_ruleGoalCaseContent_in_entryRuleGoalCaseContent6430);
            iv_ruleGoalCaseContent=ruleGoalCaseContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGoalCaseContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoalCaseContent6440); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2964:1: ruleGoalCaseContent returns [EObject current=null] : ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) (otherlv_5= KEYWORD_22 | otherlv_6= KEYWORD_22 ) ( (lv_rhs_7_0= ruleExpression ) ) ( (lv_subContent_8_0= ruleSubContent ) )? otherlv_9= KEYWORD_14 ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2967:28: ( ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) (otherlv_5= KEYWORD_22 | otherlv_6= KEYWORD_22 ) ( (lv_rhs_7_0= ruleExpression ) ) ( (lv_subContent_8_0= ruleSubContent ) )? otherlv_9= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2968:1: ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) (otherlv_5= KEYWORD_22 | otherlv_6= KEYWORD_22 ) ( (lv_rhs_7_0= ruleExpression ) ) ( (lv_subContent_8_0= ruleSubContent ) )? otherlv_9= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2968:1: ( (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) (otherlv_5= KEYWORD_22 | otherlv_6= KEYWORD_22 ) ( (lv_rhs_7_0= ruleExpression ) ) ( (lv_subContent_8_0= ruleSubContent ) )? otherlv_9= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2968:2: (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 ) ( (lv_caseName_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( (lv_condition_4_0= ruleCondition ) ) (otherlv_5= KEYWORD_22 | otherlv_6= KEYWORD_22 ) ( (lv_rhs_7_0= ruleExpression ) ) ( (lv_subContent_8_0= ruleSubContent ) )? otherlv_9= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2968:2: (otherlv_0= KEYWORD_27 | otherlv_1= KEYWORD_27 )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==KEYWORD_27) ) {
                int LA82_1 = input.LA(2);

                if ( (synpred91_InternalWreslEditorParser()) ) {
                    alt82=1;
                }
                else if ( (true) ) {
                    alt82=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 82, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2969:2: otherlv_0= KEYWORD_27
                    {
                    otherlv_0=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_ruleGoalCaseContent6479); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getGoalCaseContentAccess().getCaseKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2975:2: otherlv_1= KEYWORD_27
                    {
                    otherlv_1=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_ruleGoalCaseContent6497); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getGoalCaseContentAccess().getCASEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2979:2: ( (lv_caseName_2_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2980:1: (lv_caseName_2_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2980:1: (lv_caseName_2_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2981:3: lv_caseName_2_0= RULE_ID
            {
            lv_caseName_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleGoalCaseContent6514); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleGoalCaseContent6532); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getGoalCaseContentAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3002:1: ( (lv_condition_4_0= ruleCondition ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3003:1: (lv_condition_4_0= ruleCondition )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3003:1: (lv_condition_4_0= ruleCondition )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3004:3: lv_condition_4_0= ruleCondition
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGoalCaseContentAccess().getConditionConditionParserRuleCall_3_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleCondition_in_ruleGoalCaseContent6552);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3020:2: (otherlv_5= KEYWORD_22 | otherlv_6= KEYWORD_22 )
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==KEYWORD_22) ) {
                int LA83_1 = input.LA(2);

                if ( (synpred92_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3021:2: otherlv_5= KEYWORD_22
                    {
                    otherlv_5=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleGoalCaseContent6566); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getGoalCaseContentAccess().getRhsKeyword_4_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3027:2: otherlv_6= KEYWORD_22
                    {
                    otherlv_6=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleGoalCaseContent6584); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getGoalCaseContentAccess().getRHSKeyword_4_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3031:2: ( (lv_rhs_7_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3032:1: (lv_rhs_7_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3032:1: (lv_rhs_7_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3033:3: lv_rhs_7_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGoalCaseContentAccess().getRhsExpressionParserRuleCall_5_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleGoalCaseContent6605);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3049:2: ( (lv_subContent_8_0= ruleSubContent ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==KEYWORD_21) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3050:1: (lv_subContent_8_0= ruleSubContent )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3050:1: (lv_subContent_8_0= ruleSubContent )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3051:3: lv_subContent_8_0= ruleSubContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGoalCaseContentAccess().getSubContentSubContentParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSubContent_in_ruleGoalCaseContent6626);
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

            otherlv_9=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleGoalCaseContent6640); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3080:1: entryRuleGoalNoCaseContent returns [EObject current=null] : iv_ruleGoalNoCaseContent= ruleGoalNoCaseContent EOF ;
    public final EObject entryRuleGoalNoCaseContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoalNoCaseContent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3081:2: (iv_ruleGoalNoCaseContent= ruleGoalNoCaseContent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3082:2: iv_ruleGoalNoCaseContent= ruleGoalNoCaseContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGoalNoCaseContentRule()); 
            }
            pushFollow(FOLLOW_ruleGoalNoCaseContent_in_entryRuleGoalNoCaseContent6674);
            iv_ruleGoalNoCaseContent=ruleGoalNoCaseContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGoalNoCaseContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoalNoCaseContent6684); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3089:1: ruleGoalNoCaseContent returns [EObject current=null] : ( (otherlv_0= KEYWORD_22 | otherlv_1= KEYWORD_22 ) ( (lv_rhs_2_0= ruleExpression ) ) ( (lv_subContent_3_0= ruleSubContent ) )? ) ;
    public final EObject ruleGoalNoCaseContent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_rhs_2_0 = null;

        EObject lv_subContent_3_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3092:28: ( ( (otherlv_0= KEYWORD_22 | otherlv_1= KEYWORD_22 ) ( (lv_rhs_2_0= ruleExpression ) ) ( (lv_subContent_3_0= ruleSubContent ) )? ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3093:1: ( (otherlv_0= KEYWORD_22 | otherlv_1= KEYWORD_22 ) ( (lv_rhs_2_0= ruleExpression ) ) ( (lv_subContent_3_0= ruleSubContent ) )? )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3093:1: ( (otherlv_0= KEYWORD_22 | otherlv_1= KEYWORD_22 ) ( (lv_rhs_2_0= ruleExpression ) ) ( (lv_subContent_3_0= ruleSubContent ) )? )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3093:2: (otherlv_0= KEYWORD_22 | otherlv_1= KEYWORD_22 ) ( (lv_rhs_2_0= ruleExpression ) ) ( (lv_subContent_3_0= ruleSubContent ) )?
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3093:2: (otherlv_0= KEYWORD_22 | otherlv_1= KEYWORD_22 )
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==KEYWORD_22) ) {
                int LA85_1 = input.LA(2);

                if ( (synpred94_InternalWreslEditorParser()) ) {
                    alt85=1;
                }
                else if ( (true) ) {
                    alt85=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 85, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3094:2: otherlv_0= KEYWORD_22
                    {
                    otherlv_0=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleGoalNoCaseContent6723); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getGoalNoCaseContentAccess().getRhsKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3100:2: otherlv_1= KEYWORD_22
                    {
                    otherlv_1=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleGoalNoCaseContent6741); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getGoalNoCaseContentAccess().getRHSKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3104:2: ( (lv_rhs_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3105:1: (lv_rhs_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3105:1: (lv_rhs_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3106:3: lv_rhs_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGoalNoCaseContentAccess().getRhsExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleGoalNoCaseContent6762);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3122:2: ( (lv_subContent_3_0= ruleSubContent ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==KEYWORD_21) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3123:1: (lv_subContent_3_0= ruleSubContent )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3123:1: (lv_subContent_3_0= ruleSubContent )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3124:3: lv_subContent_3_0= ruleSubContent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getGoalNoCaseContentAccess().getSubContentSubContentParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleSubContent_in_ruleGoalNoCaseContent6783);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3148:1: entryRuleSubContent returns [EObject current=null] : iv_ruleSubContent= ruleSubContent EOF ;
    public final EObject entryRuleSubContent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubContent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3149:2: (iv_ruleSubContent= ruleSubContent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3150:2: iv_ruleSubContent= ruleSubContent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSubContentRule()); 
            }
            pushFollow(FOLLOW_ruleSubContent_in_entryRuleSubContent6819);
            iv_ruleSubContent=ruleSubContent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSubContent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSubContent6829); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3157:1: ruleSubContent returns [EObject current=null] : ( ( ( (lv_gt_0_0= ruleLhsGtRhs ) ) ( (lv_lt_1_0= ruleLhsLtRhs ) )? ) | ( ( (lv_lt_2_0= ruleLhsLtRhs ) ) ( (lv_gt_3_0= ruleLhsGtRhs ) )? ) ) ;
    public final EObject ruleSubContent() throws RecognitionException {
        EObject current = null;

        EObject lv_gt_0_0 = null;

        EObject lv_lt_1_0 = null;

        EObject lv_lt_2_0 = null;

        EObject lv_gt_3_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3160:28: ( ( ( ( (lv_gt_0_0= ruleLhsGtRhs ) ) ( (lv_lt_1_0= ruleLhsLtRhs ) )? ) | ( ( (lv_lt_2_0= ruleLhsLtRhs ) ) ( (lv_gt_3_0= ruleLhsGtRhs ) )? ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3161:1: ( ( ( (lv_gt_0_0= ruleLhsGtRhs ) ) ( (lv_lt_1_0= ruleLhsLtRhs ) )? ) | ( ( (lv_lt_2_0= ruleLhsLtRhs ) ) ( (lv_gt_3_0= ruleLhsGtRhs ) )? ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3161:1: ( ( ( (lv_gt_0_0= ruleLhsGtRhs ) ) ( (lv_lt_1_0= ruleLhsLtRhs ) )? ) | ( ( (lv_lt_2_0= ruleLhsLtRhs ) ) ( (lv_gt_3_0= ruleLhsGtRhs ) )? ) )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==KEYWORD_21) ) {
                int LA89_1 = input.LA(2);

                if ( (LA89_1==KEYWORD_10) ) {
                    alt89=1;
                }
                else if ( (LA89_1==KEYWORD_8) ) {
                    alt89=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 89, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3161:2: ( ( (lv_gt_0_0= ruleLhsGtRhs ) ) ( (lv_lt_1_0= ruleLhsLtRhs ) )? )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3161:2: ( ( (lv_gt_0_0= ruleLhsGtRhs ) ) ( (lv_lt_1_0= ruleLhsLtRhs ) )? )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3161:3: ( (lv_gt_0_0= ruleLhsGtRhs ) ) ( (lv_lt_1_0= ruleLhsLtRhs ) )?
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3161:3: ( (lv_gt_0_0= ruleLhsGtRhs ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3162:1: (lv_gt_0_0= ruleLhsGtRhs )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3162:1: (lv_gt_0_0= ruleLhsGtRhs )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3163:3: lv_gt_0_0= ruleLhsGtRhs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubContentAccess().getGtLhsGtRhsParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLhsGtRhs_in_ruleSubContent6876);
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

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3179:2: ( (lv_lt_1_0= ruleLhsLtRhs ) )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==KEYWORD_21) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3180:1: (lv_lt_1_0= ruleLhsLtRhs )
                            {
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3180:1: (lv_lt_1_0= ruleLhsLtRhs )
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3181:3: lv_lt_1_0= ruleLhsLtRhs
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getSubContentAccess().getLtLhsLtRhsParserRuleCall_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLhsLtRhs_in_ruleSubContent6897);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3198:6: ( ( (lv_lt_2_0= ruleLhsLtRhs ) ) ( (lv_gt_3_0= ruleLhsGtRhs ) )? )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3198:6: ( ( (lv_lt_2_0= ruleLhsLtRhs ) ) ( (lv_gt_3_0= ruleLhsGtRhs ) )? )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3198:7: ( (lv_lt_2_0= ruleLhsLtRhs ) ) ( (lv_gt_3_0= ruleLhsGtRhs ) )?
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3198:7: ( (lv_lt_2_0= ruleLhsLtRhs ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3199:1: (lv_lt_2_0= ruleLhsLtRhs )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3199:1: (lv_lt_2_0= ruleLhsLtRhs )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3200:3: lv_lt_2_0= ruleLhsLtRhs
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSubContentAccess().getLtLhsLtRhsParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLhsLtRhs_in_ruleSubContent6927);
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

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3216:2: ( (lv_gt_3_0= ruleLhsGtRhs ) )?
                    int alt88=2;
                    int LA88_0 = input.LA(1);

                    if ( (LA88_0==KEYWORD_21) ) {
                        alt88=1;
                    }
                    switch (alt88) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3217:1: (lv_gt_3_0= ruleLhsGtRhs )
                            {
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3217:1: (lv_gt_3_0= ruleLhsGtRhs )
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3218:3: lv_gt_3_0= ruleLhsGtRhs
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getSubContentAccess().getGtLhsGtRhsParserRuleCall_1_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleLhsGtRhs_in_ruleSubContent6948);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3242:1: entryRuleLhsGtRhs returns [EObject current=null] : iv_ruleLhsGtRhs= ruleLhsGtRhs EOF ;
    public final EObject entryRuleLhsGtRhs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLhsGtRhs = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3243:2: (iv_ruleLhsGtRhs= ruleLhsGtRhs EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3244:2: iv_ruleLhsGtRhs= ruleLhsGtRhs EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLhsGtRhsRule()); 
            }
            pushFollow(FOLLOW_ruleLhsGtRhs_in_entryRuleLhsGtRhs6985);
            iv_ruleLhsGtRhs=ruleLhsGtRhs();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLhsGtRhs; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLhsGtRhs6995); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3251:1: ruleLhsGtRhs returns [EObject current=null] : ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_10 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3254:28: ( ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_10 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3255:1: ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_10 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3255:1: ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_10 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3255:2: (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_10 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3255:2: (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==KEYWORD_21) ) {
                int LA90_1 = input.LA(2);

                if ( (synpred99_InternalWreslEditorParser()) ) {
                    alt90=1;
                }
                else if ( (true) ) {
                    alt90=2;
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3256:2: otherlv_0= KEYWORD_21
                    {
                    otherlv_0=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleLhsGtRhs7034); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getLhsGtRhsAccess().getLhsKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3262:2: otherlv_1= KEYWORD_21
                    {
                    otherlv_1=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleLhsGtRhs7052); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLhsGtRhsAccess().getLHSKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            otherlv_2=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleLhsGtRhs7065); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLhsGtRhsAccess().getGreaterThanSignKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3271:1: (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==KEYWORD_22) ) {
                int LA91_1 = input.LA(2);

                if ( (synpred100_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3272:2: otherlv_3= KEYWORD_22
                    {
                    otherlv_3=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleLhsGtRhs7078); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getLhsGtRhsAccess().getRhsKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3278:2: otherlv_4= KEYWORD_22
                    {
                    otherlv_4=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleLhsGtRhs7096); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getLhsGtRhsAccess().getRHSKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3282:2: ( ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==KEYWORD_49) ) {
                alt93=1;
            }
            else if ( (LA93_0==KEYWORD_45) ) {
                alt93=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3282:3: ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3282:3: ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3282:4: () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3282:4: ()
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3283:2: 
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

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3291:2: (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 )
                    int alt92=2;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==KEYWORD_49) ) {
                        int LA92_1 = input.LA(2);

                        if ( (synpred101_InternalWreslEditorParser()) ) {
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3292:2: otherlv_6= KEYWORD_49
                            {
                            otherlv_6=(Token)match(input,KEYWORD_49,FOLLOW_KEYWORD_49_in_ruleLhsGtRhs7124); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getLhsGtRhsAccess().getConstrainKeyword_3_0_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3298:2: otherlv_7= KEYWORD_49
                            {
                            otherlv_7=(Token)match(input,KEYWORD_49,FOLLOW_KEYWORD_49_in_ruleLhsGtRhs7142); if (state.failed) return current;
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3303:6: ( (lv_penalty_8_0= rulePenalty ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3303:6: ( (lv_penalty_8_0= rulePenalty ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3304:1: (lv_penalty_8_0= rulePenalty )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3304:1: (lv_penalty_8_0= rulePenalty )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3305:3: lv_penalty_8_0= rulePenalty
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLhsGtRhsAccess().getPenaltyPenaltyParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePenalty_in_ruleLhsGtRhs7170);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3329:1: entryRuleLhsLtRhs returns [EObject current=null] : iv_ruleLhsLtRhs= ruleLhsLtRhs EOF ;
    public final EObject entryRuleLhsLtRhs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLhsLtRhs = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3330:2: (iv_ruleLhsLtRhs= ruleLhsLtRhs EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3331:2: iv_ruleLhsLtRhs= ruleLhsLtRhs EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLhsLtRhsRule()); 
            }
            pushFollow(FOLLOW_ruleLhsLtRhs_in_entryRuleLhsLtRhs7206);
            iv_ruleLhsLtRhs=ruleLhsLtRhs();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLhsLtRhs; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLhsLtRhs7216); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3338:1: ruleLhsLtRhs returns [EObject current=null] : ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_8 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3341:28: ( ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_8 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3342:1: ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_8 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3342:1: ( (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_8 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3342:2: (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 ) otherlv_2= KEYWORD_8 (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 ) ( ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3342:2: (otherlv_0= KEYWORD_21 | otherlv_1= KEYWORD_21 )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==KEYWORD_21) ) {
                int LA94_1 = input.LA(2);

                if ( (synpred103_InternalWreslEditorParser()) ) {
                    alt94=1;
                }
                else if ( (true) ) {
                    alt94=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 94, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3343:2: otherlv_0= KEYWORD_21
                    {
                    otherlv_0=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleLhsLtRhs7255); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getLhsLtRhsAccess().getLhsKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3349:2: otherlv_1= KEYWORD_21
                    {
                    otherlv_1=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_ruleLhsLtRhs7273); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getLhsLtRhsAccess().getLHSKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            otherlv_2=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleLhsLtRhs7286); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getLhsLtRhsAccess().getLessThanSignKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3358:1: (otherlv_3= KEYWORD_22 | otherlv_4= KEYWORD_22 )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==KEYWORD_22) ) {
                int LA95_1 = input.LA(2);

                if ( (synpred104_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3359:2: otherlv_3= KEYWORD_22
                    {
                    otherlv_3=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleLhsLtRhs7299); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getLhsLtRhsAccess().getRhsKeyword_2_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3365:2: otherlv_4= KEYWORD_22
                    {
                    otherlv_4=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_ruleLhsLtRhs7317); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getLhsLtRhsAccess().getRHSKeyword_2_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3369:2: ( ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) ) | ( (lv_penalty_8_0= rulePenalty ) ) )
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==KEYWORD_49) ) {
                alt97=1;
            }
            else if ( (LA97_0==KEYWORD_45) ) {
                alt97=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }
            switch (alt97) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3369:3: ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3369:3: ( () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3369:4: () (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3369:4: ()
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3370:2: 
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

                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3378:2: (otherlv_6= KEYWORD_49 | otherlv_7= KEYWORD_49 )
                    int alt96=2;
                    int LA96_0 = input.LA(1);

                    if ( (LA96_0==KEYWORD_49) ) {
                        int LA96_1 = input.LA(2);

                        if ( (synpred105_InternalWreslEditorParser()) ) {
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3379:2: otherlv_6= KEYWORD_49
                            {
                            otherlv_6=(Token)match(input,KEYWORD_49,FOLLOW_KEYWORD_49_in_ruleLhsLtRhs7345); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getLhsLtRhsAccess().getConstrainKeyword_3_0_1_0());
                                  
                            }

                            }
                            break;
                        case 2 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3385:2: otherlv_7= KEYWORD_49
                            {
                            otherlv_7=(Token)match(input,KEYWORD_49,FOLLOW_KEYWORD_49_in_ruleLhsLtRhs7363); if (state.failed) return current;
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3390:6: ( (lv_penalty_8_0= rulePenalty ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3390:6: ( (lv_penalty_8_0= rulePenalty ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3391:1: (lv_penalty_8_0= rulePenalty )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3391:1: (lv_penalty_8_0= rulePenalty )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3392:3: lv_penalty_8_0= rulePenalty
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getLhsLtRhsAccess().getPenaltyPenaltyParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_rulePenalty_in_ruleLhsLtRhs7391);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3416:1: entryRulePenalty returns [EObject current=null] : iv_rulePenalty= rulePenalty EOF ;
    public final EObject entryRulePenalty() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePenalty = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3417:2: (iv_rulePenalty= rulePenalty EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3418:2: iv_rulePenalty= rulePenalty EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPenaltyRule()); 
            }
            pushFollow(FOLLOW_rulePenalty_in_entryRulePenalty7427);
            iv_rulePenalty=rulePenalty();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePenalty; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePenalty7437); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3425:1: rulePenalty returns [EObject current=null] : ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject rulePenalty() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3428:28: ( ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) ( (lv_expression_2_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3429:1: ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3429:1: ( (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) ( (lv_expression_2_0= ruleExpression ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3429:2: (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 ) ( (lv_expression_2_0= ruleExpression ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3429:2: (otherlv_0= KEYWORD_45 | otherlv_1= KEYWORD_45 )
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==KEYWORD_45) ) {
                int LA98_1 = input.LA(2);

                if ( (synpred107_InternalWreslEditorParser()) ) {
                    alt98=1;
                }
                else if ( (true) ) {
                    alt98=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 98, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 98, 0, input);

                throw nvae;
            }
            switch (alt98) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3430:2: otherlv_0= KEYWORD_45
                    {
                    otherlv_0=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_rulePenalty7476); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getPenaltyAccess().getPenaltyKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3436:2: otherlv_1= KEYWORD_45
                    {
                    otherlv_1=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_rulePenalty7494); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getPenaltyAccess().getPENALTYKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3440:2: ( (lv_expression_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3441:1: (lv_expression_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3441:1: (lv_expression_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3442:3: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPenaltyAccess().getExpressionExpressionParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_rulePenalty7515);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3466:1: entryRuleGoalSimple returns [EObject current=null] : iv_ruleGoalSimple= ruleGoalSimple EOF ;
    public final EObject entryRuleGoalSimple() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGoalSimple = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3467:2: (iv_ruleGoalSimple= ruleGoalSimple EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3468:2: iv_ruleGoalSimple= ruleGoalSimple EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGoalSimpleRule()); 
            }
            pushFollow(FOLLOW_ruleGoalSimple_in_entryRuleGoalSimple7550);
            iv_ruleGoalSimple=ruleGoalSimple();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGoalSimple; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleGoalSimple7560); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3475:1: ruleGoalSimple returns [EObject current=null] : ( (lv_constraint_0_0= ruleConstraint ) ) ;
    public final EObject ruleGoalSimple() throws RecognitionException {
        EObject current = null;

        EObject lv_constraint_0_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3478:28: ( ( (lv_constraint_0_0= ruleConstraint ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3479:1: ( (lv_constraint_0_0= ruleConstraint ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3479:1: ( (lv_constraint_0_0= ruleConstraint ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3480:1: (lv_constraint_0_0= ruleConstraint )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3480:1: (lv_constraint_0_0= ruleConstraint )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3481:3: lv_constraint_0_0= ruleConstraint
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getGoalSimpleAccess().getConstraintConstraintParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConstraint_in_ruleGoalSimple7605);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3505:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3506:2: (iv_ruleConstraint= ruleConstraint EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3507:2: iv_ruleConstraint= ruleConstraint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstraintRule()); 
            }
            pushFollow(FOLLOW_ruleConstraint_in_entryRuleConstraint7639);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstraint; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraint7649); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3514:1: ruleConstraint returns [EObject current=null] : ( ( (lv_lhs_0_0= ruleExpression ) ) ( ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) ) ) ( (lv_rhs_2_0= ruleExpression ) ) ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        Token lv_operator_1_1=null;
        Token lv_operator_1_2=null;
        Token lv_operator_1_3=null;
        EObject lv_lhs_0_0 = null;

        EObject lv_rhs_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3517:28: ( ( ( (lv_lhs_0_0= ruleExpression ) ) ( ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) ) ) ( (lv_rhs_2_0= ruleExpression ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3518:1: ( ( (lv_lhs_0_0= ruleExpression ) ) ( ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) ) ) ( (lv_rhs_2_0= ruleExpression ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3518:1: ( ( (lv_lhs_0_0= ruleExpression ) ) ( ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) ) ) ( (lv_rhs_2_0= ruleExpression ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3518:2: ( (lv_lhs_0_0= ruleExpression ) ) ( ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) ) ) ( (lv_rhs_2_0= ruleExpression ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3518:2: ( (lv_lhs_0_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3519:1: (lv_lhs_0_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3519:1: (lv_lhs_0_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3520:3: lv_lhs_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstraintAccess().getLhsExpressionParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleConstraint7695);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3536:2: ( ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3537:1: ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3537:1: ( (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3538:1: (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3538:1: (lv_operator_1_1= KEYWORD_8 | lv_operator_1_2= KEYWORD_10 | lv_operator_1_3= KEYWORD_9 )
            int alt99=3;
            switch ( input.LA(1) ) {
            case KEYWORD_8:
                {
                alt99=1;
                }
                break;
            case KEYWORD_10:
                {
                alt99=2;
                }
                break;
            case KEYWORD_9:
                {
                alt99=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 99, 0, input);

                throw nvae;
            }

            switch (alt99) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3539:3: lv_operator_1_1= KEYWORD_8
                    {
                    lv_operator_1_1=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleConstraint7716); if (state.failed) return current;
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3552:8: lv_operator_1_2= KEYWORD_10
                    {
                    lv_operator_1_2=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleConstraint7744); if (state.failed) return current;
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3565:8: lv_operator_1_3= KEYWORD_9
                    {
                    lv_operator_1_3=(Token)match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_ruleConstraint7772); if (state.failed) return current;
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3581:2: ( (lv_rhs_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3582:1: (lv_rhs_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3582:1: (lv_rhs_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3583:3: lv_rhs_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getConstraintAccess().getRhsExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleConstraint7807);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3607:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3608:2: (iv_ruleModel= ruleModel EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3609:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel7842);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel7852); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3616:1: ruleModel returns [EObject current=null] : ( (otherlv_0= KEYWORD_35 | otherlv_1= KEYWORD_35 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( ( (lv_pattern_4_0= rulePattern ) ) | ( (lv_alias_5_0= ruleAlias ) ) )+ otherlv_6= KEYWORD_14 ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3619:28: ( ( (otherlv_0= KEYWORD_35 | otherlv_1= KEYWORD_35 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( ( (lv_pattern_4_0= rulePattern ) ) | ( (lv_alias_5_0= ruleAlias ) ) )+ otherlv_6= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3620:1: ( (otherlv_0= KEYWORD_35 | otherlv_1= KEYWORD_35 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( ( (lv_pattern_4_0= rulePattern ) ) | ( (lv_alias_5_0= ruleAlias ) ) )+ otherlv_6= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3620:1: ( (otherlv_0= KEYWORD_35 | otherlv_1= KEYWORD_35 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( ( (lv_pattern_4_0= rulePattern ) ) | ( (lv_alias_5_0= ruleAlias ) ) )+ otherlv_6= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3620:2: (otherlv_0= KEYWORD_35 | otherlv_1= KEYWORD_35 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 ( ( (lv_pattern_4_0= rulePattern ) ) | ( (lv_alias_5_0= ruleAlias ) ) )+ otherlv_6= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3620:2: (otherlv_0= KEYWORD_35 | otherlv_1= KEYWORD_35 )
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==KEYWORD_35) ) {
                int LA100_1 = input.LA(2);

                if ( (synpred110_InternalWreslEditorParser()) ) {
                    alt100=1;
                }
                else if ( (true) ) {
                    alt100=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 100, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 100, 0, input);

                throw nvae;
            }
            switch (alt100) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3621:2: otherlv_0= KEYWORD_35
                    {
                    otherlv_0=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_ruleModel7891); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getModelAccess().getModelKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3627:2: otherlv_1= KEYWORD_35
                    {
                    otherlv_1=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_ruleModel7909); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getModelAccess().getMODELKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3631:2: ( (lv_name_2_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3632:1: (lv_name_2_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3632:1: (lv_name_2_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3633:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleModel7926); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleModel7944); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3654:1: ( ( (lv_pattern_4_0= rulePattern ) ) | ( (lv_alias_5_0= ruleAlias ) ) )+
            int cnt101=0;
            loop101:
            do {
                int alt101=3;
                alt101 = dfa101.predict(input);
                switch (alt101) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3654:2: ( (lv_pattern_4_0= rulePattern ) )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3654:2: ( (lv_pattern_4_0= rulePattern ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3655:1: (lv_pattern_4_0= rulePattern )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3655:1: (lv_pattern_4_0= rulePattern )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3656:3: lv_pattern_4_0= rulePattern
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getPatternPatternParserRuleCall_3_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_rulePattern_in_ruleModel7965);
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
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3673:6: ( (lv_alias_5_0= ruleAlias ) )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3673:6: ( (lv_alias_5_0= ruleAlias ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3674:1: (lv_alias_5_0= ruleAlias )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3674:1: (lv_alias_5_0= ruleAlias )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3675:3: lv_alias_5_0= ruleAlias
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getAliasAliasParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAlias_in_ruleModel7992);
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
            	    if ( cnt101 >= 1 ) break loop101;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(101, input);
                        throw eee;
                }
                cnt101++;
            } while (true);

            otherlv_6=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleModel8007); if (state.failed) return current;
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


    // $ANTLR start "entryRuleSequence"
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3704:1: entryRuleSequence returns [EObject current=null] : iv_ruleSequence= ruleSequence EOF ;
    public final EObject entryRuleSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequence = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3705:2: (iv_ruleSequence= ruleSequence EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3706:2: iv_ruleSequence= ruleSequence EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSequenceRule()); 
            }
            pushFollow(FOLLOW_ruleSequence_in_entryRuleSequence8041);
            iv_ruleSequence=ruleSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSequence; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleSequence8051); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3713:1: ruleSequence returns [EObject current=null] : ( (otherlv_0= KEYWORD_47 | otherlv_1= KEYWORD_47 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 (otherlv_4= KEYWORD_35 | otherlv_5= KEYWORD_35 ) ( (otherlv_6= RULE_ID ) ) ( (lv_condition_7_0= ruleCondition ) )? (this_ORDER_8= RULE_ORDER ( (lv_order_9_0= RULE_INT ) ) )? otherlv_10= KEYWORD_14 ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3716:28: ( ( (otherlv_0= KEYWORD_47 | otherlv_1= KEYWORD_47 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 (otherlv_4= KEYWORD_35 | otherlv_5= KEYWORD_35 ) ( (otherlv_6= RULE_ID ) ) ( (lv_condition_7_0= ruleCondition ) )? (this_ORDER_8= RULE_ORDER ( (lv_order_9_0= RULE_INT ) ) )? otherlv_10= KEYWORD_14 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3717:1: ( (otherlv_0= KEYWORD_47 | otherlv_1= KEYWORD_47 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 (otherlv_4= KEYWORD_35 | otherlv_5= KEYWORD_35 ) ( (otherlv_6= RULE_ID ) ) ( (lv_condition_7_0= ruleCondition ) )? (this_ORDER_8= RULE_ORDER ( (lv_order_9_0= RULE_INT ) ) )? otherlv_10= KEYWORD_14 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3717:1: ( (otherlv_0= KEYWORD_47 | otherlv_1= KEYWORD_47 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 (otherlv_4= KEYWORD_35 | otherlv_5= KEYWORD_35 ) ( (otherlv_6= RULE_ID ) ) ( (lv_condition_7_0= ruleCondition ) )? (this_ORDER_8= RULE_ORDER ( (lv_order_9_0= RULE_INT ) ) )? otherlv_10= KEYWORD_14 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3717:2: (otherlv_0= KEYWORD_47 | otherlv_1= KEYWORD_47 ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= KEYWORD_13 (otherlv_4= KEYWORD_35 | otherlv_5= KEYWORD_35 ) ( (otherlv_6= RULE_ID ) ) ( (lv_condition_7_0= ruleCondition ) )? (this_ORDER_8= RULE_ORDER ( (lv_order_9_0= RULE_INT ) ) )? otherlv_10= KEYWORD_14
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3717:2: (otherlv_0= KEYWORD_47 | otherlv_1= KEYWORD_47 )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==KEYWORD_47) ) {
                int LA102_1 = input.LA(2);

                if ( (synpred113_InternalWreslEditorParser()) ) {
                    alt102=1;
                }
                else if ( (true) ) {
                    alt102=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 102, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3718:2: otherlv_0= KEYWORD_47
                    {
                    otherlv_0=(Token)match(input,KEYWORD_47,FOLLOW_KEYWORD_47_in_ruleSequence8090); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getSequenceAccess().getSequenceKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3724:2: otherlv_1= KEYWORD_47
                    {
                    otherlv_1=(Token)match(input,KEYWORD_47,FOLLOW_KEYWORD_47_in_ruleSequence8108); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getSequenceAccess().getSEQUENCEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3728:2: ( (lv_name_2_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3729:1: (lv_name_2_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3729:1: (lv_name_2_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3730:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSequence8125); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleSequence8143); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getSequenceAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3751:1: (otherlv_4= KEYWORD_35 | otherlv_5= KEYWORD_35 )
            int alt103=2;
            int LA103_0 = input.LA(1);

            if ( (LA103_0==KEYWORD_35) ) {
                int LA103_1 = input.LA(2);

                if ( (synpred114_InternalWreslEditorParser()) ) {
                    alt103=1;
                }
                else if ( (true) ) {
                    alt103=2;
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3752:2: otherlv_4= KEYWORD_35
                    {
                    otherlv_4=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_ruleSequence8156); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getSequenceAccess().getModelKeyword_3_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3758:2: otherlv_5= KEYWORD_35
                    {
                    otherlv_5=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_ruleSequence8174); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getSequenceAccess().getMODELKeyword_3_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3762:2: ( (otherlv_6= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3763:1: (otherlv_6= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3763:1: (otherlv_6= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3764:3: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getSequenceRule());
              	        }
                      
            }
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSequence8198); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_6, grammarAccess.getSequenceAccess().getModelModelCrossReference_4_0()); 
              	
            }

            }


            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3778:2: ( (lv_condition_7_0= ruleCondition ) )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==KEYWORD_48) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3779:1: (lv_condition_7_0= ruleCondition )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3779:1: (lv_condition_7_0= ruleCondition )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3780:3: lv_condition_7_0= ruleCondition
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSequenceAccess().getConditionConditionParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleCondition_in_ruleSequence8219);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3796:3: (this_ORDER_8= RULE_ORDER ( (lv_order_9_0= RULE_INT ) ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==RULE_ORDER) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3796:4: this_ORDER_8= RULE_ORDER ( (lv_order_9_0= RULE_INT ) )
                    {
                    this_ORDER_8=(Token)match(input,RULE_ORDER,FOLLOW_RULE_ORDER_in_ruleSequence8232); if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ORDER_8, grammarAccess.getSequenceAccess().getORDERTerminalRuleCall_6_0()); 
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3800:1: ( (lv_order_9_0= RULE_INT ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3801:1: (lv_order_9_0= RULE_INT )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3801:1: (lv_order_9_0= RULE_INT )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3802:3: lv_order_9_0= RULE_INT
                    {
                    lv_order_9_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleSequence8248); if (state.failed) return current;
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

            otherlv_10=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleSequence8268); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3831:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3832:2: (iv_ruleCondition= ruleCondition EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3833:2: iv_ruleCondition= ruleCondition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionRule()); 
            }
            pushFollow(FOLLOW_ruleCondition_in_entryRuleCondition8302);
            iv_ruleCondition=ruleCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCondition; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCondition8312); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3840:1: ruleCondition returns [EObject current=null] : ( (otherlv_0= KEYWORD_48 | otherlv_1= KEYWORD_48 ) ( ( (lv_logical_2_0= ruleLogicalExpression ) ) | ( () this_ALWAYS_4= RULE_ALWAYS ) ) ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token this_ALWAYS_4=null;
        EObject lv_logical_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3843:28: ( ( (otherlv_0= KEYWORD_48 | otherlv_1= KEYWORD_48 ) ( ( (lv_logical_2_0= ruleLogicalExpression ) ) | ( () this_ALWAYS_4= RULE_ALWAYS ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3844:1: ( (otherlv_0= KEYWORD_48 | otherlv_1= KEYWORD_48 ) ( ( (lv_logical_2_0= ruleLogicalExpression ) ) | ( () this_ALWAYS_4= RULE_ALWAYS ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3844:1: ( (otherlv_0= KEYWORD_48 | otherlv_1= KEYWORD_48 ) ( ( (lv_logical_2_0= ruleLogicalExpression ) ) | ( () this_ALWAYS_4= RULE_ALWAYS ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3844:2: (otherlv_0= KEYWORD_48 | otherlv_1= KEYWORD_48 ) ( ( (lv_logical_2_0= ruleLogicalExpression ) ) | ( () this_ALWAYS_4= RULE_ALWAYS ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3844:2: (otherlv_0= KEYWORD_48 | otherlv_1= KEYWORD_48 )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==KEYWORD_48) ) {
                int LA106_1 = input.LA(2);

                if ( (synpred117_InternalWreslEditorParser()) ) {
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3845:2: otherlv_0= KEYWORD_48
                    {
                    otherlv_0=(Token)match(input,KEYWORD_48,FOLLOW_KEYWORD_48_in_ruleCondition8351); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getConditionKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3851:2: otherlv_1= KEYWORD_48
                    {
                    otherlv_1=(Token)match(input,KEYWORD_48,FOLLOW_KEYWORD_48_in_ruleCondition8369); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getConditionAccess().getCONDITIONKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3855:2: ( ( (lv_logical_2_0= ruleLogicalExpression ) ) | ( () this_ALWAYS_4= RULE_ALWAYS ) )
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==KEYWORD_1||LA107_0==KEYWORD_4||LA107_0==KEYWORD_6||(LA107_0>=RULE_RANGE && LA107_0<=RULE_FLOAT)||LA107_0==RULE_NOT||LA107_0==RULE_ID) ) {
                alt107=1;
            }
            else if ( (LA107_0==RULE_ALWAYS) ) {
                alt107=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 107, 0, input);

                throw nvae;
            }
            switch (alt107) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3855:3: ( (lv_logical_2_0= ruleLogicalExpression ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3855:3: ( (lv_logical_2_0= ruleLogicalExpression ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3856:1: (lv_logical_2_0= ruleLogicalExpression )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3856:1: (lv_logical_2_0= ruleLogicalExpression )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3857:3: lv_logical_2_0= ruleLogicalExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionAccess().getLogicalLogicalExpressionParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleLogicalExpression_in_ruleCondition8391);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3874:6: ( () this_ALWAYS_4= RULE_ALWAYS )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3874:6: ( () this_ALWAYS_4= RULE_ALWAYS )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3874:7: () this_ALWAYS_4= RULE_ALWAYS
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3874:7: ()
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3875:2: 
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

                    this_ALWAYS_4=(Token)match(input,RULE_ALWAYS,FOLLOW_RULE_ALWAYS_in_ruleCondition8421); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3895:1: entryRuleLogicalExpression returns [EObject current=null] : iv_ruleLogicalExpression= ruleLogicalExpression EOF ;
    public final EObject entryRuleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalExpression = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3896:2: (iv_ruleLogicalExpression= ruleLogicalExpression EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3897:2: iv_ruleLogicalExpression= ruleLogicalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression8457);
            iv_ruleLogicalExpression=ruleLogicalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalExpression8467); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3904:1: ruleLogicalExpression returns [EObject current=null] : ( ( (lv_c1_0_0= ruleConditionalUnary ) ) ( ruleBinaryOp ( (lv_c2_2_0= ruleConditionalUnary ) ) )* ) ;
    public final EObject ruleLogicalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_c1_0_0 = null;

        EObject lv_c2_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3907:28: ( ( ( (lv_c1_0_0= ruleConditionalUnary ) ) ( ruleBinaryOp ( (lv_c2_2_0= ruleConditionalUnary ) ) )* ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3908:1: ( ( (lv_c1_0_0= ruleConditionalUnary ) ) ( ruleBinaryOp ( (lv_c2_2_0= ruleConditionalUnary ) ) )* )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3908:1: ( ( (lv_c1_0_0= ruleConditionalUnary ) ) ( ruleBinaryOp ( (lv_c2_2_0= ruleConditionalUnary ) ) )* )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3908:2: ( (lv_c1_0_0= ruleConditionalUnary ) ) ( ruleBinaryOp ( (lv_c2_2_0= ruleConditionalUnary ) ) )*
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3908:2: ( (lv_c1_0_0= ruleConditionalUnary ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3909:1: (lv_c1_0_0= ruleConditionalUnary )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3909:1: (lv_c1_0_0= ruleConditionalUnary )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3910:3: lv_c1_0_0= ruleConditionalUnary
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getC1ConditionalUnaryParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleConditionalUnary_in_ruleLogicalExpression8513);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3926:2: ( ruleBinaryOp ( (lv_c2_2_0= ruleConditionalUnary ) ) )*
            loop108:
            do {
                int alt108=2;
                int LA108_0 = input.LA(1);

                if ( ((LA108_0>=RULE_AND && LA108_0<=RULE_OR)) ) {
                    alt108=1;
                }


                switch (alt108) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3927:2: ruleBinaryOp ( (lv_c2_2_0= ruleConditionalUnary ) )
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	  /* */ 
            	      	
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getLogicalExpressionAccess().getBinaryOpParserRuleCall_1_0()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleBinaryOp_in_ruleLogicalExpression8533);
            	    ruleBinaryOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              afterParserOrEnumRuleCall();
            	          
            	    }
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3937:1: ( (lv_c2_2_0= ruleConditionalUnary ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3938:1: (lv_c2_2_0= ruleConditionalUnary )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3938:1: (lv_c2_2_0= ruleConditionalUnary )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3939:3: lv_c2_2_0= ruleConditionalUnary
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getLogicalExpressionAccess().getC2ConditionalUnaryParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleConditionalUnary_in_ruleLogicalExpression8553);
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
            	    break loop108;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3963:1: entryRuleBinaryOp returns [String current=null] : iv_ruleBinaryOp= ruleBinaryOp EOF ;
    public final String entryRuleBinaryOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBinaryOp = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3964:1: (iv_ruleBinaryOp= ruleBinaryOp EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3965:2: iv_ruleBinaryOp= ruleBinaryOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBinaryOpRule()); 
            }
            pushFollow(FOLLOW_ruleBinaryOp_in_entryRuleBinaryOp8591);
            iv_ruleBinaryOp=ruleBinaryOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBinaryOp.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleBinaryOp8602); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3972:1: ruleBinaryOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_OR_0= RULE_OR | this_AND_1= RULE_AND ) ;
    public final AntlrDatatypeRuleToken ruleBinaryOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_OR_0=null;
        Token this_AND_1=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3976:6: ( (this_OR_0= RULE_OR | this_AND_1= RULE_AND ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3977:1: (this_OR_0= RULE_OR | this_AND_1= RULE_AND )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3977:1: (this_OR_0= RULE_OR | this_AND_1= RULE_AND )
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==RULE_OR) ) {
                alt109=1;
            }
            else if ( (LA109_0==RULE_AND) ) {
                alt109=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 109, 0, input);

                throw nvae;
            }
            switch (alt109) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3977:6: this_OR_0= RULE_OR
                    {
                    this_OR_0=(Token)match(input,RULE_OR,FOLLOW_RULE_OR_in_ruleBinaryOp8642); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_OR_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_OR_0, grammarAccess.getBinaryOpAccess().getORTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3985:10: this_AND_1= RULE_AND
                    {
                    this_AND_1=(Token)match(input,RULE_AND,FOLLOW_RULE_AND_in_ruleBinaryOp8668); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4000:1: entryRuleConditionalUnary returns [EObject current=null] : iv_ruleConditionalUnary= ruleConditionalUnary EOF ;
    public final EObject entryRuleConditionalUnary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalUnary = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4001:2: (iv_ruleConditionalUnary= ruleConditionalUnary EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4002:2: iv_ruleConditionalUnary= ruleConditionalUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleConditionalUnary_in_entryRuleConditionalUnary8712);
            iv_ruleConditionalUnary=ruleConditionalUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalUnary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalUnary8722); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4009:1: ruleConditionalUnary returns [EObject current=null] : ( ( ruleConditionalNegation )? this_ConditionalTerm_1= ruleConditionalTerm ) ;
    public final EObject ruleConditionalUnary() throws RecognitionException {
        EObject current = null;

        EObject this_ConditionalTerm_1 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4012:28: ( ( ( ruleConditionalNegation )? this_ConditionalTerm_1= ruleConditionalTerm ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4013:1: ( ( ruleConditionalNegation )? this_ConditionalTerm_1= ruleConditionalTerm )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4013:1: ( ( ruleConditionalNegation )? this_ConditionalTerm_1= ruleConditionalTerm )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4013:2: ( ruleConditionalNegation )? this_ConditionalTerm_1= ruleConditionalTerm
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4013:2: ( ruleConditionalNegation )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==RULE_NOT) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4014:2: ruleConditionalNegation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConditionalUnaryAccess().getConditionalNegationParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleConditionalNegation_in_ruleConditionalUnary8767);
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
            pushFollow(FOLLOW_ruleConditionalTerm_in_ruleConditionalUnary8793);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4044:1: entryRuleConditionalNegation returns [String current=null] : iv_ruleConditionalNegation= ruleConditionalNegation EOF ;
    public final String entryRuleConditionalNegation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleConditionalNegation = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4045:1: (iv_ruleConditionalNegation= ruleConditionalNegation EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4046:2: iv_ruleConditionalNegation= ruleConditionalNegation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalNegationRule()); 
            }
            pushFollow(FOLLOW_ruleConditionalNegation_in_entryRuleConditionalNegation8828);
            iv_ruleConditionalNegation=ruleConditionalNegation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalNegation.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalNegation8839); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4053:1: ruleConditionalNegation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_NOT_0= RULE_NOT ;
    public final AntlrDatatypeRuleToken ruleConditionalNegation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NOT_0=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4057:6: (this_NOT_0= RULE_NOT )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4058:5: this_NOT_0= RULE_NOT
            {
            this_NOT_0=(Token)match(input,RULE_NOT,FOLLOW_RULE_NOT_in_ruleConditionalNegation8878); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4073:1: entryRuleConditionalTerm returns [EObject current=null] : iv_ruleConditionalTerm= ruleConditionalTerm EOF ;
    public final EObject entryRuleConditionalTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionalTerm = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4074:2: (iv_ruleConditionalTerm= ruleConditionalTerm EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4075:2: iv_ruleConditionalTerm= ruleConditionalTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionalTermRule()); 
            }
            pushFollow(FOLLOW_ruleConditionalTerm_in_entryRuleConditionalTerm8921);
            iv_ruleConditionalTerm=ruleConditionalTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionalTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleConditionalTerm8931); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4082:1: ruleConditionalTerm returns [EObject current=null] : ( ( ( (lv_e1_0_0= ruleExpression ) ) ruleRelation ( (lv_e2_2_0= ruleExpression ) ) ) | ruleLogicalFunction ) ;
    public final EObject ruleConditionalTerm() throws RecognitionException {
        EObject current = null;

        EObject lv_e1_0_0 = null;

        EObject lv_e2_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4085:28: ( ( ( ( (lv_e1_0_0= ruleExpression ) ) ruleRelation ( (lv_e2_2_0= ruleExpression ) ) ) | ruleLogicalFunction ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4086:1: ( ( ( (lv_e1_0_0= ruleExpression ) ) ruleRelation ( (lv_e2_2_0= ruleExpression ) ) ) | ruleLogicalFunction )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4086:1: ( ( ( (lv_e1_0_0= ruleExpression ) ) ruleRelation ( (lv_e2_2_0= ruleExpression ) ) ) | ruleLogicalFunction )
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==KEYWORD_1||LA111_0==KEYWORD_4||LA111_0==KEYWORD_6||(LA111_0>=RULE_MIN && LA111_0<=RULE_FLOAT)||LA111_0==RULE_ID) ) {
                alt111=1;
            }
            else if ( (LA111_0==RULE_RANGE) ) {
                alt111=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }
            switch (alt111) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4086:2: ( ( (lv_e1_0_0= ruleExpression ) ) ruleRelation ( (lv_e2_2_0= ruleExpression ) ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4086:2: ( ( (lv_e1_0_0= ruleExpression ) ) ruleRelation ( (lv_e2_2_0= ruleExpression ) ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4086:3: ( (lv_e1_0_0= ruleExpression ) ) ruleRelation ( (lv_e2_2_0= ruleExpression ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4086:3: ( (lv_e1_0_0= ruleExpression ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4087:1: (lv_e1_0_0= ruleExpression )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4087:1: (lv_e1_0_0= ruleExpression )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4088:3: lv_e1_0_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalTermAccess().getE1ExpressionParserRuleCall_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleConditionalTerm8978);
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
                    pushFollow(FOLLOW_ruleRelation_in_ruleConditionalTerm8997);
                    ruleRelation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4115:1: ( (lv_e2_2_0= ruleExpression ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4116:1: (lv_e2_2_0= ruleExpression )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4116:1: (lv_e2_2_0= ruleExpression )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4117:3: lv_e2_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getConditionalTermAccess().getE2ExpressionParserRuleCall_0_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleConditionalTerm9017);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4135:2: ruleLogicalFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getConditionalTermAccess().getLogicalFunctionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleLogicalFunction_in_ruleConditionalTerm9043);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4153:1: entryRuleRelation returns [String current=null] : iv_ruleRelation= ruleRelation EOF ;
    public final String entryRuleRelation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelation = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4154:1: (iv_ruleRelation= ruleRelation EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4155:2: iv_ruleRelation= ruleRelation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationRule()); 
            }
            pushFollow(FOLLOW_ruleRelation_in_entryRuleRelation9078);
            iv_ruleRelation=ruleRelation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelation.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelation9089); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4162:1: ruleRelation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= KEYWORD_10 | kw= KEYWORD_8 | kw= KEYWORD_18 | kw= KEYWORD_16 | kw= KEYWORD_17 | kw= KEYWORD_15 ) ;
    public final AntlrDatatypeRuleToken ruleRelation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4166:6: ( (kw= KEYWORD_10 | kw= KEYWORD_8 | kw= KEYWORD_18 | kw= KEYWORD_16 | kw= KEYWORD_17 | kw= KEYWORD_15 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4167:1: (kw= KEYWORD_10 | kw= KEYWORD_8 | kw= KEYWORD_18 | kw= KEYWORD_16 | kw= KEYWORD_17 | kw= KEYWORD_15 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4167:1: (kw= KEYWORD_10 | kw= KEYWORD_8 | kw= KEYWORD_18 | kw= KEYWORD_16 | kw= KEYWORD_17 | kw= KEYWORD_15 )
            int alt112=6;
            switch ( input.LA(1) ) {
            case KEYWORD_10:
                {
                alt112=1;
                }
                break;
            case KEYWORD_8:
                {
                alt112=2;
                }
                break;
            case KEYWORD_18:
                {
                alt112=3;
                }
                break;
            case KEYWORD_16:
                {
                alt112=4;
                }
                break;
            case KEYWORD_17:
                {
                alt112=5;
                }
                break;
            case KEYWORD_15:
                {
                alt112=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }

            switch (alt112) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4168:2: kw= KEYWORD_10
                    {
                    kw=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleRelation9127); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationAccess().getGreaterThanSignKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4175:2: kw= KEYWORD_8
                    {
                    kw=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleRelation9146); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationAccess().getLessThanSignKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4182:2: kw= KEYWORD_18
                    {
                    kw=(Token)match(input,KEYWORD_18,FOLLOW_KEYWORD_18_in_ruleRelation9165); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationAccess().getGreaterThanSignEqualsSignKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4189:2: kw= KEYWORD_16
                    {
                    kw=(Token)match(input,KEYWORD_16,FOLLOW_KEYWORD_16_in_ruleRelation9184); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationAccess().getLessThanSignEqualsSignKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4196:2: kw= KEYWORD_17
                    {
                    kw=(Token)match(input,KEYWORD_17,FOLLOW_KEYWORD_17_in_ruleRelation9203); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getRelationAccess().getEqualsSignEqualsSignKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4203:2: kw= KEYWORD_15
                    {
                    kw=(Token)match(input,KEYWORD_15,FOLLOW_KEYWORD_15_in_ruleRelation9222); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4216:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4217:2: (iv_ruleExpression= ruleExpression EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4218:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_ruleExpression_in_entryRuleExpression9261);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpression9271); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4225:1: ruleExpression returns [EObject current=null] : this_Add_0= ruleAdd ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_Add_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4228:28: (this_Add_0= ruleAdd )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4230:2: this_Add_0= ruleAdd
            {
            if ( state.backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getExpressionAccess().getAddParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleAdd_in_ruleExpression9320);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4249:1: entryRuleAdd returns [EObject current=null] : iv_ruleAdd= ruleAdd EOF ;
    public final EObject entryRuleAdd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdd = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4250:2: (iv_ruleAdd= ruleAdd EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4251:2: iv_ruleAdd= ruleAdd EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAddRule()); 
            }
            pushFollow(FOLLOW_ruleAdd_in_entryRuleAdd9353);
            iv_ruleAdd=ruleAdd();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdd; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAdd9363); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4258:1: ruleAdd returns [EObject current=null] : ( ( (lv_m1_0_0= ruleMultiply ) ) ( (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 ) ( (lv_m2_3_0= ruleMultiply ) ) )* ) ;
    public final EObject ruleAdd() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_m1_0_0 = null;

        EObject lv_m2_3_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4261:28: ( ( ( (lv_m1_0_0= ruleMultiply ) ) ( (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 ) ( (lv_m2_3_0= ruleMultiply ) ) )* ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4262:1: ( ( (lv_m1_0_0= ruleMultiply ) ) ( (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 ) ( (lv_m2_3_0= ruleMultiply ) ) )* )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4262:1: ( ( (lv_m1_0_0= ruleMultiply ) ) ( (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 ) ( (lv_m2_3_0= ruleMultiply ) ) )* )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4262:2: ( (lv_m1_0_0= ruleMultiply ) ) ( (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 ) ( (lv_m2_3_0= ruleMultiply ) ) )*
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4262:2: ( (lv_m1_0_0= ruleMultiply ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4263:1: (lv_m1_0_0= ruleMultiply )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4263:1: (lv_m1_0_0= ruleMultiply )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4264:3: lv_m1_0_0= ruleMultiply
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getAddAccess().getM1MultiplyParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleMultiply_in_ruleAdd9409);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4280:2: ( (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 ) ( (lv_m2_3_0= ruleMultiply ) ) )*
            loop114:
            do {
                int alt114=2;
                int LA114_0 = input.LA(1);

                if ( (LA114_0==KEYWORD_4||LA114_0==KEYWORD_6) ) {
                    alt114=1;
                }


                switch (alt114) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4280:3: (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 ) ( (lv_m2_3_0= ruleMultiply ) )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4280:3: (otherlv_1= KEYWORD_4 | otherlv_2= KEYWORD_6 )
            	    int alt113=2;
            	    int LA113_0 = input.LA(1);

            	    if ( (LA113_0==KEYWORD_4) ) {
            	        alt113=1;
            	    }
            	    else if ( (LA113_0==KEYWORD_6) ) {
            	        alt113=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 113, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt113) {
            	        case 1 :
            	            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4281:2: otherlv_1= KEYWORD_4
            	            {
            	            otherlv_1=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleAdd9424); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_1, grammarAccess.getAddAccess().getPlusSignKeyword_1_0_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4287:2: otherlv_2= KEYWORD_6
            	            {
            	            otherlv_2=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleAdd9442); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getAddAccess().getHyphenMinusKeyword_1_0_1());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4291:2: ( (lv_m2_3_0= ruleMultiply ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4292:1: (lv_m2_3_0= ruleMultiply )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4292:1: (lv_m2_3_0= ruleMultiply )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4293:3: lv_m2_3_0= ruleMultiply
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAddAccess().getM2MultiplyParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleMultiply_in_ruleAdd9463);
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
            	    break loop114;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4317:1: entryRuleMultiply returns [EObject current=null] : iv_ruleMultiply= ruleMultiply EOF ;
    public final EObject entryRuleMultiply() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiply = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4318:2: (iv_ruleMultiply= ruleMultiply EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4319:2: iv_ruleMultiply= ruleMultiply EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplyRule()); 
            }
            pushFollow(FOLLOW_ruleMultiply_in_entryRuleMultiply9500);
            iv_ruleMultiply=ruleMultiply();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiply; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiply9510); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4326:1: ruleMultiply returns [EObject current=null] : ( ( (lv_u1_0_0= ruleUnary ) ) ( (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 ) ( (lv_u2_3_0= ruleUnary ) ) )* ) ;
    public final EObject ruleMultiply() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_u1_0_0 = null;

        EObject lv_u2_3_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4329:28: ( ( ( (lv_u1_0_0= ruleUnary ) ) ( (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 ) ( (lv_u2_3_0= ruleUnary ) ) )* ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4330:1: ( ( (lv_u1_0_0= ruleUnary ) ) ( (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 ) ( (lv_u2_3_0= ruleUnary ) ) )* )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4330:1: ( ( (lv_u1_0_0= ruleUnary ) ) ( (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 ) ( (lv_u2_3_0= ruleUnary ) ) )* )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4330:2: ( (lv_u1_0_0= ruleUnary ) ) ( (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 ) ( (lv_u2_3_0= ruleUnary ) ) )*
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4330:2: ( (lv_u1_0_0= ruleUnary ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4331:1: (lv_u1_0_0= ruleUnary )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4331:1: (lv_u1_0_0= ruleUnary )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4332:3: lv_u1_0_0= ruleUnary
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMultiplyAccess().getU1UnaryParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleUnary_in_ruleMultiply9556);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4348:2: ( (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 ) ( (lv_u2_3_0= ruleUnary ) ) )*
            loop116:
            do {
                int alt116=2;
                int LA116_0 = input.LA(1);

                if ( (LA116_0==KEYWORD_3||LA116_0==KEYWORD_7) ) {
                    alt116=1;
                }


                switch (alt116) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4348:3: (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 ) ( (lv_u2_3_0= ruleUnary ) )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4348:3: (otherlv_1= KEYWORD_3 | otherlv_2= KEYWORD_7 )
            	    int alt115=2;
            	    int LA115_0 = input.LA(1);

            	    if ( (LA115_0==KEYWORD_3) ) {
            	        alt115=1;
            	    }
            	    else if ( (LA115_0==KEYWORD_7) ) {
            	        alt115=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 115, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt115) {
            	        case 1 :
            	            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4349:2: otherlv_1= KEYWORD_3
            	            {
            	            otherlv_1=(Token)match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_ruleMultiply9571); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_1, grammarAccess.getMultiplyAccess().getAsteriskKeyword_1_0_0());
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4355:2: otherlv_2= KEYWORD_7
            	            {
            	            otherlv_2=(Token)match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_ruleMultiply9589); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                  	newLeafNode(otherlv_2, grammarAccess.getMultiplyAccess().getSolidusKeyword_1_0_1());
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4359:2: ( (lv_u2_3_0= ruleUnary ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4360:1: (lv_u2_3_0= ruleUnary )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4360:1: (lv_u2_3_0= ruleUnary )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4361:3: lv_u2_3_0= ruleUnary
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMultiplyAccess().getU2UnaryParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleUnary_in_ruleMultiply9610);
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
            	    break loop116;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4385:1: entryRuleUnary returns [EObject current=null] : iv_ruleUnary= ruleUnary EOF ;
    public final EObject entryRuleUnary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnary = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4386:2: (iv_ruleUnary= ruleUnary EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4387:2: iv_ruleUnary= ruleUnary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryRule()); 
            }
            pushFollow(FOLLOW_ruleUnary_in_entryRuleUnary9647);
            iv_ruleUnary=ruleUnary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnary; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnary9657); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4394:1: ruleUnary returns [EObject current=null] : ( (otherlv_0= KEYWORD_4 | ruleNegation )? this_Term_2= ruleTerm ) ;
    public final EObject ruleUnary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject this_Term_2 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4397:28: ( ( (otherlv_0= KEYWORD_4 | ruleNegation )? this_Term_2= ruleTerm ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4398:1: ( (otherlv_0= KEYWORD_4 | ruleNegation )? this_Term_2= ruleTerm )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4398:1: ( (otherlv_0= KEYWORD_4 | ruleNegation )? this_Term_2= ruleTerm )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4398:2: (otherlv_0= KEYWORD_4 | ruleNegation )? this_Term_2= ruleTerm
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4398:2: (otherlv_0= KEYWORD_4 | ruleNegation )?
            int alt117=3;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==KEYWORD_4) ) {
                alt117=1;
            }
            else if ( (LA117_0==KEYWORD_6) ) {
                alt117=2;
            }
            switch (alt117) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4399:2: otherlv_0= KEYWORD_4
                    {
                    otherlv_0=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleUnary9696); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getUnaryAccess().getPlusSignKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4405:2: ruleNegation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getUnaryAccess().getNegationParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleNegation_in_ruleUnary9720);
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
            pushFollow(FOLLOW_ruleTerm_in_ruleUnary9746);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4435:1: entryRuleNegation returns [String current=null] : iv_ruleNegation= ruleNegation EOF ;
    public final String entryRuleNegation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNegation = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4436:1: (iv_ruleNegation= ruleNegation EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4437:2: iv_ruleNegation= ruleNegation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNegationRule()); 
            }
            pushFollow(FOLLOW_ruleNegation_in_entryRuleNegation9781);
            iv_ruleNegation=ruleNegation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNegation.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNegation9792); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4444:1: ruleNegation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= KEYWORD_6 ;
    public final AntlrDatatypeRuleToken ruleNegation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4448:6: (kw= KEYWORD_6 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4450:2: kw= KEYWORD_6
            {
            kw=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleNegation9829); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4463:1: entryRuleTerm returns [EObject current=null] : iv_ruleTerm= ruleTerm EOF ;
    public final EObject entryRuleTerm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTerm = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4464:2: (iv_ruleTerm= ruleTerm EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4465:2: iv_ruleTerm= ruleTerm EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTermRule()); 
            }
            pushFollow(FOLLOW_ruleTerm_in_entryRuleTerm9867);
            iv_ruleTerm=ruleTerm();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTerm; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTerm9877); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4472:1: ruleTerm returns [EObject current=null] : ( ( (lv_i_0_0= ruleIdent ) ) | ( (lv_n_1_0= ruleNumber ) ) | ( (lv_f_2_0= ruleFunction ) ) | (otherlv_3= KEYWORD_1 ( (lv_e2_4_0= ruleExpression ) ) otherlv_5= KEYWORD_2 ) ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4475:28: ( ( ( (lv_i_0_0= ruleIdent ) ) | ( (lv_n_1_0= ruleNumber ) ) | ( (lv_f_2_0= ruleFunction ) ) | (otherlv_3= KEYWORD_1 ( (lv_e2_4_0= ruleExpression ) ) otherlv_5= KEYWORD_2 ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4476:1: ( ( (lv_i_0_0= ruleIdent ) ) | ( (lv_n_1_0= ruleNumber ) ) | ( (lv_f_2_0= ruleFunction ) ) | (otherlv_3= KEYWORD_1 ( (lv_e2_4_0= ruleExpression ) ) otherlv_5= KEYWORD_2 ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4476:1: ( ( (lv_i_0_0= ruleIdent ) ) | ( (lv_n_1_0= ruleNumber ) ) | ( (lv_f_2_0= ruleFunction ) ) | (otherlv_3= KEYWORD_1 ( (lv_e2_4_0= ruleExpression ) ) otherlv_5= KEYWORD_2 ) )
            int alt118=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA118_1 = input.LA(2);

                if ( (LA118_1==EOF||LA118_1==KEYWORD_41||LA118_1==KEYWORD_34||(LA118_1>=KEYWORD_36 && LA118_1<=KEYWORD_38)||LA118_1==KEYWORD_27||LA118_1==KEYWORD_30||(LA118_1>=KEYWORD_21 && LA118_1<=KEYWORD_22)||(LA118_1>=KEYWORD_24 && LA118_1<=KEYWORD_18)||(LA118_1>=KEYWORD_2 && LA118_1<=KEYWORD_10)||LA118_1==KEYWORD_12||LA118_1==KEYWORD_14||(LA118_1>=RULE_AND && LA118_1<=RULE_OR)||LA118_1==RULE_ORDER) ) {
                    alt118=1;
                }
                else if ( (LA118_1==KEYWORD_1||LA118_1==KEYWORD_11) ) {
                    alt118=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 118, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA118_2 = input.LA(2);

                if ( (LA118_2==KEYWORD_1) ) {
                    alt118=3;
                }
                else if ( (LA118_2==EOF||LA118_2==KEYWORD_41||LA118_2==KEYWORD_34||(LA118_2>=KEYWORD_36 && LA118_2<=KEYWORD_38)||LA118_2==KEYWORD_27||LA118_2==KEYWORD_30||(LA118_2>=KEYWORD_21 && LA118_2<=KEYWORD_22)||(LA118_2>=KEYWORD_24 && LA118_2<=KEYWORD_18)||(LA118_2>=KEYWORD_2 && LA118_2<=KEYWORD_10)||LA118_2==KEYWORD_12||LA118_2==KEYWORD_14||(LA118_2>=RULE_AND && LA118_2<=RULE_OR)||LA118_2==RULE_ORDER) ) {
                    alt118=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 118, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_FLOAT:
                {
                alt118=2;
                }
                break;
            case RULE_MIN:
            case RULE_MAX:
                {
                alt118=3;
                }
                break;
            case KEYWORD_1:
                {
                alt118=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;
            }

            switch (alt118) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4476:2: ( (lv_i_0_0= ruleIdent ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4476:2: ( (lv_i_0_0= ruleIdent ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4477:1: (lv_i_0_0= ruleIdent )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4477:1: (lv_i_0_0= ruleIdent )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4478:3: lv_i_0_0= ruleIdent
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTermAccess().getIIdentParserRuleCall_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleIdent_in_ruleTerm9923);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4495:6: ( (lv_n_1_0= ruleNumber ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4495:6: ( (lv_n_1_0= ruleNumber ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4496:1: (lv_n_1_0= ruleNumber )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4496:1: (lv_n_1_0= ruleNumber )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4497:3: lv_n_1_0= ruleNumber
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTermAccess().getNNumberParserRuleCall_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleNumber_in_ruleTerm9950);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4514:6: ( (lv_f_2_0= ruleFunction ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4514:6: ( (lv_f_2_0= ruleFunction ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4515:1: (lv_f_2_0= ruleFunction )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4515:1: (lv_f_2_0= ruleFunction )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4516:3: lv_f_2_0= ruleFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTermAccess().getFFunctionParserRuleCall_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleFunction_in_ruleTerm9977);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4533:6: (otherlv_3= KEYWORD_1 ( (lv_e2_4_0= ruleExpression ) ) otherlv_5= KEYWORD_2 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4533:6: (otherlv_3= KEYWORD_1 ( (lv_e2_4_0= ruleExpression ) ) otherlv_5= KEYWORD_2 )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4534:2: otherlv_3= KEYWORD_1 ( (lv_e2_4_0= ruleExpression ) ) otherlv_5= KEYWORD_2
                    {
                    otherlv_3=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleTerm9997); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getTermAccess().getLeftParenthesisKeyword_3_0());
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4538:1: ( (lv_e2_4_0= ruleExpression ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4539:1: (lv_e2_4_0= ruleExpression )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4539:1: (lv_e2_4_0= ruleExpression )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4540:3: lv_e2_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTermAccess().getE2ExpressionParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleExpression_in_ruleTerm10017);
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

                    otherlv_5=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleTerm10030); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4569:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4570:2: (iv_ruleFunction= ruleFunction EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4571:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleFunction_in_entryRuleFunction10065);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleFunction10075); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4578:1: ruleFunction returns [EObject current=null] : (this_ExternalFunction_0= ruleExternalFunction | this_MaxFunction_1= ruleMaxFunction | this_MinFunction_2= ruleMinFunction | this_IntFunction_3= ruleIntFunction | ruleVarModel ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        EObject this_ExternalFunction_0 = null;

        EObject this_MaxFunction_1 = null;

        EObject this_MinFunction_2 = null;

        EObject this_IntFunction_3 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4581:28: ( (this_ExternalFunction_0= ruleExternalFunction | this_MaxFunction_1= ruleMaxFunction | this_MinFunction_2= ruleMinFunction | this_IntFunction_3= ruleIntFunction | ruleVarModel ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4582:1: (this_ExternalFunction_0= ruleExternalFunction | this_MaxFunction_1= ruleMaxFunction | this_MinFunction_2= ruleMinFunction | this_IntFunction_3= ruleIntFunction | ruleVarModel )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4582:1: (this_ExternalFunction_0= ruleExternalFunction | this_MaxFunction_1= ruleMaxFunction | this_MinFunction_2= ruleMinFunction | this_IntFunction_3= ruleIntFunction | ruleVarModel )
            int alt119=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA119_1 = input.LA(2);

                if ( (LA119_1==KEYWORD_11) ) {
                    alt119=5;
                }
                else if ( (LA119_1==KEYWORD_1) ) {
                    alt119=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 119, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_MAX:
                {
                alt119=2;
                }
                break;
            case RULE_MIN:
                {
                alt119=3;
                }
                break;
            case RULE_INT:
                {
                alt119=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);

                throw nvae;
            }

            switch (alt119) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4583:2: this_ExternalFunction_0= ruleExternalFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFunctionAccess().getExternalFunctionParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleExternalFunction_in_ruleFunction10125);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4596:2: this_MaxFunction_1= ruleMaxFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFunctionAccess().getMaxFunctionParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleMaxFunction_in_ruleFunction10155);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4609:2: this_MinFunction_2= ruleMinFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFunctionAccess().getMinFunctionParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_ruleMinFunction_in_ruleFunction10185);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4622:2: this_IntFunction_3= ruleIntFunction
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFunctionAccess().getIntFunctionParserRuleCall_3()); 
                          
                    }
                    pushFollow(FOLLOW_ruleIntFunction_in_ruleFunction10215);
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
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4635:2: ruleVarModel
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getFunctionAccess().getVarModelParserRuleCall_4()); 
                          
                    }
                    pushFollow(FOLLOW_ruleVarModel_in_ruleFunction10239);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4653:1: entryRuleExternalFunction returns [EObject current=null] : iv_ruleExternalFunction= ruleExternalFunction EOF ;
    public final EObject entryRuleExternalFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExternalFunction = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4654:2: (iv_ruleExternalFunction= ruleExternalFunction EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4655:2: iv_ruleExternalFunction= ruleExternalFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExternalFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleExternalFunction_in_entryRuleExternalFunction10273);
            iv_ruleExternalFunction=ruleExternalFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExternalFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleExternalFunction10283); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4662:1: ruleExternalFunction returns [EObject current=null] : (this_ID_0= RULE_ID otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4665:28: ( (this_ID_0= RULE_ID otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4666:1: (this_ID_0= RULE_ID otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4666:1: (this_ID_0= RULE_ID otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4666:2: this_ID_0= RULE_ID otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleExternalFunction10319); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getExternalFunctionAccess().getIDTerminalRuleCall_0()); 
                  
            }
            otherlv_1=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleExternalFunction10331); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getExternalFunctionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4675:1: ( (lv_e1_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4676:1: (lv_e1_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4676:1: (lv_e1_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4677:3: lv_e1_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getExternalFunctionAccess().getE1ExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleExternalFunction10351);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4693:2: (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==KEYWORD_5) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4694:2: otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleExternalFunction10365); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getExternalFunctionAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4698:1: ( (lv_e2_4_0= ruleExpression ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4699:1: (lv_e2_4_0= ruleExpression )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4699:1: (lv_e2_4_0= ruleExpression )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4700:3: lv_e2_4_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getExternalFunctionAccess().getE2ExpressionParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpression_in_ruleExternalFunction10385);
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
            	    break loop120;
                }
            } while (true);

            otherlv_5=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleExternalFunction10400); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4729:1: entryRuleMaxFunction returns [EObject current=null] : iv_ruleMaxFunction= ruleMaxFunction EOF ;
    public final EObject entryRuleMaxFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxFunction = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4730:2: (iv_ruleMaxFunction= ruleMaxFunction EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4731:2: iv_ruleMaxFunction= ruleMaxFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleMaxFunction_in_entryRuleMaxFunction10434);
            iv_ruleMaxFunction=ruleMaxFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMaxFunction10444); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4738:1: ruleMaxFunction returns [EObject current=null] : (this_MAX_0= RULE_MAX otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4741:28: ( (this_MAX_0= RULE_MAX otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4742:1: (this_MAX_0= RULE_MAX otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4742:1: (this_MAX_0= RULE_MAX otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4742:2: this_MAX_0= RULE_MAX otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2
            {
            this_MAX_0=(Token)match(input,RULE_MAX,FOLLOW_RULE_MAX_in_ruleMaxFunction10480); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_MAX_0, grammarAccess.getMaxFunctionAccess().getMAXTerminalRuleCall_0()); 
                  
            }
            otherlv_1=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleMaxFunction10492); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMaxFunctionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4751:1: ( (lv_e1_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4752:1: (lv_e1_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4752:1: (lv_e1_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4753:3: lv_e1_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMaxFunctionAccess().getE1ExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleMaxFunction10512);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4769:2: (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )*
            loop121:
            do {
                int alt121=2;
                int LA121_0 = input.LA(1);

                if ( (LA121_0==KEYWORD_5) ) {
                    alt121=1;
                }


                switch (alt121) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4770:2: otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleMaxFunction10526); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getMaxFunctionAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4774:1: ( (lv_e2_4_0= ruleExpression ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4775:1: (lv_e2_4_0= ruleExpression )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4775:1: (lv_e2_4_0= ruleExpression )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4776:3: lv_e2_4_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMaxFunctionAccess().getE2ExpressionParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpression_in_ruleMaxFunction10546);
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
            	    break loop121;
                }
            } while (true);

            otherlv_5=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleMaxFunction10561); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4805:1: entryRuleMinFunction returns [EObject current=null] : iv_ruleMinFunction= ruleMinFunction EOF ;
    public final EObject entryRuleMinFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinFunction = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4806:2: (iv_ruleMinFunction= ruleMinFunction EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4807:2: iv_ruleMinFunction= ruleMinFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMinFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleMinFunction_in_entryRuleMinFunction10595);
            iv_ruleMinFunction=ruleMinFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMinFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleMinFunction10605); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4814:1: ruleMinFunction returns [EObject current=null] : (this_MIN_0= RULE_MIN otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4817:28: ( (this_MIN_0= RULE_MIN otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4818:1: (this_MIN_0= RULE_MIN otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4818:1: (this_MIN_0= RULE_MIN otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4818:2: this_MIN_0= RULE_MIN otherlv_1= KEYWORD_1 ( (lv_e1_2_0= ruleExpression ) ) (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )* otherlv_5= KEYWORD_2
            {
            this_MIN_0=(Token)match(input,RULE_MIN,FOLLOW_RULE_MIN_in_ruleMinFunction10641); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_MIN_0, grammarAccess.getMinFunctionAccess().getMINTerminalRuleCall_0()); 
                  
            }
            otherlv_1=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleMinFunction10653); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getMinFunctionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4827:1: ( (lv_e1_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4828:1: (lv_e1_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4828:1: (lv_e1_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4829:3: lv_e1_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMinFunctionAccess().getE1ExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleMinFunction10673);
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

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4845:2: (otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) ) )*
            loop122:
            do {
                int alt122=2;
                int LA122_0 = input.LA(1);

                if ( (LA122_0==KEYWORD_5) ) {
                    alt122=1;
                }


                switch (alt122) {
            	case 1 :
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4846:2: otherlv_3= KEYWORD_5 ( (lv_e2_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleMinFunction10687); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getMinFunctionAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4850:1: ( (lv_e2_4_0= ruleExpression ) )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4851:1: (lv_e2_4_0= ruleExpression )
            	    {
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4851:1: (lv_e2_4_0= ruleExpression )
            	    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4852:3: lv_e2_4_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getMinFunctionAccess().getE2ExpressionParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleExpression_in_ruleMinFunction10707);
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
            	    break loop122;
                }
            } while (true);

            otherlv_5=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleMinFunction10722); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4881:1: entryRuleIntFunction returns [EObject current=null] : iv_ruleIntFunction= ruleIntFunction EOF ;
    public final EObject entryRuleIntFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntFunction = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4882:2: (iv_ruleIntFunction= ruleIntFunction EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4883:2: iv_ruleIntFunction= ruleIntFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleIntFunction_in_entryRuleIntFunction10756);
            iv_ruleIntFunction=ruleIntFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntFunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntFunction10766); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4890:1: ruleIntFunction returns [EObject current=null] : (this_INT_0= RULE_INT otherlv_1= KEYWORD_1 ( (lv_e_2_0= ruleExpression ) ) otherlv_3= KEYWORD_2 ) ;
    public final EObject ruleIntFunction() throws RecognitionException {
        EObject current = null;

        Token this_INT_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_e_2_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4893:28: ( (this_INT_0= RULE_INT otherlv_1= KEYWORD_1 ( (lv_e_2_0= ruleExpression ) ) otherlv_3= KEYWORD_2 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4894:1: (this_INT_0= RULE_INT otherlv_1= KEYWORD_1 ( (lv_e_2_0= ruleExpression ) ) otherlv_3= KEYWORD_2 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4894:1: (this_INT_0= RULE_INT otherlv_1= KEYWORD_1 ( (lv_e_2_0= ruleExpression ) ) otherlv_3= KEYWORD_2 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4894:2: this_INT_0= RULE_INT otherlv_1= KEYWORD_1 ( (lv_e_2_0= ruleExpression ) ) otherlv_3= KEYWORD_2
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleIntFunction10802); if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getIntFunctionAccess().getINTTerminalRuleCall_0()); 
                  
            }
            otherlv_1=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleIntFunction10814); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getIntFunctionAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4903:1: ( (lv_e_2_0= ruleExpression ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4904:1: (lv_e_2_0= ruleExpression )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4904:1: (lv_e_2_0= ruleExpression )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4905:3: lv_e_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getIntFunctionAccess().getEExpressionParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleExpression_in_ruleIntFunction10834);
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

            otherlv_3=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleIntFunction10847); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4934:1: entryRuleLogicalFunction returns [String current=null] : iv_ruleLogicalFunction= ruleLogicalFunction EOF ;
    public final String entryRuleLogicalFunction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalFunction = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4935:1: (iv_ruleLogicalFunction= ruleLogicalFunction EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4936:2: iv_ruleLogicalFunction= ruleLogicalFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleLogicalFunction_in_entryRuleLogicalFunction10882);
            iv_ruleLogicalFunction=ruleLogicalFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalFunction.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleLogicalFunction10893); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4943:1: ruleLogicalFunction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_RangeFunction_0= ruleRangeFunction ;
    public final AntlrDatatypeRuleToken ruleLogicalFunction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_RangeFunction_0 = null;


         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4947:6: (this_RangeFunction_0= ruleRangeFunction )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4949:5: this_RangeFunction_0= ruleRangeFunction
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getLogicalFunctionAccess().getRangeFunctionParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleRangeFunction_in_ruleLogicalFunction10939);
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4967:1: entryRuleVarModel returns [String current=null] : iv_ruleVarModel= ruleVarModel EOF ;
    public final String entryRuleVarModel() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVarModel = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4968:1: (iv_ruleVarModel= ruleVarModel EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4969:2: iv_ruleVarModel= ruleVarModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVarModelRule()); 
            }
            pushFollow(FOLLOW_ruleVarModel_in_entryRuleVarModel10983);
            iv_ruleVarModel=ruleVarModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVarModel.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleVarModel10994); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4976:1: ruleVarModel returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID kw= KEYWORD_11 this_ID_2= RULE_ID kw= KEYWORD_12 ) ;
    public final AntlrDatatypeRuleToken ruleVarModel() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4980:6: ( (this_ID_0= RULE_ID kw= KEYWORD_11 this_ID_2= RULE_ID kw= KEYWORD_12 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4981:1: (this_ID_0= RULE_ID kw= KEYWORD_11 this_ID_2= RULE_ID kw= KEYWORD_12 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4981:1: (this_ID_0= RULE_ID kw= KEYWORD_11 this_ID_2= RULE_ID kw= KEYWORD_12 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:4981:6: this_ID_0= RULE_ID kw= KEYWORD_11 this_ID_2= RULE_ID kw= KEYWORD_12
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarModel11034); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getVarModelAccess().getIDTerminalRuleCall_0()); 
                  
            }
            kw=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleVarModel11052); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getVarModelAccess().getLeftSquareBracketKeyword_1()); 
                  
            }
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleVarModel11067); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getVarModelAccess().getIDTerminalRuleCall_2()); 
                  
            }
            kw=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleVarModel11085); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5015:1: entryRuleRangeFunction returns [String current=null] : iv_ruleRangeFunction= ruleRangeFunction EOF ;
    public final String entryRuleRangeFunction() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRangeFunction = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5016:1: (iv_ruleRangeFunction= ruleRangeFunction EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5017:2: iv_ruleRangeFunction= ruleRangeFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeFunctionRule()); 
            }
            pushFollow(FOLLOW_ruleRangeFunction_in_entryRuleRangeFunction11125);
            iv_ruleRangeFunction=ruleRangeFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRangeFunction.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRangeFunction11136); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5024:1: ruleRangeFunction returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_RANGE_0= RULE_RANGE kw= KEYWORD_1 this_ID_2= RULE_ID kw= KEYWORD_5 this_ID_4= RULE_ID kw= KEYWORD_5 this_ID_6= RULE_ID kw= KEYWORD_2 ) ;
    public final AntlrDatatypeRuleToken ruleRangeFunction() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_RANGE_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_4=null;
        Token this_ID_6=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5028:6: ( (this_RANGE_0= RULE_RANGE kw= KEYWORD_1 this_ID_2= RULE_ID kw= KEYWORD_5 this_ID_4= RULE_ID kw= KEYWORD_5 this_ID_6= RULE_ID kw= KEYWORD_2 ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5029:1: (this_RANGE_0= RULE_RANGE kw= KEYWORD_1 this_ID_2= RULE_ID kw= KEYWORD_5 this_ID_4= RULE_ID kw= KEYWORD_5 this_ID_6= RULE_ID kw= KEYWORD_2 )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5029:1: (this_RANGE_0= RULE_RANGE kw= KEYWORD_1 this_ID_2= RULE_ID kw= KEYWORD_5 this_ID_4= RULE_ID kw= KEYWORD_5 this_ID_6= RULE_ID kw= KEYWORD_2 )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5029:6: this_RANGE_0= RULE_RANGE kw= KEYWORD_1 this_ID_2= RULE_ID kw= KEYWORD_5 this_ID_4= RULE_ID kw= KEYWORD_5 this_ID_6= RULE_ID kw= KEYWORD_2
            {
            this_RANGE_0=(Token)match(input,RULE_RANGE,FOLLOW_RULE_RANGE_in_ruleRangeFunction11176); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_RANGE_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_RANGE_0, grammarAccess.getRangeFunctionAccess().getRANGETerminalRuleCall_0()); 
                  
            }
            kw=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleRangeFunction11194); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getRangeFunctionAccess().getLeftParenthesisKeyword_1()); 
                  
            }
            this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRangeFunction11209); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_2);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_2, grammarAccess.getRangeFunctionAccess().getIDTerminalRuleCall_2()); 
                  
            }
            kw=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleRangeFunction11227); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getRangeFunctionAccess().getCommaKeyword_3()); 
                  
            }
            this_ID_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRangeFunction11242); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_4);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_4, grammarAccess.getRangeFunctionAccess().getIDTerminalRuleCall_4()); 
                  
            }
            kw=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleRangeFunction11260); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getRangeFunctionAccess().getCommaKeyword_5()); 
                  
            }
            this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRangeFunction11275); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_6);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_6, grammarAccess.getRangeFunctionAccess().getIDTerminalRuleCall_6()); 
                  
            }
            kw=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleRangeFunction11293); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5089:1: entryRuleIdent returns [EObject current=null] : iv_ruleIdent= ruleIdent EOF ;
    public final EObject entryRuleIdent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIdent = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5090:2: (iv_ruleIdent= ruleIdent EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5091:2: iv_ruleIdent= ruleIdent EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentRule()); 
            }
            pushFollow(FOLLOW_ruleIdent_in_entryRuleIdent11332);
            iv_ruleIdent=ruleIdent();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdent; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdent11342); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5098:1: ruleIdent returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleIdent() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5101:28: ( ( (lv_name_0_0= RULE_ID ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5102:1: ( (lv_name_0_0= RULE_ID ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5102:1: ( (lv_name_0_0= RULE_ID ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5103:1: (lv_name_0_0= RULE_ID )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5103:1: (lv_name_0_0= RULE_ID )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5104:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdent11383); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5128:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5129:1: (iv_ruleNumber= ruleNumber EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5130:2: iv_ruleNumber= ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberRule()); 
            }
            pushFollow(FOLLOW_ruleNumber_in_entryRuleNumber11423);
            iv_ruleNumber=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumber11434); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5137:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT | this_FLOAT_1= RULE_FLOAT ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token this_FLOAT_1=null;

         enterRule(); 
            
        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5141:6: ( (this_INT_0= RULE_INT | this_FLOAT_1= RULE_FLOAT ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5142:1: (this_INT_0= RULE_INT | this_FLOAT_1= RULE_FLOAT )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5142:1: (this_INT_0= RULE_INT | this_FLOAT_1= RULE_FLOAT )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==RULE_INT) ) {
                alt123=1;
            }
            else if ( (LA123_0==RULE_FLOAT) ) {
                alt123=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5142:6: this_INT_0= RULE_INT
                    {
                    this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNumber11474); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_INT_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_INT_0, grammarAccess.getNumberAccess().getINTTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5150:10: this_FLOAT_1= RULE_FLOAT
                    {
                    this_FLOAT_1=(Token)match(input,RULE_FLOAT,FOLLOW_RULE_FLOAT_in_ruleNumber11500); if (state.failed) return current;
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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5165:1: entryRuleIncludeFile returns [EObject current=null] : iv_ruleIncludeFile= ruleIncludeFile EOF ;
    public final EObject entryRuleIncludeFile() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIncludeFile = null;


        try {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5166:2: (iv_ruleIncludeFile= ruleIncludeFile EOF )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5167:2: iv_ruleIncludeFile= ruleIncludeFile EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIncludeFileRule()); 
            }
            pushFollow(FOLLOW_ruleIncludeFile_in_entryRuleIncludeFile11544);
            iv_ruleIncludeFile=ruleIncludeFile();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIncludeFile; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIncludeFile11554); if (state.failed) return current;

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
    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5174:1: ruleIncludeFile returns [EObject current=null] : ( (otherlv_0= KEYWORD_43 | otherlv_1= KEYWORD_43 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_file_5_0= RULE_STRING ) ) ) ;
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
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5177:28: ( ( (otherlv_0= KEYWORD_43 | otherlv_1= KEYWORD_43 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_file_5_0= RULE_STRING ) ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5178:1: ( (otherlv_0= KEYWORD_43 | otherlv_1= KEYWORD_43 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_file_5_0= RULE_STRING ) ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5178:1: ( (otherlv_0= KEYWORD_43 | otherlv_1= KEYWORD_43 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_file_5_0= RULE_STRING ) ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5178:2: (otherlv_0= KEYWORD_43 | otherlv_1= KEYWORD_43 ) (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )? ( (lv_file_5_0= RULE_STRING ) )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5178:2: (otherlv_0= KEYWORD_43 | otherlv_1= KEYWORD_43 )
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==KEYWORD_43) ) {
                int LA124_1 = input.LA(2);

                if ( (synpred145_InternalWreslEditorParser()) ) {
                    alt124=1;
                }
                else if ( (true) ) {
                    alt124=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 124, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;
            }
            switch (alt124) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5179:2: otherlv_0= KEYWORD_43
                    {
                    otherlv_0=(Token)match(input,KEYWORD_43,FOLLOW_KEYWORD_43_in_ruleIncludeFile11593); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getIncludeFileAccess().getIncludeKeyword_0_0());
                          
                    }

                    }
                    break;
                case 2 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5185:2: otherlv_1= KEYWORD_43
                    {
                    otherlv_1=(Token)match(input,KEYWORD_43,FOLLOW_KEYWORD_43_in_ruleIncludeFile11611); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getIncludeFileAccess().getINCLUDEKeyword_0_1());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5189:2: (otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12 )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==KEYWORD_11) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5190:2: otherlv_2= KEYWORD_11 ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) ) otherlv_4= KEYWORD_12
                    {
                    otherlv_2=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleIncludeFile11625); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getIncludeFileAccess().getLeftSquareBracketKeyword_1_0());
                          
                    }
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5194:1: ( ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5195:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5195:1: ( (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 ) )
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5196:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    {
                    // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5196:1: (lv_local_3_1= KEYWORD_33 | lv_local_3_2= KEYWORD_33 )
                    int alt125=2;
                    int LA125_0 = input.LA(1);

                    if ( (LA125_0==KEYWORD_33) ) {
                        int LA125_1 = input.LA(2);

                        if ( (synpred146_InternalWreslEditorParser()) ) {
                            alt125=1;
                        }
                        else if ( (true) ) {
                            alt125=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 125, 1, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 125, 0, input);

                        throw nvae;
                    }
                    switch (alt125) {
                        case 1 :
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5197:3: lv_local_3_1= KEYWORD_33
                            {
                            lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleIncludeFile11645); if (state.failed) return current;
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
                            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5210:8: lv_local_3_2= KEYWORD_33
                            {
                            lv_local_3_2=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_ruleIncludeFile11673); if (state.failed) return current;
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

                    otherlv_4=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleIncludeFile11700); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getIncludeFileAccess().getRightSquareBracketKeyword_1_2());
                          
                    }

                    }
                    break;

            }

            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5231:3: ( (lv_file_5_0= RULE_STRING ) )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5232:1: (lv_file_5_0= RULE_STRING )
            {
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5232:1: (lv_file_5_0= RULE_STRING )
            // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5233:3: lv_file_5_0= RULE_STRING
            {
            lv_file_5_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleIncludeFile11718); if (state.failed) return current;
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

    // $ANTLR start synpred9_InternalWreslEditorParser
    public final void synpred9_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:247:2: (otherlv_0= KEYWORD_50 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:247:2: otherlv_0= KEYWORD_50
        {
        otherlv_0=(Token)match(input,KEYWORD_50,FOLLOW_KEYWORD_50_in_synpred9_InternalWreslEditorParser474); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_InternalWreslEditorParser

    // $ANTLR start synpred10_InternalWreslEditorParser
    public final void synpred10_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token lv_local_3_1=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:265:3: (lv_local_3_1= KEYWORD_33 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:265:3: lv_local_3_1= KEYWORD_33
        {
        lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_synpred10_InternalWreslEditorParser526); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_InternalWreslEditorParser

    // $ANTLR start synpred14_InternalWreslEditorParser
    public final void synpred14_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:449:2: (otherlv_0= KEYWORD_40 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:449:2: otherlv_0= KEYWORD_40
        {
        otherlv_0=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_synpred14_InternalWreslEditorParser910); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_InternalWreslEditorParser

    // $ANTLR start synpred15_InternalWreslEditorParser
    public final void synpred15_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token lv_local_3_1=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:467:3: (lv_local_3_1= KEYWORD_33 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:467:3: lv_local_3_1= KEYWORD_33
        {
        lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_synpred15_InternalWreslEditorParser962); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred15_InternalWreslEditorParser

    // $ANTLR start synpred20_InternalWreslEditorParser
    public final void synpred20_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:617:2: (otherlv_0= KEYWORD_46 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:617:2: otherlv_0= KEYWORD_46
        {
        otherlv_0=(Token)match(input,KEYWORD_46,FOLLOW_KEYWORD_46_in_synpred20_InternalWreslEditorParser1231); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_InternalWreslEditorParser

    // $ANTLR start synpred21_InternalWreslEditorParser
    public final void synpred21_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:646:2: (otherlv_3= KEYWORD_26 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:646:2: otherlv_3= KEYWORD_26
        {
        otherlv_3=(Token)match(input,KEYWORD_26,FOLLOW_KEYWORD_26_in_synpred21_InternalWreslEditorParser1287); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_InternalWreslEditorParser

    // $ANTLR start synpred23_InternalWreslEditorParser
    public final void synpred23_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:667:2: (otherlv_6= KEYWORD_20 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:667:2: otherlv_6= KEYWORD_20
        {
        otherlv_6=(Token)match(input,KEYWORD_20,FOLLOW_KEYWORD_20_in_synpred23_InternalWreslEditorParser1339); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred23_InternalWreslEditorParser

    // $ANTLR start synpred24_InternalWreslEditorParser
    public final void synpred24_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:699:2: (otherlv_0= KEYWORD_40 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:699:2: otherlv_0= KEYWORD_40
        {
        otherlv_0=(Token)match(input,KEYWORD_40,FOLLOW_KEYWORD_40_in_synpred24_InternalWreslEditorParser1443); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_InternalWreslEditorParser

    // $ANTLR start synpred25_InternalWreslEditorParser
    public final void synpred25_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token lv_local_3_1=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:717:3: (lv_local_3_1= KEYWORD_33 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:717:3: lv_local_3_1= KEYWORD_33
        {
        lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_synpred25_InternalWreslEditorParser1495); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred25_InternalWreslEditorParser

    // $ANTLR start synpred27_InternalWreslEditorParser
    public final void synpred27_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_7=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:775:2: (otherlv_7= KEYWORD_31 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:775:2: otherlv_7= KEYWORD_31
        {
        otherlv_7=(Token)match(input,KEYWORD_31,FOLLOW_KEYWORD_31_in_synpred27_InternalWreslEditorParser1599); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_InternalWreslEditorParser

    // $ANTLR start synpred28_InternalWreslEditorParser
    public final void synpred28_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_10=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:804:2: (otherlv_10= KEYWORD_30 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:804:2: otherlv_10= KEYWORD_30
        {
        otherlv_10=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_synpred28_InternalWreslEditorParser1653); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred28_InternalWreslEditorParser

    // $ANTLR start synpred30_InternalWreslEditorParser
    public final void synpred30_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_13=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:833:2: (otherlv_13= KEYWORD_36 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:833:2: otherlv_13= KEYWORD_36
        {
        otherlv_13=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_synpred30_InternalWreslEditorParser1710); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_InternalWreslEditorParser

    // $ANTLR start synpred33_InternalWreslEditorParser
    public final void synpred33_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_1=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:952:2: (otherlv_1= KEYWORD_30 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:952:2: otherlv_1= KEYWORD_30
        {
        otherlv_1=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_synpred33_InternalWreslEditorParser1993); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred33_InternalWreslEditorParser

    // $ANTLR start synpred34_InternalWreslEditorParser
    public final void synpred34_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_4=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:981:2: (otherlv_4= KEYWORD_36 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:981:2: otherlv_4= KEYWORD_36
        {
        otherlv_4=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_synpred34_InternalWreslEditorParser2047); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_InternalWreslEditorParser

    // $ANTLR start synpred35_InternalWreslEditorParser
    public final void synpred35_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1031:2: (otherlv_0= KEYWORD_23 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1031:2: otherlv_0= KEYWORD_23
        {
        otherlv_0=(Token)match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_synpred35_InternalWreslEditorParser2171); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred35_InternalWreslEditorParser

    // $ANTLR start synpred36_InternalWreslEditorParser
    public final void synpred36_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1042:2: (otherlv_2= KEYWORD_30 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1042:2: otherlv_2= KEYWORD_30
        {
        otherlv_2=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_synpred36_InternalWreslEditorParser2203); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred36_InternalWreslEditorParser

    // $ANTLR start synpred37_InternalWreslEditorParser
    public final void synpred37_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_5=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1071:2: (otherlv_5= KEYWORD_36 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1071:2: otherlv_5= KEYWORD_36
        {
        otherlv_5=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_synpred37_InternalWreslEditorParser2257); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred37_InternalWreslEditorParser

    // $ANTLR start synpred39_InternalWreslEditorParser
    public final void synpred39_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1167:2: (otherlv_0= KEYWORD_44 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1167:2: otherlv_0= KEYWORD_44
        {
        otherlv_0=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_synpred39_InternalWreslEditorParser2505); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred39_InternalWreslEditorParser

    // $ANTLR start synpred40_InternalWreslEditorParser
    public final void synpred40_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_2=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1178:2: (otherlv_2= KEYWORD_23 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1178:2: otherlv_2= KEYWORD_23
        {
        otherlv_2=(Token)match(input,KEYWORD_23,FOLLOW_KEYWORD_23_in_synpred40_InternalWreslEditorParser2537); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred40_InternalWreslEditorParser

    // $ANTLR start synpred41_InternalWreslEditorParser
    public final void synpred41_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_4=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1189:2: (otherlv_4= KEYWORD_30 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1189:2: otherlv_4= KEYWORD_30
        {
        otherlv_4=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_synpred41_InternalWreslEditorParser2569); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred41_InternalWreslEditorParser

    // $ANTLR start synpred42_InternalWreslEditorParser
    public final void synpred42_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_7=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1218:2: (otherlv_7= KEYWORD_36 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1218:2: otherlv_7= KEYWORD_36
        {
        otherlv_7=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_synpred42_InternalWreslEditorParser2623); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred42_InternalWreslEditorParser

    // $ANTLR start synpred43_InternalWreslEditorParser
    public final void synpred43_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1268:2: (otherlv_0= KEYWORD_44 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1268:2: otherlv_0= KEYWORD_44
        {
        otherlv_0=(Token)match(input,KEYWORD_44,FOLLOW_KEYWORD_44_in_synpred43_InternalWreslEditorParser2747); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred43_InternalWreslEditorParser

    // $ANTLR start synpred44_InternalWreslEditorParser
    public final void synpred44_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1291:2: (otherlv_3= KEYWORD_30 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1291:2: otherlv_3= KEYWORD_30
        {
        otherlv_3=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_synpred44_InternalWreslEditorParser2803); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred44_InternalWreslEditorParser

    // $ANTLR start synpred45_InternalWreslEditorParser
    public final void synpred45_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1320:2: (otherlv_6= KEYWORD_36 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1320:2: otherlv_6= KEYWORD_36
        {
        otherlv_6=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_synpred45_InternalWreslEditorParser2857); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred45_InternalWreslEditorParser

    // $ANTLR start synpred50_InternalWreslEditorParser
    public final void synpred50_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1455:2: (otherlv_0= KEYWORD_52 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1455:2: otherlv_0= KEYWORD_52
        {
        otherlv_0=(Token)match(input,KEYWORD_52,FOLLOW_KEYWORD_52_in_synpred50_InternalWreslEditorParser3195); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred50_InternalWreslEditorParser

    // $ANTLR start synpred52_InternalWreslEditorParser
    public final void synpred52_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1484:2: (otherlv_3= KEYWORD_30 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1484:2: otherlv_3= KEYWORD_30
        {
        otherlv_3=(Token)match(input,KEYWORD_30,FOLLOW_KEYWORD_30_in_synpred52_InternalWreslEditorParser3250); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred52_InternalWreslEditorParser

    // $ANTLR start synpred53_InternalWreslEditorParser
    public final void synpred53_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1513:2: (otherlv_6= KEYWORD_36 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1513:2: otherlv_6= KEYWORD_36
        {
        otherlv_6=(Token)match(input,KEYWORD_36,FOLLOW_KEYWORD_36_in_synpred53_InternalWreslEditorParser3304); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred53_InternalWreslEditorParser

    // $ANTLR start synpred54_InternalWreslEditorParser
    public final void synpred54_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_9=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1542:2: (otherlv_9= KEYWORD_42 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1542:2: otherlv_9= KEYWORD_42
        {
        otherlv_9=(Token)match(input,KEYWORD_42,FOLLOW_KEYWORD_42_in_synpred54_InternalWreslEditorParser3359); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred54_InternalWreslEditorParser

    // $ANTLR start synpred56_InternalWreslEditorParser
    public final void synpred56_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1592:2: (otherlv_0= KEYWORD_38 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1592:2: otherlv_0= KEYWORD_38
        {
        otherlv_0=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_synpred56_InternalWreslEditorParser3485); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred56_InternalWreslEditorParser

    // $ANTLR start synpred58_InternalWreslEditorParser
    public final void synpred58_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1759:2: (otherlv_0= KEYWORD_27 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1759:2: otherlv_0= KEYWORD_27
        {
        otherlv_0=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_synpred58_InternalWreslEditorParser3876); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred58_InternalWreslEditorParser

    // $ANTLR start synpred61_InternalWreslEditorParser
    public final void synpred61_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1893:2: (otherlv_0= KEYWORD_24 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:1893:2: otherlv_0= KEYWORD_24
        {
        otherlv_0=(Token)match(input,KEYWORD_24,FOLLOW_KEYWORD_24_in_synpred61_InternalWreslEditorParser4122); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred61_InternalWreslEditorParser

    // $ANTLR start synpred64_InternalWreslEditorParser
    public final void synpred64_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2052:2: (otherlv_0= KEYWORD_38 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2052:2: otherlv_0= KEYWORD_38
        {
        otherlv_0=(Token)match(input,KEYWORD_38,FOLLOW_KEYWORD_38_in_synpred64_InternalWreslEditorParser4466); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred64_InternalWreslEditorParser

    // $ANTLR start synpred65_InternalWreslEditorParser
    public final void synpred65_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2102:2: (otherlv_0= KEYWORD_41 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2102:2: otherlv_0= KEYWORD_41
        {
        otherlv_0=(Token)match(input,KEYWORD_41,FOLLOW_KEYWORD_41_in_synpred65_InternalWreslEditorParser4589); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred65_InternalWreslEditorParser

    // $ANTLR start synpred66_InternalWreslEditorParser
    public final void synpred66_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2131:2: (otherlv_3= KEYWORD_28 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2131:2: otherlv_3= KEYWORD_28
        {
        otherlv_3=(Token)match(input,KEYWORD_28,FOLLOW_KEYWORD_28_in_synpred66_InternalWreslEditorParser4643); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred66_InternalWreslEditorParser

    // $ANTLR start synpred67_InternalWreslEditorParser
    public final void synpred67_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2160:2: (otherlv_6= KEYWORD_32 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2160:2: otherlv_6= KEYWORD_32
        {
        otherlv_6=(Token)match(input,KEYWORD_32,FOLLOW_KEYWORD_32_in_synpred67_InternalWreslEditorParser4698); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred67_InternalWreslEditorParser

    // $ANTLR start synpred68_InternalWreslEditorParser
    public final void synpred68_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_9=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2189:2: (otherlv_9= KEYWORD_25 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2189:2: otherlv_9= KEYWORD_25
        {
        otherlv_9=(Token)match(input,KEYWORD_25,FOLLOW_KEYWORD_25_in_synpred68_InternalWreslEditorParser4751); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred68_InternalWreslEditorParser

    // $ANTLR start synpred70_InternalWreslEditorParser
    public final void synpred70_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_12=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2218:2: (otherlv_12= KEYWORD_39 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2218:2: otherlv_12= KEYWORD_39
        {
        otherlv_12=(Token)match(input,KEYWORD_39,FOLLOW_KEYWORD_39_in_synpred70_InternalWreslEditorParser4808); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred70_InternalWreslEditorParser

    // $ANTLR start synpred78_InternalWreslEditorParser
    public final void synpred78_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2602:2: (otherlv_0= KEYWORD_37 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2602:2: otherlv_0= KEYWORD_37
        {
        otherlv_0=(Token)match(input,KEYWORD_37,FOLLOW_KEYWORD_37_in_synpred78_InternalWreslEditorParser5668); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred78_InternalWreslEditorParser

    // $ANTLR start synpred79_InternalWreslEditorParser
    public final void synpred79_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2622:2: (otherlv_3= KEYWORD_51 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2622:2: otherlv_3= KEYWORD_51
        {
        otherlv_3=(Token)match(input,KEYWORD_51,FOLLOW_KEYWORD_51_in_synpred79_InternalWreslEditorParser5714); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred79_InternalWreslEditorParser

    // $ANTLR start synpred81_InternalWreslEditorParser
    public final void synpred81_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2673:2: (otherlv_0= KEYWORD_34 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2673:2: otherlv_0= KEYWORD_34
        {
        otherlv_0=(Token)match(input,KEYWORD_34,FOLLOW_KEYWORD_34_in_synpred81_InternalWreslEditorParser5845); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred81_InternalWreslEditorParser

    // $ANTLR start synpred82_InternalWreslEditorParser
    public final void synpred82_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2693:2: (otherlv_3= KEYWORD_51 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2693:2: otherlv_3= KEYWORD_51
        {
        otherlv_3=(Token)match(input,KEYWORD_51,FOLLOW_KEYWORD_51_in_synpred82_InternalWreslEditorParser5891); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred82_InternalWreslEditorParser

    // $ANTLR start synpred84_InternalWreslEditorParser
    public final void synpred84_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2744:2: (otherlv_0= KEYWORD_29 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2744:2: otherlv_0= KEYWORD_29
        {
        otherlv_0=(Token)match(input,KEYWORD_29,FOLLOW_KEYWORD_29_in_synpred84_InternalWreslEditorParser6022); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred84_InternalWreslEditorParser

    // $ANTLR start synpred85_InternalWreslEditorParser
    public final void synpred85_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token lv_local_3_1=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2762:3: (lv_local_3_1= KEYWORD_33 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2762:3: lv_local_3_1= KEYWORD_33
        {
        lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_synpred85_InternalWreslEditorParser6074); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred85_InternalWreslEditorParser

    // $ANTLR start synpred88_InternalWreslEditorParser
    public final void synpred88_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2882:2: (otherlv_0= KEYWORD_21 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2882:2: otherlv_0= KEYWORD_21
        {
        otherlv_0=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_synpred88_InternalWreslEditorParser6305); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred88_InternalWreslEditorParser

    // $ANTLR start synpred91_InternalWreslEditorParser
    public final void synpred91_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2969:2: (otherlv_0= KEYWORD_27 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:2969:2: otherlv_0= KEYWORD_27
        {
        otherlv_0=(Token)match(input,KEYWORD_27,FOLLOW_KEYWORD_27_in_synpred91_InternalWreslEditorParser6479); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred91_InternalWreslEditorParser

    // $ANTLR start synpred92_InternalWreslEditorParser
    public final void synpred92_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_5=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3021:2: (otherlv_5= KEYWORD_22 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3021:2: otherlv_5= KEYWORD_22
        {
        otherlv_5=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_synpred92_InternalWreslEditorParser6566); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred92_InternalWreslEditorParser

    // $ANTLR start synpred94_InternalWreslEditorParser
    public final void synpred94_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3094:2: (otherlv_0= KEYWORD_22 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3094:2: otherlv_0= KEYWORD_22
        {
        otherlv_0=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_synpred94_InternalWreslEditorParser6723); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred94_InternalWreslEditorParser

    // $ANTLR start synpred99_InternalWreslEditorParser
    public final void synpred99_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3256:2: (otherlv_0= KEYWORD_21 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3256:2: otherlv_0= KEYWORD_21
        {
        otherlv_0=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_synpred99_InternalWreslEditorParser7034); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred99_InternalWreslEditorParser

    // $ANTLR start synpred100_InternalWreslEditorParser
    public final void synpred100_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3272:2: (otherlv_3= KEYWORD_22 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3272:2: otherlv_3= KEYWORD_22
        {
        otherlv_3=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_synpred100_InternalWreslEditorParser7078); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred100_InternalWreslEditorParser

    // $ANTLR start synpred101_InternalWreslEditorParser
    public final void synpred101_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3292:2: (otherlv_6= KEYWORD_49 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3292:2: otherlv_6= KEYWORD_49
        {
        otherlv_6=(Token)match(input,KEYWORD_49,FOLLOW_KEYWORD_49_in_synpred101_InternalWreslEditorParser7124); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred101_InternalWreslEditorParser

    // $ANTLR start synpred103_InternalWreslEditorParser
    public final void synpred103_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3343:2: (otherlv_0= KEYWORD_21 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3343:2: otherlv_0= KEYWORD_21
        {
        otherlv_0=(Token)match(input,KEYWORD_21,FOLLOW_KEYWORD_21_in_synpred103_InternalWreslEditorParser7255); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred103_InternalWreslEditorParser

    // $ANTLR start synpred104_InternalWreslEditorParser
    public final void synpred104_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_3=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3359:2: (otherlv_3= KEYWORD_22 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3359:2: otherlv_3= KEYWORD_22
        {
        otherlv_3=(Token)match(input,KEYWORD_22,FOLLOW_KEYWORD_22_in_synpred104_InternalWreslEditorParser7299); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred104_InternalWreslEditorParser

    // $ANTLR start synpred105_InternalWreslEditorParser
    public final void synpred105_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_6=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3379:2: (otherlv_6= KEYWORD_49 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3379:2: otherlv_6= KEYWORD_49
        {
        otherlv_6=(Token)match(input,KEYWORD_49,FOLLOW_KEYWORD_49_in_synpred105_InternalWreslEditorParser7345); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred105_InternalWreslEditorParser

    // $ANTLR start synpred107_InternalWreslEditorParser
    public final void synpred107_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3430:2: (otherlv_0= KEYWORD_45 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3430:2: otherlv_0= KEYWORD_45
        {
        otherlv_0=(Token)match(input,KEYWORD_45,FOLLOW_KEYWORD_45_in_synpred107_InternalWreslEditorParser7476); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred107_InternalWreslEditorParser

    // $ANTLR start synpred110_InternalWreslEditorParser
    public final void synpred110_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3621:2: (otherlv_0= KEYWORD_35 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3621:2: otherlv_0= KEYWORD_35
        {
        otherlv_0=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_synpred110_InternalWreslEditorParser7891); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred110_InternalWreslEditorParser

    // $ANTLR start synpred113_InternalWreslEditorParser
    public final void synpred113_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3718:2: (otherlv_0= KEYWORD_47 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3718:2: otherlv_0= KEYWORD_47
        {
        otherlv_0=(Token)match(input,KEYWORD_47,FOLLOW_KEYWORD_47_in_synpred113_InternalWreslEditorParser8090); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred113_InternalWreslEditorParser

    // $ANTLR start synpred114_InternalWreslEditorParser
    public final void synpred114_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_4=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3752:2: (otherlv_4= KEYWORD_35 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3752:2: otherlv_4= KEYWORD_35
        {
        otherlv_4=(Token)match(input,KEYWORD_35,FOLLOW_KEYWORD_35_in_synpred114_InternalWreslEditorParser8156); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred114_InternalWreslEditorParser

    // $ANTLR start synpred117_InternalWreslEditorParser
    public final void synpred117_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3845:2: (otherlv_0= KEYWORD_48 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:3845:2: otherlv_0= KEYWORD_48
        {
        otherlv_0=(Token)match(input,KEYWORD_48,FOLLOW_KEYWORD_48_in_synpred117_InternalWreslEditorParser8351); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred117_InternalWreslEditorParser

    // $ANTLR start synpred145_InternalWreslEditorParser
    public final void synpred145_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token otherlv_0=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5179:2: (otherlv_0= KEYWORD_43 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5179:2: otherlv_0= KEYWORD_43
        {
        otherlv_0=(Token)match(input,KEYWORD_43,FOLLOW_KEYWORD_43_in_synpred145_InternalWreslEditorParser11593); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred145_InternalWreslEditorParser

    // $ANTLR start synpred146_InternalWreslEditorParser
    public final void synpred146_InternalWreslEditorParser_fragment() throws RecognitionException {   
        Token lv_local_3_1=null;

        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5197:3: (lv_local_3_1= KEYWORD_33 )
        // ../gov.ca.dwr.wresl.xtext.editor/src-gen/gov/ca/dwr/wresl/xtext/editor/parser/antlr/internal/InternalWreslEditorParser.g:5197:3: lv_local_3_1= KEYWORD_33
        {
        lv_local_3_1=(Token)match(input,KEYWORD_33,FOLLOW_KEYWORD_33_in_synpred146_InternalWreslEditorParser11645); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred146_InternalWreslEditorParser

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
    public final boolean synpred145_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred145_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred64_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred64_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred78_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred78_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred100_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred100_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred99_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred99_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred110_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred110_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred88_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred88_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred91_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred91_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred85_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred104_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred104_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred24_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred114_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred117_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred21_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred92_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred92_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred40_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred40_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred146_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred146_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred65_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred65_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred34_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred15_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred15_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred53_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred53_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred79_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred79_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred82_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred82_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred50_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred50_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred61_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred61_InternalWreslEditorParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred28_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred28_InternalWreslEditorParser_fragment(); // can never throw exception
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
    public final boolean synpred113_InternalWreslEditorParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred113_InternalWreslEditorParser_fragment(); // can never throw exception
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


    protected DFA101 dfa101 = new DFA101(this);
    static final String DFA101_eotS =
        "\12\uffff";
    static final String DFA101_eofS =
        "\12\uffff";
    static final String DFA101_minS =
        "\1\7\1\uffff\1\64\1\uffff\1\23\1\66\1\65\1\4\1\104\1\uffff";
    static final String DFA101_maxS =
        "\1\67\1\uffff\1\104\1\uffff\1\23\1\66\1\65\1\43\1\104\1\uffff";
    static final String DFA101_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\5\uffff\1\2";
    static final String DFA101_specialS =
        "\12\uffff}>";
    static final String[] DFA101_transitionS = {
            "\1\3\4\uffff\1\3\2\uffff\1\2\15\uffff\1\3\31\uffff\1\1",
            "",
            "\1\4\17\uffff\1\5",
            "",
            "\1\6",
            "\1\7",
            "\1\10",
            "\1\3\4\uffff\1\3\3\uffff\1\3\2\uffff\1\3\1\11\2\uffff\1\3"+
            "\2\uffff\2\3\2\uffff\1\3\6\uffff\2\3",
            "\1\5",
            ""
    };

    static final short[] DFA101_eot = DFA.unpackEncodedString(DFA101_eotS);
    static final short[] DFA101_eof = DFA.unpackEncodedString(DFA101_eofS);
    static final char[] DFA101_min = DFA.unpackEncodedStringToUnsignedChars(DFA101_minS);
    static final char[] DFA101_max = DFA.unpackEncodedStringToUnsignedChars(DFA101_maxS);
    static final short[] DFA101_accept = DFA.unpackEncodedString(DFA101_acceptS);
    static final short[] DFA101_special = DFA.unpackEncodedString(DFA101_specialS);
    static final short[][] DFA101_transition;

    static {
        int numStates = DFA101_transitionS.length;
        DFA101_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA101_transition[i] = DFA.unpackEncodedString(DFA101_transitionS[i]);
        }
    }

    class DFA101 extends DFA {

        public DFA101(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 101;
            this.eot = DFA101_eot;
            this.eof = DFA101_eof;
            this.min = DFA101_min;
            this.max = DFA101_max;
            this.accept = DFA101_accept;
            this.special = DFA101_special;
            this.transition = DFA101_transition;
        }
        public String getDescription() {
            return "()+ loopback of 3654:1: ( ( (lv_pattern_4_0= rulePattern ) ) | ( (lv_alias_5_0= ruleAlias ) ) )+";
        }
    }
 

    public static final BitSet FOLLOW_ruleWreslEvaluator_in_entryRuleWreslEvaluator73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWreslEvaluator83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlias_in_ruleWreslEvaluator131 = new BitSet(new long[]{0x0000000020009082L});
    public static final BitSet FOLLOW_rulePattern_in_ruleWreslEvaluator150 = new BitSet(new long[]{0x0000000020009082L});
    public static final BitSet FOLLOW_ruleSequence_in_ruleWreslEvaluator182 = new BitSet(new long[]{0x0000000000200400L});
    public static final BitSet FOLLOW_ruleModel_in_ruleWreslEvaluator204 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_rulePattern_in_entryRulePattern241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePattern251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefine_in_rulePattern301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeFile_in_rulePattern331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoal_in_rulePattern361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjective_in_rulePattern391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleObjective_in_entryRuleObjective425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleObjective435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_50_in_ruleObjective474 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_50_in_ruleObjective492 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleObjective506 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleObjective526 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleObjective554 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleObjective581 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleObjective599 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_KEYWORD_9_in_ruleObjective617 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleObjective629 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ruleWeightItem_in_ruleObjective649 = new BitSet(new long[]{0x0090000000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleObjective663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWeightItem_in_entryRuleWeightItem697 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWeightItem707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleWeightItem745 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleWeightItem761 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleWeightItem779 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleWeightItem799 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleWeightItem812 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleWeightItem825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefine_in_entryRuleDefine861 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefine871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_40_in_ruleDefine910 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_40_in_ruleDefine928 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleDefine942 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleDefine962 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleDefine990 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleDefine1017 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleDefine1035 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleDefine1053 = new BitSet(new long[]{0x0000000C09912210L});
    public static final BitSet FOLLOW_ruleDVar_in_ruleDefine1075 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleSVar_in_ruleDefine1094 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleDVarInteger_in_ruleDefine1113 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleExternal_in_ruleDefine1132 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleDefine1148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternal_in_entryRuleExternal1182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternal1192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_46_in_ruleExternal1231 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_46_in_ruleExternal1249 = new BitSet(new long[]{0x0000000080000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternal1268 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_KEYWORD_26_in_ruleExternal1287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_26_in_ruleExternal1305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_20_in_ruleExternal1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_20_in_ruleExternal1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAlias_in_entryRuleAlias1394 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAlias1404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_40_in_ruleAlias1443 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_40_in_ruleAlias1461 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleAlias1475 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleAlias1495 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleAlias1523 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleAlias1550 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAlias1568 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleAlias1586 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_KEYWORD_31_in_ruleAlias1599 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_31_in_ruleAlias1617 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAlias1638 = new BitSet(new long[]{0x0080000040400000L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleAlias1653 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleAlias1671 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAlias1688 = new BitSet(new long[]{0x0080000000400000L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleAlias1710 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleAlias1728 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAlias1745 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleAlias1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVar_in_entryRuleDVar1799 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDVar1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarStd_in_ruleDVar1859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarNonStd_in_ruleDVar1889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarNonStd_in_entryRuleDVarNonStd1923 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDVarNonStd1933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLowerAndOrUpper_in_ruleDVarNonStd1979 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarNonStd1993 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarNonStd2011 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarNonStd2028 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarNonStd2047 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarNonStd2065 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarNonStd2082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarStd_in_entryRuleDVarStd2122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDVarStd2132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_23_in_ruleDVarStd2171 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_KEYWORD_23_in_ruleDVarStd2189 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarStd2203 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarStd2221 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarStd2238 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarStd2257 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarStd2275 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarStd2292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarInteger_in_entryRuleDVarInteger2332 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDVarInteger2342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarIntegerStd_in_ruleDVarInteger2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarIntegerNonStd_in_ruleDVarInteger2422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarIntegerStd_in_entryRuleDVarIntegerStd2456 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDVarIntegerStd2466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_44_in_ruleDVarIntegerStd2505 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_KEYWORD_44_in_ruleDVarIntegerStd2523 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_KEYWORD_23_in_ruleDVarIntegerStd2537 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_KEYWORD_23_in_ruleDVarIntegerStd2555 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarIntegerStd2569 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarIntegerStd2587 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarIntegerStd2604 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarIntegerStd2623 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarIntegerStd2641 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarIntegerStd2658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDVarIntegerNonStd_in_entryRuleDVarIntegerNonStd2698 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDVarIntegerNonStd2708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_44_in_ruleDVarIntegerNonStd2747 = new BitSet(new long[]{0x0000000400900000L});
    public static final BitSet FOLLOW_KEYWORD_44_in_ruleDVarIntegerNonStd2765 = new BitSet(new long[]{0x0000000400900000L});
    public static final BitSet FOLLOW_ruleLowerAndOrUpper_in_ruleDVarIntegerNonStd2790 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarIntegerNonStd2803 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleDVarIntegerNonStd2821 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarIntegerNonStd2838 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarIntegerNonStd2857 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleDVarIntegerNonStd2875 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleDVarIntegerNonStd2892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVar_in_entryRuleSVar2932 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSVar2942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarDSS_in_ruleSVar2992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarExpression_in_ruleSVar3022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarSum_in_ruleSVar3052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarTable_in_ruleSVar3082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarCase_in_ruleSVar3112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarDSS_in_entryRuleSVarDSS3146 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSVarDSS3156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_52_in_ruleSVarDSS3195 = new BitSet(new long[]{0x0000000040000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_52_in_ruleSVarDSS3213 = new BitSet(new long[]{0x0000000040000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSVarDSS3230 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleSVarDSS3250 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_30_in_ruleSVarDSS3268 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSVarDSS3285 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleSVarDSS3304 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_36_in_ruleSVarDSS3322 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSVarDSS3339 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_KEYWORD_42_in_ruleSVarDSS3359 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_42_in_ruleSVarDSS3377 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleSVarDSS3394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarExpression_in_entryRuleSVarExpression3436 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSVarExpression3446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_38_in_ruleSVarExpression3485 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_38_in_ruleSVarExpression3503 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSVarExpression3524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarSum_in_entryRuleSVarSum3559 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSVarSum3569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSumContent_in_ruleSVarSum3614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarTable_in_entryRuleSVarTable3648 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSVarTable3658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableContent_in_ruleSVarTable3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSVarCase_in_entryRuleSVarCase3737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSVarCase3747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCaseContent_in_ruleSVarCase3792 = new BitSet(new long[]{0x0000000809010012L});
    public static final BitSet FOLLOW_ruleCaseContent_in_entryRuleCaseContent3827 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCaseContent3837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_27_in_ruleCaseContent3876 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_27_in_ruleCaseContent3894 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCaseContent3911 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleCaseContent3929 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCondition_in_ruleCaseContent3949 = new BitSet(new long[]{0x0000000801010000L});
    public static final BitSet FOLLOW_ruleTableContent_in_ruleCaseContent3971 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleValueContent_in_ruleCaseContent3998 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleSumContent_in_ruleCaseContent4025 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleCaseContent4039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSumContent_in_entryRuleSumContent4073 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSumContent4083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_24_in_ruleSumContent4122 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_KEYWORD_24_in_ruleSumContent4140 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_ruleSumHeader_in_ruleSumContent4161 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSumContent4182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSumHeader_in_entryRuleSumHeader4217 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSumHeader4227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleSumHeader4265 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_KEYWORD_19_in_ruleSumHeader4277 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSumHeader4297 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleSumHeader4310 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleSumHeader4330 = new BitSet(new long[]{0x0000480000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleSumHeader4344 = new BitSet(new long[]{0x0800800000000000L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleSumHeader4357 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSumHeader4369 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleSumHeader4383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueContent_in_entryRuleValueContent4417 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueContent4427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_38_in_ruleValueContent4466 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_38_in_ruleValueContent4484 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleValueContent4505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableContent_in_entryRuleTableContent4540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableContent4550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_41_in_ruleTableContent4589 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_41_in_ruleTableContent4607 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTableContent4624 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_KEYWORD_28_in_ruleTableContent4643 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_28_in_ruleTableContent4661 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTableContent4678 = new BitSet(new long[]{0x0000000002040002L});
    public static final BitSet FOLLOW_KEYWORD_32_in_ruleTableContent4698 = new BitSet(new long[]{0x1E00000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_32_in_ruleTableContent4716 = new BitSet(new long[]{0x1E00000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleTableContent4737 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_KEYWORD_25_in_ruleTableContent4751 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_25_in_ruleTableContent4769 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTableContent4786 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_KEYWORD_39_in_ruleTableContent4808 = new BitSet(new long[]{0x1E00000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_39_in_ruleTableContent4826 = new BitSet(new long[]{0x1E00000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleWhereItems_in_ruleTableContent4847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleWhereItems_in_entryRuleWhereItems4884 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleWhereItems4894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleWhereItems4940 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleWhereItems4954 = new BitSet(new long[]{0x1E00000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleAssignment_in_ruleWhereItems4974 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_ruleAssignment_in_entryRuleAssignment5011 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAssignment5021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTermSimple_in_ruleAssignment5067 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_KEYWORD_9_in_ruleAssignment5080 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleAssignment5100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTermSimple_in_entryRuleTermSimple5135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTermSimple5145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTermSimple5181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleTermSimple5205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleTermSimple5235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLowerAndOrUpper_in_entryRuleLowerAndOrUpper5269 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLowerAndOrUpper5279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelowerUpper_in_ruleLowerAndOrUpper5329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleupperLower_in_ruleLowerAndOrUpper5359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleupperLower_in_entryRuleupperLower5393 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleupperLower5403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpper_in_ruleupperLower5449 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleLower_in_ruleupperLower5470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulelowerUpper_in_entryRulelowerUpper5506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulelowerUpper5516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLower_in_rulelowerUpper5562 = new BitSet(new long[]{0x0000000400900002L});
    public static final BitSet FOLLOW_ruleUpper_in_rulelowerUpper5583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUpper_in_entryRuleUpper5619 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUpper5629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_37_in_ruleUpper5668 = new BitSet(new long[]{0x1E00A40000000100L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_37_in_ruleUpper5686 = new BitSet(new long[]{0x1E00A40000000100L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_51_in_ruleUpper5714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_51_in_ruleUpper5732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleUpper5760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLower_in_entryRuleLower5796 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLower5806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_34_in_ruleLower5845 = new BitSet(new long[]{0x1E00A40000000100L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_34_in_ruleLower5863 = new BitSet(new long[]{0x1E00A40000000100L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_51_in_ruleLower5891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_51_in_ruleLower5909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleLower5937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoal_in_entryRuleGoal5973 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoal5983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_29_in_ruleGoal6022 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_29_in_ruleGoal6040 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleGoal6054 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleGoal6074 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleGoal6102 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleGoal6129 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoal6147 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleGoal6165 = new BitSet(new long[]{0x1E00A40100000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleGoalSimple_in_ruleGoal6187 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_ruleGoalCase_in_ruleGoal6206 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleGoal6222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoalCase_in_entryRuleGoalCase6256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoalCase6266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleGoalCase6305 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleGoalCase6323 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleGoalCase6344 = new BitSet(new long[]{0x0000000208000000L});
    public static final BitSet FOLLOW_ruleGoalNoCaseContent_in_ruleGoalCase6366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoalCaseContent_in_ruleGoalCase6393 = new BitSet(new long[]{0x0000000208000002L});
    public static final BitSet FOLLOW_ruleGoalCaseContent_in_entryRuleGoalCaseContent6430 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoalCaseContent6440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_27_in_ruleGoalCaseContent6479 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_27_in_ruleGoalCaseContent6497 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleGoalCaseContent6514 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleGoalCaseContent6532 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ruleCondition_in_ruleGoalCaseContent6552 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleGoalCaseContent6566 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleGoalCaseContent6584 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleGoalCaseContent6605 = new BitSet(new long[]{0x0080000100000000L});
    public static final BitSet FOLLOW_ruleSubContent_in_ruleGoalCaseContent6626 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleGoalCaseContent6640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoalNoCaseContent_in_entryRuleGoalNoCaseContent6674 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoalNoCaseContent6684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleGoalNoCaseContent6723 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleGoalNoCaseContent6741 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleGoalNoCaseContent6762 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleSubContent_in_ruleGoalNoCaseContent6783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSubContent_in_entryRuleSubContent6819 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSubContent6829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLhsGtRhs_in_ruleSubContent6876 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleLhsLtRhs_in_ruleSubContent6897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLhsLtRhs_in_ruleSubContent6927 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_ruleLhsGtRhs_in_ruleSubContent6948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLhsGtRhs_in_entryRuleLhsGtRhs6985 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLhsGtRhs6995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleLhsGtRhs7034 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleLhsGtRhs7052 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleLhsGtRhs7065 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleLhsGtRhs7078 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleLhsGtRhs7096 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_KEYWORD_49_in_ruleLhsGtRhs7124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_49_in_ruleLhsGtRhs7142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePenalty_in_ruleLhsGtRhs7170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLhsLtRhs_in_entryRuleLhsLtRhs7206 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLhsLtRhs7216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleLhsLtRhs7255 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_KEYWORD_21_in_ruleLhsLtRhs7273 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleLhsLtRhs7286 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleLhsLtRhs7299 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_KEYWORD_22_in_ruleLhsLtRhs7317 = new BitSet(new long[]{0x0000000000004040L});
    public static final BitSet FOLLOW_KEYWORD_49_in_ruleLhsLtRhs7345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_49_in_ruleLhsLtRhs7363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePenalty_in_ruleLhsLtRhs7391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePenalty_in_entryRulePenalty7427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePenalty7437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_45_in_rulePenalty7476 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_45_in_rulePenalty7494 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_rulePenalty7515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleGoalSimple_in_entryRuleGoalSimple7550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleGoalSimple7560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_ruleGoalSimple7605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraint_in_entryRuleConstraint7639 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraint7649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConstraint7695 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleConstraint7716 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleConstraint7744 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_9_in_ruleConstraint7772 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConstraint7807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel7842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel7852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_35_in_ruleModel7891 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_35_in_ruleModel7909 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleModel7926 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleModel7944 = new BitSet(new long[]{0x0080000020009080L});
    public static final BitSet FOLLOW_rulePattern_in_ruleModel7965 = new BitSet(new long[]{0x0080000020009080L});
    public static final BitSet FOLLOW_ruleAlias_in_ruleModel7992 = new BitSet(new long[]{0x0080000020009080L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleModel8007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSequence_in_entryRuleSequence8041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSequence8051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_47_in_ruleSequence8090 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_47_in_ruleSequence8108 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSequence8125 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleSequence8143 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_KEYWORD_35_in_ruleSequence8156 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_35_in_ruleSequence8174 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSequence8198 = new BitSet(new long[]{0x0080000000000020L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondition_in_ruleSequence8219 = new BitSet(new long[]{0x0080000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ORDER_in_ruleSequence8232 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleSequence8248 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleSequence8268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCondition_in_entryRuleCondition8302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCondition8312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_48_in_ruleCondition8351 = new BitSet(new long[]{0x9F00A40000000000L,0x0000000000000011L});
    public static final BitSet FOLLOW_KEYWORD_48_in_ruleCondition8369 = new BitSet(new long[]{0x9F00A40000000000L,0x0000000000000011L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_ruleCondition8391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ALWAYS_in_ruleCondition8421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalExpression_in_entryRuleLogicalExpression8457 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalExpression8467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalUnary_in_ruleLogicalExpression8513 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_ruleBinaryOp_in_ruleLogicalExpression8533 = new BitSet(new long[]{0x9F00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleConditionalUnary_in_ruleLogicalExpression8553 = new BitSet(new long[]{0x6000000000000002L});
    public static final BitSet FOLLOW_ruleBinaryOp_in_entryRuleBinaryOp8591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOp8602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_OR_in_ruleBinaryOp8642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_AND_in_ruleBinaryOp8668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalUnary_in_entryRuleConditionalUnary8712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalUnary8722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalNegation_in_ruleConditionalUnary8767 = new BitSet(new long[]{0x9F00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleConditionalTerm_in_ruleConditionalUnary8793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalNegation_in_entryRuleConditionalNegation8828 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalNegation8839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NOT_in_ruleConditionalNegation8878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConditionalTerm_in_entryRuleConditionalTerm8921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConditionalTerm8931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalTerm8978 = new BitSet(new long[]{0x000A01E000000000L});
    public static final BitSet FOLLOW_ruleRelation_in_ruleConditionalTerm8997 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleConditionalTerm9017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalFunction_in_ruleConditionalTerm9043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelation_in_entryRuleRelation9078 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelation9089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleRelation9127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleRelation9146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_18_in_ruleRelation9165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_16_in_ruleRelation9184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_17_in_ruleRelation9203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_15_in_ruleRelation9222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression9261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpression9271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdd_in_ruleExpression9320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAdd_in_entryRuleAdd9353 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAdd9363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiply_in_ruleAdd9409 = new BitSet(new long[]{0x0000A00000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleAdd9424 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleAdd9442 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMultiply_in_ruleAdd9463 = new BitSet(new long[]{0x0000A00000000002L});
    public static final BitSet FOLLOW_ruleMultiply_in_entryRuleMultiply9500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiply9510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleMultiply9556 = new BitSet(new long[]{0x0001100000000002L});
    public static final BitSet FOLLOW_KEYWORD_3_in_ruleMultiply9571 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_KEYWORD_7_in_ruleMultiply9589 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnary_in_ruleMultiply9610 = new BitSet(new long[]{0x0001100000000002L});
    public static final BitSet FOLLOW_ruleUnary_in_entryRuleUnary9647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnary9657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleUnary9696 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNegation_in_ruleUnary9720 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTerm_in_ruleUnary9746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNegation_in_entryRuleNegation9781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNegation9792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleNegation9829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTerm_in_entryRuleTerm9867 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTerm9877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdent_in_ruleTerm9923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_ruleTerm9950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_ruleTerm9977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleTerm9997 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleTerm10017 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleTerm10030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFunction_in_entryRuleFunction10065 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFunction10075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalFunction_in_ruleFunction10125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMaxFunction_in_ruleFunction10155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMinFunction_in_ruleFunction10185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntFunction_in_ruleFunction10215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarModel_in_ruleFunction10239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExternalFunction_in_entryRuleExternalFunction10273 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExternalFunction10283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleExternalFunction10319 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleExternalFunction10331 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExternalFunction10351 = new BitSet(new long[]{0x0000480000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleExternalFunction10365 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleExternalFunction10385 = new BitSet(new long[]{0x0000480000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleExternalFunction10400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMaxFunction_in_entryRuleMaxFunction10434 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMaxFunction10444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MAX_in_ruleMaxFunction10480 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleMaxFunction10492 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleMaxFunction10512 = new BitSet(new long[]{0x0000480000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleMaxFunction10526 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleMaxFunction10546 = new BitSet(new long[]{0x0000480000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleMaxFunction10561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMinFunction_in_entryRuleMinFunction10595 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMinFunction10605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_MIN_in_ruleMinFunction10641 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleMinFunction10653 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleMinFunction10673 = new BitSet(new long[]{0x0000480000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleMinFunction10687 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleMinFunction10707 = new BitSet(new long[]{0x0000480000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleMinFunction10722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntFunction_in_entryRuleIntFunction10756 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntFunction10766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleIntFunction10802 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleIntFunction10814 = new BitSet(new long[]{0x1E00A40000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleExpression_in_ruleIntFunction10834 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleIntFunction10847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLogicalFunction_in_entryRuleLogicalFunction10882 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLogicalFunction10893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeFunction_in_ruleLogicalFunction10939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVarModel_in_entryRuleVarModel10983 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVarModel10994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarModel11034 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleVarModel11052 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleVarModel11067 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleVarModel11085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRangeFunction_in_entryRuleRangeFunction11125 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRangeFunction11136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_RANGE_in_ruleRangeFunction11176 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleRangeFunction11194 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRangeFunction11209 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleRangeFunction11227 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRangeFunction11242 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleRangeFunction11260 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRangeFunction11275 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleRangeFunction11293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdent_in_entryRuleIdent11332 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdent11342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdent11383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumber_in_entryRuleNumber11423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumber11434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNumber11474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_FLOAT_in_ruleNumber11500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIncludeFile_in_entryRuleIncludeFile11544 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIncludeFile11554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_43_in_ruleIncludeFile11593 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_43_in_ruleIncludeFile11611 = new BitSet(new long[]{0x0010000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleIncludeFile11625 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleIncludeFile11645 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_33_in_ruleIncludeFile11673 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleIncludeFile11700 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleIncludeFile11718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_50_in_synpred9_InternalWreslEditorParser474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_33_in_synpred10_InternalWreslEditorParser526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_40_in_synpred14_InternalWreslEditorParser910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_33_in_synpred15_InternalWreslEditorParser962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_46_in_synpred20_InternalWreslEditorParser1231 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_26_in_synpred21_InternalWreslEditorParser1287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_20_in_synpred23_InternalWreslEditorParser1339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_40_in_synpred24_InternalWreslEditorParser1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_33_in_synpred25_InternalWreslEditorParser1495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_31_in_synpred27_InternalWreslEditorParser1599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_30_in_synpred28_InternalWreslEditorParser1653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_synpred30_InternalWreslEditorParser1710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_30_in_synpred33_InternalWreslEditorParser1993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_synpred34_InternalWreslEditorParser2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_23_in_synpred35_InternalWreslEditorParser2171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_30_in_synpred36_InternalWreslEditorParser2203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_synpred37_InternalWreslEditorParser2257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_44_in_synpred39_InternalWreslEditorParser2505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_23_in_synpred40_InternalWreslEditorParser2537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_30_in_synpred41_InternalWreslEditorParser2569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_synpred42_InternalWreslEditorParser2623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_44_in_synpred43_InternalWreslEditorParser2747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_30_in_synpred44_InternalWreslEditorParser2803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_synpred45_InternalWreslEditorParser2857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_52_in_synpred50_InternalWreslEditorParser3195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_30_in_synpred52_InternalWreslEditorParser3250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_36_in_synpred53_InternalWreslEditorParser3304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_42_in_synpred54_InternalWreslEditorParser3359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_38_in_synpred56_InternalWreslEditorParser3485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_27_in_synpred58_InternalWreslEditorParser3876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_24_in_synpred61_InternalWreslEditorParser4122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_38_in_synpred64_InternalWreslEditorParser4466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_41_in_synpred65_InternalWreslEditorParser4589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_28_in_synpred66_InternalWreslEditorParser4643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_32_in_synpred67_InternalWreslEditorParser4698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_25_in_synpred68_InternalWreslEditorParser4751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_39_in_synpred70_InternalWreslEditorParser4808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_37_in_synpred78_InternalWreslEditorParser5668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_51_in_synpred79_InternalWreslEditorParser5714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_34_in_synpred81_InternalWreslEditorParser5845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_51_in_synpred82_InternalWreslEditorParser5891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_29_in_synpred84_InternalWreslEditorParser6022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_33_in_synpred85_InternalWreslEditorParser6074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_synpred88_InternalWreslEditorParser6305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_27_in_synpred91_InternalWreslEditorParser6479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_22_in_synpred92_InternalWreslEditorParser6566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_22_in_synpred94_InternalWreslEditorParser6723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_synpred99_InternalWreslEditorParser7034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_22_in_synpred100_InternalWreslEditorParser7078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_49_in_synpred101_InternalWreslEditorParser7124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_21_in_synpred103_InternalWreslEditorParser7255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_22_in_synpred104_InternalWreslEditorParser7299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_49_in_synpred105_InternalWreslEditorParser7345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_45_in_synpred107_InternalWreslEditorParser7476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_35_in_synpred110_InternalWreslEditorParser7891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_47_in_synpred113_InternalWreslEditorParser8090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_35_in_synpred114_InternalWreslEditorParser8156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_48_in_synpred117_InternalWreslEditorParser8351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_43_in_synpred145_InternalWreslEditorParser11593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_33_in_synpred146_InternalWreslEditorParser11645 = new BitSet(new long[]{0x0000000000000002L});

}