import java.util.*;
import java.io.*;

public class kaploeb {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        PrintWriter writer = new PrintWriter(System.out);
        int l = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        int s = Integer.parseInt(in[2]);
        HashMap<Integer, Runner> hmap = new HashMap<>(l);
        while (l > 0) {
            l--;
            String[] line = br.readLine().split(" ");
            int id = Integer.parseInt(line[0]);
            String[] time = line[1].split("\\.");
            int seconds = Integer.parseInt (time[0])*60 + Integer.parseInt(time[1]);
            if (hmap.containsKey(id)) {
                Runner r = hmap.get(id);
                hmap.replace(id, new Runner(id, r.lap +1, r.time+seconds));
            } else {
                hmap.put(id ,new Runner(id, 1, seconds));
            }
        }

        Runner[] arr = hmap.values().toArray(new Runner[0]);
        hmap.clear();
        Arrays.sort(arr, new sortById());
        Arrays.sort(arr, new sortByTime());
        Arrays.sort(arr, new sortByLap());
        for (Runner r : arr) {
            if (r.lap < k) {
                break;
            } else {
                writer.println(r.id);
            }
        }
        writer.flush();

    }
}

class Runner {
    int id;
    int lap;
    int time;

    public Runner(int id, int lap, int time) {
        this.id = id;
        this.lap = lap;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " ,Lap: " + this.lap + " ,Time: " + this.time;
    }
}

//sort in ascending order
class sortByTime implements Comparator<Runner> {
    public int compare(Runner a, Runner b) {
        return a.time - b.time;
    }
}

//sort in descending order
class sortByLap implements Comparator<Runner> {
    public int compare(Runner a, Runner b) {
        return b.lap - a.lap;
    }
}

class sortById implements Comparator<Runner> {
    public int compare(Runner a, Runner b) {
        return a.id - b.id;
    }
}
