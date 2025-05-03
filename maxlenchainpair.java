import java.util.*;
public class maxlenchainpair {
    public static void main(String[] args) {
        int pairs[][] = {{5, 24}, {39, 60}, {5, 28}, {27, 40}, {50, 90}};
        // sort
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        int ans=0;
        int len = 0;
        // select 1st
        ans = 1;
        int lastend = pairs[0][1];
        len = pairs[0][1] - pairs[0][0];
        // for rest of ...
        for (int i =1; i < pairs.length; i++){
            if (pairs[i][0]>lastend){
                ans++;
                lastend = pairs[i][1];
                len+= pairs[i][1] - pairs[i][0];
            }
        }
        System.out.println("no of chain : "+ans+"\nlength : "+len);
    }
}
