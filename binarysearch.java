import java.util.Arrays;
public class binarysearch {
    public static int bsearch(int[] numbers,int key){
        int start=0;
        int end = numbers.length-1;
        while(start<=end){
            int mid = (start + end)/2;
            if(key==numbers[mid]){
                return mid;
            }
            if(numbers[mid]> key){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int numbers[] = {2,3,4,3,4,5,46,7,5,8,9};
        int key = 5;
        Arrays.sort(numbers);
        binarysearch b = new binarysearch();
        System.out.println(b.bsearch(numbers,key));
        
    }
}
