package tracker;

import tracker.data.UserService;
import tracker.structure.Goal;
import tracker.structure.Transaction;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option: register, login, updateUser, deleteUser, addTransaction, updateTransaction, deleteTransaction, viewTransactions, setBudget, viewBudget, addGoal, viewGoals, calculateBalance, calculateIncome, calculateExpense, exit");
            String option = scanner.nextLine();

            switch (option.toLowerCase()) {
                case "register":
                    System.out.println("Enter email:");
                    String regEmail = scanner.nextLine();
                    System.out.println("Enter password:");
                    String regPassword = scanner.nextLine();
                    System.out.println("Enter name:");
                    String regName = scanner.nextLine();
                    userService.registerUser(regEmail, regPassword, regName);
                    System.out.println("User registered successfully");
                    break;
                case "login":
                    System.out.println("Enter email:");
                    String loginEmail = scanner.nextLine();
                    System.out.println("Enter password:");
                    String loginPassword = scanner.nextLine();
                    try {
                        userService.authenticateUser(loginEmail, loginPassword);
                        System.out.println("User authenticated successfully");
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "updateuser":
                    System.out.println("Enter email:");
                    String updateEmail = scanner.nextLine();
                    System.out.println("Enter new name:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new password:");
                    String newPassword = scanner.nextLine();
                    try {
                        userService.updateUser(updateEmail, newName, newPassword);
                        System.out.println("User updated successfully");
                    }catch (RuntimeException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "deleteuser":
                    System.out.println("Enter email:");
                    String deleteEmail = scanner.nextLine();
                    userService.deleteUser(deleteEmail);
                    System.out.println("User deleted successfully");
                    break;
                case "addtransaction":
                    System.out.println("Enter email:");
                    String email = scanner.nextLine();
                    System.out.println("Enter transaction ID:");
                    String transactionId = scanner.nextLine();
                    System.out.println("Enter description:");
                    String description = scanner.nextLine();
                    System.out.println("Enter amount:");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter category:");
                    String category = scanner.nextLine();
                    System.out.println("Enter date:");
                    String date = scanner.nextLine();
                    System.out.println("Enter type (income/expense):");
                    String type = scanner.nextLine();
                    userService.addTransaction(email, new Transaction(transactionId, description, amount, category, date, type));
                    System.out.println("Transaction added successfully");
                    break;
                case "updatetransaction":
                    System.out.println("Enter email:");
                    String transEmail = scanner.nextLine();
                    System.out.println("Enter transaction ID:");
                    String transId = scanner.nextLine();
                    System.out.println("Enter new description:");
                    String newDescription = scanner.nextLine();
                    System.out.println("Enter new amount:");
                    double newAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new category:");
                    String newCategory = scanner.nextLine();
                    userService.updateTransaction(transEmail, transId, newDescription, newAmount, newCategory);
                    System.out.println("Transaction updated successfully");
                    break;
                case "deletetransaction":
                    System.out.println("Enter email:");
                    String delEmail = scanner.nextLine();
                    System.out.println("Enter transaction ID:");
                    String delTransId = scanner.nextLine();
                    userService.deleteTransaction(delEmail, delTransId);
                    System.out.println("Transaction deleted successfully");
                    break;
                case "viewtransactions":
                    System.out.println("Enter email:");
                    String viewEmail = scanner.nextLine();
                    System.out.println("Enter filter type (date, category, type) or 'all' for all transactions:");
                    String filterType = scanner.nextLine();
                    String filterValue = "";
                    if (!filterType.equalsIgnoreCase("all")) {
                        System.out.println("Enter filter value:");
                        filterValue = scanner.nextLine();
                    }
                    List<Transaction> transactions = userService.getTransactions(viewEmail, filterType, filterValue);
                    System.out.println("Transactions: " + transactions);
                    break;
                case "setbudget":
                    System.out.println("Enter email:");
                    String budgetEmail = scanner.nextLine();
                    System.out.println("Enter monthly budget limit:");
                    double monthlyLimit = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    userService.setBudget(budgetEmail, monthlyLimit);
                    System.out.println("Budget set successfully");
                    break;
                case "viewbudget":
                    System.out.println("Enter email:");
                    String viewBudgetEmail = scanner.nextLine();
                    double budget = userService.getBudget(viewBudgetEmail);
                    System.out.println("Monthly Budget: " + budget);
                    break;
                case "addgoal":
                    System.out.println("Enter email:");
                    String goalEmail = scanner.nextLine();
                    System.out.println("Enter goal name:");
                    String goalName = scanner.nextLine();
                    System.out.println("Enter target amount:");
                    double targetAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    userService.addGoal(goalEmail, new Goal(goalName, targetAmount));
                    System.out.println("Goal added successfully");
                    break;
                case "viewgoals":
                    System.out.println("Enter email:");
                    String viewGoalsEmail = scanner.nextLine();
                    List<Goal> goals = userService.getGoals(viewGoalsEmail);
                    System.out.println("Goals: " + goals);
                    break;
                case "calculatebalance":
                    System.out.println("Enter email:");
                    String balanceEmail = scanner.nextLine();
                    double balance = userService.calculateBalance(balanceEmail);
                    System.out.println("Current Balance: " + balance);
                    break;
                case "calculateincome":
                    System.out.println("Enter email:");
                    String incomeEmail = scanner.nextLine();
                    double totalIncome = userService.calculateTotalIncome(incomeEmail);
                    System.out.println("Total Income: " + totalIncome);
                    break;
                case "calculateexpense":
                    System.out.println("Enter email:");
                    String expenseEmail = scanner.nextLine();
                    double totalExpense = userService.calculateTotalExpense(expenseEmail);
                    System.out.println("Total Expense: " + totalExpense);
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}