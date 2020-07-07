package lessons.lesson4.app.services;

import lessons.lesson4.app.repositories.ArticlesRepository;
import lessons.lesson4.app.repositories.data.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    private ArticlesRepository articlesRepository;

    @Autowired
    public void setArticlesRepository(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Article> getAll() {
        return articlesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Article get(Long id) {
        return null;//articlesRepository.findOne(id);
    }

    @Override
    @Transactional
    public void save(Article article) {
        articlesRepository.save(article);
    }
}
