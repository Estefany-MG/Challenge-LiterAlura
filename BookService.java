import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GutendexApiClient gutendexApiClient;

    public void searchAndSaveBookByTitle(String title) throws IOException, InterruptedException {
        Book existingBook = bookRepository.findByTitle(title);
        if (existingBook != null) {
            System.out.println("El libro ya está registrado en la base de datos.");
            return;
        }

        String response = gutendexApiClient.searchBookByTitle(title);
        JSONObject jsonResponse = new JSONObject(response);
        JSONArray results = jsonResponse.getJSONArray("results");

        if (results.isEmpty()) {
            System.out.println("Libro no encontrado.");
            return;
        }

        JSONObject bookJson = results.getJSONObject(0);
        Book book = new Book();
        book.setTitle(bookJson.getString("title"));
        book.setAuthorLastName(bookJson.getString("author_last_name"));
        book.setAuthorFirstName(bookJson.getString("author_first_name"));
        book.setLanguage(bookJson.getString("language"));
        book.setDownloadCount(bookJson.getInt("download_count"));

        bookRepository.save(book);

        Author author = authorRepository.findByLastNameAndFirstName(book.getAuthorLastName(), book.getAuthorFirstName());
        if (author == null) {
            author = new Author();
            author.setLastName(book.getAuthorLastName());
            author.setFirstName(book.getAuthorFirstName());
            author.setBirthYear(bookJson.getInt("birth_year"));
            author.setDeathYear(bookJson.getInt("death_year"));

            authorRepository.save(author);
        }
        System.out.println("Libro registrado con éxito.");
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getAuthorsAliveInYear(int year) {
        return authorRepository.findByBirthYearLessThanEqualAndDeathYearGreaterThanEqual(year, year);
    }

    public List<Book> getBooksByLanguage(String language) {
        return bookRepository.findAll().stream()
                .filter(book -> book.getLanguage().equalsIgnoreCase(language))
                .collect(Collectors.toList());
    }
}
