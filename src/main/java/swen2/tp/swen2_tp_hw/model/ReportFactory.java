package swen2.tp.swen2_tp_hw.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ReportFactory {

    ArrayList<Report> reportList;

    public void generateReport (Tour tour){
        reportList.add(
                new Report(
                        tour.getName(),
                        getAvaerageTime(tour.getTourLogs()),
                        getAverageDistance(tour.getTourLogs()),
                        getAverageRating(tour.getTourLogs())
                )
        );
    }

    public String getAvaerageTime(ArrayList<TourLog> tourLogs) {
        int sum = 0;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

        for (TourLog tourlog : tourLogs
             ) {
            Date date = null;
            try {
                date = simpleDateFormat.parse(tourlog.getTotalTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            calendar.setTime(date);
            int min = calendar.get(Calendar.HOUR)*60 + calendar.get(Calendar.MINUTE);
            sum += min+60 + calendar.get(Calendar.SECOND);
        }

        int average = sum/tourLogs.size();
        Date date = new Date(average* 1000L);

        return  simpleDateFormat.format(date);
    }

    public String getAverageDistance(ArrayList<TourLog> tourLogs){
        return "";
    }

    public String getAverageRating(ArrayList<TourLog> tourLogs){
        return "";
    }

    public Report getReport(int index){
        return reportList.get(index);
    }

    public ArrayList<Report> getReportList() {
        return reportList;
    }
}
