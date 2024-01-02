import java.util.*;
import java.io.*;

public class classy {
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
        long n;

        Pair (String s, long n) {
            this.s =s;
            this.n=n;
        }

        public int compareTo(Pair o) {
            if (this.n == o.n) {
                return this.s.compareTo(o.s);
            } else {
                return Long.compare(o.n,this.n);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            ArrayList<ArrayList<String>> arr = new ArrayList<>();
            ArrayList<String> name = new ArrayList<>();
            for (int i =0;i<n;i++) { arr.add(new ArrayList<>()); }
            int max = 0;
            int count = 0;
            while (n-- >0) {
                String s = sc.next();
                s = s.substring(0,s.length()-1);
                String[] c = sc.next().split("-"); sc.next();
                for (int i= c.length-1; i>=0;i--) {
                    arr.get(count).add(c[i]);
                }
                max = Math.max(max, c.length);
                name.add(s);
                count++;
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            count = 0;
            for (ArrayList<String> ll : arr) {
                long k= 0;
                for (int i = 0;i<ll.size();i++) {
                    if (ll.get(i).equals("upper")) {
                        k = k*10 + 3;
                    } else if (ll.get(i).equals("middle")) {
                        k = k*10 + 2;
                    } else {
                        k = k*10 + 1;
                    }
                }
                for (int i=0;i<max-ll.size();i++) {
                    k = k*10 + 2;
                }
                pq.add(new Pair(name.get(count), k));
                count++;
            }
            while (!pq.isEmpty()) {
                Pair p = pq.poll();
                System.out.println(p.s);
            }
            System.out.println("==============================");
        }
    }
}
