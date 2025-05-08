package likelion13th.blog.controller;

import likelion13th.blog.domain.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final List<Article> articleDB=new ArrayList<>(); //데이터를 임시 저장할 DB
    private Long nextId=1L; //고유번호

    @PostMapping()
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {//spring에서 알아서 article에 맞게 json을 변환함.
        Article newArticle = new Article(
                nextId++,
                article.getTitle(),
                article.getContent(),
                article.getAuthor(),
                article.getPassword()
        );

        articleDB.add(newArticle);

        return ResponseEntity.status(HttpStatus.CREATED).body(newArticle); //원래 json으로 반환
    }

    @GetMapping()
    public ResponseEntity<List<Article>> getArticle(){
        return ResponseEntity.status(HttpStatus.OK).body(articleDB);
    }

}

