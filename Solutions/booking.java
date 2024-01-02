import java.util.*;
import java.io.*;

public class booking {
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
        while (tc-- >0) {
            int n = sc.nextInt();
            int temp = n;
            int m = sc.nextInt();
            ArrayList<Integer> s = new ArrayList<>();
            ArrayList<Integer> e = new ArrayList<>();
            int[] date = new int[3];
            int[] time = new int[2];
            while (n-- > 0) {
                int[] month = new int[] {
                        0,44640,84960,129600,172800,217440,260640,305280,349920,393120,437760,480960
                };
                sc.next();
                String[] Sdate = sc.next().split("-");
                String[] Stime = sc.next().split(":");

                for (int i =0;i<3;i++) date[i] = Integer.parseInt(Sdate[i]);
                for (int i =0;i<2;i++) time[i] = Integer.parseInt(Stime[i]);
                int minutes = 0;
                minutes = (date[0]-2013)*525600 + month[date[1]-1] + date[2]*1440 + time[0]*60+ time[1];
                minutes += date[0] == 2016 && date[1] > 2 ? 1440 : 0;
                s.add(minutes);

                Sdate = sc.next().split("-");
                Stime = sc.next().split(":");
                for (int i =0;i<3;i++) date[i] = Integer.parseInt(Sdate[i]);
                for (int i =0;i<2;i++) time[i] = Integer.parseInt(Stime[i]);
                minutes = (date[0]-2013)*525600 + month[date[1]-1] + date[2]*1440 + time[0]*60+ time[1];
                minutes += date[0] == 2016 && date[1] > 2 ? 1440 : 0;
                e.add(minutes);
            }
            s.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            e.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1-o2;
                }
            });
            int r = 0;
            int k = 0;
            for (int i =0;i<temp;i++) {
                if (s.get(i) - e.get(k) < +m) {
                    r++;
                } else {
                    k++;
                }
            }
            System.out.println(r);
            //https://blog.csdn.net/wang_123_zy/article/details/79323417
        }
    }
}
