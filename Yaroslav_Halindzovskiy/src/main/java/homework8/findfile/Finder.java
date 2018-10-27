package homework8.findfile;

import java.io.File;
import java.io.FilenameFilter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Finder {
    private static String fileName;

    private static String trueDirectory;

    private File file;


    public Finder (File file ){
        this.file = file;
    }
    public static void main (String [] args ){
        fileName = "Temp.txt";

        // System.out.println("Введите имя директории");
        // fileDirectory = "D:\Example";
        creatFinder();



    }

    private String [] getTrueDirectory (File directory) {
        if( directory == null){
            return null;
        }
        String [] files = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {

                if (name.equals(fileName)){
                    trueDirectory = dir.toString();
                }
                return name.equals(fileName);
            }
        });


        return files;
    }
    public void recurs (File path ){

        printFiles(getTrueDirectory(path));
        for (File file : path.listFiles()){
            if (file.isDirectory()){
                recurs(file);
            }

        }


    }

    private void printFiles (String [] targets) {
        String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
        String user = "root";
        String pass = "root";
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO FINDER(RESULT) value (?)");
            for (String target : targets) {
                System.out.println(target + " Находится в папке " + trueDirectory);
                statement.setString(1,target + " in " + trueDirectory);
                statement.execute();
                statement.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
        public static void creatFinder () {
        Finder searcher = new Finder(new File("D:\\example"));
        searcher.recurs(searcher.file);
    }
}
