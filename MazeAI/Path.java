import java.util.HashMap;


class Path {

    public static void findPath(HashMap<Node, Node> trace) {
        Node end = MazeMap.destination;
        while (end != MazeMap.startNode) {
            Node parent = trace.get(end);

            if(parent.value != 'P' && end.value != 'P'){

           	    parent.value = '*';
                end.value = '*';

          }
            end = parent;
        }        // MazeMap.startNode.value = 'P';
    }

}

