import java.util.*;
import java.io.*;

public class zoning {

    public static void main(String[] args) throws Exception {
//        Scanner input = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<List<Long>>> facs = new ArrayList<>();
        List<List<List<Long>>> stus = new ArrayList<>();
        String[] inArr = br.readLine().split(" ");
        int f = Integer.parseInt(inArr[2]);
        long s = Long.parseLong(inArr[3]);
        int g = Integer.parseInt(inArr[4]);
        List<Long> steps = new ArrayList<>();


        for (int i = 0; i < f; i++) {
            String[] fac = br.readLine().split(" ");
            int k = Integer.parseInt(fac[0]);
            facs.add(new ArrayList<>());
            stus.add(new ArrayList<>());
            for (int j = 0; j < k; j++) {
                List<Long> xy = new ArrayList<>();
                xy.add(Long.parseLong(fac[2*j+1]));
                xy.add(Long.parseLong(fac[2*j+2]));
                facs.get(i).add(xy);
            }

            Collections.sort(facs.get(i), (first, second) -> {
                if (first.get(0) > second.get(0)) {
                    return 1;
                } else if (first.get(0) < second.get(0)) {
                    return -1;
                } else if (first.get(0) == second.get(0) && first.get(1) > second.get(1)) {
                    return 1;
                } else if (first.get(0) == second.get(0) && first.get(1) < second.get(1)) {
                    return -1;
                } else {
                    return 0;
                }
            });
        }


        for (int k = 0; k < s; k++) {
            String[] student = br.readLine().split(" ");
            List<Long> details = new ArrayList<>();
            long x = Integer.parseInt(student[0]);
            long y = Integer.parseInt(student[1]);
            long id = Integer.parseInt(student[2]);
            int f_id = Integer.parseInt(student[3]);
            details.add(id);
            details.add(x);
            details.add(y);
            stus.get(f_id-1).add(details);
        }

        for (int i =0;i <f;i++) {
            Collections.sort(stus.get(i), (first, second) -> {
                if (first.get(0) > second.get(0)) {
                    return 1;
                } else if (first.get(0) < second.get(0)) {
                    return -1;
                } else {
                    return 0;
                }
            });
        }

        System.out.println(facs);
        System.out.println(stus);

        String[] qt = br.readLine().split(" ");

        for (int i = 0; i < f; i++) {
            List<Long> moves = new ArrayList<>();
            for (int j = 0; j < stus.get(i).size(); j++) {
                long x = stus.get(i).get(j).get(1);
                long y = stus.get(i).get(j).get(2);
                long f_x = facs.get(i).get(j).get(0);
                long f_y = facs.get(i).get(j).get(1);
                long dist = Math.abs(f_y-y) + Math.abs(f_x-x);
                moves.add(dist);
            }
            Collections.sort(moves);
            steps.add(moves.subList(0, Integer.parseInt(qt[i])).stream().mapToLong(Long::longValue).sum());

        }
        Collections.sort(steps);
        if (g == 0) {
            System.out.println(0);
            return ;
        }

        System.out.println(steps.subList(0, g).stream().mapToLong(Long::longValue).sum());

    }
}
