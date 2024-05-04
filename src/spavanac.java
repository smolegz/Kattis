import java.sql.Time;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;
import java.io.*;

public class spavanac {
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
        LocalTime time = LocalTime.of(sc.nextInt(),sc.nextInt());
        time=time.minusMinutes(45);
        System.out.println(time.getHour()+" "+time.getMinute());


    }
}
