
import java.io.IOException;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerSecond {

    static ExecutorService es = Executors.newFixedThreadPool(2);
     static ByteBuffer buffer = ByteBuffer.allocate(128);

    public static void main(String[] args) {
        try {


            ServerSocketChannel server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(50005));


            while (server.isOpen()) {
                SocketChannel client = server.accept();
                es.execute(new MonoTreadClient(client));



            }
        } catch (IOException e) {
            e.printStackTrace();
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


        try {

//                do {
//
//                    System.out.println("Входящее сообщение " + new String(buffer.array()));
//                    clientDialog.read(buffer);
//                    buffer.flip();
//                    clientDialog.write(buffer);
//
//
//                    buffer.clear();
//
//                }
            int bytes;
            while ((bytes = clientDialog.read(ServerSecond.buffer)) > 0) {

                ServerSecond.buffer.flip();

                System.out.println("Входящее сообщение: "
                        + new String(ServerSecond.buffer.array(), 0, bytes));
                clientDialog.write(ServerSecond.buffer);

               ServerSecond.buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) ;


    }
}
