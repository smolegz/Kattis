import java.io.*;
import java.util.*;

public class shortestpath2 {
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
    public static class Quad {
        int a; //dest
        long b; //t0
        long c; // interval
        int w;

        Quad(int a, int b, long c, int w) {
            this.a=a;
            this.b=b;
            this.c=c;
            this.w=w;
        }
    }

    public static class Pair implements Comparable<Pair> {
        int a;
        long t;

        Pair(int a, long w) {
            this.a=a;
            this.t=w;
        }

        public int compareTo(Pair o) {
            return Long.compare(this.t,o.t);
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int query = sc.nextInt();
            int s = sc.nextInt();

            if (n == 0 && m == 0 && query == 0 && s ==0) break;

            ArrayList<ArrayList<Quad>> adj = new ArrayList<>();
            for (int i=0;i<n;i++) {
                adj.add(new ArrayList<>());
            }
            while (m-- >0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int t0 = sc.nextInt();
                int interval = sc.nextInt();
                int w = sc.nextInt();

                adj.get(a).add(new Quad(b,t0,interval,w));
            }

            long[] dist = new long[n];

            Arrays.fill(dist, Long.MAX_VALUE);
            dist[s] = 0L;
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(s,0L));

            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                int x = p.a;
                long time = p.t;
                if (dist[x] != time) continue;
                for (Quad q : adj.get(x)) {
                    long newDist = Long.MAX_VALUE;
                    if (q.c == 0 && time <= q.b) {
                        newDist = q.b + q.w;
                    } else if (q.c != 0) {
                        long c = (time - q.b) / q.c + (time-q.b) %  q.c == 0 ? 0 : 1;
                        if ((time-q.b)< 0) c = 0;
                        newDist = q.b + c*q.c + q.w;
                    }
                    if (dist[q.a] > newDist) {
                        dist[q.a] = newDist;
                        pq.add(new Pair(q.a, newDist));
                    }
                }
            }
            for (int x =0;x<query;x++) {
                int end = sc.nextInt();
                writer.println(dist[end] == Long.MAX_VALUE? "Impossible" : dist[end]);
            }

            writer.println(); //empty line after each TC
        }

        writer.flush();
    }
}
