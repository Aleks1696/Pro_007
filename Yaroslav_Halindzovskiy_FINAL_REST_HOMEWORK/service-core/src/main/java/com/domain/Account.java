package com.domain;
import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String login;
    @Column
    private String password;

    @OneToOne(fetch = FetchType.EAGER,mappedBy = "account",targetEntity = Client.class)
    private Client client;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Group.class)
    @JoinColumn
    private Group group;


    public Account() {
    }

    public Account(String login, String password, Client client, Group group) {
        this.login = login;
        this.password = password;
        this.client = client;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", client=").append(client);
        sb.append(", group=").append(group);
        sb.append('}');
        return sb.toString();
    }
}
