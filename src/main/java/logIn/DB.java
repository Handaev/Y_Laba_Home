package logIn;

import java.util.ArrayList;
import java.util.Optional;

public class DB {
    private static ArrayList<User> users = new ArrayList<>();

    public static Optional<User> getUser(String email, String password){
        return users.stream().filter
                        (u -> u.getEmail().equals(email)
                                && u.getPassword().equals(password)).
                findFirst();
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
