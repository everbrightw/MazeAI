import java.util.HashMap;


class Path {

    public static void findPath(HashMap<Node, Node> trace) {
        Node end = MazeMap.destination;
        while (end != MazeMap.startNode) {
            Node parent = trace.get(end);
<<<<<<< HEAD
            if(parent.value != 'P' && end.value != 'P'){
=======

>>>>>>> f0f05d2dfefee1eec77ac82600f39d9c057a2662
           	parent.value = '*';
            end.value = '*';
          }
            end = parent;
        }

        // MazeMap.startNode.value = 'P';
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> f0f05d2dfefee1eec77ac82600f39d9c057a2662
