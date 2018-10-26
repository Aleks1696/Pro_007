package lan.lesson5.messanger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientAsynchronized {
    public static void main(String[] args) {
        try {
            SocketChannel channel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 40000));
            ByteBuffer buffer = ByteBuffer.allocate(128);
            System.out.println("Chat with server...");
//------------------------------------------------------------------------------------------
            ExecutorService es = Executors.newSingleThreadExecutor();
            Runnable task = () -> {
                Scanner sc = new Scanner(System.in);
                String messageFromUser;
                while (true) {
                    messageFromUser = sc.nextLine();

                    if (messageFromUser.equalsIgnoreCase("exit")){
                        System.exit(0);

                    }

                    buffer.put(messageFromUser.getBytes());
                    buffer.flip();
                    try {
                        channel.write(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    buffer.clear();
                }
            };
            es.submit(task);
// -------------------------------------------------------------------------------------------
            while (true) {
                int bytes = channel.read(buffer);
                buffer.flip();
                System.out.println("Server: " + new String(buffer.array(), 0, bytes));
                buffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
