package human;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "human")
public class Human {
    @Id
    @SequenceGenerator(name = "humanSequence", sequenceName = "human_id_sequence", allocationSize = 1)
    @GeneratedValue(generator = "humanSequence")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;
}
