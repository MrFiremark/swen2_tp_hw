package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import swen2.tp.swen2_tp_hw.listener.SelectedTourListener;
import swen2.tp.swen2_tp_hw.listener.SelectedTourLogListener;
import swen2.tp.swen2_tp_hw.listener.TourListener;
import swen2.tp.swen2_tp_hw.listener.TourLogListener;
import swen2.tp.swen2_tp_hw.model.TourLog;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;
import swen2.tp.swen2_tp_hw.wrapper.ILoggerWrapper;
import swen2.tp.swen2_tp_hw.wrapper.LoggerFactory;

import java.time.LocalDate;

public class EditLogViewModel implements SelectedTourLogListener {

    private ILoggerWrapper logger = LoggerFactory.getLogger();
    private final SelectedTourService selectedTourService;

    private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    private final StringProperty durationHour = new SimpleStringProperty();
    private final StringProperty durationMin = new SimpleStringProperty();
    private final ObjectProperty<String> difficulty = new SimpleObjectProperty<>();
    private final StringProperty comment = new SimpleStringProperty();
    private final ObjectProperty<Number> rating = new SimpleObjectProperty<>();

    public EditLogViewModel(SelectedTourService selectedTourService) {
        this.selectedTourService = selectedTourService;
        selectedTourService.addListener(this);
    }

    public ObjectProperty<LocalDate> getDate(){ return date;}
    public StringProperty getDurationHour(){ return durationHour;}
    public StringProperty getDurationMin(){ return durationMin;}
    public ObjectProperty<String> getDifficulty(){ return difficulty;}
    public StringProperty getComment(){ return comment;}
    public ObjectProperty<Number> getRating(){ return rating;}

    public void editTourLog(){
        if (checkMinutes() ) {
            selectedTourService.getSetSelectedTourLog().setDate(date.get().toString());
            selectedTourService.getSetSelectedTourLog().setComment(comment.get());
            selectedTourService.getSetSelectedTourLog().setDifficulty(difficulty.get());
            selectedTourService.getSetSelectedTourLog().setTotalTime(durationHour.get() + ":" + durationMin.get());
            selectedTourService.getSetSelectedTourLog().setRating(String.valueOf(rating.get().intValue()));
            selectedTourService.editTourLog();
        }else{
            logger.error("Error creating tour log [err:61]. Wrong minutes format.");
        }
    }

    @Override
    public void update(TourLog tourLog) {
        date.set(LocalDate.parse(tourLog.getDate()));
        comment.set(tourLog.getComment());
        difficulty.set(tourLog.getDifficulty());
        String[] duration = tourLog.getTotalTime().split(":");
        durationHour.set(duration[0]);
        durationMin.set(duration[1]);
        rating.set(Integer.parseInt(tourLog.getRating()));
    }

    private boolean checkMinutes(){
        try{
            int min = Integer.parseInt(durationMin.get());
            if(min > 60){
                return false;
            }
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
