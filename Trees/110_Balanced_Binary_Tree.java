lass Solution {
public boolean isBalanced(TreeNode root) {
    return dfs(root).getKey();
}
public Pair<Boolean,Integer> dfs(TreeNode node) {
    if (node == null) return new Pair<Boolean,Integer>(true, 0);

    var left = dfs(node.left);
    var right = dfs(node.right);
    var balanced = left.getKey() && right.getKey() && (Math.abs(left.getValue() - right.getValue()) <= 1);
    return new Pair<Boolean,Integer>(balanced, 1+ Math.max(left.getValue(), right.getValue()));
}
}