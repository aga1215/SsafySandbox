package com.ssafy.sandbox.dto;

import com.ssafy.sandbox.domain.Article;
import lombok.Getter;

import java.util.List;

@Getter
public class ArticleOffsetPageResponseDto {
    private final List<ArticleResponseDto> articles;
    private final Long totalArticleCount;

    private ArticleOffsetPageResponseDto(List<ArticleResponseDto> articles, Long totalArticleCount) {
        this.articles = List.copyOf(articles); // 불변 리스트 생성
        this.totalArticleCount = totalArticleCount;
    }

    public static ArticleOffsetPageResponseDto from(List<Article> articles, Long totalArticleCount) {
        List<ArticleResponseDto> articleDtos = articles.stream()
                .map(ArticleResponseDto::from)
                .toList(); // 스트림의 최종 연산을 명확하게 수행
        return new ArticleOffsetPageResponseDto(articleDtos, totalArticleCount);
    }
}

