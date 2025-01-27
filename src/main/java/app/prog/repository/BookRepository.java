package app.prog.repository;

import app.prog.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Integer> {
    BookEntity findByAuthorName(String authorName);
}
