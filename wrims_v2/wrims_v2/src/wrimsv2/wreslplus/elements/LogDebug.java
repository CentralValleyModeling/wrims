package wrimsv2.wreslplus.elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.commons.io.FilenameUtils;

import wrimsv2.commondata.wresldata.Param;

public class LogDebug {
		
	private LogDebug(){}
	
	public static void writeMainWreslLog( StudyTemp st, String canonicalMainFilePath) {
		
		String f = FilenameUtils.removeExtension(canonicalMainFilePath) + ".de";
		PrintWriter p = null;
		try {
			p = new PrintWriter(new BufferedWriter(new FileWriter(f)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		writeSequence(st, p);
		
		p.flush();
		
	}
	
//	private static void writeModel( StudyTemp st, PrintWriter p) {
//		
//		p.println("begin model");
//		for (String s: st.modelList){
//			p.println(s);
//			p.print("\tf:"+st.modelMap.get(s).);
//			if (st.seqMap.get(s).condition!=Param.always) p.print("\tc:"+st.seqMap.get(s).condition);
//			p.print("\tm:"+st.seqMap.get(s).model);
//			p.print("\to:"+st.seqMap.get(s).order);
//			if (st.seqMap.get(s).timeStep!=Param.undefined) p.print("\tt:"+st.seqMap.get(s).timeStep);
//			p.println();
//		}
//		p.println("end model");		
//		
//	}
	
	private static void writeSequence( StudyTemp st, PrintWriter p) {
		
		p.println("begin sequence");
		for (String s: st.seqList){
			p.println(s);
			if (st.seqMap.get(s).condition!=Param.always) p.print("\tc:"+st.seqMap.get(s).condition);
			p.print("\tm:"+st.seqMap.get(s).model);
			p.print("\to:"+st.seqMap.get(s).order);
			if (st.seqMap.get(s).timeStep!=Param.undefined) p.print("\tt:"+st.seqMap.get(s).timeStep);
			p.println();
		}
		p.println("end sequence");		
		
	}
}
