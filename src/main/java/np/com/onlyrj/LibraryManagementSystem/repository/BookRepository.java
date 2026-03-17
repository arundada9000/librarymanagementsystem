package np.com.onlyrj.LibraryManagementSystem.repository;

import np.com.onlyrj.LibraryManagementSystem.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);

    boolean existByIsbn (String isbn);

    @Query("SELECT b FROM Book b WHERE b.active = true AND (" +
            ":searchTerm IS NULL OR " +
            "LOWER(b.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(b.author) LIKE LOWER(CONCAT('%', :searchTerm, '%')) OR " +
            "LOWER(b.isbn) LIKE LOWER(CONCAT('%', :searchTerm, '%'))" +
            "(:genreId IS NULL OR b.genre.id = :genreId) AND " +
            "(:availableOnly == flase OR b.availableCopies>0) AND" +

            "b.active = true"

    )

    Page<Book> searchBookWithFilters(
            @Param("searchTerm") String searchTerm,
            @Param("genreId") Long genreId,
            @Param("availableOnly") boolean availableOnly,
            Pageable pageable
    );


    long countByActiveTrue();

    @Query("select count(b) from Book b where b.availableCopies>0 and b.active=true")
    long countAvailableBooks();


}
