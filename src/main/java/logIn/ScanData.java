package logIn;

import java.util.Scanner;

public class ScanData {
     static String scan(String string){
        System.out.println("Введите " + string + " пользователя: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
