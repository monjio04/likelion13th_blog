package likelion13th.blog.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Article {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String password;
    private LocalDateTime createdAt;


    public Article( Long id,String title, String content, String author, String password){
        this.title = title;
        this.id = id;
        this.content = content;
        this.author = author;
        this.password = password;
        this.createdAt = LocalDateTime.now();
    }
    public Long getId() {return id;}

    public String getContent() {
        return content;
    }
    public String getAuthor() {return author;}

    public String getPassword() {return password;}

    public LocalDateTime getCreatedAt() {return createdAt;}

    public String getTitle() {return title;}
}
