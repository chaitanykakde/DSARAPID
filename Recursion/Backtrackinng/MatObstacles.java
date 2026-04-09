import java.util.*;

class MatObstacles{
    public static void main(String arg[]){
        boolean river[][]={{false,false,false},
                           {false,true,false},
                           {false,false,false}};
        int arr[][]={{0,0,0},{0,0,0},{0,0,0}} ;                  
       System.out.println(pathsList(2,2,"",river));                 
                           
    }

     static void pathsLen(int n,int m,boolean[][] river,int[][] arr,int count){
        
       
        if(n==2 && m==2 ){
          for(int i=0;i<n-1;i++){
            for(int j=0;j<m-1;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
          }
          return;
        }
        if(n<3 && river[n][m]){
            return;
        }
        if(n+1<3){
           arr[n][m]=count;
           pathsLen(n+1,m,river,arr,count+1);
           arr[n][m]=0;
        }
        if(m+1<3){
           arr[n][m]=count;
           pathsLen(n,m+1,river,arr,count+1);
           arr[n][m]=0;
        }
        if(n+1<3 && m+1<3){
            arr[n][m]=count;
            pathsLen(n+1,m+1,river,arr,count+1);
            arr[n][m]=0;
        }
      
    }
    //print the len
    static List<String> pathsList(int n,int m,String path,boolean[][] river){
        ArrayList<String> list=new ArrayList<>();
        if(n==0 && m==0 ){
            list.add(path);
            return list;
        }
        if(river[n][m]){
            return list;
        }
        if(n>0){
          list.addAll(pathsList(n-1,m,path+"R",river));
        }
        if(m>0){
         list.addAll(pathsList(n,m-1,path+"D",river));
        }
        // if(n>0 && m>0){
        //     list.addAll(pathsList(n-1,m-1,path+"D",river));
        // }
        return list;
    }
}