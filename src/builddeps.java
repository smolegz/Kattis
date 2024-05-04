import java.io.*;
import java.util.*;

public class builddeps {
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
    public static HashMap<String, Boolean> visited;
    public static HashMap<String, ArrayList<String>> AL;
    public static ArrayList<String> topo;

    public static void dfs(String u) {

        visited.put(u, true);
        if (AL.get(u) != null) {
            for (String v: AL.get(u)) {
                //System.out.println(v + " in " + u);
                if (!visited.get(v)) {
                    dfs(v);
                }
            }
        }
        topo.add(u);
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        visited= new HashMap<>();
        AL = new HashMap<>();
        while (n-- > 0) {
            String[] line = sc.br.readLine().split(" ");
            String a = line[0];
            a = a.substring(0, a.length()- 1);
            visited.put(a, false);

            for (int i = 1; i <line.length; i++) {
                String file = line[i];
                if (AL.get(file) == null) {
                    ArrayList<String> ff = new ArrayList<>();
                    ff.add(a);
                    AL.put(file, ff);
                } else {
                    AL.get(file).add(a);

                }
            }

        }
        //System.out.println(AL.get("set").size());
        String source = sc.next();
        topo = new ArrayList<>();
        dfs(source);

        for (int i = topo.size() - 1; i >= 0;i--) {
            System.out.println(topo.get(i));
        }
    }

}
