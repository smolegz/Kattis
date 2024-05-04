import java.util.*;
import java.io.*;

public class teque {
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
        int n = sc.nextInt();
        HashMap<Integer, Integer>  mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
        int as = -1;
        int ae =0;
        int bs = -1;
        int be = 0;
        while (n-- > 0) {
            String s = sc.next();
            int i = sc.nextInt();
            if (s.equals("push_front")) {
                mapA.put(as, i);
                as--;
            }
            if (s.equals("push_back")) {
                mapB.put(be, i);
                be++;
            }
            if (s.equals("push_middle")) {
                mapA.put(ae, i);
                ae++;
            }
            if (s.equals("get")) {
                if (i < mapA.size()) {
                    //get from A
                    writer.println(mapA.get(as + 1 + i));
                } else {
                    //get from B
                    writer.println(mapB.get(bs + 1 + (i-mapA.size())));
                }
            }

            if (mapB.size() > mapA.size()) {
                mapA.put(ae, mapB.get(bs+1));
                ae++;
                mapB.remove(bs+1);
                bs++;
            }
            if (mapA.size() - 1>mapB.size()) {
                mapB.put(bs, mapA.get(ae-1));
                bs--;
                mapA.remove(ae-1);
                ae--;
            }
        }
        writer.flush();

    }
}


