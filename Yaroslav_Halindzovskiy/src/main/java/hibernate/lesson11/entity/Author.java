package hibernate.lesson11.entity;

import javax.persistence.*;


@Entity
@Table(name = "authors")
public class Author {
    @Id
    @Column(name = "author_id")
    /* @SequenceGenerator позволяет описать свой генератор значений для нашего поля ID
     * name - имя генератора на уровне программы
     * sequenceName - имя генератора на уровне БД
     * initialValue - начальное значение
     * allocationSize - шаг на который будет изменено значение
     * */
    /* GeneratorVakue 0  позволяет подключить генератор */
    @SequenceGenerator(name = "authorId", sequenceName = "seq_author_id", initialValue = 20180000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorId")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "author", targetEntity =  Book.class)
    private Book book;
    @Column (name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    public Author() {

    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Book getBook() {
        return book;
    }

    public Author setBook(Book book) {
        this.book = book;
        return this;
    }

    public Long getId() {
        return id;
    }

    public Author setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Author setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
