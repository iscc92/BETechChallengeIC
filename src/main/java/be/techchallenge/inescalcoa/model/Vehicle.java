package be.techchallenge.inescalcoa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Vehicle {

    private int id;
    private int lineId;
    private int direction;
    private String journeyPatternId;
    private LocalDate timeFrame;
    private int vehicleJourneyId;
    private String operator;
    private int congestion;
    private String longitude;
    private String latitude;
    private int delay;
    private String blockId;
    private int atStop;

}
