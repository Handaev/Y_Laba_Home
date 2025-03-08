package tracker.web;

import tracker.data.UserService;

import java.util.Scanner;

public class HomeTrackerController {
    private UserService userService = new UserService();
    private Scanner scanner = new Scanner(System.in);

    private String regEmail;
    private String regPassword;
    private String regName;

    private void scanEmail() {
        System.out.println("Enter email:");
        regEmail = scanner.nextLine();
    }

    private void scanPass() {
        System.out.println("Enter password:");
        regPassword = scanner.nextLine();
    }

    private void scanName() {
        System.out.println("Enter name:");
        regName = scanner.nextLine();
    }

    public void start() {
        while (true) {
            System.out.println("Choose an option: register, login, updateUser, deleteUser, addTransaction, updateTransaction, deleteTransaction, viewTransactions, setBudget, viewBudget, addGoal, viewGoals, calculateBalance, calculateIncome, calculateExpense, exit");
            String option = scanner.nextLine();

            switch (option.toLowerCase()) {
                case "register":
                    scanEmail();
                    scanPass();
                    scanName();
                    userService.registerUser(regEmail, regPassword, regName);
                    System.out.println("User registered successfully");
                    break;
                case "login":
                    scanEmail();
                    scanPass();
                    try {
                        userService.authenticateUser(regEmail, regPassword);
                        System.out.println("User authenticated successfully");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}


