import java.util.*;
import java.io.*;

public class keypad {
    public static class FastScanner {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
    //Method to check if the grid is possible
    static boolean checker (String[][] input, int nR, int nC) {
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();

        for (int i = 0; i < nR; i++) {
            for (int j = 0; j < nC; j++) {
                if (input[i][j].contains("1")) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }

        String[][] test = new String[nR][nC];

        for (int i = 0; i < nR; i++) {
            for (int j = 0; j < nC; j++) {
                if (rows.contains(i) && columns.contains(j)) {
                    test[i][j] = "1";
                } else {
                    test[i][j] = "0";
                }
            }
        }

        return Arrays.deepEquals(input, test);
    }

    static boolean checkDup(String[][] inputGrid, int rowNumber, int columnNumber, int numRows) {

        int rowCounter = 0;
        int columnCounter = 0;

        for (String number : inputGrid[rowNumber]) {
            if (number.contains("1")) {
                rowCounter++;
            }
        }

        if (rowCounter == 1) {
            return false;
        }

        else {
            for (int i = 0; i < numRows; i++) {
                if (inputGrid[i][columnNumber].contains("1")) {
                    columnCounter++;
                }
            }
            if (columnCounter == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        FastScanner sc = new FastScanner();

        int tc = sc.nextInt();

        while (tc-- > 0) {
            int I = sc.nextInt();
            int C = sc.nextInt();
            String[][] input = new String[I][C];

            for (int x = 0; x < I; x++) {
                String row = sc.next();
                String[] columns = row.split("");
                for (int y = 0; y < C; y++) {
                    input[x][y] = columns[y];
                }
            }

            if (checker(input, I, C)) {
                String outputGrid[][] = new String[I][C];
                for (int i = 0; i < I; i++) {
                    for (int j = 0; j < C; j++) {
                        if (input[i][j].contains("1")) {
                            if (checkDup(input, i, j, I)) {
                                outputGrid[i][j] = "I";
                            } else {
                                outputGrid[i][j] = "P";
                            }
                        } else {
                            outputGrid[i][j] = "N";
                        }
                    }
                }
                for (int i = 0; i < I; i++) {
                    System.out.println(String.join("", outputGrid[i]));
                }
            } else {
                System.out.println("impossible");
            }
            System.out.println("----------");
        }
    }


}