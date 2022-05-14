package swen2.tp.swen2_tp_hw.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SearchResult {

    private StringProperty type;
    private String tourid;
    private String tourlogid;
    private StringProperty name;
    private StringProperty description;
    private StringProperty from;
    private StringProperty to;
    private StringProperty comment;
    private StringProperty difficulty;

    public SearchResult(String type, String tourid, String name, String description, String from, String to) {
        this.type = new SimpleStringProperty(type);
        this.tourid = tourid;
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.from = new SimpleStringProperty(from);
        this.to = new SimpleStringProperty(to);
    }

    public SearchResult(String type, String tourid, String tourlogid, String name, String description, String from, String to, String comment, String difficulty) {
        this.type = new SimpleStringProperty(type);
        this.tourid = tourid;
        this.tourlogid = tourlogid;
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.from = new SimpleStringProperty(from);
        this.to = new SimpleStringProperty(to);
        this.comment = new SimpleStringProperty(comment);
        this.difficulty = new SimpleStringProperty(difficulty);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
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
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getFrom() {
        return from.get();
    }

    public StringProperty fromProperty() {
        return from;
    }

    public void setFrom(String from) {
        this.from.set(from);
    }

    public String getTo() {
        return to.get();
    }

    public StringProperty toProperty() {
        return to;
    }

    public void setTo(String to) {
        this.to.set(to);
    }

    public String getComment() {
        return comment.get();
    }

    public StringProperty commentProperty() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment.set(comment);
    }

    public String getDifficulty() {
        return difficulty.get();
    }

    public StringProperty difficultyProperty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty.set(difficulty);
    }
}
