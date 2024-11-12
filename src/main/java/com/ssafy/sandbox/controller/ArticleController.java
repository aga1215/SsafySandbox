package com.ssafy.sandbox.controller;

import com.ssafy.sandbox.dto.ArticleCursorPageResponseDto;
import com.ssafy.sandbox.dto.ArticleOffsetPageResponseDto;
import com.ssafy.sandbox.dto.ArticlesRequestDto;
import com.ssafy.sandbox.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/paging/offset")
    public ResponseEntity<ArticleOffsetPageResponseDto> getArticlesWithOffset(
            @RequestParam Integer size,
            @RequestParam Integer page) {
        return ResponseEntity.ok(articleService.fetchArticlesByOffset(size, page));
    }

    @GetMapping("/paging/cursor")
    public ResponseEntity<ArticleCursorPageResponseDto> getArticlesWithCursor(
            @RequestParam Integer size,
            @RequestParam Long cursorId) {
        return ResponseEntity.ok(articleService.fetchArticlesByCursor(size, cursorId));
    }

    @PostMapping("/make")
    public ResponseEntity<Void> makeArticles(@RequestBody ArticlesRequestDto makeArticlesRequestDto) {
        articleService.makeArticles(makeArticlesRequestDto.getArticles());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
