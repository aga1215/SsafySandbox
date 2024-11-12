package com.ssafy.sandbox.repository;

import com.ssafy.sandbox.domain.Article;

import java.util.List;

public interface QueryDslRepository {

    // Offset 기반 페이지네이션으로 게시물 조회
    List<Article> findArticlesByOffsetPagination(int pageSize, int offset);

    // Cursor 기반 페이지네이션으로 게시물 조회
    List<Article> findArticlesByCursorPagination(int pageSize, Long cursorId);

    // 전체 게시물 수 조회
    Long countAllArticles();
}