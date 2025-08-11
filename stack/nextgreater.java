package stack;
import java.util.Stack;
public class nextgreater {
    public static void main(String[] args){
        int arr[] = {4,5,6,4,3,10,2};
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];
        for(int i=arr.length-1; i>=0;i--){
            while(!s.isEmpty()&& arr[i] >= arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i] = -1;
            }
            else{
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0; i<nextGreater.length;i++){
            System.out.print(nextGreater[i]+ " ");
        }
        System.out.println();
    }
}
