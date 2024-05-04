import java.io.*;
import java.util.*;

public class invasion {
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
    public static class Quad implements Comparable<Quad> {
        int v;
        long dist;
        int a;
        long b;

        Quad (int v, long dist, int a) {
            this.v =v;
            this.dist = dist;
            this.a = a;
        }

        public int compareTo(Quad o) {
            return Long.compare(this.dist, o.dist);
        }
    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);
        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int q = sc.nextInt();
            int K = sc.nextInt();
            if (n == 0 && m == 0) {
                break;
            }
            ArrayList<ArrayList<Quad>> adj = new ArrayList<>();
            for (int i =0;i<n;i++) {
                adj.add(new ArrayList<>());
            }
            while (m-- >0) {
                int u = sc.nextInt() -1;
                int v = sc.nextInt() -1;
                long w = sc.nextLong();
                adj.get(u).add(new Quad(v,w,0));
                adj.get(v).add(new Quad(u,w,0));
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i =0;i<n;i++) {
                set.add(i);
            }
            long[] dist = new long[n];
            Arrays.fill(dist, Long.MAX_VALUE);
            ArrayList<Integer> base = new ArrayList<>();
            while(q-- >0) {
                PriorityQueue<Quad> pq = new PriorityQueue<>();
                int s = sc.nextInt()-1;
                set.remove(s);
                base.add(s);
                dist[s]= 0;
                pq.add(new Quad(s,0,1));
                while(!pq.isEmpty()) {
                    Quad qd = pq.poll();

                    if (qd.dist == dist[qd.v]) {
                        for (Quad x : adj.get(qd.v)) {
                            if (base.contains(x.v)) continue;
                            long r = dist[qd.v] + x.dist;
                            if (dist[x.v] > r && r < K) {
                                dist[x.v] = r;
                                set.remove(x.v);
                                pq.add(new Quad(x.v, r, 0));
                            }
                        }
                    }

                }
                writer.println(set.size());
            }
            writer.println();
        }
        writer.flush();
    }
}
