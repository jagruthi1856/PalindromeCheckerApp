import java.util.Stack;
import java.util.Scanner;
public class PalindromeCheck {
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter a string: ");
                String input = sc.nextLine();
                String str = input.toLowerCase();
                Stack<Character> stack = new Stack<>();

                for (int i = 0; i < str.length(); i++) {
                    stack.push(str.charAt(i));
                }
                String reversed = "";
                while (!stack.isEmpty()) {
                    reversed = reversed + stack.pop();
                }

                if (str.equals(reversed)) {
                    System.out.println("The given string is a Palindrome.");
                } else {
                    System.out.println("The given string is NOT a Palindrome.");
                }

                sc.close();
            }
        }

