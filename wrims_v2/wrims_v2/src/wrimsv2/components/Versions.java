package wrimsv2.components;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Versions {
	
	private String xmlFileName = "version.xml";
	private Document xmlDocument = null;

	public String getComplete() {
		
		String version_complete = "";
		
		if (xmlDocument == null) setXmlDocument(xmlFileName);
		String version_svn = getTagValue("svn_number");
		String version_main = getTagValue("main");
		String version_status = getTagValue("status").toLowerCase();
		
		version_complete = "v"+version_main+" "+version_status+" (svn:"+version_svn+")";
		return version_complete;
	}
	

	
	public int getSVN() {

		if (xmlDocument == null) setXmlDocument(xmlFileName);
		String svnStr = getTagValue("svn_number");

		try {
			int version_svn_number = Integer.parseInt(svnStr);

			return version_svn_number;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return -99;
	}	

	public String getMainVersion() {

		if (xmlDocument == null) setXmlDocument(xmlFileName);
		
		String version_main = getTagValue("main");
		
		return version_main;
	}

	public String getStatus() {

		if (xmlDocument == null) setXmlDocument(xmlFileName);
		
		String version_status = getTagValue("status");
		
		return version_status;
	}
	
	private void setXmlDocument(String xmlFileName) {

		try {
			//System.out.println(System.getProperty("user.dir"));			
			InputStream inStream = getClass().getClassLoader().getResourceAsStream(xmlFileName);
			//File inStream = new File("version.xml");
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			//Document doc = db.parse(file);
			Document doc = db.parse(inStream);
			doc.getDocumentElement().normalize();
			xmlDocument = doc;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}	
	
	private String getTagValue(String xmlTag) {

		// System.out.println("Root element " +
		// doc.getDocumentElement().getNodeName());
		NodeList nodeLst = xmlDocument.getElementsByTagName(xmlTag);
		String nodeValue = ((Element) nodeLst.item(0)).getChildNodes().item(0).getNodeValue();

		return nodeValue;
	}
}