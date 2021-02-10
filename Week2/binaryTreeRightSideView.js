function bfs (root, arr) {
    if(!root) {
        return;
    }
    var queue = [root];
    while(queue.length) {
        var length = queue.length;
        for(let i = 0; i < length; i++) {
            var node = queue.shift();
            if(node.left) {
                queue.push(node.left);
            }
            if(node.right) {
                queue.push(node.right);
            }
        } 
        arr.push(node.val);
    }
};

var rightSideView = function(root) {
    var arr = [];
    bfs(root, arr);
    return arr;
};