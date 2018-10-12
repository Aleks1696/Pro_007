
import java.io.IOException;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSecond {
    static List<SocketChannel> socketChannelList = new ArrayList<>();
    static ExecutorService es = Executors.newCachedThreadPool();
    static ByteBuffer buffer = ByteBuffer.allocate(128);


    public static void main(String[] args) {


try {
    ServerSocketChannel server = ServerSocketChannel.open();
    server.bind(new InetSocketAddress(50006));
    Runnable runnable1 = () -> {
        do {
            writeAndRead();
        }while (server.isOpen());
    };

    do {
        SocketChannel client = server.accept();
        es.execute(new MonoTreadClient(client));
        es.execute(runnable1);

    } while (true);
}catch (IOException e ){}

    }


    public static void writeAndRead (){

        try {

            for (SocketChannel socketChannel:socketChannelList){
            int bytes;
            if ((bytes = socketChannel.read(ServerSecond.buffer)) > 0) {

                ServerSecond.buffer.flip();

                System.out.println("Входящее сообщение: "
                        + new String(ServerSecond.buffer.array(), 0, bytes));
                for (SocketChannel s : ServerSecond.socketChannelList) {
                    s.write(ServerSecond.buffer);
                }


                ServerSecond.buffer.clear();
                bytes = 0;
            }
            }
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
