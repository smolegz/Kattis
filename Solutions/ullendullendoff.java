import java.util.*;
import java.io.*;

public class ullendullendoff {
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
        String[] arr = sc.br.readLine().split(" ");
        if (arr.length > 13) {
            System.out.println(arr[12]);
        } else {
            int k = 13%n;
            if (k == 0) System.out.println(arr[arr.length-1]);
            else System.out.println(arr[k-1]);
        }
    }
}
