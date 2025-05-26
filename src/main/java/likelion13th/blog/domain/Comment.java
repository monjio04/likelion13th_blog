package likelion13th.blog.domain;

import jakarta.persistence.*;
import likelion13th.blog.domain.Article;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="article_id", nullable = false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    private Article article;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime createdAt;

}






/*
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
*/
