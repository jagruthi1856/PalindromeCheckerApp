import java.util.*;
interface PalindromeStrategy {
    boolean isPalindrome(String input);
    String getName(); // For display purpose
}
class StackStrategy implements PalindromeStrategy {
    public boolean isPalindrome(String input) {
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
    public String getName() {
        return "Stack Strategy";
    }
}
class DequeStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String input) {
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

    public String getName() {
        return "Deque Strategy";
    }
}
class TwoPointerStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String input) {
        String cleaned = input.replaceAll("\\s+", "").toLowerCase();
        int left = 0, right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public String getName() {
        return "Two Pointer Strategy";
    }
}
public class PalindromeCheck{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Palindrome Performance Comparison ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        List<PalindromeStrategy> strategies = new ArrayList<>();
        strategies.add(new StackStrategy());
        strategies.add(new DequeStrategy());
        strategies.add(new TwoPointerStrategy());
        System.out.println("\n--- Performance Results ---");
        for (PalindromeStrategy strategy : strategies) {
            long startTime = System.nanoTime();
            boolean result = strategy.isPalindrome(input);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println(strategy.getName() + ":");
            System.out.println("Result  : " + (result ? "Palindrome ✅" : "Not Palindrome ❌"));
            System.out.println("Time    : " + duration + " ns");
            System.out.println();
        }
        scanner.close();
    }
}