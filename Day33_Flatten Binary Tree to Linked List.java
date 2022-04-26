class Solution {

private TreeNode current;

public void flatten(TreeNode root) {
    current = null;
    dfs(root);
}

private void dfs(TreeNode root) {
    if (root == null) {
        return;
    }
    var left = root.left;
    var right = root.right;
    if (current != null) {
        current.left = null;
        current.right = root;
    }
    current = root;
    dfs(left);
    dfs(right);
}
}