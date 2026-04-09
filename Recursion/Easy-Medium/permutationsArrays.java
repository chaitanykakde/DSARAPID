import java.util.*;
class permutationsArrays{
    public static void main(String args[]){
        int arr[]={1,2,3};
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        permutationsArray2(arr, ans,temp);
        System.out.print(ans);
        

    }
       //not for the array only for valid to strings 
      static void permutations(String p,String up,List<List<Integer>> ans){
       
        if(up.isEmpty()){
           System.out.println(p);
           List<Integer> list=new ArrayList<>();
           for(int i=0;i<p.length();i++){
            list.add(p.charAt(i)-'0');
           }
           ans.add(list);
           return;
        }
        char c=up.charAt(0);
        for(int i=0;i<=p.length();i++){
           
            permutations(p.substring(0,i)+c+p.substring(i,p.length()), up.substring(1),ans);
        }
           
 
       
      }


      static void permutationsArray(int arr[],List<List<Integer>> ans,List<Integer> temp){
       
        if(temp.size()==arr.length){
           ans.add(new ArrayList<>(temp));
           return;
        }
        for(int i=0;i<arr.length;i++){
            if(temp.contains(arr[i])){
                continue;
            }
            temp.add(arr[i]);
            permutationsArray(arr, ans, temp);
            temp.remove(temp.size()-1);
        }
     
       
      }


      static void permutationsArray2(int arr[],List<List<Integer>> ans,List<Integer> temp){
       
        if(temp.size()==arr.length){
           ans.add(new ArrayList<>(temp));
           return;
        }
        for(int i=0;i<arr.length;i++){
            if(temp.contains(arr[i])){
                continue;
            }
            temp.add(arr[i]);
            permutationsArray2(arr, ans, temp);
            temp.remove(temp.size()-1);
        }
     
       
      }
}