import java.util.*;
import java.io.*;
import java.util.function.BiConsumer;


public class racinggame {
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

    public static void main(String[] arg) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);
        int n = sc.nextInt();
        int count = 0;
        TreeMap<Integer, Integer> tr = new TreeMap<>();
        while (n-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();

            if (i == 1) {
                if (count < 10) {
                    if (tr.containsKey(j)) {
                        int k = tr.get(j);
                        tr.put(j, k + 1);
                        count++;
                    } else {
                        tr.put(j, 1);
                        count++;
                    }
                } else {
                    if (j < tr.lastKey()) {
                        if (tr.containsKey(j)) {
                            int k = tr.get(j);
                            tr.put(j, k + 1);
                        } else {
                            tr.put(j, 1);
                        }
                        int old = tr.get(tr.lastKey());
                        if (old == 1) {
                            tr.pollLastEntry();
                        } else {
                            tr.put(tr.lastKey(), old - 1);
                        }
                    }
                }
            }
            if (i == 2) {
                TreeMap<Integer, Integer> newTr = new TreeMap<>();
                int finalJ = j;
                tr.forEach(new BiConsumer<Integer, Integer>() {
                    @Override
                    public void accept(Integer integer, Integer integer2) {
                        newTr.put(integer + finalJ, integer2);
                    }
                });
                tr = newTr;
            }
            if (i == 3) {
                int first = tr.firstKey();
                while (j > 0) {
                    int v = tr.get(first);
                    if (v >= j) {
                        writer.println(first);
                        break;
                    } else {
                        j -= v;
                        first = tr.higherKey(first);
                    }
                }
            }


        }
        writer.flush();
    }
}
