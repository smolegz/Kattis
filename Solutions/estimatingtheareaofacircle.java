import java.util.*;
import java.io.*;

public class estimatingtheareaofacircle {
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
        while (true) {
            double d = Double.parseDouble(sc.next());
            if (d==0) break;
            double area = Math.PI*d*d;
            int t = sc.nextInt();
            int c = sc.nextInt();
            double ratio = c / (double) t;
            System.out.println(area+" "+ 4*d*d*ratio);
        }

    }
}
