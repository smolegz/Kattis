import java.io.*;
import java.util.*;

public class naturereserve {
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
    public static class Pair implements Comparable<Pair>{
        int a;
        long w;

        Pair(int a, long w) {
            this.a =a;

            this.w =w;
        }

        public int compareTo(Pair o ) {
            if (this.w == o.w) {
                return this.a -o.a;
            } else {
                return Long.compare(this.w,o.w);
            }

        }
    }
    public static void main(String[] arg) throws Exception {
        FastScanner sc = new FastScanner();
        int tc = sc.nextInt();
        while (tc-- >0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int L = sc.nextInt();
            int s = sc.nextInt();
            TreeSet<Pair> pq = new TreeSet<>();
            ArrayList<Integer> initial = new ArrayList<>();
            boolean[] visited = new boolean[n];
            long count = 0;
            while (s-- >0) {
                int station = sc.nextInt()-1;
                initial.add(station);
                visited[station] = true;
                count++;
            }
            HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();
            for (int i =0;i<n;i++) {
                adj.put(i,new ArrayList<>());
            }
            while (m-- >0) {
                int a = sc.nextInt()-1;
                int b = sc.nextInt()-1;
                int w = sc.nextInt();
                adj.get(a).add(new Pair(b, w+L));
                adj.get(b).add(new Pair(a, w+L));
            }
            long cost = 0;

            for (int i : initial) {
                for (Pair p : adj.get(i)) {
                    pq.add(new Pair(p.a,p.w));
                }
            }

            while(!pq.isEmpty()) {
                Pair p = pq.pollFirst();
                //System.out.println(p.a);
                if (!visited[p.a]) {
                    visited[p.a] = true;
                    cost += p.w;
                    count += 1;
                    if (count > n-1) break;
                    for (Pair pp : adj.get(p.a)) {
                        if (!visited[pp.a]) {
                            pq.add(new Pair(pp.a, pp.w));
                        }
                    }
                }

            }

            System.out.println(cost);

        }
    }
}
