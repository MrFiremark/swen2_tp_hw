package swen2.tp.swen2_tp_hw.dto;

public class Route {

    public BoundingBox boundingBox;
    public double distance;
    public String formattedTime;
    public String sessionId;

    public double getDistance() {
        return distance;
    }

    public String getFormattedTime() {
        return formattedTime;
    }
}
