package com.service.core.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientsAccounts")
public class ClientAccount {

    @Id
    @Column(name = "Account_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "account", targetEntity = ClientRecord.class)
    private ClientRecord clientId;

    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = GroupRecord.class)
    @JoinTable(name = "clients_in_groups",
            joinColumns = @JoinColumn(name = "clientAccount_id", referencedColumnName = "Account_id"),
            inverseJoinColumns = @JoinColumn(name = "groupRecord_id", referencedColumnName = "Group_id"))
    private List<GroupRecord> groupRecord = new ArrayList<>();

    public ClientAccount() {

    }

    public ClientAccount(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientRecord getClientId() {
        return clientId;
    }

    public void setClientId(ClientRecord clientId) {
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

    public List<GroupRecord> getGroupRecord() {
        return groupRecord;
    }

    public void setGroupRecord(List<GroupRecord> groupRecord) {
        this.groupRecord = groupRecord;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClientAccount{");
        sb.append("id=").append(id);
        sb.append(", clientId=").append(clientId);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
