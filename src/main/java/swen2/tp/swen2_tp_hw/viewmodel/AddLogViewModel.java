package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import swen2.tp.swen2_tp_hw.model.TourLog;
//import swen2.tp.swen2_tp_hw.service.LogService;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

public class AddLogViewModel {

    public final SelectedTourService selectedTourService;

    private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    private final StringProperty durationHour = new SimpleStringProperty();
    private final StringProperty durationMin = new SimpleStringProperty();
    private final ObjectProperty<String> difficulty = new SimpleObjectProperty<>();
    private final StringProperty comment = new SimpleStringProperty();
    private final ObjectProperty<Number> rating = new SimpleObjectProperty<>();

    public AddLogViewModel(SelectedTourService selectedTourService) {
        this.selectedTourService = selectedTourService;
    }

    public ObjectProperty<LocalDate> getDate(){ return date;}
    public StringProperty getDurationHour(){ return durationHour;}
    public StringProperty getDurationMin(){ return durationMin;}
    public ObjectProperty<String> getDifficulty(){ return difficulty;}
    public StringProperty getComment(){ return comment;}
    public ObjectProperty<Number> getRating(){ return rating;}

    public void saveTourLog(){
        //TODO  validation and correct time
        if (selectedTourService.getSelectedTour() != null ) {
            TourLog tourLog = new TourLog(selectedTourService.getSelectedTour().getid(), UUID.randomUUID().toString(), date.get().toString(), "13:13:13", comment.get(), difficulty.get(), durationHour.get() + ":" + durationMin.get(), String.valueOf(rating.get().intValue()));
            resetValues();
            selectedTourService.addTourLog(tourLog);
        }else{
            System.out.println("No tour selected");
        }
    }

    private void resetValues(){
        date.set(null);
        durationHour.set("");
        durationMin.set("");
        comment.set("");
        difficulty.set("");
        rating.set(1);
    }

}
