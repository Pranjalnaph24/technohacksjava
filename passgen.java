import java.security.SecureRandom;
import java.util.Scanner;

public class passgen {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Include digits? (y/n): ");
        boolean includeDigits = scanner.nextLine().trim().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecial = scanner.nextLine().trim().equalsIgnoreCase("y");

        String password = generatePassword(length, includeLowercase, includeUppercase, includeDigits, includeSpecial);
        System.out.println("Generated Password: " + password);
    }

    public static String generatePassword(int length, boolean includeLowercase, boolean includeUppercase, boolean includeDigits, boolean includeSpecial) {
        StringBuilder characterPool = new StringBuilder();
        
        if (includeLowercase) characterPool.append(LOWERCASE);
        if (includeUppercase) characterPool.append(UPPERCASE);
        if (includeDigits) characterPool.append(DIGITS);
        if (includeSpecial) characterPool.append(SPECIAL_CHARACTERS);

        if (characterPool.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected.");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
}
