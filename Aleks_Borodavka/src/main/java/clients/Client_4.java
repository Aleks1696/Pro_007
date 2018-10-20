package clients;

import model.ClientModel;
import server.Server;

public class Client_4 {
    private static final int port = 30003;

    public static void main(String[] args) {

        Server.setSignalForOpeningNewClient(true);
        ClientModel.setPort(port);
        ClientModel.initializeClient();

    }
}
