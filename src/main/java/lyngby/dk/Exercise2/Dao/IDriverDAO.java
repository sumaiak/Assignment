package lyngby.dk.Exercise2.Dao;

import lyngby.dk.Exercise2.Driver;

import java.math.BigDecimal;
import java.util.List;

public interface IDriverDAO {
    // Driver
    void saveDriver(String name, String surname, BigDecimal salary);
    Driver getDriverById(String id);
    Driver updateDriver(Driver driver);
    void deleteDriver(String id);
    List<Driver> findAllDriversEmployedAtTheSameYear(String year);
    List<Driver> fetchAllDriversWithSalaryGreaterThan10000();
    double fetchHighestSalary();
    List<String> fetchFirstNameOfAllDrivers();
    long calculateNumberOfDrivers();
    Driver fetchDriverWithHighestSalary();
}
