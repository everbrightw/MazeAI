import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class AStar {
    public static int expandedNode = 0;
    public static void as() {

        LinkedList<Node> queue = new LinkedList<Node>();

        queue.add(MazeMap.startNode);//add start node to the queue;

        List<Node> map = MazeMap.curr_map;
        List<Node> closedSet = new ArrayList<Node>();

        List<Node> openSet = new ArrayList<Node>();

        Node goal = MazeMap.destination;

        openSet.add(MazeMap.startNode);
        MazeMap.startNode.gScore = 0;
        while (!openSet.isEmpty()) {
            Node currentNode = openSet.get(findMinF(openSet, MazeMap.destination));
            // currentNode.value = '.';
            expandedNode ++;
            if (currentNode.equals(goal)) {
                break;
            }
            openSet.remove(currentNode);
            closedSet.add(currentNode);
            for (Node node : currentNode.neighbor) {

                // node.parent = currentNode;

                if (closedSet.contains(node))
                    continue;        // Ignore the neighbor which is already evaluated.
                node.gScore = currentNode.gScore + 1;

                node.parent = currentNode;


                if (openSet.contains(node) == false)    // Discover a new node
                    openSet.add(node);

                // The distance from start to a neighbor
                int tentative_gScore = node.manhattanDistance(goal) + node.gScore;
                if (tentative_gScore > currentNode.gScore + currentNode.manhattanDistance(goal))
                    continue;    // This is not a better path.

                // This path is the best until now. Record it!
                currentNode.children.add(node);


                //changed
//                node.value == '.'

            }
        }


        // shortestPath();
        MazeMap.destination.setShortestPath();

    }

<<<<<<< HEAD
    public static int findMinF(List<Node> openSet, Node end) {
        int f = 0;
        int result = 0;
        for (Node node : openSet) {
            int score = node.gScore + node.manhattanDistance(end);
=======
    public static int findMinF(List<Node> openSet, Node destination) {
        int f = 0;
        int result = 0;
        for (Node node : openSet) {
            int score = node.gScore + node.manhattanDistance(destination);
>>>>>>> a3ac1f8f01691b4147a7e1d7418877ea553924ba
            if (score <= f || f == 0) {
                f = score;
                result = openSet.indexOf(node);
            }
        }
        return result;
    }

    public static int findMinG(List<Node> openSet) {
        int f = 0;
        int result = 0;
        for (Node node : openSet) {
            int score = node.gScore;
            if (score <= f || f == 0) {
                f = score;
                result = openSet.indexOf(node);
            }
        }
        return result;
    }

    public static Node shortestPath() {
        Stack<Node> s = new Stack<Node>();
        int currentDepth = 0;
        int minDepth = -1;
        Node route = null;
        s.push(MazeMap.startNode);
        while (!s.empty()) {
            Node curr = s.pop();
            if (curr.children.size() == 0 && curr.equals(MazeMap.destination)) {
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

    public static Node mutiAs() {

        List<Node> closedSet = new ArrayList<Node>();
        List<Node> openSet = new ArrayList<Node>();
        List<Node> goals = MultiDots.destinations;
        openSet.add(MazeMap.startNode);
        MazeMap.startNode.goalLeft = goals;
        while (!openSet.isEmpty()) {
            Node currentNode = openSet.get(findMinG(openSet));
            if (currentNode.goalLeft.isEmpty()) {
                return currentNode;
            }
            openSet.remove(currentNode);
            closedSet.add(currentNode);
            for (Node node : currentNode.goalLeft) {
                if (closedSet.contains(node))
                    continue;
                Node newNode = new Node(node);

                newNode.goalLeft = new ArrayList<Node>();
                newNode.goalLeft.addAll(currentNode.goalLeft);

                newNode.goalLeft.remove(node);
                newNode.gScore = currentNode.gScore + getDistance(currentNode, newNode);//TODO: get distance(current, node)
                // node.parent = currentNode;
                openSet.add(newNode);
                newNode.parent = currentNode;
                //changed
                //node.value == '.'
            }
        }
        return null;
    }

    public static int getDistance(Node start, Node end) {
        LinkedList<Node> queue = new LinkedList<Node>();
        start = MazeMap.getNode(start.x, start.y);
        queue.add(start);//add start node to the queue;

        List<Node> closedSet = new ArrayList<Node>();

        List<Node> openSet = new ArrayList<Node>();

        Node goal = end;

        openSet.add(start);
        start.gScore = 0;
        while (!openSet.isEmpty()) {
<<<<<<< HEAD
            Node currentNode = openSet.get(findMinF(openSet, goal));
=======
            Node currentNode = openSet.get(findMinF(openSet,goal));
>>>>>>> a3ac1f8f01691b4147a7e1d7418877ea553924ba
            if (currentNode.equals(goal)) {
                return goal.gScore;
            }
            openSet.remove(currentNode);
            closedSet.add(currentNode);
            for (Node node : currentNode.neighbor) {

                // node.parent = currentNode;

                if (closedSet.contains(node))
                    continue;        // Ignore the neighbor which is already evaluated.
                node.gScore = currentNode.gScore + 1;

                node.parent = currentNode;

                if (openSet.contains(node) == false)    // Discover a new node
                    openSet.add(node);

                // The distance from start to a neighbor
                int tentative_gScore = node.manhattanDistance(goal) + node.gScore;
                if (tentative_gScore > currentNode.gScore + currentNode.manhattanDistance(goal))
                    continue;    // This is not a better path.

                // This path is the best until now. Record it!
                currentNode.children.add(node);

            }
        }
        return 0;
        // shortestPath();
    }
}
