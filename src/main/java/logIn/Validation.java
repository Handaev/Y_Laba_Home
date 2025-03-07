package logIn;

import java.util.Optional;

public class Validation {
    public static Optional<User> checkPersonInDB(String email, String password){
        return Optional.ofNullable(DB.getUser(email, password).orElse(null));
    }
}
