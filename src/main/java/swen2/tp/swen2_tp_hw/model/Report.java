package swen2.tp.swen2_tp_hw.model;

import java.util.ArrayList;

public class Report {

    private String tourname;
    private String averageTime;
    private String averageRating;

    public Report(String tourname, String averageTime, String averageRating) {
        this.tourname = tourname;
        this.averageTime = averageTime;
        this.averageRating = averageRating;
    }

    public String getAverageTime() {
        return averageTime;
    }

    public void setAverageTime(String averageTime) {
        this.averageTime = averageTime;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }
}
