import java.util.*;
import java.io.*;

public class cetvrta {
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
        int x1 = sc.nextInt(), y1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt(), x3 = sc.nextInt(), y3 = sc.nextInt();
        int x4, y4;
        if(x1==x2)x4=x3;
        else if(x2==x3)x4=x1;
        else if(x1==x3)x4=x2;
        else x4 = x1;
        if(y1==y2)y4=y3;
        else if(y2==y3)y4=y1;
        else if(y1==y3)y4=y2;
        else y4 = y1;
        System.out.println(x4+" "+y4);
    }
}
