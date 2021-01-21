import java.util.Scanner;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class App {
    public static void main(String[] args) throws Exception {
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
        
        Document document = new Document(pdfDocument);
        document.add(paragraph);
        document.close();
       
        scanner.close();

    }
}