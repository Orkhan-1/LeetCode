var sumEvenGrandparent = function(root) {
    let sum = 0;
    function dfs (root, parent, gParent) {
        if (root === null) {
            return;
        }
        if (gParent !== null && gParent.val % 2 === 0) {
            sum += root.val
        }
        return dfs(root.left, root, parent) + dfs(root.right, root, parent);
    }
    dfs(root, null, null);
    return sum;
}