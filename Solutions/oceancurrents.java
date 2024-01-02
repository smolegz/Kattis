import java.io.*;
import java.util.*;

public class oceancurrents {
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
    public static class Pair {
        int r;
        int c;

        Pair(int t, int s) {
            this.r = t;
            this.c = s;
        }

    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] grid = new int[r][c];
        for (int i =0;i<r;i++) {
            String s = sc.next();
            for (int j = 0; j<c;j++) {
                grid[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        int tc = sc.nextInt();
        Deque<Pair> deq = new ArrayDeque<>();
        ArrayList<Pair> ls = new ArrayList<>();
        ls.add(new Pair(-1,0));
        ls.add(new Pair(-1,1));
        ls.add(new Pair(0,1));
        ls.add(new Pair(1,1));
        ls.add(new Pair(1,0));
        ls.add(new Pair(1,-1));
        ls.add(new Pair(0,-1));
        ls.add(new Pair(-1,-1));

        while (tc-- > 0) {
            int[][] dist = new int[r][c];
            for (int i = 0; i<r ;i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            int rs = sc.nextInt()-1;
            int cs = sc.nextInt()-1;

            int rd = sc.nextInt()-1;
            int cd = sc.nextInt()-1;
            deq.add(new Pair(rs,cs));
            dist[rs][cs] = 0;
            while(!deq.isEmpty()) {

                Pair p = deq.pop();
                int a = p.r;
                int b = p.c;
                for (Pair d : ls) {
                    int x = a + d.r;
                    int y = b + d.c;
                    if (x <0 || x >= c || y <0 || y>=c) {
                        continue;
                    } else {
                        int dir = grid[a][b];
//                        System.out.println(dir);
                        int w = ls.get(dir) == d ? 0:1;

                        if (dist[x][y] > dist[a][b] + w) {
                            dist[x][y] = dist[a][b] + w;
                            if (w == 0) {
                                deq.addFirst(new Pair(x,y));
                            } else {
                                deq.addLast(new Pair(x,y));
                            }
                        }
                    }
                }
            }
            System.out.println(dist[rd][cd]);
        }

    }
}
