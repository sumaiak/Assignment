package lyngby.dk.Exercise2.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lyngby.dk.Exercise2.Driver;
import lyngby.dk.HibernateConfiguration.HibernateConfig;

import java.math.BigDecimal;
import java.util.List;

public class DriverDAOImpl implements IDriverDAO{
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    @Override
    public void saveDriver(String name, String surname, BigDecimal salary) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(new Driver(name, surname, salary));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Driver getDriverById(String id) {
        EntityManager em = emf.createEntityManager();
        Driver driver = em.find(Driver.class, id);
        em.close();
        return driver;
    }

    @Override
    public Driver updateDriver(Driver driver) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Driver driver1 = em.merge(driver);
        em.getTransaction().commit();
        em.close();
        return driver1;
    }

    @Override
    public void deleteDriver(String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Driver.class, id));
        em.getTransaction().commit();
        em.close();

    }
    @Override
    public List<Driver> findAllDriversEmployedAtTheSameYear(String year) {
        EntityManager em = emf.createEntityManager();
        List<Driver> drivers = em.createQuery("SELECT d FROM Driver d WHERE YEAR(d.hiringDate) = :year", Driver.class).setParameter("year", year).getResultList();
        em.close();
        return drivers;
    }

    @Override
    public List<Driver> fetchAllDriversWithSalaryGreaterThan10000() {
        EntityManager em = emf.createEntityManager();
        List<Driver> drivers = em.createQuery("SELECT d FROM Driver d WHERE d.salary > 10000", Driver.class).getResultList();
        em.close();
        return  drivers;

    }

    @Override
    public double fetchHighestSalary() {
        EntityManager em = emf.createEntityManager();
        double highestSalary = (double) em.createQuery("SELECT MAX(d.salary) FROM Driver d").getSingleResult();
       em.close();
       return highestSalary;
    }

    @Override
    public List<String> fetchFirstNameOfAllDrivers() {
        EntityManager em = emf.createEntityManager();
        List<String>names = em.createQuery("SELECT n.name from Driver n",String.class).getResultList();
        em.close();
        return  names;
    }

    @Override
    public long calculateNumberOfDrivers() {
        EntityManager em = emf.createEntityManager();
        long numberOfDrivers = (long) em.createQuery("SELECT COUNT(d) FROM Driver d").getSingleResult();
        em.close();
        return numberOfDrivers;
    }

    @Override
    public Driver fetchDriverWithHighestSalary() {
        EntityManager em = emf.createEntityManager();
        Driver driver = (Driver) em.createQuery("SELECT d FROM Driver d WHERE d.salary = (SELECT MAX(d.salary) FROM Driver d)", Driver.class).getSingleResult();
        em.close();
        return driver;
        }
}
