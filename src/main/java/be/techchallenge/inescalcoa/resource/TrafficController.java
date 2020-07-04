package be.techchallenge.inescalcoa.resource;

import be.techchallenge.inescalcoa.model.Gps;
import be.techchallenge.inescalcoa.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/vehicles")
public class TrafficController {

    private TrafficService trafficService;

    @Autowired
    public TrafficController(TrafficService trafficService) {
        this.trafficService = trafficService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{start-time}/{end-time}")
    public List<String> getRunningOperators(@PathVariable("{start-time}") Long startTime,
                                            @PathVariable("{end-time}") Long endTime) {

        return trafficService.getListOfRunningOperators(startTime, endTime);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{operator}/{start-time}/{end-time}")
    public List<Long> getListOfVehicleIDsForAnOperator(@PathVariable("{operator}") String operator,
                                                       @PathVariable("{start-time}") Long starTime,
                                                       @PathVariable("{end-time}") Long endTime) {

        return trafficService.getListOfVehicleIDsForAnOperator(operator, starTime, endTime);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{operator}/{stopID}/{start-time}/{end-time}")
    public List<Long> getListOfVehicleIDsFromTheSameOperatorAtStop(@PathVariable("{operator}") String operator,
                                                                   @PathVariable("{stopID}") Long stopID,
                                                                   @PathVariable("{start-time}") Long starTime,
                                                                   @PathVariable("{end-time}") Long endTime) {

        return trafficService.getListOfVehicleIDsFromAFleetAtAStop(operator, stopID, starTime, endTime);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            path = "{vehicleId}/{start-time}/{end-time}")
    public List<Gps> getGPStraceOfVehicle(@PathVariable("{vehicleId}") String vehicleId,
                                          @PathVariable("{start-time}") Long starTime,
                                          @PathVariable("{end-time}") Long endTime) {

        return trafficService.getGPSTraceByVehicle(vehicleId, starTime, endTime);
    }

}
