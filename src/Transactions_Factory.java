public class Transactions_Factory {

    public static Transactions createWithdrawalTransaction(double amount) {
        return new Withdrawal_Transactions(amount);
    }

    public static Transactions createDepositTransaction(double amount) {
        return new Deposit_Transactions(amount);
    }

    public static Transactions createTransferTransaction(double amount) {
        return new Transfer_Transactions(amount);
    }
}
