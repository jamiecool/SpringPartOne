package lessons.lesson4.app.repositories;

import lessons.lesson4.app.repositories.data.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends JpaRepository<Article, Long> {
}

