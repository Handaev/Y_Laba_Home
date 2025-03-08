package tracker;


import tracker.data.DataBaseTracker;

import java.util.Scanner;


public class Main {
    private static String firstName;
    private static String lastName;
    private static String regEmail;
    private static String regPassword;

    private static Scanner scanner = new Scanner(System.in);

    private static DataBaseTracker dataBaseTracker = new DataBaseTracker();

    private static void scanName(){
        System.out.println("Введите имя:");
        firstName = scanner.nextLine();
        System.out.println("Введите фамилию:");
        lastName = scanner.nextLine();
    }

    private static void scanPass(){
        System.out.println("Введите пароль:");
        regPassword = scanner.nextLine();
    }

    private static void scanEmail(){
        System.out.println("Введите email:");
        regEmail = scanner.nextLine();
    }

    private static void logIn(){
        while (true) {
            System.out.println("Введите команду: регистрация, вход.");
            String option = scanner.nextLine().trim();

            switch (option.toLowerCase()) {
                case "регистрация":
                    scanName();
                    scanEmail();
                    scanPass();
                    try {
                        dataBaseTracker.registration(firstName, lastName, regEmail, regPassword);
                        System.out.println("Пользователь успешно зарегистрирован.");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    continue;
                case "вход":
                    scanEmail();
                    scanPass();
                    try {
                        dataBaseTracker.authenticate(regEmail, regPassword);
                        System.out.println("Пользователь успешно прошел аутентификацию.");
                        break;
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    continue;
                default:
                    System.out.println("Команда не найдена.");
                    continue;
            }
            break;
        }
    }

    private static void menu(){
        while (true) {
            System.out.println("Введите команду: обновить, удалить, выйти.");
            String option = scanner.nextLine().trim();

            switch (option.toLowerCase()) {
                case "обновить":
                    dataBaseTracker.authenticate(regEmail, regPassword);
                    scanName();
                    scanPass();
                    dataBaseTracker.updateName(regEmail, firstName, lastName, regPassword);
                    continue;
                case "удалить":
                    dataBaseTracker.deleteUser(regEmail);
                    logIn();
                    break;
                case "выйти":
                    break;
                default:
                    System.out.println("Команда не найдена.");
            }
            break;
        }
    }


    public static void main(String[] args) {
        while (true) {
            logIn();
            menu();
        }
    }
}
