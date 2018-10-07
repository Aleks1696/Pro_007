package lan.lesson05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class ServerChat {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress(20000));
            System.out.println("Сервер запущен, ожидается подключения клиента...");
            SocketChannel socket = channel.accept();
            System.out.println("Соединение установленно...");

            ByteBuffer buffer = ByteBuffer.allocate(128);
            int bytes;
            while ((bytes = socket.read(buffer)) > 0 ){
                buffer.flip();
                System.out.println("Входящее сообщение: "
                        + new String(buffer.array(),0,bytes));
                buffer.clear();
                System.out.println("Введите ответ: ");

                String text = scan.nextLine();



                buffer.put(text.getBytes());
                buffer.flip();
                socket.write(buffer);
                buffer.clear();



            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        scan.close();
    }

}
