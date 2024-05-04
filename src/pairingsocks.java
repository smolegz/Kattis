import java.util.*;
import java.io.*;

public class pairingsocks {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] socks = br.readLine().split(" ");
        Stack<String> a = new Stack<>();
        Stack<String> b = new Stack<>();
        a.addAll(Arrays.asList(socks));
        long counter = 0;
        long item = 0;
        boolean run = true;
        while (a.size() + b.size() != 0) {
            long total = a.size() + b.size();
            if (item == total - 1) {
                System.out.println("impossible");
                System.exit(0);
            }
            if (a.empty()) {
                Stack<String> temp = new Stack<>();
                a = b;
                b = temp;
            }
            String s = a.pop();
            System.out.println(s);

            while (!a.empty()) {
                String t = a.peek();
                if (t.equals(s)) {
                    a.pop();
                    counter += 2;
                    item = 0;
                } else {
                    b.add(t);
                    counter += 2;
                    item += 1;
                }
            }
        }
        //System.out.println(counter);

    }
}
