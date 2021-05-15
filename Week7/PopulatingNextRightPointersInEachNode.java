class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if(root==null) {
         return null;   
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            Node n1 = q.poll();
            Node n2 = q.peek();
            n1.next = n2;
            if(n1.left!=null) {
               q.offer(n1.left);   
            }
            if(n1.right!=null) {
               q.offer(n1.right);   
            }   
            if(n2==null){
                q.poll();
                if(q.isEmpty()) {
                  return root;
                }
                q.offer(null);
            }
        }
        return root;
    }
}