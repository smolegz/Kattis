import java.util.*;
import java.io.*;

public class prjonamynstur {
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
        int m = sc.nextInt();
        int sum = 0;
        for (int i=0;i<n;i++) {
            String s = sc.next();
            for (int j=0;j<m;j++) {
                char c = s.charAt(j);
                switch (c) {
                    case '.':
                       sum+=20;
                       break;
                    case 'O':
                        sum +=10;
                        break;
                    case '\\':
                        sum +=25;
                        break;
                    case '/':
                        sum +=25;
                        break;
                    case 'A':
                        sum +=35;
                        break;
                    case '^':
                        sum +=5;
                        break;
                    case 'v':
                        sum +=22;
                        break;
                }
            }
        }
        System.out.println(sum);
    }
}
