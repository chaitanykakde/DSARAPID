import java.util.*;
class AllPaths{
    public static void main(String args[]){
        boolean[][] vis={{false,false,false},
                         {false,false,false},
                         {false,false,false}}; 
        boolean[][] stones={{false,false,false},
                         {false,false,false},
                         {false,false,false}}; 
        int[][] numpath=new int[3][3];
        int count=1;
        pathsNum(0,0,"",stones,vis,numpath,count);                                 
    }

    static void paths(int n,int m,String path,boolean[][] stones,boolean[][] vis){
        if(n==vis.length-1 && m==vis.length-1){
              System.out.println(path);
              return; 
        }
        if(vis[n][m]){
            return;
        }
        if(stones[n][m]){
            return;
        }
        vis[n][m]=true;
        //go down       
        if(n<vis.length-1){
            paths(n+1,m,path+"D",stones,vis);
        }
        //go up
        if(n>0){ 
            paths(n-1,m,path+"U",stones,vis);
        }
         //go right
        if(m<vis.length-1){
            paths(n,m+1,path+"R",stones,vis);
        }
         //go left
        if(m>0){
            paths(n,m-1,path+"L",stones,vis);

        }
        vis[n][m]=false;
    }

     static void pathsMatrix(int n,int m,String path,boolean[][] stones,boolean[][] vis){
          if(vis[n][m]){
            return;
        }
        if(stones[n][m]){
            return;
        }
        vis[n][m]=true;
        if(n==vis.length-1 && m==vis.length-1){
            System.out.println();
             for(int i=0;i<vis.length;i++){
                for(int j=0;j<vis[0].length;j++){
                    System.out.print((vis[i][j])? "X ":"0 ");
                }
                System.out.println();
             }
             vis[n][m]=false;
              return; 
        }
      
        //go down   
        
        if(n<vis.length-1){
            pathsMatrix(n+1,m,path+"D",stones,vis);
        }
        //go up
        if(n>0){ 
            pathsMatrix(n-1,m,path+"U",stones,vis);
        }
         //go right
        if(m<vis.length-1){
            pathsMatrix(n,m+1,path+"R",stones,vis);
        }
         //go left
        if(m>0){
            pathsMatrix(n,m-1,path+"L",stones,vis);

        }
        vis[n][m]=false;
    }
     static void pathsNum(int n,int m,String path,boolean[][] stones,boolean[][] vis,int[][] numpath,int count){
          if(vis[n][m]){
            return;
        }
        if(stones[n][m]){
            return;
        }
        vis[n][m]=true;
      
        numpath[n][m]=count;
        if(n==vis.length-1 && m==vis.length-1){
            System.out.println();
            for(int[] arr:numpath){
                System.out.println(Arrays.toString(arr));
            }
            
             vis[n][m]=false;
              return; 
        }
      
        //go down   
        
        if(n<vis.length-1){
            pathsNum(n+1,m,path+"D",stones,vis,numpath,count+1);
        }
        //go up
        if(n>0){ 
            pathsNum(n-1,m,path+"U",stones,vis,numpath,count+1);
        }
         //go right
        if(m<vis.length-1){
            pathsNum(n,m+1,path+"R",stones,vis,numpath,count+1);
        }
         //go left
        if(m>0){
            pathsNum(n,m-1,path+"L",stones,vis,numpath,count+1);

        }
        vis[n][m]=false;
        numpath[n][m]=0;
    }
}