package chatHomework;

import java.io.IOException;

import java.net.InetSocketAddress;
import java.net.Socket;
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
    static ExecutorService es = Executors.newCachedThreadPool();
    static ByteBuffer buffer = ByteBuffer.allocate(128);


    public static void main(String[] args) {


try {
    ServerSocketChannel server = ServerSocketChannel.open();
    server.bind(new InetSocketAddress(50006));

        do {
            for (SocketChannel socketChannel:socketChannelList){
            writeAndRead(socketChannel);
        }}while (server.isOpen());


    do {
        SocketChannel client = server.accept();
        es.execute(new MonoTreadClient(client));


    } while (true);
}catch (IOException e ){}

    }


    public static void writeAndRead (SocketChannel socketChannel){

        try {


            int bytes;
            //if ((bytes = socketChannel.read(ServerSecond.buffer)) > 0) {

socketChannel.read(buffer);

                ServerSecond.buffer.flip();

                System.out.println("Входящее сообщение: "
                        + new String(ServerSecond.buffer.array()));
                for (SocketChannel s : ServerSecond.socketChannelList) {
                    s.write(ServerSecond.buffer);
                }


                ServerSecond.buffer.clear();


           // }
        } catch (IOException e){}




    }
    }






class MonoTreadClient implements Runnable {

    private static SocketChannel clientDialog;

    public MonoTreadClient(SocketChannel clientDialog) {
        this.clientDialog = clientDialog;

    }

    @Override
    public void run() {


        // try {
        ServerSecond.socketChannelList.add(clientDialog);
        System.out.println(ServerSecond.socketChannelList.toArray());

    }
}
