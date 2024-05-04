import java.util.*;
import java.io.*;

public class closingtheloop {
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
        int tc = sc.nextInt();
        int count = 1;
        while (tc-- > 0) {
            int seg = sc.nextInt();
            if (seg == 1) {
                System.out.println("Case #" + count + ": " + 0);
                count++;
                sc.next();
                continue;
            }
            PriorityQueue<Integer> r = new PriorityQueue<>();
            PriorityQueue<Integer> b = new PriorityQueue<>();
            while (seg-- >0) {
                String s = sc.next();
                if (s.charAt(s.length() - 1) == 'R') {
                    r.add(-Integer.parseInt(s.substring(0,s.length()-1)));
                } else {
                    b.add(-Integer.parseInt(s.substring(0,s.length()-1)));
                }
            }
            ArrayList<Integer> rope = new ArrayList<>();
            String isRed = r.size() < b.size() ? "r" : r.size() > b.size() ? "b" : "r";
            if (isRed.equals("r")) {
                while (!r.isEmpty()) {
                    rope.add(-r.poll());
                    rope.add(-b.poll());
                }
            } else {
                while (!b.isEmpty()) {
                    rope.add(-b.poll());
                    rope.add(-r.poll());
                }
            }
            int sum = 0;
            for (int i : rope) {
                //System.out.print(i+" ");
                sum+= i;
            }
            sum -= rope.size();
            System.out.println("Case #" + count + ": " + sum);
            count++;
        }
    }
}
