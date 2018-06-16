package pl.sdacademy.spring.car_dealer.repository;

import pl.sdacademy.spring.car_dealer.model.Purchase;

import java.util.List;

public class HardDrivePurchaseRepository extends AbstractHardDriveRepository<Purchase> implements PurchaseRepository {
    private final String repositoryLocation;

    public HardDrivePurchaseRepository(String repositoryLocation) {
        this.repositoryLocation = repositoryLocation;
    }

    @Override
    public List<Purchase> getAll() {
        return loadAllElements();
    }

    @Override
    public Purchase add(Purchase purchase) {
        List<Purchase> purchases = loadAllElements();
        Long newPurchaseId = getNextId(purchases);
        purchase.setId(newPurchaseId);
        purchases.add(purchase);
        saveAllElements(purchases);
        return purchase;
    }

    @Override
    protected String getRepositoryLocation() {
        return repositoryLocation;
    }
}
