public class LinkedNodeApp {
    public static void main(String[] args) {
        LinkedNode<String> linkedNode1 = new LinkedNode<>("Thor",null);
        LinkedNode<String> linkedNode2 = new LinkedNode<>("Smiegel",linkedNode1);
        LinkedNode<String> linkedNode3 = new LinkedNode<>("Snickers",linkedNode2);
    }
}

