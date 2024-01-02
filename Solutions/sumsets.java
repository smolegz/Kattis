import java.io.*;
import java.util.*;

public class sumsets {
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
    public static class Triple {
        int a;
        int b;
        int c;

        Triple(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

//        public int compareTo(subarrays.Pair o) {
//            if (this.a == o.a) {
//                return this.b - o.b;
//            } else {
//                return this.a - o.a;
//            }
//        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <n; i++) {
            int k = sc.nextInt();
            arr[i] = k;
            set.add(k);
        }
        Arrays.sort(arr);
        int count = 0;
        HashMap<Integer, Triple> map = new HashMap<>();
        for (int i = 0; i < n-1;i++) {
            for (int j = i + 1;j <n; j++) {
                map.put(count, new Triple(arr[i]+arr[j], i, j));
                count++;
            }
        }
        int max = Integer.MIN_VALUE;
        ArrayList<Triple> arr2 = new ArrayList<>();

        for (int i = 0; i <count; i++) {
            Triple t = map.get(i);
            int sum = t.a;
            if (sum >= arr[n-1]) {
                break;
            }
            arr2.add(t);
        }

        for (int i = arr2.size()-1; i >= 0; i--) {
            Triple t = arr2.get(i);
            int sum = t.a;
            int f = t.b;
            int s = t.c;
            for (int j = s+1; j < n; j++) {
                if (arr[j] == arr[f] || arr[j] == arr[s]) {
                    continue;
                } else {
                    int p = sum + arr[j];

                    if (p > arr[n-1]) {
                        continue;
                    }
                    if (p == arr[j] || p == arr[f] || p == arr[s]) {
                        continue;
                    }
                    if (set.contains(p)) {
                        if (p >= max) {
                            max = p;
                        }
                    }
                }
            }

        }
        System.out.println(max == Integer.MIN_VALUE ? "no solution" : max);
    }
}
