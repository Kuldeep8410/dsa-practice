import java.util.Arrays;

public class nozerointeger {
    public static boolean isZero(int num){
        while(num!=0){
            if(num%10==0){
                return true;
            }
            num = num/10;
        }
        return false;
    }
    public static int[] findNoZero(int n){
        int[] result = new int[2];
        for(int i=1;i<n;i++){
            int a =i;
            int b= n-i;
            if(!isZero(a)&& !isZero(b)){
                result[0]=a;
                result[1]=b;
                return result;
            }
        }
        return result;
    }
    public static void main(String[] args){
        int n=1020;
        int[] result = new int[2];
        result =findNoZero(n);
        System.out.println(Arrays.toString(result));

        //printing a 2d array
        int[][] fakearray= {{2,3},{2,34,5},{5,67,4,3,2},{4,3}};
        System.out.println(Arrays.deepToString(fakearray));
        System.out.println(Arrays.deepEquals(args, fakearray))
    }
}
