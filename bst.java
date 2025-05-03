import java.util.*;
public class bst {
    static class Node{
        int data;
        Node right;
        Node left;
        
        Node(int data){
            this.data=data;
        }
}
    public static Node insert(Node root, int val){
        if(root==null){
            root= new Node(val);
            return root;
        }
        if(root.data> val){
            root.left= insert(root.left,val);
        }
        if(root.data< val){
            root.right= insert(root.right,val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
           return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root, int key){
        if(root ==null){
            return false;
        }
           if(root.data > key){
               return search(root.left,key);
           }
           else if(root.data < key){
            return search(root.right,key);
           }
           else {
            return true;
           }
    }
     public static Node delete(Node root, int val){
        if(root.data>val){
            root.left= delete(root.left,val);
        }
        else if(root.data<val){
            root.right= delete(root.right,val);
        }
        else{// root.data==val
            //case 1 leaf node
            if(root.left==null && root.right==null){
                return null;
            }
            // case 2 node have a single child
             if(root.left==null){
                return root.right;
             }
            else if(root.right==null){
                return root.left;
             }
             //case 3 node with 2 children
             // we have to search for inorder successor
            Node IS= inordersuccessor(root.right);
            root.data= IS.data;
            root.right=delete(root.right,IS.data);
        }
        return root;
     }
     public static Node inordersuccessor(Node root){
         while(root.left!= null){
            root= root.left;
         }
         return root;
     }
     // Print the values form bst which are in range [x,y]
     public static void printinrange(Node root, int X, int Y){
        if(root==null){
            return;
        }
        if(root.data>=X && root.data<=Y){
            printinrange(root.left,X,Y);
            System.out.print(root.data +" ");
            printinrange(root.right,X,Y);
        }
        if(root.data<X){
            printinrange(root.right,X,Y);
        }
        else if(root.data>=Y){
            printinrange(root.left,X,Y);
        }
     }
     // printing all the paths from root node to leaf node
     public static void printroot2leaf(Node root, ArrayList<Integer> path){
            if(root==null){
                return;
            }
            path.add(root.data);
            //leaf
            if(root.left==null&& root.right==null){
                printpath(path);
            }
            else{//non leaf
                printroot2leaf(root.left,path);
                printroot2leaf(root.right,path);
            }
            path.remove(path.size()-1);
     }
     public static void printpath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i) +"->");
        }
         System.out.println();
     }
    public static void main(String[] args){
        int values[]={8,5,3,1,4,6,10,11,14};
        Node root= null;
        for(int i=0;i<values.length;i++){
           root = insert(root,values[i]);
        }
        // inorder(root);
        // System.out.println();
        // if(search(root,11)){
        //     System.out.print("oye oye mil gaya");
        // }
        // else{
        //     System.out.println("nhi mila ji");
        // }
        //   delete(root,11);
        //   inorder(root);

        // printinrange(root,3,12); 
        // printroot2leaf(root,new ArrayList<>());       
         
    }
}
