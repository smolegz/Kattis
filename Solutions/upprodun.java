import java.util.*;
import java.io.*;

public class upprodun {
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
        PrintWriter writer = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if (n == 1) {
            for (int i=0;i<m;i++) {
                writer.print("*");
            }
            writer.flush();
            System.exit(0);
        }
        if (n == 2) {
            int k = m/2;
            for (int i=0;i<k;i++) {
                writer.print("*");
            }
            writer.println();
            for (int i=0;i<m-k;i++) {
                writer.print("*");
            }
            writer.flush();
            System.exit(0);
        }
        if (m%n == 0) {
            for (int i=0;i<n;i++) {
                for (int j=0;j<m/n;j++) {
                    writer.print("*");
                }
                writer.println();
            }
            writer.flush();
            System.exit(0);
        } else {
            String[] arr = new String[n];
            Arrays.fill(arr,"");
            int i = 0;
            while (m >0) {
                if (i == n) i = 0;
                arr[i] += "*";
                m--;
                i++;
            }
            for (String s : arr) {
                writer.println(s);
            }
            writer.flush();
        }
    }
}
