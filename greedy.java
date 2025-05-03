import java.util.*;

public class greedy{
    public static void main(String[] args) {
        int start[] = {1, 3, 0, 5, 8, 5};
        int end[] = {2, 4, 6, 7, 9, 9};

        // sort arrays acc to end array.
        int activities[][] = new int[start.length][3];
        // store the values
        for (int i = 0; i<start.length; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;
        int endtime = 0;
        // select first activity.
        ans.add(activities[0][0]);
        endtime = activities[0][2];
        count++;
        // select next activities.
        for (int i = 1; i<start.length; i++){
            if (activities[i][1]>= endtime){
                ans.add(activities[i][0]);
                count++;
                endtime = activities[i][2];
            }
        }

        // print ans
        System.out.println("total activities : "+ count);
        for(int i = 0; i<ans.size(); i++){
            System.out.println("A"+ans.get(i));
        }
    }
}