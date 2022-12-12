package app.prog.repository;

import app.prog.model.Author;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Query("select a from Author a order by a.birthDate asc ")
    List<Author> findByOrderByBirthDateAsc(Pageable pageable);
}
