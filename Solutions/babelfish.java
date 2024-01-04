import java.util.*;
import java.io.*;

public class babelfish {
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
        HashMap<String, String> map = new HashMap<>();
        while (true) {
            String[] arr = sc.br.readLine().split(" ");
            if (arr[0].equals("")) {
                break;
            }
            map.put(arr[1],arr[0]);
        }
        while (true) {
            String s = sc.br.readLine();
            if (s.isEmpty()) break;
            if (map.containsKey(s)) {
                System.out.println(map.get(s));
            } else {
                System.out.println("eh");
            }
        }

    }
}
