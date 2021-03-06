module swen2.tp.swen2_tp_hw {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires io;
    requires kernel;
    requires layout;
    requires java.desktop;
    requires org.apache.logging.log4j;

    opens swen2.tp.swen2_tp_hw to javafx.fxml;
    exports swen2.tp.swen2_tp_hw;
    exports swen2.tp.swen2_tp_hw.view;
    exports swen2.tp.swen2_tp_hw.dto;
    exports swen2.tp.swen2_tp_hw.model;
    opens swen2.tp.swen2_tp_hw.view to javafx.fxml;

}