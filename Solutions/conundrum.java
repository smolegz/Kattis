import java.util.*;
import java.io.*;

public class conundrum {
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
        String s = sc.next();
        int n = s.length()/3;
        int r = 0;
        char[] c = {'P','E','R'};
        for (int i=0;i<n;i++) {
            for (int j=0;j<3;j++) {
                char z = s.charAt(i*3+j);
                if (z != c[j]) r++;
            }
        }
        System.out.println(r);
    }
}
