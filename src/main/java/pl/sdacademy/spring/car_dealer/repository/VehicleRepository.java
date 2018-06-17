package pl.sdacademy.spring.car_dealer.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.spring.car_dealer.model.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}
