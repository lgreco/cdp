public class OurTree {

    /**
     * Class OurTree has a special node called root, marking the
     * beginning of a tree.
     */
    private Node root;

    /**
     * Field to capture the total number of nodes in the tree.
     */
    private int size = 0;

    /**
     * Class Node is the building block for class Tree. It's an object
     * that comprises the data we wish to store (here a String called
     * content), and pointers to the left and right child nodes, as
     * well as its parent node.
     *
     *                     +---------------+
     *                     |   this node   +----> parent node
     *                     +---------------+
     *                     |    content    |
     *                     +-------+-------+
     *                     | left  | right |
     *                     +-------+-------+
     *                        /        \
     *                       /          \
     *                     left         right
     *                    child         child
     */
    class Node {
        String content;
        Node left;
        Node right;
        Node parent;

        /** Basic constructor: add content, leave pointers null */
        Node(String s) {
            content = s;
            left = null;
            right = null;
            parent = null;
        } // constructor Node

    } // class Node

    /**
     * Accessor for tree's size.
     * @return the number of nodes in the tree.
     */
    public int getSize() {
        return size;
    } // method getSize

    /**
     * Accessor for the content of a node.
     * @param node to obtain content from
     * @return String with node's content
     */
    public String getContent(Node node) {
        return node.content;
    } // method getContent()

    /**
     * Method to insert a note to tree, using recursion. The method returns a Node
     * object, and it has to be called from a node assignment statement, indicating
     * the starting point of insertion. Since all insertions begin from root, the
     * standard invocation of this recursive method must be:
     *      root = addRecursively(root, String s)
     *
     * @param current Node where the insertion begins from (usually, the root)
     * @param s Data to insert as a node in the tree.
     * @return The top node of the tree, in a successful insertion.
     */
    private Node recursiveInsertion(Node current, String s) {

        /*
        If the current node is empty, "wrap" the data into a node object
        and place it here.
         */
        if ( current == null ) {
            current = new Node(s);
            size++;
            return current;
        }

        /*
        If the starting node for insertion is not empty, we need to look
        if the new data should be placed to the left or the right of the
        node. Since we are dealing with Strings, we use the compareTo()
        method to determine the relation between the string we are trying to
        insert and the value held by the current node.
         */

        if (s.compareTo(current.content) < 0) {
            current.left = recursiveInsertion(current.left, s);
            current.left.parent = current;
        } else if (s.compareTo(current.content) > 0) {
            current.right = recursiveInsertion(current.right, s);
            current.right.parent = current;
        }

        /*
        If we make it this far, it's because the new data (String s) we are
        trying to insert in the tree, already exists and we just found it
        as the content of the current node.
         */
        return current;
    } // method recursiveInsertion

    /**
     * Wrapper method for the recursive insertion. It starts from the root
     * node and lets the recursion take charge until it finds an place for
     * the new node containing s. The method, when it executes correctly
     * (and it always does) returns the root node of the tree. This may seem
     * risky, allowing a method to potentially change the root node. The
     * method, however, will always return the root node of the tree.
     *
     * @param s Data we wish to insert in the tree.
     */
    public void addNode(String s) {
        root = recursiveInsertion(root,s);
    } // method add

    /**
     * Recursive method to traverse a binary search tree In-Order.
     * @param node The node to begin the traversal from.
     */
    public void displayInOrder(Node node) {
        if (node==null) {
            return;
        }
        // Process left
        displayInOrder(node.left);
        // Process node
        String nodeContent = node.content;
        String successorContent = ( inOrderSuccessor(root,node) == null) ? "null" : inOrderSuccessor(root,node).content;
        System.out.println("Node " + nodeContent + " has successor: " + successorContent);
        // Process right
        displayInOrder(node.right);
    } // method displayInOrder -- recursive version

    /**
     * Wrapper method for recursive displayInOrder. To disambiguate, the
     * recursive version of this method has a parameter passed to it;
     * specifically the node from which we wish to begin traversal (and
     * usually, it's the root of the tree. The wrapper method has no
     * parameters.
     */
    public void displayInOrder() {
        displayInOrder(root);
    } // method displayInOrder -- wrapper version

     public Node inOrderSuccessor(Node root, Node n)
    {
        // step 1 of the above algorithm
        if (n.right != null) {
            Node min;
            for (min = n.right; min.left != null; min = min.left)
                ;
            return min;        }

        // step 2 of the above algorithm
        Node p = n.parent;
        while (p != null && n == p.right) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    /* Given a non-empty binary search
       tree, return the minimum data
       value found in that tree. Note that
       the entire tree does not need
       to be searched. */
    Node minValue(Node node)
    {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public static void main(String[] args) {
        OurTree sycamore = new OurTree();
        sycamore.addNode("m"); //            m
        sycamore.addNode("k"); //          /   \
        sycamore.addNode("t"); //         /     \
        sycamore.addNode("r"); //        k       t
        sycamore.addNode("b"); //       /       /  \
        sycamore.addNode("f"); //       b      r    z
        sycamore.addNode("z"); //        \
        sycamore.addNode("g"); //         f
                                  //          \
                                  //           g


        sycamore.displayInOrder();

    } // method main

} // class OurTree
