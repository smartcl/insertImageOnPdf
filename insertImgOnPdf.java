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

public class insertImgOnPdf {
	insertImgOnPdf() {}

	public static insertImgOnPdf init() {
    	insertImgOnPdf obj = new insertImgOnPdf();
    	return obj;
  	}

    // public static void main(String[] args) throws DocumentException, IOException {
    //     insertImage("example/res.pdf", "example/1.pdf", "example/title.png", 330, 40, 200, 200);
    // }

    public static void insertImage(String output, String input, String img_file, int position_x, int position_y, int size_x, int size_y) throws DocumentException, IOException {
    	// 要输出的pdf文件
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(output)));
        // 将pdf文件先加水印然后输出
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
}