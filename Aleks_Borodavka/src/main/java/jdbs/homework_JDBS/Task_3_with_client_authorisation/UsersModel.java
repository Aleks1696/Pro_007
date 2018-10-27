package jdbs.homework_JDBS.Task_3_with_client_authorisation;

import java.util.ArrayList;
import java.util.List;

public class UsersModel {

    private static List<User> userList = new ArrayList<>();

    public static List<User> getUserList() {
        return userList;
    }

}
