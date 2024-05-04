import java.io.*;
import java.util.*;

public class ballotboxes {
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
        float b;
        int c;

        Pair(int a, float b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int compareTo(Pair o) {
            if (this.b == o.b) {
                return this.a - o.a;
            } else {
                return Float.compare(this.b,o.b);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);
        while (true) {
            //System.out.println("NEW TEST CASE------");
            int n = sc.nextInt();
            if (n == -1) break;
            int boxes = sc.nextInt();
            TreeSet<Pair> pq = new TreeSet<>();
            int[] arr = new int[n];
            int index = 0;
            while (n-- > 0) {
                int avg = sc.nextInt();
                arr[index] = avg;
                boxes--;
                pq.add(new Pair(index, -avg, 1));
                index++;
            }

            while (boxes > 0) {
                Pair p = pq.first();
                int popl = arr[p.a];
                pq.add(new Pair(p.a, (float) -popl /(p.c+1), p.c+1 ));
                boxes--;
            }
            writer.println( (int) Math.ceil(-pq.first().b));
        }
        writer.flush();
    }


}
