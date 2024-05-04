import java.util.*;
import java.io.*;

public class swaptosort {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);

        UnionFind unf = new UnionFind(n);

        while(k >0) {
            k--;
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            unf.unionSet(a-1,b-1);
        }
        boolean isPossible = true;
        for (int i=0; i < n/2;i++) {
            if (!unf.isSameSet(i,n-i-1)) {
                isPossible = false;
                break;
            }
        }

        System.out.println(isPossible ? "Yes": "No");

    }

}

class UnionFind {                                              // OOP style
    private ArrayList<Integer> p, rank, setSize;
    private int numSets;

    public UnionFind(int N) {
        p = new ArrayList<>(N);
        rank = new ArrayList<>(N);
        setSize = new ArrayList<>(N);
        numSets = N;
        for (int i = 0; i < N; i++) {
            p.add(i);
            rank.add(0);
            setSize.add(1);
        }
    }

    public int findSet(int i) {
        if (p.get(i) == i) return i;
        else {
            int ret = findSet(p.get(i)); p.set(i, ret);
            return ret; } }

    public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

    public void unionSet(int i, int j) {
        if (!isSameSet(i, j)) { numSets--;
            int x = findSet(i), y = findSet(j);
            // rank is used to keep the tree short
            if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
            else                           { p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
                if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } }
}