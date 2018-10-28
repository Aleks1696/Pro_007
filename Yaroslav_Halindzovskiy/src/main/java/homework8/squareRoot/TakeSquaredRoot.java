package homework8.squareRoot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TakeSquaredRoot {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите диапазон a ");
        Double aMAX = sc.nextDouble();

        System.out.println("Введите диапазон b ");
        Double bMAX = sc.nextDouble();

        System.out.println("Введите диапазон c ");
        Double cMAX = sc.nextDouble();

        for (double a = 1; a <= aMAX; a++) {
            for (double b = 1; b <= bMAX; b++) {
                for (double c = 1; c <= cMAX; c++) {
                    Double d = b * b - 4 * a * c;

                    if (d > 0) {
                        double x1, x2;
                        x1 = (-b - Math.sqrt(d)) / (2 * a);
                        x2 = (-b + Math.sqrt(d)) / (2 * a);
                        String s = "Korni yravnenia  x1 = " + x1 + ", x2 = " + x2;
                        System.out.println("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);
                        writeInBD(s);

                    }
                    else if (d == 0) {
                        double x;
                        x = -b / (2 * a);
                        System.out.println("Уравнение имеет единственный корень: x = " + x);
                        writeInBD("Yrovnenie imeet odin koren: x = " + x);
                    }
                    else {
                        System.out.println("Уравнение не имеет действительных корней!");
                    }



                } } }
    }
    public static void writeInBD (String s) {
        String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
        String user = "root";
        String pass = "root";
        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement statement = conn.prepareStatement(
                    "INSERT INTO SQUARED (RESULT) value (?)"
            );
            statement.setString(1,s);
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
