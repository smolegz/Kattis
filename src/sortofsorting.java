import java.util.*;
import java.io.*; // needed for BufferedReader

public class sortofsorting {
    public static void main(String[] args) throws Exception { // due to possible IOException
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0)
                break;

            // Arrays.sort version
            String[] names = new String[n]; // a Java String is an object
            for (int i = 0; i < n; ++i)
                names[i] = br.readLine();

            // this happens to be a stable sort as a String is not a primitive
            Arrays.sort(names, new Comparator<String>() {
                public int compare(String s1, String s2) {
                    return s1.substring(0, 2).compareTo(s2.substring(0, 2));
                }
            });

            for (int i = 0; i < n; ++i)
                pw.println(names[i]);
            pw.println();

        }

        pw.flush(); // close the buffer at the end
    }
}