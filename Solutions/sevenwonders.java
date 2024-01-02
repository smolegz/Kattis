import java.util.*;
import java.io.*;

public class sevenwonders {
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
        String s = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('T',0);
        map.put('G',0);
        map.put('C',0);
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c,1);
            } else {
                int n = map.get(c);
                map.put(c,n+1);

            }
        }
        int sum = (int) (Math.pow(map.get('T'),2) + Math.pow(map.get('G'),2) + Math.pow(map.get('C'),2));
        int m = Math.min(map.get('T'), Math.min(map.get('G'), map.get('C')));
        sum += m*7;
        System.out.println(sum);
    }
}
