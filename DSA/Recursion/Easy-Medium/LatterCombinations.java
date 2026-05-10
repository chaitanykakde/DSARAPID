import java.util.*;

class LatterCombinations{
    public static void main(String args[]){
         String digits="6";
         List<String> ans=letterCombinations(digits);
         System.out.println(ans);
          
     }
    public static List<String> letterCombinations(String digits) {
      return combinations("",digits);
        
    }

    static List<String> combinations(String p, String up){
      ArrayList<String> local=new ArrayList<>();
        if(up.isEmpty()){
          local.add(p);
          return local;
        }
        int n=up.charAt(0)-'0';
        int extra=0;int shift=0;
        if(n==7 || n==9){
            extra=1;
        }
        if(n==8 || n==9){
          shift=1;
        }
        for(int i=(3*(n-2))+shift;i<=(3*(n-1)-1)+extra+shift;i++){
            char c=(char)('a'+i);
            local.addAll(combinations(p+c,up.substring(1)));
        }

        return local;
    }
 }