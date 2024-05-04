import java.util.*;
import java.io.*;

public class compromise {
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
        int tc = sc.nextInt();
        while (tc-- >0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0;i<n;i++) {
                String s = sc.next();
                for (int j=0;j<m;j++) {
                    arr[i][j] = Character.getNumericValue(s.charAt(j));
                }
            }
            int[] a = new int[m];
            for (int i =0;i<m;i++) {
                int yes = 0;
                int maj = n%2==0 ? n/2 : n/2+1;
                for (int j = 0;j<n;j++) {
                    if (arr[j][i] == 1) yes++;
                    if (yes == maj) {
                        a[i] = 1;
                        break;
                    }
                }
                if (a[i] == 1) continue;
                a[i] = 0;
            }
            for (int i : a) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
