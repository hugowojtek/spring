package pl.sdacademy.spring.car_dealer.service;

import pl.sdacademy.spring.car_dealer.model.Customer;
import pl.sdacademy.spring.car_dealer.model.Purchase;
import pl.sdacademy.spring.car_dealer.model.Vehicle;
import pl.sdacademy.spring.car_dealer.repository.CustomerRepository;
import pl.sdacademy.spring.car_dealer.repository.PurchaseRepository;
import pl.sdacademy.spring.car_dealer.repository.VehicleRepository;

import java.util.Date;

public class DefaultSellingService implements SellingService {

    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;
    private final PurchaseRepository purchaseRepository;

    public DefaultSellingService(VehicleRepository vehicleRepository, CustomerRepository customerRepository, PurchaseRepository purchaseRepository) {
        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;
        this.purchaseRepository = purchaseRepository;
    }

    public Purchase sell(Long vehicleId, Customer customer, Long price) {
        Vehicle vehicle = vehicleRepository.byId(vehicleId);
        if (vehicle == null) {
            return null;
        }
        vehicle.setSold(true);
        vehicleRepository.update(vehicle);
        customer = customerRepository.add(customer);
        Purchase purchase = new Purchase();
        purchase.setVehicleId(vehicleId);
        purchase.setCustomerId(customer.getId());
        purchase.setDate(new Date());
        purchase.setPrice(price);
        return purchaseRepository.add(purchase);
    }
}
