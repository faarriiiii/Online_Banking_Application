import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static final String correctPassword = "Fari123";
    private static final String correctOtp = "123456";

    public static void main(String[] args) {


        if (!authenticate()) {
            System.out.println("Authentication failed. Exiting...");
            return;
        }

        Loan_Builder loan = new Loan_Builder.Builder()
                .setAmount(50000)
                .setInterestRate(3.5)
                .setLoanType("Home Loan")
                .setClientName("Fariha Mostafa")
                .setYears(15)
                .build();

        int choice;

        do {
            displayMainMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Returning to Main Menu...\n");
                    break;
                case 1:
                    creditCardOptions();
                    break;
                case 2:
                    performTransaction();
                    break;
                case 3:
                    calculateLoanPayment();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private static boolean authenticate() {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter your password: ");
        String passwordInput = scanner.nextLine();

        if (!passwordInput.equals(correctPassword)) {
            System.out.println("Incorrect password.");
            return false;
        }


        String otp = generateOtp();
        System.out.println("An OTP has been sent to your phone.");
        System.out.print("Enter OTP: ");
        String otpInput = scanner.nextLine();

        if (otpInput.equals(otp)) {
            System.out.println("OTP verified successfully.");
            return true;
        } else {
            System.out.println("Incorrect OTP.");
            return false;
        }
    }

    private static String generateOtp() {

        return correctOtp;
    }

    private static void displayMainMenu() {
        System.out.println("\n ♡ Welcome to Fari's Banking System ♡ \n");
        System.out.println("Select an option:");
        System.out.println("0. Return to Main Menu");
        System.out.println("1. Credit Cards");
        System.out.println("2. Make a Transaction");
        System.out.println("3. Calculate Loan Payment");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void calculateLoanPayment() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the loan amount: $");
        double principal = scanner.nextDouble();

        System.out.print("Enter the annual interest rate: ");
        double annualInterestRate = scanner.nextDouble();

        System.out.print("Enter the loan in years: ");
        int years = scanner.nextInt();

        double monthlyRate = (annualInterestRate / 100) / 12;

        int numberOfPayments = years * 12;

        double monthlyPayment = (principal * monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments)) /
                (Math.pow(1 + monthlyRate, numberOfPayments) - 1);

        System.out.println("Monthly Payment: $" + String.format("%.2f", monthlyPayment));
    }

    private static void creditCardOptions() {
        System.out.println("\nCredit Card Options");
        System.out.println("1. Make a Payment");
        System.out.println("2. Increase Credit Limit");

        System.out.print("Enter your choice: 1 to make a payment, 2 to increase credit limit: ");
        int choice3 = sc.nextInt();

        if (choice3 == 1) {
            System.out.println("You selected to make a payment.");
        } else if (choice3 == 2) {
            System.out.println("You selected to increase credit limit.");
        } else {
            System.out.println("Invalid account choice.");
        }
    }

    private static void performTransaction() {
        System.out.print("Enter transaction amount: ");
        double amount = sc.nextDouble();

        System.out.println("Select Transaction Type:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");

        int transacChoice = sc.nextInt();
        Transactions transaction = null;

        switch (transacChoice) {
            case 1:
                transaction = Transactions_Factory.createDepositTransaction(amount);
                break;
            case 2:
                transaction = Transactions_Factory.createWithdrawalTransaction(amount);
                break;
            case 3:
                transaction = Transactions_Factory.createTransferTransaction(amount);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (transaction != null) {
            System.out.println("Transaction processed: " + transaction);
        }
    }
}
