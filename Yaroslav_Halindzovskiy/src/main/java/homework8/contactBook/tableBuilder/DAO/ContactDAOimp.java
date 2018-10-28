package homework8.contactBook.tableBuilder.DAO;

import homework8.contactBook.domain.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDAOimp implements ContactDAO {
    String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
    String username = "root";
    String password = "root";

    @Override
    public void create(Contact contact) {
        try (Connection con =
                     DriverManager.getConnection(url, username, password)) {
            PreparedStatement statement = con.prepareStatement(
                    "insert into BOOK (LOGIN, PASSWORD) value (?,?)"
            );
            statement.setString(1, contact.getLogin());
            statement.setString(2, contact.getPassword());

            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Contact reader (Integer id) {
        try (Connection con = DriverManager.getConnection(url,username,password)){
            PreparedStatement statement = con.prepareStatement("select * from BOOK where id = ?");
            statement.setInt(1,id);
            ResultSet set = statement.executeQuery();
            Contact contact = new Contact();

            while (set.next()){
                contact.setLogin(set.getString("LOGIN"));
                contact.setPassword(set.getString("PASSWORD"));
            }
            statement.close();
            return contact;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public List<Contact> findAll() {
        try (Connection con = DriverManager.getConnection(url,username,password)){
            PreparedStatement statement = con.prepareStatement("select * from BOOK");
            ResultSet set = statement.executeQuery();
            List<Contact> contacts = new ArrayList<>();
            while (set.next()){
                contacts.add(
                        new Contact(
                                set.getString("LOGIN"),
                                set.getString("PASSWORD")
                        )
                );
            }
            return contacts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
