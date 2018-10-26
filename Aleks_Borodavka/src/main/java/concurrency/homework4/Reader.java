package concurrency.homework4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    public static void main(String[] args) throws IOException {
        String path = "home/dell/Programs/read123";
        BufferedReader bf = new BufferedReader(new FileReader(path));

        System.out.println(bf.readLine());
    }


}
