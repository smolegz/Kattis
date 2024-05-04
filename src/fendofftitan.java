import java.io.*;
import java.util.*;

public class fendofftitan {
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
    public static class Triple implements Comparable<Triple> {
        int t;
        int s;
        long w;
        int i;

        Triple(int i, int a, int b,long c){
            this.t = a;
            this.s = b;
            this.w = c;
            this.i = i;
        }

        public int compareTo(Triple o) {
            if (this.t == o.t) {
                if (this.s == o.s) {
                    return Long.compare(this.w, o.w);
                } else {
                    return this.s - o.s;
                }
            } else {
                return this.t - o.t;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt() -1;
        int y = sc.nextInt() -1;

        ArrayList<ArrayList<Triple>> adj = new ArrayList<>();
        for (int i = 0; i < n;i++) {
            adj.add(new ArrayList<>());
        }
        while (m-- > 0) {
            int a = sc.nextInt() -1;
            int b = sc.nextInt() -1;
            int w = sc.nextInt();
            int c = sc.nextInt();

            adj.get(a).add(new Triple(b, c==2 ? 1:0, c==1 ? 1:0, w));
            adj.get(b).add(new Triple(a, c==2 ? 1:0, c==1 ? 1:0, w));
        }
        Triple[] dist = new Triple[n];
        Arrays.fill(dist, null);
        dist[x] = new Triple(0, 0, 0 ,0);
        PriorityQueue<Triple> pq = new PriorityQueue<>();
        pq.add(new Triple(x,0,0,0));

        while(!pq.isEmpty()) {
            Triple t = pq.poll();
            for(Triple p: adj.get(t.i)) {
                Triple newT = new Triple(p.i, t.t + p.t, t.s + p.s, t.w + p.w);
                if(dist[p.i] == null) {
                    dist[p.i] = newT;
                    pq.add(newT);
                }
                if (dist[p.i].compareTo(newT) > 0) {
                    dist[p.i] = newT;
                    pq.add(newT);
                }
            }
        }
        Triple r = dist[y];
        if (r == null) {
            System.out.println("IMPOSSIBLE");
            System.exit(0);
        }
        System.out.println(r.w + " " + r.s + " " + r.t);
    }
}
