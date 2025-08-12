class Solution {
    public Node connect(Node root) {

        if (root == null) {
            return root;
        }

        Node pointerNode = new Node (-1);
        pointerNode.next = root;

        Queue <Node> queue = new LinkedList <> ();

        queue.add (root);

        while (!queue.isEmpty()) {
            int size = queue.size ();

            int j=0;
            while (j<size) {
                Node current = queue.poll ();
                j++;
                Node nextNode = null;
                if (j==size) {
                    current.next = nextNode;
                } else {
                    nextNode = queue.peek();
                    current.next = nextNode;
                }
                if (current.left!=null) {
                    queue.add (current.left);
                }
                if (current.right!=null) {
                    queue.add (current.right);
                }
            }
        }

        return pointerNode.next;
    }
}