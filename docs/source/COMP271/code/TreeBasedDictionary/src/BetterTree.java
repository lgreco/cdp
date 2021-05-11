public class BetterTree extends OurTree {

    class BetterNode extends Node {
        Node parent;

        public BetterNode(String s) {
            super(s);
            left = right = parent = null;
        }
    }

    @Override
    public void addNode(String s) {
        super.addNode(s);
    }

    public static void main(String[] args) {
        BetterTree maple = new BetterTree();
        maple.addNode("m");
        maple.addNode("k");
        maple.addNode("t");
        maple.addNode("r");
        maple.addNode("b");
        maple.addNode("f");
        maple.addNode("z");
        maple.addNode("g");


        //System.out.println(maple.getRootContent());
        //System.out.println(maple.getSize());

        maple.displayInOrder();

    } // method main

}
