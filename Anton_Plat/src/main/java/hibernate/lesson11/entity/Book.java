package hibernate.lesson11.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "book_id")
    @SequenceGenerator(name = "bookId", sequenceName = "seq_book_id", initialValue = 16150000, allocationSize = 50)

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookId")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Temporal(TemporalType.DATE)
    private Date publishDate;
    /* @OneToOne - позволяет нам установить связь между записью из
     * таблицы Books к таблице Authors
      * Соотношения Один-к-Одному
      * fetch - Тип выборки данных
      * FetchType.EAGER -
      * FetchType.LAZY - ленивая выборка данных(данные предоставляется по мере необходимости
      * по мере необходимости)
      * (минусы: частые запросы к БД)
      * ----------------------------------------------
      * FetchType.EAGER - полная выборка данных(данные предоставляются в полном
      * объеме
      * (минусы: предоставляются данные,которые могут нам не понадобится)

      * */
    @OneToOne(fetch = FetchType.EAGER, targetEntity = Author.class)
    /* @JoinColumn - позволяет настроить связующее поле в таблице БД
     * name         - имя столбца в текущей таблице
     * referencedColumnName - имя столбца во внешней таблице, по которому
     *                        будет установленна связь*/
    @JoinColumn(name="author_id",referencedColumnName ="author_id" )
    private Author author;

    public Book() {
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

    public Book setAuthor(Author author) {
        this.author = author;
        return this;
    }
}