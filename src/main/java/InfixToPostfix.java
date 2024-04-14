//(Adapted and inspired by Carrano & Henry, 2018)

import java.util.Stack;

public class InfixToPostfix {

    //This method determines the precedence of different operators.
    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1; // + and - have a precedence of 1.
            case '*':
            case '/':
                return 2; // * and / have a precedence of 2.
            default:
                return -1;
        }
    }
    // This Method will convert an infix expression to a postfix expression.
    public static String convertToPostfix(String infix) {
        Stack<Character> operatorStack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); ++i) {
            char nextCharacter = infix.charAt(i);

            //ignore whitespaces
            if (Character.isWhitespace(nextCharacter)) {
                continue;
            }

            //if nextCharacter is a digit or letter append to postfix.
            if (Character.isLetterOrDigit(nextCharacter)) {
                postfix.append(nextCharacter);
            } else if (nextCharacter == '(') {
                operatorStack.push(nextCharacter);
            } else if (nextCharacter == ')') {
                // Pop from stack until '(' is encountered
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }

                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop(); // Pop the '('
                } else {
                    return "Invalid Expression! Mismatched parenthesis";
                }
            } else {
                while (!operatorStack.isEmpty() && precedence(nextCharacter) <= precedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(nextCharacter); // Push the current operator on the stack
            }
        }

        // Pop all operators from the stack and append them to the postfix
        while (!operatorStack.isEmpty()) {
            if (operatorStack.peek() == '(') {
                return "Invalid Expression! Mismatched Parenthesis!";
            }
            postfix.append(operatorStack.pop());
        }

        return postfix.toString();
    }
    }

