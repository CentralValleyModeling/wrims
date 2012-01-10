package wrims.schematic.jdiagram;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Float;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;
import com.mindfusion.diagramming.Diagram;
import com.mindfusion.diagramming.RenderOptions;

public class PDFiTextExporter {
	public PDFiTextExporter() {
	}

	public static void export(Diagram diagram, String filePath)
			throws Exception {

		Document document = new Document();
		Float bounds = diagram.getBounds();
		Rectangle pageSize = new Rectangle(bounds.x, bounds.y, bounds.width,
				bounds.height);
		document.setPageSize(pageSize);
		document.addCreationDate();
		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream(filePath));
		document.open();
		//
		document.newPage();
		RenderOptions renderOptions = new RenderOptions();
		renderOptions.setVisibleRect(bounds);
		PdfContentByte cb = writer.getDirectContent();
		Graphics2D graphics2D = cb.createGraphics(bounds.width, bounds.height);
		Rectangle2D r2d2 = new Rectangle2D.Double(bounds.x, bounds.y, bounds.width, bounds.height);
		diagram.draw(graphics2D, renderOptions, r2d2);
		graphics2D.dispose();
		document.close();
	}
}