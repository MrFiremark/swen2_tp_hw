package swen2.tp.swen2_tp_hw.model;

public class Tour {

    private String id;
    private String name;
    private String description;
    private String from;
    private String to;
    private String transportType;

    public Tour(String uuid, String name, String description, String from, String to, String transportType) {
        this.id = uuid;
        this.name = name;
        this.description = description;
        this.from = from;
        this.to = to;
        this.transportType = transportType;
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
}
