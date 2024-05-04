import java.util.*;
import java.io.*;

public class annoyedcoworkers {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int h = Integer.parseInt(in[0]);
        long c = Long.parseLong(in[1]);
        long k = c;
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        while (c-->0) {
            String[] line = br.readLine().split(" ");
            pq.add(new Pair(Long.parseLong(line[0]) + Long.parseLong(line[1]),
                    Long.parseLong(line[1])));
        }

        while(h-->0) {
            Pair p = pq.poll();
            pq.add(new Pair(p.fst + p.snd, p.snd));
        }
        long max = 0L;
        while (k-- >0){
            Pair p = pq.poll();
            if (p.fst - p.snd > max) {
                max = p.fst - p.snd;
            }
        }

        System.out.println(max);
    }
}

class Pair implements Comparable<Pair> {
    Long fst, snd;
    Pair (Long fst,Long snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public int compareTo(Pair o) {
        int res = Long.compare(this.fst, o.fst);
        return res != 0 ? res : Long.compare(this.snd, o.snd);
    }
}