import java.util.HashMap;
import java.util.Map;

public class maxfreqelem {
    public int maxFrequencyElements(int[] nums) {
       Map<Integer,Integer> m = new HashMap<>();
       for(int i:nums){
        m.put(i,m.getOrDefault(i,0)+1);
       }
       int total=0;
       for(int c:m.values()){
        if(c>total)
        total=Math.max(c,total);
       }
       int count=0;
       for(int c:m.values()){
        if(c==total){
            count++;
        }
       }
       total*=count;
       return total;
    }
    public static void main(String[] args) {
        maxfreqelem m = new maxfreqelem();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(m.maxFrequencyElements(nums));
    }
}

