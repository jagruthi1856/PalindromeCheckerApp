import java.util.*;
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;

        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : cleaned.toCharArray()) {
            stack.push(ch);
        }
        for (char ch : cleaned.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : cleaned.toCharArray()) {
            deque.addLast(ch);
        }
        while (deque.size() > 1) {
            if (!deque.pollFirst().equals(deque.pollLast())) {
                return false;
            }
        }

        return true;
    }
}
class PalindromeChecker {
    private PalindromeStrategy strategy;
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }
    public boolean check(String input) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set!");
        }
        return strategy.isPalindrome(input);
    }
}
public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Palindrome Checker App (Strategy Pattern) ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.println("\nChoose Strategy:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();
        PalindromeChecker checker = new PalindromeChecker();
        switch (choice) {
            case 1:
                checker.setStrategy(new StackStrategy());
                break;
            case 2:
                checker.setStrategy(new DequeStrategy());
                break;
            default:
                System.out.println("Invalid choice!");
                scanner.close();
                return;
        }gi
        boolean result = checker.check(input);

        if (result) {
            System.out.println("Result: The string is a Palindrome ✅");
        } else {
            System.out.println("Result: The string is NOT a Palindrome ❌");
        }

        scanner.close();
    }
}