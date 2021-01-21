import java.util.Scanner;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

public class App {
    
    public static final String georgia = "./fonts/Georgia.ttf";
    public static final String georgiaItalic = "./fonts/GeorgiaItalic.ttf";
    public static final String georgiaBold = "./fonts/GeorgiaBold.ttf";
    public static final String georgiaBoldItalic = "./fonts/GeorgiaBoldItalic.ttf";

    public static void main(String[] args) throws Exception {

        PdfFont geo = PdfFontFactory.createFont(georgia, true);
        PdfFont geoBold = PdfFontFactory.createFont(georgiaBold, true);
        PdfFont geoItalic = PdfFontFactory.createFont(georgiaItalic, true);
        PdfFont geoBoldItalic = PdfFontFactory.createFont(georgiaBoldItalic, true);

        System.out.println("Hello, World!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a valid file name: ");
        String fileName = scanner.nextLine().trim();
        
        String path = "./media/"+ fileName +".pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.addNewPage();

        String text = "Hello World!";
        Paragraph paragraph = new Paragraph(text);

        Text text1 = new Text("Sample Text 1").setFont(geo);
        Text text2 = new Text("Sample Text 2").setFont(geoBold);
        Text text3 = new Text("Sample Text 3").setFont(geoItalic);
        Text text4 = new Text("Sample Text 4").setFont(geoBoldItalic);

        Paragraph paragraph2 = new Paragraph()
        .add(text1)
        .add(text2)
        .add(text3)
        .add(text4);

        Document document = new Document(pdfDocument);
        document.add(paragraph);
        document.add(paragraph2);
        document.close();

        
       
        scanner.close();

    }
}