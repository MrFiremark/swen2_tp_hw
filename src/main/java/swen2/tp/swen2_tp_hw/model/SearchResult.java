package swen2.tp.swen2_tp_hw.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SearchResult {

    private String type;
    private String tourid;
    private String tourlogid;
    private String name;
    private String description;
    private String from;
    private String to;
    private String comment;
    private String difficulty;

    public SearchResult(String type, String tourid, String tourlogid, String name, String description, String from, String to, String comment, String difficulty) {
        this.type = type;
        this.tourid = tourid;
        this.tourlogid = tourlogid;
        this.name = name;
        this.description = description;
        this.from = from;
        this.to = to;
        this.comment = comment;
        this.difficulty = difficulty;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTourid() {
        return tourid;
    }

    public void setTourid(String tourid) {
        this.tourid = tourid;
    }

    public String getTourlogid() {
        return tourlogid;
    }

    public void setTourlogid(String tourlogid) {
        this.tourlogid = tourlogid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}