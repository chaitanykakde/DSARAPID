import java.util.*;

class MatrixPaths{
    public static void main(String args[]){
       System.out.println(pathsList(3,3,""));
    }

    //just print paths
    static void paths(int n,int m,String path){
        if(n==0 && m==0 ){
            System.out.println(path);
            return;
        }
        if(n>0){
           paths(n-1,m,path+"D");
        }
        if(m>0){
        paths(n,m-1,path+"R");
        }
        
    }
    //return list of paths
    static List<String> pathsList(int n,int m,String path){
        ArrayList<String> list=new ArrayList<>();
        if(n==0 && m==0 ){
            list.add(path);
            return list;
        }
        
        if(n>0){
          list.addAll(pathsList(n-1,m,path+"H"));
        }
        if(m>0){
         list.addAll(pathsList(n,m-1,path+"V"));
        }
        if(n>0 && m>0){
            list.addAll(pathsList(n-1,m-1,path+"D"));
        }
        return list;
    }

    //return count
      static int paths(int n,int m){
        if(n==0 && m==0 ){
            return 1;
        }
        int left=0;
        int right=0;
        if(n>0){
          left+=paths(n-1,m);
        }
        if(m>0){
        right+=paths(n,m-1);
        }
       return left+right; 
    }
}