import java.util.List;
import java.util.*;


class Path {

    public static void findPath(HashMap<Node, Node> trace){
        Node end = MazeMap.destination;
        while(end != MazeMap.startNode){
            Node parent = trace.get(end);
           	parent.value = '.';
            end = parent;
        }
        MazeMap.startNode.value = 'P';
    }
    
}