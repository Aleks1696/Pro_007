package hibernate.lesson11.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
    @Table(name = "books")
    public class Book {

        @Id
        @Column(name = "book_id")
        @SequenceGenerator(name = "bookId", sequenceName = "seq_book_id", initialValue = 16150000,allocationSize = 25)
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bookId")
    private Long id;
        @Column(name = "description")
    private String description;

        @Column(name = "title")
        private String title;

        @Temporal(TemporalType.DATE)
    private Date publishDate;
/* OneToOne  - позволяет нам установить свзяь между записью Book к таблице Authors
*  Соотношения Один-К-одному
*  JoinColumn - позволяет настроить связующее поле в таблице БД
*  name -  имя столбца в текущей таблице
*  referenceColumnName - имя столбца во внешней теблице , по которому будет установлено связь
* fetch - Тип выборки данных
*   FetchType.LAZY - ленивая выборка данных ( данные предоставляются по мере необходимости )
 *   ( минус: частые запросы к БД)
*
*   Fetch.EAGER -  полная выборка данных ( данные предоставляется в полном объеме)
 *   ( минус: предоставляются данные которые нам могут не понадобится)
*
*   */
    @OneToOne(fetch = FetchType.EAGER,targetEntity = Author.class)
    @JoinColumn(name = "author_id",referencedColumnName = "author_id")
    private Author author;

    public Book(String description, String title, Date publishDate) {
        this.description = description;
        this.title = title;
        this.publishDate = publishDate;

    }

    public Book (){
        }

    public Author getAuthor() {
        return author;
    }

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Book setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public Book setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
        return this;
    }
}
