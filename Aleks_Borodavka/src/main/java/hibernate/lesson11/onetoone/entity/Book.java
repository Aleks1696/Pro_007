package hibernate.lesson11.onetoone.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "book_id")
    @SequenceGenerator(name = "bookId",
            sequenceName = "seq_book_id",
            initialValue = 16150000,
            allocationSize = 50
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "bookId"
    )
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Temporal(TemporalType.DATE)
    private Date publishDate;

    /*@OneToOne - позволяет нам установить связь между записью
    *             из таблицы books к таблице Authors
    *             (соотношение один к одному)
    * fetch - тип выборки данных
    * FetchType.Eager - полная выборка данных (данные предоставляються в полном
    *                   объеме. Минусы: предоставляются данные которые
    *                   могут не использоватся)
    * FetchType.LAZY - ленивая выборка данных (данные предоставляются
    *                  по мере ненобходимости. Минусы: частые запросы к БД)*/
    @OneToOne(fetch = FetchType.EAGER, targetEntity = Author.class)
    /*@JoinColumn - позволяет настроить связующее поле в таблице БД
    *   name - имя столбца связующего в текущей таблице
    *   referenceColumn - имя столбца во внешней таблице по которому
    *   будет установлено связь*/
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    private Author author;

    public Book(){

    }

    public Book(String title, String description, Date publishDate) {
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", publishDate=").append(publishDate);
        sb.append('}');
        return sb.toString();
    }
}
