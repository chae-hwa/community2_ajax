package com.ll.exam.article.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // json이 안 될 때 붙여넣기 (인자없는 생성자)
@AllArgsConstructor
public class ArticleDto {
    private long id;
    private String title;
    private String body;
}
