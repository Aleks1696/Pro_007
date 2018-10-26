package concurrency.homework4;

import concurrency.homework3.FileSearch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class MainController extends FileSearch {

    @FXML
    private TextField fldName;
    @FXML
    private TextField fldDirectory;
    @FXML
    private ListView<String> lstView;

    private ObservableList<String> list = FXCollections.observableArrayList(FileModel.getListOfText());

    public void readContentFromFile(String path) {

        try {
            BufferedReader inb = new BufferedReader(new FileReader(path));
            String i;
            int index = 0;
            while ((i = inb.readLine())!= null) {
                FileModel.getListOfText().add(i);
                list.addAll(i);
                lstView.setItems(list);
                lstView.refresh();
                try {
                    Thread.currentThread().sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void submit() throws IOException {
        FileSearch fs = new MainController();
        fs.search(fldDirectory.getText(), fldName.getText());
        ExecutorService es = Executors.newSingleThreadExecutor();

        Runnable task1 = () -> {
            System.out.println("thread 1 started");
//            System.out.println(FileModel.getPath().toString());
            readContentFromFile(FileModel.getPath());

        };
        es.execute(task1);

        ExecutorService es2 = Executors.newSingleThreadExecutor();
        Runnable task2 = () -> {
            System.out.println("Thread 2 started");
            while (!es.isTerminated()) {
                try {
                    es2.awaitTermination(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            es.shutdown();
            System.out.println("Thread 1 is done: " + es.isTerminated());
            System.out.println("Thread 2 ended thread 1");
        };
        es2.execute(task2);

        if (!es2.isTerminated()) {
            try {
                es2.awaitTermination(2, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        es2.shutdown();
        System.out.println("Thread 2 ended");
    }

    @Override
    public void addFoundFileToList(File file) {
        FileModel.setPath(file.getPath());
    }

    public void cancelOnClick() {
        System.exit(0);
    }
}
