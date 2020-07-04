package be.techchallenge.inescalcoa.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "dublin_traffic")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Traffic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private long timestamp;
    private long lineID;
    private long direction;
    private String journeyPatternID;
    private LocalDate timeFrame;
    private long vehicleJourneyID;
    private String operator;
    private String congestion;
    private String lonWGS84;
    private String latWGS84;
    private long delay;
    private String blockID;
    private long vehicleID;
    private long stopID;
    private long atStop;

}
