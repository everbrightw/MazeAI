import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class DFS {
    public static List<Node> visited = new ArrayList<Node>();
    public static HashMap<Node, Node> trace = new HashMap<Node, Node>();
    public static int pathCost = 0;
    public static Node end = null;

    public static Node doDFS(Node startNode) {

        Node curr;
        Stack<Node> s = new Stack<>(); // use stack to achieve first entering and first popping
        s.push(startNode);

        big:
        while (!s.empty()) {
            curr = s.peek();
            visited.add(curr);
            curr.isVisited = true;
            s.pop();

            if (curr.value == '.') {
                end = curr;
                break big;
            }
            for (int i = 0; i < curr.neighbor.size(); i++) {
                if (!curr.neighbor.get(i).isBlocked && !visited.contains(curr.neighbor.get(i))) {
                    trace.put(curr.neighbor.get(i), curr); //build connection between parent and child
                    s.push(curr.neighbor.get(i));
                }
            }
        }

        //same as the Path class
        while (end != startNode) {
         //back trace to link the parent and its child
        //until it finds the start from end
            Node parent = trace.get(end);
            if (parent != startNode) {

                parent.value = '.';
                pathCost ++;
            }
            end = parent;
        }
        return end;
    }
}
