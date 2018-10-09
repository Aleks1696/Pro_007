package lan.homework06;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class lanChatMultiUserServer {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(20000));
        System.out.println("Запуск сервера...");
        SocketChannel socket = channel.accept();
        System.out.println("Соединение установленно...");
        ByteBuffer buffer = ByteBuffer.allocate(128);


        Runnable clientListener = () ->{
            System.out.println("Запуск модуля подключения новых пользователей");
            while (true) {

                try {
                    channel.accept();
                    System.out.println("Соединение установленно...");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };


        Runnable chitalka = () -> {
            try {
                int bytes;
                while ((bytes = socket.read(buffer)) > 0 ){

                    buffer.flip();

                    System.out.println("Входящее сообщение: "
                            + new String(buffer.array(),0,bytes));

                    buffer.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        };

        Runnable pisalka = () -> {
            try{
                while (true){
                    String text = scan.nextLine();

                    buffer.put(text.getBytes());
                    buffer.flip();
                    socket.write(buffer);
                    buffer.clear();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(3);
        es.execute(clientListener);
        es.execute(chitalka);
        es.execute(pisalka);
    }
}
