import java.util.*;
import java.io.*;

public class relocation {
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
        int r = sc.nextInt();
        int[] arr = sc.readArray(n);
        while (r-->0) {
            int t = sc.nextInt();
            if (t==1) {
                arr[sc.nextInt()-1] = sc.nextInt();
            } else {
                int d = arr[sc.nextInt()-1]-arr[sc.nextInt()-1];
                System.out.println(Math.abs(d));
            }
        }
    }
}
