package wrimsv2.components;

import java.io.File;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Versions {
	
	public int getSVN() {

		try {
			//System.out.println(System.getProperty("user.dir"));			
			InputStream inStream = getClass().getClassLoader().getResourceAsStream("version.xml");
			//File inStream = new File("version.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			//Document doc = db.parse(file);
			Document doc = db.parse(inStream);
			doc.getDocumentElement().normalize();
			//System.out.println("Root element " + doc.getDocumentElement().getNodeName());
			NodeList nodeLst = doc.getElementsByTagName("svn_number");
			NodeList svn_number_node = ((Element) nodeLst.item(0)).getChildNodes();
			
				
			try {
				int version_svn_number = Integer.parseInt(svn_number_node.item(0).getNodeValue());	
			
				return version_svn_number;
			} 
			catch (Exception e){
				e.printStackTrace();	
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;	
	}
}