import java.util.Scanner;

public class OTP implements Authentication {

    private final String correctPassword = "Fari123";

    @Override
    public boolean authenticate(Scanner scanner) {
        System.out.print("Enter your password: ");
        String input = scanner.nextLine();
        if (correctPassword.equals(input)) {
            return true;
        } else {
            System.out.println("Incorrect password.");
            return false;
        }
    }
}