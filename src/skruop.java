import java.util.*;
import java.io.*;

public class skruop {
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
        int n = sc.nextInt();
        int k = 7;
        while (n-- >0) {
            String s = sc.br.readLine();
            if (s.equals("Skru op!")) {
                if (k != 10) {
                    k++;
                }
            }
            if (s.equals("Skru ned!")) {
                if (k != 0) {
                    k--;
                }
            }
            //System.out.println(k);
        }
        System.out.println(k);
    }
}
