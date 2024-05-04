import java.util.*;
import java.io.*;

public class cups {
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
    public static class Pair implements Comparable<Pair> {
        double k;
        String s;

        Pair (double k, String s) {
            this.k=k;
            this.s=s;
        }

        public int compareTo(Pair o) {
            return Double.compare(this.k,o.k);
        }
    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        while (n-- >0) {
            String a = sc.next();
            String b = sc.next();
            int c = Character.compare(a.charAt(0),b.charAt(0));
            if (c<0) {
                double f = Double.parseDouble(a)/ 2.0;
                pq.add(new Pair(f, b));
            } else {
                double f =  Double.parseDouble(b);
                pq.add(new Pair(f ,a));
            }
        }
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            System.out.println(p.s);
        }
    }
}
