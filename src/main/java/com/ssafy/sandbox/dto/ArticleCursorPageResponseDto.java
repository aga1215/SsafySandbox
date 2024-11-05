package com.ssafy.sandbox.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.ssafy.sandbox.domain.Article;

import lombok.Getter;

@Getter
public class ArticleCursorPageResponseDto {
    private final List<ArticleResponseDto> articles;
    private final Long lastId;

    private ArticleCursorPageResponseDto(List<ArticleResponseDto> articles, Long lastId) {
        this.articles = articles;
        this.lastId = lastId;
    }

    public static ArticleCursorPageResponseDto from(List<Article> articles, Long lastId) {
        List<ArticleResponseDto> articleDtos = articles.stream()
                .map(ArticleResponseDto::from)
                .collect(Collectors.toList());
        return new ArticleCursorPageResponseDto(articleDtos, lastId);
    }
}
