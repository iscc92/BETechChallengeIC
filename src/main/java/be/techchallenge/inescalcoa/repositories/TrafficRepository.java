package be.techchallenge.inescalcoa.repositories;

import be.techchallenge.inescalcoa.domain.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrafficRepository extends JpaRepository<Traffic, Long> {

    List<Traffic> findAllByTimestampBetween(Long starTime, Long endTime);

    List<Traffic> findAllByOperatorAndTimestampBetween(String operator, Long starTime, Long endTime);

    List<Traffic> findAllByOperatorAndStopIDAndTimestampBetween(String operator, long stopID, Long starTime, Long endTime);

    List<Traffic> findAllByVehicleIDAndTimestampBetweenOrderByTimestamp(String vehicleId, Long starTime, Long endTime);
}
