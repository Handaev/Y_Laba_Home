package tracker.data;

import tracker.User;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

public class DataBaseTracker {
    private Set<User> users = new HashSet<>();

    private boolean check(String email, String password){
        return users.stream().anyMatch(u -> u.getEmail().equals(email) & u.getPassword().equals(password));
    }

    public void registration(String fName, String lName, String email, String password){
        if(check(email, password)){
            throw new RuntimeException("Пользователь с таким Email или паролем уже существует.");
        }
        users.add(new User(fName, lName, email, password));
    }

    public void authenticate(String email, String password){
        if(!check(email, password)){
            throw new RuntimeException("Пользователь не найден.");
        }
    }

    public void updateName(String email, String fName, String lName, String pass){
        Iterator<User> users = this.users.iterator();
        while (users.hasNext()){
            User user = users.next();
            if(user.getEmail().equals(email) && this.users.remove(user)){
                user.setFirstName(fName);
                user.setLastName(lName);
                user.setPassword(pass);
                this.users.add(user);
                break;
            }
        }
    }

    public void deleteUser(String email){
        Iterator<User> users = this.users.iterator();
        while (users.hasNext()){
            User user = users.next();
            if(user.getEmail().equals(email)){
                this.users.remove(user);
            }
        }
    }



//    public void addTransaction(String email, Transaction transaction) {
//        User user = users.get(email);
//        if (user == null) {
//            throw new RuntimeException("User not found");
//        }
//        user.addTransaction(transaction);
//    }
//
//    public void updateTransaction(String email, String transactionId, String newDescription, double newAmount) {
//        User user = users.get(email);
//        if (user == null) {
//            throw new RuntimeException("User not found");
//        }
//        Transaction transaction = user.getTransactions().stream()
//                .filter(t -> t.getId().equals(transactionId))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Transaction not found"));
//        transaction.setDescription(newDescription);
//        transaction.setAmount(newAmount);
//    }
//
//    public void deleteTransaction(String email, String transactionId) {
//        User user = users.get(email);
//        if (user == null) {
//            throw new RuntimeException("User not found");
//        }
//        Transaction transaction = user.getTransactions().stream()
//                .filter(t -> t.getId().equals(transactionId))
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("Transaction not found"));
//        user.removeTransaction(transaction);
//    }
}



