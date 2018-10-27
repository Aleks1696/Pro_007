package jdbc.homework08.task2;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;

public class IskatelIZasovivatelVBD {
    public static void main(String[] args) {
        File dir = new File("C://games");
        processFilesFromFolder(dir,"WargamingGameUpdater.log");

    }

    public static void processFilesFromFolder(File folder, String FindingFileName)
    {
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries){

            if (entry.isDirectory()){
                processFilesFromFolder(entry, FindingFileName);
                continue;
            }else{
                System.out.println("Найден файл \"" + entry.getName() + "\" по пути \"" + entry.getPath() + "\".");                        // иначе вам попался файл, обрабатывайте его!
                if ((entry.getName()).equalsIgnoreCase(FindingFileName)){
                    System.err.println("Найден искомый файл");

                    Locale.setDefault(Locale.ENGLISH);
                    String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
                    String user = "root";
                    String pass = "root";

                    try (Connection conn = DriverManager.getConnection(url, user, pass)){
                        PreparedStatement statement = conn.prepareStatement("INSERT INTO FOUND_FILES (ID, FILENAME, FILE_PATH ) VALUES (?,?,?)");
                        statement.setInt(1,1);
                        statement.setString(2,entry.getName());
                        statement.setString(3,entry.getPath());

                        statement.execute();
                        System.out.println("Создана запись: "+ entry.toString());

                        statement.clearParameters();
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}
}
