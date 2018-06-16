package pl.sdacademy.spring.car_dealer.repository;

import pl.sdacademy.spring.car_dealer.model.Vehicle;

import java.util.List;

public interface VehicleRepository {
    Vehicle byId(Long id);
    List<Vehicle> getAll();
    List<Vehicle> getAvailable();
    Vehicle update(Vehicle vehicle);
}
