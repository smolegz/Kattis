import java.io.*;
import java.util.*;

public class bryr {
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
    public static class Pair {
        int a;
        int b;

        Pair(int a,int b) {
            this.a=a;
            this.b=b;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i =0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        while (m-- >0) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            int c = sc.nextInt();
            adj.get(a).add(new Pair(b,c));
            adj.get(b).add(new Pair(a,c));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Deque<Integer> deq = new ArrayDeque<>();
        dist[0] = 0;
        deq.add(0);
        while (!deq.isEmpty()) {
            int k = deq.poll();
            for (Pair p : adj.get(k)) {
                int v = p.a;
                int w = p.b;
                if (dist[v] > dist[k] + w) {
                    dist[v] = dist[k] + w;
                    if (w==1) {
                        deq.offerLast(v);
                    } else {
                        deq.offerFirst(v);
                    }
                }
            }
        }
        System.out.println(dist[n-1]);
    }
}
