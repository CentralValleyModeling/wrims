package wrimsv2.wreslplus.elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;

import wrimsv2.commondata.wresldata.Param;

public class CompileLog {
		
	private CompileLog(){}

	public static String createMainWreslLog( StudyTemp st) {
		
		String r = "";
		r=r+doSequence(st);
		r=r+doIncModel(st);
		r=r+doModels(st);

		return r;
	}
	public static String writeLog( String r, String canonicalFilePath) {
		
		String f = FilenameUtils.removeExtension(canonicalFilePath) + ".de";
		PrintWriter p = null;
		try {
			p = new PrintWriter(new BufferedWriter(new FileWriter(f)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		p.print(r);	
		p.flush();
		p.close();
		return r;
	}
	

	public static String createWreslLog( ModelTemp mt ) {
		
		String r = "";
		r=r+doModel(mt);		
		return r;
	}
	
	private static String doModel( ModelTemp mt) {
		
		// use symbol instead of full file path
		
		
		
		String r="";
		
			
			r=r+doDv(mt);
			r=r+doAlias(mt);
			r=r+"------------------\n";
			
			
			r=r+doSvIncFileModel(mt);


		return r;
		
	}
	private static String doModels( StudyTemp st) {
		
		// use symbol instead of full file path
		
		
		
		String r="";
		r=r+"model{\n";
		
		LinkedHashMap<String,Integer> fileMap_reverse = new LinkedHashMap<String, Integer>();
		
		for (String m: st.modelList){
			ModelTemp mt = st.modelMap.get(m);
			r=r+"\t"+m.toLowerCase()+"{\n";
			
			r=r+doDv(mt);
			r=r+doAlias(mt);
			r=r+"------------------\n";
			
			
			r=r+doSvIncFileModel(mt,fileMap_reverse);
			
			r=r+"\t}\n"; //+m.toLowerCase()+"\n";
		}

		r=r+"}\n";	
		return r;
		
	}
	private static String doSvIncFileModel(ModelTemp mt) {		
		
	    String r="";
		for (int i=0; i<mt.itemList.size();i++){
			if (mt.itemTypeList.get(i)==Param.incFileType) {
				
				String f=mt.incFileMap.get(mt.itemList.get(i)).rawPath.toLowerCase();
					r=r+"\t\t@f:" + f +"\n";

			} else if (mt.itemTypeList.get(i)==Param.svType) {
				r=r+"\t\t@s:" + mt.itemList.get(i).toLowerCase()+"\n";
			}
			
		}
		return r;


	}	
	private static String doSvIncFileModel(ModelTemp mt, LinkedHashMap<String,Integer> fileMap_reverse) {		
		
	    String r="";
		for (int i=0; i<mt.itemList.size();i++){
			if (mt.itemTypeList.get(i)==Param.incFileType) {
				String f=mt.incFileMap.get(mt.itemList.get(i)).rawPath.toLowerCase();
				if (fileMap_reverse.keySet().contains(f)) {
					r=r+"\t\t@f"+fileMap_reverse.get(f) +"^\n";
				} else {
					Integer fi = fileMap_reverse.size();
					fileMap_reverse.put(f, fi);
					r=r+"\t\t@f"+fi+":" + f +"\n";
				}

				
			} else if (mt.itemTypeList.get(i)==Param.incModelType) {
				String m = mt.itemList.get(i).toLowerCase();
				r=r+"\t\t@m:" + m.substring(9,m.length())+"\n";
			} else if (mt.itemTypeList.get(i)==Param.svType) {
				r=r+"\t\t@s:" + mt.itemList.get(i).toLowerCase()+"\n";
			}
			
		}
		return r;


	}
	private static String doAlias(ModelTemp mt) {
		String r="";
		for (String d : mt.asList) {
			AliasTemp dt = mt.asMap.get(d);
			r=r+"\t\t@a:" + d;
			r=r+"\te:" + dt.expression.toLowerCase();
			if (dt.kind!=Param.undefined) r=r+"\tk:" + dt.kind.toLowerCase();
			if (dt.units!=Param.undefined) r=r+"\tu:" + dt.units.toLowerCase();
			r=r+"\n";
		}
		return r;
	}
	private static String doSv(ModelTemp mt) {
		String r="";
		for (String d : mt.svList) {
			SvarTemp dt = mt.svMap.get(d);
			r=r+"\t\t@s:" + d;
			r=r+"\tc" + dt.caseName;
			r=r+"\n";
		}
		return r;
	}
	private static String doDv(ModelTemp mt) {
		String r="";
		for (String d : mt.dvList) {
			DvarTemp dt = mt.dvMap.get(d);
			r=r+"\t\t@d:" + d;
			r=r+"\tl:" + dt.lowerBound;
			r=r+"\tu:" + dt.upperBound;
			r=r+"\n";
		}
		return r;

	}
	
	
	
	private static String doIncModel( StudyTemp st) {
		
		String r="";
		// find included groups
		Set<String> includedModels = new LinkedHashSet<String>();

		r=r+"includeModel{\n";
		for (String s: st.modelList){
			includedModels.addAll(st.modelMap.get(s).incModelList);
		}
		
		for (String s: includedModels){
			//p.println("\t"+s);
			r=r+"\t"+s.toLowerCase()+"\n";
		}

	
		r=r+"}\n";
		
		return r;
		
	}
	
	private static String doSequence( StudyTemp st) {
		String r="";
		//ArrayList<String> effectiveModels = new ArrayList<String>();
		
		//p.println("begin sequence");
		r=r+"sequence{\n";
		for (String s: st.seqList){
			//p.println(s);
			//effectiveModels.add(st.seqMap.get(s).model);
			r=r+"\t"+st.seqMap.get(s).model.toLowerCase();
			r=r+"\ts:"+s.toLowerCase();
			if (st.seqMap.get(s).condition!=Param.always) r=r+"\tc:"+st.seqMap.get(s).condition.toLowerCase();
			r=r+"\to:"+st.seqMap.get(s).order;
			if (st.seqMap.get(s).timeStep!=Param.undefined) r=r+"\tt:"+st.seqMap.get(s).timeStep.toLowerCase();
			r=r+"\n";
		}
		r=r+"}\n";	
		return r;
		
	}
}
