package BinarySearchTree;

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val  = val;
        left = null;
        right = null;
    }
}

public class FloorAndCeilInBST {
    public static void main(String[]args){
        Node root =new Node(8);
        root.left = new Node(5);
        root.right = new Node(12);
        root.left.left = new Node(4);
        root.left.right = new Node(7);
        root.left.right.left = new Node(6);
        root.right.left = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        int key = 9;
        int[] ans = {0};
        findFloor(root,key,ans);
        if(ans[0] == 0){
            System.out.println("The floor of the key "+key+" is: null");
        }
        else{
            System.out.println("The floor of the key "+key+" is: "+ans[0]);
            findCeil(root,key,ans);
            System.out.println("The ceil of the key "+key+" is: "+ans[0]);
        }

        int res = findFloorIterative(root,key);
        
        System.out.println("The floor of the key "+key+" is: "+res);
    }

    public static void findFloor(Node root, int key,int[] ans){
        if(root == null){
            return;
        }

        if(root.val <= key){
            ans[0] = Math.max(root.val,ans[0]);
        }
        findFloor(root.left, key,ans);
        findFloor(root.right, key, ans);
    }

    public static void findCeil(Node root, int key,int[] ans){
        if(root == null){
            return;
        }

        if(root.val >= key){
            ans[0] = Math.min(root.val,ans[0]);
        }
        findCeil(root.left, key, ans);
        findCeil(root.right, key, ans);
    }

    public static int findFloorIterative(Node root, int key){
        Node curr = root;
        int ans = -1;
        while(curr  != null){
            if(curr.val == key){
                ans= curr.val;
                return ans;
            }

            if(curr.val > key){
                curr = curr.left;
            }
            else{
                ans = curr.val;
                curr = curr.right;
            }
        }
        return ans;
    }
}
