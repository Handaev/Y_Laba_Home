package tracker.structure;

public class Transaction {
    private String id;
    private String description;
    private double amount;
    private String category;
    private String date;
    private String type; // "income" or "expense"

    public Transaction(String id, String description, double amount, String category, String date, String type) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}
