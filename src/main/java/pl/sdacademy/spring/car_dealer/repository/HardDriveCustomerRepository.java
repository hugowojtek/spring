package pl.sdacademy.spring.car_dealer.repository;

import pl.sdacademy.spring.car_dealer.model.Customer;

import java.util.List;

public class HardDriveCustomerRepository extends AbstractHardDriveRepository<Customer> implements CustomerRepository {
    private final String repositoryLocation = "customers.ser";

    public Customer byId(Long id) {
        return loadAllElements().stream().filter(customer -> customer.getId().equals(id)).findAny().orElse(null);
    }

    public Customer add(Customer customer) {
        List<Customer> customers = loadAllElements();
        Long newCustomerId = getNextId(customers);
        customer.setId(newCustomerId);
        customers.add(customer);
        saveAllElements(customers);
        return customer;
    }

    @Override
    protected String getRepositoryLocation() {
        return repositoryLocation;
    }
}
