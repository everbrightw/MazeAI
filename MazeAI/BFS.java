import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class BFS {
    
    public HashMap<Node, Node> trace = new HashMap<Node, Node>();
    public List<Node> visited = new ArrayList<Node>();
    
    //return type  Node: the destination of maze;
    public Node runBfs(Node startNode) {
        LinkedList<Node> queue = new LinkedList<Node>();

        Node curr_node = startNode;
        curr_node.isVisited = true;
        queue.add(curr_node);//add start node to the queue;
        while (!queue.isEmpty()) {

            if (curr_node.equals(MazeMap.destination)) {
                return curr_node;
            }

            curr_node = queue.poll();
            curr_node.isVisited = true;
            if (!visited.contains(curr_node)) {
                visited.add(curr_node);
            }

            for (Node it_child : curr_node.neighbor) {
                if (!it_child.isBlocked && !visited.contains(it_child)) {
                    if (!queue.contains(it_child)) {
                        queue.add(it_child);
                    }
                    this.trace.put(it_child, curr_node);

                }

            }
        }
        return null;
    }
}
