import java.util.*;
import java.io.*;

public class smil {
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
        String s = sc.next();
        Deque<Integer> smil = new ArrayDeque<>();
        int k = -1;
        while (true) {
            k = s.indexOf(":)",k+1);
            if (k == -1) break;
            else smil.add(k);
        }
        k = -1;
        while (true) {
            k = s.indexOf(";-)",k+1);
            if (k == -1) break;
            else smil.add(k);
        }
        k = -1;
        while (true) {
            k = s.indexOf(":-)",k+1);
            if (k == -1) break;
            else smil.add(k);
        }

        Object[] arr = smil.toArray();
        Arrays.sort(arr);
        for (Object o :arr) {
            System.out.println(o);
        }


    }
}
