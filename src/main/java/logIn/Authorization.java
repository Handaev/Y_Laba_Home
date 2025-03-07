package logIn;

import java.util.Optional;

public class Authorization {
    private static String email = "email";
    private static String password = "пароль";

    public static boolean authorization(){
        if(check().isPresent()){
            return true;
        }
        return false;
    }

    public static Optional<User> check(){
        assign();
        return Validation.checkPersonInDB(email, password);
    }

    private static void assign(){
        email = ScanData.scan(email);
        password = ScanData.scan(password);
    }
}
