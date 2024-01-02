import java.util.*;
import java.io.*;

public class fadingwind {
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
        int h = sc.nextInt();
        int k = sc.nextInt();
        int v = sc.nextInt();
        int s = sc.nextInt();
        int sum =0;
        while (h>0) {
            v += s;
            v -= (int) Math.max(1, Math.floor(v/10.0));
            if (v >= k) h++;
            if (v > 0 && v <k) {
                h--;
                if (h==0) v = 0;
            }

            if (v <= 0) {
                h=0;
                v=0;
            }
            sum += v;
            if (s>0) s--;
        }
        System.out.println(sum);
    }
}
