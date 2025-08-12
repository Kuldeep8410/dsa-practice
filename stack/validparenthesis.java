package stack;
import java.util.Stack;
public class validparenthesis {
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char curr = str.charAt(i);
            if(curr == '(' || curr == '[' || curr == '{'){
                s.push(curr);
            }
            else{
                if(s.isEmpty()){
                    return false;
                }
                if(s.peek() == '(' && curr == ')'){
                    s.pop();
                }
                else if(s.peek() == '{' && curr == '}'){
                    s.pop();
                }
                else if(s.peek() == '[' && curr == ']'){
                    s.pop();
                }
                else {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args){
        String str = "({[{[]}]()}{})";
       System.out.println(isValid(str));

    }
}
