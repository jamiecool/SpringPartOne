package lessons.lesson4.app.services;

import lessons.lesson4.app.repositories.data.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAll();
    Article get(Long id);
    void save(Article article);
}

