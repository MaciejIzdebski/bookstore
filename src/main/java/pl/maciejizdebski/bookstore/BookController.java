package pl.maciejizdebski.bookstore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.maciejizdebski.bookstore.datamodel.Book;
import pl.maciejizdebski.bookstore.repositories.BookInMemoryRepository;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
public class BookController {

    private final BookInMemoryRepository bookRepository;

    @Autowired
    public BookController(@Qualifier("BookInMemoryRepository")BookInMemoryRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(
            @RequestParam(name = "name", required = false, defaultValue = "") String name){
        try{
            List<Book> books;
            if(name.equals("null"))
                books = bookRepository.getAllBooks();
            else
                books = bookRepository.getBooksByName(name);

            return ResponseEntity.ok(books);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<Book> getBookByISBN(@PathVariable("isbn") String isbn){
        try{
            Book book =  bookRepository.getBookByISBN(isbn);
            return ResponseEntity.ok(book);
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
