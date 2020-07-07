package lessons.lesson4.app.services;

import lessons.lesson4.app.repositories.data.Author;

import java.util.List;

public interface AuthorService {
    Author get(Long id);
    List<Author> getAll();
    void save(Author author);
    void remove(Author author);
}

