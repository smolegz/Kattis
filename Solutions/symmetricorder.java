import java.util.*;
import java.io.*;

public class symmetricorder {
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
        int count = 1;
        while (true) {
            int n = sc.nextInt();
            if (n ==0) break;
            String[] arr = new String[n];
            for (int i=0;i<n;i++) {
                arr[i] = sc.next();
            }
            System.out.println("SET "+count);
            for (int i=0;i<n;i+=2) {
                System.out.println(arr[i]);
            }
            int i = n%2 == 0 ? n-1 : n-2;
            for (;i>0;i-=2) {
                System.out.println(arr[i]);
            }
            count++;
        }
    }
}
