
/**
 * Prints the string contents of nodes in a linked list, in a snake-path whose
 * lines do not exceed a given WIDTH (in characters) in length. The printout
 * format requires three strings:
 *
 *    formatted     required
 *    output        strings
 *
 *    +-----+  .... upperFrame string
 *    | cat |  .... content string
 *    +-----+  .... lowerFrame string
 *
 * Note that when transitioning to a new line, strings content and lowerFrame
 * acquire additional content to begin the snake path to the next line, and
 * after printed, string upperFrame is initialized with the vertical element of
 * the snake path working its way to the first node of the next line.
 *
 *                                         +-----+
 *                                         | dog | --+
 *                                         +-----+   |  .... lowerFrame
 *                                                   |
 *                        +--------- ... ------------+
 *                        |
 *       upperFrame ....  |    +-----+
 *                        +--> | cat | ---> ...
 *                             +-----+
 */
public void printList() {
    if ( size > 0 ) {
        /** Drawing elements */
        final String verticalElement = "|";
        final String cornerElement   = "+";
        final String lineElement     = "-";
        final String arrowElement    = ">";
        final String spaceElement    = " ";

        /** Misc constants */
        final int arrowLength = 3;
        final int endOfLineLength = 2;
        final int WIDTH = 90;

        /**
         * OVERHEAD is the space required around the contents of a node, for example
         *    if node.value = "dog",
         * the printout will be
         *    +-----+
         *    | dog |
         *    +-----+
         * The two vertical bars and the two spaces surrounding dog, are the overhead space.
         */
        final int OVERHEAD
                = verticalElement.length() +  // |_                 // This variable assignment
                spaceElement.length() +       // | _                // is just an addition of
                spaceElement.length() +       // |      _           // mostly 1s but in a way
                verticalElement.length() +    // |       |_         // that allows us to change
                spaceElement.length() +       // |       | _        // the drawing elements
                arrowLength +                 // |       | ---_     // without redoing the
                arrowElement.length() +       // |       | --->_    // overhead space
                spaceElement.length();        // |       | ---> _   // computation.

        String upperFrame = new String();
        String lowerFrame = new String();
        String middleFrame    = new String();
        String snake      = new String();
        String snakeTail  = new String();

        /** How many characters have we used for far? */
        int lineLength = 0;

        String nodeValue;
        String frontArrow = "";
        int frontSpace = 0;
        boolean newline = false;
        boolean nothingPrinted = true;
        int nodeValueLength, spaceNeeded;

        Node currentNode = head;

        do {

            nodeValue = currentNode.value;
            nodeValueLength = nodeValue.length();
            spaceNeeded = nodeValueLength + OVERHEAD;
            lineLength = lineLength + spaceNeeded;

            if ( lineLength > WIDTH ) {
                // System.out.println("... line width exceeded");
                // next line
                newline = true;
                lineLength = 0;
            }

            if (newline) {

                System.out.println(upperFrame);
                System.out.println(middleFrame+cornerElement);
                System.out.println(lowerFrame+verticalElement);
                System.out.println(spaceElement.repeat(middleFrame.length())+verticalElement);
                System.out.println(cornerElement+lineElement.repeat(middleFrame.length()-1)+cornerElement);
                System.out.println(verticalElement);
                // print snake arrow

                nothingPrinted = false;

                upperFrame = verticalElement + spaceElement.repeat(endOfLineLength+1);
                lowerFrame = spaceElement.repeat(endOfLineLength+2);
                middleFrame = cornerElement;
                frontArrow = lineElement.repeat(endOfLineLength) + arrowElement + spaceElement;
                frontSpace = frontArrow.length()-3;
                lineLength = lineLength + middleFrame.length() + frontSpace;
                newline = false;

            } else {
                //System.out.println("... no new line");
                frontSpace = 0;
                frontArrow="";
            }

            upperFrame
                    = upperFrame
                    + spaceElement.repeat(frontSpace)
                    + cornerElement
                    + lineElement.repeat(nodeValueLength+2*spaceElement.length())
                    + cornerElement
                    + spaceElement
                    + spaceElement.repeat(arrowLength+1)
                    + spaceElement;

            lowerFrame
                    = lowerFrame
                    + spaceElement.repeat(frontSpace)
                    + cornerElement
                    + lineElement.repeat(nodeValueLength+2*spaceElement.length())
                    + cornerElement
                    + spaceElement
                    + spaceElement.repeat(arrowLength+1)
                    + spaceElement;

            middleFrame
                    = middleFrame
                    + frontArrow
                    + verticalElement + spaceElement
                    + nodeValue
                    + spaceElement + verticalElement
                    + spaceElement
                    + lineElement.repeat(arrowLength) + arrowElement
                    + spaceElement;

            lineLength = lineLength + middleFrame.length();

            currentNode = currentNode.next;

        } while (currentNode.next != null);

        if (nothingPrinted || currentNode.next==null) {
            System.out.println(upperFrame);
            System.out.println(middleFrame);
            System.out.println(lowerFrame);
        }
    }
} // method printList