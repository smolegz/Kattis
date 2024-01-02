import java.util.*;
import java.io.*;

public class vefthjonatjon {
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
        int[] arr = new int[3];
        while (n-->0) {
            String[] in = sc.br.readLine().split(" ");
            for (int i=0;i<3;i++) {
                if (in[i].equals("J")) arr[i] += 1;
            }
        }
        System.out.println(Math.min(arr[0], Math.min(arr[1], arr[2])));
    }
}
