package pl.sdacademy.spring.car_dealer;

import pl.sdacademy.spring.car_dealer.model.Customer;
import pl.sdacademy.spring.car_dealer.model.Purchase;
import pl.sdacademy.spring.car_dealer.model.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class DataGenerator {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(createVehicle(1L, "Mazda", "3", "Gasoline", 2008L, 142000L, 21000L, false));
        vehicles.add(createVehicle(2L, "Opel", "Astra", "Gasoline", 2004L, 262000L, 5000L, false));
        vehicles.add(createVehicle(3L, "VW", "Golf II", "Gasoline", 1988L, 422000L, 2000L, true));
        vehicles.add(createVehicle(4L, "BMW", "X5", "Gasoline", 2012L, 97000L, 29999L, false));
        vehicles.add(createVehicle(5L, "Skoda", "Superb", "Oil", 2016L, 180000L, 51000L, false));
        vehicles.add(createVehicle(6L, "Porsche", "Panamera", "Gasoline", 2017L, 12000L, 255000L, false));
        vehicles.add(createVehicle(7L, "Mazda", "6", "Oil", 2012L, 174000L, 27500L, false));
        serialize(vehicles, "vehicles.ser");

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(createCustomer(1L, "Jan", "Kowalski", "ABC123456", "888-888-888"));
        serialize(customers, "customers.ser");

        ArrayList<Purchase> purchases = new ArrayList<>();
        purchases.add(createPurchase(1L, 1L, 3L, 1800L, System.currentTimeMillis()));
        serialize(purchases, "purchases.ser");
    }

    private static void serialize(Serializable data, String location) {
        try (ObjectOutputStream repoOutputStream = new ObjectOutputStream(new FileOutputStream(location))) {
            repoOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Vehicle createVehicle(
            Long id,
            String manufacturer,
            String model,
            String fuel,
            Long productionYear,
            Long mileage,
            Long price,
            Boolean sold
    ) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setManufacturer(manufacturer);
        vehicle.setModel(model);
        vehicle.setFuel(fuel);
        vehicle.setProductionYear(productionYear);
        vehicle.setMileage(mileage);
        vehicle.setSold(sold);
        vehicle.setPrice(price);
        return vehicle;
    }

    private static Customer createCustomer(Long id, String name, String lastname, String documentNo, String telephone) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(name);
        customer.setSurname(lastname);
        customer.setDocumentNo(documentNo);
        customer.setTelephone(telephone);
        return customer;
    }

    private static Purchase createPurchase(Long id, Long customerId, Long vehicleId, Long price, Long date) {
        Purchase purchase = new Purchase();
        purchase.setId(id);
        purchase.setCustomerId(customerId);
        purchase.setVehicleId(vehicleId);
        purchase.setPrice(price);
        purchase.setDate(new Date(date - 100000));
        return purchase;
    }
}
