package swen2.tp.swen2_tp_hw.mapper;

import swen2.tp.swen2_tp_hw.dto.TourDTO;
import swen2.tp.swen2_tp_hw.dto.TourLogDTO;
import swen2.tp.swen2_tp_hw.model.Tour;
import swen2.tp.swen2_tp_hw.model.TourLog;

public class Mapper {

    public Tour toUser(TourDTO tourDTO){
        Tour mappedTour = new Tour(tourDTO.id,tourDTO.name,tourDTO.description,tourDTO.from,tourDTO.to,tourDTO.transportType,tourDTO.distance,tourDTO.time,tourDTO.imagePath);
        for (TourLogDTO tlDTO : tourDTO.tourLogs
        ) {
            mappedTour.addTourLog(new TourLog(tlDTO.tourId, tlDTO.logid, tlDTO.date, tlDTO.time, tlDTO.comment, tlDTO.difficulty, tlDTO.totalTime, tlDTO.rating));
        }
        return mappedTour;
    }
}
