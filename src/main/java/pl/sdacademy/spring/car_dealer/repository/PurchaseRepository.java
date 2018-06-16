package pl.sdacademy.spring.car_dealer.repository;

import pl.sdacademy.spring.car_dealer.model.Purchase;

import java.util.List;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Purchase add(Purchase purchase);
}
