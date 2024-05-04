import java.util.*;
import java.io.*;

public class rijeci {
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
    public static class Pair {
        int a;
        int b;

        Pair (int a,int b) {
            this.a=a;
            this.b=b;
        }
    }

    public static Pair result(int k ) {
        if (k==0) {
            return new Pair(1,0);
        } else {
            Pair p = result(k-1);
            return new Pair(p.b, p.a+p.b);
        }
    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        Pair p = result(sc.nextInt());
        System.out.println(p.a+" "+p.b);
    }
}
