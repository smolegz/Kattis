import java.util.*;
import java.io.*;
import java.util.function.BiConsumer;

public class nicknames {
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

        HashMap<String, Integer> map = new HashMap<>(1000000);
        int n = sc.nextInt();
        while (n-- > 0) {
            String s = sc.next();
            String input = "";
            for (int i = 0; i < s.length(); i++) {
                input += s.charAt(i);
                //writer.println(input);
                if (map.containsKey(input)) {
                    int k = map.get(input);
                    map.replace(input, k+1);
                } else {
                    map.put(input, 1);
                }
            }
        }
        int k = sc.nextInt();
        while (k-- >0) {
            String s = sc.next();
            if (!map.containsKey(s)) {
                writer.println(0);
                continue;
            }
            writer.println(map.get(s));
        }



        writer.flush();
    }
}
