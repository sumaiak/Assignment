package lyngby.dk.Exercise2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lyngby.dk.Exercise2.Dao.DriverDAOImpl;
import lyngby.dk.HibernateConfiguration.HibernateConfig;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
        EntityManager em = emf.createEntityManager();

        DriverDAOImpl driverDAO = new DriverDAOImpl();

        Driver driver = driverDAO.getDriverById("230531-WT-642B");
        driver.setSalary(new BigDecimal(90000));
        driverDAO.updateDriver(driver);

        List<Driver> drivers = driverDAO.fetchAllDriversWithSalaryGreaterThan10000();
        drivers.forEach(System.out::println);


    }
}