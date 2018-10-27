package homework8.findfile.config;

import java.io.File;
import java.io.FilenameFilter;
import java.sql.*;

public class Find {
    private File file;
    private static String filename ;
    private static String fileTrueDirectory ;

    public Find(File file) {
        this.file = file;
    }

    public static void main(String[] args) {
        filename = "Temp.txt";
        creatFind();

    }

    public static void creatFind() {
        Find f = new Find((new File("D:\\example")));
        f.recuse(f.file);
    }

    public void recuse(File path) {
        addToBD(findNameEquals(path));
        for (File file : path.listFiles()) {
            if (file.isDirectory()) {
                recuse(file);
            }
        }

    }

    private String[] findNameEquals(File directory) {
        if (directory == null) {
            return null;
        }
        String[] files = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.equals(filename)) {
                    fileTrueDirectory = dir.toString();
                }
                return name.equals(filename);
            }
        });
        return files;
    }

    ;

    private void addToBD(String[] targets) {
        String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
        String user = "root";
        String pass = "root";
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO FINDER(RESULT) value (?)");
            for (String target : targets) {


                statement.setString(1, target + " in " + fileTrueDirectory);
                statement.execute();
                statement.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
