import java.util.*;
class FirstNegetive {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        List<Integer> list=new ArrayList<>();
        Deque<Integer> dq=new LinkedList<>();
        
        for(int i=0;i<k;i++){
            if(arr[i]<0){
                dq.addLast(i);
            }
        }
        //ans for first window
        if(dq.isEmpty()){
            list.add(0);
        }else{
            list.add(arr[dq.peekFirst()]);
        }
        
        //window slide on next part
        for(int i=k;i<arr.length;i++){
            
            //remove out window elements
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            
            //adding current answet if it negetive
            if(arr[i]<0){
                dq.addLast(i);
            }
            
            //check answer for current window
            if(dq.isEmpty()){
                list.add(0);
            }else{
                list.add(arr[dq.peekFirst()]);
            }
        }
        
  return list;
    }
}