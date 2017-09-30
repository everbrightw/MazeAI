
class Path {

    public Node root;

    public Path(MazeMap b) {
        this.root = MazeMap.startNode;
    }

    public Node exists(Node n) {
        Node curr = root;
        Queue<Node> q = new LinkedListNode>();
        q.add(curr);
        while(q.peek() != null) {
            TreeNode tn = q.poll();
            if(tn.x == n.x && tn.y == n.y) {
                return tn;
            }
            for (TreeNode child: tn.children) {
                q.add(child);
            }
        }
        return null;
    }

    public void addChild(Node src, Node child) {
        if (this.exists(child) != null) {
            return;
        }
        TreeNode n = new TreeNode(child.x, child.y, this.exists(src), child.distance);
        this.exists(src).addChild(n);
        return;
    }

    public TreeNode shortestEuclidPath() {
        TreeNode curr = this.root;
        TreeNode next = null;
        System.out.println(curr.x);
        while (curr != null) {
            double minDist = curr.distance;
            next = null;
            for (TreeNode child : curr.children) {
                if (child.distance < minDist) {
                    next = child;
                    minDist = next.distance;
                }
            }
            curr = next;
        }
        return next;
    }


    public TreeNode shortestPath() {
        Stack<TreeNode> s = new Stack<TreeNode>();
        int currentDepth = 0;
        int minDepth = -1;
        TreeNode route = null;
        s.push(this.root);
        while(!s.empty()) {
            TreeNode curr = s.pop();
            if (curr.hasNoChildren() && curr.x == this.metadata.dest.x && curr.y == this.metadata.dest.y) {
                System.out.println(curr.depth);
                if (minDepth == -1) {
                    route = curr;
                    minDepth = curr.depth;
                } else if (minDepth > curr.depth) {
                    route = curr;
                    minDepth = curr.depth;
                }
            }
            for (TreeNode t : curr.children) {
                s.push(t);
            }
        }
        return route;
    }
}