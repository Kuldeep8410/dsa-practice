package DP;

public class fibonacci {
    public static int fib(int[] f,int n){
        if(n==0|| n==1){
            return 1;
        }
        if(f[n]!=0){
            return f[n];
        }
        f[n] = fib(f,n-1)+fib(f,n-2);
        return f[n];
    }
    public static void main(String[] args){
        int n=5;
        int f[] = new int[n+1]; //by default the value at each index =0
        System.out.println(fib(f,n));
        for(int i=0;i<f.length;i++){
            System.out.print(f[i]+" ,");
        }
    }
}
