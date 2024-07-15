import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String authorLastName;
    private String authorFirstName;
    private String language;
    private int downloadCount;

    // Getters y Setters

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", authorLastName=" + authorLastName + ", authorFirstName="
                + authorFirstName + ", language=" + language + ", downloadCount=" + downloadCount + "]";
    }
}
