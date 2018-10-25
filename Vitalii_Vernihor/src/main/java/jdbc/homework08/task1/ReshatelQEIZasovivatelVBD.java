package jdbc.homework08.task1;

import jdbc.lesson07.insert.Patient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ReshatelQEIZasovivatelVBD {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        String url = "jdbc:mysql://localhost:3306/jdbc_pro007?useSSL=false";
        String user = "root";
        String pass = "root";
        Scanner scan = new Scanner(System.in);
        System.out.println("Ентер зэ разброс оф значения переменных(Min Max)");
        int min = scan.nextInt();
        int max = scan.nextInt();
        double a=0,b=0,c=0,d=0;
        try (Connection conn = DriverManager.getConnection(url, user, pass)){
            PreparedStatement statement = conn.prepareStatement("INSERT INTO QUADSOLVES (ID, A, B, C, D, X1, X2) VALUES (?,?,?,?,?,?,?)");
            List<QuadE> quadEList = new ArrayList<>();
            int i = 0;
            double x1,x2;
            for (a=min,b=min,c=min,i=0;a<=max;i++){
                System.out.println("Iter № "+i);
                x1=0;
                x2=0;
                d = b * b - 4 * a * c;
                if (d > 0) {
                    x1 = (-b - Math.sqrt(d)) / (2 * a);
                    x2 = (-b + Math.sqrt(d)) / (2 * a);
                    System.out.println("Корни уравнения: x1 = " + x1 + ", x2 = " + x2);

                }
                else if (d == 0) {
                    x1 = -b / (2 * a);
                    System.out.println("Уравнение имеет единственный корень: x = " + x1);
                }
                else {
                    System.out.println("Уравнение не имеет действительных корней!");
                }
                quadEList.add(new QuadE(i,a,b,c,d,x1,x2));
                if (c >=max){
                    c = min;
                    b++;
                    if (b > max){
                        b = min;
                        a++;
                        if (a > max){
                            break;
                        }
                    }
                }else{
                    c++;
                }
            }
            quadEList.forEach(quadE -> {
                try {
                    statement.setInt(1,quadE.getId());
                    statement.setDouble(2,quadE.getA());
                    statement.setDouble(3,quadE.getB());
                    statement.setDouble(4,quadE.getC());
                    statement.setDouble(5,quadE.getD());
                    statement.setDouble(6,quadE.getX1());
                    statement.setDouble(7,quadE.getX2());

                    statement.execute();
                    statement.clearParameters();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
