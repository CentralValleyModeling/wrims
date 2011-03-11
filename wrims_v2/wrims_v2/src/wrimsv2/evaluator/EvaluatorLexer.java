// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g 2011-03-11 12:19:04

  package wrimsv2.evaluator;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class EvaluatorLexer extends Lexer {
    public static final int FUNCTION=52;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__66=66;
    public static final int WHERE=31;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int YEAR=26;
    public static final int ORDER=47;
    public static final int LETTER=13;
    public static final int MOD=30;
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
    public static final int MIN=16;
    public static final int FROM_WRESL_FILE=53;
    public static final int LHSLTRHS=50;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int FILE=36;
    public static final int T__86=86;
    public static final int ABS=18;
    public static final int DAYSIN=28;
    public static final int T__71=71;
    public static final int WS=56;
    public static final int T__72=72;
    public static final int T__70=70;
    public static final int CONSTRAIN=4;
    public static final int CONVERTUNITS=43;
    public static final int LHSGTRHS=49;
    public static final int SYMBOLS=7;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int LOWERBOUND=39;
    public static final int T__73=73;
    public static final int OUTPUT=45;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int BACKSLASH=8;
    public static final int T__77=77;

    // delegates
    // delegators

    public EvaluatorLexer() {;} 
    public EvaluatorLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public EvaluatorLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g"; }

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:11:7: ( 'v:' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:11:9: 'v:'
            {
            match("v:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__58"

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:12:7: ( 'g:' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:12:9: 'g:'
            {
            match("g:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:13:7: ( 'c:' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:13:9: 'c:'
            {
            match("c:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:14:7: ( '*' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:14:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:15:7: ( '+' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:15:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "T__63"
    public final void mT__63() throws RecognitionException {
        try {
            int _type = T__63;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:16:7: ( '-' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:16:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__63"

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:17:7: ( '/' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:17:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:18:7: ( ':' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:18:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__65"

    // $ANTLR start "T__66"
    public final void mT__66() throws RecognitionException {
        try {
            int _type = T__66;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:19:7: ( ';' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:19:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__66"

    // $ANTLR start "T__67"
    public final void mT__67() throws RecognitionException {
        try {
            int _type = T__67;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:20:7: ( '.' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:20:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__67"

    // $ANTLR start "T__68"
    public final void mT__68() throws RecognitionException {
        try {
            int _type = T__68;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:21:7: ( '|' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:21:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__68"

    // $ANTLR start "T__69"
    public final void mT__69() throws RecognitionException {
        try {
            int _type = T__69;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:22:7: ( '(' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:22:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__69"

    // $ANTLR start "T__70"
    public final void mT__70() throws RecognitionException {
        try {
            int _type = T__70;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:23:7: ( ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:23:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__70"

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:24:7: ( 'timeseries' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:24:9: 'timeseries'
            {
            match("timeseries"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:25:7: ( 'kind' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:25:9: 'kind'
            {
            match("kind"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "T__73"
    public final void mT__73() throws RecognitionException {
        try {
            int _type = T__73;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:26:7: ( '=' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:26:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__73"

    // $ANTLR start "T__74"
    public final void mT__74() throws RecognitionException {
        try {
            int _type = T__74;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:27:7: ( 'select' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:27:9: 'select'
            {
            match("select"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__74"

    // $ANTLR start "T__75"
    public final void mT__75() throws RecognitionException {
        try {
            int _type = T__75;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:28:7: ( 'from' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:28:9: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:29:7: ( 'given' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:29:9: 'given'
            {
            match("given"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:30:7: ( 'use' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:30:9: 'use'
            {
            match("use"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:31:7: ( '[' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:31:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:32:7: ( ']' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:32:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:33:7: ( '==' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:33:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:34:7: ( '<' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:34:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:35:7: ( '>' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:35:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:36:7: ( '>=' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:36:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:37:7: ( '<=' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:37:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:38:7: ( '.and.' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:38:9: '.and.'
            {
            match(".and."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:39:7: ( '.or.' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:39:9: '.or.'
            {
            match(".or."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "MULTILINE_COMMENT"
    public final void mMULTILINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTILINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:290:19: ( '/*' ( . )* '*/' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:290:21: '/*' ( . )* '*/'
            {
            match("/*"); 

            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:290:26: ( . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='/') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1>='\u0000' && LA1_1<='.')||(LA1_1>='0' && LA1_1<='\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<=')')||(LA1_0>='+' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:290:26: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match("*/"); 

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULTILINE_COMMENT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:292:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:292:19: ( 'a' .. 'z' | 'A' .. 'Z' )
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
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:293:16: ( '0' .. '9' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:293:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "SYMBOLS"
    public final void mSYMBOLS() throws RecognitionException {
        try {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:294:18: ( '_' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:294:20: '_'
            {
            match('_'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "SYMBOLS"

    // $ANTLR start "BACKSLASH"
    public final void mBACKSLASH() throws RecognitionException {
        try {
            int _type = BACKSLASH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:296:11: ( '\\\\' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:296:13: '\\\\'
            {
            match('\\'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BACKSLASH"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:298:9: ( ( DIGIT )+ )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:298:11: ( DIGIT )+
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:298:11: ( DIGIT )+
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
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:298:11: DIGIT
            	    {
            	    mDIGIT(); 

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
    // $ANTLR end "INTEGER"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:299:7: ( ( INTEGER )? '.' INTEGER | INTEGER '.' )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:299:9: ( INTEGER )? '.' INTEGER
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:299:9: ( INTEGER )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:299:9: INTEGER
                            {
                            mINTEGER(); 

                            }
                            break;

                    }

                    match('.'); 
                    mINTEGER(); 

                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:300:6: INTEGER '.'
                    {
                    mINTEGER(); 
                    match('.'); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "I"
    public final void mI() throws RecognitionException {
        try {
            int _type = I;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:303:2: ( 'i' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:303:4: 'i'
            {
            match('i'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "I"

    // $ANTLR start "YEAR"
    public final void mYEAR() throws RecognitionException {
        try {
            int _type = YEAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:304:5: ( 'wateryear' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:304:7: 'wateryear'
            {
            match("wateryear"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "YEAR"

    // $ANTLR start "MONTH"
    public final void mMONTH() throws RecognitionException {
        try {
            int _type = MONTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:305:6: ( 'month' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:305:8: 'month'
            {
            match("month"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MONTH"

    // $ANTLR start "MONTH_CONST"
    public final void mMONTH_CONST() throws RecognitionException {
        try {
            int _type = MONTH_CONST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:306:12: ( 'jan' | 'feb' | 'mar' | 'apr' | 'may' | 'jun' | 'jul' | 'aug' | 'sep' | 'oct' | 'nov' | 'dec' )
            int alt5=12;
            alt5 = dfa5.predict(input);
            switch (alt5) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:306:14: 'jan'
                    {
                    match("jan"); 


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:306:20: 'feb'
                    {
                    match("feb"); 


                    }
                    break;
                case 3 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:306:26: 'mar'
                    {
                    match("mar"); 


                    }
                    break;
                case 4 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:306:32: 'apr'
                    {
                    match("apr"); 


                    }
                    break;
                case 5 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:306:38: 'may'
                    {
                    match("may"); 


                    }
                    break;
                case 6 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:306:44: 'jun'
                    {
                    match("jun"); 


                    }
                    break;
                case 7 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:306:50: 'jul'
                    {
                    match("jul"); 


                    }
                    break;
                case 8 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:306:56: 'aug'
                    {
                    match("aug"); 


                    }
                    break;
                case 9 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:306:62: 'sep'
                    {
                    match("sep"); 


                    }
                    break;
                case 10 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:306:68: 'oct'
                    {
                    match("oct"); 


                    }
                    break;
                case 11 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:306:74: 'nov'
                    {
                    match("nov"); 


                    }
                    break;
                case 12 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:306:80: 'dec'
                    {
                    match("dec"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MONTH_CONST"

    // $ANTLR start "PASTMONTH"
    public final void mPASTMONTH() throws RecognitionException {
        try {
            int _type = PASTMONTH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:307:10: ( 'prevjan' | 'prevfeb' | 'prevmar' | 'prevapr' | 'prevmay' | 'prevjun' | 'prevjul' | 'prevaug' | 'prevsep' | 'prevoct' | 'prevnov' | 'prevdec' )
            int alt6=12;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:307:12: 'prevjan'
                    {
                    match("prevjan"); 


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:307:22: 'prevfeb'
                    {
                    match("prevfeb"); 


                    }
                    break;
                case 3 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:307:32: 'prevmar'
                    {
                    match("prevmar"); 


                    }
                    break;
                case 4 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:307:42: 'prevapr'
                    {
                    match("prevapr"); 


                    }
                    break;
                case 5 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:307:52: 'prevmay'
                    {
                    match("prevmay"); 


                    }
                    break;
                case 6 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:307:62: 'prevjun'
                    {
                    match("prevjun"); 


                    }
                    break;
                case 7 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:307:72: 'prevjul'
                    {
                    match("prevjul"); 


                    }
                    break;
                case 8 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:307:82: 'prevaug'
                    {
                    match("prevaug"); 


                    }
                    break;
                case 9 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:307:92: 'prevsep'
                    {
                    match("prevsep"); 


                    }
                    break;
                case 10 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:307:102: 'prevoct'
                    {
                    match("prevoct"); 


                    }
                    break;
                case 11 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:307:112: 'prevnov'
                    {
                    match("prevnov"); 


                    }
                    break;
                case 12 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:307:122: 'prevdec'
                    {
                    match("prevdec"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PASTMONTH"

    // $ANTLR start "RANGE"
    public final void mRANGE() throws RecognitionException {
        try {
            int _type = RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:308:6: ( 'range' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:308:8: 'range'
            {
            match("range"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGE"

    // $ANTLR start "TAFCFS"
    public final void mTAFCFS() throws RecognitionException {
        try {
            int _type = TAFCFS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:310:7: ( 'taf_cfs' | 'cfs_taf' | 'cfs_af' )
            int alt7=3;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='t') ) {
                alt7=1;
            }
            else if ( (LA7_0=='c') ) {
                int LA7_2 = input.LA(2);

                if ( (LA7_2=='f') ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3=='s') ) {
                        int LA7_4 = input.LA(4);

                        if ( (LA7_4=='_') ) {
                            int LA7_5 = input.LA(5);

                            if ( (LA7_5=='t') ) {
                                alt7=2;
                            }
                            else if ( (LA7_5=='a') ) {
                                alt7=3;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 7, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 4, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:310:9: 'taf_cfs'
                    {
                    match("taf_cfs"); 


                    }
                    break;
                case 2 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:310:19: 'cfs_taf'
                    {
                    match("cfs_taf"); 


                    }
                    break;
                case 3 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:310:29: 'cfs_af'
                    {
                    match("cfs_af"); 


                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TAFCFS"

    // $ANTLR start "DAYSIN"
    public final void mDAYSIN() throws RecognitionException {
        try {
            int _type = DAYSIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:311:7: ( 'daysin' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:311:9: 'daysin'
            {
            match("daysin"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DAYSIN"

    // $ANTLR start "SUM"
    public final void mSUM() throws RecognitionException {
        try {
            int _type = SUM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:313:4: ( 'sum' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:313:6: 'sum'
            {
            match("sum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SUM"

    // $ANTLR start "MAX"
    public final void mMAX() throws RecognitionException {
        try {
            int _type = MAX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:314:5: ( 'max' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:314:7: 'max'
            {
            match("max"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAX"

    // $ANTLR start "MIN"
    public final void mMIN() throws RecognitionException {
        try {
            int _type = MIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:315:5: ( 'min' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:315:7: 'min'
            {
            match("min"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MIN"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:316:5: ( 'int' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:316:7: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "ABS"
    public final void mABS() throws RecognitionException {
        try {
            int _type = ABS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:317:4: ( 'abs' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:317:6: 'abs'
            {
            match("abs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ABS"

    // $ANTLR start "LOG"
    public final void mLOG() throws RecognitionException {
        try {
            int _type = LOG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:318:4: ( 'log' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:318:6: 'log'
            {
            match("log"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOG"

    // $ANTLR start "LOG10"
    public final void mLOG10() throws RecognitionException {
        try {
            int _type = LOG10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:319:6: ( 'log10' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:319:8: 'log10'
            {
            match("log10"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOG10"

    // $ANTLR start "POW"
    public final void mPOW() throws RecognitionException {
        try {
            int _type = POW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:320:4: ( 'pow' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:320:6: 'pow'
            {
            match("pow"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "POW"

    // $ANTLR start "MOD"
    public final void mMOD() throws RecognitionException {
        try {
            int _type = MOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:321:4: ( 'mod' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:321:6: 'mod'
            {
            match("mod"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MOD"

    // $ANTLR start "WHERE"
    public final void mWHERE() throws RecognitionException {
        try {
            int _type = WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:322:7: ( 'where' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:322:9: 'where'
            {
            match("where"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHERE"

    // $ANTLR start "CONSTRAIN"
    public final void mCONSTRAIN() throws RecognitionException {
        try {
            int _type = CONSTRAIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:324:10: ( 'constrain' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:324:12: 'constrain'
            {
            match("constrain"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONSTRAIN"

    // $ANTLR start "ALWAYS"
    public final void mALWAYS() throws RecognitionException {
        try {
            int _type = ALWAYS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:325:7: ( 'always' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:325:9: 'always'
            {
            match("always"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ALWAYS"

    // $ANTLR start "NAME"
    public final void mNAME() throws RecognitionException {
        try {
            int _type = NAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:327:5: ( 'name' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:327:7: 'name'
            {
            match("name"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NAME"

    // $ANTLR start "DVAR"
    public final void mDVAR() throws RecognitionException {
        try {
            int _type = DVAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:328:5: ( 'dvar' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:328:7: 'dvar'
            {
            match("dvar"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DVAR"

    // $ANTLR start "CYCLE"
    public final void mCYCLE() throws RecognitionException {
        try {
            int _type = CYCLE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:329:6: ( 'cycle' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:329:8: 'cycle'
            {
            match("cycle"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CYCLE"

    // $ANTLR start "FILE"
    public final void mFILE() throws RecognitionException {
        try {
            int _type = FILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:330:5: ( 'file' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:330:7: 'file'
            {
            match("file"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FILE"

    // $ANTLR start "CONDITION"
    public final void mCONDITION() throws RecognitionException {
        try {
            int _type = CONDITION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:331:10: ( 'condition' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:331:12: 'condition'
            {
            match("condition"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONDITION"

    // $ANTLR start "INCLUDE"
    public final void mINCLUDE() throws RecognitionException {
        try {
            int _type = INCLUDE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:332:8: ( 'include' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:332:10: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INCLUDE"

    // $ANTLR start "LOWERBOUND"
    public final void mLOWERBOUND() throws RecognitionException {
        try {
            int _type = LOWERBOUND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:333:11: ( 'lower_bound' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:333:13: 'lower_bound'
            {
            match("lower_bound"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LOWERBOUND"

    // $ANTLR start "UPPERBOUND"
    public final void mUPPERBOUND() throws RecognitionException {
        try {
            int _type = UPPERBOUND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:334:11: ( 'upper_bound' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:334:13: 'upper_bound'
            {
            match("upper_bound"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UPPERBOUND"

    // $ANTLR start "INTEGERTYPE"
    public final void mINTEGERTYPE() throws RecognitionException {
        try {
            int _type = INTEGERTYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:335:12: ( 'integer' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:335:14: 'integer'
            {
            match("integer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGERTYPE"

    // $ANTLR start "UNITS"
    public final void mUNITS() throws RecognitionException {
        try {
            int _type = UNITS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:336:6: ( 'units' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:336:8: 'units'
            {
            match("units"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UNITS"

    // $ANTLR start "CONVERTUNITS"
    public final void mCONVERTUNITS() throws RecognitionException {
        try {
            int _type = CONVERTUNITS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:337:13: ( 'convert_to_units' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:337:15: 'convert_to_units'
            {
            match("convert_to_units"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONVERTUNITS"

    // $ANTLR start "TYPE"
    public final void mTYPE() throws RecognitionException {
        try {
            int _type = TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:338:5: ( 'type' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:338:7: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TYPE"

    // $ANTLR start "OUTPUT"
    public final void mOUTPUT() throws RecognitionException {
        try {
            int _type = OUTPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:339:7: ( 'output' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:339:9: 'output'
            {
            match("output"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OUTPUT"

    // $ANTLR start "CASE"
    public final void mCASE() throws RecognitionException {
        try {
            int _type = CASE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:340:5: ( 'case' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:340:7: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CASE"

    // $ANTLR start "ORDER"
    public final void mORDER() throws RecognitionException {
        try {
            int _type = ORDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:341:6: ( 'order' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:341:8: 'order'
            {
            match("order"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ORDER"

    // $ANTLR start "EXPRESSION"
    public final void mEXPRESSION() throws RecognitionException {
        try {
            int _type = EXPRESSION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:342:11: ( 'expression' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:342:13: 'expression'
            {
            match("expression"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXPRESSION"

    // $ANTLR start "LHSGTRHS"
    public final void mLHSGTRHS() throws RecognitionException {
        try {
            int _type = LHSGTRHS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:343:9: ( 'lhs_gt_rhs' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:343:11: 'lhs_gt_rhs'
            {
            match("lhs_gt_rhs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LHSGTRHS"

    // $ANTLR start "LHSLTRHS"
    public final void mLHSLTRHS() throws RecognitionException {
        try {
            int _type = LHSLTRHS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:344:9: ( 'lhs_lt_rhs' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:344:11: 'lhs_lt_rhs'
            {
            match("lhs_lt_rhs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LHSLTRHS"

    // $ANTLR start "WEIGHT"
    public final void mWEIGHT() throws RecognitionException {
        try {
            int _type = WEIGHT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:345:7: ( 'weight' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:345:9: 'weight'
            {
            match("weight"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WEIGHT"

    // $ANTLR start "FUNCTION"
    public final void mFUNCTION() throws RecognitionException {
        try {
            int _type = FUNCTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:346:9: ( 'function' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:346:11: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FUNCTION"

    // $ANTLR start "FROM_WRESL_FILE"
    public final void mFROM_WRESL_FILE() throws RecognitionException {
        try {
            int _type = FROM_WRESL_FILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:347:16: ( 'from_wresl_file' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:347:18: 'from_wresl_file'
            {
            match("from_wresl_file"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FROM_WRESL_FILE"

    // $ANTLR start "SVAR"
    public final void mSVAR() throws RecognitionException {
        try {
            int _type = SVAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:349:5: ( '{' IDENT '}' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:349:7: '{' IDENT '}'
            {
            match('{'); 
            mIDENT(); 
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SVAR"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:350:7: ( LETTER ( LETTER | DIGIT | SYMBOLS )* )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:350:9: LETTER ( LETTER | DIGIT | SYMBOLS )*
            {
            mLETTER(); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:350:16: ( LETTER | DIGIT | SYMBOLS )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:
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
            	    break loop8;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "IDENT1"
    public final void mIDENT1() throws RecognitionException {
        try {
            int _type = IDENT1;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:351:8: ( DIGIT ( LETTER | DIGIT | SYMBOLS )* )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:351:10: DIGIT ( LETTER | DIGIT | SYMBOLS )*
            {
            mDIGIT(); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:351:16: ( LETTER | DIGIT | SYMBOLS )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='0' && LA9_0<='9')||(LA9_0>='A' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:
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
            	    break loop9;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT1"

    // $ANTLR start "IDENT2"
    public final void mIDENT2() throws RecognitionException {
        try {
            int _type = IDENT2;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:352:8: ( SYMBOLS ( LETTER | DIGIT | SYMBOLS )* )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:352:10: SYMBOLS ( LETTER | DIGIT | SYMBOLS )*
            {
            mSYMBOLS(); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:352:18: ( LETTER | DIGIT | SYMBOLS )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:
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
            	    break loop10;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT2"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:354:4: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:354:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:354:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||(LA11_0>='\f' && LA11_0<='\r')||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


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

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:355:9: ( '!' ( . )* ( '\\n' | '\\r' ) )
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:355:11: '!' ( . )* ( '\\n' | '\\r' )
            {
            match('!'); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:355:15: ( . )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                    alt12=2;
                }
                else if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:355:15: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    public void mTokens() throws RecognitionException {
        // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:8: ( T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | MULTILINE_COMMENT | BACKSLASH | INTEGER | FLOAT | I | YEAR | MONTH | MONTH_CONST | PASTMONTH | RANGE | TAFCFS | DAYSIN | SUM | MAX | MIN | INT | ABS | LOG | LOG10 | POW | MOD | WHERE | CONSTRAIN | ALWAYS | NAME | DVAR | CYCLE | FILE | CONDITION | INCLUDE | LOWERBOUND | UPPERBOUND | INTEGERTYPE | UNITS | CONVERTUNITS | TYPE | OUTPUT | CASE | ORDER | EXPRESSION | LHSGTRHS | LHSLTRHS | WEIGHT | FUNCTION | FROM_WRESL_FILE | SVAR | IDENT | IDENT1 | IDENT2 | WS | COMMENT )
        int alt13=80;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:10: T__58
                {
                mT__58(); 

                }
                break;
            case 2 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:16: T__59
                {
                mT__59(); 

                }
                break;
            case 3 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:22: T__60
                {
                mT__60(); 

                }
                break;
            case 4 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:28: T__61
                {
                mT__61(); 

                }
                break;
            case 5 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:34: T__62
                {
                mT__62(); 

                }
                break;
            case 6 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:40: T__63
                {
                mT__63(); 

                }
                break;
            case 7 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:46: T__64
                {
                mT__64(); 

                }
                break;
            case 8 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:52: T__65
                {
                mT__65(); 

                }
                break;
            case 9 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:58: T__66
                {
                mT__66(); 

                }
                break;
            case 10 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:64: T__67
                {
                mT__67(); 

                }
                break;
            case 11 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:70: T__68
                {
                mT__68(); 

                }
                break;
            case 12 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:76: T__69
                {
                mT__69(); 

                }
                break;
            case 13 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:82: T__70
                {
                mT__70(); 

                }
                break;
            case 14 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:88: T__71
                {
                mT__71(); 

                }
                break;
            case 15 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:94: T__72
                {
                mT__72(); 

                }
                break;
            case 16 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:100: T__73
                {
                mT__73(); 

                }
                break;
            case 17 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:106: T__74
                {
                mT__74(); 

                }
                break;
            case 18 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:112: T__75
                {
                mT__75(); 

                }
                break;
            case 19 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:118: T__76
                {
                mT__76(); 

                }
                break;
            case 20 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:124: T__77
                {
                mT__77(); 

                }
                break;
            case 21 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:130: T__78
                {
                mT__78(); 

                }
                break;
            case 22 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:136: T__79
                {
                mT__79(); 

                }
                break;
            case 23 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:142: T__80
                {
                mT__80(); 

                }
                break;
            case 24 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:148: T__81
                {
                mT__81(); 

                }
                break;
            case 25 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:154: T__82
                {
                mT__82(); 

                }
                break;
            case 26 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:160: T__83
                {
                mT__83(); 

                }
                break;
            case 27 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:166: T__84
                {
                mT__84(); 

                }
                break;
            case 28 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:172: T__85
                {
                mT__85(); 

                }
                break;
            case 29 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:178: T__86
                {
                mT__86(); 

                }
                break;
            case 30 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:184: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;
            case 31 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:202: BACKSLASH
                {
                mBACKSLASH(); 

                }
                break;
            case 32 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:212: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 33 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:220: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 34 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:226: I
                {
                mI(); 

                }
                break;
            case 35 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:228: YEAR
                {
                mYEAR(); 

                }
                break;
            case 36 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:233: MONTH
                {
                mMONTH(); 

                }
                break;
            case 37 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:239: MONTH_CONST
                {
                mMONTH_CONST(); 

                }
                break;
            case 38 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:251: PASTMONTH
                {
                mPASTMONTH(); 

                }
                break;
            case 39 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:261: RANGE
                {
                mRANGE(); 

                }
                break;
            case 40 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:267: TAFCFS
                {
                mTAFCFS(); 

                }
                break;
            case 41 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:274: DAYSIN
                {
                mDAYSIN(); 

                }
                break;
            case 42 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:281: SUM
                {
                mSUM(); 

                }
                break;
            case 43 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:285: MAX
                {
                mMAX(); 

                }
                break;
            case 44 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:289: MIN
                {
                mMIN(); 

                }
                break;
            case 45 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:293: INT
                {
                mINT(); 

                }
                break;
            case 46 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:297: ABS
                {
                mABS(); 

                }
                break;
            case 47 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:301: LOG
                {
                mLOG(); 

                }
                break;
            case 48 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:305: LOG10
                {
                mLOG10(); 

                }
                break;
            case 49 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:311: POW
                {
                mPOW(); 

                }
                break;
            case 50 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:315: MOD
                {
                mMOD(); 

                }
                break;
            case 51 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:319: WHERE
                {
                mWHERE(); 

                }
                break;
            case 52 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:325: CONSTRAIN
                {
                mCONSTRAIN(); 

                }
                break;
            case 53 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:335: ALWAYS
                {
                mALWAYS(); 

                }
                break;
            case 54 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:342: NAME
                {
                mNAME(); 

                }
                break;
            case 55 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:347: DVAR
                {
                mDVAR(); 

                }
                break;
            case 56 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:352: CYCLE
                {
                mCYCLE(); 

                }
                break;
            case 57 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:358: FILE
                {
                mFILE(); 

                }
                break;
            case 58 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:363: CONDITION
                {
                mCONDITION(); 

                }
                break;
            case 59 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:373: INCLUDE
                {
                mINCLUDE(); 

                }
                break;
            case 60 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:381: LOWERBOUND
                {
                mLOWERBOUND(); 

                }
                break;
            case 61 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:392: UPPERBOUND
                {
                mUPPERBOUND(); 

                }
                break;
            case 62 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:403: INTEGERTYPE
                {
                mINTEGERTYPE(); 

                }
                break;
            case 63 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:415: UNITS
                {
                mUNITS(); 

                }
                break;
            case 64 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:421: CONVERTUNITS
                {
                mCONVERTUNITS(); 

                }
                break;
            case 65 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:434: TYPE
                {
                mTYPE(); 

                }
                break;
            case 66 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:439: OUTPUT
                {
                mOUTPUT(); 

                }
                break;
            case 67 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:446: CASE
                {
                mCASE(); 

                }
                break;
            case 68 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:451: ORDER
                {
                mORDER(); 

                }
                break;
            case 69 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:457: EXPRESSION
                {
                mEXPRESSION(); 

                }
                break;
            case 70 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:468: LHSGTRHS
                {
                mLHSGTRHS(); 

                }
                break;
            case 71 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:477: LHSLTRHS
                {
                mLHSLTRHS(); 

                }
                break;
            case 72 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:486: WEIGHT
                {
                mWEIGHT(); 

                }
                break;
            case 73 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:493: FUNCTION
                {
                mFUNCTION(); 

                }
                break;
            case 74 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:502: FROM_WRESL_FILE
                {
                mFROM_WRESL_FILE(); 

                }
                break;
            case 75 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:518: SVAR
                {
                mSVAR(); 

                }
                break;
            case 76 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:523: IDENT
                {
                mIDENT(); 

                }
                break;
            case 77 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:529: IDENT1
                {
                mIDENT1(); 

                }
                break;
            case 78 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:536: IDENT2
                {
                mIDENT2(); 

                }
                break;
            case 79 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:543: WS
                {
                mWS(); 

                }
                break;
            case 80 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\wrims_v2\\src\\wrimsv2\\evaluator\\Evaluator.g:1:546: COMMENT
                {
                mCOMMENT(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA5 dfa5 = new DFA5(this);
    protected DFA6 dfa6 = new DFA6(this);
    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA4_eotS =
        "\3\uffff\1\4\1\uffff";
    static final String DFA4_eofS =
        "\5\uffff";
    static final String DFA4_minS =
        "\2\56\1\uffff\1\60\1\uffff";
    static final String DFA4_maxS =
        "\2\71\1\uffff\1\71\1\uffff";
    static final String DFA4_acceptS =
        "\2\uffff\1\1\1\uffff\1\2";
    static final String DFA4_specialS =
        "\5\uffff}>";
    static final String[] DFA4_transitionS = {
            "\1\2\1\uffff\12\1",
            "\1\3\1\uffff\12\1",
            "",
            "\12\2",
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
            return "299:1: FLOAT : ( ( INTEGER )? '.' INTEGER | INTEGER '.' );";
        }
    }
    static final String DFA5_eotS =
        "\22\uffff";
    static final String DFA5_eofS =
        "\22\uffff";
    static final String DFA5_minS =
        "\2\141\1\uffff\1\141\1\160\5\uffff\1\154\1\162\6\uffff";
    static final String DFA5_maxS =
        "\1\163\1\165\1\uffff\1\141\1\165\5\uffff\1\156\1\171\6\uffff";
    static final String DFA5_acceptS =
        "\2\uffff\1\2\2\uffff\1\11\1\12\1\13\1\14\1\1\2\uffff\1\4\1\10\1"+
        "\6\1\7\1\3\1\5";
    static final String DFA5_specialS =
        "\22\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\4\2\uffff\1\10\1\uffff\1\2\3\uffff\1\1\2\uffff\1\3\1\7\1"+
            "\6\3\uffff\1\5",
            "\1\11\23\uffff\1\12",
            "",
            "\1\13",
            "\1\14\4\uffff\1\15",
            "",
            "",
            "",
            "",
            "",
            "\1\17\1\uffff\1\16",
            "\1\20\6\uffff\1\21",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "306:1: MONTH_CONST : ( 'jan' | 'feb' | 'mar' | 'apr' | 'may' | 'jun' | 'jul' | 'aug' | 'sep' | 'oct' | 'nov' | 'dec' );";
        }
    }
    static final String DFA6_eotS =
        "\26\uffff";
    static final String DFA6_eofS =
        "\26\uffff";
    static final String DFA6_minS =
        "\1\160\1\162\1\145\1\166\2\141\1\uffff\1\141\1\160\5\uffff\1\154"+
        "\1\162\6\uffff";
    static final String DFA6_maxS =
        "\1\160\1\162\1\145\1\166\1\163\1\165\1\uffff\1\141\1\165\5\uffff"+
        "\1\156\1\171\6\uffff";
    static final String DFA6_acceptS =
        "\6\uffff\1\2\2\uffff\1\11\1\12\1\13\1\14\1\1\2\uffff\1\4\1\10\1"+
        "\6\1\7\1\3\1\5";
    static final String DFA6_specialS =
        "\26\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1",
            "\1\2",
            "\1\3",
            "\1\4",
            "\1\10\2\uffff\1\14\1\uffff\1\6\3\uffff\1\5\2\uffff\1\7\1\13"+
            "\1\12\3\uffff\1\11",
            "\1\15\23\uffff\1\16",
            "",
            "\1\17",
            "\1\20\4\uffff\1\21",
            "",
            "",
            "",
            "",
            "",
            "\1\23\1\uffff\1\22",
            "\1\24\6\uffff\1\25",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "307:1: PASTMONTH : ( 'prevjan' | 'prevfeb' | 'prevmar' | 'prevapr' | 'prevmay' | 'prevjun' | 'prevjul' | 'prevaug' | 'prevsep' | 'prevoct' | 'prevnov' | 'prevdec' );";
        }
    }
    static final String DFA13_eotS =
        "\1\uffff\3\47\3\uffff\1\64\2\uffff\1\70\3\uffff\2\47\1\76\3\47"+
        "\2\uffff\1\111\1\113\1\uffff\1\114\1\120\13\47\7\uffff\1\47\1\uffff"+
        "\4\47\6\uffff\4\47\2\uffff\11\47\5\uffff\1\114\1\uffff\1\47\1\uffff"+
        "\44\47\1\u00ab\1\u00ac\1\47\1\u00ab\2\47\1\u00b0\2\47\1\u00b4\5"+
        "\47\1\u00ba\2\u00ab\1\u00bb\1\u00bc\5\u00ab\1\u00bd\1\47\1\u00ab"+
        "\2\47\1\u00ab\1\47\1\u00ab\3\47\1\u00c5\1\47\1\u00c8\11\47\1\u00d3"+
        "\2\47\1\u00d6\1\u00d7\1\47\2\uffff\1\u00da\1\u00db\1\47\1\uffff"+
        "\3\47\1\uffff\5\47\4\uffff\3\47\1\u00e8\1\47\1\u00ea\1\47\1\uffff"+
        "\2\47\1\uffff\3\47\1\u00f9\5\47\1\u00ff\1\uffff\2\47\2\uffff\2\47"+
        "\2\uffff\2\47\1\u0106\3\47\1\u010a\1\47\1\u010c\2\47\1\u010f\1\uffff"+
        "\1\47\1\uffff\10\47\1\u011b\1\u011c\4\47\1\uffff\1\47\1\u0122\3"+
        "\47\1\uffff\2\47\1\u0128\3\47\1\uffff\3\47\1\uffff\1\u012f\1\uffff"+
        "\1\u0130\1\u0131\1\uffff\1\u0132\12\47\2\uffff\4\47\1\u0122\1\uffff"+
        "\4\47\1\u0122\1\uffff\3\47\1\u014a\1\u014b\1\47\4\uffff\14\u014d"+
        "\11\47\1\u0157\1\47\2\uffff\1\47\1\uffff\4\47\1\u015e\1\u015f\3"+
        "\47\1\uffff\1\47\1\u0164\4\47\2\uffff\1\47\1\u016a\2\47\1\uffff"+
        "\1\47\1\u016e\1\u016f\1\u0170\1\47\1\uffff\1\47\1\u0173\1\u0174"+
        "\3\uffff\2\47\2\uffff\5\47\1\u017c\1\u017d\2\uffff";
    static final String DFA13_eofS =
        "\u017e\uffff";
    static final String DFA13_minS =
        "\1\11\3\72\3\uffff\1\52\2\uffff\1\60\3\uffff\1\141\1\151\1\75\2"+
        "\145\1\156\2\uffff\2\75\1\uffff\1\56\1\60\3\141\1\142\1\143\2\141"+
        "\1\157\1\141\1\150\1\170\7\uffff\1\166\1\uffff\1\163\1\156\1\143"+
        "\1\163\6\uffff\1\155\1\146\1\160\1\156\2\uffff\1\154\1\155\1\157"+
        "\1\142\1\154\1\156\1\145\1\160\1\151\5\uffff\1\56\1\uffff\1\143"+
        "\1\uffff\1\164\1\145\1\151\1\144\1\162\2\156\1\154\1\162\1\147\1"+
        "\163\1\167\2\164\1\144\1\166\1\155\1\143\1\171\1\141\1\145\1\167"+
        "\1\156\1\147\1\163\1\160\1\145\1\137\1\144\1\154\2\145\1\137\1\145"+
        "\1\144\1\145\2\60\1\155\1\60\1\145\1\143\1\60\1\145\1\164\1\60\1"+
        "\154\1\145\1\162\1\147\1\164\13\60\1\141\1\60\1\160\1\145\1\60\1"+
        "\145\1\60\1\163\1\162\1\166\1\60\1\147\1\60\1\145\1\137\1\162\1"+
        "\156\1\141\1\164\1\151\2\145\1\60\1\163\1\143\2\60\1\143\2\uffff"+
        "\2\60\1\164\1\uffff\1\162\1\163\1\147\1\uffff\1\165\1\162\1\145"+
        "\2\150\4\uffff\1\171\1\165\1\162\1\60\1\151\1\60\1\141\1\uffff\1"+
        "\145\1\60\1\uffff\1\162\1\147\1\145\1\60\1\141\1\146\1\162\1\164"+
        "\1\162\1\60\1\uffff\1\145\1\146\2\uffff\1\164\1\167\2\uffff\1\151"+
        "\1\137\1\60\1\145\1\144\1\171\1\60\1\164\1\60\1\163\1\164\1\60\1"+
        "\uffff\1\156\1\uffff\1\141\1\145\1\141\1\160\1\145\1\143\1\157\1"+
        "\145\2\60\1\137\2\164\1\163\1\uffff\1\146\1\60\1\141\1\151\1\164"+
        "\1\uffff\1\162\1\163\1\60\1\162\1\157\1\142\1\uffff\1\162\2\145"+
        "\1\uffff\1\60\1\uffff\2\60\1\uffff\1\60\1\156\1\154\1\142\2\162"+
        "\1\147\1\160\1\164\1\166\1\143\2\uffff\1\142\2\137\1\163\1\60\1"+
        "\uffff\1\151\1\157\1\137\1\151\1\60\1\uffff\1\145\1\156\1\157\2"+
        "\60\1\141\4\uffff\14\60\1\157\2\162\1\151\2\156\1\164\1\145\1\163"+
        "\1\60\1\165\2\uffff\1\162\1\uffff\1\165\2\150\1\157\2\60\1\157\1"+
        "\163\1\154\1\uffff\1\156\1\60\1\156\2\163\1\156\2\uffff\1\137\1"+
        "\60\1\137\1\144\1\uffff\1\144\3\60\1\165\1\uffff\1\146\2\60\3\uffff"+
        "\1\156\1\151\2\uffff\1\151\1\154\1\164\1\145\1\163\2\60\2\uffff";
    static final String DFA13_maxS =
        "\1\174\1\72\1\151\1\171\3\uffff\1\52\2\uffff\1\157\3\uffff\1\171"+
        "\1\151\1\75\2\165\1\163\2\uffff\2\75\1\uffff\2\172\1\150\1\157\3"+
        "\165\1\157\1\166\1\162\1\141\1\157\1\170\7\uffff\1\166\1\uffff\1"+
        "\163\1\156\1\143\1\163\6\uffff\1\155\1\146\1\160\1\156\2\uffff\1"+
        "\160\1\155\1\157\1\142\1\154\1\156\1\145\1\160\1\151\5\uffff\1\172"+
        "\1\uffff\1\164\1\uffff\1\164\1\145\1\151\1\156\1\171\3\156\1\162"+
        "\1\147\1\163\1\167\2\164\1\144\1\166\1\155\1\143\1\171\1\141\1\145"+
        "\1\167\1\156\1\167\1\163\1\160\1\145\1\137\1\166\1\154\2\145\1\137"+
        "\1\145\1\144\1\145\2\172\1\155\1\172\1\145\1\143\1\172\1\145\1\164"+
        "\1\172\1\154\1\145\1\162\1\147\1\164\13\172\1\141\1\172\1\160\1"+
        "\145\1\172\1\145\1\172\1\163\1\162\1\166\1\172\1\147\1\172\1\145"+
        "\1\137\1\162\1\156\2\164\1\151\2\145\1\172\1\163\1\143\2\172\1\143"+
        "\2\uffff\2\172\1\164\1\uffff\1\162\1\163\1\147\1\uffff\1\165\1\162"+
        "\1\145\2\150\4\uffff\1\171\1\165\1\162\1\172\1\151\1\172\1\163\1"+
        "\uffff\1\145\1\60\1\uffff\1\162\1\154\1\145\1\172\1\141\1\146\1"+
        "\162\1\164\1\162\1\172\1\uffff\1\145\1\146\2\uffff\1\164\1\167\2"+
        "\uffff\1\151\1\137\1\172\1\145\1\144\1\171\1\172\1\164\1\172\1\163"+
        "\1\164\1\172\1\uffff\1\156\1\uffff\1\165\1\145\1\141\1\165\1\145"+
        "\1\143\1\157\1\145\2\172\1\137\2\164\1\163\1\uffff\1\146\1\172\1"+
        "\141\1\151\1\164\1\uffff\1\162\1\163\1\172\1\162\1\157\1\142\1\uffff"+
        "\1\162\2\145\1\uffff\1\172\1\uffff\2\172\1\uffff\1\172\2\156\1\142"+
        "\1\171\1\162\1\147\1\160\1\164\1\166\1\143\2\uffff\1\142\2\137\1"+
        "\163\1\172\1\uffff\1\151\1\157\1\137\1\151\1\172\1\uffff\1\145\1"+
        "\156\1\157\2\172\1\141\4\uffff\14\172\1\157\2\162\1\151\2\156\1"+
        "\164\1\145\1\163\1\172\1\165\2\uffff\1\162\1\uffff\1\165\2\150\1"+
        "\157\2\172\1\157\1\163\1\154\1\uffff\1\156\1\172\1\156\2\163\1\156"+
        "\2\uffff\1\137\1\172\1\137\1\144\1\uffff\1\144\3\172\1\165\1\uffff"+
        "\1\146\2\172\3\uffff\1\156\1\151\2\uffff\1\151\1\154\1\164\1\145"+
        "\1\163\2\172\2\uffff";
    static final String DFA13_acceptS =
        "\4\uffff\1\4\1\5\1\6\1\uffff\1\10\1\11\1\uffff\1\13\1\14\1\15\6"+
        "\uffff\1\25\1\26\2\uffff\1\37\15\uffff\1\113\1\114\1\116\1\117\1"+
        "\120\1\1\1\2\1\uffff\1\3\4\uffff\1\36\1\7\1\34\1\35\1\41\1\12\4"+
        "\uffff\1\27\1\20\11\uffff\1\33\1\30\1\32\1\31\1\40\1\uffff\1\115"+
        "\1\uffff\1\42\132\uffff\1\45\1\52\3\uffff\1\24\3\uffff\1\55\5\uffff"+
        "\1\62\1\53\1\54\1\56\7\uffff\1\61\2\uffff\1\57\12\uffff\1\103\2"+
        "\uffff\1\101\1\17\2\uffff\1\22\1\71\14\uffff\1\66\1\uffff\1\67\16"+
        "\uffff\1\23\5\uffff\1\70\6\uffff\1\77\3\uffff\1\63\1\uffff\1\44"+
        "\2\uffff\1\104\13\uffff\1\47\1\60\5\uffff\1\50\5\uffff\1\21\6\uffff"+
        "\1\110\1\65\1\102\1\51\27\uffff\1\76\1\73\1\uffff\1\46\11\uffff"+
        "\1\111\6\uffff\1\64\1\72\4\uffff\1\43\5\uffff\1\16\3\uffff\1\106"+
        "\1\107\1\105\2\uffff\1\75\1\74\7\uffff\1\112\1\100";
    static final String DFA13_specialS =
        "\u017e\uffff}>";
    static final String[] DFA13_transitionS = {
            "\2\51\1\uffff\2\51\22\uffff\1\51\1\52\6\uffff\1\14\1\15\1\4"+
            "\1\5\1\uffff\1\6\1\12\1\7\12\31\1\10\1\11\1\26\1\20\1\27\2\uffff"+
            "\32\47\1\24\1\30\1\25\1\uffff\1\50\1\uffff\1\36\1\47\1\3\1\41"+
            "\1\45\1\22\1\2\1\47\1\32\1\35\1\17\1\44\1\34\1\40\1\37\1\42"+
            "\1\47\1\43\1\21\1\16\1\23\1\1\1\33\3\47\1\46\1\13",
            "\1\53",
            "\1\54\56\uffff\1\55",
            "\1\56\46\uffff\1\62\4\uffff\1\57\10\uffff\1\60\11\uffff\1"+
            "\61",
            "",
            "",
            "",
            "\1\63",
            "",
            "",
            "\12\67\47\uffff\1\65\15\uffff\1\66",
            "",
            "",
            "",
            "\1\72\7\uffff\1\71\17\uffff\1\73",
            "\1\74",
            "\1\75",
            "\1\77\17\uffff\1\100",
            "\1\102\3\uffff\1\103\10\uffff\1\101\2\uffff\1\104",
            "\1\107\1\uffff\1\106\2\uffff\1\105",
            "",
            "",
            "\1\110",
            "\1\112",
            "",
            "\1\67\1\uffff\12\115\7\uffff\32\116\4\uffff\1\116\1\uffff"+
            "\32\116",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\15\47\1\117\14\47",
            "\1\121\3\uffff\1\123\2\uffff\1\122",
            "\1\125\7\uffff\1\126\5\uffff\1\124",
            "\1\127\23\uffff\1\130",
            "\1\133\11\uffff\1\134\3\uffff\1\131\4\uffff\1\132",
            "\1\135\16\uffff\1\137\2\uffff\1\136",
            "\1\141\15\uffff\1\140",
            "\1\143\3\uffff\1\142\20\uffff\1\144",
            "\1\146\2\uffff\1\145",
            "\1\147",
            "\1\151\6\uffff\1\150",
            "\1\152",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\153",
            "",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "",
            "",
            "\1\164\3\uffff\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "",
            "",
            "",
            "",
            "",
            "\1\67\1\uffff\12\115\7\uffff\32\116\4\uffff\1\116\1\uffff"+
            "\32\116",
            "",
            "\1\177\20\uffff\1\176",
            "",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0084\11\uffff\1\u0083",
            "\1\u0085\5\uffff\1\u0087\1\u0086",
            "\1\u0088",
            "\1\u0089",
            "\1\u008b\1\uffff\1\u008a",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b\17\uffff\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a2\16\uffff\1\u00a1\2\uffff\1\u00a3",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\u00aa",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00ad",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00ae",
            "\1\u00af",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00b1",
            "\1\u00b2",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\4\47\1\u00b3\25"+
            "\47",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00be",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00bf",
            "\1\u00c0",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00c1",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00c6",
            "\1\47\1\u00c7\10\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32"+
            "\47",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00ce\22\uffff\1\u00cd",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00d4",
            "\1\u00d5",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00d8",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\u00d9\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00dc",
            "",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "",
            "",
            "",
            "",
            "\1\u00e5",
            "\1\u00e6",
            "\1\u00e7",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00e9",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00ee\2\uffff\1\u00f2\1\uffff\1\u00ec\3\uffff\1\u00eb\2"+
            "\uffff\1\u00ed\1\u00f1\1\u00f0\3\uffff\1\u00ef",
            "",
            "\1\u00f3",
            "\1\u00f4",
            "",
            "\1\u00f5",
            "\1\u00f6\4\uffff\1\u00f7",
            "\1\u00f8",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00fa",
            "\1\u00fb",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u0100",
            "\1\u0101",
            "",
            "",
            "\1\u0102",
            "\1\u0103",
            "",
            "",
            "\1\u0104",
            "\1\u0105",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u010b",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u010d",
            "\1\u010e",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u0110",
            "",
            "\1\u0111\23\uffff\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115\4\uffff\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u011d",
            "\1\u011e",
            "\1\u011f",
            "\1\u0120",
            "",
            "\1\u0121",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0123",
            "\1\u0124",
            "\1\u0125",
            "",
            "\1\u0126",
            "\1\u0127",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0129",
            "\1\u012a",
            "\1\u012b",
            "",
            "\1\u012c",
            "\1\u012d",
            "\1\u012e",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0133",
            "\1\u0135\1\uffff\1\u0134",
            "\1\u0136",
            "\1\u0137\6\uffff\1\u0138",
            "\1\u0139",
            "\1\u013a",
            "\1\u013b",
            "\1\u013c",
            "\1\u013d",
            "\1\u013e",
            "",
            "",
            "\1\u013f",
            "\1\u0140",
            "\1\u0141",
            "\1\u0142",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u0143",
            "\1\u0144",
            "\1\u0145",
            "\1\u0146",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u0147",
            "\1\u0148",
            "\1\u0149",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u014c",
            "",
            "",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u014e",
            "\1\u014f",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "\1\u0154",
            "\1\u0155",
            "\1\u0156",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0158",
            "",
            "",
            "\1\u0159",
            "",
            "\1\u015a",
            "\1\u015b",
            "\1\u015c",
            "\1\u015d",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0160",
            "\1\u0161",
            "\1\u0162",
            "",
            "\1\u0163",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0165",
            "\1\u0166",
            "\1\u0167",
            "\1\u0168",
            "",
            "",
            "\1\u0169",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u016b",
            "\1\u016c",
            "",
            "\1\u016d",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0171",
            "",
            "\1\u0172",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "",
            "\1\u0175",
            "\1\u0176",
            "",
            "",
            "\1\u0177",
            "\1\u0178",
            "\1\u0179",
            "\1\u017a",
            "\1\u017b",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | MULTILINE_COMMENT | BACKSLASH | INTEGER | FLOAT | I | YEAR | MONTH | MONTH_CONST | PASTMONTH | RANGE | TAFCFS | DAYSIN | SUM | MAX | MIN | INT | ABS | LOG | LOG10 | POW | MOD | WHERE | CONSTRAIN | ALWAYS | NAME | DVAR | CYCLE | FILE | CONDITION | INCLUDE | LOWERBOUND | UPPERBOUND | INTEGERTYPE | UNITS | CONVERTUNITS | TYPE | OUTPUT | CASE | ORDER | EXPRESSION | LHSGTRHS | LHSLTRHS | WEIGHT | FUNCTION | FROM_WRESL_FILE | SVAR | IDENT | IDENT1 | IDENT2 | WS | COMMENT );";
        }
    }
 

}