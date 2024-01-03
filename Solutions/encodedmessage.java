import java.util.*;
import java.io.*;

public class encodedmessage {
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
        int tc = sc.nextInt();
        while (tc-- >0) {
            String s = sc.next();
            int k = (int) Math.sqrt(s.length());
            char[][] arr = new char[k][k];
            int c = 0;
            for (int i=0;i<k;i++) {
                for (int j=0;j<k;j++) {
                    arr[i][j] = s.charAt(c);
                    c++;
                }
            }
            for (int j = (k-1); j>=0; j--) {
                for (int i=0;i<k;i++) {
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println();
        }
    }
}
