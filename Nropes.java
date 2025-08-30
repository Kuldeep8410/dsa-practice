import java.util.*;
public class Nropes {
    public static void main(String[] args){
        int ropes[]= {2,4,5,1,3,5,7,8};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }
        int cost =0;
        while(pq.size()>1){
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost+= min1+min2;
            pq.add(min1+min2);

        }
        System.out.println("cost of connecting all ropes = " + cost);
    }
}
