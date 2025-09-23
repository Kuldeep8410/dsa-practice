import java.util.*;

public class hashmapimp {
    static class hashmap<K,V>{
        private class Node{
            K key;
            V value;
             public Node(K key,V value){
                this.key = key;
                this.value = value;
             }
        }
        private int n;
        private int N;
        private LinkedList<Node> buckets[];
        @SuppressWarnings("unchecked")
        public hashmap(){
            this.N=4;
            buckets = new LinkedList[4];
            for(int i=0;i<buckets.length;i++){
                buckets[i] = new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc) % N;
        }
        private int searchInLL(K key,int b1){
            LinkedList<Node> ll = buckets[b1];
            int dataidx=0;
            for(int i=0;i<ll.size();i++){
                Node node = ll.get(i);
                if(node.key.equals(key)){
                    return dataidx;
                }
                dataidx++;
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldbuckets[] = buckets;
            buckets = new LinkedList[2*N];
            N=2*N;
            for(int i=0;i<buckets.length;i++){
                buckets[i] = new LinkedList<>();
            }
            for(int i=0;i<oldbuckets.length;i++){
                LinkedList<Node> ll = oldbuckets[i];
                for(int j=0;j<ll.size();j++){
                    Node node = ll.get(j); //ll.remove();
                    put(node.key,node.value);
                }
            }
        }
        public void put(K key,V value){
            int b1 = hashFunction(key);
            int dataidx = searchInLL(key,b1);
            if(dataidx !=-1){
                Node node = buckets[b1].get(dataidx);
                node.value = value;
            }
            else{
                buckets[b1].add(new Node(key,value));
                n++;
            }
            double lambda = (double) n/N;
            if(lambda>2.0){
                rehash();
            }
        }
        public boolean containKey(K key){
            int b1 = hashFunction(key);
            int dataidx = searchInLL(key, b1);
            if(dataidx!=-1){
                return true;
            }else{return false;}
        }
        public V get(K key){
            int b1 = hashFunction(key);
            int dataidx = searchInLL(key,b1);
            if(dataidx!=-1){return buckets[b1].get(dataidx).value;}
            return null;
        }
        public V remove(K key){
            int b1 = hashFunction(key);
            int di = searchInLL(key,b1);
            if(di!=-1){
                n--;
                return buckets[b1].remove(di).value;
            }else{
                return null;
            }
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i=0;i<buckets.length;i++){
                 LinkedList<Node> ll = buckets[i];
                 for(Node node: ll){
                    keys.add(node.key);
                 }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n==0;
        }
    }
        public static void main(String[] args) {
            hashmap<String,Integer> map = new hashmap<>();
            map.put("India", 120);
            map.put("US", 30);
            map.put("China", 150);
            map.put("Nepal", 10);
            map.put("Bhutan", 5);
            System.out.println(map.get("India"));
            System.out.println(map.get("US"));
            System.out.println(map.get("China"));
            System.out.println(map.get("Nepal"));
            System.out.println(map.get("Bhutan"));

            System.out.println(map.remove("US"));
            System.out.println(map.get("US"));

            ArrayList<String> keys = map.keySet();
            for(String key: keys){
                System.out.println(key + ": " + map.get(key));
            }
            
        }
}
