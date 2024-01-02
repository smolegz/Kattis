import java.util.*;
import java.io.*;

public class cprnummer {
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
        String[] arr = sc.next().split("-");
        String s = arr[0] + arr[1];
        int[] ls = {4,3,2,7,6,5,4,3,2,1};
        long sum = 0;
        for (int i=0;i<10;i++) {
            sum += Character.getNumericValue(s.charAt(i)) * ls[i];
        }
        if (sum%11 ==0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
