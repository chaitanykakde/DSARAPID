




public class LinkedListALLOP{
       public static void main(String[] args) {
           LinkedList ll=new LinkedList();
           ll.insertFirst(20);
           ll.insertFirst(20);
           ll.display();
           ll.insertFirst(20);
           ll.display();
           ll.insertAt(20, 1);
           ll.insertAt(5, 0);
           ll.insertAt(90, 5);
           ll.insertAt(90, 5);
           ll.insertAt(90, 5);
           ll.display();
           ll.removeDuplicates();
           ll.display();
          
       }
}
class Node{
    Node next;
    int data;

    Node(int data){
        this.next=null;
        this.data=data;
    }
    Node(int data,Node next){
        this.next=next;
        this.data=data;
    }
}

class LinkedList{
    int size;
    Node head;
    Node tail;
    //  1.insert first
    //  2.inseert at index
    //  3.insert at last
    //  4.delete first 
    //  5.delete at index
    //  6.delete at last
     
    void insertFirst(int data){
        Node n=new Node(data);
        n.next=null;
        if(head==null){
            head=n;
            tail=n;
        }else{
            n.next=head;
            head=n;
        }
        size++;
    }
    // 0   1.  2.  3.  4. 
    // 1-> 2-> 3-> 4-> 5->$
    //insert at index
    void insertAt(int data,int index){
        if(index==0 || head==null){
            insertFirst(data);
        }else if(index>=size-1){
           insertLast(data);
        }else{
            int i=1;
            Node temp=head;
            while(i<index){ // 3     0 1 2 3 
               temp=temp.next;
               i++; 
            }
            Node n=new Node(data);
            n.next=temp.next;
            temp.next=n;
            size++;
        }
    }
    //insert last 
    void insertLast(int data){
        Node n=new Node(data);
        n.next=null;
        if(head==null){
            head=n;
            tail=n;
            tail.next=null;
        }else{
            tail.next=n;
            tail=tail.next;  
        }
      size++;
    }

    //delete first
    void deleteFirst(){
        if(head==null){
            System.out.println("Linked List is Already Empty");
            return;
        }else if(head.next==null){
            System.out.println("Deleted:"+head.data);
            head=null;
            tail=null;
        }else{
            System.out.println("Deleted:"+head.data);
            head=head.next;
        }
        size--;
    }

    //delete last 
    void deleteLast(){
        if(head==null){
            System.out.println("Linked List is Already Empty !!");
            return;
        }else if (head.next==null) {
            System.out.println("Deleted:"+head.data);
            head=null;
            tail=null;

        }else{
            Node temp=head;
            while(temp.next!=tail){
                temp=temp.next;
            }
            System.out.println("Deleted:"+tail.data);
            tail=temp;
            tail.next=null;
        }
        size--;
    }

    //DeleteAtIndex
    void deleteAt(int index){
        if(index==0){
            deleteFirst();
        }else if(index==size-1){
            deleteLast();
        }else{
            int i=1;
            Node temp=head;
            while(i<index){
                temp=temp.next;
                i++;
            }
            //at previous node of which node to delete
            temp.next=temp.next.next;
        }
    }

    void display(){
        Node temp=head;
        System.out.println("***********");
        while(temp!=null){
            System.out.print("->"+temp.data);
            temp=temp.next;
        }
        System.out.println("\n***********");
    }

    //remove the duplicates
    void removeDuplicates(){
        if(head==null){
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            if(temp.data==temp.next.data){
                temp.next=temp.next.next;
                size--;
            }else{
                temp=temp.next;
            }
        }
        tail=temp;
        tail.next=null;
    }
}
