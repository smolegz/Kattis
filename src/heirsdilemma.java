import java.io.*;
import java.util.*;

public class heirsdilemma {
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
        int a = sc.nextInt();
        int b = sc.nextInt();
        int counter = 0;
        for (int i = a; i<=b; i++) {
            if (i%2 == 1) {
                continue;
            } else {
                //check if they are unique
                //check if they are divisible by each other
                boolean unique = true;
                String s = Integer.toString(i);
                HashMap<Character, Integer> map = new HashMap<>();
                for (int j = 0; j < 6; j++) {
                    if (!map.containsKey(s.charAt(j))) {
                        map.put(s.charAt(j), 1);
                    } else {
                        unique = false;
                        break;
                    }
                }
                if (!unique) {continue;}
                for (int j = 0;j <6;j++) {
                    int l = Character.getNumericValue(s.charAt(j));
                    if (l== 0 || i%l != 0) {
                        unique = false;
                        break;
                    }
                }
                if (!unique) {continue;}
                counter++;

            }
        }
        System.out.println(counter);
    }
}
