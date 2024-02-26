package lyngby.dk.Exercise2.Dao;

import lyngby.dk.Exercise2.Driver;
import lyngby.dk.Exercise2.WasteTruck;

import java.util.List;

public interface IWasteTruckDAO {
    // WasteTruck
    void saveWasteTruck(String brand, String registrationNumber, int capacity);
    WasteTruck getWasteTruckById(int id);
    void setWasteTruckAvailable(WasteTruck wasteTruck, boolean available);
    void deleteWasteTruck(int id);
    void addDriverToWasteTruck(WasteTruck wasteTruck, Driver driver);
    void removeDriverFromWasteTruck(WasteTruck wasteTruck, String id);
    List<WasteTruck> getAllAvailableTrucks();
}
