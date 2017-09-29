import java.util.ArrayList;

public class Astar {
    public Node as() {
        long startTime = System.nanoTime();

        List<Node> map = MazeMap.curr_map;
        ArrayList<Node> closedSet = new ArrayList<Node>();
        ArrayList<Node> openSet = new ArratList<Node>();
        Node goal = MazeMap.destination;

        openSet.add(MazeMap.startNode);
        MazeMap.startNode.gScore = 0;
        while (!openSet.isEmpty()) {
            Node currentNode = openSet.get(findMinF(openSet));
            if (currentNode.equals(goal)) {
                return currentNode;
            }
            openSet.remove(currentNode);
            closedSet.add(currentNode);
            for (Node node : currentNode.neighbor) {
                if (closedSet.contains(node))
                    continue;        // Ignore the neighbor which is already evaluated.

                if (openSet.contains(node) = false)    // Discover a new node
                    openSet.add(node);

                // The distance from start to a neighbor
                int tentative_gScore :=currentNode.gScore() + currentNode.manhattanDistance(goal);
                if (tentative_gScore >= node.gScore())
                    continue;    // This is not a better path.

                // This path is the best until now. Record it!
                node.parent = currentNode;
                node.gScore = tentative_gScore;
            }

        }
        long endTime = System.nanoTime();
        long deltaTime = endTime - startTime;
        System.out.println("Elapsed time (ms): " + deltaTime / 1000000 + "ms");
    }

    public Node findMinF(ArrayList<Node> openSet) {
        int f;
        int result = 0;
        for (Node node : openSet) {
            int score = node.gScore + node.manhattanDistance();
            if (score <= f || f == 0) {
                f = score;
                result = openSet.indexOf(node);
            }
        }
        return result;
    }

}