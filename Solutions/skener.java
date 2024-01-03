import java.util.*;
import java.io.*;

public class skener {
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
        PrintWriter writer = new PrintWriter(System.out);
        int r = sc.nextInt();
        int c= sc.nextInt();
        int zr = sc.nextInt();
        int zc = sc.nextInt();
        char[][] arr = new char[r][c];
        for (int i=0;i<r;i++) {
            String s = sc.next();
            for (int j=0;j<c;j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        char[][] out = new char[r*zr][c*zc];
        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
                char cc = arr[i][j];
                for (int k=i*zr;k<i*zr+zr;k++) {
                    for (int l=j*zc;l<j*zc+zc;l++) {
                        //System.out.println(k+" "+l+ " "+cc);
                        out[k][l] = cc;
                    }
                }
            }
        }
        for (int i=0;i<out.length;i++) {
            for (int j=0;j<out[0].length;j++) {
                writer.print(out[i][j]);
            }
            writer.println();
        }
    }
}
