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
import swen2.tp.swen2_tp_hw.model.ReportFactory;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;

public class PDFService {

    private String target = "_report.pdf";

    public void generateTourPDF(Tour tour) throws IOException {

        PdfWriter writer = new PdfWriter(tour.getName() + target);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        Paragraph Header = new Paragraph(tour.getName() + "Report")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                .setFontSize(22)
                .setBold()
                .setFontColor(ColorConstants.BLUE);
        document.add(Header);
        document.add(new Paragraph(tour.getDescription()));

        Paragraph listHeader = new Paragraph("Tour Details:")
                .setFont(PdfFontFactory.createFont(StandardFonts.TIMES_BOLD))
                .setFontSize(14)
                .setBold()
                .setFontColor(ColorConstants.GREEN);
        List list = new List()
                .setSymbolIndent(12)
                .setListSymbol("\u2022")
                .setFont(PdfFontFactory.createFont(StandardFonts.TIMES_BOLD));
        list.add(new ListItem("From : " + tour.getFrom()))
                .add(new ListItem("To: " + tour.getTo()))
                .add(new ListItem("Transport type: " + tour.getTransportType()))
                .add(new ListItem("Estimated distance: " + tour.getDistance()))
                .add(new ListItem("Estimated traveltime: " + tour.getTime()))
                .add(new ListItem("Popularity: " + tour.getPopularity()))
                .add(new ListItem("Child-Friendliness: " + tour.getChildFriendliness()));
        document.add(listHeader);
        document.add(list);

        Paragraph tableHeader = new Paragraph("Tour Logs")
                .setFont(PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN))
                .setFontSize(18)
                .setBold()
                .setFontColor(ColorConstants.MAGENTA);
        document.add(tableHeader);
        Table table = new Table(UnitValue.createPercentArray(4)).useAllAvailableWidth();
        table.addHeaderCell(getHeaderCell("Date/Time"));
        table.addHeaderCell(getHeaderCell("Comment"));
        table.addHeaderCell(getHeaderCell("Difficulty"));
        table.addHeaderCell(getHeaderCell("Total time"));
        table.addHeaderCell(getHeaderCell("Rating"));
        table.setFontSize(14).setBackgroundColor(ColorConstants.WHITE);
        ArrayList<TourLog> entryList = tour.getTourLogs();

        for(int i = 0; i <= tour.getTourLogs().size(); i++){
            table.addCell(tour.getTourLogs().get(i).getDate());
            table.addCell(tour.getTourLogs().get(i).getTime());
            table.addCell(tour.getTourLogs().get(i).getComment());
            table.addCell(tour.getTourLogs().get(i).getDifficulty());
            table.addCell(tour.getTourLogs().get(i).getTotalTime());
            table.addCell(tour.getTourLogs().get(i).getRating());
        }

        document.add(table);

        document.add(new AreaBreak());

        Paragraph imageHeader = new Paragraph("Tour Map")
                .setFont(PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN))
                .setFontSize(18)
                .setBold()
                .setFontColor(ColorConstants.GREEN);
        document.add(imageHeader);
        ImageData imageData = ImageDataFactory.create(tour.getImagePath());
        document.add(new Image(imageData));

        document.close();
    }

    public void generateSummaryPDF(Map<String, Tour> tourMap) throws IOException {

        ReportFactory reportFactory = new ReportFactory();

        PdfWriter writer = new PdfWriter("Summary_" + Time.valueOf(LocalTime.MIN) + target );
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        Paragraph Header = new Paragraph("Summary Report")
                .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA))
                .setFontSize(22)
                .setBold()
                .setFontColor(ColorConstants.BLUE);
        document.add(Header);

        document.add(new AreaBreak());

        Paragraph tableHeader = new Paragraph("Average Table")
                .setFont(PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN))
                .setFontSize(18)
                .setBold()
                .setFontColor(ColorConstants.MAGENTA);
        document.add(tableHeader);
        Table table = new Table(UnitValue.createPercentArray(4)).useAllAvailableWidth();
        table.addHeaderCell(getHeaderCell("Tourname"));
        table.addHeaderCell(getHeaderCell("Average Time"));
        table.addHeaderCell(getHeaderCell("Average Rating"));
        table.setFontSize(14).setBackgroundColor(ColorConstants.WHITE);

        for (Map.Entry<String, Tour> entry: tourMap.entrySet()
             ) {
            table.addCell(entry.getKey());
            table.addCell(reportFactory.getAverageTime(entry.getValue().getTourLogs()));
            table.addCell(reportFactory.getAverageRating(entry.getValue().getTourLogs()));
        }

        document.add(table);

        document.add(new AreaBreak());

        document.close();
    }

    private static Cell getHeaderCell(String s) {
        return new Cell().add(new Paragraph(s)).setBold().setBackgroundColor(ColorConstants.GRAY);
    }

}
