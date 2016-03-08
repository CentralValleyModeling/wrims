package gov.ca.dwr.jdiagram;

import java.util.ArrayList;

import com.mindfusion.diagramming.Diagram;
import com.mindfusion.diagramming.DiagramItem;
import com.mindfusion.pdf.PageSizesEnum;

public class SchematicPluginCore {
	public static String[] _twSelections = { "OCT1921 - SEP2009","OCT1921 - SEP2003",
		"OCT1928 - SEP1934","OCT1986 - SEP1992","OCT1975 - SEP1977",
		"OCT1976 - SEP1977","OCT1994 - SEP2003","OCT2000 - SEP2009", 
		"OCT1997 - SEP2007"};
	
	public static String selDate="";
	
	public static int selIndex=-1;
	
	public static boolean showMagnifier=false;
	
	public static boolean zoomToRect=false;
	
	public static PageSizesEnum pageSize;
	
	public static ArrayList<DiagramItem> copiedItems = new ArrayList<DiagramItem>();
	
	public static Diagram copyDiagram = null;
}
