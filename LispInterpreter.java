import java.util.Scanner;

public class LispInterpreter implements IEvaluator {

    @Override
    public String eval(String expression, ExecutionContext context) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //menu
        while (true) {
            System.out.println("LISP INTERPRETER");
            System.out.println("1. OPERACIONES ARITMETICAS");
            System.out.print("INGRESAR OPCION: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    operacionesAritmeticas();
                    break;
                default:
                    System.out.println("Opcion no valido");
                    break;
            }
        }
    }

    private static void operacionesAritmeticas() {
        Scanner scanner = new Scanner(System.in);
        OperacionesAritmeticas operaciones = new OperacionesAritmeticas();

        System.out.println("INGRESE OPERACION EN LISP:");
        String postfixExpression = scanner.nextLine();

        // Convertir a notación postfija
        //String postfixExpression = operaciones.convertToPostfix(infixExpression);
        //System.out.println("Expresión: " + postfixExpression);

        // Evaluar la expresión postfija
        try{
            double result = operaciones.evaluatePostfix(postfixExpression);
            System.out.println("RRESULTADO " + result);
        }
        catch(Exception e){
            System.out.println("ERROR");
        }
    }


}
