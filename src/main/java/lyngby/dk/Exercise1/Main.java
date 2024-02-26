package lyngby.dk.Exercise1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lyngby.dk.HibernateConfiguration.HibernateConfig;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args){

        System.out.println("hello dolphin");
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
        Person person = new Person("mousa");
        Person person1 = new Person("sumaia");
        PersonDetails personDetails = new PersonDetails ("sulsehomen",2450,"sydhavn",28);
        PersonDetails personDetails1 = new PersonDetails ("strandvangen",2650,"hvidovre",20);
        person.addPersonDetail(personDetails);
        person1.addPersonDetail(personDetails1);
        Fee fee = new Fee(500.12, LocalDate.of(2012,12,04));
        Fee fee1 = new Fee(900.50, LocalDate.of(2024,12,30));
        person.addFee(fee);
        person.addFee(fee1);
        Notes notes = new Notes("i need to to a meeting","sumaia");
        Notes notes1 = new Notes("i need to to a meeting","sumaia");
        person.addNote(notes);
        person.addNote(notes1);

        DolphinDAO dao = new DolphinDAO();
        dao.save(person);
        Person personById = dao.findById(7);
        dao.getTotalAmount(personById);
        dao.getAllNotes(personById);
        System.out.println(personById);












    }
}