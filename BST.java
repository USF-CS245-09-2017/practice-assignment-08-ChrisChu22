public class BST<S> {

    public class BSTNode
    {
        Comparable data;
        BSTNode left;
        BSTNode right;

        public BSTNode(Comparable value)
        {
            data = value;
            left = null;
            right = null;
        } //BSTNode

        public BSTNode getLeft() {
            return left;
        } //getLeft

        public BSTNode getRight() {
            return right;
        } //getRight

        public void setRight(BSTNode right) {
            this.right = right;
        } //setRight

        public void setLeft(BSTNode left) {
            this.left = left;
        } //setLeft

        public void setData(Comparable data) {
            this.data = data;
        } //setData


    } //BSTNode

    private BSTNode root;

    //calls find recursively
    public boolean find(Comparable value)
    {
        return find(root, value);
    } //find

    //find recursion
    public boolean find(BSTNode node, Comparable value)
    {
        if (node == null)
            return false;
        if (node.data.compareTo(value) == 0)
            return true;
        else if (node.data.compareTo(value) > 0)
            return find(node.right, value);
        else
            return find(node.left,value);
    } //find

    //calls insert recursively
    public void insert(Comparable value)
    {
        root = insert(root,value);
    }

    //checks the left and right values to insert the value given
    public BSTNode insert(BSTNode node, Comparable value)
    {
        if (node == null)
        {
            BSTNode n = new BSTNode(value);
            return n;
        } //if
        else if (node.data.compareTo(value) > 0)
        {
            node.right = insert(node.right,value);
        } //else if
        else
        {
            node.left = insert(node.left,value);
        } //else
        return node;
    } //insert

    //calls delete recusrively
    public void delete(Comparable value)
    {
        root = delete(root, value);
    }

    //checks the left and right data to find the value and deletes the node
    public BSTNode delete(BSTNode node, Comparable value) {
        if (node == null)
            return null;
        if (node.data.compareTo(value) == 0) {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                if (node.right.left == null) {
                    node.data = node.right.data;
                    node.right = node.right.right;
                    return node;
                } //if
                else {
                    node = (BSTNode) removeSmallest(node.right);
                    return node;
                } //else
            } //else
        } //if
        else if (node.data.compareTo(value) < 0)
        {
            node.right = delete(node.right, value);
        } //else if
        else
            {
                node.left = delete(node.left, value);
            } //else

        return null;
    }

    //remove smallest function
    Comparable removeSmallest(BSTNode node)
    {
        if (node.left.left == null)
        {
            Comparable smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        } //if
        else
        {
            return removeSmallest(node.left);
        } //else
    } //removeSmallest

    //calls recursion print
    public void print()
    {
        print(root);
    } //print

    //print binary tree using recursion
    public void print(BSTNode node)
    {
        if (node != null)
        {
            print(node.left);
            System.out.println(node.data);
            print(node.right);
        } //if
    } //print

} //BST


