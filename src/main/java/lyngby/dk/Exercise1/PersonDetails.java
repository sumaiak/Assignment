package lyngby.dk.Exercise1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@Entity
@NoArgsConstructor


public class PersonDetails {
@Id
    private Integer id;
    private String address;
    private int zip;
    private  String City;
    private int age;
    //RELATIONER 1:1

  //has one to one relation,mapid is used to mark that the id of this same id of person but a doregin key
    @OneToOne
    @MapsId
    private Person person;

    public PersonDetails(String address, int zip, String city, int age) {
        this.address = address;
        this.zip = zip;
        City = city;
        this.age = age;

    }
}
