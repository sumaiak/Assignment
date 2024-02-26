package lyngby.dk.Exercise1;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "fee")
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double amount;
    private LocalDate date;

    @ManyToOne
    private Person person;

    public Fee(double amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

}
