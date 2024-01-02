import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class gearchanging {

    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int m = Integer.parseInt(in[1]);
        int p = Integer.parseInt(in[2]);

        String[] nl = br.readLine().split(" ");
        String[] ml = br.readLine().split(" ");
        int[] nll = new int[n];
        int[] mll = new int[m];
        for (int i = 0; i < n; i++) {
            nll[i] = Integer.parseInt(nl[i]);
        }
        for (int i = 0; i < m; i++) {
            mll[i] = Integer.parseInt(ml[i]);
        }

        List<Float> f = new ArrayList<>();

        for (int i = 0; i < nll.length; i++) {
            for (int j = 0; j < mll.length; j++) {
                f.add((float)nll[i]/mll[j]);
            }
        }
        for (int i = 0; i<f.size();i++) {
            if (f.get(i) - 1 > p/100.0) {
                System.out.println("Time to change gears!");
                return;
            }
        }
        System.out.println("Ride on!");
    }
}
