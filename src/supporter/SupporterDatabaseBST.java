package supporter;

/**
 *
 * @author fadilafidina
 */
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
        System.out.println("Number of filled nodes visited: " + (numberOfNodes(root,name)));
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
        System.out.println("Depth of the binary search treee is now at: " + depth());
        System.out.println("Size of binary search tree is now: " + size());
        System.out.println("Number of filled nodes visited " + (numberOfNodes(root,supporter.getName())));
        System.out.println();
        return supporter;
    }

    private Node put(Node node, Supporter supporter){
        String name = supporter.getName();
        int numberOfVisited = 0;
        if (node == null) {
            node = new Node(supporter);
            //size++;
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
    
    /*

    question:
    1- why isn't there a thing that does the .equals thing, how do we know
    we reached the correct node? -- because we used if ELSE statements - if none equal
    to what we were looking for, then the last one must be the node we want
    2 - why am i getting a duplicate of a node i deleted?
    because i did not reset the pointer before. had

     */
    @Override
    public Supporter remove(String name) {
        System.out.println("Removing supporter " + name + "...");
        Supporter s = remove(root,name).getSupporter();
        System.out.println("Successfully deleted supporter " + s.getName() + " with ID " + s.getID());
        System.out.println("Depth of the binary search treee is now at: " + depth());
        System.out.println("Size of binary search tree is now: " + size());
        System.out.println("Number of filled nodes visited " + (numberOfNodes(root,name)));
        System.out.println();
        return s;
    }

    private Node remove(Node node, String name){
        if (node == null)
            return null;

        if (name.compareToIgnoreCase(node.getSupporter().getName()) < 0)
            node.left = remove(node.left,name);
         else if (name.compareToIgnoreCase(node.getSupporter().getName()) > 0)
            node.right = remove(node.right,name);
        else if (node.left != null && node.right != null){
            //node.supporter = findMin(node.right).getSupporter(); //give the node the most right child's supporter
            //node.right = remove(node.right,node.getSupporter().getName()); //change the link of node.right pointing to the right node
        Node t = node;
        node = findMin(t.right);
        node.right = remove(node.right,node.getSupporter().getName());
        node.left = t.left;

        } else {
            if (node.left == null) {
                node = node.right;
            } if (node.right == null) {
                node = node.left;
            }
        }
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    //the smallest node will always be on the very left position
    //this is because of the properties of BSTs
    //everything on the left is smaller than the current node,
    //if node.left is empty then the node itself is the smallest node in that subtree
    private Node findMin(Node node){
        if(node == null)
            return null;
        else if (node.left == null)
            return node;
        return findMin(node.left);
    }



    @Override
    public void printSupportersOrdered() {
        System.out.println("- - - - - -");
        System.out.println("Printing supporters: ");
        printSupporters(root);
        System.out.println("Size of the binary search tree is now: " + size());
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

