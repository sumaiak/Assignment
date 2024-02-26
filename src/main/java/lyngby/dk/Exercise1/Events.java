package lyngby.dk.Exercise1;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Events {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    Integer id;
    String name;
    LocalDate date;

    public Events(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }
}
