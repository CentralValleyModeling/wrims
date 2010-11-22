import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import Parser.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        ParseTableLexer lex = new ParseTableLexer(new ANTLRFileStream("D:\\cvwrsm\\trunk\\wrims_v2\\parser\\src\\test\\main.table", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        ParseTableParser g = new ParseTableParser(tokens, 49100, null);
        try {
            g.evaluator();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}