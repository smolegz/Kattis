import java.io.*;
import java.util.*;

public class evenup {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int c1 = Integer.parseInt(cards[i]);
            if (stack.empty()) {
                stack.add(c1);
            } else {
                int c2 = stack.peek();
                if ((c1+c2)%2 == 0) {
                    stack.pop();
                } else {
                    stack.add(c1);
                }
            }
        }
        System.out.println(stack.size());
    }
}
