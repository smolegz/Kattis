import java.util.*;
import java.io.*;

public class traveltheskies {
    public static class Triple {
        int s;
        int e;
        int d;

        public Triple(int s, int e, int d) {
            this.s=s;
            this.e=e;
            this.d=d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int airports = Integer.parseInt(input[0]);
        int days = Integer.parseInt(input[1]);
        int flights = Integer.parseInt(input[2]);
        ArrayList<Triple> arr = new ArrayList<>();
        int[][][] arrF = new int[airports][days][airports];
        int[][] p = new int[airports][days];
        boolean isOptimal = true;
        int counter = flights;
        while (flights-- > 0) {
            String[] f = br.readLine().split(" ");
            int start = Integer.parseInt(f[0]);
            int end = Integer.parseInt(f[1]);
            int day= Integer.parseInt(f[2]);
            int capacity = Integer.parseInt(f[3]);
            arrF[start-1][day-1][end-1] = capacity;
            arr.add(new Triple(start,end,day));
        }
        int kn = airports * days;
        while (kn-- > 0) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int d = Integer.parseInt(line[1]);
            int pax = Integer.parseInt(line[2]);
            for (int i = d-1; i <days; i++) {
                p[a-1][i] += pax;
            }
            //System.out.println(p[1][1]);

            for (int i = d-1; i <days;i++) {
                for (int j = 0; j < airports; j++) {
                    if (arrF[a-1][i][j] !=0 && arrF[a-1][i][j] <= p[a-1][i]) {
                        int newPassenger = arrF[a-1][i][j];
                        arrF[a-1][i][j] = 0;
                        counter--;
                        for (int k = i; k <days; k++) {
                            p[a-1][k] -= newPassenger;
                        }
                        for (int k = i+1; k <days; k++) {
                            p[j][k] += newPassenger;
                        }

                    }
                }
            }
        }
        boolean run = true;
        while (run) {
            run = false;
            for (Triple t: arr) {
                int s = t.s-1;
                int d = t.d-1;
                int e = t.e-1;
                if (arrF[s][d][e] != 0) {
                    if (p[s][d] >= arrF[s][d][e]) {
                        run = true;
                        int newPassenger = arrF[s][d][e];
                        arrF[s][d][e] = 0;
                        counter--;
                        for (int k = d; k <days; k++) {
                            p[s][k] -= newPassenger;
                        }
                        for (int k = d+1; k <days; k++) {
                            p[e][k] += newPassenger;
                        }
                    }
                }
            }
        }

        for (Triple t: arr) {
            if (arrF[t.s-1][t.d-1][t.e-1] != 0) {
                isOptimal = false;
                break;
            }
        }


        System.out.println(isOptimal ? "optimal" : "suboptimal");
    }
}
