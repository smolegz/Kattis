import java.util.*;
import java.io.*;

public class bokforing {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int q = Integer.parseInt(in[1]);
        PrintWriter writer = new PrintWriter(System.out);
        int def = 0;
        HashMap<Integer, Integer> m = new HashMap<>(20000);

        while (q-- >0) {
            String[] line = br.readLine().split(" ");
            if (line[0].equals("SET")) m.put(Integer.parseInt(line[1])-1 , Integer.parseInt(line[2]));
            if (line[0].equals("PRINT")) writer.println(m.getOrDefault(Integer.parseInt(line[1])-1, def));
            if (line[0].equals("RESTART")) {
                m = new HashMap<>(20000);
                def = Integer.parseInt(line[1]);
            }
        }
        writer.flush();
    }
}
