import java.util.List;
import java.util.ArrayList;

class AStar {
    public static Node as() {
        long startTime = System.nanoTime();

        List<Node> map = MazeMap.curr_map;
        List<Node> closedSet = new ArrayList<Node>();
        List<Node> openSet = new ArrayList<Node>();
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

                if (openSet.contains(node) == false)    // Discover a new node
                    openSet.add(node);

                // The distance from start to a neighbor
                int tentative_gScore =currentNode.gScore() + currentNode.manhattanDistance(goal);
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
        return null;
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

}