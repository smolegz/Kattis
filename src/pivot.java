import java.util.*;
import java.io.*;

public class pivot {
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
        int[] arr = sc.readArray(n);
        int[] copy = arr.clone();
        Arrays.sort(copy);
        for( int i = 0; i < arr.length/2; ++i )
        {
            int temp = copy[i];
            copy[i] = copy[copy.length - i - 1];
            copy[copy.length - i - 1] = temp;
        }
        if (Arrays.equals(arr,copy)) {
            System.out.println(0);
            System.exit(0);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> c = new PriorityQueue<>();
        for (int j=0;j<arr.length;j++) {
            int i = arr[j];
            if (j==arr.length-1 && pq.isEmpty()) {
                if (i > -c.peek()){
                    pq.add(-i);
                }
                break;
            }
            if (pq.isEmpty() && c.isEmpty()) {
                pq.add(-i);
                c.add(-i);
                continue;
            }
            if (pq.isEmpty()) {
                if (i > -c.peek()) pq.add(-i);
                c.add(-i);
            }
            while(!pq.isEmpty() && i < -pq.peek()) {
                pq.poll();
            }
            if (i > -c.peek()) {
                pq.add(-i);
                c.add(-i);
            } else {
                c.add(-i);
            }
        }

        System.out.println(pq.size());

    }
}