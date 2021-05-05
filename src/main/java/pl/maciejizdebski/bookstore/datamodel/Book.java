package pl.maciejizdebski.bookstore.datamodel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Book {
    final String isbn;
    final String name;
    final List<String> authors;

    public Book(String isbn, String name, String... authors){
        this.isbn = isbn;
        this.name = name;
        this.authors = Arrays.stream(authors).collect(Collectors.toList());
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public List<String> getAuthors() {
        return authors;
    }
}
