import java.util.*;
import java.io.*;

public class olympusmans {
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

        Pair (int a, int b) {
            this.a=a;
            this.b=b;
        }

        public int compareTo(Pair o) {
            return o.a - this.a;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        int top  = 0;
        int idx = 0;
        int first = sc.nextInt();
        arr.add(0);
        for (int i=1;i<n;i++) {
            int k = sc.nextInt()-first;
            arr.add(k);
            if (k > top) {
                top = k;
                idx = i;
            }

        }
        List<Integer> ls = arr.subList(0,idx);
        double minG = Double.MAX_VALUE;
        for (int i=0;i<ls.size();i++) {
            double g = (double) (top-ls.get(i))/ (idx-i);
            minG = Math.min(minG,g);
        }
        double c4 = top - minG*idx;
        double x4 = (4-c4)/minG;
        if (x4 > 0) {
            System.out.println(0);
        } else {
            System.out.println((long) -(x4-1));
        }
        //427.5




    }
}
