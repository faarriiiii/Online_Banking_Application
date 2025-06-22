import java.util.Scanner;

public class Password implements Authentication {

    private final String correctOtp = "1234";

    @Override
    public boolean authenticate(Scanner scanner) {
        System.out.print("Enter the OTP 4 digit code sent to your phone: ");
        String input = scanner.nextLine();
        if (correctOtp.equals(input)) {
            return true;
        } else {
            System.out.println("Incorrect OTP.");
            return false;
        }
    }
}