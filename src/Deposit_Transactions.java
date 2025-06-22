public class Deposit_Transactions implements Transactions {
    private double amount;

    public Deposit_Transactions(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void accept(Transactions_Visitor visitor) {
        visitor.visit(this);
    }
}
