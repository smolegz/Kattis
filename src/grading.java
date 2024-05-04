import java.util.*;
import java.io.*;

public class grading {
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
        String a;
        int b;

        Pair (String a,int b) {
            this.a=a;
            this.b=b;
        }

        public int compareTo(Pair o) {
            return o.b-this.b;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair("A",sc.nextInt()));
        pq.add(new Pair("B",sc.nextInt()));
        pq.add(new Pair("C",sc.nextInt()));
        pq.add(new Pair("D",sc.nextInt()));
        pq.add(new Pair("E",sc.nextInt()));
        int n = sc.nextInt();
        while (!pq.isEmpty() && pq.peek().b > n) {
            pq.poll();
        }
        System.out.println(pq.isEmpty() ? "F": pq.peek().a);
    }
}
