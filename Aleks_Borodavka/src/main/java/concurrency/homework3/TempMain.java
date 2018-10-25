package concurrency.homework3;

import concurrency.homework3.model.FileModel;

public class TempMain {
    public static void main(String[] args) {
        String path = "/home/dell/Programs";
        String fileName = "SomeFile";

        FileSearch fileSearch = new FileSearch();
        fileSearch.search(path, fileName);

        System.out.println(FileModel.getFoundFiles());
    }
}
