import java.util.*;
import java.io.*;

public class kannafriendshipA {
    //adapted from Steven Halim github
    public static class Pair {
        Integer _first, _second;

        public Pair(Integer f, Integer s) {
            _first = f;
            _second = s;
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
        ArrayList<Pair> ls = new ArrayList<>();
        Boolean[] arr = new Boolean[2000000000];
        Arrays.fill(arr, Boolean.FALSE);
        int oneType = 0;
        boolean one = true;
        int prevSize = 0;
        int counter = 0;
        while (q-- > 0) {
            String[] line = br.readLine().split(" ");
            if (line[0].equals("1")) {
                int a = Integer.parseInt(line[1]);
                int b = Integer.parseInt(line[2]);
                Pair p = new Pair(a,b);
                if (a==b) {
                    if (arr[a-1]) {

                    } else {
                        oneType += 1;
                        Arrays.fill(arr,a-1,b, true);
                        ls.add(p);
                    }
                } else {
                    Arrays.fill(arr,a-1,b, true);
                    ls.add(p);
                }
            } else {

                int sizeLS = ls.size();
//                if (prevSize == sizeLS) {
//                    writer.println(counter);
//                    continue;
//                }
//                counter = 0;
//                if (sizeLS == oneType && one) {
//                    writer.println(sizeLS);
//                    continue;
//                }
                one = false;
                ls.sort(new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return o1.first() - o2.first();
                    }
                });

                int index = 0;
                for (int i = 1; i < ls.size(); i++) {
                    if (ls.get(index).second() >= ls.get(i).first()) {
                        ls.get(index)._second = Math.max(ls.get(index).second(), ls.get(i).second());
                    } else {
                        index++;
                        ls.set(index, ls.get(i));
                    }
                }

                prevSize = sizeLS;
                writer.println(Collections.frequency(List.of(arr),true));
            }
        }
        //System.out.println(Arrays.toString(arr));
        writer.flush();
    }
}
