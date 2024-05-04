import java.util.*;
import java.io.*;

public class ptice {
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
        int a;

        Pair (String s, int a) {
            this.s=s;
            this.a=a;
        }

        public int compareTo(Pair o) {
            if (this.a == o.a) {
                return s.compareTo(o.s);
            } else {
                return o.a - this.a;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        String[] arr = {"BCA","BABC","CCAABB"};
        String[] name = {"Adrian","Bruno","Goran"};
        int n = sc.nextInt();
        String s = sc.next();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i=0;i<3;i++) {
            double k = Math.ceil(n/(double)arr[i].length());
            String ss = "";
            for (int j=0;j<k;j++) ss += arr[i];
            if (i==0) ss = "A" + ss;
            int correct = 0;
            for (int j=0;j<n;j++) {
                if (ss.charAt(j) == s.charAt(j)) correct++;
            }
            pq.add(new Pair (name[i], correct));
        }
        Pair top = pq.poll();
        System.out.println(top.a);
        System.out.println(top.s);
        while (!pq.isEmpty() && top.a == pq.peek().a) {
            System.out.println(pq.poll().s);
        }
    }
}
