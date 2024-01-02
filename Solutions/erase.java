import java.util.*;
import java.io.*;

public class erase {
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
        boolean suc = true;
        String a = sc.next();
        String b = sc.next();

        for (int i =0;i < a.length();i++) {
            int x = Character.getNumericValue(a.charAt(i));
            int y =  Character.getNumericValue(b.charAt(i));
            int t =  n%2 == 0 ? x : (x == 1 ? 0 : 1);
            suc = t == y;
            if (!suc) {
                //System.out.println(i + " " + x + " "+ y + " " + t);
                System.out.println("Deletion failed");
                System.exit(0);
            }
        }
        System.out.println("Deletion succeeded");

    }

}
