package pl.sdacademy.spring.car_dealer.repository;

import org.springframework.data.repository.CrudRepository;
import pl.sdacademy.spring.car_dealer.model.Purchase;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
}
