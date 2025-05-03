import java.util.List;
import java.util.ArrayList; //this is a inbuild class under interface List above
import java.util.LinkedList;// also a class
// public class list {
    public static void printlist(List<String> list1){
        for(String item: list1){
            System.out.println(item);
        }
    }
    public static void main(String[] args){
    List<String> arraylist= new ArrayList<>();
    arraylist.add("hello");
    arraylist.add("bello");
    List<String> Linklist= new LinkedList<>();
    // list list= new list();
    printlist(arraylist);
    // printlist(Linklist);
}
