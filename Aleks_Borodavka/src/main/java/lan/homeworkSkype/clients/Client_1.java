package lan.homeworkSkype.clients;

import lan.homeworkSkype.model.ClientModel;
import lan.homeworkSkype.server.Server;

public class Client_1 extends ClientModel {
    private static final int port = 30000;

    public static void main(String[] args) {

        Server.setSignalForOpeningNewClient(true);
        ClientModel.setPort(port);
        ClientModel.initializeClient();

    }
}
