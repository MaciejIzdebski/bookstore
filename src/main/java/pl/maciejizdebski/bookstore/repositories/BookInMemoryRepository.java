package pl.maciejizdebski.bookstore.repositories;


import org.springframework.stereotype.Repository;
import pl.maciejizdebski.bookstore.datamodel.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository("BookInMemoryRepository")
public class BookInMemoryRepository implements BookDao {

    final public List<Book> books = new ArrayList<>();

    public BookInMemoryRepository(){
        books.add(
                new Book(
                        "12345",
                        "Computer Systems: A programmer's perspective",
                        "Randal E. Brayan","David O'Hallaron"));

        books.add(
                new Book(
                        "234",
                        "Przygody Tomka Sawera",
                        "Mark Twain"));

        books.add(
                new Book(
                        "25353",
                        "Modern operating systems",
                        "Andrew Tanenbaum", "Herbert Bos"));
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book getBookByISBN(String isbn) {
        return books.stream()
                .filter( book -> book.getIsbn().equals(isbn) )
                .findFirst()
                .orElseThrow();
    }

    @Override
    public List<Book> getBooksByName(String name) {
        return books.stream()
                .filter( book -> book.getName().contains(name) )
                .collect(Collectors.toList());
    }
}
