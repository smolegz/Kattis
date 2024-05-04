import java.util.*;
import java.io.*;

public class pet {
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
        int a;
        int b;

        Pair (int a,int b) {
            this.a=a;
            this.b=b;
        }

        public int compareTo(Pair o) {
            return o.a-this.a;
        }
    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i=0;i<5;i++) {
            int sum = 0;
            for (int j=0;j<4;j++) {
                sum += sc.nextInt();
            }
            pq.add(new Pair(sum,i+1));
        }
        System.out.println(pq.peek().b+" "+pq.peek().a);
    }
}
