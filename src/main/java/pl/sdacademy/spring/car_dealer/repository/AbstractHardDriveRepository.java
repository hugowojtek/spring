package pl.sdacademy.spring.car_dealer.repository;

import pl.sdacademy.spring.car_dealer.model.BaseModel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHardDriveRepository<T extends BaseModel> {

    protected abstract String getRepositoryLocation();

    protected List<T> loadAllElements() {
        try (ObjectInputStream repoInputStream = new ObjectInputStream(new FileInputStream(getRepositoryLocation()))) {
            return (ArrayList<T>) repoInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    protected void saveAllElements(List<T> data) {
        try (ObjectOutputStream repoOutputStream = new ObjectOutputStream(new FileOutputStream(getRepositoryLocation()))) {
            repoOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected Long getNextId(List<T> modelObjects) {
        return modelObjects.stream().map(BaseModel::getId).max(Long::compare).orElse(1L);
    }
}
