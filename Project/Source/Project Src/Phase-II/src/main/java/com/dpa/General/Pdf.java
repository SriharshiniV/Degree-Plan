package com.dpa.General;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import com.dpa.model.Courses;
import com.dpa.model.DegreePlan;
import com.dpa.model.GRE;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class Pdf {
	public int generatePdf(DegreePlan degreePlan, GRE gre, List<Courses> courses){
	Document document = new Document();
    try
    {
       PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("DegreePlan.pdf"));
       document.open();
       document.add(new Paragraph("Department of Computer Science and Engineering", FontFactory.getFont(FontFactory.TIMES_BOLD, 16, BaseColor.BLACK)));
       document.add(new Paragraph("Master's Degree Plan", FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 16, BaseColor.GREEN)));
       document.add(new Paragraph(new Date().toString(), FontFactory.getFont(FontFactory.TIMES_ITALIC, 16, BaseColor.BLACK)));
       document.add(new Paragraph("-----------------------------------------------------------------------------------------------------------------------"));
       document.add(new Paragraph("Name: " + "Sharanya      " + "                                        " + "Student Id: " + "11267588", FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       document.add(new Paragraph("Local Address: " + "54678 Sycamore Street, denton, texas, 76201", FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       document.add(new Paragraph("E Mail Address: " + "sharanyajhagdauk@my.unt.edu", FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       document.add(new Paragraph("Degree to be earned: " + "M.S." + "                               " + "Major: " + "Computer Science", FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       document.add(new Paragraph("Minor: " + "Computer Engineering" + "      " + "Interest Area: " + "Networks and Communications", FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       document.add(new Paragraph("Major Professor: " + "Dr. Armin Mikler", FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       document.add(new Paragraph("Most recent GRE scores: Verbal: " + "134" + "  " + "Quantitative" + "134" + "  " + "Analytical" + "3.0" + "  " + "Date Taken" + "12/17/18", FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       
       //core courses
       document.add(new Paragraph("Core Courses", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, BaseColor.BLACK))); 
       document.add(new Paragraph("Course Title: " + "Software Engineering" + "     " + "Semester Taken: " + "Fall" + "     " + "C.Hrs" + "3" + "     " + "Grade" + "A",  FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       document.add(new Paragraph("Course Title: " + "Software Engineering" + "     " + "Semester Taken: " + "Fall" + "     " + "C.Hrs" + "3" + "     " + "Grade" + "A",  FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       document.add(new Paragraph("Course Title: " + "Software Engineering" + "     " + "Semester Taken: " + "Fall" + "     " + "C.Hrs" + "3" + "     " + "Grade" + "A",  FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       document.add(new Paragraph("Course Title: " + "Software Engineering" + "     " + "Semester Taken: " + "Fall" + "     " + "C.Hrs" + "3" + "     " + "Grade" + "A",  FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       
       //Optional courses
       document.add(new Paragraph("Supporting Courses", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, BaseColor.BLACK)));
       document.add(new Paragraph("Course Title: " + "Software Engineering" + "     " + "Semester Taken: " + "Fall" + "     " + "C.Hrs" + "3" + "     " + "Grade" + "A",  FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       document.add(new Paragraph("Course Title: " + "Software Engineering" + "     " + "Semester Taken: " + "Fall" + "     " + "C.Hrs" + "3" + "     " + "Grade" + "A",  FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       document.add(new Paragraph("Course Title: " + "Software Engineering" + "     " + "Semester Taken: " + "Fall" + "     " + "C.Hrs" + "3" + "     " + "Grade" + "A",  FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       document.add(new Paragraph("Course Title: " + "Software Engineering" + "     " + "Semester Taken: " + "Fall" + "     " + "C.Hrs" + "3" + "     " + "Grade" + "A",  FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       document.add(new Paragraph("Course Title: " + "Software Engineering" + "     " + "Semester Taken: " + "Fall" + "     " + "C.Hrs" + "3" + "     " + "Grade" + "A",  FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       document.add(new Paragraph("Course Title: " + "Software Engineering" + "     " + "Semester Taken: " + "Fall" + "     " + "C.Hrs" + "3" + "     " + "Grade" + "A",  FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       document.add(new Paragraph("Course Title: " + "Software Engineering" + "     " + "Semester Taken: " + "Fall" + "     " + "C.Hrs" + "3" + "     " + "Grade" + "A",  FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       document.add(new Paragraph("Course Title: " + "Software Engineering" + "     " + "Semester Taken: " + "Fall" + "     " + "C.Hrs" + "3" + "     " + "Grade" + "A",  FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK)));
       document.add(new Paragraph("Admission to candidacy is recommended: " + "            " + "Total Semester Hours Required: " + "36", FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK))); 
       
       //major professor signature
       document.add(new Paragraph("Advisor or Major Professor: " + "Dr. Armin Mikler", FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       document.add(new Paragraph("Associate Chair for Graduate Studies: " + "Dr. Armin Mikler", FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       document.add(new Paragraph("Department Chair:  " + "Dr. Armin Mikler", FontFactory.getFont(FontFactory.TIMES, 16, BaseColor.BLACK)));
       
       document.close();
       writer.close();
    } catch (DocumentException ex)
    {
       ex.printStackTrace();
    } catch (FileNotFoundException e)
    {
       e.printStackTrace();
    }
	return 1;
	}
}

