import java.util.*;
import java.io.*;

public class fodelsedagsmemorisering {
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
        String s;
        int b;

        Pair (String s, int b) {
            this.s=s;
            this.b=b;
        }

        public int compareTo(Pair o) {
            return o.b - this.b;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        HashMap<String, PriorityQueue<Pair>> map = new HashMap<>();
        int n = sc.nextInt();
        while (n-- >0) {
            String name = sc.next();
            int c = sc.nextInt();
            String d = sc.next();
            if (map.containsKey(d)) {
                map.get(d).add(new Pair(name, c));
            } else {
                PriorityQueue<Pair> pq = new PriorityQueue<>();
                pq.add(new Pair(name, c));
                map.put(d, pq);
            }
        }
        Iterator<String> set = map.keySet().iterator();
        ArrayList<String> arr = new ArrayList<>();
        while (set.hasNext()) {
            String a = set.next();
            arr.add(map.get(a).poll().s);
        }
        arr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(arr.size());
        for (String z :arr) {
            System.out.println(z);
        }
    }
}
