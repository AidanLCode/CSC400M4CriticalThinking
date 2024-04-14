import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter and infix expression");
        String infix = scanner.nextLine();

        String postfix = InfixToPostfix.convertToPostfix(infix);
        System.out.println("The postfix expression is: " + postfix);

        scanner.close();

    }

}
