import java.util.*;
import java.io.*;

public class stickykeys {
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
        String s = sc.br.readLine();
        String r = "";
        r += s.charAt(0);
        char p = s.charAt(0);
        for (int i=1;i<s.length();i++) {
            char c = s.charAt(i);
            if (c != p) {
                r += c;
            }
            p = c;
        }
        System.out.println(r);
    }
}
