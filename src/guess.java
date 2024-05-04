import java.util.*;
import java.io.*;

public class guess {
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
        int high = 1000;
        int low = 0;
        while (true) {
            int mid = low + (int) Math.round((high-low) /2.0);
            System.out.println(mid);
            String s = sc.next();
            if (s.equals("lower")) {
                high = mid;
            } else if (s.equals("higher")) {
                low = mid;
            } else {
                System.exit(0);
            }
        }
    }
}
