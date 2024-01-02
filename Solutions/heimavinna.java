import java.util.*;
import java.io.*;

public class heimavinna {
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
        String[] in = sc.br.readLine().split(";");
        int sum = 0;
        for (int i =0;i<in.length;i++) {
            String[] s = in[i].split("-");
            if (s.length == 1) sum++;
            else {
                sum += Integer.parseInt(s[1]) - Integer.parseInt(s[0]) + 1;
            }
        }
        System.out.println(sum);
    }
}
