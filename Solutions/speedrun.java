import java.util.*;
import java.io.*;

public class speedrun {

    static class Pair implements Comparable<Pair> {
        int fst, snd;
        Pair (int fst,int snd) {
            this.fst = fst;
            this.snd = snd;
        }

        public int compareTo(Pair o) {
            int res = Integer.compare(this.fst, o.fst);
            return res != 0 ? res : Integer.compare(this.snd, o.snd);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int g = Integer.parseInt(in[0]);
        int n = Integer.parseInt(in[1]);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int k = n;
        while (k-- > 0) {
            String[] line = br.readLine().split(" ");
            pq.add(new Pair(Integer.parseInt(line[1]), Integer.parseInt(line[0])));
        }
        int count = 0;
        int time = 0;

        while (n-- > 0) {
            Pair p = pq.poll();
            if (p.snd >= time) {
                time = p.fst;
                count++;
            }
        }
        System.out.println(count >= g ? "YES": "NO");
    }

}

