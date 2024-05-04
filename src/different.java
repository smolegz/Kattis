import java.util.*;
import java.io.*;

public class different {
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
            try {
                String a = sc.br.readLine();
                String[] arr = a.split(" ");
                long d = Math.abs(Long.parseLong(arr[0])-Long.parseLong(arr[1]));
                System.out.println(d);
            } catch (Exception e) {
                break;
            }

        }
    }
}
