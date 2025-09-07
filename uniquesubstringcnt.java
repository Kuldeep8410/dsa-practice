public class uniquesubstringcnt {
    public static class Node{
        Node[] children = new Node[26];
        Boolean eow;
        Node(){
            eow = false;
            for(int i=0;i<children.length;i++){
                children[i]=null;
            }
        }
    }
    public static Node root = new Node();
    public static void insertintrie(String word){
        Node curr= root;
        for(int i=0;i<word.length();i++){
            int idx= word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]= new Node();
            }
            curr = curr.children[idx];
        }
    }
    public static int countnodes(Node root){
        int count=0;
        if(root==null){
            return 0; 
        }
        for(int i=0;i<26;i++){
            if(root.children[i]!=null){
                count += countnodes(root.children[i]);
            }
        }
        return count+1;
    }

    public static void main(String[] args) {
        String str="ababa";
        int count=0;
        for(int i=0;i<str.length();i++){
            insertintrie(str.substring(i));
        }
        System.out.println(countnodes(root));
    }
}
