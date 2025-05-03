import java.util.*;

public class jobsequencing {
    static class Jobsc{
        int id;
        int deadline;
        int profit;

        // remember this thing
        public Jobsc(int i,int d,int p){
            id = i;
            deadline = d;
            profit = p;
            
        }
    }

    public static void main(String[] args) {
        int Job[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};
        
        ArrayList<Jobsc> Jobs = new ArrayList<>();
        for(int i =0; i< Job.length; i++){
            Jobs.add(new Jobsc(i, Job[i][0], Job[i][1]));
        }
        
        // sort in descending
        Collections.sort(Jobs, (a, b) -> b.profit-a.profit);

        // find profit.
        ArrayList<Integer> ans = new ArrayList<>();
        int time = 0;
        for (int i = 0; i<Jobs.size(); i++){
            if (time<Jobs.get(i).deadline){
                ans.add(Jobs.get(i).id);
                time++;
            }
        }
        System.out.println("time taken : "+ time);
        for(int i =0; i< ans.size(); i++){
            System.out.println(ans.get(i)+" ");
        }
        System.out.println("");
    }
}

