
import java.util.HashMap;

class LeetcodeTemplate{

    
    //node 
    static class ListNode{
        ListNode next;
        int val;

        ListNode(int val) {
            this.val=val;
            this.next=null;
        } 
        ListNode(int val,ListNode next) {
            this.val=val;
            this.next=next;
        } 
    }

    static class LinkedList{

        ListNode head;
        ListNode tail;
        int size;

         LinkedList() {
            head=null;
            tail=null;
            size=0;
        } 
        

        void insertLast(int val){
            ListNode n=new ListNode(val);
            if(head==null){
               head=n;
               tail=n;
            }else{
                tail.next=n;
                tail=tail.next;
            }
            size++;
        }

        void display(){
            ListNode temp=head;
            
            while(temp!=null){
                System.out.print("->"+temp.val);
                temp=temp.next;
            }
            System.out.println("\n__________________");

        }
        void toArray(int[] arr){
            for(int x:arr){
                insertLast(x);
            }
        }
    }

   //Questions 1. check cycle presnet or not 

   public static boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next !=null ){
            
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    
   //Question 2: return the cycle length
   public static int getCycleLength(ListNode head) {

        ListNode slow=head;
        ListNode fast=head;
        int count=0;
        while(fast!=null && fast.next !=null ){
            
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                ListNode temp=slow;
                do {  
                    temp=temp.next;
                    count++; 
                } while (temp!=slow);
                return count;
            }
        }
        return count;
    } 
    
   public static  ListNode detectCycle1(ListNode head) {
     HashMap<ListNode,Boolean> map=new HashMap<>();
     while(head!=null){
        if(map.containsKey(head)){
            return head;
        }
        map.put(head,true);
        head=head.next;
     }

     return  null;   
    }
   //leetcode detect cycle II 
   public static  ListNode detectCycle(ListNode head) {
     ListNode slow=head;
        ListNode fast=head;
        int count=0;
        while(fast!=null && fast.next !=null ){
            
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                ListNode temp=slow;
                do {  
                    temp=temp.next;
                    count++; 
                } while (temp!=slow);
                break;
            }
        }

        if(count==0){
            return null;
        }
        ListNode s=head;
        ListNode f=head;
        while(count-->0){
            s=s.next;
        }
        while(f!=s){
            f=f.next;
            s=s.next;
        }

     return  s;   
    }
    
    //Question (Math) uses linked list cycle detection approach
    public static  boolean isHappy(int n) {
        int fast=n;
        int slow=n;
        while(fast!=1){
            fast=getDigitSquareSum(fast);
            fast=getDigitSquareSum(fast);
            slow=getDigitSquareSum(slow);

            if(fast!=1 && fast==slow){
                return false;
            }
        }
        return true;
    }
    public static int getDigitSquareSum(int n){
       int sum=0;
       while(n!=0){
         int digit=n%10;
         sum+=digit*digit;
         n=n/10;
       }
       return sum;
    }
    //find the middle of the list
    public  static ListNode middleNode(ListNode head) {
        ListNode s=head;
        ListNode f=head;

        while(f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }  
   
   public  static ListNode middleNode1(ListNode head,ListNode tail) {
        ListNode s=head;
        ListNode f=head;
        if(head.next==tail){
            return head;
        }
        while(f!=tail && f.next!=tail){
            s=s.next;
            f=f.next.next;
        }
        return s;
    }  
   
   //sorting on linked list 
   //merge sort

   public static void display(ListNode head){
       System.out.println("Reverse List:");
       while(head!=null){
        System.out.print("->"+head.val);
        head=head.next;
       }
   }
   public static ListNode sortList(ListNode head) {
        ListNode end=head;
        while(end.next!=null){
            end=end.next;
        }
        return divide(head, end);
    }
    public static ListNode divide(ListNode start,ListNode end){
        if(start==end){
            ListNode l=new ListNode(start.val);
            return l;
        }
           ListNode mid=middleNode1(start,end);
           ListNode l1=divide(start, mid);
           ListNode l2=divide(mid.next, end);
        
        return merge(l1,l2);
        
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        dummy.next=null;
        ListNode tail=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
             tail.next=l1;
             l1=l1.next;
             tail=tail.next;
            }else{
             tail.next=l2;
             l2=l2.next;
             tail=tail.next;
            }
        }
        while(l1!=null){
             tail.next=l1;
             l1=l1.next;
             tail=tail.next;
        }
        while(l2!=null){
             tail.next=l2;
             l2=l2.next;
             tail=tail.next;
        }
        return dummy.next;
    }


    //bubble sort for linked list
        public static ListNode sortListBubble(ListNode head) {
            if( head==null || head.next==null ){
                return head;
            }
            int len=0;
            ListNode n=head;
            while(n!=null){
                n=n.next;
                len++;
            }
            for(int i=1;i<=len;i++){
            ListNode temp1=head;
            ListNode temp2=head.next;
            while(temp2!=null){
                if(temp1.val>temp2.val){
                    int temp=temp1.val;
                    temp1.val=temp2.val;
                    temp2.val=temp;

                    temp1=temp1.next;
                    temp2=temp2.next;
                }else{
                    temp1=temp1.next;
                    temp2=temp2.next;
                }
            }
            }
            
         return  head;
        }


    public static ListNode getNode(ListNode head,int index){
        while(index-1>0){
            head=head.next;
            index--;
        }
        return head;
    }

    public static int getLen(ListNode head){
         int len=0;
         if(head==null){
            return 0;
         }
         if(head.next==null){
            return 1;
         }
         while(head!=null){
            head=head.next;
            len++;
         }
         return len;
    }
    public static ListNode reverseList(ListNode head){
        ListNode first;
        ListNode second;
        ListNode third;
        if(head ==null || head.next==null){
            return head;
        }
        first=head;
        second=head.next;
        third=head.next.next;
        first.next=null;

        while(second!=null){
            second.next=first;
            first=second;
            second=third;
            if(third!=null){
                third=third.next;
            }
        }
        head=first;
        
        
        return head;
    }

    public static ListNode reverseRecursive(ListNode prev){
        ListNode curr=prev.next;
        ListNode head;
        if(curr==null){
            return prev;
        }
        if(curr.next==null){
            curr.next=prev;
            prev.next=null;
            return curr;
        }
        head=reverseRecursive(curr);
        curr.next=prev;
        prev.next=null;
        return head; 
    }
   
    public static ListNode reversePart(ListNode head,int s,int e){
        if(head==null || head.next==null){
            return head;
        }
        ListNode tempPrev=null;
        ListNode temp=head;
        int i=1;

        // store the prev node and reach till the start form where your goign to reverse the list
        while(i<s){
            if(i==s-1){
                tempPrev=temp;
            }
            temp=temp.next;
            i++;
        }
        // now you have the previosu node and
        // the also the node form where you have to start the reversing 
        // now you need jsut to start the reversign the list till end 

        ListNode prev=null;
        ListNode curr=null;
        ListNode next=null;

        prev=temp;
        // check does it null or not before assigning
        if(temp!=null){
         curr=temp.next;
        }
        if(temp.next!=null){
         next=temp.next.next;
        }

        while(i!=e){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null){
                next=next.next;
            }
            i++;
        }

       if(tempPrev != null){
         tempPrev.next=prev;
         temp.next=curr;
         return head;
       }else{
         temp.next=curr;
         return prev;
       }
   
    }
    
    public static boolean isPalindrome(ListNode head) {
        
        int size=0;
        if(head==null || head.next==null){
            return true;
        }
        ListNode temp=head;

        //calcaute the size of list 
        while(temp!=null){
            size++;
            temp=temp.next;
        }

        //check does size if even or odd then decide the reversal part
        int revTill=0;
        if(size%2==0){
            revTill=size/2;
        }else{
            revTill=(size-1)/2;
        }

        //reverse the list till the revTill 
        //remmeber to have an track of haed (which will be the head of revesal list)
        //head1= this will be part of half list 

        ListNode prev=null;
        ListNode curr=head;
        ListNode next=head.next;

        //template the rev list 

        while(revTill-->0){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null){
                next=next.next;
            }
        }

        //assign proper heads 
        
        //if it even then head1 will be curr
        //if it odd then head1 will be next
        //in both cases the head will be prev
       ListNode head1=null;
        if(size%2==0){
            head1=curr;
        }else{
            head1=next;
        }
        head=prev;

        //now we have 2 list with startign from same point and having same numbers form start to end if its a palindrome list
        //travese both and compare the elements if any time fails return the false
        while(head!=null && head1!=null){
            if(head.val!=head1.val){
                return false;
            }
            head=head.next;
            head1=head1.next;
        }


        return true;
    }

    public static void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        //go to the middle node 
        ListNode slow=head;
        ListNode fast=head;
        ListNode prevSlow=null;
        while(fast!=null && fast.next!=null){
            prevSlow=slow;
            slow=slow.next;
            if(fast.next!=null){
                fast=fast.next.next;
            }     
        }
        //breaking the orginal list form prev of slow
        prevSlow.next=null;

        //now we have to reverse the list from the middle node 
        ListNode newHead=revfrom(slow);

        //now we have the 2 heads from. head (this startign from begining )
        // newHead : this is starting form the reversed mid list 
        //now can rorder the list easily
        ListNode temp=head;
        ListNode temp1=newHead;
        
        while(head!=null && newHead!=null){
             newHead=newHead.next;
             head=head.next;
             if(temp.next!=null){
                temp1.next=temp.next;
             }
             temp.next=temp1; 
             temp1=newHead;
             temp=head;
        }
        //now list reoderded but the the if in case of list of odd then last element is still in newHead list
        //not needed becouse 
        // we are doint temp.next=newHead 
        //that means if newHead contains even more than 1 elements it will be connected to it already 
        //so thats it 
        
    }
    public static ListNode revfrom(ListNode head){
        
           ListNode prev=null;
           ListNode curr=head;
           ListNode next=head.next;
           
           while(curr!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(next!=null){
                next=next.next;
            }
           }
           return prev;
    }
    
    
     public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        int arr[]={1,2,3,4,5,6,7,8};
        ll.toArray(arr);
        ll.display();

        //ll.tail.next=ll.head.next;  -> make the linked list cyclic

        // System.out.println("Has Cycle:"+hasCycle(ll.head));
        // System.out.println("Cycle Length:"+getCycleLength(ll.head));
        // System.out.println("Node Form where cycle starts:"+detectCycle(ll.head).val);
        // System.out.println("IS Happy:"+isHappy(12));
        // System.out.println("Squared Sum:"+getDigitSquareSum(10));
        // System.out.println("IS Happy:"+isHappy(10));
        // System.out.println("IS Happy:"+isHappy(19));

        // System.out.println(middleNode(ll.head).val);
        // display(sortListBubble(ll.head));
        // display(reverseRecursive(ll.head));
        //display(reversePart(ll.head,1,7));
        //System.out.println("Is Palindrome:"+isPalindrome(ll.head));
        reorderList(ll.head);
        display(ll.head);
        
    }
}

