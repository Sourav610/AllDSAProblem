package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;


public class SerializeAndDeserializeBT{
    public static void main(String[]args){
        Solution sol = new Solution();
        Node root = sol.createNode();
        System.out.println("The binary tree value before serialize desrialize: ");
        inorder(root);
        String serialize = serializeBT(root);
        Node ans = deserializeBT(serialize);
        System.out.println("The binary tree value after serialize desrialize: ");
        inorder(ans);
        
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static String serializeBT(Node root){
        if(root == null){
            return "";
        }

        Queue<Node>elQueue = new LinkedList<>();
        elQueue.add(root);

        StringBuilder sb = new StringBuilder();

        while(!elQueue.isEmpty()){
            int size = elQueue.size();

            for(int i = 0; i<size; i++){
                Node curr = elQueue.poll();
                if(curr == null){
                    sb.append("#,");
                    continue;
                }
                sb.append(curr.data).append(',');
                elQueue.add(curr.left);
                elQueue.add(curr.right);

            }
        }

        return sb.toString();
    }

    public static Node deserializeBT(String data){
        if(data.length() == 0){
            return null;
        }

        String[]val = data.split(",");

        Queue<Node>elQueue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(val[0]));
        elQueue.add(root);

        int i = 1;
        while(!elQueue.isEmpty() && i< val.length){
            Node curr = elQueue.poll();

            if(!val[i].equals("#")){
                Node leftNode = new Node(Integer.parseInt(val[i]));
                elQueue.add(leftNode);
                curr.left = leftNode;
            }
            i++;

            if(!val[i].equals("#")){
                Node rightNode = new Node(Integer.parseInt(val[i]));
                elQueue.add(rightNode);
                curr.right = rightNode;
            }
            i++;
        }

        return root;
    }

}