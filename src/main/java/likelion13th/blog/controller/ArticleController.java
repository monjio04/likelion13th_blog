package likelion13th.blog.controller;

import likelion13th.blog.domain.Article;
import likelion13th.blog.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @PostMapping()
    public ResponseEntity<Article> createArticle(@RequestBody Article article) throws IllegalAccessException {//spring에서 알아서 article에 맞게 json을 변환함.
        Article newArticle = articleService.addArticle(article);

        return ResponseEntity.status(HttpStatus.CREATED).body(newArticle); //원래 json으로 반환
    }

    @GetMapping()
    public ResponseEntity<List<Article>> getArticle(){

        List<Article> articles = articleService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(articles);
    }

}

