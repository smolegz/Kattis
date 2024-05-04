import java.util.*;

public class upsanddownsofinvesting
{
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int npeaks=0, nvalleys=0;
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int rise=1, fall=1;
        int prev = in.nextInt();
        boolean inRise=false;
        boolean inFall=false;
        for(int i=1; i<s; i++) {
            int val = in.nextInt();
            if (val > prev) {
                if (inRise)
                    rise++;
                else {
                    if (rise >= n && fall >= n) npeaks++;
                    inRise = true;
                    inFall = false;
                    rise = 2;
                }
            }
            else {
                if (inFall)
                    fall++;
                else {
                    if (fall >= m && rise >= m) nvalleys++;
                    inRise = false;
                    inFall = true;
                    fall = 2;
                }
            }
            prev = val;
        }


        if (inRise && fall >= m && rise >= m)
            nvalleys++;
        else if (inFall && rise >= n && fall >= n)
            npeaks++;

        System.out.println(npeaks + " " + nvalleys);
    }
}
