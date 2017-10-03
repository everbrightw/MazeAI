import java.util.*;

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

    public static int findMinF(List<Node> openSet, Node end) {
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
    public static int findTempG(List<Node> openSet, Node end) {
        int f = 0;
        int result = 0;
        for (Node node : openSet) {
            int score = node.tempG + node.manhattanDistance(end);
            if (score <= f || f == 0) {
                f = score;
                result = openSet.indexOf(node);
            }
        }
        return result;
    }

    public static Node findMinG(List<Node> openSet) {
        int f = 0;
        Node result = null;
        for (Node node : openSet) {
            int score = node.gScore;
            if (score <= f || f == 0) {
                f = score;
                result = node;
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

        List<Node> openSet = new ArrayList<Node>();
        List<Node> goals = MultiDots.destinations;
        MazeMap.startNode.gScore = 0;
        MazeMap.startNode.goalLeft = goals;
        openSet.add(MazeMap.startNode);
        while (!openSet.isEmpty()) {
            Node currentNode = findMinG(openSet);
//            System.out.println("\n g: " + currentNode.gScore);
            if (currentNode.goalLeft.size()==0) {
                return currentNode;
            }
            openSet.remove(currentNode);
            Node lowest, second, third;
            List<Node> list = sortG(currentNode.goalLeft, currentNode);
            if (!list.isEmpty()) {
                lowest = new Node(list.get(0));
                lowest.gScore = currentNode.gScore + getDistance(currentNode, lowest);
                lowest.goalLeft = new ArrayList<Node>();
                lowest.goalLeft.addAll(currentNode.goalLeft);
                lowest.goalLeft.remove(list.get(0));
                lowest.parent = currentNode;
                openSet.add(lowest);
                expandedNode++;
            }
            if (list.size()>=2) {
                second = new Node(list.get(1));
                second.gScore = currentNode.gScore + getDistance(currentNode, second);

                second.goalLeft = new ArrayList<Node>();
                second.goalLeft.addAll(currentNode.goalLeft);
                second.goalLeft.remove(list.get(1));
                second.parent = currentNode;
                openSet.add(second);
                expandedNode++;

            }
            if (list.size()>=3 && list.get(2).tempG == list.get(1).tempG) {
                third = new Node(list.get(2));
                third.goalLeft = new ArrayList<Node>();
                third.gScore = currentNode.gScore + getDistance(currentNode, third);
                third.goalLeft.addAll(currentNode.goalLeft);
                third.goalLeft.remove(list.get(2));
                third.parent = currentNode;
                openSet.add(third);
                expandedNode++;

            }
        }
        return null;
    }

    public static List<Node> sortG(List<Node> list, Node currentNode){
        for (Node node: list) {
            node.tempG = currentNode.gScore + getDistance(currentNode, node);
        }
        Collections.reverse(list);
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {

                if (n1.tempG > n2.tempG)
                    return 1;
                if (n1.tempG< n2.tempG)
                    return -1;
                return 0;
            }
        });
        return list;
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
            Node currentNode = openSet.get(findMinF(openSet, goal));
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
        return 0;
        // shortestPath();
    }
}
