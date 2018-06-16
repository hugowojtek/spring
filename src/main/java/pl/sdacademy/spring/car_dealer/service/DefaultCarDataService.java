package pl.sdacademy.spring.car_dealer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdacademy.spring.car_dealer.model.Vehicle;
import pl.sdacademy.spring.car_dealer.repository.VehicleRepository;

import java.util.List;

@Service
public class DefaultCarDataService implements CarDataService {
    private final VehicleRepository vehicleRepository;

    public DefaultCarDataService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> loadCarsThatCanBeSold() {
        return vehicleRepository.getAvailable();
    }
}
