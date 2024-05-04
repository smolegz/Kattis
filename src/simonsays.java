import java.util.*;
import java.io.*;

public class simonsays {
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
        while (n-- >0) {
            String[] arr = sc.br.readLine().split(" ");
            if (arr[0].equals("Simon") && arr[1].equals("says")) {
                for (int i=2;i<arr.length;i++) {
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
            }
        }
    }
}
