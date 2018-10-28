package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {


    private Server server; // экземпляр сервера
    private PrintWriter outMessage; // исходящее сообщение
    private Scanner inMessage; // входящие сообщение
    private static final String HOST = "localhost";
    private static final int PORT = 3443;

    private Socket clientSocket = null; // клиентский сокет

    private static int clients_count = 0;

    public ClientHandler(Socket socket,Server server) {
       try{
           clients_count++;
           this.server = server;
           this.clientSocket = socket;
        this.outMessage = new PrintWriter(socket.getOutputStream()); // maybe mistake
        this.inMessage = new Scanner(socket.getInputStream());

       }catch (IOException ex){
           ex.printStackTrace();
       }
    }


    public void run() {
      try{
          while(true){
              server.sentMessageAllClients("Новый пользователь присоеденился к чату!");
              server.sentMessageAllClients("Клиентов в чате!" + clients_count);
              break;
          }
          while (true){
              if(inMessage.hasNext()){
                  String clientMessage = inMessage.nextLine();
                  if (clientMessage.equalsIgnoreCase("##session##end##")){
                      break;
                  }
                  System.out.println(clientMessage);
                  server.sentMessageAllClients(clientMessage);
              }
              Thread.sleep(100);
          }
      }
        catch (InterruptedException ex){
          ex.printStackTrace();
        }
        finally {
          this.close();
      }
    }
 public void sendMsg(String msg) {    // send message
        try{
            outMessage.print(msg);
            outMessage.flush(); /// what is it?????

        } catch (Exception ex){
            ex.printStackTrace();
        }

 }

 public void close(){
        server.removeClient(this);
        clients_count--;
        server.sentMessageAllClients(" всего участников: " +clients_count);
 }

}
