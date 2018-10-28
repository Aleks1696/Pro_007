package homework8.contactBook.domain;

public class Contact {
    private String login;
    private String password;

    public Contact(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Contact() {
    }

    public String getLogin() {
        return login;
    }

    public Contact setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Contact setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contact ")
                .append(login);
        return sb.toString();
    }
}
