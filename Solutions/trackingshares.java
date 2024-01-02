import java.util.*;
import java.io.*;

public class trackingshares {
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
        int day;
        long shares;

        public Pair (int a, long shares) {
            this.day = a;
            this.shares = shares;
        }

        public int compareTo(Pair o) {
            return this.day - o.day;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);
        int c = sc.nextInt();
        TreeMap<Integer, TreeMap<Integer,Long>> tr = new TreeMap<>();
        TreeSet<Integer> days = new TreeSet<>();
        while (c > 0) {
            int k = sc.nextInt();
            while (k-- > 0) {
                long s = sc.nextLong();
                int d = sc.nextInt();
                days.add(d);
                if (tr.containsKey(c)) {
                    tr.get(c).put(d,s);
                } else {
                    TreeMap<Integer, Long> map = new TreeMap<>();
                    map.put(d,s);
                    tr.put(c,map);
                }
            }
            c--;
        }

        Iterator<Integer> iter = days.iterator();
        while (iter.hasNext()) {
            long sum = 0;
            int key = tr.firstKey();
            int day = iter.next();
            //writer.print("Day: " + day+ " ");
            while (key != -1) {
                if (tr.get(key).get(day) != null) {
                    sum += tr.get(key).get(day);
                } else {
                    sum += tr.get(key).lowerEntry(day) == null ? 0 :
                            tr.get(key).lowerEntry(day).getValue();
                }
                key = tr.higherKey(key) == null ? -1 : tr.higherKey(key);
            }
            writer.print(sum + " ");
        }
        writer.flush();
    }
}
