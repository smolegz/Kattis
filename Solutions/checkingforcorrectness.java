import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class checkingforcorrectness {
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

        while (true) {
            try {
                String[] line = sc.br.readLine().split(" ");
                BigInteger a = new BigInteger(line[0]);
                BigInteger b = new BigInteger(line[2]);
                BigInteger c;
                if (line[1].equals("+")) {
                    c = a.add(b);
                } else if (line[1].equals("*")) {
                    c = a.multiply(b);
                } else {
                    c = a.modPow(b,new BigInteger("10000"));
                }
                String s = c.toString();
                if (line[1].equals("^")) {
                    System.out.println(s);
                    continue;
                }
                s = s.substring(s.length()-4, s.length());
                System.out.println(Long.parseLong(s));
            } catch (Exception e) {
                break;
            }
        }
    }
}
