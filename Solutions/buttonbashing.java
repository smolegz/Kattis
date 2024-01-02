import java.util.*;
import java.io.*;

public class buttonbashing {
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
        int t;
        long s;

        Pair(int t, long s) {
            this.t = t;
            this.s =s;
        }

        public int compareTo(Pair o) {
            return Long.compare(this.s,o.s);
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);
        int tc = sc.nextInt();
        while(tc-- >0) {
            int n = sc.nextInt();
            int t = sc.nextInt();
            int[] arr = sc.readArray(n);
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            TreeMap<Integer, Long> tr = new TreeMap<>();
            pq.add(new Pair(0,0L));
            tr.put(0, 0L);
            if (t==0) {
                writer.println(0 + " " + 0);
                continue;
            }
            boolean found = false;
            while (!pq.isEmpty()) {
                Pair p = pq.poll();

                for (int i =0; i<n;i++) {
                    int newT = p.t + arr[i];
                    if (newT == t) {
                        long jj = p.s+1;
                        System.out.println(jj + " " + 0);
                        found = true;
                        break;
                    }
                    if (newT <= 0 ) continue;
                    if (newT >= 3600) {
                        if (t == 3600) {
                            writer.println((p.s+1) + " " + 0);
                            found = true;
                            break;
                        }
                        if (!tr.containsKey(3600)) {
                            tr.put(3600, (p.s+1));
                            pq.add(new Pair(3600, p.s+1));
                        }
                        continue;
                    }
                    if (!tr.containsKey(newT)) {
                        tr.put(newT,p.s+1);
                        pq.add(new Pair(newT, p.s+1));
                    }
                }
                if(found) break;
            }
            if (!found) {
                int k = tr.higherKey(t);
                writer.println(tr.get(k) + " " + (k-t));
            }
        }
        writer.flush();
    }
}