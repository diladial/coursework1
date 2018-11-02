package supporter;

public class SupporterDatabaseBST implements ISupporterDatabase {
    protected Node root;
    protected int size;



    public SupporterDatabaseBST() {
        root = null;
        size = 0;

    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean containsName(String name) {
        return containsName(root, name);
    }

    public boolean containsName(Node node, String name) {
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
        System.out.println("Number of filled nodes visited " + (numberOfNodes(root,name)));
        return s;
    }

    public Supporter get(Node node, String name) {
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
        //depth is defined as number of steps it takes to get from the root to the
        //most furthest leaf
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
        //assign first supporter as the root supporter
        root = put(root,supporter);
        System.out.println("Depth is now at: " + depth());
        System.out.println("Size of binary search tree is now: " + size());
        System.out.println("using the getSize() method: " + getSize());
        System.out.println("Number of filled nodes visited " + (numberOfNodes(root,supporter.getName()) -1));
        System.out.println();
        return supporter;
    }

    private Node put(Node node, Supporter supporter){
        String name = supporter.getName();
        int numberOfVisited = 0;
        if (node == null) {
            node = new Node(supporter);
            size++;
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

    public int getSize(){
        return size;
    }


    @Override
    public Supporter remove(String name) {
        return null;
    }

    @Override
    public void printSupportersOrdered() {
        System.out.println("- - - - - -");
        System.out.println("Printing supporters: ");
        printSupporters(root);
    }

    public void printSupporters(Node node){
        if (node != null) {
            printSupporters(node.left);
            System.out.println(node.getSupporter().getName());
            printSupporters(node.right);
        }
    }

      class Node {
         private Supporter supporter;
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

