package swen2.tp.swen2_tp_hw.dto;

import swen2.tp.swen2_tp_hw.model.TourLog;

import java.util.ArrayList;

public class JSONTour {

    public String id;
    public String name;
    public String description;
    public String from;
    public String to;
    public String transportType;
    public double distance;
    public String time;
    public String imagePath;
    public String popularity;
    public String childFriendliness;
    public ArrayList<JSONTourLog> tourLogs;

}
