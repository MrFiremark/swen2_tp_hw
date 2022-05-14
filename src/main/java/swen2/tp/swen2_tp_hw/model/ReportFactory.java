package swen2.tp.swen2_tp_hw.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ReportFactory {

    private ArrayList<Report> reportList;

    public void generateReport (Tour tour){
        reportList.add(
                new Report(
                        tour.getName(),
                        getAverageTime(tour.getTourLogs()),
                        getAverageRating(tour.getTourLogs())
                )
        );
    }

    public String getAverageTime(ArrayList<TourLog> tourLogs) {
        int sum = 0;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();

        for (TourLog tourlog : tourLogs
             ) {
            try {
                date = simpleDateFormat.parse(tourlog.getTotalTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            calendar.setTime(date);
            int min = calendar.get(Calendar.HOUR)*60 + calendar.get(Calendar.MINUTE);
            sum += min+60;
        }

        int average = sum/tourLogs.size();
        Date date2 = new Date(average* 1000L);

        return  simpleDateFormat.format(date2);
    }

    public String getAverageRating(ArrayList<TourLog> tourLogs){

        double rating_sum = 0;

        for (TourLog tourlog: tourLogs
             ) {
            double rating = Double.parseDouble(tourlog.getRating());
            rating_sum += rating;
        }
        rating_sum = rating_sum/ tourLogs.size();

        return String.valueOf(rating_sum);
    }

    public Report getReport(int index){
        return reportList.get(index);
    }

    public ArrayList<Report> getReportList() {
        return reportList;
    }
}
