import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class MaquinaPilha {

    public static void main(String[]args) {
        Stack<Integer> stack = new Stack<Integer>();

        try{
            BufferedReader file = new BufferedReader(new FileReader(args[0]));

            String line;
            int op1, op2, ans;

            while ((line = file.readLine()) != null) {
                if (line.contains("PUSH")) {
                    String[] tokens = line.split(" ");

                    stack.push(Integer.parseInt(tokens[1]));
                }

                if (line.equals("MULT")) {
                    if (stack.size() >= 2) {
                        op2 = stack.pop();
                        op1 = stack.pop();

                        ans = op1 * op2;

                        stack.push(ans);
                    } else {
                        System.out.println("Erro na multiplicação, falta elementos na pilha!");
                    }
                }

                if (line.equals("SUM")) {
                    if (stack.size() >= 2) {
                        op2 = stack.pop();
                        op1 = stack.pop();

                        ans = op1 + op2;

                        stack.push(ans);
                    } else {
                        System.out.println("Erro na soma, falta elementos na pilha!");
                    }
                }

                if (line.equals("SUB")) {
                    if (stack.size() >= 2) {
                        op2 = stack.pop();
                        op1 = stack.pop();

                        ans = op1 - op2;

                        stack.push(ans);
                    } else {
                        System.out.println("Erro na subtração, falta elementos na pilha!");
                    }
                }

                if (line.equals("DIV")) {
                    if (stack.size() >= 2) {
                        op2 = stack.pop();
                        op1 = stack.pop();

                        ans = op1 / op2;

                        stack.push(ans);
                    } else {
                        System.out.println("Erro na divisão, falta elementos na pilha!");
                    }
                }

                if (line.equals("PRINT")) {
                    System.out.println(stack.peek());
                }
            }

        } catch(Exception e) {
            System.out.println("Arquivo não encontrado!:\n" + e);
        }

    }
}
