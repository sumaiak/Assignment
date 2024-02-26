package lyngby.dk.Exercise2.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lyngby.dk.Exercise2.Driver;
import lyngby.dk.Exercise2.WasteTruck;
import lyngby.dk.HibernateConfiguration.HibernateConfig;

import java.util.List;

public class WasteTruckDAOImpl implements IWasteTruckDAO {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    @Override
    public void saveWasteTruck(String brand, String registrationNumber, int capacity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(new WasteTruck(brand, capacity, registrationNumber));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public WasteTruck getWasteTruckById(int id) {
        EntityManager em = emf.createEntityManager();
        WasteTruck wasteTruck = em.find(WasteTruck.class, id);
        em.close();
        return wasteTruck;
    }

    @Override
    public void setWasteTruckAvailable(WasteTruck wasteTruck, boolean available) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        wasteTruck.setAvailable(available);
        em.merge(wasteTruck);
        em.getTransaction().commit();
        em.close();


    }

    @Override
    public void deleteWasteTruck(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(WasteTruck.class, id));
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void addDriverToWasteTruck(WasteTruck wasteTruck, Driver driver) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        wasteTruck.addDriver(driver);
        em.merge(wasteTruck);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void removeDriverFromWasteTruck(WasteTruck wasteTruck, String id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        wasteTruck.getDrivers().removeIf(driver -> driver.getId().equals(id));
        em.merge(wasteTruck);
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public List<WasteTruck> getAllAvailableTrucks() {
        EntityManager em = emf.createEntityManager();
        List<WasteTruck> wasteTrucks = em.createQuery("SELECT w FROM WasteTruck w WHERE w.isAvailable = true", WasteTruck.class).getResultList();
        em.close();
        return wasteTrucks;
    }
}
