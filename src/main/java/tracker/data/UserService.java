package tracker.data;

import tracker.structure.Goal;
import tracker.structure.Transaction;
import tracker.structure.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserService {
    private Map<String, User> users = new HashMap<>();

    public void registerUser(String email, String password, String name) {
        if (users.containsKey(email)) {
            throw new RuntimeException("Email already exists");
        }
        users.put(email, new User(email, password, name));
    }

    public User authenticateUser(String email, String password) {
        User user = users.get(email);
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid email or password");
        }
        return user;
    }

    public User getUser(String email) {
        return users.get(email);
    }

    public void updateUser(String email, String newName, String newPassword) {
        User user = users.get(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.setName(newName);
        user.setPassword(newPassword);
    }

    public void deleteUser(String email) {
        users.remove(email);
    }

    public void addTransaction(String email, Transaction transaction) {
        User user = users.get(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.addTransaction(transaction);
    }

    public void updateTransaction(String email, String transactionId, String newDescription, double newAmount, String newCategory) {
        User user = users.get(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Transaction transaction = user.getTransactions().stream()
                .filter(t -> t.getId().equals(transactionId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        transaction.setDescription(newDescription);
        transaction.setAmount(newAmount);
        transaction.setCategory(newCategory);
    }

    public void deleteTransaction(String email, String transactionId) {
        User user = users.get(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        Transaction transaction = user.getTransactions().stream()
                .filter(t -> t.getId().equals(transactionId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
        user.removeTransaction(transaction);
    }

    public List<Transaction> getTransactions(String email, String filterType, String filterValue) {
        User user = users.get(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user.getTransactions().stream()
                .filter(t -> filterType.equals("date") ? t.getDate().equals(filterValue) :
                        filterType.equals("category") ? t.getCategory().equals(filterValue) :
                                filterType.equals("type") ? t.getType().equals(filterValue) : true)
                .collect(Collectors.toList());
    }

    public void setBudget(String email, double monthlyLimit) {
        User user = users.get(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.getBudget().setMonthlyLimit(monthlyLimit);
    }

    public double getBudget(String email) {
        User user = users.get(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user.getBudget().getMonthlyLimit();
    }

    public void addGoal(String email, Goal goal) {
        User user = users.get(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.addGoal(goal);
    }

    public List<Goal> getGoals(String email) {
        User user = users.get(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user.getGoals();
    }

    public double calculateBalance(String email) {
        User user = users.get(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        double balance = 0.0;
        for (Transaction transaction : user.getTransactions()) {
            if (transaction.getType().equals("income")) {
                balance += transaction.getAmount();
            } else {
                balance -= transaction.getAmount();
            }
        }
        return balance;
    }

    public double calculateTotalIncome(String email) {
        User user = users.get(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user.getTransactions().stream()
                .filter(t -> t.getType().equals("income"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double calculateTotalExpense(String email) {
        User user = users.get(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return user.getTransactions().stream()
                .filter(t -> t.getType().equals("expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
}
