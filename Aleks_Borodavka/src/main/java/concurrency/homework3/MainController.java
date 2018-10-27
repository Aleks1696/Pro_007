package concurrency.homework3;

import concurrency.homework3.model.FileModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.homework2.model.ContactModel;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField fldDirectory;
    @FXML
    private TextField fldFileName;

    @FXML
    private ListView lstFilesList;

    private ObservableList list;

    @FXML
    public void searchForSpecifiedFiles (){
        FileSearch fs = new FileSearch();
        FileModel.getFoundFiles().clear();
        list = FXCollections.observableArrayList(ContactModel.getContacts());
        fs.search(fldDirectory.getText(), fldFileName.getText());
        list.setAll(FileModel.getFoundFiles());

        lstFilesList.setItems(list);
    }
}
