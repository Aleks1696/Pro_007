package web.domain;
import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long clientId;
    @Column(unique = true)
    private String login;
    @Column
    private String password;

    public Account() {
    }

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("clientId=").append(clientId);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
