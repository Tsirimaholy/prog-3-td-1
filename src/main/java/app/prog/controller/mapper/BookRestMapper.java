package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.BookEntity;
import app.prog.repository.BookRepository;
import org.springframework.stereotype.Component;

@Component
public class BookRestMapper {
    private final BookRepository bookRepository;

    public BookRestMapper(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponse toRest(BookEntity domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor().getName())
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public BookEntity toDomain(CreateBookResponse rest) {
        String authorName = rest.getAuthor() != null ? rest.getAuthor() : null;
        BookEntity bookByAuthor = bookRepository.findByAuthorName(authorName);

        return BookEntity.builder()
                .author(bookByAuthor.getAuthor())
                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toDomain(UpdateBookResponse rest) {
        String authorName = rest.getAuthor() != null ? rest.getAuthor() : null;
        BookEntity bookByAuthor = bookRepository.findByAuthorName(authorName);

        return BookEntity.builder()
                .id(rest.getId())
                .author(bookByAuthor.getAuthor())
                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }
}
