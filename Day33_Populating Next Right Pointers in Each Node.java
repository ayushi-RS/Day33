class Solution {
   public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new LinkedList();
        q.offer(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n; i++){
                Node tn = q.poll(); 
                tn.next = i < n-1? q.peek():null;
                if(tn.left != null) q.offer(tn.left);
                if(tn.right != null) q.offer(tn.right);
            }
        }
        return root;
    }
}