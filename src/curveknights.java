import java.io.*;
import java.util.*;

public class curveknights {
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
        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }


        long nextLong() {
            return Long.parseLong(next());
        }
    }
    public static class Pair {
        int a;
        int w;

        Pair(int a, int w) {
            this.a = a;
            this.w = w;
        }
    }

    static ArrayList<ArrayList<Pair>> adj;


    public static void main(String[] arg) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int d = sc.nextInt();
        long[] arr = sc.readLongArray(n);

        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        while(d-- >0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(v).add(new Pair(u,w));
            indegree[u]++;
        }

        long[] result = arr.clone();
        for (int i = 0; i<n; i++){
            int[] degree = indegree.clone();
            //System.out.println(arr[i]);
            if (arr[i] == 0) {continue;}
            Queue<Integer> q = new LinkedList<>();
            ArrayList<ArrayList<Pair>> dupe = adj;
            for (int k = 0; k <n;k++) {
                if (indegree[k]==0) {
                    q.add(k);
                }
            }
            long quant = arr[i];
            long[] inter = new long[n];
            inter[i] = 1;
            while (!q.isEmpty()) {
                 int t = q.poll();
                 for (Pair p: dupe.get(t)) {
                     inter[p.a] += p.w * inter[t];
                     degree[p.a]--;
                     if (degree[p.a] == 0) q.add(p.a);
                 }
//                for (int j: inter) {
//                    System.out.print(j + " ");
//                }
//                System.out.println();
            }

            inter[i] = 0;
            for (int j = 0; j <n;j++) {
                result[j] += quant * inter[j];
            }
        }
        for (long i : result) {
            System.out.print(i + " ");
        }
    }

}
