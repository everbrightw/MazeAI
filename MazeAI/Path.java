import java.util.List;
import java.util.*;


class Path {

    public static Node findShortestPath(Node curr_node){
        Node root = new Node();
        curr_node = MazeMap.startNode;
        while(curr_node != null){
            for(int i = 0; i < curr_node.neighbor.size(); i ++){
                root.nextPath = extractMin(curr_node.neighbor);
            }
            curr_node = extractMin(curr_node.neighbor);
            root = root.nextPath;
        }
        return root;
    }

    public static Node extractMin(List<Node> neighbor){
        List<Integer> nodeDistance = new ArrayList<>();
        for (Node it_node : neighbor) {
            if(it_node.isVisited){
                nodeDistance.add(it_node.curr_distance);
        }
    }
        int minIndex = nodeDistance.indexOf(Collections.min(nodeDistance));
        return neighbor.get(minIndex);
    }
}