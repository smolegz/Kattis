import java.util.*;
import java.io.*;

public class nothanks {
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
        int[] arr = sc.readArray(n);
        Arrays.sort(arr);
        long sum = 0;
        int j=0;
        int count = 0;
        for (int i = 1;i<n;i++) {
            if (i != 0 && arr[i]-arr[i-1] == 1) {
                count++;
            } else {
                //System.out.println("Adding: " + arr[j] + " " + count);
                sum += arr[j];
                j = i;
                count = 0;
            }
        }
        //System.out.println(count);
        if (count == 0) {
            sum += arr[n-1];
        } else {
            sum += arr[n-count-1];
        }
        System.out.println(sum);
    }
}
