package chatHomework;

import com.sun.javafx.image.impl.ByteRgb;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    private static SocketChannel socketChannel;
    private static ByteBuffer buffer = ByteBuffer.allocate(128);
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        connect();
        Runnable runnableWrite = (() -> {
            while (true) {
                writter(sc, socketChannel);
            }

        });
        Runnable runnableRead = (() -> {
            while (true) {
                reader(socketChannel);
            }
        });
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(runnableRead);
        es.execute(runnableWrite);
        while (true) {
            try {
                if (socketChannel.finishConnect()) {
                    es.shutdown();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public static void connect() {
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(50009));
            if (socketChannel.isConnected()) {
                System.out.println("Соединение с сервером устаановлено.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void reader(SocketChannel channel) {
        while (true) {
            int bytes;


            try {
                while ((bytes = channel.read(buffer)) > 0) {

                    buffer.flip();
                    System.out.println("Входящее сообщение " + new String(buffer.array(), 0, bytes));
                    buffer.clear();
                }


            } catch (IOException e) {

            } catch (BufferOverflowException r) {
            }
        }

    }

    public static void writter(Scanner sc, SocketChannel channel) {

        System.out.println("Сообщение для отправки");
        String text = sc.nextLine();
        if (text.equals("exit")) {
        }
        buffer.put(text.getBytes());
        buffer.flip();
        try {
            channel.write(buffer);
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


