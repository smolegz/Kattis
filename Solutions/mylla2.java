import java.util.*;
import java.io.*;

public class mylla2 {
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

    public static void result() {
        System.out.println("Jebb");
        System.exit(0);
    }
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        char[][] arr = new char[3][3];
        for (int i=0;i<3;i++) {
            String s = sc.next();
            for (int j=0;j<3;j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        if (arr[0][0] == 'O') {
            if (arr[1][0] == 'O' && arr[2][0] =='O') {
                result();
            }
        }
        if (arr[0][1] == 'O') {
            if (arr[0][0] == 'O' && arr[0][2] =='O') {
                result();
            }
            if (arr[1][1] == 'O' && arr[2][1] =='O') {
                result();
            }

        }
        if (arr[0][2] == 'O') {
            if (arr[1][2] == 'O' && arr[2][2] =='O') {
                result();
            }
        }

        if (arr[2][1] == 'O') {
            if (arr[2][0] == 'O' && arr[2][2] =='O') {
                result();
            }
        }

        if (arr[1][1] == 'O') {
            if (arr[1][0] == 'O' && arr[1][2] =='O') {
                result();
            }
            if (arr[0][0] == 'O' && arr[2][2] =='O') {
                result();
            }
            if (arr[0][2] == 'O' && arr[2][0] =='O') {
                result();
            }
            if (arr[0][1] == 'O' && arr[2][1] =='O') {
                result();
            }
        }

        System.out.println("Neibb");
    }
}
