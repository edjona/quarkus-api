package user.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "userSequence", sequenceName = "user_id_sequence", allocationSize = 1)
    @GeneratedValue(generator = "userSequence")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "avatar")
    private String avatar;
}
