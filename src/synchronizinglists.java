import java.util.*;
import java.io.*;

public class synchronizinglists {
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
            return this.b - o.b;
        }
    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        while (true) {
            int n = sc.nextInt();
            if (n==0) break;
            Pair[] arr = new Pair[n];
            for (int i=0;i<n;i++) {
                arr[i] = new Pair(sc.nextInt(), i);
            }
            Arrays.sort(arr, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.a-o2.a;
                }
            });
            int[] arrB = new int[n];
            for (int i=0;i<n;i++) {
                arrB[i] = sc.nextInt();
            }
            Arrays.sort(arrB);
            for (int i=0;i<n;i++) {
                arr[i] = new Pair(arrB[i], arr[i].b);
            }
            Arrays.sort(arr);
            for (Pair p : arr) {
                System.out.println(p.a);
            }
            System.out.println();
        }

    }
}
