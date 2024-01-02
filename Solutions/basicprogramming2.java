
import java.util.*;
import java.io.*;

public class basicprogramming2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        String[] in = br.readLine().split(" ");
        List<Long> A = new ArrayList<>();
        String[] ls = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        for (int i = 0; i < N; i++) {
            A.add(Long.parseLong(ls[i]));
        }
        int t = Integer.parseInt(in[1]);
        Collections.sort(A);
        List<Long> b = new ArrayList<>();

        if (t == 1) {
            boolean boo = true;
            int i = 0;
            int j = N-1;
            while (boo) {
                if (i>=j) {
                    writer.println("No");
                    writer.flush();
                    break;
                }
                long sum = A.get(i) + A.get(j);
                if (sum == 7777) {
                    writer.print("Yes");
                    writer.flush();
                    break;
                }
                if (sum > 7777) {
                    j--;
                }
                if (sum < 7777) {
                    i++;
                }
            }
        }

        if (t==2) {
            for (int i = 0; i < N; i++) {
                if (!b.contains(A.get(i))) {
                    b.add(A.get(i));
                } else {
                    break;
                }
            }
            if (A.size() == b.size()) {
                System.out.println("Unique");
            } else {
                System.out.println("Contains duplicate");
            }
        }

        if (t==3) {

            if (Collections.frequency(A, A.get(0)) > N/2) {
                System.out.println(A.get(0));
                return;
            }
            if (Collections.frequency(A, A.get(N-1)) > N/2) {
                System.out.println(A.get(N-1));
                return;
            }
            System.out.println(-1);
        }

        if (t==4) {
            if (N%2 == 0) {
                int k = N/2;
                System.out.println(A.get(k-1) + " " + A.get(k));
            } else {
                int k = N/2;
                System.out.println(A.get(k));
            }
        }

        if (t==5) {

            for (long i : A) {
                if (i < 100) {
                    continue;
                }
                if (i > 999) {
                    break;
                }
                writer.print(i+ " ");
            }
            writer.flush();

        }

    }
}
