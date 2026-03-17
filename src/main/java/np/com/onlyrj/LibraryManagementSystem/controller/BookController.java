package np.com.onlyrj.LibraryManagementSystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import np.com.onlyrj.LibraryManagementSystem.exception.BookException;
import np.com.onlyrj.LibraryManagementSystem.models.Book;
import np.com.onlyrj.LibraryManagementSystem.payload.dto.BookDTO;
import np.com.onlyrj.LibraryManagementSystem.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO) throws BookException {
        BookDTO createBook = bookService.createBook(bookDTO);
        return ResponseEntity.ok(createBook);
    }


    @PostMapping
    public ResponseEntity<BookDTO> createBooksBulk(@Valid @RequestBody BookDTO bookDTO) throws BookException {
        List<BookDTO> createBooks = bookService.cre
    }
}
