package likelion13th.blog.service;

import likelion13th.blog.domain.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArticleService {
    private final List<Article> articleDB=new ArrayList<>(); //데이터를 임시 저장할 DB
    private Long nextId=1L; //데이터베이스는 여러번 쓰이므로

    public Article addArticle(Article article) throws IllegalAccessException {

        if(article.getAuthor() == null //정보가 비어있는 지 확인
                || article.getContent()== null
                || article.getTitle()==null
                || article.getPassword()==null
                ){
            throw new IllegalArgumentException("제목,내용,작성자,비밀번호는 필수 입력 항목입니다.");
        }

        Article newArticle = new Article(
                nextId++,
                article.getTitle(),
                article.getContent(),
                article.getAuthor(),
                article.getPassword()
        );

        articleDB.add(newArticle);

        return newArticle;
    };

    public List<Article> findAll(){
        return articleDB;
    }

    public Article findById(Long id){

        for(Article article: articleDB){
            if(article.getId().equals(id)){
                return article;
            }
        }

        throw new NoSuchElementException("해당 ID의 게시글을 찾을 수 없습니다.");
    }
}
