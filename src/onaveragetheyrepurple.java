//shortest path - 1 is the answer.
// Use AdjList to store the edges
// Use BFS starting from 1.
import java.io.*;
import java.util.*;

public class onaveragetheyrepurple {
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

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        while (m-- >0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            al.get(a-1).add(b-1);
            al.get(b-1).add(a-1);
        }

         int[] dist = new int[n];
         Arrays.fill(dist, Integer.MAX_VALUE);
         dist[0] = 0;
         Queue<Integer> q = new LinkedList<>();
         q.add(0);
         while (!q.isEmpty()) {
             int u = q.poll();
             for (int v : al.get(u)) {
                 if (dist[v] == Integer.MAX_VALUE) {
                     dist[v] = dist[u] + 1;
                     q.add(v);
                 }
             }
         }
         System.out.println(dist[n-1] - 1);

    }
}
