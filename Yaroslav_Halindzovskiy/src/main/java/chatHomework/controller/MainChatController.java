package chatHomework.controller;

import chatHomework.Client;
import com.sun.javafx.tk.Toolkit;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import javafx.concurrent.Task;


public class MainChatController extends Thread {
    protected static SocketChannel socketChannel;
    private static ByteBuffer buffer = ByteBuffer.allocate(128);


    @FXML
    private ScrollPane scrollPane;
    @FXML
    private Button btnSend;
    @FXML
    private TextField fldText;
    @FXML
    private TextArea txtArea;
    private static String txtToSend;
    private static String txtToGet;


Task task = new Task<Void>() {

    @Override
    protected Void call() throws Exception {
        while (true) {

        reader(socketChannel);
        return null;
    }

    }

};

    @FXML
    private void write() {
        txtToSend = fldText.getText();
        writtemessage(socketChannel);
        fldText.setText("");

    }

    private static void writtemessage(SocketChannel channel) {
        String text = txtToSend;
        System.out.println("Сообщение для отправки: " + text);

        if (text.equals("exit")) {
            try {
                channel.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        buffer.put(text.getBytes());
        buffer.flip();
        txtToSend = "";

        try {
            channel.write(buffer);
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void connect() {
        try {
            socketChannel = SocketChannel.open(new InetSocketAddress(50007));
            if (socketChannel.isConnected()) {
                System.out.println("Соединение с сервером устаановлено.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(task).start();
    }


    public static void reader(SocketChannel channel) {
        while (true) {
            int bytes;


            try {
                while ((bytes = channel.read(buffer)) > 0) {

                    buffer.flip();
                    txtToGet = buffer.array().toString();
                    System.out.println("Входящее сообщение " + new String(buffer.array()));
                    buffer.clear();


                }

            } catch (IOException e) {

            } catch (BufferOverflowException r) {
            }

        }

    }
    public void print () {

        txtArea.appendText( txtToGet + "\n");

        txtToGet = "";
    }
}






