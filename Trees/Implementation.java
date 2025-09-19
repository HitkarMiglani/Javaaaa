package Trees;

class Node{
    int key ;
    Node left = null;
    Node right = null;
    public Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
    public Node(int key,Node left,Node right){
        this.key = key;
        this.left = left;
        this.right = right;
    }
}


class BST{
    Node root;
    public BST(){
        root = null;
    }
    public void insert(int key){
        root = insertRec(key,root);
    }

    public boolean search(int key){
        return searchRec(key ,root);
    }

    public void delete(int key){
        root = deleteRec(key, root);
    }

    static Node deleteRec(int key, Node root){
        if(root == null) return null;

        if(key < root.key){
            root.left = deleteRec(key,root.left);
        }
        else if (key > root.key){
            root.right = deleteRec(key,root.right);
        }
        else{
            if(root.left==null && root.right!=null) return root.right;
            else if(root.right==null && root.left!=null) return root.left;

            assert root.right != null;
            root.key = minValue(root.right);
            root.right = deleteRec(key,root.right);
        }
        return root;
    }

    static int minValue(Node root){
        int minv = root.key;
        while(root.left!=null){
            minv = root.key;
            root = root.left;
        }
        return minv;

    }

    static boolean searchRec(int key, Node root){
        if(root == null){
            return false;
        }
        if(root.key == key){
            return true;
        }
        else if(root.key < key){
            return searchRec(key,root.left);
        }
        else{
            return searchRec(key,root.right);
        }
    }

    static Node insertRec(int key, Node root){
        if (root==null){
            return new Node(key);
        }
        if (key<root.key){
            root.left = insertRec(key,root.left);
        }
        else if (key>root.key){
            root.right = insertRec(key,root.right);
        }
        return root;
    }
}

// INFO: ## Traversals ##

class Traversal{
    void inorder(Node root){
        inOrderRec(root);
        System.out.println();
    }

    void inOrderRec(Node root){
        if(root == null) return;
        inOrderRec(root.left);
        System.out.print(root.key+" ");
        inOrderRec(root.right);
    }
    void preorder(Node root){
        preOrderRec(root);
        System.out.println();
    }

    void preOrderRec(Node root){
        if(root == null) return;
        System.out.print(root.key+" ");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }
    void postorder(Node root){
        postOrderRec(root);
        System.out.println();
    }

    void postOrderRec(Node root){
        if(root == null) return;
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.print(root.key+" ");
    }

}
