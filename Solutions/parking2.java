import java.util.*;
import java.io.*;

public class parking2 {
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
        int tc = sc.nextInt();
        while (tc-- >0) {
            int n = sc.nextInt();
            int max = 0, min = Integer.MAX_VALUE;
            for (int i=0;i<n;i++) {
                int z = sc.nextInt();
                if (z >max) max =z;
                if (z < min) min =z;
            }
            System.out.println((max-min)*2);
        }
    }
}
