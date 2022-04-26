package swen2.tp.swen2_tp_hw.service;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.properties.UnitValue;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PDFService {

    private String target = "report.pdf";
    private String input;
    private String picturePath;

    public void generatePDF() throws IOException {

        PdfWriter writer = new PdfWriter(target);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        Paragraph loremIpsumHeader = new Paragraph("HEADER")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                .setFontSize(14)
                .setBold()
                .setFontColor(ColorConstants.RED);
        document.add(loremIpsumHeader);
        document.add(new Paragraph(input));

        Paragraph listHeader = new Paragraph("NEW PARAGRAPH LIST")
                .setFont(PdfFontFactory.createFont(StandardFonts.TIMES_BOLD))
                .setFontSize(14)
                .setBold()
                .setFontColor(ColorConstants.BLUE);
        List list = new List()
                .setSymbolIndent(12)
                .setListSymbol("\u2022")
                .setFont(PdfFontFactory.createFont(StandardFonts.TIMES_BOLD));
        list.add(new ListItem("item 1"))
                .add(new ListItem("item 2"))
                .add(new ListItem("item 3"))
                .add(new ListItem("item 4"))
                .add(new ListItem("item 5"))
                .add(new ListItem("item 6"));
        document.add(listHeader);
        document.add(list);

        Paragraph tableHeader = new Paragraph("NEW PARAGRAPGTABELLE")
                .setFont(PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN))
                .setFontSize(18)
                .setBold()
                .setFontColor(ColorConstants.MAGENTA);
        document.add(tableHeader);
        Table table = new Table(UnitValue.createPercentArray(4)).useAllAvailableWidth();
        table.addHeaderCell(getHeaderCell("Header 1"));
        table.addHeaderCell(getHeaderCell("Header 2"));
        table.addHeaderCell(getHeaderCell("Header 3"));
        table.addHeaderCell(getHeaderCell("Header 4"));
        table.setFontSize(14).setBackgroundColor(ColorConstants.WHITE);
        table.addCell("Cell 1");
        table.addCell("Cell 2");
        table.addCell("Cell 3");
        table.addCell("Cell 4");
        document.add(table);

        document.add(new AreaBreak());

        Paragraph imageHeader = new Paragraph("PICTURE")
                .setFont(PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN))
                .setFontSize(18)
                .setBold()
                .setFontColor(ColorConstants.GREEN);
        document.add(imageHeader);
        ImageData imageData = ImageDataFactory.create(picturePath);
        document.add(new Image(imageData));

        document.close();
    }

    private static Cell getHeaderCell(String s) {
        return new Cell().add(new Paragraph(s)).setBold().setBackgroundColor(ColorConstants.GRAY);
    }

}
