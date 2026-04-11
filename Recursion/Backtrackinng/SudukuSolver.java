import java.util.*;

class SudukuSolver{
    public static void main(String args[]){
           int[][] board = {
    {3, 0, 6, 5, 0, 8, 4, 0, 0},
    {5, 2, 0, 0, 0, 0, 0, 0, 0},
    {0, 8, 7, 0, 0, 0, 0, 3, 1},
    {0, 0, 3, 0, 1, 0, 0, 8, 0},
    {9, 0, 0, 8, 6, 3, 0, 0, 5},
    {0, 5, 0, 0, 9, 0, 6, 0, 0},
    {1, 3, 0, 0, 0, 0, 2, 5, 0},
    {0, 0, 0, 0, 0, 0, 0, 7, 4},
    {0, 0, 5, 2, 0, 6, 3, 0, 0}
};
       if(solve(board)){
        display(board);
       }else{
        System.out.println("False");
       }

    }
    static boolean solve(int[][] arr){
        int row=-1;
        int col=-1;
        int n=arr.length;

        //check for the empty elelment
        boolean isEmpty=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0){
                  isEmpty=true;
                  row=i;
                  col=j;
                  break;
                }
            }
            if(isEmpty){
                break;
            }
        }
        if(!isEmpty){
            return true;
        }

        //try for every number
        if(isEmpty){
          for(int i=1;i<=9;i++){
             if(isSafe(arr,row,col,i)){
                arr[row][col]=i;
                if(solve(arr)){
                    return true;
                }else{
                    arr[row][col]=0;
                }
             }
          } 
        }
        return false;
    }
    static boolean isSafe(int[][] arr,int r, int c,int n){
        //check row 
        for(int i=0;i<arr.length;i++){
            if(arr[r][i]==n){
                return false;
            }
        }
        //check column 
        for(int i=0;i<arr.length;i++){
            if(arr[i][c]==n){
                return false;
            }
        }
        //chack 3*3 grid
        int sqrt=(int)(Math.sqrt(arr.length));
        int sRow=r-r%sqrt;
        int sCol=c-c%sqrt;
        for(int i=sRow ; i<sRow+sqrt ; i++ ){
            for(int j=sCol ; j<sCol+sqrt ;j++ ){
                   if(arr[i][j]==n){
                    return false;
                   }
            }
            
        }
        return true;
    }

    static void display(int [][] board){
        for(int[] b:board){
            System.out.println(Arrays.toString(b));
        }
        System.out.println();
    }
}