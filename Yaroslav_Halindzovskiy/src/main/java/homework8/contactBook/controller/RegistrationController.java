package homework8.contactBook.controller;

import homework8.contactBook.domain.Contact;
import homework8.contactBook.model.ContactModel;
import homework8.contactBook.tableBuilder.DAO.ContactDAO;
import homework8.contactBook.tableBuilder.DAO.ContactDAOimp;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class RegistrationController {
    @FXML
    TextField fldLoginReg;
    @FXML
    TextField fldPassReg;
    @FXML
    TextField fldPassConfReg;

    @FXML
    public void registration() {


        if (ContactModel.takelogin(fldLoginReg) || fldPassReg.equals(fldPassConfReg)) {

            ContactModel.saveClient(new Contact(
                    fldLoginReg.getText(),
                    fldPassReg.getText()


            ));


        }
    }
}
