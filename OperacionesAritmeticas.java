import java.util.Stack;

public class OperacionesAritmeticas {

    public String infixExpression;

    static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    static char associativity(char c) {
        if (c == '^')
            return 'R';
        return 'L'; // Default to left-associative
    }

    public String convertToPostfix(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // Pop '('
                } else {
                    throw new IllegalArgumentException("Expresión incorrecta: paréntesis no balanceados");
                }
            } else {
                while (!stack.isEmpty() && (prec(c) < prec(stack.peek()) ||
                        prec(c) == prec(stack.peek()) &&
                                associativity(c) == 'L')) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(' || c == ')') {
                throw new IllegalArgumentException("Expresión incorrecta: paréntesis no balanceados");
            }
            result.append(c);
        }

        return result.toString();
    }

    public double evaluatePostfix(String postfixExpression) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < postfixExpression.length(); i++) {
            char c = postfixExpression.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder number = new StringBuilder();
                while (i < postfixExpression.length() && Character.isDigit(postfixExpression.charAt(i))) {
                    number.append(postfixExpression.charAt(i++));
                }
                i--; // Retroceder el índice en uno para compensar el avance adicional en el bucle while
                stack.push(Double.parseDouble(number.toString()));
            } else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                double result;
                switch (c) {
                    case '+':
                        result = operand1 + operand2;
                        break;
                    case '-':
                        result = operand1 - operand2;
                        break;
                    case '*':
                        result = operand1 * operand2;
                        break;
                    case '/':
                        result = operand1 / operand2;
                        break;
                    case '^':
                        result = Math.pow(operand1, operand2);
                        break;
                    default:
                        throw new IllegalArgumentException("Operador no válido: " + c);
                }
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public String getInfixExpression() {
        return infixExpression;
    }
}
