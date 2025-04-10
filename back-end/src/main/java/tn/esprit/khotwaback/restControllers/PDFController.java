package tn.esprit.khotwaback.restControllers;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.khotwaback.entities.Cours;
import tn.esprit.khotwaback.services.CoursService;
import tn.esprit.khotwaback.services.PDFService;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.List;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/pdf")
public class PDFController {
    private final PDFService pdfService;

    public PDFController(PDFService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/export-pdf")
    public ResponseEntity<byte[]> exportCoursToPdf() {
        try {
            byte[] pdfBytes = pdfService.generateCoursPdf();

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=courses.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfBytes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}