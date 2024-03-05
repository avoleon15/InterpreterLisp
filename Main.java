public class Main {
    public static void main(String[] args) {
        LispInterpreter interpreter = new LispInterpreter();
        try {
            interpreter.eval(null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
