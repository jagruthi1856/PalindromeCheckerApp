import java.util.Scanner;
import java.util.Stack;

class PalindromeChecker {

    public boolean checkPalindrome(String input) {
        if (input == null) return false;
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : cleaned.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        return cleaned.equals(reversed.toString());
    }
}

public class PalindromeCheck {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Palindrome Checker App ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The string is a Palindrome ✅");
        } else {
            System.out.println("Result: The string is NOT a Palindrome ❌");
        }

        scanner.close();
    }
}