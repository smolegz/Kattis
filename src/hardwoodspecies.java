import java.io.*;
import java.util.*;

public class hardwoodspecies {

    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        TreeMap<String, Integer> tr =  new TreeMap<>();
        List<Integer> data = new ArrayList<>();
        int count = 0;
        while (true) {
            try {
                String tree = br.readLine();
                if (tree.isEmpty()) {
                    break;
                } else {
                    count++;
                    if (tr.containsKey(tree)) {
                        int t = tr.get(tree);
                        int k = data.get(t);
                        data.set(t,k+1);
                    } else {
                        tr.put(tree, tr.size());
                        data.add(1);
                    }
                }
            }
            catch (Exception e) {
                break;
            }
        }
        while(!tr.isEmpty()) {
            Map.Entry<String, Integer> e = tr.pollFirstEntry();
            int c = data.get(e.getValue());
            double f= (c / (double) count) * 100;
            writer.println(e.getKey() + " " + f);
        }
        writer.flush();
    }
}