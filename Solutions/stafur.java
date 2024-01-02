import java.util.*;
import java.io.*;

public class stafur {
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

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        ArrayList<String> ls = new ArrayList<>();
        ls.add("A");
        ls.add("E");
        ls.add("I");
        ls.add("O");
        ls.add("U");
        String s = sc.next();
        if (s.equals("Y")) {
            System.out.print("Kannski");
            System.exit(0);
        }
        System.out.println(ls.contains(s) ? "Jebb" :"Neibb");
    }
}
