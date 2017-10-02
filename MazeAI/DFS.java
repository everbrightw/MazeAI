import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class DFS {
    public static List<Node> visited = new ArrayList<Node>();
    public static HashMap<Node, Node> trace = new HashMap<Node, Node>();
    public static Node end = null;

    public static Node doDFS(Node startNode) {

        Node curr;
        Stack<Node> s = new Stack<>();
        s.push(startNode);

        big:
        while (!s.empty()) {
            curr = s.peek();
            visited.add(curr);
            curr.isVisited = true;
            s.pop();
            //curr.value = '.';
            if (curr.value == '.') {
                end = curr;
                break big;
            }
            for (int i = 0; i < curr.neighbor.size(); i++) {
                if (!curr.neighbor.get(i).isBlocked && !visited.contains(curr.neighbor.get(i))) {
                    trace.put(curr.neighbor.get(i), curr);
                    s.push(curr.neighbor.get(i));
                }
            }
        }


        while (end != startNode) {
            Node parent = trace.get(end);
            //System.out.println("parent location: " + parent.x + " " + parent.y);
            if (parent != startNode) {

                parent.value = '.';
            }
            end = parent;
        }

        return end;
    }
}
