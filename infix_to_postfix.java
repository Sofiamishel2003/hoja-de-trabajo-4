/**
 * La clase infix_to_postfix proporciona un método para convertir una expresión matemática infija en una expresión posfija.
 */
public class infix_to_postfix {

    /**
     * Convierte una expresión matemática infija en una expresión posfija.
     * @param infix La expresión matemática infija a convertir.
     * @return La expresión matemática posfija.
     */
    public static String infixToPostfix(String infix) {
        String postfix = "";
        Stack_vector<Character> stack = new Stack_vector<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                postfix += c+" ";
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pull()+" ";
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "Invalid expression";
                } else {
                    stack.pull();
                }
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfix += stack.pull() +" ";
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pull();
        }
        System.out.println(postfix);
        return postfix;
    }

    /**
     * Devuelve la precedencia de un operador matemático.
     * @param c El operador para obtener la precedencia.
     * @return La precedencia del operador. Si el operador no es válido, devuelve -1.
     */
    public static int precedence(char c) {
        switch (c) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}