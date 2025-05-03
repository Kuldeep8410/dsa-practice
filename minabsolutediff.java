import java.util.*;
public class minabsolutediff {
    public static void main(String[] args) {
        int A[]={1,2,3,4};
        int B[]={2,1,4,3};
        int ans=0;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0;i<A.length;i++){
            ans= ans+ Math.abs(A[i]-B[i]);

        }
        System.out.println("difference "+ ans);

    }
}
