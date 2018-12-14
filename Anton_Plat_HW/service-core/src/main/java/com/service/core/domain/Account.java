package com.service.core.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    @Column(unique = true)
    private String login;


    @Column
    private String password;


    @OneToOne(fetch = FetchType.EAGER, mappedBy = "client", targetEntity = Client.class)
    private Client client;


    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Group.class)
    private List<Group> groups = new ArrayList<Group>();

    public Account(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Account() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("accountId=").append(accountId);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", client=").append(client);
        sb.append(", groups=").append(groups);
        sb.append('}');
        return sb.toString();
    }
}
