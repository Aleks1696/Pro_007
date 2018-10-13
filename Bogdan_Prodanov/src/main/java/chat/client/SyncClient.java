package chat.client;



import chat.server.Server;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class SyncClient extends Thread {

    private SocketChannel client;

    public SyncClient(SocketChannel client){
        this.client = client;
        start();
    }

    @Override
    public void run(){
            while(true){
                try {
//                    DataInputStream dis = new DataInputStream(client.socket().getInputStream());
                    ByteBuffer buffer = ByteBuffer.allocate(128);
                    int bytes;
                    while((bytes = client.read(buffer)) > 0){
                        buffer.flip();
                        System.out.println("Входящее сообщение: " + new String(buffer.array(), 0,bytes));
                        buffer.clear();
                        Server.end();
                    }
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

}
