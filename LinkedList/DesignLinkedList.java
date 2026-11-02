import java.util.*;
import java.lang.*;
import java.io.*;

class LinkedList
{
    static int size = 0;
    static Node head;
    static Node tail;
    
    static class Node {
        int data;
        Node next;
        
        Node (int data) {
            this.data = data;
            this.next = null;
            
        }
    }
    
    
    static void addFirst(int value) {
        Node newNode = new Node(value);
        
        if (size == 0) {
            head = tail = newNode;
            size++;
            return;
        }
        
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    static void addLast(int value) {
        Node newNode = new Node(value);
        
        if (size == 0) {
            head = tail = newNode;
            size++;
            return;
        }
        
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    
    
    static void addAtIndeX(int value, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index!!!");
            return;
        }
        
        if (index == 0) {
            addFirst(value);
            return;
        }
        
        if (index == size) {
            addLast(value);
            return;
        }
        
        Node newNode = new Node(value);
        
        Node temp = head;
        
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }
    
     static void print(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.next != null) {
                System.out.print("->");
            }

            temp = temp.next;
        }

        System.out.println("->null");
    }
    
    
    
    
    
	public static void main (String[] args) throws java.lang.Exception
	{
        LinkedList ll = new LinkedList();
        
        ll.addFirst(10);
        ll.addFirst(20);
        ll.addFirst(30);
        ll.addLast(40);
        ll.addLast(50);
        ll.addFirst(1);
        
        
        System.out.println(head.next.data);
        System.out.println(tail.data);
        System.out.println(size);
        print(head);

	}
}
