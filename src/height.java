import java.io.*;
import java.util.*;


public class height {
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
        PrintWriter writer = new PrintWriter(System.out);
        while (n-- > 0) {
            int k = sc.nextInt();
            int[] arr = sc.readArray(20);
            ArrayList<Integer> out = new ArrayList<>();
            int counter = 0;
            int total = 0;
            for (int i: arr) {
               out.add(i);
               out.sort(new Comparator<Integer>() {
                   @Override
                   public int compare(Integer o1, Integer o2) {
                       return o1 - o2;
                   }
               });
               int newIndex = out.indexOf(i);
               if (counter - newIndex > 0) {
                    total+= counter - newIndex;
               }
               counter++;
            }
            writer.println(k + " " + total);
        }
        writer.flush();
    }
}
