import java.util.*;
import java.io.*;

public class sim {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PrintWriter writer = new PrintWriter(System.out);

        for (int j = 0; j < t; j++) {
            String input = br.readLine();
            int pointer = 0;
            LinkedList<Character> ls = new LinkedList<>();

            for (int i= 0; i < input.length(); i ++) {
                char c = input.charAt(i);
                //System.out.println(pointer);
                if (c == '[') {
                    pointer = 0;
                } else if (c == ']') {
                    pointer = ls.size();
                } else if (c == '<' && pointer != 0) {
                    ls.remove(pointer-1);
                    pointer -= 1;
                } else if (c != '[' && c != '<' && c != '<'){
                    ls.add(pointer, c);
                    pointer++;
                }

            }
            ListIterator<Character> iter = ls.listIterator(0);
            while(iter.hasNext()) {
                writer.print(iter.next());
            }
            writer.println();
            writer.flush();

//            for (Character[] c: ls.toArray()) {
//                System.out.println(c);
//            }
        }


    }
}
