public class LL {
   private int size;
    Node head;
    LL(){
        this.size=0;
    }
    
    class Node{
        String data ;
        Node next;
        Node(String data ){
            this.data=data;
            this.next=null;
            size++;
        }
    }
    public void addFirst(String data){
        Node newNode= new Node(data);
        if(head==null){
            head= newNode;
            return;
        }
        newNode.next= head;
        head = newNode; 
    }
    public void addlast(String data){
        Node newNode= new Node(data);
        if(head==null){
            head= newNode;
            return;
        }
        Node currNode= head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=newNode;
    }
    public void printlist(){
        if(head==null){
            System.out.println("hey this is a empty list");
            return;
        }
        Node currNode= head;
        while(currNode!=null){
            System.out.print(currNode.data +" ->");
            currNode=currNode.next;
        }
        System.out.println("NULL");
    }
    public void deletefirst(){
        if(head==null){
            System.out.println("list is empty anna cant delete");
        }
        size--;
        head=head.next;

    }
    public void deletelast(){
        if(head==null){
            System.out.println("hey list is empty you racsal");
            return;
        }
        size--;
        if(head.next==null){
            head=null;
            return;
        }
        Node secondlast=head;
        Node last= head.next;
        while(last.next!=null){
            last=last.next;
            secondlast=secondlast.next;
        }
        secondlast.next=null;
    }
    public int getsize(){
        return size;
    }
    public static void main(String[] args) {
        LL list= new LL();
        list.addFirst("dfs");
        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("hey you");
        list.printlist();
        list.addlast("kuwait");
        list.printlist();
        list.deletefirst();
        list.printlist();
        list.deletelast();
        list.printlist();
        System.out.println("size of the list is: "+list.getsize());
        list.addFirst("cd");
        System.out.println("size of the list is: "+list.getsize());
    }
}
