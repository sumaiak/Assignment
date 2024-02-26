package lyngby.dk.Exercise1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lyngby.dk.HibernateConfiguration.HibernateConfig;

public class DolphinDAO {
    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public Person save(Person person)
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
        return person;
    }

    public Person findById(int id)
    {
        EntityManager em = emf.createEntityManager();
        Person person = em.find(Person.class, id);
        em.close();
        return person;
    }

    public Person update(Person person) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person updatedUnicorn = em.merge(person);
        em.getTransaction().commit();
        em.close();
        return updatedUnicorn;
    }
  public void getTotalAmount(Person p) {
      EntityManager em = emf.createEntityManager();
      em.getTransaction().begin();
      em.createQuery("SELECT f FROM Fee f WHERE f.person = :person", Fee.class).setParameter("person", p).getResultList();
      em.getTransaction().commit();
      em.close();
  }
    public void getAllNotes(Person p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.createQuery("SELECT n FROM Notes n WHERE n.person = :person", Notes.class).setParameter("person", p).getResultList();
        em.getTransaction().commit();
        em.close();
    }







  }


