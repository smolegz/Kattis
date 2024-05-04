import java.util.*;
import java.io.*;

public class shortestpath1 {
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
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair o ) {
            if (this.a == o.a) {
                return this.b - o.b;
            } else {
                return this.a - o.a;
            }
        }
    }

    public static void main(String[] arg) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);

        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int q = sc.nextInt();
            int s = sc.nextInt();

            if (n == 0 && m == 0 && q == 0 && s == 0) {
                break;
            }
            ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                adj.add(i, new ArrayList<>());
            }

            while (m-- > 0) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                adj.get(u).add(new Pair(v, w));

            }
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[s] = 0;
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(0 , s));

            while (!pq.isEmpty()) {
                Pair v = pq.poll();
                for (Pair p : adj.get(v.b)) {
                    if (dist[p.a] == Integer.MAX_VALUE) {
                        dist[p.a] = dist[v.b] + p.b;
                        pq.add(new Pair(dist[p.a], p.a));
                    }
                    if (dist[p.a] > dist[v.b] +p.b) {
                        dist[p.a] = dist[v.b] +p.b;
                        pq.add(new Pair(dist[p.a], p.a));
                    }
                }
            }

            while (q-- >0) {
                int k = sc.nextInt();
                writer.println(dist[k] == Integer.MAX_VALUE ? "Impossible" : dist[k]);
            }
        }
        writer.flush();

    }
}

