import java.util.*;
import java.io.*;

public class jollyjumpers {
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
        FastScanner sc = new FastScanner();
        try {
            while (true) {
                int n = sc.nextInt();
                boolean[] vis = new boolean[n];
                Arrays.fill(vis,false);
                vis[0] = true;
                int[] arr = sc.readArray(n);
                boolean isJolly = true;
                for (int i = 1; i < n;i++) {
                    int j = arr[i-1];
                    int m = arr[i];
                    int d = j-m < 0 ? m-j : j-m;
                    if (d > n-1) {
                        isJolly=false;
                        break;
                    }
                    //System.out.print(d + " ");
                    if (vis[d] == false) {
                        vis[d] = true;
                    } else {
                        isJolly = false;
                        break;
                    }
                }
                System.out.println(isJolly ? "Jolly" : "Not jolly");
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }

}
