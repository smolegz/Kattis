import java.util.*;
import java.io.*;

public class acm2 {
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
        int n = sc.nextInt();
        int i = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        while (n-- > 0) {
            arr.add(sc.nextInt());
        }

        int k = arr.remove(i);
        arr.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        arr.add(0,k);
        int ac = 0;
        int sum = 0;
        int r = 0;
        for (int j=0;j<arr.size();j++) {
            sum += arr.get(j);
            if (sum > 300) {
                break;
            }
            ac++;
            r += sum;
        }
        System.out.println(ac + " " + r);
    }
}
