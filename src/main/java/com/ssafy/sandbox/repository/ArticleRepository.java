package com.ssafy.sandbox.repository;

import com.ssafy.sandbox.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article, Long>, QueryDslRepository {
}