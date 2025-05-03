import java.util.*;
public class indiancoins {
    public static void main(String[] args) {
        Integer coins[] = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int amount = 590;
        // sort desc
        Arrays.sort(coins, Comparator.reverseOrder());

        // find ans
        ArrayList<Integer> ans = new ArrayList<>();
        int countCoins = 0;
        for(int i = 0; i<coins.length; i++){
            if (amount>=coins[i]){
                while(amount>=coins[i]){
                    amount-=coins[i];
                    countCoins++;
                    ans.add(coins[i]);
                }
            }
        }
        System.out.println("Total no. of coins : "+countCoins);
        for (int i = 0; i<ans.size(); i++){
            System.out.print(ans.get(i)+" ");
        }
        System.out.println("");
    }
}
