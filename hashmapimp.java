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
        private int size;
        private LinkedList<Node> buckets[];
        @SuppressWarnings("unchecked")
        public hashmap(){
            this.size=0;
            buckets = new LinkedList[4];
            for(int i=0;i<buckets.length;i++){
                buckets[i] = new LinkedList<>();
            }
        }
        public void put(K key,V value){
            
        }
    }
}
