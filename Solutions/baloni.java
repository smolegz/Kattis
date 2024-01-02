import java.util.*;
import java.io.*;

public class baloni {
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
        int[] arrow = new int[1000001];
        for (int i = 0;i<n;i++) {
            int k = sc.nextInt();
            if (arrow[k] == 0) {
                arrow[k-1]++;
            } else {
                arrow[k-1]++;
                arrow[k]--;
            }
        }
        int sum = 0;
        for (int j : arrow) {
            sum +=j;
        }
        System.out.println(sum);
    }
}
