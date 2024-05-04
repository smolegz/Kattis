import java.util.*;
import java.io.*;

public class detaileddifferences {
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
        while (n-- >0) {
            String a = sc.next();
            String b = sc.next();
            System.out.println(a);

            System.out.println(b);
            for (int i=0;i<b.length();i++) {
                if (b.charAt(i) != a.charAt(i)){
                    System.out.print("*");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
            System.out.println();
        }
    }
}
