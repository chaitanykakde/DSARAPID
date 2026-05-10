import java.util.*;

class MazeWithJumps{
    public static void main(String args[]){
        int n=3;
        int m=3;
        maze(n,m,"");
    }

    static void maze(int n,int m,String p){
        if(n-1==0 && m-1==0){
            System.out.println(p);
            return;
        }
        //right
        for(int i=1;i<=m-1;i++){
            maze(n,m-i,p+" R"+i);
        }
        //down
        for(int i=1;i<=n-1;i++){
            maze(n-i,m,p+" D"+i);
        }
        //daigonal
        int min=Math.min(n,m);
        for(int i=1;i<=min-1;i++){
            maze(n-i,m-i,p+" Diag"+i);
        }
    }
}