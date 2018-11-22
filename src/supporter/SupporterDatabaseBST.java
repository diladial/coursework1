package supporter;

/**
 *
 * @author 18033862
 */
public class SupporterDatabaseBST implements ISupporterDatabase {
    private Node root;

    public SupporterDatabaseBST() {
        root = null;
    }

    @Override
    public void clear() {
        System.out.println("Clearing BST...");
        root = null;
        System.out.println("BST is now cleared");
        System.out.println();
    }

    @Override
    public boolean containsName(String name) {
        return containsName(root, name);
    }

    private boolean containsName(Node node, String name) {
        if (node == null) {
            System.out.println("Name not in table");
            return false;
        } else if (node.getSupporter().getName().equalsIgnoreCase(name)) {
            return true;
        } else if (name.compareToIgnoreCase(node.getSupporter().getName()) < 0) {
            return containsName(node.left, name);
        } else if (name.compareToIgnoreCase(node.getSupporter().getName()) > 0) {
            return containsName(node.right, name);
        }
        return false;
    }

    @Override
    public Supporter get(String name) {
        System.out.println("Attempting to get supporter: " + name);
        Supporter s = get(root, name);
        if (s != null) {
            System.out.println("ID of supporter is: " + s.getID());
        }
        System.out.println("Number of nodes visited: " + (numberOfNodes(root,name)));
        return s;
    }

    private Supporter get(Node node, String name) {
        if (node == null) {
            System.out.println("Node not found");
            return null;
        } else if (node.getSupporter().getName().equals(name)) {
            return node.getSupporter();
        } else if (name.compareToIgnoreCase(node.getSupporter().getName()) < 0) {
            return get(node.left, name);
        } else if (name.compareToIgnoreCase(node.getSupporter().getName()) > 0) {
            return get(node.right, name);
        }
        return null;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        else
            return 1 + size(node.left) + size(node.right);
    }

    public int depth() {
        return depth(root);
    }

    private int depth(Node node) {
        if (node == null) {
            return -1;
        } else {
            return 1 + Math.max(depth(node.left), depth(node.right));
        }
    }

    @Override
    public boolean isEmpty() {
        return isEmpty(root);
    }

    private boolean isEmpty(Node node) {
        return node == null;
    }

    @Override
    public Supporter put(Supporter supporter) {
        System.out.println("Adding supporter: " + supporter.getName() + ", with ID: " + supporter.getID());
        root = put(root,supporter);
        System.out.println("Depth of the binary search treee is now at: " + depth());
        System.out.println("Size of binary search tree is now: " + size());
        System.out.println("Number of nodes visited " + (numberOfNodes(root,supporter.getName())));
        System.out.println();
        return supporter;
    }

    private Node put(Node node, Supporter supporter){
        String name = supporter.getName();
        int numberOfVisited = 0;
        if (node == null) {
            node = new Node(supporter);
            System.out.println("Number of nodes visited: " + numberOfVisited);
        }
         else if (name.compareToIgnoreCase(node.getSupporter().getName()) < 0) {
            numberOfVisited++;
             node.left = put(node.left, supporter);
        }
         else if (name.compareToIgnoreCase(node.getSupporter().getName()) > 0) {
            numberOfVisited++;
             node.right = put(node.right, supporter);
        }
        return node;
    }

    private int numberOfNodes(Node node, String name){
        if (node == null) {
            System.out.println("Name not in table");
            return 0;
        } else if (node.getSupporter().getName().equalsIgnoreCase(name)) {
            return 1;
        } else if (name.compareToIgnoreCase(node.getSupporter().getName()) < 0) {
            return 1 + numberOfNodes(node.left, name);
        } else if (name.compareToIgnoreCase(node.getSupporter().getName()) > 0) {
            return 1 + numberOfNodes(node.right, name);
        }
        return 0;
    }

    @Override
    public Supporter remove(String name) {
        System.out.println("Removing supporter " + name + "...");
        int num = numberOfNodes(root,name);
        Supporter s = remove(root,name).getSupporter();
        System.out.println("Successfully deleted supporter " + s.getName() + " with ID " + s.getID());
        System.out.println("Depth of the binary search treee is now at: " + depth());
        System.out.println("Size of binary search tree is now: " + size());
        System.out.println("Number of nodes visited is " + num);
        System.out.println();
        return s;
    }

    private Node remove(Node node, String name){
        if (node == null) {
            System.out.println("Node is a leaf");
            return null;
        }
        if (name.compareToIgnoreCase(node.getSupporter().getName()) < 0){
            node.left = remove(node.left,name);
        } else if (name.compareToIgnoreCase(node.getSupporter().getName()) > 0){
            node.right = remove(node.right,name);
        } else {
            if (node.left == null && node.right == null){
                System.out.println("Node is a leaf");
                return null;
            } else if (node.left == null && node.right != null) {
                return node.right;
            } else if (node.right == null && node.left != null) {
                return node.left;
            } else {
                System.out.println("Node has two descendants");
                node.supporter = findMin(node.right).getSupporter();
                node.right = remove(node.right, node.supporter.getName());
            }
        }
        return node;
    }


    private Node findMin(Node node){
        if(node == null)
            return null;
        else if (node.left == null)
            return node;
        else
        return findMin(node.left);
    }

    @Override
    public void printSupportersOrdered() {
        System.out.println("- - - - - -");
        System.out.println("Printing supporters: ");
        printSupporters(root);
        System.out.println("Size of the binary search tree is: " + size());
        System.out.println("Depth of the binary search tree is: " + depth());
        System.out.println();
    }

    public void printSupporters(Node node){
        if (node != null) {
            printSupporters(node.left);
            System.out.println(node.getSupporter().getName());
            printSupporters(node.right);
        }
    }

      class Node {
        Supporter supporter;
          Node left;
          Node right;

        Node (Supporter supporter) {
            this.supporter = supporter;
            this.left = null;
            this.right = null;
        }

        public Supporter getSupporter(){
            return supporter;
        }
    }
}

