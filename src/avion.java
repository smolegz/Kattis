import java.util.*;
import java.io.*;

public class avion {
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
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i=1;i<=5;i++) {
            String s = sc.next();
            if (s.contains("FBI")) ls.add(i);
        }
        if (ls.isEmpty()) {
            System.out.println("HE GOT AWAY!");
            System.exit(0);
        }
        for (int k:ls) {
            System.out.print(k+" ");
        }
    }
}
