import java.util.Comparator;
import java.util.PriorityQueue;

class Greedy {
    public static Comparator<Node> nodeComp = new Comparator<Node>() {

        @Override
        //override the compare function to compare Node by manhattanDistance
        public int compare(Node first, Node second) {
            return first.manhattanDistance(MazeMap.destination) - second.manhattanDistance(MazeMap.destination);
        }
    };

    public static Node end = null;

    public static Node greedySearch(Node startNode) {
        PriorityQueue<Node> pQueue = new PriorityQueue<Node>(99999, nodeComp);
        //set the initialcapacity to as large as possible

        pQueue.add(startNode);
        while (!pQueue.isEmpty()) {
            Node curr_node = pQueue.poll();
            if (curr_node.value == '.') {
                end = curr_node;
                break;
            } else {
                for (Node it_node : curr_node.neighbor) {
                    if (!it_node.isVisited && !it_node.isBlocked) {
                        it_node.isVisited = true;
                         Path.visited++;//save the node exapanded
                        if (!pQueue.contains(it_node)) {
                            pQueue.add(it_node);
                        }
                        MazeMap.trace.put(it_node, curr_node);
                        //build the connection between parent and child
                    }
                }
            }
        }
        return end;
    }

}
