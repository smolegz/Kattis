import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;

public class managingpackaging {
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
    public static class Pair implements Comparable<Pair> {
        int a;
        String b;


        Pair(int a, String b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair o) {
            return this.b.compareTo(o.b);
        }
    }
    public static void main(String[] arg) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter writer = new PrintWriter(System.out);

        while (true) {
            int n = sc.nextInt();

            if (n==0) break;
            HashMap<String, ArrayList<String>> adj = new HashMap<>();
            HashMap<String, Integer> map = new HashMap<>();
            PriorityQueue<String> pq = new PriorityQueue<>();
            int count = 0;
            ArrayList<String> temp = new ArrayList<>();
            int[] indegree = new int[n];
            while (n-- >0) {
                String[] line = sc.br.readLine().split(" ");
                map.put(line[0],count);
                if (line.length == 1) pq.add(line[0]);
                indegree[count] = line.length -1;

                for (int i=1; i<line.length; i++) {
                    if (adj.containsKey(line[i])) {
                        adj.get(line[i]).add(line[0]);
                    } else {
                        ArrayList<String> ls = new ArrayList<>();
                        ls.add(line[0]);
                        adj.put(line[i], ls);
                    }
                }
                count++;
            }

            ArrayList<String> res = new ArrayList<>();


            while(!pq.isEmpty()) {
                String str = pq.poll();
                if (adj.get(str)==null) {res.add(str); continue;}
//                adj.get(str).sort(new Comparator<String>() {
//                    @Override
//                    public int compare(String o1, String o2) {
//                        return o1.compareTo(o2);
//                    }
//                });
                for (String s: adj.get(str)) {
                    int index = map.get(s);
                    indegree[index]--;
                    if (indegree[index] == 0) {
                        pq.add(s);
                    }

                }
                res.add(str);
            }
            if (res.size() != indegree.length) {
                writer.println("cannot be ordered");
                writer.println();
                continue;
            }
            for(String d : res) {
                writer.println(d);
            }
            writer.println();
        }
        writer.flush();
    }

}
