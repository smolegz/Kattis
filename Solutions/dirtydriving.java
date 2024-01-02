import java.util.*;
import java.io.*;

public class dirtydriving {
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
        int p = sc.nextInt();
        int[] cars = sc.readArray(n);
        Arrays.sort(cars);
        long d = 0;
        for (int i =0;i<n;i++) {
            long k = (long) p *(i+1);
            //System.out.println(cars[i]+" "+k);
            if (k > cars[i]) {
                d = Math.max(d, k-cars[i]);
            }
        }
        System.out.println(d+cars[0]);
    }
}
