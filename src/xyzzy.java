import java.io.*;
import java.util.*;

public class xyzzy {
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

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

//        public int compareTo(Pair o) {
//            if (this.b == o.b) {
//                return this.a - o.a;
//            } else {
//                return Float.compare(this.b,o.b);
//            }
//        }
    }
    static PrintWriter writer = new PrintWriter(System.out);
    static void BMF(ArrayList<Pair> ls, ArrayList<Integer> e, int n) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = -100;
        for (int i=0; i <n-1;i++) {
            for (Pair p : ls) {
                if (dist[p.a] != Long.MAX_VALUE && dist[p.b] > dist[p.a] + e.get(p.b)) {
                    dist[p.b] = dist[p.a] + e.get(p.b);
                }
            }
        }
        int index = 0;
        boolean negC = false;
        while (true) {
            long[] copy = dist.clone();
            ArrayList<Integer> cycle = new ArrayList<>();
            for (int i = index; i < ls.size(); i++) {
                Pair p = ls.get(i);
                if (copy[p.a] != Long.MAX_VALUE && copy[p.b] > copy[p.a] + e.get(p.b)) {
                    negC = true;
                    cycle.add(p.b);
                    index = i+1;
                    break;
                }
            }
            if (!cycle.isEmpty()) {
                if (dist[cycle.get(0)] >= 0 ) {
                    System.out.println("hopeless");
                }
            } else {
                if (negC) {
                    System.out.println("winnable");
                    return;
                } else {
                    break;
                }
            }
        }

        System.out.println(dist[n-1] <0 ? "winnable" : "hopeless");

    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);
        while (true) {
            int n = sc.nextInt();
            if (n == -1) break;
            ArrayList<Integer> energy = new ArrayList<>();
            ArrayList<Pair> ls = new ArrayList<>();
            for (int i = 0; i <n; i++) {
                int e = sc.nextInt();
                energy.add(-e);
                int nb = sc.nextInt();
                while (nb-- >0) {
                    int v = sc.nextInt() -1;
                    ls.add(new Pair(i,v));
                }
            }
            BMF(ls,energy, n);

        }


    }

}
