package main;

import java.util.Scanner;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;

/**
 * Resume
 */
public class Resume {

    private String georgia = "./fonts/Georgia.ttf";
    private String georgiaBold = "./fonts/GeorgiaBold.ttf";

    public void createResume() throws Exception {
        
        Scanner scanner = new Scanner(System.in);

        //Takes input from its user for the name of the file the user wants to save.
        System.out.print("Enter a valid file name: ");
        String fileName = scanner.nextLine().trim();
        
        //creates a string path with the filename user provided and pass it down to PdfWritter Object from creating the file.
        String path = "./media/"+ fileName +".pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
       
        //then that path provived to PdfDocument object for initializing the pdf.
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        
        //adding a new page for us to work on.
        pdfDocument.addNewPage();

        Paragraph title = new Paragraph();

        //creating PdfFonts object to use the font we've downloaded for our project.
        PdfFont geo = PdfFontFactory.createFont(georgia, true);
        PdfFont geoBold = PdfFontFactory.createFont(georgiaBold, true);

        //creating a custom color according to our need.
        Color myColor = new DeviceRgb(131, 131, 131);
        
        //Creating and customizing the text to add in Paragraph.
       
        System.out.println("Enter your First Name");
        String fName = scanner.nextLine().trim();
       
        Text firstName = new Text(fName);
        firstName.setFont(geo);
        firstName.setFontSize(35);
        firstName.setFontColor(myColor);

        Text whiteSpace = new Text(" ");
        whiteSpace.setFontSize(35);

        System.out.println("Enter Your Last Name");
        String lName = scanner.nextLine().trim();

        Text lastName = new Text(lName);
        lastName.setFont(geoBold);
        lastName.setFontSize(35);


        //adding text to paragraph.
        title.add(firstName);
        title.add(whiteSpace);
        title.add(lastName);

        //setting the allignment.
        title.setTextAlignment(TextAlignment.CENTER);

        //initializing the pdf document object.
        Document document = new Document(pdfDocument);
        
        //adding paragraph to document.
        document.add(title);
        
        document.close();
        scanner.close();
    }
    
}