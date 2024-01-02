import java.util.*;
import java.io.*;

public class zanzibar {
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
        while (tc-->0) {
            ArrayList<Integer> arr = new ArrayList<>();
            int sum =0;
            while (true) {
                int n = sc.nextInt();
                if (n==0) break;
                else arr.add(n);
            }
            for (int i=1;i<arr.size();i++) {
                if (2*arr.get(i-1) < arr.get(i)) sum += arr.get(i)-2*arr.get(i-1);
            }
            System.out.println(sum);
        }

    }
}
