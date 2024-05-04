import java.util.*;
import java.io.*;

public class pokechat {
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
        String[] arr = sc.br.readLine().split("");
        String a = sc.next();
        int k = a.length()/3;
        String r = "";
        for (int i =0;i<k;i++) {
            String s ="";
             for (int j=0;j<3;j++) {
                 s += a.charAt(i*3+j);
             }
             r += arr[Integer.parseInt(s)-1];
        }
        System.out.println(r);
    }
}
