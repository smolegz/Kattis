import java.util.*;
import java.io.*;

public class trik {
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
        String s = sc.next();
        int[] cups = {1,0,0};
        for (int i =0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == 'A') {
                int t = cups[0];
                cups[0] = cups[1];
                cups[1] = t;
            } else if (c == 'B') {
                int t = cups[1];
                cups[1] = cups[2];
                cups[2] = t;
            } else {
                int t = cups[0];
                cups[0] = cups[2];
                cups[2] = t;
            }
        }
        for (int i =0;i<3;i++) {
            if (cups[i] == 1) {
                System.out.print(i+1);
            }
        }
    }
}
