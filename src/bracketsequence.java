import java.io.*;
import java.util.*;

public class bracketsequence {
    public static class FastScanner {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
    public static class Pair {
        long a;
        int b;

        Pair (long a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] arg) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();

        Stack<Pair> st = new Stack<>();
        int level = 0;
        boolean add = true;
        while (n-- > 0) {
            String s = sc.next();
            if (s.equals("(")) {
                level++;
                add = !add;
            } else if (s.equals(")")) {
                long r = add ? 0 : 1;
                while (true) {
                    if (st.isEmpty()) {
                        st.add(new Pair(r, level));
                        break;
                    }
                    Pair p = st.peek();
                    if (p.b < level ) {
                        level--;
                        st.add(new Pair(r, level));
                        break;
                    } else {
                        Pair pp = st.pop();
                        if (add) {
                            r = (long) ((r + pp.a) % (long) (Math.pow(10,9) + 7));
                        } else {
                            r = (long) ((r * pp.a) % (long) (Math.pow(10,9) + 7));
                        }
                    }
                }
                add = !add;
            } else {
                st.add(new Pair(Long.parseLong(s), level));
            }
        }
        long result = 0;
        while (!st.isEmpty()) {
            result = (long) ((result + st.pop().a) % (long) (Math.pow(10,9) + 7));
        }
        //int result = (int) (st.pop().a % (Math.pow(10,9)+7));
        System.out.println( result);

    }

}
