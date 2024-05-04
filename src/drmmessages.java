import java.util.*;
import java.io.*;

public class drmmessages {
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
        int n = s.length();
        String a = s.substring(0,n/2);
        String b = s.substring(n/2,n);
        int aR = 0;
        int bR = 0;
        for (int i=0;i<a.length();i++) {
            aR += a.charAt(i)-65;
            bR += b.charAt(i)-65;
        }
        String c = "";
        String d = "";
        for (int i =0;i<a.length();i++) {
            int k = a.charAt(i) + aR - 65;
            k = k%26+65;
            c += (char) k;

            k = b.charAt(i) + bR - 65;
            k = k%26+65;
            d += (char) k;
        }
        String e = "";
        for (int i=0;i<a.length();i++) {
            int z = c.charAt(i) + (d.charAt(i)-65)-65;
            z = z%26+65;
            e += (char) z;
        }
        System.out.println(e);
    }
}
