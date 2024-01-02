import java.util.*;
import java.io.*;

public class rankproblem {
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
        LinkedList<Integer> ls = new LinkedList<>();
        for (int i = 0;i<n;i++) {
            ls.add(i+1);
        }
        while (m-- > 0) {
            int a =  Integer.parseInt(sc.next().substring(1));
            int b =  Integer.parseInt(sc.next().substring(1));
            if (ls.indexOf(a) > ls.indexOf(b)) {
                int t = ls.indexOf(a);
                ls.removeFirstOccurrence(b);
                ls.add(t, b);
            }
        }
        Object[] ob = ls.toArray();
        for (Object k : ob) {
            System.out.print("T"+(int)k + " ");
        }
    }
}
