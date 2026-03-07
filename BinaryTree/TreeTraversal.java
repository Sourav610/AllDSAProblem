package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair{
    Node key;
    int val;

    Pair(Node key, int val){
        this.key = key;
        this.val = val;
    }

    Node getKey(){
        return key;
    }

    int getVal(){
        return val;
    }
}
public class TreeTraversal {
    public static void main(String[] args) {
        Solution sol  = new Solution();
        Node root = sol.createNode();
        List<List<Integer>>ans = new ArrayList<>();
        ans = traverseTree(root);

        List<Integer> pre = ans.get(0);
        List<Integer> in = ans.get(1);
        List<Integer> post = ans.get(2);

        // Printing the traversals
        System.out.print("Preorder traversal: ");
        printList(pre);

        System.out.print("Inorder traversal: ");
        printList(in);

        System.out.print("Postorder traversal: ");
        printList(post);

        
    }

    public static void printList(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static List<List<Integer>> traverseTree(Node root){
        Stack<Pair>st = new Stack<>();
        st.push(new Pair(root, 1));

        if(root == null){
            return new ArrayList<>();
        }
        List<Integer>preOrder = new ArrayList<>();
        List<Integer>inOrder = new ArrayList<>();
        List<Integer>postOrder = new ArrayList<>();

        while(!st.empty()){
            Pair pair = st.peek();
            st.pop();
            Node node = pair.getKey();
            if(pair.getVal() == 1){
                preOrder.add(node.data);
                pair = new Pair(node, 2);
                st.push(pair);
                if(node.left != null){
                    Pair temp = new Pair(node.left, 1);
                    st.push(temp);
                }
            }
            else if(pair.getVal() == 2){
                inOrder.add(node.data);
                pair = new Pair(node, 3);
                st.push(pair);
                if(node.right != null){
                    Pair temp = new Pair(node.right, 1);
                    st.push(temp);
                }
            }
            else{
                postOrder.add(node.data);
            }
        }

        List<List<Integer>>result = new ArrayList<>();
        result.add(preOrder);
        result.add(inOrder);
        result.add(postOrder);
        return result;

    }
}
