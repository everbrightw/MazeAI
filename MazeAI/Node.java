import java.util.ArrayList;
import java.util.List;

class Node {

    public int x;//current position for x
    public int y;//current position for y
    public int gScore;
    //linked node
    public Node up_child;
    public Node down_child;
    public Node left_child;
    public Node right_child;

    public int depth = 0;
    public List<Node> goalLeft = new ArrayList<Node>();

    public Node parent = null;

    public List<Node> children = new ArrayList<Node>();

    //has visited;
    public Boolean isVisited;
    //three way blocked
    public Boolean isBlocked;

    public char value;//store for curr node's value;

    //distance from goal state
    public int curr_distance;

    public List<Node> neighbor;

    public Node nextPath;

    //used for MST
    public int degree;
    public static int tempG = 0;


    public Node(Node other) {
        this.x = other.x;
        this.y = other.y;
        this.gScore = other.gScore;
    }

    public Node(int x, int y, char value) {
        this.x = x;
        this.y = y;

        this.value = value;

        up_child = null;
        down_child = null;
        left_child = null;
        right_child = null;

        isVisited = false;

        isBlocked = false;
        neighbor = new ArrayList<Node>();

        nextPath = null;

        degree = 0;
    }

    public Node() {
        this.x = x;
        this.y = y;

        this.value = value;

        up_child = null;
        down_child = null;
        left_child = null;
        right_child = null;

        isVisited = false;

        isBlocked = false;
        neighbor = new ArrayList<Node>();

    }

    public int manhattanDistance(Node dest) {
        int dist = Math.abs(this.x - dest.x) + Math.abs(this.y - dest.y);
        return dist;
    }

    public boolean equals(Node other) {
        return ((this.x == other.x) && (this.y == other.y));
    }

    //for A Star algorithm
    public int gScore() {
        if (this.parent == null) {
            return 0;
        }
        return 1 + this.parent.gScore();
    }

    public void setShortestPath() {
        if (this.parent == null) {
            return;
        }
        this.value = '.';
        MazeMap.destination.depth++;
        this.parent.setShortestPath();
    }

    public void setOrder(int i) {
        String test = "123456789abcdefghijkl";
        char[] index = test.toCharArray();
        if (this.parent == null) {
            this.value = index[i];
            return;
        }
        this.value = index[i];
        this.parent.setOrder(i + 1);
    }

    public boolean hasChild() {
        return !neighbor.isEmpty();
    }


}
