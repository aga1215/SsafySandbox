package com.ssafy.sandbox.repository;


import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.sandbox.domain.Article;
import com.ssafy.sandbox.domain.QArticle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class QueryDslRepositoryImpl implements QueryDslRepository {

    private final JPAQueryFactory jpaQueryFactory;
    private final QArticle article = QArticle.article;

    // Offset 기반 페이지네이션
    @Override
    public List<Article> findArticlesByOffsetPagination(int pageSize, int offset) {
        return jpaQueryFactory.selectFrom(article)
                .orderBy(article.createdAt.desc().nullsLast()) // null 방지
                .offset(offset)
                .limit(pageSize)
                .fetch();
    }

    // Cursor 기반 페이지네이션
    @Override
    public List<Article> findArticlesByCursorPagination(int pageSize, Long cursorId) {
        Instant cursorCreatedAt = jpaQueryFactory.select(article.createdAt)
                .from(article)
                .where(article.id.eq(cursorId))
                .fetchOne();
        if (cursorCreatedAt == null) {
            cursorCreatedAt = Instant.now();
        }
        return jpaQueryFactory.selectFrom(article)
                .where(
                        article.createdAt.loe(cursorCreatedAt)
                                .and(article.id.ne(cursorId))
                                .and(article.createdAt.isNotNull())
                )
                .orderBy(article.createdAt.desc().nullsLast())
                .limit(pageSize)
                .fetch();
    }

    // 전체 게시물 수 조회
    @Override
    public Long countAllArticles() {
        return jpaQueryFactory.select(article.count())
                .from(article)
                .fetchOne();
    }
}
