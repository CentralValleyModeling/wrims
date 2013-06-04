// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g 2013-06-04 13:24:48

  package scripting.grammar;
  import java.util.Map;
  import java.util.LinkedHashMap;
  import java.util.Arrays;
  import java.util.HashSet;
  import java.util.Set;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;


import org.antlr.runtime.tree.*;

public class ConfigSimpleParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ENDLINE", "ID", "Begin", "Config", "End", "INT", "SL_COMMENT", "Digit", "Letter", "WS", "'DssTransfer'", "'-'", "'/'", "'.'", "'\\\"'", "'\\\\'"
    };
    public static final int Config=7;
    public static final int End=8;
    public static final int INT=9;
    public static final int ID=5;
    public static final int Digit=11;
    public static final int EOF=-1;
    public static final int Begin=6;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int WS=13;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int SL_COMMENT=10;
    public static final int ENDLINE=4;
    public static final int Letter=12;

    // delegates
    // delegators


        public ConfigSimpleParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ConfigSimpleParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return ConfigSimpleParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g"; }


          //public CommonTree commonTree;
          public Map<String, String> cMap = new LinkedHashMap<String, String>();
          public Map<String, ArrayList<String>> transferMap = new LinkedHashMap<String, ArrayList<String>>();
          //public ArrayList<String> varList = new ArrayList<String>();
          public ArrayList<String> t = new ArrayList<String>();
          public static Set<String> reservedKeys = new HashSet<String>(Arrays.asList
            (  "wreslplus" 
              ,"mainfile"
              ,"solver"   
    					,"initfile"
    					,"initfpart"
    					,"svarfile" 
    					,"svarapart"
    					,"svarfpart"
    					,"dvarfile"                    
    					,"timestep"
    					,"startyear" 
    					,"startmonth"
    					,"startday"
    					,"numberofsteps"
    					,"stopyear"
    					,"stopmonth"
    					,"stopday" 
    					,"groundwaterdir"
    					,"showwresllog"
    					,"sendaliastodvar"
    					,"prefixinittodvarfile"
    					,"lpsolveconfigfile"
    					,"lpsolvenumberofretries"
    					,"ilpmaximumfractiondigits"
    					,"ilplog"  
    					,"ilplogformat" 
    					,"ilplogvarvalue" 

             ));


    public static class dssTransfer_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dssTransfer"
    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:61:1: dssTransfer : ( ENDLINE )* 'Begin' 'DssTransfer' ( ENDLINE )+ (c= transferItem )+ 'End' 'DssTransfer' ;
    public final ConfigSimpleParser.dssTransfer_return dssTransfer() throws RecognitionException {
        ConfigSimpleParser.dssTransfer_return retval = new ConfigSimpleParser.dssTransfer_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ENDLINE1=null;
        Token string_literal2=null;
        Token string_literal3=null;
        Token ENDLINE4=null;
        Token string_literal5=null;
        Token string_literal6=null;
        ConfigSimpleParser.transferItem_return c = null;


        CommonTree ENDLINE1_tree=null;
        CommonTree string_literal2_tree=null;
        CommonTree string_literal3_tree=null;
        CommonTree ENDLINE4_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree string_literal6_tree=null;

        try {
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:61:13: ( ( ENDLINE )* 'Begin' 'DssTransfer' ( ENDLINE )+ (c= transferItem )+ 'End' 'DssTransfer' )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:61:15: ( ENDLINE )* 'Begin' 'DssTransfer' ( ENDLINE )+ (c= transferItem )+ 'End' 'DssTransfer'
            {
            root_0 = (CommonTree)adaptor.nil();

            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:61:15: ( ENDLINE )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==ENDLINE) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:61:15: ENDLINE
            	    {
            	    ENDLINE1=(Token)match(input,ENDLINE,FOLLOW_ENDLINE_in_dssTransfer60); 
            	    ENDLINE1_tree = (CommonTree)adaptor.create(ENDLINE1);
            	    adaptor.addChild(root_0, ENDLINE1_tree);


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            string_literal2=(Token)match(input,Begin,FOLLOW_Begin_in_dssTransfer63); 
            string_literal2_tree = (CommonTree)adaptor.create(string_literal2);
            adaptor.addChild(root_0, string_literal2_tree);

            string_literal3=(Token)match(input,14,FOLLOW_14_in_dssTransfer65); 
            string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
            adaptor.addChild(root_0, string_literal3_tree);

            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:61:46: ( ENDLINE )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==ENDLINE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:61:46: ENDLINE
            	    {
            	    ENDLINE4=(Token)match(input,ENDLINE,FOLLOW_ENDLINE_in_dssTransfer67); 
            	    ENDLINE4_tree = (CommonTree)adaptor.create(ENDLINE4);
            	    adaptor.addChild(root_0, ENDLINE4_tree);


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:63:4: (c= transferItem )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:63:6: c= transferItem
            	    {
            	    pushFollow(FOLLOW_transferItem_in_dssTransfer79);
            	    c=transferItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, c.getTree());
            	     
            	    				
            	    				  //varList.add((c!=null?c.key:null));
            	    				  	
            	    				  if (transferMap.containsKey((c!=null?c.key:null))){
            	    					transferMap.get((c!=null?c.key:null)).add((c!=null?c.val:null));
            	    				  } else {
            	    				    t = new ArrayList<String>();
            	    				    t.add((c!=null?c.val:null));
            	    				    transferMap.put((c!=null?c.key:null), t);
            	    				  } 
            	    				

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);

            string_literal5=(Token)match(input,End,FOLLOW_End_in_dssTransfer102); 
            string_literal5_tree = (CommonTree)adaptor.create(string_literal5);
            adaptor.addChild(root_0, string_literal5_tree);

            string_literal6=(Token)match(input,14,FOLLOW_14_in_dssTransfer104); 
            string_literal6_tree = (CommonTree)adaptor.create(string_literal6);
            adaptor.addChild(root_0, string_literal6_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dssTransfer"

    public static class transferItem_return extends ParserRuleReturnScope {
        public String key;
        public String val;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "transferItem"
    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:81:1: transferItem returns [String key, String val ] : k= ID v= pair ( ENDLINE )+ ;
    public final ConfigSimpleParser.transferItem_return transferItem() throws RecognitionException {
        ConfigSimpleParser.transferItem_return retval = new ConfigSimpleParser.transferItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token k=null;
        Token ENDLINE7=null;
        ConfigSimpleParser.pair_return v = null;


        CommonTree k_tree=null;
        CommonTree ENDLINE7_tree=null;

        try {
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:82:2: (k= ID v= pair ( ENDLINE )+ )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:84:5: k= ID v= pair ( ENDLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            k=(Token)match(input,ID,FOLLOW_ID_in_transferItem137); 
            k_tree = (CommonTree)adaptor.create(k);
            adaptor.addChild(root_0, k_tree);

            pushFollow(FOLLOW_pair_in_transferItem142);
            v=pair();

            state._fsp--;

            adaptor.addChild(root_0, v.getTree());
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:84:22: ( ENDLINE )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==ENDLINE) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:84:22: ENDLINE
            	    {
            	    ENDLINE7=(Token)match(input,ENDLINE,FOLLOW_ENDLINE_in_transferItem148); 
            	    ENDLINE7_tree = (CommonTree)adaptor.create(ENDLINE7);
            	    adaptor.addChild(root_0, ENDLINE7_tree);


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

             retval.key =(k!=null?k.getText():null).toUpperCase(); retval.val =(v!=null?input.toString(v.start,v.stop):null);  

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "transferItem"

    public static class pair_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "pair"
    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:89:1: pair : ID ( '-' | ID )* '/' ID ( '-' | ID )* ;
    public final ConfigSimpleParser.pair_return pair() throws RecognitionException {
        ConfigSimpleParser.pair_return retval = new ConfigSimpleParser.pair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ID8=null;
        Token set9=null;
        Token char_literal10=null;
        Token ID11=null;
        Token set12=null;

        CommonTree ID8_tree=null;
        CommonTree set9_tree=null;
        CommonTree char_literal10_tree=null;
        CommonTree ID11_tree=null;
        CommonTree set12_tree=null;

        try {
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:89:6: ( ID ( '-' | ID )* '/' ID ( '-' | ID )* )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:89:8: ID ( '-' | ID )* '/' ID ( '-' | ID )*
            {
            root_0 = (CommonTree)adaptor.nil();

            ID8=(Token)match(input,ID,FOLLOW_ID_in_pair170); 
            ID8_tree = (CommonTree)adaptor.create(ID8);
            adaptor.addChild(root_0, ID8_tree);

            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:89:10: ( '-' | ID )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==ID||LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:
            	    {
            	    set9=(Token)input.LT(1);
            	    if ( input.LA(1)==ID||input.LA(1)==15 ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (CommonTree)adaptor.create(set9));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            char_literal10=(Token)match(input,16,FOLLOW_16_in_pair179); 
            char_literal10_tree = (CommonTree)adaptor.create(char_literal10);
            adaptor.addChild(root_0, char_literal10_tree);

            ID11=(Token)match(input,ID,FOLLOW_ID_in_pair181); 
            ID11_tree = (CommonTree)adaptor.create(ID11);
            adaptor.addChild(root_0, ID11_tree);

            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:89:27: ( '-' | ID )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ID||LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:
            	    {
            	    set12=(Token)input.LT(1);
            	    if ( input.LA(1)==ID||input.LA(1)==15 ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (CommonTree)adaptor.create(set12));
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
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pair"

    public static class configFile_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "configFile"
    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:91:1: configFile : ( ENDLINE )* Begin Config ( ENDLINE )+ (c= configItem )+ End Config ;
    public final ConfigSimpleParser.configFile_return configFile() throws RecognitionException {
        ConfigSimpleParser.configFile_return retval = new ConfigSimpleParser.configFile_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ENDLINE13=null;
        Token Begin14=null;
        Token Config15=null;
        Token ENDLINE16=null;
        Token End17=null;
        Token Config18=null;
        ConfigSimpleParser.configItem_return c = null;


        CommonTree ENDLINE13_tree=null;
        CommonTree Begin14_tree=null;
        CommonTree Config15_tree=null;
        CommonTree ENDLINE16_tree=null;
        CommonTree End17_tree=null;
        CommonTree Config18_tree=null;

        try {
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:91:12: ( ( ENDLINE )* Begin Config ( ENDLINE )+ (c= configItem )+ End Config )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:92:7: ( ENDLINE )* Begin Config ( ENDLINE )+ (c= configItem )+ End Config
            {
            root_0 = (CommonTree)adaptor.nil();

            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:92:7: ( ENDLINE )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==ENDLINE) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:92:7: ENDLINE
            	    {
            	    ENDLINE13=(Token)match(input,ENDLINE,FOLLOW_ENDLINE_in_configFile207); 
            	    ENDLINE13_tree = (CommonTree)adaptor.create(ENDLINE13);
            	    adaptor.addChild(root_0, ENDLINE13_tree);


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            Begin14=(Token)match(input,Begin,FOLLOW_Begin_in_configFile217); 
            Begin14_tree = (CommonTree)adaptor.create(Begin14);
            adaptor.addChild(root_0, Begin14_tree);

            Config15=(Token)match(input,Config,FOLLOW_Config_in_configFile219); 
            Config15_tree = (CommonTree)adaptor.create(Config15);
            adaptor.addChild(root_0, Config15_tree);

            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:93:20: ( ENDLINE )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==ENDLINE) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:93:20: ENDLINE
            	    {
            	    ENDLINE16=(Token)match(input,ENDLINE,FOLLOW_ENDLINE_in_configFile221); 
            	    ENDLINE16_tree = (CommonTree)adaptor.create(ENDLINE16);
            	    adaptor.addChild(root_0, ENDLINE16_tree);


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:94:4: (c= configItem )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:94:6: c= configItem
            	    {
            	    pushFollow(FOLLOW_configItem_in_configFile232);
            	    c=configItem();

            	    state._fsp--;

            	    adaptor.addChild(root_0, c.getTree());
            	     cMap.put((c!=null?c.key:null), (c!=null?c.val:null)); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);

            End17=(Token)match(input,End,FOLLOW_End_in_configFile245); 
            End17_tree = (CommonTree)adaptor.create(End17);
            adaptor.addChild(root_0, End17_tree);

            Config18=(Token)match(input,Config,FOLLOW_Config_in_configFile247); 
            Config18_tree = (CommonTree)adaptor.create(Config18);
            adaptor.addChild(root_0, Config18_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "configFile"

    public static class configItem_return extends ParserRuleReturnScope {
        public String key;
        public String val;
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "configItem"
    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:100:1: configItem returns [String key, String val ] : k= configKey (v1= integer | v2= complex ) ( ENDLINE )+ ;
    public final ConfigSimpleParser.configItem_return configItem() throws RecognitionException {
        ConfigSimpleParser.configItem_return retval = new ConfigSimpleParser.configItem_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ENDLINE19=null;
        ConfigSimpleParser.configKey_return k = null;

        ConfigSimpleParser.integer_return v1 = null;

        ConfigSimpleParser.complex_return v2 = null;


        CommonTree ENDLINE19_tree=null;

        try {
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:101:2: (k= configKey (v1= integer | v2= complex ) ( ENDLINE )+ )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:103:5: k= configKey (v1= integer | v2= complex ) ( ENDLINE )+
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_configKey_in_configItem278);
            k=configKey();

            state._fsp--;

            adaptor.addChild(root_0, k.getTree());
             retval.key =(k!=null?input.toString(k.start,k.stop):null);  System.out.print("key: "+(k!=null?input.toString(k.start,k.stop):null));System.out.print("\t");
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:104:5: (v1= integer | v2= complex )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==INT) ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1==ID||LA10_1==15||(LA10_1>=17 && LA10_1<=19)) ) {
                    alt10=2;
                }
                else if ( (LA10_1==ENDLINE) ) {
                    alt10=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA10_0==ID||LA10_0==15||(LA10_0>=17 && LA10_0<=19)) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:104:7: v1= integer
                    {
                    pushFollow(FOLLOW_integer_in_configItem299);
                    v1=integer();

                    state._fsp--;

                    adaptor.addChild(root_0, v1.getTree());
                     retval.val =(v1!=null?input.toString(v1.start,v1.stop):null); System.out.println((v1!=null?input.toString(v1.start,v1.stop):null));

                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:105:7: v2= complex
                    {
                    pushFollow(FOLLOW_complex_in_configItem320);
                    v2=complex();

                    state._fsp--;

                    adaptor.addChild(root_0, v2.getTree());
                     retval.val =(v2!=null?input.toString(v2.start,v2.stop):null); System.out.println((v2!=null?input.toString(v2.start,v2.stop):null));

                    }
                    break;

            }

            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:108:5: ( ENDLINE )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==ENDLINE) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:108:5: ENDLINE
            	    {
            	    ENDLINE19=(Token)match(input,ENDLINE,FOLLOW_ENDLINE_in_configItem348); 
            	    ENDLINE19_tree = (CommonTree)adaptor.create(ENDLINE19);
            	    adaptor.addChild(root_0, ENDLINE19_tree);


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "configItem"

    public static class integer_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "integer"
    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:113:1: integer : INT ;
    public final ConfigSimpleParser.integer_return integer() throws RecognitionException {
        ConfigSimpleParser.integer_return retval = new ConfigSimpleParser.integer_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT20=null;

        CommonTree INT20_tree=null;

        try {
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:113:9: ( INT )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:113:11: INT
            {
            root_0 = (CommonTree)adaptor.nil();

            INT20=(Token)match(input,INT,FOLLOW_INT_in_integer369); 
            INT20_tree = (CommonTree)adaptor.create(INT20);
            adaptor.addChild(root_0, INT20_tree);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "integer"

    public static class complex_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "complex"
    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:114:1: complex : ( INT )? ( ID | '.' | '-' | '\\\"' | '\\\\' )+ ;
    public final ConfigSimpleParser.complex_return complex() throws RecognitionException {
        ConfigSimpleParser.complex_return retval = new ConfigSimpleParser.complex_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INT21=null;
        Token set22=null;

        CommonTree INT21_tree=null;
        CommonTree set22_tree=null;

        try {
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:114:9: ( ( INT )? ( ID | '.' | '-' | '\\\"' | '\\\\' )+ )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:114:11: ( INT )? ( ID | '.' | '-' | '\\\"' | '\\\\' )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:114:11: ( INT )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==INT) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:114:11: INT
                    {
                    INT21=(Token)match(input,INT,FOLLOW_INT_in_complex377); 
                    INT21_tree = (CommonTree)adaptor.create(INT21);
                    adaptor.addChild(root_0, INT21_tree);


                    }
                    break;

            }

            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:114:17: ( ID | '.' | '-' | '\\\"' | '\\\\' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==ID||LA13_0==15||(LA13_0>=17 && LA13_0<=19)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:
            	    {
            	    set22=(Token)input.LT(1);
            	    if ( input.LA(1)==ID||input.LA(1)==15||(input.LA(1)>=17 && input.LA(1)<=19) ) {
            	        input.consume();
            	        adaptor.addChild(root_0, (CommonTree)adaptor.create(set22));
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "complex"

    public static class configKey_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "configKey"
    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:121:1: configKey : ke= ID ;
    public final ConfigSimpleParser.configKey_return configKey() throws RecognitionException {
        ConfigSimpleParser.configKey_return retval = new ConfigSimpleParser.configKey_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ke=null;

        CommonTree ke_tree=null;

        try {
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:121:11: (ke= ID )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:121:13: ke= ID
            {
            root_0 = (CommonTree)adaptor.nil();

            ke=(Token)match(input,ID,FOLLOW_ID_in_configKey418); 
            ke_tree = (CommonTree)adaptor.create(ke);
            adaptor.addChild(root_0, ke_tree);

             
                
                if (!reservedKeys.contains( (ke!=null?ke.getText():null).toLowerCase() ) ) 
                { throw new RuntimeException("Error! "+(ke!=null?ke.getText():null) + " is not a recognized keyword in the config file!" ); } 


            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "configKey"

    // Delegated rules


 

    public static final BitSet FOLLOW_ENDLINE_in_dssTransfer60 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_Begin_in_dssTransfer63 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_dssTransfer65 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ENDLINE_in_dssTransfer67 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_transferItem_in_dssTransfer79 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_End_in_dssTransfer102 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_dssTransfer104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ID_in_transferItem137 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_pair_in_transferItem142 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ENDLINE_in_transferItem148 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ID_in_pair170 = new BitSet(new long[]{0x0000000000018020L});
    public static final BitSet FOLLOW_set_in_pair171 = new BitSet(new long[]{0x0000000000018020L});
    public static final BitSet FOLLOW_16_in_pair179 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ID_in_pair181 = new BitSet(new long[]{0x0000000000008022L});
    public static final BitSet FOLLOW_set_in_pair182 = new BitSet(new long[]{0x0000000000008022L});
    public static final BitSet FOLLOW_ENDLINE_in_configFile207 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_Begin_in_configFile217 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Config_in_configFile219 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ENDLINE_in_configFile221 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_configItem_in_configFile232 = new BitSet(new long[]{0x0000000000000120L});
    public static final BitSet FOLLOW_End_in_configFile245 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_Config_in_configFile247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_configKey_in_configItem278 = new BitSet(new long[]{0x00000000000E8220L});
    public static final BitSet FOLLOW_integer_in_configItem299 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_complex_in_configItem320 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ENDLINE_in_configItem348 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_INT_in_integer369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_complex377 = new BitSet(new long[]{0x00000000000E8020L});
    public static final BitSet FOLLOW_set_in_complex381 = new BitSet(new long[]{0x00000000000E8022L});
    public static final BitSet FOLLOW_ID_in_configKey418 = new BitSet(new long[]{0x0000000000000002L});

}