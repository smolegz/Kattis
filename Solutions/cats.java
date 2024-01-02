import java.io.*;
import java.util.*;

public class cats {
    public static class UnionFind {                                              // OOP style
        private ArrayList<Integer> p, rank, setSize;
        private int numSets;

        public UnionFind(int N) {
            p = new ArrayList<>(N);
            rank = new ArrayList<>(N);
            setSize = new ArrayList<>(N);
            numSets = N;
            for (int i = 0; i < N; i++) {
                p.add(i);
                rank.add(0);
                setSize.add(1);
            }
        }

        public int findSet(int i) {
            if (p.get(i) == i) return i;
            else {
                int ret = findSet(p.get(i)); p.set(i, ret);
                return ret; } }

        public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

        public void unionSet(int i, int j) {
            if (!isSameSet(i, j)) { numSets--;
                int x = findSet(i), y = findSet(j);
                // rank is used to keep the tree short
                if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
                else                           { p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
                    if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } }
    }
    public static class Triple implements Comparable<Triple> {
        int a;
        int b;
        int c;

        Triple(int a, int b,int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int compareTo(Triple o) {
            if (this.a == o.a) {
                if (this.b == o.b) {
                    return this.c - o.c;
                } else {
                    return this.b - o.b;
                }
            } else {
                return this.a - o.a;
            }
        }
    }
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

    public static void main(String[] arg) throws Exception {
        FastScanner sc = new FastScanner();
        int T = sc.nextInt();
        while (T-- > 0) {
            PriorityQueue<Triple> pq = new PriorityQueue<>();
            int m = sc.nextInt();
            int c = sc.nextInt();
            int combi = (c*(c-1)) /2;
            while (combi-- > 0) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int w = sc.nextInt();
                pq.add(new Triple(w, a, b));
            }
            UnionFind ufds = new UnionFind(c);
            int milk = 1;
            while (!pq.isEmpty()) {
                Triple tt = pq.poll();
                if (ufds.isSameSet(tt.b, tt.c)) {
                    continue;
                } else {
                    milk += tt.a + 1;
                    ufds.unionSet(tt.b, tt.c);
                }
            }
            System.out.println(milk <= m ? "yes" : "no");
        }
    }
}

