package app;

import logIn.Authorization;
import logIn.Registration;

import java.util.Scanner;

public class Application {

    public void start(){
        logIn();
        redactor();
    }

    private void redactor(){

    }
    private void logIn(){
        while (true) {
            System.out.print("Введите символ(регистрация = r, вход = v): " );
            Scanner scanner = new Scanner(System.in);
            String rv = scanner.next();
            if(rv.equals("r") && Registration.registration() ||
                    rv.equals("v") && Authorization.authorization()){
                System.out.println("Поздравляю, вы вошли!");
                break;
            }
            System.out.println("Пользователь не зарегистрирован!");
        }
    }

}
