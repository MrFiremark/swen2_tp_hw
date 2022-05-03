package swen2.tp.swen2_tp_hw.model;

import java.util.ArrayList;

public class Report {

    private String tourname;
    private String averageTime;
    private String averageDistance;
    private String averageRating;

    public Report(String tourname, String averageTime, String averageDistance, String averageRating) {
        this.tourname = tourname;
        this.averageTime = averageTime;
        this.averageDistance = averageDistance;
        this.averageRating = averageRating;
    }

    public String getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(String averageTime) {
        this.averageTime = averageTime;
    }

    public String getAverageDistance() {
        return averageDistance;
    }

    public void setAverageDistance(String averageDistance) {
        this.averageDistance = averageDistance;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }
}
