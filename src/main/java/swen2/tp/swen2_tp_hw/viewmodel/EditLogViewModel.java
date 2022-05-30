package swen2.tp.swen2_tp_hw.viewmodel;

import javafx.beans.property.*;
import swen2.tp.swen2_tp_hw.listener.SelectedTourLogListener;
import swen2.tp.swen2_tp_hw.model.TourLog;
import swen2.tp.swen2_tp_hw.service.SelectedTourService;
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
    private final BooleanProperty enabled = new SimpleBooleanProperty();
    private final BooleanProperty warningVisibility = new SimpleBooleanProperty(false);

    public EditLogViewModel(SelectedTourService selectedTourService) {
        this.selectedTourService = selectedTourService;
        selectedTourService.addListener(this);
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
    public BooleanProperty getEnabled(){
        return enabled;
    }
    public BooleanProperty getWarningVisibility(){return warningVisibility;}

    public void editTourLog(){
        if (checkMinutes() ) {
            selectedTourService.getSelectedTourLog().setDate(date.get().toString());
            selectedTourService.getSelectedTourLog().setComment(comment.get());
            selectedTourService.getSelectedTourLog().setDifficulty(difficulty.get());
            selectedTourService.getSelectedTourLog().setTotalTime(durationHour.get() + ":" + durationMin.get());
            selectedTourService.getSelectedTourLog().setRating(String.valueOf(rating.get().intValue()));
            selectedTourService.editTourLog();
        }else{
            logger.error("Error creating tour log [err:61]. Wrong minutes format.");
        }
    }

    public void resetWindow(){
        warningVisibility.set(false);
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

    private void resetValues(){
        date.set(null);
        durationHour.set("");
        durationMin.set("");
        comment.set("");
        difficulty.set("");
        rating.set(1);
    }
}
