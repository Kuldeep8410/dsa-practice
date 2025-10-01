import java.util.*;

public class hashmap {
    public static void main(String[] args){
         HashMap<String,Integer> hm= new HashMap<>();

         //insert
         hm.put("India",125);
         hm.put("China",120);
         hm.put("Bhutan",2);
         hm.put("Indonesia",34);
         hm.put("bngld",23);
         System.out.println(hm);

         System.out.println(hm.get("India"));
        //  System.out.println(hm.containsKey("Bhutan"));
         System.out.println(hm.remove("China"));
         System.out.println(hm.remove("China")); //remove and return the value corresponding to the key
        //  System.out.println(hm);
          // hm.clear();
          // System.out.println(hm.isEmpty());

          //using entryset ->
          for (HashMap.Entry<String, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
           
        }
        hm.computeIfAbsent("Africa", (k) -> 1);
        for(String key: hm.keySet()){
          System.out.println("key:" + key);
        }
        // for(Integer value: hm.values()){
        //   System.out.println("values:" + value);
        // }
        System.out.println("Iterating using forEach:(lambda)");
        // hm.forEach((key,value) -> System.out.println(key + " => " + value));
        System.out.println(hm);
        }

}
