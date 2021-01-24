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
 * Resume class for creating a resume in pdf format through java code.
 */
public class Resume {

    private String georgia = "./fonts/Georgia.ttf";
    private String georgiaBold = "./fonts/GeorgiaBold.ttf";
    private String calibri = "./fonts/Calibri.ttf";
    private String calibriBold = "./fonts/CalibriBold.ttf";

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

        //creating PdfFonts object to use the font we've downloaded for our project.
        PdfFont geo = PdfFontFactory.createFont(georgia, true);
        PdfFont geoBold = PdfFontFactory.createFont(georgiaBold, true);
        PdfFont clibri = PdfFontFactory.createFont(calibri, true);
        PdfFont clibriBold = PdfFontFactory.createFont(calibriBold, true);

        //creating a custom color according to our need.
        Color myColor = new DeviceRgb(89, 89, 89);
        

        Paragraph title = new Paragraph();
        title.setMultipliedLeading(0.8f);

        //Creating and customizing the text to add in Paragraph.       
        System.out.println("Enter your First Name");
        String fName = scanner.nextLine().trim().toUpperCase();
       
        Text firstName = new Text(fName);
        firstName.setFont(geo);
        firstName.setFontSize(35);
        firstName.setFontColor(myColor);

        Text whiteSpace = new Text(" ");
        whiteSpace.setFontSize(35);

        System.out.println("Enter Your Last Name");
        String lName = scanner.nextLine().trim().toUpperCase();

        Text lastName = new Text(lName);
        lastName.setFont(geoBold);
        lastName.setFontSize(35);

        //adding text to paragraph.
        title.add(firstName);
        title.add(whiteSpace);
        title.add(lastName);
        
        //Creating and customizing the text to add in Paragraph.       
        System.out.println("Enter your Adress");
        String addressMeta = scanner.nextLine().trim();
        String address = addressMeta.substring(0, 1).toUpperCase() + addressMeta.substring(1);

        Text userAdress = new Text(address);
        userAdress.setFontSize(11);
        userAdress.setFont(clibri);
        userAdress.setFontColor(myColor);

        Text seperator = new Text(" | ");
        seperator.setFontSize(16);
        seperator.setFont(clibri);
        seperator.setFontColor(myColor);

        Text sampleLine = new Text("\n");

        System.out.println("Enter your Phone Number");
        String phone = scanner.nextLine().trim();

        Text userPhone = new Text(phone);
        userPhone.setFontSize(11);
        userPhone.setFont(clibri);
        userPhone.setFontColor(myColor);

        title.add(sampleLine);
        title.add(userAdress);
        title.add(seperator);
        title.add(userPhone);

        Color socialHandles = new DeviceRgb(29, 130, 76);

        Text socialSeperator = new Text(" | ");
        socialSeperator.setFontSize(16);
        socialSeperator.setFont(clibriBold);
        socialSeperator.setFontColor(socialHandles);


        System.out.println("Enter your Email");
        String email = scanner.nextLine().trim();
        
        Text userEmail = new Text(email);
        userEmail.setFontSize(11);
        userEmail.setFont(clibriBold);
        userEmail.setFontColor(socialHandles);

        System.out.println("Enter your GitHub Username");
        String gitHub = scanner.nextLine().trim();

        Text gitHubUsername = new Text(gitHub);
        gitHubUsername.setFontSize(11);
        gitHubUsername.setFont(clibriBold);
        gitHubUsername.setFontColor(socialHandles);

        System.out.println("Enter your Twitter Username");
        String twitter = scanner.nextLine().trim();

        Text twitterUsername = new Text(twitter);
        twitterUsername.setFontSize(11);
        twitterUsername.setFont(clibriBold);
        twitterUsername.setFontColor(socialHandles);

        title.add(sampleLine);
        title.add(userEmail);
        title.add(socialSeperator);
        title.add(gitHubUsername);
        title.add(socialSeperator);
        title.add(twitterUsername);


        title.setTextAlignment(TextAlignment.CENTER);



        //initializing the pdf document object.
        Document document = new Document(pdfDocument);
        
        //adding paragraph to document.
        document.add(title);
        
        document.close();
        scanner.close();
    }
    
}