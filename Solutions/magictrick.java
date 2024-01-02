import java.util.*;
import java.io.*;

public class magictrick {
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
        String[] s = sc.br.readLine().split("");
        ArrayList<String> arr = new ArrayList<>();
        for (int i=0;i<s.length;i++) {
            arr.add(s[i]);
        }

        int i =0;
        for (String ss : arr) {
            if (arr.lastIndexOf(ss) != i) {
                System.out.println(0);
                System.exit(0);
            } else {
                i++;
            }
        }
        System.out.println(1);
    }
}
