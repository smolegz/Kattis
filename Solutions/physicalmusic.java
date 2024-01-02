import java.util.*;
import java.io.*;

public class physicalmusic {
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
        while (tc-- >0) {
            int n = sc.nextInt();
            int t = Integer.MAX_VALUE;
            ArrayList<Integer> arr = new ArrayList<>();
            ArrayList<Integer> r = new ArrayList<>();
            while (n-- > 0) {
                arr.add(sc.nextInt());
            }
            for (int i =arr.size()-1;i>=0;i--) {
                if (arr.get(i) > t) {
                    r.add(arr.get(i));
                }
                t = Math.min(t,arr.get(i));
            }
            r.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            System.out.println(r.size());
            for (int i : r) {
                System.out.println(i);
            }
        }
    }
}
