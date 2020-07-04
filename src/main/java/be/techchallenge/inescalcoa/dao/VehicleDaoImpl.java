package be.techchallenge.inescalcoa.dao;

import be.techchallenge.inescalcoa.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("vehicleDao")
public class VehicleDaoImpl implements VehicleDao {

    //private final PostgreSQLTemplate postgreSQLTemplate;

    @Override
    public Vehicle selectVehicleById(Integer vehicleId) {
        return null;
    }

    @Override
    public List<Vehicle> selectAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        return vehicles;
    }
}
