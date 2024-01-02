import java.util.*;
import java.io.*;

public class countthevowels {
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
        ArrayList<Character> ls = new ArrayList<>();
        ls.add('a');
        ls.add('e');
        ls.add('i');
        ls.add('o');
        ls.add('u');
        String s = sc.br.readLine().toLowerCase();
        //System.out.println(s);
        int r = 0;
        for (int i =0;i<s.length();i++) {
            if (ls.contains(s.charAt(i))) {
                r++;
            }
        }
        System.out.println(r);
    }
}
