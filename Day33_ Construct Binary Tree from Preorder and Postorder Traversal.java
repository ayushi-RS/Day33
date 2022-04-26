class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        
        
       return builtTreeNew(preorder, 0,preorder.length-1, postorder, 0, postorder.length-1);       
        // psi-preorder starting index; pei- preorder ending index
        // postsi-postorder starting index ; postei-postorder ending index
        
        
    }
    
    public static TreeNode builtTreeNew(int [] preorder, int psi, int pei, int []postorder, int postsi, int postei)
    {
        if(psi>pei)
        {
            return null;
        }
        
        int val = preorder[psi];
        TreeNode node = new TreeNode(val); 
        int idx = postsi;
        
        if(psi==pei)
        {
            return node;
            
        }
        
        
         while(postorder[idx]!=preorder[psi+1])
         {
             idx++;
         }
         // now finding the total remaining elements
        int trel = idx -postsi+1;
             
        
       node.left= builtTreeNew(preorder, psi+1,psi+trel, postorder, postsi, idx);
       node.right= builtTreeNew(preorder, psi+trel+1,pei, postorder, idx+1, postei-1);
        
        return node;
        
        
    }
}