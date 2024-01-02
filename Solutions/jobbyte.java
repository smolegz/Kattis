import java.util.*;
import java.io.*;

public class jobbyte {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] a = br.readLine().split(" ");
        int[] b = new int[n];

        int count = 0;

        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(a[i]);
        }

        for (int i = 0 ; i < n; i++) {
            int k = b[i];
            if (i + 1 == k) {
                continue;
            } else {
                int index = k - 1;
                int temp = b[index];
                b[index] = k;
                b[i] = temp;
                i--;
                count++;
            }
        }

        System.out.print(count);
        System.out.println(Arrays.toString(b));

    }
}
