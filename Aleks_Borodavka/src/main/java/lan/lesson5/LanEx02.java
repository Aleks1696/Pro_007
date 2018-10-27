package lan.lesson5;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/*
* 193.93.76.166
* */

public class LanEx02 {

    public static void main(String[] args) {
        try {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.bind(new InetSocketAddress(20000));
            System.out.println("Server is running, waiting for Client connection...");
            SocketChannel socket = channel.accept();
            System.out.println("Connected...");

            ByteBuffer buffer = ByteBuffer.allocate(128);
            int bytes;
            while ((bytes = socket.read(buffer)) > 0){
                buffer.flip();
                System.out.println("Input message: " + new String(buffer.array() ,
                        0, bytes));
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
