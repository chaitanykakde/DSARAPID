import java.util.*;
class NKights{
    public static void main(String args[]){

        int n=4;
        boolean[][] board=new boolean[n][n];
        int k=6;
        go(board,0,0,k);
        
    }

    static void go(boolean[][] board,int r,int c,int target){
         if(target==0){
            display(board);
            return;
         }
         if(r==board.length-1 && c==board.length-1){
            return;
         }

        if(c==board.length){
            go(board,r+1,0,target);
            return;
        }
        if(isSafe(board,r,c)){
            board[r][c]=true;
            go(board,r,c+1,target-1);
            board[r][c]=false;
        }

        go(board,r,c+1,target);

    }

    static boolean isSafe(boolean[][] board,int r,int c){
        //chcek vertically
        if(r-2>=0 ){
            if(c-1>=0){
                if(board[r-2][c-1]){
                    return false;
                }
            }
            if(c+1<board.length){
                if(board[r-2][c+1]){
                    return false;
                }
            }
        }

        //check horzontally 
        if(c-2>=0){
            if(r-1>=0){
                if(board[r-1][c-2]){
                    return false;
                }
            }
        }
        if(c+2<board.length){
            if(r-1>=0){
                if(board[r-1][c+2]){
                    return false;
                }
            }
        }


        return true;
    }
        static void display(boolean[][] board){
         System.out.println();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]){
                    System.out.print("K ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
           
        }
    }
}