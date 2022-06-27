package multilng.withhibernate.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 200)
    private String title;

    @Column(name = "short_content", columnDefinition = "text")
    private String short_content;

    @Column(name = "content", columnDefinition = "text")
    private String content;

    @Column(name = "post_date", columnDefinition = "timestamp")
    private Timestamp post_date;

    @Column(name = "picture_url")
    private String picture_url;

    @Column(name = "language_id")
    private Long language_id;

    @Column(name = "publication_id")
    private Long publication_id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Publications publications;


}
