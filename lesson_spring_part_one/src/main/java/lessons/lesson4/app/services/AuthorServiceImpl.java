package lessons.lesson4.app.services;

import lessons.lesson4.app.repositories.AuthorsRepository;
import lessons.lesson4.app.repositories.data.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    private AuthorsRepository authorsRepository;

    @Autowired
    public void setAuthorsRepository(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Author get(Long id) {
        return null; //authorsRepository.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> getAll() {
        return authorsRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Author author) {
        authorsRepository.save(author);
    }

    @Override
    @Transactional
    public void remove(Author author) {
        authorsRepository.delete(author);
    }
}

