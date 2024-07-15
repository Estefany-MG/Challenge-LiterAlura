# LiterAlura

LiterAlura es una aplicación de consola que permite registrar libros en una base de datos y obtener información sobre ellos utilizando la API de Gutendex.

## Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Gutendex API

## Requisitos

- JDK 17
- PostgreSQL
- Maven

## Configuración del Proyecto

1. Clona el repositorio:

    ```bash
    git clone https://github.com/tu_usuario/literalura.git
    cd literalura
    ```

2. Configura la base de datos PostgreSQL:

    ```sql
    CREATE DATABASE literalura;
    CREATE USER tu_usuario WITH PASSWORD 'tu_contraseña';
    GRANT ALL PRIVILEGES ON DATABASE literalura TO tu_usuario;
    ```

3. Configura las credenciales de la base de datos en el archivo `src/main/resources/application.properties`.

4. Ejecuta el proyecto:

    ```bash
    mvn spring-boot:run
    ```

## Uso

1. Al iniciar la aplicación, sigue las instrucciones en la consola para interactuar con la aplicación.

## Funcionalidades

1. **Buscar libro por título:** Permite buscar un libro en la API de Gutendex por su título y registrarlo en la base de datos.
2. **Listar libros registrados:** Muestra todos los libros registrados en la base de datos.
3. **Listar autores registrados:** Muestra todos los autores registrados en la base de datos.
4. **Listar autores vivos en un año:** Muestra los autores que estaban vivos en un año específico.
5. **Listar libros por idioma:** Muestra los libros registrados en la base de datos filtrados por idioma.

## Contribución

Si deseas contribuir a este proyecto, por favor haz un fork del repositorio y crea un pull request con tus cambios.


