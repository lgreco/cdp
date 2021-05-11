/**
 * A simple linked list class comprising nodes, each containing a
 * String value and a pointer to the next node down the list. The
 * class has two special nodes called head and tail, indicating its
 * beginning and end. A integer field called size also provides a
 * current count of how may nodes are in the chain.
 *
 * A list with size == 1, has only one node that is its tail and head
 * at the same time:
 *   head.next = null
 *   tail = head
 *
 * A list with size == 2, has only a head and a tail node, such that
 *   head.next = tail
 *   tail.next = null
 *
 * Nodes are an inner class within OurLinkedList class.
 */
public class OurLinkedList {

    /** The first node in the list. */
    private Node head;

    /** The last node of the list. */
    private Node tail;

    /** Number of nodes in the list. */
    private int size=0;

    /**
     * The node class
     */
    class Node {
        /** The actual contents of the node */
        String value;
        /** The next node down the list */
        Node next;

        /**
         * Basic constructor. The node's next node is always initialized
         * to null, and determined later by the addNode method.
         *
         * @param v String value to be held by the node.
         */
        Node(String v) {
            value = v;
            next = null;
        } // constructor Node
    } // class Node

    /**
     * Accessor for the field size.
     * @return number of nodes in the list.
     */
    public int getSize() {
        return size;
    } // method getSize

    /**
     * Method to determine if a node with a specific string, exists.
     * @param v String to search for
     * @return true if node with given string exists; false otherwise.
     */
    public boolean nodeExists(String v) {
        // Initial assumption: no node found with string v
        boolean stringFound = false;
        // Start from the beginning.
        Node currentNode = head;
        if ( currentNode == null) {
            // Empty list.
            stringFound = false;
        } else {
            // List is not empty. Let's check if the last node contains
            // string we are looking for. We do this here, because the
            // last node is unreachable in a loop that terminates when
            // .next == null.
            stringFound = tail.value.equals(v);
            // Search through the rest of the linked list, hopping from
            // node to node, following the .next pointer.
            while (currentNode.next != null) {
                if ( currentNode.value.equals(v) ) {
                    stringFound = true;
                }
                currentNode = currentNode.next;
            }
        }
        return stringFound;
    } // method nodeExists

    /**
     * Method to add a new node to the list. The node is always added to the
     * end of the list and becomes its new tail. Before adding a node, we
     * verify that the list does not contain another node with the same
     * string value.
     * @param v String value of new node.
     */
    public void addNode(String v) {
        if (!nodeExists(v)) {
            // The list does not contain a node with the given string.
            // Let's create one and call it newNode.
            Node newNode = new Node(v);
            // We are adding this newNode to the list, so let's increase the size.
            size++;
            // Now we need to determine where to add this new node.
            if (head == null) {
                // List is empty. Make this newNode the list's head.
                head = newNode;
                // Because the list is empty, make this node its tail as well.
                tail = head;
            } else {
                // The list is not empty. Find its tail node and add the
                // newNode after it.
                tail.next = newNode;
                // Make the newNode, the list's new tail.
                tail = newNode;
            }
        }
    } // method addNode

    public void displayList() {
        if (size > 0) {
            Node current = head;
            while (current.next != null) {
                System.out.print(current.value + " --> ");
                current = current.next;
            }
            System.out.println(current.value);
        } else {
            System.out.println("List's empty.");
        }
    }

    public boolean reverse() {
        boolean success = false;
        if (size > 0) {
            success = true;
            Node previousNode = null;
            Node nextNode;
            Node current = head;
            while ( current != null) {
                nextNode = current.next;     // this can be null; it's ok
                current.next = previousNode; // flip the pointer
                previousNode = current;      // go to the nest candidate for "previous"
                current = nextNode;          // mode down the list
            }
            // swap head and tail
            Node temp = tail;
            tail = head;
            head = temp;
            success = true;
        }
        return success;
    }

    public void printNFromEnd(int n) {
        /*
        This version assumes that we do not know the size of the
        list and we must compute it first. Of course, class OurLinkedList
        as created here, has a field
          int size;
        the containts its current size. But for a complete demo,
        we assume we do not know the size of a list.

                                                        If we want to usse class field size:
         */
        int listSize = 0;
        if (head == null) {                           // if size == 0
            System.out.println("List is empty.");
        } else {                                        // this block
            Node current = head;                        // can be
            listSize = 1;                               // ommitted
            while (current.next != null) {             // because
                listSize++;                             // list size
                current = current.next;                 // is already
            }                                           // known .... listSize = size
            /*
            Now that we know the list size, let's make sure that the
            value
              int n
            passed as a method parameter, is not greater than the size
            of the list (so that we are not asked to print the 11th
            element from the end, for a list with 5 elements).
             */

            if (n > listSize) {                       // if n > size ..
                System.out.println("List has " + listSize + " elements; You are asking for element # " + n + " from the end. Sorry!");
            } else {
                /*
                The n-th element from the end, is the
                  (listSize - n + 1 )th
                element from the beginning
                 */
                int targetElement = listSize - n + 1;
                int count = 1;
                current = head;
                while (count < targetElement) {
                    current = current.next;
                    count++;
                }
                System.out.println("Element # " + n + " from the end is: " + current.value);
            }
        } // method printNFromEnd
    }

    public String printNthNode (int n) {

        if(head == null) {

            return "Empty List";

        }

        Node node = head;

        for(int i = 0; node !=null && i<n; i++) {

            node = node.next;

        }

        Node temp = head;

        while(node != null) {

            node = node.next;

            temp = temp.next;

        }

        return temp.value;

    }



    public static void main(String[] args) {
        OurLinkedList demo = new OurLinkedList();
        demo.addNode("A");
        demo.addNode("B");
        demo.addNode("C");
        demo.addNode("D");
        demo.addNode("E");
        demo.addNode("F");
        demo.addNode("G");
        demo.displayList();
        demo.printNFromEnd(8);
        //demo.reverse();
        demo.displayList();
        System.out.println();
        System.out.printf(demo.printNthNode(2));
    } // method mail
} // class OurLinkedList
