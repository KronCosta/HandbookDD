package entyti;


import entyti.enums.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Getter
@Setter
@Accessors(chain = true)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "emp_date")
    private LocalDate employedDate;

    @Column(name = "email", length = 50, unique = true)
    private String email;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "position", length = 50)
    private String position;


    @Enumerated(EnumType.STRING)
    @Column(name = "role", columnDefinition = "enum('USER', 'MODERATOR', 'ADMIN')")
    private Role role;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employedDate=" + employedDate +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", role=" + '}';
    }
}
