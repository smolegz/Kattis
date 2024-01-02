import java.util.*;
import java.io.*;

public class laptopstickers {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] details = br.readLine().split(" ");
        int l = Integer.parseInt(details[0]);
        int h = Integer.parseInt(details[1]);
        int n  = Integer.parseInt(details[2]);
        List<List<String>> board = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            board.add(new ArrayList<String>());
            for (int j = 0; j<l;j++) {
                board.get(i).add("_");
            }
        }
        char letter = 97;
        for (int i = 0; i < n; i++) {
            String[] stk = br.readLine().split(" ");
            int ll = Integer.parseInt(stk[0]);
            int hh = Integer.parseInt(stk[1]);
            int sx =  Integer.parseInt(stk[2]);
            int sy =  Integer.parseInt(stk[3]);
            for (int k = sy; k < sy+hh; k++) {
                if (k >= h) {
                    break;
                }
                for (int j = sx; j < sx+ll; j++) {
                    if (j >= l) {
                        continue;
                    }
                    board.get(k).set(j, Character.toString(letter));
                }
            }
            letter++;
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j <l;j++) {
                System.out.print(board.get(i).get(j));
            }
            System.out.print('\n');
        }



    }
}
