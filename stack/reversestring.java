package stack;
import java.util.*;
public class reversestring {
    public static String reversestr(String str){
        if(str.length()==0){
            return str;
        }
      Stack<Character> s = new Stack<>();
      int idx=0;
       while(idx<str.length()){
        s.push(str.charAt(idx));
        idx++;
       }
       StringBuilder newstr = new StringBuilder();
       while(!s.isEmpty()){
           newstr.append(s.pop());
       }
        return newstr.toString();
    }
    public static void main(String[] args){
        String str ="abckuldeep";
        String result = reversestr(str);
        System.out.println(result);
    }
}
