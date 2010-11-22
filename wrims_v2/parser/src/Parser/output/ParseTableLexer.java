// $ANTLR 3.2 Sep 23, 2009 12:02:23 D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g 2010-11-19 08:10:49

  package Parser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class ParseTableLexer extends Lexer {
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int WHERE=12;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__29=29;
    public static final int T__64=64;
    public static final int T__28=28;
    public static final int T__65=65;
    public static final int T__27=27;
    public static final int T__62=62;
    public static final int T__26=26;
    public static final int T__63=63;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int LETTER=8;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int CFS=13;
    public static final int T__21=21;
    public static final int MAX=10;
    public static final int FLOAT=15;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int MULTILINE_COMMENT=16;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int IDENT1=19;
    public static final int T__54=54;
    public static final int T__59=59;
    public static final int IDENT=5;
    public static final int DIGIT=9;
    public static final int COMMENT=4;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int INTEGER=7;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int MIN=11;
    public static final int TAF=14;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__71=71;
    public static final int WS=20;
    public static final int T__34=34;
    public static final int T__72=72;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__70=70;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int QUOTE_STRING_with_MINUS=18;
    public static final int T__39=39;
    public static final int SYMBOLS=17;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int BACKSLASH=6;

    // delegates
    // delegators

    public ParseTableLexer() {;} 
    public ParseTableLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ParseTableLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g"; }

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:11:7: ( '\\n' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:11:9: '\\n'
            {
            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:12:7: ( '\\r' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:12:9: '\\r'
            {
            match('\r'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:13:7: ( 'cycle' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:13:9: 'cycle'
            {
            match("cycle"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:14:7: ( ',' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:14:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:15:7: ( 'file' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:15:9: 'file'
            {
            match("file"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:16:7: ( 'condition' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:16:9: 'condition'
            {
            match("condition"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:17:7: ( 'include' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:17:9: 'include'
            {
            match("include"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:18:7: ( 'name' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:18:9: 'name'
            {
            match("name"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:19:7: ( 'x-coordinate' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:19:9: 'x-coordinate'
            {
            match("x-coordinate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:20:7: ( 'y-coordinate' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:20:9: 'y-coordinate'
            {
            match("y-coordinate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:21:7: ( 'type' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:21:9: 'type'
            {
            match("type"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:22:7: ( 'positive_error' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:22:9: 'positive_error'
            {
            match("positive_error"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:23:7: ( 'negative_error' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:23:9: 'negative_error'
            {
            match("negative_error"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:24:7: ( 'expression' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:24:9: 'expression'
            {
            match("expression"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:25:7: ( 'units' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:25:9: 'units'
            {
            match("units"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:26:7: ( 'lowerbound' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:26:9: 'lowerbound'
            {
            match("lowerbound"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:27:7: ( 'upperbound' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:27:9: 'upperbound'
            {
            match("upperbound"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:28:7: ( 'startnode' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:28:9: 'startnode'
            {
            match("startnode"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:29:7: ( 'endnode' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:29:9: 'endnode'
            {
            match("endnode"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:30:7: ( 'zone' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:30:9: 'zone'
            {
            match("zone"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:31:7: ( 'zoneinclude' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:31:9: 'zoneinclude'
            {
            match("zoneinclude"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:32:7: ( 'upbound' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:32:9: 'upbound'
            {
            match("upbound"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:33:7: ( 'weight' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:33:9: 'weight'
            {
            match("weight"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:34:7: ( 'integer' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:34:9: 'integer'
            {
            match("integer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:35:7: ( 'writetodss' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:35:9: 'writetodss'
            {
            match("writetodss"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:36:7: ( 'case' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:36:9: 'case'
            {
            match("case"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:37:7: ( 'caseinclude' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:37:9: 'caseinclude'
            {
            match("caseinclude"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:38:7: ( 'lhs>rhs' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:38:9: 'lhs>rhs'
            {
            match("lhs>rhs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:39:7: ( 'lhs<rhs' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:39:9: 'lhs<rhs'
            {
            match("lhs<rhs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:40:7: ( '#' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:40:9: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:41:7: ( 'constrain' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:41:9: 'constrain'
            {
            match("constrain"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "T__52"
    public final void mT__52() throws RecognitionException {
        try {
            int _type = T__52;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:42:7: ( '*taf_cfs' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:42:9: '*taf_cfs'
            {
            match("*taf_cfs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__52"

    // $ANTLR start "T__53"
    public final void mT__53() throws RecognitionException {
        try {
            int _type = T__53;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:43:7: ( ';' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:43:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__53"

    // $ANTLR start "T__54"
    public final void mT__54() throws RecognitionException {
        try {
            int _type = T__54;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:44:7: ( '.' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:44:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__54"

    // $ANTLR start "T__55"
    public final void mT__55() throws RecognitionException {
        try {
            int _type = T__55;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:45:7: ( '|' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:45:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__55"

    // $ANTLR start "T__56"
    public final void mT__56() throws RecognitionException {
        try {
            int _type = T__56;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:46:7: ( '-' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:46:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__56"

    // $ANTLR start "T__57"
    public final void mT__57() throws RecognitionException {
        try {
            int _type = T__57;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:47:7: ( '+' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:47:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__57"

    // $ANTLR start "T__58"
    public final void mT__58() throws RecognitionException {
        try {
            int _type = T__58;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:48:7: ( '/' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:48:9: '/'
            {
            match('/'); 

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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:49:7: ( '(' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:49:9: '('
            {
            match('('); 

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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:50:7: ( ')' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:50:9: ')'
            {
            match(')'); 

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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:51:7: ( 'timeseries' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:51:9: 'timeseries'
            {
            match("timeseries"); 


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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:52:7: ( 'kind' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:52:9: 'kind'
            {
            match("kind"); 


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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:53:7: ( '=' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:53:9: '='
            {
            match('='); 

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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:54:7: ( 'select' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:54:9: 'select'
            {
            match("select"); 


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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:55:7: ( 'from' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:55:9: 'from'
            {
            match("from"); 


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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:56:7: ( 'given' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:56:9: 'given'
            {
            match("given"); 


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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:57:7: ( 'use' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:57:9: 'use'
            {
            match("use"); 


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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:58:7: ( '&' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:58:9: '&'
            {
            match('&'); 

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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:59:7: ( '*' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:59:9: '*'
            {
            match('*'); 

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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:60:7: ( 'mod' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:60:9: 'mod'
            {
            match("mod"); 


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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:61:7: ( '<' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:61:9: '<'
            {
            match('<'); 

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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:62:7: ( '>' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:62:9: '>'
            {
            match('>'); 

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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:63:7: ( 'always' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:63:9: 'always'
            {
            match("always"); 


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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:64:7: ( '&&' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:64:9: '&&'
            {
            match("&&"); 


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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:65:7: ( '||' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:65:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__75"

    // $ANTLR start "MULTILINE_COMMENT"
    public final void mMULTILINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTILINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1225:19: ( '/*' ( . )* '*/' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1225:21: '/*' ( . )* '*/'
            {
            match("/*"); 

            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1225:26: ( . )*
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
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1225:26: .
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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1227:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1227:19: ( 'a' .. 'z' | 'A' .. 'Z' )
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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1228:16: ( '0' .. '9' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1228:18: '0' .. '9'
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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1229:18: ( '_' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1229:20: '_'
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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1231:11: ( '\\\\' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1231:13: '\\\\'
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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1233:9: ( ( DIGIT )+ )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1233:11: ( DIGIT )+
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1233:11: ( DIGIT )+
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
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1233:11: DIGIT
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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1234:7: ( ( INTEGER )? '.' INTEGER | INTEGER '.' )
            int alt4=2;
            alt4 = dfa4.predict(input);
            switch (alt4) {
                case 1 :
                    // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1234:9: ( INTEGER )? '.' INTEGER
                    {
                    // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1234:9: ( INTEGER )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1234:9: INTEGER
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
                    // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1235:6: INTEGER '.'
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

    // $ANTLR start "TAF"
    public final void mTAF() throws RecognitionException {
        try {
            int _type = TAF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1239:5: ( 'taf' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1239:7: 'taf'
            {
            match("taf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TAF"

    // $ANTLR start "CFS"
    public final void mCFS() throws RecognitionException {
        try {
            int _type = CFS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1240:5: ( 'cfs' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1240:7: 'cfs'
            {
            match("cfs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CFS"

    // $ANTLR start "MAX"
    public final void mMAX() throws RecognitionException {
        try {
            int _type = MAX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1241:5: ( 'max' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1241:7: 'max'
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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1242:5: ( 'min' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1242:7: 'min'
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

    // $ANTLR start "WHERE"
    public final void mWHERE() throws RecognitionException {
        try {
            int _type = WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1243:7: ( 'where' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1243:9: 'where'
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

    // $ANTLR start "QUOTE_STRING_with_MINUS"
    public final void mQUOTE_STRING_with_MINUS() throws RecognitionException {
        try {
            int _type = QUOTE_STRING_with_MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1245:25: ( '\\'' IDENT ( '-' | IDENT )+ '\\'' )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1245:27: '\\'' IDENT ( '-' | IDENT )+ '\\''
            {
            match('\''); 
            mIDENT(); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1245:38: ( '-' | IDENT )+
            int cnt5=0;
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='-') ) {
                    alt5=1;
                }
                else if ( ((LA5_0>='A' && LA5_0<='Z')||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1245:40: '-'
            	    {
            	    match('-'); 

            	    }
            	    break;
            	case 2 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1245:46: IDENT
            	    {
            	    mIDENT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QUOTE_STRING_with_MINUS"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1246:7: ( LETTER ( LETTER | DIGIT | SYMBOLS )* )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1246:9: LETTER ( LETTER | DIGIT | SYMBOLS )*
            {
            mLETTER(); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1246:16: ( LETTER | DIGIT | SYMBOLS )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')||(LA6_0>='A' && LA6_0<='Z')||LA6_0=='_'||(LA6_0>='a' && LA6_0<='z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:
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
            	    break loop6;
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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1247:8: ( DIGIT ( LETTER | DIGIT | SYMBOLS )* )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1247:10: DIGIT ( LETTER | DIGIT | SYMBOLS )*
            {
            mDIGIT(); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1247:16: ( LETTER | DIGIT | SYMBOLS )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')||(LA7_0>='A' && LA7_0<='Z')||LA7_0=='_'||(LA7_0>='a' && LA7_0<='z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:
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
            	    break loop7;
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

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1249:4: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1249:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1249:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\t' && LA8_0<='\n')||(LA8_0>='\f' && LA8_0<='\r')||LA8_0==' ') ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:
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
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
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
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1250:9: ( '!' ( . )* ( '\\n' | '\\r' ) )
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1250:11: '!' ( . )* ( '\\n' | '\\r' )
            {
            match('!'); 
            // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1250:15: ( . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                    alt9=2;
                }
                else if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1250:15: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
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
        // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:8: ( T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | MULTILINE_COMMENT | BACKSLASH | INTEGER | FLOAT | TAF | CFS | MAX | MIN | WHERE | QUOTE_STRING_with_MINUS | IDENT | IDENT1 | WS | COMMENT )
        int alt10=69;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:10: T__21
                {
                mT__21(); 

                }
                break;
            case 2 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:16: T__22
                {
                mT__22(); 

                }
                break;
            case 3 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:22: T__23
                {
                mT__23(); 

                }
                break;
            case 4 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:28: T__24
                {
                mT__24(); 

                }
                break;
            case 5 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:34: T__25
                {
                mT__25(); 

                }
                break;
            case 6 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:40: T__26
                {
                mT__26(); 

                }
                break;
            case 7 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:46: T__27
                {
                mT__27(); 

                }
                break;
            case 8 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:52: T__28
                {
                mT__28(); 

                }
                break;
            case 9 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:58: T__29
                {
                mT__29(); 

                }
                break;
            case 10 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:64: T__30
                {
                mT__30(); 

                }
                break;
            case 11 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:70: T__31
                {
                mT__31(); 

                }
                break;
            case 12 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:76: T__32
                {
                mT__32(); 

                }
                break;
            case 13 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:82: T__33
                {
                mT__33(); 

                }
                break;
            case 14 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:88: T__34
                {
                mT__34(); 

                }
                break;
            case 15 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:94: T__35
                {
                mT__35(); 

                }
                break;
            case 16 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:100: T__36
                {
                mT__36(); 

                }
                break;
            case 17 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:106: T__37
                {
                mT__37(); 

                }
                break;
            case 18 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:112: T__38
                {
                mT__38(); 

                }
                break;
            case 19 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:118: T__39
                {
                mT__39(); 

                }
                break;
            case 20 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:124: T__40
                {
                mT__40(); 

                }
                break;
            case 21 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:130: T__41
                {
                mT__41(); 

                }
                break;
            case 22 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:136: T__42
                {
                mT__42(); 

                }
                break;
            case 23 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:142: T__43
                {
                mT__43(); 

                }
                break;
            case 24 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:148: T__44
                {
                mT__44(); 

                }
                break;
            case 25 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:154: T__45
                {
                mT__45(); 

                }
                break;
            case 26 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:160: T__46
                {
                mT__46(); 

                }
                break;
            case 27 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:166: T__47
                {
                mT__47(); 

                }
                break;
            case 28 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:172: T__48
                {
                mT__48(); 

                }
                break;
            case 29 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:178: T__49
                {
                mT__49(); 

                }
                break;
            case 30 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:184: T__50
                {
                mT__50(); 

                }
                break;
            case 31 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:190: T__51
                {
                mT__51(); 

                }
                break;
            case 32 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:196: T__52
                {
                mT__52(); 

                }
                break;
            case 33 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:202: T__53
                {
                mT__53(); 

                }
                break;
            case 34 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:208: T__54
                {
                mT__54(); 

                }
                break;
            case 35 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:214: T__55
                {
                mT__55(); 

                }
                break;
            case 36 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:220: T__56
                {
                mT__56(); 

                }
                break;
            case 37 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:226: T__57
                {
                mT__57(); 

                }
                break;
            case 38 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:232: T__58
                {
                mT__58(); 

                }
                break;
            case 39 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:238: T__59
                {
                mT__59(); 

                }
                break;
            case 40 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:244: T__60
                {
                mT__60(); 

                }
                break;
            case 41 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:250: T__61
                {
                mT__61(); 

                }
                break;
            case 42 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:256: T__62
                {
                mT__62(); 

                }
                break;
            case 43 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:262: T__63
                {
                mT__63(); 

                }
                break;
            case 44 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:268: T__64
                {
                mT__64(); 

                }
                break;
            case 45 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:274: T__65
                {
                mT__65(); 

                }
                break;
            case 46 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:280: T__66
                {
                mT__66(); 

                }
                break;
            case 47 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:286: T__67
                {
                mT__67(); 

                }
                break;
            case 48 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:292: T__68
                {
                mT__68(); 

                }
                break;
            case 49 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:298: T__69
                {
                mT__69(); 

                }
                break;
            case 50 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:304: T__70
                {
                mT__70(); 

                }
                break;
            case 51 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:310: T__71
                {
                mT__71(); 

                }
                break;
            case 52 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:316: T__72
                {
                mT__72(); 

                }
                break;
            case 53 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:322: T__73
                {
                mT__73(); 

                }
                break;
            case 54 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:328: T__74
                {
                mT__74(); 

                }
                break;
            case 55 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:334: T__75
                {
                mT__75(); 

                }
                break;
            case 56 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:340: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;
            case 57 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:358: BACKSLASH
                {
                mBACKSLASH(); 

                }
                break;
            case 58 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:368: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 59 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:376: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 60 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:382: TAF
                {
                mTAF(); 

                }
                break;
            case 61 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:386: CFS
                {
                mCFS(); 

                }
                break;
            case 62 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:390: MAX
                {
                mMAX(); 

                }
                break;
            case 63 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:394: MIN
                {
                mMIN(); 

                }
                break;
            case 64 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:398: WHERE
                {
                mWHERE(); 

                }
                break;
            case 65 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:404: QUOTE_STRING_with_MINUS
                {
                mQUOTE_STRING_with_MINUS(); 

                }
                break;
            case 66 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:428: IDENT
                {
                mIDENT(); 

                }
                break;
            case 67 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:434: IDENT1
                {
                mIDENT1(); 

                }
                break;
            case 68 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:441: WS
                {
                mWS(); 

                }
                break;
            case 69 :
                // D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\Parser\\ParseTable.g:1:444: COMMENT
                {
                mCOMMENT(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA10 dfa10 = new DFA10(this);
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
            return "1234:1: FLOAT : ( ( INTEGER )? '.' INTEGER | INTEGER '.' );";
        }
    }
    static final String DFA10_eotS =
        "\1\uffff\1\52\1\53\1\47\1\uffff\15\47\1\uffff\1\111\1\uffff\1\112"+
        "\1\115\2\uffff\1\117\2\uffff\1\47\1\uffff\1\47\1\123\1\47\2\uffff"+
        "\1\47\1\uffff\1\130\6\uffff\11\47\2\uffff\21\47\10\uffff\2\47\2"+
        "\uffff\4\47\1\uffff\1\130\1\uffff\3\47\1\u0081\10\47\1\u008a\6\47"+
        "\1\u0091\12\47\1\u009d\1\u009e\1\u009f\4\47\1\u00a5\1\uffff\1\u00a6"+
        "\1\u00a7\2\47\1\u00aa\1\47\1\u00ac\1\47\1\uffff\6\47\1\uffff\1\47"+
        "\2\uffff\2\47\1\u00b8\3\47\1\u00bc\1\47\3\uffff\1\47\1\u00bf\3\47"+
        "\3\uffff\2\47\1\uffff\1\47\1\uffff\4\47\1\u00ca\6\47\1\uffff\2\47"+
        "\1\u00d3\1\uffff\1\u00d4\1\47\1\uffff\12\47\1\uffff\4\47\1\u00e4"+
        "\1\47\1\u00e6\1\47\2\uffff\1\u00e8\3\47\1\u00ec\1\u00ed\4\47\1\u00f2"+
        "\1\47\1\u00f4\2\47\1\uffff\1\47\1\uffff\1\47\1\uffff\3\47\2\uffff"+
        "\4\47\1\uffff\1\47\1\uffff\4\47\1\u0105\1\u0106\7\47\1\u010e\2\47"+
        "\2\uffff\2\47\1\u0113\1\47\1\u0115\1\u0116\1\u0117\1\uffff\1\47"+
        "\1\u0119\1\u011a\1\47\1\uffff\1\47\3\uffff\1\u011d\2\uffff\2\47"+
        "\1\uffff\2\47\1\u0122\1\u0123\2\uffff";
    static final String DFA10_eofS =
        "\u0124\uffff";
    static final String DFA10_minS =
        "\3\11\1\141\1\uffff\1\151\1\156\1\141\2\55\1\141\1\157\2\156\1"+
        "\150\1\145\1\157\1\145\1\uffff\1\164\1\uffff\1\60\1\174\2\uffff"+
        "\1\52\2\uffff\1\151\1\uffff\1\151\1\46\1\141\2\uffff\1\154\1\uffff"+
        "\1\56\6\uffff\1\143\1\156\2\163\1\154\1\157\1\143\1\155\1\147\2"+
        "\uffff\1\160\1\155\1\146\1\163\1\160\1\144\1\151\1\142\1\145\1\167"+
        "\1\163\1\141\1\154\1\156\2\151\1\145\10\uffff\1\156\1\166\2\uffff"+
        "\1\144\1\170\1\156\1\167\1\uffff\1\56\1\uffff\1\154\1\144\1\145"+
        "\1\60\1\145\1\155\1\154\2\145\1\141\2\145\1\60\1\151\1\162\1\156"+
        "\1\164\1\145\1\157\1\60\1\145\1\74\1\162\2\145\1\147\1\164\1\162"+
        "\1\144\1\145\3\60\1\141\1\145\1\151\1\164\1\60\1\uffff\2\60\1\165"+
        "\1\147\1\60\1\164\1\60\1\163\1\uffff\1\164\1\145\1\157\1\163\1\162"+
        "\1\165\1\uffff\1\162\2\uffff\1\164\1\143\1\60\1\150\2\145\1\60\1"+
        "\156\3\uffff\1\171\1\60\1\164\1\162\1\156\3\uffff\1\144\1\145\1"+
        "\uffff\1\151\1\uffff\1\145\1\151\1\163\1\144\1\60\1\142\1\156\1"+
        "\142\1\156\1\164\1\156\1\uffff\2\164\1\60\1\uffff\1\60\1\163\1\uffff"+
        "\1\151\1\141\1\143\1\145\1\162\1\166\1\162\1\166\1\163\1\145\1\uffff"+
        "\1\157\1\144\2\157\1\60\1\143\1\60\1\157\2\uffff\1\60\1\157\1\151"+
        "\1\154\2\60\1\145\1\151\1\145\1\151\1\60\1\165\1\60\1\165\1\144"+
        "\1\uffff\1\154\1\uffff\1\144\1\uffff\2\156\1\165\2\uffff\1\137\1"+
        "\145\1\137\1\157\1\uffff\1\156\1\uffff\1\156\1\145\1\165\1\163\2"+
        "\60\1\144\1\145\1\163\1\145\1\156\2\144\1\60\1\144\1\163\2\uffff"+
        "\1\145\1\162\1\60\1\162\3\60\1\uffff\1\145\2\60\1\162\1\uffff\1"+
        "\162\3\uffff\1\60\2\uffff\2\157\1\uffff\2\162\2\60\2\uffff";
    static final String DFA10_maxS =
        "\1\174\2\40\1\171\1\uffff\1\162\1\156\1\145\2\55\1\171\1\157\1"+
        "\170\1\163\1\157\1\164\1\157\1\162\1\uffff\1\164\1\uffff\1\71\1"+
        "\174\2\uffff\1\52\2\uffff\1\151\1\uffff\1\151\1\46\1\157\2\uffff"+
        "\1\154\1\uffff\1\172\6\uffff\1\143\1\156\2\163\1\154\1\157\1\164"+
        "\1\155\1\147\2\uffff\1\160\1\155\1\146\1\163\1\160\1\144\1\151\1"+
        "\160\1\145\1\167\1\163\1\141\1\154\1\156\2\151\1\145\10\uffff\1"+
        "\156\1\166\2\uffff\1\144\1\170\1\156\1\167\1\uffff\1\172\1\uffff"+
        "\1\154\1\163\1\145\1\172\1\145\1\155\1\154\2\145\1\141\2\145\1\172"+
        "\1\151\1\162\1\156\1\164\1\145\1\157\1\172\1\145\1\76\1\162\2\145"+
        "\1\147\1\164\1\162\1\144\1\145\3\172\1\141\1\145\1\151\1\164\1\172"+
        "\1\uffff\2\172\1\165\1\147\1\172\1\164\1\172\1\163\1\uffff\1\164"+
        "\1\145\1\157\1\163\1\162\1\165\1\uffff\1\162\2\uffff\1\164\1\143"+
        "\1\172\1\150\2\145\1\172\1\156\3\uffff\1\171\1\172\1\164\1\162\1"+
        "\156\3\uffff\1\144\1\145\1\uffff\1\151\1\uffff\1\145\1\151\1\163"+
        "\1\144\1\172\1\142\1\156\1\142\1\156\1\164\1\156\1\uffff\2\164\1"+
        "\172\1\uffff\1\172\1\163\1\uffff\1\151\1\141\1\143\1\145\1\162\1"+
        "\166\1\162\1\166\1\163\1\145\1\uffff\1\157\1\144\2\157\1\172\1\143"+
        "\1\172\1\157\2\uffff\1\172\1\157\1\151\1\154\2\172\1\145\1\151\1"+
        "\145\1\151\1\172\1\165\1\172\1\165\1\144\1\uffff\1\154\1\uffff\1"+
        "\144\1\uffff\2\156\1\165\2\uffff\1\137\1\145\1\137\1\157\1\uffff"+
        "\1\156\1\uffff\1\156\1\145\1\165\1\163\2\172\1\144\1\145\1\163\1"+
        "\145\1\156\2\144\1\172\1\144\1\163\2\uffff\1\145\1\162\1\172\1\162"+
        "\3\172\1\uffff\1\145\2\172\1\162\1\uffff\1\162\3\uffff\1\172\2\uffff"+
        "\2\157\1\uffff\2\162\2\172\2\uffff";
    static final String DFA10_acceptS =
        "\4\uffff\1\4\15\uffff\1\36\1\uffff\1\41\2\uffff\1\44\1\45\1\uffff"+
        "\1\47\1\50\1\uffff\1\53\3\uffff\1\63\1\64\1\uffff\1\71\1\uffff\1"+
        "\101\1\102\1\104\1\105\1\1\1\2\11\uffff\1\11\1\12\21\uffff\1\40"+
        "\1\61\1\42\1\73\1\67\1\43\1\70\1\46\2\uffff\1\66\1\60\4\uffff\1"+
        "\72\1\uffff\1\103\46\uffff\1\75\10\uffff\1\74\6\uffff\1\57\1\uffff"+
        "\1\34\1\35\10\uffff\1\62\1\76\1\77\5\uffff\1\32\1\5\1\55\2\uffff"+
        "\1\10\1\uffff\1\13\13\uffff\1\24\3\uffff\1\52\2\uffff\1\3\12\uffff"+
        "\1\17\10\uffff\1\100\1\56\17\uffff\1\54\1\uffff\1\27\1\uffff\1\65"+
        "\3\uffff\1\7\1\30\4\uffff\1\23\1\uffff\1\26\20\uffff\1\6\1\37\7"+
        "\uffff\1\22\4\uffff\1\51\1\uffff\1\16\1\21\1\20\1\uffff\1\31\1\33"+
        "\2\uffff\1\25\4\uffff\1\15\1\14";
    static final String DFA10_specialS =
        "\u0124\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\50\1\1\1\uffff\1\50\1\2\22\uffff\1\50\1\51\1\uffff\1\22"+
            "\2\uffff\1\37\1\46\1\32\1\33\1\23\1\30\1\4\1\27\1\25\1\31\12"+
            "\45\1\uffff\1\24\1\41\1\35\1\42\2\uffff\32\47\1\uffff\1\44\4"+
            "\uffff\1\43\1\47\1\3\1\47\1\14\1\5\1\36\1\47\1\6\1\47\1\34\1"+
            "\16\1\40\1\7\1\47\1\13\2\47\1\17\1\12\1\15\1\47\1\21\1\10\1"+
            "\11\1\20\1\uffff\1\26",
            "\2\50\1\uffff\2\50\22\uffff\1\50",
            "\2\50\1\uffff\2\50\22\uffff\1\50",
            "\1\56\4\uffff\1\57\10\uffff\1\55\11\uffff\1\54",
            "",
            "\1\60\10\uffff\1\61",
            "\1\62",
            "\1\63\3\uffff\1\64",
            "\1\65",
            "\1\66",
            "\1\71\7\uffff\1\70\17\uffff\1\67",
            "\1\72",
            "\1\74\11\uffff\1\73",
            "\1\75\1\uffff\1\76\2\uffff\1\77",
            "\1\101\6\uffff\1\100",
            "\1\103\16\uffff\1\102",
            "\1\104",
            "\1\105\2\uffff\1\107\11\uffff\1\106",
            "",
            "\1\110",
            "",
            "\12\113",
            "\1\114",
            "",
            "",
            "\1\116",
            "",
            "",
            "\1\120",
            "",
            "\1\121",
            "\1\122",
            "\1\125\7\uffff\1\126\5\uffff\1\124",
            "",
            "",
            "\1\127",
            "",
            "\1\113\1\uffff\12\131\7\uffff\32\132\4\uffff\1\132\1\uffff"+
            "\32\132",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141\20\uffff\1\142",
            "\1\143",
            "\1\144",
            "",
            "",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\155\15\uffff\1\154",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\167",
            "\1\170",
            "",
            "",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "",
            "\1\113\1\uffff\12\131\7\uffff\32\132\4\uffff\1\132\1\uffff"+
            "\32\132",
            "",
            "\1\175",
            "\1\176\16\uffff\1\177",
            "\1\u0080",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0092",
            "\1\u0094\1\uffff\1\u0093",
            "\1\u0095",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\10\47\1\u00a4\21"+
            "\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00a8",
            "\1\u00a9",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00ab",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00ad",
            "",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "",
            "\1\u00b4",
            "",
            "",
            "\1\u00b5",
            "\1\u00b6",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\10\47\1\u00b7\21"+
            "\47",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00bd",
            "",
            "",
            "",
            "\1\u00be",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00c0",
            "\1\u00c1",
            "\1\u00c2",
            "",
            "",
            "",
            "\1\u00c3",
            "\1\u00c4",
            "",
            "\1\u00c5",
            "",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "",
            "\1\u00d1",
            "\1\u00d2",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00d5",
            "",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "",
            "\1\u00e0",
            "\1\u00e1",
            "\1\u00e2",
            "\1\u00e3",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00e5",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00e7",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00f3",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00f5",
            "\1\u00f6",
            "",
            "\1\u00f7",
            "",
            "\1\u00f8",
            "",
            "\1\u00f9",
            "\1\u00fa",
            "\1\u00fb",
            "",
            "",
            "\1\u00fc",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "",
            "\1\u0100",
            "",
            "\1\u0101",
            "\1\u0102",
            "\1\u0103",
            "\1\u0104",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0107",
            "\1\u0108",
            "\1\u0109",
            "\1\u010a",
            "\1\u010b",
            "\1\u010c",
            "\1\u010d",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u010f",
            "\1\u0110",
            "",
            "",
            "\1\u0111",
            "\1\u0112",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0114",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\1\u0118",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u011b",
            "",
            "\1\u011c",
            "",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "\1\u011e",
            "\1\u011f",
            "",
            "\1\u0120",
            "\1\u0121",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | T__52 | T__53 | T__54 | T__55 | T__56 | T__57 | T__58 | T__59 | T__60 | T__61 | T__62 | T__63 | T__64 | T__65 | T__66 | T__67 | T__68 | T__69 | T__70 | T__71 | T__72 | T__73 | T__74 | T__75 | MULTILINE_COMMENT | BACKSLASH | INTEGER | FLOAT | TAF | CFS | MAX | MIN | WHERE | QUOTE_STRING_with_MINUS | IDENT | IDENT1 | WS | COMMENT );";
        }
    }
 

}