import java.util.*;
import java.io.*;

public class inverteddeck {
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
    static void reverse(long[] a,int x,int y)
    {
        while(x<y)
        {
            long temp = a[x];
            a[x] = a[y];
            a[y] = temp;
            x++;
            y--;
        }
    }
    static void sortArr(long[] a, int n)
    {
        int x = -1;
        int y = -1;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] >= a[i + 1]) {
                if (x == -1) {
                    x = i;
                }
                y = i + 1;
            }
        }

        if (x != -1) {
            reverse(a,x,y);
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    System.out.println("impossible");
                    System.exit(0);
                }
            }
        }

        System.out.print(x== -1? "1 1": (x+1) +" " +(y+1));
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i =0;i<n;i++) {
            arr[i] = sc.nextLong();
        }
        sortArr(arr,n);
    }
}
