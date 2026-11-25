
class LinkedList {

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

    Node head;
    Node tail;
    int size = 0;

    // 1. Print Forward
    void printForward() {
        Node curr = head;

        while (curr != null) {
            System.out.print(curr.val + " <-> ");
            curr = curr.next;
        }

        System.out.println("null");
    }

    // 2. Print Backward
    void printBackward() {
        Node curr = tail;

        while (curr != null) {
            System.out.print(curr.val + " <-> ");
            curr = curr.prev;
        }

        System.out.println("null");
    }

    // 3. Insert at Beginning
    void insertAtBeginning(int val) {
        Node newNode = new Node(val);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;

        head = newNode;
    }

    // 4. Insert at End
    void insertAtEnd(int val) {
        Node newNode = new Node(val);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.prev = tail;
        tail.next = newNode;

        tail = newNode;
    }

    // 5. Delete From Beginning
    void deleteFromFront() {

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }

        head = head.next;
        head.prev = null;

        size--;
    }

    // 6. Delete From End
    void deleteFromEnd() {

        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }

        tail = tail.prev;
        tail.next = null;

        size--;
    }

    // 7. Delete From Specific Position (1-based)
    void deleteFromSpecificLocation(int position) {

        if (head == null || position <= 0) {
            return;
        }

        if (position == 1) {
            deleteFromFront();
            return;
        }

        Node curr = head;

        for (int i = 1; i < position && curr != null; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            return;
        }

        if (curr == tail) {
            deleteFromEnd();
            return;
        }

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        size--;
    }

    // 8. Reverse Doubly Linked List
    void reverseList() {

        Node curr = head;

        while (curr != null) {

            Node temp = curr.prev;

            curr.prev = curr.next;
            curr.next = temp;

            curr = curr.prev;
        }

        // Swap head and tail
        Node temp = head;
        head = tail;
        tail = temp;
    }

    // 9. Get Size
    int getSize() {
        return size;
    }
    
    // 10. Update value in the list
    boolean updateValue(int oldValue, int newValue) {
        Node curr = head;
        
        while (curr != null) {
            if (curr.val == oldValue) {
                curr.val = newValue;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertAtBeginning(20);
        list.insertAtBeginning(10);

        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtEnd(60);
        list.insertAtEnd(70);

        System.out.println("Initial List:");
        list.printForward();

        System.out.println("\nBackward Traversal:");
        list.printBackward();

        System.out.println("\nDelete From Front:");
        list.deleteFromFront();
        list.printForward();

        System.out.println("\nDelete From End:");
        list.deleteFromEnd();
        list.printForward();

        System.out.println("\nDelete From Position 3:");
        list.deleteFromSpecificLocation(3);
        list.printForward();

        System.out.println("\nCurrent Size: " + list.getSize());

        System.out.println("\nReverse DLL:");
        list.reverseList();

        System.out.println("Forward after reversing:");
        list.printForward();

        System.out.println("Backward after reversing:");
        list.printBackward();

        System.out.println("\nCurrent Size: " + list.getSize());
        
        System.out.printf("Update Value: ");
        System.out.println("Before updation:");
        list.printForward();
        System.out.println("After updation:");
        list.updateValue(60, 100);
        list.printForward();
        
        
        System.out.println("\nFinal Size: " + list.getSize());
    }
}
