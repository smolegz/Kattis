import java.util.*;
import java.io.*;

public class umferd {
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
        int m = sc.nextInt();
        int n = sc.nextInt();
        long t = m*n;
        int e = 0;
        while (n-- > 0) {
            String s = sc.next();
            for (int i =0;i<m;i++) {
                if (s.charAt(i) == '.') {
                    e++;
                }
            }
        }
        double p = e/(double)t;
        System.out.println(p);
    }
}
