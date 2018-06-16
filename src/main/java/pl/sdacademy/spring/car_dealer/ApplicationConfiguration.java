package pl.sdacademy.spring.car_dealer;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import pl.sdacademy.spring.car_dealer.controller.CarDataController;
import pl.sdacademy.spring.car_dealer.controller.SellingController;
import pl.sdacademy.spring.car_dealer.repository.*;
import pl.sdacademy.spring.car_dealer.service.CarDataService;
import pl.sdacademy.spring.car_dealer.service.DefaultCarDataService;
import pl.sdacademy.spring.car_dealer.service.DefaultSellingService;
import pl.sdacademy.spring.car_dealer.service.SellingService;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfiguration {

    @Bean
    static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    HardDriveVehicleRepository hardDriveVehicleRepository(
            @Value("${repository.vehicle.hardDriveLocation}") String vehicleRepositoryLocation) {
        return new HardDriveVehicleRepository(vehicleRepositoryLocation);
    }

    @Bean
    HardDriveCustomerRepository hardDriveCustomerRepository(
            @Value("${repository.customer.hardDriveLocation}")
            String customerRepositoryLocation) {
        return new HardDriveCustomerRepository(customerRepositoryLocation);
    }

    @Bean
    HardDrivePurchaseRepository hardDrivePurchaseRepository(
            @Value("${repository.purchase.hardDriveLocation}")
            String purchaseRepositoryLocation) {
        return new HardDrivePurchaseRepository(purchaseRepositoryLocation);
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

    @Bean(autowire = Autowire.BY_TYPE)
    Application application() {
        return new Application();
    }

}
