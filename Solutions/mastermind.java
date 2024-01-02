import java.util.*;
import java.io.*;

public class mastermind {
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

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        String[] a = sc.next().split("");
        String[] b = sc.next().split("");
        ArrayList<String> arr = new ArrayList<>();

       int r=0; int s =0;
       for (int i =0;i<n;i++) {
           if (a[i].equals(b[i])) {
               a[i]= "";
               r++;
               b[i] = "";
           }
       }
        for (int i=0;i<n;i++) {
            if (a[i].equals("")) { continue;}
            arr.add(a[i]);
        }
       for (int i =0;i<n;i++) {
           if (b[i].equals("")) continue;
           if (arr.lastIndexOf(b[i]) != -1) {
               s++;
               arr.remove( arr.lastIndexOf(b[i]));
           }
       }
       System.out.print(r+" "+s);
    }
}
