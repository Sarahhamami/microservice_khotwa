package tn.esprit.khotwaback.services;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;

import com.itextpdf.layout.properties.TextAlignment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.esprit.khotwaback.entities.Cours;
import tn.esprit.khotwaback.repositories.CoursRepository;

import java.io.ByteArrayOutputStream;
import java.util.List;
@Service

public class PDFService {
    private final CoursRepository coursRepository;

    public PDFService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    public byte[] generateCoursPdf() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(out);
        PdfDocument pdf = new PdfDocument(writer);

        try (Document document = new Document(pdf)) {
            document.add(new Paragraph("List of Courses")
                    .setBold()
                    .setFontSize(18)
                    .setTextAlignment(TextAlignment.CENTER));

            // Add spacing
            document.add(new Paragraph("\n"));

            Table table = new Table(4); // Reduced to 4 columns (remove ID)
            table.addHeaderCell("Title");
            table.addHeaderCell("Price");
            table.addHeaderCell("Rating");
            table.addHeaderCell("Description");

            List<Cours> courses = coursRepository.findAll();

            for (Cours cours : courses) {
                table.addCell(cours.getTitre());
                table.addCell(String.valueOf(cours.getPrix()));
                table.addCell(String.valueOf(cours.getRating()));
                table.addCell(cours.getDescription());
            }

            document.add(table);
        }

        return out.toByteArray();
    }
}