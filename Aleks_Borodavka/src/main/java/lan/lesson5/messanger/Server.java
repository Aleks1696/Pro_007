package lan.lesson5.messanger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {

        ServerSocketChannel channel;

        {
            try {
                channel = ServerSocketChannel.open();
                channel.bind(new InetSocketAddress(30000));
                SocketChannel socket = channel.accept();

                ByteBuffer buffer = ByteBuffer.allocate(128);

                while (true) {
                    int bytes = socket.read(buffer);
                    buffer.flip();
                    System.out.println("User: " + new String(buffer.array(), 0, bytes));
                    buffer.clear();

                    Scanner scanner = new Scanner(System.in);
                    String answer = scanner.nextLine();
                    if (answer.equals("exit")){
                        System.exit(0);
                    }
                    buffer.put(answer.getBytes());
                    buffer.flip();
                    socket.write(buffer);
                    buffer.clear();

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
