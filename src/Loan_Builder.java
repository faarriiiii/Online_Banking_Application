public class Loan_Builder {

    private String clientName;
    private double amount;
    private double interestRate;
    private String loanType;
    private int years;


    private Loan_Builder(Builder builder) {
        this.amount = builder.amount;
        this.interestRate = builder.interestRate;
        this.loanType = builder.loanType;
        this.clientName = builder.clientName;
        this.years = builder.years;
    }


    public double getAmount() {
        return amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getYears() {
        return years;
    }

    public String getClientName() {
        return clientName;
    }

    public String getLoanType() {
        return loanType;
    }

    // Builder class to construct Loan_Builder object
    public static class Builder {
        private double amount;
        private double interestRate;
        private String loanType;
        private String clientName;
        private int years;

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setInterestRate(double interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Builder setLoanType(String loanType) {
            this.loanType = loanType;
            return this;
        }

        public Builder setClientName(String clientName) {
            this.clientName = clientName;
            return this;
        }

        public Builder setYears(int years) {
            this.years = years;
            return this;
        }

        public Loan_Builder build() {
            return new Loan_Builder(this);
        }
    }


    public double calculateMonthlyPayment() {
        double principal = this.amount;
        double annualInterestRate = this.interestRate;
        int numberOfYears = this.years;


        double monthlyRate = (annualInterestRate / 100) / 12;

        int numberOfPayments = numberOfYears * 12;


        return (principal * monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments)) /
                (Math.pow(1 + monthlyRate, numberOfPayments) - 1);
    }


}
