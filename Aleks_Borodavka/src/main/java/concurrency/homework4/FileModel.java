package concurrency.homework4;

import java.util.ArrayList;
import java.util.List;

public class FileModel {

    private static String path;

    private static List<String> listOfText = new ArrayList<>();

    public static void setListOfText(String str) {
       listOfText.add(str + System.lineSeparator());
    }

    public static List<String> getListOfText() {
        return listOfText;
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        FileModel.path = path;
    }
}
