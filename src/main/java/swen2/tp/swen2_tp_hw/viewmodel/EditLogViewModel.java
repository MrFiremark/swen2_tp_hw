package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;

import java.time.LocalDate;

public class EditLogViewModel {

    public final SelectedTourService selectedTourService;

    private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    private final StringProperty durationHour = new SimpleStringProperty();
    private final StringProperty durationMin = new SimpleStringProperty();
    private final ObjectProperty<String> difficulty = new SimpleObjectProperty<>();
    private final StringProperty comment = new SimpleStringProperty();
    private final ObjectProperty<Number> rating = new SimpleObjectProperty<>();

    public EditLogViewModel(SelectedTourService selectedTourService) {
        this.selectedTourService = selectedTourService;
    }

    public ObjectProperty<LocalDate> getDate(){ return date;}
    public StringProperty getDurationHour(){ return durationHour;}
    public StringProperty getDurationMin(){ return durationMin;}
    public ObjectProperty<String> getDifficulty(){ return difficulty;}
    public StringProperty getComment(){ return comment;}
    public ObjectProperty<Number> getRating(){ return rating;}

    public void editTourLog(){
        //TODO validation and correct time
        if (selectedTourService.getSetSelectedTourLog() != null ) {
            selectedTourService.getSetSelectedTourLog().setDate(date.get().toString());
            selectedTourService.getSetSelectedTourLog().setComment(comment.get());
            selectedTourService.getSetSelectedTourLog().setDifficulty(difficulty.get());
            selectedTourService.getSetSelectedTourLog().setTotalTime(durationHour.get() + ":" + durationMin.get());
            selectedTourService.getSetSelectedTourLog().setRating(String.valueOf(rating.get().intValue()));
            selectedTourService.editTourLog();
        }else{
            System.out.println("No tour selected");
        }
    }

}
