// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g 2013-06-04 13:24:48

  package scripting.grammar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ConfigSimpleLexer extends Lexer {
    public static final int End=8;
    public static final int Config=7;
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

    public ConfigSimpleLexer() {;} 
    public ConfigSimpleLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ConfigSimpleLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:11:7: ( 'DssTransfer' )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:11:9: 'DssTransfer'
            {
            match("DssTransfer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:12:7: ( '-' )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:12:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:13:7: ( '/' )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:13:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:14:7: ( '.' )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:14:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:15:7: ( '\\\"' )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:15:9: '\\\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:16:7: ( '\\\\' )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:16:9: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "SL_COMMENT"
    public final void mSL_COMMENT() throws RecognitionException {
        try {
            int _type = SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:130:12: ( '#' (~ ( '\\r' | '\\n' ) )* )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:130:14: '#' (~ ( '\\r' | '\\n' ) )*
            {
            match('#'); 
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:130:18: (~ ( '\\r' | '\\n' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:130:18: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SL_COMMENT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:133:5: ( ( Digit )+ )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:133:7: ( Digit )+
            {
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:133:7: ( Digit )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:133:7: Digit
            	    {
            	    mDigit(); 

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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "Begin"
    public final void mBegin() throws RecognitionException {
        try {
            int _type = Begin;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:135:8: ( 'Begin' )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:135:10: 'Begin'
            {
            match("Begin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Begin"

    // $ANTLR start "End"
    public final void mEnd() throws RecognitionException {
        try {
            int _type = End;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:136:8: ( 'End' )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:136:10: 'End'
            {
            match("End"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "End"

    // $ANTLR start "Config"
    public final void mConfig() throws RecognitionException {
        try {
            int _type = Config;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:137:8: ( 'Config' )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:137:10: 'Config'
            {
            match("Config"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Config"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:139:4: ( Letter ( Letter | Digit | '_' )* )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:139:6: Letter ( Letter | Digit | '_' )*
            {
            mLetter(); 
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:139:13: ( Letter | Digit | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:144:17: ( 'a' .. 'z' | 'A' .. 'Z' )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Letter"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:146:16: ( '0' .. '9' )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:146:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "Digit"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:150:4: ( ( ' ' | '\\t' ) )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:150:6: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "ENDLINE"
    public final void mENDLINE() throws RecognitionException {
        try {
            int _type = ENDLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:154:9: ( ( '\\n' | '\\r' ) )
            // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:154:11: ( '\\n' | '\\r' )
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDLINE"

    public void mTokens() throws RecognitionException {
        // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | SL_COMMENT | INT | Begin | End | Config | ID | WS | ENDLINE )
        int alt4=14;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:46: SL_COMMENT
                {
                mSL_COMMENT(); 

                }
                break;
            case 8 :
                // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:57: INT
                {
                mINT(); 

                }
                break;
            case 9 :
                // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:61: Begin
                {
                mBegin(); 

                }
                break;
            case 10 :
                // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:67: End
                {
                mEnd(); 

                }
                break;
            case 11 :
                // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:71: Config
                {
                mConfig(); 

                }
                break;
            case 12 :
                // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:78: ID
                {
                mID(); 

                }
                break;
            case 13 :
                // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:81: WS
                {
                mWS(); 

                }
                break;
            case 14 :
                // D:\\cvwrsm\\trunk\\WRIMS2_Vscript\\dev\\src\\scripting\\grammar\\ConfigSimple.g:1:84: ENDLINE
                {
                mENDLINE(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\1\uffff\1\14\7\uffff\3\14\3\uffff\6\14\1\31\3\14\1\uffff\2\14"+
        "\1\37\2\14\1\uffff\1\42\1\14\1\uffff\3\14\1\47\1\uffff";
    static final String DFA4_eofS =
        "\50\uffff";
    static final String DFA4_minS =
        "\1\11\1\163\7\uffff\1\145\1\156\1\157\3\uffff\1\163\1\147\1\144"+
        "\1\156\1\124\1\151\1\60\1\146\1\162\1\156\1\uffff\1\151\1\141\1"+
        "\60\1\147\1\156\1\uffff\1\60\1\163\1\uffff\1\146\1\145\1\162\1\60"+
        "\1\uffff";
    static final String DFA4_maxS =
        "\1\172\1\163\7\uffff\1\145\1\156\1\157\3\uffff\1\163\1\147\1\144"+
        "\1\156\1\124\1\151\1\172\1\146\1\162\1\156\1\uffff\1\151\1\141\1"+
        "\172\1\147\1\156\1\uffff\1\172\1\163\1\uffff\1\146\1\145\1\162\1"+
        "\172\1\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\3\uffff\1\14\1\15\1\16\12"+
        "\uffff\1\12\5\uffff\1\11\2\uffff\1\13\4\uffff\1\1";
    static final String DFA4_specialS =
        "\50\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\15\1\16\2\uffff\1\16\22\uffff\1\15\1\uffff\1\5\1\7\11\uffff"+
            "\1\2\1\4\1\3\12\10\7\uffff\1\14\1\11\1\13\1\1\1\12\25\14\1\uffff"+
            "\1\6\4\uffff\32\14",
            "\1\17",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\20",
            "\1\21",
            "\1\22",
            "",
            "",
            "",
            "\1\23",
            "\1\24",
            "\1\25",
            "\1\26",
            "\1\27",
            "\1\30",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "\1\32",
            "\1\33",
            "\1\34",
            "",
            "\1\35",
            "\1\36",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "\1\40",
            "\1\41",
            "",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
            "\1\43",
            "",
            "\1\44",
            "\1\45",
            "\1\46",
            "\12\14\7\uffff\32\14\4\uffff\1\14\1\uffff\32\14",
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

    class DFA4 extends DFA {

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
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | SL_COMMENT | INT | Begin | End | Config | ID | WS | ENDLINE );";
        }
    }
 

}