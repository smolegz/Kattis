import java.util.*;
import java.io.*;

public class fluortanten {
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
        ArrayList<Long> aa = new ArrayList<>(n);
        aa.add(0L);
        ArrayList<Long> base = new ArrayList<>(n-1);
        int temp = n;
        long[] bb = new long[n];
        bb[n-1] = 0;
        int count = 1;
        while (n-- > 0) {
            long k = sc.nextLong();
            if (k == 0) continue;
            base.add(k);
            aa.add(k*count+aa.get(count-1));
            count++;
        }
        for (int i = temp-2;i >= 0;i--) {
            bb[i] = bb[i+1] + base.get(i);
        }

        long res = Long.MIN_VALUE;
        for (int i =0;i<temp;i++) {
            res = Math.max(res, aa.get(i)+(aa.get(temp-1)-aa.get(i))+bb[i]);
            //System.out.print(res + " ");
        }
        System.out.println(res);
    }

}
