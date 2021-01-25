package main;

import java.util.Scanner;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
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
        Color socialHandles = new DeviceRgb(29, 130, 76);
        
        // Tile paragraph code Start here ==================================
        
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

        Text header = new Text("_______________________________________________________________________________________");
        header.setFont(clibriBold);

        title.add(sampleLine);
        title.add(userEmail);
        title.add(socialSeperator);
        title.add(gitHubUsername);
        title.add(socialSeperator);
        title.add(twitterUsername);
        title.add(sampleLine);
        title.add(sampleLine);
        title.add(header);


        title.setTextAlignment(TextAlignment.CENTER);
        // Tile paragraph code ended ==============================================================================

        //Objective paragraph started===========================
        Paragraph aboutYourself = new Paragraph();
        aboutYourself.setMultipliedLeading(1.0f);

        System.out.println("Tell us about yourself");
        Text aboutMe = new Text(scanner.nextLine().trim());
        aboutMe.setFont(clibri);
        aboutMe.setFontSize(11);
        aboutMe.setFontColor(myColor);

        aboutYourself.add(sampleLine);
        aboutYourself.add(aboutMe);
        //Objective paragraph ended==============================

        //Experrience or Projects=======================

        Paragraph projects = new Paragraph();
        projects.setMultipliedLeading(1.0f);

        Text projectsHeading = new Text("PROJECTS");
        projectsHeading.setFont(geoBold);
        projectsHeading.setFontSize(14);

        System.out.println("Project Heading 1");
        Text proHead1 = new Text(scanner.nextLine().trim());
        proHead1.setFont(clibriBold);    
        proHead1.setFontSize(13);
        proHead1.setFontColor(socialHandles);

        System.out.println("Project 1 Description");
        Text proDescription1 = new Text(scanner.nextLine().trim());
        proDescription1.setFont(clibriBold);    
        proDescription1.setFontSize(11);
        proDescription1.setFontColor(myColor);

        System.out.println("Project Heading 2");
        Text proHead2 = new Text(scanner.nextLine().trim());
        proHead2.setFont(clibriBold);    
        proHead2.setFontSize(13);
        proHead2.setFontColor(socialHandles);

        System.out.println("Project 2 Description");
        Text proDescription2 = new Text(scanner.nextLine().trim());
        proDescription2.setFont(clibriBold);    
        proDescription2.setFontSize(11);
        proDescription2.setFontColor(myColor);

        System.out.println("Project Heading 3");
        Text proHead3 = new Text(scanner.nextLine().trim());
        proHead3.setFont(clibriBold);    
        proHead3.setFontSize(13);
        proHead3.setFontColor(socialHandles);

        System.out.println("Project 3 Description");
        Text proDescription3 = new Text(scanner.nextLine().trim());
        proDescription3.setFont(clibriBold);    
        proDescription3.setFontSize(11);
        proDescription3.setFontColor(myColor);


        

        projects.add(sampleLine);
        projects.add(projectsHeading);
        projects.add(sampleLine);
        projects.add(sampleLine);
        projects.add(proHead1);
        projects.add(sampleLine);
        projects.add(proDescription1);

        projects.add(sampleLine);
        projects.add(sampleLine);
        projects.add(proHead2);
        projects.add(sampleLine);
        projects.add(proDescription2);

        projects.add(sampleLine);
        projects.add(sampleLine);
        projects.add(proHead3);
        projects.add(sampleLine);
        projects.add(proDescription3);

        //Education=======================
        Paragraph education = new Paragraph();
        education.setMultipliedLeading(1.0f);

        Text educationHeading = new Text("EDUCATION");
        educationHeading.setFont(geoBold);
        educationHeading.setFontSize(14);

        System.out.println("Enter your School or college in Monocromatically Decreasing order");
        Text eduHead1 = new Text(scanner.nextLine().trim());
        eduHead1.setFont(clibriBold);    
        eduHead1.setFontSize(13);
        eduHead1.setFontColor(socialHandles);

        System.out.println("Dates? do it like moth, year - month year");
        Text date1 = new Text(scanner.nextLine().trim());
        date1.setFont(clibri);    
        date1.setFontSize(11);
        date1.setFontColor(myColor);

        System.out.println("Education 1 Description");
        Text eduDescription1 = new Text(scanner.nextLine().trim());
        eduDescription1.setFont(clibriBold);    
        eduDescription1.setFontSize(11);
        eduDescription1.setFontColor(myColor);

        System.out.println("Enter your School or college");
        Text eduHead2 = new Text(scanner.nextLine().trim());
        eduHead2.setFont(clibriBold);    
        eduHead2.setFontSize(13);
        eduHead2.setFontColor(socialHandles);

        System.out.println("Dates?");
        Text date2 = new Text(scanner.nextLine().trim());
        date2.setFont(clibri);    
        date2.setFontSize(11);
        date2.setFontColor(myColor);

        System.out.println("Education 2 Description");
        Text eduDescription2 = new Text(scanner.nextLine().trim());
        eduDescription2.setFont(clibriBold);    
        eduDescription2.setFontSize(11);
        eduDescription2.setFontColor(myColor);

        education.add(sampleLine);
        education.add(educationHeading);
        education.add(sampleLine);
        education.add(sampleLine);
        education.add(eduHead1);
        education.add(sampleLine);
        education.add(date1);
        education.add(sampleLine);
        education.add(eduDescription1);

        education.add(sampleLine);
        education.add(sampleLine);
        education.add(eduHead2);
        education.add(sampleLine);
        education.add(date2);
        education.add(sampleLine);
        education.add(eduDescription2);

        //Skills======================
        Paragraph skills = new Paragraph();
        skills.setMultipliedLeading(1.0f);

        Text bulletPoint = new Text("\u2022");
        bulletPoint.setFont(geoBold);
        bulletPoint.setFontSize(14);
        bulletPoint.setFontColor(socialHandles);



        //initializing the pdf document object.
        Document document = new Document(pdfDocument);
        
        //adding paragraph to document.
        document.add(title);
        document.add(aboutYourself);
        document.add(projects);
        document.add(education);
        document.add(skills);
        document.close();
        scanner.close();
    }
    
}