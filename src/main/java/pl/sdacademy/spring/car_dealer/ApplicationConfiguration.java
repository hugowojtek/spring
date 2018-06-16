package pl.sdacademy.spring.car_dealer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sdacademy.spring.car_dealer.controller.CarDataController;
import pl.sdacademy.spring.car_dealer.controller.SellingController;
import pl.sdacademy.spring.car_dealer.repository.*;
import pl.sdacademy.spring.car_dealer.service.CarDataService;
import pl.sdacademy.spring.car_dealer.service.DefaultCarDataService;
import pl.sdacademy.spring.car_dealer.service.DefaultSellingService;
import pl.sdacademy.spring.car_dealer.service.SellingService;

@Configuration
public class ApplicationConfiguration {

    @Bean
    HardDriveVehicleRepository hardDriveVehicleRepository() {
        return new HardDriveVehicleRepository("vehicles.ser");
    }

    @Bean
    HardDriveCustomerRepository hardDriveCustomerRepository() {
        return new HardDriveCustomerRepository("customers.ser");
    }

    @Bean
    HardDrivePurchaseRepository hardDrivePurchaseRepository() {
        return new HardDrivePurchaseRepository("purchases.ser");
    }

    @Bean
    DefaultCarDataService defaultCarDataService(
            VehicleRepository vehicleRepository) {
        return new DefaultCarDataService(vehicleRepository);
    }

    @Bean
    DefaultSellingService defaultSellingService(
            VehicleRepository vehicleRepository,
            CustomerRepository customerRepository,
            PurchaseRepository purchaseRepository) {
        return new DefaultSellingService(vehicleRepository, customerRepository, purchaseRepository);
    }

    @Bean
    CarDataController carDataController(
            CarDataService carDataService) {
        return new CarDataController(carDataService);
    }

    @Bean
    SellingController sellingController(
            SellingService sellingService) {
        return new SellingController(sellingService);
    }

    @Bean
    Application application(
            CarDataController carDataController,
            SellingController sellingController) {
        Application application = new Application();
        application.setCarDataController(carDataController);
        application.setSellingController(sellingController);
        return application;
    }
}
