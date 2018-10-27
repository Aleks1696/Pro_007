package jdbs.homework_JDBS.Task_3_with_client_authorisation;

import java.util.Objects;

public class User {
    private Short id;
    private String name;
    private String surname;
    private String nickName;
    private String password;

    public User() {
    }

    public User(String name, String surname, String nickName, String password) {
        this.name = name;
        this.surname = surname;
        this.nickName = nickName;
        this.password = password;
        this.id = (short) this.hashCode();
    }

    public Short getId() {
        return id;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name) &&
                Objects.equals(surname, user.surname) &&
                Objects.equals(nickName, user.nickName) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, nickName, password);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" ");
        sb.append(surname);
        return sb.toString();
    }
}
