import java.util.*;
import java.io.*;

public class vedurvindhradi {
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
        double a;
        String b;

        Pair(double a,String b) {
            this.a=a;
            this.b=b;
        }

        public int compareTo(Pair o) {
            return Double.compare(this.a,o.a);
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0.2,"Logn"));
        pq.add(new Pair(1.5,"Andvari"));
        pq.add(new Pair(3.3,"Kul"));
        pq.add(new Pair(5.4,"Gola"));
        pq.add(new Pair(7.9,"Stinningsgola"));
        pq.add(new Pair(10.7,"Kaldi"));
        pq.add(new Pair(13.8,"Stinningskaldi"));
        pq.add(new Pair(17.1,"Allhvass vindur"));
        pq.add(new Pair(20.7,"Hvassvidri"));
        pq.add(new Pair(24.4,"Stormur"));
        pq.add(new Pair(28.4,"Rok"));
        pq.add(new Pair(32.6,"Ofsavedur"));
        pq.add(new Pair(200,"Farvidri"));

        double n = Double.parseDouble(sc.next());
        String prev = "";
        while (n > pq.peek().a) {
            pq.poll();
        }
        System.out.println(pq.peek().b);
    }
}
