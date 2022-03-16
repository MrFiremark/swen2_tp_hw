module swen2.tp.swen2_tp_hw {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens swen2.tp.swen2_tp_hw to javafx.fxml;
    exports swen2.tp.swen2_tp_hw;
    exports swen2.tp.swen2_tp_hw.view;
    opens swen2.tp.swen2_tp_hw.view to javafx.fxml;

}