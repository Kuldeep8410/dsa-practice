public class nqueens {
    public static int count=0;
    public static boolean isSafe(char board[][], int row,int col){
        // vertical upward direction check for queen to settle 
        for(int i= row-1;i>=0;i--){
            if(board[i][col]== 'Q'){
                return false;
            }
        }
        //left diagonal check
        for(int i = row-1,j= col-1 ;i>=0 && j>=0;i--,j--){
            if(board[i][j]== 'Q'){
                return false;
            }

        }
        // diagonal right up
        for(int i= row-1,j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]== 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void nQueens(char board[][], int row){     //for checking and print only single solution its type will be boolean
        // base case
        if(row == board.length){
            // printboard(board); 
    
            count++;
            return;   // return true kar dunga kyuki solution exist karta hai is case me 
        }
        // column loop
        for(int j=0;j<board.length;j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                nQueens(board,row+1);  //ise if case me daalunga agar true hoga to print kar dega sol possible 
                board[row][j]='x'; //backtrack step

            }
        }
    }
    public static void printboard(char board[][]){
        System.out.println("Chess Board:------------------------------");
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j] +" ");
                
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int n=4;
        char board[][] = new char[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0; j<board.length;j++){
                board[i][j]= 'x';
            }
        }
        nQueens(board,0);
        System.out.println("the total number of solution are: " +count);
    }
    
}
