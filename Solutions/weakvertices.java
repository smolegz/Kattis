import java.io.*;
import java.util.*;

public class weakvertices {
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
        while (true) {
            int n = sc.nextInt();
            if (n == -1) {
                break;
            }

            int[][] AM = new int[n][n];
            for (int i = 0; i <n;i++) {
                for (int j = 0; j <n;j++) {
                    AM[i][j] = sc.nextInt();
                }
            }

            for (int i =0;i <n;i++) {
                boolean weak = true;
                for (int j=0; j<n; j++) {
                    if (AM[i][j] == 0) {
                        continue;
                    } else {
                        for (int k =0; k<n;k++) {
                            if (AM[i][k] == 1 && AM[j][k] == 1) {
                                weak = false;
                            }
                        }
                    }
                }
                if (weak) {
                    writer.print(i + " ");
                }
            }
            writer.println();
        }
        writer.flush();
    }

}
