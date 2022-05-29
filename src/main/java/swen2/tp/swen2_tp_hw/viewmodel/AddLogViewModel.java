package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.property.*;
import javafx.fxml.FXML;
import swen2.tp.swen2_tp_hw.model.TourLog;
//import swen2.tp.swen2_tp_hw.service.LogService;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
import swen2.tp.swen2_tp_hw.service.TourService;
import swen2.tp.swen2_tp_hw.wrapper.ILoggerWrapper;
import swen2.tp.swen2_tp_hw.wrapper.LoggerFactory;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

public class AddLogViewModel {

    private ILoggerWrapper logger = LoggerFactory.getLogger();
    private final SelectedTourService selectedTourService;

    private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
    private final StringProperty durationHour = new SimpleStringProperty();
    private final StringProperty durationMin = new SimpleStringProperty();
    private final ObjectProperty<String> difficulty = new SimpleObjectProperty<>();
    private final StringProperty comment = new SimpleStringProperty();
    private final ObjectProperty<Number> rating = new SimpleObjectProperty<>();
    private final BooleanProperty enabled = new SimpleBooleanProperty();
    private final BooleanProperty warningVisibility = new SimpleBooleanProperty(false);

    public AddLogViewModel(SelectedTourService selectedTourService) {
        this.selectedTourService = selectedTourService;
        enabled.bind(date.isNull()
                .or(durationHour.isEmpty())
                .or(durationMin.isEmpty())
                .or(difficulty.isNull())
                .or(comment.isEmpty())
                .or(rating.isNull()));
    }

    public ObjectProperty<LocalDate> getDate(){ return date;}
    public StringProperty getDurationHour(){ return durationHour;}
    public StringProperty getDurationMin(){ return durationMin;}
    public ObjectProperty<String> getDifficulty(){ return difficulty;}
    public StringProperty getComment(){ return comment;}
    public ObjectProperty<Number> getRating(){ return rating;}
    public BooleanProperty getEnabled(){return enabled;}
    public BooleanProperty getWarningVisibility(){return warningVisibility;}

    public void saveTourLog(){
        if (checkMinutes()) {
            TourLog tourLog = new TourLog(selectedTourService.getSelectedTour().getid(), UUID.randomUUID().toString(), date.get().toString(), "00:00:00", comment.get(), difficulty.get(), durationHour.get() + ":" + durationMin.get(), String.valueOf(rating.get().intValue()));
            selectedTourService.addTourLog(tourLog);
        }
    }

    public void resetWindow(){
        warningVisibility.set(false);
        resetValues();
    }

    private void resetValues(){
        date.set(null);
        durationHour.set("00");
        durationMin.set("00");
        comment.set("");
        difficulty.set("");
        rating.set(1);
    }

    private boolean checkMinutes(){
        try{
            int min = Integer.parseInt(durationMin.get());
            if(min > 60){
                warningVisibility.set(true);
                logger.error("Error creating tour log [err:61]. Wrong minutes format.");
                return false;
            }
        }catch(Exception e){
            warningVisibility.set(true);
            logger.error("Error creating tour log [err:62]. Wrong number format.");
            return false;
        }
        warningVisibility.set(false);
        return true;
    }

}
