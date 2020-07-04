package be.techchallenge.inescalcoa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Gps {

    private long timestamp;
    private String lonWGS84;
    private String latWGS84;

}
