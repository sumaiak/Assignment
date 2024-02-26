package lyngby.dk.Exercise1;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "note")
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String notes;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    private String createdBy;

    @ManyToOne
    private Person person;

    public Notes(String notes, String createdBy) {
        this.notes = notes;
        this.createdBy = createdBy;
    }

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }
}
