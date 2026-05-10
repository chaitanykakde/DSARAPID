import java.util.*;
class permutationsString{
    public static void main(String args[]){
        String ans="abc";
        permutations("",ans);

    }

    static void permutations(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int size=p.length();
        for(int i=0;i<=size;i++){
              String f=p.substring(0,i);
              String s=p.substring(i,size);
              char c=up.charAt(0);
              permutations(f+c+s,up.substring(1));
        }
    }
}