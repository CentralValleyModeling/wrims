// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g 2011-03-11 12:19:04

  package wrimsv2.evaluator;
    
  import org.antlr.runtime.ANTLRFileStream;
  import org.antlr.runtime.CharStream;
  import org.antlr.runtime.CommonTokenStream;
  import org.antlr.runtime.RecognitionException;
  import org.antlr.runtime.TokenStream;
  
  import wrimsv2.components.Error;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class EvaluatorParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "CONSTRAIN", "TAFCFS", "IDENT", "SYMBOLS", "BACKSLASH", "IDENT1", "IDENT2", "INTEGER", "FLOAT", "LETTER", "DIGIT", "MAX", "MIN", "INT", "ABS", "LOG", "LOG10", "POW", "RANGE", "MONTH", "MONTH_CONST", "I", "YEAR", "PASTMONTH", "DAYSIN", "SUM", "MOD", "WHERE", "ALWAYS", "NAME", "DVAR", "CYCLE", "FILE", "CONDITION", "INCLUDE", "LOWERBOUND", "UPPERBOUND", "INTEGERTYPE", "UNITS", "CONVERTUNITS", "TYPE", "OUTPUT", "CASE", "ORDER", "EXPRESSION", "LHSGTRHS", "LHSLTRHS", "WEIGHT", "FUNCTION", "FROM_WRESL_FILE", "SVAR", "MULTILINE_COMMENT", "WS", "COMMENT", "'v:'", "'g:'", "'c:'", "'*'", "'+'", "'-'", "'/'", "':'", "';'", "'.'", "'|'", "'('", "')'", "'timeseries'", "'kind'", "'='", "'select'", "'from'", "'given'", "'use'", "'['", "']'", "'=='", "'<'", "'>'", "'>='", "'<='", "'.and.'", "'.or.'"
    };
    public static final int FUNCTION=52;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int WHERE=31;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int YEAR=26;
    public static final int ORDER=47;
    public static final int MOD=30;
    public static final int LETTER=13;
    public static final int LOG=19;
    public static final int INTEGERTYPE=41;
    public static final int CYCLE=35;
    public static final int CASE=46;
    public static final int MAX=15;
    public static final int CONDITION=37;
    public static final int FLOAT=12;
    public static final int MONTH_CONST=24;
    public static final int SUM=29;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int MONTH=23;
    public static final int TYPE=44;
    public static final int UNITS=42;
    public static final int MULTILINE_COMMENT=55;
    public static final int NAME=33;
    public static final int T__58=58;
    public static final int IDENT2=10;
    public static final int POW=21;
    public static final int IDENT1=9;
    public static final int ALWAYS=32;
    public static final int T__59=59;
    public static final int INCLUDE=38;
    public static final int IDENT=6;
    public static final int TAFCFS=5;
    public static final int DIGIT=14;
    public static final int COMMENT=57;
    public static final int EXPRESSION=48;
    public static final int INTEGER=11;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int LOG10=20;
    public static final int DVAR=34;
    public static final int I=25;
    public static final int UPPERBOUND=40;
    public static final int PASTMONTH=27;
    public static final int RANGE=22;
    public static final int SVAR=54;
    public static final int INT=17;
    public static final int WEIGHT=51;
    public static final int FROM_WRESL_FILE=53;
    public static final int MIN=16;
    public static final int LHSLTRHS=50;
    public static final int T__85=85;
    public static final int FILE=36;
    public static final int T__84=84;
    public static final int T__86=86;
    public static final int ABS=18;
    public static final int DAYSIN=28;
    public static final int WS=56;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int CONVERTUNITS=43;
    public static final int CONSTRAIN=4;
    public static final int LHSGTRHS=49;
    public static final int SYMBOLS=7;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int LOWERBOUND=39;
    public static final int T__74=74;
    public static final int OUTPUT=45;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;
    public static final int BACKSLASH=8;

    // delegates
    // delegators


        public EvaluatorParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public EvaluatorParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return EvaluatorParser.tokenNames; }
    public String getGrammarFileName() { return "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g"; }


      public static EvalConstraint evalConstraint;
      public static boolean evalCondition;
      
      @Override
      public void reportError(RecognitionException e) {
           Error.error_evaluation.add(getErrorMessage(e, tokenNames));
      }



    // $ANTLR start "evaluator"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:36:1: evaluator returns [String result] : ( expressionInput | goalInput | conditionInput );
    public final String evaluator() throws RecognitionException {
        String result = null;

        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:37:2: ( expressionInput | goalInput | conditionInput )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 58:
                {
                alt1=1;
                }
                break;
            case 59:
                {
                alt1=2;
                }
                break;
            case 60:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:37:4: expressionInput
                    {
                    pushFollow(FOLLOW_expressionInput_in_evaluator50);
                    expressionInput();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:38:2: goalInput
                    {
                    pushFollow(FOLLOW_goalInput_in_evaluator55);
                    goalInput();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:39:2: conditionInput
                    {
                    pushFollow(FOLLOW_conditionInput_in_evaluator59);
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
        }
        return result;
    }
    // $ANTLR end "evaluator"


    // $ANTLR start "expressionInput"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:46:1: expressionInput : 'v:' expressionCollection ;
    public final void expressionInput() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:46:16: ( 'v:' expressionCollection )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:46:18: 'v:' expressionCollection
            {
            match(input,58,FOLLOW_58_in_expressionInput73); 
            pushFollow(FOLLOW_expressionCollection_in_expressionInput75);
            expressionCollection();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "expressionInput"


    // $ANTLR start "goalInput"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:47:1: goalInput : 'g:' constraintStatement ;
    public final void goalInput() throws RecognitionException {
        EvalConstraint constraintStatement1 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:47:10: ( 'g:' constraintStatement )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:47:12: 'g:' constraintStatement
            {
            match(input,59,FOLLOW_59_in_goalInput81); 
            pushFollow(FOLLOW_constraintStatement_in_goalInput83);
            constraintStatement1=constraintStatement();

            state._fsp--;

            evalConstraint = constraintStatement1;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "goalInput"


    // $ANTLR start "conditionInput"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:48:1: conditionInput : 'c:' conditionStatement ;
    public final void conditionInput() throws RecognitionException {
        boolean conditionStatement2 = false;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:48:15: ( 'c:' conditionStatement )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:48:17: 'c:' conditionStatement
            {
            match(input,60,FOLLOW_60_in_conditionInput91); 
            pushFollow(FOLLOW_conditionStatement_in_conditionInput93);
            conditionStatement2=conditionStatement();

            state._fsp--;

            evalCondition=conditionStatement2;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "conditionInput"


    // $ANTLR start "lhsrhs"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:53:1: lhsrhs : ( weight | CONSTRAIN );
    public final void lhsrhs() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:53:7: ( weight | CONSTRAIN )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=INTEGER && LA2_0<=FLOAT)||LA2_0==63) ) {
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
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:53:9: weight
                    {
                    pushFollow(FOLLOW_weight_in_lhsrhs105);
                    weight();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:53:16: CONSTRAIN
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
        }
        return ;
    }
    // $ANTLR end "lhsrhs"


    // $ANTLR start "weight"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:1: weight : ( allnumber | ( allnumber '*' TAFCFS ) ) ( ( '+' allnumber ) | ( '-' allnumber ) )? ;
    public final void weight() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:8: ( ( allnumber | ( allnumber '*' TAFCFS ) ) ( ( '+' allnumber ) | ( '-' allnumber ) )? )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:10: ( allnumber | ( allnumber '*' TAFCFS ) ) ( ( '+' allnumber ) | ( '-' allnumber ) )?
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:10: ( allnumber | ( allnumber '*' TAFCFS ) )
            int alt3=2;
            switch ( input.LA(1) ) {
            case 63:
                {
                int LA3_1 = input.LA(2);

                if ( (LA3_1==INTEGER) ) {
                    int LA3_2 = input.LA(3);

                    if ( (LA3_2==61) ) {
                        alt3=2;
                    }
                    else if ( (LA3_2==EOF||(LA3_2>=62 && LA3_2<=63)) ) {
                        alt3=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA3_1==FLOAT) ) {
                    int LA3_3 = input.LA(3);

                    if ( (LA3_3==61) ) {
                        alt3=2;
                    }
                    else if ( (LA3_3==EOF||(LA3_3>=62 && LA3_3<=63)) ) {
                        alt3=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 3, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 1, input);

                    throw nvae;
                }
                }
                break;
            case INTEGER:
                {
                int LA3_2 = input.LA(2);

                if ( (LA3_2==61) ) {
                    alt3=2;
                }
                else if ( (LA3_2==EOF||(LA3_2>=62 && LA3_2<=63)) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 2, input);

                    throw nvae;
                }
                }
                break;
            case FLOAT:
                {
                int LA3_3 = input.LA(2);

                if ( (LA3_3==61) ) {
                    alt3=2;
                }
                else if ( (LA3_3==EOF||(LA3_3>=62 && LA3_3<=63)) ) {
                    alt3=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 3, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:11: allnumber
                    {
                    pushFollow(FOLLOW_allnumber_in_weight116);
                    allnumber();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:21: ( allnumber '*' TAFCFS )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:21: ( allnumber '*' TAFCFS )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:22: allnumber '*' TAFCFS
                    {
                    pushFollow(FOLLOW_allnumber_in_weight119);
                    allnumber();

                    state._fsp--;

                    match(input,61,FOLLOW_61_in_weight121); 
                    match(input,TAFCFS,FOLLOW_TAFCFS_in_weight123); 

                    }


                    }
                    break;

            }

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:45: ( ( '+' allnumber ) | ( '-' allnumber ) )?
            int alt4=3;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==62) ) {
                alt4=1;
            }
            else if ( (LA4_0==63) ) {
                alt4=2;
            }
            switch (alt4) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:46: ( '+' allnumber )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:46: ( '+' allnumber )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:47: '+' allnumber
                    {
                    match(input,62,FOLLOW_62_in_weight129); 
                    pushFollow(FOLLOW_allnumber_in_weight131);
                    allnumber();

                    state._fsp--;


                    }


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:62: ( '-' allnumber )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:62: ( '-' allnumber )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:55:63: '-' allnumber
                    {
                    match(input,63,FOLLOW_63_in_weight135); 
                    pushFollow(FOLLOW_allnumber_in_weight137);
                    allnumber();

                    state._fsp--;


                    }


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
        }
        return ;
    }
    // $ANTLR end "weight"


    // $ANTLR start "units"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:57:1: units : ( IDENT | ( IDENT '/' IDENT ) );
    public final void units() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:57:6: ( IDENT | ( IDENT '/' IDENT ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==IDENT) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==64) ) {
                    alt5=2;
                }
                else if ( (LA5_1==EOF) ) {
                    alt5=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:57:8: IDENT
                    {
                    match(input,IDENT,FOLLOW_IDENT_in_units147); 

                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:57:14: ( IDENT '/' IDENT )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:57:14: ( IDENT '/' IDENT )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:57:15: IDENT '/' IDENT
                    {
                    match(input,IDENT,FOLLOW_IDENT_in_units150); 
                    match(input,64,FOLLOW_64_in_units152); 
                    match(input,IDENT,FOLLOW_IDENT_in_units154); 

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
        }
        return ;
    }
    // $ANTLR end "units"


    // $ANTLR start "fileName"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:59:1: fileName : ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+ ;
    public final void fileName() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:3: ( ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+ )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:5: ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:5: ( ':' | ';' | '.' | '|' | SYMBOLS | '-' | '+' | BACKSLASH | IDENT | IDENT1 | IDENT2 | INTEGER | FLOAT | usedKeywords )+
            int cnt6=0;
            loop6:
            do {
                int alt6=15;
                switch ( input.LA(1) ) {
                case 65:
                    {
                    alt6=1;
                    }
                    break;
                case 66:
                    {
                    alt6=2;
                    }
                    break;
                case 67:
                    {
                    alt6=3;
                    }
                    break;
                case 68:
                    {
                    alt6=4;
                    }
                    break;
                case SYMBOLS:
                    {
                    alt6=5;
                    }
                    break;
                case 63:
                    {
                    alt6=6;
                    }
                    break;
                case 62:
                    {
                    alt6=7;
                    }
                    break;
                case BACKSLASH:
                    {
                    alt6=8;
                    }
                    break;
                case IDENT:
                    {
                    alt6=9;
                    }
                    break;
                case IDENT1:
                    {
                    alt6=10;
                    }
                    break;
                case IDENT2:
                    {
                    alt6=11;
                    }
                    break;
                case INTEGER:
                    {
                    alt6=12;
                    }
                    break;
                case FLOAT:
                    {
                    alt6=13;
                    }
                    break;
                case CONSTRAIN:
                case TAFCFS:
                case MAX:
                case MIN:
                case INT:
                case ABS:
                case LOG:
                case LOG10:
                case POW:
                case RANGE:
                case MONTH:
                case MONTH_CONST:
                case I:
                case YEAR:
                case PASTMONTH:
                case DAYSIN:
                case SUM:
                case MOD:
                case WHERE:
                case ALWAYS:
                case NAME:
                case DVAR:
                case CYCLE:
                case FILE:
                case CONDITION:
                case INCLUDE:
                case LOWERBOUND:
                case UPPERBOUND:
                case INTEGERTYPE:
                case UNITS:
                case CONVERTUNITS:
                case TYPE:
                case OUTPUT:
                case CASE:
                case ORDER:
                case EXPRESSION:
                case LHSGTRHS:
                case LHSLTRHS:
                case WEIGHT:
                case FUNCTION:
                case FROM_WRESL_FILE:
                    {
                    alt6=14;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:6: ':'
            	    {
            	    match(input,65,FOLLOW_65_in_fileName166); 

            	    }
            	    break;
            	case 2 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:10: ';'
            	    {
            	    match(input,66,FOLLOW_66_in_fileName168); 

            	    }
            	    break;
            	case 3 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:14: '.'
            	    {
            	    match(input,67,FOLLOW_67_in_fileName170); 

            	    }
            	    break;
            	case 4 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:18: '|'
            	    {
            	    match(input,68,FOLLOW_68_in_fileName172); 

            	    }
            	    break;
            	case 5 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:22: SYMBOLS
            	    {
            	    match(input,SYMBOLS,FOLLOW_SYMBOLS_in_fileName174); 

            	    }
            	    break;
            	case 6 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:30: '-'
            	    {
            	    match(input,63,FOLLOW_63_in_fileName176); 

            	    }
            	    break;
            	case 7 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:34: '+'
            	    {
            	    match(input,62,FOLLOW_62_in_fileName178); 

            	    }
            	    break;
            	case 8 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:38: BACKSLASH
            	    {
            	    match(input,BACKSLASH,FOLLOW_BACKSLASH_in_fileName180); 

            	    }
            	    break;
            	case 9 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:48: IDENT
            	    {
            	    match(input,IDENT,FOLLOW_IDENT_in_fileName182); 

            	    }
            	    break;
            	case 10 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:54: IDENT1
            	    {
            	    match(input,IDENT1,FOLLOW_IDENT1_in_fileName184); 

            	    }
            	    break;
            	case 11 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:61: IDENT2
            	    {
            	    match(input,IDENT2,FOLLOW_IDENT2_in_fileName186); 

            	    }
            	    break;
            	case 12 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:68: INTEGER
            	    {
            	    match(input,INTEGER,FOLLOW_INTEGER_in_fileName188); 

            	    }
            	    break;
            	case 13 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:76: FLOAT
            	    {
            	    match(input,FLOAT,FOLLOW_FLOAT_in_fileName190); 

            	    }
            	    break;
            	case 14 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:60:82: usedKeywords
            	    {
            	    pushFollow(FOLLOW_usedKeywords_in_fileName192);
            	    usedKeywords();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


              

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "fileName"


    // $ANTLR start "externalFile"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:64:1: externalFile : ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+ ;
    public final void externalFile() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:65:3: ( ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+ )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:65:5: ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:65:5: ( ';' | '.' | '|' | SYMBOLS | '-' | '+' | INTEGER | FLOAT | IDENT | usedKeywords )+
            int cnt7=0;
            loop7:
            do {
                int alt7=11;
                switch ( input.LA(1) ) {
                case 66:
                    {
                    alt7=1;
                    }
                    break;
                case 67:
                    {
                    alt7=2;
                    }
                    break;
                case 68:
                    {
                    alt7=3;
                    }
                    break;
                case SYMBOLS:
                    {
                    alt7=4;
                    }
                    break;
                case 63:
                    {
                    alt7=5;
                    }
                    break;
                case 62:
                    {
                    alt7=6;
                    }
                    break;
                case INTEGER:
                    {
                    alt7=7;
                    }
                    break;
                case FLOAT:
                    {
                    alt7=8;
                    }
                    break;
                case IDENT:
                    {
                    alt7=9;
                    }
                    break;
                case CONSTRAIN:
                case TAFCFS:
                case MAX:
                case MIN:
                case INT:
                case ABS:
                case LOG:
                case LOG10:
                case POW:
                case RANGE:
                case MONTH:
                case MONTH_CONST:
                case I:
                case YEAR:
                case PASTMONTH:
                case DAYSIN:
                case SUM:
                case MOD:
                case WHERE:
                case ALWAYS:
                case NAME:
                case DVAR:
                case CYCLE:
                case FILE:
                case CONDITION:
                case INCLUDE:
                case LOWERBOUND:
                case UPPERBOUND:
                case INTEGERTYPE:
                case UNITS:
                case CONVERTUNITS:
                case TYPE:
                case OUTPUT:
                case CASE:
                case ORDER:
                case EXPRESSION:
                case LHSGTRHS:
                case LHSLTRHS:
                case WEIGHT:
                case FUNCTION:
                case FROM_WRESL_FILE:
                    {
                    alt7=10;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:65:6: ';'
            	    {
            	    match(input,66,FOLLOW_66_in_externalFile211); 

            	    }
            	    break;
            	case 2 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:65:10: '.'
            	    {
            	    match(input,67,FOLLOW_67_in_externalFile213); 

            	    }
            	    break;
            	case 3 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:65:14: '|'
            	    {
            	    match(input,68,FOLLOW_68_in_externalFile215); 

            	    }
            	    break;
            	case 4 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:65:18: SYMBOLS
            	    {
            	    match(input,SYMBOLS,FOLLOW_SYMBOLS_in_externalFile217); 

            	    }
            	    break;
            	case 5 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:65:26: '-'
            	    {
            	    match(input,63,FOLLOW_63_in_externalFile219); 

            	    }
            	    break;
            	case 6 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:65:30: '+'
            	    {
            	    match(input,62,FOLLOW_62_in_externalFile221); 

            	    }
            	    break;
            	case 7 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:65:34: INTEGER
            	    {
            	    match(input,INTEGER,FOLLOW_INTEGER_in_externalFile223); 

            	    }
            	    break;
            	case 8 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:65:42: FLOAT
            	    {
            	    match(input,FLOAT,FOLLOW_FLOAT_in_externalFile225); 

            	    }
            	    break;
            	case 9 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:65:48: IDENT
            	    {
            	    match(input,IDENT,FOLLOW_IDENT_in_externalFile227); 

            	    }
            	    break;
            	case 10 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:65:54: usedKeywords
            	    {
            	    pushFollow(FOLLOW_usedKeywords_in_externalFile229);
            	    usedKeywords();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "externalFile"


    // $ANTLR start "text"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:68:1: text : LETTER ( LETTER | DIGIT )* ;
    public final void text() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:68:6: ( LETTER ( LETTER | DIGIT )* )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:68:8: LETTER ( LETTER | DIGIT )*
            {
            match(input,LETTER,FOLLOW_LETTER_in_text243); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:68:15: ( LETTER | DIGIT )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=LETTER && LA8_0<=DIGIT)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:
            	    {
            	    if ( (input.LA(1)>=LETTER && input.LA(1)<=DIGIT) ) {
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
            	    break loop8;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "text"


    // $ANTLR start "expressionCollection"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:70:1: expressionCollection returns [EvalExpression ee] : ( ( expression ) | ( tableSQL ) | ( timeseriesWithUnits ) | ( timeseries ) | ( function ) | (i1= sumExpression ) ) ;
    public final EvalExpression expressionCollection() throws RecognitionException {
        EvalExpression ee = null;

        EvalExpression expression3 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:71:2: ( ( ( expression ) | ( tableSQL ) | ( timeseriesWithUnits ) | ( timeseries ) | ( function ) | (i1= sumExpression ) ) )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:71:4: ( ( expression ) | ( tableSQL ) | ( timeseriesWithUnits ) | ( timeseries ) | ( function ) | (i1= sumExpression ) )
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:71:4: ( ( expression ) | ( tableSQL ) | ( timeseriesWithUnits ) | ( timeseries ) | ( function ) | (i1= sumExpression ) )
            int alt9=6;
            alt9 = dfa9.predict(input);
            switch (alt9) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:71:5: ( expression )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:71:5: ( expression )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:71:6: expression
                    {
                    pushFollow(FOLLOW_expression_in_expressionCollection269);
                    expression3=expression();

                    state._fsp--;


                    	   ee=expression3;
                    	

                    }


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:5: ( tableSQL )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:5: ( tableSQL )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:6: tableSQL
                    {
                    pushFollow(FOLLOW_tableSQL_in_expressionCollection274);
                    tableSQL();

                    state._fsp--;


                    }


                    }
                    break;
                case 3 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:16: ( timeseriesWithUnits )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:16: ( timeseriesWithUnits )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:17: timeseriesWithUnits
                    {
                    pushFollow(FOLLOW_timeseriesWithUnits_in_expressionCollection278);
                    timeseriesWithUnits();

                    state._fsp--;


                    }


                    }
                    break;
                case 4 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:38: ( timeseries )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:38: ( timeseries )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:39: timeseries
                    {
                    pushFollow(FOLLOW_timeseries_in_expressionCollection282);
                    timeseries();

                    state._fsp--;


                    }


                    }
                    break;
                case 5 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:51: ( function )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:51: ( function )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:52: function
                    {
                    pushFollow(FOLLOW_function_in_expressionCollection286);
                    function();

                    state._fsp--;


                    }


                    }
                    break;
                case 6 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:62: (i1= sumExpression )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:62: (i1= sumExpression )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:73:63: i1= sumExpression
                    {
                    pushFollow(FOLLOW_sumExpression_in_expressionCollection292);
                    sumExpression();

                    state._fsp--;


                    }


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
        }
        return ee;
    }
    // $ANTLR end "expressionCollection"


    // $ANTLR start "func"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:76:1: func : ( max_func | min_func | int_func | abs_func | log_func | log10_func | pow_func );
    public final void func() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:76:6: ( max_func | min_func | int_func | abs_func | log_func | log10_func | pow_func )
            int alt10=7;
            switch ( input.LA(1) ) {
            case MAX:
                {
                alt10=1;
                }
                break;
            case MIN:
                {
                alt10=2;
                }
                break;
            case INT:
                {
                alt10=3;
                }
                break;
            case ABS:
                {
                alt10=4;
                }
                break;
            case LOG:
                {
                alt10=5;
                }
                break;
            case LOG10:
                {
                alt10=6;
                }
                break;
            case POW:
                {
                alt10=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:77:3: max_func
                    {
                    pushFollow(FOLLOW_max_func_in_func307);
                    max_func();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:78:3: min_func
                    {
                    pushFollow(FOLLOW_min_func_in_func312);
                    min_func();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:79:3: int_func
                    {
                    pushFollow(FOLLOW_int_func_in_func317);
                    int_func();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:80:3: abs_func
                    {
                    pushFollow(FOLLOW_abs_func_in_func322);
                    abs_func();

                    state._fsp--;


                    }
                    break;
                case 5 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:81:3: log_func
                    {
                    pushFollow(FOLLOW_log_func_in_func327);
                    log_func();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:82:3: log10_func
                    {
                    pushFollow(FOLLOW_log10_func_in_func332);
                    log10_func();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:83:3: pow_func
                    {
                    pushFollow(FOLLOW_pow_func_in_func337);
                    pow_func();

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
        }
        return ;
    }
    // $ANTLR end "func"


    // $ANTLR start "max_func"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:85:1: max_func : MAX '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' ;
    public final void max_func() throws RecognitionException {
        EvalExpression e1 = null;

        EvalExpression e2 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:86:2: ( MAX '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:86:4: MAX '(' (e1= expression ) ( ';' (e2= expression ) )+ ')'
            {
            match(input,MAX,FOLLOW_MAX_in_max_func347); 
            match(input,69,FOLLOW_69_in_max_func349); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:86:12: (e1= expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:86:13: e1= expression
            {
            pushFollow(FOLLOW_expression_in_max_func354);
            e1=expression();

            state._fsp--;


            }

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:86:27: ( ';' (e2= expression ) )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==66) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:86:28: ';' (e2= expression )
            	    {
            	    match(input,66,FOLLOW_66_in_max_func357); 
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:86:32: (e2= expression )
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:86:33: e2= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_max_func362);
            	    e2=expression();

            	    state._fsp--;


            	    }


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

            match(input,70,FOLLOW_70_in_max_func367); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "max_func"


    // $ANTLR start "min_func"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:89:1: min_func : MIN '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' ;
    public final void min_func() throws RecognitionException {
        EvalExpression e1 = null;

        EvalExpression e2 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:90:2: ( MIN '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:90:4: MIN '(' (e1= expression ) ( ';' (e2= expression ) )+ ')'
            {
            match(input,MIN,FOLLOW_MIN_in_min_func379); 
            match(input,69,FOLLOW_69_in_min_func381); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:90:12: (e1= expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:90:13: e1= expression
            {
            pushFollow(FOLLOW_expression_in_min_func386);
            e1=expression();

            state._fsp--;


            }

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:90:27: ( ';' (e2= expression ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==66) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:90:28: ';' (e2= expression )
            	    {
            	    match(input,66,FOLLOW_66_in_min_func389); 
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:90:32: (e2= expression )
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:90:33: e2= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_min_func394);
            	    e2=expression();

            	    state._fsp--;


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);

            match(input,70,FOLLOW_70_in_min_func399); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "min_func"


    // $ANTLR start "int_func"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:93:1: int_func : INT '(' (e1= expression ) ')' ;
    public final void int_func() throws RecognitionException {
        EvalExpression e1 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:94:3: ( INT '(' (e1= expression ) ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:94:5: INT '(' (e1= expression ) ')'
            {
            match(input,INT,FOLLOW_INT_in_int_func413); 
            match(input,69,FOLLOW_69_in_int_func415); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:94:13: (e1= expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:94:14: e1= expression
            {
            pushFollow(FOLLOW_expression_in_int_func420);
            e1=expression();

            state._fsp--;


            }

            match(input,70,FOLLOW_70_in_int_func423); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "int_func"


    // $ANTLR start "abs_func"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:97:1: abs_func : ABS '(' (e1= expression ) ')' ;
    public final void abs_func() throws RecognitionException {
        EvalExpression e1 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:98:3: ( ABS '(' (e1= expression ) ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:98:5: ABS '(' (e1= expression ) ')'
            {
            match(input,ABS,FOLLOW_ABS_in_abs_func439); 
            match(input,69,FOLLOW_69_in_abs_func441); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:98:13: (e1= expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:98:14: e1= expression
            {
            pushFollow(FOLLOW_expression_in_abs_func446);
            e1=expression();

            state._fsp--;


            }

            match(input,70,FOLLOW_70_in_abs_func449); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "abs_func"


    // $ANTLR start "log_func"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:101:1: log_func : LOG '(' (e1= expression ) ')' ;
    public final void log_func() throws RecognitionException {
        EvalExpression e1 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:102:3: ( LOG '(' (e1= expression ) ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:102:5: LOG '(' (e1= expression ) ')'
            {
            match(input,LOG,FOLLOW_LOG_in_log_func463); 
            match(input,69,FOLLOW_69_in_log_func465); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:102:13: (e1= expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:102:14: e1= expression
            {
            pushFollow(FOLLOW_expression_in_log_func470);
            e1=expression();

            state._fsp--;


            }

            match(input,70,FOLLOW_70_in_log_func473); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "log_func"


    // $ANTLR start "log10_func"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:105:1: log10_func : LOG10 '(' (e1= expression ) ')' ;
    public final void log10_func() throws RecognitionException {
        EvalExpression e1 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:106:3: ( LOG10 '(' (e1= expression ) ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:106:5: LOG10 '(' (e1= expression ) ')'
            {
            match(input,LOG10,FOLLOW_LOG10_in_log10_func487); 
            match(input,69,FOLLOW_69_in_log10_func489); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:106:15: (e1= expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:106:16: e1= expression
            {
            pushFollow(FOLLOW_expression_in_log10_func494);
            e1=expression();

            state._fsp--;


            }

            match(input,70,FOLLOW_70_in_log10_func497); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "log10_func"


    // $ANTLR start "pow_func"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:109:1: pow_func : POW '(' (e1= expression ) ( ';' (e2= expression ) ) ')' ;
    public final void pow_func() throws RecognitionException {
        EvalExpression e1 = null;

        EvalExpression e2 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:110:3: ( POW '(' (e1= expression ) ( ';' (e2= expression ) ) ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:110:5: POW '(' (e1= expression ) ( ';' (e2= expression ) ) ')'
            {
            match(input,POW,FOLLOW_POW_in_pow_func513); 
            match(input,69,FOLLOW_69_in_pow_func515); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:110:13: (e1= expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:110:14: e1= expression
            {
            pushFollow(FOLLOW_expression_in_pow_func520);
            e1=expression();

            state._fsp--;


            }

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:110:29: ( ';' (e2= expression ) )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:110:30: ';' (e2= expression )
            {
            match(input,66,FOLLOW_66_in_pow_func524); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:110:34: (e2= expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:110:35: e2= expression
            {
            pushFollow(FOLLOW_expression_in_pow_func529);
            e2=expression();

            state._fsp--;


            }


            }

            match(input,70,FOLLOW_70_in_pow_func533); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pow_func"


    // $ANTLR start "range_func"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:113:1: range_func returns [boolean result] : RANGE '(' MONTH ';' m1= MONTH_CONST ';' m2= MONTH_CONST ')' ;
    public final boolean range_func() throws RecognitionException {
        boolean result = false;

        Token m1=null;
        Token m2=null;

        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:114:3: ( RANGE '(' MONTH ';' m1= MONTH_CONST ';' m2= MONTH_CONST ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:114:5: RANGE '(' MONTH ';' m1= MONTH_CONST ';' m2= MONTH_CONST ')'
            {
            match(input,RANGE,FOLLOW_RANGE_in_range_func552); 
            match(input,69,FOLLOW_69_in_range_func554); 
            match(input,MONTH,FOLLOW_MONTH_in_range_func556); 
            match(input,66,FOLLOW_66_in_range_func558); 
            m1=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_range_func562); 
            match(input,66,FOLLOW_66_in_range_func564); 
            m2=(Token)match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_range_func568); 
            match(input,70,FOLLOW_70_in_range_func570); 
            Evaluation.range((m1!=null?m1.getText():null), (m2!=null?m2.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "range_func"


    // $ANTLR start "timeseriesWithUnits"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:116:1: timeseriesWithUnits : 'timeseries' 'kind' '=' i1= partC 'units' '=' i2= IDENT ;
    public final void timeseriesWithUnits() throws RecognitionException {
        Token i2=null;

        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:117:2: ( 'timeseries' 'kind' '=' i1= partC 'units' '=' i2= IDENT )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:117:4: 'timeseries' 'kind' '=' i1= partC 'units' '=' i2= IDENT
            {
            match(input,71,FOLLOW_71_in_timeseriesWithUnits582); 
            match(input,72,FOLLOW_72_in_timeseriesWithUnits584); 
            match(input,73,FOLLOW_73_in_timeseriesWithUnits586); 
            pushFollow(FOLLOW_partC_in_timeseriesWithUnits590);
            partC();

            state._fsp--;

            match(input,UNITS,FOLLOW_UNITS_in_timeseriesWithUnits592); 
            match(input,73,FOLLOW_73_in_timeseriesWithUnits594); 
            i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_timeseriesWithUnits598); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "timeseriesWithUnits"


    // $ANTLR start "timeseries"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:120:1: timeseries : 'timeseries' ;
    public final void timeseries() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:121:2: ( 'timeseries' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:121:4: 'timeseries'
            {
            match(input,71,FOLLOW_71_in_timeseries610); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "timeseries"


    // $ANTLR start "partC"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:126:1: partC : ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )* ;
    public final void partC() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:126:6: ( ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )* )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:126:9: ( IDENT | IDENT1 | usedKeywords ) ( '-' ( IDENT | IDENT1 | usedKeywords ) )*
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:126:9: ( IDENT | IDENT1 | usedKeywords )
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
            case CONSTRAIN:
            case TAFCFS:
            case MAX:
            case MIN:
            case INT:
            case ABS:
            case LOG:
            case LOG10:
            case POW:
            case RANGE:
            case MONTH:
            case MONTH_CONST:
            case I:
            case YEAR:
            case PASTMONTH:
            case DAYSIN:
            case SUM:
            case MOD:
            case WHERE:
            case ALWAYS:
            case NAME:
            case DVAR:
            case CYCLE:
            case FILE:
            case CONDITION:
            case INCLUDE:
            case LOWERBOUND:
            case UPPERBOUND:
            case INTEGERTYPE:
            case UNITS:
            case CONVERTUNITS:
            case TYPE:
            case OUTPUT:
            case CASE:
            case ORDER:
            case EXPRESSION:
            case LHSGTRHS:
            case LHSLTRHS:
            case WEIGHT:
            case FUNCTION:
            case FROM_WRESL_FILE:
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
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:126:10: IDENT
                    {
                    match(input,IDENT,FOLLOW_IDENT_in_partC626); 

                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:126:16: IDENT1
                    {
                    match(input,IDENT1,FOLLOW_IDENT1_in_partC628); 

                    }
                    break;
                case 3 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:126:23: usedKeywords
                    {
                    pushFollow(FOLLOW_usedKeywords_in_partC630);
                    usedKeywords();

                    state._fsp--;


                    }
                    break;

            }

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:126:37: ( '-' ( IDENT | IDENT1 | usedKeywords ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==63) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:126:38: '-' ( IDENT | IDENT1 | usedKeywords )
            	    {
            	    match(input,63,FOLLOW_63_in_partC634); 
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:126:42: ( IDENT | IDENT1 | usedKeywords )
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
            	    case CONSTRAIN:
            	    case TAFCFS:
            	    case MAX:
            	    case MIN:
            	    case INT:
            	    case ABS:
            	    case LOG:
            	    case LOG10:
            	    case POW:
            	    case RANGE:
            	    case MONTH:
            	    case MONTH_CONST:
            	    case I:
            	    case YEAR:
            	    case PASTMONTH:
            	    case DAYSIN:
            	    case SUM:
            	    case MOD:
            	    case WHERE:
            	    case ALWAYS:
            	    case NAME:
            	    case DVAR:
            	    case CYCLE:
            	    case FILE:
            	    case CONDITION:
            	    case INCLUDE:
            	    case LOWERBOUND:
            	    case UPPERBOUND:
            	    case INTEGERTYPE:
            	    case UNITS:
            	    case CONVERTUNITS:
            	    case TYPE:
            	    case OUTPUT:
            	    case CASE:
            	    case ORDER:
            	    case EXPRESSION:
            	    case LHSGTRHS:
            	    case LHSLTRHS:
            	    case WEIGHT:
            	    case FUNCTION:
            	    case FROM_WRESL_FILE:
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
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:126:43: IDENT
            	            {
            	            match(input,IDENT,FOLLOW_IDENT_in_partC637); 

            	            }
            	            break;
            	        case 2 :
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:126:49: IDENT1
            	            {
            	            match(input,IDENT1,FOLLOW_IDENT1_in_partC639); 

            	            }
            	            break;
            	        case 3 :
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:126:56: usedKeywords
            	            {
            	            pushFollow(FOLLOW_usedKeywords_in_partC641);
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
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "partC"


    // $ANTLR start "usedKeywords"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:128:1: usedKeywords : ( I | YEAR | MONTH | MONTH_CONST | PASTMONTH | RANGE | TAFCFS | DAYSIN | SUM | MAX | MIN | INT | ABS | LOG | LOG10 | POW | MOD | WHERE | CONSTRAIN | ALWAYS | NAME | DVAR | CYCLE | FILE | CONDITION | INCLUDE | LOWERBOUND | UPPERBOUND | INTEGERTYPE | UNITS | CONVERTUNITS | TYPE | OUTPUT | CASE | ORDER | EXPRESSION | LHSGTRHS | LHSLTRHS | WEIGHT | FUNCTION | FROM_WRESL_FILE );
    public final void usedKeywords() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:128:13: ( I | YEAR | MONTH | MONTH_CONST | PASTMONTH | RANGE | TAFCFS | DAYSIN | SUM | MAX | MIN | INT | ABS | LOG | LOG10 | POW | MOD | WHERE | CONSTRAIN | ALWAYS | NAME | DVAR | CYCLE | FILE | CONDITION | INCLUDE | LOWERBOUND | UPPERBOUND | INTEGERTYPE | UNITS | CONVERTUNITS | TYPE | OUTPUT | CASE | ORDER | EXPRESSION | LHSGTRHS | LHSLTRHS | WEIGHT | FUNCTION | FROM_WRESL_FILE )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:
            {
            if ( (input.LA(1)>=CONSTRAIN && input.LA(1)<=TAFCFS)||(input.LA(1)>=MAX && input.LA(1)<=FROM_WRESL_FILE) ) {
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
        }
        return ;
    }
    // $ANTLR end "usedKeywords"


    // $ANTLR start "tableSQL"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:132:1: tableSQL : 'select' ( (i1= IDENT ) | (u1= usedKeywords ) ) 'from' i2= IDENT ( 'given' i3= assignStatement )? ( 'use' i4= IDENT )? ( where_items )? ;
    public final void tableSQL() throws RecognitionException {
        Token i1=null;
        Token i2=null;
        Token i4=null;
        String i3 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:133:2: ( 'select' ( (i1= IDENT ) | (u1= usedKeywords ) ) 'from' i2= IDENT ( 'given' i3= assignStatement )? ( 'use' i4= IDENT )? ( where_items )? )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:133:4: 'select' ( (i1= IDENT ) | (u1= usedKeywords ) ) 'from' i2= IDENT ( 'given' i3= assignStatement )? ( 'use' i4= IDENT )? ( where_items )?
            {
            match(input,74,FOLLOW_74_in_tableSQL745); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:133:13: ( (i1= IDENT ) | (u1= usedKeywords ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==IDENT) ) {
                alt16=1;
            }
            else if ( ((LA16_0>=CONSTRAIN && LA16_0<=TAFCFS)||(LA16_0>=MAX && LA16_0<=FROM_WRESL_FILE)) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:133:14: (i1= IDENT )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:133:14: (i1= IDENT )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:133:15: i1= IDENT
                    {
                    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_tableSQL751); 

                    }


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:133:25: (u1= usedKeywords )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:133:25: (u1= usedKeywords )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:133:26: u1= usedKeywords
                    {
                    pushFollow(FOLLOW_usedKeywords_in_tableSQL757);
                    usedKeywords();

                    state._fsp--;


                    }


                    }
                    break;

            }

            match(input,75,FOLLOW_75_in_tableSQL761); 
            i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_tableSQL765); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:134:4: ( 'given' i3= assignStatement )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==76) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:134:5: 'given' i3= assignStatement
                    {
                    match(input,76,FOLLOW_76_in_tableSQL772); 
                    pushFollow(FOLLOW_assignStatement_in_tableSQL776);
                    i3=assignStatement();

                    state._fsp--;


                    }
                    break;

            }

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:134:34: ( 'use' i4= IDENT )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==77) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:134:35: 'use' i4= IDENT
                    {
                    match(input,77,FOLLOW_77_in_tableSQL781); 
                    i4=(Token)match(input,IDENT,FOLLOW_IDENT_in_tableSQL785); 

                    }
                    break;

            }

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:135:4: ( where_items )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==WHERE) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:135:5: where_items
                    {
                    pushFollow(FOLLOW_where_items_in_tableSQL794);
                    where_items();

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
        }
        return ;
    }
    // $ANTLR end "tableSQL"


    // $ANTLR start "where_items"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:138:1: where_items : WHERE (r1= whereStatement ) ( ';' r= whereStatement )* ;
    public final void where_items() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:139:2: ( WHERE (r1= whereStatement ) ( ';' r= whereStatement )* )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:139:5: WHERE (r1= whereStatement ) ( ';' r= whereStatement )*
            {
            match(input,WHERE,FOLLOW_WHERE_in_where_items812); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:139:12: (r1= whereStatement )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:139:13: r1= whereStatement
            {
            pushFollow(FOLLOW_whereStatement_in_where_items818);
            whereStatement();

            state._fsp--;


            }

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:140:10: ( ';' r= whereStatement )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==66) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:140:11: ';' r= whereStatement
            	    {
            	    match(input,66,FOLLOW_66_in_where_items831); 
            	    pushFollow(FOLLOW_whereStatement_in_where_items835);
            	    whereStatement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "where_items"


    // $ANTLR start "upperbound"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:144:1: upperbound : ( IDENT | allnumber | ( allnumber '*' TAFCFS ) );
    public final void upperbound() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:144:11: ( IDENT | allnumber | ( allnumber '*' TAFCFS ) )
            int alt21=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt21=1;
                }
                break;
            case 63:
                {
                int LA21_2 = input.LA(2);

                if ( (LA21_2==INTEGER) ) {
                    int LA21_3 = input.LA(3);

                    if ( (LA21_3==EOF) ) {
                        alt21=2;
                    }
                    else if ( (LA21_3==61) ) {
                        alt21=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA21_2==FLOAT) ) {
                    int LA21_4 = input.LA(3);

                    if ( (LA21_4==61) ) {
                        alt21=3;
                    }
                    else if ( (LA21_4==EOF) ) {
                        alt21=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 2, input);

                    throw nvae;
                }
                }
                break;
            case INTEGER:
                {
                int LA21_3 = input.LA(2);

                if ( (LA21_3==EOF) ) {
                    alt21=2;
                }
                else if ( (LA21_3==61) ) {
                    alt21=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 3, input);

                    throw nvae;
                }
                }
                break;
            case FLOAT:
                {
                int LA21_4 = input.LA(2);

                if ( (LA21_4==61) ) {
                    alt21=3;
                }
                else if ( (LA21_4==EOF) ) {
                    alt21=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 4, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:144:13: IDENT
                    {
                    match(input,IDENT,FOLLOW_IDENT_in_upperbound847); 

                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:144:19: allnumber
                    {
                    pushFollow(FOLLOW_allnumber_in_upperbound849);
                    allnumber();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:144:29: ( allnumber '*' TAFCFS )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:144:29: ( allnumber '*' TAFCFS )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:144:30: allnumber '*' TAFCFS
                    {
                    pushFollow(FOLLOW_allnumber_in_upperbound852);
                    allnumber();

                    state._fsp--;

                    match(input,61,FOLLOW_61_in_upperbound854); 
                    match(input,TAFCFS,FOLLOW_TAFCFS_in_upperbound856); 

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
        }
        return ;
    }
    // $ANTLR end "upperbound"


    // $ANTLR start "lowerbound"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:146:1: lowerbound : ( IDENT | allnumber | ( allnumber '*' TAFCFS ) );
    public final void lowerbound() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:146:11: ( IDENT | allnumber | ( allnumber '*' TAFCFS ) )
            int alt22=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt22=1;
                }
                break;
            case 63:
                {
                int LA22_2 = input.LA(2);

                if ( (LA22_2==INTEGER) ) {
                    int LA22_3 = input.LA(3);

                    if ( (LA22_3==EOF) ) {
                        alt22=2;
                    }
                    else if ( (LA22_3==61) ) {
                        alt22=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA22_2==FLOAT) ) {
                    int LA22_4 = input.LA(3);

                    if ( (LA22_4==61) ) {
                        alt22=3;
                    }
                    else if ( (LA22_4==EOF) ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 4, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 2, input);

                    throw nvae;
                }
                }
                break;
            case INTEGER:
                {
                int LA22_3 = input.LA(2);

                if ( (LA22_3==EOF) ) {
                    alt22=2;
                }
                else if ( (LA22_3==61) ) {
                    alt22=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 3, input);

                    throw nvae;
                }
                }
                break;
            case FLOAT:
                {
                int LA22_4 = input.LA(2);

                if ( (LA22_4==61) ) {
                    alt22=3;
                }
                else if ( (LA22_4==EOF) ) {
                    alt22=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 4, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:146:13: IDENT
                    {
                    match(input,IDENT,FOLLOW_IDENT_in_lowerbound864); 

                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:146:19: allnumber
                    {
                    pushFollow(FOLLOW_allnumber_in_lowerbound866);
                    allnumber();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:146:29: ( allnumber '*' TAFCFS )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:146:29: ( allnumber '*' TAFCFS )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:146:30: allnumber '*' TAFCFS
                    {
                    pushFollow(FOLLOW_allnumber_in_lowerbound869);
                    allnumber();

                    state._fsp--;

                    match(input,61,FOLLOW_61_in_lowerbound871); 
                    match(input,TAFCFS,FOLLOW_TAFCFS_in_lowerbound873); 

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
        }
        return ;
    }
    // $ANTLR end "lowerbound"


    // $ANTLR start "sumExpression"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:148:1: sumExpression : SUM '(' I '=' e1= expression_sum ';' e2= expression_sum ( ';' (s= '-' )? INTEGER )? ')' e3= expression ;
    public final void sumExpression() throws RecognitionException {
        Token s=null;
        EvalExpression e3 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:149:3: ( SUM '(' I '=' e1= expression_sum ';' e2= expression_sum ( ';' (s= '-' )? INTEGER )? ')' e3= expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:149:5: SUM '(' I '=' e1= expression_sum ';' e2= expression_sum ( ';' (s= '-' )? INTEGER )? ')' e3= expression
            {
            match(input,SUM,FOLLOW_SUM_in_sumExpression885); 
            match(input,69,FOLLOW_69_in_sumExpression887); 
            match(input,I,FOLLOW_I_in_sumExpression889); 
            match(input,73,FOLLOW_73_in_sumExpression891); 
            pushFollow(FOLLOW_expression_sum_in_sumExpression895);
            expression_sum();

            state._fsp--;

            match(input,66,FOLLOW_66_in_sumExpression897); 
            pushFollow(FOLLOW_expression_sum_in_sumExpression901);
            expression_sum();

            state._fsp--;

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:149:59: ( ';' (s= '-' )? INTEGER )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==66) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:149:60: ';' (s= '-' )? INTEGER
                    {
                    match(input,66,FOLLOW_66_in_sumExpression904); 
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:149:64: (s= '-' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==63) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:149:65: s= '-'
                            {
                            s=(Token)match(input,63,FOLLOW_63_in_sumExpression909); 

                            }
                            break;

                    }

                    match(input,INTEGER,FOLLOW_INTEGER_in_sumExpression913); 

                    }
                    break;

            }

            match(input,70,FOLLOW_70_in_sumExpression918); 
            pushFollow(FOLLOW_expression_in_sumExpression922);
            e3=expression();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "sumExpression"


    // $ANTLR start "term_sum"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:152:1: term_sum : ( MONTH | MONTH_CONST | PASTMONTH | I | INTEGER | '(' expression_sum ')' ) ;
    public final void term_sum() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:152:9: ( ( MONTH | MONTH_CONST | PASTMONTH | I | INTEGER | '(' expression_sum ')' ) )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:152:11: ( MONTH | MONTH_CONST | PASTMONTH | I | INTEGER | '(' expression_sum ')' )
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:152:11: ( MONTH | MONTH_CONST | PASTMONTH | I | INTEGER | '(' expression_sum ')' )
            int alt25=6;
            switch ( input.LA(1) ) {
            case MONTH:
                {
                alt25=1;
                }
                break;
            case MONTH_CONST:
                {
                alt25=2;
                }
                break;
            case PASTMONTH:
                {
                alt25=3;
                }
                break;
            case I:
                {
                alt25=4;
                }
                break;
            case INTEGER:
                {
                alt25=5;
                }
                break;
            case 69:
                {
                alt25=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:152:12: MONTH
                    {
                    match(input,MONTH,FOLLOW_MONTH_in_term_sum933); 

                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:152:18: MONTH_CONST
                    {
                    match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_term_sum935); 

                    }
                    break;
                case 3 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:152:30: PASTMONTH
                    {
                    match(input,PASTMONTH,FOLLOW_PASTMONTH_in_term_sum937); 

                    }
                    break;
                case 4 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:152:40: I
                    {
                    match(input,I,FOLLOW_I_in_term_sum939); 

                    }
                    break;
                case 5 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:152:42: INTEGER
                    {
                    match(input,INTEGER,FOLLOW_INTEGER_in_term_sum941); 

                    }
                    break;
                case 6 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:152:50: '(' expression_sum ')'
                    {
                    match(input,69,FOLLOW_69_in_term_sum943); 
                    pushFollow(FOLLOW_expression_sum_in_term_sum945);
                    expression_sum();

                    state._fsp--;

                    match(input,70,FOLLOW_70_in_term_sum947); 

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
        }
        return ;
    }
    // $ANTLR end "term_sum"


    // $ANTLR start "unary_sum"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:154:1: unary_sum : ( '-' )? term_sum ;
    public final void unary_sum() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:154:11: ( ( '-' )? term_sum )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:154:13: ( '-' )? term_sum
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:154:13: ( '-' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==63) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:154:14: '-'
                    {
                    match(input,63,FOLLOW_63_in_unary_sum957); 

                    }
                    break;

            }

            pushFollow(FOLLOW_term_sum_in_unary_sum961);
            term_sum();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "unary_sum"


    // $ANTLR start "add_sum"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:155:1: add_sum : unary_sum ( ( '+' | '-' ) unary_sum )* ;
    public final void add_sum() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:155:10: ( unary_sum ( ( '+' | '-' ) unary_sum )* )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:155:13: unary_sum ( ( '+' | '-' ) unary_sum )*
            {
            pushFollow(FOLLOW_unary_sum_in_add_sum971);
            unary_sum();

            state._fsp--;

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:155:22: ( ( '+' | '-' ) unary_sum )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=62 && LA27_0<=63)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:155:23: ( '+' | '-' ) unary_sum
            	    {
            	    if ( (input.LA(1)>=62 && input.LA(1)<=63) ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_unary_sum_in_add_sum981);
            	    unary_sum();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "add_sum"


    // $ANTLR start "expression_sum"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:156:1: expression_sum : add_sum ;
    public final void expression_sum() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:156:15: ( add_sum )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:156:17: add_sum
            {
            pushFollow(FOLLOW_add_sum_in_expression_sum990);
            add_sum();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "expression_sum"


    // $ANTLR start "term"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:158:1: term returns [EvalExpression ee] : ( knownTS | ( IDENT ) | ( SVAR ) | ( '(' (e= expression ) ')' ) | ( INTEGER ) | ( FLOAT ) | func | tafcfs_term | YEAR | MONTH | MONTH_CONST | DAYSIN ) ;
    public final EvalExpression term() throws RecognitionException {
        EvalExpression ee = null;

        Token IDENT4=null;
        Token SVAR5=null;
        Token INTEGER6=null;
        Token FLOAT7=null;
        EvalExpression e = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:159:2: ( ( knownTS | ( IDENT ) | ( SVAR ) | ( '(' (e= expression ) ')' ) | ( INTEGER ) | ( FLOAT ) | func | tafcfs_term | YEAR | MONTH | MONTH_CONST | DAYSIN ) )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:159:4: ( knownTS | ( IDENT ) | ( SVAR ) | ( '(' (e= expression ) ')' ) | ( INTEGER ) | ( FLOAT ) | func | tafcfs_term | YEAR | MONTH | MONTH_CONST | DAYSIN )
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:159:4: ( knownTS | ( IDENT ) | ( SVAR ) | ( '(' (e= expression ) ')' ) | ( INTEGER ) | ( FLOAT ) | func | tafcfs_term | YEAR | MONTH | MONTH_CONST | DAYSIN )
            int alt28=12;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:159:5: knownTS
                    {
                    pushFollow(FOLLOW_knownTS_in_term1005);
                    knownTS();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:160:4: ( IDENT )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:160:4: ( IDENT )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:160:5: IDENT
                    {
                    IDENT4=(Token)match(input,IDENT,FOLLOW_IDENT_in_term1011); 
                    ee=Evaluation.term_IDENT((IDENT4!=null?IDENT4.getText():null));

                    }


                    }
                    break;
                case 3 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:161:4: ( SVAR )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:161:4: ( SVAR )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:161:5: SVAR
                    {
                    SVAR5=(Token)match(input,SVAR,FOLLOW_SVAR_in_term1020); 
                    ee=Evaluation.term_SVAR((SVAR5!=null?SVAR5.getText():null));

                    }


                    }
                    break;
                case 4 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:162:4: ( '(' (e= expression ) ')' )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:162:4: ( '(' (e= expression ) ')' )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:162:5: '(' (e= expression ) ')'
                    {
                    match(input,69,FOLLOW_69_in_term1029); 
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:162:9: (e= expression )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:162:10: e= expression
                    {
                    pushFollow(FOLLOW_expression_in_term1034);
                    e=expression();

                    state._fsp--;


                    }

                    match(input,70,FOLLOW_70_in_term1037); 
                    ee=e;

                    }


                    }
                    break;
                case 5 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:163:4: ( INTEGER )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:163:4: ( INTEGER )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:163:5: INTEGER
                    {
                    INTEGER6=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_term1046); 
                    ee=Evaluation.term_INTEGER((INTEGER6!=null?INTEGER6.getText():null));

                    }


                    }
                    break;
                case 6 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:164:4: ( FLOAT )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:164:4: ( FLOAT )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:164:5: FLOAT
                    {
                    FLOAT7=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_term1056); 
                    ee=Evaluation.term_FLOAT((FLOAT7!=null?FLOAT7.getText():null));

                    }


                    }
                    break;
                case 7 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:165:4: func
                    {
                    pushFollow(FOLLOW_func_in_term1065);
                    func();

                    state._fsp--;


                    }
                    break;
                case 8 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:166:4: tafcfs_term
                    {
                    pushFollow(FOLLOW_tafcfs_term_in_term1070);
                    tafcfs_term();

                    state._fsp--;


                    }
                    break;
                case 9 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:167:4: YEAR
                    {
                    match(input,YEAR,FOLLOW_YEAR_in_term1075); 

                    }
                    break;
                case 10 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:168:4: MONTH
                    {
                    match(input,MONTH,FOLLOW_MONTH_in_term1080); 

                    }
                    break;
                case 11 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:169:4: MONTH_CONST
                    {
                    match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_term1085); 

                    }
                    break;
                case 12 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:170:4: DAYSIN
                    {
                    match(input,DAYSIN,FOLLOW_DAYSIN_in_term1090); 

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
        }
        return ee;
    }
    // $ANTLR end "term"


    // $ANTLR start "tafcfs_term"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:173:1: tafcfs_term : ( TAFCFS | ( TAFCFS '(' ( '-' )? INTEGER ')' ) );
    public final void tafcfs_term() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:173:12: ( TAFCFS | ( TAFCFS '(' ( '-' )? INTEGER ')' ) )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==TAFCFS) ) {
                int LA30_1 = input.LA(2);

                if ( (LA30_1==69) ) {
                    alt30=2;
                }
                else if ( (LA30_1==EOF||(LA30_1>=MOD && LA30_1<=WHERE)||(LA30_1>=61 && LA30_1<=64)||LA30_1==66||LA30_1==70||LA30_1==73||LA30_1==77||(LA30_1>=80 && LA30_1<=86)) ) {
                    alt30=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 30, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:173:14: TAFCFS
                    {
                    match(input,TAFCFS,FOLLOW_TAFCFS_in_tafcfs_term1101); 

                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:173:21: ( TAFCFS '(' ( '-' )? INTEGER ')' )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:173:21: ( TAFCFS '(' ( '-' )? INTEGER ')' )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:173:22: TAFCFS '(' ( '-' )? INTEGER ')'
                    {
                    match(input,TAFCFS,FOLLOW_TAFCFS_in_tafcfs_term1104); 
                    match(input,69,FOLLOW_69_in_tafcfs_term1105); 
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:173:32: ( '-' )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==63) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:173:33: '-'
                            {
                            match(input,63,FOLLOW_63_in_tafcfs_term1108); 

                            }
                            break;

                    }

                    match(input,INTEGER,FOLLOW_INTEGER_in_tafcfs_term1112); 
                    match(input,70,FOLLOW_70_in_tafcfs_term1114); 

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
        }
        return ;
    }
    // $ANTLR end "tafcfs_term"


    // $ANTLR start "knownTS"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:175:1: knownTS : ( pastMonthTS | preMonthTS | pastCycleDV );
    public final void knownTS() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:176:3: ( pastMonthTS | preMonthTS | pastCycleDV )
            int alt31=3;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==IDENT) ) {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==69) ) {
                    int LA31_3 = input.LA(3);

                    if ( ((LA31_3>=MONTH && LA31_3<=I)||LA31_3==PASTMONTH) ) {
                        alt31=1;
                    }
                    else if ( (LA31_3==INTEGER||LA31_3==63) ) {
                        alt31=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 31, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA31_1==78) ) {
                    alt31=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA31_0==TAFCFS) ) {
                alt31=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:176:5: pastMonthTS
                    {
                    pushFollow(FOLLOW_pastMonthTS_in_knownTS1128);
                    pastMonthTS();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:176:17: preMonthTS
                    {
                    pushFollow(FOLLOW_preMonthTS_in_knownTS1130);
                    preMonthTS();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:176:28: pastCycleDV
                    {
                    pushFollow(FOLLOW_pastCycleDV_in_knownTS1132);
                    pastCycleDV();

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
        }
        return ;
    }
    // $ANTLR end "knownTS"


    // $ANTLR start "pastMonthTS"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:179:1: pastMonthTS : ( (i1= IDENT ) | TAFCFS ) '(' ( (p= PASTMONTH ) | (i= I ) | (pm= ( MONTH_CONST '-' MONTH ( ( '+' | '-' ) INTEGER )? ) ) | (mp= ( MONTH '-' MONTH_CONST ( ( '+' | '-' ) INTEGER )? ) ) ) ')' ;
    public final void pastMonthTS() throws RecognitionException {
        Token i1=null;
        Token p=null;
        Token i=null;
        Token pm=null;
        Token mp=null;

        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:3: ( ( (i1= IDENT ) | TAFCFS ) '(' ( (p= PASTMONTH ) | (i= I ) | (pm= ( MONTH_CONST '-' MONTH ( ( '+' | '-' ) INTEGER )? ) ) | (mp= ( MONTH '-' MONTH_CONST ( ( '+' | '-' ) INTEGER )? ) ) ) ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:5: ( (i1= IDENT ) | TAFCFS ) '(' ( (p= PASTMONTH ) | (i= I ) | (pm= ( MONTH_CONST '-' MONTH ( ( '+' | '-' ) INTEGER )? ) ) | (mp= ( MONTH '-' MONTH_CONST ( ( '+' | '-' ) INTEGER )? ) ) ) ')'
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:5: ( (i1= IDENT ) | TAFCFS )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==IDENT) ) {
                alt32=1;
            }
            else if ( (LA32_0==TAFCFS) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:6: (i1= IDENT )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:6: (i1= IDENT )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:7: i1= IDENT
                    {
                    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastMonthTS1153); 

                    }


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:17: TAFCFS
                    {
                    match(input,TAFCFS,FOLLOW_TAFCFS_in_pastMonthTS1156); 

                    }
                    break;

            }

            match(input,69,FOLLOW_69_in_pastMonthTS1159); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:29: ( (p= PASTMONTH ) | (i= I ) | (pm= ( MONTH_CONST '-' MONTH ( ( '+' | '-' ) INTEGER )? ) ) | (mp= ( MONTH '-' MONTH_CONST ( ( '+' | '-' ) INTEGER )? ) ) )
            int alt35=4;
            switch ( input.LA(1) ) {
            case PASTMONTH:
                {
                alt35=1;
                }
                break;
            case I:
                {
                alt35=2;
                }
                break;
            case MONTH_CONST:
                {
                alt35=3;
                }
                break;
            case MONTH:
                {
                alt35=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:30: (p= PASTMONTH )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:30: (p= PASTMONTH )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:31: p= PASTMONTH
                    {
                    p=(Token)match(input,PASTMONTH,FOLLOW_PASTMONTH_in_pastMonthTS1165); 

                    }


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:44: (i= I )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:44: (i= I )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:45: i= I
                    {
                    i=(Token)match(input,I,FOLLOW_I_in_pastMonthTS1171); 

                    }


                    }
                    break;
                case 3 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:50: (pm= ( MONTH_CONST '-' MONTH ( ( '+' | '-' ) INTEGER )? ) )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:50: (pm= ( MONTH_CONST '-' MONTH ( ( '+' | '-' ) INTEGER )? ) )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:51: pm= ( MONTH_CONST '-' MONTH ( ( '+' | '-' ) INTEGER )? )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:54: ( MONTH_CONST '-' MONTH ( ( '+' | '-' ) INTEGER )? )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:55: MONTH_CONST '-' MONTH ( ( '+' | '-' ) INTEGER )?
                    {
                    match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_pastMonthTS1178); 
                    match(input,63,FOLLOW_63_in_pastMonthTS1180); 
                    match(input,MONTH,FOLLOW_MONTH_in_pastMonthTS1182); 
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:77: ( ( '+' | '-' ) INTEGER )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( ((LA33_0>=62 && LA33_0<=63)) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:78: ( '+' | '-' ) INTEGER
                            {
                            if ( (input.LA(1)>=62 && input.LA(1)<=63) ) {
                                input.consume();
                                state.errorRecovery=false;
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            match(input,INTEGER,FOLLOW_INTEGER_in_pastMonthTS1191); 

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:101: (mp= ( MONTH '-' MONTH_CONST ( ( '+' | '-' ) INTEGER )? ) )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:101: (mp= ( MONTH '-' MONTH_CONST ( ( '+' | '-' ) INTEGER )? ) )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:102: mp= ( MONTH '-' MONTH_CONST ( ( '+' | '-' ) INTEGER )? )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:105: ( MONTH '-' MONTH_CONST ( ( '+' | '-' ) INTEGER )? )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:106: MONTH '-' MONTH_CONST ( ( '+' | '-' ) INTEGER )?
                    {
                    match(input,MONTH,FOLLOW_MONTH_in_pastMonthTS1202); 
                    match(input,63,FOLLOW_63_in_pastMonthTS1204); 
                    match(input,MONTH_CONST,FOLLOW_MONTH_CONST_in_pastMonthTS1206); 
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:128: ( ( '+' | '-' ) INTEGER )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( ((LA34_0>=62 && LA34_0<=63)) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:180:129: ( '+' | '-' ) INTEGER
                            {
                            if ( (input.LA(1)>=62 && input.LA(1)<=63) ) {
                                input.consume();
                                state.errorRecovery=false;
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            match(input,INTEGER,FOLLOW_INTEGER_in_pastMonthTS1215); 

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }

            match(input,70,FOLLOW_70_in_pastMonthTS1222); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pastMonthTS"


    // $ANTLR start "preMonthTS"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:183:1: preMonthTS : IDENT '(' (s= '-' )? INTEGER ')' ;
    public final void preMonthTS() throws RecognitionException {
        Token s=null;

        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:184:3: ( IDENT '(' (s= '-' )? INTEGER ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:184:5: IDENT '(' (s= '-' )? INTEGER ')'
            {
            match(input,IDENT,FOLLOW_IDENT_in_preMonthTS1238); 
            match(input,69,FOLLOW_69_in_preMonthTS1240); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:184:15: (s= '-' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==63) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:184:16: s= '-'
                    {
                    s=(Token)match(input,63,FOLLOW_63_in_preMonthTS1245); 

                    }
                    break;

            }

            match(input,INTEGER,FOLLOW_INTEGER_in_preMonthTS1249); 
            match(input,70,FOLLOW_70_in_preMonthTS1251); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "preMonthTS"


    // $ANTLR start "pastCycleDV"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:187:1: pastCycleDV : i1= IDENT '[' i2= IDENT ']' ;
    public final void pastCycleDV() throws RecognitionException {
        Token i1=null;
        Token i2=null;

        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:188:3: (i1= IDENT '[' i2= IDENT ']' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:188:5: i1= IDENT '[' i2= IDENT ']'
            {
            i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleDV1271); 
            match(input,78,FOLLOW_78_in_pastCycleDV1273); 
            i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_pastCycleDV1277); 
            match(input,79,FOLLOW_79_in_pastCycleDV1279); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pastCycleDV"


    // $ANTLR start "function"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:191:1: function : ( (i1= noArgFunction ) | (i2= argFunction ) ) ;
    public final void function() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:192:3: ( ( (i1= noArgFunction ) | (i2= argFunction ) ) )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:192:5: ( (i1= noArgFunction ) | (i2= argFunction ) )
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:192:5: ( (i1= noArgFunction ) | (i2= argFunction ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==IDENT) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==69) ) {
                    int LA37_2 = input.LA(3);

                    if ( (LA37_2==70) ) {
                        alt37=1;
                    }
                    else if ( ((LA37_2>=TAFCFS && LA37_2<=IDENT)||(LA37_2>=INTEGER && LA37_2<=FLOAT)||(LA37_2>=MAX && LA37_2<=POW)||(LA37_2>=MONTH && LA37_2<=MONTH_CONST)||LA37_2==YEAR||LA37_2==DAYSIN||LA37_2==SVAR||LA37_2==63||LA37_2==69) ) {
                        alt37=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:192:6: (i1= noArgFunction )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:192:6: (i1= noArgFunction )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:192:7: i1= noArgFunction
                    {
                    pushFollow(FOLLOW_noArgFunction_in_function1298);
                    noArgFunction();

                    state._fsp--;


                    }


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:192:25: (i2= argFunction )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:192:25: (i2= argFunction )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:192:26: i2= argFunction
                    {
                    pushFollow(FOLLOW_argFunction_in_function1304);
                    argFunction();

                    state._fsp--;


                    }


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
        }
        return ;
    }
    // $ANTLR end "function"


    // $ANTLR start "noArgFunction"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:195:1: noArgFunction : IDENT '(' ')' ;
    public final void noArgFunction() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:196:3: ( IDENT '(' ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:196:5: IDENT '(' ')'
            {
            match(input,IDENT,FOLLOW_IDENT_in_noArgFunction1320); 
            match(input,69,FOLLOW_69_in_noArgFunction1322); 
            match(input,70,FOLLOW_70_in_noArgFunction1324); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "noArgFunction"


    // $ANTLR start "argFunction"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:199:1: argFunction : IDENT arguments ;
    public final void argFunction() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:200:3: ( IDENT arguments )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:200:5: IDENT arguments
            {
            match(input,IDENT,FOLLOW_IDENT_in_argFunction1342); 
            pushFollow(FOLLOW_arguments_in_argFunction1344);
            arguments();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "argFunction"


    // $ANTLR start "arguments"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:203:1: arguments : ( oneArgument | multiArguments ) ;
    public final void arguments() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:204:3: ( ( oneArgument | multiArguments ) )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:204:5: ( oneArgument | multiArguments )
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:204:5: ( oneArgument | multiArguments )
            int alt38=2;
            alt38 = dfa38.predict(input);
            switch (alt38) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:204:6: oneArgument
                    {
                    pushFollow(FOLLOW_oneArgument_in_arguments1364);
                    oneArgument();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:204:18: multiArguments
                    {
                    pushFollow(FOLLOW_multiArguments_in_arguments1366);
                    multiArguments();

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
        }
        return ;
    }
    // $ANTLR end "arguments"


    // $ANTLR start "oneArgument"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:206:1: oneArgument : '(' ( ( IDENT | knownTS ) ) ')' ;
    public final void oneArgument() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:207:5: ( '(' ( ( IDENT | knownTS ) ) ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:207:6: '(' ( ( IDENT | knownTS ) ) ')'
            {
            match(input,69,FOLLOW_69_in_oneArgument1379); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:207:10: ( ( IDENT | knownTS ) )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:207:11: ( IDENT | knownTS )
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:207:11: ( IDENT | knownTS )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==IDENT) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==69||LA39_1==78) ) {
                    alt39=2;
                }
                else if ( (LA39_1==70) ) {
                    alt39=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA39_0==TAFCFS) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:207:12: IDENT
                    {
                    match(input,IDENT,FOLLOW_IDENT_in_oneArgument1383); 

                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:207:18: knownTS
                    {
                    pushFollow(FOLLOW_knownTS_in_oneArgument1385);
                    knownTS();

                    state._fsp--;


                    }
                    break;

            }


            }

            match(input,70,FOLLOW_70_in_oneArgument1389); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "oneArgument"


    // $ANTLR start "multiArguments"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:211:1: multiArguments : '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' ;
    public final void multiArguments() throws RecognitionException {
        EvalExpression e1 = null;

        EvalExpression e2 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:212:3: ( '(' (e1= expression ) ( ';' (e2= expression ) )+ ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:212:5: '(' (e1= expression ) ( ';' (e2= expression ) )+ ')'
            {
            match(input,69,FOLLOW_69_in_multiArguments1407); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:212:9: (e1= expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:212:10: e1= expression
            {
            pushFollow(FOLLOW_expression_in_multiArguments1412);
            e1=expression();

            state._fsp--;


            }

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:212:25: ( ';' (e2= expression ) )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==66) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:212:26: ';' (e2= expression )
            	    {
            	    match(input,66,FOLLOW_66_in_multiArguments1416); 
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:212:30: (e2= expression )
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:212:31: e2= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_multiArguments1421);
            	    e2=expression();

            	    state._fsp--;


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt40 >= 1 ) break loop40;
                        EarlyExitException eee =
                            new EarlyExitException(40, input);
                        throw eee;
                }
                cnt40++;
            } while (true);

            match(input,70,FOLLOW_70_in_multiArguments1426); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "multiArguments"


    // $ANTLR start "unary"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:215:1: unary returns [EvalExpression ee] : (s= '-' )? term ;
    public final EvalExpression unary() throws RecognitionException {
        EvalExpression ee = null;

        Token s=null;
        EvalExpression term8 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:216:2: ( (s= '-' )? term )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:216:4: (s= '-' )? term
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:216:4: (s= '-' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==63) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:216:5: s= '-'
                    {
                    s=(Token)match(input,63,FOLLOW_63_in_unary1450); 

                    }
                    break;

            }

            pushFollow(FOLLOW_term_in_unary1454);
            term8=term();

            state._fsp--;

            ee=Evaluation.unary((s!=null?s.getText():null), term8);
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ee;
    }
    // $ANTLR end "unary"


    // $ANTLR start "allnumber"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:219:1: allnumber returns [String result] : ( '-' )? number ;
    public final String allnumber() throws RecognitionException {
        String result = null;

        String number9 = null;


        result="";
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:220:2: ( ( '-' )? number )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:220:4: ( '-' )? number
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:220:4: ( '-' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==63) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:220:5: '-'
                    {
                    match(input,63,FOLLOW_63_in_allnumber1474); 
                    result="-";

                    }
                    break;

            }

            pushFollow(FOLLOW_number_in_allnumber1480);
            number9=number();

            state._fsp--;

            result=result+number9;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "allnumber"


    // $ANTLR start "mult"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:222:1: mult returns [EvalExpression ee] : (u1= unary ) ( ( (s1= '*' ) | (s2= '/' ) | MOD ) (u2= unary ) )* ;
    public final EvalExpression mult() throws RecognitionException {
        EvalExpression ee = null;

        Token s1=null;
        Token s2=null;
        Token MOD10=null;
        EvalExpression u1 = null;

        EvalExpression u2 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:2: ( (u1= unary ) ( ( (s1= '*' ) | (s2= '/' ) | MOD ) (u2= unary ) )* )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:4: (u1= unary ) ( ( (s1= '*' ) | (s2= '/' ) | MOD ) (u2= unary ) )*
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:4: (u1= unary )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:5: u1= unary
            {
            pushFollow(FOLLOW_unary_in_mult1499);
            u1=unary();

            state._fsp--;

            ee=u1;

            }

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:28: ( ( (s1= '*' ) | (s2= '/' ) | MOD ) (u2= unary ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==MOD||LA44_0==61||LA44_0==64) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:29: ( (s1= '*' ) | (s2= '/' ) | MOD ) (u2= unary )
            	    {
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:29: ( (s1= '*' ) | (s2= '/' ) | MOD )
            	    int alt43=3;
            	    switch ( input.LA(1) ) {
            	    case 61:
            	        {
            	        alt43=1;
            	        }
            	        break;
            	    case 64:
            	        {
            	        alt43=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt43=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 43, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt43) {
            	        case 1 :
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:30: (s1= '*' )
            	            {
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:30: (s1= '*' )
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:31: s1= '*'
            	            {
            	            s1=(Token)match(input,61,FOLLOW_61_in_mult1509); 

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:40: (s2= '/' )
            	            {
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:40: (s2= '/' )
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:41: s2= '/'
            	            {
            	            s2=(Token)match(input,64,FOLLOW_64_in_mult1516); 

            	            }


            	            }
            	            break;
            	        case 3 :
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:50: MOD
            	            {
            	            MOD10=(Token)match(input,MOD,FOLLOW_MOD_in_mult1520); 

            	            }
            	            break;

            	    }

            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:55: (u2= unary )
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:223:56: u2= unary
            	    {
            	    pushFollow(FOLLOW_unary_in_mult1526);
            	    u2=unary();

            	    state._fsp--;


            	    }


            	    	   if ((s1!=null?s1.getText():null) !=null){
            	    	     ee=Evaluation.mult(ee, u2);
            	    	   }else if ((s2!=null?s2.getText():null) !=null){
            	    	     ee=Evaluation.divide(ee, u2);
            	    	   }else if ((MOD10!=null?MOD10.getText():null) !=null){
            	    	     ee=Evaluation.mod(ee, u2);
            	    	   }   
            	      

            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ee;
    }
    // $ANTLR end "mult"


    // $ANTLR start "add"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:234:1: add returns [EvalExpression ee] : (m1= mult ) ( ( (s1= '+' ) | (s2= '-' ) ) (m2= mult ) )* ;
    public final EvalExpression add() throws RecognitionException {
        EvalExpression ee = null;

        Token s1=null;
        Token s2=null;
        EvalExpression m1 = null;

        EvalExpression m2 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:2: ( (m1= mult ) ( ( (s1= '+' ) | (s2= '-' ) ) (m2= mult ) )* )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:4: (m1= mult ) ( ( (s1= '+' ) | (s2= '-' ) ) (m2= mult ) )*
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:4: (m1= mult )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:5: m1= mult
            {
            pushFollow(FOLLOW_mult_in_add1550);
            m1=mult();

            state._fsp--;

            ee=m1;

            }

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:27: ( ( (s1= '+' ) | (s2= '-' ) ) (m2= mult ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=62 && LA46_0<=63)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:28: ( (s1= '+' ) | (s2= '-' ) ) (m2= mult )
            	    {
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:28: ( (s1= '+' ) | (s2= '-' ) )
            	    int alt45=2;
            	    int LA45_0 = input.LA(1);

            	    if ( (LA45_0==62) ) {
            	        alt45=1;
            	    }
            	    else if ( (LA45_0==63) ) {
            	        alt45=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 45, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt45) {
            	        case 1 :
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:29: (s1= '+' )
            	            {
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:29: (s1= '+' )
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:30: s1= '+'
            	            {
            	            s1=(Token)match(input,62,FOLLOW_62_in_add1560); 

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:39: (s2= '-' )
            	            {
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:39: (s2= '-' )
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:40: s2= '-'
            	            {
            	            s2=(Token)match(input,63,FOLLOW_63_in_add1567); 

            	            }


            	            }
            	            break;

            	    }

            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:49: (m2= mult )
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:235:50: m2= mult
            	    {
            	    pushFollow(FOLLOW_mult_in_add1574);
            	    m2=mult();

            	    state._fsp--;


            	    }


            	         if ((s2!=null?s2.getText():null) ==null){
            	           ee=Evaluation.add(ee, m2);
            	         }else{
            	           ee=Evaluation.minus(ee, m2);
            	         }
            	    	

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ee;
    }
    // $ANTLR end "add"


    // $ANTLR start "expression"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:244:1: expression returns [EvalExpression ee] : i= add ;
    public final EvalExpression expression() throws RecognitionException {
        EvalExpression ee = null;

        EvalExpression i = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:245:2: (i= add )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:245:4: i= add
            {
            pushFollow(FOLLOW_add_in_expression1597);
            i=add();

            state._fsp--;

            ee=i;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ee;
    }
    // $ANTLR end "expression"

    public static class relation_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "relation"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:248:1: relation : ( '==' | '<' | '>' | '>=' | '<=' );
    public final EvaluatorParser.relation_return relation() throws RecognitionException {
        EvaluatorParser.relation_return retval = new EvaluatorParser.relation_return();
        retval.start = input.LT(1);

        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:249:2: ( '==' | '<' | '>' | '>=' | '<=' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:
            {
            if ( (input.LA(1)>=80 && input.LA(1)<=84) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "relation"


    // $ANTLR start "conditionStatement"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:256:1: conditionStatement returns [boolean result] : ( (r= relationStatementSeries ) | ALWAYS ) ;
    public final boolean conditionStatement() throws RecognitionException {
        boolean result = false;

        boolean r = false;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:257:2: ( ( (r= relationStatementSeries ) | ALWAYS ) )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:257:4: ( (r= relationStatementSeries ) | ALWAYS )
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:257:4: ( (r= relationStatementSeries ) | ALWAYS )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=TAFCFS && LA47_0<=IDENT)||(LA47_0>=INTEGER && LA47_0<=FLOAT)||(LA47_0>=MAX && LA47_0<=MONTH_CONST)||LA47_0==YEAR||LA47_0==DAYSIN||LA47_0==SVAR||LA47_0==63||LA47_0==69) ) {
                alt47=1;
            }
            else if ( (LA47_0==ALWAYS) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:257:5: (r= relationStatementSeries )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:257:5: (r= relationStatementSeries )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:257:6: r= relationStatementSeries
                    {
                    pushFollow(FOLLOW_relationStatementSeries_in_conditionStatement1651);
                    r=relationStatementSeries();

                    state._fsp--;

                    result=r;

                    }


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:257:52: ALWAYS
                    {
                    match(input,ALWAYS,FOLLOW_ALWAYS_in_conditionStatement1655); 
                    result=true;

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
        }
        return result;
    }
    // $ANTLR end "conditionStatement"


    // $ANTLR start "whereStatement"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:260:1: whereStatement : ( (i= IDENT ) | (u= usedKeywords ) ) '=' expression ;
    public final void whereStatement() throws RecognitionException {
        Token i=null;

        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:261:3: ( ( (i= IDENT ) | (u= usedKeywords ) ) '=' expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:261:5: ( (i= IDENT ) | (u= usedKeywords ) ) '=' expression
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:261:5: ( (i= IDENT ) | (u= usedKeywords ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==IDENT) ) {
                alt48=1;
            }
            else if ( ((LA48_0>=CONSTRAIN && LA48_0<=TAFCFS)||(LA48_0>=MAX && LA48_0<=FROM_WRESL_FILE)) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:261:6: (i= IDENT )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:261:6: (i= IDENT )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:261:7: i= IDENT
                    {
                    i=(Token)match(input,IDENT,FOLLOW_IDENT_in_whereStatement1674); 

                    }


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:261:16: (u= usedKeywords )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:261:16: (u= usedKeywords )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:261:17: u= usedKeywords
                    {
                    pushFollow(FOLLOW_usedKeywords_in_whereStatement1680);
                    usedKeywords();

                    state._fsp--;


                    }


                    }
                    break;

            }

            match(input,73,FOLLOW_73_in_whereStatement1684); 
            pushFollow(FOLLOW_expression_in_whereStatement1686);
            expression();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "whereStatement"


    // $ANTLR start "relationStatementSeries"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:264:1: relationStatementSeries returns [boolean result] : r1= relationRangeStatement ( ( (s= '.and.' ) | (s= '.or.' ) ) r2= relationRangeStatement )* ;
    public final boolean relationStatementSeries() throws RecognitionException {
        boolean result = false;

        Token s=null;
        boolean r1 = false;

        boolean r2 = false;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:265:3: (r1= relationRangeStatement ( ( (s= '.and.' ) | (s= '.or.' ) ) r2= relationRangeStatement )* )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:265:5: r1= relationRangeStatement ( ( (s= '.and.' ) | (s= '.or.' ) ) r2= relationRangeStatement )*
            {
            pushFollow(FOLLOW_relationRangeStatement_in_relationStatementSeries1707);
            r1=relationRangeStatement();

            state._fsp--;

            result=r1;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:266:5: ( ( (s= '.and.' ) | (s= '.or.' ) ) r2= relationRangeStatement )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=85 && LA50_0<=86)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:266:6: ( (s= '.and.' ) | (s= '.or.' ) ) r2= relationRangeStatement
            	    {
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:266:6: ( (s= '.and.' ) | (s= '.or.' ) )
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==85) ) {
            	        alt49=1;
            	    }
            	    else if ( (LA49_0==86) ) {
            	        alt49=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 49, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:266:7: (s= '.and.' )
            	            {
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:266:7: (s= '.and.' )
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:266:8: s= '.and.'
            	            {
            	            s=(Token)match(input,85,FOLLOW_85_in_relationStatementSeries1721); 

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:266:19: (s= '.or.' )
            	            {
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:266:19: (s= '.or.' )
            	            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:266:20: s= '.or.'
            	            {
            	            s=(Token)match(input,86,FOLLOW_86_in_relationStatementSeries1727); 

            	            }


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relationRangeStatement_in_relationStatementSeries1733);
            	    r2=relationRangeStatement();

            	    state._fsp--;

            	    result=Evaluation.relationStatementSeries(result, r2, (s!=null?s.getText():null));

            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "relationStatementSeries"


    // $ANTLR start "relationRangeStatement"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:268:1: relationRangeStatement returns [boolean result] : ( (r1= relationStatement ) | (r2= range_func ) );
    public final boolean relationRangeStatement() throws RecognitionException {
        boolean result = false;

        boolean r1 = false;

        boolean r2 = false;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:269:3: ( (r1= relationStatement ) | (r2= range_func ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( ((LA51_0>=TAFCFS && LA51_0<=IDENT)||(LA51_0>=INTEGER && LA51_0<=FLOAT)||(LA51_0>=MAX && LA51_0<=POW)||(LA51_0>=MONTH && LA51_0<=MONTH_CONST)||LA51_0==YEAR||LA51_0==DAYSIN||LA51_0==SVAR||LA51_0==63||LA51_0==69) ) {
                alt51=1;
            }
            else if ( (LA51_0==RANGE) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:269:5: (r1= relationStatement )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:269:5: (r1= relationStatement )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:269:6: r1= relationStatement
                    {
                    pushFollow(FOLLOW_relationStatement_in_relationRangeStatement1755);
                    r1=relationStatement();

                    state._fsp--;

                    result=r1;

                    }


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:269:48: (r2= range_func )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:269:48: (r2= range_func )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:269:49: r2= range_func
                    {
                    pushFollow(FOLLOW_range_func_in_relationRangeStatement1762);
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
        }
        return result;
    }
    // $ANTLR end "relationRangeStatement"


    // $ANTLR start "relationStatement"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:273:1: relationStatement returns [boolean result] : (e1= expression ) relation (e2= expression ) ;
    public final boolean relationStatement() throws RecognitionException {
        boolean result = false;

        EvalExpression e1 = null;

        EvalExpression e2 = null;

        EvaluatorParser.relation_return relation11 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:274:2: ( (e1= expression ) relation (e2= expression ) )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:274:4: (e1= expression ) relation (e2= expression )
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:274:4: (e1= expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:274:5: e1= expression
            {
            pushFollow(FOLLOW_expression_in_relationStatement1785);
            e1=expression();

            state._fsp--;


            }

            pushFollow(FOLLOW_relation_in_relationStatement1788);
            relation11=relation();

            state._fsp--;

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:274:29: (e2= expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:274:30: e2= expression
            {
            pushFollow(FOLLOW_expression_in_relationStatement1793);
            e2=expression();

            state._fsp--;


            }

            result=Evaluation.relationStatement(e1, e2, (relation11!=null?input.toString(relation11.start,relation11.stop):null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "relationStatement"


    // $ANTLR start "constraintStatement"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:277:1: constraintStatement returns [EvalConstraint ec] : e1= expression ( (s= '=' ) | (s= '>' ) | (s= '<' ) ) e2= expression ;
    public final EvalConstraint constraintStatement() throws RecognitionException {
        EvalConstraint ec = null;

        Token s=null;
        EvalExpression e1 = null;

        EvalExpression e2 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:278:3: (e1= expression ( (s= '=' ) | (s= '>' ) | (s= '<' ) ) e2= expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:278:5: e1= expression ( (s= '=' ) | (s= '>' ) | (s= '<' ) ) e2= expression
            {
            pushFollow(FOLLOW_expression_in_constraintStatement1813);
            e1=expression();

            state._fsp--;

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:278:19: ( (s= '=' ) | (s= '>' ) | (s= '<' ) )
            int alt52=3;
            switch ( input.LA(1) ) {
            case 73:
                {
                alt52=1;
                }
                break;
            case 82:
                {
                alt52=2;
                }
                break;
            case 81:
                {
                alt52=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:278:20: (s= '=' )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:278:20: (s= '=' )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:278:21: s= '='
                    {
                    s=(Token)match(input,73,FOLLOW_73_in_constraintStatement1819); 

                    }


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:278:28: (s= '>' )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:278:28: (s= '>' )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:278:29: s= '>'
                    {
                    s=(Token)match(input,82,FOLLOW_82_in_constraintStatement1825); 

                    }


                    }
                    break;
                case 3 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:278:36: (s= '<' )
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:278:36: (s= '<' )
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:278:37: s= '<'
                    {
                    s=(Token)match(input,81,FOLLOW_81_in_constraintStatement1831); 

                    }


                    }
                    break;

            }

            pushFollow(FOLLOW_expression_in_constraintStatement1837);
            e2=expression();

            state._fsp--;

            ec=Evaluation.constraintStatement(e1, e2, (s!=null?s.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ec;
    }
    // $ANTLR end "constraintStatement"


    // $ANTLR start "assignStatement"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:281:1: assignStatement returns [String result] : IDENT '=' expression ;
    public final String assignStatement() throws RecognitionException {
        String result = null;

        Token IDENT12=null;
        EvalExpression expression13 = null;


        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:282:3: ( IDENT '=' expression )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:282:5: IDENT '=' expression
            {
            IDENT12=(Token)match(input,IDENT,FOLLOW_IDENT_in_assignStatement1857); 
            match(input,73,FOLLOW_73_in_assignStatement1859); 
            pushFollow(FOLLOW_expression_in_assignStatement1861);
            expression13=expression();

            state._fsp--;

            result=Evaluation.assignStatement((IDENT12!=null?IDENT12.getText():null),expression13);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "assignStatement"


    // $ANTLR start "number"
    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:285:1: number returns [String result] : ( INTEGER | FLOAT );
    public final String number() throws RecognitionException {
        String result = null;

        Token INTEGER14=null;
        Token FLOAT15=null;

        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:286:2: ( INTEGER | FLOAT )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==INTEGER) ) {
                alt53=1;
            }
            else if ( (LA53_0==FLOAT) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:286:4: INTEGER
                    {
                    INTEGER14=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_number1880); 
                    result=(INTEGER14!=null?INTEGER14.getText():null);

                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:287:4: FLOAT
                    {
                    FLOAT15=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_number1887); 
                    result=(FLOAT15!=null?FLOAT15.getText():null);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "number"

    // Delegated rules


    protected DFA9 dfa9 = new DFA9(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA38 dfa38 = new DFA38(this);
    static final String DFA9_eotS =
        "\30\uffff";
    static final String DFA9_eofS =
        "\2\uffff\1\1\1\uffff\1\10\23\uffff";
    static final String DFA9_minS =
        "\1\5\1\uffff\1\36\1\uffff\1\110\1\uffff\1\5\3\uffff\2\36\1\5\1"+
        "\36\2\5\2\36\4\5\2\36";
    static final String DFA9_maxS =
        "\1\112\1\uffff\1\116\1\uffff\1\110\1\uffff\1\106\3\uffff\2\102"+
        "\1\105\1\106\2\105\2\106\4\105\2\106";
    static final String DFA9_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\uffff\1\6\1\uffff\1\3\1\4\1\5\16\uffff";
    static final String DFA9_specialS =
        "\30\uffff}>";
    static final String[] DFA9_transitionS = {
            "\1\1\1\2\4\uffff\2\1\2\uffff\7\1\1\uffff\2\1\1\uffff\1\1\1"+
            "\uffff\1\1\1\5\30\uffff\1\1\10\uffff\1\1\5\uffff\1\1\1\uffff"+
            "\1\4\2\uffff\1\3",
            "",
            "\1\1\36\uffff\4\1\4\uffff\1\6\10\uffff\1\1",
            "",
            "\1\7",
            "",
            "\2\11\4\uffff\1\15\1\11\2\uffff\7\11\1\uffff\1\13\1\12\1\1"+
            "\1\11\1\1\1\11\31\uffff\1\11\10\uffff\1\14\5\uffff\2\11",
            "",
            "",
            "",
            "\1\11\36\uffff\2\11\1\16\1\11\1\uffff\1\11",
            "\1\11\36\uffff\2\11\1\17\1\11\1\uffff\1\11",
            "\2\11\4\uffff\1\15\1\11\2\uffff\7\11\1\uffff\2\11\1\uffff"+
            "\1\11\1\uffff\1\11\31\uffff\1\11\16\uffff\1\11",
            "\1\11\36\uffff\4\11\1\uffff\1\11\3\uffff\1\1",
            "\2\11\4\uffff\2\11\2\uffff\7\11\1\uffff\1\20\1\11\1\uffff"+
            "\1\11\1\uffff\1\11\31\uffff\1\11\10\uffff\1\11\5\uffff\1\11",
            "\2\11\4\uffff\2\11\2\uffff\7\11\1\uffff\1\11\1\21\1\uffff"+
            "\1\11\1\uffff\1\11\31\uffff\1\11\10\uffff\1\11\5\uffff\1\11",
            "\1\11\36\uffff\1\11\1\22\1\23\1\11\1\uffff\1\11\3\uffff\1"+
            "\1",
            "\1\11\36\uffff\1\11\1\24\1\25\1\11\1\uffff\1\11\3\uffff\1"+
            "\1",
            "\2\11\4\uffff\1\26\1\11\2\uffff\7\11\1\uffff\2\11\1\uffff"+
            "\1\11\1\uffff\1\11\31\uffff\1\11\10\uffff\1\11\5\uffff\1\11",
            "\2\11\4\uffff\1\26\1\11\2\uffff\7\11\1\uffff\2\11\1\uffff"+
            "\1\11\1\uffff\1\11\31\uffff\1\11\10\uffff\1\11\5\uffff\1\11",
            "\2\11\4\uffff\1\27\1\11\2\uffff\7\11\1\uffff\2\11\1\uffff"+
            "\1\11\1\uffff\1\11\31\uffff\1\11\10\uffff\1\11\5\uffff\1\11",
            "\2\11\4\uffff\1\27\1\11\2\uffff\7\11\1\uffff\2\11\1\uffff"+
            "\1\11\1\uffff\1\11\31\uffff\1\11\10\uffff\1\11\5\uffff\1\11",
            "\1\11\36\uffff\4\11\1\uffff\1\11\3\uffff\1\1",
            "\1\11\36\uffff\4\11\1\uffff\1\11\3\uffff\1\1"
    };

    static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
    static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
    static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
    static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
    static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
    static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
    static final short[][] DFA9_transition;

    static {
        int numStates = DFA9_transitionS.length;
        DFA9_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
        }
    }

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = DFA9_eot;
            this.eof = DFA9_eof;
            this.min = DFA9_min;
            this.max = DFA9_max;
            this.accept = DFA9_accept;
            this.special = DFA9_special;
            this.transition = DFA9_transition;
        }
        public String getDescription() {
            return "71:4: ( ( expression ) | ( tableSQL ) | ( timeseriesWithUnits ) | ( timeseries ) | ( function ) | (i1= sumExpression ) )";
        }
    }
    static final String DFA28_eotS =
        "\20\uffff";
    static final String DFA28_eofS =
        "\1\uffff\1\15\1\17\15\uffff";
    static final String DFA28_minS =
        "\1\5\2\36\13\uffff\1\13\1\uffff";
    static final String DFA28_maxS =
        "\1\105\2\126\13\uffff\1\77\1\uffff";
    static final String DFA28_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\6\1\7\1\11\1\12\1\13\1\14\1\1\1\2\1\uffff"+
        "\1\10";
    static final String DFA28_specialS =
        "\20\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\2\1\1\4\uffff\1\5\1\6\2\uffff\7\7\1\uffff\1\11\1\12\1\uffff"+
            "\1\10\1\uffff\1\13\31\uffff\1\3\16\uffff\1\4",
            "\2\15\35\uffff\4\15\1\uffff\1\15\2\uffff\1\14\1\15\2\uffff"+
            "\1\15\3\uffff\1\15\1\14\1\uffff\7\15",
            "\2\17\35\uffff\4\17\1\uffff\1\17\2\uffff\1\16\1\17\2\uffff"+
            "\1\17\3\uffff\1\17\2\uffff\7\17",
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
            "\1\17\13\uffff\3\14\1\uffff\1\14\43\uffff\1\17",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "159:4: ( knownTS | ( IDENT ) | ( SVAR ) | ( '(' (e= expression ) ')' ) | ( INTEGER ) | ( FLOAT ) | func | tafcfs_term | YEAR | MONTH | MONTH_CONST | DAYSIN )";
        }
    }
    static final String DFA38_eotS =
        "\33\uffff";
    static final String DFA38_eofS =
        "\33\uffff";
    static final String DFA38_minS =
        "\1\105\1\5\1\uffff\2\36\1\13\1\6\1\uffff\2\13\3\106\2\77\1\117"+
        "\2\36\1\27\1\30\1\36\2\76\2\13\2\106";
    static final String DFA38_maxS =
        "\2\105\1\uffff\1\116\1\105\1\77\1\6\1\uffff\1\77\1\13\3\106\2\77"+
        "\1\117\2\106\1\27\1\30\3\106\2\13\2\106";
    static final String DFA38_acceptS =
        "\2\uffff\1\2\4\uffff\1\1\23\uffff";
    static final String DFA38_specialS =
        "\33\uffff}>";
    static final String[] DFA38_transitionS = {
            "\1\1",
            "\1\4\1\3\4\uffff\2\2\2\uffff\7\2\1\uffff\2\2\1\uffff\1\2\1"+
            "\uffff\1\2\31\uffff\1\2\10\uffff\1\2\5\uffff\1\2",
            "",
            "\1\2\36\uffff\4\2\1\uffff\1\2\2\uffff\1\5\1\7\7\uffff\1\6",
            "\1\2\36\uffff\4\2\1\uffff\1\2\2\uffff\1\10",
            "\1\12\13\uffff\1\16\1\15\1\14\1\uffff\1\13\43\uffff\1\11",
            "\1\17",
            "",
            "\1\2\13\uffff\1\16\1\15\1\14\1\uffff\1\13\43\uffff\1\2",
            "\1\12",
            "\1\20",
            "\1\21",
            "\1\21",
            "\1\22",
            "\1\23",
            "\1\24",
            "\1\2\36\uffff\4\2\1\uffff\1\2\3\uffff\1\7",
            "\1\2\36\uffff\4\2\1\uffff\1\2\3\uffff\1\7",
            "\1\25",
            "\1\26",
            "\1\2\36\uffff\4\2\1\uffff\1\2\3\uffff\1\7",
            "\2\27\6\uffff\1\21",
            "\2\30\6\uffff\1\21",
            "\1\31",
            "\1\32",
            "\1\21",
            "\1\21"
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "204:5: ( oneArgument | multiArguments )";
        }
    }
 

    public static final BitSet FOLLOW_expressionInput_in_evaluator50 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_goalInput_in_evaluator55 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionInput_in_evaluator59 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_expressionInput73 = new BitSet(new long[]{0x8040000035BF9860L,0x00000000000004A0L});
    public static final BitSet FOLLOW_expressionCollection_in_expressionInput75 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_goalInput81 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_constraintStatement_in_goalInput83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_conditionInput91 = new BitSet(new long[]{0x8040000115FF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_conditionStatement_in_conditionInput93 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_weight_in_lhsrhs105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSTRAIN_in_lhsrhs107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_allnumber_in_weight116 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_allnumber_in_weight119 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_weight121 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TAFCFS_in_weight123 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_62_in_weight129 = new BitSet(new long[]{0x8000000000001800L});
    public static final BitSet FOLLOW_allnumber_in_weight131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_weight135 = new BitSet(new long[]{0x8000000000001800L});
    public static final BitSet FOLLOW_allnumber_in_weight137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_units147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_units150 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_units152 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_units154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_fileName166 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_66_in_fileName168 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_67_in_fileName170 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_68_in_fileName172 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_SYMBOLS_in_fileName174 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_63_in_fileName176 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_62_in_fileName178 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_BACKSLASH_in_fileName180 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_IDENT_in_fileName182 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_IDENT1_in_fileName184 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_IDENT2_in_fileName186 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_INTEGER_in_fileName188 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_FLOAT_in_fileName190 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_usedKeywords_in_fileName192 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_66_in_externalFile211 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_67_in_externalFile213 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_68_in_externalFile215 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_SYMBOLS_in_externalFile217 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_63_in_externalFile219 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_62_in_externalFile221 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_INTEGER_in_externalFile223 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_FLOAT_in_externalFile225 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_IDENT_in_externalFile227 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_usedKeywords_in_externalFile229 = new BitSet(new long[]{0xC03FFFFFFFFF9FF2L,0x000000000000001EL});
    public static final BitSet FOLLOW_LETTER_in_text243 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_set_in_text245 = new BitSet(new long[]{0x0000000000006002L});
    public static final BitSet FOLLOW_expression_in_expressionCollection269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tableSQL_in_expressionCollection274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timeseriesWithUnits_in_expressionCollection278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_timeseries_in_expressionCollection282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_function_in_expressionCollection286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sumExpression_in_expressionCollection292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_max_func_in_func307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_min_func_in_func312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_int_func_in_func317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_abs_func_in_func322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_log_func_in_func327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_log10_func_in_func332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pow_func_in_func337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MAX_in_max_func347 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_max_func349 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_max_func354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_max_func357 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_max_func362 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000044L});
    public static final BitSet FOLLOW_70_in_max_func367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MIN_in_min_func379 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_min_func381 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_min_func386 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_min_func389 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_min_func394 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000044L});
    public static final BitSet FOLLOW_70_in_min_func399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_int_func413 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_int_func415 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_int_func420 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_int_func423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ABS_in_abs_func439 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_abs_func441 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_abs_func446 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_abs_func449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOG_in_log_func463 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_log_func465 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_log_func470 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_log_func473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LOG10_in_log10_func487 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_log10_func489 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_log10_func494 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_log10_func497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_POW_in_pow_func513 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_pow_func515 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_pow_func520 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_pow_func524 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_pow_func529 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_pow_func533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_range_func552 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_range_func554 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_MONTH_in_range_func556 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_range_func558 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_MONTH_CONST_in_range_func562 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_range_func564 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_MONTH_CONST_in_range_func568 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_range_func570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_timeseriesWithUnits582 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_timeseriesWithUnits584 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_timeseriesWithUnits586 = new BitSet(new long[]{0xC03FFFFFFFFF9FF0L,0x000000000000001EL});
    public static final BitSet FOLLOW_partC_in_timeseriesWithUnits590 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_UNITS_in_timeseriesWithUnits592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_timeseriesWithUnits594 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_timeseriesWithUnits598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_timeseries610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_partC626 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_IDENT1_in_partC628 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_usedKeywords_in_partC630 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_partC634 = new BitSet(new long[]{0xC03FFFFFFFFF9FF0L,0x000000000000001EL});
    public static final BitSet FOLLOW_IDENT_in_partC637 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_IDENT1_in_partC639 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_usedKeywords_in_partC641 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_set_in_usedKeywords0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_tableSQL745 = new BitSet(new long[]{0xC03FFFFFFFFF9FF0L,0x000000000000081EL});
    public static final BitSet FOLLOW_IDENT_in_tableSQL751 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_usedKeywords_in_tableSQL757 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_tableSQL761 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_tableSQL765 = new BitSet(new long[]{0x0000000080000002L,0x0000000000003000L});
    public static final BitSet FOLLOW_76_in_tableSQL772 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_assignStatement_in_tableSQL776 = new BitSet(new long[]{0x0000000080000002L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_tableSQL781 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_tableSQL785 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_where_items_in_tableSQL794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where_items812 = new BitSet(new long[]{0xC03FFFFFFFFF9FF0L,0x000000000000021EL});
    public static final BitSet FOLLOW_whereStatement_in_where_items818 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_where_items831 = new BitSet(new long[]{0xC03FFFFFFFFF9FF0L,0x000000000000021EL});
    public static final BitSet FOLLOW_whereStatement_in_where_items835 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_upperbound847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_allnumber_in_upperbound849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_allnumber_in_upperbound852 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_upperbound854 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TAFCFS_in_upperbound856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_lowerbound864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_allnumber_in_lowerbound866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_allnumber_in_lowerbound869 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_lowerbound871 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_TAFCFS_in_lowerbound873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SUM_in_sumExpression885 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_sumExpression887 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_I_in_sumExpression889 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_sumExpression891 = new BitSet(new long[]{0x800000000B800800L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_sum_in_sumExpression895 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_sumExpression897 = new BitSet(new long[]{0x800000000B800800L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_sum_in_sumExpression901 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000044L});
    public static final BitSet FOLLOW_66_in_sumExpression904 = new BitSet(new long[]{0x8000000000000800L});
    public static final BitSet FOLLOW_63_in_sumExpression909 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INTEGER_in_sumExpression913 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_sumExpression918 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_sumExpression922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MONTH_in_term_sum933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MONTH_CONST_in_term_sum935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PASTMONTH_in_term_sum937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_I_in_term_sum939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_term_sum941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_term_sum943 = new BitSet(new long[]{0x800000000B800800L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_sum_in_term_sum945 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_term_sum947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_unary_sum957 = new BitSet(new long[]{0x800000000B800800L,0x0000000000000020L});
    public static final BitSet FOLLOW_term_sum_in_unary_sum961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_sum_in_add_sum971 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_set_in_add_sum973 = new BitSet(new long[]{0x800000000B800800L,0x0000000000000020L});
    public static final BitSet FOLLOW_unary_sum_in_add_sum981 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_add_sum_in_expression_sum990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_knownTS_in_term1005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_term1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SVAR_in_term1020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_term1029 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_term1034 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_term1037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_term1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_term1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_func_in_term1065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tafcfs_term_in_term1070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_YEAR_in_term1075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MONTH_in_term1080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MONTH_CONST_in_term1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DAYSIN_in_term1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TAFCFS_in_tafcfs_term1101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TAFCFS_in_tafcfs_term1104 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_tafcfs_term1105 = new BitSet(new long[]{0x8000000000000800L});
    public static final BitSet FOLLOW_63_in_tafcfs_term1108 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INTEGER_in_tafcfs_term1112 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_tafcfs_term1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pastMonthTS_in_knownTS1128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_preMonthTS_in_knownTS1130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pastCycleDV_in_knownTS1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_pastMonthTS1153 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_TAFCFS_in_pastMonthTS1156 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_pastMonthTS1159 = new BitSet(new long[]{0x000000000B800000L});
    public static final BitSet FOLLOW_PASTMONTH_in_pastMonthTS1165 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_I_in_pastMonthTS1171 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_MONTH_CONST_in_pastMonthTS1178 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_pastMonthTS1180 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_MONTH_in_pastMonthTS1182 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_set_in_pastMonthTS1185 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INTEGER_in_pastMonthTS1191 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_MONTH_in_pastMonthTS1202 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_pastMonthTS1204 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_MONTH_CONST_in_pastMonthTS1206 = new BitSet(new long[]{0xC000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_set_in_pastMonthTS1209 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INTEGER_in_pastMonthTS1215 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_pastMonthTS1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_preMonthTS1238 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_preMonthTS1240 = new BitSet(new long[]{0x8000000000000800L});
    public static final BitSet FOLLOW_63_in_preMonthTS1245 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_INTEGER_in_preMonthTS1249 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_preMonthTS1251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_pastCycleDV1271 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_pastCycleDV1273 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_IDENT_in_pastCycleDV1277 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_pastCycleDV1279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_noArgFunction_in_function1298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_argFunction_in_function1304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_noArgFunction1320 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_69_in_noArgFunction1322 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_noArgFunction1324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_argFunction1342 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_arguments_in_argFunction1344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_oneArgument_in_arguments1364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_multiArguments_in_arguments1366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_oneArgument1379 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_IDENT_in_oneArgument1383 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_knownTS_in_oneArgument1385 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_oneArgument1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_multiArguments1407 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_multiArguments1412 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_66_in_multiArguments1416 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_multiArguments1421 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000044L});
    public static final BitSet FOLLOW_70_in_multiArguments1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_unary1450 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_term_in_unary1454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_allnumber1474 = new BitSet(new long[]{0x8000000000001800L});
    public static final BitSet FOLLOW_number_in_allnumber1480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unary_in_mult1499 = new BitSet(new long[]{0x2000000040000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_61_in_mult1509 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_64_in_mult1516 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_MOD_in_mult1520 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_unary_in_mult1526 = new BitSet(new long[]{0x2000000040000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_mult_in_add1550 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_62_in_add1560 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_63_in_add1567 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_mult_in_add1574 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_add_in_expression1597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_relation0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationStatementSeries_in_conditionStatement1651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALWAYS_in_conditionStatement1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_whereStatement1674 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_usedKeywords_in_whereStatement1680 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_whereStatement1684 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_whereStatement1686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relationRangeStatement_in_relationStatementSeries1707 = new BitSet(new long[]{0x0000000000000002L,0x0000000000600000L});
    public static final BitSet FOLLOW_85_in_relationStatementSeries1721 = new BitSet(new long[]{0x8040000015FF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_86_in_relationStatementSeries1727 = new BitSet(new long[]{0x8040000015FF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_relationRangeStatement_in_relationStatementSeries1733 = new BitSet(new long[]{0x0000000000000002L,0x0000000000600000L});
    public static final BitSet FOLLOW_relationStatement_in_relationRangeStatement1755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_func_in_relationRangeStatement1762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_relationStatement1785 = new BitSet(new long[]{0x0000000000000000L,0x00000000001F0000L});
    public static final BitSet FOLLOW_relation_in_relationStatement1788 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_relationStatement1793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_constraintStatement1813 = new BitSet(new long[]{0x0000000000000000L,0x0000000000060200L});
    public static final BitSet FOLLOW_73_in_constraintStatement1819 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_82_in_constraintStatement1825 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_81_in_constraintStatement1831 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_constraintStatement1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_assignStatement1857 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_assignStatement1859 = new BitSet(new long[]{0x8040000015BF9860L,0x0000000000000020L});
    public static final BitSet FOLLOW_expression_in_assignStatement1861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_number1880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_number1887 = new BitSet(new long[]{0x0000000000000002L});

}