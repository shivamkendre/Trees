import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;
public class Tree{
    Node root;
    static int count;

    public void add(int data){
        this.root = insert(this.root, data);
    }


    private Node insert(Node root, int data){

        // if tree is empty we are creating node and returning its adress
         if(root == null)
         return new Node(data);

        if(root.data >= data)
        root.left = insert(root.left, data);
        else
        root.right = insert(root.right, data);

        return root;

    }


    public void levelOrder(){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.print(node.data+" ");
            if(node.left != null)
            queue.add(node.left);
            if(node.right != null)
            queue.add(node.right);
        }

    }

    public void inOrder(Node root){
        if(root == null)
        return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public void preOrder(Node root){
        if(root != null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root){
        if(root == null)
        return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public int getMax(){
      return max(root);
    }

    private int max(Node root){
        if(root == null)
        return -1;
        else if(root.right == null)
        return root.data;
        else{
            return max(root.right);
        }
    }

    public int getMin(){
       return min(root);
    }

    private int min(Node root){
        if(root == null)
        return -1;
        else if(root.left == null)
        return root.data;
        else{
            return min(root.left);
        }
    }

    public void delete(int data){
       root = deleteNode(root, data);
    }

    public int getHeight(){
        return height(this.root);
    }

    private int height(Node root){
        return root == null ? -1: Math.max(height(root.left), height(root.right)) + 1;
    }

    public void preOrderIterative(){
       Node temp = root;
       Stack<Node> stack = new Stack<Node>();
       while(temp != null || stack.size() != 0){


           while(temp != null){
               System.out.print(temp.data+" ");
               stack.push(temp);
               temp = temp.left;
           }

           Node current = stack.pop();
           temp = current.right;

       }
    }


    public int nthInorder(int n){
         count = 0;
         return nthPrivateInorder(root, n);
    }


    private int nthPrivateInorder(Node root, int n){
          if(root == null)
             return -1;

          int data = nthPrivateInorder(root.left, n);
          if(data != -1)
            return data;
          else if(++count == n){
              return root.data;
          }else{
              return nthPrivateInorder(root.right, n);
          }
    }
    private Node deleteNode(Node root, int data){
        if(root == null)
        return null;
        else if(root.data > data) 
        root.left = deleteNode(root.left, data);
        else if(root.data < data) 
        root.right = deleteNode(root.right, data);
        else{
            if(root.left == null && root.right == null)
            return null; 
            else if(root.left != null && root.right == null)
            return root.left;
            else if(root.right != null && root.left == null) 
            return root.right;
            else{
                Node temp;
                for(temp = root.left; temp.right != null ; temp = temp.right);
                root.data = temp.data;
                root.left = deleteNode(root.left, root.data);

            }
        }
        return root;
    }
}