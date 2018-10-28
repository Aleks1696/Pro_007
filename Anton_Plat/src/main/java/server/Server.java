package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    static final int PORT = 3443;
    private ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();

    public Server(){
        Socket clientSocket = null;
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(PORT); // создаю серверный сокет
            System.out.println("Сервер запущен!");

            while(true){
                clientSocket = serverSocket.accept();
                ClientHandler client = new ClientHandler(clientSocket, this);
                clients.add(client);
                new Thread(client).start(); // новые подключения обрабатываются в новых потоках
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        finally{
            try{
                clientSocket.close(); // закрываем подклкючение
                System.out.println("Сервер приостановлен");
                serverSocket.close();
            }catch (IOException ex){ex.printStackTrace();
            }
        }

    }
    public void sentMessageAllClients(String msg) {
        for(ClientHandler o: clients){
            o.sendMsg(msg);
        }
    }
    public void removeClient(ClientHandler client){
        clients.remove(client);
    }
}
