import java.io.*;
import java.util.*;

public class kattissquest {


    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, PriorityQueue<Integer>> tr = new TreeMap<>();
        while (n-- > 0) {
            String[] line = br.readLine().split(" ");
            if (line[0].equals("add")) {
                int energy = Integer.parseInt(line[1]);
                int gold = Integer.parseInt(line[2]);
                if (tr.containsKey(energy)) {
                    tr.get(energy).add(-gold);
                } else {
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.add(-gold);
                    tr.put(energy, pq);
                }
            } else {
                long coin = 0;
                int energy = Integer.parseInt(line[1]);
                while (tr.floorKey(energy) != null) {
                    int k = tr.floorKey(energy);
                    coin += -tr.get(k).poll();
                    if (tr.get(k).isEmpty()) {
                        tr.remove(k);
                    }
                    energy -= k;
                }
                writer.println(coin);
            }
        }
        writer.flush();
    }
}
