import java.util.*;
import java.io.*;

public class kannafriendship {
    //adapted from Steven Halim github
    public static class Pair implements Comparable<Pair> {
        Integer _first, _second;

        public Pair(Integer f, Integer s) {
            _first = f;
            _second = s;
        }

        public int compareTo(Pair o) {
            if (!this.first().equals(o.first()))
                return this.first() - o.first();
            else
                return this.second() - o.second();
        }

        Integer first() { return _first; }
        Integer second() { return _second; }

        @Override
        public String toString() {
            return "[" + _first + ", " + _second + "]";
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        PrintWriter writer = new PrintWriter(System.out);
        int q = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[0]);
        Stack<Pair> s = new Stack<>();
        TreeMap<Integer, Pair> tr = new TreeMap<>();
        long counter = 0;
        while (q-- > 0) {
            String[] line = br.readLine().split(" ");
            if (line[0].equals("1")) {
                int a = Integer.parseInt(line[1]);
                int b = Integer.parseInt(line[2]);
                int first;
                int second = 0;
                int delta = b-a+1;
                boolean noLeft = false;
                boolean noRight = false;
                int pre = tr.lowerKey(a) == null ? 0 : tr.lowerKey(a);
                //writer.println("Size of interval: " + delta);
                if (pre == 0) {
                    first = a;
                } else {
                    Pair preP = tr.get(pre);
                    //writer.println(preP);
                    if (preP._second < a) {
                        first = a;
                    } else if (preP._second <= b) {
                        //writer.println(preP._second + " - " + a + "+ 1");
                        delta -= preP._second - a + 1;
                        //writer.println("Delta: " + delta);
                        first = preP._first;
                        tr.remove(pre);
                    } else {
                        continue;
                    }
                }
                int post = b;
                second = b;
                while (post >= a) {
                    post = tr.floorKey(post) == null ? 0 : tr.floorKey(post);
                    //writer.println("Post: " + post);
                    if (post == 0) {
                        second = Math.max(b, second);
                    } else {
                        if (post < a) {
                            break;
                        }
                        Pair postP = tr.get(post);
                        //writer.println("Post: " + postP);
                        post = postP._first;
                        if (postP._second <= b) {
                            delta -= postP._second - postP._first + 1;
                            tr.remove(post);
                            second = Math.max(b, second);
                        } else {
                            delta -= b - postP._first + 1;
                            second = postP._second;
                            tr.remove(post);
                        }
                    }

                }
                //writer.println(first + " and " + second);
                Pair newP = new Pair(first, second);
                tr.put(first, newP);
                counter += delta;
                //writer.println("-------------------------");

            } else {
                //writer.println("Size: " + tr.size());
                writer.println(counter);
                //writer.println("-------------------------");
            }
        }
        writer.flush();
    }
}