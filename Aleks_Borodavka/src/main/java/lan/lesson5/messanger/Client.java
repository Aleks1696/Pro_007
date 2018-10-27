package lan.lesson5.messanger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try {
            SocketChannel chanel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 30000));

            Scanner scanner = new Scanner(System.in);
            ByteBuffer buffer = ByteBuffer.allocate(128);

            while (true) {
                String message = scanner.nextLine();
                if (message.equals("exit")){
                    System.exit(0);
                }
                buffer.put(message.getBytes());
                buffer.flip();
                chanel.write(buffer);
                buffer.clear();

                int bytes = chanel.read(buffer);
                System.out.println("Server: " + new String(buffer.array(), 0, bytes));
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
