import java.util.*;
import java.io.*;

public class classfieldtrip {
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
        String[] a = sc.next().split("");
        String[] b = sc.next().split("");
        ArrayList<String> arr = new ArrayList<>();
        for (int i =0;i<a.length;i++) {
            arr.add(a[i]);
        }
        for (int i =0;i<b.length;i++) {
            arr.add(b[i]);
        }
        arr.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for (String s : arr) {
            System.out.print(s);
        }
    }
}
