import java.io.*;
import java.util.*;

public class stockprices {
    public static class Pair implements Comparable<Pair> {
        int price;
        int count;

        Pair(int p, int c) {
            this.price = p;
            this.count = c;
        }
        @Override
        public int compareTo(Pair o) {
            if (this.price == o.price) {
                return o.count - this.count;
            } else {
                return this.price - o.price;
            }
        }

    }
    public static void main(String[] arg) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int price = 0;
            PriorityQueue<Pair> BPQ = new PriorityQueue<>();
            PriorityQueue<Pair> SPQ = new PriorityQueue<>();
            while (n-- > 0) {
                String[] order = br.readLine().split(" ");
                String type = order[0];
                int shares = Integer.parseInt(order[1]);
                int pri = Integer.parseInt(order[4]);
                if (type.equals("buy")) {
                    BPQ.add(new Pair(-pri, shares));
                } else {
                    SPQ.add(new Pair(pri, shares));
                }
                while (true) {
                    int bid = BPQ.peek() == null ? -1 : -BPQ.peek().price; //buyer
                    int ask = SPQ.peek() == null ? -1 : SPQ.peek().price; //seller
                    if (bid != -1 && ask != -1 && bid >= ask) {
                        price = ask;
                        Pair b = BPQ.poll();
                        Pair s = SPQ.poll();
                        int delta = b.count - s.count;
                        if (delta > 0) {
                            BPQ.add(new Pair(b.price, delta));
                        } else if (delta < 0){
                            SPQ.add(new Pair(s.price, -delta));
                        } else {

                        }
                    } else {
                        break;
                    }
                }
                writer.print(SPQ.peek() == null ? "- " : SPQ.peek().price + " ");
                writer.print(BPQ.peek() == null ? "- " : -BPQ.peek().price +" ");
                writer.print(price == 0 ? "-" : price);
                writer.println();
            }
            writer.flush();
        }
    }
}
