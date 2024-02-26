package lyngby.dk.Exercise2;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@NoArgsConstructor

@Table(name = "driver")
@Entity
public class Driver {
    @Id
    private String id;

    @Column(name = "employment_date")
    @Temporal(TemporalType.DATE)
    private Date hiringDate;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "salary")
    private BigDecimal salary;

    @ManyToOne
    private WasteTruck truck;


    public Driver(String name, String surname, BigDecimal salary) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.hiringDate = new Date();
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String driverid (){
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String datePart = sdf.format(hiringDate);
        String xx = String.valueOf(name.charAt(0)) + String.valueOf(surname.charAt(0));
        Random random = new Random();
        int min = 100;
        int max = 999;
        int xxx =   random.nextInt(max-min)+min;
        char l = name.charAt(name.length()-1);
        String driverID = String.format(datePart+"-" + xx + "-" + xxx+l);
        return driverID;







    }
    public Boolean validateDriverId(String driverId) {
        return driverId.matches("[0-9][0-9][0-9][0-9][0-9][0-9]-[A-Z][A-Z]-[0-9][0-9][0-9][A-Z]");
    }

    @PrePersist
    public void prePersist() {
        this.hiringDate = new Date();
        this.id = driverid();

    }


}
