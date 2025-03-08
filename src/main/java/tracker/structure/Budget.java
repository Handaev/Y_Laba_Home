package tracker.structure;

public class Budget {
    private double monthlyLimit;

    public Budget() {
        this.monthlyLimit = 0.0;
    }

    public double getMonthlyLimit() {
        return monthlyLimit;
    }

    public void setMonthlyLimit(double monthlyLimit) {
        this.monthlyLimit = monthlyLimit;
    }
}