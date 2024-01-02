import java.util.*;
import java.io.*;

public class delimitersoup {

    public static boolean checker(char a, char b) {
        if ((a == '(' && b == ')') ||
                (a == '[' && b == ']') ||
                (a == '{' && b == '}'))
            return true;

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        String in = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < in.length(); i++) {
            char c =  in.charAt(i);
            if (c == ' ')
                continue;
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.empty() || !checker(stack.peek(), c)) {
                    System.out.println(c+ " " + i);
                    System.exit(0);
                }
                stack.pop();
            }
        }

        System.out.println("ok so far");
    }
}
