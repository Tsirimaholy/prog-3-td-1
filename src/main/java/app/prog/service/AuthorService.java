package app.prog.service;

import app.prog.model.Author;
import app.prog.model.exception.NotFoundException;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;

    public List<Author> getAuthors() {
        Pageable pageable = PageRequest.of(0, 5);
        return repository.findByOrderByBirthDateAsc(pageable);
//        return repository.findAll();
    }

    public List<Author> createAuthors(List<Author> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<Author> updateAuthors(List<Author> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public Author deleteAuthor(int AuthorId) {
        /*
        TIPS: From the API, the Class Optional<T> is :
        A container object which may or may not contain a non-null value.
        If a value is present, isPresent() returns true.
        If no value is present, the object is considered empty and isPresent() returns false.

        T is the type of the value, for example : here the class type is BookEntity
         */
        Optional<Author> optional = repository.findById(AuthorId);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new NotFoundException("Author " + AuthorId+ " not found");
        }
    }
}
