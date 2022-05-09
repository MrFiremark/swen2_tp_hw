package swen2.tp.swen2_tp_hw.model;

import java.util.ArrayList;

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

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getChildFriendliness() {
        return childFriendliness;
    }

    public void setChildFriendliness(String childFriendliness) {
        this.childFriendliness = childFriendliness;
    }
}
