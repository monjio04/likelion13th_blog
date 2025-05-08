package likelion13th.blog.domain;

import java.time.LocalDateTime;

public class Comment {
    private Long id;
    private Long article;
    private String author;
    private String content;
    private LocalDateTime created_at;
    private String password;

    public Comment(Long id, Long article, String author, String content, String password) {
        this.id = id;
        this.article = article;
        this.author = author;
        this.content = content;
        this.created_at = LocalDateTime.now();
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }
    public String getContent() {
        return content;
    }

    public Long getArticle() {
        return article;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public String getPassword() {
        return password;
    }
}
