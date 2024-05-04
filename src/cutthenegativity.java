import java.util.*;
import java.io.*;

public class cutthenegativity {
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
    public static class Triple {
        int a;
        int b;
        int c;

        Triple (int a,int b,int c) {
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        ArrayList<Triple> ls = new ArrayList<>();
        for (int i=1;i<n+1;i++) {
            for (int j=1;j<n+1;j++) {
                int k = sc.nextInt();
                if (k != -1) {
                    ls.add(new Triple(i,j,k));
                }
            }
        }
        System.out.println(ls.size());
        for (Triple t:ls) {
            System.out.println(t.a+" "+t.b+" "+t.c);
        }
    }
}
