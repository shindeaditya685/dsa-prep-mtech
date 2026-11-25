


class CircularLinkedList {
    class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;
    
    // 1. Display List 
    void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        Node curr = head;

        do {
            System.out.print(curr.val + " <-> ");
            curr = curr.next;
        } while (curr != head);

        System.out.println("(back to head)");
    }
    
    // 2. Insert at the Beginning
    void insertAtBeginning(int val) {
        Node newNode = new Node(val);
        
        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }
    
    // 3. Insert at the end
    void insertAtEnd(int val) {
        Node newNode = new Node(val);
        
        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
        size++;
    }
    
    
    // 4. Get the size
    int getSize() {
        return size;
    }
    
    // 5. Delete from the Beginning
    void deleteFromFront() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        
        if (head == tail) {
            head = tail = null;
            return;
        }
        
        head = head.next;
        head.prev = tail;
        tail.next = head;
        size--;
    }
    
    // 6. Delete From the End
    void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head == tail) {
            return;
        }
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        size--;
    }
    
    // 7. Insert At Specific Position
    void InsertAtSpecificPosition(int position, int val) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid Position!");
            return;
        }
        
        if (position == 1) {
            insertAtBeginning(val);
            return;
        }
        
        if (position == size + 1) {
            insertAtEnd(val);
            return;
        }
        
        Node newNode = new Node(val);
        Node curr = head;
        
        for (int i = 1; i < position; i++) {
            curr = curr.next;
        }
        
        newNode.next = curr;
        newNode.prev = curr.prev;
        
        curr.prev.next = newNode;
        curr.prev = newNode;
        size++;
    }
    
    // 8. Delete From Specific Position
    void deleteFromSpecificPosition(int position) {
        if (position == 1) {
            deleteFromFront();
            return;
        } 
        
        if (position == size) {
            deleteFromEnd();
            return;
        }
        
        Node curr = head;
        for (int i = 1; i < position; i++) {
            curr = curr.next;
        }
        
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        size--;
    }
    

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtBeginning(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtEnd(60);
        
        list.display();
        
        
        System.out.println("Final Size of List Before Deletion: " + list.getSize());
        
        System.out.println("\nDelete From Front");
        list.deleteFromFront();
        System.out.println("List After Deletion:");
        list.display();
        
        System.out.println("\nDelete From End");
        list.deleteFromEnd();
        System.out.println("List After Deletion:");
        list.display();
    
        
        System.out.println("\nFinal Size of List After Deletion: " + list.getSize());
        
        System.out.println("\nInsert At Specific Position:");
        System.out.println("List Before Insertion");
        list.display();
        list.InsertAtSpecificPosition(3, 100);
        System.out.println("List After Insertion");
        list.display();
        
        System.out.println("\nDeletion From Specific Position:");
        System.out.println("List Before Deletion");
        list.display();
        list.deleteFromSpecificPosition(3);
        System.out.println("List After Deletion");
        list.display();
        
        
        
        
        System.out.println("Final Size of List: " + list.getSize());
        
    }

}
