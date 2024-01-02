import java.util.*;
import java.io.*;

public class asciikassi {
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
        writer.print("+");
        for (int i=0;i<n;i++) {
            writer.print("-");
        }
        writer.println("+");
        for (int i=0;i<n;i++) {
            writer.print("|");
            for (int j=0;j<n;j++) {
                writer.print(" ");
            }
            writer.println("|");
        }
        writer.print("+");
        for (int i=0;i<n;i++) {
            writer.print("-");
        }
        writer.println("+");
        writer.flush();
    }
}
