import java.util.*;
public class trieinsert {
    public static class Node{
        Node children[]= new Node[26];
        boolean eow=false;
        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public static Node root = new Node();
    public static void insert(String word){
        Node curr = root;
        for(int level=0;level<word.length();level++){
            int idx= word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow=true;
    }
    public static boolean search(String key){
        Node curr = root;
        for(int level=0;level<key.length();level++){
            int idx= key.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr= curr.children[idx];
        }
        return curr.eow== true;
    }
    public static boolean stringbreak(String key){ //O(L) linear time complexity
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0,i)) && stringbreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        // String words[]={"hello","jii","kaise","tom","jerry","sarha","sana","anjali"};
        // for(int i=0;i<words.length;i++){
        //     insert(words[i]);
        // }
        // System.out.println(search("anjali"));
        // System.out.println(search("sa"));
        String words[]= {"i","love","sam","samsung","oppo","mobile","ice"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        String key = "ilovesamsungice";
        System.out.println(stringbreak(key));
    }
}
