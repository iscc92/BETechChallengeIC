package be.techchallenge.inescalcoa.service;

import be.techchallenge.inescalcoa.domain.Traffic;
import be.techchallenge.inescalcoa.model.Gps;
import be.techchallenge.inescalcoa.repositories.TrafficRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TrafficService {

    private final TrafficRepository trafficRepository;


    public List<String> getListOfRunningOperators(Long startTime, Long endTime) {
        return trafficRepository.findAllByTimestampBetween(startTime, endTime)
                .stream()
                .map(Traffic::getOperator)
                .distinct()
                .collect(Collectors.toList());
    }


    public List<Long> getListOfVehicleIDsForAnOperator(String operator, Long starTime, Long endTime) {
        return trafficRepository.findAllByOperatorAndTimestampBetween(operator, starTime, endTime)
                .stream()
                .map(Traffic::getVehicleID)
                .collect(Collectors.toList());
    }


    public List<Long> getListOfVehicleIDsFromAFleetAtAStop(String operator, long stopID, Long starTime, Long endTime) {
        return trafficRepository.findAllByOperatorAndStopIDAndTimestampBetween(operator, stopID,
                starTime, endTime)
                .stream()
                .map(Traffic::getVehicleID)
                .collect(Collectors.toList());
    }


    public List<Gps> getGPSTraceByVehicle(String vehicleId, Long starTime, Long endTime) {
        return trafficRepository.findAllByVehicleIDAndTimestampBetweenOrderByTimestamp(vehicleId, starTime, endTime)
                .stream()
                .map(e -> new Gps(e.getTimestamp(), e.getLatWGS84(), e.getLonWGS84()))
                .collect(Collectors.toList());
    }
}
