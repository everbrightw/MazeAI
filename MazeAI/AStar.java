import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

class AStar {
    public static void as() {
        long startTime = System.nanoTime();
        LinkedList<Node> queue = new LinkedList<Node>();

        queue.add(MazeMap.startNode);//add start node to the queue;

        List<Node> map = MazeMap.curr_map;
        List<Node> closedSet = new ArrayList<Node>();

        List<Node> openSet = new ArrayList<Node>();

        Node goal = MazeMap.destination;

        openSet.add(MazeMap.startNode);
        MazeMap.startNode.gScore = 0;
        while (!openSet.isEmpty()) {
            Node currentNode = openSet.get(findMinF(openSet));
            currentNode.value = '.';
            if (currentNode.equals(goal)) {
                break;
            }
            openSet.remove(currentNode);
            closedSet.add(currentNode);
            for (Node node : currentNode.neighbor) {

                // node.parent = currentNode;

                if (closedSet.contains(node))
                    continue;        // Ignore the neighbor which is already evaluated.
                node.gScore = currentNode.gScore+1;


                if (openSet.contains(node) == false)    // Discover a new node
                    openSet.add(node);

                // The distance from start to a neighbor
                int tentative_gScore = node.manhattanDistance(goal) + node.gScore;
                if (tentative_gScore >= currentNode.gScore + currentNode.manhattanDistance(goal))
                    continue;    // This is not a better path.

                // This path is the best until now. Record it!
                currentNode.children.add(node);
                
                //changed 
//                node.value == '.'

            }
        }
        long endTime = System.nanoTime();
        long deltaTime = endTime - startTime;
        System.out.println("Elapsed time (ms): " + deltaTime / 1000000 + "ms");
    }

    public static int findMinF(List<Node> openSet) {
        int f = 0;
        int result = 0;
        for (Node node : openSet) {
            int score = node.gScore + node.manhattanDistance(MazeMap.destination);
            if (score <= f || f == 0) {
                f = score;
                result = openSet.indexOf(node);
            }
        }
        return result;
    }

    public node shortestPath() {
        Stack<Node> s = new Stack<Node>();
        int currentDepth = 0;
        int minDepth = -1;
        Node route = null;
        s.push(Mazemap.startNode);
        while(!s.empty()) {
            Node curr = s.pop();
            if (curr.children.size == 0 && curr.equals(Mazemap.destination)) {
                if (minDepth == -1) {
                    route = curr;
                    minDepth = curr.gScore;
                } else if (minDepth > curr.gScore) {
                    route = curr;
                    minDepth = curr.gScore;
                }
            }
            for (Node t : curr.children) {
                s.push(t);
            }
        }
        return route;
    }


}