import java.io.*;
import java.util.*;

public class bungeebuilder {
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

    public static void main(String[] arg) throws Exception {
        FastScanner br = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);
        int k = br.nextInt();
        String[] arr = br.br.readLine().split(" ");
        long[] line = new long[k];
        int l = 0;
        for (String s : arr) {
            line[l] = Long.parseLong(s);
            l++;
        }
        long minn = Long.MAX_VALUE;
        long maxx = 0;
        long best = 0;
        long j = 0;
        for (int i = 0; i < k; i++) {
            if (maxx == 0) {
                maxx = line[i];
            }

            if (minn == Long.MAX_VALUE) {
                minn = line[i];
                best = line[i];
                if (line[i] >= maxx) {
                    maxx = line[i];
                    minn = Long.MAX_VALUE;
                }
                continue;
            }
            if (line[i] < minn) {
                minn = line[i];
//                best = Math.max(best, minn);
            }
            if (line[i] >= maxx) {
                //System.out.println(line[i]);
                best = maxx;
                maxx = line[i];
                //System.out.println("Best:" + best);
                //System.out.println("Minn:" + minn);
                j = Math.max(best - minn,j);
                //System.out.println(j);
                minn = Long.MAX_VALUE;
                best = 0;
                continue;
            }
            //System.out.println(best);
            if (line[i] <= maxx ) {
                //System.out.println("Before:" + best);
                if (line[i] > minn) {
                    best = Math.max(best, line[i]);
                    //System.out.println("After:" + best);
                    j = Math.max(best - minn, j);
                } else {
                    continue;
                }
            }

            //System.out.println(j);
        }
        System.out.println(j <= 0 ? 0 : j);
    }
}
