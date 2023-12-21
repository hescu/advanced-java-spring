package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    List<Book> queryByTitle(String name);
    List<Book> readByTitle(String name);
    List<Book> findByTitle(String name);
    List<Book> getByTitle(String name);

    List<Book> findByTitleContaining(String pattern);

    List<Book> findByTitleIs(String name);
    Book findByIsbnIs(String isbn);

    List<Book> findByAuthors_lastName(String authorName);

    List<Book> findByPagesLessThanEqual(int pages);
    List<Book> findByPagesGreaterThanEqual(int pages);
}
