package stack;
import java.util.*;
public class stocks {
    public static void stockspan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i=1; i<stocks.length;i++){
            int currprice = stocks[i];
            if(!s.isEmpty() && stocks[s.peek()] < currprice){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                span[i]= i - s.peek();
            }
            s.push(i);
        }
    }
    public static void main(String[] args){
        int stocks[] = {100,80,60,70,60,85,100};
        int span[] = new int[stocks.length];
        span[0]=1;
        stockspan(stocks,span);
        for(int i=0;i<span.length;i++){
            System.out.println(span[i]+" ");
        }
    }
}
