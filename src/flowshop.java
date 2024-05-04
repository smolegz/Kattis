import java.util.*;
import java.io.*;

public class flowshop {
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
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i=0;i<n;i++) {
            arr.add(new ArrayList<>());
        }
        String[] first = sc.br.readLine().split(" ");
        n--;
        int ts = 0;
        for (int i = 0;i<m;i++) {
            arr.get(0).add(ts + Integer.parseInt(first[i]));
            ts += Integer.parseInt(first[i]);
        }

        int count = 1;
        while(n--> 0) {
            String[] input = sc.br.readLine().split(" ");
            int t =0;
            for (int i =0; i<m; i++) {
                if (arr.get(count-1).get(i) >= t) {
                    t = arr.get(count-1).get(i) + Integer.parseInt(input[i]);
                    arr.get(count).add(t);
                } else {
                    arr.get(count).add(t + Integer.parseInt(input[i]));
                    t += Integer.parseInt(input[i]);
                }
            }
            count++;
        }
        for (ArrayList<Integer> ll : arr) {
            System.out.println(ll.get(m-1));
        }
    }
}
