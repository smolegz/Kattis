import java.util.*;
public class falcondive {

    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String[] arr = s.split(" ");
        int height = Integer.parseInt(arr[0]);
        int width = Integer.parseInt(arr[1]);
        String c = arr[2];

        char[][] firstF = new char[height][];
        char[][] secondF = new char[height][];
        char[][] thirdF = new char[height][width];

        int startH = -1;
        int startW = -1;
        int endH = -1;
        int endW = -1;

        boolean startFound = false;
        for (int i = 0; i < height; i++) {
            String row = input.nextLine();
            if (!startFound) {
                startW = row.indexOf(c.charAt(1));
                if (startW != -1) {
                    startH = i;
                    startFound = true;
                }
            }
            firstF[i] = row.toCharArray();
        }
        input.nextLine();

        boolean endFound = false;
        for (int i = 0; i < height; i++) {
            String row = input.nextLine();
            if (!endFound) {
                endW = row.indexOf(c.charAt(1));
                if (endW != -1) {
                    endH = i;
                    endFound = true;
                }
            }
            secondF[i] = row.toCharArray();

        }

        int dH = endH - startH;
        int dW = endW - startW;

        int count = 1000*1000;


        ArrayList<Pair> ls = new ArrayList<>(count);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (secondF[i][j] == c.charAt(1)) {
                    int newH = i + dH;
                    int newW = j +  dW;
                    if (newH < 0 || newW < 0 || newH >= height || newW >= width) {

                    } else {
                        thirdF[newH][newW] = c.charAt(1);
                    }
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (thirdF[i][j] == c.charAt(1)) {
                    continue;
                } else {
                    thirdF[i][j] = firstF[i][j] == c.charAt(1) ? secondF[i][j] : firstF[i][j];
                }
            }
        }

        for (char[] l : thirdF) {

            System.out.println(l);
        }

        System.out.println();

    }

}
