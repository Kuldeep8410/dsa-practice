import java.util.ArrayList;
import java.util.List;

public class binarytree {
    static class Node {
        int data ;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class bt{
        static int idx=-1;
        public static Node buildtree(int nodes[]){
           idx++;
           if(nodes[idx]==-1){
            return null;
           }
           Node newnode=new Node(nodes[idx]);
           newnode.left=buildtree(nodes);
           newnode.right=buildtree(nodes);
           return newnode;
        }
    }
   public static void main(String[] args) {
    int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
    bt tree= new bt();
    Node root= tree.buildtree(nodes);
    List<Integer> list = new ArrayList<>();
    while(root!=null){
        if(root.left!=null){
            list.add(root.left.data);
        }
        if(root.right!=null){
            list.add(root.right.data);
        }
        root = root.left != null ? root.left : root.right;
        if(root == null) {
            break;  

    }
    for(int i=0; i<list.size(); i++){
        System.out.print(list.get(i) + " ");
    }

   } 
}
