import java.util.*;

public class heap {
        ArrayList<Integer> arr = new ArrayList<>();
        public void add(int data){
            arr.add(data);
            int x = arr.size()-1;
            int par = (x-1)/2;

            while(arr.get(x)<arr.get(par)){   //o(logn).  there are logn levels for tree of height n   // swap the sign for max heap
                //swap
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);
                x=par;
                par =  (x-1)/2;
            }
        }
            public int peek(){
               return arr.get(0);
            }
            private void heapify(int i){
                int left = 2*i +1;
                int right = 2*i +2;
                int minIdx = i;
                 
                if(left< arr.size()&& arr.get(left)<arr.get(minIdx)){    // swap the sign for max heap implementation
                    minIdx = left;
                }
                if(right<arr.size()&& arr.get(minIdx)> arr.get(right)){    //swap the sign for max heap implementation
                    minIdx = right;
                }
                if(minIdx!=i){
                    int temp = arr.get(i);
                    arr.set(i,arr.get(minIdx));
                    arr.set(minIdx,temp);
                    heapify(minIdx);
                }
            }
            public int remove(){
                int data = arr.get(0);
                //step1 - swap first and last
                int temp = data;
                arr.set(0,arr.get(arr.size()-1));
                arr.set(arr.size()-1,temp);
                // delete the last element which we just took from swapping
                arr.remove(arr.size()-1);
                //step3- heapify
                heapify(0);
                return data;
            }
            public boolean isEmpty(){
               return arr.size()==0;
            }
         public static void main(String[] args){
            heap h = new heap();    
            h.add(5);
            h.add(2);
            h.add(1);
            h.add(6);
            h.add(7);
            while(!h.isEmpty()){
                System.out.println(h.peek()); 
                h.remove();
            }
         }
}

