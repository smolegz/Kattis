import java.util.*;
import java.io.*;

public class greedilyincreasing {
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

    public static void main(String[] arg) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);
        int n = sc.nextInt();
        ArrayList<Integer> ls = new ArrayList<>();
        int m = Integer.MIN_VALUE;
        while (n-- > 0) {
            int k = sc.nextInt();
            if (m == Integer.MIN_VALUE) {
                ls.add(k);
                m = k;
            }
            if (k > m) {
                ls.add(k);
                m = k;
            }

        }
        writer.println(ls.size());
        for (int t : ls) {
            writer.print(t+" ");
        }
        writer.flush();
    }
}
