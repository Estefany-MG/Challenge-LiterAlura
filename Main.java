import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Bienvenido a LiterAlura");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar libros registrados");
            System.out.println("3. Listar autores registrados");
            System.out.println("4. Listar autores vivos en un año");
            System.out.println("5. Listar libros por idioma");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String title = scanner.nextLine();
                    bookService.searchAndSaveBookByTitle(title);
                    break;
                case 2:
                    List<Book> books = bookService.getAllBooks();
                    books.forEach(System.out::println);
                    break;
                case 3:
                    List<Author> authors = bookService.getAllAuthors();
                    authors.forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Ingrese el año: ");
                    int year = scanner.nextInt();
                    List<Author> aliveAuthors = bookService.getAuthorsAliveInYear(year);
                    aliveAuthors.forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Ingrese el código del idioma (ES, EN, FR, PT): ");
                    String language = scanner.nextLine();
                    List<Book> booksByLanguage = bookService.getBooksByLanguage(language);
                    booksByLanguage.forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
