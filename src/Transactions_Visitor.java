public interface Transactions_Visitor {
    void visit(Deposit_Transactions deposit);
    void visit(Withdrawal_Transactions withdrawal);
    void visit(Transfer_Transactions transfer);

}
