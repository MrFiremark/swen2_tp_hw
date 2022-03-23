package swen2.tp.swen2_tp_hw;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import swen2.tp.swen2_tp_hw.view.ControllerFactory;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class FXMLDependencyInjection {

    public static Parent load(String location, Locale locale) throws IOException {
        FXMLLoader loader = getLoader(location, locale);
        return loader.load();
    }

    public static FXMLLoader getLoader(String location, Locale locale) {
        return new FXMLLoader(
                FXMLDependencyInjection.class.getResource("/swen2/tp/swen2_tp_hw/view/" + location),
                ResourceBundle.getBundle("swen2.tp.swen2_tp_hw." + "gui_strings", locale),
                new JavaFXBuilderFactory(),
                controllerClass-> ControllerFactory.getInstance().create(controllerClass)
        );
    }
}
