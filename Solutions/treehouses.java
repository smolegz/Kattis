import java.io.*;
import java.util.*;

public class treehouses {
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

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
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
    public static class Pair {
        double a;
        double b;

        Pair(double a, double b, double c) {
            this.a = a;
            this.b = b;
        }

    }

    public static class Triple implements Comparable<Triple> {
        int a;
        int b;
        double w;

        Triple(int a, int b, double w) {
            this.a=a;
            this.b=b;
            this.w=w;
        }


        @Override
        public int compareTo(Triple o) {
            return Double.compare(this.w,o.w);
        }
    }

    public static void main(String[] arg) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int e = sc.nextInt();
        int p = sc.nextInt();

        Pair[] arr = new Pair[n];
        UnionFind ufds = new UnionFind(n);
        int delta = n - e;
        for (int i = 0; i < n; i++) {
            if (i < e && i != 0) {
                ufds.unionSet(i, i - 1);
            }
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            arr[i] = new Pair(x, y, 0);
        }

        while (p-- > 0) {
            int f = sc.nextInt();
            int s = sc.nextInt();
            ufds.unionSet(f - 1, s - 1);
        }

        ArrayList<Triple> edges = new ArrayList<>();
        for (int i =0; i<n; i++) {
            for (int j = i+1; j<n; j++) {
                Pair fs = arr[i];
                Pair sd = arr[j];
                double d = Math.sqrt(Math.pow(fs.b-sd.b,2) + Math.pow(fs.a-sd.a,2));
                edges.add(new Triple(i,j,d));
            }
        }
        edges.sort(new Comparator<Triple>() {
            @Override
            public int compare(Triple o1, Triple o2) {
                return Double.compare(o1.w, o2.w);
            }
        });

        double result = 0;
        for (int i =0;i< edges.size();i++) {
            Triple ed = edges.get(i);
            if (!ufds.isSameSet(ed.a,ed.b)) {
                result += ed.w;
                ufds.unionSet(ed.a,ed.b);
            }
        }
        System.out.println(result);
    }

}
