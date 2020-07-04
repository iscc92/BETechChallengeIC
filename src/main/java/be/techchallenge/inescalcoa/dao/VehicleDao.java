package be.techchallenge.inescalcoa.dao;

import be.techchallenge.inescalcoa.model.Vehicle;

import java.util.List;

public interface VehicleDao {

    Vehicle selectVehicleById(Integer vehicleId);

    List<Vehicle> selectAllVehicles();

}
