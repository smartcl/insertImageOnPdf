import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.AcroFields;

public class editPdf {
	editPdf() {}

	public static editPdf init() {
    	editPdf obj = new editPdf();
    	return obj;
  	}

    // public static void main(String[] args) throws DocumentException, IOException {
    //     insertImage("example/res.pdf", "example/1.pdf", "example/title.png", 330, 40, 200, 200);
    // }

    public static void insertImage(String output, String input, String img_file, int position_x, int position_y, int size_x, int size_y) throws DocumentException, IOException {
    	// destination pdf
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(output)));
        // Add wate mark and output
        setWatermark(bos, input, img_file, 16, position_x, position_y, size_x, size_y);
    }

    private static void setWatermark(BufferedOutputStream bos, String input, String img_file,
    								int permission, int position_x, int position_y, int size_x, int size_y)
    								throws DocumentException, IOException {
        PdfReader reader = new PdfReader(input);
        PdfStamper stamper = new PdfStamper(reader, bos);
        int total = reader.getNumberOfPages() + 1;
        PdfContentByte content;
        PdfGState gs = new PdfGState();
        for (int i = 1; i < total; i++) {
            content = stamper.getOverContent(i);
            gs.setFillOpacity(0.2f);
            content.beginText();
            content.setColorFill(Color.LIGHT_GRAY);
            content.setTextMatrix(70, 200);
            Image image = Image.getInstance(img_file);
            image.setAbsolutePosition(position_x, position_y);
            image.scaleToFit(size_x, size_y);
            content.addImage(image);
            content.setColorFill(Color.BLACK);
            content.endText();
        }
        stamper.close();
    }

    public static void insertFormText(String src, String dest, String[] arr) throws DocumentException, IOException {
        //Add text to form
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(dest)));
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, bos);
        AcroFields form = stamper.getAcroFields();

        for (int i = 0; i < arr.length / 2; i++) {
            String key = arr[i * 2];
            String value = arr[i * 2 + 1];
            form.setField(key, value);
        }
        //if set "true", the form can't be edited
        stamper.setFormFlattening(true);
        stamper.close();
    }
}