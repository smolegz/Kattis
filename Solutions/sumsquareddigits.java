import java.util.*;
import java.io.*;

public class sumsquareddigits {
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
        for (int i=1;i<=tc;i++) {
            sc.nextInt();
            int b = sc.nextInt();
            String n = sc.next();
            String a = Integer.toString(Integer.parseInt(n,10),b);
            int sum = 0;
            for (int j=0;j<a.length();j++) {
                sum += Math.pow(Character.getNumericValue(a.charAt(j)),2);
            }
            System.out.println(i+" "+sum);
        }
    }
}
