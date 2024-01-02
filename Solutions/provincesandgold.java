import java.util.*;
import java.io.*;

public class provincesandgold {
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
        int gold = sc.nextInt();
        int sil = sc.nextInt();
        int cop = sc.nextInt();
        int t = gold*3+sil*2+cop;
        if(t >= 8) System.out.println("Province or Gold");
        else if(t >= 6)System.out.println("Duchy or Gold");
        else if(t >= 5) System.out.println("Duchy or Silver");
        else if(t >= 3) System.out.println("Estate or Silver");
        else if(t >= 2) System.out.println("Estate or Copper");
        else System.out.println("Copper");
    }
}
