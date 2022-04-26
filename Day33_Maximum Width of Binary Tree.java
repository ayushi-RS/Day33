class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode node,int index){
        this.index=index;
        this.node=node;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q=new LinkedList<>();
        int ans=Integer.MIN_VALUE;
        q.add(new Pair(root,0));
        while(q.isEmpty()==false){
            int size=q.size();
            int minSizeOfLevel=q.peek().index;
            for(int i=0;i<size;i++){
                Pair p=q.poll();
                int id=p.index-minSizeOfLevel;
                if(p.node.left!=null) q.offer(new Pair(p.node.left,(2*id+1)));
                if(p.node.right!=null) q.offer(new Pair(p.node.right,(2*id+2)));
                if(i==size-1){
                    ans=Math.max((p.index-minSizeOfLevel)+1,ans);
                }
            }
        }
        return ans;
    }
}