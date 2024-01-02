import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;

public class coursescheduling {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        TreeMap<String, TreeSet<String>> tr = new TreeMap<>();
        while (n-- > 0) {
            String[] line = br.readLine().split(" ");
            String name = line[0] + " " + line[1];
            String course = line[2];
            if (tr.containsKey(course)) {
                tr.get(course).add(name);
            } else {
                TreeSet<String> tr2 = new TreeSet<>();
                tr2.add(name);
                tr.put(course, tr2);
            }
        }
        tr.forEach(new BiConsumer<String, TreeSet<String>>() {
            @Override
            public void accept(String s, TreeSet<String> strings) {
                writer.println(s+ " " + strings.size());
            }
        });

        writer.flush();
    }

}
