import java.util.*;
import java.io.*;

public class sort {
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
        int n;
        int freq;

        Pair (int n, int f) {
            this.n=n;
            this.freq=f;
        }
    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);
        int n = sc.nextInt();
        int c = sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> ls = new ArrayList<>();
        while (n-- >0) {
            int k = sc.nextInt();
            if (ls.contains(k)) {
                int f = map.get(k);
                map.put(k,f+1);
            } else {
                ls.add(k);
                map.put(k,1);
            }
        }
        ArrayList<Pair> arr = new ArrayList<>();
        for (int i =0;i<ls.size();i++) {
            arr.add(new Pair(i,map.get(ls.get(i))));
        }
        arr.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.freq == o2.freq) {
                    return o1.n - o2.n;
                } else {
                    return o2.freq-o1.freq;
                }
            }
        });
        for (Pair p : arr) {
            for (int i =0;i < p.freq;i++) {
                writer.print(ls.get(p.n) + " ");
            }
        }
        writer.flush();
    }
}
