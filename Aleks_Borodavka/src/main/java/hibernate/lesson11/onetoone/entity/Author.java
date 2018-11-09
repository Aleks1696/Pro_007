package hibernate.lesson11.onetoone.entity;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @Column(name = "author_id")
    /*SequenceGenerator - аннотация позволяет нам описать свой генератор значений
    *                     для поля ID
    * name - имя генератора на уровне программы
    * sequenceName - имя генератора на уровне БД
    * initialValue - начальное значение
    * allocationSize - шаг на который будет изменено значение*/
    @SequenceGenerator(name = "authorId",
            sequenceName = "seq_author_id",
            initialValue = 20180000
    )
    /* GeneratedValue - позволяет подключить генератор */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorId")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private  String surname;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "author", targetEntity = Book.class)
    private Book book;

    public Author(){

    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
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
