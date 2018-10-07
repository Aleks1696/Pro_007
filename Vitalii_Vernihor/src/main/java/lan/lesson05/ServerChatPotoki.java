package lan.lesson05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerChatPotoki {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(20000));
        System.out.println("Сервер запущен, ожидается подключения клиента...");
        SocketChannel socket = channel.accept();
        System.out.println("Соединение установленно...");
        ByteBuffer buffer = ByteBuffer.allocate(128);


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

        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(chitalka);
        es.execute(pisalka);
    }
}
