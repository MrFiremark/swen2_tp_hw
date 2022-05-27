package swen2.tp.swen2_tp_hw.service;

import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AttributeService {

    public String setChildFriendliness(Tour tour){
        int averageTime = 0;
        int averageDifficulty = 0;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        for (TourLog tourlog : tour.getTourLogs()
        ) {
            Date date = null;
            try {
                date = simpleDateFormat.parse(tourlog.getTotalTime());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            calendar.setTime(date);
            int min = calendar.get(Calendar.HOUR)*60 + calendar.get(Calendar.MINUTE);
            averageTime += min;

            switch (tourlog.getDifficulty()) {
                case "Very Easy" -> averageDifficulty += 1;
                case "Easy" -> averageDifficulty += 2;
                case "Normal" -> averageDifficulty += 3;
                case "Hard" -> averageDifficulty += 4;
                case "Very Hard" -> averageDifficulty += 5;
            }
        }

        averageTime = averageTime/tour.getTourLogs().size();
        averageDifficulty = averageDifficulty/tour.getTourLogs().size();

        if(averageTime < 180 && averageDifficulty <= 3 && tour.getDistance() <= 5){
            //tour.setChildFriendliness("Child Friendly");
            return "Child Friendly";
        }else {
            //tour.setChildFriendliness("NOT Child Friendly");
            return "NOT Child Friendly";
        }

        //return tour;
    }

    public int getRating(Tour tour, int stars){
        int count = 0;

        for (TourLog tourlog: tour.getTourLogs()
        ) {
            if(Integer.parseInt(tourlog.getRating()) == stars){
                count++;
            }
        }
        return count;
    }

    public int getDifficulty(Tour tour, String difficulty){
        int count = 0;

        for (TourLog tourlog: tour.getTourLogs()
        ) {
            if(tourlog.getDifficulty().equals(difficulty)){
                count++;
            }
        }
        return count;
    }

    public double getAverageRating(Tour tour){
        double count = 0;

        for (TourLog tourlog: tour.getTourLogs()
        ) {
            count += Integer.parseInt(tourlog.getRating());
        }
        if (tour.getTourLogs().size() == 0){
            return 0;
        }else{
            return BigDecimal.valueOf(count/tour.getTourLogs().size()).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
    }
}
