import java.util.*;

public class Main {

    public static void main(String[] argsh) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una expresión de Lisp:");
        String expression = scanner.nextLine();

        List<String> tokens = tokenize(expression);
        System.out.println("Tokens: " + tokens);

        List<Object> list = parse(tokens);
        System.out.println("Lista: " + list);

        processList(list);
    }

    // Función para identificar y separar los tokens de la expresión
    public static List<String> tokenize(String expression) {
        //  implementar la lógica para separar los tokens
        return Arrays.asList(expression.split("\\s+"));
    }

    // Función para parsear los tokens y transformarlos en una lista de objetos
    public static List<Object> parse(List<String> tokens) {
        List<Object> list = new ArrayList<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                list.add(Integer.parseInt(token));
            } else if (isLetter(token)) {
                list.add(token);
            } else if (isOperator(token)) {
                list.add(token);
            } else if (token.equals("(")) {
                list.add(parse(tokens.subList(tokens.indexOf(token) + 1, tokens.size())));
            } else if (token.equals(")")) {
                break;
            }
        }
        return list;
    }

    // Funciones auxiliares para verificar el tipo de token
    public static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isLetter(String token) {
        return token.matches("[a-zA-Z]+");
    }

    public static boolean isOperator(String token) {
        return token.matches("[+\\-*/]");
    }

    public static void processList(List<Object> list) {
        for (Object element : list) {
            if (element instanceof Integer) {
                System.out.println("Operador: " + element);
            } else if (element instanceof List) {
                System.out.println("Lista: " + element);
                processList((List<Object>) element);
            } else if (element instanceof String) {
                if (((String) element).startsWith("print")) {
                    System.out.println("Print: " + element);
                } else {
                    System.out.println("Desconocido: " + element);
                }
            }
        }
    }
}
