import javax.persistence.*;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;
    private String firstName;
    private Integer birthYear;
    private Integer deathYear;

    // Getters y Setters

    @Override
    public String toString() {
        return "Author [id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", birthYear=" + birthYear
                + ", deathYear=" + deathYear + "]";
    }
}
