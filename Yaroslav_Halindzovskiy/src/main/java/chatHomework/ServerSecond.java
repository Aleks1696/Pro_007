package chatHomework;

import java.io.IOException;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSecond {

    static List<SocketChannel> socketChannelList = Collections.synchronizedList(new ArrayList<>());
    static ByteBuffer buffer = ByteBuffer.allocate(128);
    static String message;


    public static void main(String[] args) {
        try {
            ServerSocketChannel server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(50009));

            ExecutorService es = Executors.newFixedThreadPool(1);
            Runnable runnable1 = (() -> {

                while (true) {
                    for (SocketChannel s : socketChannelList) {
                        read(s);
                    }

                }


            });
            Runnable runnable2 = (() -> {

            do {
                SocketChannel socket = null;
                try {
                    socket = server.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                new MonoTreadClient(socket).run();
            } while (true);


            });
            es.execute(runnable1);
            es.execute(runnable2);



        } catch (IOException e) {
        }
    }

    public static void write() {



        buffer.flip();
        for (SocketChannel s : socketChannelList) {
            //System.out.println("Писалка работает");


            try {
                //buffer.put(message.getBytes());
                s.write(buffer);


            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        buffer.clear();
    }


    public static void read(SocketChannel s) {




        try {
            // while ((bytes = channel.read(buffer)) > 0) {
            s.read(buffer);
            if (buffer == null) {
                System.out.println("буфер пустой");
            }
            buffer.flip();
            System.out.println("Входящее сообщение " + new String(buffer.array()));
            message = new String(buffer.array());
            //System.out.println(buffer.array());
            write();
        } catch (IOException e) {
        } catch (BufferOverflowException r) {
        }

    }

}


class MonoTreadClient implements Runnable {


    private static SocketChannel clientDialog;

    public MonoTreadClient(SocketChannel clientDialog) {
        this.clientDialog = clientDialog;

    }

    @Override
    public void run() {

        ServerSecond.socketChannelList.add(clientDialog);
        System.out.println(ServerSecond.socketChannelList.toArray());
    }
}