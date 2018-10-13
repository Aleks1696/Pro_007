package chat.server;


import chat.client.SyncClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class Server {

    private static ServerSocketChannel channel;
    private static SocketChannel socket;


    public static void main(String[] args) {
        try {
            start();
            treat();
            end();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void start() throws IOException {

        channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(20000));
        System.out.println("Сервер запущен");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ожидаем сообщения");
    }

    private static void treat(){
        while(true){
            try {
                socket = channel.accept();
                new SyncClient(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void end() throws IOException {
        channel.close();
    }
}
