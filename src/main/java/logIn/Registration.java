package logIn;

import java.util.Optional;

public class Registration {
    private static String[] data = {"Имя", "Фамилию", "email", "пароль"};

    public static boolean registration() {
        add();
        if (!check().isPresent()){
            DB.getUsers().add(new User(data[0], data[1], data[2], data[3]));
            return true;
        }
        return false;
    }

    private static void add(){
        for(int i = 0; i < data.length; i++){
            data[i] = ScanData.scan(data[i]);
        }
    }

    public static Optional<User> check(){
        return Validation.checkPersonInDB(data[2], data[3]);
    }
}
