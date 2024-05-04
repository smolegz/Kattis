import java.io.*;
import java.util.*;

public class modulosolitaire {
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
        int m = sc.nextInt();
        int n = sc.nextInt();
        int s = sc.nextInt();
        ArrayList<Long> a = new ArrayList<>();
        ArrayList<Long> b = new ArrayList<>();
        int temp = n;
        while (temp-- > 0) {
            long aa = sc.nextLong();
            long bb = sc.nextLong();
            a.add(aa);
            b.add(bb);
        }

        long[] dist = new long[m];
        Arrays.fill(dist, 1000000000);
        dist[s] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int i = 0; i <n; i++) {
                long r = u*a.get(i) + b.get(i);
                long  rr = r % m;
                int index = (int) rr;
                //System.out.println(rr);
                if (dist[index] == 1000000000) {
                    dist[index] = dist[u] +1;
                    q.add(index);
                }
            }
        }
        System.out.println(dist[0] == 1000000000 ? -1 : dist[0]);
    }
}
