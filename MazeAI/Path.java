import java.util.HashMap;


class Path {
	public static int visited = 0;
	public static int pathCost = 1;
    public static void findPath(HashMap<Node, Node> trace) {
        Node end = MazeMap.destination;
        while (end != MazeMap.startNode) {
            Node parent = trace.get(end);

            if(parent.value != 'P' && end.value != 'P' && !end.equals(MazeMap.destination)){

           	    parent.value = '.';
                end.value = '.';
                pathCost++;

          }
            end = parent;
        }        // MazeMap.startNode.value = 'P';
    }

}

