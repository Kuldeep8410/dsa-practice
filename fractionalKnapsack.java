import java.util.*;

public class fractionalKnapsack {
    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int weight[] = {10, 20 ,30};
        int W = 50;

        // sort acc to ratio.
        double ratio[][] = new double[val.length][2];
        for (int i = 0; i<val.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = val[i]/(double)weight[i];
        }

        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        // fill the bag.
        int profit = 0;
        int capacity = W;
        for (int i = val.length -1; i>=0; i--){
                // completely
                if (capacity > weight[(int)ratio[i][0]]){
                    capacity -= weight[(int)ratio[i][0]];
                    profit+= val[(int)ratio[i][0]];
                }else{
                    // not completely
                    profit+= capacity*ratio[i][1];
                    capacity = 0;
                }
            }
            System.out.println("Total profit : "+ profit);
    }
}
