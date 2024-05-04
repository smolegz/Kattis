import java.util.*;
import java.io.*;

public class fizzbuzz {
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
        int[] arr = sc.readArray(3);
        String[] ls = new String[arr[2] + 1];
        for (int i=1;i<=arr[2];i++) {
            if (i%arr[0] == 0) {
                if (i%arr[1] == 0) System.out.println("FizzBuzz");
                else System.out.println("Fizz");
            } else if (i%arr[1] == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
    }
}
