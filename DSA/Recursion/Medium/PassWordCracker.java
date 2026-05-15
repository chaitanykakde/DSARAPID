import java.util.*;

class PassWordCracker{
    public static void main(String[] args) {
        //   List<String> list = new ArrayList<>(Arrays.asList("ab", "abcd", "cd"));

        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
       
        while(t-->0){
            List<String> ans=new ArrayList<>();
            List<String> list=new ArrayList<>();
            Set<Integer> dp=new HashSet<>();
            String pass;
            int noOfWo=sc.nextInt();
            for(int i=0;i<noOfWo;i++){
                list.add(sc.next());
            }
            pass=sc.next();

        boolean result=passwordFinder(list,ans,pass,0,dp);
         if(result){
            System.out.println(ans);
        }
        else{
           System.out.println("Wrong Password");
        }
        }
        
        
    }

    private static boolean passwordFinder(List<String> list, List<String> ans, String pass,int index,Set<Integer> set) {
        if(index==pass.length()){
            return true;
        }
        if(index>pass.length()){
            return false;
        }
       if(set.contains(index)){
        return  false;
       }
       set.add(index);
        for(String s:list){
            if(pass.startsWith(s,index)){
                ans.add(s);
            boolean result=passwordFinder(list, ans, pass,index+s.length(),set);
            if(result){
                return true;
            }else{
                ans.remove(ans.size()-1);
            }
            }  
        }


        return false;
    }
}