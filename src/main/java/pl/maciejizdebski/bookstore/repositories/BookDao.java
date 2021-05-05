package pl.maciejizdebski.bookstore.repositories;

import pl.maciejizdebski.bookstore.datamodel.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAllBooks();
    Book getBookByISBN(String isbn);
    List<Book> getBooksByName(String name);
}
