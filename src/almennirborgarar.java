import java.util.*;
import java.io.*;

public class almennirborgarar {
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

        long[] readArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static class Triple implements Comparable<Triple> {
        long time;
        long c;
        long interval;
        int idx;

        Triple (long t, long c, long i, int indx) {
            this.time =t;
            this.c =c;
            this.interval=i;
            this.idx = indx;
        }

        public int compareTo(Triple o) {
            if (this.time == o.time) {
                if (this.interval == o.interval) {
                    return Long.compare(this.idx,o.idx);
                } else {
                    return Long.compare(this.interval,o.interval);
                }
            } else {
                return Long.compare(this.time,o.time);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] arr = sc.readArray(n);

        long low = 0;
        long high = 1000000000000000000L;
        long r = 0;
        while (low<= high) {
            long mid = (low+high)/ 2;
            long t = 0;
            for (long i : arr) {
                t += mid/i;
                if (t >= m+1) break;
            }
            if (t>=m+1) {
                high = mid-1;
                r = mid;
            } else {
                low = mid +1;
            }
        }
        System.out.println(r);
    }
}
