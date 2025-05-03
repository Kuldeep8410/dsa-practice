import java.util.HashSet;
import java.util.Iterator;
public class hashset {
    public static void main(String[] args){
        HashSet set= new HashSet();
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(1);
        set.add(5);
        System.out.println("size of hashset "+ set.size());
        // print all the elements of the hashset
        System.out.println(set);
        if(set.contains(1)){
            System.out.println("IT contains 1");
        }
        System.out.println(set.remove(6));
        if(!set.contains(1)){
            System.out.println("yup you deleted 1");
        }
        //Let's Iterate over our hashset -> we have to create a Iterator for that purpose
        Iterator it= set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() +",");
        }
    }
}
