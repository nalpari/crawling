package net.nalpari.crawling.repository;

import net.nalpari.crawling.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {
    public Article save(Article article);
    public List<Article> findAll();
}
