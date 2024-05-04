import java.util.*;
import java.io.*;

public class candydivision {

    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        long n = Long.parseLong(br.readLine());
        TreeMap<Long,Long> tr = new TreeMap<>();
        long k = (long) Math.floor(Math.sqrt(n));
        while (k > 0) {
            if ((double) n/k == Math.floor( (double) n/k)) {
                //writer.println(n/k);
                tr.put(n/k, n/k);
                tr.put(k, k);
            }
            k--;
        }
        while (!tr.isEmpty()) {
            writer.print((long) tr.firstKey() -1 + "  ");
            tr.pollFirstEntry();
        }
        writer.flush();
    }
}
