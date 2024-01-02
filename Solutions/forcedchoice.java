import java.util.*;
import java.io.*;

public class forcedchoice {
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
        int n = sc.nextInt();
        int k = sc.nextInt();
        int tc = sc.nextInt();
        while (tc-->0) {
            int z = sc.nextInt();
            ArrayList<Integer> arr =new ArrayList<>();
            for (int i=0;i<z;i++) {
                arr.add(sc.nextInt());
            }
            if (arr.contains(k)) System.out.println("KEEP");
            else System.out.println("REMOVE");
        }

    }
}
