package swen2.tp.swen2_tp_hw.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Tour {

    private String id;
    private String name;
    private String description;
    private String from;
    private String to;
    private String transportType;
    private double distance;
    private String time;
    private String imagePath;
    private String popularity;
    private String childFriendliness;
    private ArrayList<TourLog> tourLogs;

    public Tour(String uuid, String name, String description, String from, String to, String transportType) {
        this.id = uuid;
        this.name = name;
        this.description = description;
        this.from = from;
        this.to = to;
        this.transportType = transportType;
        this.tourLogs = new ArrayList<>();
    }

    public Tour(String id, String name, String description, String from, String to, String transportType, double distance, String time, String imagePath) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.from = from;
        this.to = to;
        this.transportType = transportType;
        this.distance = distance;
        this.time = time;
        this.imagePath = imagePath;
        this.tourLogs = new ArrayList<>();
    }

    public String getid() {
        return id;
    }

    public void setid(String uuid) {
        this.id = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<TourLog> getTourLogs() {
        return tourLogs;
    }

    public void addTourLog(TourLog tourLog){
        this.tourLogs.add(tourLog);
    }

    public void deleteTourLog(TourLog tourLog){
        this.tourLogs.remove(tourLog);
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getChildFriendliness() {
        return childFriendliness;
    }

    public void setChildFriendliness() {

        int averageTime = 0;
        int averageDifficulty = 0;

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

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
            averageTime += min;

            switch (tourlog.getDifficulty()) {
                case "Very Easy" -> averageDifficulty += 1;
                case "Easy" -> averageDifficulty += 2;
                case "Normal" -> averageDifficulty += 3;
                case "Hard" -> averageDifficulty += 4;
                case "Very Hard" -> averageDifficulty += 5;
            }
        }

        averageTime = averageTime/tourLogs.size();
        averageDifficulty = averageDifficulty/tourLogs.size();

        if(averageTime < 180 && averageDifficulty <= 3 && distance <= 5){
            this.childFriendliness = "Child Friendly";
        }else {
            this.childFriendliness = "NOT Child Friendly";
        }
    }

    public int getRating(int stars){
        int count = 0;

        for (TourLog tourlog: tourLogs
             ) {
            if(Integer.parseInt(tourlog.getRating()) == stars){
                count++;
            }
        }
        return count;
    }

    public double getAverageRating(){
        double count = 0;

        for (TourLog tourlog: tourLogs
        ) {
            count += Integer.parseInt(tourlog.getRating());
        }
        return count/tourLogs.size();
    }


}
