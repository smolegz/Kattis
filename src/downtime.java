import java.util.*;
import java.io.*;

public class downtime {
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
        int n = sc.nextInt();
        int t = sc.nextInt();
        long server = 1;
        Queue<Long> q = new LinkedList<>();
        while (n-- > 0) {
            long x = sc.nextLong();
            while (!q.isEmpty() &&  x >= q.peek()) {
                q.poll();
            }
            q.offer(x+1000);
//            System.out.println(q.size());
            if (q.size() > t) {
                server = Math.max(server, q.size() %t == 0 ? q.size()/t : 1+q.size()/t);
            }
        }
        System.out.println(server);
    }
}
