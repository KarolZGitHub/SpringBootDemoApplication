package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    private AuthorDao authorDao;
    private AuthorRepository authorRepository;

    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void save(Author author) {
        authorDao.save(author);
    }

    public Author findById(Long id) {
        return authorDao.findById(id);
    }

    public List<Author> findAll() {
        return authorDao.findAll();
    }

    public void update(Author author) {
        authorDao.update(author);
    }

    public void deleteById(Long id) {
        authorDao.deleteById(id);
    }
    public List<Author> FindAuthorWhereEmailStartsAt(String start){
        return authorRepository.emailStartsAt(start);
    }
    public List<Author> findAuthorWherePeselStartsAt(String starts){
        return authorRepository.peselStartsAt(starts);
    }
}
