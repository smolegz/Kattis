import java.util.*;
import java.io.*;

public class doctorkattis {

    public static class Pair {
        int inf;
        int id;
        String name;

        Pair(int a, int b, String s) {
            this.inf = a;
            this.id = b;
            this.name = s;
        }

    }
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
        FastScanner br = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);
        int n = br.nextInt();
        TreeMap<Integer, TreeMap<Integer,Pair>> tr = new TreeMap<>(); //store name,index
        HashMap<String, Pair> map = new HashMap<>(500000, 0.9F); //String, infection level
        //List<String> arr = new ArrayList<>();
        int count = 0;
        while (n-- > 0) {
//            String[] q = br.next();
            int type = br.nextInt();

            if (type == 0) {
                String name = br.next();
                int i = br.nextInt();
                map.put(name, new Pair(i, count, name));
                if (tr.containsKey(i)) {
                    tr.get(i).put(count, new Pair(i, count, name));
                } else {
                    TreeMap<Integer, Pair> t = new TreeMap<>();
                    t.put(count, new Pair(i, count, name));
                    tr.put(i, t);
                }
                count++;
            }
            if (type == 1) {
                String name = br.next();
                int i = br.nextInt();
                Pair p = map.get(name);
                tr.get(p.inf).remove(p.id);
                if (tr.get(p.inf).isEmpty()) {
                    tr.remove(p.inf);
                }
                if (!tr.containsKey(p.inf+i)) {
                    TreeMap<Integer, Pair> t = new TreeMap<>();
                    t.put(p.id, new Pair(p.inf+i, p.id, p.name));
                    tr.put(p.inf+i, t);
                } else {
                    tr.get(p.inf+i).put(p.id, new Pair(p.inf+i, p.id, p.name));
                }
                map.replace(name, new Pair(p.inf+i, p.id, p.name));
            }
            if (type == 2) {
                String name = br.next();
                Pair p = map.get(name);
                tr.get(p.inf).get(p.id).name = "removed";
//                if (tr.get(p.inf).isEmpty()) {
//                    tr.remove(p.inf);
//                }
                //map.remove(name);
            }
            if (type == 3) {
                int j = tr.lastKey();
                int k;
                boolean found = false;
                while (j != -1) {
                    TreeMap<Integer, Pair> t = tr.get(j);
                    k = t.firstKey();
                    while (k != -1) {
                        if (t.get(k).name.equals("removed")) {
                            k = t.higherKey(k) == null ? -1 : t.higherKey(k);
                        } else {
                            writer.println(t.get(k).name);
                            found = true;
                            j = -1;
                            break;
                        }
                    }
                    if (j == -1) break;
                    j = tr.lowerKey(j) == null ? -1 : tr.lowerKey(j);
                }
                if (!found) {
                    writer.println("The clinic is empty");
                }
            }
        }
        writer.flush();
    }
}