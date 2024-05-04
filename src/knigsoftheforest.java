import java.util.*;
import java.io.*;

public class knigsoftheforest {
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

    public static class Pair implements Comparable<Pair> {
        int a;
        long b;

        Pair (int a, long b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair o) {
            return Long.compare(this.b, o.b);
        }
    }
    public static void main(String[] arg) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);
        int k = sc.nextInt();
        int n = sc.nextInt();
        Pair p = new Pair(sc.nextInt(), sc.nextLong());
        int t = n + k -2;
        ArrayList<Pair> ls = new ArrayList<>();
        ls.add(p);
        for (int i = 0; i < t; i++) {
            ls.add(new Pair(sc.nextInt(), sc.nextLong()));
        }

        ls.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.a - o2.a;
            }
        });
        TreeSet<Pair> tr = new TreeSet<>();
        int year = 2011;
        int index = 0;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = index; j < ls.size(); j++) {
                Pair s = ls.get(j);
                if (s.a != year) {
                    index = j;
                    break;
                } else {
                    tr.add(s);
                }
            }

            Pair r = tr.pollLast();
            //writer.println(r.a + " " + r.b);
            if (r.a == p.a && r.b == p.b) {
                writer.println(year);
                found = true;
                break;
            }
            year++;
        }
        if (!found) writer.println("unknown");
        writer.flush();
    }
}


