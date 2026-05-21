class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        int i=0;
        int j=0;
        ArrayList<Integer> set=new ArrayList<>();

        while(i<a.length && j< b.length){
           
            if(a[i]==b[j]){
                if(set.isEmpty() || set.get(set.size()-1)!=a[i]){
                    set.add(a[i]);
                } 

                i++;
                j++;
            }else 
            if(a[i]<b[j]){
                
                    
                if(set.isEmpty() || set.get(set.size()-1)!=a[i]){
                    set.add(a[i]);
                }     
                i++;
            } else
            if(b[j]<a[i]){
                if(set.isEmpty() || set.get(set.size()-1)!=b[j]){
                   set.add(b[j]);
                }     
                

                j++;
            }
            
        }
         while(i<a.length){
               if(set.isEmpty() || set.get(set.size()-1)!=a[i]){
                    set.add(a[i]);
                }
            i++;
        }
        while(j<b.length){
            if(set.isEmpty() || set.get(set.size()-1)!=b[j]){
                    set.add(b[j]);
                } 
                    
            j++;
        }
        
        return set;
    }
}
