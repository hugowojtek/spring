package pl.sdacademy.spring.car_dealer.repository;

import pl.sdacademy.spring.car_dealer.model.Customer;

public interface CustomerRepository {
    Customer byId(Long id);
    Customer add(Customer customer);
}
