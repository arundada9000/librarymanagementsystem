package np.com.onlyrj.LibraryManagementSystem.service;

import np.com.onlyrj.LibraryManagementSystem.exception.BookException;
import np.com.onlyrj.LibraryManagementSystem.payload.dto.BookDTO;
import np.com.onlyrj.LibraryManagementSystem.payload.request.BookSearchRequest;
import np.com.onlyrj.LibraryManagementSystem.payload.response.PageResponse;

import java.util.List;

public interface BookService {

    BookDTO createBook (BookDTO bookDTO) throws BookException;
    List<BookDTO> createBooksBulks(List<BookDTO> bookDTOS) throws BookException;
    BookDTO getBookById(Long bookId) throws BookException;
    BookDTO getBookByISBN(String isbn) throws BookException;
    BookDTO updateBook(Long bookId, BookDTO bookDTO) throws BookException;
    void deleteBook(Long bookId) throws BookException;
    void hardDelete(Long bookId) throws BookException;

    PageResponse<BookDTO> searchBooksWithFilters(
            BookSearchRequest searchRequest
    );

    long getTotalActiveBooks();
    long getTotalAvailableBooks();

}
