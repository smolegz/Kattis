import java.util.*;
import java.io.*;

public class rockband {
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
        int m = sc.nextInt();
        int s = sc.nextInt();
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        for (int i =0;i<m;i++) {
            grid.add(new ArrayList<>());
            for (int j=0;j<s;j++) {
                grid.get(i).add(sc.nextInt());
            }
        }
        int[] arr = new int[s];
        int k = 0;
        for (int i=0;i<s;i++) {
            for (int j=0;j<m;j++) {
                arr[grid.get(j).get(i)-1]++;
                if (arr[grid.get(j).get(i)-1] == m) {
                    k++;
                }
            }
            if (k==i+1) break;
        }
        int res[] = new int[k];
        for (int i = 0;i<k;i++) {
            res[i] = grid.get(0).get(i);
        }
        Arrays.sort(res);
        System.out.println(res.length);
        for (int r : res) {
            System.out.print(r+" ");
        }
    }
}
