package pl.sdacademy.spring.car_dealer.controller;

import pl.sdacademy.spring.car_dealer.model.Customer;
import pl.sdacademy.spring.car_dealer.service.SellingService;

import java.util.Scanner;

public class SellingController {

    private final SellingService sellingService;

    public SellingController(SellingService sellingService) {
        this.sellingService = sellingService;
    }

    public void buyVehicle(Long vehicleId) {
        Customer customer = getCustomerData();
        Long customerPrice = getCustomerPrice();
        sellingService.sell(vehicleId, customer, customerPrice);
    }

    private Customer getCustomerData() {
        Customer customer = new Customer();
        System.out.println("Provide customer data:");
        System.out.print("   Name: ");
        customer.setName(readInput());
        System.out.print("   Last name: ");
        customer.setSurname(readInput());
        System.out.print("   Document number: ");
        customer.setDocumentNo(readInput());
        System.out.print("   Telephone: ");
        customer.setTelephone(readInput());
        return customer;
    }

    private Long getCustomerPrice() {
        while (true) {
            try {
                System.out.print("Selling price for this customer: ");
                return Long.parseLong(readInput());
            } catch (NumberFormatException e) {
                System.out.println("Invalid price. Provide again.");
            }
        }
    }

    private String readInput() {
        return new Scanner(System.in).nextLine();
    }
}
