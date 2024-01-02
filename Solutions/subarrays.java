import java.util.*;
import java.io.*;

public class subarrays {
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
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair o) {
            if (this.a == o.a) {
                return this.b - o.b;
            } else {
                return this.a - o.a;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int k = sc.nextInt();
        long b = sc.nextLong();
        HashMap<Integer, Long> map = new HashMap<>(20000);
        map.put(-1, 0L);
        boolean allNegative = true;
        boolean allPositive = true;

        int[] arr = new int[n];

        long prev = map.get(-1);
        for (int i = 0; i <n; i++) {
            int a = sc.nextInt() - k;
            if (a > 0) {
                allNegative = false;
            }
            if (a < 0) {
                allPositive = false;
            }
            arr[i] = a;
            long temp = prev + a;
            map.put(i, temp);
            if (temp == b && allNegative) {
                System.out.println("0" + " " + i);
                System.exit(0);
            }
            prev = temp;
        }

        if (allPositive) {
            long sum = arr[0];
            int L = 0;
            int R = 0;
            while (L <= R && R < n) {
                if (sum < b) {
                    R++;
                    if (R < n) {
                        sum += arr[R];
                    } else {
                        break;
                    }
                } else if (sum > b) {
                    sum -= arr[L];
                    L++;
                } else {
                    System.out.println(L + " " + R);
                    System.exit(0);
                }
            }
            System.out.println(-1);
            System.exit(0);
        }

        for (int i = -1; i < n; i++) {
            long r = map.get(i) + b;
            boolean run = true;
            if (map.containsValue(r)) {
                for (int j = i; j < n; j++) {
                    if (map.get(j) == r) {
                        System.out.println(i+1 +" " + j);
                        System.exit(0);
                    }
                }
                run = false;
            }
            if (!run) {
                break;
            }

        }
        System.out.println(-1);

    }
}
