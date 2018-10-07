package lan.lesson05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class LanEx02 {
    public static void main(String[] args) {
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
