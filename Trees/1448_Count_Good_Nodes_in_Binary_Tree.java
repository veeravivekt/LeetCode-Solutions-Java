class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
    public int dfs(TreeNode node, int max) {
        if (node == null) return 0;
        int res = node.val >= max ? 1 : 0;
        res += dfs(node.left, Math.max(max, node.val));
        res += dfs(node.right, Math.max(max, node.val));
        return res;
    }
}