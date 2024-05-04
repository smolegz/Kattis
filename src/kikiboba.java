import java.util.*;
import java.io.*;

public class kikiboba {
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
        String[] s = sc.next().split("");
        int k =0;
        int b=0;
        for (String c : s) {
            if (c.equals("k")) k++;
            if (c.equals("b")) b++;
        }
        if (b<k) System.out.println("kiki");
        else if (k < b) System.out.println("boba");
        else if (k == 0 && b==0) System.out.println("none");
        else System.out.println("boki");
    }
}
