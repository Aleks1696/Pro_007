package lan.lesson5.messanger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerAsynchronized {
    public static void main(String[] args) {
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress(40000));
            ByteBuffer buffer = ByteBuffer.allocate(128);
            SocketChannel socket = channel.accept();
            System.out.println("Chat with user...");
//------------------------------------------------------------------------------------------
            ExecutorService es = Executors.newSingleThreadExecutor();
            Runnable task = () -> {
                Scanner sc = new Scanner(System.in);
                String messageFromServer;
                while(true) {
                    messageFromServer = sc.nextLine();

                    if (messageFromServer.equalsIgnoreCase("exit")){
                        System.exit(0);
                    }

                    buffer.put(messageFromServer.getBytes());
                    buffer.flip();
                    try {
                        socket.write(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    buffer.clear();
                }
            };
            es.submit(task);
// -------------------------------------------------------------------------------------------
            while(true){
                int bytes = socket.read(buffer);
                buffer.flip();
                System.out.println("User: " + new String(buffer.array(), 0, bytes));
                buffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
