package com.ssafy.sandbox.service;

import com.ssafy.sandbox.domain.Article;
import com.ssafy.sandbox.dto.ArticleCursorPageResponseDto;
import com.ssafy.sandbox.dto.ArticleOffsetPageResponseDto;

import java.util.List;

public interface ArticleService {

    ArticleOffsetPageResponseDto fetchArticlesByOffset(int pageSize, int pageNumber);

    ArticleCursorPageResponseDto fetchArticlesByCursor(int pageSize, Long lastArticleId);

    void makeArticles(List<Article> articles);
}
