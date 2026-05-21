

class Merge2SortedList{
    public static void main(String[] args) {
        LinkedList l1=new LinkedList();
        LinkedList l2=new LinkedList();
        l1.insertLast(1);
l1.insertLast(3);
l1.insertLast(5);
l1.insertLast(7);

l2.insertLast(2);
l2.insertLast(4);
l2.insertLast(6);
l2.insertLast(8);
        
        l1.display();
        l2.display();
        merge(l1.head, l2.head);
        

    }
    static Node mergeInPlace(Node head1,Node head2){
        if(head1==null){
            return head2;
        }else if(head2==null){
            return head1;
        }
        Node temp1;
        Node temp2;
        Node head;
        if(head1.data<=head2.data){
            temp1=head1;
            temp2=head2;
            head=head1;
        }else{
            temp1=head2;
            temp2=head1;
            head=head2;
        }
        //merging the lists
        while(temp1.next!=null && temp2!=null){
            if(temp2.data <= temp1.next.data){
                if(temp1.next == null){
                    temp1.next = temp2;
                    break;
                }
              Node p=temp2;
              temp2=temp2.next;  
              p.next=temp1.next;
              temp1.next=p;
              temp1 = temp1.next; 
              
            }else{
                temp1=temp1.next;
            }
        }

        ///adding remaining elements
         //temp1.next=temp2;

        return head;
    }

    static Node merge(Node head1,Node head2){
        if(head1 ==null){
            return  head2;
        }else if(head2==null){
            return head1;
        }
        LinkedList ll=new LinkedList();
        Node temp;
        while(head1!=null && head2!=null){
            if(head1.data<head2.data){
                ll.insertLast(head1.data);
                head1=head1.next;
            }else{
                ll.insertLast(head2.data);
                head2=head2.next;
            }
        }

        //add reamining elements if any list still have elements
        while(head1!=null){
             ll.insertLast(head1.data);
              head1=head1.next;
        }

        while(head2!=null){
            ll.insertLast(head2.data);
            head2=head2.next;
        }
        ll.display();
        return ll.head;
    }
}


