package concurrency.homework3.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileModel {
    private static List<File> foundFiles = new ArrayList<>();



    public static List<File> getFoundFiles() {
        return foundFiles;
    }


}
