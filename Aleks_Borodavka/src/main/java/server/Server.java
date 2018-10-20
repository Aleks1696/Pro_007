package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Server {
    private static int portNumber = 30000;
    private static boolean signalForOpeningNewClient = true;

    public static void setSignalForOpeningNewClient(boolean signalForOpeningNewClient) {
        Server.signalForOpeningNewClient = signalForOpeningNewClient;
    }

    public static void main(String[] args) throws Exception {
        List<SocketChannel> clientSockets = new ArrayList<>();
        ByteBuffer buffer = ByteBuffer.allocate(128);

        for (int i = 0; i < 4; i++){
            newClient(portNumber, buffer, clientSockets);
            portNumber++;
            signalForOpeningNewClient = false;
        }
    }

    private static void newClient(int port, ByteBuffer buffer, List<SocketChannel> clientSockets) {

        Runnable task1 = () -> {
            String clientName;
            try {
                ServerSocketChannel channel = ServerSocketChannel.open();
                channel.bind(new InetSocketAddress(port));
                SocketChannel socket = channel.accept();
                clientSockets.add(socket);

                int bytes = socket.read(buffer);
                clientName = new String(buffer.array(), 0, bytes);
                buffer.put((" joined...").getBytes());
                messageProcessor(socket, clientSockets, buffer);

                while (true) {
                    bytes = socket.read(buffer);
                    joinMessage(clientName, buffer, bytes);
                    messageProcessor(socket, clientSockets, buffer);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        ExecutorService es1 = Executors.newSingleThreadExecutor();
        es1.execute(task1);

        if (!es1.isTerminated()) {
            try {
                es1.awaitTermination(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        es1.shutdown();
    }

    private static void messageProcessor(SocketChannel activeSocket, List<SocketChannel> clientSockets,
                                         ByteBuffer buffer) {
        for (SocketChannel socket : clientSockets) {
            if (socket != activeSocket) {
                try {
                    buffer.flip();
                    socket.write(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        buffer.clear();
    }

    private static void joinMessage(String clientName, ByteBuffer buffer, int bytes) {
        String message = new String(buffer.array(), 0, bytes);
        buffer.clear();
        buffer.put(clientName.getBytes());
        buffer.put((": ").getBytes());
        buffer.put(message.getBytes());
    }
}
