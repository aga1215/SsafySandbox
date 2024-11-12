package com.ssafy.sandbox.service;

import com.ssafy.sandbox.domain.Article;
import com.ssafy.sandbox.dto.ArticleCursorPageResponseDto;
import com.ssafy.sandbox.dto.ArticleOffsetPageResponseDto;
import com.ssafy.sandbox.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository articleRepository;


    @Override
    public ArticleOffsetPageResponseDto fetchArticlesByOffset(int pageSize, int pageNumber) {
        int offset = pageNumber * pageSize;
        List<Article> articles = articleRepository.findArticlesByOffsetPagination(pageSize, offset);
        Long totalCount = articleRepository.countAllArticles();
        return ArticleOffsetPageResponseDto.from(articles, totalCount);
    }

    @Override
    public ArticleCursorPageResponseDto fetchArticlesByCursor(int pageSize, Long lastArticleId) {
        List<Article> articles = articleRepository.findArticlesByCursorPagination(pageSize, lastArticleId);
        Long lastId = articles.isEmpty() ? null : articles.get(articles.size() - 1).getId();
        return ArticleCursorPageResponseDto.from(articles, lastId);
    }

    @Override
    public void makeArticles(List<Article> articles) {
        articleRepository.saveAll(articles);
    }
}