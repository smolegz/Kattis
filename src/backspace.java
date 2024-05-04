import java.io.*;
import java.util.*;

public class backspace {

    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        String s = br.readLine();
        char[] arr = s.toCharArray();
        Stack<Character> st = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for (char c: arr) {
            if (c == '<') {
                st.pop();
            } else {
                st.push(c);
            }
        }
        while (!st.isEmpty()) {
            st2.push(st.pop());
        }
        while (!st2.isEmpty()) {
            writer.print(st2.pop());
        }
        writer.flush();
    }
}
