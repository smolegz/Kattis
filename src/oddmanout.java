import java.util.*;
import java.io.*;

public class oddmanout {
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
        int tc = sc.nextInt();
        for (int i=1;i<=tc;i++) {
            int n = sc.nextInt();
            HashMap<Integer,Integer> map = new HashMap<>();
            while(n-->0) {
                int k =sc.nextInt();
                if (map.containsKey(k)) map.put(k,2);
                else map.put(k,1);
            }
            Set<Integer> s = map.keySet();
            Object[] arr = s.toArray();
            System.out.print("Case #"+i+": ");
            for (Object o:arr){
                if (map.get(o) == 1) System.out.print(o);
            }
            System.out.println();
        }
    }
}
