package pl.sdacademy.spring.car_dealer.repository;

import org.springframework.stereotype.Repository;
import pl.sdacademy.spring.car_dealer.model.Customer;

@Repository
public class FakeCustomerRepository implements CustomerRepository {
    @Override
    public Customer byId(Long id) {
        return null;
    }

    @Override
    public Customer add(Customer customer) {
        return customer;
    }
}
