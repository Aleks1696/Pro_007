package clients;

import model.ClientModel;
import server.Server;

public class Client_3 {
    private static final int port = 30002;

    public static void main(String[] args) {

        Server.setSignalForOpeningNewClient(true);
        ClientModel.setPort(port);
        ClientModel.initializeClient();

    }
}
