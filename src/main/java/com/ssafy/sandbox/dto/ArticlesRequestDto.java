package com.ssafy.sandbox.dto;

import com.ssafy.sandbox.domain.Article;
import lombok.Data;

import java.util.List;

@Data
public class ArticlesRequestDto {
    List<Article> articles;
}