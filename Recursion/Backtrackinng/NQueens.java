import java.util.*;

class NQueens{
    public static void main(String args[]){
        int n=8;
        boolean[][] board=new boolean[n][n];
        System.out.println(queens(board,0));
    }

    static int queens(boolean[][] board,int r){

        if(r==board.length){
            display(board);
            return 1;
        }
        int count=0;
        for(int c=0;c<board.length;c++){
            if(isSafe(board,r,c)){
                board[r][c]=true;
                count+=queens(board,r+1);
                board[r][c]=false;
            }
        }
        return count;

    }

    static boolean isSafe(boolean[][] board,int r,int c){
        //chcek vertically 
        for(int i=0;i<=r;i++){
            if(board[i][c]){
                return false;
            }
        }

        //check left daigonal
        int minLeft=Math.min(r,c);
        for(int i=1;i<=minLeft;i++){
            if(board[r-i][c-i]){
                return false;
            }
        }

        //check right daigonal
        int minRight=Math.min(r,board.length-c-1);
        for(int i=1;i<=minRight;i++){
            if(board[r-i][c+i]){
                return false;
            }
        }
        return true;
    }

    static void display(boolean[][] board){
         System.out.println();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]){
                    System.out.print("Q ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
           
        }
    }


}