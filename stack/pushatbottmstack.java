package stack;
import java.util.*;
public class pushatbottmstack {
    
        public static void pushbottom(Stack<Integer> s, int data){
            if(s.isEmpty()){
                s.push(data);
                return;
            }
            int top =s.pop();
            pushbottom(s,data);
            s.push(top);
        }
        public static void main (String[] args){
            Stack<Integer> s = new Stack<>();
            s.push(1);
            s.push(3);
            s.push(4);
            s.push(5);
            pushbottom(s,8);
            while(!s.isEmpty()){
                System.out.println((s.pop()));
            }
        }
}
