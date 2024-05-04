import java.util.*;
import java.io.*;

public class eligibility {
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
        PrintWriter writer = new PrintWriter(System.out);
        while (n-- >0) {
            String[] arr = sc.br.readLine().split(" ");

            if (Integer.parseInt(arr[1].split("/")[0]) >= 2010) {
                writer.println(arr[0]+" eligible");
                continue;
            }
            if (Integer.parseInt(arr[2].split("/")[0]) >= 1991) {
                writer.println(arr[0]+" eligible");
                continue;
            }
            if (Integer.parseInt(arr[3]) > 40) {
                writer.println(arr[0]+" ineligible");
                continue;
            }
            writer.println(arr[0] + " coach petitions");
        }
        writer.flush();
    }
}
